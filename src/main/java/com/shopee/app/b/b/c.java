package com.shopee.app.b.b;

import android.app.Activity;
import android.content.Intent;
import com.google.a.o;
import com.shopee.app.react.d;
import com.shopee.app.react.protocol.PushData;
import com.shopee.navigator.c.a.a;
import com.shopee.navigator.c.b;

public class c extends b {
    public a a() {
        return new com.shopee.navigator.c.a.b(".*");
    }

    public Class<? extends Activity> b() {
        return d.class;
    }

    public Intent a(Activity activity, com.shopee.navigator.c.a aVar, o oVar, boolean z) {
        return com.shopee.app.react.d.b.b(activity, aVar.c(), new PushData(oVar.toString()), "", 0, z ? 3 : 2);
    }
}
