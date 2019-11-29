package com.shopee.app.ui.order.detail;

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

public final class OrderExtraInfoView_ extends i implements a, b {
    private boolean h = false;
    private final c i = new c();

    public OrderExtraInfoView_(Context context) {
        super(context);
        b();
    }

    public OrderExtraInfoView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public OrderExtraInfoView_(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }

    public void onFinishInflate() {
        if (!this.h) {
            this.h = true;
            inflate(getContext(), R.layout.extra_info_view, this);
            this.i.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.i);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.f23635f = resources.getDimensionPixelSize(R.dimen.dp16);
        this.f23636g = resources.getDimensionPixelSize(R.dimen.dp8);
        a();
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f23630a = (ImageView) aVar.internalFindViewById(R.id.icon);
        this.f23631b = (TextView) aVar.internalFindViewById(R.id.title);
        this.f23632c = (TextView) aVar.internalFindViewById(R.id.content);
        this.f23633d = (TextView) aVar.internalFindViewById(R.id.extra_info);
        this.f23634e = (TextView) aVar.internalFindViewById(R.id.label);
    }
}
