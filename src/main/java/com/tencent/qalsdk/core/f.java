package com.tencent.qalsdk.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qalsdk.base.a;
import com.tencent.qalsdk.util.QLog;

final class f extends BroadcastReceiver {
    f() {
    }

    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (!TextUtils.isEmpty(action)) {
            String str = e.f32177a;
            QLog.d(str, 1, "onReceive broadcastreceiver.action = " + action);
            if (action.equals("android.intent.action.SCREEN_OFF")) {
                e.f32178b = false;
                n.i = -1;
                n.j.set(false);
                int i = e.f32179c + 1;
                e.f32179c = i;
                if (i == a.f32147a) {
                    e.a();
                }
            } else if (action.equals("android.intent.action.SCREEN_ON")) {
                e.f32178b = true;
            }
        } else if (QLog.isColorLevel()) {
            QLog.d(e.f32177a, 2, "onReceive broadcastreceiver.action null");
        }
    }
}
