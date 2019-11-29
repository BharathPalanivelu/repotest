package com.otaliastudios.cameraview;

public class e extends RuntimeException {
    private int reason = 0;

    e(Throwable th, int i) {
        super(th);
        this.reason = i;
    }
}
