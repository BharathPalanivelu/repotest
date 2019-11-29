package com.shopee.app.ui.common;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class ProductInfoView_ extends w implements a, b {
    private boolean s = false;
    private final c t = new c();

    public ProductInfoView_(Context context) {
        super(context);
        b();
    }

    public ProductInfoView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public ProductInfoView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    public void onFinishInflate() {
        if (!this.s) {
            this.s = true;
            inflate(getContext(), R.layout.product_info_layout, this);
            this.t.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.t);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.i = resources.getString(R.string.sp_selling);
        this.j = resources.getString(R.string.sp_buying);
        this.m = resources.getDimensionPixelOffset(R.dimen.font_size_12);
        this.n = resources.getDimensionPixelOffset(R.dimen.font_size_18);
        this.k = androidx.core.content.b.c(getContext(), R.color.black26);
        this.l = androidx.core.content.b.c(getContext(), R.color.black87);
        this.o = androidx.core.content.b.c(getContext(), R.color.primary);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21354a = (ImageView) aVar.internalFindViewById(R.id.product_image);
        this.f21355b = aVar.internalFindViewById(R.id.product_overlay);
        this.f21356c = (TextView) aVar.internalFindViewById(R.id.title_label);
        this.f21357d = (TextView) aVar.internalFindViewById(R.id.product_variation);
        this.f21358e = (TextView) aVar.internalFindViewById(R.id.price_label);
        this.f21359f = (TextView) aVar.internalFindViewById(R.id.deleted_label);
        this.f21360g = (TextView) aVar.internalFindViewById(R.id.like_count);
        this.h = (TextView) aVar.internalFindViewById(R.id.comment_count);
        a();
    }
}
