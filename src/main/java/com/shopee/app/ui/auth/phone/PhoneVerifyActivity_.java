package com.shopee.app.ui.auth.phone;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.events.TouchesHelper;
import org.a.a.a.d;
import org.a.a.b.c;

public final class PhoneVerifyActivity_ extends g implements org.a.a.b.a {
    private final c H = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.H);
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
        this.H.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.H.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.H.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey(TouchesHelper.TARGET_KEY)) {
                this.f19714a = extras.getInt(TouchesHelper.TARGET_KEY);
            }
            if (extras.containsKey("phone")) {
                this.f19715b = extras.getString("phone");
            }
            if (extras.containsKey("titleRes")) {
                this.f19716c = extras.getInt("titleRes");
            }
            if (extras.containsKey("tipRes")) {
                this.f19717d = extras.getInt("tipRes");
            }
            if (extras.containsKey("mainButtonRes")) {
                this.f19718e = extras.getInt("mainButtonRes");
            }
            if (extras.containsKey("otpToken")) {
                this.f19719f = extras.getString("otpToken");
            }
            if (extras.containsKey("resendToken")) {
                this.f19720g = extras.getString("resendToken");
            }
            if (extras.containsKey("email")) {
                this.h = extras.getString("email");
            }
            if (extras.containsKey("userName")) {
                this.i = extras.getString("userName");
            }
            if (extras.containsKey("needInit")) {
                this.j = extras.getBoolean("needInit");
            }
            if (extras.containsKey("phoneOTP")) {
                this.k = extras.getBoolean("phoneOTP");
            }
            if (extras.containsKey("otpSeed")) {
                this.l = extras.getString("otpSeed");
            }
            if (extras.containsKey("otpOperation")) {
                this.m = extras.getInt("otpOperation");
            }
            if (extras.containsKey("acquisitionSource")) {
                this.n = extras.getString("acquisitionSource");
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
            g_(i2);
        } else if (i == 2) {
            c(i2);
        } else if (i == 5) {
            d(i2);
        } else if (i == 6) {
            e(i2);
        } else if (i == 9) {
            b(i2);
        }
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f19677d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f19678e;

        public a(Context context) {
            super(context, PhoneVerifyActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f19678e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f19677d;
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
            return (a) super.a(TouchesHelper.TARGET_KEY, i);
        }

        public a a(String str) {
            return (a) super.a("phone", str);
        }

        public a c(int i) {
            return (a) super.a("titleRes", i);
        }

        public a d(int i) {
            return (a) super.a("tipRes", i);
        }

        public a e(int i) {
            return (a) super.a("mainButtonRes", i);
        }

        public a b(String str) {
            return (a) super.a("otpToken", str);
        }

        public a c(String str) {
            return (a) super.a("resendToken", str);
        }

        public a d(String str) {
            return (a) super.a("email", str);
        }

        public a e(String str) {
            return (a) super.a("userName", str);
        }

        public a a(boolean z) {
            return (a) super.a("needInit", z);
        }

        public a b(boolean z) {
            return (a) super.a("phoneOTP", z);
        }

        public a f(String str) {
            return (a) super.a("otpSeed", str);
        }

        public a f(int i) {
            return (a) super.a("otpOperation", i);
        }
    }
}
