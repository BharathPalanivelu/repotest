package com.otaliastudios.cameraview;

public enum n implements k {
    BACK(0),
    FRONT(1);
    

    /* renamed from: a  reason: collision with root package name */
    static final n f15660a = null;
    private int value;

    static {
        n nVar;
        f15660a = nVar;
    }

    private n(int i) {
        this.value = i;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.value;
    }

    static n a(int i) {
        for (n nVar : values()) {
            if (nVar.a() == i) {
                return nVar;
            }
        }
        return null;
    }
}
