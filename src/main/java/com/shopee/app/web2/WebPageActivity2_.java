package com.shopee.app.web2;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.a.d;
import org.a.a.b.c;

public final class WebPageActivity2_ extends a implements org.a.a.b.a {
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
            if (extras.containsKey("navbar")) {
                this.f26580c = extras.getString("navbar");
            }
            if (extras.containsKey("isPresentModel")) {
                this.f26581d = extras.getBoolean("isPresentModel");
            }
            if (extras.containsKey("url")) {
                this.f26582e = extras.getString("url");
            }
            if (extras.containsKey("lastPageJs")) {
                this.f26583f = extras.getString("lastPageJs");
            }
            if (extras.containsKey("pageType")) {
                this.f26584g = extras.getInt("pageType");
            }
            if (extras.containsKey("config")) {
                this.h = extras.getString("config");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f26576d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f26577e;

        public a(Context context) {
            super(context, WebPageActivity2_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f26577e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f26576d;
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

        public a c(String str) {
            return (a) super.a("lastPageJs", str);
        }

        public a d(String str) {
            return (a) super.a("config", str);
        }
    }
}
