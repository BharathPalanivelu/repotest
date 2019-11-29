package com.airpay.paysdk.base.c;

import com.airpay.paysdk.common.net.tcp.b.e;
import com.airpay.paysdk.common.net.tcp.b.f;
import java.util.concurrent.ConcurrentHashMap;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<Integer, c> f3798a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private e f3799b;

    /* renamed from: c  reason: collision with root package name */
    private f f3800c;

    public d a(e eVar) {
        this.f3799b = eVar;
        return this;
    }

    public d a(f fVar) {
        this.f3800c = fVar;
        return this;
    }

    public boolean a() {
        int d2 = this.f3800c.d();
        c cVar = this.f3798a.get(Integer.valueOf(d2));
        if (cVar == null) {
            cVar = a(d2);
            if (cVar == null) {
                return false;
            }
            this.f3798a.put(Integer.valueOf(d2), cVar);
        }
        return cVar.a(this.f3799b, this.f3800c);
    }

    private c a(int i) {
        if (i != 4) {
            return null;
        }
        return new e();
    }
}
