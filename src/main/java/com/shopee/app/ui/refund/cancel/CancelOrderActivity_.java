package com.shopee.app.ui.refund.cancel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.b.a;
import org.a.a.b.c;

public final class CancelOrderActivity_ extends a implements a {

    /* renamed from: c  reason: collision with root package name */
    private final c f24937c = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f24937c);
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
        this.f24937c.a((a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f24937c.a((a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f24937c.a((a) this);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("orderId")) {
                this.f24938a = extras.getLong("orderId");
            }
            if (extras.containsKey("shopId")) {
                this.f24939b = extras.getInt("shopId");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }
}
