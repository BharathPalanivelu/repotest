package com.airpay.paysdk.base.c;

import android.text.TextUtils;
import com.airpay.paysdk.base.proto.SdkLoginForShopeeReplyProto;
import com.airpay.paysdk.common.net.a.a.c;
import com.airpay.paysdk.common.net.a.a.d;

public class a implements d {
    public void a(final c cVar) {
        com.airpay.paysdk.common.b.a.a("koneng----------onConnected------", new Object[0]);
        String b2 = com.airpay.paysdk.base.b.d.a().b();
        if (!TextUtils.isEmpty(b2)) {
            com.airpay.paysdk.core.a.a().a(b2, (com.airpay.paysdk.common.net.a.a.a<SdkLoginForShopeeReplyProto>) new com.airpay.paysdk.common.net.a.a.a<SdkLoginForShopeeReplyProto>() {
                public void a(SdkLoginForShopeeReplyProto sdkLoginForShopeeReplyProto) {
                    com.airpay.paysdk.common.b.a.a("koneng----login----success------", new Object[0]);
                    cVar.a();
                }

                public void a(int i, String str) {
                    com.airpay.paysdk.common.b.a.a("koneng----login----error==------" + str, new Object[0]);
                    cVar.a(i, str);
                }
            });
        }
    }
}
