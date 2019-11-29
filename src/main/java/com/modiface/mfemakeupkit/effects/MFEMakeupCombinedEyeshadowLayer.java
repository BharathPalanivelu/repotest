package com.modiface.mfemakeupkit.effects;

import android.graphics.PointF;

public class MFEMakeupCombinedEyeshadowLayer extends MFEMakeupMaskLayer {
    public float deformationAreaFactor = 1.0f;
    public PointF[] referenceLeftBrowPoints;
    public PointF[] referenceLeftEyePoints;
    public PointF[] referenceRightBrowPoints;
    public PointF[] referenceRightEyePoints;

    public MFEMakeupCombinedEyeshadowLayer() {
    }

    /* access modifiers changed from: protected */
    public String getMFEClassName() {
        return "MakeupCombinedEyeShadowLayer";
    }

    public MFEMakeupCombinedEyeshadowLayer(MFEMakeupProduct mFEMakeupProduct) {
        super(mFEMakeupProduct);
    }
}
