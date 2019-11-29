package com.garena.g.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.garena.g.a;
import com.garena.g.c;

public class i extends a {

    /* renamed from: b  reason: collision with root package name */
    private String f8001b = null;

    public boolean a() {
        return true;
    }

    public i() {
        super("com.pinterest");
    }

    public void a(String str) {
        this.f8001b = str;
    }

    public void a(Context context, a aVar) {
        if (this.f8001b != null) {
            Uri c2 = aVar.c();
            a(context, new Intent("android.intent.action.SEND", c2).putExtra("android.intent.extra.STREAM", c2).putExtra("android.intent.extra.TEXT", aVar.b()).putExtra("com.pinterest.EXTRA_PARTNER_ID", this.f8001b).putExtra("com.pinterest.EXTRA_URL", aVar.d()).putExtra("com.pinterest.EXTRA_DESCRIPTION", aVar.b()).putExtra("com.pinterest.EXTRA_PARTNER_PACKAGE", context.getPackageName()).setType("image/*"));
            return;
        }
        throw new c("Boss, set your pinterest app key please.^_^");
    }
}
