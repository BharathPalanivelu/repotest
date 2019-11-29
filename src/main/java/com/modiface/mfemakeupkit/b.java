package com.modiface.mfemakeupkit;

import android.graphics.Bitmap;
import com.modiface.mfemakeupkit.MFEMakeupEngine;

class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine.CaptureOutputCompletionHandler f15227a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine f15228b;

    b(MFEMakeupEngine mFEMakeupEngine, MFEMakeupEngine.CaptureOutputCompletionHandler captureOutputCompletionHandler) {
        this.f15228b = mFEMakeupEngine;
        this.f15227a = captureOutputCompletionHandler;
    }

    public void run() {
        this.f15227a.onCapturedOutput((Bitmap) null, (Bitmap) null);
    }
}
