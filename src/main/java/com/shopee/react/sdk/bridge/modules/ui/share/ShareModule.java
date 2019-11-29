package com.shopee.react.sdk.bridge.modules.ui.share;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.react.sdk.a.a;
import com.shopee.react.sdk.bridge.modules.base.ReactBaseLifecycleModule;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.SharePanelResult;
import com.shopee.react.sdk.bridge.protocol.ShareResult;
import com.shopee.react.sdk.bridge.protocol.SharingDataMessage;
import com.shopee.react.sdk.bridge.protocol.ShowSharingPanelMessage;

@ReactModule(name = "GAShare")
public abstract class ShareModule extends ReactBaseLifecycleModule<a> {
    public static final String NAME = "GAShare";

    public String getName() {
        return NAME;
    }

    public ShareModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void showSharingPanel(final int i, final String str, final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (ShareModule.this.isMatchingReactTag(i) && (ShareModule.this.getCurrentActivity() != null)) {
                    ((a) ShareModule.this.getHelper()).a(ShareModule.this.getCurrentActivity(), (ShowSharingPanelMessage) a.f30143a.a(str, ShowSharingPanelMessage.class), (c<ShareResult>) new c(promise));
                } else {
                    promise.resolve(new ShareResult(-1, ""));
                }
            }
        });
    }

    @ReactMethod
    public void shareData(final int i, final String str, final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (ShareModule.this.isMatchingReactTag(i) && (ShareModule.this.getCurrentActivity() != null)) {
                    ((a) ShareModule.this.getHelper()).a(ShareModule.this.getCurrentActivity(), (SharingDataMessage) a.f30143a.a(str, SharingDataMessage.class), (c<SharePanelResult>) new c(promise));
                } else {
                    promise.resolve(new SharePanelResult(-1));
                }
            }
        });
    }
}
