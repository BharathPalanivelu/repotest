package com.tencent.imsdk;

import android.text.TextUtils;
import com.appsflyer.share.Constants;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.imsdk.utils.BuglyUtils;

public class TIMSdkConfig {
    private String accoutType = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private String appidAt3rd = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private boolean isCrashReportEnabled = true;
    private boolean isLogPrintEnabled = true;
    private TIMLogLevel logCallbackLevel = TIMLogLevel.DEBUG;
    private TIMLogLevel logLevel = TIMLogLevel.DEBUG;
    private TIMLogListener logListener;
    private String logPath = "";
    private int sdkAppId;
    private String soLibPath = "";

    public TIMSdkConfig(int i) {
        this.sdkAppId = i;
    }

    public TIMSdkConfig enableCrashReport(boolean z) {
        this.isCrashReportEnabled = z;
        BuglyUtils.getInstance().setEnabled(this.isCrashReportEnabled);
        return this;
    }

    public TIMSdkConfig enableLogPrint(boolean z) {
        this.isLogPrintEnabled = z;
        return this;
    }

    public String getAccoutType() {
        return this.accoutType;
    }

    public String getAppidAt3rd() {
        return this.appidAt3rd;
    }

    public TIMLogLevel getLogCallbackLevel() {
        return this.logCallbackLevel;
    }

    public TIMLogLevel getLogLevel() {
        return this.logLevel;
    }

    public TIMLogListener getLogListener() {
        return this.logListener;
    }

    public String getLogPath() {
        return this.logPath;
    }

    public int getSdkAppId() {
        return this.sdkAppId;
    }

    public String getSoLibPath() {
        return this.soLibPath;
    }

    public boolean isCrashReportEnabled() {
        return this.isCrashReportEnabled;
    }

    public boolean isLogPrintEnabled() {
        return this.isLogPrintEnabled;
    }

    public TIMSdkConfig setAccoutType(String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.accoutType = str;
        return this;
    }

    public TIMSdkConfig setAppidAt3rd(String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.appidAt3rd = str;
        return this;
    }

    public TIMSdkConfig setLogCallbackLevel(TIMLogLevel tIMLogLevel) {
        if (tIMLogLevel == null) {
            return this;
        }
        this.logCallbackLevel = tIMLogLevel;
        return this;
    }

    public TIMSdkConfig setLogLevel(TIMLogLevel tIMLogLevel) {
        if (tIMLogLevel == null) {
            return this;
        }
        this.logLevel = tIMLogLevel;
        return this;
    }

    public TIMSdkConfig setLogListener(TIMLogListener tIMLogListener) {
        this.logListener = tIMLogListener;
        return this;
    }

    public TIMSdkConfig setLogPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.logPath = str;
        return this;
    }

    public TIMSdkConfig setSoLibPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.soLibPath = str;
        if (this.soLibPath.charAt(str.length() - 1) != '/') {
            this.soLibPath += Constants.URL_PATH_DELIMITER;
        }
        return this;
    }
}
