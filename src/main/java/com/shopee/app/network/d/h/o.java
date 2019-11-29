package com.shopee.app.network.d.h;

import com.shopee.app.network.a.b;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.GetReturnList;
import com.squareup.wire.Message;

public class o extends az implements b {

    /* renamed from: a  reason: collision with root package name */
    private int f18400a;

    /* renamed from: b  reason: collision with root package name */
    private int f18401b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18402c;

    /* renamed from: d  reason: collision with root package name */
    private int f18403d;

    public int b() {
        return 143;
    }

    public void a(boolean z, int i, int i2, int i3) {
        this.f18400a = i;
        this.f18401b = i2;
        this.f18402c = z;
        this.f18403d = i3;
        g();
    }

    public int c() {
        return this.f18400a;
    }

    public int d() {
        return this.f18403d;
    }

    public Message q_() {
        GetReturnList.Builder builder = new GetReturnList.Builder();
        builder.requestid(i().a()).limit(Integer.valueOf(this.f18401b)).offset(Integer.valueOf(this.f18400a)).is_seller(Boolean.valueOf(this.f18402c)).return_sub_list_type(Integer.valueOf(this.f18403d));
        return builder.build();
    }
}
