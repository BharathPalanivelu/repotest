package d.e;

public final class c extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f32681b = new a((g) null);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final c f32682c = new c(1, 0);

    public c(int i, int i2) {
        super(i, i2, 1);
    }

    public Integer f() {
        return Integer.valueOf(a());
    }

    public Integer g() {
        return Integer.valueOf(b());
    }

    public boolean e() {
        return a() > b();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!e() || !((c) obj).e()) {
                c cVar = (c) obj;
                if (!(a() == cVar.a() && b() == cVar.b())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (e()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    public String toString() {
        return a() + ".." + b();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final c a() {
            return c.f32682c;
        }
    }
}
