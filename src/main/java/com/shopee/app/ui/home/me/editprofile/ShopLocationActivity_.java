package com.shopee.app.ui.home.me.editprofile;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.b.a;
import org.a.a.b.c;

public final class ShopLocationActivity_ extends k implements a {

    /* renamed from: a  reason: collision with root package name */
    private final c f22302a = new c();

    private void c(Bundle bundle) {
    }

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f22302a);
        c(bundle);
        super.onCreate(bundle);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void setContentView(int i) {
        super.setContentView(i);
        this.f22302a.a((a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f22302a.a((a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f22302a.a((a) this);
    }
}
