package com.shopee.app.ui.order.views;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.util.ak;
import com.shopee.id.R;

public class i extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    Button f23894a;

    /* renamed from: b  reason: collision with root package name */
    Button f23895b;

    /* renamed from: c  reason: collision with root package name */
    private OrderDetail f23896c;

    public i(Context context) {
        super(context);
    }

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public i(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setSeller(OrderDetail orderDetail) {
        this.f23896c = orderDetail;
        if (this.f23896c.isSelling()) {
            this.f23894a.setText(b.e(R.string.sp_contact_buyer));
            this.f23895b.setVisibility(4);
            return;
        }
        this.f23894a.setText(b.e(R.string.sp_contact_seller));
        this.f23895b.setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        com.garena.android.appkit.b.b.a("ORDER_GOTO_CHAT", new a(this.f23896c), b.a.UI_BUS);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        new ak((Activity) getContext()).b(this.f23896c.getShopId());
    }
}
