package com.google.android.exoplayer2.source.dash.a;

import com.google.android.exoplayer2.n.t;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public final String f11875a;

    /* renamed from: b  reason: collision with root package name */
    public final String f11876b;

    public g(String str, String str2) {
        this.f11875a = str;
        this.f11876b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (!t.a((Object) this.f11875a, (Object) gVar.f11875a) || !t.a((Object) this.f11876b, (Object) gVar.f11876b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f11875a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f11876b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }
}
