package com.squareup.a;

import android.content.Context;
import com.facebook.common.util.UriUtil;
import com.squareup.a.ab;
import com.squareup.a.w;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

class g extends ab {

    /* renamed from: a  reason: collision with root package name */
    final Context f30549a;

    g(Context context) {
        this.f30549a = context;
    }

    public boolean a(z zVar) {
        return UriUtil.LOCAL_CONTENT_SCHEME.equals(zVar.f30601d.getScheme());
    }

    public ab.a a(z zVar, int i) throws IOException {
        return new ab.a(b(zVar), w.d.DISK);
    }

    /* access modifiers changed from: package-private */
    public InputStream b(z zVar) throws FileNotFoundException {
        return this.f30549a.getContentResolver().openInputStream(zVar.f30601d);
    }
}
