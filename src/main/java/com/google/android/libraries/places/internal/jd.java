package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.kv;

public final class jd extends kv<jd, a> implements mc {

    /* renamed from: c  reason: collision with root package name */
    public static final jd f12801c = new jd();

    /* renamed from: d  reason: collision with root package name */
    private static volatile mj<jd> f12802d;

    /* renamed from: a  reason: collision with root package name */
    public int f12803a;

    /* renamed from: b  reason: collision with root package name */
    public jl f12804b;

    public static final class a extends kv.a<jd, a> implements mc {
        a() {
            super(jd.f12801c);
        }
    }

    private jd() {
    }

    /* access modifiers changed from: protected */
    public final Object a(kv.d dVar, Object obj) {
        switch (dVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return a((ma) f12801c, "\u0001\u0001\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0000\u0004\t\u0002", new Object[]{"a", "b"});
            case 3:
                return new jd();
            case 4:
                return new a();
            case 5:
                return f12801c;
            case 6:
                mj<jd> mjVar = f12802d;
                if (mjVar == null) {
                    synchronized (jd.class) {
                        mjVar = f12802d;
                        if (mjVar == null) {
                            mjVar = new jx<>(f12801c);
                            f12802d = mjVar;
                        }
                    }
                }
                return mjVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        kv.a(jd.class, f12801c);
    }
}
