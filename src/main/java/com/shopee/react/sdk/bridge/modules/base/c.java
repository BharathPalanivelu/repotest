package com.shopee.react.sdk.bridge.modules.base;

import com.facebook.react.bridge.Promise;
import com.shopee.navigator.a;

public class c<DATA> {

    /* renamed from: a  reason: collision with root package name */
    private Promise f30190a;

    public c(Promise promise) {
        this.f30190a = promise;
    }

    public void a(DATA data) {
        this.f30190a.resolve(a.f30102a.b((Object) data));
    }
}
