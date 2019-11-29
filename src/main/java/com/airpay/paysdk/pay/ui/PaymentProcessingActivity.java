package com.airpay.paysdk.pay.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.airpay.paysdk.base.bean.BPOrderInfo;
import com.airpay.paysdk.base.bean.EventCommonResult;
import com.airpay.paysdk.base.d.f;
import com.airpay.paysdk.base.d.o;
import com.airpay.paysdk.base.interfaces.IResultCallback;
import com.airpay.paysdk.base.proto.PaymentOrderInitRequestProto;
import com.airpay.paysdk.base.ui.a.a;
import com.airpay.paysdk.c;
import com.airpay.paysdk.core.bean.ChannelInfo;
import com.airpay.paysdk.core.bean.ChannelListInfo;
import com.airpay.paysdk.core.bean.PayResult;
import com.airpay.paysdk.pay.password.BPPaymentProcessingInfo;
import com.airpay.paysdk.pay.password.PasscodeControlView;
import com.airpay.paysdk.pay.password.PasswordResultInfo;
import com.airpay.paysdk.pay.password.PaymentOrderExecuteResultInfo;
import com.airpay.paysdk.pay.password.PaymentOrderInitResultInfo;
import com.airpay.paysdk.pay.password.ShoppingCartInfo;
import com.airpay.paysdk.pay.password.VerifyAuthMehodResultInfo;
import com.airpay.paysdk.pay.password.b;
import com.airpay.paysdk.pay.password.d;
import com.airpay.paysdk.result.TransactionDetailsActivity;
import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class PaymentProcessingActivity extends a {
    private com.airpay.paysdk.common.net.a.a.a<PaymentOrderInitResultInfo> A = new com.airpay.paysdk.common.net.a.a.a<PaymentOrderInitResultInfo>() {
        public void a(PaymentOrderInitResultInfo paymentOrderInitResultInfo) {
            BPOrderInfo unused = PaymentProcessingActivity.this.s = paymentOrderInitResultInfo.a();
            int unused2 = PaymentProcessingActivity.this.p = 3;
            EventCommonResult unused3 = PaymentProcessingActivity.this.q = new EventCommonResult(0);
            PaymentProcessingActivity paymentProcessingActivity = PaymentProcessingActivity.this;
            paymentProcessingActivity.a(paymentProcessingActivity.s);
        }

        public void a(int i, String str) {
            BPOrderInfo unused = PaymentProcessingActivity.this.s = null;
            int unused2 = PaymentProcessingActivity.this.p = 3;
            EventCommonResult unused3 = PaymentProcessingActivity.this.q = new EventCommonResult(i);
            if (i == 10012) {
                PaymentProcessingActivity.this.u();
            } else if (i == 2) {
                ArrayList arrayList = new ArrayList();
                if (PaymentProcessingActivity.this.k.f4208a.payment_channel_id != null) {
                    arrayList.add(PaymentProcessingActivity.this.k.f4208a.payment_channel_id);
                }
                if (PaymentProcessingActivity.this.k.f4208a.topup_channel_id != null) {
                    arrayList.add(PaymentProcessingActivity.this.k.f4208a.topup_channel_id);
                }
                com.airpay.paysdk.qrcode.a.a().a((List<Integer>) arrayList, (com.airpay.paysdk.common.net.a.a.a<ChannelListInfo>) PaymentProcessingActivity.this.B);
            } else {
                PaymentProcessingActivity.this.a(new EventCommonResult(i, str, true));
            }
        }
    };
    /* access modifiers changed from: private */
    public com.airpay.paysdk.common.net.a.a.a<ChannelListInfo> B = new com.airpay.paysdk.common.net.a.a.a<ChannelListInfo>() {
        public void a(ChannelListInfo channelListInfo) {
            PaymentProcessingActivity.this.s();
            PaymentProcessingActivity.this.a(new EventCommonResult(2));
        }

        public void a(int i, String str) {
            PaymentProcessingActivity.this.a(new EventCommonResult(2));
        }
    };
    private View.OnClickListener C = new View.OnClickListener() {
        public void onClick(View view) {
        }
    };
    private com.airpay.paysdk.common.net.a.a.a<PaymentOrderExecuteResultInfo> D = new com.airpay.paysdk.common.net.a.a.a<PaymentOrderExecuteResultInfo>() {
        public void a(PaymentOrderExecuteResultInfo paymentOrderExecuteResultInfo) {
            int unused = PaymentProcessingActivity.this.p = 4;
            BPOrderInfo unused2 = PaymentProcessingActivity.this.t = paymentOrderExecuteResultInfo.a();
            EventCommonResult unused3 = PaymentProcessingActivity.this.r = new EventCommonResult(0);
            if (PaymentProcessingActivity.this.v != null) {
                PaymentProcessingActivity.this.v.onResponse(PayResult.f4113a);
            }
            ShoppingCartInfo unused4 = PaymentProcessingActivity.this.u = paymentOrderExecuteResultInfo.b();
            if (f.b(PaymentProcessingActivity.this.t) != 0) {
                PaymentProcessingActivity paymentProcessingActivity = PaymentProcessingActivity.this;
                paymentProcessingActivity.a(paymentProcessingActivity.t, PaymentProcessingActivity.this.u);
                return;
            }
            PaymentProcessingActivity paymentProcessingActivity2 = PaymentProcessingActivity.this;
            paymentProcessingActivity2.b(paymentProcessingActivity2.t, PaymentProcessingActivity.this.u);
        }

        public void a(int i, String str) {
            int unused = PaymentProcessingActivity.this.p = 4;
            EventCommonResult eventCommonResult = new EventCommonResult(i, str, true);
            EventCommonResult unused2 = PaymentProcessingActivity.this.r = eventCommonResult;
            int a2 = PaymentProcessingActivity.this.o != null ? PaymentProcessingActivity.this.o.a() : -1;
            if (i == 108) {
                PaymentProcessingActivity paymentProcessingActivity = PaymentProcessingActivity.this;
                paymentProcessingActivity.a(paymentProcessingActivity, "", paymentProcessingActivity.m, a2);
            } else if (i == 348) {
                com.airpay.paysdk.base.b.a.a().b((Context) PaymentProcessingActivity.this, str);
                PaymentProcessingActivity paymentProcessingActivity2 = PaymentProcessingActivity.this;
                paymentProcessingActivity2.a(paymentProcessingActivity2, "", paymentProcessingActivity2.m, a2);
            } else if (i == 107) {
                PaymentProcessingActivity.this.a(eventCommonResult);
            } else if (i == 10012) {
                PaymentProcessingActivity.this.h();
            } else {
                com.airpay.paysdk.base.b.a.a().b((Context) PaymentProcessingActivity.this, str);
                com.airpay.paysdk.common.b.a.a("pay execute failed: " + i + "  " + str, new Object[0]);
                PaymentProcessingActivity.this.a(eventCommonResult);
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    protected PasscodeControlView f4288b;

    /* renamed from: c  reason: collision with root package name */
    private b f4289c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4290d = true;

    /* renamed from: e  reason: collision with root package name */
    private TextView f4291e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f4292f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f4293g;
    private Button h;
    private Button i;
    private Button j;
    /* access modifiers changed from: private */
    public BPPaymentProcessingInfo k;
    /* access modifiers changed from: private */
    public String l;
    /* access modifiers changed from: private */
    public long m;
    private ChannelInfo n = null;
    /* access modifiers changed from: private */
    public ChannelInfo o = null;
    /* access modifiers changed from: private */
    public int p = 0;
    /* access modifiers changed from: private */
    public EventCommonResult q;
    /* access modifiers changed from: private */
    public EventCommonResult r;
    /* access modifiers changed from: private */
    public BPOrderInfo s;
    /* access modifiers changed from: private */
    public BPOrderInfo t;
    /* access modifiers changed from: private */
    public ShoppingCartInfo u;
    /* access modifiers changed from: private */
    public com.airpay.paysdk.b v;
    private View.OnClickListener w = new View.OnClickListener() {
        public final void onClick(View view) {
            PaymentProcessingActivity.this.e(view);
        }
    };
    private View.OnClickListener x = new View.OnClickListener() {
        public final void onClick(View view) {
            PaymentProcessingActivity.this.d(view);
        }
    };
    private View.OnClickListener y = new View.OnClickListener() {
        public final void onClick(View view) {
            PaymentProcessingActivity.this.c(view);
        }
    };
    private View.OnClickListener z = new View.OnClickListener() {
        public final void onClick(View view) {
            PaymentProcessingActivity.this.b(view);
        }
    };

    /* access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        k();
        o();
        this.p = 0;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        k();
        o();
        this.p = 3;
        r();
        q();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        i();
    }

    /* access modifiers changed from: private */
    public void a(Activity activity, String str, long j2, int i2) {
        Intent intent = new Intent(activity, PaymentOTPVerifiedActivity.class);
        intent.putExtra("key_extra_phone_number", str);
        intent.putExtra("key_extra_order_id", j2);
        intent.setFlags(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        intent.putExtra("key_extra_channel_id", i2);
        a(intent, 20480, (IResultCallback) new IResultCallback() {
            public void run(int i, Intent intent) {
                if (i == -1) {
                    PaymentProcessingActivity.this.c(intent.getStringExtra("key_extra_otp"));
                } else if (i == 0) {
                    PaymentProcessingActivity.this.finish();
                }
            }
        });
    }

    public static d a(PaymentOrderInitRequestProto paymentOrderInitRequestProto) {
        return d.a(paymentOrderInitRequestProto, (Class<? extends PaymentProcessingActivity>) PaymentProcessingActivity.class);
    }

    /* access modifiers changed from: protected */
    public int a() {
        return c.h.com_garena_airpay_payment_processing_layout;
    }

    /* access modifiers changed from: protected */
    public void b() {
        Intent intent = getIntent();
        this.v = o.a(intent.getExtras());
        this.k = (BPPaymentProcessingInfo) intent.getParcelableExtra("processing_info");
        if (this.k == null) {
            com.airpay.paysdk.base.b.a.a().a((Context) this, c.i.com_garena_beepay_unknown_error);
            finish();
            return;
        }
        s();
        c(true);
        this.f4288b = (PasscodeControlView) findViewById(c.f.com_garena_beepay_passcode_control);
        this.f4289c = new b(new com.airpay.paysdk.pay.password.c() {
            public boolean a() {
                return true;
            }

            public void a(VerifyAuthMehodResultInfo verifyAuthMehodResultInfo, PasswordResultInfo passwordResultInfo) {
                PaymentProcessingActivity.this.c(false);
                PaymentProcessingActivity.this.f4288b.a(false);
                if (passwordResultInfo.a()) {
                    String unused = PaymentProcessingActivity.this.l = passwordResultInfo.f4229c;
                    PaymentProcessingActivity.this.p();
                    return;
                }
                PaymentProcessingActivity.this.finish();
            }
        });
        this.f4289c.a((Activity) this, this.f4288b);
        com.airpay.paysdk.base.d.d.a(d(), c.f.com_garena_beepay_section_main, (View.OnClickListener) new View.OnClickListener() {
            public final void onClick(View view) {
                PaymentProcessingActivity.this.a(view);
            }
        });
        this.f4291e = (TextView) findViewById(c.f.com_garena_beepay_txt_payment_status);
        this.f4292f = (TextView) findViewById(c.f.com_garena_beepay_txt_payment_status_description);
        this.f4293g = (TextView) findViewById(c.f.com_garena_beepay_txt_payment_error);
        this.i = (Button) findViewById(c.f.com_garena_beepay_btn_payment_cancel);
        this.h = (Button) findViewById(c.f.com_garena_beepay_btn_payment_try_again);
        this.j = (Button) findViewById(c.f.com_garena_beepay_btn_payment_next);
        setTitle(c.i.com_garena_beepay_label_enter_passcode);
        this.f3840a.post(new Runnable() {
            public final void run() {
                PaymentProcessingActivity.this.w();
            }
        });
        if (!this.k.a()) {
            c(false);
            p();
            this.f4288b.a(false);
            setTitle(c.i.com_garena_beepay_label_loading_caption);
            return;
        }
        com.airpay.paysdk.common.c.a.a().a(new Runnable() {
            public final void run() {
                PaymentProcessingActivity.this.v();
            }
        }, 500);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f4288b.a(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w() {
        if (d() != null) {
            d().setPadding(0, d().getMeasuredHeight() / 3, 0, 0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v() {
        this.f4288b.a(true);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f4289c.a();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        p();
    }

    public void onBackPressed() {
        if (this.f4290d) {
            super.onBackPressed();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_close_enabled", this.f4290d);
        bundle.putInt("processing_stage", this.p);
        bundle.putLong(BPOrderInfo.FIELD_ORDER_ID, this.m);
        EventCommonResult eventCommonResult = this.q;
        if (eventCommonResult != null) {
            bundle.putParcelable("order_init_status", new EventCommonResult.EventParcelableResult(eventCommonResult));
        }
        EventCommonResult eventCommonResult2 = this.r;
        if (eventCommonResult2 != null) {
            bundle.putParcelable("order_exec_status", new EventCommonResult.EventParcelableResult(eventCommonResult2));
        }
        bundle.putString("secure_token", this.l);
        BPOrderInfo bPOrderInfo = this.s;
        if (bPOrderInfo != null) {
            bundle.putParcelable("order_init_data", bPOrderInfo);
        }
        BPOrderInfo bPOrderInfo2 = this.t;
        if (bPOrderInfo2 != null) {
            bundle.putParcelable("order_exec_data", bPOrderInfo2);
        }
        ShoppingCartInfo shoppingCartInfo = this.u;
        if (shoppingCartInfo != null) {
            bundle.putParcelable("order_shop_cart_data", shoppingCartInfo);
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f4290d = bundle.getBoolean("is_close_enabled", this.f4290d);
        c(this.f4290d);
        this.p = bundle.getInt("processing_stage", 0);
        this.m = bundle.getLong(BPOrderInfo.FIELD_ORDER_ID, 0);
        this.l = bundle.getString("secure_token");
        EventCommonResult.EventParcelableResult eventParcelableResult = (EventCommonResult.EventParcelableResult) bundle.getParcelable("order_init_status");
        if (eventParcelableResult != null) {
            this.q = new EventCommonResult(eventParcelableResult);
        }
        EventCommonResult.EventParcelableResult eventParcelableResult2 = (EventCommonResult.EventParcelableResult) bundle.getParcelable("order_exec_status");
        if (eventParcelableResult2 != null) {
            this.r = new EventCommonResult(eventParcelableResult2);
        }
        try {
            this.s = (BPOrderInfo) bundle.getParcelable("order_init_data");
            this.t = (BPOrderInfo) bundle.getParcelable("order_exec_data");
            this.u = (ShoppingCartInfo) bundle.getSerializable("order_shop_cart_data");
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void p() {
        int i2 = this.p;
        if (i2 != 0) {
            if (i2 == 1 || i2 == 2) {
                q();
            } else if (i2 == 3) {
                a(this.q, this.s);
            } else if (i2 == 4) {
                b(this.r, this.t);
            }
        } else if (!this.k.a() || !TextUtils.isEmpty(this.l)) {
            t();
        }
    }

    private void q() {
        if (this.k.f4212e) {
            e(false);
        } else {
            e(true);
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        this.p = 2;
        String str2 = "{\"topup\": {\"pa_res\": \"" + str + "\", \"device_fingerprint_id\":\"" + this.k.f4210c + "\"}}";
        if (this.k.a()) {
            this.k.f4214g = this.l;
        }
        com.airpay.paysdk.core.a.a().a(this.m, str2, this.k.f4214g, this.D);
    }

    private void r() {
        String str;
        this.p = 2;
        ChannelInfo channelInfo = this.o;
        if (channelInfo == null || channelInfo.b() != 3) {
            str = null;
        } else {
            str = "{\"topup\": {\"device_fingerprint_id\":\"" + this.k.f4210c + "\"}}";
        }
        String str2 = str;
        if (this.k.a()) {
            this.k.f4214g = this.l;
        }
        com.airpay.paysdk.core.a.a().a(this.m, str2, this.k.f4214g, this.D);
    }

    /* access modifiers changed from: protected */
    public void c(boolean z2) {
        this.f3840a.setHomeBtnText(getString(c.i.com_garena_beepay_label_cancel));
        this.f3840a.setHomeActionEnabled(z2);
        this.f4290d = z2;
    }

    /* access modifiers changed from: private */
    public void s() {
        if (this.k.f4208a.payment_channel_id != null) {
            this.n = com.airpay.paysdk.qrcode.a.a().a(this.k.f4208a.payment_channel_id);
        }
        if (this.k.f4208a.topup_channel_id != null) {
            this.o = com.airpay.paysdk.qrcode.a.a().a(this.k.f4208a.topup_channel_id);
        }
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        String str2;
        this.p = 2;
        ChannelInfo channelInfo = this.o;
        if (channelInfo == null || channelInfo.b() != 3) {
            str2 = "{\"topup\": {\"otp\":\"" + str + "\"}}";
        } else {
            str2 = "{\"topup\": {\"device_fingerprint_id\":\"" + this.k.f4210c + "\", \"otp\":\"" + str + "\"}}";
        }
        com.airpay.paysdk.core.a.a().a(this.m, str2, this.k.f4214g, this.D);
    }

    private void t() {
        this.p = 1;
        com.airpay.paysdk.core.a.a().a(this.k, this.A);
        q();
    }

    private void a(EventCommonResult eventCommonResult, BPOrderInfo bPOrderInfo) {
        if (eventCommonResult != null && eventCommonResult.isSuccess()) {
            a(bPOrderInfo);
        } else if (eventCommonResult != null && eventCommonResult.getResultCode() == 10012) {
            u();
        } else if (eventCommonResult == null || eventCommonResult.getResultCode() != 2) {
            a(eventCommonResult);
        } else {
            ArrayList arrayList = new ArrayList();
            if (this.k.f4208a.payment_channel_id != null) {
                arrayList.add(this.k.f4208a.payment_channel_id);
            }
            if (this.k.f4208a.topup_channel_id != null) {
                arrayList.add(this.k.f4208a.topup_channel_id);
            }
            com.airpay.paysdk.qrcode.a.a().a((List<Integer>) arrayList, this.B);
        }
    }

    /* access modifiers changed from: protected */
    public void a(BPOrderInfo bPOrderInfo, ShoppingCartInfo shoppingCartInfo, String str) {
        TransactionDetailsActivity.a(this, bPOrderInfo, this.v);
    }

    /* access modifiers changed from: private */
    public void a(BPOrderInfo bPOrderInfo) {
        this.m = bPOrderInfo.getOrderId();
        if (this.k.f4209b) {
            JSONObject i2 = com.airpay.paysdk.pay.b.a.i(bPOrderInfo.getExtraData());
            if (i2 != null) {
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("PaReq", i2.getString("pa_req"));
                    hashMap.put("MD", i2.getString("xid"));
                    hashMap.put("TermUrl", i2.optString("term_url"));
                    String a2 = com.airpay.paysdk.pay.password.a.a(i2.getString("acs_url"), (Map<String, String>) hashMap);
                    Intent intent = new Intent(this, PaymentOTPWebViewActivity.class);
                    intent.putExtra("form_content", a2);
                    intent.putExtra("key_order_id", this.m);
                    intent.putExtra("term_url", (String) hashMap.get("TermUrl"));
                    a(intent, 17186, (IResultCallback) new IResultCallback() {
                        public void run(int i, Intent intent) {
                            if (i != -1) {
                                int unused = PaymentProcessingActivity.this.p = -1;
                                PaymentProcessingActivity.this.finish();
                                return;
                            }
                            PaymentProcessingActivity.this.b(intent.getStringExtra("pares"));
                        }
                    });
                } catch (JSONException e2) {
                    com.airpay.paysdk.common.b.a.a((Throwable) e2);
                    com.airpay.paysdk.base.b.a.a().a((Context) this, c.i.com_garena_beepay_unknown_error);
                }
            } else {
                r();
            }
        } else {
            b(bPOrderInfo);
        }
    }

    /* access modifiers changed from: private */
    public void u() {
        m();
        a(this.w);
        n();
        d(false);
    }

    /* access modifiers changed from: protected */
    public void h() {
        a(c.i.com_garena_beepay_label_go_back, this.C);
        a(this.y);
        n();
        d(true);
    }

    private void b(EventCommonResult eventCommonResult, BPOrderInfo bPOrderInfo) {
        if (eventCommonResult.getResultCode() == 10012) {
            h();
        } else if (bPOrderInfo == null || bPOrderInfo.getStatus() < 0) {
            a(eventCommonResult);
        } else if (f.b(bPOrderInfo) != 0) {
            a(bPOrderInfo, this.u);
        } else {
            b(bPOrderInfo, this.u);
        }
    }

    /* access modifiers changed from: private */
    public void a(EventCommonResult eventCommonResult) {
        n();
        b(eventCommonResult);
        if (eventCommonResult != null) {
            if (eventCommonResult.getResultCode() == 139) {
                com.airpay.paysdk.pay.b.c.a().d();
            }
            if (eventCommonResult.getResultCode() == 161) {
                a(this.x);
            } else if (eventCommonResult.getResultCode() == 281) {
                l();
            }
        } else {
            a(this.w);
        }
        a(c.i.com_garena_beepay_label_cancel, this.z);
    }

    private void b(EventCommonResult eventCommonResult) {
        int i2;
        boolean z2 = eventCommonResult == null || eventCommonResult.getResultCode() != 281;
        if (this.k.f4208a.payment_channel_id == null) {
            i2 = -1;
        } else {
            i2 = this.k.f4208a.payment_channel_id.intValue();
        }
        String a2 = f.a((Context) this, i2);
        if (eventCommonResult != null && eventCommonResult.getResultCode() == 137) {
            String string = getString(c.i.com_garena_beepay_error_payment_limit_exceed);
            String message = eventCommonResult.getMessage();
            if (!TextUtils.isEmpty(message)) {
                a((CharSequence) message, (CharSequence) string, z2);
            } else {
                a((CharSequence) a2, (CharSequence) string, z2);
            }
        } else if (eventCommonResult == null) {
            a((CharSequence) a2, (CharSequence) "", z2);
        } else if (TextUtils.isEmpty(eventCommonResult.getMessage())) {
            a((CharSequence) a2, (CharSequence) f.a((Context) this, this.n, this.o, eventCommonResult, this.k.f4208a), z2);
        } else {
            a((CharSequence) a2, (CharSequence) eventCommonResult.getMessage(), z2);
        }
    }

    /* access modifiers changed from: private */
    public void a(BPOrderInfo bPOrderInfo, ShoppingCartInfo shoppingCartInfo) {
        a(bPOrderInfo, shoppingCartInfo, com.airpay.paysdk.pay.b.a.a(bPOrderInfo));
    }

    private void b(BPOrderInfo bPOrderInfo) {
        a((CharSequence) f.a((Context) this, bPOrderInfo), (CharSequence) "", (PasscodeControlView.a) new PasscodeControlView.a(bPOrderInfo) {
            private final /* synthetic */ BPOrderInfo f$1;

            {
                this.f$1 = r2;
            }

            public final void onComplete() {
                PaymentProcessingActivity.this.c(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(BPOrderInfo bPOrderInfo) {
        com.airpay.paysdk.b bVar = this.v;
        if (bVar != null) {
            bVar.onResponse(PayResult.f4113a);
        }
        if (!isFinishing()) {
            a(bPOrderInfo, (ShoppingCartInfo) null, com.airpay.paysdk.pay.b.a.a(bPOrderInfo));
        }
    }

    /* access modifiers changed from: private */
    public void b(BPOrderInfo bPOrderInfo, ShoppingCartInfo shoppingCartInfo) {
        a((CharSequence) f.b((Context) this, bPOrderInfo), (CharSequence) this.k.f4212e ? "" : getString(c.i.com_garena_beepay_payment_complete_description), (PasscodeControlView.a) new PasscodeControlView.a(bPOrderInfo, shoppingCartInfo) {
            private final /* synthetic */ BPOrderInfo f$1;
            private final /* synthetic */ ShoppingCartInfo f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onComplete() {
                PaymentProcessingActivity.this.c(this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(BPOrderInfo bPOrderInfo, ShoppingCartInfo shoppingCartInfo) {
        if (!isFinishing()) {
            a(bPOrderInfo, shoppingCartInfo, com.airpay.paysdk.pay.b.a.a(bPOrderInfo));
        }
    }

    /* access modifiers changed from: protected */
    public void i() {
        finish();
    }

    /* access modifiers changed from: protected */
    public void j() {
        com.airpay.paysdk.base.d.d.a((Activity) this, c.f.com_garena_beepay_txt_payment_dial, 0);
    }

    /* access modifiers changed from: protected */
    public void k() {
        com.airpay.paysdk.base.d.d.a((Activity) this, c.f.com_garena_beepay_txt_payment_dial, 8);
    }

    /* access modifiers changed from: protected */
    public void a(View.OnClickListener onClickListener) {
        this.h.setOnClickListener(onClickListener);
        this.h.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void l() {
        this.h.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void a(int i2, View.OnClickListener onClickListener) {
        this.i.setText(getString(i2));
        this.i.setOnClickListener(onClickListener);
        this.i.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void m() {
        this.i.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void n() {
        this.j.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void o() {
        m();
        n();
        l();
    }

    private void e(boolean z2) {
        o();
        k();
        this.f4288b.a();
        this.f4291e.setText(c.i.com_garena_beepay_label_processing);
        if (z2) {
            this.f4292f.setText(c.i.com_garena_beepay_payment_processing_description);
        } else {
            this.f4292f.setText("");
        }
        this.f4293g.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void c(int i2) {
        j();
        this.f4288b.a(c.d.com_garena_beepay_icon_network_error);
        this.f4291e.setText(c.i.com_garena_beepay_network_unavailable);
        this.f4292f.setText(i2);
        this.f4293g.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void d(boolean z2) {
        c(z2 ? c.i.com_garena_beepay_network_unavailable_during_order_execution : c.i.com_garena_beepay_network_unavailable_description);
    }

    /* access modifiers changed from: protected */
    public void a(CharSequence charSequence, CharSequence charSequence2, boolean z2) {
        j();
        this.f4288b.a(c.d.com_garena_beepay_icon_payment_failed_page);
        this.f4291e.setText(charSequence);
        if (z2) {
            this.f4292f.setVisibility(0);
            this.f4292f.setText(c.i.com_garena_beepay_transaction_error_description);
        } else {
            this.f4292f.setVisibility(8);
        }
        this.f4293g.setText(charSequence2);
        this.f4293g.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void a(CharSequence charSequence, CharSequence charSequence2, PasscodeControlView.a aVar) {
        o();
        this.f4288b.a(aVar);
        this.f4291e.setText(charSequence);
        this.f4292f.setText(charSequence2);
        this.f4293g.setVisibility(8);
    }
}
