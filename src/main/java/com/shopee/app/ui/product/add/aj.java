package com.shopee.app.ui.product.add;

import android.os.Bundle;
import com.appsflyer.share.Constants;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.shopee.app.d.c.a;
import com.shopee.app.data.store.be;
import com.shopee.app.util.n;

public class aj extends a {

    /* renamed from: c  reason: collision with root package name */
    String f24000c;

    /* renamed from: d  reason: collision with root package name */
    t f24001d;

    /* renamed from: e  reason: collision with root package name */
    be f24002e;

    /* access modifiers changed from: protected */
    public String d() {
        return "PostToFacebookPageInteractor";
    }

    protected aj(n nVar, be beVar) {
        super(nVar);
        this.f24002e = beVar;
    }

    public void a(String str, t tVar) {
        this.f24000c = str;
        this.f24001d = tVar;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        Bundle bundle = new Bundle();
        bundle.putString("link", this.f24000c);
        bundle.putString("access_token", this.f24001d.b());
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        new GraphRequest(currentAccessToken, Constants.URL_PATH_DELIMITER + this.f24001d.c() + "/feed", bundle, HttpMethod.POST, new GraphRequest.Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                try {
                    if (aj.this.a(graphResponse)) {
                        aj.this.f24002e.a((t) null);
                    }
                } catch (Exception e2) {
                    com.garena.android.appkit.d.a.a(e2);
                }
            }
        }).executeAsync();
    }

    /* access modifiers changed from: private */
    public boolean a(GraphResponse graphResponse) {
        return graphResponse.getError() != null;
    }
}
