package com.airpay.paysdk.pay.d;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import com.airpay.paysdk.base.bean.BPOrderInfo;
import com.airpay.paysdk.base.bean.BPOrderPrecheckData;
import com.airpay.paysdk.base.bean.CollectionQrShop;
import com.airpay.paysdk.base.bean.PayParams;
import com.airpay.paysdk.base.d.i;
import com.airpay.paysdk.base.proto.PaymentOrderPrecheckReplyProto;
import com.airpay.paysdk.c;
import com.airpay.paysdk.core.bean.ChannelListInfo;
import com.airpay.paysdk.core.bean.Param;
import com.airpay.paysdk.pay.b;
import com.airpay.paysdk.pay.password.ShoppingCartInfo;
import java.util.regex.Pattern;

public class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public com.airpay.paysdk.pay.a.a f4198a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public BPOrderInfo f4199b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Param f4200c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ShoppingCartInfo f4201d;

    public a(com.airpay.paysdk.pay.a.a aVar) {
        this.f4198a = aVar;
    }

    public void a(Bundle bundle) {
        this.f4200c = (Param) bundle.getParcelable("param");
        this.f4198a.e(b.b(com.airpay.paysdk.base.different.a.a().b()));
        b(bundle);
    }

    private void b(Bundle bundle) {
        this.f4201d = (ShoppingCartInfo) bundle.getParcelable("shopping_cart");
        ShoppingCartInfo shoppingCartInfo = this.f4201d;
        if (shoppingCartInfo == null || shoppingCartInfo.a() == null || this.f4201d.a().isEmpty()) {
            this.f4198a.a(c.i.com_garena_beepay_unknown_error);
            return;
        }
        this.f4199b = this.f4201d.a().get(0);
        CollectionQrShop a2 = b.a(this.f4199b.getExtraData());
        if (a2 == null) {
            this.f4198a.a(c.i.com_garena_beepay_unknown_error);
            return;
        }
        this.f4198a.b(a2.getOwnerName());
        this.f4198a.c(a2.getShopName());
        this.f4198a.d(a2.getShopIcon());
    }

    public void a(String str) {
        a(true);
        final long b2 = b(str);
        com.airpay.paysdk.core.a.a().a(this.f4201d, b2, (com.airpay.paysdk.common.net.a.a.a<PaymentOrderPrecheckReplyProto>) new com.airpay.paysdk.common.net.a.a.a<PaymentOrderPrecheckReplyProto>() {
            public void a(PaymentOrderPrecheckReplyProto paymentOrderPrecheckReplyProto) {
                BPOrderPrecheckData bPOrderPrecheckData;
                try {
                    bPOrderPrecheckData = new BPOrderPrecheckData(paymentOrderPrecheckReplyProto);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    bPOrderPrecheckData = null;
                }
                if (bPOrderPrecheckData == null) {
                    a(-1, "parse error");
                }
                a.this.a(a.this.f4199b.getPaymentChannelId(), b2, bPOrderPrecheckData);
            }

            public void a(int i, String str) {
                a.this.a(false);
                a.this.c(str);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(int i, long j, BPOrderPrecheckData bPOrderPrecheckData) {
        final int i2 = i;
        final long j2 = j;
        final BPOrderPrecheckData bPOrderPrecheckData2 = bPOrderPrecheckData;
        com.airpay.paysdk.core.a.a().a(i, (com.airpay.paysdk.common.net.a.a.a<ChannelListInfo>) new com.airpay.paysdk.common.net.a.a.a<ChannelListInfo>() {
            public void a(ChannelListInfo channelListInfo) {
                a.this.a(false);
                a.this.f4198a.a(new PayParams(i2, a.this.f4199b.getItemId(), i.a(j2), j2, String.valueOf(a.this.f4199b.getPaymentAccountId()), bPOrderPrecheckData2, (String) null, a.this.f4201d), a.this.f4200c);
            }

            public void a(int i, String str) {
                a.this.a(false);
                a.this.c(str);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        com.airpay.paysdk.pay.a.a aVar = this.f4198a;
        if (aVar != null) {
            if (z) {
                aVar.a(false);
            } else {
                aVar.c();
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        com.airpay.paysdk.pay.a.a aVar = this.f4198a;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    public long b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return i.a(b.a(com.airpay.paysdk.base.different.a.a().b(), str));
        } catch (NumberFormatException e2) {
            com.airpay.paysdk.common.b.a.a((Throwable) e2);
            return -1;
        }
    }

    public void a() {
        this.f4198a = null;
    }

    public void a(Editable editable) {
        b.a(com.airpay.paysdk.base.different.a.a().b(), editable);
    }

    public CharSequence a(CharSequence charSequence) {
        return b.a(com.airpay.paysdk.base.different.a.a().b(), charSequence);
    }

    public Pattern b() {
        return b.c(com.airpay.paysdk.base.different.a.a().b());
    }
}
