package com.tencent.imcore;

public class NumberGroupsDetail {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public NumberGroupsDetail() {
        this(internalGroupExtJNI.new_NumberGroupsDetail(), true);
    }

    protected NumberGroupsDetail(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NumberGroupsDetail numberGroupsDetail) {
        if (numberGroupsDetail == null) {
            return 0;
        }
        return numberGroupsDetail.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_NumberGroupsDetail(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public GroupDetailInfoVec getInfos() {
        long NumberGroupsDetail_infos_get = internalGroupExtJNI.NumberGroupsDetail_infos_get(this.swigCPtr, this);
        if (NumberGroupsDetail_infos_get == 0) {
            return null;
        }
        return new GroupDetailInfoVec(NumberGroupsDetail_infos_get, false);
    }

    public long getNum() {
        return internalGroupExtJNI.NumberGroupsDetail_num_get(this.swigCPtr, this);
    }

    public void setInfos(GroupDetailInfoVec groupDetailInfoVec) {
        internalGroupExtJNI.NumberGroupsDetail_infos_set(this.swigCPtr, this, GroupDetailInfoVec.getCPtr(groupDetailInfoVec), groupDetailInfoVec);
    }

    public void setNum(long j) {
        internalGroupExtJNI.NumberGroupsDetail_num_set(this.swigCPtr, this, j);
    }
}
