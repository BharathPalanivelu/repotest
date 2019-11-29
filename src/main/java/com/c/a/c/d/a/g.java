package com.c.a.c.d.a;

public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f6005a = new e();

    /* renamed from: b  reason: collision with root package name */
    public static final g f6006b = new d();

    /* renamed from: c  reason: collision with root package name */
    public static final g f6007c = new a();

    /* renamed from: d  reason: collision with root package name */
    public static final g f6008d = new b();

    /* renamed from: e  reason: collision with root package name */
    public static final g f6009e = new c();

    /* renamed from: f  reason: collision with root package name */
    public static final g f6010f = new f();

    /* renamed from: g  reason: collision with root package name */
    public static final g f6011g = f6006b;

    /* renamed from: com.c.a.c.d.a.g$g  reason: collision with other inner class name */
    public enum C0106g {
        MEMORY,
        QUALITY
    }

    public abstract float a(int i, int i2, int i3, int i4);

    public abstract C0106g b(int i, int i2, int i3, int i4);

    private static class e extends g {
        e() {
        }

        public float a(int i, int i2, int i3, int i4) {
            return Math.min(((float) i3) / ((float) i), ((float) i4) / ((float) i2));
        }

        public C0106g b(int i, int i2, int i3, int i4) {
            return C0106g.QUALITY;
        }
    }

    private static class d extends g {
        d() {
        }

        public float a(int i, int i2, int i3, int i4) {
            return Math.max(((float) i3) / ((float) i), ((float) i4) / ((float) i2));
        }

        public C0106g b(int i, int i2, int i3, int i4) {
            return C0106g.QUALITY;
        }
    }

    private static class a extends g {
        a() {
        }

        public float a(int i, int i2, int i3, int i4) {
            int min = Math.min(i2 / i4, i / i3);
            if (min == 0) {
                return 1.0f;
            }
            return 1.0f / ((float) Integer.highestOneBit(min));
        }

        public C0106g b(int i, int i2, int i3, int i4) {
            return C0106g.QUALITY;
        }
    }

    private static class b extends g {
        b() {
        }

        public float a(int i, int i2, int i3, int i4) {
            int ceil = (int) Math.ceil((double) Math.max(((float) i2) / ((float) i4), ((float) i) / ((float) i3)));
            int i5 = 1;
            int max = Math.max(1, Integer.highestOneBit(ceil));
            if (max >= ceil) {
                i5 = 0;
            }
            return 1.0f / ((float) (max << i5));
        }

        public C0106g b(int i, int i2, int i3, int i4) {
            return C0106g.MEMORY;
        }
    }

    private static class f extends g {
        public float a(int i, int i2, int i3, int i4) {
            return 1.0f;
        }

        f() {
        }

        public C0106g b(int i, int i2, int i3, int i4) {
            return C0106g.QUALITY;
        }
    }

    private static class c extends g {
        c() {
        }

        public float a(int i, int i2, int i3, int i4) {
            return Math.min(1.0f, f6005a.a(i, i2, i3, i4));
        }

        public C0106g b(int i, int i2, int i3, int i4) {
            return C0106g.QUALITY;
        }
    }
}
