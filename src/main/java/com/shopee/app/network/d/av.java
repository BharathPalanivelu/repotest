package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.GetUserLastSeen;
import java.util.List;

public class av extends az {

    /* renamed from: a  reason: collision with root package name */
    private List<Integer> f18130a;

    public void a(List<Integer> list) {
        this.f18130a = list;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        GetUserLastSeen.Builder builder = new GetUserLastSeen.Builder();
        builder.requestid(i().a()).userid(this.f18130a);
        return new f(189, builder.build().toByteArray());
    }
}
