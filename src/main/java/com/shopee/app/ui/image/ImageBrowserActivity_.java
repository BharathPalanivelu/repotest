package com.shopee.app.ui.image;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import java.io.Serializable;
import java.util.ArrayList;
import org.a.a.a.d;
import org.a.a.b.c;

public final class ImageBrowserActivity_ extends f implements org.a.a.b.a {

    /* renamed from: g  reason: collision with root package name */
    private final c f22723g = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f22723g);
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
        this.f22723g.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f22723g.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f22723g.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("imageList")) {
                this.f22960a = extras.getStringArrayList("imageList");
            }
            if (extras.containsKey("mediaList")) {
                this.f22961b = extras.getParcelableArrayList("mediaList");
            }
            if (extras.containsKey("singleMode")) {
                this.f22962c = extras.getBoolean("singleMode");
            }
            if (extras.containsKey("currentIndex")) {
                this.f22963d = extras.getInt("currentIndex");
            }
            if (extras.containsKey("isMuted")) {
                this.f22964e = extras.getBoolean("isMuted");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f22724d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f22725e;

        public a(Context context) {
            super(context, ImageBrowserActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f22725e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f22724d;
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

        public a a(ArrayList<MediaData> arrayList) {
            return (a) super.a("mediaList", (Serializable) arrayList);
        }

        public a a(boolean z) {
            return (a) super.a("singleMode", z);
        }

        public a b(int i) {
            return (a) super.a("currentIndex", i);
        }

        public a b(boolean z) {
            return (a) super.a("isMuted", z);
        }
    }
}
