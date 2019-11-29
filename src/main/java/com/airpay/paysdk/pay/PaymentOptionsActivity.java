package com.airpay.paysdk.pay;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.airpay.paysdk.b;
import com.airpay.paysdk.base.bean.BPOrderInfo;
import com.airpay.paysdk.base.bean.BPOrderPrecheckData;
import com.airpay.paysdk.base.bean.BPPaymentOrderInfo;
import com.airpay.paysdk.base.bean.BPThirdPartyOrderDetail;
import com.airpay.paysdk.base.bean.OrderBuilder;
import com.airpay.paysdk.base.bean.PayParams;
import com.airpay.paysdk.base.d.o;
import com.airpay.paysdk.base.proto.OrderProto;
import com.airpay.paysdk.base.proto.PaymentOrderInitRequestProto;
import com.airpay.paysdk.base.proto.PaymentOrderPrecheckReplyProto;
import com.airpay.paysdk.base.proto.ShoppingCartProto;
import com.airpay.paysdk.base.ui.weidget.c;
import com.airpay.paysdk.c;
import com.airpay.paysdk.common.net.tcp.proto.PacketHeaderProto;
import com.airpay.paysdk.core.bean.ChannelInfo;
import com.airpay.paysdk.pay.PaymentOptionsActivity;
import com.airpay.paysdk.pay.password.ShoppingCartInfo;
import com.airpay.paysdk.pay.ui.PaymentProcessingActivity;
import com.airpay.paysdk.qrcode.a;
import java.util.ArrayList;
import java.util.List;

public class PaymentOptionsActivity extends a {
    private ShoppingCartInfo A;
    private b B;
    private PayParams n;
    private int o = -1;
    private String p;
    private int q = 0;
    private long r;
    private String s;
    private BPOrderPrecheckData t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private List<BPOrderInfo> z;

