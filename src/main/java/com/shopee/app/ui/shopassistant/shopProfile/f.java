package com.shopee.app.ui.shopassistant.shopProfile;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a.a.d;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.be;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.h.m;
import com.shopee.app.h.q;
import com.shopee.app.ui.auth.IsAuthProxyActivity_;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.photo.PhotoProxyActivity_;
import com.shopee.app.ui.product.common.ShopCoverControl2;
import com.shopee.app.ui.shopassistant.d;
import com.shopee.app.util.ak;
import com.shopee.app.util.as;
import com.shopee.app.util.bc;
import com.shopee.app.util.i;
import com.shopee.app.util.o;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.id.R;
import java.net.URLEncoder;
import java.util.List;

public class f extends FrameLayout {
    private String A;
    private boolean B = false;
    private boolean C = false;

    /* renamed from: a  reason: collision with root package name */
    ImageView f25511a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f25512b;

    /* renamed from: c  reason: collision with root package name */
    MaterialEditText f25513c;

    /* renamed from: d  reason: collision with root package name */
    MaterialEditText f25514d;

    /* renamed from: e  reason: collision with root package name */
    com.shopee.app.ui.setting.cell.a f25515e;

    /* renamed from: f  reason: collision with root package name */
    d f25516f;

    /* renamed from: g  reason: collision with root package name */
    d f25517g;
    r h;
    d i;
    bc j;
    ak k;
    m l;
    ShopCoverControl2 m;
    Activity n;
    View o;
    be p;
    com.shopee.app.ui.actionbar.a q;
    UserInfo r;
    private String s = "-1";
    private String t = "-1";
    private String u = "-1";
    private String v = "-1";
    private boolean w;
    private String x = null;
    private boolean y;
    private boolean z = false;

    /* access modifiers changed from: private */
    public void o() {
    }

