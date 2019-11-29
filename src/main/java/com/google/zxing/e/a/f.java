package com.google.zxing.e.a;

public enum f {
    L(1),
    M(0),
    Q(3),
    H(2);
    

    /* renamed from: a  reason: collision with root package name */
    private static final f[] f14651a = null;
    private final int bits;

    static {
        f fVar;
        f fVar2;
        f fVar3;
        f fVar4;
        f14651a = new f[]{fVar2, fVar, fVar4, fVar3};
    }

    private f(int i) {
        this.bits = i;
    }

    public int getBits() {
        return this.bits;
    }

    public static f forBits(int i) {
        if (i >= 0) {
            f[] fVarArr = f14651a;
            if (i < fVarArr.length) {
                return fVarArr[i];
            }
        }
        throw new IllegalArgumentException();
    }
}
