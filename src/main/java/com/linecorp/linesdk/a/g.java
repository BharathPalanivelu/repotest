package com.linecorp.linesdk.a;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final String f15037a;

    /* renamed from: b  reason: collision with root package name */
    public final long f15038b;

    /* renamed from: c  reason: collision with root package name */
    public final String f15039c;

    public g(String str, long j, String str2) {
        this.f15037a = str;
        this.f15038b = j;
        this.f15039c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            g gVar = (g) obj;
            if (this.f15038b != gVar.f15038b || !this.f15037a.equals(gVar.f15037a)) {
                return false;
            }
            String str = this.f15039c;
            if (str != null) {
                return str.equals(gVar.f15039c);
            }
            if (gVar.f15039c == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f15038b;
        int hashCode = ((this.f15037a.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str = this.f15039c;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "RefreshTokenResult{accessToken='#####', expiresInMillis=" + this.f15038b + ", refreshToken='#####'}";
    }
}
