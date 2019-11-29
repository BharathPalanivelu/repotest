package com.shopee.app.ui.image.crop;

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

public final class g implements b {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f22809a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f22810b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f22811c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f22812d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f22813e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f22814f;

    /* renamed from: g  reason: collision with root package name */
    private b f22815g;
    private Provider<com.shopee.app.ui.common.a> h;
    private c i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private Provider<com.shopee.app.ui.actionbar.a> k;
    private Provider<Activity> l;

    private g(a aVar) {
        a(aVar);
    }

    public static a c() {
        return new a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f22809a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f22809a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f22809a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f22809a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i g() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f22809a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private c h() {
        return new c((n) b.a.c.a(this.f22809a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private void a(a aVar) {
        this.f22810b = b.a.a.a(o.a(aVar.f22816a));
        this.f22809a = aVar.f22817b;
        this.f22811c = b.a.a.a(com.shopee.app.a.r.a(aVar.f22816a));
        this.f22812d = b.a.a.a(s.a(aVar.f22816a));
        this.f22813e = b.a.a.a(t.a(aVar.f22816a));
        this.f22814f = b.a.a.a(m.a(aVar.f22816a));
        this.f22815g = new b(aVar.f22817b);
        this.h = b.a.a.a(f.a(aVar.f22816a, this.f22815g));
        this.i = new c(aVar.f22817b);
        this.j = b.a.a.a(w.a(aVar.f22816a, this.i));
        this.k = b.a.a.a(com.shopee.app.a.c.a(aVar.f22816a));
        this.l = b.a.a.a(d.a(aVar.f22816a));
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
        return this.f22810b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f22813e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(a aVar) {
        b(aVar);
    }

    public void a(d dVar) {
        b(dVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f22810b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f22809a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f22811c.get());
        l.a(kVar, d());
        l.a(kVar, this.f22810b.get());
        l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f22809a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f22812d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f22810b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f22809a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f22809a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f22810b.get());
        return aVar;
    }

    private a b(a aVar) {
        com.shopee.app.ui.a.f.a((e) aVar, (n) b.a.c.a(this.f22809a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, (bi) b.a.c.a(this.f22809a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f22809a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, this.f22814f.get());
        com.shopee.app.ui.a.f.a((e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f22809a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, (UserInfo) b.a.c.a(this.f22809a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) aVar, this.f22810b.get());
        com.shopee.app.ui.a.f.a((e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f22809a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f22809a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) aVar, (al) b.a.c.a(this.f22809a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f22809a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f22809a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, g());
        return aVar;
    }

    private d b(d dVar) {
        f.a(dVar, this.f22811c.get());
        f.a(dVar, h());
        f.a(dVar, this.f22810b.get());
        f.a(dVar, this.k.get());
        f.a(dVar, this.l.get());
        f.a(dVar, this.f22814f.get());
        return dVar;
    }

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f22816a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f22817b;

        private a() {
        }

        public b a() {
            if (this.f22816a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f22817b != null) {
                return new g(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public a a(com.shopee.app.a.b bVar) {
            this.f22816a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public a a(UserComponent userComponent) {
            this.f22817b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f22818a;

        b(UserComponent userComponent) {
            this.f22818a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f22818a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f22819a;

        c(UserComponent userComponent) {
            this.f22819a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f22819a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
