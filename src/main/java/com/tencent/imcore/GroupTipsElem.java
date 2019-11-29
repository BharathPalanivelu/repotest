package com.tencent.imcore;

public class GroupTipsElem {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GroupTipsElem() {
        this(internalJNI.new_GroupTipsElem(), true);
    }

    protected GroupTipsElem(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GroupTipsElem groupTipsElem) {
        if (groupTipsElem == null) {
            return 0;
        }
        return groupTipsElem.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_GroupTipsElem(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public StringGroupTipsMemberInfoMap getChanged_group_member_info() {
        long GroupTipsElem_changed_group_member_info_get = internalJNI.GroupTipsElem_changed_group_member_info_get(this.swigCPtr, this);
        if (GroupTipsElem_changed_group_member_info_get == 0) {
            return null;
        }
        return new StringGroupTipsMemberInfoMap(GroupTipsElem_changed_group_member_info_get, false);
    }

    public StringProfileMap getChanged_user_info() {
        long GroupTipsElem_changed_user_info_get = internalJNI.GroupTipsElem_changed_user_info_get(this.swigCPtr, this);
        if (GroupTipsElem_changed_user_info_get == 0) {
            return null;
        }
        return new StringProfileMap(GroupTipsElem_changed_user_info_get, false);
    }

    public GroupTipsElem_GroupInfoVec getGroup_change_list() {
        long GroupTipsElem_group_change_list_get = internalJNI.GroupTipsElem_group_change_list_get(this.swigCPtr, this);
        if (GroupTipsElem_group_change_list_get == 0) {
            return null;
        }
        return new GroupTipsElem_GroupInfoVec(GroupTipsElem_group_change_list_get, false);
    }

    public byte[] getGroup_id() {
        return internalJNI.GroupTipsElem_group_id_get(this.swigCPtr, this);
    }

    public byte[] getGroup_name() {
        return internalJNI.GroupTipsElem_group_name_get(this.swigCPtr, this);
    }

    public GroupTipsElem_MemberInfoVec getMember_change_list() {
        long GroupTipsElem_member_change_list_get = internalJNI.GroupTipsElem_member_change_list_get(this.swigCPtr, this);
        if (GroupTipsElem_member_change_list_get == 0) {
            return null;
        }
        return new GroupTipsElem_MemberInfoVec(GroupTipsElem_member_change_list_get, false);
    }

    public long getMember_num() {
        return internalJNI.GroupTipsElem_member_num_get(this.swigCPtr, this);
    }

    public GroupTipsMemberInfo getOp_group_member_info() {
        long GroupTipsElem_op_group_member_info_get = internalJNI.GroupTipsElem_op_group_member_info_get(this.swigCPtr, this);
        if (GroupTipsElem_op_group_member_info_get == 0) {
            return null;
        }
        return new GroupTipsMemberInfo(GroupTipsElem_op_group_member_info_get, false);
    }

    public String getOp_user() {
        return internalJNI.GroupTipsElem_op_user_get(this.swigCPtr, this);
    }

    public FriendProfile getOp_user_info() {
        long GroupTipsElem_op_user_info_get = internalJNI.GroupTipsElem_op_user_info_get(this.swigCPtr, this);
        if (GroupTipsElem_op_user_info_get == 0) {
            return null;
        }
        return new FriendProfile(GroupTipsElem_op_user_info_get, false);
    }

    public byte[] getPlatform() {
        return internalJNI.GroupTipsElem_platform_get(this.swigCPtr, this);
    }

    public long getTime() {
        return internalJNI.GroupTipsElem_time_get(this.swigCPtr, this);
    }

    public int getType() {
        return internalJNI.GroupTipsElem_type_get(this.swigCPtr, this);
    }

    public StrVec getUser_list() {
        long GroupTipsElem_user_list_get = internalJNI.GroupTipsElem_user_list_get(this.swigCPtr, this);
        if (GroupTipsElem_user_list_get == 0) {
            return null;
        }
        return new StrVec(GroupTipsElem_user_list_get, false);
    }

    public void setChanged_group_member_info(StringGroupTipsMemberInfoMap stringGroupTipsMemberInfoMap) {
        internalJNI.GroupTipsElem_changed_group_member_info_set(this.swigCPtr, this, StringGroupTipsMemberInfoMap.getCPtr(stringGroupTipsMemberInfoMap), stringGroupTipsMemberInfoMap);
    }

    public void setChanged_user_info(StringProfileMap stringProfileMap) {
        internalJNI.GroupTipsElem_changed_user_info_set(this.swigCPtr, this, StringProfileMap.getCPtr(stringProfileMap), stringProfileMap);
    }

    public void setGroup_change_list(GroupTipsElem_GroupInfoVec groupTipsElem_GroupInfoVec) {
        internalJNI.GroupTipsElem_group_change_list_set(this.swigCPtr, this, GroupTipsElem_GroupInfoVec.getCPtr(groupTipsElem_GroupInfoVec), groupTipsElem_GroupInfoVec);
    }

    public void setGroup_id(byte[] bArr) {
        internalJNI.GroupTipsElem_group_id_set(this.swigCPtr, this, bArr);
    }

    public void setGroup_name(byte[] bArr) {
        internalJNI.GroupTipsElem_group_name_set(this.swigCPtr, this, bArr);
    }

    public void setMember_change_list(GroupTipsElem_MemberInfoVec groupTipsElem_MemberInfoVec) {
        internalJNI.GroupTipsElem_member_change_list_set(this.swigCPtr, this, GroupTipsElem_MemberInfoVec.getCPtr(groupTipsElem_MemberInfoVec), groupTipsElem_MemberInfoVec);
    }

    public void setMember_num(long j) {
        internalJNI.GroupTipsElem_member_num_set(this.swigCPtr, this, j);
    }

    public void setOp_group_member_info(GroupTipsMemberInfo groupTipsMemberInfo) {
        internalJNI.GroupTipsElem_op_group_member_info_set(this.swigCPtr, this, GroupTipsMemberInfo.getCPtr(groupTipsMemberInfo), groupTipsMemberInfo);
    }

    public void setOp_user(String str) {
        internalJNI.GroupTipsElem_op_user_set(this.swigCPtr, this, str);
    }

    public void setOp_user_info(FriendProfile friendProfile) {
        internalJNI.GroupTipsElem_op_user_info_set(this.swigCPtr, this, FriendProfile.getCPtr(friendProfile), friendProfile);
    }

    public void setPlatform(byte[] bArr) {
        internalJNI.GroupTipsElem_platform_set(this.swigCPtr, this, bArr);
    }

    public void setTime(long j) {
        internalJNI.GroupTipsElem_time_set(this.swigCPtr, this, j);
    }

    public void setType(int i) {
        internalJNI.GroupTipsElem_type_set(this.swigCPtr, this, i);
    }

    public void setUser_list(StrVec strVec) {
        internalJNI.GroupTipsElem_user_list_set(this.swigCPtr, this, StrVec.getCPtr(strVec), strVec);
    }
}
