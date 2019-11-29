package com.airpay.paysdk.core.dispatch;

import android.content.Intent;
import android.text.TextUtils;
import com.airpay.paysdk.b;
import com.airpay.paysdk.base.b.d;
import com.airpay.paysdk.base.d.o;
import com.airpay.paysdk.base.proto.SdkLoginForShopeeReplyProto;
import com.airpay.paysdk.base.ui.a.a;
import com.airpay.paysdk.c;
import com.airpay.paysdk.common.c.b;
import com.airpay.paysdk.core.bean.Param;
import com.airpay.paysdk.core.bean.PayResult;

public class DispatchActivity extends a {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b f4130b;

    /* access modifiers changed from: protected */
    public int a() {
        return c.h.activity_dispatch_layout;
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.f4130b = o.a(getIntent().getExtras());
        b(false);
        a(false);
        com.airpay.paysdk.base.different.a.a().b(((Param) getIntent().getParcelableExtra("param")).a());
        com.airpay.paysdk.common.net.b.c.a().b(this);
        com.airpay.paysdk.common.c.b.a(b.c.CACHE).execute(new Runnable() {
            public final void run() {
                DispatchActivity.this.h();
            }
        });
    }

    /* access modifiers changed from: private */
    public void h() {
        if (this.f4130b == null) {
            com.airpay.paysdk.common.b.a.a("pay call is null,close sdk", new Object[0]);
            j();
            return;
        }
        d.a().a(this.f4130b);
        com.airpay.paysdk.core.a.a().a(this.f4130b.a(), (com.airpay.paysdk.common.net.a.a.a<SdkLoginForShopeeReplyProto>) new com.airpay.paysdk.common.net.a.a.a<SdkLoginForShopeeReplyProto>() {
            public void a(SdkLoginForShopeeReplyProto sdkLoginForShopeeReplyProto) {
                com.airpay.paysdk.common.b.a.c("auth check success date = " + sdkLoginForShopeeReplyProto, new Object[0]);
                com.airpay.paysdk.common.net.tcp.a.a.a().a(8468, 1);
                com.airpay.paysdk.base.b.b.a().b();
                com.airpay.paysdk.qrcode.a.a().b();
                DispatchActivity.this.i();
            }

            public void a(int i, String str) {
                com.airpay.paysdk.common.b.a.b("auth check failed code = " + i + ", error = " + str, new Object[0]);
                DispatchActivity.this.f4130b.onResponse(new PayResult(-1, i, str));
                DispatchActivity.this.j();
            }
        });
    }

    /* access modifiers changed from: private */
    public void i() {
        Intent intent = getIntent();
        String action = intent.getAction();
        if (!TextUtils.isEmpty(action)) {
            b.a(action).a((a) this).a(intent).a();
        } else {
            j();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        c();
    }

    /* access modifiers changed from: private */
    public void j() {
        com.airpay.paysdk.a.a().d();
        finish();
        overridePendingTransition(0, 0);
    }
}
