package com.shopee.app.ui.order.rate;

import android.text.TextUtils;
import android.util.Pair;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.cl;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.data.viewmodel.OrderItemInfo;
import com.shopee.app.data.viewmodel.OrderRateItemInfo;
import com.shopee.app.h.o;
import com.shopee.app.h.r;
import com.shopee.app.network.d.az;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.n;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class d extends q<f> {

    /* renamed from: a  reason: collision with root package name */
    private final n f23773a;

    /* renamed from: c  reason: collision with root package name */
    private final cl f23774c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public long f23775d;

    /* renamed from: e  reason: collision with root package name */
    private int f23776e;

    /* renamed from: f  reason: collision with root package name */
    private int f23777f;

    /* renamed from: g  reason: collision with root package name */
    private final i f23778g;
    private e h = new g() {
        public void onEvent(a aVar) {
            if (aVar != null && aVar.data != null && (aVar.data instanceof OrderDetail)) {
                ArrayList arrayList = new ArrayList();
                for (OrderItemInfo orderItemInfo : ((OrderDetail) aVar.data).getItems()) {
                    OrderRateItemInfo orderRateItemInfo = new OrderRateItemInfo();
                    orderRateItemInfo.setOrderItemInfo(orderItemInfo);
                    arrayList.add(orderRateItemInfo);
                }
                ((f) d.this.f19220b).a((List<OrderRateItemInfo>) arrayList);
                ((f) d.this.f19220b).d();
            }
        }
    };
    private e i = new g() {
        public void onEvent(a aVar) {
            if (aVar != null) {
                d dVar = d.this;
                dVar.a(dVar.f23775d);
            }
        }
    };
    private e j = new g() {
        public void onEvent(a aVar) {
            r.a().b((int) R.string.sp_rate_product_success);
            ((f) d.this.f19220b).b();
        }
    };

    public d(n nVar, cl clVar) {
        this.f23773a = nVar;
        this.f23774c = clVar;
        this.f23778g = b.a(this);
    }

    public void a() {
        this.f23778g.a();
        this.f23773a.a("ORDER_DETAILS_SERVER_SAVED", this.i);
        this.f23773a.a("BATCH_ITEM_LOAD", this.i);
        this.f23773a.a("ITEM_SNAPSHOT_LOAD", this.i);
        this.f23773a.a("ORDER_UPDATE_SUCCESS", this.j);
        this.f23773a.a("ORDER_RATE_SUCCESS", this.j);
        this.f23773a.a("ORDER_DETAIL_LOCAL_LOAD", this.h);
    }

    public void d() {
        this.f23778g.d();
    }

    public void c() {
        this.f23778g.c();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        ((f) this.f19220b).c();
    }

    public void b() {
        this.f23778g.b();
        this.f23773a.b("ORDER_DETAILS_SERVER_SAVED", this.i);
        this.f23773a.b("BATCH_ITEM_LOAD", this.i);
        this.f23773a.b("ITEM_SNAPSHOT_LOAD", this.i);
        this.f23773a.b("ORDER_UPDATE_SUCCESS", this.j);
        this.f23773a.b("ORDER_RATE_SUCCESS", this.j);
        this.f23773a.b("ORDER_DETAIL_LOCAL_LOAD", this.h);
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else {
            int i2 = aVar.f17892a;
            if (i2 == -100) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
            } else if (i2 == 1) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_server_parameter_error);
            } else if (i2 != 2) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_server_error);
            } else {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_server_permission_error);
            }
        }
        ((f) this.f19220b).a(str);
    }

    public void a(long j2, int i2, int i3, int i4) {
        this.f23776e = i3;
        this.f23777f = i4;
        new com.shopee.app.network.d.h.i().a(j2, i2);
        a(j2);
    }

    /* access modifiers changed from: private */
    public void a(long j2) {
        this.f23775d = j2;
        this.f23774c.a(j2);
    }

    public void a(List<OrderRateItemInfo> list) {
        com.shopee.app.network.d.h.q qVar = new com.shopee.app.network.d.h.q();
        qVar.a(list);
        o.a().a(qVar.i().a(), (Pair<Integer, Integer>) new Pair(Integer.valueOf(this.f23776e), Integer.valueOf(this.f23777f)));
        o.a().a((az) qVar);
    }
}
