package com.modiface.mfemakeupkit.effects;

public class MFEMakeupSplittedLipLayer extends MFEMakeupLayer {
    public MFEMakeupLayer fillLipLayer = null;
    public MFEMakeupLowerLipLayer lowerLipLayer = null;
    public MFEMakeupUpperLipLayer upperLipLayer = null;

    public MFEMakeupSplittedLipLayer() {
    }

    public MFEMakeupSplittedLipLayer(MFEMakeupProduct mFEMakeupProduct) {
        super(mFEMakeupProduct);
    }
}
