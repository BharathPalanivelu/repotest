package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.AddressComponent;
import java.util.List;

public final class bb extends AddressComponent.Builder {

    /* renamed from: a  reason: collision with root package name */
    private String f12358a;

    /* renamed from: b  reason: collision with root package name */
    private String f12359b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f12360c;

    /* access modifiers changed from: package-private */
    public final AddressComponent.Builder a(String str) {
        if (str != null) {
            this.f12358a = str;
            return this;
        }
        throw new NullPointerException("Null name");
    }

    public final AddressComponent.Builder setShortName(String str) {
        this.f12359b = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final AddressComponent.Builder a(List<String> list) {
        if (list != null) {
            this.f12360c = list;
            return this;
        }
        throw new NullPointerException("Null types");
    }

    /* access modifiers changed from: package-private */
    public final AddressComponent a() {
        String str = "";
        if (this.f12358a == null) {
            str = str.concat(" name");
        }
        if (this.f12360c == null) {
            str = String.valueOf(str).concat(" types");
        }
        if (str.isEmpty()) {
            return new by(this.f12358a, this.f12359b, this.f12360c);
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }
}
