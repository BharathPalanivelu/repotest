package com.modiface.mfemakeupkit.camera;

public enum j {
    ROTATE0_NOFLIP(0, false, 0),
    ROTATE0_FLIP(1, false, 0),
    ROTATE90_NOFLIP(2, true, 90),
    ROTATE90_FLIP(3, true, 90),
    ROTATE180_NOFLIP(4, false, 180),
    ROTATE180_FLIP(5, false, 180),
    ROTATE270_NOFLIP(6, true, 270),
    ROTATE270_FLIP(7, true, 270);
    
    private final int j;
    private final boolean k;
    private final int l;

    private j(int i2, boolean z, int i3) {
        this.j = i2;
        this.k = z;
        this.l = i3;
    }

    public int a() {
        return this.l;
    }

    public boolean b() {
        return this.k;
    }

    public int getId() {
        return this.j;
    }
}
