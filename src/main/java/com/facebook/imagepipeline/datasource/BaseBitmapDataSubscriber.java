package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;

public abstract class BaseBitmapDataSubscriber extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
    /* access modifiers changed from: protected */
    public abstract void onNewResultImpl(Bitmap bitmap);

    public void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
        if (dataSource.isFinished()) {
            CloseableReference result = dataSource.getResult();
            Bitmap bitmap = null;
            if (result != null && (result.get() instanceof CloseableBitmap)) {
                bitmap = ((CloseableBitmap) result.get()).getUnderlyingBitmap();
            }
            try {
                onNewResultImpl(bitmap);
            } finally {
                CloseableReference.closeSafely((CloseableReference<?>) result);
            }
        }
    }
}