    public f(Context context) {
        super(context);
        setId(R.id.edit_profile_root_view);
        ((c) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.j.a(this.i);
        this.i.a(this);
        this.f25513c.b((com.rengwuxian.materialedittext.a.b) new b(com.garena.android.appkit.tools.b.e(R.string.sp_err_nick_name_length)));
        this.f25514d.b((com.rengwuxian.materialedittext.a.b) new a(com.garena.android.appkit.tools.b.e(R.string.sp_err_description_length)));
        this.m.setEditable(true);
        this.m.setOnImageRemoveListener(new ShopCoverControl2.b() {
            public void a() {
                f.this.o();
            }
        });
        this.o.requestFocus();
        this.f25515e.setChecked(this.p.h());
        this.y = this.p.h();
        this.f25515e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f.this.o();
            }
        });
        b(this.r.getPhone(), true);
        a(this.r.getEmail(), true);
        this.f25512b.setLayoutParams(new RelativeLayout.LayoutParams(com.garena.android.appkit.tools.b.b(), (int) (((float) com.garena.android.appkit.tools.b.b()) / 2.28f)));
    }

    public void b() {
        this.i.e();
    }

    /* access modifiers changed from: package-private */
    public void a(TextView textView) {
        o();
    }

    /* access modifiers changed from: package-private */
    public void b(TextView textView) {
        o();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putBoolean("isEditingAvatar", this.w);
        bundle.putString("oldAllInfoString", this.x);
        bundle.putBoolean("oldPostToSeed", this.y);
        bundle.putString("oldAllImages", this.A);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.w = bundle.getBoolean("isEditingAvatar");
            this.x = bundle.getString("oldAllInfoString");
            this.y = bundle.getBoolean("oldPostToSeed");
            this.A = bundle.getString("oldAllImages");
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.w = false;
        PhotoProxyActivity_.a(getContext()).d(true).c(true).e(1).d(2).i((int) R.string.sp_camera_hint_cover).a(1);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.w = true;
        PhotoProxyActivity_.a(getContext()).d(true).c(true).i((int) R.string.sp_camera_hint_sign_up).a(1);
    }

    public void e() {
        if (!a(this.u.equals("-1") ? this.s : this.u, this.v.equals("-1") ? this.t : this.v, this.f25513c.getText().toString().trim(), this.f25514d.getText().toString().trim(), this.m.getImagePaths()).equals(this.x) || this.y != this.f25515e.c()) {
            com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_edit_profile_discard, (int) R.string.sp_label_no_capital, (int) R.string.sp_label_discard, (a.C0318a) new a.C0318a() {
                public void onNegative() {
                }

                public void onPositive() {
                    f.this.n.finish();
                }
            });
        } else {
            this.n.finish();
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.k.J();
    }

    private void p() {
        if (this.u.equals("-1")) {
            z.a(getContext()).a(this.s).a(true).a(this.f25511a);
        }
        if (this.v.equals("-1")) {
            z.c(getContext()).a(this.t).a(this.f25512b);
        }
    }

    public void a(ShopDetail shopDetail) {
        this.s = shopDetail.getPortrait();
        this.t = shopDetail.getCover();
        this.f25513c.setText(shopDetail.getShopName());
        this.f25514d.setText(shopDetail.getDescription());
        if (shopDetail.hasShopCover()) {
            this.m.setCovers(shopDetail.getShopCovers());
        }
        if (this.x == null) {
            this.x = a(this.s, this.t, shopDetail.getShopName(), shopDetail.getDescription(), this.m.getImagePaths());
        }
        b(this.r.getPhone(), shopDetail.isPhoneVerified());
        a(this.r.getEmail(), shopDetail.isEmailVerified());
        p();
    }

    private String a(String str, String str2, String str3, String str4, List<String> list) {
        StringBuilder sb = new StringBuilder();
        String str5 = "empty";
        if (TextUtils.isEmpty(str)) {
            str = str5;
        }
        sb.append(str);
        if (TextUtils.isEmpty(str2)) {
            str2 = str5;
        }
        sb.append(str2);
        if (TextUtils.isEmpty(str3)) {
            str3 = str5;
        }
        sb.append(str3);
        if (TextUtils.isEmpty(str4)) {
            str4 = str5;
        }
        sb.append(str4);
        if (!list.isEmpty()) {
            str5 = com.shopee.app.g.d.a(list);
        }
        sb.append(str5);
        return sb.toString();
    }

    private void q() {
        com.shopee.app.h.r.a().b((int) R.string.sp_label_shop_profile_saved);
        this.n.finish();
        this.p.a(this.f25515e.c());
        this.i.f("https://graph.facebook.com/?id=" + URLEncoder.encode(i.f7041d + this.l.d()) + "&scrape=true&method=post");
    }

    public void g() {
        String str = this.u.equals("-1") ? this.s : this.u;
        String str2 = this.v.equals("-1") ? this.t : this.v;
        String a2 = a(str, str2, this.f25513c.getText().toString().trim(), this.f25514d.getText().toString().trim(), this.m.getImagePaths());
        String str3 = this.x;
        if (str3 == null || str3.equals(a2)) {
            if (this.y != this.f25515e.c()) {
                this.p.a(this.f25515e.c());
            }
            this.n.finish();
            return;
        }
        if (!this.v.equals("-1")) {
            this.t = this.v;
        }
        if (!this.u.equals("-1")) {
            this.s = this.u;
        }
        if (!this.f25513c.b()) {
            com.shopee.app.h.r.a().b((int) R.string.sp_err_nick_name_length);
        } else if (!this.f25514d.b()) {
            com.shopee.app.h.r.a().b((int) R.string.sp_err_description_length);
        } else if (!this.z) {
            this.i.a(str, str2, this.f25513c.getText().toString().trim(), this.f25514d.getText().toString().trim(), this.m.getShopCovers(), this.f25515e.c());
        }
    }

    public void h() {
        this.C = true;
        if (this.B) {
            q();
        }
    }

    public void i() {
        this.B = true;
        if (this.C) {
            q();
        }
    }

    public void j() {
        this.h.a();
    }

    public void a(String str) {
        q.a((View) this, str);
    }

    public void b(String str) {
        this.i.a(this.m.a(str), str);
        this.z = true;
    }

    public void a(String str, String str2) {
        this.i.a(this.m.a(str, str2), str);
        this.z = true;
    }

    public void k() {
        this.z = false;
    }

    public void a(int i2, String str) {
        this.m.a(i2, str);
        o();
    }

    public void c(String str) {
        if (this.w) {
            this.i.g(str);
        } else {
            this.i.h(str);
        }
    }

    public void setAvatar(String str) {
        this.u = str;
        z.a(getContext()).a(str).a(true).b(this.f25511a);
    }

    public void setCover(String str) {
        this.v = str;
        z.c(getContext()).a(str).b(this.f25512b);
    }

    /* access modifiers changed from: package-private */
    public void l() {
        IsAuthProxyActivity_.a(getContext()).b(1).a();
    }

    /* access modifiers changed from: package-private */
    public void m() {
        this.k.S();
    }

    private void a(String str, boolean z2) {
        this.f25517g.setTitle(com.garena.android.appkit.tools.b.e(R.string.sp_email));
        this.f25517g.setIcon(8);
        if (TextUtils.isEmpty(str)) {
            com.a.a.f a2 = com.a.a.f.a(getContext());
            d.a a3 = a2.a();
            a3.a((Object) SQLBuilder.PARENTHESES_LEFT + com.garena.android.appkit.tools.b.e(R.string.sp_label_condition_not_set) + SQLBuilder.PARENTHESES_RIGHT).a().b(com.garena.android.appkit.tools.b.a(R.color.gray_light)).c().b();
            a2.a(SQLBuilder.BLANK).b();
            a2.a().a((Object) com.garena.android.appkit.tools.b.e(R.string.sp_set_now)).a().b(com.garena.android.appkit.tools.b.a(R.color.primary87)).c().b();
            this.f25517g.setSubtitle(a2);
            return;
        }
        String a4 = o.a(str);
        if (z2) {
            this.f25517g.setSubtitle(a4);
            return;
        }
        com.shopee.app.ui.shopassistant.d dVar = this.f25517g;
        dVar.a(a4, "  [" + com.garena.android.appkit.tools.b.e(R.string.sp_verify_now) + "]");
    }

    private void b(String str, boolean z2) {
        this.f25516f.setTitle(com.garena.android.appkit.tools.b.e(R.string.sp_phone));
        this.f25516f.setIcon(8);
        if (TextUtils.isEmpty(str)) {
            com.a.a.f a2 = com.a.a.f.a(getContext());
            d.a a3 = a2.a();
            a3.a((Object) SQLBuilder.PARENTHESES_LEFT + com.garena.android.appkit.tools.b.e(R.string.sp_label_condition_not_set) + SQLBuilder.PARENTHESES_RIGHT).a().b(com.garena.android.appkit.tools.b.a(R.color.gray_light)).c().b();
            a2.a(SQLBuilder.BLANK).b();
            a2.a().a((Object) com.garena.android.appkit.tools.b.e(R.string.sp_set_now)).a().b(com.garena.android.appkit.tools.b.a(R.color.primary87)).c().b();
            this.f25516f.setSubtitle(a2);
            return;
        }
        String d2 = as.d(str);
        if (z2) {
            this.f25516f.setSubtitle(d2);
            return;
        }
        com.shopee.app.ui.shopassistant.d dVar = this.f25516f;
        dVar.setSubtitle(d2 + " [" + com.garena.android.appkit.tools.b.e(R.string.sp_verify_now) + "]");
    }

    private static class b extends com.rengwuxian.materialedittext.a.b {
        public b(String str) {
            super(str);
        }

        public boolean a(CharSequence charSequence, boolean z) {
            String valueOf = String.valueOf(charSequence);
            if (valueOf.isEmpty()) {
                a(com.garena.android.appkit.tools.b.e(R.string.sp_err_nick_name_empty));
                return false;
            } else if (valueOf.length() <= 80) {
                return true;
            } else {
                a(com.garena.android.appkit.tools.b.e(R.string.sp_err_nick_name_length));
                return false;
            }
        }
    }

    private static class a extends com.rengwuxian.materialedittext.a.b {
        public a(String str) {
            super(str);
        }

        public boolean a(CharSequence charSequence, boolean z) {
            return String.valueOf(charSequence).length() <= 500;
        }
    }

    public void n() {
        this.h.b();
    }
}
