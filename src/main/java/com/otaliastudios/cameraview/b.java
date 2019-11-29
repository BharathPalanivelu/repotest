package com.otaliastudios.cameraview;

public enum b implements k {
    OFF(0),
    ON(1);
    

    /* renamed from: a  reason: collision with root package name */
    static final b f15564a = null;
    private int value;

    static {
        b bVar;
        f15564a = bVar;
    }

    private b(int i) {
        this.value = i;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.value;
    }

    static b a(int i) {
        for (b bVar : values()) {
            if (bVar.a() == i) {
                return bVar;
            }
        }
        return null;
    }
}
