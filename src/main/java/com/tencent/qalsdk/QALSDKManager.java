package com.tencent.qalsdk;

import android.content.Context;
import android.os.Build;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.qalsdk.core.NetConnInfoCenter;
import com.tencent.qalsdk.core.j;
import com.tencent.qalsdk.sdk.MsfSdkUtils;
import com.tencent.qalsdk.sdk.c;
import com.tencent.qalsdk.util.ALog;
import com.tencent.qalsdk.util.GuestHelper;
import com.tencent.qalsdk.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import qalsdk.ah;
import tencent.tls.platform.TLSHelper;

public class QALSDKManager {
    private static int LANG = 2052;
    private static String appVer = "1.0";
    public static boolean bConsoleLog = true;
    private static int country = 86;
    public static String gateip = null;
    static QALSDKManager inst = null;
    public static int svrport = 0;
    private static final String tag = "QALSDKManager";
    private boolean bAppSetGuestMode = false;
    private boolean bOnlyUseConn = false;
    private boolean bSupportGuestMode = true;
    private QALConnListener connListener = null;
    private ConcurrentHashMap<QALConnListener, Object> connListeners = new ConcurrentHashMap<>();
    private Context context = null;
    public volatile boolean inited = false;
    private ConcurrentHashMap<String, QALOfflinePushListener> mCmd2OfflinePushCallBack = new ConcurrentHashMap<>();
    private j msfCore = j.a();
    /* access modifiers changed from: private */
    public String processName;
    private int sdkAppId;
    private QALUserStatusListener userStatusListener = null;

    public int getQalAppId() {
        return 537050853;
    }

    public String getSdkVersion() {
        return "2.2.17.106265";
    }

    private QALSDKManager() {
    }

    public static QALSDKManager getInstance() {
        synchronized (QALSDKManager.class) {
            if (inst == null) {
                inst = new QALSDKManager();
            }
        }
        return inst;
    }

    public synchronized void setEnv(int i) {
        QLog.i(tag, "set server env:" + i);
        c.a().a(i);
    }

    public synchronized void setOutputLogLevel(int i) {
        QLog.i(tag, "setOutputLogLevel:" + i);
        c.a().b(i);
    }

    public synchronized void setNoGuestMode() {
        QLog.i(tag, "setNoGuestMode");
        if (!this.bAppSetGuestMode) {
            this.bSupportGuestMode = false;
        }
    }

    public synchronized void appSetGuestMode() {
        QLog.i(tag, "appSetGuestMode");
        this.bSupportGuestMode = true;
        this.bAppSetGuestMode = true;
    }

    public synchronized boolean getGuestMode() {
        return this.bSupportGuestMode;
    }

    public synchronized void setOnlyUseConn() {
        this.bOnlyUseConn = true;
    }

    public synchronized void setOffLinePushListener(String str, QALOfflinePushListener qALOfflinePushListener) {
        if (str != null) {
            if (str.length() != 0) {
                this.mCmd2OfflinePushCallBack.put(str, qALOfflinePushListener);
                return;
            }
        }
        QLog.e(tag, "cmd null:" + str);
    }

    /* access modifiers changed from: package-private */
    public synchronized ConcurrentHashMap<String, QALOfflinePushListener> getOffLinePushListener() {
        return this.mCmd2OfflinePushCallBack;
    }

    public synchronized void init(Context context2, int i) {
        QLog.e(tag, 1, "init qal sdk,version:" + getSdkVersion());
        if (!this.inited) {
            this.context = context2;
            QLog.init(context2);
            ALog.init(context2);
            this.sdkAppId = i;
            this.processName = MsfSdkUtils.getProcessName(context2);
            if (!this.bOnlyUseConn) {
                initTLSSDK();
            } else {
                QLog.e(tag, 1, "set only use conn,tls not init");
            }
            c.a().a(context2);
            if (Build.VERSION.SDK_INT >= 14) {
                ah.a(context2);
            }
            if (this.bSupportGuestMode) {
                GuestHelper.getInstance().init();
            }
            c.a().a((QALInitListener) new b(this));
            this.inited = true;
        }
    }

    private void initTLSSDK() {
        TLSHelper.getInstance().init(this.context, (long) this.sdkAppId).setLocalId(LANG);
        QLog.d(tag, 1, "init tls sdk done:" + this.sdkAppId);
    }

    public void setSDKAppID(int i) {
        this.sdkAppId = i;
    }

    public synchronized void setAppEnv(String str, String str2) {
        c.a().a(str, str2);
    }

    public void sendMsg(String str, String str2, byte[] bArr, QALValueCallBack qALValueCallBack) {
        if (bArr != null) {
            c.a();
            sendMsg(str, str2, bArr, c.c(bArr.length), qALValueCallBack);
            return;
        }
        sendMsg(str, str2, bArr, 10000, qALValueCallBack);
    }

