package com.shopee.app.ui.chat2.product.a;

import android.text.TextUtils;
import android.util.Pair;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.au;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.network.d.d.a.a;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.actionbar.k;
import com.shopee.app.ui.common.ae;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class d extends q<a> implements ae.a {

    /* renamed from: a  reason: collision with root package name */
    private final i f20699a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int f20700c;

    /* renamed from: d  reason: collision with root package name */
    private final au f20701d;

    /* renamed from: e  reason: collision with root package name */
    private final com.shopee.app.d.c.h.a f20702e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f20703f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f20704g;
    /* access modifiers changed from: private */
    public String h;
    private List<Pair<Integer, Long>> i;
    private a j;
    /* access modifiers changed from: private */
    public String k;

    public d(UserInfo userInfo, au auVar, com.shopee.app.d.c.h.a aVar) {
        this.f20700c = userInfo.getShopId();
        this.f20701d = auVar;
        this.f20702e = aVar;
        this.f20699a = b.a(this);
        this.j = new a();
        this.i = new ArrayList();
    }

    public void a(int i2, boolean z) {
        a(true);
        a(i2, 20, z);
    }

    private void a(boolean z) {
        ((a) this.f19220b).h();
        if (TextUtils.isEmpty(this.h)) {
            this.f20701d.a(7, z);
        } else {
            this.f20702e.a(hashCode(), this.i, z);
        }
    }

    private void a(int i2, int i3, boolean z) {
        new com.shopee.app.network.d.ae().a(7, this.f20700c, i2, i3, z, true);
    }

    public void a() {
        this.f20699a.a();
    }

    public void c() {
        this.f20699a.c();
    }

    public void d() {
        this.f20699a.d();
    }

    public void b() {
        this.f20699a.b();
    }

    /* access modifiers changed from: package-private */
    public void a(Pair<Integer, List<ItemDetail>> pair) {
        if (((Integer) pair.first).equals(7)) {
            List subList = new ArrayList((Collection) pair.second).subList(0, Math.min(this.f20703f + 20, ((List) pair.second).size()));
            ((a) this.f19220b).a(subList);
            if (subList.size() + 1 == this.f20704g) {
                ((a) this.f19220b).e();
            } else {
                ((a) this.f19220b).f();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Pair<Integer, List<ItemDetail>> pair) {
        if (((Integer) pair.first).equals(Integer.valueOf(hashCode()))) {
            ArrayList arrayList = new ArrayList((Collection) pair.second);
            ((a) this.f19220b).a(arrayList);
            if (arrayList.size() + 1 == this.f20704g) {
                ((a) this.f19220b).e();
            } else {
                ((a) this.f19220b).f();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (i2 == 7) {
            a(false);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        c(str);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        c("");
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        c(str);
    }

    /* access modifiers changed from: package-private */
    public void c(Pair<com.shopee.app.network.d.d.a.a, List<Pair<Integer, Long>>> pair) {
        com.shopee.app.network.d.d.a.a aVar = (com.shopee.app.network.d.d.a.a) pair.first;
        if (aVar.i().a().equals(this.k)) {
            if (aVar.d() != this.f20703f || aVar.d() == 0) {
                this.i = (List) pair.second;
            } else {
                this.i.addAll((Collection) pair.second);
            }
            a(true);
        }
    }

    private void c(String str) {
        this.f20703f = 0;
        ((a) this.f19220b).g();
        this.h = str.trim().toLowerCase();
        h();
    }

    /* access modifiers changed from: package-private */
    public void f() {
        a(false);
    }

    public void d(int i2) {
        this.f20704g = i2;
        this.f20703f += 20;
        if (g()) {
            a aVar = this.j;
            aVar.f20705a = true;
            aVar.f20706b = false;
            aVar.run();
            return;
        }
        a(this.f20703f, 20, false);
    }

    public void a(k kVar) {
        if (kVar != null) {
            this.f20703f = 0;
            ((a) this.f19220b).g();
            this.h = kVar.getText().trim().toLowerCase();
            h();
        }
    }

    private void h() {
        if (this.j.f20705a) {
            this.j.f20706b = true;
            this.j = new a();
        }
        this.j.f20705a = true;
        ((a) this.f19220b).postDelayed(this.j, 500);
    }

    public boolean g() {
        return !TextUtils.isEmpty(this.h);
    }

    private class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public boolean f20705a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f20706b;

        private a() {
            this.f20705a = false;
            this.f20706b = false;
        }

        public void run() {
            if (!this.f20706b) {
                com.shopee.app.network.d.d.a.a a2 = new a.C0273a().a(d.this.h).b((Integer) 20).a(Integer.valueOf(d.this.f20703f)).a(d.this.f20700c).a();
                String unused = d.this.k = a2.i().a();
                a2.g();
            }
            this.f20705a = false;
        }
    }
}
