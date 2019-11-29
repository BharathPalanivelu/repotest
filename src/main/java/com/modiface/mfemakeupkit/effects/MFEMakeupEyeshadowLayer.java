package com.modiface.mfemakeupkit.effects;

import android.graphics.PointF;
import com.google.a.a.b;
import com.modiface.mfemakeupkit.utils.o;

public class MFEMakeupEyeshadowLayer extends MFEMakeupMaskLayer {
    public float deformationAreaFactor;
    public final Presets presetStyle;
    public PointF[] referenceBrowPoints;
    public PointF[] referenceEyePoints;

    @b(a = a.class)
    public enum Presets {
        Custom,
        Lid,
        Crease,
        FullLid,
        BrowHighlight,
        Outer,
        Inner,
        LidSharp,
        CreaseSharp,
        BrowHighlightSharp,
        OuterSharp,
        InnerSharp,
        LowerLashSharp,
        InnerHalf,
        OuterHalf,
        FullCatEye,
        SmokyCatEye,
        Rectangular
    }

    private static final class a extends o.c<Presets> {
        private a() {
            super("MFEMakeupEyeShadowStyle", Presets.class);
        }
    }

    public MFEMakeupEyeshadowLayer() {
        this.presetStyle = Presets.Custom;
        init();
    }

    private void init() {
        if (this.presetStyle != Presets.Custom) {
            this.deformationAreaFactor = 2.0f;
        } else {
            this.deformationAreaFactor = 1.0f;
        }
    }

    /* access modifiers changed from: protected */
    public String getMFEClassName() {
        return "MakeupEyeShadowLayer";
    }

    public MFEMakeupEyeshadowLayer(MFEMakeupProduct mFEMakeupProduct) {
        super(mFEMakeupProduct);
        this.presetStyle = Presets.Custom;
        init();
    }

    public MFEMakeupEyeshadowLayer(Presets presets) {
        this.presetStyle = presets == null ? Presets.Custom : presets;
        init();
    }

    public MFEMakeupEyeshadowLayer(Presets presets, MFEMakeupProduct mFEMakeupProduct) {
        super(mFEMakeupProduct);
        this.presetStyle = presets == null ? Presets.Custom : presets;
        init();
    }
}
