package com.shopee.app.ui.product.location;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.b.a;
import org.a.a.b.c;

public final class SetLocationNoticeActivity_ extends b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final c f24616a = new c();

    private void c(Bundle bundle) {
    }

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f24616a);
        c(bundle);
        super.onCreate(bundle);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void setContentView(int i) {
        super.setContentView(i);
        this.f24616a.a((a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f24616a.a((a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f24616a.a((a) this);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1041) {
            a(i2, intent);
        }
    }
}
