package com.otaliastudios.cameraview;

public class p {

    /* renamed from: a  reason: collision with root package name */
    q f15662a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f15663b = null;

    /* renamed from: c  reason: collision with root package name */
    private long f15664c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f15665d = 0;

    /* renamed from: e  reason: collision with root package name */
    private af f15666e = null;

    /* renamed from: f  reason: collision with root package name */
    private int f15667f = -1;

    p(q qVar) {
        this.f15662a = qVar;
    }

    /* access modifiers changed from: package-private */
    public void a(byte[] bArr, long j, int i, af afVar, int i2) {
        this.f15663b = bArr;
        this.f15664c = j;
        this.f15665d = i;
        this.f15666e = afVar;
        this.f15667f = i2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof p) && ((p) obj).f15664c == this.f15664c;
    }

    public void a() {
        q qVar = this.f15662a;
        if (qVar != null) {
            qVar.a(this);
        }
        this.f15663b = null;
        this.f15665d = 0;
        this.f15664c = -1;
        this.f15666e = null;
        this.f15667f = -1;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f15662a = null;
    }

    public byte[] c() {
        return this.f15663b;
    }

    public long d() {
        return this.f15664c;
    }
}
