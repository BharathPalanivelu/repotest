package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import java.util.List;

public final class eh extends fi {

    /* renamed from: a  reason: collision with root package name */
    private ha<Place.Field> f12501a;

    /* renamed from: b  reason: collision with root package name */
    private LocationBias f12502b;

    /* renamed from: c  reason: collision with root package name */
    private LocationRestriction f12503c;

    /* renamed from: d  reason: collision with root package name */
    private String f12504d;

    /* renamed from: e  reason: collision with root package name */
    private TypeFilter f12505e;

    /* access modifiers changed from: package-private */
    public final fi a(List<Place.Field> list) {
        this.f12501a = ha.a(list);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final fi a(LocationBias locationBias) {
        this.f12502b = locationBias;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final fi a(LocationRestriction locationRestriction) {
        this.f12503c = locationRestriction;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final fi a(String str) {
        this.f12504d = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final fi a(TypeFilter typeFilter) {
        this.f12505e = typeFilter;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final fh a() {
        String str = "";
        if (this.f12501a == null) {
            str = str.concat(" placeFields");
        }
        if (str.isEmpty()) {
            return new eg(this.f12501a, this.f12502b, this.f12503c, this.f12504d, this.f12505e);
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }
}
