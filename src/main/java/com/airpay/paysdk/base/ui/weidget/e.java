package com.airpay.paysdk.base.ui.weidget;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.TextView;
import com.airpay.paysdk.base.interfaces.ILoadingView;
import com.airpay.paysdk.c;

public class e extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private Handler f3926a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private ILoadingView f3927b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f3928c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public long f3929d = -1;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f3930e = false;

    /* renamed from: f  reason: collision with root package name */
    private final Runnable f3931f = new Runnable() {
        public void run() {
            boolean unused = e.this.f3930e = false;
            long unused2 = e.this.f3929d = -1;
            try {
                e.this.dismiss();
            } catch (Exception unused3) {
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f3932g = false;
    /* access modifiers changed from: private */
    public boolean h = false;
    /* access modifiers changed from: private */
    public boolean i = false;
    private final Runnable j = new Runnable() {
        public void run() {
            boolean unused = e.this.f3932g = false;
            if (!e.this.i && !e.this.h) {
                long unused2 = e.this.f3929d = System.currentTimeMillis();
                e.this.show();
            }
        }
    };
    private e k;

    public e(Activity activity) {
        super(activity, c.j.com_garena_beepay_dialog_transparent);
        a();
        this.f3927b = (ILoadingView) findViewById(c.f.com_garena_beepay_loading_view);
        this.f3928c = (TextView) findViewById(c.f.com_garena_beepay_txt_loading);
    }

    /* access modifiers changed from: protected */
    public void a() {
        setContentView(c.h.com_garena_beepay_operation_view);
    }

    public void hide() {
        this.i = true;
        this.f3927b.changeLoadingState(false);
        super.hide();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r10 = this;
            r0 = 1
            r10.h = r0     // Catch:{ Exception -> 0x0033 }
            android.os.Handler r1 = r10.f3926a     // Catch:{ Exception -> 0x0033 }
            java.lang.Runnable r2 = r10.j     // Catch:{ Exception -> 0x0033 }
            r1.removeCallbacks(r2)     // Catch:{ Exception -> 0x0033 }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0033 }
            long r3 = r10.f3929d     // Catch:{ Exception -> 0x0033 }
            long r1 = r1 - r3
            r3 = 400(0x190, double:1.976E-321)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x002f
            long r5 = r10.f3929d     // Catch:{ Exception -> 0x0033 }
            r7 = -1
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0020
            goto L_0x002f
        L_0x0020:
            boolean r5 = r10.f3930e     // Catch:{ Exception -> 0x0033 }
            if (r5 != 0) goto L_0x0042
            android.os.Handler r5 = r10.f3926a     // Catch:{ Exception -> 0x0033 }
            java.lang.Runnable r6 = r10.f3931f     // Catch:{ Exception -> 0x0033 }
            long r3 = r3 - r1
            r5.postDelayed(r6, r3)     // Catch:{ Exception -> 0x0033 }
            r10.f3930e = r0     // Catch:{ Exception -> 0x0033 }
            goto L_0x0042
        L_0x002f:
            r10.dismiss()     // Catch:{ Exception -> 0x0033 }
            goto L_0x0042
        L_0x0033:
            r1 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r2 = 0
            java.lang.String r1 = r1.getMessage()
            r0[r2] = r1
            java.lang.String r1 = "BBOperationView"
            com.airpay.paysdk.common.b.a.a(r1, r0)
        L_0x0042:
            com.airpay.paysdk.base.ui.weidget.e r0 = r10.k
            if (r0 == 0) goto L_0x004c
            r0.b()
            r0 = 0
            r10.k = r0
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airpay.paysdk.base.ui.weidget.e.b():void");
    }

    public void a(boolean z) {
        setCanceledOnTouchOutside(z);
        setCancelable(z);
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f3928c.setText(str);
        }
    }

    public void c() {
        if (!this.i) {
            this.f3929d = -1;
            this.h = false;
            this.f3926a.removeCallbacks(this.f3931f);
            if (!this.f3932g) {
                this.f3926a.postDelayed(this.j, 200);
                this.f3932g = true;
            }
        }
    }

    public void show() {
        super.show();
        this.f3927b.changeLoadingState(true);
    }

    public void dismiss() {
        this.f3927b.changeLoadingState(false);
        super.dismiss();
    }
}
