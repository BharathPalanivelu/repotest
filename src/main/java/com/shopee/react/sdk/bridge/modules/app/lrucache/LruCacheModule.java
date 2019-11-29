package com.shopee.react.sdk.bridge.modules.app.lrucache;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.react.sdk.a.a;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.CacheKeyParams;
import com.shopee.react.sdk.bridge.protocol.CachePutParams;

@ReactModule(name = "LRUCache")
public class LruCacheModule extends ReactContextBaseJavaModule {
    public static final String NAME = "LRUCache";
    private final a mImplementation;

    public String getName() {
        return NAME;
    }

    public LruCacheModule(ReactApplicationContext reactApplicationContext, a aVar) {
        super(reactApplicationContext);
        this.mImplementation = aVar;
    }

    @ReactMethod
    public void put(String str, Promise promise) {
        CachePutParams cachePutParams = (CachePutParams) a.f30143a.a(str, CachePutParams.class);
        this.mImplementation.a(cachePutParams.getKey(), cachePutParams.getData(), new c(promise));
    }

    @ReactMethod
    public void get(String str, Promise promise) {
        this.mImplementation.a(((CacheKeyParams) a.f30143a.a(str, CacheKeyParams.class)).getKey(), new c(promise));
    }

    @ReactMethod
    public void remove(String str, Promise promise) {
        this.mImplementation.a(((CacheKeyParams) a.f30143a.a(str, CacheKeyParams.class)).getKey(), new c(promise));
    }

    @ReactMethod
    public void removeAll(String str, Promise promise) {
        this.mImplementation.a(new c(promise));
    }
}
