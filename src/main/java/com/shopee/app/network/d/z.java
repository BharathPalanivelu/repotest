package com.shopee.app.network.d;

import android.util.Base64;
import com.shopee.app.network.a.b;
import com.shopee.protocol.action.GetContacts;
import com.squareup.wire.Message;
import e.f;

public class z extends az implements b {

    /* renamed from: a  reason: collision with root package name */
    private int f18467a;

    /* renamed from: b  reason: collision with root package name */
    private int f18468b;

    /* renamed from: c  reason: collision with root package name */
    private int f18469c;

    /* renamed from: d  reason: collision with root package name */
    private String f18470d;

    public int b() {
        return 111;
    }

    public void a(int i, int i2, int i3, String str) {
        this.f18467a = i;
        this.f18469c = i2;
        this.f18468b = i3;
        this.f18470d = str;
        g();
    }

    public int c() {
        return this.f18467a;
    }

    public int d() {
        return this.f18468b;
    }

    public Message q_() {
        GetContacts.Builder builder = new GetContacts.Builder();
        builder.requestid(i().a()).acctype(Integer.valueOf(this.f18467a)).offset(Integer.valueOf(this.f18468b)).limit(Integer.valueOf(this.f18469c)).deviceid(f.a(Base64.decode(this.f18470d, 0)));
        return builder.build();
    }
}
