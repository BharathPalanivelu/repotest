package com.shopee.app.d.b.a.d;

import android.view.View;
import com.shopee.app.d.b.a.a;
import com.shopee.app.d.b.a.a.f.b;
import com.shopee.app.d.b.a.a.f.c;
import com.shopee.app.d.b.a.a.f.d;
import com.shopee.app.d.b.a.a.f.e;
import com.shopee.app.d.b.a.a.f.f;
import com.shopee.app.d.b.a.a.f.g;
import com.shopee.app.d.b.a.a.f.i;
import com.shopee.app.d.b.a.a.f.j;
import com.shopee.app.d.b.a.a.f.k;
import com.shopee.app.d.b.a.a.f.l;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.app.ui.webview.WebPageActivity_;
import com.shopee.id.R;

public class h {
    public static com.shopee.app.d.b.a.a a(CheckoutItem checkoutItem) {
        if (checkoutItem.getPaymentType() == 2) {
            if (checkoutItem.getPaymentStatus() == 102) {
                if (checkoutItem.getStatus() == 3) {
                    return new c(checkoutItem);
                }
                if (checkoutItem.getStatus() == 1) {
                    return new b(checkoutItem);
                }
            }
            if (checkoutItem.getPaymentStatus() == 101 && (checkoutItem.getStatus() == 1 || checkoutItem.getStatus() == 3)) {
                return new com.shopee.app.d.b.a.a.f.a(checkoutItem);
            }
            if (checkoutItem.getStatus() == 1 && checkoutItem.getPaymentStatus() == 103) {
                return new e(checkoutItem);
            }
            if (checkoutItem.getStatus() == 1) {
                return new d(checkoutItem);
            }
        }
        if (checkoutItem.getStatus() == 1 && checkoutItem.getPaymentType() == 1) {
            return new g(checkoutItem);
        }
        if (checkoutItem.getStatus() == 1 && checkoutItem.getPaymentType() == 3) {
            return new j(checkoutItem);
        }
        if (checkoutItem.getPaymentType() == 6 && checkoutItem.logisticsNotStarted()) {
            return new f(checkoutItem);
        }
        if (checkoutItem.getPaymentType() == 14 || checkoutItem.getPaymentType() == 21 || checkoutItem.getPaymentType() == 15 || checkoutItem.getPaymentType() == 17 || checkoutItem.getPaymentType() == 23 || checkoutItem.getPaymentType() == 26) {
            return new i(checkoutItem);
        }
        if (checkoutItem.getStatus() == 1 && checkoutItem.getPaymentStatus() == 103 && checkoutItem.getPaymentType() == 29) {
            return new com.shopee.app.d.b.a.a.f.h(checkoutItem);
        }
        if (checkoutItem.getStatus() == 1 && checkoutItem.isPaymentUnsupported() && checkoutItem.getPaymentStatus() == 103) {
            return new l(checkoutItem);
        }
        if (checkoutItem.getStatus() != 1 || !checkoutItem.isPaymentUnsupported()) {
            return new a(checkoutItem);
        }
        return new k(checkoutItem);
    }

    private static class a extends com.shopee.app.d.b.a.a {
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final CheckoutItem f16354c;

        public a(CheckoutItem checkoutItem) {
            super(checkoutItem);
            this.f16354c = checkoutItem;
        }

        public long a() {
            return this.f16354c.getCheckoutId();
        }

        public a.C0251a d() {
            return new a.C0251a(a((int) R.string.sp_check_details), 0, new View.OnClickListener() {
                public void onClick(View view) {
                    WebPageActivity_.a(view.getContext()).b(com.shopee.app.util.i.f7040c + "buyer/payment/" + a.this.f16354c.getCheckoutId()).a();
                }
            });
        }
    }
}
