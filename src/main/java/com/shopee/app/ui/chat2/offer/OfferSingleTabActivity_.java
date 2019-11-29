package com.shopee.app.ui.chat2.offer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.b.a;
import org.a.a.b.c;

public final class OfferSingleTabActivity_ extends a implements a {

    /* renamed from: b  reason: collision with root package name */
    private final c f20553b = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f20553b);
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
        this.f20553b.a((a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f20553b.a((a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f20553b.a((a) this);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("userId")) {
            this.f20557a = extras.getInt("userId");
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }
}
