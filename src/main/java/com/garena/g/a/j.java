package com.garena.g.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.garena.g.a;

public class j extends a {
    public j() {
        super("");
    }

    public void a(Context context, a aVar) {
        if (aVar.e() != 1) {
            Intent intent = new Intent("android.intent.action.SENDTO");
            intent.setData(Uri.parse("smsto:"));
            intent.putExtra("sms_body", aVar.b());
            a(context, intent);
            return;
        }
        Intent intent2 = new Intent("android.intent.action.SEND");
        intent2.putExtra("sms_body", aVar.b());
        intent2.putExtra("android.intent.extra.STREAM", aVar.c());
        intent2.setType("image/png");
        a(context, intent2);
    }
}
