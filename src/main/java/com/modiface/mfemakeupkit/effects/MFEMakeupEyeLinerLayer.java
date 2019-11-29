package com.modiface.mfemakeupkit.effects;

import android.graphics.PointF;
import com.google.a.a.b;
import com.modiface.mfemakeupkit.utils.o;

public class MFEMakeupEyeLinerLayer extends MFEMakeupMaskLayer {
    public final Presets presetStyle;
    public PointF[] referenceEyePoints;

    @b(a = a.class)
    public enum Presets {
        Custom,
        Natural,
        NaturalFull,
        CatEye,
        CatEyeFull,
        Puppy,
        PuppyFull,
        Smoky,
        SmokyFull,
        Winged,
        WingedFull,
        Natural2,
        Natural2Full,
        CatEye2,
        CatEye2Full,
        Smoky2,
        Smoky2Full,
        SmokyNatural,
        SmokyNaturalFull,
        SmokyWinged,
        SmokyWingedFull,
        WingedSimple,
        WingedSimpleFull,
        WingedThin,
        WingedThinFull,
        WingedSmall,
        WingedSmallFull,
        WingedExtraSmall,
        WingedExtraSmallFull,
        Subtle,
        SubtleFull,
        Kohl,
        KohlFull
    }

    private static final class a extends o.c<Presets> {
        private a() {
            super("MFEMakeupEyeLinerStyle", Presets.class);
        }
    }

    public MFEMakeupEyeLinerLayer() {
        this.presetStyle = Presets.Custom;
    }

    public MFEMakeupEyeLinerLayer(MFEMakeupProduct mFEMakeupProduct) {
        super(mFEMakeupProduct);
        this.presetStyle = Presets.Custom;
    }

    public MFEMakeupEyeLinerLayer(Presets presets) {
        this.presetStyle = presets == null ? Presets.Custom : presets;
    }

    public MFEMakeupEyeLinerLayer(Presets presets, MFEMakeupProduct mFEMakeupProduct) {
        super(mFEMakeupProduct);
        this.presetStyle = presets == null ? Presets.Custom : presets;
    }
}
