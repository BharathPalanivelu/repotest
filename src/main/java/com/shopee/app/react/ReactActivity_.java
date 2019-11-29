package com.shopee.app.react;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.a.d;
import org.a.a.b.c;

public final class ReactActivity_ extends d implements org.a.a.b.a {
    private final c n = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.n);
        c(bundle);
        super.onCreate(bundle);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    private void c(Bundle bundle) {
        F();
    }

    public void setContentView(int i) {
        super.setContentView(i);
        this.n.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.n.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.n.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void F() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("moduleName")) {
                this.i = extras.getString("moduleName");
            }
            if (extras.containsKey("propsEvent")) {
                this.j = extras.getString("propsEvent");
            }
            if (extras.containsKey("pushData")) {
                this.k = extras.getString("pushData");
            }
            if (extras.containsKey("processingIndicator")) {
                this.l = extras.getInt("processingIndicator");
            }
            if (extras.containsKey("enterType")) {
                this.m = extras.getInt("enterType");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        F();
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f18546d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f18547e;

        public a(Context context) {
            super(context, ReactActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f18547e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f18546d;
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
            return (a) super.a("moduleName", str);
        }

        public a b(String str) {
            return (a) super.a("propsEvent", str);
        }

        public a c(String str) {
            return (a) super.a("pushData", str);
        }

        public a b(int i) {
            return (a) super.a("processingIndicator", i);
        }

        public a c(int i) {
            return (a) super.a("enterType", i);
        }
    }
}
