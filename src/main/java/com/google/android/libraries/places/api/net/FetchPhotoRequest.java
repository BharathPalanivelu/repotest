package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.internal.ay;
import com.google.android.libraries.places.internal.df;

public abstract class FetchPhotoRequest implements ay {

    public static abstract class Builder {
        public abstract Builder a(PhotoMetadata photoMetadata);

        public abstract Integer a();

        public abstract Integer b();

        public abstract PhotoMetadata c();

        public abstract FetchPhotoRequest d();

        public abstract Builder setCancellationToken(CancellationToken cancellationToken);

        public abstract Builder setMaxHeight(Integer num);

        public abstract Builder setMaxWidth(Integer num);

        public FetchPhotoRequest build() {
            PhotoMetadata c2 = c();
            if (a() == null && b() == null && c2 != null) {
                int width = c2.getWidth();
                if (width > 0) {
                    setMaxWidth(Integer.valueOf(width));
                }
                int height = c2.getHeight();
                if (height > 0) {
                    setMaxHeight(Integer.valueOf(height));
                }
            }
            return d();
        }
    }

    public abstract CancellationToken getCancellationToken();

    public abstract Integer getMaxHeight();

    public abstract Integer getMaxWidth();

    public abstract PhotoMetadata getPhotoMetadata();

    public static FetchPhotoRequest newInstance(PhotoMetadata photoMetadata) {
        return builder(photoMetadata).build();
    }

    public static Builder builder(PhotoMetadata photoMetadata) {
        return new df().a(photoMetadata);
    }
}
