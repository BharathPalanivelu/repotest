package com.shopee.app.react.util.image;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.a.d;
import org.a.a.b.c;

public final class ReactPhotoProxyActivity_ extends a implements org.a.a.b.a {

    /* renamed from: e  reason: collision with root package name */
    private final c f19014e = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f19014e);
        c(bundle);
        super.onCreate(bundle);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    private void c(Bundle bundle) {
        c();
    }

    public void setContentView(int i) {
        super.setContentView(i);
        this.f19014e.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f19014e.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f19014e.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void c() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("resizeWidth")) {
                this.f19017a = extras.getInt("resizeWidth");
            }
            if (extras.containsKey("resizeHeight")) {
                this.f19018b = extras.getInt("resizeHeight");
            }
            if (extras.containsKey("resizeQuality")) {
                this.f19019c = extras.getInt("resizeQuality");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        c();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 77) {
            a(i2, intent);
        }
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f19015d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f19016e;

        public a(Context context) {
            super(context, ReactPhotoProxyActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f19016e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f19015d;
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
            return (a) super.a("resizeWidth", i);
        }

        public a c(int i) {
            return (a) super.a("resizeHeight", i);
        }

        public a d(int i) {
            return (a) super.a("resizeQuality", i);
        }
    }
}
