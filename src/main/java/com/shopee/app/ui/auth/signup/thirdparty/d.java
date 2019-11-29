package com.shopee.app.ui.auth.signup.thirdparty;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.rengwuxian.materialedittext.a.c;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.h.k;
import com.shopee.app.h.q;
import com.shopee.app.h.r;
import com.shopee.app.network.d.bp;
import com.shopee.app.tracking.a;
import com.shopee.app.tracking.f;
import com.shopee.app.tracking.trackingv3.b;
import com.shopee.app.ui.a.e;
import com.shopee.app.ui.photo.PhotoProxyActivity_;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bj;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.id.R;

public class d extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    Activity f19936a;

    /* renamed from: b  reason: collision with root package name */
    c f19937b;

    /* renamed from: c  reason: collision with root package name */
    bc f19938c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f19939d;

    /* renamed from: e  reason: collision with root package name */
    MaterialEditText f19940e;

    /* renamed from: f  reason: collision with root package name */
    EditText f19941f;

    /* renamed from: g  reason: collision with root package name */
    MaterialEditText f19942g;
    TextView h;
    int i;
    Button j;
    ak k;
    SettingConfigStore l;
    a m;
    Activity n;
    b o;
    f p;
    private final String q;
    private final String r;
    private final String s;
    private String t;
    private String u;
    private int v = 0;
    private int w = 0;

    public d(Context context, c cVar, String str, String str2, String str3) {
        super(context);
        this.q = str;
        this.s = str2;
        this.r = str3;
        ((com.shopee.app.ui.auth.signup.b) ((x) context).b()).a(this);
        this.f19937b = cVar;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f19938c.a(this.f19937b);
        this.f19937b.a(this);
        setId(R.id.fb_registration);
        this.f19937b.a(this.r);
        if (!TextUtils.isEmpty(this.s)) {
            this.f19940e.setVisibility(0);
            this.f19940e.setText(this.s);
        }
        this.f19937b.e();
        a(this.q, "", 0, 0);
        com.a.a.f a2 = com.a.a.f.a(getContext(), (int) R.string.sp_agree_to_terms);
        a2.a((int) R.string.sp_label_terms_of_service).a().b(this.i).c().a((View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                d.this.k.C();
            }
        }).b();
        a2.a((int) R.string.sp_label_privacy_policy).a().b(this.i).c().a((View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                d.this.k.D();
            }
        }).b();
        a2.a(this.h);
        this.f19942g.b((com.rengwuxian.materialedittext.a.b) new c(com.garena.android.appkit.tools.b.e(R.string.sp_invalid_email), "^[A-Za-z0-9._%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,10}$"));
        bj.a((View) this.j, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                d.this.c();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void b() {
        PhotoProxyActivity_.a(getContext()).d(true).c(true).i((int) R.string.sp_camera_hint_sign_up).a(4);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putString("avatarId", this.t);
        bundle.putString("coverId", this.u);
        bundle.putInt("genderCode", this.v);
        bundle.putInt("birthdayStamp", this.w);
        return bundle;
    }

    public void setCoverId(String str) {
        this.u = str;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            Parcelable parcelable2 = bundle.getParcelable("superState");
            this.t = bundle.getString("avatarId");
            this.u = bundle.getString("coverId");
            this.v = bundle.getInt("genderCode");
            this.w = bundle.getInt("birthdayStamp");
            z.a(getContext()).a(this.t).b(this.f19939d);
            parcelable = parcelable2;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void a(String str) {
        this.f19937b.b(str);
    }

    /* access modifiers changed from: private */
    public void c() {
        String obj = this.f19941f.getText().toString();
        if (!com.shopee.app.ui.auth.signup.c.a(obj)) {
            b(com.garena.android.appkit.tools.b.e(R.string.sp_error_user_name_format));
        } else if (TextUtils.isEmpty(this.f19942g.getText().toString()) || this.f19942g.b()) {
            this.f19937b.a(obj, this.t, this.f19942g.getText().toString(), this.u);
            this.m.b(this.n.getClass().getSimpleName(), "facebook");
        } else {
            b(com.garena.android.appkit.tools.b.e(R.string.sp_invalid_email));
        }
    }

    public void a(String str, String str2, int i2, int i3) {
        this.f19941f.setText(str);
        if (!TextUtils.isEmpty(str2)) {
            this.f19942g.setText(str2);
        }
        this.v = i2;
        this.w = i3;
    }

    public void b(String str) {
        r.a().a(str);
    }

    public void c(String str) {
        q.a((View) this, str);
    }

    public void d(String str) {
        this.t = str;
        z.a(getContext()).a(this.t).b(this.f19939d);
    }

    public void a(int i2, String str) {
        if (!(this.v == 0 || this.w == 0)) {
            new bp().a(this.v, this.w);
        }
        b(i2, str);
        this.f19936a.setResult(-1);
        ((Activity) getContext()).finish();
    }

    public void b(int i2, String str) {
        this.p.a(i2);
        this.p.a(str);
        this.o.b("sign_up", "action_sign_up_success", b.b(str));
        k.b(getContext(), ((e) this.f19936a).j(), str, i2);
    }
}
