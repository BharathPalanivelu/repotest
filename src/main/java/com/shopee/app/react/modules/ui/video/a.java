package com.shopee.app.react.modules.ui.video;

import android.app.Activity;
import com.facebook.react.bridge.Promise;
import com.google.a.o;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.react.c;
import com.shopee.app.react.modules.base.b;
import com.shopee.app.util.ak;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.OpenYoutubeVideoMessage;

public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    ak f18995a;

    /* renamed from: b  reason: collision with root package name */
    SettingConfigStore f18996b;

    public a(c cVar) {
        cVar.c().a(this);
    }

    /* access modifiers changed from: package-private */
    public void a(Activity activity, String str, Promise promise) {
        OpenYoutubeVideoMessage openYoutubeVideoMessage = (OpenYoutubeVideoMessage) WebRegister.GSON.a(str, OpenYoutubeVideoMessage.class);
        if (openYoutubeVideoMessage.openExternalLink) {
            this.f18995a.r(openYoutubeVideoMessage.videoID);
        } else {
            this.f18995a.a(openYoutubeVideoMessage.videoID, this.f18996b);
        }
        o oVar = new o();
        oVar.a("status", (Number) 1);
        promise.resolve(oVar.toString());
    }
}
