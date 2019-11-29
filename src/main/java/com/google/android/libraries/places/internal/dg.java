package com.google.android.libraries.places.internal;

import android.graphics.Bitmap;
import com.google.android.libraries.places.api.net.FetchPhotoResponse;

public final class dg extends FetchPhotoResponse {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap f12440a;

    public dg(Bitmap bitmap) {
        if (bitmap != null) {
            this.f12440a = bitmap;
            return;
        }
        throw new NullPointerException("Null bitmap");
    }

    public final Bitmap getBitmap() {
        return this.f12440a;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f12440a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("FetchPhotoResponse{bitmap=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FetchPhotoResponse) {
            return this.f12440a.equals(((FetchPhotoResponse) obj).getBitmap());
        }
        return false;
    }

    public final int hashCode() {
        return this.f12440a.hashCode() ^ 1000003;
    }
}
