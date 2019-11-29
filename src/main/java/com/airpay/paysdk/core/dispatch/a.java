package com.airpay.paysdk.core.dispatch;

import android.content.Intent;
import android.os.Bundle;
import com.airpay.paysdk.b;
import com.airpay.paysdk.base.d.o;
import com.airpay.paysdk.base.interfaces.IResultCallback;
import com.airpay.paysdk.base.ui.a.a;
import com.airpay.paysdk.core.bean.Param;
import com.airpay.paysdk.qrcode.ui.PaymentCodeActivity;

class a extends b {
    a() {
    }

    /* access modifiers changed from: package-private */
    public void a(com.airpay.paysdk.base.ui.a.a aVar, b bVar, Param param) {
        Intent intent = new Intent(aVar, PaymentCodeActivity.class);
        Bundle bundle = new Bundle();
        o.a(bundle, bVar);
        bundle.putParcelable("param", param);
        intent.putExtras(bundle);
        aVar.a(intent, 1001, (IResultCallback) new IResultCallback() {
            public final void run(int i, Intent intent) {
                a.a(a.this, i, intent);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(com.airpay.paysdk.base.ui.a.a aVar, int i, Intent intent) {
        if (aVar != null && !aVar.isFinishing()) {
            aVar.finish();
            aVar.overridePendingTransition(0, 0);
            com.airpay.paysdk.a.a().d();
        }
    }
}
