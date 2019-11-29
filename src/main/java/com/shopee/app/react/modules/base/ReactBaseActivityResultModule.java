package com.shopee.app.react.modules.base;

import android.app.Activity;
import android.content.Intent;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.shopee.app.react.modules.base.b;
import com.shopee.app.react.util.a;

public abstract class ReactBaseActivityResultModule<T extends b> extends ReactBaseLifecycleModule<T> implements ActivityEventListener, LifecycleEventListener {
    private Intent mPassedData;
    private int mRequestCode = -1;
    private int mResultCode = -99;

    /* access modifiers changed from: protected */
    public abstract void onActivityResult(int i, int i2, Intent intent);

    public void onHostDestroy() {
    }

    public ReactBaseActivityResultModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addLifecycleEventListener(this);
        reactApplicationContext.addActivityEventListener(this);
    }

    public void onHostResume() {
        b helper = getHelper();
        if (helper instanceof a) {
            ((a) helper).b();
        }
        int i = this.mRequestCode;
        if (i != -1) {
            onActivityResult(i, this.mResultCode, this.mPassedData);
            this.mRequestCode = -1;
            this.mResultCode = -99;
            this.mPassedData = null;
        }
    }

    public void onHostPause() {
        b helper = getHelper();
        if (helper instanceof a) {
            ((a) helper).c();
        }
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        this.mResultCode = i2;
        this.mRequestCode = i;
        this.mPassedData = intent;
    }
}
