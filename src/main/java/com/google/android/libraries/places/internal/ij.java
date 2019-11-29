package com.google.android.libraries.places.internal;

import com.appsflyer.share.Constants;
import com.google.android.libraries.places.internal.kv;

public final class ij extends kv<ij, a> implements mc {

    /* renamed from: d  reason: collision with root package name */
    public static final ij f12709d = new ij();

    /* renamed from: e  reason: collision with root package name */
    private static volatile mj<ij> f12710e;

    /* renamed from: a  reason: collision with root package name */
    public int f12711a;

    /* renamed from: b  reason: collision with root package name */
    public int f12712b;

    /* renamed from: c  reason: collision with root package name */
    public int f12713c;

    public static final class a extends kv.a<ij, a> implements mc {
        a() {
            super(ij.f12709d);
        }
    }

    private ij() {
    }

    /* access modifiers changed from: protected */
    public final Object a(kv.d dVar, Object obj) {
        switch (dVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return a((ma) f12709d, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"a", "b", Constants.URL_CAMPAIGN});
            case 3:
                return new ij();
            case 4:
                return new a();
            case 5:
                return f12709d;
            case 6:
                mj<ij> mjVar = f12710e;
                if (mjVar == null) {
                    synchronized (ij.class) {
                        mjVar = f12710e;
                        if (mjVar == null) {
                            mjVar = new jx<>(f12709d);
                            f12710e = mjVar;
                        }
                    }
                }
                return mjVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        kv.a(ij.class, f12709d);
    }
}
