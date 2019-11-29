package com.shopee.app.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.d.a;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.store.p;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.h.m;
import com.shopee.app.pushnotification.NotificationDataBuilder;
import com.shopee.app.pushnotification.c;
import com.shopee.id.R;

public class FailedMessageBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private p f26120a;

    public void onReceive(Context context, Intent intent) {
        this.f26120a = new p();
        String stringExtra = intent.getStringExtra("reqID");
        a.b("Failed to send msg: " + stringExtra, new Object[0]);
        DBChatMessage a2 = this.f26120a.a(stringExtra);
        if (a2 != null && a2.k() == 1) {
            a(a2);
        }
    }

    private void a(DBChatMessage dBChatMessage) {
        dBChatMessage.f(2);
        this.f26120a.a(dBChatMessage);
        String str = "m/" + dBChatMessage.e();
        a(b.e(R.string.sp_chat_msg_failed_notification), str, c.b(str));
        b(dBChatMessage);
    }

    private void b(DBChatMessage dBChatMessage) {
        com.garena.android.appkit.b.b.a("CHAT_SEND_SUCCESS", new com.garena.android.appkit.b.a(com.shopee.app.d.b.a.a(dBChatMessage, m.a(dBChatMessage.h()))), b.a.NETWORK_BUS);
    }

    private void a(String str, String str2, Intent intent) {
        c.a(NotificationDataBuilder.notificationData().withId(8).ofType(8).withLaunchIntent(intent).withMessage(str).shouldKeepSilent(false).shouldStack(true).withMetadata(str2).build());
    }
}
