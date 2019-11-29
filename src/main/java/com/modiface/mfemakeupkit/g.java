package com.modiface.mfemakeupkit;

import android.graphics.Bitmap;
import android.hardware.Camera;
import com.modiface.mfemakeupkit.MFEMakeupEngine;
import com.modiface.mfemakeupkit.camera.i;

class g implements i.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine.TakePictureCameraParametersCallback f15311a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine.TakePictureFromCameraCompletionHandler f15312b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine f15313c;

    g(MFEMakeupEngine mFEMakeupEngine, MFEMakeupEngine.TakePictureCameraParametersCallback takePictureCameraParametersCallback, MFEMakeupEngine.TakePictureFromCameraCompletionHandler takePictureFromCameraCompletionHandler) {
        this.f15313c = mFEMakeupEngine;
        this.f15311a = takePictureCameraParametersCallback;
        this.f15312b = takePictureFromCameraCompletionHandler;
    }

    public void a(Camera.Parameters parameters) {
        MFEMakeupEngine.TakePictureCameraParametersCallback takePictureCameraParametersCallback = this.f15311a;
        if (takePictureCameraParametersCallback != null) {
            takePictureCameraParametersCallback.onTakePictureFromCameraSetCameraParameters(parameters);
        }
    }

    public void a(Bitmap bitmap, Throwable th) {
        if (th != null) {
            this.f15312b.onTakePictureFromCameraDone((Bitmap) null, (Bitmap) null, th);
        } else if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0 || bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            this.f15312b.onTakePictureFromCameraDone((Bitmap) null, (Bitmap) null, new NullPointerException("take picture from camera image null or invalid"));
        } else {
            this.f15313c.applyMakeupToPhotoInBackground(bitmap, true, new f(this));
        }
    }
}
