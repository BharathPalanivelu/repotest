package com.modiface.mfemakeupkit;

import android.graphics.Bitmap;
import com.modiface.mfemakeupkit.MFEMakeupEngine;
import com.modiface.mfemakeupkit.a.j;
import com.modiface.mfemakeupkit.b.m;
import com.modiface.mfemakeupkit.utils.u;

class d implements j.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bitmap f15302a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine.ApplyMakeupToPhotoCompletionHandler f15303b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine f15304c;

    d(MFEMakeupEngine mFEMakeupEngine, Bitmap bitmap, MFEMakeupEngine.ApplyMakeupToPhotoCompletionHandler applyMakeupToPhotoCompletionHandler) {
        this.f15304c = mFEMakeupEngine;
        this.f15302a = bitmap;
        this.f15303b = applyMakeupToPhotoCompletionHandler;
    }

    public void a(u uVar) {
        this.f15304c.mMakeupRenderingEngine.a(uVar, (m.a) new c(this));
    }
}
