package com.shopee.react.sdk.bridge.modules.ui.mediabrowser;

import android.content.Intent;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.react.sdk.a.a;
import com.shopee.react.sdk.bridge.modules.base.ReactBaseActivityResultModule;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.MediaBrowserData;
import com.shopee.react.sdk.bridge.protocol.MediaBrowserResult;

@ReactModule(name = "GAMediaBrowser")
public abstract class MediaBrowserModule extends ReactBaseActivityResultModule<a> {
    public static final String NAME = "GAMediaBrowser";

    public String getName() {
        return NAME;
    }

    public MediaBrowserModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void startBrowsing(final int i, final String str, final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (MediaBrowserModule.this.isMatchingReactTag(i)) {
                    ((a) MediaBrowserModule.this.getHelper()).a(MediaBrowserModule.this.getCurrentActivity(), (MediaBrowserData) a.f30143a.a(str, MediaBrowserData.class), (c<MediaBrowserResult>) new c(promise));
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        ((a) getHelper()).a(i, i2, intent);
    }
}
