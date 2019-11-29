package com.tencent.imcore;

public class GroupBaseInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GroupBaseInfo() {
        this(internalGroupExtJNI.new_GroupBaseInfo(), true);
    }

    protected GroupBaseInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GroupBaseInfo groupBaseInfo) {
        if (groupBaseInfo == null) {
            return 0;
        }
        return groupBaseInfo.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_GroupBaseInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public boolean getBAllShutup() {
        return internalGroupExtJNI.GroupBaseInfo_bAllShutup_get(this.swigCPtr, this);
    }

    public long getDwInfoSeq() {
        return internalGroupExtJNI.GroupBaseInfo_dwInfoSeq_get(this.swigCPtr, this);
    }

    public long getDwMsgFalg() {
        return internalGroupExtJNI.GroupBaseInfo_dwMsgFalg_get(this.swigCPtr, this);
    }

    public long getDwMsgSeq() {
        return internalGroupExtJNI.GroupBaseInfo_dwMsgSeq_get(this.swigCPtr, this);
    }

    public long getDwReadSeq() {
        return internalGroupExtJNI.GroupBaseInfo_dwReadSeq_get(this.swigCPtr, this);
    }

    public byte[] getSFaceUrl() {
        return internalGroupExtJNI.GroupBaseInfo_sFaceUrl_get(this.swigCPtr, this);
    }

    public String getSGroupId() {
        return internalGroupExtJNI.GroupBaseInfo_sGroupId_get(this.swigCPtr, this);
    }

    public byte[] getSGroupName() {
        return internalGroupExtJNI.GroupBaseInfo_sGroupName_get(this.swigCPtr, this);
    }

    public String getSGroupType() {
        return internalGroupExtJNI.GroupBaseInfo_sGroupType_get(this.swigCPtr, this);
    }

    public GroupSelfInfo getStSelfInfo() {
        long GroupBaseInfo_stSelfInfo_get = internalGroupExtJNI.GroupBaseInfo_stSelfInfo_get(this.swigCPtr, this);
        if (GroupBaseInfo_stSelfInfo_get == 0) {
            return null;
        }
        return new GroupSelfInfo(GroupBaseInfo_stSelfInfo_get, false);
    }

    public void setBAllShutup(boolean z) {
        internalGroupExtJNI.GroupBaseInfo_bAllShutup_set(this.swigCPtr, this, z);
    }

    public void setDwInfoSeq(long j) {
        internalGroupExtJNI.GroupBaseInfo_dwInfoSeq_set(this.swigCPtr, this, j);
    }

    public void setDwMsgFalg(long j) {
        internalGroupExtJNI.GroupBaseInfo_dwMsgFalg_set(this.swigCPtr, this, j);
    }

    public void setDwMsgSeq(long j) {
        internalGroupExtJNI.GroupBaseInfo_dwMsgSeq_set(this.swigCPtr, this, j);
    }

    public void setDwReadSeq(long j) {
        internalGroupExtJNI.GroupBaseInfo_dwReadSeq_set(this.swigCPtr, this, j);
    }

    public void setSFaceUrl(byte[] bArr) {
        internalGroupExtJNI.GroupBaseInfo_sFaceUrl_set(this.swigCPtr, this, bArr);
    }

    public void setSGroupId(String str) {
        internalGroupExtJNI.GroupBaseInfo_sGroupId_set(this.swigCPtr, this, str);
    }

    public void setSGroupName(byte[] bArr) {
        internalGroupExtJNI.GroupBaseInfo_sGroupName_set(this.swigCPtr, this, bArr);
    }

    public void setSGroupType(String str) {
        internalGroupExtJNI.GroupBaseInfo_sGroupType_set(this.swigCPtr, this, str);
    }

    public void setStSelfInfo(GroupSelfInfo groupSelfInfo) {
        internalGroupExtJNI.GroupBaseInfo_stSelfInfo_set(this.swigCPtr, this, GroupSelfInfo.getCPtr(groupSelfInfo), groupSelfInfo);
    }
}
