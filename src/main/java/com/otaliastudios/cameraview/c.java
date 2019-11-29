package com.otaliastudios.cameraview;

import android.annotation.TargetApi;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.location.Location;
import android.os.Build;
import android.util.Log;
import android.view.SurfaceHolder;
import cn.tongdun.android.shell.settings.Constants;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class c extends d implements Camera.ErrorCallback, Camera.PreviewCallback {
    private static final String Q = "c";
    /* access modifiers changed from: private */
    public static final g R = g.a(Q);
    /* access modifiers changed from: private */
    public Camera S;
    /* access modifiers changed from: private */
    public boolean T = false;
    private final int U = Constants.DEFAULT_WAIT_TIME;
    /* access modifiers changed from: private */
    public Runnable V = new Runnable() {
        public void run() {
            if (c.this.N()) {
                c.this.S.cancelAutoFocus();
                Camera.Parameters parameters = c.this.S.getParameters();
                int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
                int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
                if (maxNumFocusAreas > 0) {
                    parameters.setFocusAreas((List) null);
                }
                if (maxNumMeteringAreas > 0) {
                    parameters.setMeteringAreas((List) null);
                }
                c.this.a(parameters);
                c.this.S.setParameters(parameters);
            }
        }
    };

    c(CameraView.b bVar) {
        super(bVar);
        this.t = new y.a();
    }

    private void a(final ak<Void> akVar, final boolean z, final Runnable runnable) {
        this.f15618c.b(new Runnable() {
            public void run() {
                if (!z || c.this.N()) {
                    runnable.run();
                    ak akVar = akVar;
                    if (akVar != null) {
                        akVar.a(null);
                        return;
                    }
                    return;
                }
                ak akVar2 = akVar;
                if (akVar2 != null) {
                    akVar2.a(null);
                }
            }
        });
    }

    public void a() {
        R.b("onSurfaceAvailable:", "Size is", this.f15617b.d());
        a((ak<Void>) null, false, (Runnable) new Runnable() {
            public void run() {
                c.R.b("onSurfaceAvailable:", "Inside handler. About to bind.");
                if (c.this.K()) {
                    c.this.L();
                }
            }
        });
    }

    public void b() {
        R.b("onSurfaceChanged, size is", this.f15617b.d());
        a((ak<Void>) null, true, (Runnable) new Runnable() {
            public void run() {
                if (c.this.T) {
                    c cVar = c.this;
                    af a2 = cVar.a((List<af>) cVar.b(cVar.S.getParameters().getSupportedPreviewSizes()));
                    if (!a2.equals(c.this.B)) {
                        c.R.b("onSurfaceChanged:", "Computed a new preview size. Going on.");
                        c cVar2 = c.this;
                        cVar2.B = a2;
                        cVar2.S.stopPreview();
                        c.this.a("onSurfaceChanged:");
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean K() {
        return N() && this.f15617b != null && this.f15617b.f() && !this.T;
    }

    /* access modifiers changed from: private */
    public void L() {
        R.b("bindToSurface:", "Started");
        Object c2 = this.f15617b.c();
        try {
            if (this.f15617b.b() == SurfaceHolder.class) {
                this.S.setPreviewDisplay((SurfaceHolder) c2);
            } else {
                this.S.setPreviewTexture((SurfaceTexture) c2);
            }
            this.A = H();
            this.B = a(b(this.S.getParameters().getSupportedPreviewSizes()));
            a("bindToSurface:");
            this.T = true;
        } catch (IOException e2) {
            Log.e("bindToSurface:", "Failed to bind.", e2);
            throw new e(e2, 2);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        R.b(str, "Dispatching onCameraPreviewSizeChanged.");
        this.f15616a.b();
        boolean E = E();
        this.f15617b.a(E ? this.B.b() : this.B.a(), E ? this.B.a() : this.B.b());
        Camera.Parameters parameters = this.S.getParameters();
        this.C = parameters.getPreviewFormat();
        parameters.setPreviewSize(this.B.a(), this.B.b());
        parameters.setPictureSize(this.A.a(), this.A.b());
        this.S.setParameters(parameters);
        this.S.setPreviewCallbackWithBuffer((Camera.PreviewCallback) null);
        this.S.setPreviewCallbackWithBuffer(this);
        this.u.a(ImageFormat.getBitsPerPixel(this.C), this.B);
        R.b(str, "Starting preview with startPreview().");
        try {
            this.S.startPreview();
            R.b(str, "Started preview.");
        } catch (Exception e2) {
            R.d(str, "Failed to start preview.", e2);
            throw new e(e2, 2);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (N()) {
            R.c("onStart:", "Camera not available. Should not happen.");
            d();
        }
        if (M()) {
            try {
                this.S = Camera.open(this.q);
                this.S.setErrorCallback(this);
                R.b("onStart:", "Applying default parameters.");
                Camera.Parameters parameters = this.S.getParameters();
                this.r = new m(parameters);
                this.s = new h(parameters, E());
                a(parameters);
                a(parameters, o.f15661a);
                a(parameters, (Location) null);
                a(parameters, ao.f15559a);
                a(parameters, x.f15687a);
                b(this.p);
                parameters.setRecordingHint(this.j == ae.VIDEO);
                this.S.setParameters(parameters);
                this.S.setDisplayOrientation(F());
                if (K()) {
                    L();
                }
                R.b("onStart:", "Ended");
            } catch (Exception e2) {
                R.d("onStart:", "Failed to connect. Maybe in use by another app?");
                throw new e(e2, 1);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        R.b("onStop:", "About to clean up.");
        this.f15618c.a().removeCallbacks(this.V);
        this.u.a();
        if (this.S != null) {
            R.b("onStop:", "Clean up.", "Ending video.");
            O();
            try {
                R.b("onStop:", "Clean up.", "Stopping preview.");
                this.S.setPreviewCallbackWithBuffer((Camera.PreviewCallback) null);
                this.S.stopPreview();
                R.b("onStop:", "Clean up.", "Stopped preview.");
            } catch (Exception e2) {
                R.c("onStop:", "Clean up.", "Exception while stopping preview.", e2);
            }
            try {
                R.b("onStop:", "Clean up.", "Releasing camera.");
                this.S.release();
                R.b("onStop:", "Clean up.", "Released camera.");
            } catch (Exception e3) {
                R.c("onStop:", "Clean up.", "Exception while releasing camera.", e3);
            }
        }
        this.r = null;
        this.s = null;
        this.S = null;
        this.B = null;
        this.A = null;
        this.T = false;
        this.E = false;
        this.F = false;
        R.c("onStop:", "Clean up.", "Returning.");
    }

    /* access modifiers changed from: private */
    public boolean M() {
        int intValue = ((Integer) this.t.a(this.f15620e)).intValue();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == intValue) {
                this.D = cameraInfo.orientation;
                this.q = i;
                return true;
            }
        }
        return false;
    }

    public void a(byte[] bArr) {
        if (N()) {
            this.S.addCallbackBuffer(bArr);
        }
    }

    public void onError(int i, Camera camera) {
        int i2 = 0;
        if (i == 100) {
            R.c("Recoverable error inside the onError callback.", "CAMERA_ERROR_SERVER_DIED");
            k();
            i();
            return;
        }
        R.d("Error inside the onError callback.", Integer.valueOf(i));
        RuntimeException runtimeException = new RuntimeException(g.f15631a);
        if (i != 1 && i == 2) {
            i2 = 3;
        }
        throw new e(runtimeException, i2);
    }

    /* access modifiers changed from: package-private */
    public void a(ae aeVar) {
        if (aeVar != this.j) {
            this.j = aeVar;
            a((ak<Void>) null, true, (Runnable) new Runnable() {
                public void run() {
                    c.this.l();
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Location location) {
        final Location location2 = this.l;
        this.l = location;
        a((ak<Void>) this.M, true, (Runnable) new Runnable() {
            public void run() {
                Camera.Parameters parameters = c.this.S.getParameters();
                if (c.this.a(parameters, location2)) {
                    c.this.S.setParameters(parameters);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean a(Camera.Parameters parameters, Location location) {
        if (this.l == null) {
            return true;
        }
        parameters.setGpsLatitude(this.l.getLatitude());
        parameters.setGpsLongitude(this.l.getLongitude());
        parameters.setGpsAltitude(this.l.getAltitude());
        parameters.setGpsTimestamp(this.l.getTime());
        parameters.setGpsProcessingMethod(this.l.getProvider());
        if (!this.F || this.w == null) {
            return true;
        }
        this.w.setLocation((float) this.l.getLatitude(), (float) this.l.getLongitude());
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(n nVar) {
        if (nVar != this.f15620e) {
            this.f15620e = nVar;
            a((ak<Void>) null, true, (Runnable) new Runnable() {
                public void run() {
                    if (c.this.M()) {
                        c.this.l();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ao aoVar) {
        final ao aoVar2 = this.f15622g;
        this.f15622g = aoVar;
        a((ak<Void>) this.K, true, (Runnable) new Runnable() {
            public void run() {
                Camera.Parameters parameters = c.this.S.getParameters();
                if (c.this.a(parameters, aoVar2)) {
                    c.this.S.setParameters(parameters);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean a(Camera.Parameters parameters, ao aoVar) {
        if (this.s.a((k) this.f15622g)) {
            parameters.setWhiteBalance((String) this.t.a(this.f15622g));
            return true;
        }
        this.f15622g = aoVar;
        return false;
    }

    /* access modifiers changed from: package-private */
    public void a(x xVar) {
        final x xVar2 = this.k;
        this.k = xVar;
        a((ak<Void>) this.L, true, (Runnable) new Runnable() {
            public void run() {
                Camera.Parameters parameters = c.this.S.getParameters();
                if (c.this.a(parameters, xVar2)) {
                    c.this.S.setParameters(parameters);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean a(Camera.Parameters parameters, x xVar) {
        if (this.s.a((k) this.k)) {
            parameters.setSceneMode((String) this.t.a(this.k));
            return true;
        }
        this.k = xVar;
        return false;
    }

    /* access modifiers changed from: private */
    @TargetApi(17)
    public boolean b(boolean z) {
        if (Build.VERSION.SDK_INT >= 17) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(this.q, cameraInfo);
            if (cameraInfo.canDisableShutterSound) {
                this.S.enableShutterSound(this.p);
                return true;
            }
        }
        if (this.p) {
            return true;
        }
        this.p = z;
        return false;
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        if (this.m != bVar) {
            if (this.F) {
                R.c("Audio setting was changed while recording. Changes will take place starting from next video");
            }
            this.m = bVar;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(o oVar) {
        final o oVar2 = this.f15621f;
        this.f15621f = oVar;
        a((ak<Void>) this.J, true, (Runnable) new Runnable() {
            public void run() {
                Camera.Parameters parameters = c.this.S.getParameters();
                if (c.this.a(parameters, oVar2)) {
                    c.this.S.setParameters(parameters);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean a(Camera.Parameters parameters, o oVar) {
        if (this.s.a((k) this.f15621f)) {
            parameters.setFlashMode((String) this.t.a(this.f15621f));
            return true;
        }
        this.f15621f = oVar;
        return false;
    }

    /* access modifiers changed from: private */
    public void a(Camera.Parameters parameters) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (this.j == ae.VIDEO && supportedFocusModes.contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
        } else if (supportedFocusModes.contains("continuous-picture")) {
            parameters.setFocusMode("continuous-picture");
        } else if (supportedFocusModes.contains("infinity")) {
            parameters.setFocusMode("infinity");
        } else if (supportedFocusModes.contains("fixed")) {
            parameters.setFocusMode("fixed");
        }
    }

    /* access modifiers changed from: package-private */
    public void a(an anVar) {
        final an anVar2 = this.h;
        this.h = anVar;
        a((ak<Void>) this.N, true, (Runnable) new Runnable() {
            public void run() {
                if (c.this.F) {
                    c.this.h = anVar2;
                    throw new IllegalStateException("Can't change video quality while recording a video.");
                } else if (c.this.j == ae.VIDEO) {
                    af afVar = c.this.A;
                    c cVar = c.this;
                    cVar.A = cVar.H();
                    if (!c.this.A.equals(afVar)) {
                        Camera.Parameters parameters = c.this.S.getParameters();
                        parameters.setPictureSize(c.this.A.a(), c.this.A.b());
                        c.this.S.setParameters(parameters);
                        c.this.b();
                    }
                    c.R.b("setVideoQuality:", "captureSize:", c.this.A);
                    c.R.b("setVideoQuality:", "previewSize:", c.this.B);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void e() {
        R.a("capturePicture: scheduling");
        a((ak<Void>) null, true, (Runnable) new Runnable() {
            public void run() {
                final boolean z = false;
                c.R.a("capturePicture: performing.", Boolean.valueOf(c.this.E));
                if (!c.this.E) {
                    if (!c.this.F || c.this.s.g()) {
                        c cVar = c.this;
                        cVar.E = true;
                        int G = cVar.G();
                        final boolean z2 = ((c.this.F() + G) + 180) % 180 == 0;
                        if (c.this.f15620e == n.FRONT) {
                            z = true;
                        }
                        Camera.Parameters parameters = c.this.S.getParameters();
                        parameters.setRotation(G);
                        c.this.S.setParameters(parameters);
                        c.this.S.takePicture(new Camera.ShutterCallback() {
                            public void onShutter() {
                                c.this.f15616a.a(false);
                            }
                        }, (Camera.PictureCallback) null, (Camera.PictureCallback) null, new Camera.PictureCallback() {
                            public void onPictureTaken(byte[] bArr, Camera camera) {
                                c.this.E = false;
                                c.this.f15616a.a(bArr, z2, z);
                                camera.startPreview();
                            }
                        });
                    }
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void f() {
        R.a("captureSnapshot: scheduling");
        a((ak<Void>) null, true, (Runnable) new Runnable() {
            public void run() {
                c.R.a("captureSnapshot: performing.", Boolean.valueOf(c.this.E));
                if (!c.this.E) {
                    if (c.this.F) {
                        c.this.e();
                        return;
                    }
                    c cVar = c.this;
                    cVar.E = true;
                    cVar.S.setOneShotPreviewCallback(new Camera.PreviewCallback() {
                        public void onPreviewFrame(byte[] bArr, Camera camera) {
                            boolean z = true;
                            c.this.f15616a.a(true);
                            final int G = c.this.G();
                            final boolean z2 = ((c.this.F() + G) + 180) % 180 == 0;
                            final boolean z3 = c.this.f15620e == n.FRONT;
                            if (G % 180 == 0) {
                                z = false;
                            }
                            final int a2 = c.this.B.a();
                            final int b2 = c.this.B.b();
                            final int i = z ? b2 : a2;
                            final int i2 = z ? a2 : b2;
                            final int i3 = c.this.C;
                            final byte[] bArr2 = bArr;
                            ap.a((Runnable) new Runnable() {
                                public void run() {
                                    c.R.a("captureSnapshot: rotating.");
                                    byte[] a2 = ac.a(bArr2, a2, b2, G);
                                    c.R.a("captureSnapshot: rotated.");
                                    c.this.f15616a.a(new YuvImage(a2, i3, i, i2, (int[]) null), z2, z3);
                                    c.this.E = false;
                                }
                            });
                            c.this.S.setPreviewCallbackWithBuffer((Camera.PreviewCallback) null);
                            c.this.S.setPreviewCallbackWithBuffer(c.this);
                            c.this.u.a(ImageFormat.getBitsPerPixel(c.this.C), c.this.B);
                        }
                    });
                }
            }
        });
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        this.f15616a.a(this.u.a(bArr, System.currentTimeMillis(), G(), this.B, this.C));
    }

    /* access modifiers changed from: private */
    public boolean N() {
        int i = this.G;
        if (i == -1 || i == 0) {
            return false;
        }
        return i != 1 ? i == 2 : this.S != null;
    }

    private void O() {
        R.b("endVideoImmediately:", "is capturing:", Boolean.valueOf(this.F));
        this.F = false;
        if (this.w != null) {
            try {
                this.w.stop();
            } catch (Exception e2) {
                R.c("endVideoImmediately:", "Error while closing media recorder. Swallowing", e2);
            }
            this.w.release();
            this.w = null;
        }
        if (this.x != null) {
            this.f15616a.a(this.x);
            this.x = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(final float f2, final PointF[] pointFArr, final boolean z) {
        a((ak<Void>) this.H, true, (Runnable) new Runnable() {
            public void run() {
                if (c.this.s.f()) {
                    c cVar = c.this;
                    cVar.n = f2;
                    Camera.Parameters parameters = cVar.S.getParameters();
                    parameters.setZoom((int) (f2 * ((float) parameters.getMaxZoom())));
                    c.this.S.setParameters(parameters);
                    if (z) {
                        c.this.f15616a.a(f2, pointFArr);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, float[] fArr, PointF[] pointFArr, boolean z) {
        final float f3 = f2;
        final boolean z2 = z;
        final float[] fArr2 = fArr;
        final PointF[] pointFArr2 = pointFArr;
        a((ak<Void>) this.I, true, (Runnable) new Runnable() {
            public void run() {
                if (c.this.s.i()) {
                    float f2 = f3;
                    float k = c.this.s.k();
                    float j = c.this.s.j();
                    if (f2 < j) {
                        f2 = j;
                    } else if (f2 > k) {
                        f2 = k;
                    }
                    c cVar = c.this;
                    cVar.o = f2;
                    Camera.Parameters parameters = cVar.S.getParameters();
                    parameters.setExposureCompensation((int) (f2 / parameters.getExposureCompensationStep()));
                    c.this.S.setParameters(parameters);
                    if (z2) {
                        c.this.f15616a.a(f2, fArr2, pointFArr2);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void a(s sVar, PointF pointF) {
        final int i;
        final int i2;
        if (this.f15617b == null || !this.f15617b.f()) {
            i2 = 0;
            i = 0;
        } else {
            int width = this.f15617b.a().getWidth();
            i = this.f15617b.a().getHeight();
            i2 = width;
        }
        final PointF pointF2 = pointF;
        final s sVar2 = sVar;
        a((ak<Void>) null, true, (Runnable) new Runnable() {
            public void run() {
                if (c.this.s.h()) {
                    final PointF pointF = new PointF(pointF2.x, pointF2.y);
                    List a2 = c.b((double) pointF.x, (double) pointF.y, i2, i, c.this.F());
                    List subList = a2.subList(0, 1);
                    Camera.Parameters parameters = c.this.S.getParameters();
                    int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
                    int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
                    if (maxNumFocusAreas > 0) {
                        parameters.setFocusAreas(maxNumFocusAreas > 1 ? a2 : subList);
                    }
                    if (maxNumMeteringAreas > 0) {
                        if (maxNumMeteringAreas <= 1) {
                            a2 = subList;
                        }
                        parameters.setMeteringAreas(a2);
                    }
                    parameters.setFocusMode("auto");
                    c.this.S.setParameters(parameters);
                    c.this.f15616a.a(sVar2, pointF);
                    c.this.S.autoFocus(new Camera.AutoFocusCallback() {
                        public void onAutoFocus(boolean z, Camera camera) {
                            c.this.f15616a.a(sVar2, z, pointF);
                            c.this.f15618c.a().removeCallbacks(c.this.V);
                            c.this.f15618c.a().postDelayed(c.this.V, 3000);
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static List<Camera.Area> b(double d2, double d3, int i, int i2, int i3) {
        double d4 = (double) i;
        Double.isNaN(d4);
        double d5 = ((d2 / d4) * 2000.0d) - 0.00408935546875d;
        double d6 = (double) i2;
        Double.isNaN(d6);
        double d7 = ((d3 / d6) * 2000.0d) - 0.00408935546875d;
        double d8 = (double) (-i3);
        Double.isNaN(d8);
        double d9 = (d8 * 3.141592653589793d) / 180.0d;
        double cos = (Math.cos(d9) * d5) - (Math.sin(d9) * d7);
        double cos2 = (Math.cos(d9) * d7) + (Math.sin(d9) * d5);
        R.b("focus:", "viewClickX:", Double.valueOf(d5), "viewClickY:", Double.valueOf(d7));
        R.b("focus:", "sensorClickX:", Double.valueOf(cos), "sensorClickY:", Double.valueOf(cos2));
        double d10 = cos;
        double d11 = cos2;
        Rect a2 = a(d10, d11, 150.0d);
        Rect a3 = a(d10, d11, 300.0d);
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new Camera.Area(a2, 1000));
        arrayList.add(new Camera.Area(a3, 100));
        return arrayList;
    }

    private static Rect a(double d2, double d3, double d4) {
        double d5 = d4 / 2.0d;
        int max = (int) Math.max(d3 - d5, -1000.0d);
        int min = (int) Math.min(d3 + d5, 1000.0d);
        int max2 = (int) Math.max(d2 - d5, -1000.0d);
        int min2 = (int) Math.min(d2 + d5, 1000.0d);
        R.b("focus:", "computeMeteringArea:", "top:", Integer.valueOf(max), "left:", Integer.valueOf(max2), "bottom:", Integer.valueOf(min), "right:", Integer.valueOf(min2));
        return new Rect(max2, max, min2, min);
    }

    /* access modifiers changed from: private */
    public List<af> b(List<Camera.Size> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Camera.Size next : list) {
            af afVar = new af(next.width, next.height);
            if (!arrayList.contains(afVar)) {
                arrayList.add(afVar);
            }
        }
        R.b("size:", "sizesFromList:", arrayList);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        final boolean z2 = this.p;
        this.p = z;
        a((ak<Void>) this.P, true, (Runnable) new Runnable() {
            public void run() {
                boolean unused = c.this.b(z2);
            }
        });
    }
}
