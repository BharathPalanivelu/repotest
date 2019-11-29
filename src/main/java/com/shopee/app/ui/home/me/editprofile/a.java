package com.shopee.app.ui.home.me.editprofile;

import android.app.Activity;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.a.f;
import com.shopee.app.a.m;
import com.shopee.app.a.o;
import com.shopee.app.a.s;
import com.shopee.app.a.t;
import com.shopee.app.a.w;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.bt;
import com.shopee.app.d.c.bu;
import com.shopee.app.d.c.dx;
import com.shopee.app.d.c.dy;
import com.shopee.app.d.c.eh;
import com.shopee.app.d.c.ei;
import com.shopee.app.d.c.ej;
import com.shopee.app.d.c.ek;
import com.shopee.app.d.c.g.d;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.bh;
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
import com.shopee.app.ui.shopassistant.e;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f22303a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f22304b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f22305c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f22306d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f22307e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f22308f;

    /* renamed from: g  reason: collision with root package name */
    private Provider<Activity> f22309g;
    private b h;
    private Provider<com.shopee.app.ui.common.a> i;
    private c j;
    private Provider<com.shopee.app.tracking.trackingv3.b> k;

    private a(C0324a aVar) {
        a(aVar);
    }

    public static C0324a c() {
        return new C0324a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f22303a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f22303a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f22303a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f22303a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i g() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f22303a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private d h() {
        return new d((n) b.a.c.a(this.f22303a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private bt i() {
        return bu.a((n) b.a.c.a(this.f22303a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bh(), (SettingConfigStore) b.a.c.a(this.f22303a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private eh j() {
        return ei.a((n) b.a.c.a(this.f22303a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (JobManager) b.a.c.a(this.f22303a.jobManager(), "Cannot return null from a non-@Nullable component method"), (SettingConfigStore) b.a.c.a(this.f22303a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private dx k() {
        return dy.a((n) b.a.c.a(this.f22303a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bh());
    }

    private ej l() {
        return ek.a((n) b.a.c.a(this.f22303a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (JobManager) b.a.c.a(this.f22303a.jobManager(), "Cannot return null from a non-@Nullable component method"), (SettingConfigStore) b.a.c.a(this.f22303a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private f m() {
        return new f((n) b.a.c.a(this.f22303a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f22303a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), (UserInfo) b.a.c.a(this.f22303a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), h(), i(), j(), k(), l());
    }

    private void a(C0324a aVar) {
        this.f22304b = b.a.a.a(o.a(aVar.f22310a));
        this.f22303a = aVar.f22311b;
        this.f22305c = b.a.a.a(com.shopee.app.a.r.a(aVar.f22310a));
        this.f22306d = b.a.a.a(s.a(aVar.f22310a));
        this.f22307e = b.a.a.a(t.a(aVar.f22310a));
        this.f22308f = b.a.a.a(m.a(aVar.f22310a));
        this.f22309g = b.a.a.a(com.shopee.app.a.d.a(aVar.f22310a));
        this.h = new b(aVar.f22311b);
        this.i = b.a.a.a(f.a(aVar.f22310a, this.h));
        this.j = new c(aVar.f22311b);
        this.k = b.a.a.a(w.a(aVar.f22310a, this.j));
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
        return this.f22304b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f22307e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.shopassistant.d dVar) {
        b(dVar);
    }

    public void a(com.shopee.app.ui.home.me.editprofile.bio.d dVar) {
        b(dVar);
    }

    public void a(c cVar) {
        b(cVar);
    }

    public void a(h hVar) {
        b(hVar);
    }

    public void a(com.shopee.app.ui.home.me.editprofile.bio.a aVar) {
        b(aVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f22304b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f22303a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f22305c.get());
        l.a(kVar, d());
        l.a(kVar, this.f22304b.get());
        l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f22303a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f22306d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f22304b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f22303a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f22303a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f22304b.get());
        return aVar;
    }

    private com.shopee.app.ui.shopassistant.d b(com.shopee.app.ui.shopassistant.d dVar) {
        e.a(dVar, (bi) b.a.c.a(this.f22303a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        return dVar;
    }

    private com.shopee.app.ui.home.me.editprofile.bio.d b(com.shopee.app.ui.home.me.editprofile.bio.d dVar) {
        com.shopee.app.ui.home.me.editprofile.bio.f.a(dVar, this.f22308f.get());
        com.shopee.app.ui.home.me.editprofile.bio.f.a(dVar, this.f22305c.get());
        com.shopee.app.ui.home.me.editprofile.bio.f.a(dVar, new com.shopee.app.ui.home.me.editprofile.bio.b());
        com.shopee.app.ui.home.me.editprofile.bio.f.a(dVar, this.f22309g.get());
        com.shopee.app.ui.home.me.editprofile.bio.f.a(dVar, this.f22304b.get());
        return dVar;
    }

    private c b(c cVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (n) b.a.c.a(this.f22303a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (bi) b.a.c.a(this.f22303a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.application.a.b) b.a.c.a(this.f22303a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.f22308f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.tracking.f) b.a.c.a(this.f22303a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (UserInfo) b.a.c.a(this.f22303a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.i.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.f22304b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.d.c.f) b.a.c.a(this.f22303a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.tracking.a) b.a.c.a(this.f22303a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.k.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (al) b.a.c.a(this.f22303a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, (ActionRequiredCounter) b.a.c.a(this.f22303a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, (ActivityCounter) b.a.c.a(this.f22303a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, this.i.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, g());
        return cVar;
    }

    private h b(h hVar) {
        j.a(hVar, this.f22308f.get());
        j.a(hVar, m());
        j.a(hVar, this.f22305c.get());
        j.a(hVar, this.f22304b.get());
        j.a(hVar, new com.shopee.app.h.m());
        j.a(hVar, this.f22309g.get());
        j.a(hVar, (UserInfo) b.a.c.a(this.f22303a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        j.a(hVar, (SettingConfigStore) b.a.c.a(this.f22303a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        return hVar;
    }

    private com.shopee.app.ui.home.me.editprofile.bio.a b(com.shopee.app.ui.home.me.editprofile.bio.a aVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (n) b.a.c.a(this.f22303a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (bi) b.a.c.a(this.f22303a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f22303a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f22308f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f22303a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (UserInfo) b.a.c.a(this.f22303a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.i.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f22304b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f22303a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f22303a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.k.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (al) b.a.c.a(this.f22303a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f22303a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f22303a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.i.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, g());
        return aVar;
    }

    /* renamed from: com.shopee.app.ui.home.me.editprofile.a$a  reason: collision with other inner class name */
    public static final class C0324a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f22310a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f22311b;

        private C0324a() {
        }

        public d a() {
            if (this.f22310a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f22311b != null) {
                return new a(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public C0324a a(com.shopee.app.a.b bVar) {
            this.f22310a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public C0324a a(UserComponent userComponent) {
            this.f22311b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f22312a;

        b(UserComponent userComponent) {
            this.f22312a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f22312a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f22313a;

        c(UserComponent userComponent) {
            this.f22313a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f22313a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
