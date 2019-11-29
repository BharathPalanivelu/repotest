package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.s.v;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f12014a;

    /* renamed from: b  reason: collision with root package name */
    public final String f12015b;

    /* renamed from: c  reason: collision with root package name */
    public final String f12016c;

    public d(String str, String str2, String str3) {
        this.f12014a = str;
        this.f12015b = str2;
        this.f12016c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (!v.a((Object) this.f12014a, (Object) dVar.f12014a) || !v.a((Object) this.f12015b, (Object) dVar.f12015b) || !v.a((Object) this.f12016c, (Object) dVar.f12016c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f12014a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f12015b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f12016c;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }
}
