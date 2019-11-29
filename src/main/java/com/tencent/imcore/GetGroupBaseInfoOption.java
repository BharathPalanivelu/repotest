package com.tencent.imcore;

public class GetGroupBaseInfoOption {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GetGroupBaseInfoOption() {
        this(internalGroupExtJNI.new_GetGroupBaseInfoOption(), true);
    }

    protected GetGroupBaseInfoOption(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GetGroupBaseInfoOption getGroupBaseInfoOption) {
        if (getGroupBaseInfoOption == null) {
            return 0;
        }
        return getGroupBaseInfoOption.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_GetGroupBaseInfoOption(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public BytesMap getCustom_info() {
        long GetGroupBaseInfoOption_custom_info_get = internalGroupExtJNI.GetGroupBaseInfoOption_custom_info_get(this.swigCPtr, this);
        if (GetGroupBaseInfoOption_custom_info_get == 0) {
            return null;
        }
        return new BytesMap(GetGroupBaseInfoOption_custom_info_get, false);
    }

    public long getFlag() {
        return internalGroupExtJNI.GetGroupBaseInfoOption_flag_get(this.swigCPtr, this);
    }

    public StrVec getGroups() {
        long GetGroupBaseInfoOption_groups_get = internalGroupExtJNI.GetGroupBaseInfoOption_groups_get(this.swigCPtr, this);
        if (GetGroupBaseInfoOption_groups_get == 0) {
            return null;
        }
        return new StrVec(GetGroupBaseInfoOption_groups_get, false);
    }

    public void setCustom_info(BytesMap bytesMap) {
        internalGroupExtJNI.GetGroupBaseInfoOption_custom_info_set(this.swigCPtr, this, BytesMap.getCPtr(bytesMap), bytesMap);
    }

    public void setFlag(long j) {
        internalGroupExtJNI.GetGroupBaseInfoOption_flag_set(this.swigCPtr, this, j);
    }

    public void setGroups(StrVec strVec) {
        internalGroupExtJNI.GetGroupBaseInfoOption_groups_set(this.swigCPtr, this, StrVec.getCPtr(strVec), strVec);
    }
}
