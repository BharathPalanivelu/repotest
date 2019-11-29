package com.otaliastudios.cameraview;

public enum t {
    NONE(0),
    FOCUS(1),
    FOCUS_WITH_MARKER(2),
    CAPTURE(3),
    ZOOM(4),
    EXPOSURE_CORRECTION(5);
    

    /* renamed from: a  reason: collision with root package name */
    static final t f15672a = null;

    /* renamed from: b  reason: collision with root package name */
    static final t f15673b = null;

    /* renamed from: c  reason: collision with root package name */
    static final t f15674c = null;

    /* renamed from: d  reason: collision with root package name */
    static final t f15675d = null;

    /* renamed from: e  reason: collision with root package name */
    static final t f15676e = null;
    private int value;

    static {
        t tVar;
        f15672a = tVar;
        f15673b = tVar;
        f15674c = tVar;
        f15675d = tVar;
        f15676e = tVar;
    }

    private t(int i) {
        this.value = i;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.value;
    }

    static t a(int i) {
        for (t tVar : values()) {
            if (tVar.a() == i) {
                return tVar;
            }
        }
        return null;
    }
}
