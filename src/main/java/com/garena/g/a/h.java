package com.garena.g.a;

import android.content.Context;
import android.content.Intent;
import com.facebook.messenger.MessengerUtils;
import com.garena.g.a;

public class h extends a {
    public h() {
        super(MessengerUtils.PACKAGE_NAME);
    }

    public void a(Context context, a aVar) {
        if (aVar.e() != 1) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", aVar.b());
            a(context, intent);
            return;
        }
        a(context, com.garena.g.b.a.a(aVar.c(), aVar.b()));
    }
}
