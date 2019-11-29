package com.airpay.paysdk.qrcode.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.airpay.paysdk.base.ui.a.a;
import com.airpay.paysdk.c;
import com.airpay.paysdk.pay.password.PasscodeControlView;
import com.airpay.paysdk.pay.password.PasswordResultInfo;
import com.airpay.paysdk.pay.password.VerifyAuthMehodResultInfo;
import com.airpay.paysdk.pay.password.b;
import com.airpay.paysdk.pay.password.c;

public class CheckPaymentPswActivity extends a {

    /* renamed from: b  reason: collision with root package name */
    private PasscodeControlView f4375b;

    /* renamed from: c  reason: collision with root package name */
    private View f4376c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4377d = true;

    /* renamed from: e  reason: collision with root package name */
    private b f4378e = new b(new c() {
        public boolean a() {
            return false;
        }

        public void a(VerifyAuthMehodResultInfo verifyAuthMehodResultInfo, PasswordResultInfo passwordResultInfo) {
            if (passwordResultInfo != null && passwordResultInfo.a()) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putParcelable("password_result", passwordResultInfo);
                intent.putExtras(bundle);
                CheckPaymentPswActivity.this.setResult(-1, intent);
                CheckPaymentPswActivity.this.finish();
            }
        }
    });

    public int a() {
        return c.h.com_garena_beepay_check_payment_password_layout;
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.f4376c = findViewById(c.f.passcode_bg_view);
        h();
        this.f4375b = (PasscodeControlView) findViewById(c.f.com_garena_beepay_passcode_control);
        this.f4378e.a((Activity) this, this.f4375b);
        findViewById(c.f.com_garena_beepay_section_main).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CheckPaymentPswActivity.this.a(view);
            }
        });
        c(true);
        setTitle(c.i.com_garena_beepay_label_enter_passcode);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f4375b.a(true);
    }

    private void h() {
        if (this.f3840a != null) {
            this.f3840a.post(new Runnable() {
                public void run() {
                    if (CheckPaymentPswActivity.this.d() != null) {
                        CheckPaymentPswActivity.this.d().setPadding(0, CheckPaymentPswActivity.this.d().getMeasuredHeight() / 3, 0, 0);
                    }
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        b bVar = this.f4378e;
        if (bVar != null) {
            bVar.a();
            this.f4378e = null;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_close_enabled", this.f4377d);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f4377d = bundle.getBoolean("is_close_enabled", this.f4377d);
        c(this.f4377d);
    }

    /* access modifiers changed from: protected */
    public void c(boolean z) {
        this.f3840a.setHomeBtnText(getString(c.i.com_garena_beepay_label_cancel));
        this.f3840a.setHomeActionEnabled(z);
        this.f4377d = z;
    }
}
