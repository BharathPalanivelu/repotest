package com.tencent.imcore;

public class GroupSelfInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GroupSelfInfo() {
        this(internalGroupExtJNI.new_GroupSelfInfo__SWIG_0(), true);
    }

    protected GroupSelfInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public GroupSelfInfo(MemberInfo memberInfo) {
        this(internalGroupExtJNI.new_GroupSelfInfo__SWIG_1(MemberInfo.getCPtr(memberInfo), memberInfo), true);
    }

    protected static long getCPtr(GroupSelfInfo groupSelfInfo) {
        if (groupSelfInfo == null) {
            return 0;
        }
        return groupSelfInfo.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_GroupSelfInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public long getDwMsgFalg() {
        return internalGroupExtJNI.GroupSelfInfo_dwMsgFalg_get(this.swigCPtr, this);
    }

    public long getJoinTime() {
        return internalGroupExtJNI.GroupSelfInfo_joinTime_get(this.swigCPtr, this);
    }

    public long getRole() {
        return internalGroupExtJNI.GroupSelfInfo_role_get(this.swigCPtr, this);
    }

    public long getUnreadNum() {
        return internalGroupExtJNI.GroupSelfInfo_unreadNum_get(this.swigCPtr, this);
    }

    public void setDwMsgFalg(long j) {
        internalGroupExtJNI.GroupSelfInfo_dwMsgFalg_set(this.swigCPtr, this, j);
    }

    public void setJoinTime(long j) {
        internalGroupExtJNI.GroupSelfInfo_joinTime_set(this.swigCPtr, this, j);
    }

    public void setRole(long j) {
        internalGroupExtJNI.GroupSelfInfo_role_set(this.swigCPtr, this, j);
    }

    public void setUnreadNum(long j) {
        internalGroupExtJNI.GroupSelfInfo_unreadNum_set(this.swigCPtr, this, j);
    }
}
