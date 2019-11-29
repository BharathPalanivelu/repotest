package com.google.android.libraries.places.internal;

import com.appsflyer.share.Constants;
import com.google.android.libraries.places.internal.kv;

public final class jf extends kv<jf, a> implements mc {

    /* renamed from: e  reason: collision with root package name */
    public static final jf f12810e = new jf();

    /* renamed from: f  reason: collision with root package name */
    private static volatile mj<jf> f12811f;

    /* renamed from: a  reason: collision with root package name */
    public int f12812a;

    /* renamed from: b  reason: collision with root package name */
    public int f12813b;

    /* renamed from: c  reason: collision with root package name */
    public int f12814c;

    /* renamed from: d  reason: collision with root package name */
    public jl f12815d;

    public static final class a extends kv.a<jf, a> implements mc {
        a() {
            super(jf.f12810e);
        }
    }

    private jf() {
    }

    public enum b implements ky {
        NO_RESULT(0),
        NEARBY_SEARCH(1),
        ON_DEVICE_INFERENCE(2);
        

        /* renamed from: c  reason: collision with root package name */
        public final int f12820c;

        public final int a() {
            return this.f12820c;
        }

        public static kz b() {
            return jh.f12821a;
        }

        private b(int i) {
            this.f12820c = i;
        }

        static {
            new jg();
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
                return a((ma) f12810e, "\u0001\u0003\u0000\u0001\u0002\u0004\u0003\u0000\u0000\u0000\u0002\f\u0001\u0003\u0004\u0002\u0004\t\u0003", new Object[]{"a", "b", b.b(), Constants.URL_CAMPAIGN, "d"});
            case 3:
                return new jf();
            case 4:
                return new a();
            case 5:
                return f12810e;
            case 6:
                mj<jf> mjVar = f12811f;
                if (mjVar == null) {
                    synchronized (jf.class) {
                        mjVar = f12811f;
                        if (mjVar == null) {
                            mjVar = new jx<>(f12810e);
                            f12811f = mjVar;
                        }
                    }
                }
                return mjVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        kv.a(jf.class, f12810e);
    }
}
