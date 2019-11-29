package com.tencent.imsdk;

import com.tencent.imcore.FriendProfileInfoOpt;
import com.tencent.imcore.GroupInfoOpt;
import com.tencent.imcore.GroupMemberInfoOpt;
import com.tencent.imcore.IUGCUploader;
import com.tencent.imcore.UserConfig;
import com.tencent.imsdk.log.QLog;

public class TIMUserConfig {
    private static final String TAG = "TIMUserConfig";
    private TIMConnListener connListener;
    protected IMBaseListener friendshipProxyListener;
    private TIMFriendshipSettings friendshipSettings = new TIMFriendshipSettings();
    protected IMBaseListener groupAssistantListener;
    private TIMGroupEventListener groupEventListener;
    private TIMGroupSettings groupSettings = new TIMGroupSettings();
    protected boolean isAutoReportEnabled = true;
    protected boolean isFriendshipStorageEnabled = false;
    protected boolean isGroupStorageEnabled = false;
    protected boolean isReadReceiptEnabled = false;
    protected boolean isRecentContactEnabled = true;
    protected boolean isRecentContactNotifyEnabled = true;
    protected boolean isStorageEnabled = true;
    protected IMBaseListener msgRevokedListener;
    protected IMBaseListener receiptListener;
    private TIMRefreshListener refreshListener;
    private TIMUploadProgressListener uploadProgressListener;
    private TIMUser user = new TIMUser();
    private TIMUserStatusListener userStatusListener;

    public TIMUserConfig() {
    }

    public TIMUserConfig(TIMUserConfig tIMUserConfig) {
        if (tIMUserConfig != null) {
            this.groupSettings = tIMUserConfig.getGroupSettings();
            this.friendshipSettings = tIMUserConfig.getFriendshipSettings();
            this.connListener = tIMUserConfig.getConnectionListener();
            this.refreshListener = tIMUserConfig.getRefreshListener();
            this.groupEventListener = tIMUserConfig.getGroupEventListener();
            this.userStatusListener = tIMUserConfig.getUserStatusListener();
            this.uploadProgressListener = tIMUserConfig.getUploadProgressListener();
            this.isStorageEnabled = tIMUserConfig.isStorageEnabled;
            this.isAutoReportEnabled = tIMUserConfig.isAutoReportEnabled;
            this.isReadReceiptEnabled = tIMUserConfig.isReadReceiptEnabled;
            this.isRecentContactEnabled = tIMUserConfig.isRecentContactEnabled;
            this.isRecentContactNotifyEnabled = tIMUserConfig.isRecentContactNotifyEnabled;
            this.receiptListener = tIMUserConfig.receiptListener;
            this.msgRevokedListener = tIMUserConfig.msgRevokedListener;
            this.friendshipProxyListener = tIMUserConfig.friendshipProxyListener;
            this.isFriendshipStorageEnabled = tIMUserConfig.isFriendshipStorageEnabled;
            this.groupAssistantListener = tIMUserConfig.groupAssistantListener;
            this.isGroupStorageEnabled = tIMUserConfig.isGroupStorageEnabled;
            this.user = tIMUserConfig.getUser();
        }
    }

