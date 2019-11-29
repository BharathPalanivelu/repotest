package com.shopee.app.ui.image;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.a.d;
import org.a.a.b.c;

public final class SearchPreviewActivity_ extends m implements org.a.a.b.a {
    private final c i = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.i);
        c(bundle);
        super.onCreate(bundle);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    private void c(Bundle bundle) {
        l();
    }

    public void setContentView(int i2) {
        super.setContentView(i2);
        this.i.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.i.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.i.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("imageUri")) {
                this.f23034a = extras.getString("imageUri");
            }
            if (extras.containsKey("doUpload")) {
                this.f23035b = extras.getBoolean("doUpload");
            }
            if (extras.containsKey("boundBox")) {
                this.f23036c = (Rect) extras.getParcelable("boundBox");
            }
            if (extras.containsKey("imageId")) {
                this.f23037d = extras.getString("imageId");
            }
            if (extras.containsKey("scale")) {
                this.f23038e = extras.getDouble("scale");
            }
            if (extras.containsKey("isFromHint")) {
                this.f23039f = extras.getBoolean("isFromHint");
            }
            if (extras.containsKey("editBoundingBox")) {
                this.f23040g = extras.getBoolean("editBoundingBox");
            }
            if (extras.containsKey("isFromCamera")) {
                this.h = extras.getBoolean("isFromCamera");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f22727d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f22728e;

        public a(Context context) {
            super(context, SearchPreviewActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f22728e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f22727d;
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
            return (a) super.a("imageUri", str);
        }

        public a a(boolean z) {
            return (a) super.a("doUpload", z);
        }

        public a a(Rect rect) {
            return (a) super.a("boundBox", (Parcelable) rect);
        }

        public a b(String str) {
            return (a) super.a("imageId", str);
        }

        public a a(double d2) {
            return (a) super.a("scale", d2);
        }

        public a b(boolean z) {
            return (a) super.a("isFromHint", z);
        }

        public a c(boolean z) {
            return (a) super.a("editBoundingBox", z);
        }

        public a d(boolean z) {
            return (a) super.a("isFromCamera", z);
        }
    }
}
