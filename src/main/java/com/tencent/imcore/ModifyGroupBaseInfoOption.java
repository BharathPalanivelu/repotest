package com.tencent.imcore;

public class ModifyGroupBaseInfoOption {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ModifyGroupBaseInfoOption() {
        this(internalGroupExtJNI.new_ModifyGroupBaseInfoOption(), true);
    }

    protected ModifyGroupBaseInfoOption(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ModifyGroupBaseInfoOption modifyGroupBaseInfoOption) {
        if (modifyGroupBaseInfoOption == null) {
            return 0;
        }
        return modifyGroupBaseInfoOption.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_ModifyGroupBaseInfoOption(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public long getAdd_option() {
        return internalGroupExtJNI.ModifyGroupBaseInfoOption_add_option_get(this.swigCPtr, this);
    }

    public boolean getAll_shutup() {
        return internalGroupExtJNI.ModifyGroupBaseInfoOption_all_shutup_get(this.swigCPtr, this);
    }

    public BytesMap getCustom_info() {
        long ModifyGroupBaseInfoOption_custom_info_get = internalGroupExtJNI.ModifyGroupBaseInfoOption_custom_info_get(this.swigCPtr, this);
        if (ModifyGroupBaseInfoOption_custom_info_get == 0) {
            return null;
        }
        return new BytesMap(ModifyGroupBaseInfoOption_custom_info_get, false);
    }

    public byte[] getFace_url() {
        return internalGroupExtJNI.ModifyGroupBaseInfoOption_face_url_get(this.swigCPtr, this);
    }

    public long getFlag() {
        return internalGroupExtJNI.ModifyGroupBaseInfoOption_flag_get(this.swigCPtr, this);
    }

    public String getGroup_id() {
        return internalGroupExtJNI.ModifyGroupBaseInfoOption_group_id_get(this.swigCPtr, this);
    }

    public byte[] getGroup_name() {
        return internalGroupExtJNI.ModifyGroupBaseInfoOption_group_name_get(this.swigCPtr, this);
    }

    public byte[] getIntroduction() {
        return internalGroupExtJNI.ModifyGroupBaseInfoOption_introduction_get(this.swigCPtr, this);
    }

    public long getMax_member_num() {
        return internalGroupExtJNI.ModifyGroupBaseInfoOption_max_member_num_get(this.swigCPtr, this);
    }

    public byte[] getNotification() {
        return internalGroupExtJNI.ModifyGroupBaseInfoOption_notification_get(this.swigCPtr, this);
    }

    public CommStatus getSearchable() {
        return CommStatus.swigToEnum(internalGroupExtJNI.ModifyGroupBaseInfoOption_searchable_get(this.swigCPtr, this));
    }

    public CommStatus getVisible() {
        return CommStatus.swigToEnum(internalGroupExtJNI.ModifyGroupBaseInfoOption_visible_get(this.swigCPtr, this));
    }

    public void setAdd_option(long j) {
        internalGroupExtJNI.ModifyGroupBaseInfoOption_add_option_set(this.swigCPtr, this, j);
    }

    public void setAll_shutup(boolean z) {
        internalGroupExtJNI.ModifyGroupBaseInfoOption_all_shutup_set(this.swigCPtr, this, z);
    }

    public void setCustom_info(BytesMap bytesMap) {
        internalGroupExtJNI.ModifyGroupBaseInfoOption_custom_info_set(this.swigCPtr, this, BytesMap.getCPtr(bytesMap), bytesMap);
    }

    public void setFace_url(byte[] bArr) {
        internalGroupExtJNI.ModifyGroupBaseInfoOption_face_url_set(this.swigCPtr, this, bArr);
    }

    public void setFlag(long j) {
        internalGroupExtJNI.ModifyGroupBaseInfoOption_flag_set(this.swigCPtr, this, j);
    }

    public void setGroup_id(String str) {
        internalGroupExtJNI.ModifyGroupBaseInfoOption_group_id_set(this.swigCPtr, this, str);
    }

    public void setGroup_name(byte[] bArr) {
        internalGroupExtJNI.ModifyGroupBaseInfoOption_group_name_set(this.swigCPtr, this, bArr);
    }

    public void setIntroduction(byte[] bArr) {
        internalGroupExtJNI.ModifyGroupBaseInfoOption_introduction_set(this.swigCPtr, this, bArr);
    }

    public void setMax_member_num(long j) {
        internalGroupExtJNI.ModifyGroupBaseInfoOption_max_member_num_set(this.swigCPtr, this, j);
    }

    public void setNotification(byte[] bArr) {
        internalGroupExtJNI.ModifyGroupBaseInfoOption_notification_set(this.swigCPtr, this, bArr);
    }

    public void setSearchable(CommStatus commStatus) {
        internalGroupExtJNI.ModifyGroupBaseInfoOption_searchable_set(this.swigCPtr, this, commStatus.swigValue());
    }

    public void setVisible(CommStatus commStatus) {
        internalGroupExtJNI.ModifyGroupBaseInfoOption_visible_set(this.swigCPtr, this, commStatus.swigValue());
    }
}
