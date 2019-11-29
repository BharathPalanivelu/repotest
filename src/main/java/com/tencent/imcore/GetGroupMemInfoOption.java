package com.tencent.imcore;

public class GetGroupMemInfoOption {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GetGroupMemInfoOption() {
        this(internalGroupExtJNI.new_GetGroupMemInfoOption(), true);
    }

    protected GetGroupMemInfoOption(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GetGroupMemInfoOption getGroupMemInfoOption) {
        if (getGroupMemInfoOption == null) {
            return 0;
        }
        return getGroupMemInfoOption.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_GetGroupMemInfoOption(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public BytesMap getCustom_info() {
        long GetGroupMemInfoOption_custom_info_get = internalGroupExtJNI.GetGroupMemInfoOption_custom_info_get(this.swigCPtr, this);
        if (GetGroupMemInfoOption_custom_info_get == 0) {
            return null;
        }
        return new BytesMap(GetGroupMemInfoOption_custom_info_get, false);
    }

    public GroupMemRoleFilter getFilter() {
        return GroupMemRoleFilter.swigToEnum(internalGroupExtJNI.GetGroupMemInfoOption_filter_get(this.swigCPtr, this));
    }

    public long getFlag() {
        return internalGroupExtJNI.GetGroupMemInfoOption_flag_get(this.swigCPtr, this);
    }

    public String getGroup_id() {
        return internalGroupExtJNI.GetGroupMemInfoOption_group_id_get(this.swigCPtr, this);
    }

    public StrVec getMembers() {
        long GetGroupMemInfoOption_members_get = internalGroupExtJNI.GetGroupMemInfoOption_members_get(this.swigCPtr, this);
        if (GetGroupMemInfoOption_members_get == 0) {
            return null;
        }
        return new StrVec(GetGroupMemInfoOption_members_get, false);
    }

    public void setCustom_info(BytesMap bytesMap) {
        internalGroupExtJNI.GetGroupMemInfoOption_custom_info_set(this.swigCPtr, this, BytesMap.getCPtr(bytesMap), bytesMap);
    }

    public void setFilter(GroupMemRoleFilter groupMemRoleFilter) {
        internalGroupExtJNI.GetGroupMemInfoOption_filter_set(this.swigCPtr, this, groupMemRoleFilter.swigValue());
    }

    public void setFlag(long j) {
        internalGroupExtJNI.GetGroupMemInfoOption_flag_set(this.swigCPtr, this, j);
    }

    public void setGroup_id(String str) {
        internalGroupExtJNI.GetGroupMemInfoOption_group_id_set(this.swigCPtr, this, str);
    }

    public void setMembers(StrVec strVec) {
        internalGroupExtJNI.GetGroupMemInfoOption_members_set(this.swigCPtr, this, StrVec.getCPtr(strVec), strVec);
    }
}
