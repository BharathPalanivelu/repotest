package com.tencent.imcore;

public class UGCElem {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public UGCElem() {
        this(internalJNI.new_UGCElem(), true);
    }

    protected UGCElem(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(UGCElem uGCElem) {
        if (uGCElem == null) {
            return 0;
        }
        return uGCElem.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_UGCElem(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public int getCover_height() {
        return internalJNI.UGCElem_cover_height_get(this.swigCPtr, this);
    }

    public byte[] getCover_path() {
        return internalJNI.UGCElem_cover_path_get(this.swigCPtr, this);
    }

    public int getCover_size() {
        return internalJNI.UGCElem_cover_size_get(this.swigCPtr, this);
    }

    public byte[] getCover_type() {
        return internalJNI.UGCElem_cover_type_get(this.swigCPtr, this);
    }

    public byte[] getCover_url() {
        return internalJNI.UGCElem_cover_url_get(this.swigCPtr, this);
    }

    public int getCover_width() {
        return internalJNI.UGCElem_cover_width_get(this.swigCPtr, this);
    }

    public byte[] getFile_id() {
        return internalJNI.UGCElem_file_id_get(this.swigCPtr, this);
    }

    public int getVideo_duration() {
        return internalJNI.UGCElem_video_duration_get(this.swigCPtr, this);
    }

    public byte[] getVideo_path() {
        return internalJNI.UGCElem_video_path_get(this.swigCPtr, this);
    }

    public int getVideo_size() {
        return internalJNI.UGCElem_video_size_get(this.swigCPtr, this);
    }

    public byte[] getVideo_type() {
        return internalJNI.UGCElem_video_type_get(this.swigCPtr, this);
    }

    public byte[] getVideo_url() {
        return internalJNI.UGCElem_video_url_get(this.swigCPtr, this);
    }

    public void setCover_height(int i) {
        internalJNI.UGCElem_cover_height_set(this.swigCPtr, this, i);
    }

    public void setCover_path(byte[] bArr) {
        internalJNI.UGCElem_cover_path_set(this.swigCPtr, this, bArr);
    }

    public void setCover_size(int i) {
        internalJNI.UGCElem_cover_size_set(this.swigCPtr, this, i);
    }

    public void setCover_type(byte[] bArr) {
        internalJNI.UGCElem_cover_type_set(this.swigCPtr, this, bArr);
    }

    public void setCover_url(byte[] bArr) {
        internalJNI.UGCElem_cover_url_set(this.swigCPtr, this, bArr);
    }

    public void setCover_width(int i) {
        internalJNI.UGCElem_cover_width_set(this.swigCPtr, this, i);
    }

    public void setFile_id(byte[] bArr) {
        internalJNI.UGCElem_file_id_set(this.swigCPtr, this, bArr);
    }

    public void setVideo_duration(int i) {
        internalJNI.UGCElem_video_duration_set(this.swigCPtr, this, i);
    }

    public void setVideo_path(byte[] bArr) {
        internalJNI.UGCElem_video_path_set(this.swigCPtr, this, bArr);
    }

    public void setVideo_size(int i) {
        internalJNI.UGCElem_video_size_set(this.swigCPtr, this, i);
    }

    public void setVideo_type(byte[] bArr) {
        internalJNI.UGCElem_video_type_set(this.swigCPtr, this, bArr);
    }

    public void setVideo_url(byte[] bArr) {
        internalJNI.UGCElem_video_url_set(this.swigCPtr, this, bArr);
    }
}
