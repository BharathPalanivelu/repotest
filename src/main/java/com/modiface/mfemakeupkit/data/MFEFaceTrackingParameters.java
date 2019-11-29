package com.modiface.mfemakeupkit.data;

public class MFEFaceTrackingParameters {
    public static final int NO_MAX_WIDTH = 0;
    public final int maxWidth;
    public final boolean resetTracker;

    public MFEFaceTrackingParameters(int i, boolean z) {
        this.maxWidth = i;
        this.resetTracker = z;
    }
}
