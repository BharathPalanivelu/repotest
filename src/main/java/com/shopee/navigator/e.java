package com.shopee.navigator;

import android.app.Activity;
import android.content.Intent;
import com.google.a.o;
import com.shopee.navigator.a.a.a;
import com.shopee.navigator.a.b;
import com.shopee.navigator.c.d;
import com.shopee.navigator.options.PopOption;
import com.shopee.navigator.options.PushOption;

public abstract class e {
    public abstract void a(Activity activity, int i, int i2, Intent intent);

    public abstract void a(Activity activity, o oVar, PopOption popOption);

    public abstract void a(Activity activity, NavigationPath navigationPath);

    public abstract void a(Activity activity, NavigationPath navigationPath, o oVar);

    public abstract void a(Activity activity, NavigationPath navigationPath, o oVar, PushOption pushOption);

    public static e a(d dVar, Class<? extends Object> cls) {
        return new f(dVar, new b.a().a(0, a.a()).a(1, a.c()).a(2, a.b()).a(3, a.d()).a(), cls);
    }
}
