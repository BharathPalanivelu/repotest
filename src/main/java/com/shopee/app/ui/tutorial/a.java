package com.shopee.app.ui.tutorial;

import android.app.Activity;
import com.shopee.app.a.f;
import com.shopee.app.a.m;
import com.shopee.app.a.o;
import com.shopee.app.a.q;
import com.shopee.app.a.s;
import com.shopee.app.a.t;
import com.shopee.app.a.w;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.data.store.RegionConfigStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.al;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.ui.a.e;
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

public final class a implements g {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f25692a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f25693b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f25694c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f25695d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f25696e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f25697f;

    /* renamed from: g  reason: collision with root package name */
    private b f25698g;
    private Provider<com.shopee.app.ui.common.a> h;
    private d i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private c k;
    private Provider<RegionConfig> l;
    private Provider<Activity> m;

    private a(C0394a aVar) {
        a(aVar);
    }

    public static C0394a c() {
        return new C0394a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f25692a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f25692a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f25692a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f25692a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i g() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f25692a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private void a(C0394a aVar) {
        this.f25693b = b.a.a.a(o.a(aVar.f25699a));
        this.f25692a = aVar.f25700b;
        this.f25694c = b.a.a.a(com.shopee.app.a.r.a(aVar.f25699a));
        this.f25695d = b.a.a.a(s.a(aVar.f25699a));
        this.f25696e = b.a.a.a(t.a(aVar.f25699a));
        this.f25697f = b.a.a.a(m.a(aVar.f25699a));
        this.f25698g = new b(aVar.f25700b);
        this.h = b.a.a.a(f.a(aVar.f25699a, this.f25698g));
        this.i = new d(aVar.f25700b);
        this.j = b.a.a.a(w.a(aVar.f25699a, this.i));
        this.k = new c(aVar.f25700b);
        this.l = b.a.a.a(q.a(aVar.f25699a, this.k));
        this.m = b.a.a.a(com.shopee.app.a.d.a(aVar.f25699a));
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
        return this.f25693b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f25696e.get();
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

    public void a(b bVar) {
        b(bVar);
    }

    public void a(c cVar) {
        b(cVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f25693b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f25692a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f25694c.get());
        l.a(kVar, d());
        l.a(kVar, this.f25693b.get());
        l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f25692a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f25695d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f25693b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f25692a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f25692a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f25693b.get());
        return aVar;
    }

    private f b(f fVar) {
        com.shopee.app.ui.a.f.a((e) fVar, (n) b.a.c.a(this.f25692a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) fVar, (bi) b.a.c.a(this.f25692a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) fVar, (com.shopee.app.application.a.b) b.a.c.a(this.f25692a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) fVar, this.f25697f.get());
        com.shopee.app.ui.a.f.a((e) fVar, (com.shopee.app.tracking.f) b.a.c.a(this.f25692a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) fVar, (UserInfo) b.a.c.a(this.f25692a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) fVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) fVar, this.f25693b.get());
        com.shopee.app.ui.a.f.a((e) fVar, (com.shopee.app.d.c.f) b.a.c.a(this.f25692a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) fVar, (com.shopee.app.tracking.a) b.a.c.a(this.f25692a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) fVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) fVar, (al) b.a.c.a(this.f25692a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) fVar, (ActionRequiredCounter) b.a.c.a(this.f25692a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) fVar, (ActivityCounter) b.a.c.a(this.f25692a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) fVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) fVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) fVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) fVar, g());
        return fVar;
    }

    private j b(j jVar) {
        l.a(jVar, this.l.get());
        return jVar;
    }

    private b b(b bVar) {
        com.shopee.app.ui.a.f.a((e) bVar, (n) b.a.c.a(this.f25692a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, (bi) b.a.c.a(this.f25692a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, (com.shopee.app.application.a.b) b.a.c.a(this.f25692a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, this.f25697f.get());
        com.shopee.app.ui.a.f.a((e) bVar, (com.shopee.app.tracking.f) b.a.c.a(this.f25692a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, (UserInfo) b.a.c.a(this.f25692a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) bVar, this.f25693b.get());
        com.shopee.app.ui.a.f.a((e) bVar, (com.shopee.app.d.c.f) b.a.c.a(this.f25692a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, (com.shopee.app.tracking.a) b.a.c.a(this.f25692a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) bVar, (al) b.a.c.a(this.f25692a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActionRequiredCounter) b.a.c.a(this.f25692a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActivityCounter) b.a.c.a(this.f25692a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, g());
        return bVar;
    }

    private c b(c cVar) {
        e.a(cVar, (aa) b.a.c.a(this.f25692a.deviceStore(), "Cannot return null from a non-@Nullable component method"));
        e.a(cVar, this.m.get());
        e.a(cVar, this.f25697f.get());
        e.a(cVar, this.f25693b.get());
        return cVar;
    }

    /* renamed from: com.shopee.app.ui.tutorial.a$a  reason: collision with other inner class name */
    public static final class C0394a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f25699a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f25700b;

        private C0394a() {
        }

        public g a() {
            if (this.f25699a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f25700b != null) {
                return new a(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public C0394a a(com.shopee.app.a.b bVar) {
            this.f25699a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public C0394a a(UserComponent userComponent) {
            this.f25700b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f25701a;

        b(UserComponent userComponent) {
            this.f25701a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f25701a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class d implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f25703a;

        d(UserComponent userComponent) {
            this.f25703a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f25703a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<RegionConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f25702a;

        c(UserComponent userComponent) {
            this.f25702a = userComponent;
        }

        /* renamed from: a */
        public RegionConfigStore get() {
            return (RegionConfigStore) b.a.c.a(this.f25702a.regionConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
