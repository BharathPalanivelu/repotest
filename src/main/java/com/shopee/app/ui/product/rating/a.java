package com.shopee.app.ui.product.rating;

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
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.bh;
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

public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f24712a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f24713b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f24714c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f24715d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f24716e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f24717f;

    /* renamed from: g  reason: collision with root package name */
    private b f24718g;
    private Provider<com.shopee.app.ui.common.a> h;
    private c i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private Provider<Activity> k;

    private a(C0379a aVar) {
        a(aVar);
    }

    public static C0379a c() {
        return new C0379a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f24712a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f24712a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f24712a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f24712a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i g() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f24712a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private b h() {
        return new b((n) b.a.c.a(this.f24712a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new ao(), new bh());
    }

    private e i() {
        return new e(h());
    }

    private void a(C0379a aVar) {
        this.f24713b = b.a.a.a(o.a(aVar.f24719a));
        this.f24712a = aVar.f24720b;
        this.f24714c = b.a.a.a(com.shopee.app.a.r.a(aVar.f24719a));
        this.f24715d = b.a.a.a(s.a(aVar.f24719a));
        this.f24716e = b.a.a.a(t.a(aVar.f24719a));
        this.f24717f = b.a.a.a(m.a(aVar.f24719a));
        this.f24718g = new b(aVar.f24720b);
        this.h = b.a.a.a(f.a(aVar.f24719a, this.f24718g));
        this.i = new c(aVar.f24720b);
        this.j = b.a.a.a(w.a(aVar.f24719a, this.i));
        this.k = b.a.a.a(d.a(aVar.f24719a));
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
        return this.f24713b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f24716e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(d dVar) {
        b(dVar);
    }

    public void a(g gVar) {
        b(gVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f24713b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f24712a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f24714c.get());
        l.a(kVar, d());
        l.a(kVar, this.f24713b.get());
        l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f24712a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f24715d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f24713b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f24712a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f24712a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f24713b.get());
        return aVar;
    }

    private d b(d dVar) {
        com.shopee.app.ui.a.f.a((e) dVar, (n) b.a.c.a(this.f24712a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, (bi) b.a.c.a(this.f24712a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, (com.shopee.app.application.a.b) b.a.c.a(this.f24712a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, this.f24717f.get());
        com.shopee.app.ui.a.f.a((e) dVar, (com.shopee.app.tracking.f) b.a.c.a(this.f24712a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, (UserInfo) b.a.c.a(this.f24712a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) dVar, this.f24713b.get());
        com.shopee.app.ui.a.f.a((e) dVar, (com.shopee.app.d.c.f) b.a.c.a(this.f24712a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, (com.shopee.app.tracking.a) b.a.c.a(this.f24712a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) dVar, (al) b.a.c.a(this.f24712a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, (ActionRequiredCounter) b.a.c.a(this.f24712a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, (ActivityCounter) b.a.c.a(this.f24712a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, g());
        return dVar;
    }

    private g b(g gVar) {
        i.a(gVar, this.k.get());
        i.a(gVar, i());
        i.a(gVar, this.f24714c.get());
        i.a(gVar, (n) b.a.c.a(this.f24712a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        i.a(gVar, this.f24717f.get());
        return gVar;
    }

    /* renamed from: com.shopee.app.ui.product.rating.a$a  reason: collision with other inner class name */
    public static final class C0379a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f24719a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f24720b;

        private C0379a() {
        }

        public c a() {
            if (this.f24719a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f24720b != null) {
                return new a(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public C0379a a(com.shopee.app.a.b bVar) {
            this.f24719a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public C0379a a(UserComponent userComponent) {
            this.f24720b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f24721a;

        b(UserComponent userComponent) {
            this.f24721a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f24721a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f24722a;

        c(UserComponent userComponent) {
            this.f24722a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f24722a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
