package com.airpay.paysdk.core.dispatch;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.airpay.paysdk.b;
import com.airpay.paysdk.base.d.o;
import com.airpay.paysdk.base.interfaces.IResultCallback;
import com.airpay.paysdk.base.ui.a.a;
import com.airpay.paysdk.core.bean.Param;
import com.airpay.paysdk.core.bean.PayResult;
import com.airpay.paysdk.core.dispatch.c;
import com.airpay.paysdk.pay.PaymentDetailsActivity;
import com.airpay.paysdk.pay.password.ShoppingCartInfo;

class c extends b {
    c() {
    }

    /* access modifiers changed from: package-private */
    public void a(final a aVar, final b bVar, final Param param) {
        if (TextUtils.isEmpty(param.b())) {
            bVar.onResponse(new PayResult(-1, 191, "require a qrCode value."));
        } else {
            com.airpay.paysdk.core.a.a().c(param.b(), new com.airpay.paysdk.common.net.a.a.a<ShoppingCartInfo>() {
                public void a(ShoppingCartInfo shoppingCartInfo) {
                    Intent intent = new Intent(aVar, PaymentDetailsActivity.class);
                    Bundle bundle = new Bundle();
                    o.a(bundle, bVar);
                    bundle.putParcelable("shopping_cart", shoppingCartInfo);
                    bundle.putParcelable("param", param);
                    intent.putExtras(bundle);
                    a aVar = aVar;
                    aVar.a(intent, 1002, (IResultCallback) new IResultCallback(aVar) {
                        private final /* synthetic */ a f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run(int i, Intent intent) {
                            c.AnonymousClass1.this.a(this.f$1, i, intent);
                        }
                    });
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void a(a aVar, int i, Intent intent) {
                    c.this.b(aVar);
                }

                public void a(int i, String str) {
                    bVar.onResponse(new PayResult(-1, i, str));
                    c.this.b(aVar);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void b(a aVar) {
        if (aVar != null && !aVar.isFinishing()) {
            aVar.finish();
            aVar.overridePendingTransition(0, 0);
            com.airpay.paysdk.a.a().d();
        }
    }
}
