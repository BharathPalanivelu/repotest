package androidx.core.f;

import java.util.Locale;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final c f1721a = new e((c) null, false);

    /* renamed from: b  reason: collision with root package name */
    public static final c f1722b = new e((c) null, true);

    /* renamed from: c  reason: collision with root package name */
    public static final c f1723c = new e(b.f1729a, false);

    /* renamed from: d  reason: collision with root package name */
    public static final c f1724d = new e(b.f1729a, true);

    /* renamed from: e  reason: collision with root package name */
    public static final c f1725e = new e(a.f1727a, false);

    /* renamed from: f  reason: collision with root package name */
    public static final c f1726f = f.f1732a;

    private interface c {
        int a(CharSequence charSequence, int i, int i2);
    }

    static int a(int i) {
        if (i != 0) {
            return (i == 1 || i == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i) {
        if (i != 0) {
            if (i == 1 || i == 2) {
                return 0;
            }
            switch (i) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }

    /* renamed from: androidx.core.f.d$d  reason: collision with other inner class name */
    private static abstract class C0033d implements c {

        /* renamed from: a  reason: collision with root package name */
        private final c f1730a;

        /* access modifiers changed from: protected */
        public abstract boolean a();

        C0033d(c cVar) {
            this.f1730a = cVar;
        }

        public boolean a(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            } else if (this.f1730a == null) {
                return a();
            } else {
                return b(charSequence, i, i2);
            }
        }

        private boolean b(CharSequence charSequence, int i, int i2) {
            int a2 = this.f1730a.a(charSequence, i, i2);
            if (a2 == 0) {
                return true;
            }
            if (a2 != 1) {
                return a();
            }
            return false;
        }
    }

    private static class e extends C0033d {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f1731a;

        e(c cVar, boolean z) {
            super(cVar);
            this.f1731a = z;
        }

        /* access modifiers changed from: protected */
        public boolean a() {
            return this.f1731a;
        }
    }

    private static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        static final b f1729a = new b();

        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = d.b(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }

        private b() {
        }
    }

    private static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        static final a f1727a = new a(true);

        /* renamed from: b  reason: collision with root package name */
        private final boolean f1728b;

        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            boolean z = false;
            while (i < i3) {
                int a2 = d.a(Character.getDirectionality(charSequence.charAt(i)));
                if (a2 != 0) {
                    if (a2 != 1) {
                        continue;
                        i++;
                    } else if (!this.f1728b) {
                        return 1;
                    }
                } else if (this.f1728b) {
                    return 0;
                }
                z = true;
                i++;
            }
            if (z) {
                return this.f1728b ? 1 : 0;
            }
            return 2;
        }

        private a(boolean z) {
            this.f1728b = z;
        }
    }

    private static class f extends C0033d {

        /* renamed from: a  reason: collision with root package name */
        static final f f1732a = new f();

        f() {
            super((c) null);
        }

        /* access modifiers changed from: protected */
        public boolean a() {
            return e.a(Locale.getDefault()) == 1;
        }
    }
}
