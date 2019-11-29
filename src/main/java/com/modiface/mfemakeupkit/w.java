package com.modiface.mfemakeupkit;

import android.graphics.Bitmap;
import com.modiface.mfemakeupkit.MFEMakeupEngine;
import com.modiface.mfemakeupkit.utils.c;
import java.util.ArrayList;

class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine.CaptureOutputCompletionHandler f15460a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine f15461b;

    w(MFEMakeupEngine mFEMakeupEngine, MFEMakeupEngine.CaptureOutputCompletionHandler captureOutputCompletionHandler) {
        this.f15461b = mFEMakeupEngine;
        this.f15460a = captureOutputCompletionHandler;
    }

    public void run() {
        ArrayList arrayList = new ArrayList();
        c a2 = this.f15461b.mMakeupRenderingEngine.a((ArrayList<Throwable>) arrayList);
        if (a2 != null) {
            this.f15460a.onCapturedOutput(a2.f15354a, a2.f15355b);
        } else {
            this.f15460a.onCapturedOutput((Bitmap) null, (Bitmap) null);
        }
        if (!arrayList.isEmpty()) {
            MFEMakeupEngine.MFEMakeupEngineErrorCallback mFEMakeupEngineErrorCallback = (MFEMakeupEngine.MFEMakeupEngineErrorCallback) this.f15461b.mErrorCallbackRef.get();
            if (mFEMakeupEngineErrorCallback != null) {
                mFEMakeupEngineErrorCallback.onMakeupEngineError(arrayList);
            }
        }
    }
}
