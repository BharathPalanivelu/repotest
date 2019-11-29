package com.shopee.app.react.modules.app.fileloader;

import android.text.TextUtils;
import com.facebook.common.internal.Files;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.google.a.o;
import com.shopee.app.react.a.a;
import com.shopee.app.react.g;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;

@ReactModule(name = "GAFileLoader")
public class FileLoaderModule extends ReactContextBaseJavaModule {
    private static final int ERROR_INVALID_CONTENT_DATA = 4;
    private static final int ERROR_INVALID_FILE_PATH = 3;
    private static final int ERROR_INVALID_PARAMETERS = 2;
    private static final int ERROR_UNKNOWN = 1;
    protected static final String NAME = "GAFileLoader";
    a mConfig = g.a().e().h();

    public String getName() {
        return "GAFileLoader";
    }

    public FileLoaderModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void loadTextAsset(String str, Promise promise) throws Exception {
        if (TextUtils.isEmpty(str)) {
            rejectPromise(promise, 2, "Empty params");
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        String str2 = this.mConfig.d() + jSONObject.getString("filename");
        if (TextUtils.isEmpty(str2)) {
            rejectPromise(promise, 2, "Empty filename");
            return;
        }
        try {
            String str3 = new String(Files.toByteArray(new File(str2)), "UTF-8");
            o oVar = new o();
            oVar.a("status", (Number) 1);
            oVar.a("data", str3);
            promise.resolve(oVar.toString());
        } catch (IOException e2) {
            rejectPromise(promise, 3, e2.toString());
        } catch (Exception e3) {
            rejectPromise(promise, 1, e3.toString());
        }
    }

    private void rejectPromise(Promise promise, int i, String str) {
        o oVar = new o();
        oVar.a("status", (Number) 0);
        promise.resolve(oVar.toString());
    }
}
