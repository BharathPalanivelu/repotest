package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.libraries.places.internal.bp;
import com.google.android.libraries.places.internal.go;

public abstract class PhotoMetadata implements Parcelable {

    public static abstract class Builder {
        public abstract Builder a(String str);

        public abstract PhotoMetadata a();

        public abstract Builder setAttributions(String str);

        public abstract Builder setHeight(int i);

        public abstract Builder setWidth(int i);

        public PhotoMetadata build() {
            PhotoMetadata a2 = a();
            int width = a2.getWidth();
            boolean z = false;
            go.a(width >= 0, "Width must not be < 0, but was: %s.", width);
            int height = a2.getHeight();
            if (height >= 0) {
                z = true;
            }
            go.a(z, "Height must not be < 0, but was: %s.", height);
            go.b(!TextUtils.isEmpty(a2.a()), (Object) "PhotoReference must not be null or empty.");
            return a2;
        }
    }

    public abstract String a();

    public abstract String getAttributions();

    public abstract int getHeight();

    public abstract int getWidth();

    public static Builder builder(String str) {
        return new bp().a(str).setWidth(0).setHeight(0).setAttributions("");
    }
}
