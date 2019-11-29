package com.shopee.app.ui.product.add;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.a.d;
import org.a.a.b.c;

public final class AddProductActivity_ extends b implements org.a.a.b.a {

    /* renamed from: f  reason: collision with root package name */
    private final c f23942f = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f23942f);
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
        this.f23942f.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f23942f.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f23942f.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("itemId")) {
                this.f24006a = extras.getLong("itemId");
            }
            if (extras.containsKey("choosePhotoTool")) {
                this.f24007b = extras.getInt("choosePhotoTool");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0) {
            b(i2, intent);
        } else if (i == 4) {
            a(i2, intent);
        } else if (i == 25) {
            e(i2, intent);
        } else if (i == 330) {
            d(i2, intent);
        } else if (i == 561) {
            b(i2);
        } else if (i == 9281) {
            a(i2, ((intent == null || intent.getExtras() == null) ? new Bundle() : intent.getExtras()).getString("popData"));
        } else if (i == 550) {
            c(i2, intent);
        } else if (i == 551) {
            f(i2, intent);
        }
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f23943d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f23944e;

        public a(Context context) {
            super(context, AddProductActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f23944e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f23943d;
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

        public a a(long j) {
            return (a) super.a("itemId", j);
        }

        public a b(int i) {
            return (a) super.a("choosePhotoTool", i);
        }
    }
}
