package com.shopee.app.react.modules.ui.mediabrowser;

import android.content.Intent;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.react.sdk.activity.a;

@ReactModule(name = "GAMediaBrowser")
public class MediaBrowserModule extends com.shopee.react.sdk.bridge.modules.ui.mediabrowser.MediaBrowserModule {
    public void onNewIntent(Intent intent) {
    }

    public MediaBrowserModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public a initHelper(a aVar) {
        return new a();
    }

    @ReactMethod
    public void startBrowsing(int i, String str, Promise promise) {
        super.startBrowsing(i, str, promise);
    }
}
