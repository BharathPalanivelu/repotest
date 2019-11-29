package com.shopee.app.ui.order.b.c;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.f;
import com.garena.android.appkit.b.g;
import com.shopee.app.d.c.h;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.app.network.d.h.o;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.common.p;
import com.shopee.app.ui.order.a.c;
import com.shopee.app.util.n;
import java.util.List;

public class e extends q<f> implements p.a {

    /* renamed from: a  reason: collision with root package name */
    g f23542a = new f() {
        public void a(a aVar) {
            ((f) e.this.f19220b).a(((Integer) aVar.data).intValue());
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final n f23543c;

    /* renamed from: d  reason: collision with root package name */
    private final com.shopee.app.d.c.g.a f23544d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f23545e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f23546f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public List<ReturnItem> f23547g;
    private int h = 0;
    /* access modifiers changed from: private */
    public int i;
    private h j;
    private com.garena.android.appkit.b.e k = new g() {
        public void onEvent(a aVar) {
            c cVar = (c) aVar;
            if (cVar.a() == e.this.f23546f) {
                List unused = e.this.f23547g = cVar.b();
                ((f) e.this.f19220b).a((List<ReturnItem>) e.this.f23547g);
                if (e.this.f23547g.size() + 1 == e.this.i) {
                    ((f) e.this.f19220b).e();
                } else {
                    ((f) e.this.f19220b).f();
                }
            }
        }
    };
    private com.garena.android.appkit.b.e l = new f() {
        public void a(a aVar) {
            e.this.g();
        }
    };
    private com.garena.android.appkit.b.e m = new f() {
        public void a(a aVar) {
            e.this.a(true);
        }
    };
    private com.garena.android.appkit.b.e n = new g() {
        public void onEvent(a aVar) {
            boolean z = true;
            if (((Integer) ((Pair) aVar.data).first).intValue() != 1) {
                z = false;
            }
            if (e.this.f23545e == z) {
                e.this.g();
            }
        }
    };

    public e(n nVar, com.shopee.app.d.c.g.a aVar, h hVar) {
        this.f23543c = nVar;
        this.f23544d = aVar;
        this.j = hVar;
    }

    public void a(boolean z, int i2) {
        this.f23545e = z;
        this.f23546f = i2;
        g();
        f();
    }

    private void f() {
        a(false);
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        o oVar = new o();
        oVar.h();
        List<ReturnItem> list = this.f23547g;
        int i2 = 0;
        int i3 = 20;
        if (list != null && !list.isEmpty()) {
            if (z) {
                i3 = 20 + this.h + 1;
            } else {
                i2 = this.h;
            }
        }
        oVar.a(this.f23545e, i2, i3, this.f23546f);
    }

    /* access modifiers changed from: private */
    public void g() {
        ((f) this.f19220b).g();
        this.f23544d.a(this.f23545e, this.f23546f);
    }

    public void a() {
        this.f23543c.a("RETURN_LIST_SAVED", this.l);
        this.f23543c.a("ORDER_IN_BATCH_SAVED", this.l);
        this.f23543c.a("RETURN_LIST_LOCAL_LOAD", this.k);
        this.f23543c.a("RETURN_ITEM_UPDATE", this.l);
        this.f23543c.a("RETURN_UPDATE_NOTI", this.m);
        this.f23543c.a("RETURN_ARCHIVE_NOTI", this.m);
        this.f23543c.a("GET_USER_INFO_LOAD", this.l);
        this.f23543c.a("ITEM_SNAPSHOT_LOAD", this.l);
        this.f23543c.a("RETURN_UPDATE_NOTIFICATION", (com.garena.android.appkit.b.e) this.f23542a);
        this.f23543c.a("ORDER_UPDATE_NOTIFICATION", this.n);
    }

    public void b() {
        this.f23543c.b("RETURN_LIST_SAVED", this.l);
        this.f23543c.b("ORDER_IN_BATCH_SAVED", this.l);
        this.f23543c.b("RETURN_LIST_LOCAL_LOAD", this.k);
        this.f23543c.b("RETURN_ITEM_UPDATE", this.l);
        this.f23543c.b("RETURN_UPDATE_NOTI", this.m);
        this.f23543c.b("RETURN_ARCHIVE_NOTI", this.m);
        this.f23543c.b("GET_USER_INFO_LOAD", this.l);
        this.f23543c.b("ITEM_SNAPSHOT_LOAD", this.l);
        this.f23543c.b("RETURN_UPDATE_NOTIFICATION", this.f23542a);
        this.f23543c.b("ORDER_UPDATE_NOTIFICATION", this.n);
    }

    public void c(int i2) {
        this.i = i2;
        this.h += 20;
        f();
    }

    public void e() {
        this.j.a(new OrderKey(this.f23545e, 5));
    }
}
