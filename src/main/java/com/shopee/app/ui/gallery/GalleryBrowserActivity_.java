package com.shopee.app.ui.gallery;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import java.io.Serializable;
import java.util.ArrayList;
import org.a.a.a.d;
import org.a.a.b.c;

public final class GalleryBrowserActivity_ extends g implements org.a.a.b.a {

    /* renamed from: g  reason: collision with root package name */
    private final c f21834g = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f21834g);
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
        this.f21834g.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f21834g.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f21834g.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("selectedImage")) {
                this.f21901a = (GalleryData) extras.getParcelable("selectedImage");
            }
            if (extras.containsKey("imageCount")) {
                this.f21902b = extras.getInt("imageCount");
            }
            if (extras.containsKey("imageList")) {
                this.f21903c = extras.getParcelableArrayList("imageList");
            }
            if (extras.containsKey("maxCount")) {
                this.f21904d = extras.getInt("maxCount");
            }
            if (extras.containsKey("currentAlbumId")) {
                this.f21905e = extras.getLong("currentAlbumId");
            }
            if (extras.containsKey("filterCode")) {
                this.f21906f = extras.getString("filterCode");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f21835d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f21836e;

        public a(Context context) {
            super(context, GalleryBrowserActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f21836e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f21835d;
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

        public a a(GalleryData galleryData) {
            return (a) super.a("selectedImage", (Parcelable) galleryData);
        }

        public a b(int i) {
            return (a) super.a("imageCount", i);
        }

        public a a(ArrayList<GalleryData> arrayList) {
            return (a) super.a("imageList", (Serializable) arrayList);
        }

        public a c(int i) {
            return (a) super.a("maxCount", i);
        }

        public a a(long j) {
            return (a) super.a("currentAlbumId", j);
        }

        public a a(String str) {
            return (a) super.a("filterCode", str);
        }
    }
}
