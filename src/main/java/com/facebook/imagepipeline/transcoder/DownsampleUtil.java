package com.facebook.imagepipeline.transcoder;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;

public class DownsampleUtil {
    public static final int DEFAULT_SAMPLE_SIZE = 1;
    private static final float INTERVAL_ROUNDING = 0.33333334f;

    @VisibleForTesting
    public static int roundToPowerOfTwo(int i) {
        int i2 = 1;
        while (i2 < i) {
            i2 *= 2;
        }
        return i2;
    }

    private DownsampleUtil() {
    }

    public static int determineSampleSize(RotationOptions rotationOptions, ResizeOptions resizeOptions, EncodedImage encodedImage, int i) {
        int i2;
        if (!EncodedImage.isMetaDataAvailable(encodedImage)) {
            return 1;
        }
        float determineDownsampleRatio = determineDownsampleRatio(rotationOptions, resizeOptions, encodedImage);
        if (encodedImage.getImageFormat() == DefaultImageFormats.JPEG) {
            i2 = ratioToSampleSizeJPEG(determineDownsampleRatio);
        } else {
            i2 = ratioToSampleSize(determineDownsampleRatio);
        }
        int max = Math.max(encodedImage.getHeight(), encodedImage.getWidth());
        float f2 = resizeOptions != null ? resizeOptions.maxBitmapSize : (float) i;
        while (((float) (max / i2)) > f2) {
            i2 = encodedImage.getImageFormat() == DefaultImageFormats.JPEG ? i2 * 2 : i2 + 1;
        }
        return i2;
    }

    @VisibleForTesting
    public static float determineDownsampleRatio(RotationOptions rotationOptions, ResizeOptions resizeOptions, EncodedImage encodedImage) {
        Preconditions.checkArgument(EncodedImage.isMetaDataAvailable(encodedImage));
        if (resizeOptions == null || resizeOptions.height <= 0 || resizeOptions.width <= 0 || encodedImage.getWidth() == 0 || encodedImage.getHeight() == 0) {
            return 1.0f;
        }
        int rotationAngle = getRotationAngle(rotationOptions, encodedImage);
        boolean z = rotationAngle == 90 || rotationAngle == 270;
        int height = z ? encodedImage.getHeight() : encodedImage.getWidth();
        int width = z ? encodedImage.getWidth() : encodedImage.getHeight();
        float f2 = ((float) resizeOptions.width) / ((float) height);
        float f3 = ((float) resizeOptions.height) / ((float) width);
        float max = Math.max(f2, f3);
        FLog.v("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f", Integer.valueOf(resizeOptions.width), Integer.valueOf(resizeOptions.height), Integer.valueOf(height), Integer.valueOf(width), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(max));
        return max;
    }

    @VisibleForTesting
    public static int ratioToSampleSize(float f2) {
        if (f2 > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (true) {
            double d2 = (double) i;
            double pow = Math.pow(d2, 2.0d);
            Double.isNaN(d2);
            Double.isNaN(d2);
            if ((1.0d / d2) + ((1.0d / (pow - d2)) * 0.3333333432674408d) <= ((double) f2)) {
                return i - 1;
            }
            i++;
        }
    }

    @VisibleForTesting
    public static int ratioToSampleSizeJPEG(float f2) {
        if (f2 > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (true) {
            int i2 = i * 2;
            double d2 = (double) i2;
            Double.isNaN(d2);
            double d3 = 1.0d / d2;
            if (d3 + (0.3333333432674408d * d3) <= ((double) f2)) {
                return i;
            }
            i = i2;
        }
    }

    private static int getRotationAngle(RotationOptions rotationOptions, EncodedImage encodedImage) {
        boolean z = false;
        if (!rotationOptions.useImageMetadata()) {
            return 0;
        }
        int rotationAngle = encodedImage.getRotationAngle();
        if (rotationAngle == 0 || rotationAngle == 90 || rotationAngle == 180 || rotationAngle == 270) {
            z = true;
        }
        Preconditions.checkArgument(z);
        return rotationAngle;
    }
}
