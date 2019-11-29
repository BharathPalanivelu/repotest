package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.GetItemCmtList;

public class x extends az {

    /* renamed from: a  reason: collision with root package name */
    public final int f18453a;

    /* renamed from: b  reason: collision with root package name */
    public final long f18454b;

    /* renamed from: c  reason: collision with root package name */
    public final int f18455c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f18456d;

    /* renamed from: e  reason: collision with root package name */
    public final int f18457e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f18458f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f18459g;
    private final boolean h;
    private final int i;
    private final boolean j;

    public x(int i2, long j2, int i3, int i4, boolean z, int i5, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f18453a = i2;
        this.f18454b = j2;
        this.f18455c = i3;
        this.i = i4;
        this.f18456d = z;
        this.f18457e = i5;
        this.f18458f = z2;
        this.h = z3;
        this.f18459g = z4;
        this.j = z5;
    }

    /* access modifiers changed from: protected */
    public f a() {
        GetItemCmtList.Builder builder = new GetItemCmtList.Builder();
        builder.requestid(i().a()).shopid(Integer.valueOf(this.f18453a)).itemid(Long.valueOf(this.f18454b)).offset(Integer.valueOf(this.f18455c)).cmt_only(Boolean.valueOf(this.h)).limit(Integer.valueOf(this.i)).app_version_code(297).rating_only(Boolean.valueOf(this.f18456d));
        if (this.f18456d) {
            builder.type(Integer.valueOf(this.f18457e));
        }
        int i2 = 0;
        if (this.f18459g) {
            i2 = 2;
        }
        if (this.j) {
            i2 |= 1;
        }
        builder.filter(Integer.valueOf(i2));
        return new f(69, builder.build().toByteArray());
    }
}
