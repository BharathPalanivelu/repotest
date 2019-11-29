package com.shopee.app.ui.order.b.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.garena.android.uikit.a.c;
import com.shopee.app.d.b.a.d.h;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.ui.a.i;
import com.shopee.app.ui.a.m;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.order.b.a.c;
import com.shopee.app.ui.order.b.a.d;
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
    ListView f23519a;

    /* renamed from: b  reason: collision with root package name */
    FrameLayout f23520b;

    /* renamed from: c  reason: collision with root package name */
    a f23521c;

    /* renamed from: d  reason: collision with root package name */
    bc f23522d;

    /* renamed from: e  reason: collision with root package name */
    ak f23523e;

    /* renamed from: f  reason: collision with root package name */
    r f23524f;

    /* renamed from: g  reason: collision with root package name */
    Activity f23525g;
    com.shopee.app.ui.common.a h;
    private a i;

    public void e() {
    }

    public void f() {
    }

    public b(Context context, boolean z) {
        super(context);
        ((d) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f23522d.a(this.f23521c);
        this.f23521c.a(this);
        this.i = new a();
        this.i.a(new ae(this.f23519a));
        this.f23519a.setAdapter(this.i);
        this.f23519a.setOnItemClickListener(this);
        this.f23521c.e();
        this.h.a(hashCode(), this.f23520b);
    }

    public void a(List<CheckoutItem> list) {
        this.i.a(list);
        this.i.notifyDataSetChanged();
        this.f23519a.setEmptyView(findViewById(R.id.emptyView));
    }

    public void a() {
        this.f23521c.c();
    }

    public void b() {
        c cVar = (c) this.f23525g.findViewById(R.id.tab_view);
        this.f23521c.f();
        this.f23521c.d();
    }

    public void c() {
        c cVar = (c) this.f23525g.findViewById(R.id.tab_view);
        this.f23521c.f();
        this.f23522d.b(this.f23521c);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        try {
            Object a2 = this.i.getItem(i2).a();
            if (a2 != null) {
                if (a2 instanceof CheckoutItem) {
                    this.f23523e.a(((CheckoutItem) a2).getCheckoutId());
                }
                if (a2 instanceof OrderDetail) {
                    this.f23523e.a(((OrderDetail) a2).getCheckoutId(), ((OrderDetail) a2).getOrderId());
                }
            }
        } catch (Exception unused) {
        }
    }

    private static class a extends i<CheckoutItem> {

        /* renamed from: c  reason: collision with root package name */
        private ae f23526c;

        /* access modifiers changed from: protected */
        public int a() {
            return 6;
        }

        private a() {
        }

        public void a(ae aeVar) {
            this.f23526c = aeVar;
        }

        /* access modifiers changed from: protected */
        public List<m> b(List<CheckoutItem> list) {
            ArrayList arrayList = new ArrayList();
            for (final CheckoutItem next : list) {
                com.shopee.app.d.b.a.a a2 = h.a(next);
                arrayList.add(new com.shopee.app.ui.order.b.a.a());
                List<OrderDetail> orderDetailList = next.getOrderDetailList();
                int i = 0;
                for (OrderDetail next2 : orderDetailList) {
                    i += next2.getDistinctItemCount();
                    com.shopee.app.ui.order.b.a.c cVar = new com.shopee.app.ui.order.b.a.c();
                    cVar.b(next2);
                    cVar.a(new c.a(next2, a2));
                    arrayList.add(cVar);
                    com.shopee.app.ui.order.b.a.d dVar = new com.shopee.app.ui.order.b.a.d();
                    dVar.b(next2);
                    dVar.a(new d.a(next2));
                    arrayList.add(dVar);
                }
                if (i > orderDetailList.size()) {
                    final int size = i - orderDetailList.size();
                    com.shopee.app.ui.order.b.a.h hVar = new com.shopee.app.ui.order.b.a.h();
                    hVar.b(next);
                    hVar.a(new h.a() {
                        public int a() {
                            return size;
                        }

                        public List<Long> b() {
                            return Arrays.asList(new Long[]{Long.valueOf(next.getCheckoutId())});
                        }
                    });
                    arrayList.add(hVar);
                }
                g gVar = new g();
                gVar.b(next);
                gVar.a(new g.a() {
                    public int e() {
                        return R.string.sp_label_order_total;
                    }

                    public int a() {
                        return next.getTotalCount();
                    }

                    public long b() {
                        return next.getTotalPrice();
                    }

                    public List<Long> c() {
                        return Arrays.asList(new Long[]{Long.valueOf(next.getCheckoutId())});
                    }

                    public int d() {
                        if (next.isEscrow()) {
                            return R.drawable.ic_guarantee;
                        }
                        return 0;
                    }
                });
                arrayList.add(gVar);
                com.shopee.app.ui.order.b.a.b bVar = new com.shopee.app.ui.order.b.a.b();
                bVar.b(next);
                bVar.a(a2);
                arrayList.add(bVar);
            }
            return arrayList;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i, view, viewGroup);
            view2.setOnTouchListener(this.f23526c);
            view2.setTag("TOUCH_" + i);
            return view2;
        }
    }
}
