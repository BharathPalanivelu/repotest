package com.shopee.app.ui.order.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class OrderRemarkView_ extends h implements a, b {

    /* renamed from: c  reason: collision with root package name */
    private boolean f23857c = false;

    /* renamed from: d  reason: collision with root package name */
    private final c f23858d = new c();

    public OrderRemarkView_(Context context) {
        super(context);
        b();
    }

    public OrderRemarkView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public OrderRemarkView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    public static h a(Context context) {
        OrderRemarkView_ orderRemarkView_ = new OrderRemarkView_(context);
        orderRemarkView_.onFinishInflate();
        return orderRemarkView_;
    }

    public void onFinishInflate() {
        if (!this.f23857c) {
            this.f23857c = true;
            inflate(getContext(), R.layout.order_remark_layout, this);
            this.f23858d.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f23858d);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23892a = (TextView) aVar.internalFindViewById(R.id.remark_label);
        this.f23893b = (TextView) aVar.internalFindViewById(R.id.remark_text);
        a();
    }
}
