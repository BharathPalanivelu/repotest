package com.shopee.app.ui.home.me.editprofile.bio;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.a.d;
import org.a.a.b.c;

public final class EditProfileBioActivity_ extends a implements org.a.a.b.a {

    /* renamed from: g  reason: collision with root package name */
    private final c f22325g = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f22325g);
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
        this.f22325g.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f22325g.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f22325g.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("msg")) {
                this.f22328a = extras.getString("msg");
            }
            if (extras.containsKey("theme")) {
                this.f22329b = extras.getInt("theme");
            }
            if (extras.containsKey("hintRes")) {
                this.f22330c = extras.getInt("hintRes");
            }
            if (extras.containsKey("maxLimit")) {
                this.f22331d = extras.getInt("maxLimit");
            }
            if (extras.containsKey("errorRes")) {
                this.f22332e = extras.getInt("errorRes");
            }
            if (extras.containsKey("titleRes")) {
                this.f22333f = extras.getInt("titleRes");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f22326d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f22327e;

        public a(Context context) {
            super(context, EditProfileBioActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f22327e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f22326d;
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
            return (a) super.a("msg", str);
        }

        public a b(int i) {
            return (a) super.a("theme", i);
        }

        public a c(int i) {
            return (a) super.a("hintRes", i);
        }

        public a d(int i) {
            return (a) super.a("maxLimit", i);
        }

        public a e(int i) {
            return (a) super.a("errorRes", i);
        }

        public a f(int i) {
            return (a) super.a("titleRes", i);
        }
    }
}
