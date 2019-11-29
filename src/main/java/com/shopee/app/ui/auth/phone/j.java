package com.shopee.app.ui.auth.phone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.f;
import com.garena.android.appkit.f.f;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.h.q;
import com.shopee.app.tracking.g;
import com.shopee.app.ui.a.e;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.ak;
import com.shopee.app.util.as;
import com.shopee.app.util.bc;
import com.shopee.app.util.bj;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class j extends FrameLayout {
    public static int n;
    private boolean A = false;

    /* renamed from: a  reason: collision with root package name */
    MaterialEditText f19743a;

    /* renamed from: b  reason: collision with root package name */
    TextView f19744b;

    /* renamed from: c  reason: collision with root package name */
    Button f19745c;

    /* renamed from: d  reason: collision with root package name */
    View f19746d;

    /* renamed from: e  reason: collision with root package name */
    h f19747e;

    /* renamed from: f  reason: collision with root package name */
    bc f19748f;

    /* renamed from: g  reason: collision with root package name */
    ak f19749g;
    r h;
    Activity i;
    UserInfo j;
    Button k;
    com.shopee.app.tracking.a l;
    SettingConfigStore m;
    private final String o;
    private final String p;
    private final boolean q;
    private final int r;
    /* access modifiers changed from: private */
    public boolean s;
    /* access modifiers changed from: private */
    public String t;
    /* access modifiers changed from: private */
    public final String u;
    private final String v;
    /* access modifiers changed from: private */
    public final int w;
    private final int x;
    private final int y;
    /* access modifiers changed from: private */
    public final String z;

    public j(Context context, String str, int i2, int i3, int i4, String str2, String str3, String str4, String str5, boolean z2, boolean z3, String str6, int i5) {
        super(context);
        ((com.shopee.app.ui.auth.b.b) ((x) context).b()).a(this);
        this.f19747e.a(context);
        this.u = str;
        this.x = i2;
        this.r = i4;
        this.y = i3;
        this.v = str2;
        this.w = i5;
        this.z = str3;
        this.o = str4;
        this.p = str5;
        this.q = z2;
        this.s = z3;
        this.t = str6;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        String str;
        this.f19748f.a(this.f19747e);
        this.f19747e.a(this);
        this.f19743a.b((com.rengwuxian.materialedittext.a.b) new b(com.garena.android.appkit.tools.b.e(R.string.sp_error_empty_verification_)));
        if (this.y != 0) {
            String d2 = as.d(this.u);
            int i2 = this.y;
            switch (i2) {
                case R.string.sp_phone_OTP_page_hint:
                case R.string.txt_verify_phone_confirm:
                case R.string.txt_verify_phone_identity:
                case R.string.txt_verify_phone_simple:
                    str = com.garena.android.appkit.tools.b.a(i2, d2);
                    break;
                default:
                    str = com.garena.android.appkit.tools.b.e(i2);
                    break;
            }
            this.f19744b.setVisibility(0);
            this.f19744b.setText(str);
        }
        int i3 = this.r;
        if (i3 != 0) {
            this.k.setText(i3);
        }
        if (this.q) {
            m();
        } else {
            n = com.garena.android.appkit.tools.a.a.a();
            a(com.garena.android.appkit.tools.a.a.a());
        }
        if (this.s) {
            this.f19745c.setText(R.string.sp_label_call_again);
        }
        if (this.t.equals("seed_login") || this.t.equals("seed_change_password")) {
            this.f19746d.setVisibility(0);
        } else {
            this.f19746d.setVisibility(8);
        }
        bj.a((View) this.k, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                j.this.n();
            }
        });
        post(new Runnable() {
            public void run() {
                j.this.f19747e.a(j.this.i);
            }
        });
    }

    private String getScreenName() {
        return this.i.getClass().getSimpleName();
    }

    private String getTrackPageId() {
        return ((e) this.i).A();
    }

    private void m() {
        int a2 = com.garena.android.appkit.tools.a.a.a();
        int i2 = n;
        if ((i2 == 0 || a2 - i2 > 30) && TextUtils.isEmpty(this.z)) {
            this.f19747e.a(this.u, getContext(), "", this.s, this.t, this.w, false);
        } else {
            a(a2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        int i3 = 30 - (i2 - n);
        a aVar = new a(i3);
        aVar.c();
        aVar.a(i3);
        f.a().a(aVar);
    }

    public void b() {
        n = com.garena.android.appkit.tools.a.a.a();
        a aVar = new a(30);
        aVar.c();
        aVar.a(30);
        f.a().a(aVar);
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.A = true;
            this.f19743a.setText(str);
        }
    }

    public void c() {
        a(16, ".continue", 7);
        com.shopee.app.ui.dialog.a.a(getContext(), 0, (int) R.string.sp_v_code_login_session_expire, 0, (int) R.string.button_ok, (f.b) new f.b() {
            public void onPositive(com.afollestad.materialdialogs.f fVar) {
                j.this.i.finish();
                j.n = 0;
            }

            public void onNegative(com.afollestad.materialdialogs.f fVar) {
                super.onNegative(fVar);
            }
        }, false);
    }

    public void d() {
        com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_phone_call_otp_popup_msg, (int) R.string.sp_label_cancel, (int) R.string.sp_label_call_me, (a.C0318a) new a.C0318a() {
            public void onPositive() {
                j.this.f19747e.a(j.this.u, j.this.getContext(), j.this.z, true, j.this.t, j.this.w, false);
            }

            public void onNegative() {
                j.this.i.finish();
            }
        });
    }

    public void e() {
        this.s = true;
        String d2 = as.d(this.u);
        this.f19744b.setVisibility(0);
        this.f19744b.setText(com.garena.android.appkit.tools.b.a(R.string.sp_phone_OTP_page_hint, d2));
    }

    public void f() {
        this.f19747e.a(this.i);
    }

    private class a extends com.garena.android.appkit.f.a {

        /* renamed from: c  reason: collision with root package name */
        private int f19755c = 0;

        /* renamed from: d  reason: collision with root package name */
        private Button f19756d;

        protected a(int i) {
            a(i);
        }

        public void a(int i) {
            this.f19755c = i;
            this.f19756d = j.this.f19745c;
            if (i > 0) {
                this.f19756d.setEnabled(false);
            }
        }

        /* access modifiers changed from: protected */
        public void a() {
            Button button = this.f19756d;
            if (button != null) {
                int i = this.f19755c;
                if (i <= 0) {
                    button.setEnabled(true);
                    if (j.this.s) {
                        this.f19756d.setText(com.garena.android.appkit.tools.b.e(R.string.sp_label_call_again));
                    } else {
                        this.f19756d.setText(com.garena.android.appkit.tools.b.e(R.string.sp_label_resend));
                    }
                } else {
                    this.f19755c = i - 1;
                    String str = com.garena.android.appkit.tools.b.e(R.string.sp_label_resend) + SQLBuilder.PARENTHESES_LEFT + i + SQLBuilder.PARENTHESES_RIGHT;
                    if (j.this.s) {
                        str = com.garena.android.appkit.tools.b.e(R.string.sp_label_call_again) + SQLBuilder.PARENTHESES_LEFT + i + SQLBuilder.PARENTHESES_RIGHT;
                    }
                    this.f19756d.setText(str);
                    this.f19756d.postDelayed(this, 1000);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void n() {
        if (this.f19743a.b()) {
            String str = this.u;
            int i2 = this.x;
            if (i2 == 0) {
                this.f19747e.a(str, this.f19743a.getText().toString().trim(), this.v, this.t);
            } else if (i2 != 5) {
                this.f19747e.a(str, this.f19743a.getText().toString().trim(), this.t, this.w);
            } else {
                this.f19747e.a(str, this.f19743a.getText().toString().trim(), this.o, this.p, this.t);
            }
            this.l.e(this.i.getClass().getSimpleName());
        } else if ("seed_signup".equals(this.t)) {
            this.l.a(getTrackPageId(), getScreenName(), "otp", String.valueOf(g.WRONG_FORMAT_OTP.getValue()));
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        this.f19747e.a(this.u, getContext(), this.z, this.s, this.t, this.w, true);
    }

    /* access modifiers changed from: package-private */
    public void h() {
        this.f19749g.t("OTP");
    }

    /* access modifiers changed from: package-private */
    public void i() {
        this.f19749g.t("MOBILE_NO_CHANGE");
    }

    public void j() {
        this.i.setResult(-1);
        this.i.finish();
        n = 0;
    }

    public void a(String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.putExtra("phoneNumber", str);
        intent.putExtra("verifyCode", str2);
        intent.putExtra("otpToken", str3);
        intent.putExtra("otpAutoFill", this.A);
        this.i.setResult(-1, intent);
        this.i.finish();
        n = 0;
    }

    public void a(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("phoneNumber", str);
        intent.putExtra("verifyCode", str2);
        this.i.setResult(-1, intent);
        this.i.finish();
        n = 0;
    }

    private static class b extends com.rengwuxian.materialedittext.a.b {
        b(String str) {
            super(str);
        }

        public boolean a(CharSequence charSequence, boolean z) {
            return charSequence.length() > 0 && charSequence.length() <= 16;
        }
    }

    public void b(String str) {
        q.a((View) this, str);
    }

    public void k() {
        this.h.a();
    }

    public void l() {
        this.h.b();
    }

    public void a(int i2, String str) {
        a(15, "", i2);
        b(str);
    }

    public void b(int i2, String str) {
        a(16, ".continue", i2);
        b(str);
    }

    private void a(int i2, String str, int i3) {
        if ("seed_signup".equals(this.t)) {
            com.shopee.app.tracking.a aVar = this.l;
            String trackPageId = getTrackPageId();
            aVar.a(trackPageId, i2, getScreenName() + str, Integer.valueOf(i3), (String) null);
        }
    }
}
