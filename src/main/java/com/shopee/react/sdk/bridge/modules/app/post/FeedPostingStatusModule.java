package com.shopee.react.sdk.bridge.modules.app.post;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.navigator.a;
import com.shopee.navigator.b;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.feed.PostStatusRequest;

@ReactModule(name = "FeedPostingStatusModule")
public class FeedPostingStatusModule extends ReactContextBaseJavaModule {
    public static final String NAME = "FeedPostingStatusModule";
    private final a mImplementation;

    public String getName() {
        return NAME;
    }

    public FeedPostingStatusModule(ReactApplicationContext reactApplicationContext, a aVar) {
        super(reactApplicationContext);
        this.mImplementation = aVar;
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public void retryPost(String str, Promise promise) {
        if (str == null) {
            try {
                str = a.f30104c;
            } catch (Exception e2) {
                com.garena.b.a.a.b(NAME, (Throwable) e2);
                return;
            }
        }
        this.mImplementation.a((PostStatusRequest) b.fromJson(str, PostStatusRequest.class), new c(promise));
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public void deletePost(String str, Promise promise) {
        if (str == null) {
            try {
                str = a.f30104c;
            } catch (Exception e2) {
                com.garena.b.a.a.b(NAME, (Throwable) e2);
                return;
            }
        }
        this.mImplementation.b((PostStatusRequest) b.fromJson(str, PostStatusRequest.class), new c(promise));
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public void getPostList(String str, Promise promise) {
        try {
            this.mImplementation.a(new c(promise));
        } catch (Exception e2) {
            com.garena.b.a.a.b(NAME, (Throwable) e2);
        }
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public void completePost(String str, Promise promise) {
        if (str == null) {
            try {
                str = a.f30104c;
            } catch (Exception e2) {
                com.garena.b.a.a.b(NAME, (Throwable) e2);
                return;
            }
        }
        this.mImplementation.c((PostStatusRequest) b.fromJson(str, PostStatusRequest.class), new c(promise));
    }
}
