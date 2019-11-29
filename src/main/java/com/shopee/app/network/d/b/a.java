package com.shopee.app.network.d.b;

import com.beetalklib.network.d.f;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.ArchiveChat;
import java.util.List;

public class a extends az {

    /* renamed from: a  reason: collision with root package name */
    private List<Long> f18144a;

    /* renamed from: b  reason: collision with root package name */
    private int f18145b;

    /* access modifiers changed from: protected */
    public f a() {
        ArchiveChat.Builder builder = new ArchiveChat.Builder();
        builder.requestid(i().a()).chatid(this.f18144a).archive(Integer.valueOf(this.f18145b));
        return new f(136, builder.build().toByteArray());
    }

    public List<Long> b() {
        return this.f18144a;
    }

    public int c() {
        return this.f18145b;
    }
}
