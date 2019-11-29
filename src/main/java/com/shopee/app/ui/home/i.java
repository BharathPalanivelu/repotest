package com.shopee.app.ui.home;

import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.shopee.app.application.a;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.cr;
import com.shopee.app.d.c.j.d;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.bd;
import com.shopee.app.data.store.theme.ActionBarTheme;
import com.shopee.app.data.store.theme.ThemeStore;
import com.shopee.app.data.viewmodel.FollowCounter;
import com.shopee.app.data.viewmodel.MeCounter;
import com.shopee.app.h.m;
import com.shopee.app.tracking.f;
import com.shopee.app.tracking.trackingv3.b;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.common.a.c;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import com.shopee.app.util.v;

public class i extends q<m> {

    /* renamed from: a  reason: collision with root package name */
    public static c.a f22227a;

    /* renamed from: c  reason: collision with root package name */
    private final n f22228c;

    /* renamed from: d  reason: collision with root package name */
    private final bi f22229d;

    /* renamed from: e  reason: collision with root package name */
    private final a f22230e;

    /* renamed from: f  reason: collision with root package name */
    private final m f22231f;

    /* renamed from: g  reason: collision with root package name */
    private final com.garena.android.appkit.b.i f22232g;
    /* access modifiers changed from: private */
    public final b.a<com.shopee.app.d.c.j.a> h;
    /* access modifiers changed from: private */
    public final b.a<d> i;
    private final com.shopee.app.d.c.d.a j;
    /* access modifiers changed from: private */
    public final f k;
    private final UserInfo l;
    /* access modifiers changed from: private */
    public final cr m;
    private final bd n;
    private final l o;
    private final b p;
    private final FollowCounter q;
    private final ThemeStore r;
    /* access modifiers changed from: private */
    public boolean s = false;
    private e t = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
        }
    };

    public i(n nVar, bi biVar, m mVar, a aVar, al alVar, UserInfo userInfo, f fVar, cr crVar, b.a<com.shopee.app.d.c.j.a> aVar2, b.a<d> aVar3, bd bdVar, l lVar, com.shopee.app.d.c.d.a aVar4, b bVar, FollowCounter followCounter, ThemeStore themeStore) {
        this.f22228c = nVar;
        this.f22229d = biVar;
        this.f22231f = mVar;
        this.f22230e = aVar;
        this.k = fVar;
        this.l = userInfo;
        this.m = crVar;
        this.n = bdVar;
        this.o = lVar;
        this.h = aVar2;
        this.i = aVar3;
        this.f22232g = com.garena.a.a.a.b.a(this);
        this.p = bVar;
        this.j = aVar4;
        this.q = followCounter;
        this.r = themeStore;
    }

    public void a() {
        this.f22232g.a();
        this.f22230e.a();
        p();
        n();
        o();
        a(this.r.getActionBarTheme());
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (this.o.d()) {
            ((m) this.f19220b).a((v.a) new v.a() {
                public void a() {
                    ((m) i.this.f19220b).p();
                    if (!i.this.s) {
                        i.this.m.a();
                    }
                }
            });
        } else {
            this.m.a();
        }
    }

    private void n() {
        GooglePlayServicesUtil.isGooglePlayServicesAvailable(ar.f());
    }

    private void o() {
        ((m) this.f19220b).postDelayed(new Runnable() {
            public void run() {
                ((com.shopee.app.d.c.j.a) i.this.h.get()).a();
                ((d) i.this.i.get()).a(((m) i.this.f19220b).getContext());
            }
        }, 5000);
    }

    public void c() {
        this.f22232g.c();
        this.f22229d.a("ICON_BAR_ICON_ON_LONG_CLICK", this.t);
        this.j.a();
        ((m) this.f19220b).a(a.TAB_FEED, this.q.isDotShown());
    }

    public void d() {
        this.f22232g.d();
        this.f22229d.b("ICON_BAR_ICON_ON_LONG_CLICK", this.t);
    }

    public void b() {
        this.f22232g.b();
    }

    private void p() {
        if (f22227a != null && this.l.isLoggedIn()) {
            ((m) this.f19220b).postDelayed(new Runnable() {
                public void run() {
                    if (i.f22227a != null) {
                        i.this.k.a(i.f22227a.f21081a, "IDR", i.f22227a.f21083c, i.f22227a.f21084d, i.f22227a.f21085e, "");
                        if (i.f22227a.f21086f <= 0) {
                            new com.shopee.app.network.d.g().a(i.f22227a.f21081a, i.f22227a.f21084d, i.f22227a.f21085e, i.f22227a.f21087g);
                        } else {
                            new com.shopee.app.network.d.g().a(i.f22227a.f21081a, i.f22227a.f21084d, i.f22227a.f21085e, i.f22227a.f21086f, i.f22227a.f21087g);
                        }
                        i.f22227a = null;
                        return;
                    }
                }
            }, 1000);
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        ((m) this.f19220b).l();
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.f22231f.a()) {
            ((m) this.f19220b).k();
        } else {
            ((m) this.f19220b).i();
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        if (this.f22231f.a()) {
            ((m) this.f19220b).g();
        } else {
            ((m) this.f19220b).h();
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        ((m) this.f19220b).j();
    }

    /* access modifiers changed from: package-private */
    public void j() {
        ((m) this.f19220b).setShowMeTabBadge(false);
        this.n.b(false);
    }

    /* access modifiers changed from: package-private */
    public void k() {
        this.n.a(false);
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.n.c(false);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        boolean z2 = ((m) this.f19220b).f22271d.getVisibility() == 0;
        if (z && z2) {
            return;
        }
        if (z || z2) {
            com.shopee.app.util.c.d.a(((m) this.f19220b).f22271d, z);
            this.p.a("me", "create_new_post");
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        ((m) this.f19220b).c(i2);
    }

    /* access modifiers changed from: package-private */
    public void a(MeCounter meCounter) {
        ((m) this.f19220b).a(meCounter);
    }

    /* access modifiers changed from: package-private */
    public void m() {
        ((m) this.f19220b).a(a.TAB_FEED, this.q.isDotShown());
    }

    /* access modifiers changed from: package-private */
    public void a(ActionBarTheme actionBarTheme) {
        ((m) this.f19220b).setActionBarTheme(actionBarTheme);
    }
}
