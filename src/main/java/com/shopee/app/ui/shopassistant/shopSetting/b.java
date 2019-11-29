package com.shopee.app.ui.shopassistant.shopSetting;

import android.app.Activity;
import com.shopee.app.a.d;
import com.shopee.app.a.f;
import com.shopee.app.a.o;
import com.shopee.app.a.s;
import com.shopee.app.a.t;
import com.shopee.app.a.w;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.bt;
import com.shopee.app.d.c.bu;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.h.m;
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

public final class b implements j {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f25539a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f25540b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f25541c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f25542d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f25543e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f25544f;

    /* renamed from: g  reason: collision with root package name */
    private C0391b f25545g;
    private Provider<com.shopee.app.ui.common.a> h;
    private c i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private Provider<Activity> k;
    private Provider<com.shopee.app.ui.actionbar.a> l;

    private b(a aVar) {
        a(aVar);
    }

    public static a c() {
        return new a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f25539a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f25539a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f25539a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f25539a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i g() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f25539a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private bt h() {
        return bu.a((n) b.a.c.a(this.f25539a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bh(), (SettingConfigStore) b.a.c.a(this.f25539a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private k i() {
        return new k((n) b.a.c.a(this.f25539a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bh(), new m());
    }

    private l j() {
        return new l((n) b.a.c.a(this.f25539a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f25539a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), h(), i(), new m(), (UserInfo) b.a.c.a(this.f25539a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
    }

    private a k() {
        return new a((n) b.a.c.a(this.f25539a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bh(), new m());
    }

    private d l() {
        return new d(k());
    }

    private void a(a aVar) {
        this.f25540b = b.a.a.a(o.a(aVar.f25546a));
        this.f25539a = aVar.f25547b;
        this.f25541c = b.a.a.a(com.shopee.app.a.r.a(aVar.f25546a));
        this.f25542d = b.a.a.a(s.a(aVar.f25546a));
        this.f25543e = b.a.a.a(t.a(aVar.f25546a));
        this.f25544f = b.a.a.a(com.shopee.app.a.m.a(aVar.f25546a));
        this.f25545g = new C0391b(aVar.f25547b);
        this.h = b.a.a.a(f.a(aVar.f25546a, this.f25545g));
        this.i = new c(aVar.f25547b);
        this.j = b.a.a.a(w.a(aVar.f25546a, this.i));
        this.k = b.a.a.a(d.a(aVar.f25546a));
        this.l = b.a.a.a(com.shopee.app.a.c.a(aVar.f25546a));
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
        return this.f25540b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f25543e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(i iVar) {
        b(iVar);
    }

    public void a(n nVar) {
        b(nVar);
    }

    public void a(c cVar) {
        b(cVar);
    }

    public void a(f fVar) {
        b(fVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f25540b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f25539a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f25541c.get());
        l.a(kVar, d());
        l.a(kVar, this.f25540b.get());
        l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f25539a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f25542d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f25540b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f25539a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f25539a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f25540b.get());
        return aVar;
    }

    private i b(i iVar) {
        com.shopee.app.ui.a.f.a((e) iVar, (n) b.a.c.a(this.f25539a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) iVar, (bi) b.a.c.a(this.f25539a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) iVar, (com.shopee.app.application.a.b) b.a.c.a(this.f25539a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) iVar, this.f25544f.get());
        com.shopee.app.ui.a.f.a((e) iVar, (com.shopee.app.tracking.f) b.a.c.a(this.f25539a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) iVar, (UserInfo) b.a.c.a(this.f25539a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) iVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) iVar, this.f25540b.get());
        com.shopee.app.ui.a.f.a((e) iVar, (com.shopee.app.d.c.f) b.a.c.a(this.f25539a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) iVar, (com.shopee.app.tracking.a) b.a.c.a(this.f25539a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) iVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) iVar, (al) b.a.c.a(this.f25539a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) iVar, (ActionRequiredCounter) b.a.c.a(this.f25539a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) iVar, (ActivityCounter) b.a.c.a(this.f25539a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) iVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) iVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) iVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) iVar, g());
        return iVar;
    }

    private n b(n nVar) {
        p.a(nVar, this.f25540b.get());
        p.a(nVar, this.f25544f.get());
        p.a(nVar, this.k.get());
        p.a(nVar, j());
        p.a(nVar, this.f25541c.get());
        p.a(nVar, (UserInfo) b.a.c.a(this.f25539a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        p.a(nVar, (SettingConfigStore) b.a.c.a(this.f25539a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        return nVar;
    }

    private c b(c cVar) {
        com.shopee.app.ui.a.f.a((e) cVar, (n) b.a.c.a(this.f25539a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, (bi) b.a.c.a(this.f25539a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, (com.shopee.app.application.a.b) b.a.c.a(this.f25539a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, this.f25544f.get());
        com.shopee.app.ui.a.f.a((e) cVar, (com.shopee.app.tracking.f) b.a.c.a(this.f25539a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, (UserInfo) b.a.c.a(this.f25539a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) cVar, this.f25540b.get());
        com.shopee.app.ui.a.f.a((e) cVar, (com.shopee.app.d.c.f) b.a.c.a(this.f25539a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, (com.shopee.app.tracking.a) b.a.c.a(this.f25539a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) cVar, (al) b.a.c.a(this.f25539a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, (ActionRequiredCounter) b.a.c.a(this.f25539a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, (ActivityCounter) b.a.c.a(this.f25539a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, g());
        return cVar;
    }

    private f b(f fVar) {
        h.a(fVar, this.k.get());
        h.a(fVar, this.l.get());
        h.a(fVar, this.f25541c.get());
        h.a(fVar, l());
        h.a(fVar, this.f25544f.get());
        return fVar;
    }

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f25546a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f25547b;

        private a() {
        }

        public j a() {
            if (this.f25546a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f25547b != null) {
                return new b(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public a a(com.shopee.app.a.b bVar) {
            this.f25546a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public a a(UserComponent userComponent) {
            this.f25547b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    /* renamed from: com.shopee.app.ui.shopassistant.shopSetting.b$b  reason: collision with other inner class name */
    private static class C0391b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f25548a;

        C0391b(UserComponent userComponent) {
            this.f25548a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f25548a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f25549a;

        c(UserComponent userComponent) {
            this.f25549a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f25549a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
