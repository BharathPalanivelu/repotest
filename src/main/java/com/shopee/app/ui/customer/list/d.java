package com.shopee.app.ui.customer.list;

import android.text.TextUtils;
import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.shopee.app.d.c.ci;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.network.d.ah;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.common.p;
import com.shopee.app.ui.follow.search.j;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.List;

public class d extends q<e> implements p.a {

    /* renamed from: a  reason: collision with root package name */
    private final n f21401a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final bi f21402c;

    /* renamed from: d  reason: collision with root package name */
    private final ci f21403d;

    /* renamed from: e  reason: collision with root package name */
    private final j f21404e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public List<UserBriefInfo> f21405f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private boolean f21406g = false;
    /* access modifiers changed from: private */
    public int h;
    private int i = 0;
    /* access modifiers changed from: private */
    public String j;
    /* access modifiers changed from: private */
    public int k;
    private int l = 0;
    private e m = new g() {
        public void onEvent(a aVar) {
            List unused = d.this.f21405f = (List) aVar.data;
            ((e) d.this.f19220b).a((List<UserBriefInfo>) new ArrayList(d.this.f21405f));
            ((e) d.this.f19220b).c();
            if (d.this.f21405f.size() + 1 == d.this.h) {
                ((e) d.this.f19220b).d();
            } else {
                ((e) d.this.f19220b).e();
            }
            d.this.a(false);
        }
    };
    private e n = new g() {
        public void onEvent(a aVar) {
            if (d.this.a((String) aVar.data)) {
                d.this.f21402c.a("SHOW_SEARCH_PROGRESS", new a());
            } else {
                d.this.g();
            }
        }
    };
    private e o = new g() {
        public void onEvent(a aVar) {
            ((e) d.this.f19220b).a((List<UserBriefInfo>) new ArrayList());
            d.this.g();
            d.this.f21402c.a("HIDE_SEARCH_PROGRESS", new a());
        }
    };
    private e p = new g() {
        public void onEvent(a aVar) {
            if (aVar.data != null && (aVar.data instanceof Pair)) {
                Pair pair = (Pair) aVar.data;
                if (d.this.j == null || !d.this.j.equals(pair.first)) {
                    d.this.f21405f.clear();
                    return;
                }
                d.this.f21405f.addAll((List) pair.second);
                ((e) d.this.f19220b).a((List<UserBriefInfo>) new ArrayList(d.this.f21405f));
                d.this.f21402c.a("HIDE_SEARCH_PROGRESS", new a());
                if (d.this.f21405f.size() + 1 == d.this.k) {
                    ((e) d.this.f19220b).d();
                } else {
                    ((e) d.this.f19220b).e();
                }
                d.this.a(true);
            }
        }
    };
    private e q = new g() {
        public void onEvent(a aVar) {
            if (d.this.f21405f == null || d.this.f21405f.size() <= 0) {
                ((e) d.this.f19220b).a((List<UserBriefInfo>) new ArrayList());
            } else if (d.this.f21405f.size() + 1 == d.this.k) {
                ((e) d.this.f19220b).d();
            } else {
                ((e) d.this.f19220b).e();
            }
            d.this.f21402c.a("HIDE_SEARCH_PROGRESS", new a());
        }
    };
    private e r = new g() {
        public void onEvent(a aVar) {
            ((e) d.this.f19220b).c();
        }
    };
    private e s = new g() {
        public void onEvent(a aVar) {
            d.this.g();
        }
    };

    public d(n nVar, bi biVar, ci ciVar, j jVar) {
        this.f21401a = nVar;
        this.f21402c = biVar;
        this.f21403d = ciVar;
        this.f21404e = jVar;
    }

    public void e() {
        f();
        g();
    }

    private void f() {
        ((e) this.f19220b).b();
        ah ahVar = new ah();
        ahVar.h();
        List<UserBriefInfo> list = this.f21405f;
        if (list == null || list.isEmpty()) {
            ahVar.a(0, 20);
        } else {
            ahVar.a(this.i, 20);
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        this.f21403d.a();
    }

    /* access modifiers changed from: private */
    public boolean a(String str) {
        if (!str.equals(this.j) || this.l == 0) {
            List<UserBriefInfo> list = this.f21405f;
            if (list != null) {
                list.clear();
            }
            this.l = 0;
            this.j = str;
        }
        if (TextUtils.isEmpty(this.j)) {
            return false;
        }
        List<UserBriefInfo> list2 = this.f21405f;
        if (list2 == null || list2.isEmpty()) {
            this.f21404e.a(str, 20, 0, 1);
        } else {
            this.f21404e.a(str, 20, this.l, 1);
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            if (!this.f21406g) {
                this.f21406g = true;
                ((e) this.f19220b).f();
            }
        } else if (this.f21406g) {
            this.f21406g = false;
            ((e) this.f19220b).f();
        }
    }

    public void a() {
        this.f21401a.a("MY_CUSTOMER_SAVE", this.s);
        this.f21401a.a("MY_CUSTOMER_LOAD", this.m);
        this.f21401a.a("MY_CUSTOMER_ERROR", this.r);
        this.f21401a.a("SEARCH_USER_LOAD", this.p);
        this.f21401a.a("SEARCH_USER_EMPTY", this.q);
        this.f21401a.a("SEARCH_USER_ERROR", this.r);
    }

    public void c() {
        this.f21402c.a("SEARCH_TEXT_CHANGED", this.n);
        this.f21402c.a("SEARCH_TEXT_DONE", this.n);
        this.f21402c.a("SEARCH_TEXT_CANCELLED", this.o);
    }

    public void d() {
        this.f21402c.b("SEARCH_TEXT_CHANGED", this.n);
        this.f21402c.b("SEARCH_TEXT_DONE", this.n);
        this.f21402c.b("SEARCH_TEXT_CANCELLED", this.o);
    }

    public void b() {
        this.f21401a.b("MY_CUSTOMER_SAVE", this.m);
        this.f21401a.b("MY_CUSTOMER_LOAD", this.m);
        this.f21401a.b("MY_CUSTOMER_ERROR", this.r);
        this.f21401a.b("SEARCH_USER_LOAD", this.p);
        this.f21401a.b("SEARCH_USER_EMPTY", this.q);
        this.f21401a.b("SEARCH_USER_ERROR", this.r);
    }

    public void c(int i2) {
        if (this.f21406g) {
            this.k = i2;
            this.l += 20;
            a(this.j);
            return;
        }
        this.h = i2;
        this.i += 20;
        f();
    }
}
