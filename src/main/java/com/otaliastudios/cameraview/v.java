package com.otaliastudios.cameraview;

public enum v implements k {
    OFF(0),
    DRAW_3X3(1),
    DRAW_4X4(2),
    DRAW_PHI(3);
    

    /* renamed from: a  reason: collision with root package name */
    static final v f15680a = null;
    private int value;

    static {
        v vVar;
        f15680a = vVar;
    }

    private v(int i) {
        this.value = i;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.value;
    }

    static v a(int i) {
        for (v vVar : values()) {
            if (vVar.a() == i) {
                return vVar;
            }
        }
        return null;
    }
}
