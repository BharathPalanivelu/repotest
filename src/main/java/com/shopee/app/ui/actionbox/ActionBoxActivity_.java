package com.shopee.app.ui.actionbox;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.a.d;
import org.a.a.b.c;

public final class ActionBoxActivity_ extends ActionBoxActivity implements org.a.a.b.a {

    /* renamed from: g  reason: collision with root package name */
    private final c f19336g = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f19336g);
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
        this.f19336g.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f19336g.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f19336g.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("tabPosition")) {
                this.f19329a = extras.getInt("tabPosition");
            }
            if (extras.containsKey("cateId")) {
                this.f19330b = extras.getInt("cateId");
            }
            if (extras.containsKey("actionType")) {
                this.f19331c = extras.getInt("actionType");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f19337d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f19338e;

        public a(Context context) {
            super(context, ActionBoxActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f19338e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f19337d;
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
            return (a) super.a("actionType", i);
        }
    }
}
