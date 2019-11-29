package com.shopee.app.react;

import android.app.Activity;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.shopee.app.react.modules.base.a;
import com.shopee.app.react.modules.base.b;

public interface c extends DefaultHardwareBackBtnHandler {
    Activity a();

    b a(String str);

    void a(String str, b bVar);

    a c();

    int getReactTag();
}
