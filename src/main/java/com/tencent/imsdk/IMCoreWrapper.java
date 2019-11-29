package com.tencent.imsdk;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.imcore.IMCore;
import com.tencent.imcore.SWIGTYPE_p_void;
import com.tencent.imcore.internalJNI;
import com.tencent.imsdk.log.QLog;
import com.tencent.qalsdk.QALSDKManager;
import tencent.tls.platform.TLSLoginHelper;

public class IMCoreWrapper {
    static IMCoreWrapper inst = new IMCoreWrapper();
    private static final String tag = "imsdk.IMCoreWrapper";
    private boolean isIMCoreInited = false;
    private boolean isIMCoreUserInited = false;

    private IMCoreWrapper() {
    }

    public static IMCoreWrapper get() {
        return inst;
    }

    static SWIGTYPE_p_void getFrdManagerExt(String str) {
        try {
            return (SWIGTYPE_p_void) Class.forName("com.tencent.imsdk.ext.sns.IMSnsExtBridge").getMethod("getFrdManagerExt", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    static SWIGTYPE_p_void getGrpManagerExt(String str) {
        try {
            return (SWIGTYPE_p_void) Class.forName("com.tencent.imsdk.ext.group.IMGroupExtBridge").getMethod("getGrpManagerExt", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    static SWIGTYPE_p_void getMsgManagerExt(String str) {
        try {
            return (SWIGTYPE_p_void) Class.forName("com.tencent.imsdk.ext.message.IMMsgExtBridge").getMethod("getMsgManagerExt", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private boolean loadCppRuntime() {
        if (!loadLibrary("gnustl_shared")) {
            return false;
        }
        QLog.i(tag, 1, "LoadLibrary|4-End|succ, " + "gnustl_shared");
        return true;
    }

    private boolean loadECExtLib() {
        try {
            if (Class.forName("com.tencent.imcore.ECExtHelper") != null) {
                if (loadLibrary("_imcore_ec_ext_gyp")) {
                    try {
                        QLog.i(tag, 1, "LoadLibrary|3-MethodTest|succ, " + "_imcore_ec_ext_gyp");
                        QLog.i(tag, 1, "LoadLibrary|4-End|succ, " + "_imcore_ec_ext_gyp");
                    } catch (Throwable th) {
                        QLog.e(tag, 1, IMFunc.getExceptionInfo(th));
                        QLog.i(tag, 1, "LoadLibrary|3-MethodTest|failed, " + "_imcore_ec_ext_gyp");
                    }
                }
                return false;
            }
        } catch (ClassNotFoundException unused) {
        }
        return true;
    }

    private boolean loadGroupExtLib() {
        try {
            if (Class.forName("com.tencent.imcore.GroupExtHelper") != null) {
                if (loadLibrary("_imcore_group_ext_gyp")) {
                    try {
                        QLog.i(tag, 1, "LoadLibrary|3-MethodTest|succ, " + "_imcore_group_ext_gyp");
                        QLog.i(tag, 1, "LoadLibrary|4-End|succ, " + "_imcore_group_ext_gyp");
                    } catch (Throwable th) {
                        QLog.e(tag, 1, IMFunc.getExceptionInfo(th));
                        QLog.i(tag, 1, "LoadLibrary|3-MethodTest|failed, " + "_imcore_group_ext_gyp");
                    }
                }
                return false;
            }
        } catch (ClassNotFoundException unused) {
        }
        return true;
    }

    private boolean loadLibrary(String str) {
        String str2;
        QLog.i(tag, 1, "LoadLibrary|1-Begin|succ, lib: " + str);
        try {
            String soLibPath = IMMsfCoreProxy.get().getSdkConfig().getSoLibPath();
            if (TextUtils.isEmpty(soLibPath)) {
                System.loadLibrary(str);
                str2 = "LoadLibrary|2-Loading|system load " + str + " succ";
            } else {
                System.load(soLibPath + ("lib" + str + ".so"));
                str2 = "LoadLibrary|2-Loading|system load " + str + " succ, from [" + soLibPath + "]";
            }
            QLog.i(tag, 1, str2);
            return true;
        } catch (Throwable th) {
            QLog.e(tag, 1, "LoadLibrary|2-Loading|system load " + str + " failed\n" + IMFunc.getExceptionInfo(th));
            return false;
        }
    }

    private boolean loadLiteLib() {
        if (loadLibrary("_imcore_jni_gyp")) {
            try {
                internalJNI.new_INotify();
                internalJNI.IMCore_get();
                internalJNI.new_Context();
                internalJNI.new_IEnv();
                internalJNI.new_SdkReportItem();
                QLog.i(tag, 1, "LoadLibrary|3-MethodTest|succ, " + "_imcore_jni_gyp");
                QLog.i(tag, 1, "LoadLibrary|4-End|succ, " + "_imcore_jni_gyp");
                return true;
            } catch (Throwable th) {
                QLog.e(tag, 1, IMFunc.getExceptionInfo(th));
                QLog.i(tag, 1, "LoadLibrary|3-MethodTest|failed, " + "_imcore_jni_gyp");
            }
        }
        return false;
    }

    private boolean loadMsgExtLib() {
        try {
            if (Class.forName("com.tencent.imcore.MsgExtHelper") != null) {
                if (loadLibrary("_imcore_msg_ext_gyp")) {
                    try {
                        QLog.i(tag, 1, "LoadLibrary|3-MethodTest|succ, " + "_imcore_msg_ext_gyp");
                        QLog.i(tag, 1, "LoadLibrary|4-End|succ, " + "_imcore_msg_ext_gyp");
                    } catch (Throwable th) {
                        QLog.e(tag, 1, IMFunc.getExceptionInfo(th));
                        QLog.i(tag, 1, "LoadLibrary|3-MethodTest|failed, " + "_imcore_msg_ext_gyp");
                    }
                }
                return false;
            }
        } catch (ClassNotFoundException unused) {
        }
        return true;
    }

    private boolean loadSnsExtLib() {
        try {
            if (Class.forName("com.tencent.imcore.FriendExtHelper") != null) {
                if (loadLibrary("_imcore_sns_ext_gyp")) {
                    try {
                        QLog.i(tag, 1, "LoadLibrary|3-MethodTest|succ, " + "_imcore_sns_ext_gyp");
                        QLog.i(tag, 1, "LoadLibrary|4-End|succ, " + "_imcore_sns_ext_gyp");
                    } catch (Throwable th) {
                        QLog.e(tag, 1, IMFunc.getExceptionInfo(th));
                        QLog.i(tag, 1, "LoadLibrary|3-MethodTest|failed, " + "_imcore_sns_ext_gyp");
                    }
                }
                return false;
            }
        } catch (ClassNotFoundException unused) {
        }
        return true;
    }

    private boolean loadUGCExtLib() {
        try {
            if (Class.forName("com.tencent.imcore.UGCExtHelper") != null) {
                if (loadLibrary("_imcore_ugc_ext_gyp")) {
                    try {
                        QLog.i(tag, 1, "LoadLibrary|3-MethodTest|succ, " + "_imcore_ugc_ext_gyp");
                        QLog.i(tag, 1, "LoadLibrary|4-End|succ, " + "_imcore_ugc_ext_gyp");
                    } catch (Throwable th) {
                        QLog.e(tag, 1, IMFunc.getExceptionInfo(th));
                        QLog.i(tag, 1, "LoadLibrary|3-MethodTest|failed, " + "_imcore_ugc_ext_gyp");
                    }
                }
                return false;
            }
        } catch (ClassNotFoundException unused) {
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void loginSyncAndCacheCleanup(String str) {
        new Thread(new at(this, str)).start();
    }

    public boolean initIMCore(Context context, TIMSdkConfig tIMSdkConfig) {
        com.tencent.imcore.Context context2 = new com.tencent.imcore.Context();
        context2.setMajor_ver("3.3.2");
        context2.setRevision_ver("13740.13759");
        context2.setEnv(IMCoreAndroidEnv.get());
        context2.setLog_file_name(BaseConstants.IMSDK_NAME);
        context2.setLog_path(tIMSdkConfig.getLogPath());
        context2.setPrint_log(tIMSdkConfig.isLogPrintEnabled());
        context2.setLog_lvl(tIMSdkConfig.getLogLevel().getDescr());
        context2.setLog_cb_lvl(tIMSdkConfig.getLogCallbackLevel().getDescr());
        context2.setLog_cb(tIMSdkConfig.getLogListener() != null ? new IMCoreLogMsgCallback(tIMSdkConfig.getLogListener()) : null);
        context2.setData_dir(context.getFilesDir().toString());
        context2.setFile_cache_path(context.getCacheDir().toString());
        context2.setPic_cache_path(context.getCacheDir().toString());
        String gatewayIp = QALSDKManager.getInstance().getGatewayIp();
        if (TextUtils.isEmpty(gatewayIp)) {
            gatewayIp = "";
        }
        context2.setIp(gatewayIp);
        context2.setBid((long) QALSDKManager.getInstance().getQalAppId());
        context2.setMm_guard(getMsgManagerExt(""));
        context2.setFm_guard(getFrdManagerExt(""));
        context2.setGrp_guard(getGrpManagerExt(""));
        try {
            IMCore.get().initOpenIM(context2);
            this.isIMCoreInited = true;
            return true;
        } catch (Throwable th) {
            IMMsfCoreProxy.get().setMode(0);
            QLog.e(tag, 1, "init IMCore failed, setMode 0\n" + QLog.getStackTraceString(th));
            return false;
        }
    }

    public boolean initUser(Context context, TIMUser tIMUser, TIMCallBack tIMCallBack) {
        QLog.i(tag, 1, "welcome to imsdk, version: " + TIMManager.getInstanceById(tIMUser.getIdentifier()).getVersion());
        this.isIMCoreUserInited = false;
        try {
            IMMsfUserInfo msfUserInfo = IMMsfCoreProxy.get().getMsfUserInfo(tIMUser.getIdentifier());
            if (msfUserInfo == null) {
                QLog.e(tag, 1, "Login|4-InitIMCore|Fail| init failed, user not found:" + tIMUser.getIdentifier());
                IMMsfCoreProxy.loginErrOnMainthread(tIMCallBack, BaseConstants.ERR_SDK_NOT_LOGGED_IN, "current user not login. id: " + tIMUser.getIdentifier());
                return false;
            }
            long servetTimeSecondInterv = QALSDKManager.getInstance().getServetTimeSecondInterv();
            IMCore.get().refreshSvrDiff(servetTimeSecondInterv);
            IMCore.get().refreshA2((byte[]) TLSLoginHelper.getInstance().getSSOTicket(msfUserInfo.getUser().getIdentifier()).get("A2"));
            QLog.i(tag, 1, "servertimediff: " + servetTimeSecondInterv);
            ar arVar = new ar(this, tIMCallBack, tIMUser);
            TIMManager.getInstance().getUserConfig().setUser(tIMUser);
            if (IMCore.get().initUser(TIMManager.getInstance().getUserConfig().convertTo(), arVar) == 0) {
                IMMsfCoreProxy.loginErrOnMainthread(tIMCallBack, BaseConstants.ERR_DATABASE_OPERATE_FAILED, "local database operation failed!");
            } else {
                TIMManager.getInstanceById(tIMUser.getIdentifier()).setCoreUser(IMCore.get().getUser(msfUserInfo.getIdentifier()));
            }
            return true;
        } catch (Throwable th) {
            this.isIMCoreUserInited = false;
            IMErrInfo iMErrInfo = new IMErrInfo(BaseConstants.ERR_INIT_CORE_FAIL, QLog.getStackTraceString(th));
            QLog.e(tag, 1, "Login|4-InitIMCore|Fail|init failed, exception: " + iMErrInfo.getMsg());
            IMMsfCoreProxy.loginErrOnMainthread(tIMCallBack, iMErrInfo.getCode(), iMErrInfo.getMsg());
            return false;
        }
    }

    public boolean isIMCoreInited() {
        return this.isIMCoreInited;
    }

    public boolean isIMCoreUserInited() {
        return this.isIMCoreUserInited;
    }

    public boolean loadLib() {
        return loadCppRuntime() && loadLiteLib() && loadMsgExtLib() && loadSnsExtLib() && loadGroupExtLib() && loadUGCExtLib() && loadECExtLib();
    }

    public void setIMCoreInited() {
        this.isIMCoreInited = true;
    }

    public void setIMCoreUserInited(boolean z) {
        this.isIMCoreUserInited = z;
    }
}
