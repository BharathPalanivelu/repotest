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

public final class IsAuthProxyActivity_ extends h implements org.a.a.b.a {

    /* renamed from: e  reason: collision with root package name */
    private final c f19474e = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f19474e);
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
        this.f19474e.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f19474e.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f19474e.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("authAction")) {
                this.f19536a = extras.getInt("authAction");
            }
            if (extras.containsKey("callbackId")) {
                this.f19537b = extras.getString("callbackId");
            }
            if (extras.containsKey("skipCheck")) {
                this.f19539d = extras.getBoolean("skipCheck");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2) {
            b(i2);
        } else if (i == 5) {
            c(i2);
        } else if (i == 1723) {
            d_(i2);
        } else if (i == 1725) {
            Bundle bundle = (intent == null || intent.getExtras() == null) ? new Bundle() : intent.getExtras();
            a(i2, bundle.getString("phoneNumber"), bundle.getString("verifyCode"));
        } else if (i == 1821) {
            Bundle bundle2 = (intent == null || intent.getExtras() == null) ? new Bundle() : intent.getExtras();
            a(i2, bundle2.getString("phoneNumber"), bundle2.getString("verifyCode"), bundle2.getString("otpToken"));
        } else if (i == 1772) {
            b(i2, ((intent == null || intent.getExtras() == null) ? new Bundle() : intent.getExtras()).getString("password"));
        } else if (i == 1773) {
            a(i2, ((intent == null || intent.getExtras() == null) ? new Bundle() : intent.getExtras()).getString("password"));
        }
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f19475d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f19476e;

        public a(Context context) {
            super(context, IsAuthProxyActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f19476e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f19475d;
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
            return (a) super.a("authAction", i);
        }

        public a a(String str) {
            return (a) super.a("callbackId", str);
        }

        public a a(boolean z) {
            return (a) super.a("skipCheck", z);
        }
    }
}
