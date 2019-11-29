package com.google.android.libraries.places.internal;

import com.appsflyer.share.Constants;
import com.google.android.libraries.places.internal.kv;

public final class iy extends kv<iy, a> implements mc {
    public static final iy o = new iy();
    private static volatile mj<iy> s;

    /* renamed from: a  reason: collision with root package name */
    public int f12776a;

    /* renamed from: b  reason: collision with root package name */
    public int f12777b = 1;

    /* renamed from: c  reason: collision with root package name */
    public ie f12778c;

    /* renamed from: d  reason: collision with root package name */
    public Cif f12779d;

    /* renamed from: e  reason: collision with root package name */
    public jm f12780e;

    /* renamed from: f  reason: collision with root package name */
    public iq f12781f;

    /* renamed from: g  reason: collision with root package name */
    public ji f12782g;
    public jf h;
    public it i;
    public ik j;
    public boolean k;
    public String l = "";
    public String m = "";
    public int n;
    private byte p = 2;

    public static final class a extends kv.a<iy, a> implements mc {
        a() {
            super(iy.o);
        }

        public final a a(b bVar) {
            b();
            iy iyVar = (iy) this.f12904a;
            if (bVar != null) {
                iyVar.f12776a |= 2;
                iyVar.f12777b = bVar.f12789f;
                return this;
            }
            throw new NullPointerException();
        }

        public final a a(jm jmVar) {
            b();
            iy iyVar = (iy) this.f12904a;
            if (jmVar != null) {
                iyVar.f12780e = jmVar;
                iyVar.f12776a |= 64;
                return this;
            }
            throw new NullPointerException();
        }

        public final a a(String str) {
            b();
            iy iyVar = (iy) this.f12904a;
            if (str != null) {
                iyVar.f12776a |= 33554432;
                iyVar.l = str;
                return this;
            }
            throw new NullPointerException();
        }
    }

    private iy() {
    }

    public enum b implements ky {
        PLACES_QUERY(1),
        PLACE_OBJECT_ACCESS(2),
        PLACE_REPORT(3),
        PLACE_PICKER_RESULT(4),
        PLACE_PHOTO_QUERY(5),
        GET_CURRENT_PLACE(6),
        NEARBY_ALERT_REQUEST(7),
        NEARBY_ALERT(8),
        PLACE_UPDATE_REQUEST(9),
        AUTOCOMPLETE_WIDGET_SESSION(10),
        GEOFENCE_STATUS(11),
        SERVER_RESPONSE(12),
        COUNT_OPERATION(13),
        PLACES_BOUNDS_REFRESH(14),
        HAS_PERSONALIZED_DATA_ACCESS(15),
        NETWORK_REQUEST_EVENT(16),
        SEMANTIC_LOCATION_PROVIDER_EVENT(17);
        

        /* renamed from: f  reason: collision with root package name */
        public final int f12789f;

        public final int a() {
            return this.f12789f;
        }

        public static kz b() {
            return ja.f12799a;
        }

        private b(int i) {
            this.f12789f = i;
        }

        static {
            new iz();
        }
    }

    public enum c implements ky {
        UNKNOWN_SOURCE(0),
        PROGRAMMATIC_API(1),
        PLACE_PICKER(2),
        AUTOCOMPLETE_WIDGET(3);
        

        /* renamed from: d  reason: collision with root package name */
        public final int f12795d;

        public final int a() {
            return this.f12795d;
        }

        public static kz b() {
            return jc.f12800a;
        }

        private c(int i) {
            this.f12795d = i;
        }

        static {
            new jb();
        }
    }

    /* access modifiers changed from: protected */
    public final Object a(kv.d dVar, Object obj) {
        int i2 = 1;
        switch (dVar.ordinal()) {
            case 0:
                return Byte.valueOf(this.p);
            case 1:
                if (obj == null) {
                    i2 = 0;
                }
                this.p = (byte) i2;
                return null;
            case 2:
                return a((ma) o, "\u0001\r\u0000\u0001\u0001 \r\u0000\u0000\u0003\u0001\f\u0001\u0002\t\u0002\u0003Љ\u0003\u0005Љ\u0006\bЉ\b\f\t\t\u000e\t\n\u0012\t\u000e\u0018\t\u0017\u001b\u0007\u0018\u001c\b\u0019\u001e\b\u001b \f\u001d", new Object[]{"a", "b", b.b(), Constants.URL_CAMPAIGN, "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", c.b()});
            case 3:
                return new iy();
            case 4:
                return new a();
            case 5:
                return o;
            case 6:
                mj<iy> mjVar = s;
                if (mjVar == null) {
                    synchronized (iy.class) {
                        mjVar = s;
                        if (mjVar == null) {
                            mjVar = new jx<>(o);
                            s = mjVar;
                        }
                    }
                }
                return mjVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        kv.a(iy.class, o);
    }
}
