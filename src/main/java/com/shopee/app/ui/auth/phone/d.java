package com.shopee.app.ui.auth.phone;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.aa;
import com.shopee.app.h.q;
import com.shopee.app.ui.auth.b.b;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.ak;
import com.shopee.app.util.as;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class d extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    MaterialEditText f19704a;

    /* renamed from: b  reason: collision with root package name */
    TextView f19705b;

    /* renamed from: c  reason: collision with root package name */
    ak f19706c;

    /* renamed from: d  reason: collision with root package name */
    bc f19707d;

    /* renamed from: e  reason: collision with root package name */
    b f19708e;

    /* renamed from: f  reason: collision with root package name */
    r f19709f;

    /* renamed from: g  reason: collision with root package name */
    UserInfo f19710g;
    Activity h;
    aa i;
    private final int j;
    private final int k;
    /* access modifiers changed from: private */
    public final int l;
    private final String m;
    /* access modifiers changed from: private */
    public final String n;
    private boolean o = true;

    public d(Context context, int i2, int i3, int i4, String str, String str2) {
        super(context);
        this.j = i2;
        this.k = i3;
        this.l = i4;
        this.m = str;
        this.n = str2;
        ((b) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f19707d.a(this.f19708e);
        this.f19708e.a(this);
        String l2 = this.i.l();
        if (this.f19710g.getUserId() != 0 || !as.b(l2)) {
            l2 = this.f19710g.getUserId() != 0 ? this.f19710g.getPhone() : "";
        }
        if (this.j != 0) {
            this.f19704a.setText(l2);
        }
        this.f19704a.b((com.rengwuxian.materialedittext.a.b) new as.a(com.garena.android.appkit.tools.b.e(R.string.sp_invalid_phone_format)));
        if (this.k != 0) {
            this.f19705b.setVisibility(0);
            this.f19705b.setText(this.k);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Editable editable) {
        if (this.o) {
            this.o = false;
            as.a(getContext(), editable);
            this.o = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        as.a(getContext(), (EditText) this.f19704a);
        if (this.f19704a.b()) {
            String trim = this.f19704a.getText().toString().trim();
            this.f19708e.a(trim);
            int i2 = this.j;
            if (i2 == 0 || i2 == 3) {
                this.f19708e.a(this.n, this.l, this.j == 3);
            } else {
                this.f19708e.b(trim);
            }
        }
    }

    public void a(String str) {
        q.a((View) this, str);
    }

    public void c() {
        a.a(getContext(), (int) R.string.sp_phone_call_otp_popup_msg, (int) R.string.sp_label_cancel, (int) R.string.sp_label_call_me, (a.C0318a) new a.C0318a() {
            public void onNegative() {
            }

            public void onPositive() {
                d.this.f19708e.b(d.this.n, d.this.l);
            }
        });
    }

    public void d() {
        this.f19709f.a();
    }

    public void e() {
        this.f19709f.b();
    }

    public void f() {
        if (this.j == 5) {
            this.f19708e.a(this.n, 2);
        }
    }

    public void g() {
        if (this.j == 5) {
            a(com.garena.android.appkit.tools.b.e(R.string.sp_ban_user_popup_msg));
        }
    }

    public void a(String str, Integer num) {
        int i2 = this.j;
        if (i2 == 0 || i2 == 3) {
            a(com.garena.android.appkit.tools.b.e(R.string.sp_try_another_phone));
        } else if (i2 == 5) {
            this.f19708e.a(num);
        }
    }

    public void b(String str) {
        int i2 = this.j;
        if (i2 == 0) {
            this.f19708e.a(this.n, this.l);
        } else if (i2 == 3) {
            this.f19708e.a(this.n, 1);
        } else if (i2 == 5) {
            a(com.garena.android.appkit.tools.b.e(R.string.sp_need_sign_up));
        }
    }

    public void c(String str) {
        int i2 = this.j;
        if (i2 == 0) {
            a(com.garena.android.appkit.tools.b.e(R.string.sp_try_another_phone));
        } else if (i2 == 3) {
            this.f19708e.a(this.n, 1);
        } else if (i2 == 5) {
            this.f19708e.a(this.n, 2);
        }
    }

    public void d(String str) {
        int i2 = this.j;
        if (i2 == 0) {
            PhoneVerifyActivity_.a(getContext()).b(0).b(this.m).f(this.n).f(this.l).d(this.f19710g.hasPhone() ? R.string.txt_verify_phone_confirm_hidden : R.string.txt_verify_phone_simple).a(false).a(str).a(6);
        } else if (i2 == 3) {
            PhoneVerifyActivity_.a(getContext()).b(6).a(str).f(this.n).f(this.l).a(false).a(12);
        } else if (i2 == 5) {
            PhoneVerifyActivity_.a(getContext()).b(5).a(str).a(false).f(this.n).f(this.l).a(9);
        }
    }

    public void e(String str) {
        int i2 = this.j;
        if (i2 == 0) {
            PhoneVerifyActivity_.a(getContext()).b(0).b(this.m).d((int) R.string.sp_phone_OTP_page_hint).a(false).f(this.n).f(this.l).a(str).b(true).a(6);
        } else if (i2 == 3) {
            PhoneVerifyActivity_.a(getContext()).b(6).a(str).f(this.n).f(this.l).a(false).b(true).a(12);
        } else if (i2 == 5) {
            PhoneVerifyActivity_.a(getContext()).b(5).a(str).f(this.n).f(this.l).a(false).b(true).a(9);
        }
    }
}
