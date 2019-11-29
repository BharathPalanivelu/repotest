package com.google.android.libraries.places.internal;

import com.appsflyer.share.Constants;
import com.google.android.libraries.places.internal.kv;

/* renamed from: com.google.android.libraries.places.internal.if  reason: invalid class name */
public final class Cif extends kv<Cif, a> implements mc {

    /* renamed from: d  reason: collision with root package name */
    public static final Cif f12689d = new Cif();

    /* renamed from: f  reason: collision with root package name */
    private static volatile mj<Cif> f12690f;

    /* renamed from: a  reason: collision with root package name */
    public int f12691a;

    /* renamed from: b  reason: collision with root package name */
    public int f12692b;

    /* renamed from: c  reason: collision with root package name */
    public int f12693c;

    /* renamed from: e  reason: collision with root package name */
    private byte f12694e = 2;

    /* renamed from: com.google.android.libraries.places.internal.if$a */
    public static final class a extends kv.a<Cif, a> implements mc {
        a() {
            super(Cif.f12689d);
        }
    }

    private Cif() {
    }

    /* access modifiers changed from: protected */
    public final Object a(kv.d dVar, Object obj) {
        int i = 1;
        switch (dVar.ordinal()) {
            case 0:
                return Byte.valueOf(this.f12694e);
            case 1:
                if (obj == null) {
                    i = 0;
                }
                this.f12694e = (byte) i;
                return null;
            case 2:
                return a((ma) f12689d, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001Ԇ\u0000\u0002Ԇ\u0001", new Object[]{"a", "b", Constants.URL_CAMPAIGN});
            case 3:
                return new Cif();
            case 4:
                return new a();
            case 5:
                return f12689d;
            case 6:
                mj<Cif> mjVar = f12690f;
                if (mjVar == null) {
                    synchronized (Cif.class) {
                        mjVar = f12690f;
                        if (mjVar == null) {
                            mjVar = new jx<>(f12689d);
                            f12690f = mjVar;
                        }
                    }
                }
                return mjVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        kv.a(Cif.class, f12689d);
    }
}
