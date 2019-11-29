package com.path.android.jobqueue.executor;

import com.path.android.jobqueue.JobHolder;
import com.path.android.jobqueue.TagConstraint;
import com.path.android.jobqueue.config.Configuration;
import com.path.android.jobqueue.log.JqLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class JobConsumerExecutor {
    private final AtomicInteger activeConsumerCount = new AtomicInteger(0);
    private final Contract contract;
    /* access modifiers changed from: private */
    public final int keepAliveSeconds;
    private int loadFactor;
    private int maxConsumerSize;
    private int minConsumerSize;
    private final ConcurrentHashMap<String, JobHolder> runningJobHolders;
    private final ThreadGroup threadGroup;

    public interface Contract {
        int countRemainingReadyJobs();

        JobHolder getNextJob(int i, TimeUnit timeUnit);

        void insertOrReplace(JobHolder jobHolder);

        boolean isRunning();

        void removeJob(JobHolder jobHolder);
    }

    public JobConsumerExecutor(Configuration configuration, Contract contract2) {
        this.loadFactor = configuration.getLoadFactor();
        this.maxConsumerSize = configuration.getMaxConsumerCount();
        this.minConsumerSize = configuration.getMinConsumerCount();
        this.keepAliveSeconds = configuration.getConsumerKeepAlive();
        this.contract = contract2;
        this.threadGroup = new ThreadGroup("JobConsumers");
        this.runningJobHolders = new ConcurrentHashMap<>();
    }

    public void considerAddingConsumer() {
        doINeedANewThread(false, true);
    }

    /* access modifiers changed from: private */
    public boolean canIDie() {
        return !doINeedANewThread(true, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
        if (r4 == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002b, code lost:
        r3.activeConsumerCount.decrementAndGet();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean doINeedANewThread(boolean r4, boolean r5) {
        /*
            r3 = this;
            com.path.android.jobqueue.executor.JobConsumerExecutor$Contract r0 = r3.contract
            boolean r0 = r0.isRunning()
            r1 = 0
            if (r0 != 0) goto L_0x0011
            if (r4 == 0) goto L_0x0010
            java.util.concurrent.atomic.AtomicInteger r4 = r3.activeConsumerCount
            r4.decrementAndGet()
        L_0x0010:
            return r1
        L_0x0011:
            java.lang.ThreadGroup r0 = r3.threadGroup
            monitor-enter(r0)
            boolean r2 = r3.isAboveLoadFactor(r4)     // Catch:{ all -> 0x0031 }
            if (r2 == 0) goto L_0x0028
            boolean r2 = r3.canAddMoreConsumers()     // Catch:{ all -> 0x0031 }
            if (r2 == 0) goto L_0x0028
            if (r5 == 0) goto L_0x0025
            r3.addConsumer()     // Catch:{ all -> 0x0031 }
        L_0x0025:
            r4 = 1
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            return r4
        L_0x0028:
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            if (r4 == 0) goto L_0x0030
            java.util.concurrent.atomic.AtomicInteger r4 = r3.activeConsumerCount
            r4.decrementAndGet()
        L_0x0030:
            return r1
        L_0x0031:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.path.android.jobqueue.executor.JobConsumerExecutor.doINeedANewThread(boolean, boolean):boolean");
    }

    private void addConsumer() {
        JqLog.d("adding another consumer", new Object[0]);
        synchronized (this.threadGroup) {
            Thread thread = new Thread(this.threadGroup, new JobConsumer(this.contract, this));
            this.activeConsumerCount.incrementAndGet();
            thread.start();
        }
    }

    private boolean canAddMoreConsumers() {
        boolean z;
        synchronized (this.threadGroup) {
            z = this.activeConsumerCount.intValue() < this.maxConsumerSize;
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isAboveLoadFactor(boolean r9) {
        /*
            r8 = this;
            java.lang.ThreadGroup r0 = r8.threadGroup
            monitor-enter(r0)
            java.util.concurrent.atomic.AtomicInteger r1 = r8.activeConsumerCount     // Catch:{ all -> 0x008f }
            int r1 = r1.intValue()     // Catch:{ all -> 0x008f }
            r2 = 1
            r3 = 0
            if (r9 == 0) goto L_0x000f
            r4 = 1
            goto L_0x0010
        L_0x000f:
            r4 = 0
        L_0x0010:
            int r1 = r1 - r4
            int r4 = r8.minConsumerSize     // Catch:{ all -> 0x008f }
            if (r1 < r4) goto L_0x002b
            int r4 = r8.loadFactor     // Catch:{ all -> 0x008f }
            int r4 = r4 * r1
            com.path.android.jobqueue.executor.JobConsumerExecutor$Contract r5 = r8.contract     // Catch:{ all -> 0x008f }
            int r5 = r5.countRemainingReadyJobs()     // Catch:{ all -> 0x008f }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.path.android.jobqueue.JobHolder> r6 = r8.runningJobHolders     // Catch:{ all -> 0x008f }
            int r6 = r6.size()     // Catch:{ all -> 0x008f }
            int r5 = r5 + r6
            if (r4 >= r5) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r4 = 0
            goto L_0x002c
        L_0x002b:
            r4 = 1
        L_0x002c:
            boolean r5 = com.path.android.jobqueue.log.JqLog.isDebugEnabled()     // Catch:{ all -> 0x008f }
            if (r5 == 0) goto L_0x008d
            java.lang.String r5 = "%s: load factor check. %s = (%d < %d)|| (%d * %d < %d + %d). consumer thread: %s"
            r6 = 9
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x008f }
            java.lang.Thread r7 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x008f }
            java.lang.String r7 = r7.getName()     // Catch:{ all -> 0x008f }
            r6[r3] = r7     // Catch:{ all -> 0x008f }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x008f }
            r6[r2] = r3     // Catch:{ all -> 0x008f }
            r2 = 2
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x008f }
            r6[r2] = r3     // Catch:{ all -> 0x008f }
            r2 = 3
            int r3 = r8.minConsumerSize     // Catch:{ all -> 0x008f }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x008f }
            r6[r2] = r3     // Catch:{ all -> 0x008f }
            r2 = 4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x008f }
            r6[r2] = r1     // Catch:{ all -> 0x008f }
            r1 = 5
            int r2 = r8.loadFactor     // Catch:{ all -> 0x008f }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x008f }
            r6[r1] = r2     // Catch:{ all -> 0x008f }
            r1 = 6
            com.path.android.jobqueue.executor.JobConsumerExecutor$Contract r2 = r8.contract     // Catch:{ all -> 0x008f }
            int r2 = r2.countRemainingReadyJobs()     // Catch:{ all -> 0x008f }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x008f }
            r6[r1] = r2     // Catch:{ all -> 0x008f }
            r1 = 7
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.path.android.jobqueue.JobHolder> r2 = r8.runningJobHolders     // Catch:{ all -> 0x008f }
            int r2 = r2.size()     // Catch:{ all -> 0x008f }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x008f }
            r6[r1] = r2     // Catch:{ all -> 0x008f }
            r1 = 8
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch:{ all -> 0x008f }
            r6[r1] = r9     // Catch:{ all -> 0x008f }
            com.path.android.jobqueue.log.JqLog.d(r5, r6)     // Catch:{ all -> 0x008f }
        L_0x008d:
            monitor-exit(r0)     // Catch:{ all -> 0x008f }
            return r4
        L_0x008f:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008f }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.path.android.jobqueue.executor.JobConsumerExecutor.isAboveLoadFactor(boolean):boolean");
    }

    /* access modifiers changed from: private */
    public void onBeforeRun(JobHolder jobHolder) {
        synchronized (this.runningJobHolders) {
            this.runningJobHolders.put(createRunningJobHolderKey(jobHolder), jobHolder);
        }
    }

    /* access modifiers changed from: private */
    public void onAfterRun(JobHolder jobHolder) {
        synchronized (this.runningJobHolders) {
            this.runningJobHolders.remove(createRunningJobHolderKey(jobHolder));
            this.runningJobHolders.notifyAll();
        }
    }

    private String createRunningJobHolderKey(JobHolder jobHolder) {
        return createRunningJobHolderKey(jobHolder.getId().longValue(), jobHolder.getJob().isPersistent());
    }

    private String createRunningJobHolderKey(long j, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append("_");
        sb.append(z ? "t" : "f");
        return sb.toString();
    }

    public boolean isRunning(long j, boolean z) {
        boolean containsKey;
        synchronized (this.runningJobHolders) {
            containsKey = this.runningJobHolders.containsKey(createRunningJobHolderKey(j, z));
        }
        return containsKey;
    }

    public void waitUntilDone(Set<Long> set, Set<Long> set2) throws InterruptedException {
        ArrayList arrayList = new ArrayList();
        for (Long longValue : set) {
            arrayList.add(createRunningJobHolderKey(longValue.longValue(), true));
        }
        for (Long longValue2 : set2) {
            arrayList.add(createRunningJobHolderKey(longValue2.longValue(), false));
        }
        synchronized (this.runningJobHolders) {
            while (containsAny(arrayList)) {
                this.runningJobHolders.wait();
            }
        }
    }

    private boolean containsAny(List<String> list) {
        for (String containsKey : list) {
            if (this.runningJobHolders.containsKey(containsKey)) {
                return true;
            }
        }
        return false;
    }

    public void inRunningJobHoldersLock(Runnable runnable) {
        synchronized (runnable) {
            runnable.run();
        }
    }

    public Set<JobHolder> findRunningByTags(TagConstraint tagConstraint, String[] strArr, boolean z) {
        HashSet hashSet = new HashSet();
        synchronized (this.runningJobHolders) {
            for (JobHolder next : this.runningJobHolders.values()) {
                JqLog.d("checking job tag %s. tags of job: %s", next.getJob(), next.getJob().getTags());
                if (next.hasTags()) {
                    if (z == next.getJob().isPersistent()) {
                        if (!next.isCancelled()) {
                            if (doesHolderMatchTags(next, tagConstraint, strArr)) {
                                hashSet.add(next);
                            }
                        }
                    }
                }
            }
        }
        return hashSet;
    }

    private boolean doesHolderMatchTags(JobHolder jobHolder, TagConstraint tagConstraint, String[] strArr) {
        if (tagConstraint == TagConstraint.ANY) {
            for (String contains : jobHolder.getTags()) {
                if (contains(strArr, contains)) {
                    return true;
                }
            }
            return false;
        }
        Set<String> tags = jobHolder.getTags();
        for (String contains2 : strArr) {
            if (!tags.contains(contains2)) {
                return false;
            }
        }
        return true;
    }

    private boolean contains(String[] strArr, String str) {
        for (String equals : strArr) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public void waitUntilAllConsumersAreFinished() throws InterruptedException {
        Thread[] threadArr = new Thread[(this.threadGroup.activeCount() * 3)];
        this.threadGroup.enumerate(threadArr);
        for (Thread thread : threadArr) {
            if (thread != null) {
                thread.join();
            }
        }
    }

    private static class JobConsumer implements Runnable {
        private final Contract contract;
        private boolean didRunOnce = false;
        private final JobConsumerExecutor executor;

        public JobConsumer(Contract contract2, JobConsumerExecutor jobConsumerExecutor) {
            this.executor = jobConsumerExecutor;
            this.contract = contract2;
        }

        public void run() {
            boolean access$300;
            JobHolder nextJob;
            boolean isDebugEnabled;
            do {
                try {
                    if (JqLog.isDebugEnabled()) {
                        if (!this.didRunOnce) {
                            JqLog.d("starting consumer %s", Thread.currentThread().getName());
                            this.didRunOnce = true;
                        } else {
                            JqLog.d("re-running consumer %s", Thread.currentThread().getName());
                        }
                    }
                    do {
                        nextJob = this.contract.isRunning() ? this.contract.getNextJob(this.executor.keepAliveSeconds, TimeUnit.SECONDS) : null;
                        if (nextJob != null) {
                            this.executor.onBeforeRun(nextJob);
                            int safeRun = nextJob.safeRun(nextJob.getRunCount());
                            if (safeRun == 1) {
                                nextJob.markAsSuccessful();
                                this.contract.removeJob(nextJob);
                            } else if (safeRun == 2) {
                                this.contract.removeJob(nextJob);
                            } else if (safeRun == 3) {
                                JqLog.d("running job failed and cancelled, doing nothing. Will be removed after it's onCancel is called by the JobManager", new Object[0]);
                            } else if (safeRun == 4) {
                                this.contract.insertOrReplace(nextJob);
                            }
                            this.executor.onAfterRun(nextJob);
                            continue;
                        }
                    } while (nextJob != null);
                    if (isDebugEnabled) {
                        if (access$300) {
                            continue;
                        } else {
                            JqLog.d("didn't allow me to die, re-running %s", Thread.currentThread().getName());
                            continue;
                        }
                    }
                } finally {
                    access$300 = this.executor.canIDie();
                    if (JqLog.isDebugEnabled()) {
                        if (access$300) {
                            JqLog.d("finishing consumer %s", Thread.currentThread().getName());
                        } else {
                            JqLog.d("didn't allow me to die, re-running %s", Thread.currentThread().getName());
                        }
                    }
                }
            } while (!access$300);
        }
    }
}
