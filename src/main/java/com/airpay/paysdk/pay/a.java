package com.airpay.paysdk.pay;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.airpay.paysdk.base.bean.BPCheckoutInfo;
import com.airpay.paysdk.base.bean.BPEvent;
import com.airpay.paysdk.base.bean.BPOrderPrecheckData;
import com.airpay.paysdk.base.bean.BPProductDetail;
import com.airpay.paysdk.base.bean.BPThirdPartyOrderDetail;
import com.airpay.paysdk.base.bean.BPTopupAmountInfo;
import com.airpay.paysdk.base.bean.BPTopupChannelWithEvents;
import com.airpay.paysdk.base.d.f;
import com.airpay.paysdk.base.d.i;
import com.airpay.paysdk.base.proto.TopupInfoProto;
import com.airpay.paysdk.base.ui.weidget.BBPermissionEmptyView;
import com.airpay.paysdk.base.ui.weidget.BPPriceSummarySection;
import com.airpay.paysdk.base.ui.weidget.c;
import com.airpay.paysdk.base.ui.weidget.k;
import com.airpay.paysdk.c;
import com.airpay.paysdk.common.net.tcp.b.b;
import com.airpay.paysdk.core.bean.ChannelInfo;
import com.airpay.paysdk.pay.a;
import com.airpay.paysdk.pay.c.a.d;
import com.airpay.paysdk.qrcode.model.BankAccountFullInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class a extends com.airpay.paysdk.base.ui.a.a {

    /* renamed from: b  reason: collision with root package name */
    protected ListView f4150b;

    /* renamed from: c  reason: collision with root package name */
    protected BPPriceSummarySection f4151c;

    /* renamed from: d  reason: collision with root package name */
    protected d f4152d;

    /* renamed from: e  reason: collision with root package name */
    protected BPCheckoutInfo f4153e;

    /* renamed from: f  reason: collision with root package name */
    protected ChannelInfo f4154f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f4155g;
    protected boolean h;
    protected long i;
    protected BPTopupChannelWithEvents j;
    protected BPTopupChannelWithEvents k;
    protected d.a l = new d.a() {
        public void a(boolean z, boolean z2, long j, BPTopupChannelWithEvents bPTopupChannelWithEvents, BPTopupChannelWithEvents bPTopupChannelWithEvents2) {
            a aVar = a.this;
            aVar.f4155g = z;
            aVar.h = z2;
            aVar.i = j;
            aVar.j = bPTopupChannelWithEvents;
            aVar.k = bPTopupChannelWithEvents2;
            aVar.h();
        }
    };
    protected boolean m = false;
    private BBPermissionEmptyView n;
    private k o;
    private BPOrderPrecheckData p;
    private int q = 0;
    /* access modifiers changed from: private */
    public int r = 0;
    /* access modifiers changed from: private */
    public List<BankAccountFullInfo> s = new ArrayList();

    /* access modifiers changed from: protected */
    public abstract void o();

    /* access modifiers changed from: protected */
    public abstract BPProductDetail p();

    /* access modifiers changed from: protected */
    public abstract b q();

    /* access modifiers changed from: protected */
    public abstract int r();

    /* access modifiers changed from: protected */
    public abstract boolean s();

    /* access modifiers changed from: protected */
    public abstract void t();

    /* access modifiers changed from: protected */
    public abstract long u();

    /* access modifiers changed from: protected */
    public int a() {
        return c.h.com_garena_airpay_payment_option_base_layout;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        c(false);
        k();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        d dVar = this.f4152d;
        if (dVar != null) {
            dVar.b();
            this.f4152d = null;
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        o();
        this.f4150b = (ListView) findViewById(c.f.com_garena_beepay_list_content);
        this.n = (BBPermissionEmptyView) findViewById(c.f.com_garena_beepay_payment_option_empty_view);
        this.f4151c = (BPPriceSummarySection) findViewById(c.f.com_garena_beepay_section_price_summary);
        this.f4151c.setOnNextPressedListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.a(view);
            }
        });
        this.o = new k(this);
        this.f4150b.addHeaderView(this.o, (Object) null, false);
        this.f4152d = new d();
        this.f4152d.a(this.f4150b, this, this.l);
        i();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (j()) {
            t();
        }
    }

    /* access modifiers changed from: protected */
    public void h() {
        if (!s()) {
            com.airpay.paysdk.common.b.a.a("pay order not ready", new Object[0]);
            return;
        }
        long u = u();
        if (this.k != null) {
            this.f4151c.setEnabled(true);
            BPTopupChannelWithEvents bPTopupChannelWithEvents = this.k;
            if (!(bPTopupChannelWithEvents == null || bPTopupChannelWithEvents.getTopupAmountInfo() == null)) {
                u = this.k.getTopupAmountInfo().topupPayment;
            }
        } else if (this.f4155g) {
            this.f4151c.setEnabled(this.h);
            BPTopupChannelWithEvents bPTopupChannelWithEvents2 = this.j;
            if (!(bPTopupChannelWithEvents2 == null || bPTopupChannelWithEvents2.getTopupAmountInfo() == null)) {
                u = this.j.getTopupAmountInfo().topupPayment;
            }
        } else {
            this.f4151c.setEnabled(false);
        }
        this.f4151c.a(u, (CharSequence) null);
    }

    /* access modifiers changed from: protected */
    public void a(BPOrderPrecheckData bPOrderPrecheckData) {
        this.p = bPOrderPrecheckData;
        this.q = com.airpay.paysdk.base.d.c.a();
        this.f4153e = com.airpay.paysdk.pay.b.a.o(this.p.getExtraData());
        com.airpay.paysdk.pay.b.c.a().c();
    }

    /* access modifiers changed from: protected */
    public void i() {
        ChannelInfo channelInfo = this.f4154f;
        if (channelInfo != null) {
            int b2 = channelInfo.b();
            if (b2 == 10007 || b2 == 10011) {
                setTitle(c.i.com_garena_beepay_airpay_secure_payment);
                this.f4151c.setBtnText(getString(c.i.com_garena_beepay_label_pay_now));
                return;
            }
        }
        setTitle(c.i.com_garena_beepay_label_payment_options);
        this.f4151c.setBtnText(getString(c.i.com_garena_beepay_label_pay_now));
    }

    /* access modifiers changed from: protected */
    public boolean j() {
        BPTopupChannelWithEvents bPTopupChannelWithEvents = this.k;
        if (!(bPTopupChannelWithEvents == null || bPTopupChannelWithEvents.getBankAccountInfo() == null)) {
            BankAccountFullInfo bankAccountInfo = this.k.getBankAccountInfo();
            ChannelInfo e2 = bankAccountInfo.e();
            if (e2 != null) {
                long j2 = this.k.getTopupAmountInfo().topupPayment;
                if (this.f4155g) {
                    j2 -= this.i;
                }
                String a2 = f.a(bankAccountInfo.d(), e2.a(), false, true);
                if (e2.e() > 0 && j2 < e2.e()) {
                    com.airpay.paysdk.base.b.a.a().b((Context) this, getString(c.i.com_garena_beepay_error_min_topup_txn_limit, new Object[]{a2, b.b((double) e2.e())}));
                    com.airpay.paysdk.common.b.a.a("topup amount has min limit", new Object[0]);
                    return false;
                } else if (e2.f() > 0 && j2 > e2.f()) {
                    com.airpay.paysdk.base.b.a.a().b((Context) this, getString(c.i.com_garena_beepay_error_max_topup_txn_limit, new Object[]{a2, b.b((double) e2.f())}));
                    com.airpay.paysdk.common.b.a.a("topup amount has max limit", new Object[0]);
                    return false;
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void k() {
        if (this.f4152d == null) {
            com.airpay.paysdk.common.b.a.a("payment option viewhost is null", new Object[0]);
        } else if (!this.m) {
            com.airpay.paysdk.common.b.a.a("payment options data loaded is false", new Object[0]);
        } else if (this.p == null) {
            com.airpay.paysdk.common.b.a.a("order precheck data is null", new Object[0]);
        } else {
            long j2 = -1;
            ChannelInfo a2 = com.airpay.paysdk.qrcode.a.a().a(Integer.valueOf(r()));
            if (a2 != null) {
                j2 = com.airpay.paysdk.pay.b.a.x(a2.d());
            }
            long j3 = j2;
            androidx.b.d<BPEvent> s2 = com.airpay.paysdk.pay.b.a.s(this.p.getExtraData());
            androidx.b.d<String> n2 = com.airpay.paysdk.pay.b.a.n(this.p.getExtraData());
            BPEvent a3 = s2.a(11000);
            String a4 = n2.a(11000);
            boolean allowCash = this.p.allowCash();
            if (allowCash) {
                BPTopupChannelWithEvents a5 = a(a3);
                a5.setRebateText(a4);
                this.f4152d.a(i.c(com.airpay.paysdk.base.b.c.a().b()), a5, u(), j3);
            }
            List<BPTopupChannelWithEvents> a6 = a(s2, n2);
            ArrayList arrayList = new ArrayList();
            for (BPTopupChannelWithEvents next : a6) {
                next.setTopupAmountInfo(i.a(next.getEvent(), u()));
                if (next.isAvailable()) {
                    arrayList.add(next);
                }
            }
            this.f4152d.a((List<BPTopupChannelWithEvents>) arrayList);
            this.f4152d.a(allowCash, this.p);
            this.f4152d.a();
        }
    }

    private BPTopupChannelWithEvents a(BPEvent bPEvent) {
        BPTopupAmountInfo bPTopupAmountInfo = null;
        BPTopupChannelWithEvents bPTopupChannelWithEvents = new BPTopupChannelWithEvents((BankAccountFullInfo) null, bPEvent, true);
        long u = u();
        if (bPEvent != null) {
            bPTopupAmountInfo = i.a(bPEvent, u);
        }
        bPTopupChannelWithEvents.setTopupAmountInfo(bPTopupAmountInfo);
        return bPTopupChannelWithEvents;
    }

    /* access modifiers changed from: protected */
    public void c(boolean z) {
        if (!l() || z) {
            v();
        }
        if (!m() || z) {
            q();
        }
    }

    /* access modifiers changed from: private */
    public void v() {
        com.airpay.paysdk.qrcode.a.a().b(new com.airpay.paysdk.common.net.a.a.a<List<BankAccountFullInfo>>() {
            public void a(List<BankAccountFullInfo> list) {
                a.this.s.clear();
                a.this.s.addAll(list);
                int unused = a.this.r = com.airpay.paysdk.base.d.c.a();
                a.this.m = true;
                com.airpay.paysdk.common.c.a.a().a(new Runnable() {
                    public void run() {
                        a.this.k();
                    }
                });
            }

            public void a(int i, String str) {
                com.airpay.paysdk.pay.b.b.a(a.this.d(), str, c.i.com_garena_beepay_label_try_again, new c.a() {
                    public final void onCallBack(boolean z) {
                        a.AnonymousClass2.this.a(z);
                    }
                });
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void a(boolean z) {
                if (!z) {
                    a.this.v();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public boolean l() {
        return com.airpay.paysdk.base.d.c.a() - this.r < 120;
    }

    /* access modifiers changed from: protected */
    public boolean m() {
        return !com.airpay.paysdk.pay.b.c.a().b() && com.airpay.paysdk.base.d.c.a() - this.q < 300;
    }

    /* access modifiers changed from: protected */
    public List<BPTopupChannelWithEvents> a(androidx.b.d<BPEvent> dVar, androidx.b.d<String> dVar2) {
        ArrayList arrayList = new ArrayList();
        BPOrderPrecheckData bPOrderPrecheckData = this.p;
        if (bPOrderPrecheckData != null) {
            for (TopupInfoProto next : bPOrderPrecheckData.getPaymentOptions()) {
                if (next.type.intValue() == 2) {
                    Iterator<BankAccountFullInfo> it = this.s.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        BankAccountFullInfo next2 = it.next();
                        if (next2.c() == next.data.longValue()) {
                            BPTopupChannelWithEvents bPTopupChannelWithEvents = new BPTopupChannelWithEvents(next2, dVar.a(a(next2)), true);
                            bPTopupChannelWithEvents.setRebateText(dVar2.a(a(next2)));
                            arrayList.add(bPTopupChannelWithEvents);
                            break;
                        }
                    }
                }
            }
            for (TopupInfoProto next3 : this.p.getUnavailablePaymentOptions()) {
                if (next3.type.intValue() == 2) {
                    Iterator<BankAccountFullInfo> it2 = this.s.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        BankAccountFullInfo next4 = it2.next();
                        if (next4.c() == next3.data.longValue()) {
                            BPTopupChannelWithEvents bPTopupChannelWithEvents2 = new BPTopupChannelWithEvents(next4, dVar.a(a(next4)), false);
                            bPTopupChannelWithEvents2.setRebateText(dVar2.a(a(next4)));
                            arrayList.add(bPTopupChannelWithEvents2);
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private long a(BankAccountFullInfo bankAccountFullInfo) {
        if (bankAccountFullInfo.f()) {
            return bankAccountFullInfo.d().f4355a;
        }
        return (long) bankAccountFullInfo.a();
    }

    /* access modifiers changed from: protected */
    public void a(BPThirdPartyOrderDetail bPThirdPartyOrderDetail, String str, boolean z) {
        k kVar = this.o;
        if (kVar != null) {
            kVar.a(p(), bPThirdPartyOrderDetail, u(), str, z);
        }
    }

    /* access modifiers changed from: protected */
    public int n() {
        BPOrderPrecheckData bPOrderPrecheckData = this.p;
        if (bPOrderPrecheckData != null) {
            return bPOrderPrecheckData.getAllowedAuthMethods();
        }
        return 0;
    }
}
