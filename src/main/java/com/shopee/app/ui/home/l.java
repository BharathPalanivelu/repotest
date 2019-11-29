package com.shopee.app.ui.home;

import com.google.a.o;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.ui.home.q;
import com.shopee.app.util.az;
import com.shopee.app.util.bl;
import com.shopee.app.util.c;
import com.shopee.app.util.s;
import com.shopee.id.R;
import d.d.b.j;
import d.d.b.k;
import d.d.b.m;
import d.d.b.n;
import d.d.b.p;
import d.f;
import d.f.e;
import java.util.HashMap;
import java.util.Map;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ e[] f22261a = {p.a((m) new n(p.a(l.class), "bottomNavData", "getBottomNavData()[Lcom/shopee/app/ui/home/BottomNavigationData;")), p.a((m) new n(p.a(l.class), "tabUiMap", "getTabUiMap()Ljava/util/Map;"))};

    /* renamed from: b  reason: collision with root package name */
    private final boolean f22262b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f22263c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f22264d;

    /* renamed from: e  reason: collision with root package name */
    private final d.e f22265e;

    /* renamed from: f  reason: collision with root package name */
    private final d.e f22266f;

    /* renamed from: g  reason: collision with root package name */
    private final s f22267g;
    private final SettingConfigStore h;

    private final Map<String, q> f() {
        d.e eVar = this.f22266f;
        e eVar2 = f22261a[1];
        return (Map) eVar.a();
    }

    public final a[] b() {
        d.e eVar = this.f22265e;
        e eVar2 = f22261a[0];
        return (a[]) eVar.a();
    }

    public final boolean c() {
        return true;
    }

    public l(s sVar, SettingConfigStore settingConfigStore) {
        j.b(sVar, "featureToggleManager");
        j.b(settingConfigStore, "settingConfigStore");
        this.f22267g = sVar;
        this.h = settingConfigStore;
        boolean z = true;
        this.f22262b = this.f22267g.a("feed") && this.f22267g.a("feed_rn");
        this.f22263c = this.f22267g.a("live_streaming_3rd_tab");
        this.f22264d = (c.h() || !this.f22267g.a("live_streaming_rn_tab")) ? false : z;
        this.f22265e = f.a(new a(this));
        this.f22266f = f.a(new b(this));
    }

    public final boolean a() {
        return this.f22262b;
    }

    static final class a extends k implements d.d.a.a<a[]> {
        final /* synthetic */ l this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(l lVar) {
            super(0);
            this.this$0 = lVar;
        }

        /* renamed from: a */
        public final a[] invoke() {
            return new a[]{a.TAB_HOME_RN, a.TAB_FEED, this.this$0.g(), a.TAB_NOTIFICATION, a.TAB_ME};
        }
    }

    static final class b extends k implements d.d.a.a<HashMap<String, q>> {
        final /* synthetic */ l this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(l lVar) {
            super(0);
            this.this$0 = lVar;
        }

        /* renamed from: a */
        public final HashMap<String, q> invoke() {
            HashMap<String, q> hashMap = new HashMap<>();
            Map map = hashMap;
            String id = a.TAB_LIVE_STREAMING.getId();
            j.a((Object) id, "BottomNavigationData.TAB_LIVE_STREAMING.id");
            map.put(id, this.this$0.h());
            o oVar = new o();
            oVar.a("is_tab", (Boolean) true);
            String id2 = a.TAB_MALL_RN.getId();
            j.a((Object) id2, "BottomNavigationData.TAB_MALL_RN.id");
            String oVar2 = oVar.toString();
            j.a((Object) oVar2, "params.toString()");
            map.put(id2, new q.a("MALL_PAGE", oVar2));
            return hashMap;
        }
    }

    public final q a(int i) {
        q qVar = f().get(b()[i].getId());
        return qVar != null ? qVar : q.c.f22697a;
    }

    public final String b(int i) {
        a aVar = b()[i];
        if (aVar == a.TAB_LIVE_STREAMING) {
            String e2 = com.garena.android.appkit.tools.b.e(R.string.sp_home_tab_title_live_streaming);
            j.a((Object) e2, "BBAppResource.string(R.s…tab_title_live_streaming)");
            return e2;
        }
        String e3 = com.garena.android.appkit.tools.b.e(aVar.getTitleResId());
        j.a((Object) e3, "BBAppResource.string(navTab.titleResId)");
        return e3;
    }

    public final a c(int i) {
        return b()[i];
    }

    public final boolean d() {
        return this.h.showMallTabAnimationInAppStart();
    }

    public final int e() {
        return this.f22263c ? R.raw.live_tab_animation : R.raw.mall_tab_animation;
    }

    /* access modifiers changed from: private */
    public final a g() {
        if (this.f22263c) {
            return a.TAB_LIVE_STREAMING;
        }
        return a.TAB_MALL_RN;
    }

    /* access modifiers changed from: private */
    public final q h() {
        if (!this.f22264d) {
            return new q.b(bl.f7034a.a());
        }
        o oVar = new o();
        oVar.a("is_tab", (Boolean) true);
        String a2 = az.f26222a.a();
        String oVar2 = oVar.toString();
        j.a((Object) oVar2, "params.toString()");
        return new q.a(a2, oVar2);
    }
}
