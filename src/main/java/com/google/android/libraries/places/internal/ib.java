package com.google.android.libraries.places.internal;

import com.appsflyer.share.Constants;
import com.google.android.libraries.places.internal.kv;

public final class ib extends kv<ib, a> implements mc {

    /* renamed from: d  reason: collision with root package name */
    public static final ib f12670d = new ib();

    /* renamed from: f  reason: collision with root package name */
    private static volatile mj<ib> f12671f;

    /* renamed from: a  reason: collision with root package name */
    public int f12672a;

    /* renamed from: b  reason: collision with root package name */
    public int f12673b = 1;

    /* renamed from: c  reason: collision with root package name */
    public iy f12674c;

    /* renamed from: e  reason: collision with root package name */
    private byte f12675e = 2;

    public static final class a extends kv.a<ib, a> implements mc {
        a() {
            super(ib.f12670d);
        }
    }

    private ib() {
    }

    public enum b implements ky {
        PLACES(1),
        ENGINE_STATS(2),
        USER_CONFIG(3),
        PLACE_INFERENCE(4),
        FLP(5),
        GEOCODER_STATS(6),
        DIALOGS(7),
        CHRE(8),
        FOP(9),
        GEOFENCER(10),
        RE_UP(11),
        NANOAPP(12);
        

        /* renamed from: b  reason: collision with root package name */
        public final int f12682b;

        public final int a() {
            return this.f12682b;
        }

        public static kz b() {
            return id.f12683a;
        }

        private b(int i) {
            this.f12682b = i;
        }

        static {
            new ic();
        }
    }

    /* access modifiers changed from: protected */
    public final Object a(kv.d dVar, Object obj) {
        int i = 1;
        switch (dVar.ordinal()) {
            case 0:
                return Byte.valueOf(this.f12675e);
            case 1:
                if (obj == null) {
                    i = 0;
                }
                this.f12675e = (byte) i;
                return null;
            case 2:
                return a((ma) f12670d, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001\f\u0000\u0002Љ\u0001", new Object[]{"a", "b", b.b(), Constants.URL_CAMPAIGN});
            case 3:
                return new ib();
            case 4:
                return new a();
            case 5:
                return f12670d;
            case 6:
                mj<ib> mjVar = f12671f;
                if (mjVar == null) {
                    synchronized (ib.class) {
                        mjVar = f12671f;
                        if (mjVar == null) {
                            mjVar = new jx<>(f12670d);
                            f12671f = mjVar;
                        }
                    }
                }
                return mjVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        kv.a(ib.class, f12670d);
    }
}