    public void sendMsg(String str, String str2, byte[] bArr, long j, QALValueCallBack qALValueCallBack) {
        String str3 = str;
        long j2 = j;
        StringBuilder sb = new StringBuilder("sendmsg:");
        sb.append(str);
        sb.append(":");
        String str4 = str2;
        sb.append(str2);
        sb.append(":");
        sb.append(j2);
        QLog.d(tag, sb.toString());
        if (str3 == null || str.length() == 0) {
            str3 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        String str5 = str3;
        if (!this.inited) {
            QLog.e(tag, "qalsdk should init first!");
            return;
        }
        if (j2 < 2000 || j2 > 120000) {
            j2 = 10000;
        }
        c.a().a(str5, str2, bArr, qALValueCallBack, j2, false);
    }

    public int sendMsgAndGetSeq(String str, String str2, byte[] bArr, QALValueWithSeqCallBack qALValueWithSeqCallBack, boolean z) {
        if (bArr == null) {
            return sendMsgAndGetSeq(str, str2, bArr, 10000, qALValueWithSeqCallBack, z);
        }
        c.a();
        return sendMsgAndGetSeq(str, str2, bArr, c.c(bArr.length), qALValueWithSeqCallBack, z);
    }

    public int sendMsgAndGetSeq(String str, String str2, byte[] bArr, long j, QALValueWithSeqCallBack qALValueWithSeqCallBack, boolean z) {
        String str3 = str;
        long j2 = j;
        StringBuilder sb = new StringBuilder("sendmsg:");
        sb.append(str);
        sb.append(":");
        String str4 = str2;
        sb.append(str2);
        sb.append(":");
        sb.append(j2);
        QLog.d(tag, sb.toString());
        if (str3 == null || str.length() == 0) {
            str3 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        String str5 = str3;
        if (!this.inited) {
            QLog.e(tag, "qalsdk should init first!");
            return -1;
        }
        if (j2 < 2000 || j2 > 120000) {
            j2 = 10000;
        }
        return c.a().a(str5, str2, bArr, qALValueWithSeqCallBack, j2, z);
    }

    public synchronized QALUserStatusListener getUserStatusListener() {
        return this.userStatusListener;
    }

    public synchronized void setUserStatusListener(QALUserStatusListener qALUserStatusListener) {
        this.userStatusListener = qALUserStatusListener;
    }

    public synchronized QALConnListener getConnectionListener() {
        return this.connListener;
    }

    public synchronized void setConnectionListener(QALConnListener qALConnListener) {
        this.connListener = qALConnListener;
        this.connListeners.putIfAbsent(qALConnListener, new Object());
    }

    public synchronized ConcurrentHashMap<QALConnListener, Object> getConnectionListeners() {
        return this.connListeners;
    }

    public synchronized void removeConnectionListener(QALConnListener qALConnListener) {
        this.connListeners.remove(qALConnListener);
    }

    public synchronized void setInitListener(QALInitListener qALInitListener) {
        c.a().a(qALInitListener);
    }

    public Context getContext() {
        return this.context;
    }

    public void bindID(String str, QALCallBack qALCallBack) {
        QLog.i(tag, "begin bindID:" + str);
        c.a().b(str, qALCallBack);
    }

    public void unBindID(String str, QALCallBack qALCallBack) {
        QLog.i(tag, "unBindID:" + str);
        if (!c.a().e().containsKey(str)) {
            qALCallBack.onError(-2, "user is not registerd");
            QLog.e(tag, "user is not registerd");
        } else if (str.equals(c.a().c())) {
            qALCallBack.onError(-2, "guest user can't unbind");
            QLog.e(tag, "guest user can't unbind");
        } else {
            c.a().a(str, qALCallBack);
        }
    }

    public void addPushListener(String str, QALPushListener qALPushListener) {
        if (str == null || str.length() == 0) {
            QLog.e(tag, "cmd null:" + str);
            return;
        }
        QLog.i(tag, 1, "setPushCallBack: " + str);
        c.a().a(str, qALPushListener);
    }

    public void setTIMLogListener(QALLogListener qALLogListener) {
        QLog.setSdkLogListener(qALLogListener);
    }

    public void setReqTimeout(long j) {
        c.a().a(j);
    }

    public void login(String str, String str2, String str3, QALCallBack qALCallBack) {
        if (TLSHelper.getInstance() == null) {
            QLog.e(tag, 1, "tls login null");
            return;
        }
        TLSHelper.getInstance().TLSExchangeTicket((long) this.sdkAppId, str, str3, new c(this, str, qALCallBack));
    }

    public int getSdkAppId() {
        return this.sdkAppId;
    }

    public String getGuestIdentifier() {
        return c.a().c();
    }

    public String getGatewayIp() {
        return c.a().f();
    }

    public long getServetTimeSecondInterv() {
        return NetConnInfoCenter.servetTimeSecondInterv;
    }

    public void setAppQuit() {
        c.a().g();
    }

    public int getServerEnv() {
        return c.a().b();
    }

    public void stopQALService() {
        c.a();
        c.i();
    }

    public void setProxyList(String str, String[] strArr) {
        c.a().a(str, strArr);
    }

    public void cancelProxyList(String str) {
        c.a().b(str);
    }

    public void setDefineVersion(String str) {
        c.a().c(str);
    }
}
