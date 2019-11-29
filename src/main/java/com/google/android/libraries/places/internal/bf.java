package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.AutocompletePrediction;

abstract class bf extends AutocompletePrediction.a {

    /* renamed from: a  reason: collision with root package name */
    private final int f12376a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12377b;

    bf(int i, int i2) {
        this.f12376a = i;
        this.f12377b = i2;
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.f12376a;
    }

    /* access modifiers changed from: package-private */
    public final int b() {
        return this.f12377b;
    }

    public String toString() {
        int i = this.f12376a;
        int i2 = this.f12377b;
        StringBuilder sb = new StringBuilder(54);
        sb.append("SubstringMatch{offset=");
        sb.append(i);
        sb.append(", length=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutocompletePrediction.a) {
            AutocompletePrediction.a aVar = (AutocompletePrediction.a) obj;
            return this.f12376a == aVar.a() && this.f12377b == aVar.b();
        }
    }

    public int hashCode() {
        return ((this.f12376a ^ 1000003) * 1000003) ^ this.f12377b;
    }
}
