package com.shopee.app.ui.follow.following.recommend;

import android.app.Activity;
import com.shopee.app.a.d;
import com.shopee.app.a.m;
import com.shopee.app.a.o;
import com.shopee.app.a.s;
import com.shopee.app.a.w;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.am;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.aj;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.be;
import com.shopee.app.data.store.t;
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

public final class f implements i {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f21697a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f21698b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f21699c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f21700d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f21701e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f21702f;

    /* renamed from: g  reason: collision with root package name */
    private b f21703g;
    private Provider<com.shopee.app.ui.common.a> h;
    private c i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private Provider<Activity> k;

    private f(a aVar) {
        a(aVar);
    }

    public static a c() {
        return new a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f21697a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f21697a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f21697a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f21697a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i g() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f21697a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.follow.following.n h() {
        return new com.shopee.app.ui.follow.following.n((n) b.a.c.a(this.f21697a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new t());
    }

    private am i() {
        return new am((n) b.a.c.a(this.f21697a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (aa) b.a.c.a(this.f21697a.deviceStore(), "Cannot return null from a non-@Nullable component method"), (be) b.a.c.a(this.f21697a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"), new aj());
    }

    private com.shopee.app.ui.follow.following.c j() {
        return new com.shopee.app.ui.follow.following.c((n) b.a.c.a(this.f21697a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private g k() {
        return new g((n) b.a.c.a(this.f21697a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new t());
    }

    private d l() {
        return new d((n) b.a.c.a(this.f21697a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f21697a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), h(), i(), (com.shopee.app.ui.follow.following.i) b.a.c.a(this.f21697a.getContactInteractor(), "Cannot return null from a non-@Nullable component method"), j(), k(), new t(), (aa) b.a.c.a(this.f21697a.deviceStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private o m() {
        return new o(new p());
    }

    private void a(a aVar) {
        this.f21698b = b.a.a.a(o.a(aVar.f21704a));
        this.f21697a = aVar.f21705b;
        this.f21699c = b.a.a.a(com.shopee.app.a.r.a(aVar.f21704a));
        this.f21700d = b.a.a.a(s.a(aVar.f21704a));
        this.f21701e = b.a.a.a(com.shopee.app.a.t.a(aVar.f21704a));
        this.f21702f = b.a.a.a(m.a(aVar.f21704a));
        this.f21703g = new b(aVar.f21705b);
        this.h = b.a.a.a(com.shopee.app.a.f.a(aVar.f21704a, this.f21703g));
        this.i = new c(aVar.f21705b);
        this.j = b.a.a.a(w.a(aVar.f21704a, this.i));
        this.k = b.a.a.a(d.a(aVar.f21704a));
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
        return this.f21698b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f21701e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(h hVar) {
        b(hVar);
    }

    public void a(j jVar) {
        b(jVar);
    }

    public void a(a aVar) {
        b(aVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f21698b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f21697a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f21699c.get());
        l.a(kVar, d());
        l.a(kVar, this.f21698b.get());
        l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f21697a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f21700d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f21698b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f21697a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f21697a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f21698b.get());
        return aVar;
    }

    private h b(h hVar) {
        com.shopee.app.ui.a.f.a((e) hVar, (n) b.a.c.a(this.f21697a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) hVar, (bi) b.a.c.a(this.f21697a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) hVar, (com.shopee.app.application.a.b) b.a.c.a(this.f21697a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) hVar, this.f21702f.get());
        com.shopee.app.ui.a.f.a((e) hVar, (com.shopee.app.tracking.f) b.a.c.a(this.f21697a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) hVar, (UserInfo) b.a.c.a(this.f21697a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) hVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) hVar, this.f21698b.get());
        com.shopee.app.ui.a.f.a((e) hVar, (com.shopee.app.d.c.f) b.a.c.a(this.f21697a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) hVar, (com.shopee.app.tracking.a) b.a.c.a(this.f21697a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) hVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) hVar, (al) b.a.c.a(this.f21697a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) hVar, (ActionRequiredCounter) b.a.c.a(this.f21697a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) hVar, (ActivityCounter) b.a.c.a(this.f21697a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) hVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) hVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) hVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) hVar, g());
        return hVar;
    }

    private j b(j jVar) {
        l.a(jVar, this.f21702f.get());
        l.a(jVar, l());
        l.a(jVar, this.k.get());
        l.a(jVar, this.f21699c.get());
        l.a(jVar, this.f21698b.get());
        l.a(jVar, m());
        return jVar;
    }

    private a b(a aVar) {
        c.a(aVar, (bi) b.a.c.a(this.f21697a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        c.a(aVar, (UserInfo) b.a.c.a(this.f21697a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        c.a(aVar, this.f21698b.get());
        return aVar;
    }

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f21704a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f21705b;

        private a() {
        }

        public i a() {
            if (this.f21704a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f21705b != null) {
                return new f(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public a a(com.shopee.app.a.b bVar) {
            this.f21704a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public a a(UserComponent userComponent) {
            this.f21705b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f21706a;

        b(UserComponent userComponent) {
            this.f21706a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f21706a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f21707a;

        c(UserComponent userComponent) {
            this.f21707a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f21707a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
