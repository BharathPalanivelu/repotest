package com.tencent.imsdk;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.imcore.IMCore;
import com.tencent.imcore.IMCoreUser;
import com.tencent.imsdk.log.QLog;
import com.tencent.qalsdk.QALSDKManager;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TIMManager {
    public static final int DEBUG = 4;
    public static final int ERROR = 1;
    public static final int INFO = 3;
    private static final String TAG = "imsdk.TIMManager";
    public static final int WARN = 2;
    static String defaultId = "";
    static ConcurrentHashMap<String, TIMManager> mutiMap = new ConcurrentHashMap<>();
    private IMCoreUser coreUser;
    private TIMConversation defaultConversation = new TIMConversation("");
    private String identification = "";
    private TIMMessageListener msgListener = null;
    private HashSet<TIMMessageListener> msgListeners = new HashSet<>();
    private HashSet<TIMMessageUpdateListener> msgUpdateListeners = new HashSet<>();
    private TIMOfflinePushListener offlinePushListener;
    private TIMUserConfig userConfig = new TIMUserConfig();

    private TIMManager(String str) {
        this.identification = str;
    }

    private void ensureId(String str) {
        if (str != null) {
            if (!TextUtils.isEmpty(this.identification) && !str.equals(this.identification)) {
                IMMsfCoreProxy.get().logout(this.identification, (TIMCallBack) null);
            }
            setIdentifier(str, true);
            this.coreUser = null;
            if (TextUtils.isEmpty(this.defaultConversation.getIdentifer())) {
                this.defaultConversation.setIdentifer(str);
            }
        }
    }

    public static TIMManager getInstance() {
        return getInstanceById(defaultId);
    }

    public static TIMManager getInstanceById(String str) {
        if (TextUtils.isEmpty(str)) {
            str = defaultId;
        } else if (TextUtils.isEmpty(defaultId)) {
            if (mutiMap.containsKey(defaultId)) {
                TIMManager tIMManager = mutiMap.get(defaultId);
                defaultId = str;
                tIMManager.setIdentifier(str, false);
                return tIMManager;
            }
            defaultId = str;
        }
        if (mutiMap.containsKey(str)) {
            return mutiMap.get(str);
        }
        if (!str.equals(defaultId) || !mutiMap.containsKey("")) {
            TIMManager tIMManager2 = new TIMManager(str);
            mutiMap.put(str, tIMManager2);
            return tIMManager2;
        }
        TIMManager tIMManager3 = mutiMap.get("");
        mutiMap.put(defaultId, tIMManager3);
        return tIMManager3;
    }

    protected static ConcurrentHashMap<String, TIMManager> getMutiTIMMangerMap() {
        return mutiMap;
    }

    public void addMessageListener(TIMMessageListener tIMMessageListener) {
        QLog.i(TAG, 1, "addMessageListener: " + tIMMessageListener);
        this.msgListeners.add(tIMMessageListener);
    }

    public void addMessageUpdateListener(TIMMessageUpdateListener tIMMessageUpdateListener) {
        QLog.i(TAG, 1, "addMessageUpdateListener: " + tIMMessageUpdateListener);
        this.msgUpdateListeners.add(tIMMessageUpdateListener);
    }

    public TIMConversation getConversation(TIMConversationType tIMConversationType, String str) {
        if (!IMCoreWrapper.get().isIMCoreUserInited()) {
            return this.defaultConversation;
        }
        if (str == null) {
            QLog.e(TAG, 1, "get conversation with null peer");
            return this.defaultConversation;
        }
        TIMConversation tIMConversation = new TIMConversation(this.identification);
        tIMConversation.setPeer(str);
        tIMConversation.setType(tIMConversationType);
        return tIMConversation;
    }

    /* access modifiers changed from: protected */
    public IMCoreUser getCoreUser() {
        if (this.coreUser == null && IMMsfCoreProxy.get().getMode() == 1) {
            QLog.w(TAG, 1, "TIMManager|getCoreUser reload user from: " + this.identification);
            this.coreUser = IMCore.get().getUser(this.identification);
        }
        return this.coreUser;
    }

    @Deprecated
    public int getEnv() {
        return IMMsfCoreProxy.get().getEnv();
    }

    /* access modifiers changed from: protected */
    public String getIdentifier() {
        return this.identification;
    }

    public String getLoginUser() {
        IMMsfUserInfo msfUserInfo = IMMsfCoreProxy.get().getMsfUserInfo(this.identification);
        if (msfUserInfo != null && msfUserInfo.isLoggedIn() && msfUserInfo.getTinyid() != 0) {
            return this.identification;
        }
        IMMsfUserInfo anyOnLineMsfUserInfo = IMMsfCoreProxy.get().getAnyOnLineMsfUserInfo();
        return (anyOnLineMsfUserInfo == null || !anyOnLineMsfUserInfo.isLoggedIn() || anyOnLineMsfUserInfo.getTinyid() == 0) ? "" : anyOnLineMsfUserInfo.getIdentifier();
    }

    /* access modifiers changed from: package-private */
    public Set<TIMMessageListener> getMessageListeners() {
        return this.msgListeners;
    }

    /* access modifiers changed from: package-private */
    public Set<TIMMessageUpdateListener> getMessageUpdateListeners() {
        return this.msgUpdateListeners;
    }

    public int getMode() {
        return IMMsfCoreProxy.get().getMode();
    }

    public TIMNetworkStatus getNetworkStatus() {
        return IMMsfCoreProxy.get().getNetworkStatus();
    }

    /* access modifiers changed from: protected */
    public TIMOfflinePushListener getOfflinePushListener() {
        return this.offlinePushListener;
    }

    public void getOfflinePushSettings(TIMValueCallBack<TIMOfflinePushSettings> tIMValueCallBack) {
        IMMsfCoreProxy.get().getOfflinePushSettings(this.identification, tIMValueCallBack);
    }

    public TIMSdkConfig getSdkConfig() {
        return IMMsfCoreProxy.get().getSdkConfig();
    }

    public long getServerTimeDiff() {
        return QALSDKManager.getInstance().getServetTimeSecondInterv();
    }

    public TIMUserConfig getUserConfig() {
        TIMUserConfig tIMUserConfig = this.userConfig;
        return tIMUserConfig != null ? tIMUserConfig : new TIMUserConfig();
    }

    public String getVersion() {
        return "3.3.2" + ".13740.13759";
    }

    public boolean init(Context context, TIMSdkConfig tIMSdkConfig) {
        if (context != null && tIMSdkConfig != null) {
            return IMMsfCoreProxy.get().init(context.getApplicationContext(), tIMSdkConfig);
        }
        QLog.e(TAG, 1, "invalid param");
        return false;
    }

    public void log(int i, String str, String str2) {
        if (i == 1) {
            QLog.e(str, 1, str2);
        } else if (i == 2) {
            QLog.w(str, 1, str2);
        } else if (i == 3) {
            QLog.i(str, 1, str2);
        } else if (i == 4) {
            QLog.d(str, 1, str2);
        }
    }

    public void login(String str, String str2, TIMCallBack tIMCallBack) {
        if (tIMCallBack != null) {
            ensureId(str);
            IMMsfCoreProxy.get().login(str, str2, tIMCallBack);
        }
    }

    public void logout(TIMCallBack tIMCallBack) {
        if (!TextUtils.isEmpty(this.identification)) {
            QLog.i(TAG, 1, "Logout|0-CallByUser| identifier: " + this.identification);
            IMMsfCoreProxy.get().logout(this.identification, tIMCallBack);
            mutiMap.remove(this.identification);
            if (defaultId.equals(this.identification)) {
                QLog.d(TAG, 1, "reset default id");
                defaultId = "";
            }
            this.identification = "";
        }
    }

    public void removeMessageListener(TIMMessageListener tIMMessageListener) {
        QLog.i(TAG, 1, "removeMessageListener: " + tIMMessageListener);
        this.msgListeners.remove(tIMMessageListener);
    }

    public void removeMessageUpdateListener(TIMMessageUpdateListener tIMMessageUpdateListener) {
        QLog.i(TAG, 1, "removeMessageUpdateListener: " + tIMMessageUpdateListener);
        this.msgUpdateListeners.remove(tIMMessageUpdateListener);
    }

    /* access modifiers changed from: protected */
    public void setCoreUser(IMCoreUser iMCoreUser) {
        this.coreUser = iMCoreUser;
    }

    @Deprecated
    public void setEnv(int i) {
        QLog.w(TAG, 1, "setEnv " + i);
        IMMsfCoreProxy.get().setEnv(i);
    }

    /* access modifiers changed from: protected */
    public void setIdentifier(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            QLog.w(TAG, 1, "setIdentifier->enter with empty id");
        } else if (TextUtils.isEmpty(this.identification) || !str.equals(this.identification)) {
            QLog.d(TAG, 1, "setIdentifier->update id:" + this.identification + "=>" + str + ", " + z);
            if (!TextUtils.isEmpty(this.identification)) {
                if (TextUtils.isEmpty(defaultId) || this.identification.equals(defaultId)) {
                    defaultId = str;
                }
                if (z && !TextUtils.isEmpty(this.identification) && mutiMap.containsKey(this.identification) && mutiMap.get(this.identification) == this) {
                    mutiMap.remove(this.identification);
                }
            }
            if (TextUtils.isEmpty(defaultId)) {
                defaultId = str;
            }
            this.identification = str;
            mutiMap.put(str, this);
        }
    }

    public void setMode(int i) {
        IMMsfCoreProxy.get().setMode(i);
    }

    public void setOfflinePushListener(TIMOfflinePushListener tIMOfflinePushListener) {
        QLog.d(TAG, 1, "registering offline push listener");
        this.offlinePushListener = tIMOfflinePushListener;
        QALSDKManager.getInstance().setOffLinePushListener("im_open_push.msg_push", new dj(this, tIMOfflinePushListener));
    }

    public void setOfflinePushSettings(TIMOfflinePushSettings tIMOfflinePushSettings) {
        IMMsfCoreProxy.get().initOfflinePushSettings(this.identification, tIMOfflinePushSettings);
    }

    public void setOfflinePushToken(TIMOfflinePushToken tIMOfflinePushToken, TIMCallBack tIMCallBack) {
        IMMsfCoreProxy.get().setOfflinePushToken(this.identification, tIMOfflinePushToken, tIMCallBack);
    }

    public void setUserConfig(TIMUserConfig tIMUserConfig) {
        if (tIMUserConfig != null) {
            this.userConfig = tIMUserConfig;
        }
    }

    public void stopQALService() {
        IMMsfCoreProxy.get().stopQALService();
    }
}
