package com.shopee.app.ui.order.b.a;

import android.content.Context;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.app.ui.a.m;
import com.shopee.app.ui.order.views.f;
import com.shopee.app.ui.order.views.g;
import com.shopee.app.util.au;
import com.shopee.id.R;
import java.util.Arrays;
import java.util.List;

public class d extends m<f, b> {

    public interface b {
        boolean a();

        String b();

        String c();

        boolean d();

        boolean e();

        String f();

        long g();

        long h();

        int i();

        List<Long> j();

        boolean k();

        int l();

        boolean m();

        boolean n();
    }

    public int b() {
        return 1;
    }

    public f a(Context context, b bVar, int i) {
        return g.a(context);
    }

    public void a(f fVar, b bVar) {
        boolean z;
        fVar.setAsReturn(bVar.a());
        fVar.setAsBundle(bVar.m());
        fVar.setProductName(bVar.b());
        fVar.setProductImage(bVar.f());
        if (bVar.m()) {
            fVar.b(au.b(bVar.g()), au.b(bVar.h()));
        } else if (bVar.d()) {
            fVar.b(au.b(bVar.g()), au.b(bVar.h()));
        } else if (bVar.e() || bVar.n()) {
            fVar.a(au.b(bVar.g()), au.b(bVar.h()));
        } else if (bVar.k()) {
            fVar.setWholeSalePrice(au.b(bVar.g()));
        } else {
            fVar.b(au.b(bVar.g()), au.b(bVar.h()));
        }
        fVar.setQuantity(bVar.i());
        fVar.setVariation(bVar.c());
        fVar.setIds(bVar.j());
        fVar.setFreeReturnReturnPeriod(bVar.l());
        Object a2 = a();
        boolean m = bVar.m();
        if (a2 instanceof CheckoutItem) {
            z = ((CheckoutItem) a2).isUnread();
        } else if (a2 instanceof OrderDetail) {
            z = ((OrderDetail) a2).isUnread();
        } else {
            z = a2 instanceof ReturnItem ? ((ReturnItem) a2).isUnread() : false;
        }
        if (z) {
            b(fVar);
        } else if (m) {
            c(fVar);
        } else {
            a(fVar);
        }
    }

    private void a(f fVar) {
        fVar.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.white));
        fVar.setTag(R.id.button, Integer.valueOf(R.color.white));
    }

    private void b(f fVar) {
        fVar.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.unread_bg));
        fVar.setTag(R.id.button, Integer.valueOf(R.color.unread_bg));
    }

    private void c(f fVar) {
        fVar.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.black03));
        fVar.setTag(R.id.button, Integer.valueOf(R.color.black03));
    }

    public static class a implements b {

        /* renamed from: a  reason: collision with root package name */
        private OrderDetail f23490a;

        public a(OrderDetail orderDetail) {
            this.f23490a = orderDetail;
        }

        public boolean a() {
            return this.f23490a.isFirstItemReturn();
        }

        public String b() {
            return this.f23490a.getFirstItemName();
        }

        public String c() {
            return this.f23490a.getFirstItemVariantName();
        }

        public boolean d() {
            return this.f23490a.isAnOffer();
        }

        public boolean e() {
            return this.f23490a.firstItemHasPromotion();
        }

        public String f() {
            return this.f23490a.getFirstItemImage();
        }

        public long g() {
            if (this.f23490a.isBundleItem()) {
                return this.f23490a.getFirstOrderPrice();
            }
            if (this.f23490a.isFirstItemVariant()) {
                if (this.f23490a.isFirstItemVariantIsAnOffer()) {
                    return this.f23490a.getFirstItemVariantOrderPrice();
                }
                if (this.f23490a.firstItemVariantHasPromotion()) {
                    return this.f23490a.getFirstItemVariantPrice();
                }
                return this.f23490a.getFirstItemVariantOrderPrice();
            } else if (this.f23490a.isAnOffer()) {
                return this.f23490a.getFirstOrderPrice();
            } else {
                if (this.f23490a.firstItemHasPromotion()) {
                    return this.f23490a.getFirstItemPrice();
                }
                return this.f23490a.getFirstOrderPrice();
            }
        }

        public long h() {
            if (this.f23490a.isBundleItem()) {
                return this.f23490a.getFirstOrderPrice();
            }
            if (this.f23490a.isFirstItemVariant()) {
                if (this.f23490a.isFirstItemVariantIsAnOffer()) {
                    return this.f23490a.getFirstItemVariantPrice();
                }
                if (this.f23490a.firstItemVariantHasPromotion()) {
                    return this.f23490a.getFirstItemVariantPriceBeforeDiscount();
                }
                return this.f23490a.getFirstItemVariantPrice();
            } else if (this.f23490a.isAnOffer()) {
                return this.f23490a.getFirstItemPrice();
            } else {
                if (this.f23490a.firstItemHasPromotion()) {
                    return this.f23490a.getFirstItemPriceBeforeDiscount();
                }
                return this.f23490a.getFirstItemPrice();
            }
        }

        public int i() {
            return this.f23490a.getFirstBuyCount();
        }

        public List<Long> j() {
            return Arrays.asList(new Long[]{Long.valueOf(this.f23490a.getOrderId()), Long.valueOf(this.f23490a.getCheckoutId())});
        }

        public boolean k() {
            return this.f23490a.isFirstItemWholesale();
        }

        public int l() {
            return this.f23490a.getFreeReturnRefundPeriod();
        }

        public boolean m() {
            return this.f23490a.isBundleItem();
        }

        public boolean n() {
            return this.f23490a.isGroupBuyItem();
        }
    }
}
