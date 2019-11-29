package com.google.android.exoplayer2.e;

import com.google.android.exoplayer2.e.b.d;
import com.google.android.exoplayer2.e.c.b;
import com.google.android.exoplayer2.e.d.e;
import com.google.android.exoplayer2.e.d.g;
import com.google.android.exoplayer2.e.g.a;
import com.google.android.exoplayer2.e.g.p;
import com.google.android.exoplayer2.e.g.u;
import java.lang.reflect.Constructor;

public final class c implements i {

    /* renamed from: a  reason: collision with root package name */
    private static final Constructor<? extends f> f9365a;

    /* renamed from: b  reason: collision with root package name */
    private int f9366b;

    /* renamed from: c  reason: collision with root package name */
    private int f9367c;

    /* renamed from: d  reason: collision with root package name */
    private int f9368d;

    /* renamed from: e  reason: collision with root package name */
    private int f9369e = 1;

    /* renamed from: f  reason: collision with root package name */
    private int f9370f;

    static {
        Constructor<? extends U> constructor;
        try {
            constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(f.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            constructor = null;
        }
        f9365a = constructor;
    }

    public synchronized f[] a() {
        f[] fVarArr;
        fVarArr = new f[(f9365a == null ? 11 : 12)];
        fVarArr[0] = new d(this.f9366b);
        fVarArr[1] = new e(this.f9367c);
        fVarArr[2] = new g();
        fVarArr[3] = new b(this.f9368d);
        fVarArr[4] = new com.google.android.exoplayer2.e.g.c();
        fVarArr[5] = new a();
        fVarArr[6] = new u(this.f9369e, this.f9370f);
        fVarArr[7] = new com.google.android.exoplayer2.e.a.b();
        fVarArr[8] = new com.google.android.exoplayer2.e.e.c();
        fVarArr[9] = new p();
        fVarArr[10] = new com.google.android.exoplayer2.e.h.a();
        if (f9365a != null) {
            try {
                fVarArr[11] = (f) f9365a.newInstance(new Object[0]);
            } catch (Exception e2) {
                throw new IllegalStateException("Unexpected error creating FLAC extractor", e2);
            }
        }
        return fVarArr;
    }
}
