package com.shopee.app.ui.home.d;

import android.text.TextUtils;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.store.al;
import com.shopee.app.ui.home.c;
import com.shopee.app.ui.home.m;
import com.shopee.app.util.ShopeeInstallReceiver;
import com.shopee.app.util.ak;

public class e extends b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final al f22156a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ak f22157b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final c f22158c;

    /* renamed from: d  reason: collision with root package name */
    private i f22159d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f22160e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f22161f = false;

    /* renamed from: g  reason: collision with root package name */
    private Runnable f22162g = new Runnable() {
        public void run() {
            if (!e.this.f22158c.isFinishing() && !e.this.f22160e) {
                boolean unused = e.this.f22160e = true;
                String a2 = e.a(ShopeeInstallReceiver.f26121a);
                if (TextUtils.isEmpty(a2)) {
                    e.this.f22157b.ab();
                    return;
                }
                c a3 = e.this.f22158c;
                a3.d(a2 + "&indicator=splash");
                e.this.f22156a.i();
            }
        }
    };

    public e(c cVar, al alVar, ak akVar) {
        this.f22158c = cVar;
        this.f22156a = alVar;
        this.f22157b = akVar;
        this.f22159d = b.a(this);
    }

    public boolean a() {
        m p = this.f22158c.p();
        if (this.f22156a.h() || p == null) {
            return false;
        }
        if (TextUtils.isEmpty(ShopeeInstallReceiver.f26121a)) {
            p.postDelayed(this.f22162g, 600);
            return true;
        }
        this.f22162g.run();
        return true;
    }

    public void g() {
        this.f22161f = true;
        String a2 = a(ShopeeInstallReceiver.f26121a);
        if (!TextUtils.isEmpty(a2)) {
            c cVar = this.f22158c;
            cVar.d(a2 + "&indicator=threeDots");
            this.f22156a.i();
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r6) {
        /*
            java.lang.String r0 = "version"
            java.lang.String r1 = "af_sub1"
            boolean r2 = android.text.TextUtils.isEmpty(r6)
            r3 = 0
            if (r2 == 0) goto L_0x000c
            return r3
        L_0x000c:
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{  }
            r2.<init>()     // Catch:{  }
            java.lang.String r6 = com.shopee.app.util.bm.b(r6)     // Catch:{  }
            com.shopee.app.util.bm.a((java.lang.String) r6, (java.util.Map<java.lang.String, java.lang.String>) r2)     // Catch:{  }
            boolean r6 = r2.containsKey(r1)     // Catch:{  }
            if (r6 == 0) goto L_0x0056
            java.lang.String r6 = new java.lang.String     // Catch:{  }
            java.lang.Object r1 = r2.get(r1)     // Catch:{  }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{  }
            r2 = 0
            byte[] r1 = android.util.Base64.decode(r1, r2)     // Catch:{  }
            r6.<init>(r1)     // Catch:{  }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{  }
            r1.<init>()     // Catch:{  }
            java.lang.String r2 = "\\?"
            java.lang.String[] r2 = r6.split(r2)     // Catch:{  }
            int r4 = r2.length     // Catch:{  }
            r5 = 2
            if (r4 < r5) goto L_0x0056
            r4 = 1
            r2 = r2[r4]     // Catch:{  }
            com.shopee.app.util.bm.a((java.lang.String) r2, (java.util.Map<java.lang.String, java.lang.String>) r1)     // Catch:{  }
            boolean r2 = r1.containsKey(r0)     // Catch:{  }
            if (r2 == 0) goto L_0x0056
            java.lang.Object r0 = r1.get(r0)     // Catch:{ Throwable -> 0x0056 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Throwable -> 0x0056 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Throwable -> 0x0056 }
            if (r0 != r4) goto L_0x0056
            return r6
        L_0x0056:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.home.d.e.a(java.lang.String):java.lang.String");
    }

    public void c() {
        super.c();
        this.f22159d.c();
    }

    public void b() {
        super.b();
        this.f22159d.d();
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        this.f22160e = true;
        if (!this.f22161f) {
            String a2 = a(str);
            if (!TextUtils.isEmpty(a2)) {
                c cVar = this.f22158c;
                cVar.d(a2 + "&indicator=threeDots");
                this.f22156a.i();
            }
        }
    }
}
