package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.kv;

public final class ir extends kv<ir, a> implements mc {

    /* renamed from: c  reason: collision with root package name */
    public static final ir f12745c = new ir();

    /* renamed from: e  reason: collision with root package name */
    private static volatile mj<ir> f12746e;

    /* renamed from: a  reason: collision with root package name */
    public int f12747a;

    /* renamed from: b  reason: collision with root package name */
    public Cif f12748b;

    /* renamed from: d  reason: collision with root package name */
    private byte f12749d = 2;

    public static final class a extends kv.a<ir, a> implements mc {
        a() {
            super(ir.f12745c);
        }
    }

    private ir() {
    }

    /* access modifiers changed from: protected */
    public final Object a(kv.d dVar, Object obj) {
        int i = 1;
        switch (dVar.ordinal()) {
            case 0:
                return Byte.valueOf(this.f12749d);
            case 1:
                if (obj == null) {
                    i = 0;
                }
                this.f12749d = (byte) i;
                return null;
            case 2:
                return a((ma) f12745c, "\u0001\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0001\u0002Љ\u0001", new Object[]{"a", "b"});
            case 3:
                return new ir();
            case 4:
                return new a();
            case 5:
                return f12745c;
            case 6:
                mj<ir> mjVar = f12746e;
                if (mjVar == null) {
                    synchronized (ir.class) {
                        mjVar = f12746e;
                        if (mjVar == null) {
                            mjVar = new jx<>(f12745c);
                            f12746e = mjVar;
                        }
                    }
                }
                return mjVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        kv.a(ir.class, f12745c);
    }
}
