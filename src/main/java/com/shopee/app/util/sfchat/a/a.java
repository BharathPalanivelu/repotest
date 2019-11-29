package com.shopee.app.util.sfchat.a;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.i;
import com.garena.android.appkit.tools.b;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.home.HomeActivity_;
import com.shopee.id.R;
import d.d.b.j;
import d.m;
import tencent.tls.platform.SigType;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26505a = new a();

    private a() {
    }

    public final void a(Context context) {
        j.b(context, "context");
        Intent intent = new Intent(context, HomeActivity_.class);
        intent.setFlags(SigType.TLS);
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        PendingIntent activity = PendingIntent.getActivity(context, 9123, intent, 134217728);
        Object systemService = context.getSystemService("notification");
        if (systemService != null) {
            ((NotificationManager) systemService).notify(547, new i.d(context, "SHOPEE_NOTIFY_ID").a((int) R.drawable.com_garena_shopee_logo_shopee_stat_white).a((CharSequence) b.e(R.string.sp_label_shopee_customer_service)).b((CharSequence) b.e(R.string.sp_label_cs_chat_notification_message)).a((i.g) new i.c()).a(activity).b());
            return;
        }
        throw new m("null cannot be cast to non-null type android.app.NotificationManager");
    }

    /* renamed from: com.shopee.app.util.sfchat.a.a$a  reason: collision with other inner class name */
    public static final class C0409a implements a.C0318a {
        public void onNegative() {
        }

        C0409a() {
        }

        public void onPositive() {
            com.shopee.app.util.sfchat.b.f26507a.a();
        }
    }

    public final void b(Context context) {
        j.b(context, "context");
        com.shopee.app.ui.dialog.a.a(context, (int) R.string.chat_end_dialog_title, (int) R.string.sp_label_end_chat_popup_message, (int) R.string.sp_label_cancel, (int) R.string.sp_label_yes, (a.C0318a) new C0409a());
    }
}
