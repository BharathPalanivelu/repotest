package com.shopee.app.ui.order.detail;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a.a.f;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.appkit.tools.b;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.viewmodel.OrderItemInfo;
import com.shopee.app.util.ak;
import com.shopee.app.util.au;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.id.R;

public class k extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    ImageView f23644a;

    /* renamed from: b  reason: collision with root package name */
    TextView f23645b;

    /* renamed from: c  reason: collision with root package name */
    TextView f23646c;

    /* renamed from: d  reason: collision with root package name */
    TextView f23647d;

    /* renamed from: e  reason: collision with root package name */
    TextView f23648e;

    /* renamed from: f  reason: collision with root package name */
    TextView f23649f;

    /* renamed from: g  reason: collision with root package name */
    int f23650g;
    int h;
    int i;
    int j;
    String k;
    bi l;
    ak m;
    ao n;
    private OrderItemInfo o;

    public interface a {
        void a(k kVar);
    }

    public k(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        ((a) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        setBackgroundResource(R.drawable.bottom_border_white_background_highlight);
        int i2 = this.f23650g;
        int i3 = this.h;
        setPadding(i2, i3, i2, i3);
        setOnClickListener(this);
    }

    public void setOrderItemInfo(OrderItemInfo orderItemInfo) {
        int i2;
        this.o = orderItemInfo;
        if (this.o.isRequestReturned()) {
            i2 = b.a(R.color.black26);
        } else {
            i2 = b.a(R.color.black87);
        }
        z.b(getContext()).a(this.o.getItemImage()).a(this.f23644a);
        this.f23645b.setText(this.o.getItemName());
        if (this.o.getModelId() > 0) {
            this.f23646c.setVisibility(0);
            this.f23646c.setText(b.e(R.string.sp_label_variation) + ": " + this.o.getModelName());
        } else {
            this.f23646c.setVisibility(8);
        }
        f a2 = f.a(getContext());
        if (this.o.isVariant()) {
            if (this.o.isVariantAnOffer()) {
                a2.a().a().b(i2).a(this.i).c().a((Object) au.a(this.o.getOrderPrice(), this.o.getCurrency())).b();
                String a3 = au.a(this.o.getModelPrice(), this.o.getCurrency());
                a2.a(SQLBuilder.BLANK).b();
                a2.a().a().b().b(b.a(R.color.black26)).a(this.i).c().a((Object) a3).b();
            } else if (this.o.variantHasPromotion()) {
                a2.a().a().b().b(b.a(R.color.black26)).a(this.i).c().a((Object) au.a(this.o.getModelPriceBeforeDiscount(), this.o.getCurrency())).b();
                a2.a(SQLBuilder.BLANK).b();
                a2.a().a().b(b.a(R.color.primary)).a(this.i).c().a((Object) au.a(this.o.getModelPrice(), this.o.getCurrency())).b();
            } else {
                a2.a().a().b(i2).a(this.i).c().a((Object) au.a(this.o.getOrderPrice(), this.o.getCurrency())).b();
            }
        } else if (this.o.isAnOffer()) {
            a2.a().a().b(i2).a(this.i).c().a((Object) au.a(this.o.getOrderPrice(), this.o.getCurrency())).b();
            String a4 = au.a(this.o.getItemPrice(), this.o.getCurrency());
            a2.a(SQLBuilder.BLANK).b();
            a2.a().a().b().b(b.a(R.color.black26)).a(this.i).c().a((Object) a4).b();
        } else if (this.o.hasPromotion()) {
            a2.a().a().b().b(b.a(R.color.black26)).a(this.i).c().a((Object) au.a(this.o.getPriceBeforeDiscount(), this.o.getCurrency())).b();
            a2.a(SQLBuilder.BLANK).b();
            a2.a().a().b(b.a(R.color.primary)).a(this.i).c().a((Object) au.a(this.o.getItemPrice(), this.o.getCurrency())).b();
        } else {
            a2.a().a().b(i2).a(this.i).c().a((Object) au.a(this.o.getOrderPrice(), this.o.getCurrency())).b();
        }
        a2.a(this.f23647d);
        if (this.o.isRequestReturned()) {
            this.f23648e.setBackgroundResource(R.drawable.request_return_n_refund_background);
            this.f23648e.setText(R.string.sp_request_return);
            this.f23648e.setTextColor(b.a(R.color.white));
            this.f23648e.setTextSize(2, 12.0f);
            this.f23648e.setPadding(b.a.f7694e, b.a.f7691b, b.a.f7694e, b.a.f7691b);
        } else {
            this.f23648e.setBackgroundResource(R.color.transparent);
            this.f23648e.setText(com.garena.android.appkit.tools.b.a(R.string.sp_order_first_item_buy_n_count, Integer.valueOf(this.o.getAmount())));
            this.f23648e.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
            this.f23648e.setTextSize(2, 14.0f);
            this.f23648e.setPadding(0, 0, 0, 0);
        }
        this.f23645b.setTextColor(i2);
        if (this.o.isRequestReturned()) {
            this.f23644a.setColorFilter(Color.argb(150, 255, 255, 255));
        } else {
            this.f23644a.clearColorFilter();
        }
    }

    public void b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, R.id.product_price);
        layoutParams.addRule(8, R.id.product_image);
        this.f23648e.setLayoutParams(layoutParams);
        this.f23649f.setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        OrderItemInfo orderItemInfo = this.o;
        if (orderItemInfo != null) {
            this.l.a("ORDER_CHAT_PRODUCT_SEND", new com.garena.android.appkit.b.a(orderItemInfo));
        }
    }

    public void onClick(View view) {
        if (this.o.isRequestReturned()) {
            this.m.d(this.o.getShopId(), this.o.getOrderId());
        } else {
            this.m.c(this.o.getShopId(), this.o.getSnapshotId());
        }
    }
}
