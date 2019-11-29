package com.squareup.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import com.facebook.common.util.UriUtil;
import com.squareup.a.ab;
import com.squareup.a.w;
import java.io.IOException;

class l extends g {
    l(Context context) {
        super(context);
    }

    public boolean a(z zVar) {
        return UriUtil.LOCAL_FILE_SCHEME.equals(zVar.f30601d.getScheme());
    }

    public ab.a a(z zVar, int i) throws IOException {
        return new ab.a((Bitmap) null, b(zVar), w.d.DISK, a(zVar.f30601d));
    }

    static int a(Uri uri) throws IOException {
        return new ExifInterface(uri.getPath()).getAttributeInt("Orientation", 1);
    }
}
