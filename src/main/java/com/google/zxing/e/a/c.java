package com.google.zxing.e.a;

abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private static final c[] f14648a = {new a(), new b(), new C0240c(), new d(), new e(), new f(), new g(), new h()};

    /* access modifiers changed from: package-private */
    public abstract boolean a(int i, int i2);

    private c() {
    }

    /* access modifiers changed from: package-private */
    public final void a(com.google.zxing.c.b bVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                if (a(i2, i3)) {
                    bVar.c(i3, i2);
                }
            }
        }
    }

    static c a(int i) {
        if (i >= 0 && i <= 7) {
            return f14648a[i];
        }
        throw new IllegalArgumentException();
    }

    private static final class a extends c {
        /* access modifiers changed from: package-private */
        public boolean a(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }

        private a() {
            super();
        }
    }

    private static final class b extends c {
        /* access modifiers changed from: package-private */
        public boolean a(int i, int i2) {
            return (i & 1) == 0;
        }

        private b() {
            super();
        }
    }

    /* renamed from: com.google.zxing.e.a.c$c  reason: collision with other inner class name */
    private static final class C0240c extends c {
        private C0240c() {
            super();
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i, int i2) {
            return i2 % 3 == 0;
        }
    }

    private static final class d extends c {
        private d() {
            super();
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i, int i2) {
            return (i + i2) % 3 == 0;
        }
    }

    private static final class e extends c {
        private e() {
            super();
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i, int i2) {
            return (((i / 2) + (i2 / 3)) & 1) == 0;
        }
    }

    private static final class f extends c {
        private f() {
            super();
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i, int i2) {
            int i3 = i * i2;
            return (i3 & 1) + (i3 % 3) == 0;
        }
    }

    private static final class g extends c {
        private g() {
            super();
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i, int i2) {
            int i3 = i * i2;
            return (((i3 & 1) + (i3 % 3)) & 1) == 0;
        }
    }

    private static final class h extends c {
        private h() {
            super();
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i, int i2) {
            return ((((i + i2) & 1) + ((i * i2) % 3)) & 1) == 0;
        }
    }
}
