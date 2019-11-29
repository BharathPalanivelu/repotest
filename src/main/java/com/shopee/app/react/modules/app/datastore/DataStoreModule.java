package com.shopee.app.react.modules.app.datastore;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.WebDataStore;

@ReactModule(name = "GADataStore")
public class DataStoreModule extends ReactContextBaseJavaModule {
    protected static final String NAME = "GADataStore";
    private WebDataStore mWebStore = ar.f().e().webStore();

    public String getName() {
        return NAME;
    }

    public DataStoreModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void save(String str, String str2, Promise promise) {
        this.mWebStore.put(str, str2, false);
        promise.resolve(ServiceLogger.PLACEHOLDER);
    }

    @ReactMethod
    public void savePersistent(String str, String str2, Promise promise) {
        this.mWebStore.put(str, str2, true);
        promise.resolve(ServiceLogger.PLACEHOLDER);
    }

    @ReactMethod
    public void load(String str, Promise promise) {
        String str2 = this.mWebStore.get(str);
        if (str2 != null) {
            promise.resolve(str2);
        } else {
            promise.reject((Throwable) new RuntimeException("Key Not Found"));
        }
    }
}
