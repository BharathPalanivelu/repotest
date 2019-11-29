package com.modiface.mfemakeupkit;

import android.graphics.Bitmap;
import com.modiface.mfemakeupkit.MFEMakeupEngine;
import com.modiface.mfemakeupkit.a.j;
import com.modiface.mfemakeupkit.utils.u;

class e implements j.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine.FaceTrackedOnPhotoCompletionHandler f15305a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Bitmap f15306b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine f15307c;

    e(MFEMakeupEngine mFEMakeupEngine, MFEMakeupEngine.FaceTrackedOnPhotoCompletionHandler faceTrackedOnPhotoCompletionHandler, Bitmap bitmap) {
        this.f15307c = mFEMakeupEngine;
        this.f15305a = faceTrackedOnPhotoCompletionHandler;
        this.f15306b = bitmap;
    }

    public void a(u uVar) {
        this.f15305a.onFaceTrackedOnPhoto(this.f15306b, uVar != null ? uVar.f15398a : null);
    }
}
