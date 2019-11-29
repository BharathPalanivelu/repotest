package com.shopee.app.b.b;

import android.app.Activity;
import android.content.Intent;
import com.google.a.o;
import com.shopee.app.ui.webview.WebPageActivity_;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.NavbarMessage;
import com.shopee.navigator.c.a.a;
import com.shopee.navigator.c.b;

public class g extends b {
    public a a() {
        return new com.shopee.navigator.c.a.b(".*");
    }

    public Class<? extends Activity> b() {
        return WebPageActivity_.class;
    }

    public Intent a(Activity activity, com.shopee.navigator.c.a aVar, o oVar, boolean z) {
        return WebPageActivity_.a(activity).b(aVar.a()).a(WebRegister.GSON.b((Object) new NavbarMessage())).b();
    }
}
