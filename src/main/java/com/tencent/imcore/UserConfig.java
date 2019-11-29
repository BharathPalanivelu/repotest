package com.tencent.imcore;

public class UserConfig {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public UserConfig() {
        this(internalJNI.new_UserConfig(), true);
    }

    protected UserConfig(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(UserConfig userConfig) {
        if (userConfig == null) {
            return 0;
        }
        return userConfig.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_UserConfig(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public String getAccount_type() {
        return internalJNI.UserConfig_account_type_get(this.swigCPtr, this);
    }

    public String getAppid3rd() {
        return internalJNI.UserConfig_appid3rd_get(this.swigCPtr, this);
    }

    public boolean getAuto_report() {
        return internalJNI.UserConfig_auto_report_get(this.swigCPtr, this);
    }

    public SWIGTYPE_p_void getFm_ext() {
        long UserConfig_fm_ext_get = internalJNI.UserConfig_fm_ext_get(this.swigCPtr, this);
        if (UserConfig_fm_ext_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(UserConfig_fm_ext_get, false);
    }

    public FriendProfileInfoOpt getFriend_profile_opt() {
        long UserConfig_friend_profile_opt_get = internalJNI.UserConfig_friend_profile_opt_get(this.swigCPtr, this);
        if (UserConfig_friend_profile_opt_get == 0) {
            return null;
        }
        return new FriendProfileInfoOpt(UserConfig_friend_profile_opt_get, false);
    }

    public boolean getFriendship_proxy() {
        return internalJNI.UserConfig_friendship_proxy_get(this.swigCPtr, this);
    }

    public boolean getGroup_assistant() {
        return internalJNI.UserConfig_group_assistant_get(this.swigCPtr, this);
    }

    public GroupInfoOpt getGroup_info_opt() {
        long UserConfig_group_info_opt_get = internalJNI.UserConfig_group_info_opt_get(this.swigCPtr, this);
        if (UserConfig_group_info_opt_get == 0) {
            return null;
        }
        return new GroupInfoOpt(UserConfig_group_info_opt_get, false);
    }

    public GroupMemberInfoOpt getGroup_member_info_opt() {
        long UserConfig_group_member_info_opt_get = internalJNI.UserConfig_group_member_info_opt_get(this.swigCPtr, this);
        if (UserConfig_group_member_info_opt_get == 0) {
            return null;
        }
        return new GroupMemberInfoOpt(UserConfig_group_member_info_opt_get, false);
    }

    public SWIGTYPE_p_void getGrp_ext() {
        long UserConfig_grp_ext_get = internalJNI.UserConfig_grp_ext_get(this.swigCPtr, this);
        if (UserConfig_grp_ext_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(UserConfig_grp_ext_get, false);
    }

    public String getIdentifier() {
        return internalJNI.UserConfig_identifier_get(this.swigCPtr, this);
    }

    public SWIGTYPE_p_void getMm_ext() {
        long UserConfig_mm_ext_get = internalJNI.UserConfig_mm_ext_get(this.swigCPtr, this);
        if (UserConfig_mm_ext_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(UserConfig_mm_ext_get, false);
    }

    public INotify getNotify() {
        long UserConfig_notify_get = internalJNI.UserConfig_notify_get(this.swigCPtr, this);
        if (UserConfig_notify_get == 0) {
            return null;
        }
        return new INotify(UserConfig_notify_get, false);
    }

    public boolean getRead_receipt() {
        return internalJNI.UserConfig_read_receipt_get(this.swigCPtr, this);
    }

    public boolean getRecent_contact() {
        return internalJNI.UserConfig_recent_contact_get(this.swigCPtr, this);
    }

    public boolean getRecent_contact_notify() {
        return internalJNI.UserConfig_recent_contact_notify_get(this.swigCPtr, this);
    }

    public long getSdk_appid() {
        return internalJNI.UserConfig_sdk_appid_get(this.swigCPtr, this);
    }

    public boolean getStorage() {
        return internalJNI.UserConfig_storage_get(this.swigCPtr, this);
    }

    public String getTinyid() {
        return internalJNI.UserConfig_tinyid_get(this.swigCPtr, this);
    }

    public IUGCUploader getUgc_uploader() {
        long UserConfig_ugc_uploader_get = internalJNI.UserConfig_ugc_uploader_get(this.swigCPtr, this);
        if (UserConfig_ugc_uploader_get == 0) {
            return null;
        }
        return new IUGCUploader(UserConfig_ugc_uploader_get, false);
    }

    public long getUtinyid() {
        return internalJNI.UserConfig_utinyid_get(this.swigCPtr, this);
    }

    public void setAccount_type(String str) {
        internalJNI.UserConfig_account_type_set(this.swigCPtr, this, str);
    }

    public void setAppid3rd(String str) {
        internalJNI.UserConfig_appid3rd_set(this.swigCPtr, this, str);
    }

    public void setAuto_report(boolean z) {
        internalJNI.UserConfig_auto_report_set(this.swigCPtr, this, z);
    }

    public void setFm_ext(SWIGTYPE_p_void sWIGTYPE_p_void) {
        internalJNI.UserConfig_fm_ext_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public void setFriend_profile_opt(FriendProfileInfoOpt friendProfileInfoOpt) {
        internalJNI.UserConfig_friend_profile_opt_set(this.swigCPtr, this, FriendProfileInfoOpt.getCPtr(friendProfileInfoOpt), friendProfileInfoOpt);
    }

    public void setFriendship_proxy(boolean z) {
        internalJNI.UserConfig_friendship_proxy_set(this.swigCPtr, this, z);
    }

    public void setGroup_assistant(boolean z) {
        internalJNI.UserConfig_group_assistant_set(this.swigCPtr, this, z);
    }

    public void setGroup_info_opt(GroupInfoOpt groupInfoOpt) {
        internalJNI.UserConfig_group_info_opt_set(this.swigCPtr, this, GroupInfoOpt.getCPtr(groupInfoOpt), groupInfoOpt);
    }

    public void setGroup_member_info_opt(GroupMemberInfoOpt groupMemberInfoOpt) {
        internalJNI.UserConfig_group_member_info_opt_set(this.swigCPtr, this, GroupMemberInfoOpt.getCPtr(groupMemberInfoOpt), groupMemberInfoOpt);
    }

    public void setGrp_ext(SWIGTYPE_p_void sWIGTYPE_p_void) {
        internalJNI.UserConfig_grp_ext_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public void setIdentifier(String str) {
        internalJNI.UserConfig_identifier_set(this.swigCPtr, this, str);
    }

    public void setMm_ext(SWIGTYPE_p_void sWIGTYPE_p_void) {
        internalJNI.UserConfig_mm_ext_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public void setNotify(INotify iNotify) {
        internalJNI.UserConfig_notify_set(this.swigCPtr, this, INotify.getCPtr(iNotify), iNotify);
    }

    public void setRead_receipt(boolean z) {
        internalJNI.UserConfig_read_receipt_set(this.swigCPtr, this, z);
    }

    public void setRecent_contact(boolean z) {
        internalJNI.UserConfig_recent_contact_set(this.swigCPtr, this, z);
    }

    public void setRecent_contact_notify(boolean z) {
        internalJNI.UserConfig_recent_contact_notify_set(this.swigCPtr, this, z);
    }

    public void setSdk_appid(long j) {
        internalJNI.UserConfig_sdk_appid_set(this.swigCPtr, this, j);
    }

    public void setStorage(boolean z) {
        internalJNI.UserConfig_storage_set(this.swigCPtr, this, z);
    }

    public void setTinyid(String str) {
        internalJNI.UserConfig_tinyid_set(this.swigCPtr, this, str);
    }

    public void setUgc_uploader(IUGCUploader iUGCUploader) {
        internalJNI.UserConfig_ugc_uploader_set(this.swigCPtr, this, IUGCUploader.getCPtr(iUGCUploader), iUGCUploader);
    }

    public void setUtinyid(long j) {
        internalJNI.UserConfig_utinyid_set(this.swigCPtr, this, j);
    }
}
