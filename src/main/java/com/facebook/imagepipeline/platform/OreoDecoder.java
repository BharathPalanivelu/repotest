package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.util.Pools;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;

@TargetApi(26)
public class OreoDecoder extends DefaultDecoder {
    public OreoDecoder(BitmapPool bitmapPool, int i, Pools.b bVar) {
        super(bitmapPool, i, bVar);
    }

    public int getBitmapSize(int i, int i2, BitmapFactory.Options options) {
        if (hasColorGamutMismatch(options)) {
            return i * i2 * 8;
        }
        return BitmapUtil.getSizeInByteForBitmap(i, i2, options.inPreferredConfig);
    }

    private static boolean hasColorGamutMismatch(BitmapFactory.Options options) {
        return (options.outColorSpace == null || !options.outColorSpace.isWideGamut() || options.inPreferredConfig == Bitmap.Config.RGBA_F16) ? false : true;
    }
}
