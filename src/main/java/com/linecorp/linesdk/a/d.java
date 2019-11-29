package com.linecorp.linesdk.a;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f15029a;

    /* renamed from: b  reason: collision with root package name */
    public final long f15030b;

    /* renamed from: c  reason: collision with root package name */
    public final long f15031c;

    /* renamed from: d  reason: collision with root package name */
    public final String f15032d;

    public d(String str, long j, long j2, String str2) {
        this.f15029a = str;
        this.f15030b = j;
        this.f15031c = j2;
        this.f15032d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f15030b == dVar.f15030b && this.f15031c == dVar.f15031c && this.f15029a.equals(dVar.f15029a)) {
            return this.f15032d.equals(dVar.f15032d);
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f15030b;
        long j2 = this.f15031c;
        return (((((this.f15029a.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.f15032d.hashCode();
    }

    public final String toString() {
        return "InternalAccessToken{accessToken='#####', expiresInMillis=" + this.f15030b + ", issuedClientTimeMillis=" + this.f15031c + ", refreshToken='" + this.f15032d + '\'' + '}';
    }
}
