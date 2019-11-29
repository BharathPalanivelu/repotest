package com.tencent.imcore;

public class MemberInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public MemberInfo() {
        this(internalGroupExtJNI.new_MemberInfo(), true);
    }

    protected MemberInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MemberInfo memberInfo) {
        if (memberInfo == null) {
            return 0;
        }
        return memberInfo.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_MemberInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public BytesMap getCustom_info() {
        long MemberInfo_custom_info_get = internalGroupExtJNI.MemberInfo_custom_info_get(this.swigCPtr, this);
        if (MemberInfo_custom_info_get == 0) {
            return null;
        }
        return new BytesMap(MemberInfo_custom_info_get, false);
    }

    public long getJoin_time() {
        return internalGroupExtJNI.MemberInfo_join_time_get(this.swigCPtr, this);
    }

    public String getMember() {
        return internalGroupExtJNI.MemberInfo_member_get(this.swigCPtr, this);
    }

    public long getMsg_flag() {
        return internalGroupExtJNI.MemberInfo_msg_flag_get(this.swigCPtr, this);
    }

    public long getMsg_seq() {
        return internalGroupExtJNI.MemberInfo_msg_seq_get(this.swigCPtr, this);
    }

    public byte[] getName_card() {
        return internalGroupExtJNI.MemberInfo_name_card_get(this.swigCPtr, this);
    }

    public long getRole() {
        return internalGroupExtJNI.MemberInfo_role_get(this.swigCPtr, this);
    }

    public long getShutup_time() {
        return internalGroupExtJNI.MemberInfo_shutup_time_get(this.swigCPtr, this);
    }

    public void setCustom_info(BytesMap bytesMap) {
        internalGroupExtJNI.MemberInfo_custom_info_set(this.swigCPtr, this, BytesMap.getCPtr(bytesMap), bytesMap);
    }

    public void setJoin_time(long j) {
        internalGroupExtJNI.MemberInfo_join_time_set(this.swigCPtr, this, j);
    }

    public void setMember(String str) {
        internalGroupExtJNI.MemberInfo_member_set(this.swigCPtr, this, str);
    }

    public void setMsg_flag(long j) {
        internalGroupExtJNI.MemberInfo_msg_flag_set(this.swigCPtr, this, j);
    }

    public void setMsg_seq(long j) {
        internalGroupExtJNI.MemberInfo_msg_seq_set(this.swigCPtr, this, j);
    }

    public void setName_card(byte[] bArr) {
        internalGroupExtJNI.MemberInfo_name_card_set(this.swigCPtr, this, bArr);
    }

    public void setRole(long j) {
        internalGroupExtJNI.MemberInfo_role_set(this.swigCPtr, this, j);
    }

    public void setShutup_time(long j) {
        internalGroupExtJNI.MemberInfo_shutup_time_set(this.swigCPtr, this, j);
    }
}
