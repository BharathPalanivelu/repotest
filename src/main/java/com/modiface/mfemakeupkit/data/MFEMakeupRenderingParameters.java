package com.modiface.mfemakeupkit.data;

public class MFEMakeupRenderingParameters {
    public final boolean showDebugPoints;

    public MFEMakeupRenderingParameters(boolean z) {
        this.showDebugPoints = z;
    }

    public MFEMakeupRenderingParameters clone() {
        return new MFEMakeupRenderingParameters(this.showDebugPoints);
    }
}
