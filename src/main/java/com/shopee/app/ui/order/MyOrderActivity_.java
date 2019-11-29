package com.shopee.app.ui.order;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import com.shopee.id.R;
import org.a.a.a.d;
import org.a.a.b.c;

public final class MyOrderActivity_ extends b implements org.a.a.b.a {
    private final c j = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.j);
        c(bundle);
        super.onCreate(bundle);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    private void c(Bundle bundle) {
        Resources resources = getResources();
        this.f23465d = resources.getString(R.string.sp_title_buying);
        this.f23466e = resources.getString(R.string.sp_title_selling);
        l();
    }

    public void setContentView(int i) {
        super.setContentView(i);
        this.j.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.j.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.j.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("uType")) {
                this.f23462a = extras.getInt("uType");
            }
            if (extras.containsKey("tabPosition")) {
                this.f23463b = extras.getInt("tabPosition");
            }
            if (extras.containsKey("filter")) {
                this.f23464c = extras.getString("filter");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1002) {
            a(((intent == null || intent.getExtras() == null) ? new Bundle() : intent.getExtras()).getString(AbTestingModule.KEY_RESULT));
        }
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f23443d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f23444e;

        public a(Context context) {
            super(context, MyOrderActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f23444e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f23443d;
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
            return (a) super.a("uType", i);
        }

        public a c(int i) {
            return (a) super.a("tabPosition", i);
        }

        public a a(String str) {
            return (a) super.a("filter", str);
        }
    }
}
