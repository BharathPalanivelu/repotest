package com.shopee.app.ui.setting.CustomerService;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.b.a;
import org.a.a.b.c;

public final class CustomerServiceActivity_ extends a implements a {

    /* renamed from: a  reason: collision with root package name */
    private final c f24999a = new c();

    private void c(Bundle bundle) {
    }

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f24999a);
        c(bundle);
        super.onCreate(bundle);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void setContentView(int i) {
        super.setContentView(i);
        this.f24999a.a((a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f24999a.a((a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f24999a.a((a) this);
    }
}
