package com.shopee.app.ui.chat2.product.c;

import android.text.TextUtils;
import android.util.Pair;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.be;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.network.d.ak;
import com.shopee.app.network.d.al;
import com.shopee.app.network.d.d.a.a;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.actionbar.k;
import com.shopee.app.ui.common.ae;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class d extends q<a> implements ae.a {

    /* renamed from: a  reason: collision with root package name */
    private final i f20763a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f20764c;

    /* renamed from: d  reason: collision with root package name */
    private final be f20765d;

    /* renamed from: e  reason: collision with root package name */
    private final com.shopee.app.d.c.h.a f20766e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f20767f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f20768g = 0;
    private int h;
    /* access modifiers changed from: private */
    public String i;
    private List<Pair<Integer, Long>> j;
    private a k;
    /* access modifiers changed from: private */
    public String l;

    public d(UserInfo userInfo, be beVar, com.shopee.app.d.c.h.a aVar) {
        this.f20764c = userInfo.getShopId();
        this.f20765d = beVar;
        this.f20766e = aVar;
        this.f20763a = b.a(this);
        this.k = new a();
        this.j = new ArrayList();
    }

    public void a(int i2, int i3) {
        this.f20764c = i2;
        this.f20767f = i3;
        this.f20768g = i3;
        a(true);
        b(i2);
        c(i2);
    }

    private void a(boolean z) {
        ((a) this.f19220b).e();
        if (TextUtils.isEmpty(this.i)) {
            this.f20765d.a(this.f20764c, this.f20768g, false);
        } else {
            this.f20766e.a(hashCode(), this.j, z);
        }
    }

    private void b(int i2) {
        new al().a(i2, 0);
    }

    private void c(int i2) {
        new ak().a(i2);
    }

    public void a() {
        this.f20763a.a();
    }

    public void c() {
        this.f20763a.c();
    }

    public void d() {
        this.f20763a.d();
    }

    public void b() {
        this.f20763a.b();
    }

    /* access modifiers changed from: package-private */
    public void a(Pair<Integer, List<ItemDetail>> pair) {
        if (((Integer) pair.first).intValue() == this.f20764c) {
            ArrayList arrayList = new ArrayList((Collection) pair.second);
            ((a) this.f19220b).a(arrayList);
            if (arrayList.size() + 1 == this.h) {
                ((a) this.f19220b).f();
            } else {
                ((a) this.f19220b).g();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Pair<Integer, List<ItemDetail>> pair) {
        if (((Integer) pair.first).equals(Integer.valueOf(hashCode()))) {
            ArrayList arrayList = new ArrayList((Collection) pair.second);
            ((a) this.f19220b).a(arrayList);
            if (arrayList.size() + 1 == this.h) {
                ((a) this.f19220b).f();
            } else {
                ((a) this.f19220b).g();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        a(true);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (this.f20764c == i2) {
            a(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        c(str);
    }

    /* access modifiers changed from: package-private */
    public void f() {
        c("");
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        c(str);
    }

    /* access modifiers changed from: package-private */
    public void c(Pair<com.shopee.app.network.d.d.a.a, List<Pair<Integer, Long>>> pair) {
        com.shopee.app.network.d.d.a.a aVar = (com.shopee.app.network.d.d.a.a) pair.first;
        if (aVar.i().a().equals(this.l)) {
            if (aVar.d() != this.f20767f || aVar.d() == 0) {
                this.j = (List) pair.second;
            } else {
                this.j.addAll((Collection) pair.second);
            }
            a(true);
        }
    }

    private void c(String str) {
        this.f20767f = 0;
        this.f20768g = 0;
        ((a) this.f19220b).h();
        this.i = str.trim().toLowerCase();
        i();
    }

    /* access modifiers changed from: package-private */
    public void g() {
        a(false);
    }

    public void d(int i2) {
        this.h = i2;
        this.f20767f += 20;
        this.f20768g++;
        if (h()) {
            a aVar = this.k;
            aVar.f20769a = true;
            aVar.f20770b = false;
            aVar.run();
            return;
        }
        a(true);
    }

    /* access modifiers changed from: package-private */
    public void a(k kVar) {
        if (kVar != null) {
            this.f20767f = 0;
            this.f20768g = 0;
            ((a) this.f19220b).h();
            this.i = kVar.getText().trim().toLowerCase();
            i();
        }
    }

    private void i() {
        if (this.k.f20769a) {
            this.k.f20770b = true;
            this.k = new a();
        }
        this.k.f20769a = true;
        ((a) this.f19220b).postDelayed(this.k, 500);
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return !TextUtils.isEmpty(this.i);
    }

    private class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public boolean f20769a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f20770b;

        private a() {
            this.f20769a = false;
            this.f20770b = false;
        }

        public void run() {
            if (!this.f20770b) {
                com.shopee.app.network.d.d.a.a a2 = new a.C0273a().a(d.this.i).b((Integer) 20).a(Integer.valueOf(d.this.f20767f)).a(d.this.f20764c).a();
                String unused = d.this.l = a2.i().a();
                a2.g();
            }
            this.f20769a = false;
        }
    }
}
