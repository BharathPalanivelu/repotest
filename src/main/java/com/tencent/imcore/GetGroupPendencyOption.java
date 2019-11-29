package com.tencent.imcore;

public class GetGroupPendencyOption {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GetGroupPendencyOption() {
        this(internalGroupExtJNI.new_GetGroupPendencyOption(), true);
    }

    protected GetGroupPendencyOption(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GetGroupPendencyOption getGroupPendencyOption) {
        if (getGroupPendencyOption == null) {
            return 0;
        }
        return getGroupPendencyOption.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_GetGroupPendencyOption(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public long getMax_limited() {
        return internalGroupExtJNI.GetGroupPendencyOption_max_limited_get(this.swigCPtr, this);
    }

    public long getStart_time() {
        return internalGroupExtJNI.GetGroupPendencyOption_start_time_get(this.swigCPtr, this);
    }

    public void setMax_limited(long j) {
        internalGroupExtJNI.GetGroupPendencyOption_max_limited_set(this.swigCPtr, this, j);
    }

    public void setStart_time(long j) {
        internalGroupExtJNI.GetGroupPendencyOption_start_time_set(this.swigCPtr, this, j);
    }
}
