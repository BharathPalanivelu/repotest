package com.google.android.exoplayer2;

import java.io.IOException;

public final class ac extends Exception {
    public final int rendererIndex;
    public final int type;

    public static ac a(Exception exc, int i) {
        return new ac(1, (String) null, exc, i);
    }

    public static ac a(IOException iOException) {
        return new ac(0, (String) null, iOException, -1);
    }

    static ac a(RuntimeException runtimeException) {
        return new ac(2, (String) null, runtimeException, -1);
    }

    private ac(int i, String str, Throwable th, int i2) {
        super(str, th);
        this.type = i;
        this.rendererIndex = i2;
    }
}
