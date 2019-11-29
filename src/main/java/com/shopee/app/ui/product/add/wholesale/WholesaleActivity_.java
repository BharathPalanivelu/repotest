package com.shopee.app.ui.product.add.wholesale;

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

public final class WholesaleActivity_ extends c implements org.a.a.b.a {

    /* renamed from: e  reason: collision with root package name */
    private final c f24167e = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f24167e);
        c(bundle);
        super.onCreate(bundle);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    private void c(Bundle bundle) {
        r();
    }

    public void setContentView(int i) {
        super.setContentView(i);
        this.f24167e.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f24167e.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f24167e.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void r() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("originalPrice")) {
                this.f24192b = (Long) extras.getSerializable("originalPrice");
            }
            if (extras.containsKey("models")) {
                this.f24193c = extras.getParcelableArrayList("models");
            }
            if (extras.containsKey("shouldShowPromotionPopup")) {
                this.f24194d = extras.getBoolean("shouldShowPromotionPopup");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        r();
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f24168d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f24169e;

        public a(Context context) {
            super(context, WholesaleActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f24169e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f24168d;
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

        public a a(Long l) {
            return (a) super.a("originalPrice", (Serializable) l);
        }

        public a a(ArrayList<WholesaleTierModel> arrayList) {
            return (a) super.a("models", (Serializable) arrayList);
        }

        public a a(boolean z) {
            return (a) super.a("shouldShowPromotionPopup", z);
        }
    }
}
