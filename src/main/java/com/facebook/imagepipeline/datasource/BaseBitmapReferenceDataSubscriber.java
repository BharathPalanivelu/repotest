package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;

public abstract class BaseBitmapReferenceDataSubscriber extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
    /* access modifiers changed from: protected */
    public abstract void onNewResultImpl(CloseableReference<Bitmap> closeableReference);

    public void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
        if (dataSource.isFinished()) {
            CloseableReference result = dataSource.getResult();
            CloseableReference<Bitmap> closeableReference = null;
            if (result != null && (result.get() instanceof CloseableStaticBitmap)) {
                closeableReference = ((CloseableStaticBitmap) result.get()).cloneUnderlyingBitmapReference();
            }
            try {
                onNewResultImpl(closeableReference);
            } finally {
                CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                CloseableReference.closeSafely((CloseableReference<?>) result);
            }
        }
    }
}
