package com.shopee.feeds.feedlibrary.c;

import android.app.Activity;
import android.content.Context;
import com.google.a.o;
import com.shopee.feeds.feedlibrary.activity.SelectPictureActivity;
import com.shopee.sdk.d.a;

public class b extends com.shopee.sdk.d.b {
    public a a() {
        return a.a(SelectPictureActivity.f7077c);
    }

    public boolean a(Activity activity, o oVar) {
        activity.startActivity(com.shopee.sdk.modules.ui.navigator.a.a((Context) activity, (Class<? extends Activity>) SelectPictureActivity.class, oVar));
        return true;
    }
}
