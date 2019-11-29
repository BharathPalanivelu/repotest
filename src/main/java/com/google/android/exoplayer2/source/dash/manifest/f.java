package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.s.u;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final long f12020a;

    /* renamed from: b  reason: collision with root package name */
    public final long f12021b;

    /* renamed from: c  reason: collision with root package name */
    private final String f12022c;

    /* renamed from: d  reason: collision with root package name */
    private int f12023d;

    public f(String str, long j, long j2) {
        this.f12022c = str == null ? "" : str;
        this.f12020a = j;
        this.f12021b = j2;
    }

    public Uri a(String str) {
        return u.a(str, this.f12022c);
    }

    public String b(String str) {
        return u.b(str, this.f12022c);
    }

    public f a(f fVar, String str) {
        String b2 = b(str);
        if (fVar != null && b2.equals(fVar.b(str))) {
            long j = this.f12021b;
            long j2 = -1;
            if (j != -1) {
                long j3 = this.f12020a;
                if (j3 + j == fVar.f12020a) {
                    long j4 = fVar.f12021b;
                    if (j4 != -1) {
                        j2 = j + j4;
                    }
                    return new f(b2, j3, j2);
                }
            }
            long j5 = fVar.f12021b;
            if (j5 != -1) {
                long j6 = fVar.f12020a;
                if (j6 + j5 == this.f12020a) {
                    long j7 = this.f12021b;
                    if (j7 != -1) {
                        j2 = j5 + j7;
                    }
                    return new f(b2, j6, j2);
                }
            }
        }
        return null;
    }

    public int hashCode() {
        if (this.f12023d == 0) {
            this.f12023d = ((((527 + ((int) this.f12020a)) * 31) + ((int) this.f12021b)) * 31) + this.f12022c.hashCode();
        }
        return this.f12023d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f12020a == fVar.f12020a && this.f12021b == fVar.f12021b && this.f12022c.equals(fVar.f12022c)) {
            return true;
        }
        return false;
    }
}
