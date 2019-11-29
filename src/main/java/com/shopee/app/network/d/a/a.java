package com.shopee.app.network.d.a;

import com.shopee.app.network.a.b;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.ActionGetContent;
import com.squareup.wire.Message;
import java.util.List;

public class a extends az implements b {

    /* renamed from: a  reason: collision with root package name */
    private List<Long> f18068a;

    /* renamed from: b  reason: collision with root package name */
    private long f18069b = -1;

    public int b() {
        return 105;
    }

    public void a(List<Long> list) {
        this.f18068a = list;
        g();
    }

    public long c() {
        return this.f18069b;
    }

    public void a(long j) {
        this.f18069b = j;
    }

    public boolean d() {
        return this.f18069b > 0;
    }

    public Message q_() {
        return new ActionGetContent.Builder().requestid(i().a()).actionid_list(this.f18068a).build();
    }
}
