package com.shopee.app.ui.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class QuantityManageView2_ extends g implements a, b {
    private boolean h = false;
    private final c i = new c();

    public QuantityManageView2_(Context context) {
        super(context);
        d();
    }

    public QuantityManageView2_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    public QuantityManageView2_(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        d();
    }

    public void onFinishInflate() {
        if (!this.h) {
            this.h = true;
            inflate(getContext(), R.layout.quantity_manage_view_layout2, this);
            this.i.a((a) this);
        }
        super.onFinishInflate();
    }

    private void d() {
        c a2 = c.a(this.i);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.f21564f = resources.getString(R.string.sp_quantity_not_0);
        this.f21565g = resources.getString(R.string.sp_quantity_exceed_stock);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f21559a = (ImageView) aVar.internalFindViewById(R.id.minus_btn);
        this.f21560b = (ImageView) aVar.internalFindViewById(R.id.plus_btn);
        this.f21561c = (TextView) aVar.internalFindViewById(R.id.quantity_title);
        this.f21562d = (MaterialEditText) aVar.internalFindViewById(R.id.product_quantity);
        this.f21563e = aVar.internalFindViewById(R.id.wholesaleHintView);
        a();
    }
}
