package com.airpay.paysdk.pay;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.airpay.paysdk.b;
import com.airpay.paysdk.base.bean.PayParams;
import com.airpay.paysdk.base.d.m;
import com.airpay.paysdk.base.d.o;
import com.airpay.paysdk.base.ui.a.a;
import com.airpay.paysdk.c;
import com.airpay.paysdk.core.bean.Param;
import com.airpay.paysdk.core.bean.PayResult;
import com.airpay.paysdk.pay.password.ShoppingCartInfo;
import java.util.regex.Pattern;

public class PaymentDetailsActivity extends a implements com.airpay.paysdk.pay.a.a {

    /* renamed from: b  reason: collision with root package name */
    private ImageView f4139b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f4140c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f4141d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f4142e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public EditText f4143f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Button f4144g;
    /* access modifiers changed from: private */
    public com.airpay.paysdk.pay.d.a h;
    private Param i;
    private b j;
    private ShoppingCartInfo k;

    /* access modifiers changed from: protected */
    public int a() {
        return c.h.activity_payment_details;
    }

    /* access modifiers changed from: protected */
    public void b() {
        setTitle(c.i.com_garena_beepay_label_payment_details);
        this.f4139b = (ImageView) findViewById(c.f.iv_shop_icon);
        this.f4140c = (TextView) findViewById(c.f.tv_owner_name);
        this.f4141d = (TextView) findViewById(c.f.tv_shop_name);
        this.f4142e = (TextView) findViewById(c.f.tv_symbol);
        this.f4144g = (Button) findViewById(c.f.btn_pay);
        this.f4143f = (EditText) findViewById(c.f.edit_amount);
        this.f3840a.setHomeAction(new View.OnClickListener() {
            public final void onClick(View view) {
                PaymentDetailsActivity.this.b(view);
            }
        });
        h();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        j();
    }

    public void onBackPressed() {
        j();
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.h = new com.airpay.paysdk.pay.d.a(this);
        this.h.a(getIntent().getExtras());
        i();
    }

    private void h() {
        Bundle extras = getIntent().getExtras();
        this.i = (Param) extras.getParcelable("param");
        this.k = (ShoppingCartInfo) extras.getParcelable("shopping_cart");
        this.j = o.a(extras);
    }

    private void i() {
        com.airpay.paysdk.common.d.a.a((View) this.f4144g).a((View.OnClickListener) new View.OnClickListener() {
            public final void onClick(View view) {
                PaymentDetailsActivity.this.a(view);
            }
        });
        this.f4143f.setFilters(new InputFilter[]{new InputFilter() {

            /* renamed from: b  reason: collision with root package name */
            private final Pattern f4146b = PaymentDetailsActivity.this.h.b();

            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                CharSequence a2 = PaymentDetailsActivity.this.h.a(TextUtils.concat(new CharSequence[]{spanned.subSequence(0, i3), charSequence.subSequence(i, i2), spanned.subSequence(i4, spanned.length())}));
                if (!this.f4146b.matcher(a2).matches() || TextUtils.isEmpty(a2)) {
                    return "";
                }
                return null;
            }
        }});
        this.f4143f.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                PaymentDetailsActivity.this.h.a(editable);
                PaymentDetailsActivity.this.f4144g.setEnabled(PaymentDetailsActivity.this.h.b(PaymentDetailsActivity.this.f4143f.getText().toString().trim()) > 0);
            }
        });
        this.f4143f.requestFocus();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.h.a(this.f4143f.getText().toString().trim());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.h.a();
        super.onDestroy();
    }

    private void j() {
        com.airpay.paysdk.common.b.a.a("exit, releaseResource...", new Object[0]);
        b bVar = this.j;
        if (bVar != null) {
            bVar.onResponse(PayResult.f4114b);
        }
        finish();
    }

    public void b(String str) {
        this.f4140c.setText(str);
    }

    public void c(String str) {
        this.f4141d.setText(str);
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f4139b.setImageResource(c.d.icon_collection_qr_shop_default);
        } else {
            m.a(this.f4139b, str, c.d.icon_collection_qr_shop_default);
        }
    }

    public void e(String str) {
        this.f4142e.setText(str);
    }

    public void a(PayParams payParams, Param param) {
        Intent intent = new Intent(this, PaymentOptionsActivity.class);
        intent.putExtra("key_order_params", payParams);
        intent.putExtra("param", param);
        Bundle bundle = new Bundle();
        o.a(bundle, this.j);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
