package com.shopee.app.react.modules.ui.search;

import android.app.Activity;
import com.facebook.internal.NativeProtocol;
import com.facebook.react.bridge.Promise;
import com.facebook.share.internal.ShareConstants;
import com.google.a.l;
import com.google.a.o;
import com.shopee.app.react.modules.base.b;
import com.shopee.app.ui.product.newsearch.SearchTabActivity_;
import com.shopee.app.util.ak;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.SearchConfig;

public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private Promise f18967a;

    /* access modifiers changed from: package-private */
    public void a(Activity activity, String str, Promise promise) {
        this.f18967a = promise;
        SearchConfig searchConfig = (SearchConfig) WebRegister.GSON.a(str, SearchConfig.class);
        ((SearchTabActivity_.a) SearchTabActivity_.a(activity).b(str).a(searchConfig.getSearchText()).b(searchConfig.getCurrentSearchType()).k(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)).a(10029);
    }

    /* access modifiers changed from: package-private */
    public void a(String str, int i, int i2, int i3, String str2, int i4, String str3, String str4) {
        o oVar = new o();
        oVar.a("status", (Number) 1);
        oVar.a("type", (Number) Integer.valueOf(i));
        oVar.a("keyword", str);
        oVar.a("defaultSuggestionsIndex", (Number) Integer.valueOf(i2));
        oVar.a("scopeListIndex", (Number) Integer.valueOf(i3));
        oVar.a(ShareConstants.FEED_SOURCE_PARAM, str2);
        oVar.a("cateId", (Number) Integer.valueOf(i4));
        oVar.a("cateName", str3);
        oVar.a("tracking", (l) WebRegister.GSON.a(str4, o.class));
        Promise promise = this.f18967a;
        if (promise != null) {
            promise.resolve(oVar.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.f18967a != null) {
            o oVar = new o();
            oVar.a("status", (Number) 0);
            this.f18967a.resolve(oVar.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Activity activity) {
        if (this.f18967a != null) {
            o oVar = new o();
            oVar.a("status", (Number) 0);
            this.f18967a.resolve(oVar.toString());
        }
        new ak(activity).as();
    }
}
