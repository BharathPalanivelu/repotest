package com.shopee.app.util.sfchat.ui;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.a.d;
import org.a.a.b.c;

public final class SFChatProxyActivity_ extends a implements org.a.a.b.a {

    /* renamed from: b  reason: collision with root package name */
    private final c f26523b = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f26523b);
        a(bundle);
        super.onCreate(bundle);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    private void a(Bundle bundle) {
        b();
    }

    public void setContentView(int i) {
        super.setContentView(i);
        this.f26523b.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f26523b.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f26523b.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void b() {
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("chatData")) {
            this.f26526a = extras.getString("chatData");
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        b();
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f26524d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f26525e;

        public a(Context context) {
            super(context, SFChatProxyActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f26525e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f26524d;
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
            return (a) super.a("chatData", str);
        }
    }
}
