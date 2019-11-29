package com.shopee.app.ui.customer.order;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.a.d;
import org.a.a.b.c;

public final class CustomerOrdersActivity_ extends b implements org.a.a.b.a {

    /* renamed from: e  reason: collision with root package name */
    private final c f21424e = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f21424e);
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
        this.f21424e.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f21424e.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f21424e.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("userId")) {
                this.f21435a = extras.getInt("userId");
            }
            if (extras.containsKey("shopId")) {
                this.f21436b = extras.getInt("shopId");
            }
            if (extras.containsKey("recipientName")) {
                this.f21437c = extras.getString("recipientName");
            }
            if (extras.containsKey("title")) {
                this.f21438d = extras.getString("title");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f21425d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f21426e;

        public a(Context context) {
            super(context, CustomerOrdersActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f21426e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f21425d;
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
            return (a) super.a("userId", i);
        }

        public a c(int i) {
            return (a) super.a("shopId", i);
        }

        public a a(String str) {
            return (a) super.a("recipientName", str);
        }

        public a b(String str) {
            return (a) super.a("title", str);
        }
    }
}
