package com.squareup.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.common.util.UriUtil;
import com.squareup.a.ab;
import com.squareup.a.w;
import java.io.IOException;

class ac extends ab {

    /* renamed from: a  reason: collision with root package name */
    private final Context f30508a;

    ac(Context context) {
        this.f30508a = context;
    }

    public boolean a(z zVar) {
        if (zVar.f30602e != 0) {
            return true;
        }
        return UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(zVar.f30601d.getScheme());
    }

    public ab.a a(z zVar, int i) throws IOException {
        Resources a2 = aj.a(this.f30508a, zVar);
        return new ab.a(a(a2, aj.a(a2, zVar), zVar), w.d.DISK);
    }

    private static Bitmap a(Resources resources, int i, z zVar) {
        BitmapFactory.Options c2 = c(zVar);
        if (a(c2)) {
            BitmapFactory.decodeResource(resources, i, c2);
            a(zVar.h, zVar.i, c2, zVar);
        }
        return BitmapFactory.decodeResource(resources, i, c2);
    }
}
