package com.google.android.libraries.places.internal;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class ae extends r {
    public ae(FetchPhotoRequest fetchPhotoRequest, String str, boolean z, fg fgVar) {
        super(fetchPhotoRequest, (Locale) null, str, z, fgVar);
    }

    /* access modifiers changed from: protected */
    public final String d() {
        return AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO;
    }

    public final Map<String, String> e() {
        FetchPhotoRequest fetchPhotoRequest = (FetchPhotoRequest) this.f13061a;
        PhotoMetadata photoMetadata = fetchPhotoRequest.getPhotoMetadata();
        HashMap hashMap = new HashMap();
        r.a(hashMap, "maxheight", fetchPhotoRequest.getMaxHeight(), (Object) null);
        r.a(hashMap, "maxwidth", fetchPhotoRequest.getMaxWidth(), (Object) null);
        hashMap.put("photoreference", photoMetadata.a());
        return hashMap;
    }
}
