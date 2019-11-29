package com.shopee.feeds.feedlibrary.c;

import android.app.Activity;
import android.content.Context;
import com.google.a.o;
import com.shopee.feeds.feedlibrary.editor.activity.PhotoEditActivity;
import com.shopee.sdk.d.b;

public class a extends b {
    public com.shopee.sdk.d.a a() {
        return com.shopee.sdk.d.a.a("ShopeeFeedsEditPage");
    }

    public boolean a(Activity activity, o oVar) {
        activity.startActivity(com.shopee.sdk.modules.ui.navigator.a.a((Context) activity, (Class<? extends Activity>) PhotoEditActivity.class, oVar));
        return true;
    }
}
