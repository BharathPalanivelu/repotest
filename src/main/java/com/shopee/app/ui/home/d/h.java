package com.shopee.app.ui.home.d;

import com.facebook.internal.NativeProtocol;
import com.shopee.app.tracking.a;
import com.shopee.app.tracking.trackingv3.b;
import com.shopee.app.ui.home.c;
import com.shopee.app.ui.webview.WebPageActivity_;
import com.shopee.app.util.aw;

public class h extends b {

    /* renamed from: a  reason: collision with root package name */
    private final a f22177a;

    /* renamed from: b  reason: collision with root package name */
    private final c f22178b;

    /* renamed from: c  reason: collision with root package name */
    private final aw f22179c;

    /* renamed from: d  reason: collision with root package name */
    private final b f22180d;

    public h(c cVar, aw awVar, a aVar, b bVar) {
        this.f22178b = cVar;
        this.f22179c = awVar;
        this.f22177a = aVar;
        this.f22180d = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Intent r13, int r14) {
        /*
            r12 = this;
            if (r13 != 0) goto L_0x0003
            return
        L_0x0003:
            com.shopee.app.ui.home.c r14 = r12.f22178b
            com.shopee.app.ui.home.m r14 = r14.p()
            if (r14 != 0) goto L_0x000c
            return
        L_0x000c:
            java.lang.String r0 = "httpURL"
            java.lang.String r0 = r13.getStringExtra(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0028
            java.util.regex.Pattern r1 = android.util.Patterns.WEB_URL
            java.util.regex.Matcher r1 = r1.matcher(r0)
            boolean r1 = r1.matches()
            if (r1 == 0) goto L_0x0028
            r12.b(r0)
            return
        L_0x0028:
            java.lang.String r0 = "redirect"
            java.lang.String r1 = r13.getStringExtra(r0)
            r2 = 0
            java.lang.String r3 = "tabPosition"
            int r3 = r13.getIntExtra(r3, r2)
            java.lang.String r4 = "notification"
            android.os.Bundle r4 = r13.getBundleExtra(r4)
            r5 = 0
            if (r4 == 0) goto L_0x0063
            java.lang.String r6 = ""
            java.lang.String r0 = r4.getString(r0, r6)
            boolean r4 = r0.isEmpty()
            if (r4 != 0) goto L_0x0063
            java.lang.String r4 = ","
            java.lang.String[] r0 = r0.split(r4)     // Catch:{ Exception -> 0x005c }
            com.shopee.app.data.viewmodel.RedirectParameters r4 = new com.shopee.app.data.viewmodel.RedirectParameters     // Catch:{ Exception -> 0x005c }
            r4.<init>(r0)     // Catch:{ Exception -> 0x005c }
            java.lang.String r1 = r4.getPath()     // Catch:{ Exception -> 0x005a }
            goto L_0x0061
        L_0x005a:
            r0 = move-exception
            goto L_0x005e
        L_0x005c:
            r0 = move-exception
            r4 = r5
        L_0x005e:
            com.garena.android.appkit.d.a.a(r0)
        L_0x0061:
            r7 = r1
            goto L_0x0065
        L_0x0063:
            r7 = r1
            r4 = r5
        L_0x0065:
            r14.setSelectedIndex(r3)
            com.shopee.app.ui.home.c r14 = r12.f22178b
            r14.f7012a = r3
            com.shopee.app.util.aw r0 = r12.f22179c
            com.shopee.app.ui.home.m r14 = r14.p()
            r0.a(r14, r7, r4)
            com.shopee.app.ui.home.c r14 = r12.f22178b
            r14.f7013b = r5
            java.lang.String r14 = "KEY_FROM_NOTI"
            boolean r14 = r13.getBooleanExtra(r14, r2)
            if (r14 == 0) goto L_0x009b
            r14 = -1
            java.lang.String r0 = "KEY_PUSH_NOTI_CODE"
            int r8 = r13.getIntExtra(r0, r14)
            java.lang.String r14 = "KEY_PUSH_NOTI_PARAMS"
            java.lang.String r9 = r13.getStringExtra(r14)
            r0 = -1
            java.lang.String r14 = "KEY_RECEIVED_TIME"
            long r10 = r13.getLongExtra(r14, r0)
            com.shopee.app.tracking.trackingv3.b r6 = r12.f22180d
            com.shopee.app.tracking.e.b.a(r6, r7, r8, r9, r10)
        L_0x009b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.home.d.h.a(android.content.Intent, int):void");
    }

    public void a(String str) {
        this.f22179c.a(this.f22178b.p(), str);
        this.f22178b.f7013b = null;
    }

    private void b(String str) {
        ((WebPageActivity_.a) WebPageActivity_.a(this.f22178b.a()).b(str).k(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)).a();
    }
}
