package com.shopee.app.ui.product.attributes;

import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.ax;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.af;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import java.util.List;

public class k extends q<q> {

    /* renamed from: a  reason: collision with root package name */
    private final i f24295a = b.a(this);

    /* renamed from: c  reason: collision with root package name */
    private final n f24296c;

    /* renamed from: d  reason: collision with root package name */
    private final bi f24297d;

    /* renamed from: e  reason: collision with root package name */
    private final ax f24298e;

    /* renamed from: f  reason: collision with root package name */
    private List<v> f24299f;

    /* renamed from: g  reason: collision with root package name */
    private int f24300g;

    public k(n nVar, bi biVar, ax axVar) {
        this.f24296c = nVar;
        this.f24297d = biVar;
        this.f24298e = axVar;
    }

    public void a() {
        this.f24295a.a();
    }

    public void c() {
        super.c();
        this.f24295a.c();
    }

    public void d() {
        super.d();
        this.f24295a.d();
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        d(str);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        d("");
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        d(str);
    }

    private void d(final String str) {
        if (!af.a(this.f24299f)) {
            List<T> a2 = af.a(this.f24299f, new af.a<v>() {
                /* renamed from: a */
                public boolean shouldInclude(v vVar) {
                    return vVar.f24352f.toLowerCase().contains(str.toLowerCase()) || vVar.f24351e == 1;
                }
            });
            for (T a3 : a2) {
                a3.a(str);
            }
            if (a2.size() > 0) {
                ((q) this.f19220b).b(a2);
            } else {
                ((q) this.f19220b).e();
            }
        }
    }

    public void b() {
        this.f24295a.b();
    }

    /* access modifiers changed from: package-private */
    public void a(List<v> list) {
        this.f24299f = list;
        ((q) this.f19220b).b(list);
    }

    /* access modifiers changed from: package-private */
    public void a(u uVar) {
        int a2 = uVar.a();
        int i = this.f24300g;
        if (a2 == i) {
            ((q) this.f19220b).a(new u(i, uVar.b(), 0), 0);
        }
    }

    public void a(int i, int i2, String str, byte[] bArr) {
        this.f24300g = i;
        this.f24298e.a(i, i2, str, bArr);
    }

    public void c(String str) {
        ((q) this.f19220b).a(new u(this.f24300g, str, 1), 1);
    }
}
