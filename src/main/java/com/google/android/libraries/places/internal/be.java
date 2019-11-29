package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.Place;
import java.util.List;

public final class be extends AutocompletePrediction.Builder {

    /* renamed from: a  reason: collision with root package name */
    private String f12369a;

    /* renamed from: b  reason: collision with root package name */
    private List<Place.Type> f12370b;

    /* renamed from: c  reason: collision with root package name */
    private String f12371c;

    /* renamed from: d  reason: collision with root package name */
    private String f12372d;

    /* renamed from: e  reason: collision with root package name */
    private String f12373e;

    /* renamed from: f  reason: collision with root package name */
    private List<AutocompletePrediction.a> f12374f;

    /* renamed from: g  reason: collision with root package name */
    private List<AutocompletePrediction.a> f12375g;
    private List<AutocompletePrediction.a> h;

    /* access modifiers changed from: package-private */
    public final AutocompletePrediction.Builder a(String str) {
        if (str != null) {
            this.f12369a = str;
            return this;
        }
        throw new NullPointerException("Null placeId");
    }

    public final AutocompletePrediction.Builder setPlaceTypes(List<Place.Type> list) {
        if (list != null) {
            this.f12370b = list;
            return this;
        }
        throw new NullPointerException("Null placeTypes");
    }

    public final AutocompletePrediction.Builder setFullText(String str) {
        if (str != null) {
            this.f12371c = str;
            return this;
        }
        throw new NullPointerException("Null fullText");
    }

    public final AutocompletePrediction.Builder setPrimaryText(String str) {
        if (str != null) {
            this.f12372d = str;
            return this;
        }
        throw new NullPointerException("Null primaryText");
    }

    public final AutocompletePrediction.Builder setSecondaryText(String str) {
        if (str != null) {
            this.f12373e = str;
            return this;
        }
        throw new NullPointerException("Null secondaryText");
    }

    public final AutocompletePrediction.Builder a(List<AutocompletePrediction.a> list) {
        this.f12374f = list;
        return this;
    }

    public final AutocompletePrediction.Builder b(List<AutocompletePrediction.a> list) {
        this.f12375g = list;
        return this;
    }

    public final AutocompletePrediction.Builder c(List<AutocompletePrediction.a> list) {
        this.h = list;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final AutocompletePrediction a() {
        String str = "";
        if (this.f12369a == null) {
            str = str.concat(" placeId");
        }
        if (this.f12370b == null) {
            str = String.valueOf(str).concat(" placeTypes");
        }
        if (this.f12371c == null) {
            str = String.valueOf(str).concat(" fullText");
        }
        if (this.f12372d == null) {
            str = String.valueOf(str).concat(" primaryText");
        }
        if (this.f12373e == null) {
            str = String.valueOf(str).concat(" secondaryText");
        }
        if (str.isEmpty()) {
            return new cc(this.f12369a, this.f12370b, this.f12371c, this.f12372d, this.f12373e, this.f12374f, this.f12375g, this.h);
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }
}
