package com.modiface.mfemakeupkit.camera;

import com.modiface.mfemakeupkit.utils.p;
import java.util.ArrayList;

class g implements p {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f15276a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f15277b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f15278c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ j f15279d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ int f15280e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ i f15281f;

    g(i iVar, ArrayList arrayList, int i, int i2, j jVar, int i3) {
        this.f15281f = iVar;
        this.f15276a = arrayList;
        this.f15277b = i;
        this.f15278c = i2;
        this.f15279d = jVar;
        this.f15280e = i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.modiface.mfemakeupkit.utils.MFEImage a(com.modiface.mfemakeupkit.utils.MFEImage r10) {
        /*
            r9 = this;
            com.modiface.mfemakeupkit.camera.i r0 = r9.f15281f
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.k
            boolean r0 = r0.get()
            r1 = 0
            if (r0 == 0) goto L_0x000e
            return r1
        L_0x000e:
            if (r10 != 0) goto L_0x0015
            com.modiface.mfemakeupkit.utils.MFEImage r10 = new com.modiface.mfemakeupkit.utils.MFEImage
            r10.<init>()
        L_0x0015:
            com.modiface.mfemakeupkit.camera.i r0 = r9.f15281f
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r0 = r0.s
            if (r0 == 0) goto L_0x0029
            com.modiface.mfemakeupkit.camera.i r0 = r9.f15281f
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r0 = r0.s
            boolean r0 = r0.hasError()
            if (r0 == 0) goto L_0x0035
        L_0x0029:
            com.modiface.mfemakeupkit.camera.i r0 = r9.f15281f
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r2 = new com.modiface.mfemakeupkit.utils.MFEGLFramebuffer
            java.lang.String r3 = "camera"
            r2.<init>(r3)
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer unused = r0.s = r2
        L_0x0035:
            com.modiface.mfemakeupkit.camera.i r0 = r9.f15281f
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r0 = r0.s
            boolean r0 = r0.hasError()
            if (r0 == 0) goto L_0x0056
            java.util.ArrayList r10 = r9.f15276a
            com.modiface.mfemakeupkit.camera.i r0 = r9.f15281f
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r0 = r0.s
            java.util.ArrayList r0 = r0.getAndClearErrors()
            r10.addAll(r0)
            com.modiface.mfemakeupkit.camera.i r10 = r9.f15281f
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer unused = r10.s = r1
            return r1
        L_0x0056:
            int r0 = r10.textureWidth
            int r2 = r9.f15277b
            r3 = 1
            r4 = 0
            if (r0 != r2) goto L_0x0095
            int r0 = r10.textureHeight
            int r2 = r9.f15278c
            if (r0 != r2) goto L_0x0095
            int r0 = r10.textureId
            if (r0 == 0) goto L_0x0095
            com.modiface.mfemakeupkit.camera.i r0 = r9.f15281f
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r0 = r0.s
            int r2 = r10.textureId
            int r5 = r9.f15277b
            int r6 = r9.f15278c
            r0.attachTexture(r2, r5, r6)
            com.modiface.mfemakeupkit.camera.i r0 = r9.f15281f
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r0 = r0.s
            boolean r0 = r0.hasError()
            if (r0 == 0) goto L_0x0093
            java.util.ArrayList r0 = r9.f15276a
            com.modiface.mfemakeupkit.camera.i r2 = r9.f15281f
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r2 = r2.s
            java.util.ArrayList r2 = r2.getAndClearErrors()
            r0.addAll(r2)
            goto L_0x0095
        L_0x0093:
            r0 = 1
            goto L_0x0096
        L_0x0095:
            r0 = 0
        L_0x0096:
            if (r0 != 0) goto L_0x00c1
            int r0 = r10.textureId
            if (r0 == 0) goto L_0x00b0
            int[] r2 = new int[r3]
            r2[r4] = r0
            android.opengl.GLES20.glDeleteTextures(r3, r2, r4)
            r10.textureId = r4
            java.lang.Throwable r0 = com.modiface.mfemakeupkit.utils.MFEGLUtil.getGLError()
            if (r0 == 0) goto L_0x00b0
            java.util.ArrayList r2 = r9.f15276a
            r2.add(r0)
        L_0x00b0:
            r10.textureWidth = r4
            r10.textureHeight = r4
            com.modiface.mfemakeupkit.camera.i r0 = r9.f15281f
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r0 = r0.s
            int r2 = r9.f15277b
            int r3 = r9.f15278c
            r0.generateEmptyWithSize(r2, r3)
        L_0x00c1:
            com.modiface.mfemakeupkit.camera.i r0 = r9.f15281f
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r0 = r0.s
            boolean r0 = r0.hasError()
            if (r0 == 0) goto L_0x00e2
            java.util.ArrayList r10 = r9.f15276a
            com.modiface.mfemakeupkit.camera.i r0 = r9.f15281f
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r0 = r0.s
            java.util.ArrayList r0 = r0.getAndClearErrors()
            r10.addAll(r0)
            com.modiface.mfemakeupkit.camera.i r10 = r9.f15281f
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer unused = r10.s = r1
            return r1
        L_0x00e2:
            r0 = 8
            float[] r4 = new float[r0]
            float[] r5 = com.modiface.mfemakeupkit.utils.MFEGLUtil.untransformedTextureCoordinates
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            com.modiface.mfemakeupkit.camera.j r2 = r9.f15279d
            android.graphics.Matrix r2 = com.modiface.mfemakeupkit.camera.l.a((com.modiface.mfemakeupkit.camera.j) r2)
            r0.postConcat(r2)
            float[] r2 = com.modiface.mfemakeupkit.utils.MFEGLUtil.untransformedVertices
            r0.mapPoints(r4, r2)
            com.modiface.mfemakeupkit.utils.MFENativeError r0 = new com.modiface.mfemakeupkit.utils.MFENativeError
            r0.<init>()
            com.modiface.mfemakeupkit.camera.i r2 = r9.f15281f
            com.modiface.mfemakeupkit.mfea.d r2 = r2.x
            int r3 = r9.f15280e
            com.modiface.mfemakeupkit.camera.i r6 = r9.f15281f
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r6 = r6.s
            long r7 = r0.getNativeState()
            r2.c(r3, r4, r5, r6, r7)
            java.lang.Throwable r0 = r0.getNativeError()
            if (r0 == 0) goto L_0x0121
            java.util.ArrayList r10 = r9.f15276a
            r10.add(r0)
            return r1
        L_0x0121:
            com.modiface.mfemakeupkit.camera.i r0 = r9.f15281f
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r0 = r0.s
            android.graphics.Bitmap r2 = r10.bitmap
            android.graphics.Bitmap r0 = r0.captureToBitmap(r2)
            r10.bitmap = r0
            com.modiface.mfemakeupkit.camera.i r0 = r9.f15281f
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r0 = r0.s
            boolean r0 = r0.hasError()
            if (r0 == 0) goto L_0x014b
            java.util.ArrayList r10 = r9.f15276a
            com.modiface.mfemakeupkit.camera.i r0 = r9.f15281f
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r0 = r0.s
            java.util.ArrayList r0 = r0.getAndClearErrors()
            r10.addAll(r0)
            return r1
        L_0x014b:
            com.modiface.mfemakeupkit.camera.i r0 = r9.f15281f
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r0 = r0.s
            int r0 = r0.detachTexture()
            r10.textureId = r0
            com.modiface.mfemakeupkit.camera.i r0 = r9.f15281f
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r0 = r0.s
            boolean r0 = r0.hasError()
            if (r0 == 0) goto L_0x0173
            java.util.ArrayList r10 = r9.f15276a
            com.modiface.mfemakeupkit.camera.i r0 = r9.f15281f
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r0 = r0.s
            java.util.ArrayList r0 = r0.getAndClearErrors()
            r10.addAll(r0)
            return r1
        L_0x0173:
            com.modiface.mfemakeupkit.camera.i r0 = r9.f15281f
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r0 = r0.s
            int r0 = r0.getWidth()
            r10.textureWidth = r0
            com.modiface.mfemakeupkit.camera.i r0 = r9.f15281f
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r0 = r0.s
            int r0 = r0.getHeight()
            r10.textureHeight = r0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.modiface.mfemakeupkit.camera.g.a(com.modiface.mfemakeupkit.utils.MFEImage):com.modiface.mfemakeupkit.utils.MFEImage");
    }
}
