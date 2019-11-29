package com.shopee.app.ui.product.add.wholesale;

import android.content.Context;
import com.shopee.app.a.f;
import com.shopee.app.a.h;
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

public final class a implements e {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f24180a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f24181b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f24182c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f24183d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f24184e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f24185f;

    /* renamed from: g  reason: collision with root package name */
    private b f24186g;
    private Provider<com.shopee.app.ui.common.a> h;
    private c i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private Provider<Context> k;

    private a(C0373a aVar) {
        a(aVar);
    }

    public static C0373a c() {
        return new C0373a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f24180a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f24180a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f24180a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f24180a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i g() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f24180a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private k h() {
        return new k(this.k.get(), (SettingConfigStore) b.a.c.a(this.f24180a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private void a(C0373a aVar) {
        this.f24181b = b.a.a.a(o.a(aVar.f24187a));
        this.f24180a = aVar.f24188b;
        this.f24182c = b.a.a.a(com.shopee.app.a.r.a(aVar.f24187a));
        this.f24183d = b.a.a.a(s.a(aVar.f24187a));
        this.f24184e = b.a.a.a(t.a(aVar.f24187a));
        this.f24185f = b.a.a.a(m.a(aVar.f24187a));
        this.f24186g = new b(aVar.f24188b);
        this.h = b.a.a.a(f.a(aVar.f24187a, this.f24186g));
        this.i = new c(aVar.f24188b);
        this.j = b.a.a.a(w.a(aVar.f24187a, this.i));
        this.k = b.a.a.a(h.a(aVar.f24187a));
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
        return this.f24181b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f24184e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(c cVar) {
        b(cVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f24181b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f24180a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f24182c.get());
        l.a(kVar, d());
        l.a(kVar, this.f24181b.get());
        l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f24180a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f24183d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f24181b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f24180a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f24180a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f24181b.get());
        return aVar;
    }

    private c b(c cVar) {
        com.shopee.app.ui.a.f.a((e) cVar, (n) b.a.c.a(this.f24180a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, (bi) b.a.c.a(this.f24180a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, (com.shopee.app.application.a.b) b.a.c.a(this.f24180a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, this.f24185f.get());
        com.shopee.app.ui.a.f.a((e) cVar, (com.shopee.app.tracking.f) b.a.c.a(this.f24180a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, (UserInfo) b.a.c.a(this.f24180a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) cVar, this.f24181b.get());
        com.shopee.app.ui.a.f.a((e) cVar, (com.shopee.app.d.c.f) b.a.c.a(this.f24180a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, (com.shopee.app.tracking.a) b.a.c.a(this.f24180a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) cVar, (al) b.a.c.a(this.f24180a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, (ActionRequiredCounter) b.a.c.a(this.f24180a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, (ActivityCounter) b.a.c.a(this.f24180a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, g());
        d.a(cVar, h());
        return cVar;
    }

    /* renamed from: com.shopee.app.ui.product.add.wholesale.a$a  reason: collision with other inner class name */
    public static final class C0373a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f24187a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f24188b;

        private C0373a() {
        }

        public e a() {
            if (this.f24187a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f24188b != null) {
                return new a(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public C0373a a(com.shopee.app.a.b bVar) {
            this.f24187a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public C0373a a(UserComponent userComponent) {
            this.f24188b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f24189a;

        b(UserComponent userComponent) {
            this.f24189a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f24189a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f24190a;

        c(UserComponent userComponent) {
            this.f24190a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f24190a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
