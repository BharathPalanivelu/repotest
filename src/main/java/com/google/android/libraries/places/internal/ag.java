package com.google.android.libraries.places.internal;

import com.facebook.GraphRequest;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class ag extends r {
    public ag(FetchPlaceRequest fetchPlaceRequest, Locale locale, String str, boolean z, fg fgVar) {
        super(fetchPlaceRequest, locale, str, z, fgVar);
    }

    /* access modifiers changed from: protected */
    public final String d() {
        return "details/json";
    }

    public final Map<String, String> e() {
        FetchPlaceRequest fetchPlaceRequest = (FetchPlaceRequest) this.f13061a;
        HashMap hashMap = new HashMap();
        r.a(hashMap, "placeid", fetchPlaceRequest.getPlaceId(), (Object) null);
        r.a(hashMap, "sessiontoken", fetchPlaceRequest.getSessionToken(), (Object) null);
        r.a(hashMap, GraphRequest.FIELDS_PARAM, aq.b(fetchPlaceRequest.getPlaceFields()), (Object) null);
        return hashMap;
    }
}
