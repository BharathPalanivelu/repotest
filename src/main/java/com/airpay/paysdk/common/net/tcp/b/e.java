package com.airpay.paysdk.common.net.tcp.b;

import com.airpay.paysdk.common.net.a.a.g;
import com.airpay.paysdk.common.net.tcp.d.a;
import com.airpay.paysdk.libs.wire.Message;

public class e implements g {

    /* renamed from: a  reason: collision with root package name */
    private b f4056a;

    /* renamed from: b  reason: collision with root package name */
    private a f4057b;

    /* renamed from: c  reason: collision with root package name */
    private int f4058c;

    /* renamed from: d  reason: collision with root package name */
    private volatile com.airpay.paysdk.common.net.a.a.a f4059d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Class f4060e;

    public e(b bVar, int i, Message message) {
        this.f4058c = i & 255;
        this.f4057b = new a(i, message.encode());
        this.f4056a = bVar;
        com.airpay.paysdk.common.b.a.b("Airpay cmd-0x" + Integer.toHexString(i) + "--request data-- " + message.toString(), new Object[0]);
    }

    public e(b bVar, int i, a aVar) {
        this.f4058c = i;
        this.f4057b = aVar;
        this.f4056a = bVar;
    }

    public b a() {
        return this.f4056a;
    }

    public byte[] b() {
        return this.f4057b.c();
    }

    public int c() {
        return this.f4057b.d();
    }

    public a d() {
        return this.f4057b;
    }

    public int e() {
        return this.f4058c;
    }

    public com.airpay.paysdk.common.net.a.a.a f() {
        return this.f4059d;
    }

    public <T> void a(com.airpay.paysdk.common.net.a.a.a<T> aVar) {
        this.f4059d = aVar;
    }

    public Class g() {
        return this.f4060e;
    }

    public <T> void a(Class<T> cls) {
        this.f4060e = cls;
    }
}
