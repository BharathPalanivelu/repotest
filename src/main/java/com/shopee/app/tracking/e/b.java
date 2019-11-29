package com.shopee.app.tracking.e;

import android.text.TextUtils;
import com.garena.android.appkit.d.a;
import com.google.a.o;
import com.shopee.app.data.viewmodel.RedirectParameters;
import com.shopee.app.tracking.trackingv3.model.Info;
import com.shopee.app.tracking.trackingv3.model.TrackingEvent;
import com.shopee.app.tracking.trackingv3.model.UserActionV3;
import com.shopee.app.web.WebRegister;

public class b {
    public static void a(com.shopee.app.tracking.trackingv3.b bVar, String str, int i, String str2, long j) {
        bVar.a("push_notification", "", b(str, i, str2, j), "phone_notifications");
    }

    public static void a(String str, int i, String str2, long j) {
        UserActionV3.create(new TrackingEvent(Info.InfoBuilder.builder().withPageType("phone_notifications").withOperation("impression").withTargetType("push_notification").withData(b(str, i, str2, j)).build())).log();
    }

    private static o b(String str, int i, String str2, long j) {
        o oVar = new o();
        try {
            oVar.a("noticode", (Number) Integer.valueOf(i));
            oVar.a("destination_page", WebRegister.GSON.a((Object) a(str)));
            if (j != -1) {
                oVar.a("pn_received_time", (Number) Long.valueOf(j));
            }
            if (!TextUtils.isEmpty(str2)) {
                RedirectParameters redirectParameters = new RedirectParameters(str2.split(","));
                oVar.a("task_id", (Number) Integer.valueOf(redirectParameters.getTaskId()));
                oVar.a("action_id", (Number) Long.valueOf(redirectParameters.getActionId()));
            }
        } catch (Exception e2) {
            a.a(e2);
        }
        return oVar;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0030, code lost:
        if (r0.equals("home") != false) goto L_0x0050;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.shopee.app.tracking.e.a a(java.lang.String r9) throws java.lang.Exception {
        /*
            java.lang.String r0 = "\\?"
            java.lang.String[] r0 = r9.split(r0)
            r1 = 0
            r0 = r0[r1]
            java.util.HashMap r9 = com.shopee.app.util.aw.b((java.lang.String) r9)
            com.shopee.app.tracking.e.a r2 = new com.shopee.app.tracking.e.a
            r2.<init>()
            int r3 = r0.hashCode()
            java.lang.String r4 = "activity"
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            switch(r3) {
                case -1655966961: goto L_0x0047;
                case -1422950858: goto L_0x003d;
                case -1204214656: goto L_0x0033;
                case 3208415: goto L_0x002a;
                case 198298581: goto L_0x0020;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x004f
        L_0x0020:
            java.lang.String r1 = "actionbox"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004f
            r1 = 1
            goto L_0x0050
        L_0x002a:
            java.lang.String r3 = "home"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x004f
            goto L_0x0050
        L_0x0033:
            java.lang.String r1 = "appSystemSetting"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004f
            r1 = 2
            goto L_0x0050
        L_0x003d:
            java.lang.String r1 = "action"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004f
            r1 = 3
            goto L_0x0050
        L_0x0047:
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x004f
            r1 = 4
            goto L_0x0050
        L_0x004f:
            r1 = -1
        L_0x0050:
            if (r1 == 0) goto L_0x00ac
            java.lang.String r0 = "type"
            java.lang.String r3 = "notification_folder"
            if (r1 == r8) goto L_0x009d
            if (r1 == r7) goto L_0x009d
            if (r1 == r6) goto L_0x007e
            if (r1 == r5) goto L_0x005f
            return r2
        L_0x005f:
            r2.f19168a = r3
            com.google.a.o r1 = new com.google.a.o
            r1.<init>()
            r2.f19169b = r1
            java.lang.String r1 = "cat"
            java.lang.Object r9 = r9.get(r1)
            java.lang.String r9 = (java.lang.String) r9
            int r9 = java.lang.Integer.parseInt(r9)
            com.google.a.o r1 = r2.f19169b
            java.lang.String r9 = com.shopee.app.tracking.a.a.c(r9)
            r1.a((java.lang.String) r0, (java.lang.String) r9)
            return r2
        L_0x007e:
            r2.f19168a = r3
            com.google.a.o r1 = new com.google.a.o
            r1.<init>()
            r2.f19169b = r1
            java.lang.String r1 = "catid"
            java.lang.Object r9 = r9.get(r1)
            java.lang.String r9 = (java.lang.String) r9
            int r9 = java.lang.Integer.parseInt(r9)
            com.google.a.o r1 = r2.f19169b
            java.lang.String r9 = com.shopee.app.tracking.a.a.c(r9)
            r1.a((java.lang.String) r0, (java.lang.String) r9)
            return r2
        L_0x009d:
            r2.f19168a = r3
            com.google.a.o r9 = new com.google.a.o
            r9.<init>()
            r2.f19169b = r9
            com.google.a.o r9 = r2.f19169b
            r9.a((java.lang.String) r0, (java.lang.String) r4)
            return r2
        L_0x00ac:
            java.lang.String r0 = "apprl"
            java.lang.Object r9 = r9.get(r0)
            java.lang.String r9 = (java.lang.String) r9
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L_0x00bc
            r2.f19168a = r9
        L_0x00bc:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.tracking.e.b.a(java.lang.String):com.shopee.app.tracking.e.a");
    }
}
