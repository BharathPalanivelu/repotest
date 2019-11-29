package com.google.android.exoplayer2.source.dash.a;

import android.net.Uri;
import com.google.android.exoplayer2.n.s;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final long f11862a;

    /* renamed from: b  reason: collision with root package name */
    public final long f11863b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11864c;

    /* renamed from: d  reason: collision with root package name */
    private int f11865d;

    public e(String str, long j, long j2) {
        this.f11864c = str == null ? "" : str;
        this.f11862a = j;
        this.f11863b = j2;
    }

    public Uri a(String str) {
        return s.a(str, this.f11864c);
    }

    public String b(String str) {
        return s.b(str, this.f11864c);
    }

    public e a(e eVar, String str) {
        String b2 = b(str);
        if (eVar != null && b2.equals(eVar.b(str))) {
            long j = this.f11863b;
            long j2 = -1;
            if (j != -1) {
                long j3 = this.f11862a;
                if (j3 + j == eVar.f11862a) {
                    long j4 = eVar.f11863b;
                    if (j4 != -1) {
                        j2 = j + j4;
                    }
                    return new e(b2, j3, j2);
                }
            }
            long j5 = eVar.f11863b;
            if (j5 != -1) {
                long j6 = eVar.f11862a;
                if (j6 + j5 == this.f11862a) {
                    long j7 = this.f11863b;
                    if (j7 != -1) {
                        j2 = j5 + j7;
                    }
                    return new e(b2, j6, j2);
                }
            }
        }
        return null;
    }

    public int hashCode() {
        if (this.f11865d == 0) {
            this.f11865d = ((((527 + ((int) this.f11862a)) * 31) + ((int) this.f11863b)) * 31) + this.f11864c.hashCode();
        }
        return this.f11865d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f11862a == eVar.f11862a && this.f11863b == eVar.f11863b && this.f11864c.equals(eVar.f11864c)) {
            return true;
        }
        return false;
    }
}
