package com.shopee.app.network.d.c;

import com.beetalklib.network.d.f;
import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.BlockUser;
import com.tencent.qalsdk.im_open.http;

public class a extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18233a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f18234b;

    public boolean b() {
        return this.f18234b;
    }

    public int c() {
        return this.f18233a;
    }

    public void a(int i, boolean z) {
        this.f18233a = i;
        this.f18234b = z;
        o.a().a((az) this);
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        BlockUser.Builder builder = new BlockUser.Builder();
        builder.requestid(i().a()).userid(Integer.valueOf(this.f18233a)).block(Boolean.valueOf(this.f18234b)).build();
        return new f(http.Partial_Content, builder.build().toByteArray());
    }
}
