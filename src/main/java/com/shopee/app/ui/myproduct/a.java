package com.shopee.app.ui.myproduct;

import android.app.Activity;
import com.shopee.app.a.d;
import com.shopee.app.a.m;
import com.shopee.app.a.o;
import com.shopee.app.a.s;
import com.shopee.app.a.t;
import com.shopee.app.a.w;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.au;
import com.shopee.app.d.c.av;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.ao;
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
import com.shopee.app.ui.myproduct.a.b;
import com.shopee.app.ui.myproduct.a.f;
import com.shopee.app.ui.myproduct.a.h;
import com.shopee.app.ui.myproduct.a.j;
import com.shopee.app.upload.UploadManager;
import com.shopee.app.upload.UploadStore;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f23371a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f23372b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f23373c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f23374d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f23375e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f23376f;

    /* renamed from: g  reason: collision with root package name */
    private b f23377g;
    private Provider<com.shopee.app.ui.common.a> h;
    private c i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private Provider<Activity> k;

    private a(C0367a aVar) {
        a(aVar);
    }

    public static C0367a c() {
        return new C0367a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f23371a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f23371a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f23371a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f23371a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i g() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f23371a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private au h() {
        return av.a((n) b.a.c.a(this.f23371a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new ah(), new ao());
    }

    private f i() {
        return new f((n) b.a.c.a(this.f23371a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (UserInfo) b.a.c.a(this.f23371a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), h());
    }

    private UploadManager j() {
        return new UploadManager((UploadStore) b.a.c.a(this.f23371a.uploadStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private void a(C0367a aVar) {
        this.f23372b = b.a.a.a(o.a(aVar.f23378a));
        this.f23371a = aVar.f23379b;
        this.f23373c = b.a.a.a(com.shopee.app.a.r.a(aVar.f23378a));
        this.f23374d = b.a.a.a(s.a(aVar.f23378a));
        this.f23375e = b.a.a.a(t.a(aVar.f23378a));
        this.f23376f = b.a.a.a(m.a(aVar.f23378a));
        this.f23377g = new b(aVar.f23379b);
        this.h = b.a.a.a(com.shopee.app.a.f.a(aVar.f23378a, this.f23377g));
        this.i = new c(aVar.f23379b);
        this.j = b.a.a.a(w.a(aVar.f23378a, this.i));
        this.k = b.a.a.a(d.a(aVar.f23378a));
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
        return this.f23372b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f23375e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(b bVar) {
        b(bVar);
    }

    public void a(h hVar) {
        b(hVar);
    }

    public void a(com.shopee.app.ui.myproduct.a.a aVar) {
        b(aVar);
    }

    public void a(e eVar) {
        b(eVar);
    }

    public void a(b bVar) {
        b(bVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f23372b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f23371a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f23373c.get());
        l.a(kVar, d());
        l.a(kVar, this.f23372b.get());
        l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f23371a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f23374d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f23372b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f23371a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f23371a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f23372b.get());
        return aVar;
    }

    private b b(b bVar) {
        com.shopee.app.ui.a.f.a((e) bVar, (n) b.a.c.a(this.f23371a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, (bi) b.a.c.a(this.f23371a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, (com.shopee.app.application.a.b) b.a.c.a(this.f23371a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, this.f23376f.get());
        com.shopee.app.ui.a.f.a((e) bVar, (com.shopee.app.tracking.f) b.a.c.a(this.f23371a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, (UserInfo) b.a.c.a(this.f23371a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) bVar, this.f23372b.get());
        com.shopee.app.ui.a.f.a((e) bVar, (com.shopee.app.d.c.f) b.a.c.a(this.f23371a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, (com.shopee.app.tracking.a) b.a.c.a(this.f23371a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) bVar, (al) b.a.c.a(this.f23371a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActionRequiredCounter) b.a.c.a(this.f23371a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActivityCounter) b.a.c.a(this.f23371a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, g());
        return bVar;
    }

    private h b(h hVar) {
        j.a(hVar, i());
        j.a(hVar, this.f23376f.get());
        j.a(hVar, (bi) b.a.c.a(this.f23371a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        j.a(hVar, this.f23372b.get());
        j.a(hVar, this.f23373c.get());
        j.a(hVar, j());
        j.a(hVar, (SettingConfigStore) b.a.c.a(this.f23371a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        return hVar;
    }

    private com.shopee.app.ui.myproduct.a.a b(com.shopee.app.ui.myproduct.a.a aVar) {
        com.shopee.app.ui.myproduct.a.e.a(aVar, (bi) b.a.c.a(this.f23371a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.myproduct.a.e.a(aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f23371a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        return aVar;
    }

    private e b(e eVar) {
        g.a(eVar, this.f23372b.get());
        g.a(eVar, (com.shopee.app.tracking.f) b.a.c.a(this.f23371a.tracker(), "Cannot return null from a non-@Nullable component method"));
        g.a(eVar, (UserInfo) b.a.c.a(this.f23371a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        g.a(eVar, j());
        g.a(eVar, (SettingConfigStore) b.a.c.a(this.f23371a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        g.a(eVar, this.k.get());
        g.a(eVar, (com.shopee.app.util.s) b.a.c.a(this.f23371a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return eVar;
    }

    private b b(b bVar) {
        com.shopee.app.ui.myproduct.a.e.a((com.shopee.app.ui.myproduct.a.a) bVar, (bi) b.a.c.a(this.f23371a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.myproduct.a.e.a((com.shopee.app.ui.myproduct.a.a) bVar, (com.shopee.app.tracking.a) b.a.c.a(this.f23371a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.myproduct.a.d.a(bVar, (com.shopee.app.util.s) b.a.c.a(this.f23371a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return bVar;
    }

    /* renamed from: com.shopee.app.ui.myproduct.a$a  reason: collision with other inner class name */
    public static final class C0367a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f23378a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f23379b;

        private C0367a() {
        }

        public c a() {
            if (this.f23378a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f23379b != null) {
                return new a(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public C0367a a(com.shopee.app.a.b bVar) {
            this.f23378a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public C0367a a(UserComponent userComponent) {
            this.f23379b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f23389a;

        b(UserComponent userComponent) {
            this.f23389a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f23389a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f23390a;

        c(UserComponent userComponent) {
            this.f23390a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f23390a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
