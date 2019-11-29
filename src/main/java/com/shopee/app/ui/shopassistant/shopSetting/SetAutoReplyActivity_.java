package com.shopee.app.ui.shopassistant.shopSetting;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.a.d;
import org.a.a.b.c;

public final class SetAutoReplyActivity_ extends c implements org.a.a.b.a {

    /* renamed from: d  reason: collision with root package name */
    private final c f25530d = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f25530d);
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
        this.f25530d.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f25530d.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f25530d.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("oldReply")) {
                this.f25550a = extras.getString("oldReply");
            }
            if (extras.containsKey("autoReplyToggle")) {
                this.f25551b = extras.getBoolean("autoReplyToggle");
            }
            if (extras.containsKey("acceptChatToggle")) {
                this.f25552c = extras.getBoolean("acceptChatToggle");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f25531d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f25532e;

        public a(Context context) {
            super(context, SetAutoReplyActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f25532e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f25531d;
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
            return (a) super.a("oldReply", str);
        }
    }
}
