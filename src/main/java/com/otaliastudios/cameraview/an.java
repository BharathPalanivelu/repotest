package com.otaliastudios.cameraview;

public enum an implements k {
    LOWEST(0),
    HIGHEST(1),
    MAX_QVGA(2),
    MAX_480P(3),
    MAX_720P(4),
    MAX_1080P(5),
    MAX_2160P(6);
    

    /* renamed from: a  reason: collision with root package name */
    static final an f15558a = null;
    private int value;

    static {
        an anVar;
        f15558a = anVar;
    }

    private an(int i) {
        this.value = i;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.value;
    }

    static an a(int i) {
        for (an anVar : values()) {
            if (anVar.a() == i) {
                return anVar;
            }
        }
        return null;
    }
}
