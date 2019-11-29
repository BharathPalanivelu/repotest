package com.shopee.app.ui.chat2.block;

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
import com.shopee.app.data.store.l;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.ui.a.e;
import com.shopee.app.ui.actionbar.k;
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

public final class q implements e {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f20352a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f20353b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f20354c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f20355d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f20356e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f20357f;

    /* renamed from: g  reason: collision with root package name */
    private b f20358g;
    private Provider<com.shopee.app.ui.common.a> h;
    private c i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private Provider<Activity> k;

    private q(a aVar) {
        a(aVar);
    }

    public static a c() {
        return new a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f20352a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f20352a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f20352a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f20352a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i g() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f20352a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private r h() {
        return new r((n) b.a.c.a(this.f20352a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), l.b());
    }

    private i i() {
        return new i((n) b.a.c.a(this.f20352a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), h());
    }

    private void a(a aVar) {
        this.f20353b = b.a.a.a(o.a(aVar.f20359a));
        this.f20352a = aVar.f20360b;
        this.f20354c = b.a.a.a(com.shopee.app.a.r.a(aVar.f20359a));
        this.f20355d = b.a.a.a(s.a(aVar.f20359a));
        this.f20356e = b.a.a.a(t.a(aVar.f20359a));
        this.f20357f = b.a.a.a(m.a(aVar.f20359a));
        this.f20358g = new b(aVar.f20360b);
        this.h = b.a.a.a(f.a(aVar.f20359a, this.f20358g));
        this.i = new c(aVar.f20360b);
        this.j = b.a.a.a(w.a(aVar.f20359a, this.i));
        this.k = b.a.a.a(d.a(aVar.f20359a));
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
        return this.f20353b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f20356e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(d dVar) {
        b(dVar);
    }

    public void a(l lVar) {
        b(lVar);
    }

    public void a(f fVar) {
        b(fVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f20353b.get());
        return avatarView;
    }

    private k b(k kVar) {
        com.shopee.app.ui.actionbar.l.a(kVar, (bi) b.a.c.a(this.f20352a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbar.l.a(kVar, this.f20354c.get());
        com.shopee.app.ui.actionbar.l.a(kVar, d());
        com.shopee.app.ui.actionbar.l.a(kVar, this.f20353b.get());
        com.shopee.app.ui.actionbar.l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f20352a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f20355d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f20353b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f20352a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f20352a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f20353b.get());
        return aVar;
    }

    private d b(d dVar) {
        com.shopee.app.ui.a.f.a((e) dVar, (n) b.a.c.a(this.f20352a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, (bi) b.a.c.a(this.f20352a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, (com.shopee.app.application.a.b) b.a.c.a(this.f20352a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, this.f20357f.get());
        com.shopee.app.ui.a.f.a((e) dVar, (com.shopee.app.tracking.f) b.a.c.a(this.f20352a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, (UserInfo) b.a.c.a(this.f20352a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) dVar, this.f20353b.get());
        com.shopee.app.ui.a.f.a((e) dVar, (com.shopee.app.d.c.f) b.a.c.a(this.f20352a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, (com.shopee.app.tracking.a) b.a.c.a(this.f20352a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) dVar, (al) b.a.c.a(this.f20352a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, (ActionRequiredCounter) b.a.c.a(this.f20352a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, (ActivityCounter) b.a.c.a(this.f20352a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, g());
        return dVar;
    }

    private l b(l lVar) {
        n.a(lVar, this.f20354c.get());
        n.a(lVar, i());
        n.a(lVar, this.f20357f.get());
        n.a(lVar, this.k.get());
        return lVar;
    }

    private f b(f fVar) {
        h.a(fVar, (bi) b.a.c.a(this.f20352a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        h.a(fVar, (UserInfo) b.a.c.a(this.f20352a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        h.a(fVar, this.f20353b.get());
        return fVar;
    }

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f20359a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f20360b;

        private a() {
        }

        public e a() {
            if (this.f20359a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f20360b != null) {
                return new q(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public a a(com.shopee.app.a.b bVar) {
            this.f20359a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public a a(UserComponent userComponent) {
            this.f20360b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f20361a;

        b(UserComponent userComponent) {
            this.f20361a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f20361a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f20362a;

        c(UserComponent userComponent) {
            this.f20362a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f20362a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
