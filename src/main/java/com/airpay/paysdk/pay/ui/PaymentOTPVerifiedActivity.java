package com.airpay.paysdk.pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.airpay.paysdk.base.d.d;
import com.airpay.paysdk.base.ui.a.a;
import com.airpay.paysdk.base.ui.weidget.BSSectionPureTextItemView;
import com.airpay.paysdk.base.ui.weidget.c;
import com.airpay.paysdk.c;
import com.airpay.paysdk.common.net.a.a.b;
import com.airpay.paysdk.pay.password.e;

public class PaymentOTPVerifiedActivity extends a {

    /* renamed from: b  reason: collision with root package name */
    private String f4270b;

    /* renamed from: c  reason: collision with root package name */
    private long f4271c;

    /* renamed from: d  reason: collision with root package name */
    private int f4272d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public BSSectionPureTextItemView f4273e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f4274f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextView f4275g;
    private b h;
    private com.airpay.paysdk.common.net.a.a.a<Void> i = new com.airpay.paysdk.common.net.a.a.a<Void>() {
        public void a(Void voidR) {
            PaymentOTPVerifiedActivity.this.c();
            PaymentOTPVerifiedActivity.this.j();
        }

        public void a(int i, String str) {
            PaymentOTPVerifiedActivity.this.c();
            PaymentOTPVerifiedActivity.this.j();
        }
    };

    /* access modifiers changed from: protected */
    public int a() {
        return c.h.com_garena_airpay_payment_verify_otp_layout;
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.f4270b = getIntent().getStringExtra("key_extra_phone_number");
        this.f4271c = getIntent().getLongExtra("key_extra_order_id", 0);
        this.f4272d = getIntent().getIntExtra("key_extra_channel_id", -1);
        this.f3840a.setVisibility(8);
        d.a(d(), c.f.com_garena_beepay_tv_action_left, (View.OnClickListener) new View.OnClickListener() {
            public final void onClick(View view) {
                PaymentOTPVerifiedActivity.this.b(view);
            }
        });
        this.f4275g = (TextView) findViewById(c.f.com_garena_beepay_tv_action_right);
        d.a(d(), c.f.com_garena_beepay_tv_action_right, (View.OnClickListener) new View.OnClickListener() {
            public final void onClick(View view) {
                PaymentOTPVerifiedActivity.this.a(view);
            }
        });
        this.f4274f = (TextView) findViewById(c.f.com_garena_beepay_txt_phone_number);
        this.f4273e = (BSSectionPureTextItemView) findViewById(c.f.com_garena_beepay_verification_code_area);
        this.f4274f.setText(getString(c.i.com_garena_beepay_label_phone_number_plus_prefix, new Object[]{this.f4270b}));
        EditText editField = this.f4273e.getEditField();
        a(editField, this.f4272d);
        editField.setHint(c.i.com_garena_beepay_label_verification_code);
        editField.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                PaymentOTPVerifiedActivity.this.f4275g.setEnabled(!TextUtils.isEmpty(PaymentOTPVerifiedActivity.this.f4273e.getDescription()));
            }
        });
        editField.requestFocus();
        com.airpay.paysdk.base.ui.weidget.d.b(editField);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        h();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        String description = this.f4273e.getDescription();
        if (!TextUtils.isEmpty(description)) {
            b(description);
            com.airpay.paysdk.base.ui.weidget.d.a((Activity) this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        b bVar = this.h;
        if (bVar != null) {
            bVar.a();
        }
    }

    private void a(EditText editText, int i2) {
        editText.setInputType(e.a(i2));
    }

    private void b(String str) {
        Intent intent = new Intent();
        intent.putExtra("key_extra_otp", str);
        setResult(-1, intent);
        finish();
    }

    private void h() {
        com.airpay.paysdk.base.ui.weidget.c cVar = new com.airpay.paysdk.base.ui.weidget.c(this);
        cVar.c(c.i.com_garena_beepay_label_payment_cancel_confirmation);
        cVar.a((c.a) new c.a() {
            public final void onCallBack(boolean z) {
                PaymentOTPVerifiedActivity.this.c(z);
            }
        });
        cVar.a(c.i.com_garena_beepay_label_ok);
        cVar.b(c.i.com_garena_beepay_label_cancel);
        cVar.a(d());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(boolean z) {
        if (!z) {
            i();
        }
    }

    private void i() {
        a("", false);
        this.h = com.airpay.paysdk.core.a.a().a(this.f4271c, this.i);
    }

    /* access modifiers changed from: private */
    public void j() {
        setResult(0);
        finish();
    }
}
