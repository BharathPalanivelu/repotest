package com.airpay.paysdk.pay.password;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.airpay.paysdk.base.d.f;
import com.airpay.paysdk.base.ui.weidget.c;
import com.airpay.paysdk.c;
import com.airpay.paysdk.common.net.a.a.a;
import com.airpay.paysdk.pay.password.PasscodeControlView;
import java.lang.ref.WeakReference;

public class b {

    /* renamed from: a  reason: collision with root package name */
    protected WeakReference<Activity> f4246a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public PasscodeControlView f4247b;

    /* renamed from: c  reason: collision with root package name */
    private c.a f4248c;

    /* renamed from: d  reason: collision with root package name */
    private String f4249d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public c f4250e;

    /* renamed from: f  reason: collision with root package name */
    private com.airpay.paysdk.common.net.a.a.b f4251f;

    /* renamed from: g  reason: collision with root package name */
    private com.airpay.paysdk.common.net.a.a.b f4252g;
    private a<VerifyResultFullInfo> h = new a<VerifyResultFullInfo>() {
        public void a(VerifyResultFullInfo verifyResultFullInfo) {
            if (b.this.f4250e != null && !b.this.f4250e.a()) {
                b.this.f4247b.c();
                b.this.f4247b.d();
            }
            VerifyAuthMehodResultInfo a2 = verifyResultFullInfo.a();
            PasswordResultInfo b2 = verifyResultFullInfo.b();
            if (b.this.f4250e != null) {
                b.this.f4250e.a(a2, b2);
            }
        }

        public void a(int i, String str) {
            b.this.f4247b.c();
            b.this.f4247b.d();
            if (i == 111) {
                b.this.b((String) null);
            } else if (i == 113) {
                b.this.d();
            } else if (!(b.this.f4246a == null || b.this.f4246a.get() == null)) {
                com.airpay.paysdk.base.b.a.a().b((Context) b.this.f4246a.get(), str);
            }
            com.airpay.paysdk.common.b.a.d("verify psw error: " + str, new Object[0]);
        }
    };
    private a<InitPasswordResetResultInfo> i = new a<InitPasswordResetResultInfo>() {
        public void a(InitPasswordResetResultInfo initPasswordResetResultInfo) {
            b.this.f4247b.c();
            if (initPasswordResetResultInfo.a() != 1) {
            }
            b.this.c();
        }

        public void a(int i, String str) {
            b.this.f4247b.c();
            if (i == 7) {
                com.airpay.paysdk.common.b.a.d("psw init request forbid : " + str, new Object[0]);
                b.this.c();
                return;
            }
            com.airpay.paysdk.common.b.a.d("psw init request error : " + str, new Object[0]);
            if (b.this.f4246a != null && b.this.f4246a.get() != null) {
                com.airpay.paysdk.base.b.a.a().b((Context) b.this.f4246a.get(), str);
            }
        }
    };

    public b(c cVar) {
        this.f4250e = cVar;
    }

    private Activity b() {
        WeakReference<Activity> weakReference = this.f4246a;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        com.airpay.paysdk.common.b.a.d("activity context null", new Object[0]);
        return null;
    }

    /* access modifiers changed from: private */
    public void c() {
        if (b() != null) {
            b().finish();
        }
    }

    public void a() {
        com.airpay.paysdk.common.net.a.a.b bVar = this.f4251f;
        if (bVar != null) {
            bVar.a();
        }
        com.airpay.paysdk.common.net.a.a.b bVar2 = this.f4252g;
        if (bVar2 != null) {
            bVar2.a();
        }
        PasscodeControlView passcodeControlView = this.f4247b;
        if (passcodeControlView != null) {
            passcodeControlView.b();
        }
    }

    public void a(Activity activity, PasscodeControlView passcodeControlView) {
        this.f4246a = new WeakReference<>(activity);
        this.f4247b = passcodeControlView;
        this.f4247b.setCompleteCallback(new PasscodeControlView.b() {
            public void a(int i) {
            }

            public void a() {
                b bVar = b.this;
                bVar.a(bVar.f4247b.getPassword());
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        this.f4249d = str;
        this.f4247b.a();
        this.f4251f = com.airpay.paysdk.core.a.a().b(str, this.h);
    }

    /* access modifiers changed from: private */
    public void d() {
        Activity b2 = b();
        if (b2 != null) {
            com.airpay.paysdk.pay.ui.a aVar = new com.airpay.paysdk.pay.ui.a(b2);
            aVar.a(c.i.com_garena_beepay_title_exceeded_limit);
            String e2 = com.airpay.paysdk.base.different.a.a().e();
            int i2 = c.i.com_garena_beepay_label_exceeded_limit_call_service;
            aVar.a((CharSequence) f.b((Context) b2, b2.getString(i2, new Object[]{"[" + e2 + "]"})));
            aVar.b();
            aVar.a((View) this.f4247b);
            com.airpay.paysdk.common.b.a.a("showVerifyLimitError ........", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        com.airpay.paysdk.base.ui.weidget.c cVar = new com.airpay.paysdk.base.ui.weidget.c(b());
        cVar.c(c.i.com_garena_beepay_error_incorrect_payment_password);
        if (str != null) {
            cVar.a((CharSequence) str);
        }
        cVar.b(c.i.com_garena_beepay_label_forgot);
        cVar.a(c.i.com_garena_beepay_label_retry);
        this.f4248c = new c.a() {
            public final void onCallBack(boolean z) {
                b.this.a(z);
            }
        };
        cVar.a(this.f4248c);
        cVar.a(this.f4247b, false);
        com.airpay.paysdk.common.b.a.a("showIncorrectPasswordPopup ........", new Object[0]);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(boolean z) {
        if (z) {
            e();
        } else {
            com.airpay.paysdk.common.c.a.a().a(new Runnable() {
                public final void run() {
                    b.this.f();
                }
            }, 1000);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f() {
        this.f4247b.a(true);
    }

    private void e() {
        this.f4247b.a();
        this.f4252g = com.airpay.paysdk.core.a.a().c(this.i);
    }
}
