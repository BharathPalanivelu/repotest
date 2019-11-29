package com.shopee.app.ui.order.detail;

import android.text.TextUtils;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.f;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.c;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.h.o;
import com.shopee.app.network.d.as;
import com.shopee.app.network.d.az;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.order.k;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import com.shopee.id.R;

public class b extends q<e> {

    /* renamed from: a  reason: collision with root package name */
    private final c f23588a;

    /* renamed from: c  reason: collision with root package name */
    private final n f23589c;

    /* renamed from: d  reason: collision with root package name */
    private final bi f23590d;

    /* renamed from: e  reason: collision with root package name */
    private final k f23591e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public long f23592f;

    /* renamed from: g  reason: collision with root package name */
    private final i f23593g;
    private e h = new g() {
        public void onEvent(a aVar) {
            ((e) b.this.f19220b).a((OrderDetail) aVar.data);
        }
    };
    private e i = new f() {
        public void a(a aVar) {
            ((e) b.this.f19220b).c();
        }
    };
    private e j = new f() {
        public void a(a aVar) {
            if (b.this.f23592f == ((Long) aVar.data).longValue()) {
                ((e) b.this.f19220b).d();
            }
        }
    };
    private e k = new f() {
        public void a(a aVar) {
            b bVar = b.this;
            bVar.b(bVar.f23592f);
        }
    };
    private g l = new g() {
        public void onEvent(a aVar) {
            ((e) b.this.f19220b).a((CheckoutItem) aVar.data);
        }
    };
    private g m = new g() {
        public void onEvent(a aVar) {
            h hVar = (h) aVar;
            az f2 = o.a().f(hVar.f23628a);
            if (f2 != null && ((as) f2).b().contains(Long.valueOf(b.this.f23592f)) && hVar.f23629b == 4) {
                ((e) b.this.f19220b).setEmptyView(true);
            }
        }
    };

    b(n nVar, bi biVar, k kVar, c cVar) {
        this.f23589c = nVar;
        this.f23590d = biVar;
        this.f23591e = kVar;
        this.f23588a = cVar;
        this.f23593g = com.garena.a.a.a.b.a(this);
    }

    public void a() {
        this.f23593g.a();
        this.f23589c.a("ORDER_DETAILS_SERVER_SAVED", this.k);
        this.f23589c.a("GET_UNPAID_ORDER_ERROR", (e) this.m);
        this.f23589c.a("GET_CHECKOUT_ORDER_SUCCESS", this.k);
        this.f23589c.a("GET_UNPAID_ORDER_SAVED", this.k);
        this.f23589c.a("GET_USER_INFO_LOAD", this.k);
        this.f23589c.a("CHECKOUT_ITEM_PAID", this.j);
        this.f23589c.a("ITEM_SNAPSHOT_LOAD", this.k);
        this.f23589c.a("ORDER_UPDATE_NOTIFICATION", this.k);
        this.f23589c.a("SINGLE_CHECKOUT_LOCAL_LOAD", (e) this.l);
        this.f23589c.a("CANCEL_CHECKOUT_SUCCESS", this.i);
    }

    public void b() {
        this.f23593g.b();
        this.f23589c.b("ORDER_DETAILS_SERVER_SAVED", this.k);
        this.f23589c.b("GET_UNPAID_ORDER_ERROR", this.m);
        this.f23589c.b("GET_CHECKOUT_ORDER_SUCCESS", this.k);
        this.f23589c.b("GET_UNPAID_ORDER_SAVED", this.k);
        this.f23589c.b("GET_USER_INFO_LOAD", this.k);
        this.f23589c.b("CHECKOUT_ITEM_PAID", this.j);
        this.f23589c.b("ITEM_SNAPSHOT_LOAD", this.k);
        this.f23589c.b("ORDER_UPDATE_NOTIFICATION", this.k);
        this.f23589c.b("SINGLE_CHECKOUT_LOCAL_LOAD", this.l);
        this.f23589c.b("CANCEL_CHECKOUT_SUCCESS", this.i);
    }

    public void c() {
        this.f23591e.a();
        this.f23590d.a("ORDER_GOTO_DETAIL", this.h);
    }

    public void d() {
        this.f23591e.b();
        this.f23590d.b("ORDER_GOTO_DETAIL", this.h);
    }

    public void a(long j2) {
        this.f23592f = j2;
        b(j2);
        as asVar = new as();
        asVar.h();
        asVar.a(j2);
    }

    /* access modifiers changed from: private */
    public void b(long j2) {
        this.f23588a.a(j2);
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else if (aVar.f17892a != -100) {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
        } else {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
        }
        ((e) this.f19220b).a(str);
    }
}
