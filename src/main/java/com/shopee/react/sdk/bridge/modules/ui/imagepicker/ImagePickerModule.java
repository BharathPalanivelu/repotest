package com.shopee.react.sdk.bridge.modules.ui.imagepicker;

import android.content.Intent;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.react.sdk.a.a;
import com.shopee.react.sdk.bridge.modules.base.ReactBaseActivityResultModule;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.DataResponse;
import com.shopee.react.sdk.bridge.protocol.GetRecentImageRequest;
import com.shopee.react.sdk.bridge.protocol.GetRecentImageResponse;
import com.shopee.react.sdk.bridge.protocol.ImagePickerData;
import com.shopee.react.sdk.bridge.protocol.ImagePickerResult;

@ReactModule(name = "GAImagePicker")
public abstract class ImagePickerModule extends ReactBaseActivityResultModule<a> {
    public static final String NAME = "GAImagePicker";

    public String getName() {
        return NAME;
    }

    public void onNewIntent(Intent intent) {
    }

    public ImagePickerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void pickImage(final int i, final String str, final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (ImagePickerModule.this.isMatchingReactTag(i)) {
                    ((a) ImagePickerModule.this.getHelper()).a(ImagePickerModule.this.getCurrentActivity(), false, (ImagePickerData) a.f30143a.a(str, ImagePickerData.class), new c(promise));
                    return;
                }
                promise.resolve(new ImagePickerResult(0));
            }
        });
    }

    @ReactMethod
    public void takePhoto(final int i, final String str, final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (ImagePickerModule.this.isMatchingReactTag(i)) {
                    ((a) ImagePickerModule.this.getHelper()).a(ImagePickerModule.this.getCurrentActivity(), true, (ImagePickerData) a.f30143a.a(str, ImagePickerData.class), new c(promise));
                    return;
                }
                promise.resolve(new ImagePickerResult(0));
            }
        });
    }

    @ReactMethod
    public void getRecentImage(final String str, final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                ImagePickerModule imagePickerModule = ImagePickerModule.this;
                if (imagePickerModule.isMatchingReactTag(imagePickerModule.getReactTag())) {
                    ((a) ImagePickerModule.this.getHelper()).a(ImagePickerModule.this.getCurrentActivity(), (GetRecentImageRequest) a.f30143a.a(str, GetRecentImageRequest.class), (c<DataResponse<GetRecentImageResponse>>) new c(promise));
                    return;
                }
                promise.resolve(DataResponse.error());
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        ((a) getHelper()).a(i, i2, intent);
    }
}
