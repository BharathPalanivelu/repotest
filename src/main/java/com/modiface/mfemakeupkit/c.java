package com.modiface.mfemakeupkit;

import com.modiface.mfemakeupkit.b.m;

class c implements m.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f15261a;

    c(d dVar) {
        this.f15261a = dVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r2, java.util.ArrayList<java.lang.Throwable> r3, com.modiface.mfemakeupkit.utils.u r4, com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r5, com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r6) {
        /*
            r1 = this;
            com.modiface.mfemakeupkit.d r4 = r1.f15261a
            android.graphics.Bitmap r4 = r4.f15302a
            r0 = 0
            if (r2 == 0) goto L_0x0031
            if (r5 == 0) goto L_0x001e
            android.graphics.Bitmap r4 = r5.captureToBitmap()
            boolean r2 = r5.hasError()
            if (r2 == 0) goto L_0x001e
            java.util.ArrayList r2 = r5.getAndClearErrors()
            r3.addAll(r2)
            com.modiface.mfemakeupkit.d r2 = r1.f15261a
            android.graphics.Bitmap r4 = r2.f15302a
        L_0x001e:
            if (r6 == 0) goto L_0x0031
            android.graphics.Bitmap r2 = r6.captureToBitmap()
            boolean r5 = r6.hasError()
            if (r5 == 0) goto L_0x0032
            java.util.ArrayList r2 = r6.getAndClearErrors()
            r3.addAll(r2)
        L_0x0031:
            r2 = r0
        L_0x0032:
            if (r2 == 0) goto L_0x003c
            com.modiface.mfemakeupkit.d r5 = r1.f15261a
            com.modiface.mfemakeupkit.MFEMakeupEngine$ApplyMakeupToPhotoCompletionHandler r5 = r5.f15303b
            r5.onMakeupAppliedToPhoto(r4, r2, r0)
            goto L_0x004a
        L_0x003c:
            com.modiface.mfemakeupkit.d r2 = r1.f15261a
            com.modiface.mfemakeupkit.MFEMakeupEngine$ApplyMakeupToPhotoCompletionHandler r2 = r2.f15303b
            java.lang.Exception r5 = new java.lang.Exception
            java.lang.String r6 = "failed to apply makeup to photo"
            r5.<init>(r6)
            r2.onMakeupAppliedToPhoto(r4, r0, r5)
        L_0x004a:
            boolean r2 = r3.isEmpty()
            if (r2 != 0) goto L_0x0063
            com.modiface.mfemakeupkit.d r2 = r1.f15261a
            com.modiface.mfemakeupkit.MFEMakeupEngine r2 = r2.f15304c
            java.lang.ref.WeakReference r2 = r2.mErrorCallbackRef
            java.lang.Object r2 = r2.get()
            com.modiface.mfemakeupkit.MFEMakeupEngine$MFEMakeupEngineErrorCallback r2 = (com.modiface.mfemakeupkit.MFEMakeupEngine.MFEMakeupEngineErrorCallback) r2
            if (r2 == 0) goto L_0x0063
            r2.onMakeupEngineError(r3)
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.modiface.mfemakeupkit.c.a(boolean, java.util.ArrayList, com.modiface.mfemakeupkit.utils.u, com.modiface.mfemakeupkit.utils.MFEGLFramebuffer, com.modiface.mfemakeupkit.utils.MFEGLFramebuffer):void");
    }
}
