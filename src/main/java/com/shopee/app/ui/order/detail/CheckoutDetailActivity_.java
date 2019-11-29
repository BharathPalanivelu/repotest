package com.shopee.app.ui.order.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.b.a;
import org.a.a.b.c;

public final class CheckoutDetailActivity_ extends a implements a {

    /* renamed from: c  reason: collision with root package name */
    private final c f23581c = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f23581c);
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
        this.f23581c.a((a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f23581c.a((a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f23581c.a((a) this);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("checkout_id")) {
                this.f23584a = extras.getLong("checkout_id");
            }
            if (extras.containsKey("orderId")) {
                this.f23585b = extras.getLong("orderId");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }
}
