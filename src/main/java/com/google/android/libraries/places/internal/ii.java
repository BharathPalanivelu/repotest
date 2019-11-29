package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.kv;

public final class ii extends kv<ii, a> implements mc {

    /* renamed from: c  reason: collision with root package name */
    public static final ii f12705c = new ii();

    /* renamed from: d  reason: collision with root package name */
    private static volatile mj<ii> f12706d;

    /* renamed from: a  reason: collision with root package name */
    public int f12707a;

    /* renamed from: b  reason: collision with root package name */
    public int f12708b;

    public static final class a extends kv.a<ii, a> implements mc {
        a() {
            super(ii.f12705c);
        }
    }

    private ii() {
    }

    /* access modifiers changed from: protected */
    public final Object a(kv.d dVar, Object obj) {
        switch (dVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return a((ma) f12705c, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004\u0000", new Object[]{"a", "b"});
            case 3:
                return new ii();
            case 4:
                return new a();
            case 5:
                return f12705c;
            case 6:
                mj<ii> mjVar = f12706d;
                if (mjVar == null) {
                    synchronized (ii.class) {
                        mjVar = f12706d;
                        if (mjVar == null) {
                            mjVar = new jx<>(f12705c);
                            f12706d = mjVar;
                        }
                    }
                }
                return mjVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        kv.a(ii.class, f12705c);
    }
}
