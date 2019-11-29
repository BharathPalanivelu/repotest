package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.AutocompletePrediction;

public final class bg extends AutocompletePrediction.a.C0213a {

    /* renamed from: a  reason: collision with root package name */
    private Integer f12378a;

    /* renamed from: b  reason: collision with root package name */
    private Integer f12379b;

    public final AutocompletePrediction.a.C0213a a(int i) {
        this.f12378a = Integer.valueOf(i);
        return this;
    }

    public final AutocompletePrediction.a.C0213a b(int i) {
        this.f12379b = Integer.valueOf(i);
        return this;
    }

    public final AutocompletePrediction.a a() {
        String str = "";
        if (this.f12378a == null) {
            str = str.concat(" offset");
        }
        if (this.f12379b == null) {
            str = String.valueOf(str).concat(" length");
        }
        if (str.isEmpty()) {
            return new ce(this.f12378a.intValue(), this.f12379b.intValue());
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }
}
