package com.shopee.app.ui.chat2.offer.a;

import android.util.Pair;
import android.view.View;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.Cdo;
import com.shopee.app.d.c.bg;
import com.shopee.app.d.c.dg;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.data.viewmodel.chatP2P.VMOffer;
import com.shopee.app.data.viewmodel.chatP2P.VMOfferHistory;
import com.shopee.app.network.d.aj;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.chat2.a;
import com.shopee.app.ui.common.ae;
import com.shopee.app.ui.common.b.c;
import com.shopee.app.util.ak;
import java.util.List;

public class e extends q<g> implements ae.a {

    /* renamed from: a  reason: collision with root package name */
    private final bg f20573a;

    /* renamed from: c  reason: collision with root package name */
    private final Cdo f20574c;

    /* renamed from: d  reason: collision with root package name */
    private i f20575d = b.a(this);

    /* renamed from: e  reason: collision with root package name */
    private int f20576e;

    /* renamed from: f  reason: collision with root package name */
    private dg f20577f;

    /* renamed from: g  reason: collision with root package name */
    private a f20578g;
    private ak h;
    private SettingConfigStore i;

    public e(bg bgVar, dg dgVar, ak akVar, Cdo doVar, SettingConfigStore settingConfigStore) {
        this.f20573a = bgVar;
        this.f20577f = dgVar;
        this.h = akVar;
        this.i = settingConfigStore;
        this.f20574c = doVar;
    }

    public void a(int i2) {
        this.f20576e = i2;
        this.f20578g = new a((View) this.f19220b, this.h, this.i);
        new aj().a(i2, 0, 20, true);
        new aj().a(i2, 0, 20, false);
        a(false);
    }

    private void a(boolean z) {
        this.f20573a.a(this.f20576e, z);
    }

    public void a() {
        this.f20575d.a();
    }

    public void b() {
        this.f20575d.b();
    }

    public void c() {
        this.f20575d.c();
    }

    public void d() {
        this.f20575d.d();
    }

    /* access modifiers changed from: package-private */
    public void a(Pair<Integer, List<VMOfferHistory>> pair) {
        if (((Integer) pair.first).intValue() == this.f20576e) {
            ((g) this.f19220b).a((List) pair.second);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        if (this.f20576e == i2) {
            a(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        a(false);
    }

    /* access modifiers changed from: package-private */
    public void f() {
        a(false);
    }

    public void d(int i2) {
        a(true);
    }

    /* access modifiers changed from: package-private */
    public void a(ChatMessage chatMessage) {
        ((g) this.f19220b).e();
    }

    /* access modifiers changed from: package-private */
    public void b(Pair<ItemDetail, VMOffer> pair) {
        this.f20578g.a(this.f20574c, this.f20576e, (ItemDetail) pair.first, (VMOffer) pair.second, new c.b() {
            public void a(int i, long j, long j2) {
                ((g) e.this.f19220b).f();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void c(Pair<ItemDetail, VMOffer> pair) {
        this.f20578g.b(this.f20574c, this.f20576e, (ItemDetail) pair.first, (VMOffer) pair.second, new c.b() {
            public void a(int i, long j, long j2) {
                ((g) e.this.f19220b).f();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void a(VMOfferHistory vMOfferHistory) {
        this.f20577f.a(0, this.f20576e, vMOfferHistory.getOffer(), vMOfferHistory.getSnapshot());
        ((g) this.f19220b).f();
    }
}
