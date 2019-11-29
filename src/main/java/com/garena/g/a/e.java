package com.garena.g.a;

import android.content.Context;
import android.content.Intent;
import com.garena.g.a;

public class e extends a {
    public e() {
        super("");
    }

    public void a(Context context, a aVar) {
        if (aVar.e() != 1) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("message/rfc822");
            intent.putExtra("android.intent.extra.SUBJECT", aVar.a());
            intent.putExtra("android.intent.extra.TEXT", aVar.b());
            a(context, intent);
            return;
        }
        Intent intent2 = new Intent("android.intent.action.SEND");
        intent2.setType("message/rfc822");
        intent2.putExtra("android.intent.extra.SUBJECT", aVar.a());
        intent2.putExtra("android.intent.extra.TEXT", aVar.b());
        intent2.putExtra("android.intent.extra.STREAM", aVar.c());
        intent2.setType("image/png");
        a(context, intent2);
    }
}
