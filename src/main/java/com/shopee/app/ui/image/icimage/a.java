package com.shopee.app.ui.image.icimage;

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
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.SettingConfigStore;
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

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f22978a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f22979b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f22980c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f22981d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f22982e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f22983f;

    /* renamed from: g  reason: collision with root package name */
    private b f22984g;
    private Provider<com.shopee.app.ui.common.a> h;
    private c i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private Provider<Activity> k;

    private a(C0359a aVar) {
        a(aVar);
    }

    public static C0359a c() {
        return new C0359a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f22978a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f22978a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f22978a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f22978a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i g() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f22978a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private void a(C0359a aVar) {
        this.f22979b = b.a.a.a(o.a(aVar.f22985a));
        this.f22978a = aVar.f22986b;
        this.f22980c = b.a.a.a(com.shopee.app.a.r.a(aVar.f22985a));
        this.f22981d = b.a.a.a(s.a(aVar.f22985a));
        this.f22982e = b.a.a.a(t.a(aVar.f22985a));
        this.f22983f = b.a.a.a(m.a(aVar.f22985a));
        this.f22984g = new b(aVar.f22986b);
        this.h = b.a.a.a(f.a(aVar.f22985a, this.f22984g));
        this.i = new c(aVar.f22986b);
        this.j = b.a.a.a(w.a(aVar.f22985a, this.i));
        this.k = b.a.a.a(d.a(aVar.f22985a));
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
        return this.f22979b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f22982e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(d dVar) {
        b(dVar);
    }

    public void a(e eVar) {
        b(eVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f22979b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f22978a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f22980c.get());
        l.a(kVar, d());
        l.a(kVar, this.f22979b.get());
        l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f22978a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f22981d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f22979b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f22978a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f22978a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f22979b.get());
        return aVar;
    }

    private d b(d dVar) {
        com.shopee.app.ui.a.f.a((e) dVar, (n) b.a.c.a(this.f22978a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, (bi) b.a.c.a(this.f22978a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, (com.shopee.app.application.a.b) b.a.c.a(this.f22978a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, this.f22983f.get());
        com.shopee.app.ui.a.f.a((e) dVar, (com.shopee.app.tracking.f) b.a.c.a(this.f22978a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, (UserInfo) b.a.c.a(this.f22978a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) dVar, this.f22979b.get());
        com.shopee.app.ui.a.f.a((e) dVar, (com.shopee.app.d.c.f) b.a.c.a(this.f22978a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, (com.shopee.app.tracking.a) b.a.c.a(this.f22978a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) dVar, (al) b.a.c.a(this.f22978a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, (ActionRequiredCounter) b.a.c.a(this.f22978a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, (ActivityCounter) b.a.c.a(this.f22978a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, g());
        return dVar;
    }

    private e b(e eVar) {
        g.a(eVar, this.k.get());
        g.a(eVar, this.f22983f.get());
        return eVar;
    }

    /* renamed from: com.shopee.app.ui.image.icimage.a$a  reason: collision with other inner class name */
    public static final class C0359a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f22985a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f22986b;

        private C0359a() {
        }

        public b a() {
            if (this.f22985a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f22986b != null) {
                return new a(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public C0359a a(com.shopee.app.a.b bVar) {
            this.f22985a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public C0359a a(UserComponent userComponent) {
            this.f22986b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f22987a;

        b(UserComponent userComponent) {
            this.f22987a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f22987a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f22988a;

        c(UserComponent userComponent) {
            this.f22988a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f22988a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
