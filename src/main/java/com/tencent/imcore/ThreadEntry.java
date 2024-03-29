package com.tencent.imcore;

public class ThreadEntry {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected ThreadEntry(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ThreadEntry threadEntry) {
        if (threadEntry == null) {
            return 0;
        }
        return threadEntry.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_ThreadEntry(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public void release() {
        internalJNI.ThreadEntry_release(this.swigCPtr, this);
    }

    public void run() {
        internalJNI.ThreadEntry_run(this.swigCPtr, this);
    }
}
