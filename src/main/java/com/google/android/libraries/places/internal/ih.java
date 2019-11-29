package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.kv;

public final class ih extends kv<ih, a> implements mc {

    /* renamed from: c  reason: collision with root package name */
    public static final ih f12701c = new ih();

    /* renamed from: d  reason: collision with root package name */
    private static volatile mj<ih> f12702d;

    /* renamed from: a  reason: collision with root package name */
    public int f12703a;

    /* renamed from: b  reason: collision with root package name */
    public int f12704b;

    public static final class a extends kv.a<ih, a> implements mc {
        a() {
            super(ih.f12701c);
        }
    }

    private ih() {
    }

    /* access modifiers changed from: protected */
    public final Object a(kv.d dVar, Object obj) {
        switch (dVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return a((ma) f12701c, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004\u0000", new Object[]{"a", "b"});
            case 3:
                return new ih();
            case 4:
                return new a();
            case 5:
                return f12701c;
            case 6:
                mj<ih> mjVar = f12702d;
                if (mjVar == null) {
                    synchronized (ih.class) {
                        mjVar = f12702d;
                        if (mjVar == null) {
                            mjVar = new jx<>(f12701c);
                            f12702d = mjVar;
                        }
                    }
                }
                return mjVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        kv.a(ih.class, f12701c);
    }
}
