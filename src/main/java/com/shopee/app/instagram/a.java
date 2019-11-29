package com.shopee.app.instagram;

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

public final class a implements g {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f17735a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f17736b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f17737c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f17738d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f17739e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f17740f;

    /* renamed from: g  reason: collision with root package name */
    private b f17741g;
    private Provider<com.shopee.app.ui.common.a> h;
    private c i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;

    private a(C0264a aVar) {
        a(aVar);
    }

    public static C0264a c() {
        return new C0264a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f17735a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f17735a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f17735a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f17735a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i g() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f17735a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private void a(C0264a aVar) {
        this.f17736b = b.a.a.a(o.a(aVar.f17742a));
        this.f17735a = aVar.f17743b;
        this.f17737c = b.a.a.a(com.shopee.app.a.r.a(aVar.f17742a));
        this.f17738d = b.a.a.a(s.a(aVar.f17742a));
        this.f17739e = b.a.a.a(t.a(aVar.f17742a));
        this.f17740f = b.a.a.a(m.a(aVar.f17742a));
        this.f17741g = new b(aVar.f17743b);
        this.h = b.a.a.a(f.a(aVar.f17742a, this.f17741g));
        this.i = new c(aVar.f17743b);
        this.j = b.a.a.a(w.a(aVar.f17742a, this.i));
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
        return this.f17736b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f17739e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(b bVar) {
        b(bVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f17736b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f17735a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f17737c.get());
        l.a(kVar, d());
        l.a(kVar, this.f17736b.get());
        l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f17735a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f17738d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f17736b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f17735a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f17735a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f17736b.get());
        return aVar;
    }

    private b b(b bVar) {
        com.shopee.app.ui.a.f.a((e) bVar, (n) b.a.c.a(this.f17735a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, (bi) b.a.c.a(this.f17735a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, (com.shopee.app.application.a.b) b.a.c.a(this.f17735a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, this.f17740f.get());
        com.shopee.app.ui.a.f.a((e) bVar, (com.shopee.app.tracking.f) b.a.c.a(this.f17735a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, (UserInfo) b.a.c.a(this.f17735a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) bVar, this.f17736b.get());
        com.shopee.app.ui.a.f.a((e) bVar, (com.shopee.app.d.c.f) b.a.c.a(this.f17735a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, (com.shopee.app.tracking.a) b.a.c.a(this.f17735a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) bVar, (al) b.a.c.a(this.f17735a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActionRequiredCounter) b.a.c.a(this.f17735a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActivityCounter) b.a.c.a(this.f17735a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, g());
        return bVar;
    }

    /* renamed from: com.shopee.app.instagram.a$a  reason: collision with other inner class name */
    public static final class C0264a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f17742a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f17743b;

        private C0264a() {
        }

        public g a() {
            if (this.f17742a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f17743b != null) {
                return new a(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public C0264a a(com.shopee.app.a.b bVar) {
            this.f17742a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public C0264a a(UserComponent userComponent) {
            this.f17743b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f17744a;

        b(UserComponent userComponent) {
            this.f17744a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f17744a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f17745a;

        c(UserComponent userComponent) {
            this.f17745a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f17745a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
