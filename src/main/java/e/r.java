package e;

final class r {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f32781a;

    /* renamed from: b  reason: collision with root package name */
    int f32782b;

    /* renamed from: c  reason: collision with root package name */
    int f32783c;

    /* renamed from: d  reason: collision with root package name */
    boolean f32784d;

    /* renamed from: e  reason: collision with root package name */
    boolean f32785e;

    /* renamed from: f  reason: collision with root package name */
    r f32786f;

    /* renamed from: g  reason: collision with root package name */
    r f32787g;

    r() {
        this.f32781a = new byte[8192];
        this.f32785e = true;
        this.f32784d = false;
    }

    r(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f32781a = bArr;
        this.f32782b = i;
        this.f32783c = i2;
        this.f32784d = z;
        this.f32785e = z2;
    }

    /* access modifiers changed from: package-private */
    public final r a() {
        this.f32784d = true;
        return new r(this.f32781a, this.f32782b, this.f32783c, true, false);
    }

    /* access modifiers changed from: package-private */
    public final r b() {
        return new r((byte[]) this.f32781a.clone(), this.f32782b, this.f32783c, false, true);
    }

    public final r c() {
        r rVar = this.f32786f;
        if (rVar == this) {
            rVar = null;
        }
        r rVar2 = this.f32787g;
        rVar2.f32786f = this.f32786f;
        this.f32786f.f32787g = rVar2;
        this.f32786f = null;
        this.f32787g = null;
        return rVar;
    }

    public final r a(r rVar) {
        rVar.f32787g = this;
        rVar.f32786f = this.f32786f;
        this.f32786f.f32787g = rVar;
        this.f32786f = rVar;
        return rVar;
    }

    public final r a(int i) {
        r rVar;
        if (i <= 0 || i > this.f32783c - this.f32782b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            rVar = a();
        } else {
            rVar = s.a();
            System.arraycopy(this.f32781a, this.f32782b, rVar.f32781a, 0, i);
        }
        rVar.f32783c = rVar.f32782b + i;
        this.f32782b += i;
        this.f32787g.a(rVar);
        return rVar;
    }

    public final void d() {
        r rVar = this.f32787g;
        if (rVar == this) {
            throw new IllegalStateException();
        } else if (rVar.f32785e) {
            int i = this.f32783c - this.f32782b;
            if (i <= (8192 - rVar.f32783c) + (rVar.f32784d ? 0 : rVar.f32782b)) {
                a(this.f32787g, i);
                c();
                s.a(this);
            }
        }
    }

    public final void a(r rVar, int i) {
        if (rVar.f32785e) {
            int i2 = rVar.f32783c;
            if (i2 + i > 8192) {
                if (!rVar.f32784d) {
                    int i3 = rVar.f32782b;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = rVar.f32781a;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        rVar.f32783c -= rVar.f32782b;
                        rVar.f32782b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f32781a, this.f32782b, rVar.f32781a, rVar.f32783c, i);
            rVar.f32783c += i;
            this.f32782b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
