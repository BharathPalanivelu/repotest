package com.shopee.live.livestreaming.c;

import android.app.Activity;
import android.content.Context;
import com.google.a.o;
import com.shopee.live.livestreaming.ui.anchor.LiveStreamingAnchorActivity;
import com.shopee.sdk.d.b;

public class a extends b {
    public com.shopee.sdk.d.a a() {
        return com.shopee.sdk.d.a.a(LiveStreamingAnchorActivity.f28802b);
    }

    public boolean a(Activity activity, o oVar) {
        activity.startActivityForResult(com.shopee.sdk.modules.ui.navigator.a.a((Context) activity, (Class<? extends Activity>) LiveStreamingAnchorActivity.class, oVar), 88);
        return true;
    }
}
