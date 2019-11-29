package com.shopee.app.ui.a;

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
import com.shopee.app.ui.actionbar.k;
import com.shopee.app.ui.actionbar.l;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.ui.common.i;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.home.me.v3.OptionBox;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.photo.PhotoProxyActivity;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class j implements k {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f19207a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f19208b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f19209c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f19210d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f19211e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f19212f;

    /* renamed from: g  reason: collision with root package name */
    private b f19213g;
    private Provider<com.shopee.app.ui.common.a> h;
    private c i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;

    private j(a aVar) {
        a(aVar);
    }

    public static a c() {
        return new a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f19207a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f19207a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f19207a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f19207a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i g() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f19207a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private void a(a aVar) {
        this.f19208b = b.a.a.a(o.a(aVar.f19214a));
        this.f19207a = aVar.f19215b;
        this.f19209c = b.a.a.a(com.shopee.app.a.r.a(aVar.f19214a));
        this.f19210d = b.a.a.a(s.a(aVar.f19214a));
        this.f19211e = b.a.a.a(t.a(aVar.f19214a));
        this.f19212f = b.a.a.a(m.a(aVar.f19214a));
        this.f19213g = new b(aVar.f19215b);
        this.h = b.a.a.a(f.a(aVar.f19214a, this.f19213g));
        this.i = new c(aVar.f19215b);
        this.j = b.a.a.a(w.a(aVar.f19214a, this.i));
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
        return this.f19208b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f19211e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(PhotoProxyActivity photoProxyActivity) {
        b(photoProxyActivity);
    }

    public void a(com.shopee.app.react.util.image.a aVar) {
        b(aVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f19208b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f19207a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f19209c.get());
        l.a(kVar, d());
        l.a(kVar, this.f19208b.get());
        l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f19207a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f19210d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f19208b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f19207a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f19207a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f19208b.get());
        return aVar;
    }

    private PhotoProxyActivity b(PhotoProxyActivity photoProxyActivity) {
        f.a((e) photoProxyActivity, (n) b.a.c.a(this.f19207a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        f.a((e) photoProxyActivity, (bi) b.a.c.a(this.f19207a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        f.a((e) photoProxyActivity, (com.shopee.app.application.a.b) b.a.c.a(this.f19207a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        f.a((e) photoProxyActivity, this.f19212f.get());
        f.a((e) photoProxyActivity, (com.shopee.app.tracking.f) b.a.c.a(this.f19207a.tracker(), "Cannot return null from a non-@Nullable component method"));
        f.a((e) photoProxyActivity, (UserInfo) b.a.c.a(this.f19207a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        f.a((e) photoProxyActivity, this.h.get());
        f.a((e) photoProxyActivity, this.f19208b.get());
        f.a((e) photoProxyActivity, (com.shopee.app.d.c.f) b.a.c.a(this.f19207a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        f.a((e) photoProxyActivity, (com.shopee.app.tracking.a) b.a.c.a(this.f19207a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        f.a((e) photoProxyActivity, this.j.get());
        f.a((e) photoProxyActivity, (al) b.a.c.a(this.f19207a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        c.a((b) photoProxyActivity, (ActionRequiredCounter) b.a.c.a(this.f19207a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        c.a((b) photoProxyActivity, (ActivityCounter) b.a.c.a(this.f19207a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        c.a((b) photoProxyActivity, e());
        c.a((b) photoProxyActivity, this.h.get());
        c.a((b) photoProxyActivity, f());
        c.a((b) photoProxyActivity, g());
        com.shopee.app.ui.photo.a.a(photoProxyActivity, (com.shopee.app.application.a.b) b.a.c.a(this.f19207a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.photo.a.a(photoProxyActivity, (UserInfo) b.a.c.a(this.f19207a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return photoProxyActivity;
    }

    private com.shopee.app.react.util.image.a b(com.shopee.app.react.util.image.a aVar) {
        f.a((e) aVar, (n) b.a.c.a(this.f19207a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        f.a((e) aVar, (bi) b.a.c.a(this.f19207a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        f.a((e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f19207a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        f.a((e) aVar, this.f19212f.get());
        f.a((e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f19207a.tracker(), "Cannot return null from a non-@Nullable component method"));
        f.a((e) aVar, (UserInfo) b.a.c.a(this.f19207a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        f.a((e) aVar, this.h.get());
        f.a((e) aVar, this.f19208b.get());
        f.a((e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f19207a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        f.a((e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f19207a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        f.a((e) aVar, this.j.get());
        f.a((e) aVar, (al) b.a.c.a(this.f19207a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        c.a((b) aVar, (ActionRequiredCounter) b.a.c.a(this.f19207a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        c.a((b) aVar, (ActivityCounter) b.a.c.a(this.f19207a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        c.a((b) aVar, e());
        c.a((b) aVar, this.h.get());
        c.a((b) aVar, f());
        c.a((b) aVar, g());
        com.shopee.app.react.util.image.b.a(aVar, this.f19212f.get());
        return aVar;
    }

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f19214a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f19215b;

        private a() {
        }

        public k a() {
            if (this.f19214a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f19215b != null) {
                return new j(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public a a(com.shopee.app.a.b bVar) {
            this.f19214a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public a a(UserComponent userComponent) {
            this.f19215b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f19216a;

        b(UserComponent userComponent) {
            this.f19216a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f19216a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f19217a;

        c(UserComponent userComponent) {
            this.f19217a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f19217a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
