package com.shopee.app.ui.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class QuantityManageView_ extends f implements a, b {

    /* renamed from: g  reason: collision with root package name */
    private boolean f21488g = false;
    private final c h = new c();

    public QuantityManageView_(Context context) {
        super(context);
        b();
    }

    public QuantityManageView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public QuantityManageView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    public void onFinishInflate() {
        if (!this.f21488g) {
            this.f21488g = true;
            inflate(getContext(), R.layout.quantity_manage_view_layout, this);
            this.h.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.h);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21549a = (ImageButton) aVar.internalFindViewById(R.id.minus_btn);
        this.f21550b = (ImageButton) aVar.internalFindViewById(R.id.plus_btn);
        this.f21551c = (TextView) aVar.internalFindViewById(R.id.quantity_title);
        this.f21552d = (MaterialEditText) aVar.internalFindViewById(R.id.product_quantity);
        a();
    }
}
