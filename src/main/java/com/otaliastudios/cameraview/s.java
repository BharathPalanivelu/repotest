package com.otaliastudios.cameraview;

import java.util.Arrays;
import java.util.List;

public enum s {
    PINCH(t.ZOOM, t.EXPOSURE_CORRECTION),
    TAP(t.FOCUS, t.FOCUS_WITH_MARKER, t.CAPTURE),
    LONG_TAP(t.FOCUS, t.FOCUS_WITH_MARKER, t.CAPTURE),
    SCROLL_HORIZONTAL(t.ZOOM, t.EXPOSURE_CORRECTION),
    SCROLL_VERTICAL(t.ZOOM, t.EXPOSURE_CORRECTION);
    
    private List<t> mControls;

    private s(t... tVarArr) {
        this.mControls = Arrays.asList(tVarArr);
    }

    /* access modifiers changed from: package-private */
    public boolean a(t tVar) {
        return tVar == t.NONE || this.mControls.contains(tVar);
    }
}
