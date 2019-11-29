package com.shopee.app.ui.order.rate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.b.a;
import org.a.a.b.c;

public final class OrderRateActivity_ extends a implements a {

    /* renamed from: e  reason: collision with root package name */
    private final c f23756e = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f23756e);
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
        this.f23756e.a((a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f23756e.a((a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f23756e.a((a) this);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("orderId")) {
                this.f23757a = extras.getLong("orderId");
            }
            if (extras.containsKey("shopId")) {
                this.f23758b = extras.getInt("shopId");
            }
            if (extras.containsKey("UType")) {
                this.f23759c = extras.getInt("UType");
            }
            if (extras.containsKey("orderListType")) {
                this.f23760d = extras.getInt("orderListType");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }
}
