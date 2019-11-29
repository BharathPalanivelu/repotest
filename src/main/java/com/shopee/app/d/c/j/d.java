package com.shopee.app.d.c.j;

import android.content.Context;
import cn.tongdun.android.shell.settings.Constants;
import com.firebase.jobdispatcher.e;
import com.firebase.jobdispatcher.g;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.be;
import com.shopee.app.util.datapoint.a.b;
import com.shopee.app.util.datapoint.a.c;
import com.shopee.app.util.n;
import com.shopee.app.util.q;
import com.shopee.app.util.r;
import com.shopee.app.util.t;
import com.shopee.shopeetracker.ShopeeTracker;
import com.shopee.shopeetracker.bimodel.TrackingMeta;

public class d extends com.shopee.app.d.c.a.a<a> {

    /* renamed from: d  reason: collision with root package name */
    private final UserInfo f17070d;

    /* renamed from: e  reason: collision with root package name */
    private final SettingConfigStore f17071e;

    /* renamed from: f  reason: collision with root package name */
    private final aa f17072f;

    /* renamed from: g  reason: collision with root package name */
    private final q f17073g;
    private final be h;
    private final com.shopee.app.util.datapoint.a.a i;
    private final c j;
    private final com.shopee.app.util.datapoint.a.d k;
    private final b l;

    public d(UserInfo userInfo, q qVar, SettingConfigStore settingConfigStore, n nVar, aa aaVar, be beVar, com.shopee.app.util.datapoint.a.a aVar, com.shopee.app.util.datapoint.a.d dVar, c cVar, b bVar) {
        super(nVar);
        this.f17070d = userInfo;
        this.f17071e = settingConfigStore;
        this.f17072f = aaVar;
        this.f17073g = qVar;
        this.h = beVar;
        this.i = aVar;
        this.k = dVar;
        this.j = cVar;
        this.l = bVar;
    }

    public void a(Context context) {
        b(new a(context));
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        com.shopee.app.network.http.b.a.c();
        f();
        e();
        d();
        c();
        com.shopee.app.util.datapoint.a aVar2 = new com.shopee.app.util.datapoint.a(new e(new g(aVar.f17076a)));
        if (!this.f17070d.isLoggedIn() || !this.f17071e.isDataPointOn(this.f17070d.getUserId())) {
            aVar2.b();
        } else {
            aVar2.a();
        }
        new com.shopee.app.react.sync.a(new e(new g(aVar.f17076a))).a();
        a();
    }

    private void a() {
        this.i.a(true);
        this.l.a(true);
        this.k.a(true);
        this.j.a(true);
    }

    private void c() {
        if (!this.h.J()) {
            this.f17073g.a(r.b());
            this.h.K();
        }
    }

    private void d() {
        final TrackingMeta trackingMeta = ShopeeTracker.getInstance().getTrackingMeta();
        String c2 = this.f17072f.c();
        if (trackingMeta.advertising_id == null || !trackingMeta.advertising_id.equals(c2)) {
            trackingMeta.advertising_id = c2;
            ShopeeTracker.getInstance().setTrackingMetaFunction(new d.d.a.a<TrackingMeta>() {
                /* renamed from: a */
                public TrackingMeta invoke() {
                    return trackingMeta;
                }
            });
        }
    }

    private void e() {
        try {
            if (!t.f26530a.a()) {
                com.google.firebase.perf.a.a().a(true);
            }
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    private void f() {
        com.shopee.app.util.p.a.f26481a.a(ar.f(), ar.f().e().loginStore().g());
    }

    public static class a extends a.C0253a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final Context f17076a;

        public a(Context context) {
            super("PostLaunchTasksInteractor", "use_case_52", Constants.DEFAULT_WAIT_TIME, false);
            this.f17076a = context;
        }
    }
}
