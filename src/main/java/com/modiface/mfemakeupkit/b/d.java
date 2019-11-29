package com.modiface.mfemakeupkit.b;

import android.content.res.AssetManager;
import com.modiface.mfemakeupkit.MFEMakeupEngine;

class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f15239a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine.Region f15240b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AssetManager f15241c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ m f15242d;

    d(m mVar, String str, MFEMakeupEngine.Region region, AssetManager assetManager) {
        this.f15242d = mVar;
        this.f15239a = str;
        this.f15240b = region;
        this.f15241c = assetManager;
    }

    public void run() {
        this.f15242d.o.h(this.f15239a, this.f15240b, "MFELiveMakeup", this.f15241c);
    }
}
