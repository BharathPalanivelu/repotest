package com.tencent.imsdk.log;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.imsdk.IMMsfCoreProxy;

public class LogManager {
    static boolean isInited = false;
    static boolean isScreenOn = true;
    private static final BroadcastReceiver mReceiver = new aa();
    static int screenOffCount = 0;
    static String tag = "MSF.C.LogManager";

    /* access modifiers changed from: private */
    public static void delExpiresLog() {
        ab abVar = new ab();
        abVar.setName("imsdkDelLogThread");
        abVar.start();
    }

    public static synchronized void init() {
        synchronized (LogManager.class) {
            if (!isInited) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                IMMsfCoreProxy.get().getContext().registerReceiver(mReceiver, intentFilter);
                QLog.i(tag, 1, "LogManager inited.");
                isInited = true;
            }
        }
    }
}
