package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.ReportItem;

public class bb extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18166a;

    /* renamed from: b  reason: collision with root package name */
    private long f18167b;

    /* renamed from: c  reason: collision with root package name */
    private String f18168c;

    public void a(int i, long j, String str) {
        this.f18166a = i;
        this.f18167b = j;
        this.f18168c = str;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        ReportItem.Builder builder = new ReportItem.Builder();
        builder.requestid(i().a()).shopid(Integer.valueOf(this.f18166a)).itemid(Long.valueOf(this.f18167b)).reason(this.f18168c);
        return new f(29, builder.build().toByteArray());
    }
}
