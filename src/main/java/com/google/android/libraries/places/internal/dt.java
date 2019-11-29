package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.dw;

final class dt extends dw {

    /* renamed from: a  reason: collision with root package name */
    private final String f12475a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12476b;

    /* renamed from: c  reason: collision with root package name */
    private final dw.b f12477c;

    dt(String str, int i, dw.b bVar) {
        this.f12475a = str;
        this.f12476b = i;
        this.f12477c = bVar;
    }

    public final String a() {
        return this.f12475a;
    }

    public final int b() {
        return this.f12476b;
    }

    public final dw.b c() {
        return this.f12477c;
    }

    public final String toString() {
        String str = this.f12475a;
        int i = this.f12476b;
        String valueOf = String.valueOf(this.f12477c);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(valueOf).length());
        sb.append("ClientProfile{packageName=");
        sb.append(str);
        sb.append(", versionCode=");
        sb.append(i);
        sb.append(", requestSource=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof dw) {
            dw dwVar = (dw) obj;
            return this.f12475a.equals(dwVar.a()) && this.f12476b == dwVar.b() && this.f12477c.equals(dwVar.c());
        }
    }

    public final int hashCode() {
        return ((((this.f12475a.hashCode() ^ 1000003) * 1000003) ^ this.f12476b) * 1000003) ^ this.f12477c.hashCode();
    }
}
