package com.tencent.imcore;

public class CreateGroupParams {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public CreateGroupParams() {
        this(internalJNI.new_CreateGroupParams(), true);
    }

    protected CreateGroupParams(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(CreateGroupParams createGroupParams) {
        if (createGroupParams == null) {
            return 0;
        }
        return createGroupParams.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_CreateGroupParams(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public long getAdd_option() {
        return internalJNI.CreateGroupParams_add_option_get(this.swigCPtr, this);
    }

    public BytesMap getCustom_info() {
        long CreateGroupParams_custom_info_get = internalJNI.CreateGroupParams_custom_info_get(this.swigCPtr, this);
        if (CreateGroupParams_custom_info_get == 0) {
            return null;
        }
        return new BytesMap(CreateGroupParams_custom_info_get, false);
    }

    public String getFace_url() {
        return internalJNI.CreateGroupParams_face_url_get(this.swigCPtr, this);
    }

    public byte[] getGroup_id() {
        return internalJNI.CreateGroupParams_group_id_get(this.swigCPtr, this);
    }

    public GroupTipsMemberInfoVec getGroup_members() {
        long CreateGroupParams_group_members_get = internalJNI.CreateGroupParams_group_members_get(this.swigCPtr, this);
        if (CreateGroupParams_group_members_get == 0) {
            return null;
        }
        return new GroupTipsMemberInfoVec(CreateGroupParams_group_members_get, false);
    }

    public byte[] getGroup_name() {
        return internalJNI.CreateGroupParams_group_name_get(this.swigCPtr, this);
    }

    public String getGroup_type() {
        return internalJNI.CreateGroupParams_group_type_get(this.swigCPtr, this);
    }

    public byte[] getIntroduction() {
        return internalJNI.CreateGroupParams_introduction_get(this.swigCPtr, this);
    }

    public long getMax_member_num() {
        return internalJNI.CreateGroupParams_max_member_num_get(this.swigCPtr, this);
    }

    public byte[] getNotification() {
        return internalJNI.CreateGroupParams_notification_get(this.swigCPtr, this);
    }

    public long getOwner_tiny_id() {
        return internalJNI.CreateGroupParams_owner_tiny_id_get(this.swigCPtr, this);
    }

    public boolean getSet_add_option() {
        return internalJNI.CreateGroupParams_set_add_option_get(this.swigCPtr, this);
    }

    public void setAdd_option(long j) {
        internalJNI.CreateGroupParams_add_option_set(this.swigCPtr, this, j);
    }

    public void setCustom_info(BytesMap bytesMap) {
        internalJNI.CreateGroupParams_custom_info_set(this.swigCPtr, this, BytesMap.getCPtr(bytesMap), bytesMap);
    }

    public void setFace_url(String str) {
        internalJNI.CreateGroupParams_face_url_set(this.swigCPtr, this, str);
    }

    public void setGroup_id(byte[] bArr) {
        internalJNI.CreateGroupParams_group_id_set(this.swigCPtr, this, bArr);
    }

    public void setGroup_members(GroupTipsMemberInfoVec groupTipsMemberInfoVec) {
        internalJNI.CreateGroupParams_group_members_set(this.swigCPtr, this, GroupTipsMemberInfoVec.getCPtr(groupTipsMemberInfoVec), groupTipsMemberInfoVec);
    }

    public void setGroup_name(byte[] bArr) {
        internalJNI.CreateGroupParams_group_name_set(this.swigCPtr, this, bArr);
    }

    public void setGroup_type(String str) {
        internalJNI.CreateGroupParams_group_type_set(this.swigCPtr, this, str);
    }

    public void setIntroduction(byte[] bArr) {
        internalJNI.CreateGroupParams_introduction_set(this.swigCPtr, this, bArr);
    }

    public void setMax_member_num(long j) {
        internalJNI.CreateGroupParams_max_member_num_set(this.swigCPtr, this, j);
    }

    public void setNotification(byte[] bArr) {
        internalJNI.CreateGroupParams_notification_set(this.swigCPtr, this, bArr);
    }

    public void setOwner_tiny_id(long j) {
        internalJNI.CreateGroupParams_owner_tiny_id_set(this.swigCPtr, this, j);
    }

    public void setSet_add_option(boolean z) {
        internalJNI.CreateGroupParams_set_add_option_set(this.swigCPtr, this, z);
    }
}
