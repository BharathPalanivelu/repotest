package fr.greweb.reactnativeviewshot;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import android.util.Log;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.UIManagerModule;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public class RNViewShotModule extends ReactContextBaseJavaModule {
    public static final String SNAPSHOT_VIEW = "SnapshotView";
    private static final String TEMP_FILE_PREFIX = "ReactNative-snapshot-image";
    private final ReactApplicationContext reactContext;

    public String getName() {
        return SNAPSHOT_VIEW;
    }

    public RNViewShotModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    public Map<String, Object> getConstants() {
        return Collections.emptyMap();
    }

    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        new a(getReactApplicationContext()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void releaseCapture(String str) {
        String path = Uri.parse(str).getPath();
        if (path != null) {
            File file = new File(path);
            if (file.exists()) {
                File parentFile = file.getParentFile();
                if (parentFile.equals(this.reactContext.getExternalCacheDir()) || parentFile.equals(this.reactContext.getCacheDir())) {
                    file.delete();
                }
            }
        }
    }

    @ReactMethod
    public void captureRef(int i, ReadableMap readableMap, Promise promise) {
        int i2;
        Integer num;
        Integer num2;
        int i3 = i;
        ReadableMap readableMap2 = readableMap;
        DisplayMetrics displayMetrics = getReactApplicationContext().getResources().getDisplayMetrics();
        String string = readableMap2.getString(IjkMediaMeta.IJKM_KEY_FORMAT);
        if ("jpg".equals(string)) {
            i2 = 0;
        } else if ("webm".equals(string)) {
            i2 = 2;
        } else {
            i2 = "raw".equals(string) ? -1 : 1;
        }
        double d2 = readableMap2.getDouble("quality");
        if (readableMap2.hasKey("width")) {
            double d3 = (double) displayMetrics.density;
            double d4 = readableMap2.getDouble("width");
            Double.isNaN(d3);
            num = Integer.valueOf((int) (d3 * d4));
        } else {
            num = null;
        }
        if (readableMap2.hasKey("height")) {
            double d5 = (double) displayMetrics.density;
            double d6 = readableMap2.getDouble("height");
            Double.isNaN(d5);
            num2 = Integer.valueOf((int) (d5 * d6));
        } else {
            num2 = null;
        }
        String string2 = readableMap2.getString(AbTestingModule.KEY_RESULT);
        Boolean valueOf = Boolean.valueOf(readableMap2.getBoolean("snapshotContentContainer"));
        try {
            File createTempFile = "tmpfile".equals(string2) ? createTempFile(getReactApplicationContext(), string) : null;
            Activity currentActivity = getCurrentActivity();
            ReactApplicationContext reactApplicationContext = this.reactContext;
            c cVar = r2;
            Integer num3 = num2;
            File file = createTempFile;
            UIManagerModule uIManagerModule = (UIManagerModule) this.reactContext.getNativeModule(UIManagerModule.class);
            c cVar2 = new c(i, string, i2, d2, num, num3, file, string2, valueOf, reactApplicationContext, currentActivity, promise);
            uIManagerModule.addUIBlock(cVar);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to snapshot view tag ");
            int i4 = i;
            sb.append(i4);
            Log.e(SNAPSHOT_VIEW, sb.toString(), th);
            promise.reject("E_UNABLE_TO_SNAPSHOT", "Failed to snapshot view tag " + i4);
        }
    }

    @ReactMethod
    public void captureScreen(ReadableMap readableMap, Promise promise) {
        captureRef(-1, readableMap, promise);
    }

    private static class a extends GuardedAsyncTask<Void, Void> implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        private final File f33027a;

        /* renamed from: b  reason: collision with root package name */
        private final File f33028b;

        private a(ReactContext reactContext) {
            super(reactContext);
            this.f33027a = reactContext.getCacheDir();
            this.f33028b = reactContext.getExternalCacheDir();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void doInBackgroundGuarded(Void... voidArr) {
            File file = this.f33027a;
            if (file != null) {
                a(file);
            }
            File file2 = this.f33028b;
            if (file2 != null) {
                a(file2);
            }
        }

        public final boolean accept(File file, String str) {
            return str.startsWith(RNViewShotModule.TEMP_FILE_PREFIX);
        }

        private void a(File file) {
            File[] listFiles = file.listFiles(this);
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.delete()) {
                        Log.d(RNViewShotModule.SNAPSHOT_VIEW, "deleted file: " + file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    private File createTempFile(Context context, String str) throws IOException {
        File externalCacheDir = context.getExternalCacheDir();
        File cacheDir = context.getCacheDir();
        if (externalCacheDir == null && cacheDir == null) {
            throw new IOException("No cache directory available");
        }
        if (externalCacheDir == null || (cacheDir != null && externalCacheDir.getFreeSpace() <= cacheDir.getFreeSpace())) {
            externalCacheDir = cacheDir;
        }
        return File.createTempFile(TEMP_FILE_PREFIX, "." + str, externalCacheDir);
    }
}
