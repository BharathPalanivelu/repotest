package com.shopee.arcatch.c.f;

import android.app.Activity;
import android.content.Context;
import com.google.a.o;
import com.shopee.arcatch.page.activity.ArCatchLoadingActivity;
import com.shopee.sdk.d.a;
import com.shopee.sdk.d.b;

public class c extends b {
    public a a() {
        return a.a("ShopeeARCatchGame");
    }

    public boolean a(Activity activity, o oVar) {
        activity.startActivity(com.shopee.sdk.modules.ui.navigator.a.a((Context) activity, (Class<? extends Activity>) ArCatchLoadingActivity.class, oVar));
        return true;
    }
}
