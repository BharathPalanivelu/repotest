package com.google.android.exoplayer2;

public final class m extends IllegalStateException {
    public final long positionMs;
    public final x timeline;
    public final int windowIndex;

    public m(x xVar, int i, long j) {
        this.timeline = xVar;
        this.windowIndex = i;
        this.positionMs = j;
    }
}
