package com.shopee.app.ui.auth.password;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.a.d;
import org.a.a.b.c;

public final class SetNewPasswordActivity_ extends r implements org.a.a.b.a {

    /* renamed from: e  reason: collision with root package name */
    private final c f19589e = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f19589e);
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
        this.f19589e.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f19589e.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f19589e.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("phone")) {
                this.f19651a = extras.getString("phone");
            }
            if (extras.containsKey("verification_code")) {
                this.f19652b = extras.getString("verification_code");
            }
            if (extras.containsKey("oldPassword")) {
                this.f19653c = extras.getString("oldPassword");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f19590d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f19591e;

        public a(Context context) {
            super(context, SetNewPasswordActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f19591e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f19590d;
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

        public a c(String str) {
            return (a) super.a("oldPassword", str);
        }
    }
}
