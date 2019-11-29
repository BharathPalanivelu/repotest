package com.shopee.app.network.d;

import android.util.Base64;
import com.beetalklib.network.d.f;
import com.shopee.protocol.action.FollowAllContacts;

public class p extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18442a;

    /* renamed from: b  reason: collision with root package name */
    private String f18443b;

    public void a(int i, String str) {
        this.f18442a = i;
        this.f18443b = str;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        FollowAllContacts.Builder builder = new FollowAllContacts.Builder();
        builder.requestid(i().a()).acctype(Integer.valueOf(this.f18442a)).deviceid(e.f.a(Base64.decode(this.f18443b, 0)));
        return new f(109, builder.build().toByteArray());
    }
}
