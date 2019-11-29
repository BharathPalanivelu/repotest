package com.shopee.app.ui.auth.phone;

import android.content.BroadcastReceiver;
import android.content.Context;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.shopee.app.g.q;
import d.d.b.j;

public final class SmsOtpReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final a f19679a = new a((g) null);

    public static final boolean a(Context context) {
        return f19679a.a(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
        if (r5 != null) goto L_0x004c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r5, android.content.Intent r6) {
        /*
            r4 = this;
            r5 = 0
            if (r6 == 0) goto L_0x0008
            java.lang.String r0 = r6.getAction()
            goto L_0x0009
        L_0x0008:
            r0 = r5
        L_0x0009:
            java.lang.String r1 = "com.google.android.gms.auth.api.phone.SMS_RETRIEVED"
            boolean r0 = d.d.b.j.a((java.lang.Object) r1, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0078
            android.os.Bundle r6 = r6.getExtras()
            java.lang.String r0 = "com.google.android.gms.auth.api.phone.EXTRA_STATUS"
            java.lang.Object r0 = r6.get(r0)
            if (r0 == 0) goto L_0x0070
            com.google.android.gms.common.api.Status r0 = (com.google.android.gms.common.api.Status) r0
            int r0 = r0.getStatusCode()
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0029
            r6 = r1
            goto L_0x0033
        L_0x0029:
            java.lang.String r0 = "com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE"
            java.lang.Object r6 = r6.get(r0)
            if (r6 == 0) goto L_0x0068
            java.lang.String r6 = (java.lang.String) r6
        L_0x0033:
            d.h.k r0 = new d.h.k
            java.lang.String r2 = "[0-9]{6}"
            r0.<init>((java.lang.String) r2)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r2 = 0
            r3 = 2
            d.h.i r5 = d.h.k.a(r0, r6, r2, r3, r5)
            if (r5 == 0) goto L_0x004b
            java.lang.String r5 = r5.a()
            if (r5 == 0) goto L_0x004b
            goto L_0x004c
        L_0x004b:
            r5 = r1
        L_0x004c:
            com.shopee.app.application.ar r6 = com.shopee.app.application.ar.f()
            java.lang.String r0 = "ShopeeApplication.get()"
            d.d.b.j.a((java.lang.Object) r6, (java.lang.String) r0)
            com.shopee.app.appuser.UserComponent r6 = r6.e()
            com.shopee.app.util.n r6 = r6.dataEventBus()
            com.garena.android.appkit.b.a r0 = new com.garena.android.appkit.b.a
            r0.<init>(r5)
            java.lang.String r5 = "OTP_RECEIVED"
            r6.a((java.lang.String) r5, (com.garena.android.appkit.b.a) r0)
            goto L_0x0078
        L_0x0068:
            d.m r5 = new d.m
            java.lang.String r6 = "null cannot be cast to non-null type kotlin.String"
            r5.<init>(r6)
            throw r5
        L_0x0070:
            d.m r5 = new d.m
            java.lang.String r6 = "null cannot be cast to non-null type com.google.android.gms.common.api.Status"
            r5.<init>(r6)
            throw r5
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.auth.phone.SmsOtpReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final boolean a(Context context) {
            j.b(context, "context");
            if (!q.a()) {
                return false;
            }
            SmsRetriever.getClient(context).startSmsRetriever();
            return true;
        }
    }
}
