package com.shopee.app.ui.order.rate;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a.a.f;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.c.a;
import com.shopee.app.data.viewmodel.OrderItemInfo;
import com.shopee.app.data.viewmodel.OrderRateItemInfo;
import com.shopee.app.ui.a.n;
import com.shopee.app.util.au;
import com.shopee.app.util.z;
import com.shopee.id.R;

public class b extends RelativeLayout implements n<OrderRateItemInfo> {

    /* renamed from: a  reason: collision with root package name */
    int f23762a = 0;

    /* renamed from: b  reason: collision with root package name */
    ImageView f23763b;

    /* renamed from: c  reason: collision with root package name */
    TextView f23764c;

    /* renamed from: d  reason: collision with root package name */
    TextView f23765d;

    /* renamed from: e  reason: collision with root package name */
    TextView f23766e;

    /* renamed from: f  reason: collision with root package name */
    Button f23767f;

    /* renamed from: g  reason: collision with root package name */
    Button f23768g;
    Button h;
    EditText i;
    int j;
    int k;
    int l;
    private OrderRateItemInfo m;

    public b(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.i.setBackgroundResource(R.drawable.edit_text_bg);
    }

    public void a(OrderRateItemInfo orderRateItemInfo) {
        this.m = orderRateItemInfo;
        OrderItemInfo orderItemInfo = orderRateItemInfo.getOrderItemInfo();
        z.b(getContext()).a(orderItemInfo.getItemImage()).a(this.f23763b);
        if (!TextUtils.isEmpty(orderItemInfo.getModelName())) {
            this.f23766e.setVisibility(0);
            this.f23766e.setText(com.garena.android.appkit.tools.b.e(R.string.sp_label_variation) + ": " + orderItemInfo.getModelName());
        } else {
            this.f23766e.setVisibility(8);
        }
        this.f23764c.setText(orderItemInfo.getItemName());
        f a2 = f.a(getContext());
        if (orderItemInfo.isAnOffer()) {
            a2.a().a().b(this.j).a(this.l).c().a((Object) au.a(orderItemInfo.getOrderPrice(), orderItemInfo.getCurrency())).b();
            String a3 = au.a(orderItemInfo.getItemPrice(), orderItemInfo.getCurrency());
            a2.a(SQLBuilder.BLANK).b();
            a2.a().a().b().b(this.k).a(this.l).c().a((Object) a3).b();
        } else if (orderItemInfo.hasPromotion()) {
            a2.a().a().b().b(this.k).a(this.l).c().a((Object) au.a(orderItemInfo.getPriceBeforeDiscount(), orderItemInfo.getCurrency())).b();
            a2.a(SQLBuilder.BLANK).b();
            a2.a().a().b(this.j).a(this.l).c().a((Object) au.a(orderItemInfo.getItemPrice(), orderItemInfo.getCurrency())).b();
        } else {
            a2.a().a().b(this.j).a(this.l).c().a((Object) au.a(orderItemInfo.getOrderPrice(), orderItemInfo.getCurrency())).b();
        }
        a2.a(this.f23765d);
        this.f23762a = 1;
        f();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f23762a = 1;
        f();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f23762a = 0;
        f();
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f23762a = -1;
        f();
    }

    /* access modifiers changed from: package-private */
    public void a(Editable editable) {
        this.m.setComment(editable.toString());
    }

    private void f() {
        this.m.setRate(this.f23762a);
        int i2 = this.f23762a;
        if (i2 == -1) {
            this.f23767f.setBackgroundResource(R.drawable.btn_secondary_primary);
            this.f23768g.setBackgroundResource(R.drawable.btn_secondary_complement);
            this.h.setBackgroundResource(R.drawable.btn_secondary_grey_reverse);
        } else if (i2 == 0) {
            this.f23767f.setBackgroundResource(R.drawable.btn_secondary_primary);
            this.f23768g.setBackgroundResource(R.drawable.btn_secondary_complement_reverse);
            this.h.setBackgroundResource(R.drawable.btn_secondary_grey);
        } else if (i2 == 1) {
            this.f23767f.setBackgroundResource(R.drawable.btn_secondary_primary_reverse);
            this.f23768g.setBackgroundResource(R.drawable.btn_secondary_complement);
            this.h.setBackgroundResource(R.drawable.btn_secondary_grey);
        }
    }

    public void e() {
        this.i.requestFocus();
        a.b(this.i);
    }
}
