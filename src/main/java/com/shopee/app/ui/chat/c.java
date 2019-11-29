package com.shopee.app.ui.chat;

import android.app.Activity;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.Cdo;
import com.shopee.app.d.c.aa;
import com.shopee.app.d.c.ad;
import com.shopee.app.d.c.ae;
import com.shopee.app.d.c.ag;
import com.shopee.app.d.c.ah;
import com.shopee.app.d.c.as;
import com.shopee.app.d.c.at;
import com.shopee.app.d.c.au;
import com.shopee.app.d.c.av;
import com.shopee.app.d.c.be;
import com.shopee.app.d.c.bf;
import com.shopee.app.d.c.bm;
import com.shopee.app.d.c.br;
import com.shopee.app.d.c.bs;
import com.shopee.app.d.c.bx;
import com.shopee.app.d.c.by;
import com.shopee.app.d.c.bz;
import com.shopee.app.d.c.ca;
import com.shopee.app.d.c.ce;
import com.shopee.app.d.c.cf;
import com.shopee.app.d.c.cl;
import com.shopee.app.d.c.co;
import com.shopee.app.d.c.dg;
import com.shopee.app.d.c.dh;
import com.shopee.app.d.c.di;
import com.shopee.app.d.c.dn;
import com.shopee.app.d.c.dp;
import com.shopee.app.d.c.dq;
import com.shopee.app.d.c.dr;
import com.shopee.app.d.c.ds;
import com.shopee.app.d.c.dt;
import com.shopee.app.d.c.du;
import com.shopee.app.d.c.ed;
import com.shopee.app.d.c.ee;
import com.shopee.app.d.c.f.g;
import com.shopee.app.d.c.f.h;
import com.shopee.app.d.c.f.m;
import com.shopee.app.d.c.f.o;
import com.shopee.app.d.c.j;
import com.shopee.app.d.c.q;
import com.shopee.app.d.c.z;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.data.store.RegionConfigStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.am;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.az;
import com.shopee.app.data.store.bb;
import com.shopee.app.data.store.bg;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.store.l;
import com.shopee.app.data.store.p;
import com.shopee.app.data.store.x;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.ui.actionbar.k;
import com.shopee.app.ui.chat.cell.aj;
import com.shopee.app.ui.chat2.s;
import com.shopee.app.ui.chat2.t;
import com.shopee.app.ui.chat2.u;
import com.shopee.app.ui.chat2.w;
import com.shopee.app.ui.chat2.y;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.ui.common.af;
import com.shopee.app.ui.common.i;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.common.v;
import com.shopee.app.ui.home.me.v3.OptionBox;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f20008a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f20009b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f20010c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f20011d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f20012e;

    /* renamed from: f  reason: collision with root package name */
    private C0304c f20013f;

    /* renamed from: g  reason: collision with root package name */
    private Provider<RegionConfig> f20014g;
    private d h;
    private Provider<com.shopee.app.tracking.trackingv3.b> i;
    private Provider<Activity> j;
    private Provider<com.shopee.app.ui.actionbar.a> k;
    private Provider<r> l;
    private b m;
    private Provider<com.shopee.app.ui.common.a> n;
    private f o;
    private e p;
    private Provider<com.shopee.app.a.a.a> q;

    private c(a aVar) {
        a(aVar);
    }

    public static a c() {
        return new a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private ag e() {
        return ah.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new ao(), new p());
    }

    private br f() {
        return bs.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new ao(), new com.shopee.app.data.store.ah());
    }

    private v g() {
        return new v((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), e(), f());
    }

    private af h() {
        return new af((bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private as i() {
        return at.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new ao(), new com.shopee.app.data.store.ah());
    }

    private Cdo j() {
        return new Cdo((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new p(), new bh(), (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.b.a k() {
        return new com.shopee.app.ui.common.b.a(i(), j());
    }

    private com.shopee.app.ui.common.a.a l() {
        return new com.shopee.app.ui.common.a.a(i());
    }

    private com.shopee.app.d.c.b m() {
        return new com.shopee.app.d.c.b((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new p(), new bh(), (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.chat2.send.d n() {
        return new com.shopee.app.ui.chat2.send.d((bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.c o() {
        return com.shopee.app.d.c.c.d.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), com.shopee.app.data.store.as.b());
    }

    private dh p() {
        return new dh((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new p(), (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.chat2.a.b q() {
        return new com.shopee.app.ui.chat2.a.b((UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), f(), o(), p(), j());
    }

    private com.shopee.app.ui.chat2.product.e r() {
        return new com.shopee.app.ui.chat2.product.e((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.chat2.product.c s() {
        return new com.shopee.app.ui.chat2.product.c((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private au t() {
        return av.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.ah(), new ao());
    }

    private com.shopee.app.d.c.h.a u() {
        return com.shopee.app.d.c.h.b.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.ah(), new ao());
    }

    private com.shopee.app.ui.chat2.product.a.d v() {
        return new com.shopee.app.ui.chat2.product.a.d((UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), t(), u());
    }

    private be w() {
        return bf.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (az) b.a.c.a(this.f20008a.productListStore(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.ah(), new ao());
    }

    private com.shopee.app.ui.chat2.product.c.d x() {
        return new com.shopee.app.ui.chat2.product.c.d((UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), w(), u());
    }

    private ad y() {
        return ae.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (az) b.a.c.a(this.f20008a.productListStore(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.ah(), new ao());
    }

    private com.shopee.app.ui.chat2.product.b.d z() {
        return new com.shopee.app.ui.chat2.product.b.d((UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), y());
    }

    private j A() {
        return com.shopee.app.d.c.k.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new p(), new com.shopee.app.data.store.av(), (ChatBadgeStore) b.a.c.a(this.f20008a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.f.i B() {
        return com.shopee.app.d.c.f.j.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bg(), new com.shopee.app.data.store.av());
    }

    private o C() {
        return com.shopee.app.d.c.f.p.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bg(), new p(), (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f20008a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.ah(), new com.shopee.app.data.store.c.c(), (x) b.a.c.a(this.f20008a.customerOrderCountStore(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.av());
    }

    private ce D() {
        return cf.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new p(), new com.shopee.app.data.store.av(), (ChatBadgeStore) b.a.c.a(this.f20008a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private m E() {
        return com.shopee.app.d.c.f.n.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.data.store.o) b.a.c.a(this.f20008a.chatListLoadingStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.chat2.search.b F() {
        return new com.shopee.app.ui.chat2.search.b(A(), B(), C(), D(), E(), (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a G() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f20008a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n H() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f20008a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i I() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f20008a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private s J() {
        return t.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (SettingConfigStore) b.a.c.a(this.f20008a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"), (am) b.a.c.a(this.f20008a.messageShortcutStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.chat2.ad K() {
        return new com.shopee.app.ui.chat2.ad(J());
    }

    private w L() {
        return new w(J());
    }

    private cl M() {
        return new cl((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bh(), new com.shopee.app.data.store.c.e(), new com.shopee.app.data.store.ah(), new ao(), new com.shopee.app.data.store.c.c());
    }

    private dq N() {
        return dr.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new p(), new com.shopee.app.data.store.av(), (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.chat.order.a O() {
        return new com.shopee.app.ui.chat.order.a((bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), (n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), M(), N());
    }

    private com.shopee.app.d.c.af P() {
        return new com.shopee.app.d.c.af((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new p(), (com.shopee.app.tracking.a) b.a.c.a(this.f20008a.actionTracker(), "Cannot return null from a non-@Nullable component method"), com.shopee.app.data.store.as.b(), (com.shopee.app.data.store.j) b.a.c.a(this.f20008a.blacklistStore(), "Cannot return null from a non-@Nullable component method"), (SettingConfigStore) b.a.c.a(this.f20008a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"), (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
    }

    private du Q() {
        return new du((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new p(), new com.shopee.app.data.store.av(), (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), (JobManager) b.a.c.a(this.f20008a.jobManager(), "Cannot return null from a non-@Nullable component method"));
    }

    private dn R() {
        return new dn((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new p(), new com.shopee.app.data.store.av(), (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), (JobManager) b.a.c.a(this.f20008a.jobManager(), "Cannot return null from a non-@Nullable component method"), (SettingConfigStore) b.a.c.a(this.f20008a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private ds S() {
        return new ds((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new p(), new com.shopee.app.data.store.av(), (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), (JobManager) b.a.c.a(this.f20008a.jobManager(), "Cannot return null from a non-@Nullable component method"));
    }

    private dp T() {
        return new dp((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new p(), new com.shopee.app.data.store.av(), (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), (JobManager) b.a.c.a(this.f20008a.jobManager(), "Cannot return null from a non-@Nullable component method"));
    }

    private dt U() {
        return new dt((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new p(), new com.shopee.app.data.store.av(), (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), (JobManager) b.a.c.a(this.f20008a.jobManager(), "Cannot return null from a non-@Nullable component method"));
    }

    private co V() {
        return new co((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.c.c(), new com.shopee.app.data.store.ah(), new ao());
    }

    private com.shopee.app.ui.chat2.block.o W() {
        return com.shopee.app.ui.chat2.block.p.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), l.b());
    }

    private di X() {
        return new di((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new p(), new com.shopee.app.data.store.av(), (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), (JobManager) b.a.c.a(this.f20008a.jobManager(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.n Y() {
        return new com.shopee.app.d.c.n((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new p(), new com.shopee.app.data.store.av(), (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), (JobManager) b.a.c.a(this.f20008a.jobManager(), "Cannot return null from a non-@Nullable component method"));
    }

    private bz Z() {
        return ca.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bh());
    }

    private bm aa() {
        return new bm((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bh(), new com.shopee.app.data.store.c.c(), new com.shopee.app.data.store.r(), new com.shopee.app.data.store.c.e(), (SettingConfigStore) b.a.c.a(this.f20008a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.c.b(), new com.shopee.app.data.store.ah(), new ao(), (bb) b.a.c.a(this.f20008a.ratingShopeeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private bx ab() {
        return by.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), b.a.a.b(this.o), b.a.a.b(this.p));
    }

    private com.shopee.app.d.c.p ac() {
        return q.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), b.a.a.b(this.o), b.a.a.b(this.p));
    }

    private com.shopee.app.ui.chat2.j ad() {
        return new com.shopee.app.ui.chat2.j(P(), Q(), R(), A(), j(), S(), T(), U(), V(), W(), X(), Y(), Z(), J(), (SettingConfigStore) b.a.c.a(this.f20008a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"), aa(), aa(), ab(), ac(), this.f20009b.get(), (com.garena.sticker.b) b.a.c.a(this.f20008a.stickerManager(), "Cannot return null from a non-@Nullable component method"), this.f20014g.get(), this.i.get());
    }

    private com.shopee.app.d.c.f.c ae() {
        return com.shopee.app.d.c.f.d.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bg(), new p(), (ChatBadgeStore) b.a.c.a(this.f20008a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.ah(), new com.shopee.app.data.store.c.c(), (x) b.a.c.a(this.f20008a.customerOrderCountStore(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.av(), (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.f.e af() {
        return com.shopee.app.d.c.f.f.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bg(), new p(), (ChatBadgeStore) b.a.c.a(this.f20008a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.ah(), new com.shopee.app.data.store.c.c(), (x) b.a.c.a(this.f20008a.customerOrderCountStore(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.av(), (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
    }

    private g ag() {
        return h.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bg(), new p(), (ChatBadgeStore) b.a.c.a(this.f20008a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.ah(), new com.shopee.app.data.store.c.c(), (x) b.a.c.a(this.f20008a.customerOrderCountStore(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.av(), (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.f.k ah() {
        return com.shopee.app.d.c.f.l.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.av());
    }

    private com.shopee.app.d.c.f.a ai() {
        return com.shopee.app.d.c.f.b.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bg(), new p(), (ChatBadgeStore) b.a.c.a(this.f20008a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.ah(), new com.shopee.app.data.store.c.c(), (x) b.a.c.a(this.f20008a.customerOrderCountStore(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.av(), (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
    }

    private ed aj() {
        return ee.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.data.store.j) b.a.c.a(this.f20008a.blacklistStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.chat2.e ak() {
        return new com.shopee.app.ui.chat2.e(ae(), af(), A(), ag(), ah(), E(), ai(), D(), aj(), (ChatBadgeStore) b.a.c.a(this.f20008a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.chat2.offer.b.a al() {
        return new com.shopee.app.ui.chat2.offer.b.a(w(), this.f20009b.get(), j(), (SettingConfigStore) b.a.c.a(this.f20008a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private z am() {
        return aa.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (az) b.a.c.a(this.f20008a.productListStore(), "Cannot return null from a non-@Nullable component method"), com.shopee.app.data.store.as.b(), new com.shopee.app.data.store.ah(), new ao());
    }

    private com.shopee.app.ui.chat2.buy.b an() {
        return new com.shopee.app.ui.chat2.buy.b(am(), j(), this.f20009b.get(), this.f20014g.get(), (SettingConfigStore) b.a.c.a(this.f20008a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"), this.i.get());
    }

    private com.shopee.app.ui.chat2.product.k ao() {
        return new com.shopee.app.ui.chat2.product.k((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), w(), t());
    }

    private com.shopee.app.ui.chat2.order.b ap() {
        return new com.shopee.app.ui.chat2.order.b(aa());
    }

    private com.shopee.app.d.c.bg aq() {
        return com.shopee.app.d.c.bh.a((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (az) b.a.c.a(this.f20008a.productListStore(), "Cannot return null from a non-@Nullable component method"), com.shopee.app.data.store.as.b(), new com.shopee.app.data.store.ah(), new ao());
    }

    private dg ar() {
        return new dg((n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new p(), (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), (JobManager) b.a.c.a(this.f20008a.jobManager(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.chat2.offer.a.e as() {
        return new com.shopee.app.ui.chat2.offer.a.e(aq(), ar(), this.f20009b.get(), j(), (SettingConfigStore) b.a.c.a(this.f20008a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private void a(a aVar) {
        this.f20009b = b.a.a.a(com.shopee.app.a.o.a(aVar.f20015a));
        this.f20008a = aVar.f20016b;
        this.f20010c = b.a.a.a(com.shopee.app.a.r.a(aVar.f20015a));
        this.f20011d = b.a.a.a(com.shopee.app.a.s.a(aVar.f20015a));
        this.f20012e = b.a.a.a(com.shopee.app.a.t.a(aVar.f20015a));
        this.f20013f = new C0304c(aVar.f20016b);
        this.f20014g = b.a.a.a(com.shopee.app.a.q.a(aVar.f20015a, this.f20013f));
        this.h = new d(aVar.f20016b);
        this.i = b.a.a.a(com.shopee.app.a.w.a(aVar.f20015a, this.h));
        this.j = b.a.a.a(com.shopee.app.a.d.a(aVar.f20015a));
        this.k = b.a.a.a(com.shopee.app.a.c.a(aVar.f20015a));
        this.l = b.a.a.a(com.shopee.app.a.m.a(aVar.f20015a));
        this.m = new b(aVar.f20016b);
        this.n = b.a.a.a(com.shopee.app.a.f.a(aVar.f20015a, this.m));
        this.o = new f(aVar.f20016b);
        this.p = new e(aVar.f20016b);
        this.q = b.a.a.a(com.shopee.app.a.e.a(aVar.f20015a));
    }

    public void a(AvatarView avatarView) {
        b(avatarView);
    }

    public void a(k kVar) {
        b(kVar);
    }

    public void a(MaterialTabView materialTabView) {
        b(materialTabView);
    }

    public void a(com.shopee.app.ui.product.a.a aVar) {
        b(aVar);
    }

    public void a(OptionRow optionRow) {
        b(optionRow);
    }

    public void a(OptionBox optionBox) {
        b(optionBox);
    }

    public ak a() {
        return this.f20009b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f20012e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.common.w wVar) {
        b(wVar);
    }

    public void a(com.shopee.app.ui.common.ag agVar) {
        b(agVar);
    }

    public void a(com.shopee.app.ui.order.detail.k kVar) {
        b(kVar);
    }

    public void a(com.shopee.app.ui.chat.cell.b bVar) {
        b(bVar);
    }

    public void a(com.shopee.app.ui.common.b.c cVar) {
        b(cVar);
    }

    public void a(com.shopee.app.ui.common.a.c cVar) {
        b(cVar);
    }

    public void a(com.shopee.app.ui.chat2.send.e eVar) {
        b(eVar);
    }

    public void a(com.shopee.app.ui.chat2.a.d dVar) {
        b(dVar);
    }

    public void a(com.shopee.app.ui.chat2.product.q qVar) {
        b(qVar);
    }

    public void a(com.shopee.app.ui.chat2.product.n nVar) {
        b(nVar);
    }

    public void a(com.shopee.app.ui.chat2.product.a.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.chat2.product.c.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.chat2.product.b.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.order.views.m mVar) {
        b(mVar);
    }

    public void a(com.shopee.app.ui.chat.cell.s sVar) {
        b(sVar);
    }

    public void a(com.shopee.app.ui.chat2.offer.a.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.chat2.search.d dVar) {
        b(dVar);
    }

    public void a(u uVar) {
        b(uVar);
    }

    public void a(com.shopee.app.ui.chat2.af afVar) {
        b(afVar);
    }

    public void a(com.shopee.app.ui.chat2.v vVar) {
        b(vVar);
    }

    public void a(y yVar) {
        b(yVar);
    }

    public void a(com.shopee.app.ui.chat2.b.d dVar) {
        b(dVar);
    }

    public void a(a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.chat.order.b bVar) {
        b(bVar);
    }

    public void a(com.shopee.app.ui.chat.cell.y yVar) {
        b(yVar);
    }

    public void a(com.shopee.app.ui.chat.cell.m mVar) {
        b(mVar);
    }

    public void a(com.shopee.app.ui.chat2.n nVar) {
        b(nVar);
    }

    public void a(com.shopee.app.ui.chat2.g gVar) {
        b(gVar);
    }

    public void a(com.shopee.app.ui.chat2.send.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.chat2.product.g gVar) {
        b(gVar);
    }

    public void a(com.shopee.app.ui.chat2.offer.b bVar) {
        b(bVar);
    }

    public void a(com.shopee.app.ui.chat2.offer.b.c cVar) {
        b(cVar);
    }

    public void a(com.shopee.app.ui.chat2.buy.d dVar) {
        b(dVar);
    }

    public void a(com.shopee.app.ui.chat2.buy.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.chat2.product.h hVar) {
        b(hVar);
    }

    public void a(com.shopee.app.ui.chat.cell.v vVar) {
        b(vVar);
    }

    public void a(com.shopee.app.ui.chat.cell.ah ahVar) {
        b(ahVar);
    }

    public void a(com.shopee.app.ui.chat2.order.f fVar) {
        b(fVar);
    }

    public void a(com.shopee.app.ui.chat2.order.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.chat.cell.p pVar) {
        b(pVar);
    }

    public void a(com.shopee.app.ui.chat2.search.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.chat2.offer.a.g gVar) {
        b(gVar);
    }

    public void a(com.shopee.app.ui.chat2.order.singletab.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.chat2.b bVar) {
        b(bVar);
    }

    public void a(com.shopee.app.ui.chat2.offer.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.chat.cell.g gVar) {
        b(gVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f20009b.get());
        return avatarView;
    }

    private k b(k kVar) {
        com.shopee.app.ui.actionbar.l.a(kVar, (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbar.l.a(kVar, this.f20010c.get());
        com.shopee.app.ui.actionbar.l.a(kVar, d());
        com.shopee.app.ui.actionbar.l.a(kVar, this.f20009b.get());
        com.shopee.app.ui.actionbar.l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f20008a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f20011d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f20009b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f20009b.get());
        return aVar;
    }

    private com.shopee.app.ui.common.w b(com.shopee.app.ui.common.w wVar) {
        com.shopee.app.ui.common.x.a(wVar, g());
        com.shopee.app.ui.common.x.a(wVar, this.f20010c.get());
        com.shopee.app.ui.common.x.a(wVar, this.f20009b.get());
        return wVar;
    }

    private com.shopee.app.ui.common.ag b(com.shopee.app.ui.common.ag agVar) {
        com.shopee.app.ui.common.ah.a(agVar, h());
        com.shopee.app.ui.common.ah.a(agVar, (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.common.ah.a(agVar, this.f20010c.get());
        com.shopee.app.ui.common.ah.a(agVar, (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return agVar;
    }

    private com.shopee.app.ui.order.detail.k b(com.shopee.app.ui.order.detail.k kVar) {
        com.shopee.app.ui.order.detail.m.a(kVar, (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.order.detail.m.a(kVar, this.f20009b.get());
        com.shopee.app.ui.order.detail.m.a(kVar, new ao());
        return kVar;
    }

    private com.shopee.app.ui.chat.cell.b b(com.shopee.app.ui.chat.cell.b bVar) {
        com.shopee.app.ui.chat.cell.d.a(bVar, (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.chat.cell.d.a(bVar, this.f20014g.get());
        return bVar;
    }

    private com.shopee.app.ui.common.b.c b(com.shopee.app.ui.common.b.c cVar) {
        com.shopee.app.ui.common.b.e.a(cVar, k());
        com.shopee.app.ui.common.b.e.a(cVar, this.f20010c.get());
        com.shopee.app.ui.common.b.e.a(cVar, (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.common.b.e.a(cVar, this.f20014g.get());
        com.shopee.app.ui.common.b.e.a(cVar, (SettingConfigStore) b.a.c.a(this.f20008a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.common.b.e.a(cVar, (com.shopee.app.util.s) b.a.c.a(this.f20008a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.common.b.e.a(cVar, this.i.get());
        return cVar;
    }

    private com.shopee.app.ui.common.a.c b(com.shopee.app.ui.common.a.c cVar) {
        com.shopee.app.ui.common.a.e.a(cVar, l());
        com.shopee.app.ui.common.a.e.a(cVar, this.f20010c.get());
        com.shopee.app.ui.common.a.e.a(cVar, (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.common.a.e.a(cVar, (com.shopee.app.tracking.f) b.a.c.a(this.f20008a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.common.a.e.a(cVar, this.i.get());
        com.shopee.app.ui.common.a.e.a(cVar, this.f20014g.get());
        com.shopee.app.ui.common.a.e.a(cVar, (SettingConfigStore) b.a.c.a(this.f20008a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.common.a.e.a(cVar, (com.shopee.app.util.s) b.a.c.a(this.f20008a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.common.a.e.a(cVar, this.f20009b.get());
        com.shopee.app.ui.common.a.e.a(cVar, m());
        com.shopee.app.ui.common.a.e.a(cVar, (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.common.a.e.a(cVar, this.j.get());
        return cVar;
    }

    private com.shopee.app.ui.chat2.send.e b(com.shopee.app.ui.chat2.send.e eVar) {
        com.shopee.app.ui.chat2.send.f.a(eVar, n());
        com.shopee.app.ui.chat2.send.f.a(eVar, this.f20010c.get());
        com.shopee.app.ui.chat2.send.f.a(eVar, (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        return eVar;
    }

    private com.shopee.app.ui.chat2.a.d b(com.shopee.app.ui.chat2.a.d dVar) {
        com.shopee.app.ui.chat2.a.f.a(dVar, q());
        com.shopee.app.ui.chat2.a.f.a(dVar, this.f20010c.get());
        com.shopee.app.ui.chat2.a.f.a(dVar, this.f20009b.get());
        return dVar;
    }

    private com.shopee.app.ui.chat2.product.q b(com.shopee.app.ui.chat2.product.q qVar) {
        com.shopee.app.ui.chat2.product.s.a(qVar, (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.chat2.product.s.a(qVar, (n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.chat2.product.s.a(qVar, this.f20010c.get());
        com.shopee.app.ui.chat2.product.s.a(qVar, r());
        return qVar;
    }

    private com.shopee.app.ui.chat2.product.n b(com.shopee.app.ui.chat2.product.n nVar) {
        com.shopee.app.ui.chat2.product.p.a(nVar, this.f20010c.get());
        com.shopee.app.ui.chat2.product.p.a(nVar, s());
        com.shopee.app.ui.chat2.product.p.a(nVar, this.k.get());
        com.shopee.app.ui.chat2.product.p.a(nVar, (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return nVar;
    }

    private com.shopee.app.ui.chat2.product.a.a b(com.shopee.app.ui.chat2.product.a.a aVar) {
        com.shopee.app.ui.chat2.product.a.c.a(aVar, this.f20010c.get());
        com.shopee.app.ui.chat2.product.a.c.a(aVar, v());
        com.shopee.app.ui.chat2.product.a.c.a(aVar, this.j.get());
        com.shopee.app.ui.chat2.product.a.c.a(aVar, this.k.get());
        return aVar;
    }

    private com.shopee.app.ui.chat2.product.c.a b(com.shopee.app.ui.chat2.product.c.a aVar) {
        com.shopee.app.ui.chat2.product.c.c.a(aVar, this.f20010c.get());
        com.shopee.app.ui.chat2.product.c.c.a(aVar, x());
        com.shopee.app.ui.chat2.product.c.c.a(aVar, this.j.get());
        com.shopee.app.ui.chat2.product.c.c.a(aVar, this.k.get());
        return aVar;
    }

    private com.shopee.app.ui.chat2.product.b.a b(com.shopee.app.ui.chat2.product.b.a aVar) {
        com.shopee.app.ui.chat2.product.b.c.a(aVar, this.f20010c.get());
        com.shopee.app.ui.chat2.product.b.c.a(aVar, z());
        com.shopee.app.ui.chat2.product.b.c.a(aVar, this.j.get());
        com.shopee.app.ui.chat2.product.b.c.a(aVar, this.k.get());
        return aVar;
    }

    private com.shopee.app.ui.order.views.m b(com.shopee.app.ui.order.views.m mVar) {
        com.shopee.app.ui.order.views.o.a(mVar, this.f20009b.get());
        return mVar;
    }

    private com.shopee.app.ui.chat.cell.s b(com.shopee.app.ui.chat.cell.s sVar) {
        com.shopee.app.ui.chat.cell.u.a(sVar, this.f20009b.get());
        com.shopee.app.ui.chat.cell.u.a(sVar, new ao());
        com.shopee.app.ui.chat.cell.u.a(sVar, (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return sVar;
    }

    private com.shopee.app.ui.chat2.offer.a.a b(com.shopee.app.ui.chat2.offer.a.a aVar) {
        com.shopee.app.ui.chat2.offer.a.c.a(aVar, this.j.get());
        com.shopee.app.ui.chat2.offer.a.c.a(aVar, this.f20009b.get());
        com.shopee.app.ui.chat2.offer.a.c.a(aVar, (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.chat2.offer.a.c.a(aVar, (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return aVar;
    }

    private com.shopee.app.ui.chat2.search.d b(com.shopee.app.ui.chat2.search.d dVar) {
        com.shopee.app.ui.chat2.search.f.a(dVar, F());
        com.shopee.app.ui.chat2.search.f.a(dVar, this.f20010c.get());
        com.shopee.app.ui.chat2.search.f.a(dVar, new com.shopee.app.h.m());
        com.shopee.app.ui.chat2.search.f.a(dVar, this.j.get());
        com.shopee.app.ui.chat2.search.f.a(dVar, this.f20009b.get());
        com.shopee.app.ui.chat2.search.f.a(dVar, (com.shopee.app.data.store.be) b.a.c.a(this.f20008a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.chat2.search.f.a(dVar, this.l.get());
        return dVar;
    }

    private u b(u uVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) uVar, (n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) uVar, (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) uVar, (com.shopee.app.application.a.b) b.a.c.a(this.f20008a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) uVar, this.l.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) uVar, (com.shopee.app.tracking.f) b.a.c.a(this.f20008a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) uVar, (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) uVar, this.n.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) uVar, this.f20009b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) uVar, (com.shopee.app.d.c.f) b.a.c.a(this.f20008a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) uVar, (com.shopee.app.tracking.a) b.a.c.a(this.f20008a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) uVar, this.i.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) uVar, (al) b.a.c.a(this.f20008a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) uVar, (ActionRequiredCounter) b.a.c.a(this.f20008a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) uVar, (ActivityCounter) b.a.c.a(this.f20008a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) uVar, G());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) uVar, this.n.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) uVar, H());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) uVar, I());
        return uVar;
    }

    private com.shopee.app.ui.chat2.af b(com.shopee.app.ui.chat2.af afVar) {
        com.shopee.app.ui.chat2.ah.a(afVar, this.l.get());
        com.shopee.app.ui.chat2.ah.a(afVar, this.f20010c.get());
        com.shopee.app.ui.chat2.ah.a(afVar, K());
        com.shopee.app.ui.chat2.ah.a(afVar, (SettingConfigStore) b.a.c.a(this.f20008a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.chat2.ah.a(afVar, this.j.get());
        com.shopee.app.ui.chat2.ah.a(afVar, this.f20009b.get());
        return afVar;
    }

    private com.shopee.app.ui.chat2.v b(com.shopee.app.ui.chat2.v vVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) vVar, (n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) vVar, (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) vVar, (com.shopee.app.application.a.b) b.a.c.a(this.f20008a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) vVar, this.l.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) vVar, (com.shopee.app.tracking.f) b.a.c.a(this.f20008a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) vVar, (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) vVar, this.n.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) vVar, this.f20009b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) vVar, (com.shopee.app.d.c.f) b.a.c.a(this.f20008a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) vVar, (com.shopee.app.tracking.a) b.a.c.a(this.f20008a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) vVar, this.i.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) vVar, (al) b.a.c.a(this.f20008a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) vVar, (ActionRequiredCounter) b.a.c.a(this.f20008a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) vVar, (ActivityCounter) b.a.c.a(this.f20008a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) vVar, G());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) vVar, this.n.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) vVar, H());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) vVar, I());
        return vVar;
    }

    private y b(y yVar) {
        com.shopee.app.ui.chat2.aa.a(yVar, this.l.get());
        com.shopee.app.ui.chat2.aa.a(yVar, this.f20010c.get());
        com.shopee.app.ui.chat2.aa.a(yVar, L());
        com.shopee.app.ui.chat2.aa.a(yVar, this.j.get());
        com.shopee.app.ui.chat2.aa.a(yVar, this.f20009b.get());
        return yVar;
    }

    private com.shopee.app.ui.chat2.b.d b(com.shopee.app.ui.chat2.b.d dVar) {
        com.shopee.app.ui.chat2.b.f.a(dVar, (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        return dVar;
    }

    private a b(a aVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f20008a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.l.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f20008a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.n.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f20009b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f20008a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f20008a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.i.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (al) b.a.c.a(this.f20008a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f20008a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f20008a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, G());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.n.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, H());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, I());
        return aVar;
    }

    private com.shopee.app.ui.chat.order.b b(com.shopee.app.ui.chat.order.b bVar) {
        com.shopee.app.ui.chat.order.c.a(bVar, O());
        com.shopee.app.ui.chat.order.c.a(bVar, this.f20010c.get());
        com.shopee.app.ui.chat.order.c.a(bVar, this.f20009b.get());
        com.shopee.app.ui.chat.order.c.a(bVar, this.j.get());
        return bVar;
    }

    private com.shopee.app.ui.chat.cell.y b(com.shopee.app.ui.chat.cell.y yVar) {
        com.shopee.app.ui.chat.cell.aa.a(yVar, this.f20009b.get());
        com.shopee.app.ui.chat.cell.aa.a(yVar, new ao());
        com.shopee.app.ui.chat.cell.aa.a(yVar, (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.chat.cell.aa.a(yVar, (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.chat.cell.aa.a(yVar, this.i.get());
        return yVar;
    }

    private com.shopee.app.ui.chat.cell.m b(com.shopee.app.ui.chat.cell.m mVar) {
        com.shopee.app.ui.chat.cell.o.a(mVar, new ao());
        com.shopee.app.ui.chat.cell.o.a(mVar, this.f20009b.get());
        com.shopee.app.ui.chat.cell.o.a(mVar, this.i.get());
        return mVar;
    }

    private com.shopee.app.ui.chat2.n b(com.shopee.app.ui.chat2.n nVar) {
        com.shopee.app.ui.chat2.p.a(nVar, ad());
        com.shopee.app.ui.chat2.p.a(nVar, this.f20010c.get());
        com.shopee.app.ui.chat2.p.a(nVar, this.f20009b.get());
        com.shopee.app.ui.chat2.p.a(nVar, this.j.get());
        com.shopee.app.ui.chat2.p.a(nVar, this.l.get());
        com.shopee.app.ui.chat2.p.a(nVar, this.k.get());
        com.shopee.app.ui.chat2.p.a(nVar, (SettingConfigStore) b.a.c.a(this.f20008a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.chat2.p.a(nVar, (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.chat2.p.a(nVar, this.i.get());
        com.shopee.app.ui.chat2.p.a(nVar, this.q.get());
        return nVar;
    }

    private com.shopee.app.ui.chat2.g b(com.shopee.app.ui.chat2.g gVar) {
        com.shopee.app.ui.chat2.i.a(gVar, ak());
        com.shopee.app.ui.chat2.i.a(gVar, this.f20010c.get());
        com.shopee.app.ui.chat2.i.a(gVar, new com.shopee.app.h.m());
        com.shopee.app.ui.chat2.i.a(gVar, this.j.get());
        com.shopee.app.ui.chat2.i.a(gVar, this.f20009b.get());
        com.shopee.app.ui.chat2.i.a(gVar, (com.shopee.app.data.store.be) b.a.c.a(this.f20008a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.chat2.i.a(gVar, this.l.get());
        com.shopee.app.ui.chat2.i.a(gVar, (SettingConfigStore) b.a.c.a(this.f20008a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        return gVar;
    }

    private com.shopee.app.ui.chat2.send.a b(com.shopee.app.ui.chat2.send.a aVar) {
        com.shopee.app.ui.chat2.send.c.a(aVar, (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.chat2.send.c.a(aVar, (SettingConfigStore) b.a.c.a(this.f20008a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.chat2.send.c.a(aVar, this.i.get());
        return aVar;
    }

    private com.shopee.app.ui.chat2.product.g b(com.shopee.app.ui.chat2.product.g gVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (com.shopee.app.application.a.b) b.a.c.a(this.f20008a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, this.l.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (com.shopee.app.tracking.f) b.a.c.a(this.f20008a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, this.n.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, this.f20009b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (com.shopee.app.d.c.f) b.a.c.a(this.f20008a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (com.shopee.app.tracking.a) b.a.c.a(this.f20008a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, this.i.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (al) b.a.c.a(this.f20008a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, (ActionRequiredCounter) b.a.c.a(this.f20008a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, (ActivityCounter) b.a.c.a(this.f20008a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, G());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, this.n.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, H());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, I());
        return gVar;
    }

    private com.shopee.app.ui.chat2.offer.b b(com.shopee.app.ui.chat2.offer.b bVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.application.a.b) b.a.c.a(this.f20008a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.l.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.tracking.f) b.a.c.a(this.f20008a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.n.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.f20009b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.d.c.f) b.a.c.a(this.f20008a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.tracking.a) b.a.c.a(this.f20008a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.i.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (al) b.a.c.a(this.f20008a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActionRequiredCounter) b.a.c.a(this.f20008a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActivityCounter) b.a.c.a(this.f20008a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, G());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, this.n.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, H());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, I());
        return bVar;
    }

    private com.shopee.app.ui.chat2.offer.b.c b(com.shopee.app.ui.chat2.offer.b.c cVar) {
        com.shopee.app.ui.chat2.offer.b.e.a(cVar, al());
        com.shopee.app.ui.chat2.offer.b.e.a(cVar, this.f20010c.get());
        com.shopee.app.ui.chat2.offer.b.e.a(cVar, this.j.get());
        return cVar;
    }

    private com.shopee.app.ui.chat2.buy.d b(com.shopee.app.ui.chat2.buy.d dVar) {
        com.shopee.app.ui.chat2.buy.f.a(dVar, an());
        com.shopee.app.ui.chat2.buy.f.a(dVar, this.f20010c.get());
        com.shopee.app.ui.chat2.buy.f.a(dVar, this.j.get());
        com.shopee.app.ui.chat2.buy.f.a(dVar, this.f20009b.get());
        return dVar;
    }

    private com.shopee.app.ui.chat2.buy.a b(com.shopee.app.ui.chat2.buy.a aVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f20008a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.l.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f20008a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.n.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f20009b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f20008a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f20008a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.i.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (al) b.a.c.a(this.f20008a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f20008a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f20008a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, G());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.n.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, H());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, I());
        return aVar;
    }

    private com.shopee.app.ui.chat2.product.h b(com.shopee.app.ui.chat2.product.h hVar) {
        com.shopee.app.ui.chat2.product.j.a(hVar, this.f20010c.get());
        com.shopee.app.ui.chat2.product.j.a(hVar, ao());
        com.shopee.app.ui.chat2.product.j.a(hVar, this.j.get());
        return hVar;
    }

    private com.shopee.app.ui.chat.cell.v b(com.shopee.app.ui.chat.cell.v vVar) {
        com.shopee.app.ui.chat.cell.x.a(vVar, (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.chat.cell.x.a(vVar, (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.chat.cell.x.a(vVar, this.f20009b.get());
        com.shopee.app.ui.chat.cell.x.a(vVar, this.i.get());
        return vVar;
    }

    private com.shopee.app.ui.chat.cell.ah b(com.shopee.app.ui.chat.cell.ah ahVar) {
        aj.a(ahVar, (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        return ahVar;
    }

    private com.shopee.app.ui.chat2.order.f b(com.shopee.app.ui.chat2.order.f fVar) {
        com.shopee.app.ui.chat2.order.h.a(fVar, ap());
        com.shopee.app.ui.chat2.order.h.a(fVar, this.f20010c.get());
        com.shopee.app.ui.chat2.order.h.a(fVar, this.j.get());
        com.shopee.app.ui.chat2.order.h.a(fVar, this.f20009b.get());
        return fVar;
    }

    private com.shopee.app.ui.chat2.order.a b(com.shopee.app.ui.chat2.order.a aVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f20008a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.l.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f20008a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.n.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f20009b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f20008a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f20008a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.i.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (al) b.a.c.a(this.f20008a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f20008a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f20008a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, G());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.n.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, H());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, I());
        return aVar;
    }

    private com.shopee.app.ui.chat.cell.p b(com.shopee.app.ui.chat.cell.p pVar) {
        com.shopee.app.ui.chat.cell.r.a(pVar, (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.chat.cell.r.a(pVar, (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.chat.cell.r.a(pVar, this.f20009b.get());
        return pVar;
    }

    private com.shopee.app.ui.chat2.search.a b(com.shopee.app.ui.chat2.search.a aVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f20008a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.l.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f20008a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.n.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f20009b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f20008a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f20008a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.i.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (al) b.a.c.a(this.f20008a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f20008a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f20008a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, G());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.n.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, H());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, I());
        return aVar;
    }

    private com.shopee.app.ui.chat2.offer.a.g b(com.shopee.app.ui.chat2.offer.a.g gVar) {
        com.shopee.app.ui.chat2.offer.a.i.a(gVar, as());
        com.shopee.app.ui.chat2.offer.a.i.a(gVar, this.f20010c.get());
        com.shopee.app.ui.chat2.offer.a.i.a(gVar, this.j.get());
        return gVar;
    }

    private com.shopee.app.ui.chat2.order.singletab.a b(com.shopee.app.ui.chat2.order.singletab.a aVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f20008a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.l.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f20008a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.n.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f20009b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f20008a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f20008a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.i.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (al) b.a.c.a(this.f20008a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f20008a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f20008a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, G());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.n.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, H());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, I());
        return aVar;
    }

    private com.shopee.app.ui.chat2.b b(com.shopee.app.ui.chat2.b bVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.application.a.b) b.a.c.a(this.f20008a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.l.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.tracking.f) b.a.c.a(this.f20008a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.n.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.f20009b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.d.c.f) b.a.c.a(this.f20008a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.tracking.a) b.a.c.a(this.f20008a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.i.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (al) b.a.c.a(this.f20008a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActionRequiredCounter) b.a.c.a(this.f20008a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActivityCounter) b.a.c.a(this.f20008a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, G());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, this.n.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, H());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, I());
        return bVar;
    }

    private com.shopee.app.ui.chat2.offer.a b(com.shopee.app.ui.chat2.offer.a aVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (n) b.a.c.a(this.f20008a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (bi) b.a.c.a(this.f20008a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f20008a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.l.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f20008a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (UserInfo) b.a.c.a(this.f20008a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.n.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f20009b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f20008a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f20008a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.i.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (al) b.a.c.a(this.f20008a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f20008a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f20008a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, G());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.n.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, H());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, I());
        return aVar;
    }

    private com.shopee.app.ui.chat.cell.g b(com.shopee.app.ui.chat.cell.g gVar) {
        com.shopee.app.ui.chat.cell.h.a(gVar, this.f20009b.get());
        com.shopee.app.ui.chat.cell.h.a(gVar, (com.shopee.app.data.store.aa) b.a.c.a(this.f20008a.deviceStore(), "Cannot return null from a non-@Nullable component method"));
        return gVar;
    }

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f20015a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f20016b;

        private a() {
        }

        public b a() {
            if (this.f20015a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f20016b != null) {
                return new c(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public a a(com.shopee.app.a.b bVar) {
            this.f20015a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public a a(UserComponent userComponent) {
            this.f20016b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    /* renamed from: com.shopee.app.ui.chat.c$c  reason: collision with other inner class name */
    private static class C0304c implements Provider<RegionConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f20018a;

        C0304c(UserComponent userComponent) {
            this.f20018a = userComponent;
        }

        /* renamed from: a */
        public RegionConfigStore get() {
            return (RegionConfigStore) b.a.c.a(this.f20018a.regionConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class d implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f20019a;

        d(UserComponent userComponent) {
            this.f20019a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f20019a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f20017a;

        b(UserComponent userComponent) {
            this.f20017a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f20017a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class f implements Provider<com.shopee.app.data.store.be> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f20021a;

        f(UserComponent userComponent) {
            this.f20021a = userComponent;
        }

        /* renamed from: a */
        public com.shopee.app.data.store.be get() {
            return (com.shopee.app.data.store.be) b.a.c.a(this.f20021a.uiStatusStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class e implements Provider<com.garena.sticker.b> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f20020a;

        e(UserComponent userComponent) {
            this.f20020a = userComponent;
        }

        /* renamed from: a */
        public com.garena.sticker.b get() {
            return (com.garena.sticker.b) b.a.c.a(this.f20020a.stickerManager(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
