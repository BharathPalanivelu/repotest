package com.garena.g.a;

import android.content.Context;
import android.content.Intent;
import com.garena.g.a;

public class k extends a {
    public k() {
        super("");
    }

    public void a(Context context, a aVar) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", aVar.a());
        intent.putExtra("android.intent.extra.TEXT", aVar.b());
        a(context, intent);
    }
}
