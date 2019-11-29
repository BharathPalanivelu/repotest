package com.modiface.mfemakeupkit;

import android.graphics.Bitmap;
import com.modiface.mfemakeupkit.MFEMakeupEngine;

class f implements MFEMakeupEngine.ApplyMakeupToPhotoCompletionHandler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f15310a;

    f(g gVar) {
        this.f15310a = gVar;
    }

    public void onMakeupAppliedToPhoto(Bitmap bitmap, Bitmap bitmap2, Throwable th) {
        if (th != null) {
            this.f15310a.f15312b.onTakePictureFromCameraDone(bitmap, (Bitmap) null, th);
        } else if (bitmap2 != null) {
            this.f15310a.f15312b.onTakePictureFromCameraDone(bitmap, bitmap2, (Throwable) null);
        } else {
            this.f15310a.f15312b.onTakePictureFromCameraDone(bitmap, (Bitmap) null, new Exception("failed to apply makeup to photo taken from camera"));
        }
    }
}
