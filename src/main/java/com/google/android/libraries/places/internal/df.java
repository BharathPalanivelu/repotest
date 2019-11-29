package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;

public final class df extends FetchPhotoRequest.Builder {

    /* renamed from: a  reason: collision with root package name */
    private Integer f12436a;

    /* renamed from: b  reason: collision with root package name */
    private Integer f12437b;

    /* renamed from: c  reason: collision with root package name */
    private PhotoMetadata f12438c;

    /* renamed from: d  reason: collision with root package name */
    private CancellationToken f12439d;

    public final FetchPhotoRequest.Builder setMaxWidth(Integer num) {
        this.f12436a = num;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final Integer a() {
        return this.f12436a;
    }

    public final FetchPhotoRequest.Builder setMaxHeight(Integer num) {
        this.f12437b = num;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final Integer b() {
        return this.f12437b;
    }

    /* access modifiers changed from: package-private */
    public final FetchPhotoRequest.Builder a(PhotoMetadata photoMetadata) {
        if (photoMetadata != null) {
            this.f12438c = photoMetadata;
            return this;
        }
        throw new NullPointerException("Null photoMetadata");
    }

    /* access modifiers changed from: package-private */
    public final PhotoMetadata c() {
        PhotoMetadata photoMetadata = this.f12438c;
        if (photoMetadata != null) {
            return photoMetadata;
        }
        throw new IllegalStateException("Property \"photoMetadata\" has not been set");
    }

    public final FetchPhotoRequest.Builder setCancellationToken(CancellationToken cancellationToken) {
        this.f12439d = cancellationToken;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final FetchPhotoRequest d() {
        String str = "";
        if (this.f12438c == null) {
            str = str.concat(" photoMetadata");
        }
        if (str.isEmpty()) {
            return new de(this.f12436a, this.f12437b, this.f12438c, this.f12439d);
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }
}
