package com.facebook.react.modules.systeminfo;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.os.Build;
import android.provider.Settings;
import com.facebook.internal.ServerProtocol;
import com.facebook.react.R;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.livequiz.data.bean.LiveParams;
import com.tencent.cos.xml.BuildConfig;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"HardwareIds"})
@ReactModule(name = "PlatformConstants")
public class AndroidInfoModule extends ReactContextBaseJavaModule {
    private static final String IS_TESTING = "IS_TESTING";
    public static final String NAME = "PlatformConstants";

    public String getName() {
        return NAME;
    }

    public AndroidInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private String uiMode() {
        int currentModeType = ((UiModeManager) getReactApplicationContext().getSystemService("uimode")).getCurrentModeType();
        if (currentModeType == 1) {
            return BuildConfig.FLAVOR;
        }
        if (currentModeType == 2) {
            return "desk";
        }
        if (currentModeType == 3) {
            return "car";
        }
        if (currentModeType != 4) {
            return currentModeType != 6 ? "unknown" : "watch";
        }
        return LiveParams.SYNC_TYPE_TV;
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("Version", Integer.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("Release", Build.VERSION.RELEASE);
        hashMap.put("Serial", Build.SERIAL);
        hashMap.put("Fingerprint", Build.FINGERPRINT);
        hashMap.put("Model", Build.MODEL);
        hashMap.put("isTesting", Boolean.valueOf(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(System.getProperty(IS_TESTING)) || isRunningScreenshotTest().booleanValue()));
        hashMap.put("reactNativeVersion", ReactNativeVersion.VERSION);
        hashMap.put("uiMode", uiMode());
        return hashMap;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public String getAndroidID() {
        return Settings.Secure.getString(getReactApplicationContext().getContentResolver(), "android_id");
    }

    private Boolean isRunningScreenshotTest() {
        try {
            Class.forName("androidx.test.rule.ActivityTestRule");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private String getServerHost() {
        return AndroidInfoHelpers.getServerHost(Integer.valueOf(getReactApplicationContext().getApplicationContext().getResources().getInteger(R.integer.react_native_dev_server_port)));
    }
}
