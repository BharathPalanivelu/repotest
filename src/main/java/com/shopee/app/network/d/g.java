package com.shopee.app.network.d;

import android.text.TextUtils;
import com.beetalklib.network.d.f;
import com.shopee.app.h.o;
import com.shopee.app.web.protocol.AddCartMessage;
import com.shopee.protocol.action.CartAddItem;
import com.shopee.protocol.action.CartItemInfo;

public class g extends az {

    /* renamed from: a  reason: collision with root package name */
    private long f18341a;

    /* renamed from: b  reason: collision with root package name */
    private int f18342b;

    /* renamed from: c  reason: collision with root package name */
    private int f18343c;

    /* renamed from: d  reason: collision with root package name */
    private long f18344d;

    /* renamed from: e  reason: collision with root package name */
    private AddCartMessage f18345e;

    public void a(long j, int i, int i2, long j2, AddCartMessage addCartMessage) {
        this.f18341a = j;
        this.f18342b = i;
        this.f18343c = i2;
        this.f18344d = j2;
        this.f18345e = addCartMessage;
        this.f18345e.setSelectedModelId(j2);
        g();
    }

    public void a(long j, int i, int i2, AddCartMessage addCartMessage) {
        this.f18341a = j;
        this.f18342b = i;
        this.f18343c = i2;
        this.f18344d = -1;
        this.f18345e = addCartMessage;
        this.f18345e.setSelectedModelId(this.f18344d);
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        o.a().a((az) this);
        CartItemInfo.Builder builder = new CartItemInfo.Builder();
        builder.itemid(Long.valueOf(this.f18341a)).quantity(Integer.valueOf(this.f18342b));
        long j = this.f18344d;
        if (j > 0) {
            builder.modelid(Long.valueOf(j));
        }
        if (!TextUtils.isEmpty(this.f18345e.getSource())) {
            builder.source(this.f18345e.getSource());
        }
        CartAddItem.Builder builder2 = new CartAddItem.Builder();
        builder2.requestid(i().a()).iteminfo(builder.build());
        int i = this.f18343c;
        if (i != 0) {
            builder2.shopid(Integer.valueOf(i));
        }
        return new f(84, builder2.build().toByteArray());
    }

    public AddCartMessage b() {
        return this.f18345e;
    }

    public int c() {
        return this.f18342b;
    }
}
