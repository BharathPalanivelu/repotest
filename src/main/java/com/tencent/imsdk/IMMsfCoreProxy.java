package com.tencent.imsdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.appsflyer.share.Constants;
import com.facebook.appevents.AppEventsConstants;
import com.g.a.a.g;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import com.tencent.imcore.IMCore;
import com.tencent.imcore.QrEventType;
import com.tencent.imsdk.log.LogManager;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.protocol.log_report;
import com.tencent.imsdk.protocol.log_upload_pb;
import com.tencent.imsdk.protocol.msg_push;
import com.tencent.imsdk.protocol.stat_get_pushsound;
import com.tencent.imsdk.protocol.stat_set_pushsound;
import com.tencent.imsdk.protocol.stat_settoken;
import com.tencent.imsdk.utils.BuglyUtils;
import com.tencent.imsdk.utils.QualityReportHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qalsdk.QALSDKManager;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.NetworkInterface;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tencent.tls.platform.TLSHelper;
import tencent.tls.platform.TLSLoginHelper;

public class IMMsfCoreProxy {
    private static final String TAG = "imsdk.IMMsfCoreProxy";
    static IMMsfCoreProxy coreProxy = new IMMsfCoreProxy();
    public static Handler mainHandler = new Handler(Looper.getMainLooper());
    private static TIMSdkConfig sdkConfig = new TIMSdkConfig(0);
    /* access modifiers changed from: private */
    public Context context = null;
    private long count = 0;
    public volatile boolean inited = false;
    /* access modifiers changed from: private */
    public int mode = 1;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, IMMsfUserInfo> mutiUserMap = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public TIMNetworkStatus networkStatus = TIMNetworkStatus.TIM_NETWORK_STATUS_DISCONNECTED;
    private IMMsfUserInfo onlineMsfUser = null;
    /* access modifiers changed from: private */
    public ExecutorService pool = Executors.newFixedThreadPool(getNumCores());
    private long reqTimeout = BaseConstants.DEFAULT_MSG_TIMEOUT;
    private String sdkType = BaseConstants.IMSDK_TYPE;
    private long ttotal = 0;

    private IMMsfCoreProxy() {
    }

    public static IMMsfCoreProxy get() {
        return coreProxy;
    }

