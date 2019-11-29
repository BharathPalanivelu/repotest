package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.kv;

public final class ip extends kv<ip, a> implements mc {

    /* renamed from: c  reason: collision with root package name */
    public static final ip f12736c = new ip();

    /* renamed from: d  reason: collision with root package name */
    private static volatile mj<ip> f12737d;

    /* renamed from: a  reason: collision with root package name */
    public int f12738a;

    /* renamed from: b  reason: collision with root package name */
    public lc<String> f12739b = mn.f12974b;

    public static final class a extends kv.a<ip, a> implements mc {
        a() {
            super(ip.f12736c);
        }
    }

    private ip() {
    }

    /* access modifiers changed from: protected */
    public final Object a(kv.d dVar, Object obj) {
        switch (dVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return a((ma) f12736c, "\u0001\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0001\u0000\u0002\u001a", new Object[]{"a", "b"});
            case 3:
                return new ip();
            case 4:
                return new a();
            case 5:
                return f12736c;
            case 6:
                mj<ip> mjVar = f12737d;
                if (mjVar == null) {
                    synchronized (ip.class) {
                        mjVar = f12737d;
                        if (mjVar == null) {
                            mjVar = new jx<>(f12736c);
                            f12737d = mjVar;
                        }
                    }
                }
                return mjVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        kv.a(ip.class, f12736c);
    }
}
