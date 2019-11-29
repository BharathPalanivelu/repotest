package com.shopee.app.ui.chat.order;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a.a.d;
import com.a.a.f;
import com.garena.android.appkit.tools.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.util.ai;
import com.shopee.app.util.ak;
import com.shopee.app.util.au;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class b extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    ImageView f20179a;

    /* renamed from: b  reason: collision with root package name */
    TextView f20180b;

    /* renamed from: c  reason: collision with root package name */
    TextView f20181c;

    /* renamed from: d  reason: collision with root package name */
    TextView f20182d;

    /* renamed from: e  reason: collision with root package name */
    ImageButton f20183e;

    /* renamed from: f  reason: collision with root package name */
    String f20184f;

    /* renamed from: g  reason: collision with root package name */
    String f20185g;
    String h;
    String i;
    int j;
    int k;
    int l;
    int m;
    a n;
    bc o;
    ak p;
    Activity q;
    private f r;
    private d s;
    private OrderDetail t;

    public void a(OrderDetail orderDetail) {
    }

    public void b(OrderDetail orderDetail) {
    }

    public b(Context context) {
        super(context);
        a(context);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public b(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        ((com.shopee.app.ui.chat.b) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.r = f.a(getContext());
        this.r.a().a("order_total").a().b(this.k).c().b();
        this.r.a().a("order_qty").b();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.o.a(this.n);
        this.n.a(this);
        if (com.garena.android.appkit.tools.b.c()) {
            this.f20183e.setScaleType(ImageView.ScaleType.MATRIX);
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f20183e.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.addRule(15);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        OrderDetail orderDetail = this.t;
        if (orderDetail == null) {
            return;
        }
        if (!orderDetail.isUnPaid() || this.t.isSelling()) {
            this.p.a(this.t.getOrderId(), this.t.getShopId());
        } else {
            this.p.a(this.t.getCheckoutId(), this.t.getOrderId(), this.t.getShopId());
        }
    }

    public void setOrderInfo(OrderDetail orderDetail) {
        String str;
        this.t = orderDetail;
        this.r.b("order_total").a((Object) au.b(orderDetail.getTotalPrice()));
        if (orderDetail.getTotalCount() == 1) {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_chat_list_1_item);
        } else {
            str = com.garena.android.appkit.tools.b.a(R.string.sp_chat_list_n_items, Integer.valueOf(orderDetail.getTotalCount()));
        }
        d b2 = this.r.b("order_qty");
        b2.a((Object) " [" + str + "]");
        this.r.a(this.f20180b);
        TextView textView = this.f20181c;
        textView.setText(this.h + ": #" + orderDetail.getSerialNumber());
        TextView textView2 = this.f20182d;
        textView2.setText(this.i + ": " + a.a(orderDetail.getCreateTime(), "ID"));
        if (orderDetail.isSelling()) {
            a(orderDetail);
        } else {
            b(orderDetail);
        }
        ai.a(getContext()).a(orderDetail.getImages(), this.f20179a);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        Integer num = (Integer) this.f20183e.getTag();
        if (num == null || num.equals(0)) {
            this.f20183e.setTag(1);
            this.f20183e.setImageResource(R.drawable.com_garena_shopee_ic_chat_collapse);
            f();
            return;
        }
        this.f20183e.setTag(0);
        this.f20183e.setImageResource(R.drawable.com_garena_shopee_ic_chat_expand);
        g();
    }

    private void f() {
        if (this.t != null) {
            if (this.s == null) {
                this.s = e.a(getContext());
                h();
            }
            this.s.setProducts(this.t.getItems());
            this.s.setVisibility(0);
        }
    }

    private void g() {
        d dVar = this.s;
        if (dVar != null) {
            dVar.setVisibility(8);
        }
    }

    private void h() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = getHeight();
        ((FrameLayout) getParent().getParent()).addView(this.s, layoutParams);
    }

    public void e() {
        this.q.finish();
    }
}
