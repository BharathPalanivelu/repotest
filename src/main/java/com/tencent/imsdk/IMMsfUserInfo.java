package com.tencent.imsdk;

import com.tencent.imsdk.log.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class IMMsfUserInfo {
    private static final String tag = "IMMsfUserInfo";
    ConcurrentHashMap<String, TIMValueCallBack<byte[]>> cmd2PushCallBack = new ConcurrentHashMap<>();
    private boolean isLoggedIn = false;
    private boolean isSigExpire = false;
    private long tinyid = 0;
    private TIMUser user = new TIMUser();

    public String getAccoutType() {
        TIMUser tIMUser = this.user;
        return tIMUser != null ? tIMUser.getAccountType() : "";
    }

    public ConcurrentHashMap<String, TIMValueCallBack<byte[]>> getCmd2PushCallBack() {
        return this.cmd2PushCallBack;
    }

    public String getIdentifier() {
        TIMUser tIMUser = this.user;
        return tIMUser != null ? tIMUser.getIdentifier() : "";
    }

    public String getSdkAppId() {
        TIMUser tIMUser = this.user;
        return tIMUser != null ? tIMUser.getAppIdAt3rd() : "";
    }

    public long getTinyid() {
        return this.tinyid;
    }

    public TIMUser getUser() {
        return this.user;
    }

    public boolean isLoggedIn() {
        return this.isLoggedIn;
    }

    public boolean isSigExpire() {
        return this.isSigExpire;
    }

    public void setIsLoggedIn(boolean z) {
        QLog.d(tag, 1, "set login flag to: " + z + "|" + this.user.getIdentifier());
        this.isLoggedIn = z;
    }

    public void setIsSigExpire(boolean z) {
        this.isSigExpire = z;
    }

    public void setPushCallBack(String str, TIMValueCallBack<byte[]> tIMValueCallBack) {
        this.cmd2PushCallBack.put(str, tIMValueCallBack);
    }

    public void setTinyid(long j) {
        this.tinyid = j;
    }

    public void setUser(TIMUser tIMUser) {
        this.user = tIMUser;
    }
}