    /* access modifiers changed from: protected */
    public UserConfig convertTo() {
        UserConfig userConfig = new UserConfig();
        userConfig.setSdk_appid(this.user.getSdkAppid());
        userConfig.setAppid3rd(this.user.getAppIdAt3rd());
        userConfig.setAccount_type(this.user.getAccountType());
        userConfig.setIdentifier(this.user.getIdentifier());
        userConfig.setUtinyid(this.user.getTinyId());
        userConfig.setTinyid(String.valueOf(this.user.getTinyId()));
        GroupInfoOpt groupInfoOpt = new GroupInfoOpt();
        this.groupSettings.groupInfoOptions.convertTo(groupInfoOpt);
        userConfig.setGroup_info_opt(groupInfoOpt);
        GroupMemberInfoOpt groupMemberInfoOpt = new GroupMemberInfoOpt();
        this.groupSettings.memberInfoOptions.convertTo(groupMemberInfoOpt);
        userConfig.setGroup_member_info_opt(groupMemberInfoOpt);
        FriendProfileInfoOpt friendProfileInfoOpt = new FriendProfileInfoOpt();
        this.friendshipSettings.convertTo(friendProfileInfoOpt);
        userConfig.setFriend_profile_opt(friendProfileInfoOpt);
        userConfig.setNotify(new IMCoreNotify(this.user.getIdentifier()));
        userConfig.setAuto_report(this.isAutoReportEnabled);
        userConfig.setRead_receipt(this.isReadReceiptEnabled);
        userConfig.setRecent_contact(this.isRecentContactEnabled);
        userConfig.setRecent_contact_notify(this.isRecentContactNotifyEnabled);
        userConfig.setStorage(this.isStorageEnabled);
        userConfig.setMm_ext(IMCoreWrapper.getMsgManagerExt(this.user.getIdentifier()));
        userConfig.setFriendship_proxy(this.isFriendshipStorageEnabled);
        userConfig.setFm_ext(IMCoreWrapper.getFrdManagerExt(this.user.getIdentifier()));
        userConfig.setGroup_assistant(this.isGroupStorageEnabled);
        userConfig.setGrp_ext(IMCoreWrapper.getGrpManagerExt(this.user.getIdentifier()));
        try {
            userConfig.setUgc_uploader((IUGCUploader) Class.forName("com.tencent.imsdk.ext.ugc.IMUGCExtBridge").getMethod("getUploader", new Class[0]).invoke((Object) null, new Object[0]));
        } catch (Throwable unused) {
            QLog.w(TAG, 1, "ugc ext package not found");
        }
        return userConfig;
    }

    public TIMConnListener getConnectionListener() {
        return this.connListener;
    }

    public TIMFriendshipSettings getFriendshipSettings() {
        return this.friendshipSettings;
    }

    /* access modifiers changed from: protected */
    public TIMGroupEventListener getGroupEventListener() {
        return this.groupEventListener;
    }

    public TIMGroupSettings getGroupSettings() {
        return this.groupSettings;
    }

    /* access modifiers changed from: protected */
    public TIMRefreshListener getRefreshListener() {
        return this.refreshListener;
    }

    public TIMUploadProgressListener getUploadProgressListener() {
        return this.uploadProgressListener;
    }

    /* access modifiers changed from: protected */
    public TIMUser getUser() {
        return this.user;
    }

    public TIMUserStatusListener getUserStatusListener() {
        return this.userStatusListener;
    }

    public TIMUserConfig setConnectionListener(TIMConnListener tIMConnListener) {
        this.connListener = tIMConnListener;
        return this;
    }

    public TIMUserConfig setFriendshipSettings(TIMFriendshipSettings tIMFriendshipSettings) {
        this.friendshipSettings = tIMFriendshipSettings;
        return this;
    }

    public TIMUserConfig setGroupEventListener(TIMGroupEventListener tIMGroupEventListener) {
        this.groupEventListener = tIMGroupEventListener;
        return this;
    }

    public TIMUserConfig setGroupSettings(TIMGroupSettings tIMGroupSettings) {
        this.groupSettings = tIMGroupSettings;
        return this;
    }

    public TIMUserConfig setRefreshListener(TIMRefreshListener tIMRefreshListener) {
        this.refreshListener = tIMRefreshListener;
        return this;
    }

    public TIMUserConfig setUploadProgressListener(TIMUploadProgressListener tIMUploadProgressListener) {
        this.uploadProgressListener = tIMUploadProgressListener;
        return this;
    }

    /* access modifiers changed from: protected */
    public void setUser(TIMUser tIMUser) {
        if (tIMUser != null) {
            this.user = tIMUser;
        }
    }

    public TIMUserConfig setUserStatusListener(TIMUserStatusListener tIMUserStatusListener) {
        this.userStatusListener = tIMUserStatusListener;
        return this;
    }
}
