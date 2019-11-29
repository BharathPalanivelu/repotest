package com.shopee.react.sdk.bridge.modules.ui.navigate;

import android.app.Activity;
import android.content.Intent;
import com.google.a.o;
import com.shopee.navigator.NavigationPath;
import com.shopee.navigator.e;
import com.shopee.navigator.options.PopOption;
import com.shopee.navigator.options.PushOption;
import com.shopee.react.sdk.activity.b;
import com.shopee.react.sdk.bridge.modules.base.d;
import com.shopee.react.sdk.bridge.protocol.PopData;
import com.shopee.react.sdk.bridge.protocol.PushData;
import com.shopee.react.sdk.bridge.protocol.PushExtra;

public class a extends d {

    /* renamed from: a  reason: collision with root package name */
    private e f30250a;

    /* renamed from: b  reason: collision with root package name */
    private Class<? extends Activity> f30251b;

    public void b(Activity activity, String str) {
    }

    public a(e eVar, Class<? extends Activity> cls) {
        this.f30250a = eVar;
        this.f30251b = cls;
    }

    public void a(Activity activity, String str, String str2, int i, String str3) {
        PushData pushData = (PushData) com.shopee.react.sdk.a.a.f30143a.a(str3, PushData.class);
        this.f30250a.a(activity, NavigationPath.a(this.f30251b), new b.a().a(str).b(str2).a(i).c(pushData.getPropsString()).a().toJsonObject(), PushOption.a(i, pushData.getPopCount()));
    }

    public void a(Activity activity, String str) {
        PopData popData = (PopData) com.shopee.react.sdk.a.a.f30143a.a(str, PopData.class);
        this.f30250a.a(activity, popData.getDataAsJson(), PopOption.b(popData.getCount()));
    }

    public void a(Activity activity, String str, String str2) {
        PushExtra pushExtra = (PushExtra) com.shopee.react.sdk.a.a.f30143a.a(str2, PushExtra.class);
        this.f30250a.a(activity, NavigationPath.a(str), (o) null, PushOption.a(pushExtra.getEnterType(), pushExtra.getPopCount()));
    }

    public void a(Activity activity, int i, int i2, Intent intent) {
        this.f30250a.a(activity, i, i2, intent);
    }
}
