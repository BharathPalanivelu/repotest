package com.shopee.app.ui.order.b.c;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.garena.android.uikit.a.c;
import com.shopee.app.d.b.a.d.l;
import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.app.ui.a.e;
import com.shopee.app.ui.a.i;
import com.shopee.app.ui.a.m;
import com.shopee.app.ui.common.p;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.order.b.a.b;
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
import com.shopee.protocol.action.ReturnSubListType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class f extends com.garena.android.uikit.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    ListView f23553a;

    /* renamed from: b  reason: collision with root package name */
    FrameLayout f23554b;

    /* renamed from: c  reason: collision with root package name */
    e f23555c;

    /* renamed from: d  reason: collision with root package name */
    bc f23556d;

    /* renamed from: e  reason: collision with root package name */
    ak f23557e;

    /* renamed from: f  reason: collision with root package name */
    r f23558f;

    /* renamed from: g  reason: collision with root package name */
    Activity f23559g;
    com.shopee.app.ui.common.a h;
    com.shopee.app.tracking.a i;
    private p j;
    private a k;
    private final boolean l;
    private final int m;

    public f(Context context, boolean z) {
        this(context, z, ReturnSubListType.RETURN_SUB_LIST_ALL.getValue());
    }

    public f(Context context, boolean z, int i2) {
        super(context);
        this.l = z;
        this.m = i2;
        ((d) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f23556d.a(this.f23555c);
        this.f23555c.a(this);
        this.k = new a(this.l);
        this.k.a(new ae(this.f23553a));
        this.f23553a.setAdapter(this.k);
        this.j = new p(this.f23553a);
        this.j.a((p.a) this.f23555c);
        this.f23555c.a(this.l, this.m);
        this.h.a(hashCode(), this.f23554b);
    }

    public void a(List<ReturnItem> list) {
        this.k.a(list);
        this.k.notifyDataSetChanged();
        this.f23553a.setEmptyView(findViewById(R.id.emptyView));
    }

    public void a() {
        this.f23555c.c();
    }

    public void b() {
        this.f23555c.e();
        this.f23555c.d();
    }

    public void c() {
        this.f23555c.e();
        this.f23556d.b(this.f23555c);
    }

    public void e() {
        this.j.c();
    }

    public void f() {
        this.j.b();
    }

    public void a(int i2) {
        com.shopee.app.ui.common.f fVar = (com.shopee.app.ui.common.f) ((c) this.f23559g.findViewById(R.id.tab_view)).findViewWithTag("ORDER_5");
        if (fVar != null) {
            fVar.setNumber(Integer.valueOf(i2));
        }
    }

    public void g() {
        this.f23558f.b();
    }

    /* access modifiers changed from: package-private */
    public void a(m mVar) {
        Object a2 = mVar.a();
        if (a2 != null && (a2 instanceof ReturnItem)) {
            ReturnItem returnItem = (ReturnItem) a2;
            if (returnItem.isSelling()) {
                this.i.a(getTrackingPageId(), returnItem);
            }
            this.f23557e.a(returnItem.isSelling(), returnItem.getReturnId());
        }
    }

    private String getTrackingPageId() {
        return ((e) this.f23559g).A();
    }

    private static class a extends i<ReturnItem> {
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final boolean f23560c;

        /* renamed from: d  reason: collision with root package name */
        private ae f23561d;

        /* access modifiers changed from: protected */
        public int a() {
            return 6;
        }

        public a(boolean z) {
            this.f23560c = z;
        }

        public void a(ae aeVar) {
            this.f23561d = aeVar;
        }

        /* access modifiers changed from: protected */
        public List<m> b(List<ReturnItem> list) {
            ArrayList arrayList = new ArrayList();
            for (final ReturnItem next : list) {
                final com.shopee.app.d.b.a.a a2 = l.a(next);
                arrayList.add(new com.shopee.app.ui.order.b.a.a());
                com.shopee.app.ui.order.b.a.c cVar = new com.shopee.app.ui.order.b.a.c();
                cVar.b(next);
                cVar.a(new c.b() {
                    public String a() {
                        return next.getUserAvatar();
                    }

                    public String b() {
                        return next.getUserName();
                    }

                    public List<Long> c() {
                        return Arrays.asList(new Long[]{Long.valueOf(next.getReturnId())});
                    }

                    public com.shopee.app.d.b.a.a d() {
                        return a2;
                    }

                    public boolean e() {
                        return !a.this.f23560c && next.isOfficialShop();
                    }
                });
                arrayList.add(cVar);
                com.shopee.app.ui.order.b.a.d dVar = new com.shopee.app.ui.order.b.a.d();
                dVar.b(next);
                dVar.a(new d.b() {
                    public boolean a() {
                        return false;
                    }

                    public String b() {
                        return next.getFirstItemName();
                    }

                    public String c() {
                        return next.getModelName();
                    }

                    public boolean d() {
                        return next.isAnOffer();
                    }

                    public boolean e() {
                        return next.hasPromotions();
                    }

                    public String f() {
                        return next.getFirstItemImage();
                    }

                    public long g() {
                        if (next.isFirstItemBundle()) {
                            return next.getOrderPrice();
                        }
                        if (next.isAnOffer()) {
                            return next.getOrderPrice();
                        }
                        if (next.hasPromotions()) {
                            return next.getItemPrice();
                        }
                        return next.getOrderPrice();
                    }

                    public long h() {
                        if (next.isFirstItemBundle()) {
                            return next.getOrderPrice();
                        }
                        if (next.isAnOffer()) {
                            return next.getItemPrice();
                        }
                        if (next.hasPromotions()) {
                            return next.getAmountBeforeDiscount();
                        }
                        return next.getItemPrice();
                    }

                    public int i() {
                        return next.getQuantity();
                    }

                    public List<Long> j() {
                        return Arrays.asList(new Long[]{Long.valueOf(next.getReturnId())});
                    }

                    public boolean k() {
                        return next.isFirstItemWholesale();
                    }

                    public int l() {
                        return next.getFreeReturnRefundPeriod();
                    }

                    public boolean m() {
                        return next.isFirstItemBundle();
                    }

                    public boolean n() {
                        return next.isGroupBuyItem();
                    }
                });
                arrayList.add(dVar);
                if (next.getDistinctItemCount() > 1) {
                    h hVar = new h();
                    hVar.b(next);
                    hVar.a(new h.a() {
                        public int a() {
                            return next.getDistinctItemCount() - 1;
                        }

                        public List<Long> b() {
                            return Arrays.asList(new Long[]{Long.valueOf(next.getReturnId())});
                        }
                    });
                    arrayList.add(hVar);
                }
                g gVar = new g();
                gVar.b(next);
                gVar.a(new g.a() {
                    public int d() {
                        return R.drawable.ic_guarantee;
                    }

                    public int e() {
                        return R.string.sp_label_order_return_refuned_total;
                    }

                    public int a() {
                        return next.getTotalReturnItemCount();
                    }

                    public long b() {
                        return next.getRefundAmount();
                    }

                    public List<Long> c() {
                        return Arrays.asList(new Long[]{Long.valueOf(next.getReturnId())});
                    }
                });
                arrayList.add(gVar);
                if (a2.c() || a2.p()) {
                    b bVar = new b();
                    bVar.b(next);
                    bVar.a(a2);
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i, view, viewGroup);
            view2.setOnTouchListener(this.f23561d);
            view2.setTag("TOUCH_" + i);
            return view2;
        }
    }
}
