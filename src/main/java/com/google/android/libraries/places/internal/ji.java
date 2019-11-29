package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.kv;

public final class ji extends kv<ji, a> implements mc {

    /* renamed from: c  reason: collision with root package name */
    public static final ji f12822c = new ji();

    /* renamed from: d  reason: collision with root package name */
    private static volatile mj<ji> f12823d;

    /* renamed from: a  reason: collision with root package name */
    public int f12824a;

    /* renamed from: b  reason: collision with root package name */
    public int f12825b;

    public static final class a extends kv.a<ji, a> implements mc {
        a() {
            super(ji.f12822c);
        }
    }

    private ji() {
    }

    public enum b implements ky {
        PHOTO_METADATA(0),
        PHOTO_IMAGE(1);
        

        /* renamed from: b  reason: collision with root package name */
        public final int f12829b;

        public final int a() {
            return this.f12829b;
        }

        public static kz b() {
            return jk.f12830a;
        }

        private b(int i) {
            this.f12829b = i;
        }

        static {
            new jj();
        }
    }

    /* access modifiers changed from: protected */
    public final Object a(kv.d dVar, Object obj) {
        switch (dVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return a((ma) f12822c, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f\u0000", new Object[]{"a", "b", b.b()});
            case 3:
                return new ji();
            case 4:
                return new a();
            case 5:
                return f12822c;
            case 6:
                mj<ji> mjVar = f12823d;
                if (mjVar == null) {
                    synchronized (ji.class) {
                        mjVar = f12823d;
                        if (mjVar == null) {
                            mjVar = new jx<>(f12822c);
                            f12823d = mjVar;
                        }
                    }
                }
                return mjVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        kv.a(ji.class, f12822c);
    }
}
