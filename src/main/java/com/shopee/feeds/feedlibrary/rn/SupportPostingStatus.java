package com.shopee.feeds.feedlibrary.rn;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.navigator.a;
import com.shopee.navigator.b;
import com.shopee.react.sdk.bridge.modules.app.post.FeedPostingStatusModule;
import com.shopee.react.sdk.bridge.protocol.feed.PostStatusRequest;

@ReactModule(name = "SupportPostingStatus")
public class SupportPostingStatus extends ReactContextBaseJavaModule {
    public static final String NAME = "SupportPostingStatus";

    public String getName() {
        return NAME;
    }

    public SupportPostingStatus(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public void isSupportPostingStatus(String str, Promise promise) {
        if (str == null) {
            try {
                str = a.f30104c;
            } catch (Exception e2) {
                com.garena.b.a.a.b(FeedPostingStatusModule.NAME, (Throwable) e2);
                return;
            }
        }
        PostStatusRequest postStatusRequest = (PostStatusRequest) b.fromJson(str, PostStatusRequest.class);
    }
}
