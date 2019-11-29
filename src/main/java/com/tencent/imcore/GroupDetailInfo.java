package com.tencent.imcore;

public class GroupDetailInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GroupDetailInfo() {
        this(internalGroupExtJNI.new_GroupDetailInfo(), true);
    }

    protected GroupDetailInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GroupDetailInfo groupDetailInfo) {
        if (groupDetailInfo == null) {
            return 0;
        }
        return groupDetailInfo.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_GroupDetailInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public boolean getBAllShutup() {
        return internalGroupExtJNI.GroupDetailInfo_bAllShutup_get(this.swigCPtr, this);
    }

    public BytesMap getCustom_info() {
        long GroupDetailInfo_custom_info_get = internalGroupExtJNI.GroupDetailInfo_custom_info_get(this.swigCPtr, this);
        if (GroupDetailInfo_custom_info_get == 0) {
            return null;
        }
        return new BytesMap(GroupDetailInfo_custom_info_get, false);
    }

    public long getDdwOwnerTinyId() {
        return internalGroupExtJNI.GroupDetailInfo_ddwOwnerTinyId_get(this.swigCPtr, this);
    }

    public long getDwAddOption() {
        return internalGroupExtJNI.GroupDetailInfo_dwAddOption_get(this.swigCPtr, this);
    }

    public long getDwAppid() {
        return internalGroupExtJNI.GroupDetailInfo_dwAppid_get(this.swigCPtr, this);
    }

    public long getDwCreateTime() {
        return internalGroupExtJNI.GroupDetailInfo_dwCreateTime_get(this.swigCPtr, this);
    }

    public long getDwInfoSeq() {
        return internalGroupExtJNI.GroupDetailInfo_dwInfoSeq_get(this.swigCPtr, this);
    }

    public long getDwLastInfoTime() {
        return internalGroupExtJNI.GroupDetailInfo_dwLastInfoTime_get(this.swigCPtr, this);
    }

    public long getDwLastMsgTime() {
        return internalGroupExtJNI.GroupDetailInfo_dwLastMsgTime_get(this.swigCPtr, this);
    }

    public long getDwMaxMemberNum() {
        return internalGroupExtJNI.GroupDetailInfo_dwMaxMemberNum_get(this.swigCPtr, this);
    }

    public long getDwMemberNum() {
        return internalGroupExtJNI.GroupDetailInfo_dwMemberNum_get(this.swigCPtr, this);
    }

    public long getDwNextMsgSeq() {
        return internalGroupExtJNI.GroupDetailInfo_dwNextMsgSeq_get(this.swigCPtr, this);
    }

    public long getDwOnlineMemberNum() {
        return internalGroupExtJNI.GroupDetailInfo_dwOnlineMemberNum_get(this.swigCPtr, this);
    }

    public CommStatus getESearchable() {
        return CommStatus.swigToEnum(internalGroupExtJNI.GroupDetailInfo_eSearchable_get(this.swigCPtr, this));
    }

    public CommStatus getEVisible() {
        return CommStatus.swigToEnum(internalGroupExtJNI.GroupDetailInfo_eVisible_get(this.swigCPtr, this));
    }

    public Msg getLastMsg() {
        long GroupDetailInfo_lastMsg_get = internalGroupExtJNI.GroupDetailInfo_lastMsg_get(this.swigCPtr, this);
        if (GroupDetailInfo_lastMsg_get == 0) {
            return null;
        }
        return new Msg(GroupDetailInfo_lastMsg_get, false);
    }

    public String getSFaceUrl() {
        return internalGroupExtJNI.GroupDetailInfo_sFaceUrl_get(this.swigCPtr, this);
    }

    public String getSGroupId() {
        return internalGroupExtJNI.GroupDetailInfo_sGroupId_get(this.swigCPtr, this);
    }

    public byte[] getSGroupName() {
        return internalGroupExtJNI.GroupDetailInfo_sGroupName_get(this.swigCPtr, this);
    }

    public String getSGroupType() {
        return internalGroupExtJNI.GroupDetailInfo_sGroupType_get(this.swigCPtr, this);
    }

    public byte[] getSIntroduction() {
        return internalGroupExtJNI.GroupDetailInfo_sIntroduction_get(this.swigCPtr, this);
    }

    public byte[] getSNotification() {
        return internalGroupExtJNI.GroupDetailInfo_sNotification_get(this.swigCPtr, this);
    }

    public String getSOwner() {
        return internalGroupExtJNI.GroupDetailInfo_sOwner_get(this.swigCPtr, this);
    }

    public void setBAllShutup(boolean z) {
        internalGroupExtJNI.GroupDetailInfo_bAllShutup_set(this.swigCPtr, this, z);
    }

    public void setCustom_info(BytesMap bytesMap) {
        internalGroupExtJNI.GroupDetailInfo_custom_info_set(this.swigCPtr, this, BytesMap.getCPtr(bytesMap), bytesMap);
    }

    public void setDdwOwnerTinyId(long j) {
        internalGroupExtJNI.GroupDetailInfo_ddwOwnerTinyId_set(this.swigCPtr, this, j);
    }

    public void setDwAddOption(long j) {
        internalGroupExtJNI.GroupDetailInfo_dwAddOption_set(this.swigCPtr, this, j);
    }

    public void setDwAppid(long j) {
        internalGroupExtJNI.GroupDetailInfo_dwAppid_set(this.swigCPtr, this, j);
    }

    public void setDwCreateTime(long j) {
        internalGroupExtJNI.GroupDetailInfo_dwCreateTime_set(this.swigCPtr, this, j);
    }

    public void setDwInfoSeq(long j) {
        internalGroupExtJNI.GroupDetailInfo_dwInfoSeq_set(this.swigCPtr, this, j);
    }

    public void setDwLastInfoTime(long j) {
        internalGroupExtJNI.GroupDetailInfo_dwLastInfoTime_set(this.swigCPtr, this, j);
    }

    public void setDwLastMsgTime(long j) {
        internalGroupExtJNI.GroupDetailInfo_dwLastMsgTime_set(this.swigCPtr, this, j);
    }

    public void setDwMaxMemberNum(long j) {
        internalGroupExtJNI.GroupDetailInfo_dwMaxMemberNum_set(this.swigCPtr, this, j);
    }

    public void setDwMemberNum(long j) {
        internalGroupExtJNI.GroupDetailInfo_dwMemberNum_set(this.swigCPtr, this, j);
    }

    public void setDwNextMsgSeq(long j) {
        internalGroupExtJNI.GroupDetailInfo_dwNextMsgSeq_set(this.swigCPtr, this, j);
    }

    public void setDwOnlineMemberNum(long j) {
        internalGroupExtJNI.GroupDetailInfo_dwOnlineMemberNum_set(this.swigCPtr, this, j);
    }

    public void setESearchable(CommStatus commStatus) {
        internalGroupExtJNI.GroupDetailInfo_eSearchable_set(this.swigCPtr, this, commStatus.swigValue());
    }

    public void setEVisible(CommStatus commStatus) {
        internalGroupExtJNI.GroupDetailInfo_eVisible_set(this.swigCPtr, this, commStatus.swigValue());
    }

    public void setLastMsg(Msg msg) {
        internalGroupExtJNI.GroupDetailInfo_lastMsg_set(this.swigCPtr, this, Msg.getCPtr(msg), msg);
    }

    public void setSFaceUrl(String str) {
        internalGroupExtJNI.GroupDetailInfo_sFaceUrl_set(this.swigCPtr, this, str);
    }

    public void setSGroupId(String str) {
        internalGroupExtJNI.GroupDetailInfo_sGroupId_set(this.swigCPtr, this, str);
    }

    public void setSGroupName(byte[] bArr) {
        internalGroupExtJNI.GroupDetailInfo_sGroupName_set(this.swigCPtr, this, bArr);
    }

    public void setSGroupType(String str) {
        internalGroupExtJNI.GroupDetailInfo_sGroupType_set(this.swigCPtr, this, str);
    }

    public void setSIntroduction(byte[] bArr) {
        internalGroupExtJNI.GroupDetailInfo_sIntroduction_set(this.swigCPtr, this, bArr);
    }

    public void setSNotification(byte[] bArr) {
        internalGroupExtJNI.GroupDetailInfo_sNotification_set(this.swigCPtr, this, bArr);
    }

    public void setSOwner(String str) {
        internalGroupExtJNI.GroupDetailInfo_sOwner_set(this.swigCPtr, this, str);
    }
}
