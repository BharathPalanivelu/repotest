package com.modiface.mfemakeupkit;

import com.modiface.mfemakeupkit.MFEMakeupEngine;
import com.modiface.mfemakeupkit.a.j;

class o implements j.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine.MFEMakeupEngineLoadResourcesCallback f15328a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine f15329b;

    o(MFEMakeupEngine mFEMakeupEngine, MFEMakeupEngine.MFEMakeupEngineLoadResourcesCallback mFEMakeupEngineLoadResourcesCallback) {
        this.f15329b = mFEMakeupEngine;
        this.f15328a = mFEMakeupEngineLoadResourcesCallback;
    }

    public void a() {
        MFEMakeupEngine.MFEMakeupEngineLoadResourcesCallback mFEMakeupEngineLoadResourcesCallback = this.f15328a;
        if (mFEMakeupEngineLoadResourcesCallback != null) {
            mFEMakeupEngineLoadResourcesCallback.onMFEMakeupFinishedLoadResources();
        }
    }
}
