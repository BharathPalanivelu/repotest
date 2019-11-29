package com.shopee.app.ui.auth.signup.phone;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.a.d;
import org.a.a.b.c;

public final class PhoneDetailActivity_ extends a implements org.a.a.b.a {

    /* renamed from: f  reason: collision with root package name */
    private final c f19882f = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f19882f);
        c(bundle);
        super.onCreate(bundle);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    private void c(Bundle bundle) {
        l();
    }

    public void setContentView(int i) {
        super.setContentView(i);
        this.f19882f.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f19882f.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f19882f.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("phone")) {
                this.f19885a = extras.getString("phone");
            }
            if (extras.containsKey("verification_code")) {
                this.f19886b = extras.getString("verification_code");
            }
            if (extras.containsKey("isShadow")) {
                this.f19887c = extras.getBoolean("isShadow");
            }
            if (extras.containsKey("otpAutoFill")) {
                this.f19888d = extras.getBoolean("otpAutoFill");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 4) {
            a(i2, intent);
        }
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f19883d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f19884e;

        public a(Context context) {
            super(context, PhoneDetailActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f19884e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f19883d;
                if (fragment2 != null) {
                    fragment2.startActivityForResult(this.f7170c, i, this.f7168a);
                } else if (this.f7169b instanceof Activity) {
                    androidx.core.app.a.a((Activity) this.f7169b, this.f7170c, i, this.f7168a);
                } else {
                    this.f7169b.startActivity(this.f7170c, this.f7168a);
                }
            }
            return new d(this.f7169b);
        }

        public a a(String str) {
            return (a) super.a("phone", str);
        }

        public a b(String str) {
            return (a) super.a("verification_code", str);
        }

        public a a(boolean z) {
            return (a) super.a("otpAutoFill", z);
        }
    }
}
