package com.tencent.liteav.capturer;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.basic.e.b;
import com.tencent.liteav.basic.log.TXCLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import tencent.tls.platform.TLSErrInfo;

public class a implements Camera.AutoFocusCallback, Camera.ErrorCallback, Camera.PreviewCallback {

    /* renamed from: c  reason: collision with root package name */
    private static final String f31583c = "a";

    /* renamed from: a  reason: collision with root package name */
    private Matrix f31584a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private int f31585b = 0;

    /* renamed from: d  reason: collision with root package name */
    private Camera f31586d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f31587e = true;

    /* renamed from: f  reason: collision with root package name */
    private b f31588f;

    /* renamed from: g  reason: collision with root package name */
    private int f31589g = 15;
    private int h;
    private int i = 1;
    private int j;
    private int k;
    private int l;
    private int m;
    private SurfaceTexture n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r = false;
    private int s;
    private int t;
    private boolean u = false;

    public void a(b bVar) {
        this.f31588f = bVar;
    }

    public void a(SurfaceTexture surfaceTexture) {
        this.n = surfaceTexture;
    }

    public boolean a(boolean z) {
        this.q = z;
        Camera camera = this.f31586d;
        if (camera == null) {
            return false;
        }
        boolean z2 = true;
        Camera.Parameters parameters = camera.getParameters();
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (z) {
            if (supportedFlashModes != null && supportedFlashModes.contains("torch")) {
                TXCLog.i(f31583c, "set FLASH_MODE_TORCH");
                parameters.setFlashMode("torch");
                this.f31586d.setParameters(parameters);
                return z2;
            }
        } else if (supportedFlashModes != null && supportedFlashModes.contains("off")) {
            TXCLog.i(f31583c, "set FLASH_MODE_OFF");
            parameters.setFlashMode("off");
            this.f31586d.setParameters(parameters);
            return z2;
        }
        z2 = false;
        try {
            this.f31586d.setParameters(parameters);
            return z2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void a(int i2) {
        this.h = i2;
    }

    public void b(int i2) {
        this.f31589g = i2;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(float r6, float r7) {
        /*
            r5 = this;
            boolean r0 = r5.u
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            android.hardware.Camera r0 = r5.f31586d     // Catch:{ Exception -> 0x0050 }
            r0.cancelAutoFocus()     // Catch:{ Exception -> 0x0050 }
            android.hardware.Camera r0 = r5.f31586d     // Catch:{ Exception -> 0x0050 }
            android.hardware.Camera$Parameters r0 = r0.getParameters()     // Catch:{ Exception -> 0x0050 }
            boolean r1 = r5.o
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r1 == 0) goto L_0x002c
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.hardware.Camera$Area r3 = new android.hardware.Camera$Area
            r4 = 1073741824(0x40000000, float:2.0)
            android.graphics.Rect r4 = r5.a((float) r6, (float) r7, (float) r4)
            r3.<init>(r4, r2)
            r1.add(r3)
            r0.setFocusAreas(r1)
        L_0x002c:
            boolean r1 = r5.p
            if (r1 == 0) goto L_0x0046
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.hardware.Camera$Area r3 = new android.hardware.Camera$Area
            r4 = 1077936128(0x40400000, float:3.0)
            android.graphics.Rect r6 = r5.a((float) r6, (float) r7, (float) r4)
            r3.<init>(r6, r2)
            r1.add(r3)
            r0.setMeteringAreas(r1)
        L_0x0046:
            android.hardware.Camera r6 = r5.f31586d     // Catch:{  }
            r6.setParameters(r0)     // Catch:{  }
            android.hardware.Camera r6 = r5.f31586d     // Catch:{  }
            r6.autoFocus(r5)     // Catch:{  }
        L_0x0050:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.capturer.a.a(float, float):void");
    }

    public void b(boolean z) {
        this.u = z;
    }

    private Rect a(float f2, float f3, float f4) {
        float f5 = f4 * 200.0f;
        if (this.f31587e) {
            f2 = 1.0f - f2;
        }
        int i2 = 0;
        while (i2 < this.l / 90) {
            i2++;
            float f6 = (-(-(f3 - 0.5f))) + 0.5f;
            f3 = (-(f2 - 0.5f)) + 0.5f;
            f2 = f6;
        }
        int i3 = (int) ((f2 * 2000.0f) - 1000.0f);
        int i4 = (int) ((f3 * 2000.0f) - 1000.0f);
        if (i3 < -1000) {
            i3 = TLSErrInfo.TIMEOUT;
        }
        if (i4 < -1000) {
            i4 = TLSErrInfo.TIMEOUT;
        }
        int i5 = (int) f5;
        int i6 = i3 + i5;
        int i7 = i5 + i4;
        if (i6 > 1000) {
            i6 = 1000;
        }
        if (i7 > 1000) {
            i7 = 1000;
        }
        return new Rect(i3, i4, i6, i7);
    }

    public int a() {
        Camera camera = this.f31586d;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            if (parameters.getMaxZoom() > 0 && parameters.isZoomSupported()) {
                return parameters.getMaxZoom();
            }
        }
        return 0;
    }

    public boolean c(int i2) {
        Camera camera = this.f31586d;
        if (camera == null) {
            return false;
        }
        Camera.Parameters parameters = camera.getParameters();
        if (parameters.getMaxZoom() <= 0 || !parameters.isZoomSupported()) {
            TXCLog.e(f31583c, "camera not support zoom!");
            return false;
        } else if (i2 < 0 || i2 > parameters.getMaxZoom()) {
            String str = f31583c;
            TXCLog.e(str, "invalid zoom value : " + i2 + ", while max zoom is " + parameters.getMaxZoom());
            return false;
        } else {
            try {
                parameters.setZoom(i2);
                this.f31586d.setParameters(parameters);
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
    }

    public void a(boolean z, int i2, int i3) {
        this.r = z;
        this.s = i2;
        this.t = i3;
    }

    public void a(float f2) {
        if (this.f31586d != null) {
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            if (f2 < -1.0f) {
                f2 = -1.0f;
            }
            Camera.Parameters parameters = this.f31586d.getParameters();
            int minExposureCompensation = parameters.getMinExposureCompensation();
            int maxExposureCompensation = parameters.getMaxExposureCompensation();
            if (minExposureCompensation == 0 || maxExposureCompensation == 0) {
                TXCLog.e(f31583c, "camera not support setExposureCompensation!");
            } else {
                int d2 = b.a().d();
                float f3 = (float) maxExposureCompensation;
                float f4 = f2 * f3;
                if (d2 != 0 && d2 <= maxExposureCompensation && d2 >= minExposureCompensation) {
                    String str = f31583c;
                    TXCLog.d(str, "camera setExposureCompensation: " + d2);
                    parameters.setExposureCompensation(d2);
                } else if (f4 <= f3 && f4 >= ((float) minExposureCompensation)) {
                    String str2 = f31583c;
                    TXCLog.d(str2, "camera setExposureCompensation: " + f4);
                    parameters.setExposureCompensation((int) f4);
                }
            }
            try {
                this.f31586d.setParameters(parameters);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void d(int i2) {
        this.i = i2;
        this.l = (((this.m - 90) + (this.i * 90)) + 360) % 360;
    }

    public int c(boolean z) {
        try {
            TXCLog.d(f31583c, "trtc_capture: start capture");
            if (this.n == null) {
                return -2;
            }
            if (this.f31586d != null) {
                b();
            }
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < Camera.getNumberOfCameras(); i4++) {
                Camera.getCameraInfo(i4, cameraInfo);
                String str = f31583c;
                TXCLog.i(str, "camera index " + i4 + ", facing = " + cameraInfo.facing);
                if (cameraInfo.facing == 1) {
                    i2 = i4;
                }
                if (cameraInfo.facing == 0) {
                    i3 = i4;
                }
            }
            String str2 = f31583c;
            TXCLog.i(str2, "camera front, id = " + i2);
            String str3 = f31583c;
            TXCLog.i(str3, "camera back , id = " + i3);
            if (i2 == -1 && i3 != -1) {
                i2 = i3;
            }
            if (i3 == -1 && i2 != -1) {
                i3 = i2;
            }
            this.f31587e = z;
            if (this.f31587e) {
                this.f31586d = Camera.open(i2);
            } else {
                this.f31586d = Camera.open(i3);
            }
            Camera.Parameters parameters = this.f31586d.getParameters();
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (this.u && supportedFocusModes != null && supportedFocusModes.contains("auto")) {
                TXCLog.i(f31583c, "support FOCUS_MODE_AUTO");
                parameters.setFocusMode("auto");
            } else if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                TXCLog.i(f31583c, "support FOCUS_MODE_CONTINUOUS_VIDEO");
                parameters.setFocusMode("continuous-video");
            }
            if (Build.VERSION.SDK_INT >= 14) {
                if (parameters.getMaxNumFocusAreas() > 0) {
                    this.o = true;
                }
                if (parameters.getMaxNumMeteringAreas() > 0) {
                    this.p = true;
                }
            }
            if (this.r) {
                parameters.setPreviewFormat(17);
                this.f31586d.setPreviewCallback(this);
                a(parameters);
            } else {
                b(parameters);
            }
            parameters.setPreviewSize(this.j, this.k);
            int[] g2 = g(this.f31589g);
            if (g2 != null) {
                parameters.setPreviewFpsRange(g2[0], g2[1]);
            } else {
                parameters.setPreviewFrameRate(f(this.f31589g));
            }
            if (!this.f31587e) {
                i2 = i3;
            }
            this.m = h(i2);
            this.l = (((this.m - 90) + (this.i * 90)) + 360) % 360;
            this.f31586d.setDisplayOrientation(0);
            String str4 = f31583c;
            TXCLog.d(str4, "camera orientation " + this.m + ", preview " + this.l + ", home orientation " + this.i);
            this.f31586d.setPreviewTexture(this.n);
            this.f31586d.setParameters(parameters);
            this.f31586d.setErrorCallback(this);
            this.f31586d.startPreview();
            return 0;
        } catch (IOException e2) {
            e2.printStackTrace();
            return -1;
        } catch (Exception e3) {
            e3.printStackTrace();
            return -1;
        }
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        b bVar = this.f31588f;
        if (bVar != null) {
            bVar.a(bArr);
        }
    }

    public void b() {
        Camera camera = this.f31586d;
        if (camera != null) {
            try {
                camera.setErrorCallback((Camera.ErrorCallback) null);
                this.f31586d.setPreviewCallback((Camera.PreviewCallback) null);
                this.f31586d.stopPreview();
                this.f31586d.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                this.f31586d = null;
                this.n = null;
                throw th;
            }
            this.f31586d = null;
            this.n = null;
        }
    }

    public int c() {
        return this.l;
    }

    public boolean d() {
        return this.f31587e;
    }

    public int e() {
        return this.j;
    }

    public int f() {
        return this.k;
    }

    public Camera g() {
        return this.f31586d;
    }

    private void a(Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        String str = "\n";
        if (supportedPreviewSizes != null) {
            String str2 = str;
            for (int i2 = 0; i2 < supportedPreviewSizes.size(); i2++) {
                Camera.Size size = supportedPreviewSizes.get(i2);
                str2 = str2 + String.format("camera preview supported size %d x %d\n", new Object[]{Integer.valueOf(size.width), Integer.valueOf(size.height)});
            }
            str = str2;
        }
        TXCLog.i(f31583c, str);
        TXCLog.w(f31583c, "camera preview wanted:" + this.s + "*" + this.t);
        this.j = supportedPreviewSizes.get(0).width;
        this.k = supportedPreviewSizes.get(0).height;
        int i3 = this.s;
        int i4 = this.t;
        if (i3 < i4) {
            i3 = i4;
        }
        int i5 = this.s;
        int i6 = this.t;
        if (i5 >= i6) {
            i5 = i6;
        }
        int size2 = supportedPreviewSizes.size() - 1;
        while (true) {
            if (size2 < 0) {
                break;
            }
            Camera.Size size3 = supportedPreviewSizes.get(size2);
            if (size3.width >= i3 && size3.width >= 640 && size3.height >= i5 && size3.height >= 480) {
                this.j = size3.width;
                this.k = size3.height;
                break;
            }
            size2--;
        }
        TXCLog.w(f31583c, "camera preview GOT:" + this.j + "*" + this.k);
    }

    private void b(Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        String str = "\n";
        if (supportedPreviewSizes != null) {
            String str2 = str;
            for (int i2 = 0; i2 < supportedPreviewSizes.size(); i2++) {
                Camera.Size size = supportedPreviewSizes.get(i2);
                str2 = str2 + String.format("camera preview supported size %d x %d\n", new Object[]{Integer.valueOf(size.width), Integer.valueOf(size.height)});
            }
            str = str2;
        }
        TXCLog.i(f31583c, str);
        C0489a e2 = e(this.h);
        if (e2 == null) {
            this.f31586d.release();
            this.f31586d = null;
            TXCLog.d(f31583c, "camera preview 不支持的视频分辨率 " + this.h);
            return;
        }
        this.j = e2.f31591a;
        this.k = e2.f31592b;
        TXCLog.w(f31583c, "camera preview GOT:" + this.j + "*" + this.k);
    }

    private C0489a e(int i2) {
        int i3 = i2;
        List<Camera.Size> supportedPreviewSizes = this.f31586d.getParameters().getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList();
        String str = f31583c;
        TXCLog.w(str, "wanted Resolution:" + i3);
        switch (i3) {
            case 1:
            case 2:
            case 4:
                arrayList.add(new C0489a(640, 360));
                arrayList.add(new C0489a(768, 432));
                arrayList.add(new C0489a(640, 480));
                arrayList.add(new C0489a(TXEAudioDef.TXE_OPUS_SAMPLE_NUM, 544));
                arrayList.add(new C0489a(TXEAudioDef.TXE_OPUS_SAMPLE_NUM, 540));
                arrayList.add(new C0489a(800, 480));
                arrayList.add(new C0489a(TXEAudioDef.TXE_OPUS_SAMPLE_NUM, 720));
                arrayList.add(new C0489a(1280, 720));
                break;
            case 3:
                break;
            case 5:
                arrayList.add(new C0489a(TXEAudioDef.TXE_OPUS_SAMPLE_NUM, 544));
                arrayList.add(new C0489a(TXEAudioDef.TXE_OPUS_SAMPLE_NUM, 540));
                arrayList.add(new C0489a(TXEAudioDef.TXE_OPUS_SAMPLE_NUM, 720));
                arrayList.add(new C0489a(1280, 720));
                arrayList.add(new C0489a(800, 480));
                arrayList.add(new C0489a(640, 360));
                arrayList.add(new C0489a(640, 480));
                break;
            case 6:
                arrayList.add(new C0489a(1280, 720));
                arrayList.add(new C0489a(1920, 1088));
                arrayList.add(new C0489a(1920, 1080));
                arrayList.add(new C0489a(TXEAudioDef.TXE_OPUS_SAMPLE_NUM, 544));
                arrayList.add(new C0489a(TXEAudioDef.TXE_OPUS_SAMPLE_NUM, 540));
                arrayList.add(new C0489a(TXEAudioDef.TXE_OPUS_SAMPLE_NUM, 720));
                arrayList.add(new C0489a(800, 480));
                arrayList.add(new C0489a(640, 360));
                arrayList.add(new C0489a(640, 480));
                break;
            case 7:
                arrayList.add(new C0489a(1920, 1088));
                arrayList.add(new C0489a(1920, 1080));
                arrayList.add(new C0489a(1280, 720));
                arrayList.add(new C0489a(TXEAudioDef.TXE_OPUS_SAMPLE_NUM, 544));
                arrayList.add(new C0489a(TXEAudioDef.TXE_OPUS_SAMPLE_NUM, 540));
                arrayList.add(new C0489a(TXEAudioDef.TXE_OPUS_SAMPLE_NUM, 720));
                arrayList.add(new C0489a(800, 480));
                arrayList.add(new C0489a(768, 432));
                arrayList.add(new C0489a(640, 360));
                arrayList.add(new C0489a(640, 480));
                break;
        }
        arrayList.add(new C0489a(480, 320));
        arrayList.add(new C0489a(640, 360));
        arrayList.add(new C0489a(640, 480));
        arrayList.add(new C0489a(768, 432));
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            C0489a aVar = (C0489a) arrayList.get(i4);
            for (int i5 = 0; i5 < supportedPreviewSizes.size(); i5++) {
                Camera.Size size = supportedPreviewSizes.get(i5);
                if (size.width == aVar.f31591a && size.height == aVar.f31592b) {
                    String str2 = f31583c;
                    TXCLog.w(str2, "GOT Size:" + aVar.f31591a + "*" + aVar.f31592b);
                    return aVar;
                }
            }
        }
        return null;
    }

    public void onAutoFocus(boolean z, Camera camera) {
        if (z) {
            TXCLog.i(f31583c, "AUTO focus success");
        } else {
            TXCLog.i(f31583c, "AUTO focus failed");
        }
    }

    public void onError(int i2, Camera camera) {
        String str = f31583c;
        TXCLog.w(str, "camera catch error " + i2);
        if (!this.r) {
            return;
        }
        if (i2 == 1 || i2 == 2 || i2 == 100) {
            b bVar = this.f31588f;
            if (bVar != null) {
                bVar.h();
            }
        }
    }

    /* renamed from: com.tencent.liteav.capturer.a$a  reason: collision with other inner class name */
    private class C0489a {

        /* renamed from: a  reason: collision with root package name */
        public int f31591a = 1280;

        /* renamed from: b  reason: collision with root package name */
        public int f31592b = 720;

        C0489a(int i, int i2) {
            this.f31591a = i;
            this.f31592b = i2;
        }
    }

    private int f(int i2) {
        List<Integer> supportedPreviewFrameRates = this.f31586d.getParameters().getSupportedPreviewFrameRates();
        if (supportedPreviewFrameRates == null) {
            TXCLog.e(f31583c, "getSupportedFPS error");
            return 1;
        }
        int intValue = supportedPreviewFrameRates.get(0).intValue();
        for (int i3 = 0; i3 < supportedPreviewFrameRates.size(); i3++) {
            int intValue2 = supportedPreviewFrameRates.get(i3).intValue();
            if (Math.abs(intValue2 - i2) - Math.abs(intValue - i2) < 0) {
                intValue = intValue2;
            }
        }
        String str = f31583c;
        TXCLog.i(str, "choose fps=" + intValue);
        return intValue;
    }

    private int[] g(int i2) {
        int[] iArr;
        int i3 = i2 * 1000;
        String str = "camera supported preview fps range: wantFPS = " + i3 + "\n";
        List<int[]> supportedPreviewFpsRange = this.f31586d.getParameters().getSupportedPreviewFpsRange();
        if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.size() <= 0) {
            return null;
        }
        int[] iArr2 = supportedPreviewFpsRange.get(0);
        Collections.sort(supportedPreviewFpsRange, new Comparator<int[]>() {
            /* renamed from: a */
            public int compare(int[] iArr, int[] iArr2) {
                return iArr[1] - iArr2[1];
            }
        });
        for (int[] next : supportedPreviewFpsRange) {
            str = str + "camera supported preview fps range: " + next[0] + " - " + next[1] + "\n";
        }
        Iterator<int[]> it = supportedPreviewFpsRange.iterator();
        while (true) {
            if (!it.hasNext()) {
                iArr = iArr2;
                break;
            }
            iArr = it.next();
            if (iArr[0] <= i3 && i3 <= iArr[1]) {
                break;
            }
        }
        TXCLog.i(f31583c, str + "choose preview fps range: " + iArr[0] + " - " + iArr[1]);
        return iArr;
    }

    private int h(int i2) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i2, cameraInfo);
        String str = f31583c;
        TXCLog.d(str, "camera orientation " + cameraInfo.orientation);
        int i3 = cameraInfo.orientation;
        if (i3 == 0 || i3 == 180) {
            i3 += 90;
        }
        if (cameraInfo.facing == 1) {
            return (360 - i3) % 360;
        }
        return (i3 + 360) % 360;
    }
}
