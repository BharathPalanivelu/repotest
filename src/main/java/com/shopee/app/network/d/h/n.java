package com.shopee.app.network.d.h;

import com.shopee.app.network.a.b;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.GetReturnList;
import com.squareup.wire.Message;

public class n extends az implements b {

    /* renamed from: a  reason: collision with root package name */
    private int f18396a;

    /* renamed from: b  reason: collision with root package name */
    private int f18397b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18398c;

    /* renamed from: d  reason: collision with root package name */
    private int f18399d;

    public int b() {
        return 120;
    }

    public int c() {
        return this.f18396a;
    }

    public int d() {
        return this.f18399d;
    }

    public Message q_() {
        GetReturnList.Builder builder = new GetReturnList.Builder();
        builder.requestid(i().a()).limit(Integer.valueOf(this.f18397b)).offset(Integer.valueOf(this.f18396a)).is_seller(Boolean.valueOf(this.f18398c)).return_sub_list_type(Integer.valueOf(this.f18399d));
        return builder.build();
    }
}
