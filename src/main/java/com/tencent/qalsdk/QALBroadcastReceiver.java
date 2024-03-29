package com.tencent.qalsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qalsdk.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class QALBroadcastReceiver extends BroadcastReceiver {
    private static Handler mainHandler = new Handler(Looper.getMainLooper());
    public static final String tag = "QALBroadcastReceiver";

    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            QLog.e(tag, "context or intent null");
            return;
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra("offlineMsgContent");
        String stringExtra = intent.getStringExtra("offlineMsgID");
        String stringExtra2 = intent.getStringExtra("offlineMsgCmd");
        QLog.d(tag, "userid:" + stringExtra + " cmd:" + stringExtra2);
        if (stringExtra2 == null) {
            QLog.i(tag, "userid:" + stringExtra + " cmd: null");
            return;
        }
        ConcurrentHashMap<String, QALOfflinePushListener> offLinePushListener = QALSDKManager.getInstance().getOffLinePushListener();
        if (offLinePushListener == null || !offLinePushListener.containsKey(stringExtra2)) {
            QLog.d(tag, 2, "offline push come,no callback ");
            return;
        }
        QALOfflinePushListener qALOfflinePushListener = offLinePushListener.get(stringExtra2);
        if (qALOfflinePushListener == null) {
            QLog.i(tag, stringExtra2 + " listener null");
            return;
        }
        mainHandler.post(new a(this, stringExtra, stringExtra2, byteArrayExtra, context, qALOfflinePushListener));
    }
}
