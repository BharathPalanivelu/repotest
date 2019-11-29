package com.android.b;

public class d implements p {

    /* renamed from: a  reason: collision with root package name */
    private int f4596a;

    /* renamed from: b  reason: collision with root package name */
    private int f4597b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4598c;

    /* renamed from: d  reason: collision with root package name */
    private final float f4599d;

    public d() {
        this(2500, 1, 1.0f);
    }

    public d(int i, int i2, float f2) {
        this.f4596a = i;
        this.f4598c = i2;
        this.f4599d = f2;
    }

    public int a() {
        return this.f4596a;
    }

    public int b() {
        return this.f4597b;
    }

    public void a(s sVar) throws s {
        this.f4597b++;
        int i = this.f4596a;
        this.f4596a = (int) (((float) i) + (((float) i) * this.f4599d));
        if (!c()) {
            throw sVar;
        }
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        return this.f4597b <= this.f4598c;
    }
}
