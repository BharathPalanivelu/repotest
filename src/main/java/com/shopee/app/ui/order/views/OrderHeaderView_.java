package com.shopee.app.ui.order.views;

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

public final class OrderHeaderView_ extends d implements a, b {
    private boolean i = false;
    private final c j = new c();

    public OrderHeaderView_(Context context) {
        super(context);
        e();
    }

    public OrderHeaderView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e();
    }

    public OrderHeaderView_(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        e();
    }

    public static d a(Context context) {
        OrderHeaderView_ orderHeaderView_ = new OrderHeaderView_(context);
        orderHeaderView_.onFinishInflate();
        return orderHeaderView_;
    }

    public void onFinishInflate() {
        if (!this.i) {
            this.i = true;
            inflate(getContext(), R.layout.order_header_layout, this);
            this.j.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        c a2 = c.a(this.j);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.f23875e = resources.getDimensionPixelSize(R.dimen.dp16);
        this.f23876f = androidx.core.content.b.c(getContext(), R.color.primary);
        this.f23877g = androidx.core.content.b.c(getContext(), R.color.black87);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f23871a = (ImageView) aVar.internalFindViewById(R.id.avatar);
        this.f23872b = (TextView) aVar.internalFindViewById(R.id.username);
        this.f23873c = (TextView) aVar.internalFindViewById(R.id.status);
        this.f23874d = aVar.internalFindViewById(R.id.divider);
        this.h = aVar.internalFindViewById(R.id.officialShopIcon);
        a();
    }
}