    private int getNumCores() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new bq(this));
            Log.d(TAG, "CPU Count: " + listFiles.length);
            return listFiles.length;
        } catch (Exception e2) {
            Log.d(TAG, "CPU Count: Failed.");
            e2.printStackTrace();
            return 2;
        }
    }

    /* access modifiers changed from: private */
    public void logReport(String str, String str2, int i, String str3) {
        if (!TextUtils.isEmpty(str2)) {
            log_report.ReqBody reqBody = new log_report.ReqBody();
            reqBody.bytes_log_id.set(ByteStringMicro.copyFromUtf8(str2));
            if (i != 0) {
                reqBody.uint32_err_code.set(i);
                reqBody.bytes_err_msg.set(ByteStringMicro.copyFromUtf8(str3));
            }
            request(str, "open_logs.report", reqBody.toByteArray(), new bs(this));
        }
    }

    public static void loginErrOnMainthread(TIMCallBack tIMCallBack, int i, String str) {
        mainHandler.post(new aw(tIMCallBack, i, str));
    }

    /* access modifiers changed from: private */
    public void saveOfflinePushSettingsToLocal(String str, TIMOfflinePushSettings tIMOfflinePushSettings) {
        Context context2 = this.context;
        if (context2 == null || tIMOfflinePushSettings == null) {
            QLog.e(TAG, 1, "save offlinePushSettings failed");
            return;
        }
        SharedPreferences.Editor edit = context2.getSharedPreferences(BaseConstants.OFFLINE_PUSH_SETTINGS_FILE, 0).edit();
        edit.putBoolean(str + BaseConstants.OFFLINE_IS_ENABLED_TAG, tIMOfflinePushSettings.isEnabled());
        String str2 = "";
        edit.putString(str + BaseConstants.OFFLINE_C2C_SOUND_TAG, tIMOfflinePushSettings.getC2cMsgRemindSound() != null ? tIMOfflinePushSettings.getC2cMsgRemindSound().toString() : str2);
        String str3 = str + BaseConstants.OFFLINE_GRP_SOUND_TAG;
        if (tIMOfflinePushSettings.getGroupMsgRemindSound() != null) {
            str2 = tIMOfflinePushSettings.getGroupMsgRemindSound().toString();
        }
        edit.putString(str3, str2);
        edit.apply();
    }

    public void addPushListener(Context context2) {
        QALSDKManager.getInstance().addPushListener("im_open_push.msg_push", new cg(this, context2));
    }

    public void downloadToFile(List<String> list, String str, TIMCallBack tIMCallBack, QualityReportHelper qualityReportHelper, long j) {
        if (tIMCallBack != null) {
            QualityReportHelper qualityReportHelper2 = qualityReportHelper;
            if (IMFunc.preCheck(list == null || list.isEmpty() || TextUtils.isEmpty(str), tIMCallBack, qualityReportHelper) == 0) {
                new Thread(new bu(this, list, tIMCallBack, qualityReportHelper, str, j)).start();
            }
        }
    }

    public String getAccountType() {
        TIMSdkConfig tIMSdkConfig = sdkConfig;
        return tIMSdkConfig == null ? AppEventsConstants.EVENT_PARAM_VALUE_NO : tIMSdkConfig.getAccoutType();
    }

    public String getAndroidId() {
        try {
            String string = Settings.Secure.getString(this.context.getContentResolver(), "android_id");
            MessageDigest instance = MessageDigest.getInstance(Hash.ALGORITHM_MD5);
            instance.update(string.getBytes());
            String byte2hexInternal = IMFunc.byte2hexInternal(instance.digest());
            return !TextUtils.isEmpty(byte2hexInternal) ? byte2hexInternal : string;
        } catch (Throwable th) {
            QLog.e(TAG, 1, "get android id failed: " + QLog.getStackTraceString(th));
            return "";
        }
    }

    public IMMsfUserInfo getAnyOnLineMsfUserInfo() {
        IMMsfUserInfo iMMsfUserInfo = this.onlineMsfUser;
        if (iMMsfUserInfo != null && iMMsfUserInfo.isLoggedIn()) {
            return this.onlineMsfUser;
        }
        for (Map.Entry<String, IMMsfUserInfo> value : this.mutiUserMap.entrySet()) {
            IMMsfUserInfo iMMsfUserInfo2 = (IMMsfUserInfo) value.getValue();
            if (iMMsfUserInfo2.isLoggedIn()) {
                this.onlineMsfUser = iMMsfUserInfo2;
                return this.onlineMsfUser;
            }
        }
        return this.onlineMsfUser;
    }

    public Context getContext() {
        return this.context;
    }

    public int getEnv() {
        return QALSDKManager.getInstance().getServerEnv();
    }

    public String getIMEI() {
        String str = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.context.getSystemService("phone");
            if (telephonyManager != null) {
                str = telephonyManager.getDeviceId();
            }
            MessageDigest instance = MessageDigest.getInstance(Hash.ALGORITHM_MD5);
            instance.update(str.getBytes());
            String byte2hexInternal = IMFunc.byte2hexInternal(instance.digest());
            return !TextUtils.isEmpty(byte2hexInternal) ? byte2hexInternal : str;
        } catch (Throwable th) {
            QLog.e(TAG, 1, "get imei failed: " + QLog.getStackTraceString(th));
            return str;
        }
    }

    public String getMacAddress() {
        try {
            NetworkInterface byName = NetworkInterface.getByName("wlan0");
            if (byName == null) {
                return "";
            }
            byte[] hardwareAddress = byName.getHardwareAddress();
            MessageDigest instance = MessageDigest.getInstance(Hash.ALGORITHM_MD5);
            instance.update(hardwareAddress);
            String byte2hexInternal = IMFunc.byte2hexInternal(instance.digest());
            return !TextUtils.isEmpty(byte2hexInternal) ? byte2hexInternal : "";
        } catch (Throwable th) {
            QLog.e(TAG, 1, "get mac address failed: " + QLog.getStackTraceString(th));
            return "";
        }
    }

    public int getMode() {
        return this.mode;
    }

    public IMMsfUserInfo getMsfUserInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            str = TIMManager.getInstance().getIdentifier();
            QLog.w(TAG, 1, "IMMsfCoreProxy|getMsfUserInfo empty, take identifer id:" + str);
        }
        if (this.mutiUserMap.containsKey(str)) {
            return this.mutiUserMap.get(str);
        }
        return null;
    }

    public TIMNetworkStatus getNetworkStatus() {
        return this.networkStatus;
    }

    public void getOfflinePushSettings(String str, TIMValueCallBack<TIMOfflinePushSettings> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            if (!isLoggedIn(str)) {
                new IMErrInfo(BaseConstants.ERR_SDK_NOT_LOGGED_IN, "current user not login. id: " + str);
                QLog.e(TAG, 1, "getOfflinePushSettings failed, user not online: " + str);
                mainHandler.post(new bl(this, tIMValueCallBack, str));
                return;
            }
            stat_get_pushsound.ReqBody reqBody = new stat_get_pushsound.ReqBody();
            reqBody.uint32_platform.set(2);
            reqBody.uint64_tinyid.set(get().getMsfUserInfo(str).getTinyid());
            get().request(str, "im_open_status.stat_get_pushsound", reqBody.toByteArray(), new bm(this, tIMValueCallBack, str));
        }
    }

    public boolean getOfflinePushSettingsFromLocal(Context context2, String str, TIMOfflinePushSettings tIMOfflinePushSettings) {
        if (tIMOfflinePushSettings == null || context2 == null) {
            return false;
        }
        SharedPreferences sharedPreferences = context2.getSharedPreferences(BaseConstants.OFFLINE_PUSH_SETTINGS_FILE, 0);
        if (!sharedPreferences.contains(str + BaseConstants.OFFLINE_IS_ENABLED_TAG)) {
            return false;
        }
        tIMOfflinePushSettings.setEnabled(sharedPreferences.getBoolean(str + BaseConstants.OFFLINE_IS_ENABLED_TAG, false));
        String string = sharedPreferences.getString(str + BaseConstants.OFFLINE_C2C_SOUND_TAG, "");
        if (!TextUtils.isEmpty(string)) {
            tIMOfflinePushSettings.setC2cMsgRemindSound(Uri.parse(string));
        }
        String string2 = sharedPreferences.getString(str + BaseConstants.OFFLINE_GRP_SOUND_TAG, "");
        if (TextUtils.isEmpty(string2)) {
            return true;
        }
        tIMOfflinePushSettings.setGroupMsgRemindSound(Uri.parse(string2));
        return true;
    }

    public long getReqTimeout() {
        return this.reqTimeout;
    }

    public int getSdkAppId() {
        TIMSdkConfig tIMSdkConfig = sdkConfig;
        if (tIMSdkConfig == null) {
            return 0;
        }
        return tIMSdkConfig.getSdkAppId();
    }

    public TIMSdkConfig getSdkConfig() {
        return sdkConfig;
    }

    public String getSdkType() {
        return this.sdkType;
    }

    public ConcurrentHashMap<String, TIMValueCallBack<byte[]>> getUserPushCallBack(String str) {
        if (this.mutiUserMap.containsKey(str)) {
            return this.mutiUserMap.get(str).getCmd2PushCallBack();
        }
        return null;
    }

    public void handleMsg(String str, Context context2, byte[] bArr) {
        String str2 = str;
        byte[] bArr2 = bArr;
        msg_push.ReqBody reqBody = new msg_push.ReqBody();
        try {
            reqBody.mergeFrom(bArr2);
            int i = reqBody.msg_msg.msg_msg_head.msg_content_head.uint32_type.get();
            int i2 = reqBody.msg_msg.msg_msg_head.msg_content_head.uint32_subtype.get();
            long j = reqBody.msg_msg.msg_msg_head.msg_routine_head.msg_c2c_info.uint64_to_uin.get();
            QLog.i(TAG, 1, "im_open_push.msg_push ack");
            msg_push.RspBody rspBody = new msg_push.RspBody();
            rspBody.bytes_session_data.setHasFlag(true);
            rspBody.bytes_session_data.set(ByteStringMicro.copyFrom(reqBody.bytes_session_data.get().toByteArray()));
            get().request(str2, "im_open_push.msg_push", rspBody.toByteArray(), (TIMValueCallBack<byte[]>) null);
            IMMsfUserInfo msfUserInfo = get().getMsfUserInfo(str2);
            if (msfUserInfo == null || !msfUserInfo.isLoggedIn()) {
                QLog.w(TAG, 1, "RecvMsg|1-OnlinePush|Fail| user not found or not online. id: " + str2 + "|" + str2);
                QLog.d(TAG, 1, "OfflinePush|1-Begin|succ|recv offline push, id: " + str2 + "|" + str2);
                if (!isOfflinePushEnabled(context2, str2)) {
                    QLog.d(TAG, 1, "OfflinePush|2-callback|failed|offline push disabled");
                    return;
                }
                TIMOfflinePushListener offlinePushListener = TIMManager.getInstanceById(str).getOfflinePushListener();
                if (offlinePushListener == null) {
                    QLog.d(TAG, 1, "OfflinePush|2-callback|failed|no callback ");
                    return;
                }
                TIMOfflinePushNotification offlinePush2PushNotification = IMCoreProtobufParser.offlinePush2PushNotification(str, context2, bArr);
                if (offlinePush2PushNotification == null || !offlinePush2PushNotification.isValid()) {
                    QLog.d(TAG, 1, "OfflinePush|2-callback|failed|invalid msg");
                    return;
                }
                QLog.d(TAG, 1, "OfflinePush|2-callback|succ|callback");
                offlinePushListener.handleNotification(offlinePush2PushNotification);
            } else if ((i == 561 || i == 734) && j != msfUserInfo.getTinyid()) {
                QLog.d(TAG, 1, "discard other's push: " + j);
            } else {
                QLog.e(TAG, 1, "msg type: " + i + " subtype: " + i2 + Constants.URL_PATH_DELIMITER + str2);
                if (i == 561 && i2 == 34) {
                    log_upload_pb.MsgBody msgBody = new log_upload_pb.MsgBody();
                    try {
                        msgBody.mergeFrom(reqBody.msg_msg.msg_msg_body.msg_content.get().toByteArray());
                        IMCoreUploadLogFileOpt iMCoreUploadLogFileOpt = new IMCoreUploadLogFileOpt();
                        String str3 = msgBody.rpt_string_tag.get();
                        String str4 = msgBody.rpt_string_logtime.get(0);
                        TIMSdkConfig tIMSdkConfig = sdkConfig;
                        iMCoreUploadLogFileOpt.setFilePath((tIMSdkConfig == null ? "" : tIMSdkConfig.getLogPath()) + str3 + "_" + str4 + ".log");
                        iMCoreUploadLogFileOpt.setTag(str3);
                        iMCoreUploadLogFileOpt.setLogId(msgBody.bytes_log_id.get().toStringUtf8());
                        iMCoreUploadLogFileOpt.setLogSize((long) msgBody.uint32_log_size.get());
                        iMCoreUploadLogFileOpt.setRelativePath(msgBody.bytes_log_path.get().toStringUtf8());
                        uploadLogFile(str2, iMCoreUploadLogFileOpt);
                    } catch (Throwable th) {
                        QLog.e(TAG, 1, IMFunc.getExceptionInfo(th));
                        QLog.e(TAG, 1, "parse upload log pb failed");
                    }
                } else {
                    String str5 = "im_open_push.msg_push" + "_" + i;
                    if (msfUserInfo.getCmd2PushCallBack().containsKey(str5)) {
                        TIMValueCallBack tIMValueCallBack = msfUserInfo.getCmd2PushCallBack().get(str5);
                        if (i == 734) {
                            mainHandler.post(new ci(this, tIMValueCallBack, reqBody));
                        } else {
                            tIMValueCallBack.onSuccess(bArr2);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            QLog.e(TAG, 1, IMFunc.getExceptionInfo(th2));
        }
    }

    public synchronized boolean init(Context context2, TIMSdkConfig tIMSdkConfig) {
        boolean z = false;
        if (!this.inited) {
            this.context = context2;
            sdkConfig = tIMSdkConfig;
            tIMSdkConfig.setLogPath(initLogPath(sdkConfig.getLogPath()));
            QLog.i(TAG, 1, "\n=====================================================");
            QLog.i(TAG, 1, "initSdk msfCoreProxy...");
            QLog.i(TAG, 1, "try initSdk msfCoreProxy|appid: " + QALSDKManager.getInstance().getQalAppId());
            if (Build.VERSION.SDK_INT >= 23 && context2.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                QLog.e(TAG, 1, "no WRITE_EXTERNAL_STORAGE permission granted, won't log to file");
                sdkConfig.setLogLevel(TIMLogLevel.OFF);
            }
            if (this.mode == 1) {
                try {
                    if (IMCoreWrapper.get().loadLib()) {
                        initQalSdk();
                        if (!IMCoreWrapper.get().initIMCore(context2, sdkConfig)) {
                            return false;
                        }
                    } else {
                        setMode(0);
                        QLog.e(TAG, 1, "load so libs failed, fail to load so libs, setMode 0");
                        return false;
                    }
                } catch (Throwable th) {
                    setMode(0);
                    QLog.e(TAG, 1, "init failed, setMode 0\n" + QLog.getStackTraceString(th));
                    return false;
                }
            } else {
                initQalSdk();
                LogManager.init();
                QLog.init(context2);
            }
            this.inited = true;
            StringBuilder sb = new StringBuilder("init done, with imcore: ");
            if (this.mode == 1) {
                z = true;
            }
            sb.append(z);
            QLog.i(TAG, 1, sb.toString());
            return true;
        }
        StringBuilder sb2 = new StringBuilder("init done, Already inited before, with imcore: ");
        if (this.mode == 1) {
            z = true;
        }
        sb2.append(z);
        QLog.i(TAG, 1, sb2.toString());
        return true;
    }

    public String initLogPath(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            try {
                str2 = this.context.getPackageName();
            } catch (Exception unused) {
                str2 = "unknown";
            }
            str = Environment.getExternalStorageDirectory().getPath() + "/tencent/imsdklogs/" + str2.replace(".", Constants.URL_PATH_DELIMITER) + Constants.URL_PATH_DELIMITER;
            if (this.context == null) {
                return str;
            }
        }
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            file = this.context.getFilesDir();
            QLog.d(TAG, 1, "create imsdklogs folder failed");
        }
        return file.getAbsolutePath() + Constants.URL_PATH_DELIMITER;
    }

    public void initOfflinePushSettings(String str, TIMOfflinePushSettings tIMOfflinePushSettings) {
        if (!isLoggedIn(str)) {
            QLog.e(TAG, 1, "initOfflinePushSettings failed, user not online");
        } else if (tIMOfflinePushSettings == null) {
            QLog.e(TAG, 1, "initOfflinePushSettings failed, invalid param");
        } else {
            stat_set_pushsound.ReqBody reqBody = new stat_set_pushsound.ReqBody();
            int i = 2;
            reqBody.uint32_platform.set(2);
            reqBody.msg_config.setHasFlag(true);
            PBUInt32Field pBUInt32Field = reqBody.msg_config.uint32_openpush;
            if (tIMOfflinePushSettings.isEnabled()) {
                i = 1;
            }
            pBUInt32Field.set(i);
            try {
                String str2 = "";
                reqBody.msg_config.bytes_c2c_sound.set(ByteStringMicro.copyFrom((tIMOfflinePushSettings.getC2cMsgRemindSound() != null ? tIMOfflinePushSettings.getC2cMsgRemindSound().toString() : str2).getBytes("utf-8")));
                if (tIMOfflinePushSettings.getGroupMsgRemindSound() != null) {
                    str2 = tIMOfflinePushSettings.getGroupMsgRemindSound().toString();
                }
                reqBody.msg_config.bytes_grp_sound.set(ByteStringMicro.copyFrom(str2.getBytes("utf-8")));
                request(str, "im_open_status.stat_set_pushsound", reqBody.toByteArray(), new bk(this, str, tIMOfflinePushSettings));
            } catch (Throwable th) {
                QLog.e(TAG, 1, "initOfflinePushSettings failed, form req failed: " + QLog.getStackTraceString(th));
            }
        }
    }

    public void initQalSdk() {
        QALSDKManager.getInstance().setOutputLogLevel(sdkConfig.getLogLevel().getIntLevel());
        QALSDKManager.getInstance().setTIMLogListener(new br(this));
        QALSDKManager.getInstance().setConnectionListener(new ca(this));
        QALSDKManager.getInstance().setUserStatusListener(new ce(this));
        addPushListener(this.context);
        QALSDKManager.getInstance().setNoGuestMode();
        QALSDKManager.getInstance().init(this.context, sdkConfig.getSdkAppId());
    }

    public boolean isLoggedIn(String str) {
        if (this.mutiUserMap.containsKey(str)) {
            return this.mutiUserMap.get(str).isLoggedIn();
        }
        return false;
    }

    public boolean isOfflinePushEnabled(Context context2, String str) {
        if (context2 == null) {
            return false;
        }
        if (this.context == null) {
            this.context = context2;
        }
        SharedPreferences sharedPreferences = context2.getSharedPreferences(BaseConstants.OFFLINE_PUSH_SETTINGS_FILE, 0);
        if (!sharedPreferences.contains(str + BaseConstants.OFFLINE_IS_ENABLED_TAG)) {
            return true;
        }
        return sharedPreferences.getBoolean(str + BaseConstants.OFFLINE_IS_ENABLED_TAG, false);
    }

    public void login(String str, String str2, TIMCallBack tIMCallBack) {
        String str3 = str;
        String str4 = str2;
        TIMCallBack tIMCallBack2 = tIMCallBack;
        QualityReportHelper qualityReportHelper = new QualityReportHelper(QrEventType.kEventLogin.swigValue());
        if (!this.inited) {
            IMErrInfo iMErrInfo = new IMErrInfo(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not initialized");
            loginErrOnMainthread(tIMCallBack2, iMErrInfo.getCode(), iMErrInfo.getMsg());
            qualityReportHelper.init(iMErrInfo.getCode(), iMErrInfo.getMsg());
            qualityReportHelper.report();
        } else if (TextUtils.isEmpty(str)) {
            IMErrInfo iMErrInfo2 = new IMErrInfo(BaseConstants.ERR_INVALID_PARAMETERS, "invalid identifier");
            loginErrOnMainthread(tIMCallBack2, iMErrInfo2.getCode(), iMErrInfo2.getMsg());
            qualityReportHelper.init(iMErrInfo2.getCode(), iMErrInfo2.getMsg());
            qualityReportHelper.report();
        } else if (TextUtils.isEmpty(str2)) {
            IMErrInfo iMErrInfo3 = new IMErrInfo(BaseConstants.ERR_INVALID_PARAMETERS, "invalid usersig");
            loginErrOnMainthread(tIMCallBack2, iMErrInfo3.getCode(), iMErrInfo3.getMsg());
            qualityReportHelper.init(iMErrInfo3.getCode(), iMErrInfo3.getMsg());
            qualityReportHelper.report();
        } else {
            QLog.i(TAG, 1, "Login|1-Begin|Succ|identifer=" + str3 + ", sdkappid=" + getSdkAppId());
            TIMUser tIMUser = new TIMUser();
            tIMUser.setIdentifier(str3);
            tIMUser.setSdkAppid((long) getSdkAppId());
            tIMUser.setAccountType(getAccountType());
            tIMUser.setAppIdAt3rd(String.valueOf(getSdkAppId()));
            IMMsfUserInfo msfUserInfo = getMsfUserInfo(str);
            if (msfUserInfo == null) {
                msfUserInfo = new IMMsfUserInfo();
                msfUserInfo.setUser(tIMUser);
            }
            IMMsfUserInfo iMMsfUserInfo = msfUserInfo;
            QALSDKManager.getInstance().setSDKAppID(getSdkAppId());
            BuglyUtils instance = BuglyUtils.getInstance();
            Context context2 = this.context;
            TIMSdkConfig tIMSdkConfig = sdkConfig;
            int i = 0;
            instance.init(context2, tIMSdkConfig != null && tIMSdkConfig.isCrashReportEnabled(), tIMUser);
            if (!QALSDKManager.getInstance().inited) {
                IMErrInfo iMErrInfo4 = new IMErrInfo(BaseConstants.ERR_SDK_NOT_INITIALIZED, "qalsdk not initialized.");
                loginErrOnMainthread(tIMCallBack2, iMErrInfo4.getCode(), iMErrInfo4.getMsg());
                qualityReportHelper.init(iMErrInfo4.getCode(), iMErrInfo4.getMsg());
                qualityReportHelper.report();
                return;
            }
            TIMUser tIMUser2 = tIMUser;
            cl clVar = new cl(this, tIMUser2, tIMCallBack, qualityReportHelper, iMMsfUserInfo);
            cn cnVar = r0;
            cn cnVar2 = new cn(this, tIMUser2, iMMsfUserInfo, clVar, tIMCallBack, qualityReportHelper);
            try {
                i = Integer.valueOf(getAccountType()).intValue();
            } catch (Exception unused) {
                QLog.e(TAG, 1, "invalid accountType: " + getAccountType());
            }
            if (i <= 0 || i >= 100) {
                TLSLoginHelper.getInstance().TLSExchangeTicket((long) getSdkAppId(), tIMUser.getIdentifier(), str2, cnVar);
                return;
            }
            QLog.i(TAG, 1, "3rd login:" + getAccountType() + ":" + tIMUser.getAppIdAt3rd() + ":" + tIMUser.getIdentifier() + ":" + str4);
            TLSHelper.getInstance().setOpenAccountInfo(i, tIMUser.getAppIdAt3rd(), tIMUser.getIdentifier(), str4);
            TLSHelper.getInstance().TLSOpenAccountLogin(cnVar);
        }
    }

    public void logout(String str, TIMCallBack tIMCallBack) {
        QLog.i(TAG, 1, "Logout|1-Begin|Succ, identifier: " + str);
        if (!TextUtils.isEmpty(str)) {
            QALSDKManager.getInstance().unBindID(str, new ax(this, tIMCallBack));
        }
        IMMsfUserInfo msfUserInfo = getMsfUserInfo(str);
        if (msfUserInfo == null) {
            QLog.e(TAG, 1, "user logout error user not found: " + str);
            if (tIMCallBack != null) {
                QLog.e(TAG, 1, "Logout|2-Callback|Succ|user not found");
                mainHandler.post(new ba(this, tIMCallBack, str));
                return;
            }
            return;
        }
        TIMUser user = msfUserInfo.getUser();
        QLog.i(TAG, 1, "user logout: " + user);
        if (user != null && IMCoreWrapper.get().isIMCoreUserInited()) {
            IMCore.get().unInitUser(user.getIdentifier());
            if (getAnyOnLineMsfUserInfo() == null) {
                IMCoreWrapper.get().setIMCoreUserInited(false);
            }
        }
        msfUserInfo.setTinyid(0);
        msfUserInfo.setIsLoggedIn(false);
        if (str != null) {
            return;
        }
        if (tIMCallBack != null) {
            QLog.i(TAG, 1, "Logout|2-Callback|Succ|logout succ");
            mainHandler.post(new bb(this, tIMCallBack));
            return;
        }
        QLog.e(TAG, 1, "Logout|2-Callback|Fail|user not set logout callback");
    }

    /* access modifiers changed from: package-private */
    public void notifyOnUsersigExpired(String str) {
        IMMsfUserInfo msfUserInfo = getMsfUserInfo(str);
        if (msfUserInfo == null) {
            QLog.e(TAG, 1, "sSORequest no user found: " + str);
            msfUserInfo = new IMMsfUserInfo();
        }
        QLog.i(TAG, 1, "onUsersigExpired, identifier: " + str);
        if (!msfUserInfo.isSigExpire()) {
            TIMUserStatusListener userStatusListener = TIMManager.getInstanceById(str).getUserConfig().getUserStatusListener();
            if (userStatusListener != null) {
                mainHandler.post(new bz(this, userStatusListener));
            }
        }
        msfUserInfo.setIsSigExpire(true);
    }

    public void performanceTest(String str) {
        byte[] bArr = {10, -99, 1, 10, -113, 1, 10, 30, 8, -76, 4, 16, 6, 24, -16, 80, 32, -87, -58, -100, 42, 40, -4, -121, -25, -72, 5, 48, -4, -121, -25, -72, 5, 64, -58, -59, -47, 2, 18, 99, 10, 19, 26, 17, 16, -79, -49, -118, Byte.MIN_VALUE, 2, 40, -3, -89, -55, -101, 5, 90, 3, 87, 101, 98, 34, 74, 8, -86, -62, -50, -84, -90, Byte.MIN_VALUE, Byte.MIN_VALUE, Byte.MIN_VALUE, 2, 16, -11, -72, -102, -97, -90, Byte.MIN_VALUE, Byte.MIN_VALUE, Byte.MIN_VALUE, 2, 24, 5, 32, 5, 42, 6, -25, -117, -105, -27, -72, -90, 56, -4, -55, -36, -120, 16, 66, 3, 66, 66, 67, 98, 14, 64, 84, 71, 83, 35, 50, 52, 72, 74, 79, 82, 65, 69, 77, 104, 0, 114, g.STRUCT_END, 16, -56, 1, 50, 6, 120, 107, 97, 122, 101, 114, 58, 0, 34, 8, 34, 2, 8, 0, 40, 0, 80, 2, 18, 9, 10, 7, 18, 5, 10, 3, 10, 1, 51, 18, 21, g.SIMPLE_LIST, 10, -21, 8, 25, 21, 52, -127, 0, 0, 24, -44, -1, -53, -43, -90, -95, -4, -71, -88, 1};
        long currentTimeMillis = System.currentTimeMillis();
        this.count++;
        int i = 0;
        while (i < 100) {
            IMCore.get().getUser(str).manualPush(bArr);
            i++;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        Log.e("XIAO", "totoal cost: " + currentTimeMillis2 + "ms/" + i);
        StringBuilder sb = new StringBuilder("level: ");
        long j = currentTimeMillis2 / ((long) i);
        sb.append(j);
        sb.append("mpm");
        Log.e("XIAO", sb.toString());
        this.ttotal += j;
        Log.e("XIAO", "ave: " + (this.ttotal / this.count) + "mpm/" + this.count);
    }

    public void request(String str, String str2, byte[] bArr, TIMValueCallBack<byte[]> tIMValueCallBack) {
        request(str, str2, bArr, tIMValueCallBack, this.reqTimeout);
    }

    public void request(String str, String str2, byte[] bArr, TIMValueCallBack<byte[]> tIMValueCallBack, long j) {
        StringBuilder sb;
        String str3;
        String str4 = str;
        String str5 = str2;
        TIMValueCallBack<byte[]> tIMValueCallBack2 = tIMValueCallBack;
        QLog.i(TAG, 1, "request user: " + str + "|cmd:" + str2);
        IMMsfUserInfo msfUserInfo = getMsfUserInfo(str);
        if (str2.equals("im_open_push.msg_push") || (msfUserInfo != null && msfUserInfo.isLoggedIn())) {
            cj cjVar = null;
            if (tIMValueCallBack2 != null) {
                cjVar = new cj(this, tIMValueCallBack, str2);
            }
            cj cjVar2 = cjVar;
            String identifier = TextUtils.isEmpty(str) ? TIMManager.getInstance().getIdentifier() : str4;
            if (IMCoreWrapper.get().isIMCoreInited()) {
                sb = new StringBuilder("request user: ");
                sb.append(str);
                sb.append("|cmd:");
                sb.append(str2);
                str3 = "|req";
            } else {
                sb = new StringBuilder("request user: ");
                sb.append(str);
                sb.append("|cmd:");
                sb.append(str2);
                sb.append("|req:");
                str3 = IMFunc.byte2hex(bArr);
            }
            sb.append(str3);
            QLog.d(TAG, 1, sb.toString());
            IMMsgSender.getInstance().sendMsg(identifier, str2, bArr, str2.equals("group_open_long_polling_svc.get_msg") ? 5000 : j, cjVar2);
            return;
        }
        QLog.e(TAG, 1, "user not logged in: " + str);
        if (tIMValueCallBack2 != null) {
            tIMValueCallBack.onError(BaseConstants.ERR_SDK_NOT_LOGGED_IN, "current user not login. id: " + str);
            QLog.e(TAG, 1, "current user not login. id: " + str);
        }
    }

    public void setEnv(int i) {
        QALSDKManager.getInstance().setEnv(i);
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public void setOfflinePushToken(String str, TIMOfflinePushToken tIMOfflinePushToken, TIMCallBack tIMCallBack) {
        QualityReportHelper qualityReportHelper = new QualityReportHelper(QrEventType.kEventSetToken.swigValue());
        if (!isLoggedIn(str)) {
            IMErrInfo iMErrInfo = new IMErrInfo(BaseConstants.ERR_SDK_NOT_LOGGED_IN, "current user not login. id: " + str);
            QLog.e(TAG, 1, iMErrInfo.getMsg());
            qualityReportHelper.init(iMErrInfo.getCode(), iMErrInfo.getMsg());
            qualityReportHelper.report();
            mainHandler.post(new bc(this, tIMCallBack, iMErrInfo));
        } else if (tIMOfflinePushToken == null || TextUtils.isEmpty(tIMOfflinePushToken.getToken()) || tIMOfflinePushToken.getBussid() == 0) {
            IMErrInfo iMErrInfo2 = new IMErrInfo(BaseConstants.ERR_INVALID_PARAMETERS, "setToken failed, busisid=0 or token is empty");
            QLog.e(TAG, 1, iMErrInfo2.getMsg());
            qualityReportHelper.init(iMErrInfo2.getCode(), iMErrInfo2.getMsg());
            qualityReportHelper.report();
            mainHandler.post(new bd(this, tIMCallBack, iMErrInfo2));
        } else {
            int clientInstType = IMFunc.getClientInstType();
            QLog.i(TAG, 1, "setToken, token: " + tIMOfflinePushToken.getToken() + "|bussid: " + tIMOfflinePushToken.getBussid() + "|vendor: " + Build.MANUFACTURER + "|vendorId:" + clientInstType);
            stat_settoken.ReqBody reqBody = new stat_settoken.ReqBody();
            reqBody.uint32_busiid.set((int) tIMOfflinePushToken.getBussid());
            try {
                reqBody.bytes_token_id.set(ByteStringMicro.copyFrom(tIMOfflinePushToken.getToken().getBytes("utf-8")));
                reqBody.uint32_inst_type.set(clientInstType);
                reqBody.uint32_enter_version.set(getSdkAppId());
                reqBody.uint32_push_msg.set(1);
                request(str, "im_open_status.stat_settoken", reqBody.toByteArray(), new bf(this, tIMCallBack, qualityReportHelper));
            } catch (Throwable unused) {
                IMErrInfo iMErrInfo3 = new IMErrInfo(BaseConstants.ERR_SERIALIZE_REQ_FAILED, "setToken failed, req serialize failed");
                QLog.e(TAG, 1, iMErrInfo3.getMsg());
                qualityReportHelper.init(iMErrInfo3.getCode(), iMErrInfo3.getMsg());
                qualityReportHelper.report();
                QLog.e(TAG, 1, iMErrInfo3.getMsg());
                mainHandler.post(new be(this, tIMCallBack, iMErrInfo3));
            }
        }
    }

    public void setReqTimeout(long j) {
        this.reqTimeout = j;
    }

    public void setSdkType(String str) {
        this.sdkType = str;
    }

    public void stopQALService() {
        QALSDKManager.getInstance().stopQALService();
    }

    public boolean uploadLogFile(String str, IMCoreUploadLogFileOpt iMCoreUploadLogFileOpt) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        RandomAccessFile randomAccessFile;
        byte[] bArr;
        HashMap hashMap;
        String str10 = str;
        IMMsfUserInfo msfUserInfo = get().getMsfUserInfo(str10);
        if (msfUserInfo == null) {
            QLog.e(TAG, 1, "uploadLogFile->find user failed: " + str10);
            return false;
        }
        String logId = iMCoreUploadLogFileOpt.getLogId();
        String filePath = iMCoreUploadLogFileOpt.getFilePath();
        String tag = iMCoreUploadLogFileOpt.getTag();
        String relativePath = iMCoreUploadLogFileOpt.getRelativePath();
        long logSize = iMCoreUploadLogFileOpt.getLogSize() * BaseConstants.MEGA;
        long j = 0;
        if (logSize == 0) {
            QLog.e(TAG, 1, "uploadLogFile->failed: invalid parameters, request size 0");
            get().logReport(str10, logId, BaseConstants.ERR_INVALID_PARAMETERS, "invalid parameters, request size 0");
            return false;
        }
        try {
            UUID randomUUID = UUID.randomUUID();
            String str11 = TAG;
            try {
                String uuid = randomUUID.toString();
                String str12 = "op";
                if (!TextUtils.isEmpty(logId)) {
                    str8 = logId + ".lz4";
                    str6 = "biz_attr";
                    str7 = "sha";
                    str5 = logId;
                } else {
                    str5 = logId;
                    try {
                        int lastIndexOf = filePath.lastIndexOf(46);
                        str6 = "biz_attr";
                        String substring = filePath.substring(lastIndexOf - 8, lastIndexOf);
                        StringBuilder sb = new StringBuilder();
                        sb.append(tag);
                        sb.append("_");
                        sb.append(substring);
                        sb.append("_");
                        str7 = "sha";
                        sb.append(msfUserInfo.getTinyid());
                        sb.append(".lz4");
                        str8 = sb.toString();
                    } catch (Throwable th) {
                        th = th;
                        str3 = str;
                        str2 = str5;
                        str4 = str11;
                        QLog.e(str4, 1, "uploadLogFile->error: " + IMFunc.getExceptionInfo(th));
                        get().logReport(str3, str2, BaseConstants.ERR_IO_OPERATION_FAILED, IMFunc.getExceptionInfo(th));
                        return false;
                    }
                }
                String str13 = Constants.URL_PATH_DELIMITER + 10002868 + Constants.URL_PATH_DELIMITER + "sdklog" + Constants.URL_PATH_DELIMITER + BaseConstants.IMSDK_NAME + Constants.URL_PATH_DELIMITER + str8;
                str9 = "http://" + "web.file.myqcloud.com/files/v1" + str13;
                if (TextUtils.isEmpty(relativePath)) {
                    randomAccessFile = new RandomAccessFile(filePath, "r");
                } else {
                    randomAccessFile = new RandomAccessFile(Environment.getExternalStorageDirectory().getPath() + Constants.URL_PATH_DELIMITER + relativePath, "r");
                }
                FileChannel channel = randomAccessFile.getChannel();
                long size = channel.size();
                if (size > logSize) {
                    randomAccessFile.seek(size - logSize);
                } else {
                    logSize = (long) ((int) size);
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ByteBuffer allocate = ByteBuffer.allocate(1024);
                while (true) {
                    long read = (long) channel.read(allocate);
                    if (read == -1) {
                        break;
                    }
                    allocate.flip();
                    byteArrayOutputStream.write(IMFunc.gzCompress(new String(allocate.array())));
                    allocate.clear();
                    j += read;
                    if (j >= logSize) {
                        break;
                    }
                }
                randomAccessFile.close();
                byteArrayOutputStream.close();
                byte[] paramBytes = IMFunc.getParamBytes(uuid, str7, str7, IMFunc.calcSHA(byteArrayOutputStream.toByteArray()));
                String str14 = str6;
                byte[] paramBytes2 = IMFunc.getParamBytes(uuid, str14, str14, "");
                byte[] paramBytes3 = IMFunc.getParamBytes(uuid, "filecontent", str8, byteArrayOutputStream.toByteArray());
                String str15 = str12;
                byte[] paramBytes4 = IMFunc.getParamBytes(uuid, str15, str15, "upload");
                byte[] bytes = ("--" + uuid + "--\r\n").getBytes();
                bArr = new byte[(paramBytes.length + paramBytes2.length + paramBytes3.length + paramBytes4.length + bytes.length)];
                System.arraycopy(paramBytes, 0, bArr, 0, paramBytes.length);
                System.arraycopy(paramBytes2, 0, bArr, paramBytes.length, paramBytes2.length);
                System.arraycopy(paramBytes3, 0, bArr, paramBytes.length + paramBytes2.length, paramBytes3.length);
                System.arraycopy(paramBytes4, 0, bArr, paramBytes.length + paramBytes2.length + paramBytes3.length, paramBytes4.length);
                System.arraycopy(bytes, 0, bArr, paramBytes.length + paramBytes2.length + paramBytes3.length + paramBytes4.length, bytes.length);
                hashMap = new HashMap();
                hashMap.put(HttpConstants.Header.AUTHORIZATION, IMFunc.appSignature(10002868, "AKIDIsvZoS8DRMqxDPh0wQ5B3sF6SlCINL0G", "8whnoADaf5USGpmmio7JATVQWrj5BaSz", 60, str13, "sdklog"));
                hashMap.put(HttpConstants.Header.CONTENT_TYPE, "multipart/form-data; boundary=" + uuid);
                str4 = str11;
            } catch (Throwable th2) {
                th = th2;
                str3 = str;
                str2 = logId;
                str4 = str11;
                QLog.e(str4, 1, "uploadLogFile->error: " + IMFunc.getExceptionInfo(th));
                get().logReport(str3, str2, BaseConstants.ERR_IO_OPERATION_FAILED, IMFunc.getExceptionInfo(th));
                return false;
            }
            try {
                QLog.i(str4, 1, "uploadLogFile->request: " + str9);
                str3 = str;
                str2 = str5;
                try {
                    IMFunc.httpPostReq(str9, bArr, hashMap, new bt(this, str8, str3, str2));
                    return true;
                } catch (Throwable th3) {
                    th = th3;
                    QLog.e(str4, 1, "uploadLogFile->error: " + IMFunc.getExceptionInfo(th));
                    get().logReport(str3, str2, BaseConstants.ERR_IO_OPERATION_FAILED, IMFunc.getExceptionInfo(th));
                    return false;
                }
            } catch (Throwable th4) {
                th = th4;
                str3 = str;
                str2 = str5;
                QLog.e(str4, 1, "uploadLogFile->error: " + IMFunc.getExceptionInfo(th));
                get().logReport(str3, str2, BaseConstants.ERR_IO_OPERATION_FAILED, IMFunc.getExceptionInfo(th));
                return false;
            }
        } catch (Throwable th5) {
            th = th5;
            str4 = TAG;
            str2 = logId;
            str3 = str;
            QLog.e(str4, 1, "uploadLogFile->error: " + IMFunc.getExceptionInfo(th));
            get().logReport(str3, str2, BaseConstants.ERR_IO_OPERATION_FAILED, IMFunc.getExceptionInfo(th));
            return false;
        }
    }
}
