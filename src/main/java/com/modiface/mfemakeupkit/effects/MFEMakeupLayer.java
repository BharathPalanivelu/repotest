package com.modiface.mfemakeupkit.effects;

import com.google.a.a.c;

public class MFEMakeupLayer {
    @c(a = "class")
    private final String className = getMFEClassName();
    public MFEMakeupProduct product = null;

    public MFEMakeupLayer() {
    }

    /* access modifiers changed from: protected */
    public String getMFEClassName() {
        String simpleName = getClass().getSimpleName();
        return simpleName.startsWith("MFE") ? simpleName.substring(3) : simpleName;
    }

    public MFEMakeupLayer(MFEMakeupProduct mFEMakeupProduct) {
        this.product = mFEMakeupProduct;
    }
}
