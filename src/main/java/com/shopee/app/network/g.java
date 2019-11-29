package com.shopee.app.network;

import java.util.UUID;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private long f18488a;

    public g() {
        this.f18488a = c();
    }

    public g(String str) {
        this.f18488a = Long.parseLong(str);
    }

    public String toString() {
        return "BBRequestId{m_rawValue=" + this.f18488a + ", longvalue=" + b() + '}';
    }

    public String a() {
        return Long.valueOf(this.f18488a).toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof g) && this.f18488a == ((g) obj).f18488a) {
            return true;
        }
        return false;
    }

    public long b() {
        return this.f18488a;
    }

    private static long c() {
        UUID randomUUID = UUID.randomUUID();
        long mostSignificantBits = randomUUID.getMostSignificantBits() ^ randomUUID.getLeastSignificantBits();
        return mostSignificantBits < 0 ? -mostSignificantBits : mostSignificantBits;
    }

    public int hashCode() {
        return (int) (this.f18488a % 2147483647L);
    }
}
