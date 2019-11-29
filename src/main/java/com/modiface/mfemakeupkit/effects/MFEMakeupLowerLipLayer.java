package com.modiface.mfemakeupkit.effects;

import android.graphics.PointF;

public class MFEMakeupLowerLipLayer extends MFEMakeupMaskLayer {
    public float deformationAreaFactor = 1.0f;
    public PointF[] referenceLowerMouthPoints;

    public MFEMakeupLowerLipLayer() {
    }

    public MFEMakeupLowerLipLayer(MFEMakeupProduct mFEMakeupProduct) {
        super(mFEMakeupProduct);
    }
}
