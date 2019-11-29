package com.otaliastudios.cameraview;

public enum o implements k {
    OFF(0),
    ON(1),
    AUTO(2),
    TORCH(3);
    

    /* renamed from: a  reason: collision with root package name */
    static final o f15661a = null;
    private int value;

    static {
        o oVar;
        f15661a = oVar;
    }

    private o(int i) {
        this.value = i;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.value;
    }

    static o a(int i) {
        for (o oVar : values()) {
            if (oVar.a() == i) {
                return oVar;
            }
        }
        return null;
    }
}
