package com.shopee.app.ui.chat2;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.ViewProps;
import org.a.a.a.d;
import org.a.a.b.c;

public final class MessageShortcutsEditActivity_ extends v implements org.a.a.b.a {

    /* renamed from: c  reason: collision with root package name */
    private final c f20197c = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f20197c);
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
        this.f20197c.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f20197c.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f20197c.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey(ViewProps.POSITION)) {
                this.f20945a = extras.getInt(ViewProps.POSITION);
            }
            if (extras.containsKey("msg")) {
                this.f20946b = extras.getString("msg");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f20198d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f20199e;

        public a(Context context) {
            super(context, MessageShortcutsEditActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f20199e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f20198d;
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
            return (a) super.a(ViewProps.POSITION, i);
        }

        public a a(String str) {
            return (a) super.a("msg", str);
        }
    }
}
