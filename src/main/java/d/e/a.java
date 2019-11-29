package d.e;

import d.a.y;
import d.b.c;

public class a implements Iterable<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final C0498a f32673a = new C0498a((g) null);

    /* renamed from: b  reason: collision with root package name */
    private final int f32674b;

    /* renamed from: c  reason: collision with root package name */
    private final int f32675c;

    /* renamed from: d  reason: collision with root package name */
    private final int f32676d;

    public a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i3 != Integer.MIN_VALUE) {
            this.f32674b = i;
            this.f32675c = c.a(i, i2, i3);
            this.f32676d = i3;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final int a() {
        return this.f32674b;
    }

    public final int b() {
        return this.f32675c;
    }

    public final int c() {
        return this.f32676d;
    }

    /* renamed from: d */
    public y iterator() {
        return new b(this.f32674b, this.f32675c, this.f32676d);
    }

    public boolean e() {
        if (this.f32676d > 0) {
            if (this.f32674b > this.f32675c) {
                return true;
            }
        } else if (this.f32674b < this.f32675c) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!e() || !((a) obj).e()) {
                a aVar = (a) obj;
                if (!(this.f32674b == aVar.f32674b && this.f32675c == aVar.f32675c && this.f32676d == aVar.f32676d)) {
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
        return (((this.f32674b * 31) + this.f32675c) * 31) + this.f32676d;
    }

    public String toString() {
        int i;
        StringBuilder sb;
        if (this.f32676d > 0) {
            sb = new StringBuilder();
            sb.append(this.f32674b);
            sb.append("..");
            sb.append(this.f32675c);
            sb.append(" step ");
            i = this.f32676d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f32674b);
            sb.append(" downTo ");
            sb.append(this.f32675c);
            sb.append(" step ");
            i = -this.f32676d;
        }
        sb.append(i);
        return sb.toString();
    }

    /* renamed from: d.e.a$a  reason: collision with other inner class name */
    public static final class C0498a {
        private C0498a() {
        }

        public /* synthetic */ C0498a(g gVar) {
            this();
        }

        public final a a(int i, int i2, int i3) {
            return new a(i, i2, i3);
        }
    }
}
