package com.modiface.mfemakeupkit.effects;

import com.google.a.a.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.modiface.mfemakeupkit.utils.o;

public class MFEMakeupConcealerLayer extends MFEMakeupMaskLayer {
    public float offsetX;
    public float offsetY;
    public final Presets presetStyle;
    public float scaleX;
    public float scaleY;

    @b(a = a.class)
    public enum Presets {
        Custom,
        Default
    }

    private static final class a extends o.c<Presets> {
        private a() {
            super("MFEMakeupConcealerStyle", Presets.class);
        }
    }

    public MFEMakeupConcealerLayer() {
        this.presetStyle = Presets.Custom;
        init();
    }

    private void init() {
        if (this.presetStyle != Presets.Custom) {
            this.offsetX = 0.1363f;
            this.offsetY = -0.2416f;
            this.scaleX = 1.332f;
            this.scaleY = 1.045f;
            this.sourceSide = 2;
            return;
        }
        this.offsetX = BitmapDescriptorFactory.HUE_RED;
        this.offsetY = BitmapDescriptorFactory.HUE_RED;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.sourceSide = 1;
    }

    public MFEMakeupConcealerLayer(MFEMakeupProduct mFEMakeupProduct) {
        super(mFEMakeupProduct);
        this.presetStyle = Presets.Custom;
        init();
    }

    public MFEMakeupConcealerLayer(Presets presets) {
        this.presetStyle = presets == null ? Presets.Custom : presets;
        init();
    }

    public MFEMakeupConcealerLayer(Presets presets, MFEMakeupProduct mFEMakeupProduct) {
        super(mFEMakeupProduct);
        this.presetStyle = presets == null ? Presets.Custom : presets;
        init();
    }
}
