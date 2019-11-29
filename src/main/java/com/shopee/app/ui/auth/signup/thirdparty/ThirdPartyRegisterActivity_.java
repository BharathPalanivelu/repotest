package com.shopee.app.ui.auth.signup.thirdparty;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.Scopes;
import java.io.Serializable;
import org.a.a.a.d;
import org.a.a.b.c;

public final class ThirdPartyRegisterActivity_ extends a implements org.a.a.b.a {
    private final c h = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.h);
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
        this.h.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.h.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.h.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("thirdPartAppType")) {
                this.f19925a = extras.getInt("thirdPartAppType");
            }
            if (extras.containsKey("userName")) {
                this.f19926b = extras.getString("userName");
            }
            if (extras.containsKey("phone")) {
                this.f19927c = extras.getString("phone");
            }
            if (extras.containsKey(Scopes.PROFILE)) {
                this.f19928d = extras.getString(Scopes.PROFILE);
            }
            if (extras.containsKey("data")) {
                this.f19929e = extras.getSerializable("data");
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
        private Fragment f19923d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f19924e;

        public a(Context context) {
            super(context, ThirdPartyRegisterActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f19924e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f19923d;
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
            return (a) super.a("thirdPartAppType", i);
        }

        public a a(Serializable serializable) {
            return (a) super.a("data", serializable);
        }
    }
}
