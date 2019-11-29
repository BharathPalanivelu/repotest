package com.shopee.app.ui.order.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class OrderShopFooter_ extends i implements a, b {

    /* renamed from: c  reason: collision with root package name */
    private boolean f23859c = false;

    /* renamed from: d  reason: collision with root package name */
    private final c f23860d = new c();

    public OrderShopFooter_(Context context) {
        super(context);
        c();
    }

    public OrderShopFooter_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public OrderShopFooter_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }

    public static i a(Context context) {
        OrderShopFooter_ orderShopFooter_ = new OrderShopFooter_(context);
        orderShopFooter_.onFinishInflate();
        return orderShopFooter_;
    }

    public void onFinishInflate() {
        if (!this.f23859c) {
            this.f23859c = true;
            inflate(getContext(), R.layout.order_shop_footer_layout, this);
            this.f23860d.a((a) this);
        }
        super.onFinishInflate();
    }

    private void c() {
        c a2 = c.a(this.f23860d);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23894a = (Button) aVar.internalFindViewById(R.id.contact_btn);
        this.f23895b = (Button) aVar.internalFindViewById(R.id.visit_shop_btn);
        if (this.f23894a != null) {
            this.f23894a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    OrderShopFooter_.this.a();
                }
            });
        }
        if (this.f23895b != null) {
            this.f23895b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    OrderShopFooter_.this.b();
                }
            });
        }
    }
}
