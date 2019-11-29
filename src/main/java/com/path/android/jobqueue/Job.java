package com.path.android.jobqueue;

import android.content.Context;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class Job implements Serializable {
    public static final int DEFAULT_RETRY_LIMIT = 20;
    private static final long serialVersionUID = 3;
    private transient Context applicationContext;
    transient boolean cancelled;
    private transient int currentRunCount;
    private transient long delayInMs;
    private String groupId;
    private boolean persistent;
    transient int priority;
    private Set<String> readonlyTags;
    private boolean requiresNetwork;
    transient RetryConstraint retryConstraint;

    /* access modifiers changed from: protected */
    public int getRetryLimit() {
        return 20;
    }

    public abstract void onAdded();

    /* access modifiers changed from: protected */
    public abstract void onCancel();

    public abstract void onRun() throws Throwable;

    /* access modifiers changed from: protected */
    @Deprecated
    public boolean shouldReRunOnThrowable(Throwable th) {
        return true;
    }

    protected Job(Params params) {
        Set<String> set;
        this.requiresNetwork = params.doesRequireNetwork();
        this.persistent = params.isPersistent();
        this.groupId = params.getGroupId();
        this.priority = params.getPriority();
        this.delayInMs = params.getDelayMs();
        HashSet<String> tags = params.getTags();
        if (tags == null) {
            set = null;
        } else {
            set = Collections.unmodifiableSet(tags);
        }
        this.readonlyTags = set;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final long getDelayInMs() {
        return this.delayInMs;
    }

    public final Set<String> getTags() {
        return this.readonlyTags;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeBoolean(this.requiresNetwork);
        objectOutputStream.writeObject(this.groupId);
        objectOutputStream.writeBoolean(this.persistent);
        Set<String> set = this.readonlyTags;
        int size = set == null ? 0 : set.size();
        objectOutputStream.writeInt(size);
        if (size > 0) {
            for (String writeUTF : this.readonlyTags) {
                objectOutputStream.writeUTF(writeUTF);
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        this.requiresNetwork = objectInputStream.readBoolean();
        this.groupId = (String) objectInputStream.readObject();
        this.persistent = objectInputStream.readBoolean();
        int readInt = objectInputStream.readInt();
        if (readInt > 0) {
            this.readonlyTags = new HashSet(readInt);
            for (int i = 0; i < readInt; i++) {
                this.readonlyTags.add(objectInputStream.readUTF());
            }
        }
    }

    public final boolean isPersistent() {
        return this.persistent;
    }

    /* access modifiers changed from: protected */
    public RetryConstraint shouldReRunOnThrowable(Throwable th, int i, int i2) {
        return shouldReRunOnThrowable(th) ? RetryConstraint.RETRY : RetryConstraint.CANCEL;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int safeRun(com.path.android.jobqueue.JobHolder r8, int r9) {
        /*
            r7 = this;
            r7.currentRunCount = r9
            boolean r0 = com.path.android.jobqueue.log.JqLog.isDebugEnabled()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001b
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.Class r3 = r7.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r0[r2] = r3
            java.lang.String r3 = "running job %s"
            com.path.android.jobqueue.log.JqLog.d(r3, r0)
        L_0x001b:
            r7.onRun()     // Catch:{ Throwable -> 0x0030 }
            boolean r0 = com.path.android.jobqueue.log.JqLog.isDebugEnabled()     // Catch:{ Throwable -> 0x0030 }
            if (r0 == 0) goto L_0x002d
            java.lang.String r0 = "finished job %s"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x0030 }
            r3[r2] = r7     // Catch:{ Throwable -> 0x0030 }
            com.path.android.jobqueue.log.JqLog.d(r0, r3)     // Catch:{ Throwable -> 0x0030 }
        L_0x002d:
            r9 = 0
            r3 = 0
            goto L_0x0066
        L_0x0030:
            r0 = move-exception
            java.lang.Object[] r3 = new java.lang.Object[r1]
            r3[r2] = r7
            java.lang.String r4 = "error while executing job %s"
            com.path.android.jobqueue.log.JqLog.e(r0, r4, r3)
            int r3 = r7.getRetryLimit()
            if (r9 >= r3) goto L_0x0042
            r3 = 1
            goto L_0x0043
        L_0x0042:
            r3 = 0
        L_0x0043:
            if (r3 == 0) goto L_0x0065
            boolean r4 = r7.cancelled
            if (r4 != 0) goto L_0x0065
            int r4 = r7.getRetryLimit()     // Catch:{ Throwable -> 0x005d }
            com.path.android.jobqueue.RetryConstraint r9 = r7.shouldReRunOnThrowable(r0, r9, r4)     // Catch:{ Throwable -> 0x005d }
            if (r9 != 0) goto L_0x0055
            com.path.android.jobqueue.RetryConstraint r9 = com.path.android.jobqueue.RetryConstraint.RETRY     // Catch:{ Throwable -> 0x005d }
        L_0x0055:
            r7.retryConstraint = r9     // Catch:{ Throwable -> 0x005d }
            boolean r9 = r9.shouldRetry()     // Catch:{ Throwable -> 0x005d }
            r3 = r9
            goto L_0x0065
        L_0x005d:
            r9 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r4 = "shouldReRunOnThrowable did throw an exception"
            com.path.android.jobqueue.log.JqLog.e(r9, r4, r0)
        L_0x0065:
            r9 = 1
        L_0x0066:
            r0 = 4
            java.lang.Object[] r4 = new java.lang.Object[r0]
            r4[r2] = r7
            r2 = r9 ^ 1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r4[r1] = r2
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r3)
            r5 = 2
            r4[r5] = r2
            boolean r2 = r7.cancelled
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r6 = 3
            r4[r6] = r2
            java.lang.String r2 = "safeRunResult for %s : %s. re run:%s. cancelled: %s"
            com.path.android.jobqueue.log.JqLog.d(r2, r4)
            if (r9 != 0) goto L_0x008b
            return r1
        L_0x008b:
            boolean r8 = r8.isCancelled()
            if (r8 == 0) goto L_0x0092
            return r6
        L_0x0092:
            if (r3 == 0) goto L_0x0095
            return r0
        L_0x0095:
            r7.onCancel()     // Catch:{ Throwable -> 0x0098 }
        L_0x0098:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.path.android.jobqueue.Job.safeRun(com.path.android.jobqueue.JobHolder, int):int");
    }

    /* access modifiers changed from: protected */
    public int getCurrentRunCount() {
        return this.currentRunCount;
    }

    public final boolean requiresNetwork() {
        return this.requiresNetwork;
    }

    public final String getRunGroupId() {
        return this.groupId;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void assertNotCancelled() {
        if (this.cancelled) {
            throw new RuntimeException("job is cancelled");
        }
    }

    /* access modifiers changed from: package-private */
    public void setApplicationContext(Context context) {
        this.applicationContext = context;
    }

    public Context getApplicationContext() {
        return this.applicationContext;
    }
}
