package com.tencent.imcore;

public class GroupTipsMemberInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GroupTipsMemberInfo() {
        this(internalJNI.new_GroupTipsMemberInfo(), true);
    }

    protected GroupTipsMemberInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GroupTipsMemberInfo groupTipsMemberInfo) {
        if (groupTipsMemberInfo == null) {
            return 0;
        }
        return groupTipsMemberInfo.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_GroupTipsMemberInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public BytesMap getCustom_info() {
        long GroupTipsMemberInfo_custom_info_get = internalJNI.GroupTipsMemberInfo_custom_info_get(this.swigCPtr, this);
        if (GroupTipsMemberInfo_custom_info_get == 0) {
            return null;
        }
        return new BytesMap(GroupTipsMemberInfo_custom_info_get, false);
    }

    public String getIdentifier() {
        return internalJNI.GroupTipsMemberInfo_identifier_get(this.swigCPtr, this);
    }

    public int getMember_role() {
        return internalJNI.GroupTipsMemberInfo_member_role_get(this.swigCPtr, this);
    }

    public int getMsg_flag() {
        return internalJNI.GroupTipsMemberInfo_msg_flag_get(this.swigCPtr, this);
    }

    public byte[] getName_card() {
        return internalJNI.GroupTipsMemberInfo_name_card_get(this.swigCPtr, this);
    }

    public void setCustom_info(BytesMap bytesMap) {
        internalJNI.GroupTipsMemberInfo_custom_info_set(this.swigCPtr, this, BytesMap.getCPtr(bytesMap), bytesMap);
    }

    public void setIdentifier(String str) {
        internalJNI.GroupTipsMemberInfo_identifier_set(this.swigCPtr, this, str);
    }

    public void setMember_role(int i) {
        internalJNI.GroupTipsMemberInfo_member_role_set(this.swigCPtr, this, i);
    }

    public void setMsg_flag(int i) {
        internalJNI.GroupTipsMemberInfo_msg_flag_set(this.swigCPtr, this, i);
    }

    public void setName_card(byte[] bArr) {
        internalJNI.GroupTipsMemberInfo_name_card_set(this.swigCPtr, this, bArr);
    }
}
