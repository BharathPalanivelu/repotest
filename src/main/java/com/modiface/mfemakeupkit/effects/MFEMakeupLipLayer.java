package com.modiface.mfemakeupkit.effects;

public class MFEMakeupLipLayer extends MFEMakeupLayer {
    public float blurFactor = 1.0f;
    public float blurFactorInner = 1.0f;

    public MFEMakeupLipLayer() {
    }

    public MFEMakeupLipLayer(MFEMakeupProduct mFEMakeupProduct) {
        super(mFEMakeupProduct);
    }
}
