package com.shopee.app.ui.image.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class PresetToolbar_ extends h implements a, b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f22854b = false;

    /* renamed from: c  reason: collision with root package name */
    private final c f22855c = new c();

    public PresetToolbar_(Context context) {
        super(context);
        b();
    }

    public PresetToolbar_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public PresetToolbar_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    public void onFinishInflate() {
        if (!this.f22854b) {
            this.f22854b = true;
            inflate(getContext(), R.layout.preset_toolbar_layout, this);
            this.f22855c.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f22855c);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f22946a = (LinearLayout) aVar.internalFindViewById(R.id.container);
        a();
    }
}
