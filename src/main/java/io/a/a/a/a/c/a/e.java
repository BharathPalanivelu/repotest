package io.a.a.a.a.c.a;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final int f33135a;

    /* renamed from: b  reason: collision with root package name */
    private final a f33136b;

    /* renamed from: c  reason: collision with root package name */
    private final d f33137c;

    public e(a aVar, d dVar) {
        this(0, aVar, dVar);
    }

    public e(int i, a aVar, d dVar) {
        this.f33135a = i;
        this.f33136b = aVar;
        this.f33137c = dVar;
    }

    public long a() {
        return this.f33136b.a(this.f33135a);
    }

    public e b() {
        return new e(this.f33135a + 1, this.f33136b, this.f33137c);
    }

    public e c() {
        return new e(this.f33136b, this.f33137c);
    }
}
