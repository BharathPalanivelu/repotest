package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.shopee.shopeetracker.bimodel.TrackingType;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class ah extends r {
    public ah(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest, Locale locale, String str, boolean z, fg fgVar) {
        super(findAutocompletePredictionsRequest, locale, str, z, fgVar);
    }

    /* access modifiers changed from: protected */
    public final String d() {
        return "autocomplete/json";
    }

    public final Map<String, String> e() {
        FindAutocompletePredictionsRequest findAutocompletePredictionsRequest = (FindAutocompletePredictionsRequest) this.f13061a;
        HashMap hashMap = new HashMap();
        r.a(hashMap, TrackingType.INPUT, findAutocompletePredictionsRequest.getQuery(), (Object) null);
        r.a(hashMap, "types", ar.a(findAutocompletePredictionsRequest.getTypeFilter()), (Object) null);
        r.a(hashMap, "sessiontoken", findAutocompletePredictionsRequest.getSessionToken(), (Object) null);
        r.a(hashMap, "locationbias", ap.a(findAutocompletePredictionsRequest.getLocationBias()), (Object) null);
        r.a(hashMap, "locationrestriction", ap.a(findAutocompletePredictionsRequest.getLocationRestriction()), (Object) null);
        r.a(hashMap, "components", ap.a(findAutocompletePredictionsRequest.getCountry()), (Object) null);
        return hashMap;
    }
}
