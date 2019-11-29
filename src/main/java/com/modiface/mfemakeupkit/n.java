package com.modiface.mfemakeupkit;

import com.modiface.mfemakeupkit.MFEMakeupEngine;
import com.modiface.mfemakeupkit.a.j;

class n implements j.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine.MFEMakeupEngineLoadResourcesCallback f15326a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine f15327b;

    n(MFEMakeupEngine mFEMakeupEngine, MFEMakeupEngine.MFEMakeupEngineLoadResourcesCallback mFEMakeupEngineLoadResourcesCallback) {
        this.f15327b = mFEMakeupEngine;
        this.f15326a = mFEMakeupEngineLoadResourcesCallback;
    }

    public void a() {
        MFEMakeupEngine.MFEMakeupEngineLoadResourcesCallback mFEMakeupEngineLoadResourcesCallback = this.f15326a;
        if (mFEMakeupEngineLoadResourcesCallback != null) {
            mFEMakeupEngineLoadResourcesCallback.onMFEMakeupFinishedLoadResources();
        }
    }
}
