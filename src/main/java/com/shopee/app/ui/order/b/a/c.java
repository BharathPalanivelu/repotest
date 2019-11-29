package com.shopee.app.ui.order.b.a;

import android.content.Context;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.app.ui.a.m;
import com.shopee.app.ui.order.views.OrderHeaderView_;
import com.shopee.app.ui.order.views.d;
import com.shopee.id.R;
import java.util.Arrays;
import java.util.List;

public class c extends m<d, b> {

    public interface b {
        String a();

        String b();

        List<Long> c();

        com.shopee.app.d.b.a.a d();

        boolean e();
    }

    public int b() {
        return 0;
    }

    public d a(Context context, b bVar, int i) {
        return OrderHeaderView_.a(context);
    }

    public void a(d dVar, b bVar) {
        dVar.setAvatar(bVar.a());
        dVar.setIds(bVar.c());
        dVar.setUsername(bVar.b());
        dVar.setOfficialShop(bVar.e());
        Object a2 = a();
        boolean z = a2 instanceof CheckoutItem;
        Integer valueOf = Integer.valueOf(R.color.unread_bg);
        Integer valueOf2 = Integer.valueOf(R.color.white);
        if (z) {
            if (((CheckoutItem) a2).isUnread()) {
                dVar.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.unread_bg));
                dVar.setTag(R.id.button, valueOf);
            } else {
                dVar.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.white));
                dVar.setTag(R.id.button, valueOf2);
            }
        } else if (a2 instanceof OrderDetail) {
            if (((OrderDetail) a2).isUnread()) {
                dVar.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.unread_bg));
                dVar.setTag(R.id.button, valueOf);
            } else {
                dVar.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.white));
                dVar.setTag(R.id.button, valueOf2);
            }
        } else if (!(a2 instanceof ReturnItem)) {
            dVar.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.white));
            dVar.setTag(R.id.button, valueOf2);
        } else if (((ReturnItem) a2).isUnread()) {
            dVar.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.unread_bg));
            dVar.setTag(R.id.button, valueOf);
        } else {
            dVar.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.white));
            dVar.setTag(R.id.button, valueOf2);
        }
        dVar.setStatus(bVar.d().j());
    }

    public static class a implements b {

        /* renamed from: a  reason: collision with root package name */
        private OrderDetail f23487a;

        /* renamed from: b  reason: collision with root package name */
        private com.shopee.app.d.b.a.a f23488b;

        public a(OrderDetail orderDetail, com.shopee.app.d.b.a.a aVar) {
            this.f23487a = orderDetail;
            this.f23488b = aVar;
        }

        public String a() {
            return this.f23487a.getPortrait();
        }

        public String b() {
            return this.f23487a.getUserName();
        }

        public List<Long> c() {
            return Arrays.asList(new Long[]{Long.valueOf(this.f23487a.getOrderId()), Long.valueOf(this.f23487a.getCheckoutId())});
        }

        public com.shopee.app.d.b.a.a d() {
            return this.f23488b;
        }

        public boolean e() {
            return this.f23487a.isOfficialShop();
        }
    }

    /* renamed from: com.shopee.app.ui.order.b.a.c$c  reason: collision with other inner class name */
    public static class C0370c extends a {

        /* renamed from: a  reason: collision with root package name */
        private int f23489a;

        public C0370c(OrderDetail orderDetail, com.shopee.app.d.b.a.a aVar, int i) {
            super(orderDetail, aVar);
            this.f23489a = i;
        }

        public boolean e() {
            return this.f23489a == 0 && super.e();
        }
    }
}
