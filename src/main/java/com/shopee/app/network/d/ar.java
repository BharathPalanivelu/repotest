package com.shopee.app.network.d;

import com.shopee.app.network.a.b;
import com.shopee.protocol.action.GetSubCategory;
import com.squareup.wire.Message;

public class ar extends az implements b {

    /* renamed from: a  reason: collision with root package name */
    private int f18121a;

    /* renamed from: b  reason: collision with root package name */
    private int f18122b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18123c;

    public int b() {
        return 219;
    }

    public void a(int i, int i2, boolean z) {
        this.f18121a = i;
        this.f18122b = i2;
        this.f18123c = z;
        g();
    }

    public boolean c() {
        return this.f18123c;
    }

    public Message q_() {
        h();
        GetSubCategory.Builder builder = new GetSubCategory.Builder();
        builder.requestid(i().a()).levels(Integer.valueOf(this.f18122b)).parent_catid(Integer.valueOf(this.f18121a)).country("ID").build();
        return builder.build();
    }
}
