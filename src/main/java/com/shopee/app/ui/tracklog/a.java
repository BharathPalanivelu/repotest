package com.shopee.app.ui.tracklog;

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

public final class a implements h {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f25634a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f25635b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f25636c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f25637d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f25638e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f25639f;

    /* renamed from: g  reason: collision with root package name */
    private b f25640g;
    private Provider<com.shopee.app.ui.common.a> h;
    private c i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;

    private a(C0392a aVar) {
        a(aVar);
    }

    public static C0392a c() {
        return new C0392a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f25634a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f25634a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f25634a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f25634a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private i g() {
        return new i((al) b.a.c.a(this.f25634a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private void a(C0392a aVar) {
        this.f25635b = b.a.a.a(o.a(aVar.f25641a));
        this.f25634a = aVar.f25642b;
        this.f25636c = b.a.a.a(com.shopee.app.a.r.a(aVar.f25641a));
        this.f25637d = b.a.a.a(s.a(aVar.f25641a));
        this.f25638e = b.a.a.a(t.a(aVar.f25641a));
        this.f25639f = b.a.a.a(m.a(aVar.f25641a));
        this.f25640g = new b(aVar.f25642b);
        this.h = b.a.a.a(f.a(aVar.f25641a, this.f25640g));
        this.i = new c(aVar.f25642b);
        this.j = b.a.a.a(w.a(aVar.f25641a, this.i));
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
        return this.f25635b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f25638e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(TrackLogActivity trackLogActivity) {
        b(trackLogActivity);
    }

    public void a(j jVar) {
        b(jVar);
    }

    public void a(d dVar) {
        b(dVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f25635b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f25634a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f25636c.get());
        l.a(kVar, d());
        l.a(kVar, this.f25635b.get());
        l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f25634a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f25637d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f25635b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f25634a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f25634a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f25635b.get());
        return aVar;
    }

    private TrackLogActivity b(TrackLogActivity trackLogActivity) {
        com.shopee.app.ui.a.f.a((e) trackLogActivity, (n) b.a.c.a(this.f25634a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) trackLogActivity, (bi) b.a.c.a(this.f25634a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) trackLogActivity, (com.shopee.app.application.a.b) b.a.c.a(this.f25634a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) trackLogActivity, this.f25639f.get());
        com.shopee.app.ui.a.f.a((e) trackLogActivity, (com.shopee.app.tracking.f) b.a.c.a(this.f25634a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) trackLogActivity, (UserInfo) b.a.c.a(this.f25634a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) trackLogActivity, this.h.get());
        com.shopee.app.ui.a.f.a((e) trackLogActivity, this.f25635b.get());
        com.shopee.app.ui.a.f.a((e) trackLogActivity, (com.shopee.app.d.c.f) b.a.c.a(this.f25634a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) trackLogActivity, (com.shopee.app.tracking.a) b.a.c.a(this.f25634a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) trackLogActivity, this.j.get());
        com.shopee.app.ui.a.f.a((e) trackLogActivity, (al) b.a.c.a(this.f25634a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) trackLogActivity, (ActionRequiredCounter) b.a.c.a(this.f25634a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) trackLogActivity, (ActivityCounter) b.a.c.a(this.f25634a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) trackLogActivity, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) trackLogActivity, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) trackLogActivity, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) trackLogActivity, g());
        return trackLogActivity;
    }

    private j b(j jVar) {
        l.a(jVar, (b) b.a.c.a(this.f25634a.shopeeTrackLogger(), "Cannot return null from a non-@Nullable component method"));
        return jVar;
    }

    private d b(d dVar) {
        com.shopee.app.ui.a.f.a((e) dVar, (n) b.a.c.a(this.f25634a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, (bi) b.a.c.a(this.f25634a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, (com.shopee.app.application.a.b) b.a.c.a(this.f25634a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, this.f25639f.get());
        com.shopee.app.ui.a.f.a((e) dVar, (com.shopee.app.tracking.f) b.a.c.a(this.f25634a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, (UserInfo) b.a.c.a(this.f25634a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) dVar, this.f25635b.get());
        com.shopee.app.ui.a.f.a((e) dVar, (com.shopee.app.d.c.f) b.a.c.a(this.f25634a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, (com.shopee.app.tracking.a) b.a.c.a(this.f25634a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) dVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) dVar, (al) b.a.c.a(this.f25634a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, (ActionRequiredCounter) b.a.c.a(this.f25634a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, (ActivityCounter) b.a.c.a(this.f25634a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, g());
        return dVar;
    }

    /* renamed from: com.shopee.app.ui.tracklog.a$a  reason: collision with other inner class name */
    public static final class C0392a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f25641a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f25642b;

        private C0392a() {
        }

        public h a() {
            if (this.f25641a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f25642b != null) {
                return new a(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public C0392a a(com.shopee.app.a.b bVar) {
            this.f25641a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public C0392a a(UserComponent userComponent) {
            this.f25642b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f25643a;

        b(UserComponent userComponent) {
            this.f25643a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f25643a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f25644a;

        c(UserComponent userComponent) {
            this.f25644a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f25644a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
