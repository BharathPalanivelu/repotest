package com.shopee.app.ui.home.follow;

import com.garena.a.a.a.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.j.c;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.data.viewmodel.FollowCounter;
import com.shopee.app.react.modules.app.data.k;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.n;
import com.shopee.app.util.s;

public class a extends q<FollowTab> {

    /* renamed from: a  reason: collision with root package name */
    private final FollowCounter f22205a;

    /* renamed from: c  reason: collision with root package name */
    private final UserInfo f22206c;

    /* renamed from: d  reason: collision with root package name */
    private final n f22207d;

    /* renamed from: e  reason: collision with root package name */
    private final RegionConfig f22208e;

    /* renamed from: f  reason: collision with root package name */
    private final k f22209f;

    /* renamed from: g  reason: collision with root package name */
    private final c f22210g;
    private final s h;
    private boolean i = false;
    private i j = b.a(this);
    private e k = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            a.this.g();
        }
    };
    private e l = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((FollowTab) a.this.f19220b).h();
        }
    };

    public a(n nVar, FollowCounter followCounter, RegionConfig regionConfig, k kVar, c cVar, UserInfo userInfo, s sVar) {
        this.f22207d = nVar;
        this.f22205a = followCounter;
        this.f22206c = userInfo;
        this.f22208e = regionConfig;
        this.f22209f = kVar;
        this.f22210g = cVar;
        this.h = sVar;
    }

    public void a() {
        this.f22207d.a("NEW_LOGIN", this.k);
        this.f22207d.a("FOLLOW_USER_REFRESH", this.l);
        ((FollowTab) this.f19220b).a(this.f22205a.isDotShown());
    }

    public void e() {
        this.i = true;
        this.j.c();
    }

    public void f() {
        this.i = false;
        this.j.d();
    }

    public void b() {
        this.f22207d.b("NEW_LOGIN", this.k);
        this.f22207d.b("FOLLOW_USER_REFRESH", this.l);
    }

    public void a(int i2) {
        if (i2 == 1) {
            ((FollowTab) this.f19220b).g();
        }
    }

    public void g() {
        if (this.h.a("feed")) {
            ((FollowTab) this.f19220b).f();
        } else {
            ((FollowTab) this.f19220b).e();
        }
    }

    public void h() {
        this.f22205a.clearDot();
        ((FollowTab) this.f19220b).a(this.f22205a.isDotShown());
    }
}
