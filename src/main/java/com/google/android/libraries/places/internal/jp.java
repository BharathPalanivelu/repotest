package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.kv;

public final class jp extends kv<jp, a> implements mc {

    /* renamed from: c  reason: collision with root package name */
    public static final jp f12849c = new jp();

    /* renamed from: e  reason: collision with root package name */
    private static volatile mj<jp> f12850e;

    /* renamed from: a  reason: collision with root package name */
    public int f12851a;

    /* renamed from: b  reason: collision with root package name */
    public ig f12852b;

    /* renamed from: d  reason: collision with root package name */
    private byte f12853d = 2;

    public static final class a extends kv.a<jp, a> implements mc {
        a() {
            super(jp.f12849c);
        }
    }

    private jp() {
    }

    /* access modifiers changed from: protected */
    public final Object a(kv.d dVar, Object obj) {
        int i = 1;
        switch (dVar.ordinal()) {
            case 0:
                return Byte.valueOf(this.f12853d);
            case 1:
                if (obj == null) {
                    i = 0;
                }
                this.f12853d = (byte) i;
                return null;
            case 2:
                return a((ma) f12849c, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001Љ\u0000", new Object[]{"a", "b"});
            case 3:
                return new jp();
            case 4:
                return new a();
            case 5:
                return f12849c;
            case 6:
                mj<jp> mjVar = f12850e;
                if (mjVar == null) {
                    synchronized (jp.class) {
                        mjVar = f12850e;
                        if (mjVar == null) {
                            mjVar = new jx<>(f12849c);
                            f12850e = mjVar;
                        }
                    }
                }
                return mjVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        kv.a(jp.class, f12849c);
    }
}
