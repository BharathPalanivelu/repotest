package com.shopee.app.ui.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.auth.b.a;
import com.shopee.app.ui.auth.password.CheckPasswordActivity_;
import com.shopee.app.ui.auth.password.SetNewPasswordActivity_;
import com.shopee.app.ui.auth.phone.PhoneAskActivity_;
import com.shopee.app.ui.auth.phone.PhoneVerifyActivity_;
import com.shopee.app.ui.setting.account.SingleEntrySettingActivity_;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class h extends b implements x<com.shopee.app.ui.auth.b.b> {

    /* renamed from: a  reason: collision with root package name */
    int f19536a;

    /* renamed from: b  reason: collision with root package name */
    String f19537b;

    /* renamed from: c  reason: collision with root package name */
    UserInfo f19538c;

    /* renamed from: d  reason: collision with root package name */
    boolean f19539d = false;

    /* renamed from: e  reason: collision with root package name */
    private com.shopee.app.ui.auth.b.b f19540e;

    /* renamed from: f  reason: collision with root package name */
    private String f19541f = null;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            l();
        }
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) new RelativeLayout(this));
    }

    private void l() {
        int i = 0;
        if (this.f19538c.hasPassword()) {
            if (!this.f19538c.hasPhone()) {
                int i2 = this.f19536a;
                if (i2 != 0) {
                    if (i2 != 2) {
                        CheckPasswordActivity_.a(this).a(1772);
                    } else {
                        CheckPasswordActivity_.a(this).a(1773);
                    }
                } else if (this.f19539d) {
                    PhoneAskActivity_.a(this).b(0).b("seed_bind_phone").d(0).a(1723);
                } else {
                    CheckPasswordActivity_.a(this).a(1772);
                }
            } else if (this.f19536a != 1) {
                CheckPasswordActivity_.a(this).a(1773);
            } else {
                CheckPasswordActivity_.a(this).a(1772);
            }
        } else if (this.f19538c.hasPhone()) {
            String str = null;
            int i3 = this.f19536a;
            if (i3 == 0) {
                str = "seed_bind_phone";
            } else if (i3 == 1) {
                str = "seed_bind_email";
            } else if (i3 == 2) {
                str = "seed_change_password";
            }
            int i4 = this.f19536a;
            if (!(i4 == 0 || i4 == 1 || i4 != 2)) {
                i = 21;
            }
            PhoneVerifyActivity_.a(this).d((int) R.string.txt_verify_phone_identity).b(6).f(i).a(this.f19538c.getPhone()).f(str).a(1821);
        } else {
            int i5 = this.f19536a;
            if (i5 == 0) {
                PhoneAskActivity_.a(this).b(0).b("seed_bind_phone").d(0).a(1723);
            } else if (i5 == 1) {
                PhoneAskActivity_.a(this).b(0).b("seed_bind_email").d(0).a(1725);
            } else if (i5 != 2) {
                PhoneAskActivity_.a(this).c(R.string.sp_verify_phone_tip).b(0).b("seed_bind_phone").d(0).a(1725);
            } else {
                PhoneAskActivity_.a(this).b(0).b("seed_change_password").d(21).a(1725);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i, String str) {
        if (i == -1) {
            this.f19541f = str;
            int i2 = this.f19536a;
            if (i2 == 0) {
                PhoneVerifyActivity_.a(this).d((int) R.string.txt_verify_phone_identity).b(6).a(this.f19538c.getPhone()).f("seed_bind_phone").f(0).a(1821);
            } else if (i2 != 2) {
                PhoneVerifyActivity_.a(this).b(6).a(this.f19538c.getPhone()).a(1821);
            } else if (this.f19538c.hasPhone()) {
                PhoneVerifyActivity_.a(this).d((int) R.string.txt_verify_phone_confirm).b(6).a(this.f19538c.getPhone()).f("seed_change_password").f(21).a(1821);
            } else {
                PhoneAskActivity_.a(this).b(0).b("seed_change_password").d(21).a(1725);
            }
        } else {
            finish();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i, String str) {
        if (i == -1) {
            int i2 = this.f19536a;
            if (i2 == 0) {
                PhoneAskActivity_.a(this).b(0).b("seed_bind_phone").d(0).a(1723);
            } else if (i2 == 1) {
                SingleEntrySettingActivity_.a(this).b(0).a(5);
            } else if (i2 != 2) {
                finish();
            } else {
                SetNewPasswordActivity_.a(this).c(str).a(2);
            }
        } else {
            finish();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i, String str, String str2, String str3) {
        if (i == -1) {
            int i2 = this.f19536a;
            if (i2 == 0) {
                PhoneAskActivity_.a(this).a(str3).b(0).b("seed_bind_phone").d(0).a(1723);
            } else if (i2 == 1) {
                SingleEntrySettingActivity_.a(this).b(0).a(5);
            } else if (i2 != 2) {
                finish();
            } else {
                SetNewPasswordActivity_.a(this).a(str).b(str2).c(this.f19541f).a(2);
            }
        } else {
            finish();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i, String str, String str2) {
        if (i == -1) {
            int i2 = this.f19536a;
            if (i2 == 0) {
                setResult(i);
                finish();
            } else if (i2 == 1) {
                SingleEntrySettingActivity_.a(this).b(0).a(5);
            } else if (i2 != 2) {
                finish();
            } else {
                SetNewPasswordActivity_.a(this).a(str).b(str2).c(this.f19541f).a(2);
            }
        } else {
            setResult(i);
            finish();
        }
    }

    /* access modifiers changed from: package-private */
    public void d_(int i) {
        d(i);
    }

    /* access modifiers changed from: package-private */
    public void b(int i) {
        d(i);
    }

    /* access modifiers changed from: package-private */
    public void c(int i) {
        d(i);
    }

    private void d(int i) {
        Intent intent = new Intent();
        intent.putExtra("callbackId", this.f19537b);
        setResult(i, intent);
        finish();
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f19540e = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f19540e.a(this);
    }

    /* renamed from: c */
    public com.shopee.app.ui.auth.b.b b() {
        return this.f19540e;
    }
}
