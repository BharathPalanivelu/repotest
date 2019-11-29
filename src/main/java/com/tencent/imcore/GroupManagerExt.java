package com.tencent.imcore;

public class GroupManagerExt extends GroupManager {
    private transient long swigCPtr;

    protected GroupManagerExt(long j, boolean z) {
        super(internalGroupExtJNI.GroupManagerExt_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public GroupManagerExt(String str, IGroupNotify iGroupNotify) {
        this(internalGroupExtJNI.new_GroupManagerExt(str, IGroupNotify.getCPtr(iGroupNotify), iGroupNotify), true);
    }

    protected static long getCPtr(GroupManagerExt groupManagerExt) {
        if (groupManagerExt == null) {
            return 0;
        }
        return groupManagerExt.swigCPtr;
    }

    public static void onMsgEventExt(String str, MsgVec msgVec) {
        internalGroupExtJNI.GroupManagerExt_onMsgEventExt(str, MsgVec.getCPtr(msgVec), msgVec);
    }

    public SWIGTYPE_p_std__shared_ptrT_imcore__GroupAssistant_t assistant() {
        return new SWIGTYPE_p_std__shared_ptrT_imcore__GroupAssistant_t(internalGroupExtJNI.GroupManagerExt_assistant(this.swigCPtr, this), true);
    }

    public boolean checkGroupModifyOption(ModifyGroupBaseInfoOption modifyGroupBaseInfoOption) {
        return internalGroupExtJNI.GroupManagerExt_checkGroupModifyOption(this.swigCPtr, this, ModifyGroupBaseInfoOption.getCPtr(modifyGroupBaseInfoOption), modifyGroupBaseInfoOption);
    }

    public boolean checkMemberModifyOption(ModifyGroupMemberInfoOption modifyGroupMemberInfoOption) {
        return internalGroupExtJNI.GroupManagerExt_checkMemberModifyOption(this.swigCPtr, this, ModifyGroupMemberInfoOption.getCPtr(modifyGroupMemberInfoOption), modifyGroupMemberInfoOption);
    }

    public boolean createGroup(String str, StrVec strVec, byte[] bArr, ICallbackWithString iCallbackWithString) {
        return internalGroupExtJNI.GroupManagerExt_createGroup(this.swigCPtr, this, str, StrVec.getCPtr(strVec), strVec, bArr, ICallbackWithString.getCPtr(iCallbackWithString), iCallbackWithString);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_GroupManagerExt(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean deleteGroupMember(String str, StrVec strVec, ICallbackWithMemberResultVec iCallbackWithMemberResultVec, byte[] bArr) {
        return internalGroupExtJNI.GroupManagerExt_deleteGroupMember(this.swigCPtr, this, str, StrVec.getCPtr(strVec), strVec, ICallbackWithMemberResultVec.getCPtr(iCallbackWithMemberResultVec), iCallbackWithMemberResultVec, bArr);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public boolean getGroupBaseInfo(StrVec strVec, ICallbackWithGroupDetailInfoVec iCallbackWithGroupDetailInfoVec) {
        return internalGroupExtJNI.GroupManagerExt_getGroupBaseInfo(this.swigCPtr, this, StrVec.getCPtr(strVec), strVec, ICallbackWithGroupDetailInfoVec.getCPtr(iCallbackWithGroupDetailInfoVec), iCallbackWithGroupDetailInfoVec);
    }

    public boolean getGroupList(boolean z, ICallbackWithGroupBaseInfoVec iCallbackWithGroupBaseInfoVec) {
        return internalGroupExtJNI.GroupManagerExt_getGroupList(this.swigCPtr, this, z, ICallbackWithGroupBaseInfoVec.getCPtr(iCallbackWithGroupBaseInfoVec), iCallbackWithGroupBaseInfoVec);
    }

    public boolean getGroupMembers(String str, ICallbackWithMemberInfoVec iCallbackWithMemberInfoVec) {
        return internalGroupExtJNI.GroupManagerExt_getGroupMembers(this.swigCPtr, this, str, ICallbackWithMemberInfoVec.getCPtr(iCallbackWithMemberInfoVec), iCallbackWithMemberInfoVec);
    }

    public boolean getGroupMembersByFilter(String str, long j, GroupMemRoleFilter groupMemRoleFilter, BytesVec bytesVec, long j2, ICallbackWithSeqMemberInfo iCallbackWithSeqMemberInfo) {
        return internalGroupExtJNI.GroupManagerExt_getGroupMembersByFilter(this.swigCPtr, this, str, j, groupMemRoleFilter.swigValue(), BytesVec.getCPtr(bytesVec), bytesVec, j2, ICallbackWithSeqMemberInfo.getCPtr(iCallbackWithSeqMemberInfo), iCallbackWithSeqMemberInfo);
    }

    public boolean getGroupMembersInfo(String str, StrVec strVec, ICallbackWithMemberInfoVec iCallbackWithMemberInfoVec) {
        return internalGroupExtJNI.GroupManagerExt_getGroupMembersInfo(this.swigCPtr, this, str, StrVec.getCPtr(strVec), strVec, ICallbackWithMemberInfoVec.getCPtr(iCallbackWithMemberInfoVec), iCallbackWithMemberInfoVec);
    }

    public boolean getGroupPublicInfo(StrVec strVec, ICallbackWithGroupDetailInfoVec iCallbackWithGroupDetailInfoVec) {
        return internalGroupExtJNI.GroupManagerExt_getGroupPublicInfo(this.swigCPtr, this, StrVec.getCPtr(strVec), strVec, ICallbackWithGroupDetailInfoVec.getCPtr(iCallbackWithGroupDetailInfoVec), iCallbackWithGroupDetailInfoVec);
    }

    public int getGroups(StrVec strVec, GroupCacheInfoVec groupCacheInfoVec) {
        return internalGroupExtJNI.GroupManagerExt_getGroups(this.swigCPtr, this, StrVec.getCPtr(strVec), strVec, GroupCacheInfoVec.getCPtr(groupCacheInfoVec), groupCacheInfoVec);
    }

    public boolean getPendency(GetGroupPendencyOption getGroupPendencyOption, ICallbackWithGroupPendencyResult iCallbackWithGroupPendencyResult) {
        return internalGroupExtJNI.GroupManagerExt_getPendency(this.swigCPtr, this, GetGroupPendencyOption.getCPtr(getGroupPendencyOption), getGroupPendencyOption, ICallbackWithGroupPendencyResult.getCPtr(iCallbackWithGroupPendencyResult), iCallbackWithGroupPendencyResult);
    }

    public boolean getSelfInfo(String str, ICallbackWithMemberInfoVec iCallbackWithMemberInfoVec) {
        return internalGroupExtJNI.GroupManagerExt_getSelfInfo(this.swigCPtr, this, str, ICallbackWithMemberInfoVec.getCPtr(iCallbackWithMemberInfoVec), iCallbackWithMemberInfoVec);
    }

    public boolean handleInviteRequest(String str, String str2, byte[] bArr, byte[] bArr2, long j, long j2, byte[] bArr3, INotifyCallback iNotifyCallback) {
        return internalGroupExtJNI.GroupManagerExt_handleInviteRequest(this.swigCPtr, this, str, str2, bArr, bArr2, j, j2, bArr3, INotifyCallback.getCPtr(iNotifyCallback), iNotifyCallback);
    }

    public boolean handleJoinRequest(String str, String str2, byte[] bArr, byte[] bArr2, long j, long j2, byte[] bArr3, INotifyCallback iNotifyCallback) {
        return internalGroupExtJNI.GroupManagerExt_handleJoinRequest(this.swigCPtr, this, str, str2, bArr, bArr2, j, j2, bArr3, INotifyCallback.getCPtr(iNotifyCallback), iNotifyCallback);
    }

    public boolean inviteGroupMember(String str, StrVec strVec, ICallbackWithMemberResultVec iCallbackWithMemberResultVec) {
        return internalGroupExtJNI.GroupManagerExt_inviteGroupMember(this.swigCPtr, this, str, StrVec.getCPtr(strVec), strVec, ICallbackWithMemberResultVec.getCPtr(iCallbackWithMemberResultVec), iCallbackWithMemberResultVec);
    }

    public boolean modifyGroupBaseInfo(ModifyGroupBaseInfoOption modifyGroupBaseInfoOption, INotifyCallback iNotifyCallback) {
        return internalGroupExtJNI.GroupManagerExt_modifyGroupBaseInfo(this.swigCPtr, this, ModifyGroupBaseInfoOption.getCPtr(modifyGroupBaseInfoOption), modifyGroupBaseInfoOption, INotifyCallback.getCPtr(iNotifyCallback), iNotifyCallback);
    }

    public boolean modifyGroupMemberInfo(ModifyGroupMemberInfoOption modifyGroupMemberInfoOption, INotifyCallback iNotifyCallback) {
        return internalGroupExtJNI.GroupManagerExt_modifyGroupMemberInfo(this.swigCPtr, this, ModifyGroupMemberInfoOption.getCPtr(modifyGroupMemberInfoOption), modifyGroupMemberInfoOption, INotifyCallback.getCPtr(iNotifyCallback), iNotifyCallback);
    }

    public boolean modifyGroupOwner(String str, String str2, INotifyCallback iNotifyCallback) {
        return internalGroupExtJNI.GroupManagerExt_modifyGroupOwner(this.swigCPtr, this, str, str2, INotifyCallback.getCPtr(iNotifyCallback), iNotifyCallback);
    }

    public boolean pendencyReport(long j, INotifyCallback iNotifyCallback) {
        return internalGroupExtJNI.GroupManagerExt_pendencyReport(this.swigCPtr, this, j, INotifyCallback.getCPtr(iNotifyCallback), iNotifyCallback);
    }

    public GetGroupBaseInfoOption prepareDefaultGetGroupOption(StrVec strVec) {
        return new GetGroupBaseInfoOption(internalGroupExtJNI.GroupManagerExt_prepareDefaultGetGroupOption(this.swigCPtr, this, StrVec.getCPtr(strVec), strVec), true);
    }

    public GetGroupMemInfoOption prepareDefaultGetMemOption(String str, StrVec strVec) {
        return new GetGroupMemInfoOption(internalGroupExtJNI.GroupManagerExt_prepareDefaultGetMemOption(this.swigCPtr, this, str, StrVec.getCPtr(strVec), strVec), true);
    }

    public boolean searchGroupByName(String str, long j, BytesVec bytesVec, long j2, long j3, ICallbackWithNumberGroupsDetail iCallbackWithNumberGroupsDetail) {
        return internalGroupExtJNI.GroupManagerExt_searchGroupByName(this.swigCPtr, this, str, j, BytesVec.getCPtr(bytesVec), bytesVec, j2, j3, ICallbackWithNumberGroupsDetail.getCPtr(iCallbackWithNumberGroupsDetail), iCallbackWithNumberGroupsDetail);
    }
}
