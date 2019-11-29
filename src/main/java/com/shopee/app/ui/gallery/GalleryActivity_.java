package com.shopee.app.ui.gallery;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import org.a.a.a.d;
import org.a.a.b.c;

public final class GalleryActivity_ extends e implements org.a.a.b.a {

    /* renamed from: e  reason: collision with root package name */
    private final c f21831e = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f21831e);
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
        this.f21831e.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f21831e.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f21831e.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("mode")) {
                this.f21882a = extras.getInt("mode");
            }
            if (extras.containsKey("maxImageCount")) {
                this.f21883b = extras.getInt("maxImageCount");
            }
            if (extras.containsKey("maxVideoCount")) {
                this.f21884c = extras.getInt("maxVideoCount");
            }
            if (extras.containsKey("filter")) {
                this.f21885d = extras.getString("filter");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 4) {
            b(i2, intent);
        } else if (i == 1837) {
            a(i2, intent);
        } else if (i == 10092) {
            Bundle bundle = (intent == null || intent.getExtras() == null) ? new Bundle() : intent.getExtras();
            a((ArrayList<GalleryData>) bundle.getParcelableArrayList("imageList"), bundle.getBoolean("submit"));
        }
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f21832d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f21833e;

        public a(Context context) {
            super(context, GalleryActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f21833e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f21832d;
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
            return (a) super.a("mode", i);
        }

        public a c(int i) {
            return (a) super.a("maxImageCount", i);
        }

        public a d(int i) {
            return (a) super.a("maxVideoCount", i);
        }

        public a a(String str) {
            return (a) super.a("filter", str);
        }
    }
}
