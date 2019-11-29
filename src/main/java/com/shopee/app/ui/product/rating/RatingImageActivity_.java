package com.shopee.app.ui.product.rating;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.a.d;
import org.a.a.b.c;

public final class RatingImageActivity_ extends d implements org.a.a.b.a {
    private final c h = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.h);
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
        this.h.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.h.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.h.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("shopId")) {
                this.f24733a = extras.getInt("shopId");
            }
            if (extras.containsKey("itemId")) {
                this.f24734b = extras.getLong("itemId");
            }
            if (extras.containsKey("commentIndex")) {
                this.f24735c = extras.getInt("commentIndex");
            }
            if (extras.containsKey("imageIndex")) {
                this.f24736d = extras.getInt("imageIndex");
            }
            if (extras.containsKey("eventId")) {
                this.f24737e = extras.getString("eventId");
            }
            if (extras.containsKey("type")) {
                this.f24738f = extras.getInt("type");
            }
            if (extras.containsKey("filterWithComments")) {
                this.f24739g = extras.getBoolean("filterWithComments");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f24710d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f24711e;

        public a(Context context) {
            super(context, RatingImageActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f24711e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f24710d;
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
            return (a) super.a("itemId", j);
        }

        public a c(int i) {
            return (a) super.a("commentIndex", i);
        }

        public a d(int i) {
            return (a) super.a("imageIndex", i);
        }

        public a a(String str) {
            return (a) super.a("eventId", str);
        }

        public a e(int i) {
            return (a) super.a("type", i);
        }

        public a a(boolean z) {
            return (a) super.a("filterWithComments", z);
        }
    }
}
