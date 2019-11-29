package com.shopee.app.ui.order.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class OrderInfoView_ extends e implements a, b {
    private boolean k = false;
    private final c l = new c();

    public OrderInfoView_(Context context) {
        super(context);
        b();
    }

    public OrderInfoView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public OrderInfoView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    public static e a(Context context) {
        OrderInfoView_ orderInfoView_ = new OrderInfoView_(context);
        orderInfoView_.onFinishInflate();
        return orderInfoView_;
    }

    public void onFinishInflate() {
        if (!this.k) {
            this.k = true;
            inflate(getContext(), R.layout.order_info_layout, this);
            this.l.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.l);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23878a = (TextView) aVar.internalFindViewById(R.id.order_number);
        this.f23879b = (TextView) aVar.internalFindViewById(R.id.order_time);
        this.f23880c = (TextView) aVar.internalFindViewById(R.id.order_payment_time);
        this.f23881d = (TextView) aVar.internalFindViewById(R.id.txt_order_payment_time);
        this.f23882e = (TextView) aVar.internalFindViewById(R.id.order_deliver_time);
        this.f23883f = (TextView) aVar.internalFindViewById(R.id.txt_order_deliver_time);
        this.f23884g = (TextView) aVar.internalFindViewById(R.id.order_complete_time);
        this.h = (TextView) aVar.internalFindViewById(R.id.txt_order_complete_time);
        this.i = (TextView) aVar.internalFindViewById(R.id.order_cancel_time);
        this.j = (TextView) aVar.internalFindViewById(R.id.txt_order_cancel_time);
        a();
    }
}
