package com.shopee.app.ui.customer.order;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.viewmodel.CustomerOrderInfo;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.ui.a.i;
import com.shopee.app.ui.a.m;
import com.shopee.app.ui.a.o;
import com.shopee.app.ui.common.p;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.order.b.a.c;
import com.shopee.app.ui.order.b.a.d;
import com.shopee.app.ui.order.b.a.g;
import com.shopee.app.ui.order.b.a.h;
import com.shopee.app.util.ae;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class c extends RelativeLayout implements o {

    /* renamed from: a  reason: collision with root package name */
    ImageView f21440a;

    /* renamed from: b  reason: collision with root package name */
    TextView f21441b;

    /* renamed from: c  reason: collision with root package name */
    TextView f21442c;

    /* renamed from: d  reason: collision with root package name */
    com.shopee.app.ui.common.o f21443d;

    /* renamed from: e  reason: collision with root package name */
    ListView f21444e;

    /* renamed from: f  reason: collision with root package name */
    a f21445f;

    /* renamed from: g  reason: collision with root package name */
    bc f21446g;
    bh h;
    r i;
    ak j;
    private final int k;
    private final String l;
    private final int m;
    private a n;
    private p o;

    public c(Context context, int i2, int i3, String str) {
        super(context);
        this.m = i3;
        this.k = i2;
        this.l = str;
        ((com.shopee.app.ui.customer.a) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f21446g.a(this.f21445f);
        this.f21445f.a(this);
        this.n = new a();
        this.f21444e.setAdapter(this.n);
        this.o = new p(this.f21444e);
        this.o.a((p.a) this.f21445f);
        this.n.a(new ae(this.f21444e));
        this.n.notifyDataSetChanged();
        this.f21445f.a(this.k, this.m);
    }

    public void a(CustomerOrderInfo customerOrderInfo) {
        z.a(getContext()).a(customerOrderInfo.getUserAvatar()).a(this.f21440a);
        this.f21441b.setText(customerOrderInfo.getUserName());
        if (!TextUtils.isEmpty(this.l)) {
            this.f21442c.setText(b.a(R.string.sp_recipient_info, this.l));
        } else {
            this.f21442c.setText(customerOrderInfo.getUserNickName());
        }
        List<OrderDetail> orderDetailList = customerOrderInfo.getOrderDetailList();
        if (customerOrderInfo.getTotalCount() == 1) {
            this.f21443d.setText(b.e(R.string.sp_1_order));
        } else {
            this.f21443d.setText(b.a(R.string.sp_n_orders, Integer.toString(customerOrderInfo.getTotalCount())));
        }
        this.n.a(orderDetailList);
        this.n.notifyDataSetChanged();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.j.b(this.m);
    }

    public void x_() {
        this.i.a();
    }

    public void d() {
        this.i.b();
    }

    /* access modifiers changed from: package-private */
    public void a(m mVar) {
        Object a2 = mVar.a();
        if (a2 != null && (a2 instanceof OrderDetail)) {
            OrderDetail orderDetail = (OrderDetail) a2;
            this.j.a(orderDetail.getOrderId(), orderDetail.getShopId());
        }
    }

    private static class a extends i<OrderDetail> {

        /* renamed from: c  reason: collision with root package name */
        private ae f21447c;

        /* access modifiers changed from: protected */
        public int a() {
            return 7;
        }

        private a() {
        }

        public void a(ae aeVar) {
            this.f21447c = aeVar;
        }

        /* access modifiers changed from: protected */
        public List<m> b(List<OrderDetail> list) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (final OrderDetail next : list) {
                com.shopee.app.d.b.a.a a2 = com.shopee.app.d.b.a.d.i.a(next);
                if (i > 0) {
                    arrayList.add(new com.shopee.app.ui.order.b.a.a());
                }
                i++;
                com.shopee.app.ui.order.b.a.c cVar = new com.shopee.app.ui.order.b.a.c();
                cVar.b(next);
                cVar.a(new c.a(next, a2));
                arrayList.add(cVar);
                d dVar = new d();
                dVar.a(new d.b() {
                    public boolean a() {
                        return next.isFirstItemReturn();
                    }

                    public String b() {
                        return next.getFirstItemName();
                    }

                    public String c() {
                        return next.getFirstItemVariantName();
                    }

                    public boolean d() {
                        return next.isAnOffer();
                    }

                    public boolean e() {
                        return next.firstItemHasPromotion();
                    }

                    public String f() {
                        return next.getFirstItemImage();
                    }

                    public long g() {
                        return next.getFirstOrderPrice();
                    }

                    public long h() {
                        if (next.isBundleItem()) {
                            return next.getFirstOrderPrice();
                        }
                        return next.getFirstItemPrice();
                    }

                    public int i() {
                        return next.getFirstBuyCount();
                    }

                    public List<Long> j() {
                        return Arrays.asList(new Long[]{Long.valueOf(next.getOrderId()), Long.valueOf(next.getCheckoutId())});
                    }

                    public boolean k() {
                        return next.isFirstItemWholesale();
                    }

                    public int l() {
                        return next.getFreeReturnRefundPeriod();
                    }

                    public boolean m() {
                        return next.isBundleItem();
                    }

                    public boolean n() {
                        return next.isGroupBuyItem();
                    }
                });
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
                gVar.a(new g.b(next, 0));
                arrayList.add(gVar);
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
            }
            return arrayList;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i, view, viewGroup);
            view2.setOnTouchListener(this.f21447c);
            view2.setTag("TOUCH_" + i);
            return view2;
        }
    }

    public void e() {
        this.o.c();
    }

    public void f() {
        this.o.b();
    }
}
