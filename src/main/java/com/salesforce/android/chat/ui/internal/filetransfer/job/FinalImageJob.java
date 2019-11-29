package com.salesforce.android.chat.ui.internal.filetransfer.job;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import com.salesforce.android.chat.ui.internal.filetransfer.model.ImageFinal;
import com.salesforce.android.chat.ui.internal.filetransfer.model.ImageMeta;
import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import com.salesforce.android.service.common.utilities.functional.Function;
import com.salesforce.android.service.common.utilities.internal.android.BitmapHelper;
import com.salesforce.android.service.common.utilities.internal.stream.InputStreamHelper;
import com.salesforce.android.service.common.utilities.spatial.Size;
import com.salesforce.android.service.common.utilities.threading.Job;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.io.InputStream;

public class FinalImageJob implements Job<ImageFinal> {
    private static final double ESTIMATED_JPG_BITS_PER_PIXEL = 4.0d;
    private static final int JPG_COMPRESSION_VALUE = 100;
    private static final int MAXIMUM_IMAGE_STREAM_READS = 3;
    static final double MAX_FILE_SIZE_IN_BYTES = 2411724.8d;
    /* access modifiers changed from: private */
    public final BitmapHelper mBitmapHelper;
    private final ContentResolver mContentResolver;
    /* access modifiers changed from: private */
    public final ImageMeta mImageMeta;
    /* access modifiers changed from: private */
    public final InputStreamHelper mInputStreamHelper;

    private FinalImageJob(Builder builder) {
        this.mImageMeta = builder.mImageMeta;
        this.mContentResolver = builder.mContentResolver;
        this.mInputStreamHelper = builder.mInputStreamHelper;
        this.mBitmapHelper = builder.mBitmapHelper;
    }

    public void execute(ResultReceiver<ImageFinal> resultReceiver) {
        this.mInputStreamHelper.openContentUri(this.mContentResolver, this.mImageMeta.getContentUri()).map(readImage()).pipe(resultReceiver);
        resultReceiver.complete();
    }

    /* access modifiers changed from: package-private */
    public Function<InputStream, ImageFinal> readImage() {
        return new Function<InputStream, ImageFinal>() {
            public ImageFinal apply(InputStream inputStream) {
                inputStream.mark(FinalImageJob.this.mInputStreamHelper.availableBytes(inputStream) * 3);
                int calculateInitialPowerOf2 = FinalImageJob.this.calculateInitialPowerOf2(FinalImageJob.this.mBitmapHelper.getImageDimensions(inputStream));
                while (true) {
                    FinalImageJob.this.mInputStreamHelper.reset(inputStream);
                    int i = calculateInitialPowerOf2 + 1;
                    Bitmap scaledBitmap = FinalImageJob.this.mBitmapHelper.getScaledBitmap(inputStream, (int) Math.pow(2.0d, (double) calculateInitialPowerOf2));
                    if (!(FinalImageJob.this.mImageMeta == null || FinalImageJob.this.mImageMeta.getOrientation() == null)) {
                        scaledBitmap = FinalImageJob.this.mBitmapHelper.rotate(scaledBitmap, (float) FinalImageJob.this.mImageMeta.getOrientation().getValue());
                    }
                    byte[] compress = FinalImageJob.this.mBitmapHelper.compress(scaledBitmap, Bitmap.CompressFormat.JPEG, 100);
                    if (!FinalImageJob.this.isBitmapTooLarge(compress)) {
                        FinalImageJob.this.mInputStreamHelper.close(inputStream);
                        return new ImageFinal(compress, "image/jpg");
                    }
                    calculateInitialPowerOf2 = i;
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    public int calculateInitialPowerOf2(Size size) {
        double width = (double) (size.getWidth() * size.getHeight());
        Double.isNaN(width);
        return (int) Math.max(Math.log(((width * ESTIMATED_JPG_BITS_PER_PIXEL) / 8.0d) / MAX_FILE_SIZE_IN_BYTES) / Math.log(2.0d), 0.0d);
    }

    /* access modifiers changed from: package-private */
    public boolean isBitmapTooLarge(byte[] bArr) {
        return ((double) bArr.length) > MAX_FILE_SIZE_IN_BYTES;
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

        public Builder with(Context context) {
            this.mContext = context;
            return this;
        }

        public Builder imageMeta(ImageMeta imageMeta) {
            this.mImageMeta = imageMeta;
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

        public FinalImageJob build() {
            Arguments.checkNotNull(this.mContext);
            Arguments.checkNotNull(this.mImageMeta);
            if (this.mContentResolver == null) {
                this.mContentResolver = this.mContext.getContentResolver();
            }
            if (this.mInputStreamHelper == null) {
                this.mInputStreamHelper = new InputStreamHelper();
            }
            if (this.mBitmapHelper == null) {
                this.mBitmapHelper = new BitmapHelper();
            }
            return new FinalImageJob(this);
        }
    }
}
