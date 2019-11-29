package com.squareup.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.facebook.common.util.UriUtil;
import com.squareup.a.ab;
import com.squareup.a.w;
import java.io.IOException;

class b extends ab {

    /* renamed from: a  reason: collision with root package name */
    private static final int f30531a = 22;

    /* renamed from: b  reason: collision with root package name */
    private final Context f30532b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f30533c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private AssetManager f30534d;

    public b(Context context) {
        this.f30532b = context;
    }

    public boolean a(z zVar) {
        Uri uri = zVar.f30601d;
        if (!UriUtil.LOCAL_FILE_SCHEME.equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !"android_asset".equals(uri.getPathSegments().get(0))) {
            return false;
        }
        return true;
    }

    public ab.a a(z zVar, int i) throws IOException {
        if (this.f30534d == null) {
            synchronized (this.f30533c) {
                if (this.f30534d == null) {
                    this.f30534d = this.f30532b.getAssets();
                }
            }
        }
        return new ab.a(this.f30534d.open(b(zVar)), w.d.DISK);
    }

    static String b(z zVar) {
        return zVar.f30601d.toString().substring(f30531a);
    }
}
