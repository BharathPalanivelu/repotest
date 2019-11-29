package com.google.android.libraries.places.api.net;

import android.graphics.Bitmap;
import com.google.android.libraries.places.internal.dg;

public abstract class FetchPhotoResponse {
    public abstract Bitmap getBitmap();

    public static FetchPhotoResponse newInstance(Bitmap bitmap) {
        return new dg(bitmap);
    }
}
