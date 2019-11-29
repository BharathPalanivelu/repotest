package com.google.android.libraries.places.internal;

import com.appsflyer.share.Constants;
import com.google.android.libraries.places.internal.kv;

public final class ik extends kv<ik, a> implements mc {
    public static final ik h = new ik();
    private static volatile mj<ik> i;

    /* renamed from: a  reason: collision with root package name */
    public int f12714a;

    /* renamed from: b  reason: collision with root package name */
    public int f12715b;

    /* renamed from: c  reason: collision with root package name */
    public int f12716c;

    /* renamed from: d  reason: collision with root package name */
    public int f12717d;

    /* renamed from: e  reason: collision with root package name */
    public ij f12718e;

    /* renamed from: f  reason: collision with root package name */
    public ih f12719f;

    /* renamed from: g  reason: collision with root package name */
    public ii f12720g;

    public static final class a extends kv.a<ik, a> implements mc {
        a() {
            super(ik.h);
        }

        public final a a(b bVar) {
            b();
            ik ikVar = (ik) this.f12904a;
            if (bVar != null) {
                ikVar.f12714a |= 1;
                ikVar.f12715b = bVar.f12727e;
                return this;
            }
            throw new NullPointerException();
        }

        public final a a(c cVar) {
            b();
            ik ikVar = (ik) this.f12904a;
            if (cVar != null) {
                ikVar.f12714a |= 2;
                ikVar.f12716c = cVar.f12733e;
                return this;
            }
            throw new NullPointerException();
        }

        public final a a(int i) {
            b();
            ik ikVar = (ik) this.f12904a;
            ikVar.f12714a |= 4;
            ikVar.f12717d = i;
            return this;
        }
    }

    private ik() {
    }

    public enum b implements ky {
        UNDEFINED(0),
        ADD_PLACE(1),
        DELETE_ALIAS(2),
        ESTIMATE_PLACES_BY_LOCATION(3),
        GET_ALIASES(4),
        GET_AUTOCOMPLETE_PREDICTIONS(5),
        GET_NEARBY_ALERT_DATA_BY_ID(6),
        GET_PLACE_BY_ID(7),
        GET_PLACE_PHOTO_METADATA(8),
        SEARCH(9),
        SEARCH_BY_BEACON(10),
        SEARCH_BY_CHAIN(11),
        WRITE_ALIAS(12),
        SEARCH_BY_CLIENT(13),
        GET_PHOTO(14),
        SNAP_TO_PLACE(15);
        

        /* renamed from: e  reason: collision with root package name */
        public final int f12727e;

        public final int a() {
            return this.f12727e;
        }

        public static kz b() {
            return im.f12734a;
        }

        private b(int i) {
            this.f12727e = i;
        }

        static {
            new il();
        }
    }

    public enum c implements ky {
        INVALID(0),
        SUCCESS(1),
        TIMEOUT(2),
        NETWORK_ERROR(3);
        

        /* renamed from: e  reason: collision with root package name */
        public final int f12733e;

        public final int a() {
            return this.f12733e;
        }

        public static kz b() {
            return io.f12735a;
        }

        private c(int i) {
            this.f12733e = i;
        }

        static {
            new in();
        }
    }

    public static a a() {
        return (a) h.f();
    }

    /* access modifiers changed from: protected */
    public final Object a(kv.d dVar, Object obj) {
        switch (dVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return a((ma) h, "\u0001\u0006\u0000\u0001\u0001\n\u0006\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\u0004\u0002\u0006\t\u0005\b\t\u0007\n\t\t", new Object[]{"a", "b", b.b(), Constants.URL_CAMPAIGN, c.b(), "d", "e", "f", "g"});
            case 3:
                return new ik();
            case 4:
                return new a();
            case 5:
                return h;
            case 6:
                mj<ik> mjVar = i;
                if (mjVar == null) {
                    synchronized (ik.class) {
                        mjVar = i;
                        if (mjVar == null) {
                            mjVar = new jx<>(h);
                            i = mjVar;
                        }
                    }
                }
                return mjVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        kv.a(ik.class, h);
    }
}
