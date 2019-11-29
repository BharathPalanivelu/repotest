package com.modiface.mfemakeupkit.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.modiface.mfemakeupkit.MFEMakeupEngine;
import com.modiface.mfemakeupkit.a.j;
import com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters;
import com.modiface.mfemakeupkit.data.MFEFaceTrackingParameters;
import com.modiface.mfemakeupkit.data.MFETrackingData;
import com.modiface.mfemakeupkit.mfea.d;
import com.modiface.mfemakeupkit.utils.MFEGLFramebuffer;
import com.modiface.mfemakeupkit.utils.MFEImage;
import com.modiface.mfemakeupkit.utils.f;
import com.modiface.mfemakeupkit.utils.n;
import com.modiface.mfemakeupkit.utils.p;
import com.modiface.mfemakeupkit.utils.s;
import com.modiface.mfemakeupkit.utils.u;
import com.modiface.mfemakeupkit.utils.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class i implements SurfaceTexture.OnFrameAvailableListener, x.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15283a = "MFEAndroidCamera";

    /* renamed from: b  reason: collision with root package name */
    private static final int f15284b = 11;

    /* renamed from: c  reason: collision with root package name */
    private static final int f15285c = 12;

    /* renamed from: d  reason: collision with root package name */
    private static final int f15286d = 13;

    /* renamed from: e  reason: collision with root package name */
    private static i f15287e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final String f15288f = "camera";
    private final Object A = new Object();

    /* renamed from: g  reason: collision with root package name */
    private WeakReference<MFEAndroidCameraErrorCallback> f15289g = new WeakReference<>((Object) null);
    private WeakReference<MFEAndroidCameraParametersCallback> h = new WeakReference<>((Object) null);
    private final List<WeakReference<b>> i = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */
    public final s j = new s("MFEAndroidCameraThread");
    /* access modifiers changed from: private */
    public AtomicBoolean k = new AtomicBoolean(false);
    private boolean l = false;
    private MFEAndroidCameraParameters m = new MFEAndroidCameraParameters();
    private Camera n = null;
    private MFEAndroidCameraParameters o = new MFEAndroidCameraParameters();
    /* access modifiers changed from: private */
    public SurfaceTexture p = null;
    /* access modifiers changed from: private */
    public int[] q = {0};
    private AtomicReference<a> r = new AtomicReference<>(new a(1080, 1920, 270, (a) null));
    /* access modifiers changed from: private */
    public MFEGLFramebuffer s = null;
    private Long t = null;
    private Camera.Size u = null;
    private Boolean v = null;
    private MFEAndroidCameraParameters.CameraRotation w = MFEAndroidCameraParameters.CameraRotation.ROTATE_0;
    /* access modifiers changed from: private */
    public final d x = new d();
    private boolean y = false;
    private final j z;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        final int f15290a;

        /* renamed from: b  reason: collision with root package name */
        final int f15291b;

        /* renamed from: c  reason: collision with root package name */
        final int f15292c;

        /* synthetic */ a(int i, int i2, int i3, a aVar) {
            this(i, i2, i3);
        }

        private a(int i, int i2, int i3) {
            this.f15290a = i;
            this.f15291b = i2;
            this.f15292c = i3;
        }
    }

    public interface b {
        void onCameraFrameDroppedFromFaceTracking(MFEImage mFEImage);

        void onFaceTrackedOnCameraFrame(MFETrackingData mFETrackingData);

        MFEImage onNewCameraFrame(p pVar);

        void onProcessCameraFrameErrors(ArrayList<Throwable> arrayList);
    }

    public interface c {
        void a(Bitmap bitmap, Throwable th);

        void a(Camera.Parameters parameters);
    }

    private i(Context context, MFEMakeupEngine.Region region) {
        if (context != null) {
            this.z = j.a(context, region);
            this.j.a((x.a) this);
            return;
        }
        throw new IllegalArgumentException("context cannot be null when in constructor of MFEAndroidCamera");
    }

    public void finalize() throws Throwable {
        b();
        super.finalize();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:11|(3:13|14|(2:16|(2:17|(2:19|(2:53|21)))))|22|23) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x005d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleMessage(android.os.Message r11) {
        /*
            r10 = this;
            java.lang.String r0 = "on"
            int r1 = r11.what
            r2 = 1
            switch(r1) {
                case 11: goto L_0x00c6;
                case 12: goto L_0x00ba;
                case 13: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x00ea
        L_0x000a:
            java.lang.Object r1 = r11.obj
            if (r1 == 0) goto L_0x0093
            com.modiface.mfemakeupkit.camera.i$c r1 = (com.modiface.mfemakeupkit.camera.i.c) r1
            java.util.concurrent.atomic.AtomicBoolean r3 = r10.k
            boolean r3 = r3.get()
            r9 = 0
            if (r3 != 0) goto L_0x0088
            android.hardware.Camera r3 = r10.n
            if (r3 == 0) goto L_0x007d
            r3.stopPreview()     // Catch:{ Throwable -> 0x0078 }
            com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters r3 = r10.o     // Catch:{ Throwable -> 0x0078 }
            boolean r5 = r3.isFrontCamera     // Catch:{ Throwable -> 0x0078 }
            java.util.concurrent.atomic.AtomicReference<com.modiface.mfemakeupkit.camera.i$a> r3 = r10.r     // Catch:{ Throwable -> 0x0078 }
            java.lang.Object r3 = r3.get()     // Catch:{ Throwable -> 0x0078 }
            com.modiface.mfemakeupkit.camera.i$a r3 = (com.modiface.mfemakeupkit.camera.i.a) r3     // Catch:{ Throwable -> 0x0078 }
            int r6 = r3.f15292c     // Catch:{ Throwable -> 0x0078 }
            com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters r3 = r10.o     // Catch:{ Throwable -> 0x0078 }
            com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters$CameraRotation r7 = r3.cameraRotation     // Catch:{ Throwable -> 0x0078 }
            android.hardware.Camera r3 = r10.n     // Catch:{ Throwable -> 0x0078 }
            android.hardware.Camera$Parameters r3 = r3.getParameters()     // Catch:{ Throwable -> 0x0078 }
            if (r3 == 0) goto L_0x0065
            int r11 = r11.arg1     // Catch:{ Throwable -> 0x0078 }
            if (r11 != r2) goto L_0x005d
            java.util.List r11 = r3.getSupportedFlashModes()     // Catch:{ Throwable -> 0x005d }
            if (r11 == 0) goto L_0x005d
            java.util.Iterator r11 = r11.iterator()     // Catch:{ Throwable -> 0x005d }
        L_0x0048:
            boolean r4 = r11.hasNext()     // Catch:{ Throwable -> 0x005d }
            if (r4 == 0) goto L_0x005d
            java.lang.Object r4 = r11.next()     // Catch:{ Throwable -> 0x005d }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Throwable -> 0x005d }
            boolean r4 = r0.equals(r4)     // Catch:{ Throwable -> 0x005d }
            if (r4 == 0) goto L_0x0048
            r3.setFlashMode(r0)     // Catch:{ Throwable -> 0x005d }
        L_0x005d:
            r1.a(r3)     // Catch:{ Throwable -> 0x0078 }
            android.hardware.Camera r11 = r10.n     // Catch:{ Throwable -> 0x0078 }
            r11.setParameters(r3)     // Catch:{ Throwable -> 0x0078 }
        L_0x0065:
            android.hardware.Camera r11 = r10.n     // Catch:{ Throwable -> 0x0078 }
            r11.startPreview()     // Catch:{ Throwable -> 0x0078 }
            android.hardware.Camera r11 = r10.n     // Catch:{ Throwable -> 0x0078 }
            com.modiface.mfemakeupkit.camera.f r0 = new com.modiface.mfemakeupkit.camera.f     // Catch:{ Throwable -> 0x0078 }
            r3 = r0
            r4 = r10
            r8 = r1
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ Throwable -> 0x0078 }
            r11.takePicture(r9, r9, r0)     // Catch:{ Throwable -> 0x0078 }
            goto L_0x0087
        L_0x0078:
            r11 = move-exception
            r1.a(r9, r11)
            goto L_0x0087
        L_0x007d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "failed to take picture because camera has not started"
            r11.<init>(r0)
            r1.a(r9, r11)
        L_0x0087:
            return r2
        L_0x0088:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "failed to take picture because app is paused"
            r11.<init>(r0)
            r1.a(r9, r11)
            goto L_0x00ea
        L_0x0093:
            java.util.concurrent.atomic.AtomicBoolean r11 = r10.k
            boolean r11 = r11.get()
            if (r11 != 0) goto L_0x00ea
            android.hardware.Camera r11 = r10.n
            if (r11 == 0) goto L_0x00b9
            r11.stopPreview()
            android.hardware.Camera r11 = r10.n
            android.hardware.Camera$Parameters r11 = r11.getParameters()
            if (r11 == 0) goto L_0x00b4
            java.lang.String r0 = "off"
            r11.setFlashMode(r0)
            android.hardware.Camera r0 = r10.n
            r0.setParameters(r11)
        L_0x00b4:
            android.hardware.Camera r11 = r10.n
            r11.startPreview()
        L_0x00b9:
            return r2
        L_0x00ba:
            java.util.concurrent.atomic.AtomicBoolean r11 = r10.k
            boolean r11 = r11.get()
            if (r11 != 0) goto L_0x00ea
            r10.f()
            return r2
        L_0x00c6:
            java.util.concurrent.atomic.AtomicBoolean r0 = r10.k
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x00ea
            java.lang.Object r11 = r11.obj
            if (r11 == 0) goto L_0x00d7
            com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters r11 = (com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters) r11
            r10.o = r11
            goto L_0x00de
        L_0x00d7:
            com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters r11 = new com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters
            r11.<init>()
            r10.o = r11
        L_0x00de:
            java.util.concurrent.atomic.AtomicBoolean r11 = r10.k
            boolean r11 = r11.get()
            if (r11 != 0) goto L_0x00e9
            r10.c()
        L_0x00e9:
            return r2
        L_0x00ea:
            r11 = 0
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.modiface.mfemakeupkit.camera.i.handleMessage(android.os.Message):boolean");
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (!this.k.get()) {
            Handler b2 = this.j.b();
            if (b2 != null && !b2.hasMessages(12)) {
                b2.sendEmptyMessage(12);
            }
        }
    }

    private void b() {
        if (!this.y) {
            this.y = true;
            a();
            this.j.a();
        }
    }

    private void c(Context context) {
        if (!n.a()) {
            throw new IllegalStateException("must call startCamera() of MFEAndroidCamera in UI thread");
        } else if (context == null) {
            throw new IllegalArgumentException("context cannot be null when calling startCamera() in MFEAndroidCamera");
        } else if (androidx.core.content.b.b(context, "android.permission.CAMERA") == 0) {
            this.l = true;
            MFEAndroidCameraParameters mFEAndroidCameraParameters = this.m;
            Handler b2 = this.j.b();
            if (b2 != null) {
                b2.removeMessages(11);
                b2.removeMessages(12);
                if (!this.k.get()) {
                    e();
                    if (!b2.hasMessages(11)) {
                        b2.sendMessage(Message.obtain(b2, 11, mFEAndroidCameraParameters));
                    }
                }
            }
        } else {
            throw new IllegalStateException("camera permission not granted when calling startCamera() in MFEAndroidCamera");
        }
    }

    private void d() {
        if (n.a()) {
            e();
            this.l = false;
            return;
        }
        throw new IllegalStateException("must call stopCamera() of MFEAndroidCamera in UI thread");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|4|5|6) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0028 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e() {
        /*
            r6 = this;
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference
            r1 = 0
            r0.<init>(r1)
            java.util.concurrent.atomic.AtomicInteger r2 = new java.util.concurrent.atomic.AtomicInteger
            r3 = 0
            r2.<init>(r3)
            com.modiface.mfemakeupkit.utils.s r3 = r6.j
            com.modiface.mfemakeupkit.camera.b r4 = new com.modiface.mfemakeupkit.camera.b
            r4.<init>(r6, r0, r2)
            r5 = 1
            r3.b(r4, r5)
            com.modiface.mfemakeupkit.utils.s r3 = r6.j
            com.modiface.mfemakeupkit.camera.c r4 = new com.modiface.mfemakeupkit.camera.c
            r4.<init>(r6)
            r3.b(r4)
            android.hardware.Camera r3 = r6.n
            if (r3 == 0) goto L_0x003c
            r3.stopPreview()     // Catch:{ Exception -> 0x0028 }
        L_0x0028:
            android.hardware.Camera r3 = r6.n     // Catch:{ Exception -> 0x002d }
            r3.setPreviewTexture(r1)     // Catch:{ Exception -> 0x002d }
        L_0x002d:
            android.hardware.Camera r3 = r6.n
            r3.release()
            r6.n = r1
            r6.u = r1
            r6.v = r1
            com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters$CameraRotation r1 = com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters.CameraRotation.ROTATE_0
            r6.w = r1
        L_0x003c:
            com.modiface.mfemakeupkit.utils.s r1 = r6.j
            com.modiface.mfemakeupkit.camera.d r3 = new com.modiface.mfemakeupkit.camera.d
            r3.<init>(r6, r0, r2)
            r1.b(r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.modiface.mfemakeupkit.camera.i.e():void");
    }

    private void f() {
        ArrayList arrayList;
        if (!this.k.get()) {
            SurfaceTexture surfaceTexture = this.p;
            if (surfaceTexture != null) {
                surfaceTexture.updateTexImage();
                long timestamp = surfaceTexture.getTimestamp();
                Long l2 = this.t;
                if (l2 == null || timestamp >= l2.longValue()) {
                    this.t = Long.valueOf(timestamp);
                    Boolean bool = this.v;
                    if (bool != null) {
                        MFEAndroidCameraParameters.CameraRotation cameraRotation = this.w;
                        if (cameraRotation == null) {
                            cameraRotation = MFEAndroidCameraParameters.CameraRotation.ROTATE_0;
                        }
                        Camera.Size size = this.u;
                        if (size != null && size.width > 0 && size.height > 0) {
                            int i2 = this.q[0];
                            if (i2 != 0) {
                                if (!this.x.f()) {
                                    this.x.d();
                                }
                                if (this.x.f()) {
                                    j a2 = l.a(bool.booleanValue(), this.r.get().f15292c, cameraRotation);
                                    int i3 = a2.b() ? size.height : size.width;
                                    int i4 = a2.b() ? size.width : size.height;
                                    synchronized (this.i) {
                                        arrayList = new ArrayList(this.i);
                                    }
                                    HashMap hashMap = new HashMap();
                                    Iterator it = arrayList.iterator();
                                    MFEImage mFEImage = null;
                                    while (it.hasNext()) {
                                        WeakReference weakReference = (WeakReference) it.next();
                                        b bVar = (b) weakReference.get();
                                        if (bVar != null) {
                                            ArrayList arrayList2 = new ArrayList();
                                            g gVar = r1;
                                            ArrayList arrayList3 = arrayList2;
                                            int i5 = i3;
                                            b bVar2 = bVar;
                                            j jVar = a2;
                                            j jVar2 = a2;
                                            WeakReference weakReference2 = weakReference;
                                            g gVar2 = new g(this, arrayList2, i3, i4, jVar, i2);
                                            MFEImage onNewCameraFrame = bVar2.onNewCameraFrame(gVar);
                                            if (!(onNewCameraFrame == null || onNewCameraFrame.bitmap == null)) {
                                                if (mFEImage == null) {
                                                    mFEImage = onNewCameraFrame;
                                                }
                                                hashMap.put(weakReference2, onNewCameraFrame);
                                            }
                                            if (!arrayList3.isEmpty()) {
                                                bVar2.onProcessCameraFrameErrors(arrayList3);
                                            }
                                            i3 = i5;
                                            a2 = jVar2;
                                        }
                                    }
                                    if (mFEImage != null) {
                                        u a3 = this.z.a(this.A, new u(mFEImage, f.a(), hashMap), new MFEFaceTrackingParameters(320, false), (j.d) new h(this));
                                        if (a3 != null) {
                                            Object obj = a3.f15399b;
                                            if (obj != null) {
                                                for (Map.Entry entry : ((HashMap) obj).entrySet()) {
                                                    if (entry != null) {
                                                        WeakReference weakReference3 = (WeakReference) entry.getKey();
                                                        MFEImage mFEImage2 = (MFEImage) entry.getValue();
                                                        if (!(weakReference3 == null || mFEImage2 == null)) {
                                                            b bVar3 = (b) weakReference3.get();
                                                            if (bVar3 != null) {
                                                                bVar3.onCameraFrameDroppedFromFaceTracking(mFEImage2);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static synchronized i a(Context context, MFEMakeupEngine.Region region) {
        i iVar;
        synchronized (i.class) {
            if (context != null) {
                if (f15287e == null) {
                    f15287e = new i(context, region);
                }
                f15287e.a(context);
                iVar = f15287e;
            } else {
                throw new IllegalArgumentException("context cannot be null when getting singleton instance of MFEAndroidCamera");
            }
        }
        return iVar;
    }

    public void b(Context context) {
        if (!n.a()) {
            throw new IllegalStateException("must call onResume() of MFEAndroidCamera in UI thread");
        } else if (this.k.get()) {
            this.j.b((EGLContext) null);
            this.k.set(false);
            if (this.l) {
                c(context);
            }
        }
    }

    public void a(MFEAndroidCameraParametersCallback mFEAndroidCameraParametersCallback) {
        if (n.a()) {
            this.h = new WeakReference<>(mFEAndroidCameraParametersCallback);
            return;
        }
        throw new IllegalStateException("must call setParametersCallback() of MFEAndroidCamera on the UI thread");
    }

    public void a(MFEAndroidCameraErrorCallback mFEAndroidCameraErrorCallback) {
        if (n.a()) {
            this.f15289g = new WeakReference<>(mFEAndroidCameraErrorCallback);
            return;
        }
        throw new IllegalStateException("must call setErrorCallback() of MFEAndroidCamera on the UI thread");
    }

    public void a(Context context, MFEAndroidCameraParameters mFEAndroidCameraParameters) {
        if (n.a()) {
            if (mFEAndroidCameraParameters == null) {
                mFEAndroidCameraParameters = new MFEAndroidCameraParameters();
            }
            this.m = mFEAndroidCameraParameters;
            if (this.l) {
                c(context);
                return;
            }
            return;
        }
        throw new IllegalStateException("must call setCameraParameters() of MFEAndroidCamera in UI thread");
    }

    /* JADX WARNING: Removed duplicated region for block: B:86:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c() {
        /*
            r10 = this;
            java.lang.String r0 = "fixed"
            java.lang.String r1 = "continuous-video"
            java.lang.String r2 = "auto"
            java.lang.String r3 = "get camera id"
            r4 = 0
            com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters r5 = r10.o     // Catch:{ Exception -> 0x0156 }
            boolean r5 = r5.isFrontCamera     // Catch:{ Exception -> 0x0156 }
            java.lang.Integer r5 = com.modiface.mfemakeupkit.camera.l.a((boolean) r5)     // Catch:{ Exception -> 0x0156 }
            if (r5 == 0) goto L_0x0134
            java.lang.String r3 = "open camera"
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x0156 }
            android.hardware.Camera r5 = android.hardware.Camera.open(r5)     // Catch:{ Exception -> 0x0156 }
            r10.n = r5     // Catch:{ Exception -> 0x0156 }
            android.hardware.Camera r3 = r10.n     // Catch:{ Exception -> 0x0156 }
            if (r3 == 0) goto L_0x0131
            java.lang.String r3 = "set camera parameters"
            android.hardware.Camera r5 = r10.n     // Catch:{ Exception -> 0x0156 }
            android.hardware.Camera$Parameters r5 = r5.getParameters()     // Catch:{ Exception -> 0x0156 }
            java.util.concurrent.atomic.AtomicReference<com.modiface.mfemakeupkit.camera.i$a> r6 = r10.r     // Catch:{ Exception -> 0x0156 }
            java.lang.Object r6 = r6.get()     // Catch:{ Exception -> 0x0156 }
            com.modiface.mfemakeupkit.camera.i$a r6 = (com.modiface.mfemakeupkit.camera.i.a) r6     // Catch:{ Exception -> 0x0156 }
            com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters r7 = r10.o     // Catch:{ Exception -> 0x0156 }
            boolean r7 = r7.isFrontCamera     // Catch:{ Exception -> 0x0156 }
            int r8 = r6.f15292c     // Catch:{ Exception -> 0x0156 }
            com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters r9 = r10.o     // Catch:{ Exception -> 0x0156 }
            com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters$CameraRotation r9 = r9.cameraRotation     // Catch:{ Exception -> 0x0156 }
            com.modiface.mfemakeupkit.camera.j r7 = com.modiface.mfemakeupkit.camera.l.a((boolean) r7, (int) r8, (com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters.CameraRotation) r9)     // Catch:{ Exception -> 0x0156 }
            com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters r8 = r10.o     // Catch:{ Exception -> 0x0156 }
            int r8 = r8.hintWidth     // Catch:{ Exception -> 0x0156 }
            com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters r9 = r10.o     // Catch:{ Exception -> 0x0156 }
            int r9 = r9.hintHeight     // Catch:{ Exception -> 0x0156 }
            if (r8 != 0) goto L_0x0056
            boolean r8 = r7.b()     // Catch:{ Exception -> 0x0156 }
            if (r8 == 0) goto L_0x0054
            int r8 = r6.f15291b     // Catch:{ Exception -> 0x0156 }
            goto L_0x0056
        L_0x0054:
            int r8 = r6.f15290a     // Catch:{ Exception -> 0x0156 }
        L_0x0056:
            if (r9 != 0) goto L_0x0063
            boolean r7 = r7.b()     // Catch:{ Exception -> 0x0156 }
            if (r7 == 0) goto L_0x0061
            int r9 = r6.f15290a     // Catch:{ Exception -> 0x0156 }
            goto L_0x0063
        L_0x0061:
            int r9 = r6.f15291b     // Catch:{ Exception -> 0x0156 }
        L_0x0063:
            android.hardware.Camera$Size r6 = com.modiface.mfemakeupkit.camera.l.a((int) r8, (int) r9, (android.hardware.Camera.Parameters) r5)     // Catch:{ Exception -> 0x0156 }
            if (r6 == 0) goto L_0x0070
            int r7 = r6.width     // Catch:{ Exception -> 0x0156 }
            int r6 = r6.height     // Catch:{ Exception -> 0x0156 }
            r5.setPreviewSize(r7, r6)     // Catch:{ Exception -> 0x0156 }
        L_0x0070:
            r6 = 17
            r5.setPreviewFormat(r6)     // Catch:{ Exception -> 0x0156 }
            java.util.List r6 = r5.getSupportedFocusModes()     // Catch:{ Exception -> 0x0156 }
            if (r6 == 0) goto L_0x009e
            com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters r7 = r10.o     // Catch:{ Exception -> 0x0156 }
            boolean r7 = r7.isContinuousAutoFocusOn     // Catch:{ Exception -> 0x0156 }
            if (r7 == 0) goto L_0x008b
            boolean r0 = r6.contains(r1)     // Catch:{ Exception -> 0x0156 }
            if (r0 == 0) goto L_0x009e
            r5.setFocusMode(r1)     // Catch:{ Exception -> 0x0156 }
            goto L_0x009e
        L_0x008b:
            boolean r1 = r6.contains(r2)     // Catch:{ Exception -> 0x0156 }
            if (r1 == 0) goto L_0x0095
            r5.setFocusMode(r2)     // Catch:{ Exception -> 0x0156 }
            goto L_0x009e
        L_0x0095:
            boolean r1 = r6.contains(r0)     // Catch:{ Exception -> 0x0156 }
            if (r1 == 0) goto L_0x009e
            r5.setFocusMode(r0)     // Catch:{ Exception -> 0x0156 }
        L_0x009e:
            android.hardware.Camera r0 = r10.n     // Catch:{ Exception -> 0x0156 }
            r0.setParameters(r5)     // Catch:{ Exception -> 0x0156 }
            android.hardware.Camera r0 = r10.n     // Catch:{ Exception -> 0x0156 }
            android.hardware.Camera$Parameters r0 = r0.getParameters()     // Catch:{ Exception -> 0x0156 }
            java.lang.ref.WeakReference<com.modiface.mfemakeupkit.camera.MFEAndroidCameraParametersCallback> r1 = r10.h     // Catch:{ Exception -> 0x0156 }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x0156 }
            com.modiface.mfemakeupkit.camera.MFEAndroidCameraParametersCallback r1 = (com.modiface.mfemakeupkit.camera.MFEAndroidCameraParametersCallback) r1     // Catch:{ Exception -> 0x0156 }
            if (r1 == 0) goto L_0x00bd
            com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters r2 = r10.o     // Catch:{ Exception -> 0x0156 }
            r1.onCameraSetParameters(r0, r2)     // Catch:{ Exception -> 0x0156 }
            android.hardware.Camera r1 = r10.n     // Catch:{ Exception -> 0x0156 }
            r1.setParameters(r0)     // Catch:{ Exception -> 0x0156 }
        L_0x00bd:
            android.hardware.Camera r0 = r10.n     // Catch:{ Exception -> 0x0156 }
            android.hardware.Camera$Parameters r0 = r0.getParameters()     // Catch:{ Exception -> 0x0156 }
            if (r0 == 0) goto L_0x012e
            android.hardware.Camera$Size r0 = r0.getPreviewSize()     // Catch:{ Exception -> 0x0156 }
            if (r0 == 0) goto L_0x012b
            java.lang.String r3 = "prepare to start camera preview"
            r10.u = r0     // Catch:{ Exception -> 0x0156 }
            com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters r0 = r10.o     // Catch:{ Exception -> 0x0156 }
            boolean r0 = r0.isFrontCamera     // Catch:{ Exception -> 0x0156 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x0156 }
            r10.v = r0     // Catch:{ Exception -> 0x0156 }
            com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters r0 = r10.o     // Catch:{ Exception -> 0x0156 }
            com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters$CameraRotation r0 = r0.cameraRotation     // Catch:{ Exception -> 0x0156 }
            r10.w = r0     // Catch:{ Exception -> 0x0156 }
            com.modiface.mfemakeupkit.utils.s r0 = r10.j     // Catch:{ Exception -> 0x0156 }
            boolean r0 = r0.d()     // Catch:{ Exception -> 0x0156 }
            if (r0 == 0) goto L_0x0128
            java.lang.String r3 = "prepare surface texture to start camera preview"
            int[] r0 = r10.q     // Catch:{ Exception -> 0x0156 }
            r1 = 0
            r0 = r0[r1]     // Catch:{ Exception -> 0x0156 }
            if (r0 != 0) goto L_0x00f6
            r0 = 1
            int[] r2 = r10.q     // Catch:{ Exception -> 0x0156 }
            android.opengl.GLES20.glGenTextures(r0, r2, r1)     // Catch:{ Exception -> 0x0156 }
        L_0x00f6:
            android.graphics.SurfaceTexture r0 = r10.p     // Catch:{ Exception -> 0x0156 }
            if (r0 != 0) goto L_0x0110
            int[] r0 = r10.q     // Catch:{ Exception -> 0x0156 }
            r0 = r0[r1]     // Catch:{ Exception -> 0x0156 }
            if (r0 == 0) goto L_0x0110
            android.graphics.SurfaceTexture r0 = new android.graphics.SurfaceTexture     // Catch:{ Exception -> 0x0156 }
            int[] r2 = r10.q     // Catch:{ Exception -> 0x0156 }
            r1 = r2[r1]     // Catch:{ Exception -> 0x0156 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0156 }
            r10.p = r0     // Catch:{ Exception -> 0x0156 }
            android.graphics.SurfaceTexture r0 = r10.p     // Catch:{ Exception -> 0x0156 }
            r0.setOnFrameAvailableListener(r10)     // Catch:{ Exception -> 0x0156 }
        L_0x0110:
            r10.t = r4     // Catch:{ Exception -> 0x0156 }
            android.graphics.SurfaceTexture r0 = r10.p     // Catch:{ Exception -> 0x0156 }
            if (r0 == 0) goto L_0x0125
            java.lang.String r3 = "start camera preview"
            android.hardware.Camera r0 = r10.n     // Catch:{ Exception -> 0x0156 }
            android.graphics.SurfaceTexture r1 = r10.p     // Catch:{ Exception -> 0x0156 }
            r0.setPreviewTexture(r1)     // Catch:{ Exception -> 0x0156 }
            android.hardware.Camera r0 = r10.n     // Catch:{ Exception -> 0x0156 }
            r0.startPreview()     // Catch:{ Exception -> 0x0156 }
            return
        L_0x0125:
            java.lang.String r0 = "Failed to start camera preview due to fail to initialize surface"
            goto L_0x0169
        L_0x0128:
            java.lang.String r0 = "Failed to start camera preview due to fail to setup EGL that is necessary for initializing surface"
            goto L_0x0169
        L_0x012b:
            java.lang.String r0 = "Failed to setup camera preview because camera preview size is null"
            goto L_0x0169
        L_0x012e:
            java.lang.String r0 = "Failed to setup camera preview because camera parameter is null"
            goto L_0x0169
        L_0x0131:
            java.lang.String r0 = "Failed to open camera with Camera.open()"
            goto L_0x0169
        L_0x0134:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0156 }
            r0.<init>()     // Catch:{ Exception -> 0x0156 }
            java.lang.String r1 = "Failed to find "
            r0.append(r1)     // Catch:{ Exception -> 0x0156 }
            com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters r1 = r10.o     // Catch:{ Exception -> 0x0156 }
            boolean r1 = r1.isFrontCamera     // Catch:{ Exception -> 0x0156 }
            if (r1 == 0) goto L_0x0147
            java.lang.String r1 = "front"
            goto L_0x0149
        L_0x0147:
            java.lang.String r1 = "back"
        L_0x0149:
            r0.append(r1)     // Catch:{ Exception -> 0x0156 }
            java.lang.String r1 = " camera id"
            r0.append(r1)     // Catch:{ Exception -> 0x0156 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0156 }
            goto L_0x0169
        L_0x0156:
            r0 = move-exception
            r4 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "exception thrown when doing "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
        L_0x0169:
            java.lang.ref.WeakReference<com.modiface.mfemakeupkit.camera.MFEAndroidCameraErrorCallback> r1 = r10.f15289g
            java.lang.Object r1 = r1.get()
            com.modiface.mfemakeupkit.camera.MFEAndroidCameraErrorCallback r1 = (com.modiface.mfemakeupkit.camera.MFEAndroidCameraErrorCallback) r1
            if (r1 == 0) goto L_0x0176
            r1.onCameraFailedToStart(r0, r4)
        L_0x0176:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.modiface.mfemakeupkit.camera.i.c():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
        if (r3.l == false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        c(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0036, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r4, com.modiface.mfemakeupkit.camera.i.b r5) {
        /*
            r3 = this;
            boolean r0 = com.modiface.mfemakeupkit.utils.n.a()
            if (r0 == 0) goto L_0x003a
            java.util.List<java.lang.ref.WeakReference<com.modiface.mfemakeupkit.camera.i$b>> r0 = r3.i
            monitor-enter(r0)
            java.util.List<java.lang.ref.WeakReference<com.modiface.mfemakeupkit.camera.i$b>> r1 = r3.i     // Catch:{ all -> 0x0037 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0037 }
        L_0x000f:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0037 }
            if (r2 == 0) goto L_0x0023
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0037 }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x0037 }
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0037 }
            if (r2 != r5) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x0037 }
            return
        L_0x0023:
            java.util.List<java.lang.ref.WeakReference<com.modiface.mfemakeupkit.camera.i$b>> r1 = r3.i     // Catch:{ all -> 0x0037 }
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0037 }
            r2.<init>(r5)     // Catch:{ all -> 0x0037 }
            r1.add(r2)     // Catch:{ all -> 0x0037 }
            monitor-exit(r0)     // Catch:{ all -> 0x0037 }
            boolean r5 = r3.l
            if (r5 == 0) goto L_0x0033
            return
        L_0x0033:
            r3.c((android.content.Context) r4)
            return
        L_0x0037:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0037 }
            throw r4
        L_0x003a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "must call requestCameraFramesForCallback() of MFEAndroidCamera in UI thread"
            r4.<init>(r5)
            goto L_0x0043
        L_0x0042:
            throw r4
        L_0x0043:
            goto L_0x0042
        */
        throw new UnsupportedOperationException("Method not decompiled: com.modiface.mfemakeupkit.camera.i.a(android.content.Context, com.modiface.mfemakeupkit.camera.i$b):void");
    }

    public void a(b bVar) {
        boolean isEmpty;
        if (n.a()) {
            synchronized (this.i) {
                ListIterator<WeakReference<b>> listIterator = this.i.listIterator();
                while (listIterator.hasNext()) {
                    if (listIterator.next().get() == bVar) {
                        listIterator.remove();
                    }
                }
                isEmpty = this.i.isEmpty();
            }
            if (isEmpty) {
                d();
                return;
            }
            return;
        }
        throw new IllegalStateException("must call stopCameraFramesForCallback() of MFEAndroidCamera in UI thread");
    }

    public void a(boolean z2, c cVar) {
        if (n.a()) {
            Handler b2 = this.j.b();
            if (b2 == null) {
                cVar.a((Bitmap) null, new IllegalStateException("cannot take picture because initialization failed"));
            } else if (!b2.hasMessages(13)) {
                b2.sendMessage(Message.obtain(b2, 13, z2 ? 1 : 0, 0, cVar));
            } else {
                cVar.a((Bitmap) null, new IllegalStateException("failed to take picture because previous call to take picture has not been processed yet"));
            }
        } else {
            throw new IllegalStateException("must call takePicture() of MFEAndroidCamera in UI thread");
        }
    }

    public void a() {
        if (!n.a()) {
            throw new IllegalStateException("must call onPause() of MFEAndroidCamera in UI thread");
        } else if (!this.k.get()) {
            this.k.set(true);
            e();
            this.j.c((Runnable) new a(this));
        }
    }

    public void a(Context context) {
        if (context != null) {
            try {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                if (windowManager != null) {
                    Display defaultDisplay = windowManager.getDefaultDisplay();
                    if (defaultDisplay != null) {
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        defaultDisplay.getMetrics(displayMetrics);
                        int i2 = displayMetrics.widthPixels;
                        int i3 = displayMetrics.heightPixels;
                        int rotation = defaultDisplay.getRotation();
                        this.r.set(new a(i2, i3, rotation != 0 ? rotation != 1 ? rotation != 2 ? 270 : 180 : 90 : 0, (a) null));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("context cannot be null when calling onConfigurationChanged in MFEAndroidCamera");
        }
    }
}
