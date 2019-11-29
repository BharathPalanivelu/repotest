package com.shopee.app.ui.chat2.buy;

import android.app.Dialog;
import android.net.Uri;
import android.util.Pair;
import android.view.View;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.Cdo;
import com.shopee.app.d.c.z;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.network.d.al;
import com.shopee.app.network.d.h;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.chat2.a;
import com.shopee.app.ui.common.ae;
import com.shopee.app.util.ak;
import com.shopee.app.web.protocol.AddCartMessage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class b extends q<d> implements ae.a {

    /* renamed from: a  reason: collision with root package name */
    private final z f20370a;

    /* renamed from: c  reason: collision with root package name */
    private final Cdo f20371c;

    /* renamed from: d  reason: collision with root package name */
    private final ak f20372d;

    /* renamed from: e  reason: collision with root package name */
    private final RegionConfig f20373e;

    /* renamed from: f  reason: collision with root package name */
    private i f20374f;

    /* renamed from: g  reason: collision with root package name */
    private int f20375g;
    private int h;
    private List<ItemDetail> i = new ArrayList();
    private int j;
    private int k;
    private a l;
    private Dialog m;
    private boolean n;
    private SettingConfigStore o;

    public b(z zVar, Cdo doVar, ak akVar, RegionConfig regionConfig, SettingConfigStore settingConfigStore, com.shopee.app.tracking.trackingv3.b bVar) {
        this.f20370a = zVar;
        this.f20371c = doVar;
        this.f20372d = akVar;
        this.o = settingConfigStore;
        this.f20373e = regionConfig;
        this.f20374f = com.garena.a.a.a.b.a(this);
    }

    public void a(int i2, int i3) {
        this.f20375g = i2;
        this.k = i3;
        this.l = new a((View) this.f19220b, this.f20372d, this.o);
        i();
        b(this.f20375g);
        c(this.f20375g);
        a(true);
    }

    private void i() {
        new h().g();
    }

    private void b(int i2) {
        new al().a(i2, 0);
    }

    private void c(int i2) {
        new com.shopee.app.network.d.ak().a(i2);
    }

    private void a(boolean z) {
        this.f20370a.a(this.f20375g, this.h, z);
    }

    public void a(ItemDetail itemDetail) {
        this.m = this.l.a(this.f20371c, this.k, this.f20373e, itemDetail);
    }

    public void a() {
        this.f20374f.a();
    }

    public void c() {
        this.n = false;
        this.f20374f.c();
    }

    public void d() {
        this.n = true;
        this.f20374f.d();
    }

    public void b() {
        this.f20374f.b();
    }

    /* access modifiers changed from: package-private */
    public void a(AddCartMessage addCartMessage) {
        String str;
        boolean z = false;
        if (addCartMessage != null) {
            boolean isAddOnly = addCartMessage.isAddOnly();
            str = Uri.encode(String.format(Locale.ENGLISH, "{\"refererItems\":[{\"shopID\":%1$d,\"itemID\":%2$d}],\"source\":\"chat\"}", new Object[]{Integer.valueOf(addCartMessage.shopID), Long.valueOf(addCartMessage.itemID)}));
            z = isAddOnly;
        } else {
            str = "";
        }
        if (!this.n) {
            Dialog dialog = this.m;
            if (dialog != null) {
                dialog.dismiss();
            }
            if (!z) {
                ((d) this.f19220b).a(str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        if (!this.n) {
            this.l.a(aVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Pair<Integer, List<ItemDetail>> pair) {
        if (((Integer) pair.first).intValue() == this.f20375g) {
            this.i = new ArrayList((Collection) pair.second);
            ((d) this.f19220b).a(this.i);
            if (this.i.size() + 1 == this.j) {
                ((d) this.f19220b).e();
            } else {
                ((d) this.f19220b).f();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        a(false);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (this.f20375g == i2) {
            a(false);
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        a(false);
    }

    /* access modifiers changed from: package-private */
    public void g() {
        a(false);
    }

    /* access modifiers changed from: package-private */
    public void h() {
        a(true);
    }

    public void d(int i2) {
        this.h++;
        this.j = i2;
        a(true);
    }
}
