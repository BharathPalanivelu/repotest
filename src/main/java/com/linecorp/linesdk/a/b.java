package com.linecorp.linesdk.a;

import java.util.Collections;
import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final long f15023a;

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f15024b;

    /* renamed from: c  reason: collision with root package name */
    private final String f15025c;

    public b(String str, long j, List<String> list) {
        this.f15025c = str;
        this.f15023a = j;
        this.f15024b = Collections.unmodifiableList(list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f15025c.equals(bVar.f15025c) && this.f15023a == bVar.f15023a) {
            return this.f15024b.equals(bVar.f15024b);
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f15023a;
        return (((Integer.valueOf(this.f15025c).intValue() * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.f15024b.hashCode();
    }

    public final String toString() {
        return "AccessTokenVerificationResult{expiresInMillis=" + this.f15023a + ", channelId=" + this.f15025c + ", permissions=" + this.f15024b + '}';
    }
}
