package com.shopee.app.util.k;

import android.content.Intent;
import com.garena.android.appkit.tools.b;
import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.RetryConstraint;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ShareConfigStore;
import com.shopee.app.data.store.ba;
import com.shopee.app.data.store.be;
import com.shopee.app.pushnotification.NotificationDataBuilder;
import com.shopee.app.ui.home.me.v3.MeTabView3;
import com.shopee.app.ui.product.add.aj;
import com.shopee.app.ui.product.add.t;
import com.shopee.app.ui.product.twitter.e;
import com.shopee.app.util.bi;
import com.shopee.app.util.f.a;
import com.shopee.app.util.n;
import com.shopee.app.web.protocol.ShareMessage;
import com.shopee.id.R;
import com.shopee.protocol.action.ResponseCommon;

public class c extends Job {

    /* renamed from: a  reason: collision with root package name */
    transient n f26389a;

    /* renamed from: b  reason: collision with root package name */
    transient bi f26390b;

    /* renamed from: c  reason: collision with root package name */
    transient a f26391c;

    /* renamed from: d  reason: collision with root package name */
    transient ba f26392d;

    /* renamed from: e  reason: collision with root package name */
    transient be f26393e;

    /* renamed from: f  reason: collision with root package name */
    transient e f26394f;

    /* renamed from: g  reason: collision with root package name */
    transient h f26395g;
    transient UserInfo h;
    transient ShareConfigStore i;
    transient SettingConfigStore j;
    transient aj k;
    private g mProduct;

    public void onAdded() {
        com.garena.android.appkit.d.a.b("PostProductJob", this.f26389a);
    }

    public void onRun() throws Throwable {
        g a2 = this.f26395g.a();
        if (this.h.isLoggedIn() && a2 != null && a2.requestId.equals(this.mProduct.requestId)) {
            f fVar = new f(this.f26389a, this.f26391c, this.f26395g, this.f26393e, this.f26392d, this.j, this.mProduct);
            this.f26395g.a(this.mProduct, fVar);
            fVar.run();
            this.f26395g.a(this.mProduct);
            this.f26392d.b(this.mProduct);
            ResponseCommon a3 = fVar.a();
            if (a3 != null) {
                ShareMessage o = this.f26393e.o();
                t p = this.f26393e.p();
                if (p != null) {
                    try {
                        this.k.a(o.getUrl(), p);
                    } catch (Exception e2) {
                        com.garena.android.appkit.d.a.a(e2);
                    }
                }
                if (a3.errcode.intValue() == 0) {
                    a(b.e(R.string.sp_product_success_noti_message), com.shopee.app.pushnotification.c.a());
                    boolean z = this.mProduct.isShareToFB;
                    if (this.mProduct.isShareToTwitter) {
                        this.f26394f.a(o.getItemID(), a(this.mProduct.item.images), this.mProduct.item.name, this.mProduct.item.price, o.getShopName(), o.getUsername(), this.i);
                    }
                    if (MeTabView3.j()) {
                        this.f26390b.a("PRODUCT_UPLOAD_SUCCESS", new com.garena.android.appkit.b.a());
                    }
                }
                com.garena.android.appkit.d.a.b("PRODUCT_UPLOAD: " + this.mProduct.item.name + " DONE ", new Object[0]);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCancel() {
        g gVar = this.mProduct;
        gVar.status = 2;
        this.f26392d.a(gVar);
        a(this.mProduct.errorMessage, com.shopee.app.pushnotification.c.a(5));
        com.garena.android.appkit.d.a.b("PRODUCT_UPLOAD: " + this.mProduct.item.name + " CANCEL ", new Object[0]);
    }

    /* access modifiers changed from: protected */
    public RetryConstraint shouldReRunOnThrowable(Throwable th, int i2, int i3) {
        return RetryConstraint.CANCEL;
    }

    public String a(String str) {
        return str.split(",")[0];
    }

    private void a(String str, Intent intent) {
        if (!MeTabView3.j()) {
            com.shopee.app.pushnotification.c.a(NotificationDataBuilder.notificationData().withId(102).ofType(102).withLaunchIntent(intent).withMessage(str).shouldKeepSilent(false).shouldStack(false).withMetadata("").build());
        }
    }
}
