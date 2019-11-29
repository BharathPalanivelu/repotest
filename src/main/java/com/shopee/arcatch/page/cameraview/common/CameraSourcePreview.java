package com.shopee.arcatch.page.cameraview.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import com.google.android.gms.common.images.Size;
import java.io.IOException;

public class CameraSourcePreview extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private Context f26958a;

    /* renamed from: b  reason: collision with root package name */
    private SurfaceView f26959b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f26960c = false;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f26961d = false;

    /* renamed from: e  reason: collision with root package name */
    private a f26962e;

    /* renamed from: f  reason: collision with root package name */
    private GraphicOverlay f26963f;

    public CameraSourcePreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f26958a = context;
        this.f26959b = new SurfaceView(context);
        this.f26959b.getHolder().addCallback(new a());
        addView(this.f26959b, 0);
    }

    public void a(a aVar) throws IOException {
        if (aVar != null) {
            a();
        }
        this.f26962e = aVar;
        if (this.f26962e != null) {
            this.f26960c = true;
            b();
        }
    }

    public void a(a aVar, GraphicOverlay graphicOverlay) throws IOException {
        this.f26963f = graphicOverlay;
        a(aVar);
    }

    public void a() {
        a aVar = this.f26962e;
        if (aVar != null) {
            aVar.c();
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void b() throws IOException {
        if (this.f26960c && this.f26961d) {
            this.f26962e.a(this.f26959b.getHolder());
            if (this.f26963f != null) {
                Size d2 = this.f26962e.d();
                int min = Math.min(d2.getWidth(), d2.getHeight());
                int max = Math.max(d2.getWidth(), d2.getHeight());
                if (c()) {
                    this.f26963f.a(min, max, this.f26962e.f());
                } else {
                    this.f26963f.a(max, min, this.f26962e.f());
                }
                this.f26963f.a();
            }
            this.f26960c = false;
        }
    }

    private class a implements SurfaceHolder.Callback {
        private a() {
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            boolean unused = CameraSourcePreview.this.f26961d = true;
            try {
                CameraSourcePreview.this.b();
            } catch (Exception e2) {
                Log.e("FaceDetector:Preview", "Could not start camera source.", e2);
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            boolean unused = CameraSourcePreview.this.f26961d = false;
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            CameraSourcePreview.this.requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0061 A[LOOP:0: B:14:0x005b->B:16:0x0061, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r6, int r7, int r8, int r9, int r10) {
        /*
            r5 = this;
            com.shopee.arcatch.page.cameraview.common.a r6 = r5.f26962e
            if (r6 == 0) goto L_0x0013
            com.google.android.gms.common.images.Size r6 = r6.d()
            if (r6 == 0) goto L_0x0013
            int r0 = r6.getWidth()
            int r6 = r6.getHeight()
            goto L_0x0017
        L_0x0013:
            r0 = 960(0x3c0, float:1.345E-42)
            r6 = 544(0x220, float:7.62E-43)
        L_0x0017:
            boolean r1 = r5.c()
            if (r1 == 0) goto L_0x001e
            goto L_0x0021
        L_0x001e:
            r4 = r0
            r0 = r6
            r6 = r4
        L_0x0021:
            int r9 = r9 - r7
            int r10 = r10 - r8
            float r7 = (float) r9
            float r6 = (float) r6
            float r7 = r7 / r6
            float r6 = (float) r0
            float r7 = r7 * r6
            int r6 = (int) r7
            if (r6 <= r10) goto L_0x0035
            com.shopee.arcatch.c.d.a r7 = com.shopee.arcatch.c.d.a.a()
            r8 = 1065353216(0x3f800000, float:1.0)
            r7.n = r8
            goto L_0x004d
        L_0x0035:
            com.shopee.arcatch.c.d.a r7 = com.shopee.arcatch.c.d.a.a()
            int r8 = r10 - r6
            r7.k = r8
            com.shopee.arcatch.c.d.a r7 = com.shopee.arcatch.c.d.a.a()
            r7.a((int) r10)
            com.shopee.arcatch.c.d.a r7 = com.shopee.arcatch.c.d.a.a()
            float r8 = (float) r6
            float r10 = (float) r10
            float r8 = r8 / r10
            r7.n = r8
        L_0x004d:
            com.shopee.arcatch.c.d.a r7 = com.shopee.arcatch.c.d.a.a()
            int r7 = r7.k
            com.shopee.arcatch.c.d.a r8 = com.shopee.arcatch.c.d.a.a()
            int r8 = r8.l
            r10 = 0
            r0 = 0
        L_0x005b:
            int r1 = r5.getChildCount()
            if (r0 >= r1) goto L_0x0070
            android.view.View r1 = r5.getChildAt(r0)
            int r2 = r7 + r8
            int r3 = r6 + r7
            int r3 = r3 + r8
            r1.layout(r10, r2, r9, r3)
            int r0 = r0 + 1
            goto L_0x005b
        L_0x0070:
            r5.b()     // Catch:{ Exception -> 0x0074 }
            goto L_0x0078
        L_0x0074:
            r6 = move-exception
            com.garena.android.appkit.d.a.a(r6)
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.arcatch.page.cameraview.common.CameraSourcePreview.onLayout(boolean, int, int, int, int):void");
    }

    private boolean c() {
        int i = this.f26958a.getResources().getConfiguration().orientation;
        if (i == 2) {
            return false;
        }
        if (i == 1) {
            return true;
        }
        com.garena.android.appkit.d.a.b("isPortraitMode returning false by default", new Object[0]);
        return false;
    }
}
