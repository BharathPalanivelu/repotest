package com.shopee.app.d.c;

import android.util.Pair;
import com.shopee.app.data.store.c.a;
import com.shopee.app.util.n;

public class bk extends a {

    /* renamed from: c  reason: collision with root package name */
    private final a f16587c;

    /* renamed from: d  reason: collision with root package name */
    private int f16588d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f16589e;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetOrderCountInteractor";
    }

    protected bk(n nVar, a aVar) {
        super(nVar);
        this.f16587c = aVar;
    }

    public void a(int i) {
        this.f16588d = i;
        this.f16589e = false;
        a();
    }

    public void e() {
        this.f16589e = true;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (this.f16589e) {
            this.f16402a.a().cz.a(new Pair(Integer.valueOf(this.f16587c.c()), Integer.valueOf(this.f16587c.d()))).a();
        } else if (this.f16588d == 0) {
            this.f16402a.a().cJ.a(this.f16587c.a()).a();
        } else {
            this.f16402a.a().ch.a(this.f16587c.b()).a();
        }
    }
}
