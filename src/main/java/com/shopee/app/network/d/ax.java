package com.shopee.app.network.d;

import com.shopee.app.network.a.b;
import com.shopee.protocol.action.GetItemDetail;
import com.squareup.wire.Message;

public class ax extends az implements b {

    /* renamed from: a  reason: collision with root package name */
    private int f18132a;

    /* renamed from: b  reason: collision with root package name */
    private long f18133b;

    public int b() {
        return 4;
    }

    public ax(int i, long j) {
        this.f18132a = i;
        this.f18133b = j;
    }

    public Message q_() {
        GetItemDetail.Builder builder = new GetItemDetail.Builder();
        builder.requestid(i().a()).shopid(Integer.valueOf(this.f18132a)).itemid(Long.valueOf(this.f18133b)).need_deleted_items(true);
        return builder.build();
    }
}
