package com.shopee.app.ui.product.attributes;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.a.d;
import org.a.a.b.c;

public final class AttributeListActivity_ extends g implements org.a.a.b.a {
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
            if (extras.containsKey("attrId")) {
                this.f24284a = extras.getInt("attrId");
            }
            if (extras.containsKey("attrName")) {
                this.f24285b = extras.getString("attrName");
            }
            if (extras.containsKey("totalSubAttr")) {
                this.f24286c = extras.getInt("totalSubAttr");
            }
            if (extras.containsKey("attributeSelected")) {
                this.f24287d = extras.getString("attributeSelected");
            }
            if (extras.containsKey("setOwn")) {
                this.f24288e = extras.getBoolean("setOwn");
            }
            if (extras.containsKey("signature")) {
                this.f24289f = extras.getByteArray("signature");
            }
            if (extras.containsKey("modelId")) {
                this.f24290g = extras.getInt("modelId");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f24234d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f24235e;

        public a(Context context) {
            super(context, AttributeListActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f24235e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f24234d;
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
            return (a) super.a("attrId", i);
        }

        public a a(String str) {
            return (a) super.a("attrName", str);
        }

        public a c(int i) {
            return (a) super.a("totalSubAttr", i);
        }

        public a b(String str) {
            return (a) super.a("attributeSelected", str);
        }

        public a a(boolean z) {
            return (a) super.a("setOwn", z);
        }

        public a a(byte[] bArr) {
            return (a) super.a("signature", bArr);
        }

        public a d(int i) {
            return (a) super.a("modelId", i);
        }
    }
}
