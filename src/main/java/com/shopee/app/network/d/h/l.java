package com.shopee.app.network.d.h;

import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.network.a.b;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.GetOrderList;
import com.shopee.protocol.action.OrderListSortOptions;
import com.squareup.wire.Message;

public class l extends az implements b {

    /* renamed from: a  reason: collision with root package name */
    private int f18389a;

    /* renamed from: b  reason: collision with root package name */
    private int f18390b;

    /* renamed from: c  reason: collision with root package name */
    private int f18391c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f18392d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f18393e;

    /* renamed from: f  reason: collision with root package name */
    private OrderKey f18394f;

    public int b() {
        return 11;
    }

    public void a(OrderKey orderKey, int i, int i2, boolean z) {
        this.f18394f = orderKey;
        this.f18389a = orderKey.listType;
        this.f18390b = i;
        this.f18391c = i2;
        boolean z2 = true;
        if (orderKey.uType != 1) {
            z2 = false;
        }
        this.f18392d = z2;
        this.f18393e = z;
        g();
    }

    public OrderKey c() {
        return this.f18394f;
    }

    public int d() {
        return this.f18390b;
    }

    public Message q_() {
        GetOrderList.Builder builder = new GetOrderList.Builder();
        builder.requestid(i().a()).type(Integer.valueOf(this.f18389a)).limit(Integer.valueOf(this.f18391c)).offset(Integer.valueOf(this.f18390b)).is_seller(Boolean.valueOf(this.f18392d));
        if (this.f18393e) {
            builder.sort_options(Integer.valueOf(OrderListSortOptions.TO_SHIP_SHIPPING_CONFIRM_TIME_ASC.getValue()));
        }
        return builder.build();
    }
}
