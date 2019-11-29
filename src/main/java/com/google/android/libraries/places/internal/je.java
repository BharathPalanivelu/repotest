package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.kv;

public final class je extends kv<je, a> implements mc {

    /* renamed from: c  reason: collision with root package name */
    public static final je f12805c = new je();

    /* renamed from: e  reason: collision with root package name */
    private static volatile mj<je> f12806e;

    /* renamed from: a  reason: collision with root package name */
    public int f12807a;

    /* renamed from: b  reason: collision with root package name */
    public Cif f12808b;

    /* renamed from: d  reason: collision with root package name */
    private byte f12809d = 2;

    public static final class a extends kv.a<je, a> implements mc {
        a() {
            super(je.f12805c);
        }
    }

    private je() {
    }

    /* access modifiers changed from: protected */
    public final Object a(kv.d dVar, Object obj) {
        int i = 1;
        switch (dVar.ordinal()) {
            case 0:
                return Byte.valueOf(this.f12809d);
            case 1:
                if (obj == null) {
                    i = 0;
                }
                this.f12809d = (byte) i;
                return null;
            case 2:
                return a((ma) f12805c, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001Љ\u0000", new Object[]{"a", "b"});
            case 3:
                return new je();
            case 4:
                return new a();
            case 5:
                return f12805c;
            case 6:
                mj<je> mjVar = f12806e;
                if (mjVar == null) {
                    synchronized (je.class) {
                        mjVar = f12806e;
                        if (mjVar == null) {
                            mjVar = new jx<>(f12805c);
                            f12806e = mjVar;
                        }
                    }
                }
                return mjVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        kv.a(je.class, f12805c);
    }
}
