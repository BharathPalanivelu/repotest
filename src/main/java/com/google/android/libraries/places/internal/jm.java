package com.google.android.libraries.places.internal;

import com.appsflyer.share.Constants;
import com.google.android.libraries.places.internal.kv;

public final class jm extends kv<jm, a> implements mc {
    public static final jm j = new jm();
    private static volatile mj<jm> l;

    /* renamed from: a  reason: collision with root package name */
    public int f12834a;

    /* renamed from: b  reason: collision with root package name */
    public int f12835b;

    /* renamed from: c  reason: collision with root package name */
    public String f12836c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f12837d = "";

    /* renamed from: e  reason: collision with root package name */
    public jp f12838e;

    /* renamed from: f  reason: collision with root package name */
    public je f12839f;

    /* renamed from: g  reason: collision with root package name */
    public ir f12840g;
    public jd h;
    public is i;
    private byte k = 2;

    public static final class a extends kv.a<jm, a> implements mc {
        a() {
            super(jm.j);
        }

        public final a a(b bVar) {
            b();
            jm jmVar = (jm) this.f12904a;
            if (bVar != null) {
                jmVar.f12834a |= 1;
                jmVar.f12835b = bVar.f12847c;
                return this;
            }
            throw new NullPointerException();
        }
    }

    private jm() {
    }

    public enum b implements ky {
        UNKNOWN(0),
        SEARCH(1),
        BY_LATLNG(2),
        ADD_A_PLACE(3),
        BY_ID(4),
        AUTOCOMPLETE(5),
        GET_ALIASES(6),
        SET_ALIAS(7),
        GET_BY_LOCATION(8),
        DELETE_ALIAS(9),
        SEARCH_BY_BEACON(10),
        SEARCH_BY_CHAIN(11),
        NEARBY_ALERTS_RADIUS_REQUEST(12),
        GET_USER_PLACES(13),
        SEARCH_BY_CLIENT(14);
        

        /* renamed from: c  reason: collision with root package name */
        public final int f12847c;

        public final int a() {
            return this.f12847c;
        }

        public static kz b() {
            return jo.f12848a;
        }

        private b(int i) {
            this.f12847c = i;
        }

        static {
            new jn();
        }
    }

    /* access modifiers changed from: protected */
    public final Object a(kv.d dVar, Object obj) {
        int i2 = 1;
        switch (dVar.ordinal()) {
            case 0:
                return Byte.valueOf(this.k);
            case 1:
                if (obj == null) {
                    i2 = 0;
                }
                this.k = (byte) i2;
                return null;
            case 2:
                return a((ma) j, "\u0001\b\u0000\u0001\u0001\t\b\u0000\u0000\u0004\u0001\f\u0000\u0002\b\u0001\u0003\b\u0002\u0005Љ\u0004\u0006Љ\u0005\u0007Љ\u0006\b\t\u0007\tЉ\b", new Object[]{"a", "b", b.b(), Constants.URL_CAMPAIGN, "d", "e", "f", "g", "h", "i"});
            case 3:
                return new jm();
            case 4:
                return new a();
            case 5:
                return j;
            case 6:
                mj<jm> mjVar = l;
                if (mjVar == null) {
                    synchronized (jm.class) {
                        mjVar = l;
                        if (mjVar == null) {
                            mjVar = new jx<>(j);
                            l = mjVar;
                        }
                    }
                }
                return mjVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        kv.a(jm.class, j);
    }
}
