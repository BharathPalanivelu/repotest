package com.shopee.app.ui.customer;

import android.content.Context;
import com.shopee.app.a.f;
import com.shopee.app.a.h;
import com.shopee.app.a.o;
import com.shopee.app.a.s;
import com.shopee.app.a.t;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.ci;
import com.shopee.app.d.c.cj;
import com.shopee.app.d.c.cm;
import com.shopee.app.d.c.cn;
import com.shopee.app.d.c.l;
import com.shopee.app.d.c.m;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.ap;
import com.shopee.app.data.store.bg;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.store.w;
import com.shopee.app.data.store.x;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.ui.actionbar.k;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.ui.common.i;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.customer.list.d;
import com.shopee.app.ui.customer.list.e;
import com.shopee.app.ui.customer.list.g;
import com.shopee.app.ui.follow.search.j;
import com.shopee.app.ui.home.me.v3.OptionBox;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f21380a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f21381b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f21382c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f21383d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f21384e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f21385f;

    /* renamed from: g  reason: collision with root package name */
    private C0315b f21386g;
    private Provider<com.shopee.app.ui.common.a> h;
    private c i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private Provider<Context> k;

    private b(a aVar) {
        a(aVar);
    }

    public static a c() {
        return new a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f21380a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private ci e() {
        return cj.a((n) b.a.c.a(this.f21380a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ap) b.a.c.a(this.f21380a.myCustomerIdStore(), "Cannot return null from a non-@Nullable component method"), new bg());
    }

    private j f() {
        return new j((n) b.a.c.a(this.f21380a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private d g() {
        return new d((n) b.a.c.a(this.f21380a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f21380a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), e(), f());
    }

    private com.shopee.app.d.c.c.a h() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f21380a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f21380a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n i() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f21380a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i j() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f21380a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private cm k() {
        return cn.a((n) b.a.c.a(this.f21380a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.order.k l() {
        return new com.shopee.app.ui.order.k(this.k.get(), this.f21381b.get(), this.f21385f.get(), (bi) b.a.c.a(this.f21380a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), (n) b.a.c.a(this.f21380a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), k());
    }

    private l m() {
        return m.a((n) b.a.c.a(this.f21380a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bh(), new bg(), (x) b.a.c.a(this.f21380a.customerOrderCountStore(), "Cannot return null from a non-@Nullable component method"), (w) b.a.c.a(this.f21380a.customerOrderIdStore(), "Cannot return null from a non-@Nullable component method"), new ao(), new ah(), new com.shopee.app.data.store.c.c());
    }

    private com.shopee.app.ui.customer.order.a n() {
        return new com.shopee.app.ui.customer.order.a((n) b.a.c.a(this.f21380a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f21380a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), l(), k(), m());
    }

    private void a(a aVar) {
        this.f21381b = b.a.a.a(o.a(aVar.f21387a));
        this.f21380a = aVar.f21388b;
        this.f21382c = b.a.a.a(com.shopee.app.a.r.a(aVar.f21387a));
        this.f21383d = b.a.a.a(s.a(aVar.f21387a));
        this.f21384e = b.a.a.a(t.a(aVar.f21387a));
        this.f21385f = b.a.a.a(com.shopee.app.a.m.a(aVar.f21387a));
        this.f21386g = new C0315b(aVar.f21388b);
        this.h = b.a.a.a(f.a(aVar.f21387a, this.f21386g));
        this.i = new c(aVar.f21388b);
        this.j = b.a.a.a(com.shopee.app.a.w.a(aVar.f21387a, this.i));
        this.k = b.a.a.a(h.a(aVar.f21387a));
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
        return this.f21381b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f21384e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.order.views.m mVar) {
        b(mVar);
    }

    public void a(com.shopee.app.ui.dialog.k kVar) {
        b(kVar);
    }

    public void a(e eVar) {
        b(eVar);
    }

    public void a(com.shopee.app.ui.customer.list.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.customer.order.b bVar) {
        b(bVar);
    }

    public void a(com.shopee.app.ui.customer.order.c cVar) {
        b(cVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f21381b.get());
        return avatarView;
    }

    private k b(k kVar) {
        com.shopee.app.ui.actionbar.l.a(kVar, (bi) b.a.c.a(this.f21380a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbar.l.a(kVar, this.f21382c.get());
        com.shopee.app.ui.actionbar.l.a(kVar, d());
        com.shopee.app.ui.actionbar.l.a(kVar, this.f21381b.get());
        com.shopee.app.ui.actionbar.l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f21380a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f21383d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f21381b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f21380a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f21380a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f21381b.get());
        return aVar;
    }

    private com.shopee.app.ui.order.views.m b(com.shopee.app.ui.order.views.m mVar) {
        com.shopee.app.ui.order.views.o.a(mVar, this.f21381b.get());
        return mVar;
    }

    private com.shopee.app.ui.dialog.k b(com.shopee.app.ui.dialog.k kVar) {
        com.shopee.app.ui.dialog.m.a(kVar, (bi) b.a.c.a(this.f21380a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.dialog.m.a(kVar, this.f21381b.get());
        com.shopee.app.ui.dialog.m.a(kVar, (SettingConfigStore) b.a.c.a(this.f21380a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private e b(e eVar) {
        g.a(eVar, g());
        g.a(eVar, this.f21382c.get());
        g.a(eVar, this.f21385f.get());
        g.a(eVar, this.f21381b.get());
        g.a(eVar, com.shopee.app.ui.customer.list.h.b());
        return eVar;
    }

    private com.shopee.app.ui.customer.list.a b(com.shopee.app.ui.customer.list.a aVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (n) b.a.c.a(this.f21380a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (bi) b.a.c.a(this.f21380a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f21380a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f21385f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f21380a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (UserInfo) b.a.c.a(this.f21380a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f21381b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f21380a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f21380a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (al) b.a.c.a(this.f21380a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f21380a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f21380a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, h());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, i());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, j());
        return aVar;
    }

    private com.shopee.app.ui.customer.order.b b(com.shopee.app.ui.customer.order.b bVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (n) b.a.c.a(this.f21380a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (bi) b.a.c.a(this.f21380a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.application.a.b) b.a.c.a(this.f21380a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.f21385f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.tracking.f) b.a.c.a(this.f21380a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (UserInfo) b.a.c.a(this.f21380a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.f21381b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.d.c.f) b.a.c.a(this.f21380a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.tracking.a) b.a.c.a(this.f21380a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (al) b.a.c.a(this.f21380a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActionRequiredCounter) b.a.c.a(this.f21380a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActivityCounter) b.a.c.a(this.f21380a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, h());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, i());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, j());
        return bVar;
    }

    private com.shopee.app.ui.customer.order.c b(com.shopee.app.ui.customer.order.c cVar) {
        com.shopee.app.ui.customer.order.e.a(cVar, n());
        com.shopee.app.ui.customer.order.e.a(cVar, this.f21382c.get());
        com.shopee.app.ui.customer.order.e.a(cVar, new bh());
        com.shopee.app.ui.customer.order.e.a(cVar, this.f21385f.get());
        com.shopee.app.ui.customer.order.e.a(cVar, this.f21381b.get());
        return cVar;
    }

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f21387a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f21388b;

        private a() {
        }

        public a a() {
            if (this.f21387a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f21388b != null) {
                return new b(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public a a(com.shopee.app.a.b bVar) {
            this.f21387a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public a a(UserComponent userComponent) {
            this.f21388b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    /* renamed from: com.shopee.app.ui.customer.b$b  reason: collision with other inner class name */
    private static class C0315b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f21389a;

        C0315b(UserComponent userComponent) {
            this.f21389a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f21389a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f21390a;

        c(UserComponent userComponent) {
            this.f21390a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f21390a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
