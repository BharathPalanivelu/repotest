package com.shopee.app.ui.follow;

import android.app.Activity;
import com.shopee.app.a.o;
import com.shopee.app.a.q;
import com.shopee.app.a.s;
import com.shopee.app.a.t;
import com.shopee.app.a.v;
import com.shopee.app.a.w;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.am;
import com.shopee.app.d.c.eb;
import com.shopee.app.d.c.ec;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.data.store.RegionConfigStore;
import com.shopee.app.data.store.SearchKeywordsStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.aj;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.be;
import com.shopee.app.data.store.h;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.tracking.f;
import com.shopee.app.ui.actionbar.k;
import com.shopee.app.ui.actionbar.l;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.ui.common.ac;
import com.shopee.app.ui.common.ad;
import com.shopee.app.ui.common.i;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.follow.following.FollowingActivity;
import com.shopee.app.ui.follow.following.e;
import com.shopee.app.ui.follow.following.m;
import com.shopee.app.ui.follow.following.u;
import com.shopee.app.ui.follow.following.x;
import com.shopee.app.ui.follow.search.j;
import com.shopee.app.ui.home.me.v3.OptionBox;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f21613a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f21614b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f21615c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f21616d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f21617e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f21618f;

    /* renamed from: g  reason: collision with root package name */
    private Provider<Activity> f21619g;
    private d h;
    private Provider<com.shopee.app.tracking.c> i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private Provider<com.shopee.app.a.a.a> k;
    private b l;
    private Provider<com.shopee.app.ui.common.a> m;
    private c n;
    private Provider<RegionConfig> o;

    private a(C0320a aVar) {
        a(aVar);
    }

    public static C0320a c() {
        return new C0320a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f21613a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.follow.following.c e() {
        return new com.shopee.app.ui.follow.following.c((n) b.a.c.a(this.f21613a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private j f() {
        return new j((n) b.a.c.a(this.f21613a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private m g() {
        return new m((n) b.a.c.a(this.f21613a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new ah());
    }

    private com.shopee.app.ui.follow.following.j h() {
        return new com.shopee.app.ui.follow.following.j((n) b.a.c.a(this.f21613a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.follow.search.k i() {
        return new com.shopee.app.ui.follow.search.k((n) b.a.c.a(this.f21613a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f21613a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), e(), f(), (SearchKeywordsStore) b.a.c.a(this.f21613a.searchKeywordStore(), "Cannot return null from a non-@Nullable component method"), this.f21614b.get(), (f) b.a.c.a(this.f21613a.tracker(), "Cannot return null from a non-@Nullable component method"), (UserInfo) b.a.c.a(this.f21613a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), g(), h());
    }

    private com.shopee.app.d.c.c.a j() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f21613a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f21613a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n k() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f21613a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i l() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f21613a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private am m() {
        return new am((n) b.a.c.a(this.f21613a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (aa) b.a.c.a(this.f21613a.deviceStore(), "Cannot return null from a non-@Nullable component method"), (be) b.a.c.a(this.f21613a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"), new aj());
    }

    private eb n() {
        return ec.a((n) b.a.c.a(this.f21613a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (h) b.a.c.a(this.f21613a.bannerStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private x o() {
        return new x((n) b.a.c.a(this.f21613a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f21613a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.h.m(), e(), m(), (com.shopee.app.ui.follow.following.i) b.a.c.a(this.f21613a.getContactInteractor(), "Cannot return null from a non-@Nullable component method"), g(), n(), (aa) b.a.c.a(this.f21613a.deviceStore(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.react.modules.app.data.k) b.a.c.a(this.f21613a.rnConfigProvider(), "Cannot return null from a non-@Nullable component method"), (be) b.a.c.a(this.f21613a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"), (UserInfo) b.a.c.a(this.f21613a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.follow.following.d p() {
        return new com.shopee.app.ui.follow.following.d(new e());
    }

    private void a(C0320a aVar) {
        this.f21614b = b.a.a.a(o.a(aVar.f21620a));
        this.f21613a = aVar.f21621b;
        this.f21615c = b.a.a.a(com.shopee.app.a.r.a(aVar.f21620a));
        this.f21616d = b.a.a.a(s.a(aVar.f21620a));
        this.f21617e = b.a.a.a(t.a(aVar.f21620a));
        this.f21618f = b.a.a.a(com.shopee.app.a.m.a(aVar.f21620a));
        this.f21619g = b.a.a.a(com.shopee.app.a.d.a(aVar.f21620a));
        this.h = new d(aVar.f21621b);
        this.i = b.a.a.a(v.a(aVar.f21620a, this.h));
        this.j = b.a.a.a(w.a(aVar.f21620a, this.h));
        this.k = b.a.a.a(com.shopee.app.a.e.a(aVar.f21620a));
        this.l = new b(aVar.f21621b);
        this.m = b.a.a.a(com.shopee.app.a.f.a(aVar.f21620a, this.l));
        this.n = new c(aVar.f21621b);
        this.o = b.a.a.a(q.a(aVar.f21620a, this.n));
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
        return this.f21614b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f21617e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.follow.search.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.follow.search.m mVar) {
        b(mVar);
    }

    public void a(ac acVar) {
        b(acVar);
    }

    public void a(FollowingActivity followingActivity) {
        b(followingActivity);
    }

    public void a(com.shopee.app.ui.follow.following.f fVar) {
        b(fVar);
    }

    public void a(com.shopee.app.ui.follow.search.h hVar) {
        b(hVar);
    }

    public void a(u uVar) {
        b(uVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f21614b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f21613a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f21615c.get());
        l.a(kVar, d());
        l.a(kVar, this.f21614b.get());
        l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f21613a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f21616d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f21614b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f21613a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f21613a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f21614b.get());
        return aVar;
    }

    private com.shopee.app.ui.follow.search.a b(com.shopee.app.ui.follow.search.a aVar) {
        com.shopee.app.ui.follow.search.c.a(aVar, (bi) b.a.c.a(this.f21613a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.follow.search.c.a(aVar, (UserInfo) b.a.c.a(this.f21613a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.follow.search.c.a(aVar, this.f21614b.get());
        return aVar;
    }

    private com.shopee.app.ui.follow.search.m b(com.shopee.app.ui.follow.search.m mVar) {
        com.shopee.app.ui.follow.search.o.a(mVar, this.f21618f.get());
        com.shopee.app.ui.follow.search.o.a(mVar, i());
        com.shopee.app.ui.follow.search.o.a(mVar, this.f21615c.get());
        com.shopee.app.ui.follow.search.o.a(mVar, this.f21614b.get());
        com.shopee.app.ui.follow.search.o.a(mVar, new com.shopee.app.h.m());
        com.shopee.app.ui.follow.search.o.a(mVar, this.f21619g.get());
        com.shopee.app.ui.follow.search.o.a(mVar, (com.shopee.app.tracking.a) b.a.c.a(this.f21613a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.follow.search.o.a(mVar, this.i.get());
        com.shopee.app.ui.follow.search.o.a(mVar, this.j.get());
        com.shopee.app.ui.follow.search.o.a(mVar, this.k.get());
        return mVar;
    }

    private ac b(ac acVar) {
        ad.a(acVar, this.f21614b.get());
        return acVar;
    }

    private FollowingActivity b(FollowingActivity followingActivity) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) followingActivity, (n) b.a.c.a(this.f21613a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) followingActivity, (bi) b.a.c.a(this.f21613a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) followingActivity, (com.shopee.app.application.a.b) b.a.c.a(this.f21613a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) followingActivity, this.f21618f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) followingActivity, (f) b.a.c.a(this.f21613a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) followingActivity, (UserInfo) b.a.c.a(this.f21613a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) followingActivity, this.m.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) followingActivity, this.f21614b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) followingActivity, (com.shopee.app.d.c.f) b.a.c.a(this.f21613a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) followingActivity, (com.shopee.app.tracking.a) b.a.c.a(this.f21613a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) followingActivity, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) followingActivity, (al) b.a.c.a(this.f21613a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) followingActivity, (ActionRequiredCounter) b.a.c.a(this.f21613a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) followingActivity, (ActivityCounter) b.a.c.a(this.f21613a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) followingActivity, j());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) followingActivity, this.m.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) followingActivity, k());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) followingActivity, l());
        return followingActivity;
    }

    private com.shopee.app.ui.follow.following.f b(com.shopee.app.ui.follow.following.f fVar) {
        com.shopee.app.ui.follow.following.h.a(fVar, this.f21618f.get());
        com.shopee.app.ui.follow.following.h.a(fVar, o());
        com.shopee.app.ui.follow.following.h.a(fVar, p());
        com.shopee.app.ui.follow.following.h.a(fVar, this.f21615c.get());
        com.shopee.app.ui.follow.following.h.a(fVar, this.f21614b.get());
        com.shopee.app.ui.follow.following.h.a(fVar, new com.shopee.app.h.m());
        com.shopee.app.ui.follow.following.h.a(fVar, (h) b.a.c.a(this.f21613a.bannerStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.follow.following.h.a(fVar, this.o.get());
        com.shopee.app.ui.follow.following.h.a(fVar, (com.shopee.app.application.a.b) b.a.c.a(this.f21613a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.follow.following.h.a(fVar, this.f21619g.get());
        com.shopee.app.ui.follow.following.h.a(fVar, (be) b.a.c.a(this.f21613a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.follow.following.h.a(fVar, (al) b.a.c.a(this.f21613a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.follow.following.h.a(fVar, (com.shopee.app.util.s) b.a.c.a(this.f21613a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return fVar;
    }

    private com.shopee.app.ui.follow.search.h b(com.shopee.app.ui.follow.search.h hVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) hVar, (n) b.a.c.a(this.f21613a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) hVar, (bi) b.a.c.a(this.f21613a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) hVar, (com.shopee.app.application.a.b) b.a.c.a(this.f21613a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) hVar, this.f21618f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) hVar, (f) b.a.c.a(this.f21613a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) hVar, (UserInfo) b.a.c.a(this.f21613a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) hVar, this.m.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) hVar, this.f21614b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) hVar, (com.shopee.app.d.c.f) b.a.c.a(this.f21613a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) hVar, (com.shopee.app.tracking.a) b.a.c.a(this.f21613a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) hVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) hVar, (al) b.a.c.a(this.f21613a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) hVar, (ActionRequiredCounter) b.a.c.a(this.f21613a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) hVar, (ActivityCounter) b.a.c.a(this.f21613a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) hVar, j());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) hVar, this.m.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) hVar, k());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) hVar, l());
        com.shopee.app.ui.follow.search.i.a(hVar, this.j.get());
        return hVar;
    }

    private u b(u uVar) {
        com.shopee.app.ui.follow.following.w.a(uVar, (bi) b.a.c.a(this.f21613a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.follow.following.w.a(uVar, this.f21614b.get());
        return uVar;
    }

    /* renamed from: com.shopee.app.ui.follow.a$a  reason: collision with other inner class name */
    public static final class C0320a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f21620a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f21621b;

        private C0320a() {
        }

        public b a() {
            if (this.f21620a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f21621b != null) {
                return new a(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public C0320a a(com.shopee.app.a.b bVar) {
            this.f21620a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public C0320a a(UserComponent userComponent) {
            this.f21621b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class d implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f21624a;

        d(UserComponent userComponent) {
            this.f21624a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f21624a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f21622a;

        b(UserComponent userComponent) {
            this.f21622a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f21622a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<RegionConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f21623a;

        c(UserComponent userComponent) {
            this.f21623a = userComponent;
        }

        /* renamed from: a */
        public RegionConfigStore get() {
            return (RegionConfigStore) b.a.c.a(this.f21623a.regionConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
