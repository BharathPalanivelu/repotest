package com.shopee.app.ui.auth.signup.phone;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.app.h.k;
import com.shopee.app.h.q;
import com.shopee.app.tracking.f;
import com.shopee.app.tracking.g;
import com.shopee.app.ui.a.e;
import com.shopee.app.ui.auth.password.j;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.photo.PhotoProxyActivity_;
import com.shopee.app.util.ak;
import com.shopee.app.util.as;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.id.R;
import com.shopee.shopeetracker.bimodel.FormRowValidateError;
import java.util.ArrayList;
import java.util.List;

public class d extends FrameLayout implements MaterialEditText.a {

    /* renamed from: a  reason: collision with root package name */
    MaterialEditText f19907a;

    /* renamed from: b  reason: collision with root package name */
    MaterialEditText f19908b;

    /* renamed from: c  reason: collision with root package name */
    MaterialEditText f19909c;

    /* renamed from: d  reason: collision with root package name */
    MaterialEditText f19910d;

    /* renamed from: e  reason: collision with root package name */
    TextView f19911e;

    /* renamed from: f  reason: collision with root package name */
    ImageView f19912f;

    /* renamed from: g  reason: collision with root package name */
    int f19913g;
    b h;
    Activity i;
    bc j;
    r k;
    ak l;
    com.shopee.app.tracking.a m;
    f n;
    com.shopee.app.tracking.trackingv3.b o;
    private String p;
    /* access modifiers changed from: private */
    public final String q;
    private final String r;

    public d(Context context, String str, String str2) {
        super(context);
        ((com.shopee.app.ui.auth.signup.b) ((x) context).b()).a(this);
        this.q = str;
        this.r = str2;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.j.a(this.h);
        this.h.a(this);
        this.f19909c.setTypeface(Typeface.DEFAULT);
        this.f19910d.setTypeface(Typeface.DEFAULT);
        this.f19909c.b((com.rengwuxian.materialedittext.a.b) j.b());
        this.f19910d.b((com.rengwuxian.materialedittext.a.b) new b(com.garena.android.appkit.tools.b.e(R.string.sp_password_not_match)));
        this.f19907a.b((com.rengwuxian.materialedittext.a.b) new a(com.garena.android.appkit.tools.b.e(R.string.sp_error_empty_username)));
        this.f19907a.b((com.rengwuxian.materialedittext.a.b) new c(com.garena.android.appkit.tools.b.e(R.string.sp_error_user_name_format)));
        this.f19908b.setText(as.d(this.q));
        this.f19907a.a((MaterialEditText.a) this);
        this.f19909c.a((MaterialEditText.a) this);
        this.f19910d.a((MaterialEditText.a) this);
        com.shopee.app.util.d.a(this.f19907a, "username", g.WRONG_FORMAT_USERNAME);
        com.shopee.app.util.d.a(this.f19909c, "password", g.WRONG_FORMAT_PASSWORD);
        com.shopee.app.util.d.a(this.f19910d, "password_confirm", g.PASSWORD_MISMATCH);
        com.a.a.f a2 = com.a.a.f.a(getContext(), (int) R.string.sp_agree_to_terms);
        a2.a((int) R.string.sp_label_terms_of_service).a().b(this.f19913g).c().a((View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                d.this.l.C();
            }
        }).b();
        a2.a((int) R.string.sp_label_privacy_policy).a().b(this.f19913g).c().a((View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                d.this.l.D();
            }
        }).b();
        a2.a(this.f19911e);
    }

    private String getScreenName() {
        return this.i.getClass().getSimpleName();
    }

    private String getTrackPageId() {
        return ((e) this.i).A();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        PhotoProxyActivity_.a(getContext()).d(true).c(true).i((int) R.string.sp_camera_hint_sign_up).a(4);
    }

    public void a(String str) {
        this.h.a(str);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.f19907a.b() && this.f19909c.b() && this.f19910d.b()) {
            String obj = this.f19909c.getText().toString();
            this.h.a(this.q, this.f19907a.getText().toString().trim(), this.r, obj, this.p);
            this.m.b(this.i.getClass().getSimpleName(), "phone");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return !TextUtils.isEmpty(this.f19907a.getText()) || !TextUtils.isEmpty(this.f19909c.getText()) || !TextUtils.isEmpty(this.f19910d.getText());
    }

    public void a(int i2, String str) {
        a(i2);
        q.a((View) this, str);
    }

    public void e() {
        this.k.a();
    }

    public void f() {
        this.k.b();
    }

    public void b(int i2, String str) {
        a(0);
        this.n.a(i2);
        this.n.a(str);
        this.o.b("sign_up", "action_sign_up_success", com.shopee.app.tracking.trackingv3.b.b(str));
        k.b(getContext(), ((e) this.i).j(), str, i2);
    }

    public void g() {
        a(5);
        com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_registered_ask_login, (int) R.string.sp_label_no, (int) R.string.sp_label_yes, (a.C0318a) new a.C0318a() {
            public void onNegative() {
            }

            public void onPositive() {
                d.this.l.b(d.this.q);
                d.this.i.finish();
            }
        });
    }

    public void setAvatar(String str) {
        this.p = str;
        z.a(getContext()).a(str).b(this.f19912f);
    }

    private void a(int i2) {
        com.shopee.app.tracking.a aVar = this.m;
        String trackPageId = getTrackPageId();
        aVar.a(trackPageId, 12, getScreenName() + ".continue", Integer.valueOf(i2), (String) null);
    }

    public void a(boolean z) {
        if (!z) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(this.f19907a.getError())) {
                FormRowValidateError formRowValidateError = (FormRowValidateError) this.f19907a.getTag(R.id.tracking_info_tag);
                if (formRowValidateError != null) {
                    arrayList.add(formRowValidateError);
                }
            }
            if (!TextUtils.isEmpty(this.f19909c.getError())) {
                FormRowValidateError formRowValidateError2 = (FormRowValidateError) this.f19909c.getTag(R.id.tracking_info_tag);
                if (formRowValidateError2 != null) {
                    arrayList.add(formRowValidateError2);
                }
            }
            if (!TextUtils.isEmpty(this.f19910d.getError())) {
                FormRowValidateError formRowValidateError3 = (FormRowValidateError) this.f19910d.getTag(R.id.tracking_info_tag);
                if (formRowValidateError3 != null) {
                    arrayList.add(formRowValidateError3);
                }
            }
            if (!arrayList.isEmpty()) {
                this.m.a(getTrackPageId(), getScreenName(), (List<FormRowValidateError>) arrayList);
            }
        }
    }

    private class b extends com.rengwuxian.materialedittext.a.b {
        b(String str) {
            super(str);
        }

        public boolean a(CharSequence charSequence, boolean z) {
            return !TextUtils.isEmpty(charSequence) && charSequence.toString().equals(d.this.f19909c.getText().toString());
        }
    }

    private static class c extends com.rengwuxian.materialedittext.a.b {
        c(String str) {
            super(str);
        }

        public boolean a(CharSequence charSequence, boolean z) {
            return com.shopee.app.ui.auth.signup.c.a(String.valueOf(charSequence));
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
