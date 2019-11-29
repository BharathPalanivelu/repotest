package com.shopee.app.d.c.j;

import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.be;
import com.shopee.app.util.n;

public class c extends com.shopee.app.d.c.a.a<a> {

    /* renamed from: d  reason: collision with root package name */
    private final b.a<be> f17067d;

    public static class a extends a.C0253a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public boolean f17068a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f17069b;
    }

    public c(b.a<be> aVar, n nVar) {
        super(nVar);
        this.f17067d = aVar;
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        be beVar = this.f17067d.get();
        int H = beVar.H();
        if (H >= 99) {
            return;
        }
        if (aVar.f17068a && H < 2) {
            beVar.e(H + 1);
        } else if (aVar.f17069b) {
            beVar.e(99);
        }
    }
}
