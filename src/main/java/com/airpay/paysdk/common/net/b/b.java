package com.airpay.paysdk.common.net.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.airpay.paysdk.common.b.a;

public class b extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            a.a("BSConnectionReceiver error , intent=null", new Object[0]);
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            a.a("BSConnectionReceiver error , action=null", new Object[0]);
        } else if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            c.a().b();
        }
    }
}
