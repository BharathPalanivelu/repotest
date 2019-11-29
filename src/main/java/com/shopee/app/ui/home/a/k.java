package com.shopee.app.ui.home.a;

import android.text.TextUtils;
import android.util.Pair;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.f;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.eb;
import com.shopee.app.d.c.w;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.data.viewmodel.ActivityItemInfo;
import com.shopee.app.h.m;
import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.ba;
import com.shopee.app.network.d.r;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.common.ae;
import com.shopee.app.ui.follow.following.c;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import com.shopee.app.web.protocol.notification.FollowUserUpdateMessage;
import com.shopee.id.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class k extends q<m> implements ae.a {

    /* renamed from: a  reason: collision with root package name */
    private final n f22051a;

    /* renamed from: c  reason: collision with root package name */
    private final m f22052c;

    /* renamed from: d  reason: collision with root package name */
    private final eb f22053d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final c f22054e;

    /* renamed from: f  reason: collision with root package name */
    private final ActivityCounter f22055f;

    /* renamed from: g  reason: collision with root package name */
    private w f22056g;
    /* access modifiers changed from: private */
    public Map<String, Integer> h = new HashMap();
    /* access modifiers changed from: private */
    public List<ActivityItemInfo> i;
    private int j = 0;
    /* access modifiers changed from: private */
    public int k;
    private bi l;
    private final i m;
    /* access modifiers changed from: private */
    public int n;
    private boolean o = false;
    private e p = new g() {
        public void onEvent(a aVar) {
            ((m) k.this.f19220b).a((ActivityItemInfo) aVar.data);
        }
    };
    private e q = new g() {
        public void onEvent(a aVar) {
            int intValue = ((Integer) aVar.data).intValue();
            k.this.a(k.this.f22054e.a(intValue).a(), intValue);
        }
    };
    private e r = new g() {
        public void onEvent(a aVar) {
            k.this.e(((Integer) aVar.data).intValue());
        }
    };
    private g s = new f() {
        public void a(a aVar) {
            List unused = k.this.i = (List) aVar.data;
            ((m) k.this.f19220b).a((List<ActivityItemInfo>) k.this.i);
            if (k.this.i.size() + 1 == k.this.k) {
                ((m) k.this.f19220b).j();
            } else {
                ((m) k.this.f19220b).k();
            }
        }
    };
    private e t = new g() {
        public void onEvent(a aVar) {
            if (aVar.data != null && (aVar.data instanceof String)) {
                String str = (String) aVar.data;
                if (k.this.h.containsKey(str)) {
                    ((m) k.this.f19220b).a(((Integer) k.this.h.get(str)).intValue());
                    k.this.a(str);
                    ((m) k.this.f19220b).g();
                }
            }
        }
    };
    private g u = new f() {
        public void a(a aVar) {
            ((m) k.this.f19220b).m();
            ((m) k.this.f19220b).e();
            k.this.k();
        }
    };
    private e v = new g() {
        public void onEvent(a aVar) {
            k kVar = k.this;
            kVar.a(kVar.n);
        }
    };
    private e w = new g() {
        public void onEvent(a aVar) {
            ((m) k.this.f19220b).g();
            k kVar = k.this;
            kVar.a(kVar.n);
        }
    };
    private e x = new g() {
        public void onEvent(a aVar) {
            if (aVar.data != null && (aVar.data instanceof FollowUserUpdateMessage)) {
                FollowUserUpdateMessage followUserUpdateMessage = (FollowUserUpdateMessage) aVar.data;
                int shopId = followUserUpdateMessage.getShopId();
                if (followUserUpdateMessage.isFollowed()) {
                    ((m) k.this.f19220b).a(shopId);
                } else {
                    ((m) k.this.f19220b).b(shopId);
                }
            }
        }
    };

    /* access modifiers changed from: package-private */
    public void a(ActivityCounter activityCounter) {
    }

    public k(n nVar, bi biVar, w wVar, eb ebVar, ActivityCounter activityCounter, c cVar, m mVar) {
        this.f22051a = nVar;
        this.f22056g = wVar;
        this.f22052c = mVar;
        this.f22055f = activityCounter;
        this.f22053d = ebVar;
        this.f22054e = cVar;
        this.l = biVar;
        this.m = b.a(this);
    }

    public void a(int i2) {
        this.n = i2;
        if (this.f22052c.a()) {
            ((m) this.f19220b).i();
            k();
            j();
            ((m) this.f19220b).l();
            return;
        }
        ((m) this.f19220b).h();
    }

    private void j() {
        r rVar = new r();
        o.a().a((az) rVar);
        List<ActivityItemInfo> list = this.i;
        if (list == null || list.isEmpty()) {
            rVar.a(0, 15, this.n);
            return;
        }
        List<ActivityItemInfo> list2 = this.i;
        rVar.a(list2.get(list2.size() - 1).getActivityId(), 15, this.n);
    }

    public void e() {
        this.i = null;
    }

    /* access modifiers changed from: private */
    public void k() {
        if (f()) {
            this.f22056g.a(this.n);
        }
    }

    public boolean f() {
        return this.f22052c.a();
    }

    public void a() {
        this.m.a();
        this.f22051a.a("GET_USER_INFO_LOAD", (e) this.u);
        this.f22051a.a("BATCH_ITEM_LOAD", (e) this.u);
        this.f22051a.a("USER_BRIEF_LOAD", (e) this.u);
        this.f22051a.a("LOGIN_SUCCESS", this.v);
        this.f22051a.a("ACTIVITY_REMOVE_SUCCESS", this.w);
        this.f22051a.a("ACTION_BANNER_SAVED", (e) this.u);
        this.f22051a.a("FOLLOW_SUCCESS", this.t);
        this.f22051a.a("FOLLOW_USER_UPDATE", this.x);
    }

    public void g() {
        this.l.a("FOLLOW_SHOP_ACTIVITY_REQUEST", this.q);
        this.l.a("ON_ACTIVITY_ITEM_CLICKED", this.p);
        this.l.a("ON_DELETE_ITEM", this.r);
        this.o = true;
    }

    public void h() {
        this.l.b("FOLLOW_SHOP_ACTIVITY_REQUEST", this.q);
        this.l.b("ON_ACTIVITY_ITEM_CLICKED", this.p);
        this.l.b("ON_DELETE_ITEM", this.r);
    }

    /* access modifiers changed from: private */
    public void a(String str, int i2) {
        if (str != null) {
            this.h.put(str, Integer.valueOf(i2));
        }
    }

    public void b() {
        this.m.b();
        this.f22051a.b("GET_USER_INFO_LOAD", this.u);
        this.f22051a.b("BATCH_ITEM_LOAD", this.u);
        this.f22051a.b("USER_BRIEF_LOAD", this.u);
        this.f22051a.b("FOLLOW_SUCCESS", this.t);
        this.f22051a.b("FOLLOW_USER_UPDATE", this.x);
        this.f22051a.b("LOGIN_SUCCESS", this.v);
        this.f22051a.b("ACTIVITY_REMOVE_SUCCESS", this.w);
        this.f22051a.b("ACTION_BANNER_SAVED", this.u);
        if (this.o) {
            i();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Pair<Integer, List<ActivityItemInfo>> pair) {
        if (((Integer) pair.first).intValue() == this.n) {
            this.i = (List) pair.second;
            ((m) this.f19220b).a(this.i);
            if (this.i.size() + 1 == this.k) {
                ((m) this.f19220b).j();
            } else {
                ((m) this.f19220b).k();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        if (i2 == this.n) {
            ((m) this.f19220b).m();
            ((m) this.f19220b).e();
            k();
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        ((m) this.f19220b).g();
        a(this.n);
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
        ((m) this.f19220b).g();
        ((m) this.f19220b).a(str);
    }

    public void e(int i2) {
        ((m) this.f19220b).f();
        ba baVar = new ba();
        o.a().a((az) baVar);
        baVar.a(i2);
    }

    public void i() {
        this.f22055f.clear();
    }

    public void f(int i2) {
        this.f22055f.remove((long) i2);
        k();
    }

    public void d(int i2) {
        this.k = i2;
        this.j += 15;
        j();
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        if (str != null) {
            this.h.remove(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(com.shopee.app.network.c.d.a aVar) {
        String str;
        ((m) this.f19220b).g();
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
        ((m) this.f19220b).a(str);
    }
}
