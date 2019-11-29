package com.shopee.app.network.d.c;

import com.beetalklib.network.d.f;
import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import com.shopee.live.livestreaming.data.entity.DanmaKuEntity;
import com.shopee.protocol.action.GetPchatList;

public class d extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18236a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f18237b;

    public void a(int i, boolean z) {
        this.f18236a = i;
        this.f18237b = z;
        o.a().a((az) this);
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        GetPchatList.Builder builder = new GetPchatList.Builder();
        builder.requestid(i().a()).last_timestamp(Integer.valueOf(this.f18236a)).start_from_old(Boolean.valueOf(this.f18237b)).build();
        return new f(DanmaKuEntity.MESSAGE_PUBLIC, builder.build().toByteArray());
    }

    public boolean b() {
        return this.f18237b;
    }

    public int c() {
        return this.f18236a;
    }
}
