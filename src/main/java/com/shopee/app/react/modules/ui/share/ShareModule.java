package com.shopee.app.react.modules.ui.share;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.google.a.o;
import com.shopee.app.react.c;
import com.shopee.app.react.modules.base.ReactBaseLifecycleModule;
import com.shopee.app.ui.sharing.base.a;
import com.shopee.app.ui.sharing.base.b;
import com.shopee.app.ui.sharing.d;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.SharingDataMessage;
import com.shopee.app.web.protocol.ShowSharingPanelMessage;

@ReactModule(name = "GAShare")
public class ShareModule extends ReactBaseLifecycleModule<a> {
    protected static final String NAME = "GAShare";
    /* access modifiers changed from: private */
    public a mShare;
    /* access modifiers changed from: private */
    public Promise mShareDataPromise;
    /* access modifiers changed from: private */
    public b mShareListener = new b() {
        public void onPreProcessingData() {
        }

        public void onResult(com.shopee.app.ui.sharing.base.data.a aVar) {
            o oVar = new o();
            oVar.a("errorCode", (Number) Integer.valueOf(aVar.a()));
            oVar.a("errorMessage", aVar.b());
            if (ShareModule.this.mShareDataPromise != null) {
                ShareModule.this.mShareDataPromise.resolve(oVar.toString());
            }
        }
    };

    public String getName() {
        return "GAShare";
    }

    public ShareModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public a initHelper(c cVar) {
        return new a(cVar);
    }

    @ReactMethod
    public void shareItem(final int i, final String str, final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (ShareModule.this.isMatchingReactTag(i)) {
                    ((a) ShareModule.this.getHelper()).a(ShareModule.this.getCurrentActivity(), str, promise);
                }
            }
        });
    }

    @ReactMethod
    public void showSharingPanel(final int i, final String str, final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (ShareModule.this.isMatchingReactTag(i) && (ShareModule.this.getCurrentActivity() != null)) {
                    ShowSharingPanelMessage showSharingPanelMessage = (ShowSharingPanelMessage) WebRegister.GSON.a(str, ShowSharingPanelMessage.class);
                    new com.shopee.app.ui.sharing.c(ShareModule.this.getCurrentActivity()).a(showSharingPanelMessage.getTitle(), showSharingPanelMessage.getSubTitle(), showSharingPanelMessage.getAutoDismissForUnavailablePlatform(), showSharingPanelMessage.getSharingAppIDsTop(), showSharingPanelMessage.getSharingAppIDsBottom(), new d() {
                        public void onSelectApp(String str, boolean z) {
                            o oVar = new o();
                            oVar.a("status", (Number) 1);
                            oVar.a("sharingAppID", str);
                            oVar.a("isAppAvailable", Boolean.valueOf(z));
                            promise.resolve(oVar.toString());
                        }

                        public void onDismiss() {
                            ShareModule.this.rejectPromise(promise);
                        }
                    });
                    return;
                }
                ShareModule.this.rejectPromise(promise);
            }
        });
    }

    @ReactMethod
    public void shareData(final int i, final String str, final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (ShareModule.this.isMatchingReactTag(i) && (ShareModule.this.getCurrentActivity() != null)) {
                    SharingDataMessage sharingDataMessage = (SharingDataMessage) WebRegister.GSON.a(str, SharingDataMessage.class);
                    if (ShareModule.this.mShare != null) {
                        ShareModule.this.mShare.c();
                    }
                    String lVar = sharingDataMessage.getSharingData() != null ? sharingDataMessage.getSharingData().toString() : "";
                    Promise unused = ShareModule.this.mShareDataPromise = promise;
                    ShareModule shareModule = ShareModule.this;
                    a unused2 = shareModule.mShare = com.shopee.app.ui.sharing.b.a(shareModule.getCurrentActivity(), sharingDataMessage.getSharingAppID(), lVar, ShareModule.this.mShareListener);
                    return;
                }
                ShareModule.this.rejectPromise(promise);
            }
        });
    }

    /* access modifiers changed from: private */
    public void rejectPromise(Promise promise) {
        o oVar = new o();
        oVar.a("status", (Number) 0);
        promise.resolve(oVar.toString());
    }
}
