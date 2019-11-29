package com.shopee.app.util;

import android.content.Context;
import android.net.Uri;
import com.facebook.react.uimanager.events.TouchesHelper;
import com.garena.android.appkit.tools.b;
import com.garena.android.uikit.image.c.a;
import com.squareup.a.af;
import com.squareup.a.r;
import com.squareup.a.w;
import d.d.b.j;
import d.h.m;
import java.io.File;

public final class aa {
    public static final void a(Context context, a aVar, String str) {
        j.b(context, "context");
        j.b(aVar, "image");
        if (str != null && !m.a(str)) {
            double b2 = (double) b.b();
            Double.isNaN(b2);
            a(context, aVar, str, m.a(str, "data:image", false, 2, (Object) null) ? new ah(aVar) : new ag(aVar, str), (int) (b2 * 1.5d), b.d());
        }
    }

    public static final void a(Context context, a aVar, String str, af afVar, int i, int i2) {
        j.b(context, "context");
        j.b(aVar, "image");
        j.b(str, "path");
        j.b(afVar, TouchesHelper.TARGET_KEY);
        aVar.setTag(afVar);
        aVar.a();
        File file = new File(str);
        if (m.a(str, "data:image", false, 2, (Object) null)) {
            com.shopee.app.ui.image.j.a(context).a(Uri.parse(str)).b(i, i2).e().f().a(r.NO_CACHE, r.NO_STORE).a(afVar);
        } else if (file.exists()) {
            w.a(context).a(file).b(i, i2).e().f().a(r.NO_CACHE, r.NO_STORE).a(afVar);
        } else {
            w.a(context).a(str).b(i, i2).e().f().a(r.NO_CACHE, r.NO_STORE).a(afVar);
        }
    }
}
