package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.app.h.o;
import com.shopee.protocol.action.GetUserInfo;
import java.util.ArrayList;
import java.util.List;

public class au extends az {

    /* renamed from: a  reason: collision with root package name */
    private List<Integer> f18128a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private boolean f18129b = false;

    public void a(int i) {
        this.f18128a.clear();
        this.f18128a.add(Integer.valueOf(i));
        o.a().a((az) this);
        g();
    }

    public void a(List<Integer> list) {
        this.f18128a.clear();
        this.f18128a.addAll(list);
        if (this.f18128a.size() > 0) {
            o.a().a((az) this);
            g();
        }
    }

    /* access modifiers changed from: protected */
    public f a() {
        GetUserInfo.Builder builder = new GetUserInfo.Builder();
        builder.requestid(i().a()).userid(this.f18128a);
        return new f(63, builder.build().toByteArray());
    }

    public boolean b() {
        return this.f18129b;
    }
}
