package com.shopee.app.ui.product.comment;

import com.shopee.app.a.m;
import com.shopee.app.a.o;
import com.shopee.app.a.t;
import com.shopee.app.a.w;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.aj;
import com.shopee.app.d.c.ap;
import com.shopee.app.d.c.br;
import com.shopee.app.d.c.bs;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.tracking.f;
import com.shopee.app.ui.actionbar.k;
import com.shopee.app.ui.actionbar.l;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.ui.common.af;
import com.shopee.app.ui.common.ag;
import com.shopee.app.ui.common.i;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.home.me.v3.OptionBox;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.product.comment.FeedsComment.e;
import com.shopee.app.ui.product.comment.FeedsComment.g;
import com.shopee.app.ui.product.comment.m;
import com.shopee.app.ui.shopassistant.d;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class s implements a {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f24576a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f24577b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f24578c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f24579d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f24580e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f24581f;

    /* renamed from: g  reason: collision with root package name */
    private b f24582g;
    private Provider<com.shopee.app.ui.common.a> h;
    private c i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;

    public void a(f fVar) {
    }

    private s(a aVar) {
        a(aVar);
    }

    public static a c() {
        return new a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f24576a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private af e() {
        return new af((bi) b.a.c.a(this.f24576a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a f() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f24576a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f24576a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n g() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f24576a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i h() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f24576a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private br i() {
        return bs.a((n) b.a.c.a(this.f24576a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new ao(), new ah());
    }

    private aj j() {
        return new aj((n) b.a.c.a(this.f24576a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.s(), new ah(), new ao(), new bh());
    }

    private k k() {
        return new k(i(), j(), (UserInfo) b.a.c.a(this.f24576a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), (f) b.a.c.a(this.f24576a.tracker(), "Cannot return null from a non-@Nullable component method"));
    }

    private i l() {
        return new i(j());
    }

    private ap m() {
        return new ap((n) b.a.c.a(this.f24576a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bh());
    }

    private e n() {
        return new e(m(), (UserInfo) b.a.c.a(this.f24576a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
    }

    private void a(a aVar) {
        this.f24577b = b.a.a.a(o.a(aVar.f24583a));
        this.f24576a = aVar.f24584b;
        this.f24578c = b.a.a.a(com.shopee.app.a.r.a(aVar.f24583a));
        this.f24579d = b.a.a.a(com.shopee.app.a.s.a(aVar.f24583a));
        this.f24580e = b.a.a.a(t.a(aVar.f24583a));
        this.f24581f = b.a.a.a(m.a(aVar.f24583a));
        this.f24582g = new b(aVar.f24584b);
        this.h = b.a.a.a(com.shopee.app.a.f.a(aVar.f24583a, this.f24582g));
        this.i = new c(aVar.f24584b);
        this.j = b.a.a.a(w.a(aVar.f24583a, this.i));
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
        return this.f24577b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f24580e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(ag agVar) {
        b(agVar);
    }

    public void a(com.shopee.app.ui.follow.search.a aVar) {
        b(aVar);
    }

    public void a(d dVar) {
        b(dVar);
    }

    public void a(g gVar) {
        b(gVar);
    }

    public void a(m mVar) {
        b(mVar);
    }

    public void a(p pVar) {
        b(pVar);
    }

    public void a(c cVar) {
        b(cVar);
    }

    public void a(com.shopee.app.ui.product.comment.FeedsComment.d dVar) {
        b(dVar);
    }

    public void a(g gVar) {
        b(gVar);
    }

    public void a(com.shopee.app.ui.product.comment.FeedsComment.a aVar) {
        b(aVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f24577b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f24576a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f24578c.get());
        l.a(kVar, d());
        l.a(kVar, this.f24577b.get());
        l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f24576a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f24579d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f24577b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f24576a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f24576a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f24577b.get());
        return aVar;
    }

    private ag b(ag agVar) {
        com.shopee.app.ui.common.ah.a(agVar, e());
        com.shopee.app.ui.common.ah.a(agVar, (bi) b.a.c.a(this.f24576a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.common.ah.a(agVar, this.f24578c.get());
        com.shopee.app.ui.common.ah.a(agVar, (UserInfo) b.a.c.a(this.f24576a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return agVar;
    }

    private com.shopee.app.ui.follow.search.a b(com.shopee.app.ui.follow.search.a aVar) {
        com.shopee.app.ui.follow.search.c.a(aVar, (bi) b.a.c.a(this.f24576a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.follow.search.c.a(aVar, (UserInfo) b.a.c.a(this.f24576a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.follow.search.c.a(aVar, this.f24577b.get());
        return aVar;
    }

    private d b(d dVar) {
        com.shopee.app.ui.shopassistant.e.a(dVar, (bi) b.a.c.a(this.f24576a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        return dVar;
    }

    private g b(g gVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (n) b.a.c.a(this.f24576a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (bi) b.a.c.a(this.f24576a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (com.shopee.app.application.a.b) b.a.c.a(this.f24576a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, this.f24581f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (f) b.a.c.a(this.f24576a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (UserInfo) b.a.c.a(this.f24576a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, this.f24577b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (com.shopee.app.d.c.f) b.a.c.a(this.f24576a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (com.shopee.app.tracking.a) b.a.c.a(this.f24576a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (al) b.a.c.a(this.f24576a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, (ActionRequiredCounter) b.a.c.a(this.f24576a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, (ActivityCounter) b.a.c.a(this.f24576a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, g());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, h());
        h.a(gVar, this.f24577b.get());
        return gVar;
    }

    private m b(m mVar) {
        o.a(mVar, k());
        o.a(mVar, new m.b());
        o.a(mVar, new m.c());
        o.a(mVar, this.f24578c.get());
        o.a(mVar, this.f24577b.get());
        o.a(mVar, this.f24581f.get());
        return mVar;
    }

    private p b(p pVar) {
        r.a(pVar, l());
        r.a(pVar, this.f24578c.get());
        return pVar;
    }

    private c b(c cVar) {
        e.a(cVar, (bi) b.a.c.a(this.f24576a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        e.a(cVar, this.f24577b.get());
        e.a(cVar, (UserInfo) b.a.c.a(this.f24576a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return cVar;
    }

    private com.shopee.app.ui.product.comment.FeedsComment.d b(com.shopee.app.ui.product.comment.FeedsComment.d dVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, (n) b.a.c.a(this.f24576a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, (bi) b.a.c.a(this.f24576a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, (com.shopee.app.application.a.b) b.a.c.a(this.f24576a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, this.f24581f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, (f) b.a.c.a(this.f24576a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, (UserInfo) b.a.c.a(this.f24576a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, this.f24577b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, (com.shopee.app.d.c.f) b.a.c.a(this.f24576a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, (com.shopee.app.tracking.a) b.a.c.a(this.f24576a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, (al) b.a.c.a(this.f24576a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, (ActionRequiredCounter) b.a.c.a(this.f24576a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, (ActivityCounter) b.a.c.a(this.f24576a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, g());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, h());
        return dVar;
    }

    private g b(g gVar) {
        com.shopee.app.ui.product.comment.FeedsComment.i.a(gVar, n());
        com.shopee.app.ui.product.comment.FeedsComment.i.a(gVar, new g.a());
        com.shopee.app.ui.product.comment.FeedsComment.i.a(gVar, new g.b());
        com.shopee.app.ui.product.comment.FeedsComment.i.a(gVar, this.f24578c.get());
        com.shopee.app.ui.product.comment.FeedsComment.i.a(gVar, this.f24577b.get());
        com.shopee.app.ui.product.comment.FeedsComment.i.a(gVar, this.f24581f.get());
        return gVar;
    }

    private com.shopee.app.ui.product.comment.FeedsComment.a b(com.shopee.app.ui.product.comment.FeedsComment.a aVar) {
        com.shopee.app.ui.product.comment.FeedsComment.c.a(aVar, (bi) b.a.c.a(this.f24576a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.product.comment.FeedsComment.c.a(aVar, (UserInfo) b.a.c.a(this.f24576a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return aVar;
    }

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f24583a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f24584b;

        private a() {
        }

        public a a() {
            if (this.f24583a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f24584b != null) {
                return new s(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public a a(com.shopee.app.a.b bVar) {
            this.f24583a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public a a(UserComponent userComponent) {
            this.f24584b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f24585a;

        b(UserComponent userComponent) {
            this.f24585a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f24585a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f24586a;

        c(UserComponent userComponent) {
            this.f24586a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f24586a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
