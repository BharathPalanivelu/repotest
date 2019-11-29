package com.shopee.app.ui.home.me.editprofile;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.f;
import com.garena.android.appkit.tools.b;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.h.m;
import com.shopee.app.h.q;
import com.shopee.app.ui.auth.IsAuthProxyActivity_;
import com.shopee.app.ui.auth.signup.c;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.home.me.editprofile.bio.EditProfileBioActivity_;
import com.shopee.app.ui.photo.PhotoProxyActivity_;
import com.shopee.app.util.ak;
import com.shopee.app.util.as;
import com.shopee.app.util.bc;
import com.shopee.app.util.i;
import com.shopee.app.util.o;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.id.R;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.net.URLEncoder;
import java.util.Calendar;

public class h extends FrameLayout {
    private static CharSequence[] H = new CharSequence[3];
    private boolean A = false;
    private boolean B;
    private String C = null;
    private boolean D = false;
    private ShopDetail E;
    private String F;
    private String G;

    /* renamed from: a  reason: collision with root package name */
    ImageView f22381a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f22382b;

    /* renamed from: c  reason: collision with root package name */
    MaterialEditText f22383c;

    /* renamed from: d  reason: collision with root package name */
    r f22384d;

    /* renamed from: e  reason: collision with root package name */
    f f22385e;

    /* renamed from: f  reason: collision with root package name */
    bc f22386f;

    /* renamed from: g  reason: collision with root package name */
    ak f22387g;
    m h;
    Activity i;
    View j;
    EditProfileItemView k;
    EditProfileItemView l;
    EditProfileItemView m;
    EditText n;
    EditText o;
    EditProfileItemView p;
    EditProfileItemView q;
    EditProfileItemView r;
    EditProfileItemView s;
    UserInfo t;
    SettingConfigStore u;
    private String v = "-1";
    private String w = "-1";
    private String x = "-1";
    private String y = "-1";
    private boolean z = false;

