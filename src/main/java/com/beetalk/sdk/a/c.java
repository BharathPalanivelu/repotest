package com.beetalk.sdk.a;

import android.content.Context;
import com.garena.pay.android.a.a;
import com.garena.pay.android.c.a;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f5372a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f5373b = null;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public long f5374c = 0;

    public static c a() {
        if (f5372a == null) {
            synchronized (c.class) {
                if (f5372a == null) {
                    f5372a = new c();
                }
            }
        }
        return f5372a;
    }

    public void a(Context context, boolean z, a aVar, final a.C0138a.C0139a aVar2) {
        if (z || this.f5373b == null || System.currentTimeMillis() - this.f5374c > 60000) {
            com.garena.pay.android.c.a.c(new a.C0138a.C0139a() {
                public void a(String str) {
                    String unused = c.this.f5373b = str;
                    long unused2 = c.this.f5374c = System.currentTimeMillis();
                    aVar2.a(str);
                }

                public void a() {
                    aVar2.a();
                }
            }, aVar.a(context));
        } else {
            aVar2.a(this.f5373b);
        }
    }

    public void b() {
        this.f5374c = 0;
        this.f5373b = null;
    }
}
