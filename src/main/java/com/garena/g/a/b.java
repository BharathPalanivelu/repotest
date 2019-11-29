package com.garena.g.a;

import android.content.Context;
import android.content.Intent;
import com.garena.g.a;

public class b extends a {
    public b() {
        super("com.beetalk");
    }

    public void a(Context context, a aVar) {
        Intent intent = new Intent();
        intent.setAction("com.beetalk.SHARE_URL_BUZZ");
        intent.putExtra("android.intent.extra.TEXT", aVar.d());
        intent.setType("text/plain");
        a(context, intent);
    }
}