    public h(Context context) {
        super(context);
        setId(R.id.edit_profile_root_view);
        ((d) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f22386f.a(this.f22385e);
        this.f22385e.a(this);
        this.f22382b.setLayoutParams(new RelativeLayout.LayoutParams(b.b(), (int) ((((float) b.b()) * 1.2f) / 2.5f)));
        this.f22383c.b((com.rengwuxian.materialedittext.a.b) new a(b.e(R.string.sp_error_user_name_format)));
        Typeface a2 = com.devspark.robototextview.b.a(getContext(), 0, 0, 0);
        v();
        com.devspark.robototextview.b.a((TextView) this.f22383c, a2);
        this.n.setTag(0);
        this.j.requestFocus();
        setGenderText(0);
        setBirthdayText((Integer) null);
        b(this.t.getPhone(), true);
        a(this.t.getEmail(), true);
    }

    public void b() {
        this.f22385e.e();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putBoolean("isEditingAvatar", this.B);
        bundle.putString("avatarId", this.v);
        bundle.putString("coverId", this.w);
        bundle.putBoolean("isShopInfoSet", this.z);
        bundle.putBoolean("isUserInfoSet", this.A);
        bundle.putString("newCoverId", this.y);
        bundle.putString("newAvatarId", this.x);
        bundle.putString("oldAllInfoString", this.C);
        bundle.putBoolean("allowEditUserName", this.D);
        bundle.putString("bio", this.F);
        bundle.putString("mName", this.G);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.B = bundle.getBoolean("isEditingAvatar");
            this.v = bundle.getString("avatarId");
            this.w = bundle.getString("coverId");
            this.z = bundle.getBoolean("isShopInfoSet");
            this.A = bundle.getBoolean("isUserInfoSet");
            this.y = bundle.getString("newCoverId");
            this.x = bundle.getString("newAvatarId");
            this.C = bundle.getString("oldAllInfoString");
            this.D = bundle.getBoolean("allowEditUserName");
            this.F = bundle.getString("bio");
            this.G = bundle.getString("mName");
            parcelable = bundle.getParcelable("superState");
            u();
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.B = false;
        PhotoProxyActivity_.a(getContext()).d(true).c(true).e(1).d(2).i((int) R.string.sp_camera_hint_cover).a(1);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.B = true;
        PhotoProxyActivity_.a(getContext()).d(true).c(true).i((int) R.string.sp_camera_hint_sign_up).a(1);
    }

    static {
        H[0] = b.e(R.string.sp_male);
        H[1] = b.e(R.string.sp_female);
        H[2] = b.e(R.string.sp_gender_other);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        if (z2) {
            s();
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        s();
    }

    private void s() {
        com.shopee.app.ui.dialog.a.a(getContext(), this.o.getTag() != null ? ((long) ((Integer) this.o.getTag()).intValue()) * 1000 : 0, (DatePicker.OnDateChangedListener) new DatePicker.OnDateChangedListener() {
            public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
                if (datePicker.isShown()) {
                    Calendar instance = Calendar.getInstance();
                    instance.set(i, i2, i3);
                    if (instance.getTimeInMillis() < com.garena.android.appkit.tools.a.a.b()) {
                        h.this.setBirthdayText(Integer.valueOf((int) (instance.getTimeInMillis() / 1000)));
                    } else {
                        h.this.b(b.e(R.string.sp_birthday_invalid));
                    }
                }
            }
        }, (f.b) new f.b() {
            public void onNegative(f fVar) {
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void f() {
        t();
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z2) {
        if (z2) {
            t();
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (TextUtils.isEmpty(this.F)) {
            this.F = "";
        }
        EditProfileBioActivity_.a(getContext()).a(this.F).e(R.string.sp_feed_bio_error).d(500).b(0).f(R.string.sp_edit_profile).a((int) IjkMediaMeta.FF_PROFILE_H264_HIGH_444_INTRA);
    }

    /* access modifiers changed from: package-private */
    public void h() {
        if (TextUtils.isEmpty(this.G)) {
            this.G = "";
        }
        EditProfileBioActivity_.a(getContext()).a(this.G).e(R.string.sp_edit_name_error).c(R.string.sp_hint_for_edit_name).d(this.u.getProfileNickNameMaxLength()).b(1).f(R.string.sp_title_edit_name).a(2291);
    }

    /* access modifiers changed from: package-private */
    public void i() {
        IsAuthProxyActivity_.a(getContext()).b(2).a();
    }

    /* access modifiers changed from: package-private */
    public void j() {
        IsAuthProxyActivity_.a(getContext()).b(1).a();
    }

    /* access modifiers changed from: package-private */
    public void k() {
        this.f22387g.S();
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.f22387g.T();
    }

    private void t() {
        com.shopee.app.ui.dialog.a.a(getContext(), b.e(R.string.sp_gender), H, (a.c) new a.c() {
            public void a(f fVar, View view, int i, CharSequence charSequence) {
                int i2 = 1;
                if (i != 0) {
                    i2 = i != 1 ? 10 : 2;
                }
                h.this.setGenderText(i2);
            }
        });
    }

    /* access modifiers changed from: private */
    public void setGenderText(int i2) {
        String str;
        if (i2 == 1) {
            str = H[0].toString();
        } else if (i2 == 2) {
            str = H[1].toString();
        } else if (i2 != 10) {
            str = "";
            i2 = 0;
        } else {
            str = H[2].toString();
        }
        this.p.setValueAndActionBtnVisibility(str);
        this.p.setTag(Integer.valueOf(i2));
        this.n.setText(str);
        this.n.setTag(Integer.valueOf(i2));
    }

    public void a(String str) {
        if (this.B) {
            this.f22385e.a(str);
        } else {
            this.f22385e.b(str);
        }
    }

    public void m() {
        if (a(this.x.equals("-1") ? this.v : this.x, this.y.equals("-1") ? this.w : this.y, this.n.getText().toString(), this.o.getText().toString(), this.F, this.G).equals(this.C)) {
            this.i.finish();
        } else {
            com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_edit_profile_discard, (int) R.string.sp_label_no_capital, (int) R.string.sp_label_discard, (a.C0318a) new a.C0318a() {
                public void onNegative() {
                }

                public void onPositive() {
                    h.this.i.finish();
                }
            });
        }
    }

    private void u() {
        if (this.x.equals("-1")) {
            z.a(getContext()).a(this.v).a(true).a(this.f22381a);
        }
        if (this.y.equals("-1")) {
            z.c(getContext()).a(this.w).a(b.a(R.color.black40)).a(this.f22382b);
        }
    }

    public void a(ShopDetail shopDetail) {
        this.E = shopDetail;
        this.G = this.t.getNickname();
        this.F = shopDetail.getDescription();
        this.v = shopDetail.getPortrait();
        this.w = shopDetail.getCover();
        this.f22383c.setText(shopDetail.getUserName());
        if (shopDetail.allowUserChangeName()) {
            this.D = true;
            this.f22383c.setEnabled(true);
            this.f22383c.setFocusable(true);
            this.f22383c.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    if (z) {
                        com.shopee.app.ui.dialog.a.a(h.this.getContext(), b.e(R.string.sp_edit_username_reminder), b.e(R.string.sp_label_cancel), b.e(R.string.sp_label_continue), (a.C0318a) new a.C0318a() {
                            public void onPositive() {
                            }

                            public void onNegative() {
                                h.this.j.requestFocus();
                            }
                        });
                    }
                }
            });
        } else {
            this.D = false;
            this.f22383c.setEnabled(false);
            this.f22383c.setFocusable(false);
        }
        setGenderText(shopDetail.getGender());
        setBirthdayText(shopDetail.getBirthdayTimeStamp());
        b(this.t.getPhone(), shopDetail.isPhoneVerified());
        a(this.t.getEmail(), shopDetail.isEmailVerified());
        setBioText(this.F);
        setNameText(this.G);
        v();
        u();
        if (this.C == null) {
            this.C = a(shopDetail.getPortrait(), shopDetail.getCover(), this.n.getText().toString(), this.o.getText().toString(), this.F, this.G);
        }
    }

    private void setBioText(String str) {
        if (this.t.canPostFeed()) {
            this.l.setVisibility(0);
            this.l.setValueAndActionBtnVisibility(str);
            return;
        }
        this.l.setVisibility(8);
    }

    private void setNameText(String str) {
        this.k.setVisibility(0);
        this.k.setValueAndActionBtnVisibility(str);
    }

    private void v() {
        if (this.t.hasPassword()) {
            this.m.setTitle(b.e(R.string.sp_change_password));
        } else {
            this.m.setTitle(b.e(R.string.sp_label_set_password));
        }
    }

    private void a(String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            this.s.setAction(b.e(R.string.sp_set_now));
            this.s.setValueAndActionBtnVisibility("");
            return;
        }
        String a2 = o.a(str);
        if (z2) {
            this.s.setValueAndActionBtnVisibility(a2);
            return;
        }
        this.s.setAction(b.e(R.string.sp_verify_now));
        this.s.a(a2, 0);
    }

    private void b(String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            this.r.setAction(b.e(R.string.sp_set_now));
            this.r.setValueAndActionBtnVisibility("");
            return;
        }
        String d2 = as.d(str);
        if (z2) {
            this.r.setValueAndActionBtnVisibility(d2);
            return;
        }
        this.r.setAction(b.e(R.string.sp_verify_now));
        this.r.a(d2, 0);
    }

