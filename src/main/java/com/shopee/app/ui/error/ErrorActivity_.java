package com.shopee.app.ui.error;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import org.a.a.b.a;
import org.a.a.b.c;

public final class ErrorActivity_ extends a implements a {

    /* renamed from: b  reason: collision with root package name */
    private final c f21603b = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f21603b);
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
        this.f21603b.a((a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f21603b.a((a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f21603b.a((a) this);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("errorTitle")) {
            this.f21604a = extras.getString("errorTitle");
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }
}
