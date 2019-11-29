package com.shopee.app.camera;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.f.f;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import tencent.tls.platform.TLSErrInfo;

public class c extends SurfaceView implements Camera.AutoFocusCallback, SurfaceHolder.Callback {

    /* renamed from: a  reason: collision with root package name */
    private SurfaceHolder f15964a;

    /* renamed from: b  reason: collision with root package name */
    private Camera f15965b;

    /* renamed from: c  reason: collision with root package name */
    private int f15966c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f15967d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f15968e;

    /* renamed from: f  reason: collision with root package name */
    private double f15969f = 1.3d;

    /* renamed from: g  reason: collision with root package name */
    private Camera.Size f15970g;
    private int h = 90;
    private boolean i = true;
    private int j = -1;

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public c(Context context, Camera camera, int i2, int i3, int i4, double d2, boolean z) {
        super(context);
        this.f15965b = camera;
        this.f15966c = i2;
        this.i = z;
        this.f15968e = i3;
        this.f15967d = i4;
        this.f15964a = getHolder();
        this.f15964a.addCallback(this);
        this.f15969f = d2;
        this.f15964a.setType(3);
    }

    public void a() {
        int i2 = this.f15967d;
        int i3 = this.f15968e;
        final Rect rect = new Rect((i2 / 2) - 50, i3 - 50, (i2 / 2) + 50, i3 + 50);
        f.a().a(new Runnable() {
            public void run() {
                try {
                    c.this.a(rect);
                    b.a("CAMERA_FOCUS", new a(new Pair(Integer.valueOf(c.this.f15967d / 2), Integer.valueOf(c.this.f15968e / 2))), b.a.UI_BUS);
                } catch (RuntimeException e2) {
                    com.garena.android.appkit.d.a.a(e2);
                }
            }
        }, 1000);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        try {
            this.f15965b.setPreviewDisplay(surfaceHolder);
            Camera.Parameters parameters = this.f15965b.getParameters();
            List<Camera.Size> supportedPreviewSizes = this.f15965b.getParameters().getSupportedPreviewSizes();
            if (supportedPreviewSizes != null) {
                this.f15970g = a(supportedPreviewSizes);
            }
            parameters.setPreviewSize(this.f15970g.width, this.f15970g.height);
            this.f15965b.setParameters(parameters);
            this.f15965b.startPreview();
        } catch (IOException e2) {
            com.garena.android.appkit.d.a.a(e2);
        } catch (RuntimeException e3) {
            com.garena.android.appkit.d.a.a(e3);
            b.a("CAMERA_STATUS_WRONG", new a(), b.a.UI_BUS);
        }
    }

