package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;

final class de extends FetchPhotoRequest {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f12432a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f12433b;

    /* renamed from: c  reason: collision with root package name */
    private final PhotoMetadata f12434c;

    /* renamed from: d  reason: collision with root package name */
    private final CancellationToken f12435d;

    de(Integer num, Integer num2, PhotoMetadata photoMetadata, CancellationToken cancellationToken) {
        this.f12432a = num;
        this.f12433b = num2;
        this.f12434c = photoMetadata;
        this.f12435d = cancellationToken;
    }

    public final Integer getMaxWidth() {
        return this.f12432a;
    }

    public final Integer getMaxHeight() {
        return this.f12433b;
    }

    public final PhotoMetadata getPhotoMetadata() {
        return this.f12434c;
    }

    public final CancellationToken getCancellationToken() {
        return this.f12435d;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f12432a);
        String valueOf2 = String.valueOf(this.f12433b);
        String valueOf3 = String.valueOf(this.f12434c);
        String valueOf4 = String.valueOf(this.f12435d);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 76 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("FetchPhotoRequest{maxWidth=");
        sb.append(valueOf);
        sb.append(", maxHeight=");
        sb.append(valueOf2);
        sb.append(", photoMetadata=");
        sb.append(valueOf3);
        sb.append(", cancellationToken=");
        sb.append(valueOf4);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FetchPhotoRequest) {
            FetchPhotoRequest fetchPhotoRequest = (FetchPhotoRequest) obj;
            Integer num = this.f12432a;
            if (num != null ? num.equals(fetchPhotoRequest.getMaxWidth()) : fetchPhotoRequest.getMaxWidth() == null) {
                Integer num2 = this.f12433b;
                if (num2 != null ? num2.equals(fetchPhotoRequest.getMaxHeight()) : fetchPhotoRequest.getMaxHeight() == null) {
                    if (this.f12434c.equals(fetchPhotoRequest.getPhotoMetadata())) {
                        CancellationToken cancellationToken = this.f12435d;
                        return cancellationToken != null ? cancellationToken.equals(fetchPhotoRequest.getCancellationToken()) : fetchPhotoRequest.getCancellationToken() == null;
                    }
                }
            }
        }
    }

    public final int hashCode() {
        Integer num = this.f12432a;
        int i = 0;
        int hashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        Integer num2 = this.f12433b;
        int hashCode2 = (((hashCode ^ (num2 == null ? 0 : num2.hashCode())) * 1000003) ^ this.f12434c.hashCode()) * 1000003;
        CancellationToken cancellationToken = this.f12435d;
        if (cancellationToken != null) {
            i = cancellationToken.hashCode();
        }
        return hashCode2 ^ i;
    }
}
