package com.google.android.libraries.places.internal;

import com.appsflyer.share.Constants;
import com.google.android.libraries.places.internal.kv;

public final class is extends kv<is, a> implements mc {

    /* renamed from: d  reason: collision with root package name */
    public static final is f12750d = new is();

    /* renamed from: f  reason: collision with root package name */
    private static volatile mj<is> f12751f;

    /* renamed from: a  reason: collision with root package name */
    public int f12752a;

    /* renamed from: b  reason: collision with root package name */
    public ig f12753b;

    /* renamed from: c  reason: collision with root package name */
    public ip f12754c;

    /* renamed from: e  reason: collision with root package name */
    private byte f12755e = 2;

    public static final class a extends kv.a<is, a> implements mc {
        a() {
            super(is.f12750d);
        }
    }

    private is() {
    }

    /* access modifiers changed from: protected */
    public final Object a(kv.d dVar, Object obj) {
        int i = 1;
        switch (dVar.ordinal()) {
            case 0:
                return Byte.valueOf(this.f12755e);
            case 1:
                if (obj == null) {
                    i = 0;
                }
                this.f12755e = (byte) i;
                return null;
            case 2:
                return a((ma) f12750d, "\u0001\u0002\u0000\u0001\u0002\u0003\u0002\u0000\u0000\u0001\u0002Љ\u0001\u0003\t\u0002", new Object[]{"a", "b", Constants.URL_CAMPAIGN});
            case 3:
                return new is();
            case 4:
                return new a();
            case 5:
                return f12750d;
            case 6:
                mj<is> mjVar = f12751f;
                if (mjVar == null) {
                    synchronized (is.class) {
                        mjVar = f12751f;
                        if (mjVar == null) {
                            mjVar = new jx<>(f12750d);
                            f12751f = mjVar;
                        }
                    }
                }
                return mjVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        kv.a(is.class, f12750d);
    }
}
