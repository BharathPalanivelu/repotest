package com.shopee.app.ui.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class IconImageView_ extends m implements a, b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f20981a = false;

    /* renamed from: b  reason: collision with root package name */
    private final c f20982b = new c();

    public IconImageView_(Context context) {
        super(context);
        b();
    }

    public IconImageView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public IconImageView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    public void onFinishInflate() {
        if (!this.f20981a) {
            this.f20981a = true;
            this.f20982b.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f20982b);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        a();
    }
}
