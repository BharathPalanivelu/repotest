package com.shopee.app.ui.product.newsearch;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.a.d;
import org.a.a.b.c;

public final class SearchTabActivity_ extends c implements org.a.a.b.a {

    /* renamed from: g  reason: collision with root package name */
    private final c f24647g = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f24647g);
        c(bundle);
        super.onCreate(bundle);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    private void c(Bundle bundle) {
        p();
    }

    public void setContentView(int i) {
        super.setContentView(i);
        this.f24647g.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f24647g.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f24647g.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void p() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("keyword")) {
                this.f24689a = extras.getString("keyword");
            }
            if (extras.containsKey("searchConfig")) {
                this.f24690b = extras.getString("searchConfig");
            }
            if (extras.containsKey("selectedIndex")) {
                this.f24691c = extras.getInt("selectedIndex");
            }
            if (extras.containsKey("pageType")) {
                this.f24692d = extras.getInt("pageType");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        p();
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f24648d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f24649e;

        public a(Context context) {
            super(context, SearchTabActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f24649e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f24648d;
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
            return (a) super.a("keyword", str);
        }

        public a b(String str) {
            return (a) super.a("searchConfig", str);
        }

        public a b(int i) {
            return (a) super.a("selectedIndex", i);
        }

        public a c(int i) {
            return (a) super.a("pageType", i);
        }
    }
}
