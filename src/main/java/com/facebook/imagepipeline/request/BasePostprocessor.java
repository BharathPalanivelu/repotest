package com.facebook.imagepipeline.request;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public abstract class BasePostprocessor implements Postprocessor {
    public static final Bitmap.Config FALLBACK_BITMAP_CONFIGURATION = Bitmap.Config.ARGB_8888;

    public String getName() {
        return "Unknown postprocessor";
    }

    public CacheKey getPostprocessorCacheKey() {
        return null;
    }

    public void process(Bitmap bitmap) {
    }

    public CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
        Bitmap.Config config = bitmap.getConfig();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (config == null) {
            config = FALLBACK_BITMAP_CONFIGURATION;
        }
        CloseableReference<Bitmap> createBitmapInternal = platformBitmapFactory.createBitmapInternal(width, height, config);
        try {
            process(createBitmapInternal.get(), bitmap);
            return CloseableReference.cloneOrNull(createBitmapInternal);
        } finally {
            CloseableReference.closeSafely((CloseableReference<?>) createBitmapInternal);
        }
    }

    public void process(Bitmap bitmap, Bitmap bitmap2) {
        internalCopyBitmap(bitmap, bitmap2);
        process(bitmap);
    }

    private static void internalCopyBitmap(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap.getConfig() == bitmap2.getConfig()) {
            Bitmaps.copyBitmap(bitmap, bitmap2);
        } else {
            new Canvas(bitmap).drawBitmap(bitmap2, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (Paint) null);
        }
    }
}
