package com.shopee.app.ui.shopassistant;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.bi;
import com.shopee.app.d.c.bp;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.n;
import java.util.Map;

public class f extends q<g> {

    /* renamed from: a  reason: collision with root package name */
    private final n f25445a;

    /* renamed from: c  reason: collision with root package name */
    private final bi f25446c;

    /* renamed from: d  reason: collision with root package name */
    private final UserInfo f25447d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final bp f25448e;

    /* renamed from: f  reason: collision with root package name */
    private e f25449f = new g() {
        public void onEvent(a aVar) {
            Pair pair = (Pair) aVar.data;
            if (((Integer) pair.first).intValue() == 1) {
                int i = 0;
                for (Map.Entry value : ((Map) pair.second).entrySet()) {
                    i += ((Integer) value.getValue()).intValue();
                }
                ((g) f.this.f19220b).a(i);
            }
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private e f25450g = new com.garena.android.appkit.b.f() {
        public void a(a aVar) {
            if (1 == ((Integer) ((Pair) aVar.data).first).intValue()) {
                f.this.e();
            }
        }
    };
    private e h = new g() {
        public void onEvent(a aVar) {
            ((g) f.this.f19220b).b(((Integer) aVar.data).intValue());
        }
    };
    private e i = new com.garena.android.appkit.b.f() {
        public void a(a aVar) {
            f.this.f25448e.e();
        }
    };

    public f(n nVar, UserInfo userInfo, bp bpVar, bi biVar) {
        this.f25445a = nVar;
        this.f25447d = userInfo;
        this.f25448e = bpVar;
        this.f25446c = biVar;
    }

    public void a() {
        this.f25445a.a("ORDER_BADGE_LOAD", this.f25449f);
        this.f25445a.a("ORDER_UPDATE_NOTIFICATION", this.f25450g);
        this.f25445a.a("GET_PRODUCT_COUNT", this.h);
        this.f25445a.a("SHOP_INFO_FETCHED", this.i);
    }

    public void b() {
        this.f25445a.b("ORDER_BADGE_LOAD", this.f25449f);
        this.f25445a.b("ORDER_UPDATE_NOTIFICATION", this.f25450g);
        this.f25445a.b("GET_PRODUCT_COUNT", this.h);
        this.f25445a.b("SHOP_INFO_FETCHED", this.i);
    }

    public void e() {
        this.f25446c.a(1);
    }

    public void f() {
        this.f25448e.e();
    }
}
