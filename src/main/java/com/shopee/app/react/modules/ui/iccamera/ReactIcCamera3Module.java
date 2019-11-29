package com.shopee.app.react.modules.ui.iccamera;

import android.content.Intent;
import android.text.TextUtils;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.google.a.o;
import com.shopee.app.data.viewmodel.camera.IcCamera3Info;
import com.shopee.app.react.modules.base.ReactBaseActivityResultModule;
import com.shopee.app.react.modules.base.b;
import com.shopee.app.react.protocol.BridgeResult;
import com.shopee.app.ui.image.icimage.c;
import com.shopee.app.web.WebRegister;

@ReactModule(name = "ICCamera")
public class ReactIcCamera3Module extends ReactBaseActivityResultModule<b> {
    protected static final String NAME = "ICCamera";
    private static final int STATUS_CODE_CANCEL = 2;
    private static final int STATUS_CODE_ERROR = 1;
    /* access modifiers changed from: private */
    public c mIcImageHandler = c.e(new c.a() {
        public void onResult(String str, int i) {
            if (ReactIcCamera3Module.this.mPromise == null) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                o oVar = new o();
                oVar.a("imageUri", str);
                ReactIcCamera3Module.this.mPromise.resolve(BridgeResult.Companion.success(oVar).toString());
                return;
            }
            ReactIcCamera3Module.this.onError(2, "User Cancel");
        }
    });
    /* access modifiers changed from: private */
    public Promise mPromise;

    public String getName() {
        return NAME;
    }

    public void onNewIntent(Intent intent) {
    }

    public ReactIcCamera3Module(ReactApplicationContext reactApplicationContext) {
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
    public void open(final int i, final String str, final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (ReactIcCamera3Module.this.isMatchingReactTag(i)) {
                    Promise unused = ReactIcCamera3Module.this.mPromise = promise;
                    ReactIcCamera3Module.this.mIcImageHandler.a((IcCamera3Info) WebRegister.GSON.a(str, IcCamera3Info.class));
                    ReactIcCamera3Module.this.mIcImageHandler.a(ReactIcCamera3Module.this.getCurrentActivity());
                    return;
                }
                ReactIcCamera3Module.this.onError(1, "");
            }
        });
    }

    /* access modifiers changed from: private */
    public void onError(int i, String str) {
        this.mPromise.resolve(BridgeResult.Companion.fail(i, str).toString());
    }
}
