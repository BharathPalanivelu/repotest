package com.shopee.app.react.modules.ui.airpay;

import android.app.Activity;
import com.airpay.paysdk.core.bean.PayResult;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.share.internal.ShareConstants;
import com.shopee.app.react.protocol.PayWithPaymentInfoMessage;
import com.shopee.app.react.protocol.PayWithQRCodeMessage;
import com.shopee.app.react.util.e;
import com.shopee.app.web.WebRegister;
import d.d.b.j;

@ReactModule(name = "GAAPAPaymentKit")
public final class ReactAirPayModule extends ReactContextBaseJavaModule {
    public static final b Companion = new b((g) null);
    public static final int ERROR_CODE_CANCEL = 1;
    public static final int ERROR_CODE_UNKNOWN = -1;
    public static final String ERROR_NO_PAY_RESULT = "No PayResult";
    public static final String ERROR_REACT_TAG_NOT_MATCH = "React tag not match";
    public static final String NAME = "GAAPAPaymentKit";

    public String getName() {
        return NAME;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReactAirPayModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        j.b(reactApplicationContext, "context");
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }
    }

    @ReactMethod
    public final void startPayWithPaymentInfo(int i, String str, Promise promise) {
        j.b(str, "data");
        j.b(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (!e.a(i, getCurrentActivity())) {
            a.b(promise, ERROR_REACT_TAG_NOT_MATCH);
        } else {
            openScanToPay(str, promise);
        }
    }

    @ReactMethod
    public final void startPayWithQRCode(int i, String str, Promise promise) {
        j.b(str, "data");
        j.b(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (!e.a(i, getCurrentActivity())) {
            a.b(promise, ERROR_REACT_TAG_NOT_MATCH);
        } else {
            openQRCode(str, promise);
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReactAirPayModule f18819a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f18820b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Promise f18821c;

        d(ReactAirPayModule reactAirPayModule, String str, Promise promise) {
            this.f18819a = reactAirPayModule;
            this.f18820b = str;
            this.f18821c = promise;
        }

        public final void run() {
            Activity access$getCurrentActivity = this.f18819a.getCurrentActivity();
            if (access$getCurrentActivity != null) {
                try {
                    PayWithPaymentInfoMessage payWithPaymentInfoMessage = (PayWithPaymentInfoMessage) WebRegister.GSON.a(this.f18820b, PayWithPaymentInfoMessage.class);
                    com.shopee.app.util.b.a aVar = com.shopee.app.util.b.a.f26227a;
                    j.a((Object) access$getCurrentActivity, "activity");
                    j.a((Object) payWithPaymentInfoMessage, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                    aVar.a(access$getCurrentActivity, payWithPaymentInfoMessage, new a(payWithPaymentInfoMessage.getSessionKey(), this.f18821c));
                } catch (Exception e2) {
                    Promise promise = this.f18821c;
                    String message = e2.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    a.b(promise, message);
                    com.garena.android.appkit.d.a.a(e2);
                }
            }
        }
    }

    private final void openScanToPay(String str, Promise promise) {
        UiThreadUtil.runOnUiThread(new d(this, str, promise));
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReactAirPayModule f18816a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f18817b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Promise f18818c;

        c(ReactAirPayModule reactAirPayModule, String str, Promise promise) {
            this.f18816a = reactAirPayModule;
            this.f18817b = str;
            this.f18818c = promise;
        }

        public final void run() {
            Activity access$getCurrentActivity = this.f18816a.getCurrentActivity();
            if (access$getCurrentActivity != null) {
                try {
                    com.shopee.app.util.b.a aVar = com.shopee.app.util.b.a.f26227a;
                    j.a((Object) access$getCurrentActivity, "activity");
                    aVar.a(access$getCurrentActivity, new a(((PayWithQRCodeMessage) WebRegister.GSON.a(this.f18817b, PayWithQRCodeMessage.class)).getSessionKey(), this.f18818c));
                } catch (Exception e2) {
                    Promise promise = this.f18818c;
                    String message = e2.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    a.b(promise, message);
                    com.garena.android.appkit.d.a.a(e2);
                }
            }
        }
    }

    private final void openQRCode(String str, Promise promise) {
        UiThreadUtil.runOnUiThread(new c(this, str, promise));
    }

    private static final class a extends com.airpay.paysdk.b {

        /* renamed from: a  reason: collision with root package name */
        private final String f18814a;

        /* renamed from: b  reason: collision with root package name */
        private final Promise f18815b;

        public a(String str, Promise promise) {
            j.b(str, "sessionKey");
            j.b(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
            this.f18814a = str;
            this.f18815b = promise;
        }

        public void onResponse(PayResult payResult) {
            a.b(this.f18815b, payResult);
        }

        public String a() {
            return this.f18814a;
        }
    }
}
