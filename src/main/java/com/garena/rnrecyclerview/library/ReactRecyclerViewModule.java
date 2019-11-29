package com.garena.rnrecyclerview.library;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name = "NativeRecyclerViewModule")
public class ReactRecyclerViewModule extends ReactContextBaseJavaModule {
    protected static final String NAME = "NativeRecyclerViewModule";
    /* access modifiers changed from: private */
    public HashMap<Integer, LinearLayoutManager> mViewMap = new HashMap<>();

    public String getName() {
        return NAME;
    }

    public ReactRecyclerViewModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public void registerLayoutManager(int i, LinearLayoutManager linearLayoutManager) {
        this.mViewMap.put(Integer.valueOf(i), linearLayoutManager);
    }

    public void unregisterLayoutManager(int i) {
        this.mViewMap.remove(Integer.valueOf(i));
    }

    @ReactMethod
    public void getLayout(final int i, final int i2, final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) ReactRecyclerViewModule.this.mViewMap.get(Integer.valueOf(i));
                    if (linearLayoutManager != null) {
                        int n = linearLayoutManager.n();
                        int p = linearLayoutManager.p();
                        if (i2 < n || i2 > p) {
                            promise.resolve(ReactRecyclerViewModule.this.serializeEmpty(i2, n, p));
                            return;
                        }
                        View c2 = linearLayoutManager.c(i2);
                        if (c2 != null) {
                            promise.resolve(ReactRecyclerViewModule.this.serializeEventData(i2, c2.getLeft(), c2.getTop(), c2.getWidth(), c2.getHeight(), n, p));
                            return;
                        }
                        promise.resolve(ReactRecyclerViewModule.this.serializeEmpty(i2, n, p));
                        return;
                    }
                    promise.reject("NOT_FOUND", "View with reactTag not found.");
                } catch (JSONException unused) {
                    promise.reject("NOT_FOUND", "View with reactTag not found.");
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public String serializeEventData(int i, int i2, int i3, int i4, int i5, int i6, int i7) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("rowIndex", i);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("x", (double) PixelUtil.toDIPFromPixel((float) i2));
        jSONObject2.put("y", (double) PixelUtil.toDIPFromPixel((float) i3));
        jSONObject2.put("width", (double) PixelUtil.toDIPFromPixel((float) i4));
        jSONObject2.put("height", (double) PixelUtil.toDIPFromPixel((float) i5));
        jSONObject.put("layout", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("firstVisible", i6);
        jSONObject3.put("lastPos", i7);
        jSONObject.put("extra", jSONObject3);
        return jSONObject.toString();
    }

    /* access modifiers changed from: private */
    public String serializeEmpty(int i, int i2, int i3) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("rowIndex", i);
        jSONObject.put("layout", new JSONObject());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("firstVisible", i2);
        jSONObject2.put("lastPos", i3);
        jSONObject.put("extra", jSONObject2);
        return jSONObject.toString();
    }
}
