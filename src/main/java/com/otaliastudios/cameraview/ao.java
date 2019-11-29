package com.otaliastudios.cameraview;

public enum ao implements k {
    AUTO(0),
    INCANDESCENT(1),
    FLUORESCENT(2),
    DAYLIGHT(3),
    CLOUDY(4);
    

    /* renamed from: a  reason: collision with root package name */
    static final ao f15559a = null;
    private int value;

    static {
        ao aoVar;
        f15559a = aoVar;
    }

    private ao(int i) {
        this.value = i;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.value;
    }

    static ao a(int i) {
        for (ao aoVar : values()) {
            if (aoVar.a() == i) {
                return aoVar;
            }
        }
        return null;
    }
}
