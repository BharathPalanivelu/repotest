package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.app.util.af;
import com.shopee.protocol.action.SetChatQuickReply;
import java.util.List;

public class bh extends az {

    /* renamed from: a  reason: collision with root package name */
    private List<String> f18184a = null;

    /* renamed from: b  reason: collision with root package name */
    private boolean f18185b;

    public void a(boolean z, List<String> list) {
        this.f18185b = z;
        this.f18184a = list;
        h();
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        SetChatQuickReply.Builder builder = new SetChatQuickReply.Builder();
        builder.requestid(i().a()).is_on(Boolean.valueOf(this.f18185b));
        if (!af.a(this.f18184a)) {
            builder.content(this.f18184a);
        }
        builder.build();
        return new f(126, builder.build().toByteArray());
    }

    public List<String> b() {
        return this.f18184a;
    }

    public boolean c() {
        return this.f18185b;
    }
}
