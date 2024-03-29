package com.facebook.react.views.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.controller.ForwardingControllerListener;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.fresco.ReactNetworkImageRequest;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.FloatUtil;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.imagehelper.ImageSource;
import com.facebook.react.views.imagehelper.MultiSourceHelper;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.facebook.share.internal.ShareConstants;
import com.facebook.yoga.YogaConstants;
import com.garena.android.gpns.utility.CONSTANT;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class ReactImageView extends GenericDraweeView {
    public static int MAX_DEBUG_IMAGE_SIZE = CONSTANT.TIME.MIN_5;
    public static final int REMOTE_IMAGE_FADE_DURATION_MS = 300;
    public static final String REMOTE_TRANSPARENT_BITMAP_URI = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII=";
    /* access modifiers changed from: private */
    public static float[] sComputedCornerRadii = new float[4];
    /* access modifiers changed from: private */
    public static final Matrix sInverse = new Matrix();
    /* access modifiers changed from: private */
    public static final Matrix sMatrix = new Matrix();
    /* access modifiers changed from: private */
    public static final Matrix sTileMatrix = new Matrix();
    private int mBackgroundColor = 0;
    private RoundedColorDrawable mBackgroundImageDrawable;
    private Bitmap.Config mBitmapConfig;
    private int mBorderColor;
    private float[] mBorderCornerRadii;
    private float mBorderRadius = Float.NaN;
    private float mBorderWidth;
    private ImageSource mCachedImageSource;
    private final Object mCallerContext;
    private ControllerListener mControllerForTesting;
    private ControllerListener mControllerListener;
    private Drawable mDefaultImageDrawable;
    private final AbstractDraweeControllerBuilder mDraweeControllerBuilder;
    private int mFadeDurationMs = -1;
    private GlobalImageLoadListener mGlobalImageLoadListener;
    private ReadableMap mHeaders;
    /* access modifiers changed from: private */
    public ImageSource mImageSource;
    protected boolean mIsDirty;
    private IterativeBoxBlurPostProcessor mIterativeBoxBlurPostProcessor;
    private Drawable mLoadingImageDrawable;
    private boolean mOptimizeEnabled = true;
    private int mOverlayColor;
    private boolean mProgressiveRenderingEnabled;
    private int mResizeHeight = -1;
    private ImageResizeMethod mResizeMethod = ImageResizeMethod.AUTO;
    private int mResizeWidth = -1;
    private final RoundedCornerPostprocessor mRoundedCornerPostprocessor;
    /* access modifiers changed from: private */
    public ScalingUtils.ScaleType mScaleType = ImageResizeMode.defaultValue();
    private final List<ImageSource> mSources;
    /* access modifiers changed from: private */
    public Shader.TileMode mTileMode = ImageResizeMode.defaultTileMode();
    private final TilePostprocessor mTilePostprocessor;

    private void warnImageSource(String str) {
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    private class RoundedCornerPostprocessor extends BasePostprocessor {
        private RoundedCornerPostprocessor() {
        }

        /* access modifiers changed from: package-private */
        public void getRadii(Bitmap bitmap, float[] fArr, float[] fArr2) {
            ReactImageView.this.mScaleType.getTransform(ReactImageView.sMatrix, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), bitmap.getWidth(), bitmap.getHeight(), BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
            ReactImageView.sMatrix.invert(ReactImageView.sInverse);
            fArr2[0] = ReactImageView.sInverse.mapRadius(fArr[0]);
            fArr2[1] = fArr2[0];
            fArr2[2] = ReactImageView.sInverse.mapRadius(fArr[1]);
            fArr2[3] = fArr2[2];
            fArr2[4] = ReactImageView.sInverse.mapRadius(fArr[2]);
            fArr2[5] = fArr2[4];
            fArr2[6] = ReactImageView.sInverse.mapRadius(fArr[3]);
            fArr2[7] = fArr2[6];
        }

        public void process(Bitmap bitmap, Bitmap bitmap2) {
            ReactImageView.this.cornerRadii(ReactImageView.sComputedCornerRadii);
            bitmap.setHasAlpha(true);
            if (!FloatUtil.floatsEqual(ReactImageView.sComputedCornerRadii[0], BitmapDescriptorFactory.HUE_RED) || !FloatUtil.floatsEqual(ReactImageView.sComputedCornerRadii[1], BitmapDescriptorFactory.HUE_RED) || !FloatUtil.floatsEqual(ReactImageView.sComputedCornerRadii[2], BitmapDescriptorFactory.HUE_RED) || !FloatUtil.floatsEqual(ReactImageView.sComputedCornerRadii[3], BitmapDescriptorFactory.HUE_RED)) {
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setShader(new BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
                Canvas canvas = new Canvas(bitmap);
                float[] fArr = new float[8];
                getRadii(bitmap2, ReactImageView.sComputedCornerRadii, fArr);
                Path path = new Path();
                path.addRoundRect(new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) bitmap2.getWidth(), (float) bitmap2.getHeight()), fArr, Path.Direction.CW);
                canvas.drawPath(path, paint);
                return;
            }
            super.process(bitmap, bitmap2);
        }

        public String getName() {
            return getClass().getSimpleName();
        }

        public CacheKey getPostprocessorCacheKey() {
            return new SimpleCacheKey(String.format(Locale.ENGLISH, "%f%f%f%f", new Object[]{Float.valueOf(ReactImageView.sComputedCornerRadii[0]), Float.valueOf(ReactImageView.sComputedCornerRadii[1]), Float.valueOf(ReactImageView.sComputedCornerRadii[2]), Float.valueOf(ReactImageView.sComputedCornerRadii[3])}));
        }
    }

    private class TilePostprocessor extends BasePostprocessor {
        private TilePostprocessor() {
        }

        public CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
            Rect rect = new Rect(0, 0, ReactImageView.this.getWidth(), ReactImageView.this.getHeight());
            ReactImageView.this.mScaleType.getTransform(ReactImageView.sTileMatrix, rect, bitmap.getWidth(), bitmap.getHeight(), BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            BitmapShader bitmapShader = new BitmapShader(bitmap, ReactImageView.this.mTileMode, ReactImageView.this.mTileMode);
            bitmapShader.setLocalMatrix(ReactImageView.sTileMatrix);
            paint.setShader(bitmapShader);
            CloseableReference<Bitmap> createBitmap = platformBitmapFactory.createBitmap(ReactImageView.this.getWidth(), ReactImageView.this.getHeight());
            try {
                new Canvas(createBitmap.get()).drawRect(rect, paint);
                return createBitmap.clone();
            } finally {
                CloseableReference.closeSafely((CloseableReference<?>) createBitmap);
            }
        }

        public String getName() {
            return getClass().getSimpleName();
        }
    }

    private static GenericDraweeHierarchy buildHierarchy(Context context) {
        return new GenericDraweeHierarchyBuilder(context.getResources()).setRoundingParams(RoundingParams.fromCornersRadius(BitmapDescriptorFactory.HUE_RED)).build();
    }

    public ReactImageView(Context context, AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, GlobalImageLoadListener globalImageLoadListener, Object obj) {
        super(context, buildHierarchy(context));
        this.mDraweeControllerBuilder = abstractDraweeControllerBuilder;
        this.mRoundedCornerPostprocessor = new RoundedCornerPostprocessor();
        this.mTilePostprocessor = new TilePostprocessor();
        this.mGlobalImageLoadListener = globalImageLoadListener;
        this.mCallerContext = obj;
        this.mSources = new LinkedList();
    }

    public void setShouldNotifyLoadEvents(boolean z) {
        if (!z) {
            this.mControllerListener = null;
        } else {
            final EventDispatcher eventDispatcher = ((UIManagerModule) ((ReactContext) getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();
            this.mControllerListener = new BaseControllerListener<ImageInfo>() {
                public void onSubmit(String str, Object obj) {
                    eventDispatcher.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), 4));
                }

                public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
                    if (imageInfo != null) {
                        eventDispatcher.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), 2, ReactImageView.this.mImageSource.getSource(), imageInfo.getWidth(), imageInfo.getHeight()));
                        eventDispatcher.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), 3));
                    }
                }

                public void onFailure(String str, Throwable th) {
                    eventDispatcher.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), 1, true, th.getMessage()));
                }
            };
        }
        this.mIsDirty = true;
    }

    public void setBlurRadius(float f2) {
        int pixelFromDIP = (int) PixelUtil.toPixelFromDIP(f2);
        if (pixelFromDIP == 0) {
            this.mIterativeBoxBlurPostProcessor = null;
        } else {
            this.mIterativeBoxBlurPostProcessor = new IterativeBoxBlurPostProcessor(pixelFromDIP);
        }
        this.mIsDirty = true;
    }

    public void setBackgroundColor(int i) {
        if (this.mBackgroundColor != i) {
            this.mBackgroundColor = i;
            this.mBackgroundImageDrawable = new RoundedColorDrawable(i);
            this.mIsDirty = true;
        }
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
        this.mIsDirty = true;
    }

    public void setOverlayColor(int i) {
        this.mOverlayColor = i;
        this.mIsDirty = true;
    }

    public void setBorderWidth(float f2) {
        this.mBorderWidth = PixelUtil.toPixelFromDIP(f2);
        this.mIsDirty = true;
    }

    public void setBorderRadius(float f2) {
        if (!FloatUtil.floatsEqual(this.mBorderRadius, f2)) {
            this.mBorderRadius = f2;
            this.mIsDirty = true;
        }
    }

    public void setBorderRadius(float f2, int i) {
        if (this.mBorderCornerRadii == null) {
            this.mBorderCornerRadii = new float[4];
            Arrays.fill(this.mBorderCornerRadii, Float.NaN);
        }
        if (!FloatUtil.floatsEqual(this.mBorderCornerRadii[i], f2)) {
            this.mBorderCornerRadii[i] = f2;
            this.mIsDirty = true;
        }
    }

    public void setScaleType(ScalingUtils.ScaleType scaleType) {
        this.mScaleType = scaleType;
        this.mIsDirty = true;
    }

    public void setTileMode(Shader.TileMode tileMode) {
        this.mTileMode = tileMode;
        this.mIsDirty = true;
    }

    public void setResizeMethod(ImageResizeMethod imageResizeMethod) {
        this.mResizeMethod = imageResizeMethod;
        this.mIsDirty = true;
    }

    public void setSource(ReadableArray readableArray) {
        this.mSources.clear();
        if (readableArray == null || readableArray.size() == 0) {
            this.mSources.add(new ImageSource(getContext(), REMOTE_TRANSPARENT_BITMAP_URI));
        } else {
            if (readableArray.size() == 1) {
                String string = readableArray.getMap(0).getString(ShareConstants.MEDIA_URI);
                ImageSource imageSource = new ImageSource(getContext(), string);
                this.mSources.add(imageSource);
                if (Uri.EMPTY.equals(imageSource.getUri())) {
                    warnImageSource(string);
                }
            } else {
                for (int i = 0; i < readableArray.size(); i++) {
                    ReadableMap map = readableArray.getMap(i);
                    String string2 = map.getString(ShareConstants.MEDIA_URI);
                    ImageSource imageSource2 = new ImageSource(getContext(), string2, map.getDouble("width"), map.getDouble("height"));
                    this.mSources.add(imageSource2);
                    if (Uri.EMPTY.equals(imageSource2.getUri())) {
                        warnImageSource(string2);
                    }
                }
            }
        }
        this.mIsDirty = true;
    }

    public void setDefaultSource(String str) {
        this.mDefaultImageDrawable = ResourceDrawableIdHelper.getInstance().getResourceDrawable(getContext(), str);
        this.mIsDirty = true;
    }

    public void setLoadingIndicatorSource(String str) {
        Drawable resourceDrawable = ResourceDrawableIdHelper.getInstance().getResourceDrawable(getContext(), str);
        this.mLoadingImageDrawable = resourceDrawable != null ? new AutoRotateDrawable(resourceDrawable, 1000) : null;
        this.mIsDirty = true;
    }

    public void setProgressiveRenderingEnabled(boolean z) {
        this.mProgressiveRenderingEnabled = z;
    }

    public void setFadeDuration(int i) {
        this.mFadeDurationMs = i;
    }

    /* access modifiers changed from: private */
    public void cornerRadii(float[] fArr) {
        float f2 = !YogaConstants.isUndefined(this.mBorderRadius) ? this.mBorderRadius : BitmapDescriptorFactory.HUE_RED;
        float[] fArr2 = this.mBorderCornerRadii;
        fArr[0] = (fArr2 == null || YogaConstants.isUndefined(fArr2[0])) ? f2 : this.mBorderCornerRadii[0];
        float[] fArr3 = this.mBorderCornerRadii;
        fArr[1] = (fArr3 == null || YogaConstants.isUndefined(fArr3[1])) ? f2 : this.mBorderCornerRadii[1];
        float[] fArr4 = this.mBorderCornerRadii;
        fArr[2] = (fArr4 == null || YogaConstants.isUndefined(fArr4[2])) ? f2 : this.mBorderCornerRadii[2];
        float[] fArr5 = this.mBorderCornerRadii;
        if (fArr5 != null && !YogaConstants.isUndefined(fArr5[3])) {
            f2 = this.mBorderCornerRadii[3];
        }
        fArr[3] = f2;
    }

    public void setHeaders(ReadableMap readableMap) {
        this.mHeaders = readableMap;
    }

    public void setResizeDimension(int i, int i2) {
        this.mResizeWidth = i;
        this.mResizeHeight = i2;
    }

    public void setBitmapConfig(String str) {
        if (!TextUtils.isEmpty(str)) {
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 1138394946) {
                if (hashCode != 1701049491) {
                    if (hashCode == 1701172627 && str.equals("argb_8888")) {
                        c2 = 1;
                    }
                } else if (str.equals("argb_4444")) {
                    c2 = 2;
                }
            } else if (str.equals("rgb_565")) {
                c2 = 0;
            }
            if (c2 == 0) {
                this.mBitmapConfig = Bitmap.Config.RGB_565;
            } else if (c2 == 1) {
                this.mBitmapConfig = Bitmap.Config.ARGB_8888;
            } else if (c2 == 2) {
                this.mBitmapConfig = Bitmap.Config.ARGB_4444;
            }
        }
    }

    public void setOptimizeEnabled(boolean z) {
        this.mOptimizeEnabled = z;
    }

    public void maybeUpdateView() {
        if (this.mIsDirty) {
            if (!hasMultipleSources() || (getWidth() > 0 && getHeight() > 0)) {
                setSourceImage();
                ImageSource imageSource = this.mImageSource;
                if (imageSource != null) {
                    boolean shouldResize = shouldResize(imageSource);
                    if (shouldResize && (getWidth() <= 0 || getHeight() <= 0)) {
                        return;
                    }
                    if (!isTiled() || (getWidth() > 0 && getHeight() > 0)) {
                        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) getHierarchy();
                        genericDraweeHierarchy.setActualImageScaleType(this.mScaleType);
                        Drawable drawable = this.mDefaultImageDrawable;
                        if (drawable != null) {
                            genericDraweeHierarchy.setPlaceholderImage(drawable, this.mScaleType);
                        }
                        Drawable drawable2 = this.mLoadingImageDrawable;
                        if (drawable2 != null) {
                            genericDraweeHierarchy.setPlaceholderImage(drawable2, ScalingUtils.ScaleType.CENTER);
                        }
                        boolean z = (this.mScaleType == ScalingUtils.ScaleType.CENTER_CROP || this.mScaleType == ScalingUtils.ScaleType.FOCUS_CROP) ? false : true;
                        RoundingParams roundingParams = genericDraweeHierarchy.getRoundingParams();
                        cornerRadii(sComputedCornerRadii);
                        float[] fArr = sComputedCornerRadii;
                        roundingParams.setCornersRadii(fArr[0], fArr[1], fArr[2], fArr[3]);
                        RoundedColorDrawable roundedColorDrawable = this.mBackgroundImageDrawable;
                        if (roundedColorDrawable != null) {
                            roundedColorDrawable.setBorder(this.mBorderColor, this.mBorderWidth);
                            this.mBackgroundImageDrawable.setRadii(roundingParams.getCornersRadii());
                            genericDraweeHierarchy.setBackgroundImage(this.mBackgroundImageDrawable);
                        }
                        if (z) {
                            roundingParams.setCornersRadius(BitmapDescriptorFactory.HUE_RED);
                        }
                        roundingParams.setBorder(this.mBorderColor, this.mBorderWidth);
                        int i = this.mOverlayColor;
                        if (i != 0) {
                            roundingParams.setOverlayColor(i);
                        } else {
                            roundingParams.setRoundingMethod(RoundingParams.RoundingMethod.BITMAP_ONLY);
                        }
                        genericDraweeHierarchy.setRoundingParams(roundingParams);
                        int i2 = this.mFadeDurationMs;
                        if (i2 < 0) {
                            i2 = this.mImageSource.isResource() ? 0 : 300;
                        }
                        genericDraweeHierarchy.setFadeDuration(i2);
                        LinkedList linkedList = new LinkedList();
                        if (z) {
                            linkedList.add(this.mRoundedCornerPostprocessor);
                        }
                        IterativeBoxBlurPostProcessor iterativeBoxBlurPostProcessor = this.mIterativeBoxBlurPostProcessor;
                        if (iterativeBoxBlurPostProcessor != null) {
                            linkedList.add(iterativeBoxBlurPostProcessor);
                        }
                        if (isTiled()) {
                            linkedList.add(this.mTilePostprocessor);
                        }
                        Postprocessor from = MultiPostprocessor.from(linkedList);
                        ResizeOptions resizeOption = shouldResize ? getResizeOption() : null;
                        Bitmap.Config bitmapConfig = getBitmapConfig();
                        ImageDecodeOptionsBuilder newBuilder = ImageDecodeOptions.newBuilder();
                        if (bitmapConfig != null) {
                            newBuilder.setBitmapConfig(bitmapConfig);
                        }
                        if (Build.VERSION.SDK_INT <= 23) {
                            newBuilder.setForceStaticImage(true).setDecodePreviewFrame(true);
                        }
                        ImageDecodeOptions build = newBuilder.build();
                        ReactNetworkImageRequest fromBuilderWithHeaders = ReactNetworkImageRequest.fromBuilderWithHeaders(ImageRequestBuilder.newBuilderWithSource(this.mImageSource.getUri()).setPostprocessor(from).setResizeOptions(resizeOption).setImageDecodeOptions(build).setRotationOptions(RotationOptions.autoRotate()).setProgressiveRenderingEnabled(this.mProgressiveRenderingEnabled), this.mHeaders);
                        GlobalImageLoadListener globalImageLoadListener = this.mGlobalImageLoadListener;
                        if (globalImageLoadListener != null) {
                            globalImageLoadListener.onLoadAttempt(this.mImageSource.getUri());
                        }
                        this.mDraweeControllerBuilder.reset();
                        this.mDraweeControllerBuilder.setAutoPlayAnimations(true).setCallerContext(this.mCallerContext).setOldController(getController()).setImageRequest(fromBuilderWithHeaders);
                        ImageSource imageSource2 = this.mCachedImageSource;
                        if (imageSource2 != null) {
                            this.mDraweeControllerBuilder.setLowResImageRequest(ImageRequestBuilder.newBuilderWithSource(imageSource2.getUri()).setPostprocessor(from).setResizeOptions(resizeOption).setImageDecodeOptions(build).setRotationOptions(RotationOptions.autoRotate()).setProgressiveRenderingEnabled(this.mProgressiveRenderingEnabled).build());
                        }
                        if (this.mControllerListener == null || this.mControllerForTesting == null) {
                            ControllerListener controllerListener = this.mControllerForTesting;
                            if (controllerListener != null) {
                                this.mDraweeControllerBuilder.setControllerListener(controllerListener);
                            } else {
                                ControllerListener controllerListener2 = this.mControllerListener;
                                if (controllerListener2 != null) {
                                    this.mDraweeControllerBuilder.setControllerListener(controllerListener2);
                                }
                            }
                        } else {
                            ForwardingControllerListener forwardingControllerListener = new ForwardingControllerListener();
                            forwardingControllerListener.addListener(this.mControllerListener);
                            forwardingControllerListener.addListener(this.mControllerForTesting);
                            this.mDraweeControllerBuilder.setControllerListener(forwardingControllerListener);
                        }
                        setController(this.mDraweeControllerBuilder.build());
                        this.mIsDirty = false;
                        this.mDraweeControllerBuilder.reset();
                    }
                }
            }
        }
    }

    public void setControllerListener(ControllerListener controllerListener) {
        this.mControllerForTesting = controllerListener;
        this.mIsDirty = true;
        maybeUpdateView();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.mIsDirty = this.mIsDirty || hasMultipleSources() || isTiled();
            maybeUpdateView();
        }
    }

    private boolean hasMultipleSources() {
        return this.mSources.size() > 1;
    }

    private boolean isTiled() {
        return this.mTileMode != Shader.TileMode.CLAMP;
    }

    private void setSourceImage() {
        this.mImageSource = null;
        if (this.mSources.isEmpty()) {
            this.mSources.add(new ImageSource(getContext(), REMOTE_TRANSPARENT_BITMAP_URI));
        } else if (hasMultipleSources()) {
            MultiSourceHelper.MultiSourceResult bestSourceForSize = MultiSourceHelper.getBestSourceForSize(getWidth(), getHeight(), this.mSources);
            this.mImageSource = bestSourceForSize.getBestResult();
            this.mCachedImageSource = bestSourceForSize.getBestResultInCache();
            return;
        }
        this.mImageSource = this.mSources.get(0);
    }

    private boolean shouldResize(ImageSource imageSource) {
        if (this.mResizeMethod != ImageResizeMethod.AUTO) {
            return this.mResizeMethod == ImageResizeMethod.RESIZE;
        }
        if (UriUtil.isLocalContentUri(imageSource.getUri()) || UriUtil.isLocalFileUri(imageSource.getUri())) {
            return true;
        }
        return false;
    }

    private ResizeOptions getResizeOption() {
        float f2;
        if (this.mImageSource == null) {
            return null;
        }
        int width = getWidth();
        int height = getHeight();
        String host = this.mImageSource.getUri().getHost();
        boolean z = true;
        boolean z2 = this.mOptimizeEnabled && Build.VERSION.SDK_INT >= 21;
        if (!UriUtil.isLocalContentUri(this.mImageSource.getUri()) && !UriUtil.isLocalFileUri(this.mImageSource.getUri()) && (host == null || !host.contains(AndroidInfoHelpers.DEVICE_LOCALHOST))) {
            z = false;
        }
        if (z) {
            int i = this.mResizeWidth;
            if (i > 0) {
                int i2 = this.mResizeHeight;
                if (i2 > 0) {
                    return new ResizeOptions(i, i2);
                }
            }
            if (z2) {
                DisplayMetrics screenDisplayMetrics = DisplayMetricsHolder.getScreenDisplayMetrics();
                int i3 = screenDisplayMetrics.widthPixels;
                int i4 = screenDisplayMetrics.heightPixels;
                if (((float) width) > ((float) i3) * 0.8f || ((float) height) > ((float) i4) * 0.8f) {
                    return new ResizeOptions(width / 2, height / 2);
                }
            }
            return new ResizeOptions(width, height);
        }
        int i5 = this.mResizeWidth;
        if (i5 > 0) {
            int i6 = this.mResizeHeight;
            if (i6 > 0) {
                return new ResizeOptions(i5, i6);
            }
        }
        if (!z2) {
            return new ResizeOptions(width, height);
        }
        DisplayMetrics screenDisplayMetrics2 = DisplayMetricsHolder.getScreenDisplayMetrics();
        if (screenDisplayMetrics2.density >= 3.0f) {
            f2 = 0.5f;
        } else {
            f2 = screenDisplayMetrics2.density >= 2.0f ? 0.75f : 1.0f;
        }
        return new ResizeOptions((int) (((float) width) * f2), (int) (((float) height) * f2));
    }

    private Bitmap.Config getBitmapConfig() {
        ImageSource imageSource = this.mImageSource;
        if (imageSource == null) {
            return null;
        }
        if (this.mIterativeBoxBlurPostProcessor != null) {
            return Bitmap.Config.ARGB_8888;
        }
        Bitmap.Config config = this.mBitmapConfig;
        if (config != null) {
            return config;
        }
        if (!this.mOptimizeEnabled) {
            return null;
        }
        String lastPathSegment = imageSource.getUri().getLastPathSegment();
        if (TextUtils.isEmpty(lastPathSegment) || !lastPathSegment.endsWith(".png")) {
            return Bitmap.Config.RGB_565;
        }
        return Bitmap.Config.ARGB_8888;
    }
}
