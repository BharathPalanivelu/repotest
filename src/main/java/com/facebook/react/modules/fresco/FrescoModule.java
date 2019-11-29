package com.facebook.react.modules.fresco;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.ByteConstants;
import com.facebook.drawee.backends.pipeline.DraweeConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoderConfig;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.common.ModuleDataCleaner;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.tencent.ijk.media.player.IjkMediaCodecInfo;
import java.util.HashSet;
import okhttp3.OkHttpClient;

@ReactModule(name = "FrescoModule", needsEagerInit = true)
public class FrescoModule extends ReactContextBaseJavaModule implements LifecycleEventListener, ModuleDataCleaner.Cleanable {
    public static boolean DO_DEBUG = false;
    public static final String NAME = "FrescoModule";
    private static boolean sHasBeenInitialized = false;
    private final boolean mClearOnDestroy;
    private ImagePipelineConfig mConfig;

    public String getName() {
        return NAME;
    }

    public void onHostPause() {
    }

    public void onHostResume() {
    }

    public FrescoModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, true, (ImagePipelineConfig) null);
    }

    public FrescoModule(ReactApplicationContext reactApplicationContext, boolean z) {
        this(reactApplicationContext, z, (ImagePipelineConfig) null);
    }

    public FrescoModule(ReactApplicationContext reactApplicationContext, boolean z, ImagePipelineConfig imagePipelineConfig) {
        super(reactApplicationContext);
        this.mClearOnDestroy = z;
        this.mConfig = imagePipelineConfig;
    }

    public void initialize() {
        super.initialize();
        getReactApplicationContext().addLifecycleEventListener(this);
        if (!hasBeenInitialized()) {
            if (this.mConfig == null) {
                this.mConfig = getDefaultConfig(getReactApplicationContext());
            }
            Fresco.initialize(getReactApplicationContext().getApplicationContext(), this.mConfig);
            sHasBeenInitialized = true;
        } else if (this.mConfig != null) {
            FLog.w(ReactConstants.TAG, "Fresco has already been initialized with a different config. The new Fresco configuration will be ignored!");
        }
        this.mConfig = null;
    }

    public void clearSensitiveData() {
        Fresco.getImagePipeline().clearCaches();
    }

    public static void initializeFresco(Application application) {
        if (!hasBeenInitialized()) {
            DraweeConfig.Builder newBuilder = DraweeConfig.newBuilder();
            if (DO_DEBUG) {
                newBuilder.setDrawDebugOverlay(true);
            }
            Context applicationContext = application.getApplicationContext();
            Fresco.initialize(applicationContext, getDefaultConfig(applicationContext), newBuilder.build());
            sHasBeenInitialized = true;
        }
    }

    public static boolean hasBeenInitialized() {
        return sHasBeenInitialized;
    }

    private static ImagePipelineConfig getDefaultConfig(Context context) {
        return getDefaultConfigBuilder(context).build();
    }

    public static ImagePipelineConfig.Builder getDefaultConfigBuilder(Context context) {
        HashSet hashSet = new HashSet();
        hashSet.add(new SystraceRequestListener());
        OkHttpClient okHttpClient = OkHttpClientProvider.getOkHttpClient();
        return OkHttpImagePipelineConfigFactory.newBuilder(context.getApplicationContext(), okHttpClient).setNetworkFetcher(new ReactOkHttpNetworkFetcher(okHttpClient)).setDownsampleEnabled(true).setBitmapMemoryCacheParamsSupplier(new LollipopBitmapMemoryCacheParamsSupplier((ActivityManager) context.getSystemService("activity"))).setImageDecoderConfig(ImageDecoderConfig.newBuilder().overrideDecoder(DefaultImageFormats.PNG, new PNGDecoder()).build()).setRequestListeners(hashSet);
    }

    public void onHostDestroy() {
        if (hasBeenInitialized() && this.mClearOnDestroy) {
            Fresco.getImagePipeline().clearMemoryCaches();
        }
    }

    private static class LollipopBitmapMemoryCacheParamsSupplier implements Supplier<MemoryCacheParams> {
        private ActivityManager activityManager;

        public LollipopBitmapMemoryCacheParamsSupplier(ActivityManager activityManager2) {
            this.activityManager = activityManager2;
        }

        public MemoryCacheParams get() {
            int maxCacheSize = getMaxCacheSize();
            if (Build.VERSION.SDK_INT >= 21) {
                return new MemoryCacheParams(maxCacheSize, 256, Integer.MAX_VALUE, IjkMediaCodecInfo.RANK_LAST_CHANCE, 2000000);
            }
            return new MemoryCacheParams(maxCacheSize, 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        private int getMaxCacheSize() {
            int min = Math.min(this.activityManager.getMemoryClass() * ByteConstants.MB, Integer.MAX_VALUE);
            if (min < 33554432) {
                return 4194304;
            }
            if (min < 67108864) {
                return 6291456;
            }
            return min / 4;
        }
    }

    public static class PNGDecoder implements ImageDecoder {
        public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
            CloseableReference<Bitmap> decodeFromEncodedImage = Fresco.getImagePipelineFactory().getPlatformDecoder().decodeFromEncodedImage(encodedImage, Bitmap.Config.ARGB_8888, (Rect) null);
            try {
                return new CloseableStaticBitmap(decodeFromEncodedImage, ImmutableQualityInfo.FULL_QUALITY, encodedImage.getRotationAngle());
            } finally {
                decodeFromEncodedImage.close();
            }
        }
    }
}
