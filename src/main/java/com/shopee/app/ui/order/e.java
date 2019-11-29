package com.shopee.app.ui.order;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.f;
import com.garena.android.appkit.b.g;
import com.shopee.app.d.b.b;
import com.shopee.app.d.c.bi;
import com.shopee.app.network.d.h.h;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.n;
import java.util.Map;

public class e extends q<g> {

    /* renamed from: a  reason: collision with root package name */
    g f23652a = new g() {
        public void onEvent(a aVar) {
            Pair pair = (Pair) aVar.data;
            if (((Integer) pair.first).intValue() == e.this.i) {
                for (Map.Entry entry : ((Map) pair.second).entrySet()) {
                    ((g) e.this.f19220b).b(((Integer) entry.getKey()).intValue(), ((Integer) entry.getValue()).intValue());
                }
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    g f23653c = new f() {
        public void a(a aVar) {
            e eVar = e.this;
            eVar.a(eVar.i);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    g f23654d = new f() {
        public void a(a aVar) {
            Pair pair = (Pair) aVar.data;
            if (b.a((Integer) pair.first, 0) + b.a((Integer) pair.second, 0) > 0) {
                ((g) e.this.f19220b).e();
            } else {
                ((g) e.this.f19220b).f();
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    g f23655e = new f() {
        public void a(a aVar) {
            Pair pair = (Pair) aVar.data;
            if (e.this.i == ((Integer) pair.first).intValue()) {
                for (Map.Entry entry : ((Map) pair.second).entrySet()) {
                    ((g) e.this.f19220b).b(((Integer) entry.getKey()).intValue(), ((Integer) entry.getValue()).intValue());
                }
            }
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final n f23656f;

    /* renamed from: g  reason: collision with root package name */
    private final bi f23657g;
    private final k h;
    /* access modifiers changed from: private */
    public int i;

    public e(n nVar, k kVar, bi biVar) {
        this.f23656f = nVar;
        this.h = kVar;
        this.f23657g = biVar;
    }

    public void a(int i2) {
        this.i = i2;
        this.f23657g.a(i2);
    }

    public void e() {
        new h().a(true, true);
    }

    public void a() {
        this.f23656f.a("ORDER_BADGE_LOAD", (com.garena.android.appkit.b.e) this.f23652a);
        this.f23656f.a("ORDER_UPDATE_NOTIFICATION", (com.garena.android.appkit.b.e) this.f23655e);
        this.f23656f.a("CHECKOUT_ITEM_PAID", (com.garena.android.appkit.b.e) this.f23653c);
        this.f23656f.a("CHECKOUT_ITEM_CANCEL", (com.garena.android.appkit.b.e) this.f23653c);
        this.f23656f.a("PAYMENT_RECEIVED_SUCCESS", (com.garena.android.appkit.b.e) this.f23653c);
        this.f23656f.a("SHIP_ORDER_SUCCESS", (com.garena.android.appkit.b.e) this.f23653c);
        this.f23656f.a("SHIPMENT_RECEIVED_SUCCESS", (com.garena.android.appkit.b.e) this.f23653c);
        this.f23656f.a("ORDER_CANCEL_SUCCESS", (com.garena.android.appkit.b.e) this.f23653c);
        this.f23656f.a("CANCEL_CHECKOUT_SUCCESS", (com.garena.android.appkit.b.e) this.f23653c);
        this.f23656f.a("GET_GROUP_BUY_ORDER_COUNT", (com.garena.android.appkit.b.e) this.f23654d);
    }

    public void c() {
        this.h.a();
    }

    public void d() {
        this.h.b();
    }

    public void b() {
        this.f23656f.b("ORDER_BADGE_LOAD", this.f23652a);
        this.f23656f.b("ORDER_UPDATE_NOTIFICATION", this.f23655e);
        this.f23656f.b("CHECKOUT_ITEM_PAID", this.f23653c);
        this.f23656f.b("CHECKOUT_ITEM_CANCEL", this.f23653c);
        this.f23656f.b("PAYMENT_RECEIVED_SUCCESS", this.f23653c);
        this.f23656f.b("SHIP_ORDER_SUCCESS", this.f23653c);
        this.f23656f.b("SHIPMENT_RECEIVED_SUCCESS", this.f23653c);
        this.f23656f.b("ORDER_CANCEL_SUCCESS", this.f23653c);
        this.f23656f.b("CANCEL_CHECKOUT_SUCCESS", this.f23653c);
        this.f23656f.b("GET_GROUP_BUY_ORDER_COUNT", this.f23654d);
    }
}
