package com.shopee.app.ui.auth.b;

import android.text.TextUtils;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.network.d.f.j;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.auth.m;
import com.shopee.app.util.as;
import com.shopee.app.util.n;
import com.shopee.app.util.o;
import com.shopee.id.R;

public class d extends q<m> {

    /* renamed from: a  reason: collision with root package name */
    private final i f19505a = b.a(this);

    /* renamed from: c  reason: collision with root package name */
    private a f19506c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f19507d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f19508e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f19509f = "";

    enum a {
        phone,
        email,
        username
    }

    public d(n nVar) {
    }

    public void a() {
        this.f19505a.a();
    }

    public void b() {
        this.f19505a.b();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        ((m) this.f19220b).g();
        m mVar = (m) this.f19220b;
        a aVar = this.f19506c;
        mVar.a(aVar != null ? aVar.name() : null);
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        int i = aVar.f17892a;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else if (i == 9) {
            ((m) this.f19220b).g();
            ((m) this.f19220b).o();
            return;
        } else if (i == 16) {
            ((m) this.f19220b).g();
            ((m) this.f19220b).n();
            return;
        } else if (i == 25) {
            ((m) this.f19220b).g();
            ((m) this.f19220b).p();
            return;
        } else if (i != 35) {
            str = a(aVar.f17892a);
        } else {
            ((m) this.f19220b).g();
            ((m) this.f19220b).a(this.f19508e, this.f19509f, this.f19507d, aVar.f17894c.m_token);
            return;
        }
        ((m) this.f19220b).g();
        if (!TextUtils.isEmpty(str)) {
            ((m) this.f19220b).b(str);
        }
    }

    /* access modifiers changed from: package-private */
    public String a(int i) {
        if (i == -100) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
        }
        if (i == 2) {
            return f();
        }
        if (i == 4) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_need_sign_up);
        }
        if (i == 9) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_error_account_banned);
        }
        if (i == 12) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_login_error_country_restricted);
        }
        if (i != 13) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
        }
        return com.garena.android.appkit.tools.b.e(R.string.sp_error_account_deleted);
    }

    private String f() {
        if (this.f19506c == a.email) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_failed_email_login);
        }
        if (this.f19506c == a.phone) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_failed_phone_login);
        }
        return com.garena.android.appkit.tools.b.e(R.string.sp_failed_username_login);
    }

    public void a(String str, String str2) {
        if (o.a((CharSequence) str)) {
            ((m) this.f19220b).f();
            this.f19506c = a.email;
            this.f19509f = str;
            new com.shopee.app.network.d.f.d().a(str, str2);
        } else if (str.matches("[a-zA-Z0-9._]*$")) {
            ((m) this.f19220b).f();
            this.f19506c = a.username;
            this.f19508e = str;
            new com.shopee.app.network.d.f.n().a(str, str2);
        } else if (!TextUtils.isEmpty(as.a(str))) {
            ((m) this.f19220b).f();
            this.f19506c = a.phone;
            this.f19507d = str;
            new j().a(str, str2);
        } else {
            ((m) this.f19220b).b(com.garena.android.appkit.tools.b.e(R.string.sp_invalid_login_id));
        }
    }
}
