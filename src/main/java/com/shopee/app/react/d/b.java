package com.shopee.app.react.d;

import android.app.Activity;
import android.content.Intent;
import com.facebook.react.ReactInstanceManager;
import com.shopee.app.react.ReactActivity_;
import com.shopee.app.react.ReactTransparentActivity_;
import com.shopee.app.react.d;
import com.shopee.app.react.protocol.PushData;
import com.shopee.app.web.WebRegister;

public class b {
    public static Class<? extends d> a(int i) {
        return i == 3 ? ReactTransparentActivity_.class : ReactActivity_.class;
    }

    public static void a(Activity activity, String str, PushData pushData, String str2, int i, int i2) {
        activity.startActivityForResult(b(activity, str, pushData, str2, i, i2), 9281);
    }

    public static Intent b(Activity activity, String str, PushData pushData, String str2, int i, int i2) {
        if (i2 == 3) {
            return ReactTransparentActivity_.a(activity).a(str).c(WebRegister.GSON.b((Object) pushData)).b(str2).b(i).c(i2).b();
        }
        return ReactActivity_.a(activity).a(str).c(WebRegister.GSON.b((Object) pushData)).b(str2).b(i).c(i2).b();
    }

    public static boolean a(ReactInstanceManager reactInstanceManager, Activity activity) {
        return reactInstanceManager.getCurrentReactContext() != null && reactInstanceManager.getCurrentReactContext().getCurrentActivity() == activity;
    }
}
