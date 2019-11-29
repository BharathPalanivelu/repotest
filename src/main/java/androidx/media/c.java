package androidx.media;

import java.util.Arrays;

class c implements a {

    /* renamed from: a  reason: collision with root package name */
    int f2660a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f2661b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f2662c = 0;

    /* renamed from: d  reason: collision with root package name */
    int f2663d = -1;

    c() {
    }

    public int a() {
        int i = this.f2663d;
        if (i != -1) {
            return i;
        }
        return AudioAttributesCompat.a(false, this.f2662c, this.f2660a);
    }

    public int b() {
        return this.f2661b;
    }

    public int c() {
        return this.f2660a;
    }

    public int d() {
        int i = this.f2662c;
        int a2 = a();
        if (a2 == 6) {
            i |= 4;
        } else if (a2 == 7) {
            i |= 1;
        }
        return i & 273;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2661b), Integer.valueOf(this.f2662c), Integer.valueOf(this.f2660a), Integer.valueOf(this.f2663d)});
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f2661b == cVar.b() && this.f2662c == cVar.d() && this.f2660a == cVar.c() && this.f2663d == cVar.f2663d) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f2663d != -1) {
            sb.append(" stream=");
            sb.append(this.f2663d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.a(this.f2660a));
        sb.append(" content=");
        sb.append(this.f2661b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f2662c).toUpperCase());
        return sb.toString();
    }
}
