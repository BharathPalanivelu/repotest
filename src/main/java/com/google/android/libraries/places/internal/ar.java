package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.TypeFilter;

public final class ar {

    /* renamed from: a  reason: collision with root package name */
    private static final hd<TypeFilter, String> f12344a = new he().a(TypeFilter.ADDRESS, "address").a(TypeFilter.CITIES, "(cities)").a(TypeFilter.ESTABLISHMENT, "establishment").a(TypeFilter.GEOCODE, "geocode").a(TypeFilter.REGIONS, "(regions)").a();

    public static String a(TypeFilter typeFilter) {
        return f12344a.get(typeFilter);
    }
}
