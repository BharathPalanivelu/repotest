package com.shopee.app.ui.webview.simpleweb;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.a.d;
import org.a.a.b.c;

public final class SimpleWebPageActivity_ extends a implements org.a.a.b.a {

    /* renamed from: d  reason: collision with root package name */
    private final c f26070d = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f26070d);
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
        this.f26070d.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f26070d.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f26070d.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("navbar")) {
                this.f26073a = extras.getString("navbar");
            }
            if (extras.containsKey("url")) {
                this.f26074b = extras.getString("url");
            }
            if (extras.containsKey("chromeMode")) {
                this.f26075c = extras.getBoolean("chromeMode");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 8772) {
            a(i2, intent);
        }
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f26071d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f26072e;

        public a(Context context) {
            super(context, SimpleWebPageActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f26072e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f26071d;
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
            return (a) super.a("navbar", str);
        }

        public a b(String str) {
            return (a) super.a("url", str);
        }

        public a a(boolean z) {
            return (a) super.a("chromeMode", z);
        }
    }
}
