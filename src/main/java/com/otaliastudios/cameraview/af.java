package com.otaliastudios.cameraview;

public class af implements Comparable<af> {

    /* renamed from: a  reason: collision with root package name */
    private final int f15528a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15529b;

    af(int i, int i2) {
        this.f15528a = i;
        this.f15529b = i2;
    }

    public int a() {
        return this.f15528a;
    }

    public int b() {
        return this.f15529b;
    }

    /* access modifiers changed from: package-private */
    public af c() {
        return new af(this.f15529b, this.f15528a);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof af)) {
            return false;
        }
        af afVar = (af) obj;
        if (this.f15528a == afVar.f15528a && this.f15529b == afVar.f15529b) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.f15528a + "x" + this.f15529b;
    }

    public int hashCode() {
        int i = this.f15529b;
        int i2 = this.f15528a;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    /* renamed from: a */
    public int compareTo(af afVar) {
        return (this.f15528a * this.f15529b) - (afVar.f15528a * afVar.f15529b);
    }
}
