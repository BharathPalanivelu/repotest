package com.shopee.app.react.modules.ui.imagepicker;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.react.sdk.activity.a;

@ReactModule(name = "GAImagePicker")
public class ImagePickerModule extends com.shopee.react.sdk.bridge.modules.ui.imagepicker.ImagePickerModule {
    public ImagePickerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public a initHelper(a aVar) {
        return b.a(getCurrentActivity());
    }

    @ReactMethod
    public void pickImage(int i, String str, Promise promise) {
        super.pickImage(i, str, promise);
    }

    @ReactMethod
    public void takePhoto(int i, String str, Promise promise) {
        super.takePhoto(i, str, promise);
    }

    @ReactMethod
    public void getRecentImage(String str, Promise promise) {
        super.getRecentImage(str, promise);
    }
}
