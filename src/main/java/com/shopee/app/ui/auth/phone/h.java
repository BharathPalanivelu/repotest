package com.shopee.app.ui.auth.phone;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.application.ar;
import com.shopee.app.d.c.t;
import com.shopee.app.data.store.ak;
import com.shopee.app.h.o;
import com.shopee.app.h.r;
import com.shopee.app.network.d.d;
import com.shopee.app.network.d.f.m;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.n;
import com.shopee.id.R;
import io.b.b.b;

public class h extends q<j> {

    /* renamed from: a  reason: collision with root package name */
    private final n f19721a;

    /* renamed from: c  reason: collision with root package name */
    private final i f19722c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f19723d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f19724e;

    /* renamed from: f  reason: collision with root package name */
    private String f19725f;

    /* renamed from: g  reason: collision with root package name */
    private String f19726g;
    private t h;
    private m i;
    private b j;
    private e k = new g() {
        public void onEvent(a aVar) {
            ((j) h.this.f19220b).l();
            com.shopee.app.ui.auth.signup.phone.g gVar = (com.shopee.app.ui.auth.signup.phone.g) aVar;
            com.shopee.app.network.d.i iVar = (com.shopee.app.network.d.i) o.a().f(gVar.f19920a);
            if (iVar != null && iVar.b().equals(h.this.f19723d)) {
                ((j) h.this.f19220b).a(h.this.f19723d, h.this.f19724e, gVar.f19922c);
            }
        }
    };
    private e l = new g() {
        public void onEvent(a aVar) {
            r.a().b((int) R.string.sp_phone_changed);
            ((j) h.this.f19220b).l();
            ((j) h.this.f19220b).a(h.this.f19723d, h.this.f19724e);
        }
    };
    private e m = new g() {
        public void onEvent(a aVar) {
            ((j) h.this.f19220b).l();
            ((j) h.this.f19220b).j();
        }
    };

    public void a(Activity activity) {
    }

    public h(n nVar, t tVar) {
        this.f19721a = nVar;
        this.h = tVar;
        this.f19722c = com.garena.a.a.a.b.a(this);
    }

    public void a(Context context) {
        SmsOtpReceiver.a(context);
    }

    public void a(String str, String str2, String str3, int i2) {
        this.f19723d = str;
        this.f19724e = str2;
        new com.shopee.app.network.d.i(str, str2, str3, i2).g();
        ((j) this.f19220b).k();
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        this.f19723d = str;
        this.f19724e = str2;
        this.f19725f = str3;
        this.f19726g = str4;
        new com.shopee.app.network.d.f.o().a(ak.a(), ar.f().e().deviceStore().d(), str, str2, this.f19725f, this.f19726g, str5, true);
        ((j) this.f19220b).k();
    }

    public void a(String str, String str2, String str3, String str4) {
        this.f19723d = str;
        this.f19724e = str2;
        new d().a(str, str2, str3, str4);
        ((j) this.f19220b).k();
    }

    public void a(String str, Context context, String str2, boolean z, String str3, int i2, boolean z2) {
        ((j) this.f19220b).k();
        this.i = new m(str, str3, i2);
        this.i.a(str2, z, z2);
    }

    public void a() {
        this.f19722c.a();
        this.f19721a.a("PHONE_VERIFY_SUCCESS", this.k);
        this.f19721a.a("BIND_ACCOUNT_SUCCESS", this.l);
        this.f19721a.a("NEW_LOGIN", this.m);
    }

    public void b() {
        this.f19722c.b();
        this.f19721a.b("PHONE_VERIFY_SUCCESS", this.k);
        this.f19721a.b("BIND_ACCOUNT_SUCCESS", this.l);
        this.f19721a.b("NEW_LOGIN", this.m);
        b bVar = this.j;
        if (bVar != null && !bVar.isDisposed()) {
            this.j.dispose();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        ((j) this.f19220b).l();
        com.shopee.app.network.d.i iVar = (com.shopee.app.network.d.i) o.a().f(aVar.f17894c.requestid);
        if (iVar != null && iVar.b().equals(this.f19723d)) {
            int i2 = -1;
            if (!TextUtils.isEmpty(aVar.f17893b)) {
                str = aVar.f17893b;
            } else {
                i2 = aVar.f17892a;
                if (i2 != -100) {
                    str = com.garena.android.appkit.tools.b.e(R.string.sp_verification_code_error);
                } else {
                    iVar.h();
                    str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
                }
            }
            ((j) this.f19220b).b(i2, str);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(com.shopee.app.network.c.d.a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else {
            int i2 = aVar.f17892a;
            if (i2 == -100) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
            } else if (i2 != 4) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_verification_code_error);
            } else {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_need_sign_up);
            }
        }
        ((j) this.f19220b).l();
        ((j) this.f19220b).b(str);
    }

    /* access modifiers changed from: package-private */
    public void c(com.shopee.app.network.c.d.a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else if (aVar.f17892a != -100) {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_verification_code_error);
        } else {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
        }
        ((j) this.f19220b).l();
        ((j) this.f19220b).b(str);
    }

    /* access modifiers changed from: package-private */
    public void a(Pair<String, Boolean> pair) {
        m mVar = this.i;
        if (mVar != null && mVar.i().a().equals(pair.first)) {
            if (((Boolean) pair.second).booleanValue()) {
                ((j) this.f19220b).e();
            }
            ((j) this.f19220b).l();
            ((j) this.f19220b).b();
        }
    }

    /* access modifiers changed from: package-private */
    public void d(com.shopee.app.network.c.d.a aVar) {
        String str;
        m mVar = this.i;
        if (mVar != null && mVar.i().a().equals(aVar.f17894c.requestid)) {
            ((j) this.f19220b).l();
            int i2 = -1;
            if (!TextUtils.isEmpty(aVar.f17893b)) {
                str = aVar.f17893b;
            } else {
                i2 = aVar.f17892a;
                if (i2 == -100) {
                    str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
                } else if (i2 == 1) {
                    str = com.garena.android.appkit.tools.b.e(R.string.sp_invalid_phone_format);
                } else if (i2 == 7) {
                    ((j) this.f19220b).c();
                    return;
                } else if (i2 != 38) {
                    str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
                } else {
                    ((j) this.f19220b).d();
                    return;
                }
            }
            ((j) this.f19220b).a(i2, str);
        }
    }

    public void a(String str) {
        ((j) this.f19220b).a(str);
    }
}
