package com.modiface.mfemakeupkit.effects;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;

public class MFEMakeupLook {
    private static final String TAG = "MFEMakeupLook";
    public ArrayList<MFEMakeupBlushLayer> blushLayers = new ArrayList<>();
    public MFEMakeupLayer browLayer = null;
    public MFEMakeupCombinedEyeshadowLayer combinedEyeshadowLayer = null;
    public MFEMakeupConcealerLayer concealerLayer = null;
    public ArrayList<MFEMakeupDeformableFoundationLayer> deformableFoundationLayers = new ArrayList<>();
    public float eyeEraseExpandFactorBottom = 0.9f;
    public float eyeEraseExpandFactorInner = 0.9f;
    public float eyeEraseExpandFactorOuter = 0.9f;
    public float eyeEraseExpandFactorTop = 0.9f;
    public float eyeHeightEnlarge = BitmapDescriptorFactory.HUE_RED;
    public ArrayList<MFEMakeupEyeLinerLayer> eyeLinerLayers = new ArrayList<>();
    public ArrayList<MFEMakeupEyeshadowLayer> eyeShadowLayers = new ArrayList<>();
    public float eyeWidthEnlarge = BitmapDescriptorFactory.HUE_RED;
    public MFEMakeupForeheadLayer foreheadLayer = null;
    public MFEMakeupLayer foundationLayer = null;
    public MFEMakeupLayer innerLipLayer = null;
    public float intensity = 1.0f;
    public float jawSlimming = BitmapDescriptorFactory.HUE_RED;
    public MFEMakeupLayer lipLayer = null;
    public MFEMakeupLayer lipLinerLayer = null;
    public ArrayList<MFEMakeupMascaraLayer> mascaraLayers = new ArrayList<>();
    public float noseBridgeThinning = BitmapDescriptorFactory.HUE_RED;
    public float nostrilThinning = BitmapDescriptorFactory.HUE_RED;
    public boolean shouldApplySkinEffectsToBaseLook = false;
    public float skinClearingAmount = BitmapDescriptorFactory.HUE_RED;
    public float skinGlowAmount = BitmapDescriptorFactory.HUE_RED;
    public float skinWhiteningAmount = BitmapDescriptorFactory.HUE_RED;

    private int getBlushCount() {
        return this.blushLayers.size();
    }

    private MFEMakeupBlushLayer getBlushLayer(int i) {
        if (i < 0 || i >= this.blushLayers.size()) {
            return null;
        }
        return this.blushLayers.get(i);
    }

    private int getEyelinerCount() {
        return this.eyeLinerLayers.size();
    }

    private MFEMakeupEyeLinerLayer getEyelinerLayer(int i) {
        if (i < 0 || i >= this.eyeLinerLayers.size()) {
            return null;
        }
        return this.eyeLinerLayers.get(i);
    }

    private int getEyeshadowCount() {
        return this.eyeShadowLayers.size();
    }

    private MFEMakeupEyeshadowLayer getEyeshadowLayer(int i) {
        if (i < 0 || i >= this.eyeShadowLayers.size()) {
            return null;
        }
        return this.eyeShadowLayers.get(i);
    }

    private int getMascaraCount() {
        return this.mascaraLayers.size();
    }

    private MFEMakeupMascaraLayer getMascaraLayer(int i) {
        if (i < 0 || i >= this.mascaraLayers.size()) {
            return null;
        }
        return this.mascaraLayers.get(i);
    }
}
