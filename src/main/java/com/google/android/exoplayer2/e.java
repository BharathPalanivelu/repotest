package com.google.android.exoplayer2;

import java.io.IOException;

public final class e extends Exception {
    public final int rendererIndex;
    public final int type;

    public static e a(Exception exc, int i) {
        return new e(1, (String) null, exc, i);
    }

    public static e a(IOException iOException) {
        return new e(0, (String) null, iOException, -1);
    }

    static e a(RuntimeException runtimeException) {
        return new e(2, (String) null, runtimeException, -1);
    }

    private e(int i, String str, Throwable th, int i2) {
        super(str, th);
        this.type = i;
        this.rendererIndex = i2;
    }
}
