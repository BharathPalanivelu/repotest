package com.tencent.imcore;

public class IUGCUploader {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public IUGCUploader() {
        this(internalJNI.new_IUGCUploader(), true);
        internalJNI.IUGCUploader_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected IUGCUploader(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(IUGCUploader iUGCUploader) {
        if (iUGCUploader == null) {
            return 0;
        }
        return iUGCUploader.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_IUGCUploader(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    /* access modifiers changed from: protected */
    public void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        internalJNI.IUGCUploader_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        internalJNI.IUGCUploader_change_ownership(this, this.swigCPtr, true);
    }

    public void upload(Msg msg, int i, UGCUploadClosure uGCUploadClosure) {
        internalJNI.IUGCUploader_upload(this.swigCPtr, this, Msg.getCPtr(msg), msg, i, UGCUploadClosure.getCPtr(uGCUploadClosure), uGCUploadClosure);
    }
}
