package com.airpay.paysdk.common.net.tcp.b;

import java.util.UUID;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f4028a;

    private b(a aVar) {
        this.f4028a = aVar.b();
    }

    public static b a() {
        return new a().a();
    }

    public int b() {
        return this.f4028a;
    }

    public int hashCode() {
        return this.f4028a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b) || ((b) obj).b() != this.f4028a) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "RequestId { value= " + this.f4028a + " }";
    }

    public static class a {
        public b a() {
            return new b(this);
        }

        /* access modifiers changed from: private */
        public int b() {
            UUID randomUUID = UUID.randomUUID();
            return (int) (randomUUID.getMostSignificantBits() ^ (randomUUID.getLeastSignificantBits() & 65535));
        }
    }
}
