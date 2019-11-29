package com.shopee.app.ui.order.search;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.a.d;
import org.a.a.b.c;

public final class GetSearchShopCustomerActivity_ extends a implements org.a.a.b.a {

    /* renamed from: g  reason: collision with root package name */
    private final c f23794g = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f23794g);
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
        this.f23794g.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f23794g.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f23794g.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("title")) {
                this.f23797a = extras.getString("title");
            }
            if (extras.containsKey("filter")) {
                this.f23798b = extras.getString("filter");
            }
            if (extras.containsKey("total")) {
                this.f23799c = extras.getInt("total");
            }
            if (extras.containsKey("loadType")) {
                this.f23800d = extras.getInt("loadType");
            }
            if (extras.containsKey("intention")) {
                this.f23801e = extras.getInt("intention");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f23795d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f23796e;

        public a(Context context) {
            super(context, GetSearchShopCustomerActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f23796e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f23795d;
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
            return (a) super.a("title", str);
        }

        public a b(String str) {
            return (a) super.a("filter", str);
        }

        public a b(int i) {
            return (a) super.a("total", i);
        }

        public a c(int i) {
            return (a) super.a("loadType", i);
        }

        public a d(int i) {
            return (a) super.a("intention", i);
        }
    }
}
