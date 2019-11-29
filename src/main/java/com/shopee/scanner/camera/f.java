package com.shopee.scanner.camera;

public class f implements Comparable<f> {

    /* renamed from: a  reason: collision with root package name */
    private final int f30313a;

    /* renamed from: b  reason: collision with root package name */
    private final int f30314b;

    public f(int i, int i2) {
        this.f30313a = i;
        this.f30314b = i2;
    }

    public int a() {
        return this.f30313a;
    }

    public int b() {
        return this.f30314b;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f30313a == fVar.f30313a && this.f30314b == fVar.f30314b) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.f30313a + "x" + this.f30314b;
    }

    public int hashCode() {
        int i = this.f30314b;
        int i2 = this.f30313a;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    /* renamed from: a */
    public int compareTo(f fVar) {
        return (this.f30313a * this.f30314b) - (fVar.f30313a * fVar.f30314b);
    }
}