    /* access modifiers changed from: protected */
    public boolean s() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void o() {
        Bundle extras = getIntent().getExtras();
        this.B = o.a(getIntent().getExtras());
        if (extras != null) {
            this.n = (PayParams) extras.getParcelable("key_order_params");
        }
        PayParams payParams = this.n;
        if (payParams != null) {
            this.o = payParams.channelId;
            this.p = this.n.itemId;
            this.q = this.n.itemAmount;
            this.r = this.n.subtotal;
            this.s = this.n.accountId;
            this.t = this.n.precheckData;
            this.u = this.n.faceCurrency;
            this.v = this.n.faceValue;
            this.w = this.n.localJsonData;
            this.x = this.n.mPaymentChannelTxnId;
            this.y = this.n.paymentExtraData;
            this.A = this.n.cart;
            this.f4154f = a.a().a(Integer.valueOf(this.o));
            if (this.f4154f == null) {
                BPOrderInfo bPOrderInfo = this.n.cart.a().get(0);
                this.f4154f = new ChannelInfo(bPOrderInfo.getPaymentChannelId(), bPOrderInfo.getCurrency());
            }
            if (this.A != null) {
                this.z = new ArrayList();
                this.z.addAll(this.A.a());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        super.b();
        a(this.t);
    }

    /* access modifiers changed from: protected */
    public void a(BPOrderPrecheckData bPOrderPrecheckData) {
        super.a(bPOrderPrecheckData);
        a(v(), this.f4154f.c(), false);
    }

    /* access modifiers changed from: protected */
    public com.airpay.paysdk.common.net.tcp.b.b q() {
        if (this.f4154f.a() != 21001) {
            if (this.A != null) {
                com.airpay.paysdk.core.a.a().a(this.A, 0, (com.airpay.paysdk.common.net.a.a.a<PaymentOrderPrecheckReplyProto>) new com.airpay.paysdk.common.net.a.a.a<PaymentOrderPrecheckReplyProto>() {
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
                            return;
                        }
                        PaymentOptionsActivity.this.a(bPOrderPrecheckData);
                        PaymentOptionsActivity paymentOptionsActivity = PaymentOptionsActivity.this;
                        paymentOptionsActivity.m = true;
                        paymentOptionsActivity.k();
                    }

                    public void a(int i, String str) {
                        com.airpay.paysdk.pay.b.b.a(PaymentOptionsActivity.this.d(), str, c.i.com_garena_beepay_label_try_again, new c.a() {
                            public final void onCallBack(boolean z) {
                                PaymentOptionsActivity.AnonymousClass1.this.a(z);
                            }
                        });
                    }

                    /* access modifiers changed from: private */
                    public /* synthetic */ void a(boolean z) {
                        if (!z) {
                            PaymentOptionsActivity.this.q();
                        }
                    }
                });
            } else {
                com.airpay.paysdk.core.a.a().a(this.f4154f, this.s, this.q, this.p, this.r, this.y, new com.airpay.paysdk.common.net.a.a.a<PaymentOrderPrecheckReplyProto>() {
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
                            return;
                        }
                        PaymentOptionsActivity.this.a(bPOrderPrecheckData);
                        PaymentOptionsActivity paymentOptionsActivity = PaymentOptionsActivity.this;
                        paymentOptionsActivity.m = true;
                        paymentOptionsActivity.k();
                    }

                    public void a(int i, String str) {
                        com.airpay.paysdk.pay.b.b.a(PaymentOptionsActivity.this.d(), str, c.i.com_garena_beepay_label_try_again, new c.a() {
                            public final void onCallBack(boolean z) {
                                PaymentOptionsActivity.AnonymousClass2.this.a(z);
                            }
                        });
                    }

                    /* access modifiers changed from: private */
                    public /* synthetic */ void a(boolean z) {
                        if (!z) {
                            PaymentOptionsActivity.this.q();
                        }
                    }
                });
            }
        }
        return com.airpay.paysdk.common.net.tcp.b.b.a();
    }

    /* access modifiers changed from: protected */
    public int r() {
        return this.f4154f.a();
    }

    /* access modifiers changed from: protected */
    public void t() {
        boolean z2;
        PaymentOrderInitRequestProto.Builder builder;
        BPPaymentOrderInfo bPPaymentOrderInfo;
        Long l;
        List<BPOrderInfo> list = this.z;
        boolean z3 = true;
        boolean z4 = list != null && list.size() > 0;
        long j = 0;
        if (!this.h || !this.f4155g) {
            bPPaymentOrderInfo = new BPPaymentOrderInfo(this.k, this.p, this.q, this.f4154f, this.s);
            builder = com.airpay.paysdk.core.a.a().a(bPPaymentOrderInfo, this.f4155g ? this.i : 0);
            z2 = false;
        } else {
            bPPaymentOrderInfo = new BPPaymentOrderInfo(this.p, this.q, this.f4154f, this.s);
            bPPaymentOrderInfo.topupChannelId = 11000;
            if (this.j == null || this.j.getTopupAmountInfo() == null) {
                bPPaymentOrderInfo.paymentPayable = u();
                bPPaymentOrderInfo.currencyAmount = u();
                bPPaymentOrderInfo.topupPayable = u();
                bPPaymentOrderInfo.eventId = null;
            } else {
                bPPaymentOrderInfo.paymentPayable = this.j.getTopupAmountInfo().paymentPayable;
                bPPaymentOrderInfo.currencyAmount = this.j.getTopupAmountInfo().currencyAmount;
                bPPaymentOrderInfo.topupPayable = this.j.getTopupAmountInfo().topupPayment;
                if (this.j.getEvent() == null) {
                    l = null;
                } else {
                    l = Long.valueOf(this.j.getEvent().getEventId());
                }
                bPPaymentOrderInfo.eventId = l;
            }
            bPPaymentOrderInfo.bankAccountId = null;
            builder = com.airpay.paysdk.core.a.a().a(bPPaymentOrderInfo, this.i);
            z2 = true;
        }
        String str = this.y;
        builder.extra_data(str);
        String str2 = this.x;
        if (str2 != null) {
            builder.payment_channel_txn_id(str2);
        }
        if (z4) {
            ArrayList arrayList = new ArrayList();
            if (this.z.size() == 1) {
                OrderProto.Builder newBuilder = this.z.get(0).getOriginalData().newBuilder();
                if (TextUtils.isEmpty(str)) {
                    str = newBuilder.extra_data;
                }
                OrderBuilder orderBuilder = new OrderBuilder(newBuilder);
                orderBuilder.buildOrder(bPPaymentOrderInfo, this.x, str);
                arrayList.add(orderBuilder.build());
            } else {
                for (BPOrderInfo originalData : this.z) {
                    arrayList.add(originalData.getOriginalData());
                }
            }
            OrderBuilder orderBuilder2 = new OrderBuilder(new OrderProto.Builder());
            if (this.f4155g) {
                j = this.i;
            }
            orderBuilder2.addTopUpInfo(bPPaymentOrderInfo, j);
            arrayList.add(orderBuilder2.build());
            ShoppingCartProto build = this.A.b().newBuilder().orders(arrayList).build();
            PacketHeaderProto packetHeaderProto = builder.header;
            builder = new PaymentOrderInitRequestProto.Builder();
            builder.header(packetHeaderProto);
            builder.shopping_cart(build);
        }
        if (!z2 && !this.k.getBankAccountInfo().f()) {
            z3 = false;
        }
        Bundle bundle = new Bundle();
        o.a(bundle, this.B);
        PaymentProcessingActivity.a(builder.build()).a(z3).a(this.w).a(n()).a((Activity) this, bundle);
    }

    /* access modifiers changed from: protected */
    public long u() {
        return this.r;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.airpay.paysdk.base.bean.BPProductDetail p() {
        /*
            r15 = this;
            com.airpay.paysdk.core.bean.ChannelInfo r0 = r15.f4154f
            java.lang.String r1 = com.airpay.paysdk.pay.b.a()
            java.lang.String r0 = r0.b(r1)
            com.airpay.paysdk.core.bean.ChannelInfo r1 = r15.f4154f
            java.lang.String r1 = r1.i()
            com.airpay.paysdk.core.bean.ChannelInfo r2 = r15.f4154f
            int r2 = r2.g()
            com.airpay.paysdk.core.bean.ChannelInfo r3 = r15.f4154f
            int r3 = r3.b()
            r4 = 10008(0x2718, float:1.4024E-41)
            java.lang.String r5 = " "
            r6 = 10004(0x2714, float:1.4019E-41)
            r7 = 10003(0x2713, float:1.4017E-41)
            if (r3 == r7) goto L_0x00bb
            com.airpay.paysdk.core.bean.ChannelInfo r3 = r15.f4154f
            int r3 = r3.b()
            if (r3 == r4) goto L_0x00bb
            com.airpay.paysdk.core.bean.ChannelInfo r3 = r15.f4154f
            int r3 = r3.b()
            r7 = 10015(0x271f, float:1.4034E-41)
            if (r3 == r7) goto L_0x00bb
            com.airpay.paysdk.core.bean.ChannelInfo r3 = r15.f4154f
            int r3 = r3.b()
            r7 = 10018(0x2722, float:1.4038E-41)
            if (r3 == r7) goto L_0x00bb
            com.airpay.paysdk.core.bean.ChannelInfo r3 = r15.f4154f
            int r3 = r3.b()
            r7 = 10006(0x2716, float:1.4021E-41)
            if (r3 == r7) goto L_0x00bb
            com.airpay.paysdk.core.bean.ChannelInfo r3 = r15.f4154f
            int r3 = r3.b()
            r7 = 10005(0x2715, float:1.402E-41)
            if (r3 == r7) goto L_0x00bb
            com.airpay.paysdk.core.bean.ChannelInfo r3 = r15.f4154f
            int r3 = r3.b()
            if (r3 == r6) goto L_0x00bb
            com.airpay.paysdk.core.bean.ChannelInfo r3 = r15.f4154f
            int r3 = r3.b()
            r7 = 10020(0x2724, float:1.4041E-41)
            if (r3 != r7) goto L_0x0069
            goto L_0x00bb
        L_0x0069:
            com.airpay.paysdk.core.bean.ChannelInfo r3 = r15.f4154f
            int r3 = r3.a()
            r4 = 20041(0x4e49, float:2.8083E-41)
            if (r3 != r4) goto L_0x0074
            goto L_0x0078
        L_0x0074:
            r4 = 21001(0x5209, float:2.9429E-41)
            if (r3 != r4) goto L_0x007c
        L_0x0078:
            java.lang.String r3 = ""
            goto L_0x0100
        L_0x007c:
            com.airpay.paysdk.core.bean.ChannelInfo r4 = r15.f4154f
            int r4 = r4.b()
            r7 = 11000(0x2af8, float:1.5414E-41)
            r8 = 0
            r9 = 1
            if (r4 <= r7) goto L_0x009d
            com.airpay.paysdk.core.bean.ChannelInfo r4 = r15.f4154f
            int r4 = r4.b()
            r7 = 11900(0x2e7c, float:1.6675E-41)
            if (r4 >= r7) goto L_0x009d
            int r3 = com.airpay.paysdk.c.i.com_garena_beepay_label_bill_payment_with
            java.lang.Object[] r4 = new java.lang.Object[r9]
            r4[r8] = r1
            java.lang.String r3 = r15.getString(r3, r4)
            goto L_0x0100
        L_0x009d:
            r4 = 21007(0x520f, float:2.9437E-41)
            if (r3 != r4) goto L_0x00ff
            r3 = 0
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x00b6
            r4 = 3
            java.lang.CharSequence[] r4 = new java.lang.CharSequence[r4]
            r4[r8] = r1
            r4[r9] = r5
            r1 = 2
            r4[r1] = r3
            java.lang.CharSequence r1 = android.text.TextUtils.concat(r4)
        L_0x00b6:
            r9 = r2
            r14 = r3
            r3 = r1
            r1 = r14
            goto L_0x0101
        L_0x00bb:
            com.airpay.paysdk.core.bean.ChannelInfo r3 = r15.f4154f
            int r3 = r3.b()
            if (r3 != r6) goto L_0x00c4
            goto L_0x00cc
        L_0x00c4:
            java.lang.String r3 = r15.u
            java.lang.String r7 = r15.v
            android.text.Spannable r1 = com.airpay.paysdk.base.d.f.a((java.lang.String) r1, (java.lang.String) r3, (java.lang.String) r7)
        L_0x00cc:
            com.airpay.paysdk.core.bean.ChannelInfo r3 = r15.f4154f
            int r3 = r3.b()
            if (r3 != r4) goto L_0x00d6
            int r2 = com.airpay.paysdk.c.d.com_garena_beepay_icon_item_gamecredits
        L_0x00d6:
            java.lang.String r3 = r15.s
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x00ff
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            r3.append(r5)
            int r4 = com.airpay.paysdk.c.i.com_garena_beepay_label_for
            java.lang.String r4 = r15.getString(r4)
            r3.append(r4)
            r3.append(r5)
            java.lang.String r4 = r15.s
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            goto L_0x0100
        L_0x00ff:
            r3 = r1
        L_0x0100:
            r9 = r2
        L_0x0101:
            com.airpay.paysdk.base.bean.BPCheckoutInfo r2 = r15.f4153e
            if (r2 == 0) goto L_0x012d
            com.airpay.paysdk.core.bean.ChannelInfo r2 = r15.f4154f
            int r2 = r2.b()
            if (r2 == r6) goto L_0x012d
            com.airpay.paysdk.base.bean.BPCheckoutInfo r2 = r15.f4153e
            java.lang.String r2 = r2.icon
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x011b
            com.airpay.paysdk.base.bean.BPCheckoutInfo r0 = r15.f4153e
            java.lang.String r0 = r0.icon
        L_0x011b:
            com.airpay.paysdk.base.bean.BPCheckoutInfo r2 = r15.f4153e
            java.lang.String r2 = r2.name
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x012d
            com.airpay.paysdk.base.bean.BPCheckoutInfo r1 = r15.f4153e
            java.lang.String r1 = r1.name
            com.airpay.paysdk.base.bean.BPCheckoutInfo r2 = r15.f4153e
            java.lang.String r3 = r2.name
        L_0x012d:
            r8 = r0
            r10 = r1
            r11 = r3
            r13 = 0
            r12 = 0
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 != 0) goto L_0x0146
            boolean r0 = android.text.TextUtils.isEmpty(r13)
            if (r0 == 0) goto L_0x013f
            goto L_0x0146
        L_0x013f:
            com.airpay.paysdk.base.bean.BPProductDetail r0 = new com.airpay.paysdk.base.bean.BPProductDetail
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13)
            return r0
        L_0x0146:
            com.airpay.paysdk.base.bean.BPProductDetail r0 = new com.airpay.paysdk.base.bean.BPProductDetail
            r0.<init>(r8, r9, r10, r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airpay.paysdk.pay.PaymentOptionsActivity.p():com.airpay.paysdk.base.bean.BPProductDetail");
    }

    /* access modifiers changed from: protected */
    public boolean j() {
        return super.j();
    }

    private BPThirdPartyOrderDetail v() {
        if (this.f4154f.a() != 21071) {
            return null;
        }
        try {
            return new BPThirdPartyOrderDetail.Builder().shop(b.a(this.z.get(0).getExtraData())).build();
        } catch (RuntimeException e2) {
            com.airpay.paysdk.common.b.a.a((Throwable) e2);
            return null;
        }
    }
}
