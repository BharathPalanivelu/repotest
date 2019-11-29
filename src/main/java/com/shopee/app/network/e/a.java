package com.shopee.app.network.e;

import com.beetalklib.network.d.f;
import com.garena.h.e;
import com.squareup.wire.Message;

public class a implements e {

    /* renamed from: a  reason: collision with root package name */
    private final String f18482a;

    /* renamed from: b  reason: collision with root package name */
    private final f f18483b;

    /* renamed from: c  reason: collision with root package name */
    private final Message f18484c;

    public a(f fVar) {
        this.f18483b = fVar;
        this.f18482a = this.f18483b.toString();
        this.f18484c = null;
    }

    public a(String str, Message message, f fVar) {
        this.f18482a = str;
        this.f18484c = message;
        this.f18483b = fVar;
    }

    public String a() {
        return this.f18482a;
    }

    public byte[] b() {
        return this.f18483b.c();
    }

    public f c() {
        return this.f18483b;
    }
}
