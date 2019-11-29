package com.modiface.mfemakeupkit.effects;

import android.graphics.PointF;

public class MFEMakeupLipMaskLayer extends MFEMakeupMaskLayer {
    public float deformationAreaFactor = 1.0f;
    public PointF[] referenceInnerMouthPoints;
    public PointF[] referenceOuterMouthPoints;

    public MFEMakeupLipMaskLayer() {
    }

    public MFEMakeupLipMaskLayer(MFEMakeupProduct mFEMakeupProduct) {
        super(mFEMakeupProduct);
    }
}
