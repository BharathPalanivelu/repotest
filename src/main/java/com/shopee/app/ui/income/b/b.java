package com.shopee.app.ui.income.b;

import android.util.Pair;
import com.garena.android.appkit.b.i;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.bt;
import com.shopee.app.d.c.e.a;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.data.viewmodel.income.ShopBalance;
import com.shopee.app.data.viewmodel.income.TransactionItem;
import com.shopee.app.h.o;
import com.shopee.app.network.d.ao;
import com.shopee.app.network.d.az;
import com.shopee.app.network.g;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.common.p;
import com.shopee.app.ui.income.h;
import java.util.List;

public class b extends q<d> implements p.a {

    /* renamed from: a  reason: collision with root package name */
    i f23137a;

    /* renamed from: c  reason: collision with root package name */
    private final a f23138c;

    /* renamed from: d  reason: collision with root package name */
    private final UserInfo f23139d;

    /* renamed from: e  reason: collision with root package name */
    private final bt f23140e;

    /* renamed from: f  reason: collision with root package name */
    private int f23141f;

    /* renamed from: g  reason: collision with root package name */
    private int f23142g = 0;
    private int h;
    private int i = -1;
    private int j = -1;

    public b(a aVar, bt btVar, UserInfo userInfo) {
        this.f23138c = aVar;
        this.f23140e = btVar;
        this.f23139d = userInfo;
        this.f23137a = com.garena.a.a.a.b.a(this);
    }

    public void e() {
        new com.shopee.app.network.d.e.a().g();
        new ao().a(this.f23139d.getShopId());
    }

    public void a(int i2) {
        this.f23141f = i2;
        new com.shopee.app.network.d.e.a().g();
        if (this.f23141f == 0) {
            this.f23140e.a(this.f23139d.getUserId(), this.f23139d.getShopId(), (g) null);
        }
        f();
        g();
    }

    private void f() {
        com.shopee.app.network.d.e.b bVar = new com.shopee.app.network.d.e.b();
        o.a().a((az) bVar);
        int i2 = this.i;
        if (i2 != -1) {
            int i3 = this.j;
            if (i3 != -1) {
                bVar.a(this.f23141f, this.f23142g, 15, i2, i3);
                return;
            }
        }
        bVar.a(this.f23141f, this.f23142g, 15);
    }

    private void g() {
        this.f23138c.a(this.f23141f, ((d) this.f19220b).hashCode());
    }

    public void a() {
        this.f23137a.a();
    }

    public void c() {
        this.f23137a.c();
    }

    public void d() {
        this.f23137a.d();
    }

    public void b() {
        this.f23137a.b();
    }

    /* access modifiers changed from: package-private */
    public void a(h hVar) {
        if (this.f23141f == 0) {
            this.f23142g = 0;
            com.shopee.app.network.d.e.b bVar = new com.shopee.app.network.d.e.b();
            o.a().a((az) bVar);
            ((d) this.f19220b).g();
            this.i = hVar.f23182a;
            this.j = hVar.f23183b;
            if (this.i == -1) {
                bVar.a(this.f23141f, this.f23142g, 15, 1420070400, com.garena.android.appkit.tools.a.a.a());
            } else {
                bVar.a(this.f23141f, this.f23142g, 15, hVar.f23182a, hVar.f23183b);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ShopBalance shopBalance) {
        ((d) this.f19220b).b(shopBalance);
        g();
    }

    /* access modifiers changed from: package-private */
    public void a(ShopDetail shopDetail) {
        if (shopDetail.getShopId() == this.f23139d.getShopId()) {
            ((d) this.f19220b).a(shopDetail);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Pair<Integer, List<TransactionItem>> pair) {
        if (((Integer) pair.first).intValue() == this.f23141f) {
            ((d) this.f19220b).h();
            List list = (List) pair.second;
            ((d) this.f19220b).a((List<TransactionItem>) list);
            if (list.size() + 1 == this.h) {
                ((d) this.f19220b).e();
            } else {
                ((d) this.f19220b).f();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        if (i2 == this.f23141f) {
            g();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Pair<Integer, Long> pair) {
        if (((Integer) pair.first).intValue() == this.f23141f) {
            g();
            ((d) this.f19220b).setSum((Long) pair.second);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(Pair<ShopBalance, Integer> pair) {
        if (((d) this.f19220b).hashCode() == ((Integer) pair.second).intValue()) {
            ((d) this.f19220b).a((ShopBalance) pair.first);
        }
    }

    public void c(int i2) {
        this.h = i2;
        this.f23142g += 15;
        f();
    }
}
