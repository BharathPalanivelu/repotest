package com.shopee.app.ui.chat2.product.b;

import android.text.TextUtils;
import android.util.Pair;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.ad;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.network.d.u;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.actionbar.k;
import com.shopee.app.ui.common.ae;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class d extends q<a> implements ae.a {

    /* renamed from: a  reason: collision with root package name */
    private final i f20732a;

    /* renamed from: c  reason: collision with root package name */
    private int f20733c;

    /* renamed from: d  reason: collision with root package name */
    private String f20734d;

    /* renamed from: e  reason: collision with root package name */
    private final ad f20735e;

    /* renamed from: f  reason: collision with root package name */
    private int f20736f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f20737g;
    private String h = "";
    private a i;

    public d(UserInfo userInfo, ad adVar) {
        this.f20733c = userInfo.getShopId();
        this.f20735e = adVar;
        this.f20732a = b.a(this);
        this.i = new a();
    }

    public void a(int i2, int i3, String str) {
        this.f20733c = i2;
        this.f20736f = i3;
        this.f20734d = str;
        h();
        a(i2);
    }

    /* access modifiers changed from: private */
    public void h() {
        this.f20735e.a(this.f20733c, this.f20736f, false, this.h);
        ((a) this.f19220b).a(!TextUtils.isEmpty(this.h));
    }

    private void a(int i2) {
        new u().a(i2, false);
    }

    public void a() {
        this.f20732a.a();
    }

    public void c() {
        this.f20732a.c();
    }

    public void d() {
        this.f20732a.d();
    }

    public void b() {
        this.f20732a.b();
    }

    /* access modifiers changed from: package-private */
    public void a(Pair<Integer, List<ItemDetail>> pair) {
        if (((Integer) pair.first).intValue() == this.f20733c) {
            ArrayList arrayList = new ArrayList((Collection) pair.second);
            ((a) this.f19220b).a((List<ItemDetail>) arrayList);
            if (arrayList.size() + 1 == this.f20737g) {
                ((a) this.f19220b).e();
            } else {
                ((a) this.f19220b).f();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        h();
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

    private void c(String str) {
        this.f20736f = 0;
        this.h = str.trim().toLowerCase();
        if (!this.i.f20738a) {
            this.i.f20738a = true;
            ((a) this.f19220b).postDelayed(this.i, 500);
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        h();
    }

    public void d(int i2) {
        this.f20737g = i2;
        h();
    }

    public void a(k kVar) {
        if (kVar != null) {
            this.f20736f = 0;
            this.h = kVar.getText().trim().toLowerCase();
            i();
        }
    }

    private void i() {
        if (this.i.f20738a) {
            this.i.f20739b = true;
            this.i = new a();
        }
        this.i.f20738a = true;
        ((a) this.f19220b).postDelayed(this.i, 500);
    }

    private class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public boolean f20738a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f20739b;

        private a() {
            this.f20738a = false;
            this.f20739b = false;
        }

        public void run() {
            if (!this.f20739b) {
                d.this.h();
            }
            this.f20738a = false;
        }
    }
}
