package com.squareup.a;

import android.graphics.Bitmap;
import android.net.NetworkInfo;
import com.squareup.a.ab;
import com.squareup.a.j;
import com.squareup.a.w;
import java.io.IOException;
import java.io.InputStream;

class t extends ab {

    /* renamed from: a  reason: collision with root package name */
    private final j f30578a;

    /* renamed from: b  reason: collision with root package name */
    private final ad f30579b;

    /* access modifiers changed from: package-private */
    public int a() {
        return 2;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return true;
    }

    public t(j jVar, ad adVar) {
        this.f30578a = jVar;
        this.f30579b = adVar;
    }

    public boolean a(z zVar) {
        String scheme = zVar.f30601d.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    public ab.a a(z zVar, int i) throws IOException {
        j.a a2 = this.f30578a.a(zVar.f30601d, zVar.f30600c);
        if (a2 == null) {
            return null;
        }
        w.d dVar = a2.f30568c ? w.d.DISK : w.d.NETWORK;
        Bitmap b2 = a2.b();
        if (b2 != null) {
            return new ab.a(b2, dVar);
        }
        InputStream a3 = a2.a();
        if (a3 == null) {
            return null;
        }
        if (dVar == w.d.DISK && a2.c() == 0) {
            aj.a(a3);
            throw new a("Received response with 0 content-length header.");
        }
        if (dVar == w.d.NETWORK && a2.c() > 0) {
            this.f30579b.a(a2.c());
        }
        return new ab.a(a3, dVar);
    }

    /* access modifiers changed from: package-private */
    public boolean a(boolean z, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    static class a extends IOException {
        public a(String str) {
            super(str);
        }
    }
}
