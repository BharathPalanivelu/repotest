package com.shopee.app.ui.auth.signup.email;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.app.h.k;
import com.shopee.app.h.q;
import com.shopee.app.tracking.f;
import com.shopee.app.tracking.g;
import com.shopee.app.ui.a.e;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.photo.PhotoProxyActivity_;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bj;
import com.shopee.app.util.d;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.id.R;
import com.shopee.shopeetracker.bimodel.FormRowValidateError;
import java.util.ArrayList;
import java.util.List;

public class j extends RelativeLayout implements MaterialEditText.a {

    /* renamed from: a  reason: collision with root package name */
    MaterialEditText f19868a;

    /* renamed from: b  reason: collision with root package name */
    MaterialEditText f19869b;

    /* renamed from: c  reason: collision with root package name */
    MaterialEditText f19870c;

    /* renamed from: d  reason: collision with root package name */
    MaterialEditText f19871d;

    /* renamed from: e  reason: collision with root package name */
    TextView f19872e;

    /* renamed from: f  reason: collision with root package name */
    ImageView f19873f;

    /* renamed from: g  reason: collision with root package name */
    int f19874g;
    h h;
    Activity i;
    ak j;
    bc k;
    r l;
    Button m;
    com.shopee.app.tracking.a n;
    f o;
    com.shopee.app.tracking.trackingv3.b p;
    String q;
    private final String r;
    private final String s;

