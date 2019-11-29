package com.shopee.app.ui.order.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.garena.android.uikit.a.c;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.ui.a.i;
import com.shopee.app.ui.a.m;
import com.shopee.app.ui.common.p;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.order.b.a.c;
import com.shopee.app.ui.order.b.a.d;
import com.shopee.app.ui.order.b.a.e;
import com.shopee.app.ui.order.b.a.f;
import com.shopee.app.ui.order.b.a.g;
import com.shopee.app.ui.order.b.a.h;
import com.shopee.app.ui.order.d;
import com.shopee.app.util.ae;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class b extends com.garena.android.uikit.a.a.a implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    ListView f23494a;

    /* renamed from: b  reason: collision with root package name */
    FrameLayout f23495b;

    /* renamed from: c  reason: collision with root package name */
    a f23496c;

    /* renamed from: d  reason: collision with root package name */
    bc f23497d;

    /* renamed from: e  reason: collision with root package name */
    ak f23498e;

    /* renamed from: f  reason: collision with root package name */
    r f23499f;

    /* renamed from: g  reason: collision with root package name */
    Activity f23500g;
    com.shopee.app.ui.common.a h;
    private a i;
    private p j;
    private final OrderKey k;

    public b(Context context, OrderKey orderKey) {
        super(context);
        this.k = orderKey;
        ((d) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f23497d.a(this.f23496c);
        this.f23496c.a(this);
        this.i = new a(this.k.uType);
        this.i.a(new ae(this.f23494a));
        this.f23494a.setAdapter(this.i);
        this.f23494a.setOnItemClickListener(this);
        this.j = new p(this.f23494a);
        this.j.a((p.a) this.f23496c);
        this.f23496c.a(this.k);
        this.h.a(hashCode(), this.f23495b);
    }

    public void setAscending(boolean z) {
        this.f23496c.a(z);
    }

    public void a(List<OrderDetail> list) {
        this.i.a(list);
        this.i.notifyDataSetChanged();
        if (list.isEmpty()) {
            this.f23494a.setEmptyView(findViewById(R.id.emptyView));
        }
    }

    public void e() {
        this.j.c();
    }

    public void f() {
        this.j.b();
    }

    public void g() {
        this.f23499f.a();
    }

    public void h() {
        this.f23499f.b();
    }

    public void a() {
        this.f23496c.c();
    }

    public void b() {
        c cVar = (c) this.f23500g.findViewById(R.id.tab_view);
        this.f23496c.e();
        this.f23496c.d();
    }

    public void c() {
        c cVar = (c) this.f23500g.findViewById(R.id.tab_view);
        this.f23496c.e();
        this.f23497d.b(this.f23496c);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        try {
            Object a2 = this.i.getItem(i2).a();
            if (a2 != null && (a2 instanceof OrderDetail)) {
                this.f23498e.a(((OrderDetail) a2).getOrderId(), ((OrderDetail) a2).getShopId(), e.f23572a);
            }
        } catch (Exception unused) {
        }
    }

    public void a(String str) {
        this.f23498e.j(str);
    }

    private static class a extends i<OrderDetail> {

        /* renamed from: c  reason: collision with root package name */
        private ae f23501c;

        /* renamed from: d  reason: collision with root package name */
        private int f23502d;

        /* access modifiers changed from: protected */
        public int a() {
            return 9;
        }

        private a(int i) {
            this.f23502d = i;
        }

        public void a(ae aeVar) {
            this.f23501c = aeVar;
        }

        /* access modifiers changed from: protected */
        public List<m> b(List<OrderDetail> list) {
            ArrayList arrayList = new ArrayList();
            for (final OrderDetail next : list) {
                com.shopee.app.d.b.a.a a2 = com.shopee.app.d.b.a.d.i.a(next);
                com.shopee.app.ui.order.b.a.a aVar = new com.shopee.app.ui.order.b.a.a();
                arrayList.add(aVar);
                com.shopee.app.ui.order.b.a.c cVar = new com.shopee.app.ui.order.b.a.c();
                cVar.b(next);
                cVar.a(new c.C0370c(next, a2, this.f23502d));
                arrayList.add(cVar);
                com.shopee.app.ui.order.b.a.d dVar = new com.shopee.app.ui.order.b.a.d();
                dVar.a(new d.a(next));
                dVar.b(next);
                arrayList.add(dVar);
                if (next.getDistinctItemCount() > 1) {
                    h hVar = new h();
                    hVar.b(next);
                    hVar.a(new h.a() {
                        public int a() {
                            return next.getDistinctItemCount() - 1;
                        }

                        public List<Long> b() {
                            return Arrays.asList(new Long[]{Long.valueOf(next.getOrderId()), Long.valueOf(next.getCheckoutId())});
                        }
                    });
                    arrayList.add(hVar);
                }
                g gVar = new g();
                gVar.b(next);
                gVar.a(new g.b(next, this.f23502d));
                arrayList.add(gVar);
                if (!TextUtils.isEmpty(next.getDeliveryStatusDes())) {
                    f fVar = new f();
                    fVar.b(next);
                    fVar.a(a2);
                    arrayList.add(fVar);
                }
                if (a2.c() || a2.p()) {
                    com.shopee.app.ui.order.b.a.b bVar = new com.shopee.app.ui.order.b.a.b();
                    bVar.b(next);
                    bVar.a(a2);
                    arrayList.add(bVar);
                }
                if (next.isSelling()) {
                    com.shopee.app.ui.order.m mVar = new com.shopee.app.ui.order.m();
                    mVar.b(next);
                    mVar.a(a2);
                    arrayList.add(mVar);
                }
                if (next.ratingIsNotDefaultOrShown()) {
                    e eVar = new e();
                    eVar.a(new e.a() {
                        public int a() {
                            return next.getShowRating();
                        }
                    });
                    eVar.b(next);
                    arrayList.add(aVar);
                    arrayList.add(eVar);
                }
            }
            return arrayList;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i, view, viewGroup);
            view2.setOnTouchListener(this.f23501c);
            view2.setTag("TOUCH_" + i);
            return view2;
        }
    }
}
