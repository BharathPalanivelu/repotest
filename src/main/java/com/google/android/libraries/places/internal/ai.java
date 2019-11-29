package com.google.android.libraries.places.internal;

import android.location.Location;
import com.facebook.GraphRequest;
import com.facebook.places.model.PlaceFields;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class ai extends r {

    /* renamed from: f  reason: collision with root package name */
    private final Location f12335f;

    /* renamed from: g  reason: collision with root package name */
    private final ha<fu> f12336g;

    public ai(FindCurrentPlaceRequest findCurrentPlaceRequest, Location location, ha<fu> haVar, Locale locale, String str, boolean z, fg fgVar) {
        super(findCurrentPlaceRequest, locale, str, z, fgVar);
        this.f12335f = location;
        this.f12336g = haVar;
    }

    /* access modifiers changed from: protected */
    public final String d() {
        return "findplacefromuserlocation/json";
    }

    public final Map<String, String> e() {
        HashMap hashMap = new HashMap();
        r.a(hashMap, PlaceFields.LOCATION, ap.b(this.f12335f), (Object) null);
        r.a(hashMap, "wifiaccesspoints", ap.a(this.f12336g), (Object) null);
        r.a(hashMap, "precision", ap.a(this.f12335f), (Object) null);
        r.a(hashMap, "timestamp", Long.valueOf(this.f12335f.getTime()), (Object) null);
        r.a(hashMap, GraphRequest.FIELDS_PARAM, aq.b(((FindCurrentPlaceRequest) this.f13061a).getPlaceFields()), (Object) null);
        return hashMap;
    }
}
