package com.airpay.paysdk.common.net;

import com.airpay.paysdk.common.net.a.a.b;
import com.airpay.paysdk.common.net.a.a.g;
import com.airpay.paysdk.common.net.tcp.a;
import com.airpay.paysdk.common.net.tcp.b.c;
import com.airpay.paysdk.libs.wire.Message;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private com.airpay.paysdk.common.net.a.a f3982a;

    /* renamed from: com.airpay.paysdk.common.net.a$a  reason: collision with other inner class name */
    private static final class C0077a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final a f3983a = new a();
    }

    public static a a() {
        return C0077a.f3983a;
    }

    private a() {
    }

    public com.airpay.paysdk.common.net.a.a b() {
        return this.f3982a;
    }

    public void a(com.airpay.paysdk.common.net.a.a aVar) {
        if (aVar == null) {
            throw new RuntimeException("NetConfig init is null !");
        } else if (this.f3982a == null) {
            this.f3982a = aVar;
        } else {
            throw new RuntimeException("NetConfig already init !");
        }
    }

    public <T> b a(g gVar, Class<T> cls, com.airpay.paysdk.common.net.a.a.a<T> aVar) {
        return a(0, gVar, cls, aVar);
    }

    public <T> b a(int i, g gVar, Class<T> cls, com.airpay.paysdk.common.net.a.a.a<T> aVar) {
        return a(i, gVar, cls, (com.airpay.paysdk.common.net.tcp.c.b) null, aVar);
    }

    public <T> b a(int i, g gVar, Class<T> cls, com.airpay.paysdk.common.net.tcp.c.b bVar, com.airpay.paysdk.common.net.a.a.a<T> aVar) {
        com.airpay.paysdk.common.net.tcp.a a2 = new a.C0079a().a((c) this.f3982a.b()).a(this.f3982a.a()).c(i).a(0).a(gVar).a();
        a2.a(cls, aVar);
        return a2;
    }

    public <T extends Message> b a(int i, Class<T> cls, com.airpay.paysdk.common.net.a.a.a<T> aVar) {
        com.airpay.paysdk.common.net.tcp.a a2 = new a.C0079a().a((c) this.f3982a.b()).a(0).b(1).a();
        a2.a(i, cls, aVar);
        return a2;
    }

    public void c() {
        this.f3982a = null;
    }
}
