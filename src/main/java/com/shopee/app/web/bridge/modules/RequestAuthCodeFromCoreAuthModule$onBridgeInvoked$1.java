package com.shopee.app.web.bridge.modules;

import com.shopee.app.network.http.data.user.UserAccessTokenResponse;
import io.b.d.f;

final class RequestAuthCodeFromCoreAuthModule$onBridgeInvoked$1<T> implements f<UserAccessTokenResponse> {
    final /* synthetic */ RequestAuthCodeFromCoreAuthModule this$0;

    RequestAuthCodeFromCoreAuthModule$onBridgeInvoked$1(RequestAuthCodeFromCoreAuthModule requestAuthCodeFromCoreAuthModule) {
        this.this$0 = requestAuthCodeFromCoreAuthModule;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
        if (r4 != null) goto L_0x001d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void accept(com.shopee.app.network.http.data.user.UserAccessTokenResponse r4) {
        /*
            r3 = this;
            java.lang.String r0 = "response"
            d.d.b.j.a((java.lang.Object) r4, (java.lang.String) r0)
            boolean r0 = r4.isSuccess()
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0021
            com.shopee.app.web.bridge.modules.RequestAuthCodeFromCoreAuthModule r0 = r3.this$0
            com.shopee.app.network.http.data.user.AccessTokenData r4 = r4.getData()
            if (r4 == 0) goto L_0x001c
            java.lang.String r4 = r4.getAuthCode()
            if (r4 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r4 = r1
        L_0x001d:
            r0.resolvePromise(r4)
            goto L_0x0037
        L_0x0021:
            com.shopee.app.web.bridge.modules.RequestAuthCodeFromCoreAuthModule r0 = r3.this$0
            java.lang.Integer r2 = r4.errorCode
            if (r2 == 0) goto L_0x002c
            int r2 = r2.intValue()
            goto L_0x002e
        L_0x002c:
            r2 = -99
        L_0x002e:
            java.lang.String r4 = r4.errorMsg
            if (r4 == 0) goto L_0x0033
            goto L_0x0034
        L_0x0033:
            r4 = r1
        L_0x0034:
            r0.rejectPromise(r2, r4)
        L_0x0037:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.web.bridge.modules.RequestAuthCodeFromCoreAuthModule$onBridgeInvoked$1.accept(com.shopee.app.network.http.data.user.UserAccessTokenResponse):void");
    }
}
