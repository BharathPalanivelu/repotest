package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;

final class eg extends fh {

    /* renamed from: a  reason: collision with root package name */
    private final ha<Place.Field> f12496a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationBias f12497b;

    /* renamed from: c  reason: collision with root package name */
    private final LocationRestriction f12498c;

    /* renamed from: d  reason: collision with root package name */
    private final String f12499d;

    /* renamed from: e  reason: collision with root package name */
    private final TypeFilter f12500e;

    eg(ha<Place.Field> haVar, LocationBias locationBias, LocationRestriction locationRestriction, String str, TypeFilter typeFilter) {
        this.f12496a = haVar;
        this.f12497b = locationBias;
        this.f12498c = locationRestriction;
        this.f12499d = str;
        this.f12500e = typeFilter;
    }

    public final ha<Place.Field> a() {
        return this.f12496a;
    }

    public final LocationBias b() {
        return this.f12497b;
    }

    public final LocationRestriction c() {
        return this.f12498c;
    }

    public final String d() {
        return this.f12499d;
    }

    public final TypeFilter e() {
        return this.f12500e;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f12496a);
        String valueOf2 = String.valueOf(this.f12497b);
        String valueOf3 = String.valueOf(this.f12498c);
        String str = this.f12499d;
        String valueOf4 = String.valueOf(this.f12500e);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 93 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(str).length() + String.valueOf(valueOf4).length());
        sb.append("AutocompleteOptions{placeFields=");
        sb.append(valueOf);
        sb.append(", locationBias=");
        sb.append(valueOf2);
        sb.append(", locationRestriction=");
        sb.append(valueOf3);
        sb.append(", country=");
        sb.append(str);
        sb.append(", typeFilter=");
        sb.append(valueOf4);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof fh) {
            fh fhVar = (fh) obj;
            if (this.f12496a.equals(fhVar.a())) {
                LocationBias locationBias = this.f12497b;
                if (locationBias != null ? locationBias.equals(fhVar.b()) : fhVar.b() == null) {
                    LocationRestriction locationRestriction = this.f12498c;
                    if (locationRestriction != null ? locationRestriction.equals(fhVar.c()) : fhVar.c() == null) {
                        String str = this.f12499d;
                        if (str != null ? str.equals(fhVar.d()) : fhVar.d() == null) {
                            TypeFilter typeFilter = this.f12500e;
                            return typeFilter != null ? typeFilter.equals(fhVar.e()) : fhVar.e() == null;
                        }
                    }
                }
            }
        }
    }

    public final int hashCode() {
        int hashCode = (this.f12496a.hashCode() ^ 1000003) * 1000003;
        LocationBias locationBias = this.f12497b;
        int i = 0;
        int hashCode2 = (hashCode ^ (locationBias == null ? 0 : locationBias.hashCode())) * 1000003;
        LocationRestriction locationRestriction = this.f12498c;
        int hashCode3 = (hashCode2 ^ (locationRestriction == null ? 0 : locationRestriction.hashCode())) * 1000003;
        String str = this.f12499d;
        int hashCode4 = (hashCode3 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        TypeFilter typeFilter = this.f12500e;
        if (typeFilter != null) {
            i = typeFilter.hashCode();
        }
        return hashCode4 ^ i;
    }
}
