package com.shopee.app.ui.image;

import android.app.Activity;
import com.shopee.app.a.d;
import com.shopee.app.a.f;
import com.shopee.app.a.m;
import com.shopee.app.a.o;
import com.shopee.app.a.s;
import com.shopee.app.a.t;
import com.shopee.app.a.w;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.cu;
import com.shopee.app.d.c.cv;
import com.shopee.app.d.c.dj;
import com.shopee.app.d.c.dk;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.be;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.h.p;
import com.shopee.app.ui.actionbar.k;
import com.shopee.app.ui.actionbar.l;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.ui.common.i;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.home.me.v3.OptionBox;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class e implements h {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f22826a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f22827b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f22828c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f22829d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f22830e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f22831f;

    /* renamed from: g  reason: collision with root package name */
    private b f22832g;
    private Provider<com.shopee.app.ui.common.a> h;
    private c i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private Provider<Activity> k;

    private e(a aVar) {
        a(aVar);
    }

    public static a c() {
        return new a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f22826a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f22826a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f22826a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f22826a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i g() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f22826a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private dj h() {
        return dk.a((n) b.a.c.a(this.f22826a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private i i() {
        return new i((n) b.a.c.a(this.f22826a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), h());
    }

    private cu j() {
        return cv.a((n) b.a.c.a(this.f22826a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (SettingConfigStore) b.a.c.a(this.f22826a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"), (p) b.a.c.a(this.f22826a.serverManager(), "Cannot return null from a non-@Nullable component method"), (UserInfo) b.a.c.a(this.f22826a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
    }

    private n k() {
        return new n((n) b.a.c.a(this.f22826a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), j());
    }

    private void a(a aVar) {
        this.f22827b = b.a.a.a(o.a(aVar.f22833a));
        this.f22826a = aVar.f22834b;
        this.f22828c = b.a.a.a(com.shopee.app.a.r.a(aVar.f22833a));
        this.f22829d = b.a.a.a(s.a(aVar.f22833a));
        this.f22830e = b.a.a.a(t.a(aVar.f22833a));
        this.f22831f = b.a.a.a(m.a(aVar.f22833a));
        this.f22832g = new b(aVar.f22834b);
        this.h = b.a.a.a(f.a(aVar.f22833a, this.f22832g));
        this.i = new c(aVar.f22834b);
        this.j = b.a.a.a(w.a(aVar.f22833a, this.i));
        this.k = b.a.a.a(d.a(aVar.f22833a));
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
        return this.f22827b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f22830e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(f fVar) {
        b(fVar);
    }

    public void a(j jVar) {
        b(jVar);
    }

    public void a(m mVar) {
        b(mVar);
    }

    public void a(p pVar) {
        b(pVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f22827b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f22826a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f22828c.get());
        l.a(kVar, d());
        l.a(kVar, this.f22827b.get());
        l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f22826a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f22829d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f22827b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f22826a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f22826a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f22827b.get());
        return aVar;
    }

    private f b(f fVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) fVar, (n) b.a.c.a(this.f22826a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) fVar, (bi) b.a.c.a(this.f22826a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) fVar, (com.shopee.app.application.a.b) b.a.c.a(this.f22826a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) fVar, this.f22831f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) fVar, (com.shopee.app.tracking.f) b.a.c.a(this.f22826a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) fVar, (UserInfo) b.a.c.a(this.f22826a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) fVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) fVar, this.f22827b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) fVar, (com.shopee.app.d.c.f) b.a.c.a(this.f22826a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) fVar, (com.shopee.app.tracking.a) b.a.c.a(this.f22826a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) fVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) fVar, (al) b.a.c.a(this.f22826a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) fVar, (ActionRequiredCounter) b.a.c.a(this.f22826a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) fVar, (ActivityCounter) b.a.c.a(this.f22826a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) fVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) fVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) fVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) fVar, g());
        g.a(fVar, this.j.get());
        return fVar;
    }

    private j b(j jVar) {
        l.a(jVar, this.k.get());
        l.a(jVar, i());
        l.a(jVar, this.f22828c.get());
        l.a(jVar, this.j.get());
        return jVar;
    }

    private m b(m mVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) mVar, (n) b.a.c.a(this.f22826a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) mVar, (bi) b.a.c.a(this.f22826a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) mVar, (com.shopee.app.application.a.b) b.a.c.a(this.f22826a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) mVar, this.f22831f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) mVar, (com.shopee.app.tracking.f) b.a.c.a(this.f22826a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) mVar, (UserInfo) b.a.c.a(this.f22826a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) mVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) mVar, this.f22827b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) mVar, (com.shopee.app.d.c.f) b.a.c.a(this.f22826a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) mVar, (com.shopee.app.tracking.a) b.a.c.a(this.f22826a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) mVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) mVar, (al) b.a.c.a(this.f22826a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) mVar, (ActionRequiredCounter) b.a.c.a(this.f22826a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) mVar, (ActivityCounter) b.a.c.a(this.f22826a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) mVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) mVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) mVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) mVar, g());
        return mVar;
    }

    private p b(p pVar) {
        r.a(pVar, k());
        r.a(pVar, this.f22828c.get());
        r.a(pVar, this.k.get());
        r.a(pVar, (be) b.a.c.a(this.f22826a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"));
        return pVar;
    }

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f22833a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f22834b;

        private a() {
        }

        public h a() {
            if (this.f22833a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f22834b != null) {
                return new e(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public a a(com.shopee.app.a.b bVar) {
            this.f22833a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public a a(UserComponent userComponent) {
            this.f22834b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f22835a;

        b(UserComponent userComponent) {
            this.f22835a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f22835a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f22836a;

        c(UserComponent userComponent) {
            this.f22836a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f22836a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
