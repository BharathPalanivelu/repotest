package com.tencent.imsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.TIMLogLevel;
import com.tencent.imsdk.TIMManager;
import com.tencent.imsdk.TIMUser;
import com.tencent.imsdk.log.QLog;
import java.lang.reflect.Method;

public class BuglyUtils {
    private static final String TAG = "BuglyUtils";
    private static BuglyUtils instance = new BuglyUtils();
    private boolean isDebugModeEnabled = true;
    private boolean isEnabled = true;
    private boolean isInited = false;

    private BuglyUtils() {
    }

    public static BuglyUtils getInstance() {
        return instance;
    }

    public void init(Context context, boolean z, TIMUser tIMUser) {
        if (context == null) {
            this.isEnabled = false;
            return;
        }
        this.isEnabled = z;
        if (!this.isInited && this.isEnabled) {
            try {
                Class<?> cls = Class.forName("com.tencent.bugly.imsdk.crashreport.CrashReport");
                Method method = cls.getMethod("setSdkExtraData", new Class[]{Context.class, String.class, String.class});
                if (method != null) {
                    method.invoke((Object) null, new Object[]{context, BaseConstants.BUGLY_APP_ID, TIMManager.getInstance().getVersion()});
                }
                Method method2 = cls.getMethod("initCrashReport", new Class[]{Context.class, String.class, Boolean.TYPE});
                if (method2 != null) {
                    method2.invoke((Object) null, new Object[]{context, tIMUser.getAppIdAt3rd(), Boolean.valueOf(this.isDebugModeEnabled)});
                    this.isInited = true;
                    QLog.i(TAG, 1, "initUser imsdk bugly succ");
                }
                Method method3 = cls.getMethod("setUserId", new Class[]{String.class});
                if (method3 != null) {
                    method3.invoke((Object) null, new Object[]{tIMUser.getAppIdAt3rd() + "_" + tIMUser.getAccountType() + "_" + tIMUser.getIdentifier()});
                }
            } catch (Throwable th) {
                String str = TAG;
                QLog.e(str, 1, "enable crashreport failed|" + QLog.getStackTraceString(th));
            }
        }
    }

    public void log(TIMLogLevel tIMLogLevel, String str, String str2) {
        String str3;
        if (this.isEnabled) {
            try {
                if (tIMLogLevel == TIMLogLevel.DEBUG) {
                    str3 = "d";
                } else if (tIMLogLevel == TIMLogLevel.INFO) {
                    str3 = "i";
                } else if (tIMLogLevel == TIMLogLevel.WARN) {
                    str3 = "w";
                } else if (tIMLogLevel == TIMLogLevel.ERROR) {
                    str3 = "e";
                } else {
                    return;
                }
                Class<?> cls = Class.forName("com.tencent.bugly.imsdk.crashreport.BuglyLog");
                if (cls != null) {
                    cls.getMethod(str3, new Class[]{String.class, String.class}).invoke((Object) null, new Object[]{str, str2});
                }
            } catch (Throwable th) {
                String str4 = TAG;
                QLog.e(str4, 1, "logBugly failed|" + QLog.getStackTraceString(th));
            }
        }
    }

    public void setAvSDKVersionToBugly(Context context, String str, String str2) {
        if (this.isEnabled) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                QLog.e(TAG, 1, "setAvSDKVersionToBugly failed| invalid param");
                return;
            }
            try {
                Method method = Class.forName("com.tencent.bugly.imsdk.crashreport.CrashReport").getMethod("setSdkExtraData", new Class[]{Context.class, String.class, String.class});
                if (method != null) {
                    method.invoke((Object) null, new Object[]{context, str, str2});
                }
            } catch (Throwable th) {
                String str3 = TAG;
                QLog.e(str3, 1, "setAvSDKVersionToBugly failed|" + QLog.getStackTraceString(th));
            }
        }
    }

    public void setDebugModeEnabled(boolean z) {
        this.isDebugModeEnabled = z;
    }

    public void setEnabled(boolean z) {
        this.isEnabled = z;
    }
}
