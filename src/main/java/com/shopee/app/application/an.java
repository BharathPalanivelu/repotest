package com.shopee.app.application;

import com.path.android.jobqueue.JobManager;
import com.shopee.app.data.store.RegionConfigStore;
import com.shopee.app.data.store.ServerConfigStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ShareConfigStore;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.ae;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.bd;
import com.shopee.app.data.store.theme.ThemeStore;
import com.shopee.app.data.store.v;
import com.shopee.app.data.store.z;
import com.shopee.app.h.p;
import com.shopee.app.react.modules.app.data.k;
import com.shopee.app.util.am;
import com.shopee.app.util.bh;
import com.shopee.app.util.bi;
import com.shopee.app.util.datapoint.a.b;
import com.shopee.app.util.datapoint.a.c;
import com.shopee.app.util.datapoint.a.d;
import com.shopee.app.util.n;
import com.shopee.app.util.q;
import com.shopee.navigator.e;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class an implements b {
    private Provider<com.shopee.app.util.datapoint.b.a> A;
    private Provider<e> B;
    private Provider<z> C;
    private Provider<com.shopee.app.util.datapoint.a.a> D;
    private Provider<d> E;
    private Provider<c> F;
    private Provider<b> G;
    private Provider<com.shopee.b.a> H;

    /* renamed from: a  reason: collision with root package name */
    private Provider<com.shopee.app.react.modules.app.data.c> f6910a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<n> f6911b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bi> f6912c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<al> f6913d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<v> f6914e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<ae> f6915f;

    /* renamed from: g  reason: collision with root package name */
    private Provider<ar> f6916g;
    private Provider<bh> h;
    private Provider<com.shopee.app.h.a.a> i;
    private Provider<ServerConfigStore> j;
    private Provider<p> k;
    private Provider<q> l;
    private Provider<ShareConfigStore> m;
    private Provider<SettingConfigStore> n;
    private Provider<RegionConfigStore> o;
    private Provider<aa> p;
    private Provider<bd> q;
    private Provider<am> r;
    private Provider<JobManager> s;
    private Provider<com.shopee.app.application.a.b> t;
    private Provider<com.shopee.app.data.store.am> u;
    private Provider<ThemeStore> v;
    private Provider<OkHttpClient> w;
    private Provider<com.garena.sticker.b> x;
    private Provider<f.n> y;
    private Provider<k> z;

    private an(a aVar) {
        a(aVar);
    }

    public static a a() {
        return new a();
    }

    private void a(a aVar) {
        this.f6910a = b.a.a.a(h.a(aVar.f6917a));
        this.f6911b = b.a.a.a(j.a(aVar.f6917a));
        this.f6912c = b.a.a.a(aj.a(aVar.f6917a));
        this.f6913d = b.a.a.a(v.a(aVar.f6917a));
        this.f6914e = b.a.a.a(i.a(aVar.f6917a));
        this.f6915f = b.a.a.a(s.a(aVar.f6917a));
        this.f6916g = b.a.a.a(g.a(aVar.f6917a));
        this.h = b.a.a.a(ah.a(aVar.f6917a));
        this.i = b.a.a.a(r.a(aVar.f6917a));
        this.j = b.a.a.a(ac.a(aVar.f6917a, this.h, this.i, this.f6913d));
        this.k = b.a.a.a(ad.a(aVar.f6917a, this.j, this.h));
        this.l = b.a.a.a(d.a(aVar.f6917a));
        this.m = b.a.a.a(af.a(aVar.f6917a));
        this.n = b.a.a.a(ae.a(aVar.f6917a));
        this.o = b.a.a.a(aa.a(aVar.f6917a));
        this.p = b.a.a.a(q.a(aVar.f6917a));
        this.q = b.a.a.a(ai.a(aVar.f6917a));
        this.r = b.a.a.a(y.a(aVar.f6917a));
        this.s = b.a.a.a(t.a(aVar.f6917a, this.r));
        this.t = b.a.a.a(f.a(aVar.f6917a));
        this.u = b.a.a.a(w.a(aVar.f6917a));
        this.v = b.a.a.a(ag.a(aVar.f6917a));
        this.w = b.a.a.a(e.a(aVar.f6917a, this.f6915f));
        this.x = b.a.a.a(ak.a(aVar.f6917a, this.p, this.f6913d, this.w));
        this.y = b.a.a.a(ab.a(aVar.f6917a, this.w));
        this.z = b.a.a.a(z.a(aVar.f6917a, this.f6911b));
        this.A = b.a.a.a(u.a(aVar.f6917a, this.y, this.p));
        this.B = b.a.a.a(x.a(aVar.f6917a));
        this.C = b.a.a.a(k.a(aVar.f6917a));
        this.D = b.a.a.a(m.a(aVar.f6917a, this.y, this.p, this.C));
        this.E = b.a.a.a(p.a(aVar.f6917a, this.y, this.p, this.C));
        this.F = b.a.a.a(o.a(aVar.f6917a, this.y, this.p, this.C));
        this.G = b.a.a.a(n.a(aVar.f6917a, this.y, this.p, this.C));
        this.H = b.a.a.a(l.a(aVar.f6917a));
    }

    public ar inject(ar arVar) {
        return a(arVar);
    }

    public n dataEventBus() {
        return this.f6911b.get();
    }

    public bi uiEventBus() {
        return this.f6912c.get();
    }

    public al loginStore() {
        return this.f6913d.get();
    }

    public v crossUserStatusStore() {
        return this.f6914e.get();
    }

    public ae forbiddenZoneStore() {
        return this.f6915f.get();
    }

    public ar app() {
        return this.f6916g.get();
    }

    public p serverManager() {
        return this.k.get();
    }

    public q fabricClient() {
        return this.l.get();
    }

    public ShareConfigStore shareConfigStore() {
        return this.m.get();
    }

    public SettingConfigStore settingConfigStore() {
        return this.n.get();
    }

    public RegionConfigStore regionConfigStore() {
        return this.o.get();
    }

    public aa deviceStore() {
        return this.p.get();
    }

    public bd toolTipStore() {
        return this.q.get();
    }

    public JobManager jobManager() {
        return this.s.get();
    }

    public am networkUtil() {
        return this.r.get();
    }

    public com.shopee.app.application.a.b appLifeCycleManager() {
        return this.t.get();
    }

    public com.shopee.app.data.store.am messageShortcutStore() {
        return this.u.get();
    }

    public ThemeStore themeStore() {
        return this.v.get();
    }

    public com.garena.sticker.b stickerManager() {
        return this.x.get();
    }

    public OkHttpClient okHttpClient() {
        return this.w.get();
    }

    public f.n retrofit() {
        return this.y.get();
    }

    public com.shopee.app.react.modules.app.data.c provideAppsFlyerStore() {
        return this.f6910a.get();
    }

    public k rnConfigProvider() {
        return this.z.get();
    }

    public com.shopee.app.util.datapoint.b.a locationSyncManager() {
        return this.A.get();
    }

    public e navigator2() {
        return this.B.get();
    }

    public com.shopee.app.util.datapoint.a.a deviceInfoHFSyncManager() {
        return this.D.get();
    }

    public d deviceInfoMFSyncManager() {
        return this.E.get();
    }

    public c deviceInfoLFSyncManager() {
        return this.F.get();
    }

    public b deviceInfoInstalledAppSyncManager() {
        return this.G.get();
    }

    public com.shopee.b.a deviceInfoCollector() {
        return this.H.get();
    }

    private ar a(ar arVar) {
        as.a(arVar, this.f6910a.get());
        return arVar;
    }

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public c f6917a;

        private a() {
        }

        public b a() {
            if (this.f6917a != null) {
                return new an(this);
            }
            throw new IllegalStateException(c.class.getCanonicalName() + " must be set");
        }

        public a a(c cVar) {
            this.f6917a = (c) b.a.c.a(cVar);
            return this;
        }
    }
}
