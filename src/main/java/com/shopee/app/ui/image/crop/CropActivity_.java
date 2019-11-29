package com.shopee.app.ui.image.crop;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.share.internal.ShareConstants;
import org.a.a.a.d;
import org.a.a.b.c;

public final class CropActivity_ extends a implements org.a.a.b.a {

    /* renamed from: e  reason: collision with root package name */
    private final c f22789e = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f22789e);
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
        this.f22789e.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f22789e.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f22789e.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey(ShareConstants.MEDIA_URI)) {
                this.f22792a = extras.getString(ShareConstants.MEDIA_URI);
            }
            if (extras.containsKey("aspectWidth")) {
                this.f22793b = extras.getInt("aspectWidth");
            }
            if (extras.containsKey("aspectHeight")) {
                this.f22794c = extras.getInt("aspectHeight");
            }
            if (extras.containsKey("allowSpacing")) {
                this.f22795d = extras.getBoolean("allowSpacing");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f22790d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f22791e;

        public a(Context context) {
            super(context, CropActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f22791e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f22790d;
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
            return (a) super.a(ShareConstants.MEDIA_URI, str);
        }

        public a b(int i) {
            return (a) super.a("aspectWidth", i);
        }

        public a c(int i) {
            return (a) super.a("aspectHeight", i);
        }

        public a a(boolean z) {
            return (a) super.a("allowSpacing", z);
        }
    }
}
