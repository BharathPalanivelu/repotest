package com.airpay.paysdk.qrcode;

import android.app.Activity;
import android.content.Context;
import com.airpay.paysdk.base.bean.BPOrderInfo;
import com.airpay.paysdk.base.proto.PaymentOrderExecuteReplyProto;
import com.airpay.paysdk.core.a;
import com.airpay.paysdk.core.bean.PayResult;
import com.airpay.paysdk.pay.password.PaymentConfirmDetailInfo;
import com.airpay.paysdk.qrcode.ui.ConfirmPaymentActivity;
import com.airpay.paysdk.result.TransactionDetailsActivity;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private com.airpay.paysdk.common.net.a.a.b f4333a;

    /* renamed from: b  reason: collision with root package name */
    private com.airpay.paysdk.common.net.a.a.b f4334b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public com.airpay.paysdk.b f4335c;

    public static b a() {
        return new b();
    }

    public b a(final Activity activity, com.airpay.paysdk.b bVar) {
        if (!(bVar == null || activity == null)) {
            this.f4335c = bVar;
            this.f4333a = a.a().d(new com.airpay.paysdk.common.net.a.a.a<PaymentOrderExecuteReplyProto>() {
                public void a(int i, String str) {
                }

                public void a(PaymentOrderExecuteReplyProto paymentOrderExecuteReplyProto) {
                    b.this.f4335c.onResponse(PayResult.f4113a);
                    TransactionDetailsActivity.a(activity, new BPOrderInfo(paymentOrderExecuteReplyProto.order), b.this.f4335c);
                }
            });
            this.f4334b = a.a().e(new com.airpay.paysdk.common.net.a.a.a<PaymentConfirmDetailInfo>() {
                public void a(PaymentConfirmDetailInfo paymentConfirmDetailInfo) {
                    ConfirmPaymentActivity.a((Context) activity, paymentConfirmDetailInfo, b.this.f4335c);
                }

                public void a(int i, String str) {
                    com.airpay.paysdk.common.b.a.a("payment confirm, code: " + i + ", error: " + str, new Object[0]);
                }
            });
        }
        return this;
    }

    public void b() {
        com.airpay.paysdk.common.net.a.a.b bVar = this.f4334b;
        if (bVar != null) {
            bVar.a();
        }
        com.airpay.paysdk.common.net.a.a.b bVar2 = this.f4333a;
        if (bVar2 != null) {
            bVar2.a();
        }
        if (this.f4335c != null) {
            this.f4335c = null;
        }
    }
}
