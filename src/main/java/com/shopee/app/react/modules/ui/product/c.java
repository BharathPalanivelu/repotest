package com.shopee.app.react.modules.ui.product;

import android.app.Activity;
import b.a.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.tracking.f;
import com.shopee.app.util.ak;
import javax.inject.Provider;

public final class c implements b<a> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<UserInfo> f18958a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<f> f18959b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Activity> f18960c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ak> f18961d;

    /* renamed from: a */
    public a get() {
        a aVar = new a(this.f18958a.get(), this.f18959b.get(), this.f18960c.get(), this.f18961d.get());
        d.a(aVar, this.f18958a.get());
        d.a(aVar, this.f18959b.get());
        d.a(aVar, this.f18961d.get());
        return aVar;
    }

    public static a a(UserInfo userInfo, f fVar, Activity activity, ak akVar) {
        return new a(userInfo, fVar, activity, akVar);
    }
}
