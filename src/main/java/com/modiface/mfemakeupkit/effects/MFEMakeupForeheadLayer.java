package com.modiface.mfemakeupkit.effects;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class MFEMakeupForeheadLayer extends MFEMakeupMaskLayer {
    public float eraseBlurFactor = 1.0f;
    public float eraseExpandFactorHorizontal = 1.0f;
    public float eraseExpandFactorTop = 1.0f;
    public float horizontalScale = 1.0f;
    public float verticalOffset = BitmapDescriptorFactory.HUE_RED;
    public float verticalScale = 1.0f;

    public MFEMakeupForeheadLayer() {
    }

    public MFEMakeupForeheadLayer(MFEMakeupProduct mFEMakeupProduct) {
        super(mFEMakeupProduct);
    }
}
