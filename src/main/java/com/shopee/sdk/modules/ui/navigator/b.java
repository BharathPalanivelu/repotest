package com.shopee.sdk.modules.ui.navigator;

import android.app.Activity;
import android.content.Intent;
import com.google.a.o;
import com.shopee.sdk.modules.ui.navigator.options.JumpOption;
import com.shopee.sdk.modules.ui.navigator.options.PopOption;
import com.shopee.sdk.modules.ui.navigator.options.PushOption;

public interface b {
    void a(Activity activity);

    void a(Activity activity, int i, int i2, Intent intent);

    void a(Activity activity, o oVar, PopOption popOption);

    void a(Activity activity, NavigationPath navigationPath);

    void a(Activity activity, NavigationPath navigationPath, o oVar);

    void a(Activity activity, NavigationPath navigationPath, o oVar, JumpOption jumpOption);

    void a(Activity activity, NavigationPath navigationPath, o oVar, PushOption pushOption);
}
