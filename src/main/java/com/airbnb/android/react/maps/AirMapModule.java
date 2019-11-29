package com.airbnb.android.react.maps;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = "AirMapModule")
public class AirMapModule extends ReactContextBaseJavaModule {
    protected static final String NAME = "AirMapModule";
    private static final String SNAPSHOT_FORMAT_JPG = "jpg";
    private static final String SNAPSHOT_FORMAT_PNG = "png";
    private static final String SNAPSHOT_RESULT_BASE64 = "base64";
    private static final String SNAPSHOT_RESULT_FILE = "file";

    public String getName() {
        return NAME;
    }

    public AirMapModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("legalNotice", "This license information is displayed in Settings > Google > Open Source on any device running Google Play services.");
        return hashMap;
    }

    public Activity getActivity() {
        return getCurrentActivity();
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @ReactMethod
    public void takeSnapshot(int i, ReadableMap readableMap, Promise promise) {
        Bitmap.CompressFormat compressFormat;
        int i2;
        ReadableMap readableMap2 = readableMap;
        final ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        final String string = readableMap2.hasKey(IjkMediaMeta.IJKM_KEY_FORMAT) ? readableMap2.getString(IjkMediaMeta.IJKM_KEY_FORMAT) : SNAPSHOT_FORMAT_PNG;
        if (string.equals(SNAPSHOT_FORMAT_PNG)) {
            compressFormat = Bitmap.CompressFormat.PNG;
        } else {
            compressFormat = string.equals(SNAPSHOT_FORMAT_JPG) ? Bitmap.CompressFormat.JPEG : null;
        }
        final Bitmap.CompressFormat compressFormat2 = compressFormat;
        final double d2 = readableMap2.hasKey("quality") ? readableMap2.getDouble("quality") : 1.0d;
        DisplayMetrics displayMetrics = reactApplicationContext.getResources().getDisplayMetrics();
        int i3 = 0;
        if (readableMap2.hasKey("width")) {
            double d3 = (double) displayMetrics.density;
            double d4 = readableMap2.getDouble("width");
            Double.isNaN(d3);
            i2 = (int) (d3 * d4);
        } else {
            i2 = 0;
        }
        Integer valueOf = Integer.valueOf(i2);
        if (readableMap2.hasKey("height")) {
            double d5 = (double) displayMetrics.density;
            double d6 = readableMap2.getDouble("height");
            Double.isNaN(d5);
            i3 = (int) (d5 * d6);
        }
        Integer valueOf2 = Integer.valueOf(i3);
        final int i4 = i;
        final Promise promise2 = promise;
        final Integer num = valueOf;
        final Integer num2 = valueOf2;
        final String string2 = readableMap2.hasKey(AbTestingModule.KEY_RESULT) ? readableMap2.getString(AbTestingModule.KEY_RESULT) : "file";
        ((UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                j jVar = (j) nativeViewHierarchyManager.resolveView(i4);
                if (jVar == null) {
                    promise2.reject("AirMapView not found");
                } else if (jVar.f3306a == null) {
                    promise2.reject("AirMapView.map is not valid");
                } else {
                    jVar.f3306a.snapshot(new GoogleMap.SnapshotReadyCallback() {
                        public void onSnapshotReady(Bitmap bitmap) {
                            if (bitmap == null) {
                                promise2.reject("Failed to generate bitmap, snapshot = null");
                                return;
                            }
                            if (!(num.intValue() == 0 || num2.intValue() == 0 || (num.intValue() == bitmap.getWidth() && num2.intValue() == bitmap.getHeight()))) {
                                bitmap = Bitmap.createScaledBitmap(bitmap, num.intValue(), num2.intValue(), true);
                            }
                            if (string2.equals("file")) {
                                try {
                                    File createTempFile = File.createTempFile("AirMapSnapshot", "." + string, reactApplicationContext.getCacheDir());
                                    FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                                    bitmap.compress(compressFormat2, (int) (d2 * 100.0d), fileOutputStream);
                                    AirMapModule.closeQuietly(fileOutputStream);
                                    promise2.resolve(Uri.fromFile(createTempFile).toString());
                                } catch (Exception e2) {
                                    promise2.reject((Throwable) e2);
                                }
                            } else if (string2.equals(AirMapModule.SNAPSHOT_RESULT_BASE64)) {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                bitmap.compress(compressFormat2, (int) (d2 * 100.0d), byteArrayOutputStream);
                                AirMapModule.closeQuietly(byteArrayOutputStream);
                                promise2.resolve(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2));
                            }
                        }
                    });
                }
            }
        });
    }

    @ReactMethod
    public void pointForCoordinate(int i, ReadableMap readableMap, Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        final double d2 = (double) reactApplicationContext.getResources().getDisplayMetrics().density;
        double d3 = 0.0d;
        double d4 = readableMap.hasKey("latitude") ? readableMap.getDouble("latitude") : 0.0d;
        if (readableMap.hasKey("longitude")) {
            d3 = readableMap.getDouble("longitude");
        }
        final LatLng latLng = new LatLng(d4, d3);
        final int i2 = i;
        final Promise promise2 = promise;
        ((UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                j jVar = (j) nativeViewHierarchyManager.resolveView(i2);
                if (jVar == null) {
                    promise2.reject("AirMapView not found");
                } else if (jVar.f3306a == null) {
                    promise2.reject("AirMapView.map is not valid");
                } else {
                    Point screenLocation = jVar.f3306a.getProjection().toScreenLocation(latLng);
                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                    double d2 = (double) screenLocation.x;
                    double d3 = d2;
                    Double.isNaN(d2);
                    writableNativeMap.putDouble("x", d2 / d3);
                    double d4 = (double) screenLocation.y;
                    double d5 = d2;
                    Double.isNaN(d4);
                    writableNativeMap.putDouble("y", d4 / d5);
                    promise2.resolve(writableNativeMap);
                }
            }
        });
    }

    @ReactMethod
    public void coordinateForPoint(final int i, ReadableMap readableMap, final Promise promise) {
        int i2;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        double d2 = (double) reactApplicationContext.getResources().getDisplayMetrics().density;
        int i3 = 0;
        if (readableMap.hasKey("x")) {
            double d3 = readableMap.getDouble("x");
            Double.isNaN(d2);
            i2 = (int) (d3 * d2);
        } else {
            i2 = 0;
        }
        if (readableMap.hasKey("y")) {
            double d4 = readableMap.getDouble("y");
            Double.isNaN(d2);
            i3 = (int) (d4 * d2);
        }
        final Point point = new Point(i2, i3);
        ((UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                j jVar = (j) nativeViewHierarchyManager.resolveView(i);
                if (jVar == null) {
                    promise.reject("AirMapView not found");
                } else if (jVar.f3306a == null) {
                    promise.reject("AirMapView.map is not valid");
                } else {
                    LatLng fromScreenLocation = jVar.f3306a.getProjection().fromScreenLocation(point);
                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                    writableNativeMap.putDouble("latitude", fromScreenLocation.latitude);
                    writableNativeMap.putDouble("longitude", fromScreenLocation.longitude);
                    promise.resolve(writableNativeMap);
                }
            }
        });
    }
}