    /* access modifiers changed from: private */
    public void setBirthdayText(Integer num) {
        if (num != null) {
            String c2 = com.garena.android.appkit.tools.a.a.c(num.intValue(), "ID");
            this.o.setText(c2);
            this.o.setTag(num);
            this.q.setValueAndActionBtnVisibility(c2);
            this.q.setTag(num);
            return;
        }
        this.q.setValueAndActionBtnVisibility("");
    }

    private String a(String str, String str2, String str3, String str4, String str5, String str6) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            str = "empty";
        }
        sb.append(str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "empty";
        }
        sb.append(str2);
        if (TextUtils.isEmpty(str3)) {
            str3 = "empty";
        }
        sb.append(str3);
        if (TextUtils.isEmpty(str4)) {
            str4 = "empty";
        }
        sb.append(str4);
        if (TextUtils.isEmpty(str5)) {
            str5 = "empty";
        }
        sb.append(str5);
        if (TextUtils.isEmpty(str6)) {
            str6 = "empty";
        }
        sb.append(str6);
        return sb.toString();
    }

    public void n() {
        this.A = true;
        if (this.z) {
            w();
        }
    }

    public void o() {
        this.z = true;
        if (this.A) {
            w();
        }
    }

    private void w() {
        com.shopee.app.h.r.a().b((int) R.string.sp_label_profile_saved);
        this.i.finish();
        String encode = URLEncoder.encode(i.f7041d + this.h.d());
        this.f22385e.c("https://graph.facebook.com/?id=" + encode + "&scrape=true&method=post");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Integer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void p() {
        /*
            r10 = this;
            r0 = 0
            r10.z = r0
            r10.A = r0
            com.rengwuxian.materialedittext.MaterialEditText r0 = r10.f22383c
            boolean r0 = r0.b()
            if (r0 != 0) goto L_0x0018
            com.shopee.app.h.r r0 = com.shopee.app.h.r.a()
            r1 = 2131887962(0x7f12075a, float:1.9410546E38)
            r0.b((int) r1)
            return
        L_0x0018:
            java.lang.String r0 = r10.y
            java.lang.String r1 = "-1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0026
            java.lang.String r0 = r10.y
            r10.w = r0
        L_0x0026:
            java.lang.String r0 = r10.x
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0032
            java.lang.String r0 = r10.x
            r10.v = r0
        L_0x0032:
            boolean r0 = r10.D
            r1 = 0
            if (r0 == 0) goto L_0x0043
            com.rengwuxian.materialedittext.MaterialEditText r0 = r10.f22383c
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            r5 = r0
            goto L_0x0044
        L_0x0043:
            r5 = r1
        L_0x0044:
            android.widget.EditText r0 = r10.o
            java.lang.Object r0 = r0.getTag()
            if (r0 != 0) goto L_0x004d
            goto L_0x0056
        L_0x004d:
            android.widget.EditText r0 = r10.o
            java.lang.Object r0 = r0.getTag()
            r1 = r0
            java.lang.Integer r1 = (java.lang.Integer) r1
        L_0x0056:
            r7 = r1
            com.shopee.app.ui.home.me.editprofile.f r2 = r10.f22385e
            java.lang.String r3 = r10.v
            java.lang.String r4 = r10.w
            android.widget.EditText r0 = r10.n
            java.lang.Object r0 = r0.getTag()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r6 = r0.intValue()
            java.lang.String r8 = r10.F
            java.lang.String r9 = r10.G
            r2.a(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.home.me.editprofile.h.p():void");
    }

    public void setAvatar(String str) {
        this.x = str;
        z.a(getContext()).a(str).a(true).b(this.f22381a);
    }

    public void setCover(String str) {
        this.y = str;
        z.c(getContext()).a(str).b(this.f22382b);
    }

    public void q() {
        this.f22384d.a();
    }

    public void b(String str) {
        q.a((View) this, str);
    }

    public void a(UserInfo userInfo) {
        this.t = userInfo;
        ShopDetail shopDetail = this.E;
        if (shopDetail != null) {
            a(shopDetail);
        }
    }

    public void c(String str) {
        this.F = str;
        setBioText(this.F);
    }

    public void d(String str) {
        this.G = str;
        setNameText(this.G);
    }

    private static class a extends com.rengwuxian.materialedittext.a.b {
        public a(String str) {
            super(str);
        }

        public boolean a(CharSequence charSequence, boolean z) {
            return c.a(String.valueOf(charSequence));
        }
    }

    public void r() {
        this.f22384d.b();
    }
}
