package com.modiface.mfemakeupkit.effects;

import com.google.a.a.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.modiface.mfemakeupkit.utils.o;

public class MFEMakeupBlushLayer extends MFEMakeupMaskLayer {
    public float offsetX;
    public float offsetY;
    public final Presets presetStyle;
    public float scaleX;
    public float scaleY;
    public float skinGlowAmount;

    @b(a = a.class)
    public enum Presets {
        Custom,
        Blush,
        Highlight,
        Contour
    }

    private static final class a extends o.c<Presets> {
        private a() {
            super("MFEMakeupBlushStyle", Presets.class);
        }
    }

    public MFEMakeupBlushLayer() {
        this.skinGlowAmount = BitmapDescriptorFactory.HUE_RED;
        this.presetStyle = Presets.Custom;
        init();
    }

    private void init() {
        if (this.presetStyle != Presets.Custom) {
            this.offsetX = 0.1f;
            this.offsetY = -0.1f;
            this.scaleX = 1.2f;
            this.scaleY = 1.45f;
            return;
        }
        this.offsetX = BitmapDescriptorFactory.HUE_RED;
        this.offsetY = BitmapDescriptorFactory.HUE_RED;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
    }

    public MFEMakeupBlushLayer(MFEMakeupProduct mFEMakeupProduct) {
        super(mFEMakeupProduct);
        this.skinGlowAmount = BitmapDescriptorFactory.HUE_RED;
        this.presetStyle = Presets.Custom;
        init();
    }

    public MFEMakeupBlushLayer(Presets presets) {
        this.skinGlowAmount = BitmapDescriptorFactory.HUE_RED;
        this.presetStyle = presets == null ? Presets.Custom : presets;
        init();
    }

    public MFEMakeupBlushLayer(Presets presets, MFEMakeupProduct mFEMakeupProduct) {
        super(mFEMakeupProduct);
        this.skinGlowAmount = BitmapDescriptorFactory.HUE_RED;
        this.presetStyle = presets == null ? Presets.Custom : presets;
        init();
    }
}
