package com.airpay.paysdk.common.net.b;

import android.content.Context;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.List;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f3988a;

    /* renamed from: b  reason: collision with root package name */
    private final List<a> f3989b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private b f3990c;

    private c() {
    }

    public static c a() {
        if (f3988a == null) {
            synchronized (c.class) {
                if (f3988a == null) {
                    f3988a = new c();
                }
            }
        }
        return f3988a;
    }

    public void a(a aVar) {
        if (!this.f3989b.contains(aVar)) {
            this.f3989b.add(aVar);
        }
    }

    public void b() {
        for (a a2 : this.f3989b) {
            a2.a();
        }
    }

    public void a(Context context) {
        this.f3989b.clear();
        b bVar = this.f3990c;
        if (bVar != null && context != null) {
            context.unregisterReceiver(bVar);
            this.f3990c = null;
        }
    }

    public void b(Context context) {
        if (this.f3990c == null && context == null) {
            this.f3990c = new b();
            context.registerReceiver(this.f3990c, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }
}
