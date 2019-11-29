package com.shopee.app.ui.product.comment.FeedsComment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.a.d;
import org.a.a.b.c;

public final class FeedsCommentActivity_ extends d implements org.a.a.b.a {

    /* renamed from: c  reason: collision with root package name */
    private final c f24407c = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f24407c);
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
        this.f24407c.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f24407c.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f24407c.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("shopId")) {
                this.f24425a = extras.getInt("shopId");
            }
            if (extras.containsKey("feedId")) {
                this.f24426b = extras.getLong("feedId");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f24408d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f24409e;

        public a(Context context) {
            super(context, FeedsCommentActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f24409e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f24408d;
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
            return (a) super.a("shopId", i);
        }

        public a a(long j) {
            return (a) super.a("feedId", j);
        }
    }
}