    private Camera.Size a(List<Camera.Size> list) {
        Camera.Size size = null;
        if (list == null) {
            return null;
        }
        int i2 = 0;
        for (Camera.Size next : list) {
            double d2 = (double) next.width;
            double d3 = (double) next.height;
            Double.isNaN(d2);
            Double.isNaN(d3);
            if (Math.abs((d2 / d3) - this.f15969f) <= 0.1d && next.height > i2) {
                i2 = next.height;
                size = next;
            }
        }
        if (size == null) {
            for (Camera.Size next2 : list) {
                if (next2.height > i2) {
                    i2 = next2.height;
                    size = next2;
                }
            }
        }
        return size;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            float touchMajor = motionEvent.getTouchMajor();
            float touchMinor = motionEvent.getTouchMinor();
            if (touchMajor == BitmapDescriptorFactory.HUE_RED) {
                touchMajor = 100.0f;
            }
            if (touchMinor == BitmapDescriptorFactory.HUE_RED) {
                touchMinor = 100.0f;
            }
            float f2 = touchMajor / 2.0f;
            float f3 = touchMinor / 2.0f;
            try {
                a(new Rect((int) (x - f2), (int) (y - f3), (int) (f2 + x), (int) (f3 + y)));
                b.a("CAMERA_FOCUS", new a(new Pair(Integer.valueOf((int) x), Integer.valueOf((int) y))), b.a.UI_BUS);
            } catch (RuntimeException e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void a(Rect rect) {
        Camera.Parameters parameters = this.f15965b.getParameters();
        this.f15965b.cancelAutoFocus();
        if (Build.VERSION.SDK_INT < 14 || parameters.getMaxNumFocusAreas() != 0) {
            Rect rect2 = new Rect();
            int i2 = ((rect.left * 2000) / this.f15967d) - 1000;
            int i3 = TLSErrInfo.TIMEOUT;
            int i4 = i2 >= -1000 ? ((rect.left * 2000) / this.f15967d) - 1000 : TLSErrInfo.TIMEOUT;
            if (((rect.top * 2000) / this.f15968e) - 1000 >= -1000) {
                i3 = ((rect.top * 2000) / this.f15968e) - 1000;
            }
            rect2.set(i4, i3, ((rect.right * 2000) / this.f15967d) - 1000 <= 1000 ? ((rect.right * 2000) / this.f15967d) - 1000 : 1000, ((rect.bottom * 2000) / this.f15968e) - 1000 <= 1000 ? ((rect.bottom * 2000) / this.f15968e) - 1000 : 1000);
            ArrayList arrayList = new ArrayList();
            if (parameters.getSupportedFocusModes().contains("auto")) {
                parameters.setFocusMode("auto");
                if (Build.VERSION.SDK_INT >= 14) {
                    arrayList.add(new Camera.Area(rect2, 1000));
                    parameters.setFocusAreas(arrayList);
                }
                this.f15965b.setParameters(parameters);
            }
            this.f15965b.autoFocus(this);
        }
    }

    public void onAutoFocus(boolean z, Camera camera) {
        if (z) {
            try {
                this.f15965b.cancelAutoFocus();
                camera.getParameters().getFocusDistances(new float[3]);
            } catch (RuntimeException e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        a(((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:3|4|5|6|(5:8|(2:10|(2:12|(2:14|(1:16)(1:17))(1:18))(1:19))(1:20)|21|(1:23)|24)|25|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0072, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0073, code lost:
        android.util.Log.d("camera test", "Error starting camera preview: " + r4.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000e */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0019 A[Catch:{ Exception -> 0x0072 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r4) {
        /*
            r3 = this;
            android.view.SurfaceHolder r0 = r3.f15964a
            android.view.Surface r0 = r0.getSurface()
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            android.hardware.Camera r0 = r3.f15965b     // Catch:{ Exception -> 0x000e }
            r0.stopPreview()     // Catch:{ Exception -> 0x000e }
        L_0x000e:
            android.hardware.Camera r0 = r3.f15965b     // Catch:{ Exception -> 0x0072 }
            android.view.SurfaceHolder r1 = r3.f15964a     // Catch:{ Exception -> 0x0072 }
            r0.setPreviewDisplay(r1)     // Catch:{ Exception -> 0x0072 }
            android.hardware.Camera$Size r0 = r3.f15970g     // Catch:{ Exception -> 0x0072 }
            if (r0 == 0) goto L_0x006c
            android.hardware.Camera r0 = r3.f15965b     // Catch:{ Exception -> 0x0072 }
            android.hardware.Camera$Parameters r0 = r0.getParameters()     // Catch:{ Exception -> 0x0072 }
            if (r4 == 0) goto L_0x0039
            r1 = 1
            if (r4 == r1) goto L_0x0035
            r1 = 2
            if (r4 == r1) goto L_0x0030
            r1 = 3
            if (r4 == r1) goto L_0x002b
            goto L_0x003d
        L_0x002b:
            r4 = 180(0xb4, float:2.52E-43)
            r3.h = r4     // Catch:{ Exception -> 0x0072 }
            goto L_0x003d
        L_0x0030:
            r4 = 270(0x10e, float:3.78E-43)
            r3.h = r4     // Catch:{ Exception -> 0x0072 }
            goto L_0x003d
        L_0x0035:
            r4 = 0
            r3.h = r4     // Catch:{ Exception -> 0x0072 }
            goto L_0x003d
        L_0x0039:
            r4 = 90
            r3.h = r4     // Catch:{ Exception -> 0x0072 }
        L_0x003d:
            android.content.Context r4 = r3.getContext()     // Catch:{ Exception -> 0x0072 }
            android.app.Activity r4 = (android.app.Activity) r4     // Catch:{ Exception -> 0x0072 }
            int r1 = r3.f15966c     // Catch:{ Exception -> 0x0072 }
            android.hardware.Camera r2 = r3.f15965b     // Catch:{ Exception -> 0x0072 }
            com.shopee.app.camera.d.a((android.app.Activity) r4, (int) r1, (android.hardware.Camera) r2)     // Catch:{ Exception -> 0x0072 }
            android.hardware.Camera r4 = r3.f15965b     // Catch:{ Exception -> 0x0072 }
            android.hardware.Camera$Parameters r4 = r4.getParameters()     // Catch:{ Exception -> 0x0072 }
            java.util.List r4 = r4.getSupportedPreviewSizes()     // Catch:{ Exception -> 0x0072 }
            if (r4 == 0) goto L_0x005c
            android.hardware.Camera$Size r4 = r3.a((java.util.List<android.hardware.Camera.Size>) r4)     // Catch:{ Exception -> 0x0072 }
            r3.f15970g = r4     // Catch:{ Exception -> 0x0072 }
        L_0x005c:
            android.hardware.Camera$Size r4 = r3.f15970g     // Catch:{ Exception -> 0x0072 }
            int r4 = r4.width     // Catch:{ Exception -> 0x0072 }
            android.hardware.Camera$Size r1 = r3.f15970g     // Catch:{ Exception -> 0x0072 }
            int r1 = r1.height     // Catch:{ Exception -> 0x0072 }
            r0.setPreviewSize(r4, r1)     // Catch:{ Exception -> 0x0072 }
            android.hardware.Camera r4 = r3.f15965b     // Catch:{ Exception -> 0x0072 }
            r4.setParameters(r0)     // Catch:{ Exception -> 0x0072 }
        L_0x006c:
            android.hardware.Camera r4 = r3.f15965b     // Catch:{ Exception -> 0x0072 }
            r4.startPreview()     // Catch:{ Exception -> 0x0072 }
            goto L_0x008d
        L_0x0072:
            r4 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error starting camera preview: "
            r0.append(r1)
            java.lang.String r4 = r4.getMessage()
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.lang.String r0 = "camera test"
            android.util.Log.d(r0, r4)
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.camera.c.a(int):void");
    }

    public int getCameraAngle() {
        return this.h;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.i) {
            this.f15967d = View.MeasureSpec.getSize(i2);
            this.f15968e = View.MeasureSpec.getSize(i3);
            if (((double) (((float) this.f15968e) / ((float) this.f15967d))) < this.f15969f) {
                int i4 = this.f15967d;
                double d2 = (double) i4;
                double d3 = this.f15969f;
                Double.isNaN(d2);
                setMeasuredDimension(i4, (int) (d2 * d3));
                return;
            }
            int i5 = this.f15968e;
            double d4 = (double) i5;
            double d5 = this.f15969f;
            Double.isNaN(d4);
            setMeasuredDimension((int) (d4 / d5), i5);
        }
    }
}
