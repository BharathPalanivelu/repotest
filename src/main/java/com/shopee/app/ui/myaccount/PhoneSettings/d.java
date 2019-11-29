package com.shopee.app.ui.myaccount.PhoneSettings;

import android.text.TextUtils;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.h.r;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.n;
import com.shopee.id.R;

public class d extends q<f> {

    /* renamed from: a  reason: collision with root package name */
    private final n f23242a;

    /* renamed from: c  reason: collision with root package name */
    private final i f23243c;

    /* renamed from: d  reason: collision with root package name */
    private e f23244d = new g() {
        public void onEvent(a aVar) {
            ((f) d.this.f19220b).d();
            ((f) d.this.f19220b).a((UserInfo) aVar.data);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private e f23245e = new g() {
        public void onEvent(a aVar) {
            ((f) d.this.f19220b).d();
            ((f) d.this.f19220b).a(((com.shopee.app.ui.auth.a.a) aVar).a());
        }
    };

    public d(n nVar) {
        this.f23242a = nVar;
        this.f23243c = b.a(this);
    }

    public void a() {
        this.f23243c.a();
        this.f23242a.a("EMAIL_VERIFIED", this.f23244d);
        this.f23242a.a("BIND_ACCOUNT_SUCCESS", this.f23245e);
        this.f23242a.a("UNBIND_ACCOUNT_SUCCESS", this.f23244d);
        this.f23242a.a("LOGIN_USER_INFO_LOAD", this.f23244d);
    }

    public void b() {
        this.f23243c.b();
        this.f23242a.b("EMAIL_VERIFIED", this.f23244d);
        this.f23242a.b("BIND_ACCOUNT_SUCCESS", this.f23245e);
        this.f23242a.b("UNBIND_ACCOUNT_SUCCESS", this.f23244d);
        this.f23242a.b("LOGIN_USER_INFO_LOAD", this.f23244d);
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else {
            int i = aVar.f17892a;
            if (i == -100) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
            } else if (i != 5) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_verification_code_error);
            } else {
                com.shopee.app.f.a.a().f();
                str = com.garena.android.appkit.tools.b.e(R.string.sp_facebook_bind_error);
            }
        }
        ((f) this.f19220b).d();
        r.a().a(str);
    }

    /* access modifiers changed from: package-private */
    public void b(com.shopee.app.network.c.d.a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else if (aVar.f17892a != -100) {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
        } else {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
        }
        ((f) this.f19220b).d();
        r.a().a(str);
    }

    /* access modifiers changed from: package-private */
    public void c(com.shopee.app.network.c.d.a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else {
            int i = aVar.f17892a;
            if (i == -100) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
            } else if (i == 1) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_invalid_email_format);
            } else if (i != 11) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
            } else {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_duplicate_user_name);
            }
        }
        ((f) this.f19220b).d();
        ((f) this.f19220b).b();
        ((f) this.f19220b).a(str);
    }
}
