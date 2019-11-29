package com.otaliastudios.cameraview;

public enum am implements k {
    DEVICE_DEFAULT(0),
    H_263(1),
    H_264(2);
    

    /* renamed from: a  reason: collision with root package name */
    static final am f15557a = null;
    private int value;

    static {
        am amVar;
        f15557a = amVar;
    }

    private am(int i) {
        this.value = i;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.value;
    }

    static am a(int i) {
        for (am amVar : values()) {
            if (amVar.a() == i) {
                return amVar;
            }
        }
        return null;
    }
}
