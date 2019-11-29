package com.shopee.app.ui.setting.account;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.a.d;
import org.a.a.b.c;

public final class SingleEntrySettingActivity_ extends g implements org.a.a.b.a {

    /* renamed from: e  reason: collision with root package name */
    private final c f25152e = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f25152e);
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
        this.f25152e.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f25152e.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f25152e.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("settingType")) {
                this.f25177a = extras.getInt("settingType");
            }
            if (extras.containsKey("password")) {
                this.f25178b = extras.getString("password");
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
            d(i2);
        } else if (i == 24) {
            c(i2);
        } else if (i == 5) {
            b(i2);
        } else if (i == 6) {
            e(i2);
        }
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f25153d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f25154e;

        public a(Context context) {
            super(context, SingleEntrySettingActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f25154e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f25153d;
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
            return (a) super.a("settingType", i);
        }
    }
}