    public j(Context context, String str, String str2) {
        super(context);
        this.r = str;
        this.s = str2;
        ((com.shopee.app.ui.auth.signup.b) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.k.a(this.h);
        this.h.a(this);
        this.f19870c.setTypeface(Typeface.DEFAULT);
        this.f19871d.setTypeface(Typeface.DEFAULT);
        this.f19869b.b((com.rengwuxian.materialedittext.a.b) new com.rengwuxian.materialedittext.a.c(com.garena.android.appkit.tools.b.e(R.string.sp_invalid_email), "^[A-Za-z0-9._%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,10}$"));
        this.f19870c.b((com.rengwuxian.materialedittext.a.b) com.shopee.app.ui.auth.password.j.b());
        this.f19871d.b((com.rengwuxian.materialedittext.a.b) new b(com.garena.android.appkit.tools.b.e(R.string.sp_password_not_match)));
        this.f19868a.b((com.rengwuxian.materialedittext.a.b) new a(com.garena.android.appkit.tools.b.e(R.string.sp_error_empty_username)));
        this.f19868a.b((com.rengwuxian.materialedittext.a.b) new c(com.garena.android.appkit.tools.b.e(R.string.sp_error_user_name_format)));
        bj.a((View) this.m, this.f19868a, this.f19870c, this.f19871d);
        com.a.a.f a2 = com.a.a.f.a(getContext(), (int) R.string.sp_agree_to_terms);
        a2.a((int) R.string.sp_label_terms_of_service).a().b(this.f19874g).c().a((View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                j.this.j.C();
            }
        }).b();
        a2.a((int) R.string.sp_label_privacy_policy).a().b(this.f19874g).c().a((View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                j.this.j.D();
            }
        }).b();
        a2.a(this.f19872e);
        bj.a((View) this.m, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                j.this.h();
            }
        });
        this.f19869b.setText(this.r);
        this.f19868a.a((MaterialEditText.a) this);
        this.f19870c.a((MaterialEditText.a) this);
        this.f19871d.a((MaterialEditText.a) this);
        d.a(this.f19868a, "username", g.WRONG_FORMAT_USERNAME);
        d.a(this.f19870c, "password", g.WRONG_FORMAT_PASSWORD);
        d.a(this.f19871d, "password_confirm", g.PASSWORD_MISMATCH);
    }

    private String getTrackPageId() {
        return ((e) this.i).A();
    }

    private String getScreenName() {
        return this.i.getClass().getSimpleName();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        PhotoProxyActivity_.a(getContext()).d(true).c(true).i((int) R.string.sp_camera_hint_sign_up).a(4);
    }

    public void a(String str) {
        this.h.a(str);
    }

    public void setAvatar(String str) {
        this.q = str;
        z.a(getContext()).a(str).b(this.f19873f);
    }

    /* access modifiers changed from: private */
    public void h() {
        if (this.f19868a.b() && this.f19869b.b() && this.f19870c.b() && this.f19871d.b()) {
            String obj = this.f19870c.getText().toString();
            String trim = this.f19869b.getText().toString().trim();
            String trim2 = this.f19868a.getText().toString().trim();
            if (!com.shopee.app.ui.auth.signup.c.a(trim2)) {
                com.shopee.app.h.r.a().a(com.garena.android.appkit.tools.b.e(R.string.sp_error_user_name_format));
                return;
            }
            this.h.a(trim, obj, trim2, this.q, this.s);
            this.n.b(getScreenName(), "email");
        }
    }

    private void a(int i2) {
        com.shopee.app.tracking.a aVar = this.n;
        String trackPageId = getTrackPageId();
        aVar.a(trackPageId, 12, getScreenName() + ".signup", Integer.valueOf(i2), (String) null);
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return !TextUtils.isEmpty(this.f19868a.getText()) || !TextUtils.isEmpty(this.f19869b.getText()) || !TextUtils.isEmpty(this.f19870c.getText()) || !TextUtils.isEmpty(this.f19871d.getText());
    }

    public void a(int i2, String str) {
        a(0);
        this.o.a(i2);
        this.o.a(str);
        this.p.b("sign_up", "action_sign_up_success", com.shopee.app.tracking.trackingv3.b.b(str));
        k.b(getContext(), ((e) this.i).j(), str, i2);
    }

    public void d() {
        this.l.a();
    }

    public void e() {
        this.l.b();
    }

    public void b(int i2, String str) {
        a(i2);
        q.a((View) this, str);
    }

    /* access modifiers changed from: package-private */
    public void a(View view, boolean z) {
        if (!z && TextUtils.isEmpty(this.f19868a.getText())) {
            this.f19868a.setText(b(this.f19869b.getText().toString()));
        }
    }

    private String b(String str) {
        int indexOf = str.indexOf(64);
        if (indexOf < 0) {
            return "";
        }
        String substring = str.substring(0, indexOf);
        if (!str.substring(indexOf, str.length() - 1).toLowerCase().contains("qq")) {
            return substring;
        }
        return "qq" + substring;
    }

    public void f() {
        a(5);
        com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_mail_registered_ask_login, (int) R.string.sp_label_no, (int) R.string.sp_label_yes, (a.C0318a) new a.C0318a() {
            public void onNegative() {
            }

            public void onPositive() {
                j.this.j.b(j.this.f19869b.getText().toString());
                j.this.i.finish();
            }
        });
    }

    public void g() {
        a(7);
        com.shopee.app.h.r.a().b((int) R.string.sp_captcha_error_expired);
        this.i.setResult(0);
        this.i.finish();
    }

    public void a(boolean z) {
        if (!z) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(this.f19868a.getError())) {
                FormRowValidateError formRowValidateError = (FormRowValidateError) this.f19868a.getTag(R.id.tracking_info_tag);
                if (formRowValidateError != null) {
                    arrayList.add(formRowValidateError);
                }
            }
            if (!TextUtils.isEmpty(this.f19870c.getError())) {
                FormRowValidateError formRowValidateError2 = (FormRowValidateError) this.f19870c.getTag(R.id.tracking_info_tag);
                if (formRowValidateError2 != null) {
                    arrayList.add(formRowValidateError2);
                }
            }
            if (!TextUtils.isEmpty(this.f19871d.getError())) {
                FormRowValidateError formRowValidateError3 = (FormRowValidateError) this.f19871d.getTag(R.id.tracking_info_tag);
                if (formRowValidateError3 != null) {
                    arrayList.add(formRowValidateError3);
                }
            }
            if (!arrayList.isEmpty()) {
                this.n.a(getTrackPageId(), getScreenName(), (List<FormRowValidateError>) arrayList);
            }
        }
    }

    private class b extends com.rengwuxian.materialedittext.a.b {
        public b(String str) {
            super(str);
        }

        public boolean a(CharSequence charSequence, boolean z) {
            return charSequence.toString().equals(j.this.f19870c.getText().toString()) && !TextUtils.isEmpty(charSequence);
        }
    }

    private static class c extends com.rengwuxian.materialedittext.a.b {
        public c(String str) {
            super(str);
        }

        public boolean a(CharSequence charSequence, boolean z) {
            return com.shopee.app.ui.auth.signup.c.a(String.valueOf(charSequence));
        }
    }

    private static class a extends com.rengwuxian.materialedittext.a.b {
        public a(String str) {
            super(str);
        }

        public boolean a(CharSequence charSequence, boolean z) {
            return !TextUtils.isEmpty(charSequence);
        }
    }
}
