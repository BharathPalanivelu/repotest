package com.google.android.libraries.places.internal;

import com.appsflyer.share.Constants;
import com.google.android.libraries.places.internal.kv;

public final class ie extends kv<ie, a> implements mc {

    /* renamed from: d  reason: collision with root package name */
    public static final ie f12684d = new ie();

    /* renamed from: e  reason: collision with root package name */
    private static volatile mj<ie> f12685e;

    /* renamed from: a  reason: collision with root package name */
    public int f12686a;

    /* renamed from: b  reason: collision with root package name */
    public String f12687b = "";

    /* renamed from: c  reason: collision with root package name */
    public int f12688c;

    public static final class a extends kv.a<ie, a> implements mc {
        a() {
            super(ie.f12684d);
        }
    }

    private ie() {
    }

    /* access modifiers changed from: protected */
    public final Object a(kv.d dVar, Object obj) {
        switch (dVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return a((ma) f12684d, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\u0004\u0001", new Object[]{"a", "b", Constants.URL_CAMPAIGN});
            case 3:
                return new ie();
            case 4:
                return new a();
            case 5:
                return f12684d;
            case 6:
                mj<ie> mjVar = f12685e;
                if (mjVar == null) {
                    synchronized (ie.class) {
                        mjVar = f12685e;
                        if (mjVar == null) {
                            mjVar = new jx<>(f12684d);
                            f12685e = mjVar;
                        }
                    }
                }
                return mjVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        kv.a(ie.class, f12684d);
    }
}
