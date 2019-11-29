package com.shopee.app.ui.image.icimage;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import com.shopee.app.data.viewmodel.camera.IcCamera3Info;
import com.shopee.app.data.viewmodel.camera.PhotoFrameInfo;
import org.a.a.a.d;
import org.a.a.b.c;

public final class IcImagePreviewActivity_ extends d implements org.a.a.b.a {

    /* renamed from: e  reason: collision with root package name */
    private final c f22975e = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f22975e);
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
        this.f22975e.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f22975e.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f22975e.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("imageUri")) {
                this.f22995a = extras.getString("imageUri");
            }
            if (extras.containsKey("photoFrameInfo")) {
                this.f22996b = (PhotoFrameInfo) extras.getParcelable("photoFrameInfo");
            }
            if (extras.containsKey("icCamera3Info")) {
                this.f22997c = (IcCamera3Info) extras.getParcelable("icCamera3Info");
            }
            if (extras.containsKey("photoOrientation")) {
                this.f22998d = extras.getInt("photoOrientation");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f22976d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f22977e;

        public a(Context context) {
            super(context, IcImagePreviewActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f22977e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f22976d;
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

        public a a(PhotoFrameInfo photoFrameInfo) {
            return (a) super.a("photoFrameInfo", (Parcelable) photoFrameInfo);
        }

        public a a(IcCamera3Info icCamera3Info) {
            return (a) super.a("icCamera3Info", (Parcelable) icCamera3Info);
        }

        public a b(int i) {
            return (a) super.a("photoOrientation", i);
        }
    }
}
