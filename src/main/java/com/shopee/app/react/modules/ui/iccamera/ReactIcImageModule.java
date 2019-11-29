package com.shopee.app.react.modules.ui.iccamera;

import android.content.Intent;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.google.a.o;
import com.shopee.app.react.modules.base.ReactBaseActivityResultModule;
import com.shopee.app.react.modules.base.b;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import com.shopee.app.ui.image.icimage.c;
import com.shopee.app.web.WebRegister;

@ReactModule(name = "openICCamera")
public class ReactIcImageModule extends ReactBaseActivityResultModule<b> {
    /* access modifiers changed from: private */
    public c mIcImageHandler = c.c(this.mImageResultListener);
    private c.a mImageResultListener = new c.a() {
        public void onResult(String str, int i) {
            if (ReactIcImageModule.this.mPromise != null) {
                o oVar = new o();
                oVar.a(AbTestingModule.KEY_RESULT, str);
                ReactIcImageModule.this.mPromise.resolve(oVar.toString());
            }
        }
    };
    /* access modifiers changed from: private */
    public Promise mPromise;

    public String getName() {
        return "openICCamera";
    }

    public void onNewIntent(Intent intent) {
    }

    public ReactIcImageModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mIcImageHandler.a(getCurrentActivity(), i, i2, intent);
    }

    public b initHelper(com.shopee.app.react.c cVar) {
        return new b();
    }

    @ReactMethod
    public void openIcCamera(final int i, final String str, final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (ReactIcImageModule.this.isMatchingReactTag(i)) {
                    o oVar = (o) WebRegister.GSON.a(str, o.class);
                    Promise unused = ReactIcImageModule.this.mPromise = promise;
                    ReactIcImageModule.this.mIcImageHandler.a(ReactIcImageModule.this.getCurrentActivity());
                    return;
                }
                o oVar2 = new o();
                oVar2.a(AbTestingModule.KEY_RESULT, "");
                promise.resolve(oVar2.toString());
            }
        });
    }
}
