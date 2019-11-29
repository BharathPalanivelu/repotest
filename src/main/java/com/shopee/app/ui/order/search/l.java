package com.shopee.app.ui.order.search;

import android.text.TextUtils;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.network.d.an;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.common.p;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l extends q<o> implements p.a {

    /* renamed from: a  reason: collision with root package name */
    List<f> f23829a = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final i f23830c;

    /* renamed from: d  reason: collision with root package name */
    private n f23831d;

    /* renamed from: e  reason: collision with root package name */
    private UserInfo f23832e;

    /* renamed from: f  reason: collision with root package name */
    private final SettingConfigStore f23833f;

    /* renamed from: g  reason: collision with root package name */
    private d f23834g;
    private int h;
    private int i;
    private int j;
    private int k = 0;
    private String l;

    public l(n nVar, UserInfo userInfo, SettingConfigStore settingConfigStore, d dVar) {
        this.f23831d = nVar;
        this.f23832e = userInfo;
        this.f23833f = settingConfigStore;
        this.f23834g = dVar;
        this.f23830c = b.a(this);
    }

    public void a() {
        this.f23830c.a();
    }

    public void c() {
        super.c();
        this.f23830c.c();
    }

    public void d() {
        super.d();
        this.f23830c.d();
    }

    public void a(int i2, int i3) {
        this.h = i2;
        this.i = i3;
    }

    public void b() {
        this.f23830c.b();
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
    public void c(String str) {
        this.l = str;
        ArrayList arrayList = new ArrayList();
        if (this.f23833f.searchRecipientEnabled()) {
            arrayList.add(3);
        }
        arrayList.addAll(Arrays.asList(new Integer[]{1, 2}));
        this.f23834g.a(arrayList, this.f23832e.getShopId(), str, 3, 0, this.h);
    }

    /* access modifiers changed from: package-private */
    public void a(List<f> list) {
        if (this.h == 0) {
            b(list);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        ArrayList arrayList = new ArrayList();
        if (this.h == 0) {
            b((List<f>) arrayList);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(List<f> list) {
        if (!af.a(list)) {
            ((o) this.f19220b).c();
            ((o) this.f19220b).a(list);
            if (list.size() + 1 == this.j) {
                ((o) this.f19220b).d();
            } else {
                ((o) this.f19220b).e();
            }
        } else if (!TextUtils.isEmpty(this.l)) {
            ((o) this.f19220b).f();
        } else {
            ((o) this.f19220b).b();
        }
    }

    /* access modifiers changed from: package-private */
    public void c(List<f> list) {
        if (this.h == 1) {
            this.f23829a.addAll(list);
            b(this.f23829a);
        }
    }

    public void a(String str, int i2) {
        this.l = str;
        String str2 = str;
        new an(Arrays.asList(new Integer[]{Integer.valueOf(this.i)}), this.f23832e.getShopId(), str2, 20, 0, this.h).g();
        this.f23829a.clear();
    }

    private void f() {
        new an(Arrays.asList(new Integer[]{Integer.valueOf(this.i)}), this.f23832e.getShopId(), this.l, 20, this.k, this.h).g();
    }

    public void c(int i2) {
        this.j = i2;
        this.k += 20;
        f();
    }
}
