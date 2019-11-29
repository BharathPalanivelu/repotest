package com.shopee.app.ui.product.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class ProductPriceView_ extends b implements a, b {

    /* renamed from: g  reason: collision with root package name */
    private boolean f24597g = false;
    private final c h = new c();

    public ProductPriceView_(Context context) {
        super(context);
        e();
    }

    public ProductPriceView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e();
    }

    public void onFinishInflate() {
        if (!this.f24597g) {
            this.f24597g = true;
            inflate(getContext(), R.layout.product_option_view, this);
            this.h.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        c a2 = c.a(this.h);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f24609a = (EditText) aVar.internalFindViewById(R.id.edit_value);
        this.f24610b = (ImageView) aVar.internalFindViewById(R.id.product_icon);
        this.f24611c = (TextView) aVar.internalFindViewById(R.id.product_title);
        this.f24612d = (TextView) aVar.internalFindViewById(R.id.text_value);
        this.f24613e = (ProgressBar) aVar.internalFindViewById(R.id.progress1);
        this.f24614f = aVar.internalFindViewById(R.id.arrowIcon);
        a();
    }
}
