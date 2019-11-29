package com.shopee.app.ui.follow.following.recommend;

import android.text.TextUtils;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.shopee.app.d.c.am;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.t;
import com.shopee.app.database.orm.bean.DBContactInfo;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.z;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.common.p;
import com.shopee.app.ui.follow.following.c;
import com.shopee.app.ui.follow.following.i;
import com.shopee.app.ui.follow.following.l;
import com.shopee.app.ui.follow.following.o;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import com.shopee.app.web.protocol.notification.FollowUserUpdateMessage;
import com.shopee.id.R;
import java.util.HashMap;
import java.util.Map;

public class d extends q<j> implements p.a {

    /* renamed from: a  reason: collision with root package name */
    private final n f21678a;

    /* renamed from: c  reason: collision with root package name */
    private final bi f21679c;

    /* renamed from: d  reason: collision with root package name */
    private final aa f21680d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final com.shopee.app.ui.follow.following.n f21681e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final c f21682f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final g f21683g;
    private final am h;
    private final i i;
    /* access modifiers changed from: private */
    public final t j;
    /* access modifiers changed from: private */
    public String k;
    /* access modifiers changed from: private */
    public Map<String, Integer> l = new HashMap();
    private int m = 0;
    /* access modifiers changed from: private */
    public int n;
    /* access modifiers changed from: private */
    public int o;
    private final com.garena.android.appkit.b.i p;
    private e q = new g() {
        public void onEvent(a aVar) {
            if (aVar.data != null && (aVar.data instanceof FollowUserUpdateMessage)) {
                FollowUserUpdateMessage followUserUpdateMessage = (FollowUserUpdateMessage) aVar.data;
                int shopId = followUserUpdateMessage.getShopId();
                if (followUserUpdateMessage.isFollowed()) {
                    ((j) d.this.f19220b).b(shopId);
                } else {
                    ((j) d.this.f19220b).a(shopId);
                }
            }
        }
    };
    private e r = new g() {
        public void onEvent(a aVar) {
            ((j) d.this.f19220b).d();
            ((j) d.this.f19220b).g();
        }
    };
    private e s = new g() {
        public void onEvent(a aVar) {
            o oVar = (o) aVar;
            ((j) d.this.f19220b).c(oVar.f21662b);
            if (d.this.k != null && d.this.k.equals(oVar.f21661a)) {
                d.this.f21681e.a(d.this.o);
            }
        }
    };
    private e t = new g() {
        public void onEvent(a aVar) {
            d.this.e();
        }
    };
    private e u = new g() {
        public void onEvent(a aVar) {
            if (aVar.data != null && (aVar.data instanceof String)) {
                String str = (String) aVar.data;
                if (d.this.l.containsKey(str)) {
                    int intValue = ((Integer) d.this.l.get(str)).intValue();
                    ((j) d.this.f19220b).b(intValue);
                    DBContactInfo a2 = d.this.j.a(intValue);
                    a2.a(true);
                    d.this.j.a(a2);
                    d.this.a(str);
                    ((j) d.this.f19220b).d();
                }
            }
        }
    };
    private e v = new g() {
        public void onEvent(a aVar) {
            d.this.f21683g.a(d.this.o);
            ((j) d.this.f19220b).b();
            ((j) d.this.f19220b).d();
        }
    };
    private e w = new g() {
        public void onEvent(a aVar) {
            l lVar = (l) aVar;
            int i = 2;
            if (d.this.o == 2) {
                i = 3;
            }
            ((j) d.this.f19220b).a(lVar.f21654a);
            ((j) d.this.f19220b).d();
            if ((lVar.f21654a.size() - i) + 1 == d.this.n) {
                ((j) d.this.f19220b).f();
            } else {
                ((j) d.this.f19220b).g();
            }
        }
    };
    private e x = new g() {
        public void onEvent(a aVar) {
            int intValue = ((Integer) aVar.data).intValue();
            d.this.a(d.this.f21682f.a(intValue).a(), intValue);
        }
    };

    public d(n nVar, bi biVar, com.shopee.app.ui.follow.following.n nVar2, am amVar, i iVar, c cVar, g gVar, t tVar, aa aaVar) {
        this.f21678a = nVar;
        this.f21679c = biVar;
        this.f21681e = nVar2;
        this.f21682f = cVar;
        this.f21683g = gVar;
        this.i = iVar;
        this.h = amVar;
        this.j = tVar;
        this.f21680d = aaVar;
        this.p = b.a(this);
    }

    public void a(int i2) {
        this.o = i2;
        this.f21681e.a(i2);
        if (i2 == 2) {
            this.h.a();
        } else if (i2 == 4) {
            this.i.a();
        }
        e();
        ((j) this.f19220b).x_();
    }

    public void a() {
        this.p.a();
        this.f21678a.a("CONTACT_LOADED", this.w);
        this.f21678a.a("FOLLOW_SUCCESS", this.u);
        this.f21678a.a("FOLLOW_ALL_SUCCESS", this.v);
        this.f21678a.a("RESPONSE_LOCAL_CONTACT_SUCCESS", this.s);
        this.f21678a.a("RESPONSE_LOCAL_CONTACT_ERROR", this.r);
        this.f21678a.a("FOLLOW_USER_UPDATE", this.q);
        this.f21678a.a("RESPONSE_CONTACT_SUCCESS", this.t);
    }

    public void c() {
        this.f21679c.a("FOLLOW_SHOP_REQUEST_CONTACT", this.x);
    }

    public void d() {
        this.f21679c.b("FOLLOW_SHOP_REQUEST_CONTACT", this.x);
    }

    public void b() {
        this.p.b();
        this.f21678a.b("CONTACT_LOADED", this.w);
        this.f21678a.b("FOLLOW_SUCCESS", this.u);
        this.f21678a.b("FOLLOW_ALL_SUCCESS", this.v);
        this.f21678a.b("RESPONSE_LOCAL_CONTACT_SUCCESS", this.s);
        this.f21678a.b("RESPONSE_LOCAL_CONTACT_ERROR", this.r);
        this.f21678a.b("FOLLOW_USER_UPDATE", this.q);
        this.f21678a.b("RESPONSE_CONTACT_SUCCESS", this.t);
    }

    public void b(int i2) {
        new com.shopee.app.network.d.p().a(i2, this.f21680d.d());
        ((j) this.f19220b).x_();
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else if (aVar.f17892a != -100) {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
        } else {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
        }
        ((j) this.f19220b).a(str);
        ((j) this.f19220b).d();
        com.garena.android.appkit.d.a.a("follow all fail.....", new Object[0]);
    }

    /* access modifiers changed from: package-private */
    public void b(com.shopee.app.network.c.d.a aVar) {
        String str;
        ((j) this.f19220b).d();
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else {
            int i2 = aVar.f17892a;
            if (i2 == -100) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
            } else if (i2 == 3) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_err_follow_limit);
            } else if (i2 != 15) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
            } else {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_err_frequent);
            }
        }
        ((j) this.f19220b).a(str);
    }

    /* access modifiers changed from: private */
    public void a(String str, int i2) {
        if (str != null) {
            this.l.put(str, Integer.valueOf(i2));
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        if (str != null) {
            this.l.remove(str);
        }
    }

    public void c(int i2) {
        this.n = i2;
        this.m += 15;
        e();
    }

    /* access modifiers changed from: private */
    public void e() {
        z zVar = new z();
        com.shopee.app.h.o.a().a((az) zVar);
        this.k = zVar.i().a();
        zVar.a(this.o, 15, this.m, this.f21680d.d());
    }
}
