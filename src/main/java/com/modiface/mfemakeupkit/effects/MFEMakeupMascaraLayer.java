package com.modiface.mfemakeupkit.effects;

import android.graphics.PointF;
import com.google.a.a.b;
import com.modiface.mfemakeupkit.utils.o;

public class MFEMakeupMascaraLayer extends MFEMakeupMaskLayer {
    public final Presets presetStyle;
    public PointF[] referenceEyePoints;

    @b(a = a.class)
    public enum Presets {
        Custom,
        Natural,
        NaturalLength,
        Length,
        Volume,
        VolumeLength,
        Doll,
        Lower,
        Natural2,
        Natural2Full,
        Volume2,
        Volume2Full,
        Doll2,
        Doll2Full,
        Subtle,
        SubtleFull,
        Grandiose,
        GrandioseFull,
        Dense,
        DenseFull,
        Drama,
        DramaFull
    }

    private static final class a extends o.c<Presets> {
        private a() {
            super("MFEMakeupMascaraStyle", Presets.class);
        }
    }

    public MFEMakeupMascaraLayer() {
        this.presetStyle = Presets.Custom;
    }

    public MFEMakeupMascaraLayer(MFEMakeupProduct mFEMakeupProduct) {
        super(mFEMakeupProduct);
        this.presetStyle = Presets.Custom;
    }

    public MFEMakeupMascaraLayer(Presets presets) {
        this.presetStyle = presets == null ? Presets.Custom : presets;
    }

    public MFEMakeupMascaraLayer(Presets presets, MFEMakeupProduct mFEMakeupProduct) {
        super(mFEMakeupProduct);
        this.presetStyle = presets == null ? Presets.Custom : presets;
    }
}
