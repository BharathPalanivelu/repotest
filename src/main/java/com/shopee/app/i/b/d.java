package com.shopee.app.i.b;

import android.app.Activity;
import com.shopee.app.react.g;
import com.shopee.app.ui.auth.AuthTabActivity_;
import com.shopee.sdk.modules.ui.c.a;
import com.shopee.sdk.modules.ui.c.b;

public class d implements b {
    public void a(Activity activity, a aVar) {
        if (!activity.isFinishing()) {
            g.a(aVar.b());
            AuthTabActivity_.a(activity).b(aVar.a()).a();
        }
    }
}
