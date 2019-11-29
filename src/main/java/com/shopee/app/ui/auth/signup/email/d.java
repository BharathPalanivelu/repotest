package com.shopee.app.ui.auth.signup.email;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.rengwuxian.materialedittext.a.c;
import com.shopee.app.h.q;
import com.shopee.app.tracking.g;
import com.shopee.app.ui.a.e;
import com.shopee.app.ui.auth.signup.b;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bj;
import com.shopee.app.util.x;
import com.shopee.id.R;
import com.shopee.shopeetracker.bimodel.FormRowValidateError;
import com.squareup.a.w;
import java.util.ArrayList;
import java.util.List;

public class d extends RelativeLayout implements MaterialEditText.a {

    /* renamed from: a  reason: collision with root package name */
    b f19841a;

    /* renamed from: b  reason: collision with root package name */
    Activity f19842b;

    /* renamed from: c  reason: collision with root package name */
    ak f19843c;

    /* renamed from: d  reason: collision with root package name */
    bc f19844d;

    /* renamed from: e  reason: collision with root package name */
    r f19845e;

    /* renamed from: f  reason: collision with root package name */
    com.shopee.app.tracking.a f19846f;

    /* renamed from: g  reason: collision with root package name */
    MaterialEditText f19847g;
    MaterialEditText h;
    ImageView i;
    Button j;
    private String k;

    public d(Context context) {
        super(context);
        ((b) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f19844d.a(this.f19841a);
        this.f19841a.a(this);
        com.shopee.app.util.d.a(this.f19847g, "email", g.WRONG_FORMAT_EMAIL);
        com.shopee.app.util.d.a(this.h, "captcha", g.WRONG_EMPTY_CAPTCHA);
        b();
        this.f19847g.b((com.rengwuxian.materialedittext.a.b) new c(com.garena.android.appkit.tools.b.e(R.string.sp_invalid_email), "^[A-Za-z0-9._%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,10}$"));
        this.h.b((com.rengwuxian.materialedittext.a.b) new a(com.garena.android.appkit.tools.b.e(R.string.sp_captcha_error_empty)));
        this.f19847g.a((MaterialEditText.a) this);
        this.h.a((MaterialEditText.a) this);
        bj.a((View) this.j, this.f19847g, this.h);
        bj.a((View) this.j, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                d.this.h();
            }
        });
    }

    private String getTrackPageId() {
        return ((e) this.f19842b).A();
    }

    private String getScreenName() {
        return this.f19842b.getClass().getSimpleName();
    }

    public void b() {
        this.k = new com.shopee.app.network.g().a();
        w.a(getContext()).a(String.format("https://%s/image?key=%s&type=%s", new Object[]{"captcha.shopeemobile.com", this.k, "alphanumeric"})).a((Drawable) new ColorDrawable(-1)).a(this.i);
        if (this.h.getText().length() > 0) {
            this.h.setText("");
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        if (this.h.b() && this.f19847g.b()) {
            this.f19841a.a(this.f19847g.getText().toString(), this.h.getText().toString(), this.k);
            this.f19846f.e(this.f19842b.getClass().getSimpleName());
        }
    }

    public void c() {
        this.f19845e.a();
    }

    public void d() {
        this.f19845e.b();
    }

    public void a(int i2, String str) {
        b();
        q.a((View) this, str);
        a(i2);
    }

    public void e() {
        b();
        this.f19847g.setError(com.garena.android.appkit.tools.b.e(R.string.sp_invalid_email));
        a(1);
    }

    private void a(int i2) {
        com.shopee.app.tracking.a aVar = this.f19846f;
        String trackPageId = getTrackPageId();
        aVar.a(trackPageId, 243, getScreenName() + ".continue", Integer.valueOf(i2), (String) null);
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return !TextUtils.isEmpty(this.f19847g.getText()) && !TextUtils.isEmpty(this.h.getText());
    }

    public void g() {
        a(5);
        com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_mail_registered_ask_login, (int) R.string.sp_label_no, (int) R.string.sp_label_yes, (a.C0318a) new a.C0318a() {
            public void onNegative() {
            }

            public void onPositive() {
                d.this.f19843c.b(d.this.f19847g.getText().toString());
                d.this.f19842b.finish();
            }
        });
    }

    public void a(String str) {
        this.f19843c.a(this.f19847g.getText().toString(), str);
    }

    public void a(boolean z) {
        if (!z) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(this.f19847g.getError())) {
                FormRowValidateError formRowValidateError = (FormRowValidateError) this.f19847g.getTag(R.id.tracking_info_tag);
                if (formRowValidateError != null) {
                    arrayList.add(formRowValidateError);
                }
            }
            if (!TextUtils.isEmpty(this.h.getError())) {
                FormRowValidateError formRowValidateError2 = (FormRowValidateError) this.h.getTag(R.id.tracking_info_tag);
                if (formRowValidateError2 != null) {
                    arrayList.add(formRowValidateError2);
                }
            }
            if (!arrayList.isEmpty()) {
                this.f19846f.a(getTrackPageId(), getScreenName(), (List<FormRowValidateError>) arrayList);
            }
        }
    }

    private static class a extends com.rengwuxian.materialedittext.a.b {
        a(String str) {
            super(str);
        }

        public boolean a(CharSequence charSequence, boolean z) {
            return !TextUtils.isEmpty(charSequence);
        }
    }
}
