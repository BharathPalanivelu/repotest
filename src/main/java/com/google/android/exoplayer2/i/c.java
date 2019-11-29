package com.google.android.exoplayer2.i;

import com.google.android.exoplayer2.i.b.d;
import com.google.android.exoplayer2.i.c.b;
import com.google.android.exoplayer2.i.d.e;
import com.google.android.exoplayer2.i.d.g;
import com.google.android.exoplayer2.i.g.a;
import com.google.android.exoplayer2.i.g.p;
import com.google.android.exoplayer2.i.g.u;
import java.lang.reflect.Constructor;

public final class c implements h {

    /* renamed from: a  reason: collision with root package name */
    private static final Constructor<? extends e> f10009a;

    /* renamed from: b  reason: collision with root package name */
    private int f10010b;

    /* renamed from: c  reason: collision with root package name */
    private int f10011c;

    /* renamed from: d  reason: collision with root package name */
    private int f10012d;

    /* renamed from: e  reason: collision with root package name */
    private int f10013e = 1;

    /* renamed from: f  reason: collision with root package name */
    private int f10014f;

    static {
        Constructor<? extends U> constructor;
        try {
            constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(e.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            constructor = null;
        }
        f10009a = constructor;
    }

    public synchronized e[] a() {
        e[] eVarArr;
        eVarArr = new e[(f10009a == null ? 11 : 12)];
        eVarArr[0] = new d(this.f10010b);
        eVarArr[1] = new e(this.f10011c);
        eVarArr[2] = new g();
        eVarArr[3] = new b(this.f10012d);
        eVarArr[4] = new com.google.android.exoplayer2.i.g.c();
        eVarArr[5] = new a();
        eVarArr[6] = new u(this.f10013e, this.f10014f);
        eVarArr[7] = new com.google.android.exoplayer2.i.a.b();
        eVarArr[8] = new com.google.android.exoplayer2.i.e.c();
        eVarArr[9] = new p();
        eVarArr[10] = new com.google.android.exoplayer2.i.h.a();
        if (f10009a != null) {
            try {
                eVarArr[11] = (e) f10009a.newInstance(new Object[0]);
            } catch (Exception e2) {
                throw new IllegalStateException("Unexpected error creating FLAC extractor", e2);
            }
        }
        return eVarArr;
    }
}
