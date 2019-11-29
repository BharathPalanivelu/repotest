package com.google.android.libraries.places.internal;

import com.appsflyer.share.Constants;
import com.google.android.libraries.places.internal.kv;

public final class ig extends kv<ig, a> implements mc {

    /* renamed from: d  reason: collision with root package name */
    public static final ig f12695d = new ig();

    /* renamed from: f  reason: collision with root package name */
    private static volatile mj<ig> f12696f;

    /* renamed from: a  reason: collision with root package name */
    public int f12697a;

    /* renamed from: b  reason: collision with root package name */
    public Cif f12698b;

    /* renamed from: c  reason: collision with root package name */
    public Cif f12699c;

    /* renamed from: e  reason: collision with root package name */
    private byte f12700e = 2;

    public static final class a extends kv.a<ig, a> implements mc {
        a() {
            super(ig.f12695d);
        }
    }

    private ig() {
    }

    /* access modifiers changed from: protected */
    public final Object a(kv.d dVar, Object obj) {
        int i = 1;
        switch (dVar.ordinal()) {
            case 0:
                return Byte.valueOf(this.f12700e);
            case 1:
                if (obj == null) {
                    i = 0;
                }
                this.f12700e = (byte) i;
                return null;
            case 2:
                return a((ma) f12695d, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001Љ\u0000\u0002Љ\u0001", new Object[]{"a", "b", Constants.URL_CAMPAIGN});
            case 3:
                return new ig();
            case 4:
                return new a();
            case 5:
                return f12695d;
            case 6:
                mj<ig> mjVar = f12696f;
                if (mjVar == null) {
                    synchronized (ig.class) {
                        mjVar = f12696f;
                        if (mjVar == null) {
                            mjVar = new jx<>(f12695d);
                            f12696f = mjVar;
                        }
                    }
                }
                return mjVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        kv.a(ig.class, f12695d);
    }
}
