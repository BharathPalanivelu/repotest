package com.tencent.imcore;

public class ModifyGroupMemberInfoOption {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ModifyGroupMemberInfoOption() {
        this(internalGroupExtJNI.new_ModifyGroupMemberInfoOption(), true);
    }

    protected ModifyGroupMemberInfoOption(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ModifyGroupMemberInfoOption modifyGroupMemberInfoOption) {
        if (modifyGroupMemberInfoOption == null) {
            return 0;
        }
        return modifyGroupMemberInfoOption.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_ModifyGroupMemberInfoOption(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public BytesMap getCustom_info() {
        long ModifyGroupMemberInfoOption_custom_info_get = internalGroupExtJNI.ModifyGroupMemberInfoOption_custom_info_get(this.swigCPtr, this);
        if (ModifyGroupMemberInfoOption_custom_info_get == 0) {
            return null;
        }
        return new BytesMap(ModifyGroupMemberInfoOption_custom_info_get, false);
    }

    public long getFlag() {
        return internalGroupExtJNI.ModifyGroupMemberInfoOption_flag_get(this.swigCPtr, this);
    }

    public String getGroup_id() {
        return internalGroupExtJNI.ModifyGroupMemberInfoOption_group_id_get(this.swigCPtr, this);
    }

    public String getMember() {
        return internalGroupExtJNI.ModifyGroupMemberInfoOption_member_get(this.swigCPtr, this);
    }

    public long getMsg_flag() {
        return internalGroupExtJNI.ModifyGroupMemberInfoOption_msg_flag_get(this.swigCPtr, this);
    }

    public byte[] getName_card() {
        return internalGroupExtJNI.ModifyGroupMemberInfoOption_name_card_get(this.swigCPtr, this);
    }

    public long getRole() {
        return internalGroupExtJNI.ModifyGroupMemberInfoOption_role_get(this.swigCPtr, this);
    }

    public long getShutup_time() {
        return internalGroupExtJNI.ModifyGroupMemberInfoOption_shutup_time_get(this.swigCPtr, this);
    }

    public void setCustom_info(BytesMap bytesMap) {
        internalGroupExtJNI.ModifyGroupMemberInfoOption_custom_info_set(this.swigCPtr, this, BytesMap.getCPtr(bytesMap), bytesMap);
    }

    public void setFlag(long j) {
        internalGroupExtJNI.ModifyGroupMemberInfoOption_flag_set(this.swigCPtr, this, j);
    }

    public void setGroup_id(String str) {
        internalGroupExtJNI.ModifyGroupMemberInfoOption_group_id_set(this.swigCPtr, this, str);
    }

    public void setMember(String str) {
        internalGroupExtJNI.ModifyGroupMemberInfoOption_member_set(this.swigCPtr, this, str);
    }

    public void setMsg_flag(long j) {
        internalGroupExtJNI.ModifyGroupMemberInfoOption_msg_flag_set(this.swigCPtr, this, j);
    }

    public void setName_card(byte[] bArr) {
        internalGroupExtJNI.ModifyGroupMemberInfoOption_name_card_set(this.swigCPtr, this, bArr);
    }

    public void setRole(long j) {
        internalGroupExtJNI.ModifyGroupMemberInfoOption_role_set(this.swigCPtr, this, j);
    }

    public void setShutup_time(long j) {
        internalGroupExtJNI.ModifyGroupMemberInfoOption_shutup_time_set(this.swigCPtr, this, j);
    }
}
