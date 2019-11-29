package com.shopee.app.ui.chat2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class KeyboardPane_ extends r implements a, b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f20192b = false;

    /* renamed from: c  reason: collision with root package name */
    private final c f20193c = new c();

    public KeyboardPane_(Context context) {
        super(context);
        j();
    }

    public KeyboardPane_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j();
    }

    public KeyboardPane_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j();
    }

    public KeyboardPane_(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        j();
    }

    public void onFinishInflate() {
        if (!this.f20192b) {
            this.f20192b = true;
            this.f20193c.a((a) this);
        }
        super.onFinishInflate();
    }

    private void j() {
        c a2 = c.a(this.f20193c);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20845a = aVar.internalFindViewById(R.id.keyboardMargin);
        a();
    }
}
