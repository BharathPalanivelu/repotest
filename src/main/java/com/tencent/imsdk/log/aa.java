package com.tencent.imsdk.log;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.imsdk.BaseConstants;

final class aa extends BroadcastReceiver {
    aa() {
    }

    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (!TextUtils.isEmpty(action)) {
            String str = LogManager.tag;
            QLog.d(str, 1, "onReceive broadcastreceiver.action = " + action);
            if (action.equals("android.intent.action.SCREEN_OFF")) {
                LogManager.isScreenOn = false;
                int i = LogManager.screenOffCount + 1;
                LogManager.screenOffCount = i;
                if (i == BaseConstants.checkExpiresLogScreenOffCount) {
                    LogManager.delExpiresLog();
                }
            } else if (action.equals("android.intent.action.SCREEN_ON")) {
                LogManager.isScreenOn = true;
            }
        } else if (QLog.isColorLevel()) {
            QLog.d(LogManager.tag, 2, "onReceive broadcastreceiver.action null");
        }
    }
}
