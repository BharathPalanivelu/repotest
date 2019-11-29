package com.shopee.app.ui.product.attributes;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class AttributeMultipleItemView_ extends t implements a, b {

    /* renamed from: d  reason: collision with root package name */
    private boolean f24236d = false;

    /* renamed from: e  reason: collision with root package name */
    private final c f24237e = new c();

    public AttributeMultipleItemView_(Context context) {
        super(context);
        d();
    }

    public AttributeMultipleItemView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    public void onFinishInflate() {
        if (!this.f24236d) {
            this.f24236d = true;
            inflate(getContext(), R.layout.attribute_multiple_item, this);
            this.f24237e.a((a) this);
        }
        super.onFinishInflate();
    }

    private void d() {
        c a2 = c.a(this.f24237e);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f24343a = (LinearLayout) aVar.internalFindViewById(R.id.attribute_multiple_section);
        this.f24344b = aVar.internalFindViewById(R.id.divider);
    }
}
