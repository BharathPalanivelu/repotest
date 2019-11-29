package com.shopee.app.ui.chat2.offer.b;

import android.util.Pair;
import android.view.View;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.Cdo;
import com.shopee.app.d.c.be;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.chatP2P.VMOffer;
import com.shopee.app.network.d.al;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.common.ae;
import com.shopee.app.ui.common.b.c;
import com.shopee.app.util.ak;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class a extends q<c> implements ae.a {

    /* renamed from: a  reason: collision with root package name */
    private final be f20609a;

    /* renamed from: c  reason: collision with root package name */
    private final Cdo f20610c;

    /* renamed from: d  reason: collision with root package name */
    private i f20611d;

    /* renamed from: e  reason: collision with root package name */
    private int f20612e;

    /* renamed from: f  reason: collision with root package name */
    private int f20613f;

    /* renamed from: g  reason: collision with root package name */
    private int f20614g;
    private ArrayList<ItemDetail> h = new ArrayList<>();
    private int i;
    private com.shopee.app.ui.chat2.a j;
    private ak k;
    private SettingConfigStore l;

    public a(be beVar, ak akVar, Cdo doVar, SettingConfigStore settingConfigStore) {
        this.f20609a = beVar;
        this.f20610c = doVar;
        this.k = akVar;
        this.l = settingConfigStore;
        this.f20611d = b.a(this);
    }

    public void a(int i2, int i3) {
        this.f20612e = i2;
        this.i = i3;
        this.j = new com.shopee.app.ui.chat2.a((View) this.f19220b, this.k, this.l);
        g();
        b(i2);
        c(i2);
    }

    private void b(int i2) {
        new al().a(i2, 0);
    }

    private void c(int i2) {
        new com.shopee.app.network.d.ak().a(i2);
    }

    private void g() {
        this.f20609a.a(this.f20612e, this.f20613f, true);
    }

    public void a(ItemDetail itemDetail) {
        this.j.a(this.f20610c, this.i, itemDetail, (VMOffer) null, new c.b() {
            public void a(int i, long j, long j2) {
                ((c) a.this.f19220b).g();
            }
        });
    }

    public void a() {
        this.f20611d.a();
    }

    public void b() {
        this.f20611d.b();
    }

    /* access modifiers changed from: package-private */
    public void a(Pair<Integer, List<ItemDetail>> pair) {
        if (((Integer) pair.first).intValue() == this.f20612e) {
            this.h = new ArrayList<>((Collection) pair.second);
            ((c) this.f19220b).a(this.h);
            if (this.h.size() + 1 == this.f20614g) {
                ((c) this.f19220b).e();
            } else {
                ((c) this.f19220b).f();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        g();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (this.f20612e == i2) {
            g();
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        g();
    }

    public void d(int i2) {
        this.f20613f++;
        this.f20614g = i2;
        g();
    }
}
