package com.shopee.live.livestreaming.c;

import android.app.Activity;
import android.content.Context;
import com.google.a.o;
import com.shopee.live.livestreaming.ui.audience.activity.LiveStreamingReplayActivity;
import com.shopee.sdk.d.a;
import com.shopee.sdk.d.b;

public class c extends b {
    public a a() {
        return a.a(LiveStreamingReplayActivity.N);
    }

    public boolean a(Activity activity, o oVar) {
        activity.startActivity(com.shopee.sdk.modules.ui.navigator.a.a((Context) activity, (Class<? extends Activity>) LiveStreamingReplayActivity.class, oVar));
        return true;
    }
}
