package com.shopee.app.network.d;

import com.shopee.app.h.o;
import com.shopee.app.network.a.b;
import com.shopee.protocol.action.GetWallet;
import com.squareup.wire.Message;

public class aw extends az implements b {

    /* renamed from: a  reason: collision with root package name */
    private int f18131a;

    public int b() {
        return 226;
    }

    public static aw c() {
        return new aw(1);
    }

    public static aw d() {
        return new aw(2);
    }

    private aw(int i) {
        this.f18131a = i;
    }

    public int e() {
        return this.f18131a;
    }

    /* access modifiers changed from: protected */
    public void f() {
        super.f();
        o.a().a((az) this);
    }

    public Message q_() {
        return new GetWallet.Builder().requestid(i().a()).wallet_type(Integer.valueOf(this.f18131a)).build();
    }
}
