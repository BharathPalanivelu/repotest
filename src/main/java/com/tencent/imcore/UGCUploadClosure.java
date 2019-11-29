package com.tencent.imcore;

public class UGCUploadClosure {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected UGCUploadClosure(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(UGCUploadClosure uGCUploadClosure) {
        if (uGCUploadClosure == null) {
            return 0;
        }
        return uGCUploadClosure.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_UGCUploadClosure(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void done(String str, String str2, String str3) {
        internalJNI.UGCUploadClosure_done(this.swigCPtr, this, str, str2, str3);
    }

    public void fail(int i, String str) {
        internalJNI.UGCUploadClosure_fail(this.swigCPtr, this, i, str);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public void release() {
        internalJNI.UGCUploadClosure_release(this.swigCPtr, this);
    }
}
