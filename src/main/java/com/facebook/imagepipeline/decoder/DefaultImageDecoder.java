package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import java.util.Map;

public class DefaultImageDecoder implements ImageDecoder {
    private final ImageDecoder mAnimatedGifDecoder;
    private final ImageDecoder mAnimatedWebPDecoder;
    private final Map<ImageFormat, ImageDecoder> mCustomDecoders;
    private final ImageDecoder mDefaultDecoder;
    private final PlatformDecoder mPlatformDecoder;

    public DefaultImageDecoder(ImageDecoder imageDecoder, ImageDecoder imageDecoder2, PlatformDecoder platformDecoder) {
        this(imageDecoder, imageDecoder2, platformDecoder, (Map<ImageFormat, ImageDecoder>) null);
    }

    public DefaultImageDecoder(ImageDecoder imageDecoder, ImageDecoder imageDecoder2, PlatformDecoder platformDecoder, Map<ImageFormat, ImageDecoder> map) {
        this.mDefaultDecoder = new ImageDecoder() {
            public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
                ImageFormat imageFormat = encodedImage.getImageFormat();
                if (imageFormat == DefaultImageFormats.JPEG) {
                    return DefaultImageDecoder.this.decodeJpeg(encodedImage, i, qualityInfo, imageDecodeOptions);
                }
                if (imageFormat == DefaultImageFormats.GIF) {
                    return DefaultImageDecoder.this.decodeGif(encodedImage, i, qualityInfo, imageDecodeOptions);
                }
                if (imageFormat == DefaultImageFormats.WEBP_ANIMATED) {
                    return DefaultImageDecoder.this.decodeAnimatedWebp(encodedImage, i, qualityInfo, imageDecodeOptions);
                }
                if (imageFormat != ImageFormat.UNKNOWN) {
                    return DefaultImageDecoder.this.decodeStaticImage(encodedImage, imageDecodeOptions);
                }
                throw new DecodeException("unknown image format", encodedImage);
            }
        };
        this.mAnimatedGifDecoder = imageDecoder;
        this.mAnimatedWebPDecoder = imageDecoder2;
        this.mPlatformDecoder = platformDecoder;
        this.mCustomDecoders = map;
    }

    public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        if (imageDecodeOptions.customImageDecoder != null) {
            return imageDecodeOptions.customImageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
        ImageFormat imageFormat = encodedImage.getImageFormat();
        if (imageFormat == null || imageFormat == ImageFormat.UNKNOWN) {
            imageFormat = ImageFormatChecker.getImageFormat_WrapIOException(encodedImage.getInputStream());
            encodedImage.setImageFormat(imageFormat);
        }
        Map<ImageFormat, ImageDecoder> map = this.mCustomDecoders;
        if (map != null) {
            ImageDecoder imageDecoder = map.get(imageFormat);
            if (imageDecoder != null) {
                return imageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
            }
        }
        return this.mDefaultDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
    }

    public CloseableImage decodeGif(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        if (encodedImage.getWidth() == -1 || encodedImage.getHeight() == -1) {
            throw new DecodeException("image width or height is incorrect", encodedImage);
        }
        if (!imageDecodeOptions.forceStaticImage) {
            ImageDecoder imageDecoder = this.mAnimatedGifDecoder;
            if (imageDecoder != null) {
                return imageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
            }
        }
        return decodeStaticImage(encodedImage, imageDecodeOptions);
    }

    public CloseableStaticBitmap decodeStaticImage(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions) {
        CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace = this.mPlatformDecoder.decodeFromEncodedImageWithColorSpace(encodedImage, imageDecodeOptions.bitmapConfig, (Rect) null, imageDecodeOptions.colorSpace);
        try {
            maybeApplyTransformation(imageDecodeOptions.bitmapTransformation, decodeFromEncodedImageWithColorSpace);
            return new CloseableStaticBitmap(decodeFromEncodedImageWithColorSpace, ImmutableQualityInfo.FULL_QUALITY, encodedImage.getRotationAngle(), encodedImage.getExifOrientation());
        } finally {
            decodeFromEncodedImageWithColorSpace.close();
        }
    }

    public CloseableStaticBitmap decodeJpeg(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace = this.mPlatformDecoder.decodeJPEGFromEncodedImageWithColorSpace(encodedImage, imageDecodeOptions.bitmapConfig, (Rect) null, i, imageDecodeOptions.colorSpace);
        try {
            maybeApplyTransformation(imageDecodeOptions.bitmapTransformation, decodeJPEGFromEncodedImageWithColorSpace);
            return new CloseableStaticBitmap(decodeJPEGFromEncodedImageWithColorSpace, qualityInfo, encodedImage.getRotationAngle(), encodedImage.getExifOrientation());
        } finally {
            decodeJPEGFromEncodedImageWithColorSpace.close();
        }
    }

    public CloseableImage decodeAnimatedWebp(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        return this.mAnimatedWebPDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
    }

    private void maybeApplyTransformation(BitmapTransformation bitmapTransformation, CloseableReference<Bitmap> closeableReference) {
        if (bitmapTransformation != null) {
            Bitmap bitmap = closeableReference.get();
            if (Build.VERSION.SDK_INT >= 12 && bitmapTransformation.modifiesTransparency()) {
                bitmap.setHasAlpha(true);
            }
            bitmapTransformation.transform(bitmap);
        }
    }
}
