package com.shopee.app.ui.order.b.a;

import android.content.Context;
import com.shopee.app.application.ar;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.app.ui.a.m;
import com.shopee.app.ui.order.views.n;
import com.shopee.app.util.au;
import com.shopee.id.R;
import java.util.Arrays;
import java.util.List;

public class g extends m<com.shopee.app.ui.order.views.m, a> {

    /* renamed from: a  reason: collision with root package name */
    boolean f23491a = false;

    public interface a {
        int a();

        long b();

        List<Long> c();

        int d();

        int e();
    }

    public int b() {
        return 2;
    }

    public com.shopee.app.ui.order.views.m a(Context context, a aVar, int i) {
        return n.a(context);
    }

    public void d() {
        this.f23491a = true;
    }

    public void a(com.shopee.app.ui.order.views.m mVar, a aVar) {
        mVar.setCount(aVar.a());
        mVar.a(aVar.e(), au.b(aVar.b()));
        mVar.a(aVar.d());
        mVar.setIds(aVar.c());
        mVar.setNoPopup(this.f23491a);
        Object a2 = a();
        boolean z = a2 instanceof CheckoutItem;
        Integer valueOf = Integer.valueOf(R.color.unread_bg);
        Integer valueOf2 = Integer.valueOf(R.color.white);
        if (z) {
            CheckoutItem checkoutItem = (CheckoutItem) a2;
            mVar.setTotal(checkoutItem);
            if (checkoutItem.isUnread()) {
                mVar.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.unread_bg));
                mVar.setTag(R.id.button, valueOf);
                return;
            }
            mVar.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.white));
            mVar.setTag(R.id.button, valueOf2);
        } else if (a2 instanceof OrderDetail) {
            if (((OrderDetail) a2).isUnread()) {
                mVar.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.unread_bg));
                mVar.setTag(R.id.button, valueOf);
                return;
            }
            mVar.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.white));
            mVar.setTag(R.id.button, valueOf2);
        } else if (!(a2 instanceof ReturnItem)) {
            mVar.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.white));
            mVar.setTag(R.id.button, valueOf2);
        } else if (((ReturnItem) a2).isUnread()) {
            mVar.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.unread_bg));
            mVar.setTag(R.id.button, valueOf);
        } else {
            mVar.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.white));
            mVar.setTag(R.id.button, valueOf2);
        }
    }

    public static class b implements a {

        /* renamed from: a  reason: collision with root package name */
        private OrderDetail f23492a;

        /* renamed from: b  reason: collision with root package name */
        private int f23493b;

        public b(OrderDetail orderDetail, int i) {
            this.f23492a = orderDetail;
            this.f23493b = i;
        }

        public int a() {
            return this.f23492a.getTotalCount();
        }

        public long b() {
            return this.f23492a.getTotalPrice();
        }

        public List<Long> c() {
            return Arrays.asList(new Long[]{Long.valueOf(this.f23492a.getOrderId())});
        }

        public int d() {
            if (this.f23492a.isEscrow()) {
                return R.drawable.ic_guarantee;
            }
            return 0;
        }

        public int e() {
            if (this.f23493b == 1 && this.f23492a.getListType() == 9) {
                return R.string.sp_label_order_total;
            }
            boolean mySaleNewStringsEnabled = ar.f().e().settingConfigStore().getMySaleNewStringsEnabled();
            if (this.f23493b != 1 || !mySaleNewStringsEnabled) {
                return R.string.sp_label_order_total;
            }
            return R.string.sp_label_order_income_total;
        }
    }
}
