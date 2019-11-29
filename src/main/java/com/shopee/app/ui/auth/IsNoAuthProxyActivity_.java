package com.shopee.app.ui.auth;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.a.d;
import org.a.a.b.c;

public final class IsNoAuthProxyActivity_ extends j implements org.a.a.b.a {

    /* renamed from: e  reason: collision with root package name */
    private final c f19477e = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f19477e);
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
        this.f19477e.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f19477e.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f19477e.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("noAuthAction")) {
                this.f19542a = extras.getInt("noAuthAction");
            }
            if (extras.containsKey("phoneNumber")) {
                this.f19543b = extras.getString("phoneNumber");
            }
            if (extras.containsKey("isPhoneOTP")) {
                this.f19544c = extras.getBoolean("isPhoneOTP");
            }
            if (extras.containsKey("acquisitionSource")) {
                this.f19545d = extras.getString("acquisitionSource");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            b(i2);
        } else if (i == 2) {
            c(i2);
        } else if (i == 1724) {
            e_(i2);
        } else if (i == 1821) {
            Bundle bundle = (intent == null || intent.getExtras() == null) ? new Bundle() : intent.getExtras();
            a(i2, bundle.getString("phoneNumber"), bundle.getString("verifyCode"), bundle.getBoolean("otpAutoFill"));
        }
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f19478d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f19479e;

        public a(Context context) {
            super(context, IsNoAuthProxyActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f19479e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f19478d;
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

        public a b(int i) {
            return (a) super.a("noAuthAction", i);
        }

        public a a(String str) {
            return (a) super.a("phoneNumber", str);
        }

        public a a(boolean z) {
            return (a) super.a("isPhoneOTP", z);
        }

        public a b(String str) {
            return (a) super.a("acquisitionSource", str);
        }
    }
}
