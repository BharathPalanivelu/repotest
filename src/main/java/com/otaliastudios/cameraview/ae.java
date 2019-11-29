package com.otaliastudios.cameraview;

public enum ae implements k {
    PICTURE(0),
    VIDEO(1);
    

    /* renamed from: a  reason: collision with root package name */
    static final ae f15527a = null;
    private int value;

    static {
        ae aeVar;
        f15527a = aeVar;
    }

    private ae(int i) {
        this.value = i;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.value;
    }

    static ae a(int i) {
        for (ae aeVar : values()) {
            if (aeVar.a() == i) {
                return aeVar;
            }
        }
        return null;
    }
}
