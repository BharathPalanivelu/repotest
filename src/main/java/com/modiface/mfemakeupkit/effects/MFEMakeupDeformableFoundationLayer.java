package com.modiface.mfemakeupkit.effects;

import android.graphics.PointF;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class MFEMakeupDeformableFoundationLayer extends MFEMakeupMaskLayer {
    public float deformationAreaFactor = 1.0f;
    public float eraseBlurFactor = 1.0f;
    public float eraseExpandFactorHorizontal = 1.0f;
    public float eraseExpandFactorTop = 1.0f;
    public PointF[] referenceCheekPoints;
    public PointF[] referenceFacePoints;
    public float referenceFaceRotationX = BitmapDescriptorFactory.HUE_RED;
    public float referenceFaceRotationY = BitmapDescriptorFactory.HUE_RED;
    public float referenceFaceRotationZ = BitmapDescriptorFactory.HUE_RED;
    public PointF[] referenceForeheadPoints;
    public PointF[] referenceInnerMouthPoints;
    public boolean referenceIsMouthOpen = true;
    public PointF[] referenceLeftBrowPoints;
    public PointF[] referenceLeftExtendedBrowPoints;
    public PointF[] referenceLeftEyePoints;
    public PointF[] referenceNosePoints;
    public PointF[] referenceOuterMouthPoints;
    public PointF[] referenceRightBrowPoints;
    public PointF[] referenceRightExtendedBrowPoints;
    public PointF[] referenceRightEyePoints;

    public MFEMakeupDeformableFoundationLayer() {
    }

    public MFEMakeupDeformableFoundationLayer(MFEMakeupProduct mFEMakeupProduct) {
        super(mFEMakeupProduct);
    }
}
