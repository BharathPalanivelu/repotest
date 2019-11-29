package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.facebook.imageutils.JfifUtil;
import com.shopee.protocol.action.GetFeedComment;

public class ac extends az {

    /* renamed from: a  reason: collision with root package name */
    private long f18079a;

    /* renamed from: b  reason: collision with root package name */
    private long f18080b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18081c;

    /* renamed from: d  reason: collision with root package name */
    private final int f18082d = 20;

    public ac(long j, long j2, boolean z) {
        this.f18079a = j;
        this.f18080b = j2;
        this.f18081c = z;
    }

    /* access modifiers changed from: protected */
    public f a() {
        GetFeedComment.Builder builder = new GetFeedComment.Builder();
        builder.requestid(i().a()).feedid(Long.valueOf(this.f18079a)).last_timestamp(Long.valueOf(this.f18080b)).limit(20);
        return new f(JfifUtil.MARKER_SOFn, builder.build().toByteArray());
    }

    public boolean b() {
        return this.f18081c;
    }

    public long c() {
        return this.f18079a;
    }
}
