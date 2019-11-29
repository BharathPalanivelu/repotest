package com.shopee.app.ui.product.add;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.garena.android.appkit.d.a;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.photo.PhotoProxyActivity_;
import com.shopee.app.ui.product.add.wholesale.WholesaleTierModel;
import com.shopee.app.ui.product.attributes.u;
import com.shopee.app.ui.product.twitter.e;
import com.shopee.app.util.x;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.notification.UpdateItemShippingMessage;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class b extends com.shopee.app.ui.a.b implements x<d> {

    /* renamed from: a  reason: collision with root package name */
    long f24006a;

    /* renamed from: b  reason: collision with root package name */
    int f24007b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f24008c;

    /* renamed from: d  reason: collision with root package name */
    e f24009d;

    /* renamed from: e  reason: collision with root package name */
    SettingConfigStore f24010e;

    /* renamed from: f  reason: collision with root package name */
    private d f24011f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public k f24012g;
    private CallbackManager h;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f24012g = l.a(this, this.f24006a);
        a((View) this.f24012g);
        this.h = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(this.h, new FacebookCallback<LoginResult>() {
            /* renamed from: a */
            public void onSuccess(LoginResult loginResult) {
                b.this.f24012g.p();
            }

            public void onCancel() {
                a.e("user cancel", new Object[0]);
            }

            public void onError(FacebookException facebookException) {
                b.this.f24012g.a(com.garena.android.appkit.tools.b.e(R.string.sp_label_facebook_login_error));
            }
        });
        if (bundle == null) {
            if (this.f24006a == 0) {
                PhotoProxyActivity_.a a2 = PhotoProxyActivity_.a(this);
                int i = this.f24007b;
                if (i == 0) {
                    a2.a(true);
                } else if (i == 1) {
                    a2.d(true);
                } else if (i == 2) {
                    a2.e(true);
                }
                a2.c(true).h(true).g(true).h(1).i((int) R.string.sp_camera_hint).a(4);
            }
        } else if (bundle.containsKey("rootActivity")) {
            this.f24008c = bundle.getInt("rootActivity");
        }
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        if (this.f24006a == 0) {
            aVar.f(1).b((int) R.string.sp_label_add_product).e(0).a("PRODUCT_SUBMIT_PRODUCT", (int) R.drawable.com_garena_shopee_ic_done);
        } else {
            aVar.f(1).b((int) R.string.sp_edit_product).e(0).a("PRODUCT_SUBMIT_PRODUCT", (int) R.drawable.com_garena_shopee_ic_done);
        }
    }

    /* access modifiers changed from: protected */
    public void a(com.shopee.app.ui.common.a aVar) {
        aVar.a(hashCode(), this.f24012g);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        com.shopee.app.c.a.a((Context) this);
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f24011f = o.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f24011f.a(this);
    }

    /* renamed from: c */
    public d b() {
        return this.f24011f;
    }

    /* access modifiers changed from: package-private */
    public void a(int i, Intent intent) {
        if (intent == null) {
            finish();
            return;
        }
        this.f24008c = intent.getIntExtra("add_product_harbour_activity", -1);
        if (i == -1) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("add_product_image_uri_list");
            if (stringArrayListExtra != null) {
                this.f24012g.b((List<String>) stringArrayListExtra);
            }
            if (intent.hasExtra("INSTAGRAM_INFO")) {
                String stringExtra = intent.getStringExtra("INSTAGRAM_INFO");
                if (!TextUtils.isEmpty(stringExtra)) {
                    this.f24012g.setInstagramInfo(stringExtra);
                }
            }
            ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("add_product_video_uri_list");
            String stringExtra2 = intent.getStringExtra("add_product_trim_video_data");
            if (stringArrayListExtra2 != null) {
                this.f24012g.a((List<String>) stringArrayListExtra2, stringExtra2);
            }
        } else if (this.f24008c == 1) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("rootActivity", this.f24008c);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: package-private */
    public void b(int i, Intent intent) {
        if (i == -1) {
            this.f24012g.x();
            this.f24009d.a(intent);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i, Intent intent) {
        if (i == -1) {
            String stringExtra = intent.getStringExtra("pageInfo");
            this.f24012g.setPageInfo((t) WebRegister.GSON.a(stringExtra, t.class));
        }
    }

    /* access modifiers changed from: package-private */
    public void d(int i, Intent intent) {
        if (i == -1 && intent.hasExtra("updateItemShippingMessage")) {
            this.f24012g.a((UpdateItemShippingMessage) WebRegister.GSON.a(intent.getStringExtra("updateItemShippingMessage"), UpdateItemShippingMessage.class));
        }
    }

    /* access modifiers changed from: package-private */
    public void e(int i, Intent intent) {
        if (i == -1) {
            int intExtra = intent.getIntExtra("return_type", 1);
            this.f24012g.a((u) intent.getSerializableExtra(AbTestingModule.KEY_RESULT), intExtra);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode() && i2 == -1) {
            this.h.onActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: package-private */
    public void f(int i, Intent intent) {
        if (i == -1) {
            this.f24012g.c((List<WholesaleTierModel>) intent.getParcelableArrayListExtra("EXTRA_WHOLESALE_TIERS"));
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i) {
        if (i == -1) {
            this.f24012g.H();
            return;
        }
        this.f24012g.H();
        this.f24012g.I();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:2|3|4|5|(2:9|10)|11|12|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0035 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r3, java.lang.String r4) {
        /*
            r2 = this;
            r0 = -1
            if (r3 != r0) goto L_0x0051
            com.google.a.f r3 = com.shopee.app.web.WebRegister.GSON     // Catch:{ Exception -> 0x004d }
            java.lang.Class<com.shopee.app.react.protocol.PopData> r0 = com.shopee.app.react.protocol.PopData.class
            java.lang.Object r3 = r3.a((java.lang.String) r4, r0)     // Catch:{ Exception -> 0x004d }
            com.shopee.app.react.protocol.PopData r3 = (com.shopee.app.react.protocol.PopData) r3     // Catch:{ Exception -> 0x004d }
            com.google.a.f r4 = com.shopee.app.web.WebRegister.GSON     // Catch:{ Exception -> 0x0035 }
            java.lang.String r0 = r3.getData()     // Catch:{ Exception -> 0x0035 }
            java.lang.Class<com.shopee.app.data.viewmodel.EditCategoryData> r1 = com.shopee.app.data.viewmodel.EditCategoryData.class
            java.lang.Object r4 = r4.a((java.lang.String) r0, r1)     // Catch:{ Exception -> 0x0035 }
            com.shopee.app.data.viewmodel.EditCategoryData r4 = (com.shopee.app.data.viewmodel.EditCategoryData) r4     // Catch:{ Exception -> 0x0035 }
            java.lang.String r0 = "ADD_PRODUCT_CATEGORY"
            java.lang.String r1 = r4.page     // Catch:{ Exception -> 0x0035 }
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x0035 }
            if (r0 == 0) goto L_0x0035
            java.util.List<com.shopee.app.data.viewmodel.EditCategoryData$EditCategory> r0 = r4.selectedPath     // Catch:{ Exception -> 0x0035 }
            boolean r0 = com.shopee.app.util.af.a(r0)     // Catch:{ Exception -> 0x0035 }
            if (r0 != 0) goto L_0x0035
            com.shopee.app.ui.product.add.k r0 = r2.f24012g     // Catch:{ Exception -> 0x0035 }
            java.util.List<com.shopee.app.data.viewmodel.EditCategoryData$EditCategory> r4 = r4.selectedPath     // Catch:{ Exception -> 0x0035 }
            r0.setCategoryRN(r4)     // Catch:{ Exception -> 0x0035 }
            return
        L_0x0035:
            com.google.a.f r4 = com.shopee.app.web.WebRegister.GSON     // Catch:{ Exception -> 0x0051 }
            java.lang.String r3 = r3.getData()     // Catch:{ Exception -> 0x0051 }
            java.lang.Class<com.shopee.app.data.viewmodel.VariationData> r0 = com.shopee.app.data.viewmodel.VariationData.class
            java.lang.Object r3 = r4.a((java.lang.String) r3, r0)     // Catch:{ Exception -> 0x0051 }
            com.shopee.app.data.viewmodel.VariationData r3 = (com.shopee.app.data.viewmodel.VariationData) r3     // Catch:{ Exception -> 0x0051 }
            com.shopee.app.ui.product.add.k r4 = r2.f24012g     // Catch:{ Exception -> 0x0051 }
            java.util.List<com.shopee.app.data.viewmodel.Variation> r0 = r3.variations     // Catch:{ Exception -> 0x0051 }
            java.util.List<com.shopee.app.data.viewmodel.ModelDetail> r3 = r3.models     // Catch:{ Exception -> 0x0051 }
            r4.a((java.util.List<com.shopee.app.data.viewmodel.Variation>) r0, (java.util.List<com.shopee.app.data.viewmodel.ModelDetail>) r3)     // Catch:{ Exception -> 0x0051 }
            goto L_0x0051
        L_0x004d:
            r3 = move-exception
            com.garena.android.appkit.d.a.a(r3)
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.product.add.b.a(int, java.lang.String):void");
    }

    public void onBackPressed() {
        com.shopee.app.c.a.a((Context) this);
        this.f24012g.y();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f24012g = null;
    }
}
