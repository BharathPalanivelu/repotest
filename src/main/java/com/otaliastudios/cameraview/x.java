package com.otaliastudios.cameraview;

public enum x implements k {
    OFF(0),
    ON(1);
    

    /* renamed from: a  reason: collision with root package name */
    static final x f15687a = null;
    private int value;

    static {
        x xVar;
        f15687a = xVar;
    }

    private x(int i) {
        this.value = i;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.value;
    }

    static x a(int i) {
        for (x xVar : values()) {
            if (xVar.a() == i) {
                return xVar;
            }
        }
        return null;
    }
}
