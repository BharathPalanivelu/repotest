package com.shopee.live.livestreaming.c;

import android.app.Activity;
import android.content.Context;
import com.google.a.o;
import com.shopee.live.livestreaming.ui.audience.activity.LiveStreamingAudienceActivity;
import com.shopee.sdk.d.a;

public class b extends com.shopee.sdk.d.b {
    public a a() {
        return a.a(LiveStreamingAudienceActivity.N);
    }

    public boolean a(Activity activity, o oVar) {
        activity.startActivity(com.shopee.sdk.modules.ui.navigator.a.a((Context) activity, (Class<? extends Activity>) LiveStreamingAudienceActivity.class, oVar));
        return true;
    }
}
