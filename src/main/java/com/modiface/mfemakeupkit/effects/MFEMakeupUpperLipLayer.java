package com.modiface.mfemakeupkit.effects;

import android.graphics.PointF;

public class MFEMakeupUpperLipLayer extends MFEMakeupMaskLayer {
    public float deformationAreaFactor = 1.0f;
    public PointF[] referenceUpperMouthPoints;

    public MFEMakeupUpperLipLayer() {
    }

    public MFEMakeupUpperLipLayer(MFEMakeupProduct mFEMakeupProduct) {
        super(mFEMakeupProduct);
    }
}
