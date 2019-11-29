package com.shopee.app.network.d.e;

import com.beetalklib.network.d.f;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.GetTransHistory;

public class b extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18258a;

    /* renamed from: b  reason: collision with root package name */
    private int f18259b;

    /* renamed from: c  reason: collision with root package name */
    private int f18260c;

    /* renamed from: d  reason: collision with root package name */
    private int f18261d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f18262e = -1;

    public void a(int i, int i2, int i3) {
        this.f18258a = i;
        this.f18259b = i2;
        this.f18260c = i3;
        g();
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        this.f18258a = i;
        this.f18259b = i2;
        this.f18260c = i3;
        this.f18261d = i4;
        this.f18262e = i5;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        GetTransHistory.Builder builder = new GetTransHistory.Builder();
        builder.requestid(i().a()).histype(Integer.valueOf(this.f18258a)).limit(Integer.valueOf(this.f18260c)).offset(Integer.valueOf(this.f18259b));
        int i = this.f18261d;
        if (!(i == -1 || this.f18262e == -1)) {
            builder.time_begin(Integer.valueOf(i)).time_end(Integer.valueOf(this.f18262e));
        }
        return new f(51, builder.build().toByteArray());
    }

    public int b() {
        return this.f18258a;
    }

    public int c() {
        return this.f18259b;
    }
}
