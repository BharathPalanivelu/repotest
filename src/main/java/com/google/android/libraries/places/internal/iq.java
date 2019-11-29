package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.kv;

public final class iq extends kv<iq, a> implements mc {

    /* renamed from: c  reason: collision with root package name */
    public static final iq f12740c = new iq();

    /* renamed from: e  reason: collision with root package name */
    private static volatile mj<iq> f12741e;

    /* renamed from: a  reason: collision with root package name */
    public int f12742a;

    /* renamed from: b  reason: collision with root package name */
    public ig f12743b;

    /* renamed from: d  reason: collision with root package name */
    private byte f12744d = 2;

    public static final class a extends kv.a<iq, a> implements mc {
        a() {
            super(iq.f12740c);
        }
    }

    private iq() {
    }

    /* access modifiers changed from: protected */
    public final Object a(kv.d dVar, Object obj) {
        int i = 1;
        switch (dVar.ordinal()) {
            case 0:
                return Byte.valueOf(this.f12744d);
            case 1:
                if (obj == null) {
                    i = 0;
                }
                this.f12744d = (byte) i;
                return null;
            case 2:
                return a((ma) f12740c, "\u0001\u0001\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0001\u0004Љ\u0003", new Object[]{"a", "b"});
            case 3:
                return new iq();
            case 4:
                return new a();
            case 5:
                return f12740c;
            case 6:
                mj<iq> mjVar = f12741e;
                if (mjVar == null) {
                    synchronized (iq.class) {
                        mjVar = f12741e;
                        if (mjVar == null) {
                            mjVar = new jx<>(f12740c);
                            f12741e = mjVar;
                        }
                    }
                }
                return mjVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        kv.a(iq.class, f12740c);
    }
}
