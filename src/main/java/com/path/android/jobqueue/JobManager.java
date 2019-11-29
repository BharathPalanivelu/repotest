package com.path.android.jobqueue;

import android.content.Context;
import com.facebook.common.time.Clock;
import com.path.android.jobqueue.CancelResult;
import com.path.android.jobqueue.cachedQueue.CachedJobQueue;
import com.path.android.jobqueue.config.Configuration;
import com.path.android.jobqueue.di.DependencyInjector;
import com.path.android.jobqueue.executor.JobConsumerExecutor;
import com.path.android.jobqueue.log.JqLog;
import com.path.android.jobqueue.network.NetworkEventProvider;
import com.path.android.jobqueue.network.NetworkUtil;
import com.path.android.jobqueue.nonPersistentQueue.NonPersistentPriorityQueue;
import com.path.android.jobqueue.persistentQueue.sqlite.SqliteJobQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JobManager implements NetworkEventProvider.Listener {
    public static final long NOT_DELAYED_JOB_DELAY = Long.MIN_VALUE;
    public static final long NOT_RUNNING_SESSION_ID = Long.MIN_VALUE;
    public static final long NS_PER_MS = 1000000;
    private final Context appContext;
    private Executor cancelExecutor;
    private final Object cancelExecutorInitLock;
    private final JobConsumerExecutor.Contract consumerContract;
    private final DependencyInjector dependencyInjector;
    private final Object getNextJobLock;
    /* access modifiers changed from: private */
    public final JobConsumerExecutor jobConsumerExecutor;
    /* access modifiers changed from: private */
    public final NetworkUtil networkUtil;
    /* access modifiers changed from: private */
    public final Object newJobListeners;
    /* access modifiers changed from: private */
    public final JobQueue nonPersistentJobQueue;
    private final ConcurrentHashMap<Long, CountDownLatch> nonPersistentOnAddedLocks;
    private final Runnable notifyRunnable;
    /* access modifiers changed from: private */
    public final JobQueue persistentJobQueue;
    private final ConcurrentHashMap<Long, CountDownLatch> persistentOnAddedLocks;
    /* access modifiers changed from: private */
    public volatile boolean running;
    /* access modifiers changed from: private */
    public final RunningJobSet runningJobGroups;
    private final long sessionId;
    private ScheduledExecutorService timedExecutor;

    public JobManager(Context context) {
        this(context, "default");
    }

    public JobManager(Context context, String str) {
        this(context, new Configuration.Builder(context).id(str).build());
    }

    public JobManager(Context context, Configuration configuration) {
        this.newJobListeners = new Object();
        this.cancelExecutorInitLock = new Object();
        this.getNextJobLock = new Object();
        this.notifyRunnable = new Runnable() {
            public void run() {
                JobManager.this.notifyJobConsumer();
            }
        };
        this.consumerContract = new JobConsumerExecutor.Contract() {
            public boolean isRunning() {
                return JobManager.this.running;
            }

            public void insertOrReplace(JobHolder jobHolder) {
                RetryConstraint retryConstraint = jobHolder.getJob().retryConstraint;
                if (retryConstraint == null) {
                    JobManager.this.reAddJob(jobHolder);
                    return;
                }
                if (retryConstraint.getNewPriority() != null) {
                    jobHolder.setPriority(retryConstraint.getNewPriority().intValue());
                }
                long j = -1;
                if (retryConstraint.getNewDelayInMs() != null) {
                    if (!retryConstraint.willApplyNewDelayToGroup() || jobHolder.getGroupId() == null) {
                        j = retryConstraint.getNewDelayInMs().longValue();
                    } else {
                        JobManager.this.runningJobGroups.addGroupUntil(jobHolder.getGroupId(), System.nanoTime() + (retryConstraint.getNewDelayInMs().longValue() * JobManager.NS_PER_MS));
                    }
                }
                jobHolder.setDelayUntilNs(j > 0 ? System.nanoTime() + (j * JobManager.NS_PER_MS) : Long.MIN_VALUE);
                JobManager.this.reAddJob(jobHolder);
            }

            public void removeJob(JobHolder jobHolder) {
                JobManager.this.removeJob(jobHolder);
            }

            public JobHolder getNextJob(int i, TimeUnit timeUnit) {
                JobHolder access$900 = JobManager.this.getNextJob();
                if (access$900 != null) {
                    return access$900;
                }
                long nanos = timeUnit.toNanos((long) i) + System.nanoTime();
                long access$1000 = JobManager.this.ensureConsumerWhenNeeded((Boolean) null);
                while (access$900 == null && nanos > System.nanoTime() && JobManager.this.running) {
                    access$900 = JobManager.this.running ? JobManager.this.getNextJob() : null;
                    if (access$900 == null) {
                        long nanoTime = nanos - System.nanoTime();
                        if (nanoTime > 0) {
                            long min = Math.min(access$1000, TimeUnit.NANOSECONDS.toMillis(nanoTime));
                            if (min >= 1 && JobManager.this.running) {
                                if (JobManager.this.networkUtil instanceof NetworkEventProvider) {
                                    synchronized (JobManager.this.newJobListeners) {
                                        try {
                                            JobManager.this.newJobListeners.wait(min);
                                        } catch (InterruptedException e2) {
                                            JqLog.e(e2, "exception while waiting for a new job.", new Object[0]);
                                        }
                                    }
                                } else {
                                    synchronized (JobManager.this.newJobListeners) {
                                        try {
                                            JobManager.this.newJobListeners.wait(Math.min(500, min));
                                        } catch (InterruptedException e3) {
                                            JqLog.e(e3, "exception while waiting for a new job.", new Object[0]);
                                        }
                                    }
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
                return access$900;
            }

            public int countRemainingReadyJobs() {
                JobManager jobManager = JobManager.this;
                return jobManager.countReadyJobs(jobManager.networkUtil instanceof NetworkEventProvider ? JobManager.this.hasNetwork() : true);
            }
        };
        if (configuration.getCustomLogger() != null) {
            JqLog.setCustomLogger(configuration.getCustomLogger());
        }
        this.appContext = context.getApplicationContext();
        this.running = true;
        this.runningJobGroups = new RunningJobSet();
        this.sessionId = System.nanoTime();
        this.persistentJobQueue = configuration.getQueueFactory().createPersistentQueue(context, Long.valueOf(this.sessionId), configuration.getId(), configuration.isInTestMode());
        this.nonPersistentJobQueue = configuration.getQueueFactory().createNonPersistent(context, Long.valueOf(this.sessionId), configuration.getId(), configuration.isInTestMode());
        this.persistentOnAddedLocks = new ConcurrentHashMap<>();
        this.nonPersistentOnAddedLocks = new ConcurrentHashMap<>();
        this.networkUtil = configuration.getNetworkUtil();
        this.dependencyInjector = configuration.getDependencyInjector();
        NetworkUtil networkUtil2 = this.networkUtil;
        if (networkUtil2 instanceof NetworkEventProvider) {
            ((NetworkEventProvider) networkUtil2).setListener(this);
        }
        this.jobConsumerExecutor = new JobConsumerExecutor(configuration, this.consumerContract);
        this.timedExecutor = Executors.newSingleThreadScheduledExecutor();
        start();
    }

    public void stop() {
        this.running = false;
    }

    public void start() {
        if (!this.running) {
            this.running = true;
            notifyJobConsumer();
        }
    }

    public int count() {
        int count;
        int count2;
        synchronized (this.nonPersistentJobQueue) {
            count = this.nonPersistentJobQueue.count() + 0;
        }
        synchronized (this.persistentJobQueue) {
            count2 = count + this.persistentJobQueue.count();
        }
        return count2;
    }

    /* access modifiers changed from: private */
    public int countReadyJobs(boolean z) {
        int countReadyJobs;
        int countReadyJobs2;
        synchronized (this.nonPersistentJobQueue) {
            countReadyJobs = this.nonPersistentJobQueue.countReadyJobs(z, this.runningJobGroups.getSafe()) + 0;
        }
        synchronized (this.persistentJobQueue) {
            countReadyJobs2 = countReadyJobs + this.persistentJobQueue.countReadyJobs(z, this.runningJobGroups.getSafe());
        }
        return countReadyJobs2;
    }

    public long addJob(Job job) {
        long j;
        JobHolder jobHolder = new JobHolder(job.getPriority(), job, job.getDelayInMs() > 0 ? System.nanoTime() + (job.getDelayInMs() * NS_PER_MS) : Long.MIN_VALUE, Long.MIN_VALUE);
        if (job.isPersistent()) {
            synchronized (this.persistentJobQueue) {
                j = this.persistentJobQueue.insert(jobHolder);
                addOnAddedLock(this.persistentOnAddedLocks, j);
            }
        } else {
            synchronized (this.nonPersistentJobQueue) {
                j = this.nonPersistentJobQueue.insert(jobHolder);
                addOnAddedLock(this.nonPersistentOnAddedLocks, j);
            }
        }
        if (JqLog.isDebugEnabled()) {
            JqLog.d("added job id: %d class: %s priority: %d delay: %d group : %s persistent: %s requires network: %s", Long.valueOf(j), job.getClass().getSimpleName(), Integer.valueOf(job.getPriority()), Long.valueOf(job.getDelayInMs()), job.getRunGroupId(), Boolean.valueOf(job.isPersistent()), Boolean.valueOf(job.requiresNetwork()));
        }
        DependencyInjector dependencyInjector2 = this.dependencyInjector;
        if (dependencyInjector2 != null) {
            dependencyInjector2.inject(job);
        }
        jobHolder.getJob().setApplicationContext(this.appContext);
        jobHolder.getJob().onAdded();
        if (job.isPersistent()) {
            synchronized (this.persistentJobQueue) {
                clearOnAddedLock(this.persistentOnAddedLocks, j);
            }
        } else {
            synchronized (this.nonPersistentJobQueue) {
                clearOnAddedLock(this.nonPersistentOnAddedLocks, j);
            }
        }
        ensureConsumerWhenNeeded((Boolean) null);
        return j;
    }

    public void cancelJobsInBackground(final CancelResult.AsyncCancelCallback asyncCancelCallback, final TagConstraint tagConstraint, final String... strArr) {
        synchronized (this.cancelExecutorInitLock) {
            if (this.cancelExecutor == null) {
                this.cancelExecutor = Executors.newSingleThreadExecutor();
            }
            this.cancelExecutor.execute(new Runnable() {
                public void run() {
                    CancelResult cancelJobs = JobManager.this.cancelJobs(tagConstraint, strArr);
                    CancelResult.AsyncCancelCallback asyncCancelCallback = asyncCancelCallback;
                    if (asyncCancelCallback != null) {
                        asyncCancelCallback.onCancelled(cancelJobs);
                    }
                }
            });
        }
    }

    public CancelResult cancelJobs(TagConstraint tagConstraint, String... strArr) {
        HashSet hashSet;
        ArrayList<JobHolder> arrayList;
        HashSet hashSet2;
        ArrayList arrayList2 = new ArrayList();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        HashSet hashSet6 = new HashSet();
        synchronized (this.getNextJobLock) {
            final TagConstraint tagConstraint2 = tagConstraint;
            final String[] strArr2 = strArr;
            final HashSet hashSet7 = hashSet4;
            final HashSet hashSet8 = hashSet5;
            final ArrayList arrayList3 = arrayList2;
            hashSet = hashSet5;
            AnonymousClass2 r13 = r1;
            final HashSet hashSet9 = hashSet3;
            arrayList = arrayList2;
            JobConsumerExecutor jobConsumerExecutor2 = this.jobConsumerExecutor;
            final HashSet hashSet10 = hashSet6;
            AnonymousClass2 r1 = new Runnable() {
                public void run() {
                    Set<JobHolder> findRunningByTags = JobManager.this.jobConsumerExecutor.findRunningByTags(tagConstraint2, strArr2, false);
                    synchronized (JobManager.this.nonPersistentJobQueue) {
                        JobManager.this.markJobsAsCancelledAndFilterAlreadyCancelled(findRunningByTags, JobManager.this.nonPersistentJobQueue, hashSet7);
                        hashSet8.addAll(hashSet7);
                        Set<JobHolder> findJobsByTags = JobManager.this.nonPersistentJobQueue.findJobsByTags(tagConstraint2, true, hashSet7, strArr2);
                        JobManager.this.markJobsAsCancelledAndFilterAlreadyCancelled(findJobsByTags, JobManager.this.nonPersistentJobQueue, hashSet7);
                        arrayList3.addAll(findJobsByTags);
                    }
                    arrayList3.addAll(findRunningByTags);
                    Set<JobHolder> findRunningByTags2 = JobManager.this.jobConsumerExecutor.findRunningByTags(tagConstraint2, strArr2, true);
                    synchronized (JobManager.this.persistentJobQueue) {
                        JobManager.this.markJobsAsCancelledAndFilterAlreadyCancelled(findRunningByTags2, JobManager.this.persistentJobQueue, hashSet9);
                        hashSet10.addAll(hashSet9);
                        Set<JobHolder> findJobsByTags2 = JobManager.this.persistentJobQueue.findJobsByTags(tagConstraint2, true, hashSet9, strArr2);
                        JobManager.this.markJobsAsCancelledAndFilterAlreadyCancelled(findJobsByTags2, JobManager.this.persistentJobQueue, hashSet9);
                        arrayList3.addAll(findJobsByTags2);
                    }
                    arrayList3.addAll(findRunningByTags2);
                }
            };
            jobConsumerExecutor2.inRunningJobHoldersLock(r13);
        }
        try {
            this.jobConsumerExecutor.waitUntilDone(hashSet3, hashSet4);
        } catch (InterruptedException e2) {
            JqLog.e(e2, "error while waiting for jobs to finish", new Object[0]);
        }
        CancelResult cancelResult = new CancelResult();
        for (JobHolder jobHolder : arrayList) {
            JqLog.d("checking if I could cancel %s. Result: %s", jobHolder.getJob(), Boolean.valueOf(!jobHolder.isSuccessful()));
            if (jobHolder.isSuccessful()) {
                cancelResult.failedToCancel.add(jobHolder.getJob());
            } else {
                cancelResult.cancelledJobs.add(jobHolder.getJob());
                try {
                    jobHolder.getJob().onCancel();
                } catch (Throwable th) {
                    JqLog.e(th, "cancelled job's onCancel has thrown exception", new Object[0]);
                }
                if (jobHolder.getJob().isPersistent()) {
                    synchronized (this.persistentJobQueue) {
                        this.persistentJobQueue.remove(jobHolder);
                    }
                    if (jobHolder.getGroupId() != null && hashSet6.contains(jobHolder.getId())) {
                        this.runningJobGroups.remove(jobHolder.getGroupId());
                    }
                } else if (jobHolder.getGroupId() != null) {
                    hashSet2 = hashSet;
                    if (hashSet2.contains(jobHolder.getId())) {
                        this.runningJobGroups.remove(jobHolder.getGroupId());
                    }
                    hashSet = hashSet2;
                }
            }
            hashSet2 = hashSet;
            hashSet = hashSet2;
        }
        return cancelResult;
    }

    /* access modifiers changed from: private */
    public void markJobsAsCancelledAndFilterAlreadyCancelled(Set<JobHolder> set, JobQueue jobQueue, Set<Long> set2) {
        Iterator<JobHolder> it = set.iterator();
        while (it.hasNext()) {
            JobHolder next = it.next();
            if (next.isCancelled()) {
                it.remove();
            } else {
                next.markAsCancelled();
                set2.add(next.getId());
                jobQueue.onJobCancelled(next);
            }
        }
    }

    public void addJobInBackground(Job job) {
        addJobInBackground(job, (AsyncAddCallback) null);
    }

    public void addJobInBackground(final Job job, final AsyncAddCallback asyncAddCallback) {
        this.timedExecutor.execute(new Runnable() {
            public void run() {
                try {
                    long addJob = JobManager.this.addJob(job);
                    if (asyncAddCallback != null) {
                        asyncAddCallback.onAdded(addJob);
                    }
                } catch (Throwable th) {
                    JqLog.e(th, "addJobInBackground received an exception. job class: %s", job.getClass().getSimpleName());
                }
            }
        });
    }

    private void addOnAddedLock(ConcurrentHashMap<Long, CountDownLatch> concurrentHashMap, long j) {
        concurrentHashMap.put(Long.valueOf(j), new CountDownLatch(1));
    }

    private void waitForOnAddedLock(ConcurrentHashMap<Long, CountDownLatch> concurrentHashMap, long j) {
        CountDownLatch countDownLatch = concurrentHashMap.get(Long.valueOf(j));
        if (countDownLatch != null) {
            try {
                countDownLatch.await();
            } catch (InterruptedException e2) {
                JqLog.e(e2, "could not wait for onAdded lock", new Object[0]);
            }
        }
    }

    private void clearOnAddedLock(ConcurrentHashMap<Long, CountDownLatch> concurrentHashMap, long j) {
        CountDownLatch countDownLatch = concurrentHashMap.get(Long.valueOf(j));
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
        concurrentHashMap.remove(Long.valueOf(j));
    }

    /* access modifiers changed from: private */
    public long ensureConsumerWhenNeeded(Boolean bool) {
        Long nextJobDelayUntilNs;
        Long nextJobDelayUntilNs2;
        if (bool == null) {
            bool = Boolean.valueOf(this.networkUtil instanceof NetworkEventProvider ? hasNetwork() : true);
        }
        Long nextDelayForGroups = this.runningJobGroups.getNextDelayForGroups();
        Collection<String> safe = this.runningJobGroups.getSafe();
        synchronized (this.nonPersistentJobQueue) {
            nextJobDelayUntilNs = this.nonPersistentJobQueue.getNextJobDelayUntilNs(bool.booleanValue(), safe);
        }
        if (nextDelayForGroups == null || (nextJobDelayUntilNs != null && nextJobDelayUntilNs.longValue() < nextDelayForGroups.longValue())) {
            nextDelayForGroups = nextJobDelayUntilNs;
        }
        if (nextDelayForGroups == null || nextDelayForGroups.longValue() > System.nanoTime()) {
            synchronized (this.persistentJobQueue) {
                nextJobDelayUntilNs2 = this.persistentJobQueue.getNextJobDelayUntilNs(bool.booleanValue(), safe);
            }
            if (nextJobDelayUntilNs2 == null || (nextDelayForGroups != null && nextJobDelayUntilNs2.longValue() >= nextDelayForGroups.longValue())) {
                nextJobDelayUntilNs2 = nextDelayForGroups;
            }
            if (nextJobDelayUntilNs2 == null) {
                return Clock.MAX_TIME;
            }
            if (nextJobDelayUntilNs2.longValue() < System.nanoTime()) {
                notifyJobConsumer();
                return 0;
            }
            double longValue = (double) (nextJobDelayUntilNs2.longValue() - System.nanoTime());
            Double.isNaN(longValue);
            long ceil = (long) Math.ceil(longValue / 1000000.0d);
            ensureConsumerOnTime(ceil);
            return ceil;
        }
        notifyJobConsumer();
        return 0;
    }

    /* access modifiers changed from: private */
    public void notifyJobConsumer() {
        synchronized (this.newJobListeners) {
            this.newJobListeners.notifyAll();
        }
        this.jobConsumerExecutor.considerAddingConsumer();
    }

    private void ensureConsumerOnTime(long j) {
        this.timedExecutor.schedule(this.notifyRunnable, j, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: private */
    public boolean hasNetwork() {
        NetworkUtil networkUtil2 = this.networkUtil;
        return networkUtil2 == null || networkUtil2.isConnected(this.appContext);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x007c, code lost:
        if (r1 == false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x007e, code lost:
        waitForOnAddedLock(r8.persistentOnAddedLocks, r6.getId().longValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x008c, code lost:
        waitForOnAddedLock(r8.nonPersistentOnAddedLocks, r6.getId().longValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0099, code lost:
        r6.getJob().setApplicationContext(r8.appContext);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a2, code lost:
        return r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.path.android.jobqueue.JobHolder getNextJob() {
        /*
            r8 = this;
            boolean r0 = r8.hasNetwork()
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "looking for next job"
            com.path.android.jobqueue.log.JqLog.d(r3, r2)
            java.lang.Object r2 = r8.getNextJobLock
            monitor-enter(r2)
            com.path.android.jobqueue.RunningJobSet r3 = r8.runningJobGroups     // Catch:{ all -> 0x00a6 }
            java.util.Collection r3 = r3.getSafe()     // Catch:{ all -> 0x00a6 }
            boolean r4 = com.path.android.jobqueue.log.JqLog.isDebugEnabled()     // Catch:{ all -> 0x00a6 }
            r5 = 1
            if (r4 == 0) goto L_0x002b
            java.lang.String r4 = "running groups %s"
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x00a6 }
            java.lang.String r7 = ","
            java.lang.String r7 = com.path.android.jobqueue.persistentQueue.sqlite.SqlHelper.joinStrings(r7, r3)     // Catch:{ all -> 0x00a6 }
            r6[r1] = r7     // Catch:{ all -> 0x00a6 }
            com.path.android.jobqueue.log.JqLog.d(r4, r6)     // Catch:{ all -> 0x00a6 }
        L_0x002b:
            com.path.android.jobqueue.JobQueue r4 = r8.nonPersistentJobQueue     // Catch:{ all -> 0x00a6 }
            monitor-enter(r4)     // Catch:{ all -> 0x00a6 }
            com.path.android.jobqueue.JobQueue r6 = r8.nonPersistentJobQueue     // Catch:{ all -> 0x00a3 }
            com.path.android.jobqueue.JobHolder r6 = r6.nextJobAndIncRunCount(r0, r3)     // Catch:{ all -> 0x00a3 }
            monitor-exit(r4)     // Catch:{ all -> 0x00a3 }
            java.lang.String r4 = "non persistent result %s"
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ all -> 0x00a6 }
            r7[r1] = r6     // Catch:{ all -> 0x00a6 }
            com.path.android.jobqueue.log.JqLog.d(r4, r7)     // Catch:{ all -> 0x00a6 }
            if (r6 != 0) goto L_0x0058
            com.path.android.jobqueue.JobQueue r4 = r8.persistentJobQueue     // Catch:{ all -> 0x00a6 }
            monitor-enter(r4)     // Catch:{ all -> 0x00a6 }
            com.path.android.jobqueue.JobQueue r6 = r8.persistentJobQueue     // Catch:{ all -> 0x0055 }
            com.path.android.jobqueue.JobHolder r6 = r6.nextJobAndIncRunCount(r0, r3)     // Catch:{ all -> 0x0055 }
            monitor-exit(r4)     // Catch:{ all -> 0x0055 }
            java.lang.String r0 = "persistent result %s"
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ all -> 0x00a6 }
            r3[r1] = r6     // Catch:{ all -> 0x00a6 }
            com.path.android.jobqueue.log.JqLog.d(r0, r3)     // Catch:{ all -> 0x00a6 }
            r1 = 1
            goto L_0x0058
        L_0x0055:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0055 }
            throw r0     // Catch:{ all -> 0x00a6 }
        L_0x0058:
            if (r6 != 0) goto L_0x005d
            r0 = 0
            monitor-exit(r2)     // Catch:{ all -> 0x00a6 }
            return r0
        L_0x005d:
            if (r1 == 0) goto L_0x006c
            com.path.android.jobqueue.di.DependencyInjector r0 = r8.dependencyInjector     // Catch:{ all -> 0x00a6 }
            if (r0 == 0) goto L_0x006c
            com.path.android.jobqueue.di.DependencyInjector r0 = r8.dependencyInjector     // Catch:{ all -> 0x00a6 }
            com.path.android.jobqueue.Job r3 = r6.getJob()     // Catch:{ all -> 0x00a6 }
            r0.inject(r3)     // Catch:{ all -> 0x00a6 }
        L_0x006c:
            java.lang.String r0 = r6.getGroupId()     // Catch:{ all -> 0x00a6 }
            if (r0 == 0) goto L_0x007b
            com.path.android.jobqueue.RunningJobSet r0 = r8.runningJobGroups     // Catch:{ all -> 0x00a6 }
            java.lang.String r3 = r6.getGroupId()     // Catch:{ all -> 0x00a6 }
            r0.add(r3)     // Catch:{ all -> 0x00a6 }
        L_0x007b:
            monitor-exit(r2)     // Catch:{ all -> 0x00a6 }
            if (r1 == 0) goto L_0x008c
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.util.concurrent.CountDownLatch> r0 = r8.persistentOnAddedLocks
            java.lang.Long r1 = r6.getId()
            long r1 = r1.longValue()
            r8.waitForOnAddedLock(r0, r1)
            goto L_0x0099
        L_0x008c:
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.util.concurrent.CountDownLatch> r0 = r8.nonPersistentOnAddedLocks
            java.lang.Long r1 = r6.getId()
            long r1 = r1.longValue()
            r8.waitForOnAddedLock(r0, r1)
        L_0x0099:
            com.path.android.jobqueue.Job r0 = r6.getJob()
            android.content.Context r1 = r8.appContext
            r0.setApplicationContext(r1)
            return r6
        L_0x00a3:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00a3 }
            throw r0     // Catch:{ all -> 0x00a6 }
        L_0x00a6:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00a6 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.path.android.jobqueue.JobManager.getNextJob():com.path.android.jobqueue.JobHolder");
    }

    /* access modifiers changed from: private */
    public void reAddJob(JobHolder jobHolder) {
        JqLog.d("re-adding job %s", jobHolder.getId());
        if (jobHolder.isCancelled()) {
            JqLog.d("not re-adding cancelled job " + jobHolder, new Object[0]);
        } else if (jobHolder.getJob().isPersistent()) {
            synchronized (this.persistentJobQueue) {
                this.persistentJobQueue.insertOrReplace(jobHolder);
            }
        } else {
            synchronized (this.nonPersistentJobQueue) {
                this.nonPersistentJobQueue.insertOrReplace(jobHolder);
            }
        }
        if (jobHolder.getGroupId() != null) {
            this.runningJobGroups.remove(jobHolder.getGroupId());
        }
    }

    public JobStatus getJobStatus(long j, boolean z) {
        JobHolder jobHolder;
        if (this.jobConsumerExecutor.isRunning(j, z)) {
            return JobStatus.RUNNING;
        }
        if (z) {
            synchronized (this.persistentJobQueue) {
                jobHolder = this.persistentJobQueue.findJobById(j);
            }
        } else {
            synchronized (this.nonPersistentJobQueue) {
                jobHolder = this.nonPersistentJobQueue.findJobById(j);
            }
        }
        if (jobHolder == null) {
            return JobStatus.UNKNOWN;
        }
        boolean hasNetwork = hasNetwork();
        if (jobHolder.requiresNetwork() && !hasNetwork) {
            return JobStatus.WAITING_NOT_READY;
        }
        if (jobHolder.getDelayUntilNs() > System.nanoTime()) {
            return JobStatus.WAITING_NOT_READY;
        }
        return JobStatus.WAITING_READY;
    }

    /* access modifiers changed from: private */
    public void removeJob(JobHolder jobHolder) {
        if (jobHolder.getJob().isPersistent()) {
            synchronized (this.persistentJobQueue) {
                this.persistentJobQueue.remove(jobHolder);
            }
        } else {
            synchronized (this.nonPersistentJobQueue) {
                this.nonPersistentJobQueue.remove(jobHolder);
            }
        }
        if (jobHolder.getGroupId() != null) {
            this.runningJobGroups.remove(jobHolder.getGroupId());
        }
    }

    public synchronized void stopAndWaitUntilConsumersAreFinished() throws InterruptedException {
        stop();
        this.timedExecutor.shutdownNow();
        synchronized (this.newJobListeners) {
            this.newJobListeners.notifyAll();
        }
        this.jobConsumerExecutor.waitUntilAllConsumersAreFinished();
        this.timedExecutor = Executors.newSingleThreadScheduledExecutor();
    }

    public synchronized void clear() {
        synchronized (this.nonPersistentJobQueue) {
            this.nonPersistentJobQueue.clear();
            this.nonPersistentOnAddedLocks.clear();
        }
        synchronized (this.persistentJobQueue) {
            this.persistentJobQueue.clear();
            this.persistentOnAddedLocks.clear();
        }
        this.runningJobGroups.clear();
    }

    public void onNetworkChange(boolean z) {
        ensureConsumerWhenNeeded(Boolean.valueOf(z));
    }

    public static class DefaultQueueFactory implements QueueFactory {
        SqliteJobQueue.JobSerializer jobSerializer;

        public DefaultQueueFactory() {
            this.jobSerializer = new SqliteJobQueue.JavaSerializer();
        }

        public DefaultQueueFactory(SqliteJobQueue.JobSerializer jobSerializer2) {
            this.jobSerializer = jobSerializer2;
        }

        public JobQueue createPersistentQueue(Context context, Long l, String str, boolean z) {
            return new CachedJobQueue(new SqliteJobQueue(context, l.longValue(), str, this.jobSerializer, z));
        }

        public JobQueue createNonPersistent(Context context, Long l, String str, boolean z) {
            return new CachedJobQueue(new NonPersistentPriorityQueue(l.longValue(), str, z));
        }
    }
}
