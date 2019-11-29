package com.shopee.app.ui.follow.following;

import android.text.TextUtils;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.f;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.tools.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.am;
import com.shopee.app.d.c.eb;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.be;
import com.shopee.app.h.m;
import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.bn;
import com.shopee.app.network.d.z;
import com.shopee.app.react.modules.app.data.k;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import com.shopee.app.web.protocol.notification.FollowUserUpdateMessage;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class x extends q<f> {
    private e A = new g() {
        public void onEvent(a aVar) {
            ((f) x.this.f19220b).d();
        }
    };
    private e B = new g() {
        public void onEvent(a aVar) {
            if (aVar.data != null && (aVar.data instanceof String)) {
                String str = (String) aVar.data;
                if (x.this.l.containsKey(str)) {
                    ((f) x.this.f19220b).a(((Integer) x.this.l.get(str)).intValue());
                    x.this.a(str);
                    ((f) x.this.f19220b).d();
                }
            }
        }
    };
    private e C = new g() {
        public void onEvent(a aVar) {
            ((f) x.this.f19220b).b();
            ((f) x.this.f19220b).a((List<t>) new ArrayList());
        }
    };
    private e D = new g() {
        public void onEvent(a aVar) {
            if (aVar.data != null && (aVar.data instanceof FollowUserUpdateMessage)) {
                FollowUserUpdateMessage followUserUpdateMessage = (FollowUserUpdateMessage) aVar.data;
                int shopId = followUserUpdateMessage.getShopId();
                if (followUserUpdateMessage.isFollowed()) {
                    ((f) x.this.f19220b).a(shopId);
                } else {
                    ((f) x.this.f19220b).b(shopId);
                }
            }
        }
    };
    private e E = new g() {
        public void onEvent(a aVar) {
            String str;
            ((f) x.this.f19220b).d();
            if (aVar == null || !(aVar.data instanceof Integer)) {
                ((f) x.this.f19220b).a(b.e(R.string.sp_unknown_error));
                return;
            }
            int intValue = ((Integer) aVar.data).intValue();
            if (intValue == -100) {
                str = b.e(R.string.sp_network_error);
            } else if (intValue == 3) {
                str = b.e(R.string.sp_err_follow_limit);
            } else if (intValue != 15) {
                str = b.e(R.string.sp_unknown_error);
            } else {
                str = b.e(R.string.sp_err_frequent);
            }
            ((f) x.this.f19220b).a(str);
        }
    };
    private e F = new g() {
        public void onEvent(a aVar) {
            int intValue = ((Integer) aVar.data).intValue();
            x.this.a(x.this.f21751g.a(intValue).a(), intValue);
        }
    };
    private e G = new g() {
        public void onEvent(a aVar) {
            ((f) x.this.f19220b).d();
            ((f) x.this.f19220b).f();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final int f21746a = 0;

    /* renamed from: c  reason: collision with root package name */
    private final int f21747c = 1;

    /* renamed from: d  reason: collision with root package name */
    private final n f21748d;

    /* renamed from: e  reason: collision with root package name */
    private final bi f21749e;

    /* renamed from: f  reason: collision with root package name */
    private m f21750f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final c f21751g;
    private final am h;
    private final i i;
    /* access modifiers changed from: private */
    public final m j;
    private final aa k;
    /* access modifiers changed from: private */
    public Map<String, Integer> l = new HashMap();
    /* access modifiers changed from: private */
    public String m;
    /* access modifiers changed from: private */
    public String n;
    /* access modifiers changed from: private */
    public String o;
    private final eb p;
    /* access modifiers changed from: private */
    public t q;
    private final k r;
    private final UserInfo s;
    private final be t;
    private e u = new f() {
        public void a(a aVar) {
            if (x.this.q != null) {
                ((f) x.this.f19220b).b(x.this.q);
            }
        }
    };
    private e v = new g() {
        public void onEvent(a aVar) {
            int i = ((com.shopee.app.network.c.d.a) aVar.data).f17892a;
            String str = ((com.shopee.app.network.c.d.a) aVar.data).f17893b;
            if (i == -100) {
                str = b.e(R.string.sp_network_error);
            } else if (i == 5) {
                com.shopee.app.f.a.a().f();
                str = b.e(R.string.sp_social_bind_error);
            } else if (TextUtils.isEmpty(str)) {
                str = b.e(R.string.sp_unknown_error);
            }
            ((f) x.this.f19220b).a(str);
        }
    };
    private e w = new g() {
        public void onEvent(a aVar) {
            o oVar = (o) aVar;
            if (x.this.m.equals(oVar.f21661a)) {
                ((f) x.this.f19220b).a(2, oVar.f21662b);
            } else if (x.this.n.equals(oVar.f21661a)) {
                ((f) x.this.f19220b).a(4, oVar.f21662b);
            } else if (x.this.o.equals(oVar.f21661a)) {
                ((f) x.this.f19220b).a(5, oVar.f21662b);
            }
            ((f) x.this.f19220b).d();
        }
    };
    private e x = new g() {
        public void onEvent(a aVar) {
            ((f) x.this.f19220b).d();
        }
    };
    private e y = new g() {
        public void onEvent(a aVar) {
            if (aVar.data != null && (aVar.data instanceof List)) {
                ((f) x.this.f19220b).a((List<t>) (List) aVar.data);
                ((f) x.this.f19220b).d();
            }
        }
    };
    private e z = new g() {
        public void onEvent(a aVar) {
            x.this.j.a((String) aVar.data);
        }
    };

    public void e() {
    }

    public x(n nVar, bi biVar, m mVar, c cVar, am amVar, i iVar, m mVar2, eb ebVar, aa aaVar, k kVar, be beVar, UserInfo userInfo) {
        this.f21748d = nVar;
        this.f21749e = biVar;
        this.f21750f = mVar;
        this.f21751g = cVar;
        this.h = amVar;
        this.i = iVar;
        this.j = mVar2;
        this.p = ebVar;
        this.k = aaVar;
        this.s = userInfo;
        this.r = kVar;
        this.t = beVar;
    }

    public void a() {
        this.f21748d.a("GET_REC_FRIEND_LIST", this.y);
        this.f21748d.a("BATCH_ITEM_LOAD_FAIL", this.A);
        this.f21748d.a("BATCH_ITEM_LOAD", this.z);
        this.f21748d.a("GET_REC_FRIEND_ERROR", this.A);
        this.f21748d.a("FOLLOW_SUCCESS", this.B);
        this.f21748d.a("FOLLOW_ERROR", this.E);
        this.f21748d.a("RESPONSE_LOCAL_CONTACT_SUCCESS", this.w);
        this.f21748d.a("RESPONSE_LOCAL_CONTACT_ERROR", this.x);
        this.f21748d.a("FOLLOW_USER_UPDATE", this.D);
        this.f21748d.a("RECOMMEND_BANNER_SAVED", this.C);
        this.f21748d.a("BIND_ACCOUNT_ERROR", this.v);
        this.f21748d.a("SET_USER_INFO", this.u);
        this.f21748d.a("SET_USER_INFO_ERROR", this.u);
    }

    public void c() {
        this.f21749e.a("FOLLOW_SHOP_REQUEST", this.F);
        this.f21749e.a("ACTIVITY_SEARCH_FRIENDS", this.G);
        i();
    }

    public void d() {
        this.f21749e.b("FOLLOW_SHOP_REQUEST", this.F);
        this.f21749e.b("ACTIVITY_SEARCH_FRIENDS", this.G);
    }

    public void b() {
        this.f21748d.b("GET_REC_FRIEND_LIST", this.y);
        this.f21748d.b("GET_REC_FRIEND_ERROR", this.A);
        this.f21748d.b("BATCH_ITEM_LOAD_FAIL", this.A);
        this.f21748d.b("FOLLOW_SUCCESS", this.B);
        this.f21748d.b("FOLLOW_ERROR", this.E);
        this.f21748d.b("BATCH_ITEM_LOAD", this.z);
        this.f21748d.b("RESPONSE_LOCAL_CONTACT_SUCCESS", this.w);
        this.f21748d.b("RESPONSE_LOCAL_CONTACT_ERROR", this.x);
        this.f21748d.b("FOLLOW_USER_UPDATE", this.D);
        this.f21748d.b("BIND_ACCOUNT_ERROR", this.v);
        this.f21748d.b("RECOMMEND_BANNER_SAVED", this.C);
        this.f21748d.b("SET_USER_INFO", this.u);
        this.f21748d.b("SET_USER_INFO_ERROR", this.u);
    }

    public void f() {
        z zVar = new z();
        zVar.a(2, 1, 0, this.k.d());
        this.m = zVar.i().a();
        o.a().a((az) zVar);
        z zVar2 = new z();
        zVar2.a(4, 1, 0, this.k.d());
        this.n = zVar2.i().a();
        o.a().a((az) zVar2);
        z zVar3 = new z();
        zVar3.a(5, 1, 0, this.k.d());
        this.p.a();
        this.o = zVar3.i().a();
        o.a().a((az) zVar3);
        ((f) this.f19220b).x_();
    }

    public void g() {
        if (!TextUtils.isEmpty(this.f21750f.e())) {
            this.h.a();
        }
    }

    public void h() {
        this.i.a();
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

    public void a(boolean z2, t tVar) {
        this.q = tVar;
        new bn().a(z2);
    }

    private void i() {
        if (!this.t.I() && this.r.b() && this.s.isLoggedIn()) {
            ((f) this.f19220b).g();
            this.t.b(true);
        }
    }
}
