package com.shopee.arcatch.page.cameraview.common;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.google.android.gms.common.images.Size;
import com.shopee.arcatch.c.g.c;
import com.tencent.liteav.audio.TXEAudioDef;
import java.io.IOException;
import java.lang.Thread;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"MissingPermission"})
public class a {

    /* renamed from: a  reason: collision with root package name */
    protected Activity f26973a;

    /* renamed from: b  reason: collision with root package name */
    protected int f26974b = 1;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Camera f26975c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f26976d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Size f26977e;

    /* renamed from: f  reason: collision with root package name */
    private float f26978f = 24.0f;

    /* renamed from: g  reason: collision with root package name */
    private int f26979g = TXEAudioDef.TXE_OPUS_SAMPLE_NUM;
    private int h = 544;
    private final boolean i = true;
    private final GraphicOverlay j;
    private boolean k;
    /* access modifiers changed from: private */
    public Thread l;
    /* access modifiers changed from: private */
    public final b m;
    /* access modifiers changed from: private */
    public final Object n = new Object();
    /* access modifiers changed from: private */
    public b o;
    /* access modifiers changed from: private */
    public final Map<byte[], ByteBuffer> p = new IdentityHashMap();

    public a(Activity activity, GraphicOverlay graphicOverlay) {
        this.f26973a = activity;
        this.j = graphicOverlay;
        this.j.a();
        this.m = new b();
        this.f26978f = c.e();
        if (Camera.getNumberOfCameras() == 1) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(0, cameraInfo);
            this.f26974b = cameraInfo.facing;
        }
    }

    public String a() {
        if (this.f26977e == null) {
            return "";
        }
        return this.f26977e.getWidth() + "*" + this.f26977e.getHeight();
    }

    public void a(int i2, int i3) {
        this.f26979g = i2;
        this.h = i3;
    }

    public void b() {
        synchronized (this.n) {
            c();
            this.m.a();
            h();
            if (this.o != null) {
                this.o.a();
            }
        }
    }

    public synchronized a a(SurfaceHolder surfaceHolder) throws IOException {
        if (this.f26975c != null) {
            return this;
        }
        this.f26975c = g();
        this.f26975c.setPreviewDisplay(surfaceHolder);
        this.f26975c.startPreview();
        this.l = new Thread(this.m);
        this.m.a(true);
        this.l.start();
        this.k = false;
        return this;
    }

    public synchronized void c() {
        this.m.a(false);
        if (this.l != null) {
            try {
                this.l.join();
            } catch (InterruptedException unused) {
                com.shopee.e.a.a.a((Object) "Frame processing thread interrupted on release.");
            }
            this.l = null;
        }
        if (this.f26975c != null) {
            try {
                this.f26975c.stopPreview();
                this.f26975c.setPreviewCallbackWithBuffer((Camera.PreviewCallback) null);
                if (this.k) {
                    this.f26975c.setPreviewTexture((SurfaceTexture) null);
                } else {
                    this.f26975c.setPreviewDisplay((SurfaceHolder) null);
                }
            } catch (Exception e2) {
                com.shopee.e.a.a.b("CameraSource", "Failed to clear camera preview: " + e2);
            }
            this.f26975c.release();
            this.f26975c = null;
        }
        this.p.clear();
    }

    public Size d() {
        return this.f26977e;
    }

    public float e() {
        return this.f26978f;
    }

    public int f() {
        return this.f26974b;
    }

    @SuppressLint({"InlinedApi"})
    private Camera g() throws IOException {
        int a2 = a(this.f26974b);
        if (a2 != -1) {
            Camera open = Camera.open(a2);
            if (open != null) {
                Size a3 = a(open, this.f26979g, this.h);
                if (a3 != null) {
                    this.f26977e = a3;
                    int[] a4 = a(open, this.f26978f);
                    if (a4 != null) {
                        Camera.Parameters parameters = open.getParameters();
                        parameters.setPreviewSize(this.f26977e.getWidth(), this.f26977e.getHeight());
                        parameters.setPreviewFpsRange(a4[0], a4[1]);
                        parameters.setPreviewFormat(17);
                        a(open, parameters, a2);
                        if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                            parameters.setFocusMode("continuous-video");
                        } else {
                            com.shopee.e.a.a.c("CameraSource", "Camera auto focus is not supported on this device.");
                        }
                        open.setParameters(parameters);
                        open.setPreviewCallbackWithBuffer(new C0419a());
                        open.addCallbackBuffer(a(this.f26977e));
                        open.addCallbackBuffer(a(this.f26977e));
                        open.addCallbackBuffer(a(this.f26977e));
                        open.addCallbackBuffer(a(this.f26977e));
                        return open;
                    }
                    com.shopee.arcatch.c.b.c.a("Could not find suitable preview frames per second range.", 1);
                    throw new IOException("Could not find suitable preview frames per second range.");
                }
                com.shopee.arcatch.c.b.c.a("Could not find suitable preview size.", 1);
                throw new IOException("Could not find suitable preview size.");
            }
            com.shopee.arcatch.c.b.c.a("Could not open camera.", 1);
            throw new IOException("Could not open the camera.");
        }
        com.shopee.arcatch.c.b.c.a("Could not find requested camera.", 1);
        throw new IOException("Could not find requested camera.");
    }

    private static int a(int i2) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i3 = 0; i3 < Camera.getNumberOfCameras(); i3++) {
            Camera.getCameraInfo(i3, cameraInfo);
            if (cameraInfo.facing == i2) {
                return i3;
            }
        }
        return -1;
    }

    private static Size a(Camera camera, int i2, int i3) {
        List<Camera.Size> a2 = a(camera);
        Size size = new Size(i2, i3);
        int i4 = Integer.MAX_VALUE;
        for (Camera.Size next : a2) {
            int abs = Math.abs(next.width - i2) + Math.abs(next.height - i3);
            if (abs < i4) {
                size = new Size(next.width, next.height);
                i4 = abs;
            }
        }
        com.shopee.e.a.a.c("xxxxx", "selected preview size = " + size.getWidth() + "x" + size.getHeight());
        return size;
    }

    private static List<Camera.Size> a(Camera camera) {
        List<Camera.Size> supportedPreviewSizes = camera.getParameters().getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            supportedPreviewSizes = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        float f2 = com.shopee.arcatch.c.d.a.a().m;
        com.shopee.e.a.a.c("CameraSource", "min width height ratio = " + f2);
        for (Camera.Size size : supportedPreviewSizes) {
            float f3 = ((float) size.width) / ((float) size.height);
            if (f3 >= f2) {
                arrayList.add(size);
                com.shopee.e.a.a.d("CameraSource", "add preview size = " + size.width + "x" + size.height + ": ratio = " + f3);
            }
        }
        if (arrayList.size() == 0) {
            com.shopee.e.a.a.d("CameraSource", "No preview sizes have a corresponding same-aspect-ratio picture size");
            arrayList.addAll(supportedPreviewSizes);
        }
        return arrayList;
    }

    @SuppressLint({"InlinedApi"})
    private static int[] a(Camera camera, float f2) {
        int i2 = (int) (f2 * 1000.0f);
        int[] iArr = null;
        int i3 = Integer.MAX_VALUE;
        for (int[] next : camera.getParameters().getSupportedPreviewFpsRange()) {
            int abs = Math.abs(i2 - next[0]) + Math.abs(i2 - next[1]);
            if (abs < i3) {
                iArr = next;
                i3 = abs;
            }
        }
        return iArr;
    }

    private void a(Camera camera, Camera.Parameters parameters, int i2) {
        int i3;
        int i4;
        int rotation = ((WindowManager) this.f26973a.getSystemService("window")).getDefaultDisplay().getRotation();
        int i5 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i5 = 90;
            } else if (rotation == 2) {
                i5 = 180;
            } else if (rotation != 3) {
                com.shopee.e.a.a.b("CameraSource", "Bad rotation value: " + rotation);
            } else {
                i5 = 270;
            }
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i2, cameraInfo);
        if (cameraInfo.facing == 1) {
            i3 = (cameraInfo.orientation + i5) % 360;
            if (com.shopee.arcatch.b.c.b.a()) {
                i3 -= 90;
            }
            i4 = (360 - i3) % 360;
        } else {
            int i6 = ((cameraInfo.orientation - i5) + 360) % 360;
            if (com.shopee.arcatch.b.c.b.a()) {
                i6 -= 90;
            }
            i4 = i3;
        }
        this.f26976d = i3 / 90;
        camera.setDisplayOrientation(i4);
        parameters.setRotation(i3);
    }

    @SuppressLint({"InlinedApi"})
    private byte[] a(Size size) {
        double height = (double) (((long) size.getHeight()) * ((long) size.getWidth()) * ((long) ImageFormat.getBitsPerPixel(17)));
        Double.isNaN(height);
        byte[] bArr = new byte[(((int) Math.ceil(height / 8.0d)) + 1)];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (!wrap.hasArray() || wrap.array() != bArr) {
            throw new IllegalStateException("Failed to create valid buffer for camera source.");
        }
        this.p.put(bArr, wrap);
        return bArr;
    }

    /* renamed from: com.shopee.arcatch.page.cameraview.common.a$a  reason: collision with other inner class name */
    private class C0419a implements Camera.PreviewCallback {
        private C0419a() {
        }

        public void onPreviewFrame(byte[] bArr, Camera camera) {
            a.this.m.a(bArr, camera);
        }
    }

    public void a(b bVar) {
        synchronized (this.n) {
            h();
            if (this.o != null) {
                this.o.a();
            }
            this.o = bVar;
        }
    }

    private class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ boolean f26981a = (!a.class.desiredAssertionStatus());

        /* renamed from: c  reason: collision with root package name */
        private final Object f26983c = new Object();

        /* renamed from: d  reason: collision with root package name */
        private boolean f26984d = true;

        /* renamed from: e  reason: collision with root package name */
        private ByteBuffer f26985e;

        b() {
        }

        /* access modifiers changed from: package-private */
        @SuppressLint({"Assert"})
        public void a() {
            if (!f26981a && a.this.l.getState() != Thread.State.TERMINATED) {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z) {
            synchronized (this.f26983c) {
                this.f26984d = z;
                this.f26983c.notifyAll();
            }
        }

        /* access modifiers changed from: package-private */
        public void a(byte[] bArr, Camera camera) {
            synchronized (this.f26983c) {
                if (this.f26985e != null) {
                    camera.addCallbackBuffer(this.f26985e.array());
                    this.f26985e = null;
                }
                if (!a.this.p.containsKey(bArr)) {
                    com.shopee.e.a.a.a((Object) "Skipping frame. Could not find ByteBuffer associated with the image data from the camera.");
                    return;
                }
                this.f26985e = (ByteBuffer) a.this.p.get(bArr);
                this.f26983c.notifyAll();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r0 = com.shopee.arcatch.page.cameraview.common.a.d(r8.f26982b);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0031, code lost:
            monitor-enter(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            com.shopee.arcatch.page.cameraview.common.a.g(r8.f26982b).b(new com.google.android.gms.vision.Frame.Builder().setImageData(r1, com.shopee.arcatch.page.cameraview.common.a.f(r8.f26982b).getWidth(), com.shopee.arcatch.page.cameraview.common.a.f(r8.f26982b).getHeight(), 17).setRotation(com.shopee.arcatch.page.cameraview.common.a.e(r8.f26982b)).build());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0068, code lost:
            monitor-exit(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0069, code lost:
            com.shopee.arcatch.page.cameraview.common.a.h(r8.f26982b).addCallbackBuffer(r1.array());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x007a, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x007c, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            com.shopee.e.a.a.b("CameraSource", "Exception thrown from receiver.", r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x009a, code lost:
            com.shopee.arcatch.page.cameraview.common.a.h(r8.f26982b).addCallbackBuffer(r1.array());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a7, code lost:
            throw r0;
         */
        @android.annotation.SuppressLint({"InlinedApi"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r8 = this;
            L_0x0000:
                java.lang.Object r0 = r8.f26983c
                monitor-enter(r0)
            L_0x0003:
                boolean r1 = r8.f26984d     // Catch:{ all -> 0x00a8 }
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L_0x001f
                java.nio.ByteBuffer r1 = r8.f26985e     // Catch:{ all -> 0x00a8 }
                if (r1 != 0) goto L_0x001f
                java.lang.Object r1 = r8.f26983c     // Catch:{ InterruptedException -> 0x0013 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0013 }
                goto L_0x0003
            L_0x0013:
                r1 = move-exception
                java.lang.String r4 = "Frame processing loop terminated."
                java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x00a8 }
                r3[r2] = r1     // Catch:{ all -> 0x00a8 }
                com.shopee.e.a.a.a(r4, r3)     // Catch:{ all -> 0x00a8 }
                monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
                return
            L_0x001f:
                boolean r1 = r8.f26984d     // Catch:{ all -> 0x00a8 }
                if (r1 != 0) goto L_0x0025
                monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
                return
            L_0x0025:
                java.nio.ByteBuffer r1 = r8.f26985e     // Catch:{ all -> 0x00a8 }
                r4 = 0
                r8.f26985e = r4     // Catch:{ all -> 0x00a8 }
                monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
                com.shopee.arcatch.page.cameraview.common.a r0 = com.shopee.arcatch.page.cameraview.common.a.this     // Catch:{ Throwable -> 0x007c }
                java.lang.Object r0 = r0.n     // Catch:{ Throwable -> 0x007c }
                monitor-enter(r0)     // Catch:{ Throwable -> 0x007c }
                com.google.android.gms.vision.Frame$Builder r4 = new com.google.android.gms.vision.Frame$Builder     // Catch:{ all -> 0x0077 }
                r4.<init>()     // Catch:{ all -> 0x0077 }
                com.shopee.arcatch.page.cameraview.common.a r5 = com.shopee.arcatch.page.cameraview.common.a.this     // Catch:{ all -> 0x0077 }
                com.google.android.gms.common.images.Size r5 = r5.f26977e     // Catch:{ all -> 0x0077 }
                int r5 = r5.getWidth()     // Catch:{ all -> 0x0077 }
                com.shopee.arcatch.page.cameraview.common.a r6 = com.shopee.arcatch.page.cameraview.common.a.this     // Catch:{ all -> 0x0077 }
                com.google.android.gms.common.images.Size r6 = r6.f26977e     // Catch:{ all -> 0x0077 }
                int r6 = r6.getHeight()     // Catch:{ all -> 0x0077 }
                r7 = 17
                com.google.android.gms.vision.Frame$Builder r4 = r4.setImageData(r1, r5, r6, r7)     // Catch:{ all -> 0x0077 }
                com.shopee.arcatch.page.cameraview.common.a r5 = com.shopee.arcatch.page.cameraview.common.a.this     // Catch:{ all -> 0x0077 }
                int r5 = r5.f26976d     // Catch:{ all -> 0x0077 }
                com.google.android.gms.vision.Frame$Builder r4 = r4.setRotation(r5)     // Catch:{ all -> 0x0077 }
                com.google.android.gms.vision.Frame r4 = r4.build()     // Catch:{ all -> 0x0077 }
                com.shopee.arcatch.page.cameraview.common.a r5 = com.shopee.arcatch.page.cameraview.common.a.this     // Catch:{ all -> 0x0077 }
                com.shopee.arcatch.page.cameraview.common.b r5 = r5.o     // Catch:{ all -> 0x0077 }
                r5.b(r4)     // Catch:{ all -> 0x0077 }
                monitor-exit(r0)     // Catch:{ all -> 0x0077 }
                com.shopee.arcatch.page.cameraview.common.a r0 = com.shopee.arcatch.page.cameraview.common.a.this
                android.hardware.Camera r0 = r0.f26975c
                byte[] r1 = r1.array()
                r0.addCallbackBuffer(r1)
                goto L_0x0000
            L_0x0077:
                r4 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0077 }
                throw r4     // Catch:{ Throwable -> 0x007c }
            L_0x007a:
                r0 = move-exception
                goto L_0x009a
            L_0x007c:
                r0 = move-exception
                java.lang.String r4 = "CameraSource"
                r5 = 2
                java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x007a }
                java.lang.String r6 = "Exception thrown from receiver."
                r5[r2] = r6     // Catch:{ all -> 0x007a }
                r5[r3] = r0     // Catch:{ all -> 0x007a }
                com.shopee.e.a.a.b(r4, r5)     // Catch:{ all -> 0x007a }
                com.shopee.arcatch.page.cameraview.common.a r0 = com.shopee.arcatch.page.cameraview.common.a.this
                android.hardware.Camera r0 = r0.f26975c
                byte[] r1 = r1.array()
                r0.addCallbackBuffer(r1)
                goto L_0x0000
            L_0x009a:
                com.shopee.arcatch.page.cameraview.common.a r2 = com.shopee.arcatch.page.cameraview.common.a.this
                android.hardware.Camera r2 = r2.f26975c
                byte[] r1 = r1.array()
                r2.addCallbackBuffer(r1)
                throw r0
            L_0x00a8:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
                goto L_0x00ac
            L_0x00ab:
                throw r1
            L_0x00ac:
                goto L_0x00ab
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.arcatch.page.cameraview.common.a.b.run():void");
        }
    }

    private void h() {
        this.j.a();
    }
}
