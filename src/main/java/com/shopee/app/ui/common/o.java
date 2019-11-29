package com.shopee.app.ui.common;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.ui.a.n;

public class o extends RelativeLayout implements n {

    /* renamed from: a  reason: collision with root package name */
    TextView f21301a;

    public o(Context context) {
        super(context);
    }

    public o(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public o(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setText(int i) {
        this.f21301a.setText(i);
    }

    public void setText(String str) {
        this.f21301a.setText(str);
    }

    public void a(OrderDetail orderDetail) {
        setText(orderDetail.getRemark());
    }

    public void a(CheckoutItem checkoutItem) {
        setText(checkoutItem.getRemark());
    }

    public void a(Object obj) {
        if (obj instanceof OrderDetail) {
            a((OrderDetail) obj);
        } else if (obj instanceof CheckoutItem) {
            a((CheckoutItem) obj);
        }
    }
}
