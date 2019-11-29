package com.modiface.mfemakeupkit.camera;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters;
import com.modiface.mfemakeupkit.camera.i;
import com.modiface.mfemakeupkit.utils.n;

class f implements Camera.PictureCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f15271a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f15272b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ MFEAndroidCameraParameters.CameraRotation f15273c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ i.c f15274d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ i f15275e;

    f(i iVar, boolean z, int i, MFEAndroidCameraParameters.CameraRotation cameraRotation, i.c cVar) {
        this.f15275e = iVar;
        this.f15271a = z;
        this.f15272b = i;
        this.f15273c = cameraRotation;
        this.f15274d = cVar;
    }

    public void onPictureTaken(byte[] bArr, Camera camera) {
        Bitmap bitmap;
        if (bArr != null) {
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            j a2 = l.a(this.f15271a, this.f15272b, this.f15273c);
            if (a2 == null) {
                a2 = j.ROTATE0_NOFLIP;
            }
            bitmap = n.a(a2.b() ? decodeByteArray.getHeight() : decodeByteArray.getWidth(), a2.b() ? decodeByteArray.getWidth() : decodeByteArray.getHeight(), Bitmap.Config.ARGB_8888);
            this.f15275e.x.g(decodeByteArray, bitmap, a2.getId());
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            this.f15274d.a(bitmap, (Throwable) null);
        } else {
            this.f15274d.a((Bitmap) null, new NullPointerException("failed to take picture, the returned picture is null"));
        }
        if (!this.f15275e.k.get()) {
            n.a((Runnable) new e(this));
        }
    }
}
