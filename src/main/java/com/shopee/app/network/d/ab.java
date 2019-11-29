package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.GetExtractedHashTag;

public class ab extends az {

    /* renamed from: a  reason: collision with root package name */
    private String f18078a;

    public void a(String str) {
        this.f18078a = str;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        GetExtractedHashTag.Builder builder = new GetExtractedHashTag.Builder();
        builder.text(this.f18078a).requestid(i().a());
        return new f(178, builder.build().toByteArray());
    }
}
