package com.google.android.libraries.places.internal;

import android.graphics.Bitmap;
import com.google.android.gms.common.api.ApiException;
import com.google.android.libraries.places.api.net.FetchPhotoResponse;

public final class af extends aj<Object, FetchPhotoResponse> {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap f12334a;

    public af(Bitmap bitmap) {
        this.f12334a = bitmap;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.libraries.places.internal.az, com.google.android.libraries.places.api.net.FetchPhotoResponse] */
    public final /* synthetic */ az convert() throws ApiException {
        return FetchPhotoResponse.newInstance(this.f12334a);
    }
}
