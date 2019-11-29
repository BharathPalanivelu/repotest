package com.airpay.paysdk.qrcode.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.airpay.paysdk.b;
import com.airpay.paysdk.base.bean.BPOrderInfo;
import com.airpay.paysdk.base.d.o;
import com.airpay.paysdk.base.interfaces.IResultCallback;
import com.airpay.paysdk.base.ui.a.a;
import com.airpay.paysdk.base.ui.weidget.g;
import com.airpay.paysdk.c;
import com.airpay.paysdk.core.bean.PayResult;
import com.airpay.paysdk.pay.password.PasswordResultInfo;
import com.airpay.paysdk.pay.password.PaymentConfirmDetailInfo;
import com.airpay.paysdk.pay.password.PaymentOrderExecuteResultInfo;
import com.airpay.paysdk.pay.password.ShoppingCartInfo;
import com.airpay.paysdk.result.TransactionDetailsActivity;

public class ConfirmPaymentActivity extends a {

    /* renamed from: b  reason: collision with root package name */
    private PaymentConfirmDetailInfo f4381b;

    /* renamed from: c  reason: collision with root package name */
    private Button f4382c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f4383d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f4384e;

    /* renamed from: f  reason: collision with root package name */
    private g f4385f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public b f4386g;
    private com.airpay.paysdk.common.net.a.a.b h;
    private com.airpay.paysdk.common.net.a.a.a<PaymentOrderExecuteResultInfo> i = new com.airpay.paysdk.common.net.a.a.a<PaymentOrderExecuteResultInfo>() {
        public void a(PaymentOrderExecuteResultInfo paymentOrderExecuteResultInfo) {
            if (ConfirmPaymentActivity.this.f4386g != null) {
                ConfirmPaymentActivity.this.f4386g.onResponse(PayResult.f4113a);
            }
            ConfirmPaymentActivity.this.a(paymentOrderExecuteResultInfo.a(), paymentOrderExecuteResultInfo.b());
            ConfirmPaymentActivity.this.finish();
        }

        public void a(int i, String str) {
            if (i == 10012) {
                ConfirmPaymentActivity.this.h();
                return;
            }
            if (i == 124) {
                com.airpay.paysdk.base.b.a.a().a((Context) ConfirmPaymentActivity.this, c.i.com_garena_beepay_error_order_expired);
            } else {
                com.airpay.paysdk.base.b.a.a().b((Context) ConfirmPaymentActivity.this, str);
            }
            ConfirmPaymentActivity.this.finish();
        }
    };
    private boolean j = true;

    /* access modifiers changed from: protected */
    public void h() {
    }

    public static void a(Context context, PaymentConfirmDetailInfo paymentConfirmDetailInfo, b bVar) {
        Intent intent = new Intent(context, ConfirmPaymentActivity.class);
        Bundle bundle = new Bundle();
        o.a(bundle, bVar);
        intent.putExtras(bundle);
        intent.putExtra("PAYMENT_CONFIRM_DETAIL", paymentConfirmDetailInfo);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public int a() {
        return c.h.activity_qr_confirm_payment;
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.f4381b = (PaymentConfirmDetailInfo) getIntent().getParcelableExtra("PAYMENT_CONFIRM_DETAIL");
        this.f4386g = o.a(getIntent().getExtras());
        if (this.f4381b == null) {
            finish();
        }
        setTitle(c.i.com_garena_beepay_label_confirm_payment);
        c(true);
        i();
        if (this.f4381b != null) {
            j();
        }
        this.f3840a.post(new Runnable() {
            public final void run() {
                ConfirmPaymentActivity.this.l();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l() {
        if (d() != null) {
            d().setPadding(0, d().getMeasuredHeight() / 3, 0, 0);
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        b();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        com.airpay.paysdk.common.net.a.a.b bVar = this.h;
        if (bVar != null) {
            bVar.a();
        }
    }

    private void i() {
        this.f4382c = (Button) findViewById(c.f.confirm_payment_btn_pay_now);
        this.f4383d = (TextView) findViewById(c.f.confirm_payment_tv_payment_amount);
        this.f4384e = (TextView) findViewById(c.f.confirm_payment_tv_payee_name);
        this.f4385f = (g) findViewById(c.f.confirm_payment_payee_icon);
        this.f4382c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ConfirmPaymentActivity.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        k();
    }

    private void j() {
        this.f4384e.setText(this.f4381b.a());
        if (!TextUtils.isEmpty(this.f4381b.c())) {
            this.f4383d.setText(this.f4381b.c());
        }
    }

    private void k() {
        com.airpay.paysdk.common.d.a.a().c();
        a(new Intent(this, CheckPaymentPswActivity.class), 1043, (IResultCallback) new IResultCallback() {
            public void run(int i, Intent intent) {
                if (i == -1 && intent != null) {
                    PasswordResultInfo passwordResultInfo = (PasswordResultInfo) intent.getParcelableExtra("password_result");
                    if (passwordResultInfo != null && passwordResultInfo.a()) {
                        ConfirmPaymentActivity.this.b(passwordResultInfo.f4229c);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        this.h = com.airpay.paysdk.core.a.a().a(this.f4381b.b().b(), str, this.i);
    }

    /* access modifiers changed from: private */
    public void a(BPOrderInfo bPOrderInfo, ShoppingCartInfo shoppingCartInfo) {
        if (bPOrderInfo != null) {
            TransactionDetailsActivity.a(this, bPOrderInfo, this.f4386g);
        }
    }

    /* access modifiers changed from: protected */
    public void c(boolean z) {
        this.f3840a.setHomeBtnText(getString(c.i.com_garena_beepay_label_cancel));
        this.f3840a.setHomeActionEnabled(z);
        this.j = z;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_close_enabled", this.j);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.j = bundle.getBoolean("is_close_enabled", this.j);
        c(this.j);
    }

    public void onBackPressed() {
        if (this.j) {
            super.onBackPressed();
        }
    }
}
