package com.shopee.app.ui.order.b;

import android.util.Pair;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.f;
import com.garena.android.appkit.b.g;
import com.shopee.app.d.c.bd;
import com.shopee.app.d.c.h;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.MeCounter;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.h.l;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.common.p;
import com.shopee.app.ui.order.a.b;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import java.util.List;

public class a extends q<b> implements p.a {

    /* renamed from: a  reason: collision with root package name */
    private final n f23470a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final SettingConfigStore f23471c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public MeCounter f23472d;

    /* renamed from: e  reason: collision with root package name */
    private final bd f23473e;

    /* renamed from: f  reason: collision with root package name */
    private final bi f23474f;

    /* renamed from: g  reason: collision with root package name */
    private h f23475g;
    /* access modifiers changed from: private */
    public OrderKey h;
    private int i = 0;
    /* access modifiers changed from: private */
    public int j;
    private boolean k = false;
    private e l = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            b bVar = (b) aVar;
            if (bVar.a().equals(a.this.h)) {
                List<OrderDetail> b2 = bVar.b();
                ((b) a.this.f19220b).a(b2);
                ((b) a.this.f19220b).h();
                if (b2.size() + 1 == a.this.j) {
                    ((b) a.this.f19220b).e();
                } else {
                    ((b) a.this.f19220b).f();
                }
            }
        }
    };
    private e m = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (((com.shopee.app.ui.order.a.a) aVar).a().equals(a.this.h)) {
                a.this.g();
            }
        }
    };
    private e n = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (a.this.h.listType == 4) {
                a.this.g();
            }
        }
    };
    private e o = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (a.this.h.listType == 4 && a.this.h.uType == 0) {
                a.this.g();
            }
        }
    };
    private e p = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (a.this.h.listType == 3) {
                a.this.g();
            }
        }
    };
    private e q = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (a.this.h.listType == 3) {
                a.this.g();
            }
        }
    };
    private e r = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            com.shopee.app.ui.order.p pVar = (com.shopee.app.ui.order.p) aVar;
            if (a.this.h.listType == 5) {
                a.this.g();
            }
            if (a.this.h.listType == 8 && pVar.f23744c > 0 && a.this.f23471c.coinAnimationEnabled()) {
                new com.shopee.app.util.c.a().a(((com.shopee.app.ui.a.b) ((b) a.this.f19220b).f23500g).x(), a.this.f23472d.getCoinCount(), pVar.f23744c, a.this.f23471c.coinMultiplier());
            }
        }
    };
    private e s = new f() {
        public void a(com.garena.android.appkit.b.a aVar) {
            a.this.g();
        }
    };
    private e t = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (a.this.h.uType == ((Integer) ((Pair) aVar.data).first).intValue()) {
                a.this.g();
            }
        }
    };
    private e u = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((b) a.this.f19220b).a((String) aVar.data);
        }
    };

    public a(n nVar, bi biVar, MeCounter meCounter, SettingConfigStore settingConfigStore, bd bdVar, h hVar) {
        this.f23470a = nVar;
        this.f23474f = biVar;
        this.f23471c = settingConfigStore;
        this.f23472d = meCounter;
        this.f23473e = bdVar;
        this.f23475g = hVar;
    }

    public void a(OrderKey orderKey) {
        this.h = orderKey;
        this.i = 0;
        this.k = false;
        g();
        f();
    }

    public void a(boolean z) {
        this.k = z;
        this.i = 0;
        ((b) this.f19220b).g();
        f();
    }

    private void f() {
        l lVar = new l();
        o.a().a((az) lVar);
        lVar.a(this.h, this.i, 20, this.k);
    }

    /* access modifiers changed from: private */
    public void g() {
        ((b) this.f19220b).h();
        this.f23473e.a(this.h, 20);
    }

    public void c() {
        super.c();
        this.f23474f.a("FAQ_SHOPEE_ITEM", this.u);
    }

    public void d() {
        super.d();
        this.f23474f.b("FAQ_SHOPEE_ITEM", this.u);
    }

    public void a() {
        this.f23470a.a("ORDER_LIST_LOCAL_LOAD", this.l);
        this.f23470a.a("ORDER_LIST_SAVED", this.m);
        this.f23470a.a("ITEM_SNAPSHOT_LOAD", this.s);
        this.f23470a.a("ORDER_RATE_SUCCESS", this.p);
        this.f23470a.a("GET_USER_INFO_LOAD", this.s);
        this.f23470a.a("ORDER_UPDATE_NOTIFICATION", this.t);
        this.f23470a.a("PAYMENT_RECEIVED_SUCCESS", this.s);
        this.f23470a.a("SHIP_ORDER_SUCCESS", this.s);
        this.f23470a.a("SHIPMENT_RECEIVED_SUCCESS", this.r);
        this.f23470a.a("ORDER_CANCEL_SUCCESS", this.s);
        this.f23470a.a("ARCHIVE_ORDER_SUCCESS", this.n);
        this.f23470a.a("CANCEL_CHECKOUT_SUCCESS", this.o);
        this.f23470a.a("ORDER_DETAILS_SERVER_SAVED", this.s);
        this.f23470a.a("RARING_STATUS_CHANGE", this.q);
    }

    public void b() {
        this.f23470a.b("ORDER_LIST_LOCAL_LOAD", this.l);
        this.f23470a.b("ORDER_LIST_SAVED", this.m);
        this.f23470a.b("ITEM_SNAPSHOT_LOAD", this.s);
        this.f23470a.b("ORDER_RATE_SUCCESS", this.p);
        this.f23470a.b("GET_USER_INFO_LOAD", this.s);
        this.f23470a.b("ORDER_UPDATE_NOTIFICATION", this.t);
        this.f23470a.b("PAYMENT_RECEIVED_SUCCESS", this.s);
        this.f23470a.b("SHIP_ORDER_SUCCESS", this.s);
        this.f23470a.b("SHIPMENT_RECEIVED_SUCCESS", this.r);
        this.f23470a.b("ORDER_CANCEL_SUCCESS", this.s);
        this.f23470a.b("ARCHIVE_ORDER_SUCCESS", this.n);
        this.f23470a.b("CANCEL_CHECKOUT_SUCCESS", this.o);
        this.f23470a.b("ORDER_DETAILS_SERVER_SAVED", this.s);
        this.f23470a.b("RARING_STATUS_CHANGE", this.q);
    }

    public void c(int i2) {
        this.j = i2;
        this.i += 20;
        f();
    }

    public void e() {
        this.f23475g.a(this.h);
    }
}
