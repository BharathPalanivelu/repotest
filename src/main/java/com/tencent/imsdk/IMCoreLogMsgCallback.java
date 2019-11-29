package com.tencent.imsdk;

import com.tencent.imcore.ILogMsgCallback;
import com.tencent.imcore.LogLevel;

public class IMCoreLogMsgCallback extends ILogMsgCallback {
    private static String logTag = "imcore_jni";
    private TIMLogListener logListener;

    public IMCoreLogMsgCallback(TIMLogListener tIMLogListener) {
        this.logListener = tIMLogListener;
        swigReleaseOwnership();
    }

    public void onLogMsg(String str, LogLevel logLevel, String str2) {
        TIMLogListener tIMLogListener = this.logListener;
        if (tIMLogListener != null) {
            tIMLogListener.log(logLevel.swigValue(), str2, str);
        }
    }
}
