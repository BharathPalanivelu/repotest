package com.shopee.app.ui.order.b.b;

import android.util.Pair;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.f;
import com.garena.android.appkit.b.g;
import com.shopee.app.d.c.g.c;
import com.shopee.app.d.c.h;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.network.d.h.p;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.n;
import java.util.List;

public class a extends q<b> {

    /* renamed from: a  reason: collision with root package name */
    private final n f23503a;

    /* renamed from: c  reason: collision with root package name */
    private final c f23504c;

    /* renamed from: d  reason: collision with root package name */
    private final h f23505d;

    /* renamed from: e  reason: collision with root package name */
    private e f23506e = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            a.this.h();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private e f23507f = new f() {
        public void a(com.garena.android.appkit.b.a aVar) {
            ((b) a.this.f19220b).f();
            ((b) a.this.f19220b).a((List) aVar.data);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private e f23508g = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            a.this.h();
        }
    };
    private e h = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            a.this.h();
        }
    };
    private e i = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            a.this.h();
        }
    };
    private e j = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            boolean z = true;
            if (((Integer) ((Pair) aVar.data).first).intValue() != 1) {
                z = false;
            }
            if (!z) {
                a.this.h();
            }
        }
    };

    public a(n nVar, c cVar, h hVar) {
        this.f23503a = nVar;
        this.f23504c = cVar;
        this.f23505d = hVar;
    }

    public void e() {
        h();
        g();
    }

    private void g() {
        new p().a(0);
    }

    /* access modifiers changed from: private */
    public void h() {
        ((b) this.f19220b).e();
        this.f23504c.a(20);
    }

    public void a() {
        this.f23503a.a("CHECKOUT_LIST_LOCAL_LOAD", this.f23507f);
        this.f23503a.a("GET_UNPAID_ORDER_SAVED", this.f23506e);
        this.f23503a.a("CHECKOUT_LIST_SAVED", this.f23506e);
        this.f23503a.a("CHECKOUT_ITEM_PAID", this.h);
        this.f23503a.a("CHECKOUT_ITEM_CANCEL", this.i);
        this.f23503a.a("ORDER_LIST_SAVED", this.f23506e);
        this.f23503a.a("USER_BRIEF_LOAD", this.f23508g);
        this.f23503a.a("CANCEL_CHECKOUT_SUCCESS", this.i);
        this.f23503a.a("ORDER_UPDATE_NOTIFICATION", this.j);
    }

    public void b() {
        this.f23503a.b("CHECKOUT_LIST_LOCAL_LOAD", this.f23507f);
        this.f23503a.b("GET_UNPAID_ORDER_SAVED", this.f23506e);
        this.f23503a.b("CHECKOUT_LIST_SAVED", this.f23506e);
        this.f23503a.b("CHECKOUT_ITEM_PAID", this.h);
        this.f23503a.b("CHECKOUT_ITEM_CANCEL", this.i);
        this.f23503a.b("ORDER_LIST_SAVED", this.f23506e);
        this.f23503a.b("USER_BRIEF_LOAD", this.f23508g);
        this.f23503a.b("CANCEL_CHECKOUT_SUCCESS", this.i);
        this.f23503a.b("ORDER_UPDATE_NOTIFICATION", this.j);
    }

    public void f() {
        this.f23505d.a(new OrderKey(false, 9));
    }
}
