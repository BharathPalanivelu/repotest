package com.salesforce.android.chat.ui.internal.filetransfer;

import android.media.ExifInterface;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.spatial.Orientation;
import java.io.IOException;

class ExifReader {
    /* access modifiers changed from: private */
    public static final ServiceLogger log = ServiceLogging.getLogger(ExifReader.class);
    private final ExifInterfaceProvider mExifInterfaceProvider;

    private ExifReader(Builder builder) {
        this.mExifInterfaceProvider = builder.mExifInterfaceProvider;
    }

    /* access modifiers changed from: package-private */
    public Orientation getImageOrientation(String str) {
        return convertOrientation(readExifOrientation(this.mExifInterfaceProvider.loadExif(str)));
    }

    /* access modifiers changed from: package-private */
    public int readExifOrientation(ExifInterface exifInterface) {
        if (exifInterface == null) {
            return 1;
        }
        return exifInterface.getAttributeInt("Orientation", 1);
    }

    /* access modifiers changed from: package-private */
    public Orientation convertOrientation(int i) {
        if (i == 3) {
            return Orientation.SOUTH;
        }
        if (i == 6) {
            return Orientation.EAST;
        }
        if (i != 8) {
            return Orientation.NORTH;
        }
        return Orientation.WEST;
    }

    static class ExifInterfaceProvider {
        ExifInterfaceProvider() {
        }

        /* access modifiers changed from: package-private */
        public ExifInterface loadExif(String str) {
            try {
                return new ExifInterface(str);
            } catch (IOException e2) {
                ExifReader.log.warn("Unable to read Exif data for file at {}\n{}", str, e2);
                return null;
            }
        }
    }

    static class Builder {
        /* access modifiers changed from: private */
        public ExifInterfaceProvider mExifInterfaceProvider;

        Builder() {
        }

        /* access modifiers changed from: package-private */
        public Builder exifInterfaceProvider(ExifInterfaceProvider exifInterfaceProvider) {
            this.mExifInterfaceProvider = exifInterfaceProvider;
            return this;
        }

        public ExifReader build() {
            if (this.mExifInterfaceProvider == null) {
                this.mExifInterfaceProvider = new ExifInterfaceProvider();
            }
            return new ExifReader(this);
        }
    }
}
