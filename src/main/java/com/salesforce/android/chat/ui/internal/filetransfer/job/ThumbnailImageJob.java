package com.salesforce.android.chat.ui.internal.filetransfer.job;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.filetransfer.model.ImageMeta;
import com.salesforce.android.chat.ui.internal.filetransfer.model.ImageThumbnail;
import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import com.salesforce.android.service.common.utilities.functional.Function;
import com.salesforce.android.service.common.utilities.internal.android.BitmapHelper;
import com.salesforce.android.service.common.utilities.internal.stream.InputStreamHelper;
import com.salesforce.android.service.common.utilities.spatial.Size;
import com.salesforce.android.service.common.utilities.threading.Job;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.io.InputStream;

public class ThumbnailImageJob implements Job<ImageThumbnail> {
    /* access modifiers changed from: private */
    public final BitmapHelper mBitmapHelper;
    private final ContentResolver mContentResolver;
    /* access modifiers changed from: private */
    public final ImageMeta mImageMeta;
    /* access modifiers changed from: private */
    public final InputStreamHelper mInputStreamHelper;
    /* access modifiers changed from: private */
    public final int mThumbnailHeightPx;

    private ThumbnailImageJob(Builder builder) {
        this.mImageMeta = builder.mImageMeta;
        this.mThumbnailHeightPx = builder.mThumbnailHeightPx.intValue();
        this.mContentResolver = builder.mContentResolver;
        this.mInputStreamHelper = builder.mInputStreamHelper;
        this.mBitmapHelper = builder.mBitmapHelper;
    }

    public void execute(ResultReceiver<ImageThumbnail> resultReceiver) {
        this.mInputStreamHelper.openContentUri(this.mContentResolver, this.mImageMeta.getContentUri()).map(readThumbnailImage()).pipe(resultReceiver);
        resultReceiver.complete();
    }

    /* access modifiers changed from: package-private */
    public Function<InputStream, ImageThumbnail> readThumbnailImage() {
        return new Function<InputStream, ImageThumbnail>() {
            public ImageThumbnail apply(InputStream inputStream) {
                inputStream.mark(ThumbnailImageJob.this.mInputStreamHelper.availableBytes(inputStream));
                Size imageDimensions = ThumbnailImageJob.this.mBitmapHelper.getImageDimensions(inputStream);
                ThumbnailImageJob.this.mInputStreamHelper.reset(inputStream);
                ThumbnailImageJob thumbnailImageJob = ThumbnailImageJob.this;
                Bitmap scaledBitmap = ThumbnailImageJob.this.mBitmapHelper.getScaledBitmap(inputStream, thumbnailImageJob.calculateSampleSize(imageDimensions, thumbnailImageJob.mThumbnailHeightPx));
                ThumbnailImageJob.this.mInputStreamHelper.close(inputStream);
                if (!(ThumbnailImageJob.this.mImageMeta == null || ThumbnailImageJob.this.mImageMeta.getOrientation() == null)) {
                    scaledBitmap = ThumbnailImageJob.this.mBitmapHelper.rotate(scaledBitmap, (float) ThumbnailImageJob.this.mImageMeta.getOrientation().getValue());
                }
                return new ImageThumbnail(ThumbnailImageJob.this.mImageMeta, scaledBitmap);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public int calculateSampleSize(Size size, int i) {
        return (int) Math.floor((double) (size.getHeight() / i));
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public BitmapHelper mBitmapHelper;
        /* access modifiers changed from: private */
        public ContentResolver mContentResolver;
        private Context mContext;
        /* access modifiers changed from: private */
        public ImageMeta mImageMeta;
        /* access modifiers changed from: private */
        public InputStreamHelper mInputStreamHelper;
        /* access modifiers changed from: private */
        public Integer mThumbnailHeightPx;

        public Builder with(Context context) {
            this.mContext = context;
            return this;
        }

        public Builder imageMeta(ImageMeta imageMeta) {
            this.mImageMeta = imageMeta;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder thumbnailHeightPx(int i) {
            this.mThumbnailHeightPx = Integer.valueOf(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder contentResolver(ContentResolver contentResolver) {
            this.mContentResolver = contentResolver;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder inputStreamHelper(InputStreamHelper inputStreamHelper) {
            this.mInputStreamHelper = inputStreamHelper;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder bitmapHelper(BitmapHelper bitmapHelper) {
            this.mBitmapHelper = bitmapHelper;
            return this;
        }

        public ThumbnailImageJob build() {
            Arguments.checkNotNull(this.mContext);
            Arguments.checkNotNull(this.mImageMeta);
            if (this.mThumbnailHeightPx == null) {
                this.mThumbnailHeightPx = Integer.valueOf(this.mContext.getResources().getDimensionPixelSize(R.dimen.chat_image_thumbnail_height));
            }
            if (this.mContentResolver == null) {
                this.mContentResolver = this.mContext.getContentResolver();
            }
            if (this.mInputStreamHelper == null) {
                this.mInputStreamHelper = new InputStreamHelper();
            }
            if (this.mBitmapHelper == null) {
                this.mBitmapHelper = new BitmapHelper();
            }
            Arguments.check(this.mThumbnailHeightPx.intValue() > 0, "The dimension resource 'chat_image_thumbnail_height' must be defined and greater than 0dp.");
            return new ThumbnailImageJob(this);
        }
    }
}
