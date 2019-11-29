package com.shopee.app.ui.product.newsearch;

import android.app.Activity;
import com.shopee.app.a.e;
import com.shopee.app.a.o;
import com.shopee.app.a.s;
import com.shopee.app.a.t;
import com.shopee.app.a.v;
import com.shopee.app.a.w;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.SearchKeywordsStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.al;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.tracking.f;
import com.shopee.app.ui.actionbar.k;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.ui.common.i;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.follow.following.m;
import com.shopee.app.ui.follow.search.d;
import com.shopee.app.ui.follow.search.j;
import com.shopee.app.ui.home.me.v3.OptionBox;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.product.newsearch.a.b;
import com.shopee.app.ui.product.newsearch.a.g;
import com.shopee.app.ui.product.search.l;
import com.shopee.app.ui.product.search.q;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class a implements e {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f24650a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f24651b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f24652c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f24653d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f24654e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f24655f;

    /* renamed from: g  reason: collision with root package name */
    private Provider<Activity> f24656g;
    private c h;
    private Provider<com.shopee.app.tracking.c> i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private Provider<com.shopee.app.a.a.a> k;
    private b l;
    private Provider<com.shopee.app.ui.common.a> m;
    private Provider<com.shopee.app.ui.actionbar.a> n;

    private a(C0377a aVar) {
        a(aVar);
    }

    public static C0377a c() {
        return new C0377a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f24650a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.follow.following.c e() {
        return new com.shopee.app.ui.follow.following.c((n) b.a.c.a(this.f24650a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private j f() {
        return new j((n) b.a.c.a(this.f24650a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private m g() {
        return new m((n) b.a.c.a(this.f24650a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new ah());
    }

    private com.shopee.app.ui.follow.following.j h() {
        return new com.shopee.app.ui.follow.following.j((n) b.a.c.a(this.f24650a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.follow.search.k i() {
        return new com.shopee.app.ui.follow.search.k((n) b.a.c.a(this.f24650a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f24650a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), e(), f(), (SearchKeywordsStore) b.a.c.a(this.f24650a.searchKeywordStore(), "Cannot return null from a non-@Nullable component method"), this.f24651b.get(), (f) b.a.c.a(this.f24650a.tracker(), "Cannot return null from a non-@Nullable component method"), (UserInfo) b.a.c.a(this.f24650a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), g(), h());
    }

    private d j() {
        return new d((n) b.a.c.a(this.f24650a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private l k() {
        return new l((n) b.a.c.a(this.f24650a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f24650a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), (SearchKeywordsStore) b.a.c.a(this.f24650a.searchKeywordStore(), "Cannot return null from a non-@Nullable component method"), f(), j(), this.i.get());
    }

    private com.shopee.app.d.c.c.a l() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f24650a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f24650a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n m() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f24650a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i n() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f24650a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.product.newsearch.a.a o() {
        return new com.shopee.app.ui.product.newsearch.a.a(this.j.get());
    }

    private void a(C0377a aVar) {
        this.f24651b = b.a.a.a(o.a(aVar.f24657a));
        this.f24650a = aVar.f24658b;
        this.f24652c = b.a.a.a(com.shopee.app.a.r.a(aVar.f24657a));
        this.f24653d = b.a.a.a(s.a(aVar.f24657a));
        this.f24654e = b.a.a.a(t.a(aVar.f24657a));
        this.f24655f = b.a.a.a(com.shopee.app.a.m.a(aVar.f24657a));
        this.f24656g = b.a.a.a(com.shopee.app.a.d.a(aVar.f24657a));
        this.h = new c(aVar.f24658b);
        this.i = b.a.a.a(v.a(aVar.f24657a, this.h));
        this.j = b.a.a.a(w.a(aVar.f24657a, this.h));
        this.k = b.a.a.a(e.a(aVar.f24657a));
        this.l = new b(aVar.f24658b);
        this.m = b.a.a.a(com.shopee.app.a.f.a(aVar.f24657a, this.l));
        this.n = b.a.a.a(com.shopee.app.a.c.a(aVar.f24657a));
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
        return this.f24651b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f24654e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.follow.search.m mVar) {
        b(mVar);
    }

    public void a(com.shopee.app.ui.follow.search.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.product.search.o oVar) {
        b(oVar);
    }

    public void a(c cVar) {
        b(cVar);
    }

    public void a(f fVar) {
        b(fVar);
    }

    public void a(com.shopee.app.ui.product.newsearch.a.e eVar) {
        b(eVar);
    }

    public void a(b bVar) {
        b(bVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f24651b.get());
        return avatarView;
    }

    private k b(k kVar) {
        com.shopee.app.ui.actionbar.l.a(kVar, (bi) b.a.c.a(this.f24650a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbar.l.a(kVar, this.f24652c.get());
        com.shopee.app.ui.actionbar.l.a(kVar, d());
        com.shopee.app.ui.actionbar.l.a(kVar, this.f24651b.get());
        com.shopee.app.ui.actionbar.l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f24650a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f24653d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f24651b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f24650a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f24650a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f24651b.get());
        return aVar;
    }

    private com.shopee.app.ui.follow.search.m b(com.shopee.app.ui.follow.search.m mVar) {
        com.shopee.app.ui.follow.search.o.a(mVar, this.f24655f.get());
        com.shopee.app.ui.follow.search.o.a(mVar, i());
        com.shopee.app.ui.follow.search.o.a(mVar, this.f24652c.get());
        com.shopee.app.ui.follow.search.o.a(mVar, this.f24651b.get());
        com.shopee.app.ui.follow.search.o.a(mVar, new com.shopee.app.h.m());
        com.shopee.app.ui.follow.search.o.a(mVar, this.f24656g.get());
        com.shopee.app.ui.follow.search.o.a(mVar, (com.shopee.app.tracking.a) b.a.c.a(this.f24650a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.follow.search.o.a(mVar, this.i.get());
        com.shopee.app.ui.follow.search.o.a(mVar, this.j.get());
        com.shopee.app.ui.follow.search.o.a(mVar, this.k.get());
        return mVar;
    }

    private com.shopee.app.ui.follow.search.a b(com.shopee.app.ui.follow.search.a aVar) {
        com.shopee.app.ui.follow.search.c.a(aVar, (bi) b.a.c.a(this.f24650a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.follow.search.c.a(aVar, (UserInfo) b.a.c.a(this.f24650a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.follow.search.c.a(aVar, this.f24651b.get());
        return aVar;
    }

    private com.shopee.app.ui.product.search.o b(com.shopee.app.ui.product.search.o oVar) {
        q.a(oVar, k());
        q.a(oVar, this.f24652c.get());
        q.a(oVar, this.f24651b.get());
        q.a(oVar, this.f24656g.get());
        q.a(oVar, (com.shopee.app.tracking.a) b.a.c.a(this.f24650a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        q.a(oVar, this.i.get());
        q.a(oVar, (SearchKeywordsStore) b.a.c.a(this.f24650a.searchKeywordStore(), "Cannot return null from a non-@Nullable component method"));
        q.a(oVar, this.k.get());
        q.a(oVar, this.j.get());
        return oVar;
    }

    private c b(c cVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (n) b.a.c.a(this.f24650a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (bi) b.a.c.a(this.f24650a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.application.a.b) b.a.c.a(this.f24650a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.f24655f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (f) b.a.c.a(this.f24650a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (UserInfo) b.a.c.a(this.f24650a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.m.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.f24651b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.d.c.f) b.a.c.a(this.f24650a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.tracking.a) b.a.c.a(this.f24650a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (al) b.a.c.a(this.f24650a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, (ActionRequiredCounter) b.a.c.a(this.f24650a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, (ActivityCounter) b.a.c.a(this.f24650a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, l());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, this.m.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, m());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, n());
        d.a(cVar, (com.shopee.app.util.s) b.a.c.a(this.f24650a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        d.a(cVar, this.j.get());
        return cVar;
    }

    private f b(f fVar) {
        i.a(fVar, this.n.get());
        i.a(fVar, (com.shopee.app.tracking.a) b.a.c.a(this.f24650a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        i.a(fVar, (com.shopee.app.util.s) b.a.c.a(this.f24650a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        i.a(fVar, this.f24651b.get());
        return fVar;
    }

    private com.shopee.app.ui.product.newsearch.a.e b(com.shopee.app.ui.product.newsearch.a.e eVar) {
        g.a(eVar, (bi) b.a.c.a(this.f24650a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        g.a(eVar, this.f24656g.get());
        g.a(eVar, (SearchKeywordsStore) b.a.c.a(this.f24650a.searchKeywordStore(), "Cannot return null from a non-@Nullable component method"));
        return eVar;
    }

    private b b(b bVar) {
        com.shopee.app.ui.product.newsearch.a.d.a(bVar, (bi) b.a.c.a(this.f24650a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.product.newsearch.a.d.a(bVar, this.f24656g.get());
        com.shopee.app.ui.product.newsearch.a.d.a(bVar, this.n.get());
        com.shopee.app.ui.product.newsearch.a.d.a(bVar, o());
        return bVar;
    }

    /* renamed from: com.shopee.app.ui.product.newsearch.a$a  reason: collision with other inner class name */
    public static final class C0377a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f24657a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f24658b;

        private C0377a() {
        }

        public e a() {
            if (this.f24657a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f24658b != null) {
                return new a(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public C0377a a(com.shopee.app.a.b bVar) {
            this.f24657a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public C0377a a(UserComponent userComponent) {
            this.f24658b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f24672a;

        c(UserComponent userComponent) {
            this.f24672a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f24672a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f24660a;

        b(UserComponent userComponent) {
            this.f24660a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f24660a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
