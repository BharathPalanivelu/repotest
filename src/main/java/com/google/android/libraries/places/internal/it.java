package com.google.android.libraries.places.internal;

import com.appsflyer.share.Constants;
import com.google.android.libraries.places.internal.kv;

public final class it extends kv<it, b> implements mc {
    public static final it p = new it();
    private static volatile mj<it> s;

    /* renamed from: a  reason: collision with root package name */
    public int f12756a;

    /* renamed from: b  reason: collision with root package name */
    public int f12757b;

    /* renamed from: c  reason: collision with root package name */
    public int f12758c = 1;

    /* renamed from: d  reason: collision with root package name */
    public boolean f12759d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12760e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12761f;

    /* renamed from: g  reason: collision with root package name */
    public int f12762g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public int o;

    public static final class b extends kv.a<it, b> implements mc {
        b() {
            super(it.p);
        }

        public final b a(c cVar) {
            b();
            it itVar = (it) this.f12904a;
            if (cVar != null) {
                itVar.f12756a |= 1;
                itVar.f12757b = cVar.f12773d;
                return this;
            }
            throw new NullPointerException();
        }

        public final b a(a aVar) {
            b();
            it itVar = (it) this.f12904a;
            if (aVar != null) {
                itVar.f12756a |= 2;
                itVar.f12758c = aVar.f12766c;
                return this;
            }
            throw new NullPointerException();
        }
    }

    private it() {
    }

    public enum a implements ky {
        OVERLAY(1),
        FULLSCREEN(2);
        

        /* renamed from: c  reason: collision with root package name */
        public final int f12766c;

        public final int a() {
            return this.f12766c;
        }

        public static kz b() {
            return iv.f12774a;
        }

        private a(int i) {
            this.f12766c = i;
        }

        static {
            new iu();
        }
    }

    public enum c implements ky {
        UNKNOWN_ORIGIN(0),
        ANDROID_AUTOCOMPLETE_FRAGMENT(1),
        ANDROID_AUTOCOMPLETE_MANUAL_LAUNCHER(2),
        ANDROID_PLACE_PICKER(3),
        ANDROID_ADAPTER(4),
        IOS_AUTOCOMPLETE_VIEW_CONTROLLER(5),
        IOS_AUTOCOMPLETE_SEARCH_CONTROLLER(6),
        IOS_AUTOCOMPLETE_DATA_SOURCE(7),
        IOS_PLACE_PICKER(8);
        

        /* renamed from: d  reason: collision with root package name */
        public final int f12773d;

        public final int a() {
            return this.f12773d;
        }

        public static kz b() {
            return ix.f12775a;
        }

        private c(int i) {
            this.f12773d = i;
        }

        static {
            new iw();
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
                return a((ma) p, "\u0001\u000e\u0000\u0001\u0001\u000f\u000e\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\u0007\u0002\u0004\u0007\u0003\u0005\u0007\u0004\u0006\u000b\u0005\u0007\u000b\u0006\b\u000b\u0007\n\u000b\t\u000b\u000b\n\f\u000b\u000b\r\u0007\f\u000e\u000b\r\u000f\u000b\b", new Object[]{"a", "b", c.b(), Constants.URL_CAMPAIGN, a.b(), "d", "e", "f", "g", "h", "i", "k", "l", "m", "n", "o", "j"});
            case 3:
                return new it();
            case 4:
                return new b();
            case 5:
                return p;
            case 6:
                mj<it> mjVar = s;
                if (mjVar == null) {
                    synchronized (it.class) {
                        mjVar = s;
                        if (mjVar == null) {
                            mjVar = new jx<>(p);
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
        kv.a(it.class, p);
    }
}
