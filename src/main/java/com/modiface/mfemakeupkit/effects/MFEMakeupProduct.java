package com.modiface.mfemakeupkit.effects;

import com.facebook.react.uimanager.ViewProps;
import com.google.a.a.c;
import com.modiface.mfemakeupkit.utils.o;

public class MFEMakeupProduct {
    private static final String TAG = "MFEMakeupProduct";
    @com.google.a.a.b(a = o.a.class)
    @c(a = "intensity")
    public int amount = 100;
    @com.google.a.a.b(a = a.class)
    public int color = 0;
    @com.google.a.a.b(a = o.a.class)
    public int contrastBoost = 0;
    @c(a = "useDynamicColor")
    public boolean enableDynamicColor = true;
    @com.google.a.a.b(a = o.a.class)
    public int envMappingIntensity = 0;
    @com.google.a.a.b(a = o.a.class)
    @c(a = "sparkleIntensity")
    public int glitter = 0;
    @com.google.a.a.b(a = b.class)
    @c(a = "sparkleColor")
    public int glitterColor = -1;
    @com.google.a.a.b(a = o.a.class)
    @c(a = "sparkleDensity")
    public int glitterDensity = 100;
    @c(a = "sparkleSize")
    public int glitterSize = 0;
    @com.google.a.a.b(a = o.a.class)
    public int gloss = 0;
    @com.google.a.a.b(a = o.a.class)
    public int glossDetail = 0;
    @com.google.a.a.b(a = o.a.class)
    public int skinClearing = 0;
    @com.google.a.a.b(a = o.a.class)
    public int skinGlow = 0;
    public boolean useNormalizedGloss = false;
    @com.google.a.a.b(a = o.a.class)
    public int wetness = 0;

    private static final class a extends o.b {
        protected a() {
            super(ViewProps.COLOR);
        }
    }

    private static final class b extends o.b {
        protected b() {
            super("sparkle");
        }
    }
}
