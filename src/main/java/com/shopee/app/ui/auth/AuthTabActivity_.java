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

public final class AuthTabActivity_ extends b implements org.a.a.b.a {
    private final c j = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.j);
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
        this.j.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.j.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.j.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("tabIndex")) {
                this.f19485a = extras.getInt("tabIndex");
            }
            if (extras.containsKey("existedAccount")) {
                this.f19486b = extras.getString("existedAccount");
            }
            if (extras.containsKey("fromRN")) {
                this.f19487c = extras.getBoolean("fromRN");
            }
            if (extras.containsKey("acquisitionSource")) {
                this.f19488d = extras.getString("acquisitionSource");
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
            c_(i2);
        } else if (i == 9) {
            b(i2);
        } else if (i == 30) {
            a(i2, intent);
        } else if (i == 121) {
            Bundle bundle = (intent == null || intent.getExtras() == null) ? new Bundle() : intent.getExtras();
            a(i2, bundle.getString("username"), bundle.getString("password"));
        }
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f19472d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f19473e;

        public a(Context context) {
            super(context, AuthTabActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f19473e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f19472d;
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
            return (a) super.a("tabIndex", i);
        }

        public a a(String str) {
            return (a) super.a("existedAccount", str);
        }

        public a b(String str) {
            return (a) super.a("acquisitionSource", str);
        }
    }
}
