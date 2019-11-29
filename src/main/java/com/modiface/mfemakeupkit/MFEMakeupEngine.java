package com.modiface.mfemakeupkit;

import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Camera;
import com.modiface.mfemakeupkit.a.j;
import com.modiface.mfemakeupkit.aa;
import com.modiface.mfemakeupkit.b.m;
import com.modiface.mfemakeupkit.camera.MFEAndroidCameraErrorCallback;
import com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters;
import com.modiface.mfemakeupkit.camera.MFEAndroidCameraParametersCallback;
import com.modiface.mfemakeupkit.camera.i;
import com.modiface.mfemakeupkit.data.MFEFaceTrackingParameters;
import com.modiface.mfemakeupkit.data.MFEMakeupRenderingParameters;
import com.modiface.mfemakeupkit.data.MFETrackingData;
import com.modiface.mfemakeupkit.effects.MFEMakeupLook;
import com.modiface.mfemakeupkit.effects.MFEMakeupProductCategory;
import com.modiface.mfemakeupkit.utils.MFEDebugInfo;
import com.modiface.mfemakeupkit.utils.MFEGLFramebuffer;
import com.modiface.mfemakeupkit.utils.MFEImage;
import com.modiface.mfemakeupkit.utils.n;
import com.modiface.mfemakeupkit.utils.p;
import com.modiface.mfemakeupkit.utils.u;
import com.modiface.mfemakeupkit.utils.y;
import com.modiface.mfemakeupkit.video.MFEVideoRecordingError;
import com.modiface.mfemakeupkit.widgets.MFEMakeupView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class MFEMakeupEngine implements aa.b, m.c, m.d, i.b {
    private static final String TAG = "MFEMakeupEngine";
    private static final String kMFEMakeupEngineCameraDebugInfoName = "Camera";
    private static final String kMFEMakeupEngineDebugInfoName = "MFE Makeup Engine";
    private double cameraFps;
    private y cameraTimer;
    private WeakReference<b> mCallbackRef;
    private final i mCamera;
    private WeakReference<MFEMakeupEngineImageProcessedCallback> mCameraImageProcessedCallbackRef;
    private AtomicReference<a> mCurrentInputState;
    /* access modifiers changed from: private */
    public final MFEDebugInfo mDebugInfo;
    private WeakReference<MFEMakeupEngineDetectionCallback> mDetectionCallbackRef;
    /* access modifiers changed from: private */
    public WeakReference<MFEMakeupEngineErrorCallback> mErrorCallbackRef;
    private final j mFaceTrackingEngine;
    private final Object mFaceTrackingEngineStreamTag;
    private CopyOnWriteArrayList<WeakReference<MFEMakeupEngineInternalUpdateCallback>> mInternalUpdateCallbackRefs;
    private AtomicBoolean mIsPaused;
    /* access modifiers changed from: private */
    public ConcurrentLinkedQueue<MFEImage> mLiveImageCache;
    /* access modifiers changed from: private */
    public m mMakeupRenderingEngine;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<WeakReference<MFEMakeupView>> mMakeupViewRefs;
    /* access modifiers changed from: private */
    public com.modiface.mfemakeupkit.video.j mVideoRecorder;
    public final Region serverRegion;

    public interface ApplyMakeupToPhotoCompletionHandler {
        void onMakeupAppliedToPhoto(Bitmap bitmap, Bitmap bitmap2, Throwable th);
    }

    public interface CaptureOutputCompletionHandler {
        void onCapturedOutput(Bitmap bitmap, Bitmap bitmap2);
    }

    public interface FaceTrackedOnPhotoCompletionHandler {
        void onFaceTrackedOnPhoto(Bitmap bitmap, MFETrackingData mFETrackingData);
    }

    public interface MFEMakeupEngineDetectionCallback {
        void onMFEMakeupFinishedDetection(MFETrackingData mFETrackingData);
    }

    public interface MFEMakeupEngineErrorCallback {
        void onMakeupEngineError(ArrayList<Throwable> arrayList);
    }

    public interface MFEMakeupEngineImageProcessedCallback {
        void onMFEMakeupFinishedProcessingImage(MFETrackingData mFETrackingData);
    }

    interface MFEMakeupEngineInternalUpdateCallback {
        void onEngineMakeupApplied(MFEGLFramebuffer mFEGLFramebuffer, MFEGLFramebuffer mFEGLFramebuffer2);
    }

    public interface MFEMakeupEngineLoadResourcesCallback {
        void onMFEMakeupFinishedLoadResources();
    }

    public interface RecordVideoOutputCompletionHandler {
        void onVideoRecorded(File file, boolean z, long j, long j2, List<MFEVideoRecordingError> list);
    }

    public enum Region {
        US,
        Europe,
        China
    }

    public interface TakePictureCameraParametersCallback {
        void onTakePictureFromCameraSetCameraParameters(Camera.Parameters parameters);
    }

    public interface TakePictureFromCameraCompletionHandler {
        void onTakePictureFromCameraDone(Bitmap bitmap, Bitmap bitmap2, Throwable th);
    }

    private enum a {
        NONE,
        CAMERA_LIVE_FEED,
        STATIC_IMAGE
    }

    public interface b {
        void a(Bitmap bitmap, Bitmap bitmap2);
    }

    public interface c {
        void a();
    }

    public interface d {
        void a();
    }

    protected static class e {

        /* renamed from: a  reason: collision with root package name */
        final f f15180a;

        /* renamed from: b  reason: collision with root package name */
        final MFEMakeupEngineDetectionCallback f15181b;

        /* renamed from: c  reason: collision with root package name */
        final MFEMakeupEngineImageProcessedCallback f15182c;

        e(f fVar, MFEMakeupEngineDetectionCallback mFEMakeupEngineDetectionCallback, MFEMakeupEngineImageProcessedCallback mFEMakeupEngineImageProcessedCallback) {
            this.f15180a = fVar;
            this.f15181b = mFEMakeupEngineDetectionCallback;
            this.f15182c = mFEMakeupEngineImageProcessedCallback;
        }
    }

    protected enum f {
        STATIC,
        LIVE
    }

    public MFEMakeupEngine(Context context, Region region) {
        this(context, region, (MFEMakeupEngineErrorCallback) null);
    }

    private void callOnPauseOnMakeupViewsOnRenderThread() {
        Iterator<WeakReference<MFEMakeupView>> it = this.mMakeupViewRefs.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            if (next != null) {
                MFEMakeupView mFEMakeupView = (MFEMakeupView) next.get();
                if (mFEMakeupView != null) {
                    mFEMakeupView.getMakeupSurface().a((MFEGLFramebuffer) null, (MFEGLFramebuffer) null, (Long) null, (MFETrackingData) null, (MFEMakeupProductCategory) null);
                    mFEMakeupView.getMakeupSurface().b();
                }
            }
        }
    }

    private void callOnResumeOnMakeupViewsOnRenderThread() {
        Iterator<WeakReference<MFEMakeupView>> it = this.mMakeupViewRefs.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            if (next != null) {
                MFEMakeupView mFEMakeupView = (MFEMakeupView) next.get();
                if (mFEMakeupView != null) {
                    mFEMakeupView.getMakeupSurface().c();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void onFaceTrackedOnImage(u uVar) {
        if (uVar != null) {
            Object obj = uVar.f15399b;
            if (obj != null) {
                MFEMakeupEngineDetectionCallback mFEMakeupEngineDetectionCallback = ((e) obj).f15181b;
                if (mFEMakeupEngineDetectionCallback != null) {
                    mFEMakeupEngineDetectionCallback.onMFEMakeupFinishedDetection(uVar.f15398a);
                }
            }
        }
        this.mMakeupRenderingEngine.a(uVar);
    }

    /* access modifiers changed from: package-private */
    public void addInternalUpdateCallback(MFEMakeupEngineInternalUpdateCallback mFEMakeupEngineInternalUpdateCallback) {
        this.mInternalUpdateCallbackRefs.add(new WeakReference(mFEMakeupEngineInternalUpdateCallback));
    }

    public void applyMakeupToPhotoInBackground(Bitmap bitmap, boolean z, ApplyMakeupToPhotoCompletionHandler applyMakeupToPhotoCompletionHandler) {
        if (applyMakeupToPhotoCompletionHandler != null) {
            if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0 || bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
                throw new IllegalArgumentException("Invalid bitmap to apply makeup on");
            }
            MFEImage mFEImage = new MFEImage();
            mFEImage.bitmap = bitmap;
            this.mFaceTrackingEngine.a(new u(mFEImage, com.modiface.mfemakeupkit.utils.f.a(), new e(f.STATIC, (MFEMakeupEngineDetectionCallback) null, (MFEMakeupEngineImageProcessedCallback) null)), new MFEFaceTrackingParameters(z ? 320 : 0, true), new d(this, bitmap, applyMakeupToPhotoCompletionHandler));
        }
    }

    public void attachMakeupView(MFEMakeupView mFEMakeupView) {
        if (!n.a()) {
            throw new IllegalStateException("must call addMakeupView() of MFEMakeupEngine in UI thread");
        } else if (mFEMakeupView != null) {
            Iterator<WeakReference<MFEMakeupView>> it = this.mMakeupViewRefs.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                if (next != null && ((MFEMakeupView) next.get()) == mFEMakeupView) {
                    return;
                }
            }
            mFEMakeupView.getMakeupSurface().a((aa.b) this);
            this.mMakeupViewRefs.add(new WeakReference(mFEMakeupView));
        } else {
            throw new IllegalArgumentException("makeup view must not be null when calling addMakeupView() of MFEMakeupEngine");
        }
    }

    public void captureOutputWithCompletionHandler(CaptureOutputCompletionHandler captureOutputCompletionHandler) {
        if (captureOutputCompletionHandler != null) {
            this.mMakeupRenderingEngine.a((Runnable) new w(this, captureOutputCompletionHandler), (Runnable) new b(this, captureOutputCompletionHandler));
        }
    }

    public void close() {
        callOnPauseOnMakeupViewsOnRenderThread();
        this.mMakeupRenderingEngine.b((Runnable) new m(this));
        this.mMakeupRenderingEngine.a();
    }

    public void disableFaceTracking(c cVar) {
        this.mFaceTrackingEngine.a((j.b) new s(this, cVar));
    }

    public void enableFaceTracking(d dVar) {
        this.mFaceTrackingEngine.a((j.a) new q(this, dVar));
    }

    public void finalize() throws Throwable {
        close();
        super.finalize();
    }

    public MFEDebugInfo getDebugInfo() {
        MFEDebugInfo newCopy = this.mDebugInfo.getNewCopy();
        newCopy.addSubDebugInfo(this.mFaceTrackingEngine.a());
        newCopy.addSubDebugInfo(this.mMakeupRenderingEngine.b());
        return newCopy;
    }

    public boolean isFaceTrackingEnabled() {
        return this.mFaceTrackingEngine.b();
    }

    public void loadResources(Context context, MFEMakeupEngineLoadResourcesCallback mFEMakeupEngineLoadResourcesCallback) {
        this.mFaceTrackingEngine.a(context, (j.c) new n(this, mFEMakeupEngineLoadResourcesCallback));
    }

    public void onCameraFrameDroppedFromFaceTracking(MFEImage mFEImage) {
        if (mFEImage != null) {
            Bitmap bitmap = mFEImage.bitmap;
            if (bitmap != null && !bitmap.isRecycled() && mFEImage.bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
                onFinishedWithTrackingData(new u(mFEImage, com.modiface.mfemakeupkit.utils.f.a(), new e(f.LIVE, (MFEMakeupEngineDetectionCallback) this.mDetectionCallbackRef.get(), (MFEMakeupEngineImageProcessedCallback) this.mCameraImageProcessedCallbackRef.get())));
            }
        }
    }

    public void onConfigurationChanged(Context context) {
        if (context != null) {
            this.mCamera.a(context);
            return;
        }
        throw new IllegalArgumentException("context cannot be null when calling onConfigurationChanged() in MFEMakeupEngine");
    }

    public void onFaceTrackedOnCameraFrame(MFETrackingData mFETrackingData) {
        if (!this.mIsPaused.get() && this.mCurrentInputState.get() == a.CAMERA_LIVE_FEED && mFETrackingData != null && mFETrackingData.getImage() != null && mFETrackingData.getImageBitmap() != null && !mFETrackingData.getImageBitmap().isRecycled() && mFETrackingData.getImageBitmap().getConfig() == Bitmap.Config.ARGB_8888) {
            onFaceTrackedOnImage(new u(mFETrackingData, new e(f.LIVE, (MFEMakeupEngineDetectionCallback) this.mDetectionCallbackRef.get(), (MFEMakeupEngineImageProcessedCallback) this.mCameraImageProcessedCallbackRef.get())));
        }
    }

    public void onFinishedWithTrackingData(u uVar) {
        if (!this.mIsPaused.get() && uVar != null) {
            Object obj = uVar.f15399b;
            if (obj != null) {
                e eVar = (e) obj;
                if (eVar.f15180a == f.LIVE) {
                    MFETrackingData mFETrackingData = uVar.f15398a;
                    if (mFETrackingData != null) {
                        MFEImage image = mFETrackingData.getImage();
                        if (image != null) {
                            Bitmap bitmap = image.bitmap;
                            if (bitmap != null && !bitmap.isRecycled() && image.bitmap.getWidth() > 0 && image.bitmap.getHeight() > 0 && image.bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
                                this.mLiveImageCache.add(image);
                            }
                        }
                    }
                }
                MFEMakeupEngineImageProcessedCallback mFEMakeupEngineImageProcessedCallback = eVar.f15182c;
                if (mFEMakeupEngineImageProcessedCallback != null) {
                    mFEMakeupEngineImageProcessedCallback.onMFEMakeupFinishedProcessingImage(uVar.f15398a);
                }
            }
        }
    }

    public void onMFEMakeupSurfaceRenderFrameError(aa aaVar, Throwable th) {
        MFEMakeupEngineErrorCallback mFEMakeupEngineErrorCallback = (MFEMakeupEngineErrorCallback) this.mErrorCallbackRef.get();
        if (mFEMakeupEngineErrorCallback != null) {
            mFEMakeupEngineErrorCallback.onMakeupEngineError(new l(this, th));
        }
    }

    public void onMFEMakeupSurfaceSetSurfaceError(aa aaVar, ArrayList<Throwable> arrayList) {
        MFEMakeupEngineErrorCallback mFEMakeupEngineErrorCallback = (MFEMakeupEngineErrorCallback) this.mErrorCallbackRef.get();
        if (mFEMakeupEngineErrorCallback != null) {
            mFEMakeupEngineErrorCallback.onMakeupEngineError(arrayList);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMakeupApplied(boolean r9, java.util.ArrayList<java.lang.Throwable> r10, com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r11, com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r12, com.modiface.mfemakeupkit.data.MFETrackingData r13, com.modiface.mfemakeupkit.effects.MFEMakeupProductCategory r14) {
        /*
            r8 = this;
            if (r9 == 0) goto L_0x00e9
            com.modiface.mfemakeupkit.utils.y r9 = new com.modiface.mfemakeupkit.utils.y
            r9.<init>()
            android.opengl.GLES20.glFinish()
            com.modiface.mfemakeupkit.utils.MFEDebugInfo r0 = r8.mDebugInfo
            long r1 = r9.d()
            java.lang.String r9 = "flush renderer gl context time (ms)"
            r0.addDetailedDebugInfo((java.lang.String) r9, (long) r1)
            java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<com.modiface.mfemakeupkit.widgets.MFEMakeupView>> r9 = r8.mMakeupViewRefs
            java.util.Iterator r9 = r9.iterator()
            r0 = 1
        L_0x001c:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto L_0x0066
            java.lang.Object r1 = r9.next()
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1
            if (r1 != 0) goto L_0x002b
            goto L_0x001c
        L_0x002b:
            java.lang.Object r1 = r1.get()
            com.modiface.mfemakeupkit.widgets.MFEMakeupView r1 = (com.modiface.mfemakeupkit.widgets.MFEMakeupView) r1
            if (r1 != 0) goto L_0x0034
            goto L_0x001c
        L_0x0034:
            com.modiface.mfemakeupkit.aa r2 = r1.getMakeupSurface()
            r5 = 0
            r3 = r11
            r4 = r12
            r6 = r13
            r7 = r14
            r2.a(r3, r4, r5, r6, r7)
            com.modiface.mfemakeupkit.utils.MFEDebugInfo r1 = r1.getDebugInfo()
            com.modiface.mfemakeupkit.utils.MFEDebugInfo r2 = r8.mDebugInfo
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r1.name
            r3.append(r4)
            java.lang.String r4 = " "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            com.modiface.mfemakeupkit.utils.MFEDebugInfo r1 = r1.getNewCopy(r3)
            r2.addSubDebugInfo(r1)
            int r0 = r0 + 1
            goto L_0x001c
        L_0x0066:
            com.modiface.mfemakeupkit.video.j r9 = r8.mVideoRecorder
            if (r9 == 0) goto L_0x0084
            r9.a((com.modiface.mfemakeupkit.utils.MFEGLFramebuffer) r12)
            com.modiface.mfemakeupkit.video.j r9 = r8.mVideoRecorder
            com.modiface.mfemakeupkit.aa r0 = r9.c()
            com.modiface.mfemakeupkit.video.j r9 = r8.mVideoRecorder
            long r1 = r9.b()
            java.lang.Long r3 = java.lang.Long.valueOf(r1)
            r1 = r11
            r2 = r12
            r4 = r13
            r5 = r14
            r0.a(r1, r2, r3, r4, r5)
        L_0x0084:
            java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<com.modiface.mfemakeupkit.MFEMakeupEngine$MFEMakeupEngineInternalUpdateCallback>> r9 = r8.mInternalUpdateCallbackRefs
            java.util.Iterator r9 = r9.iterator()
        L_0x008a:
            boolean r13 = r9.hasNext()
            if (r13 == 0) goto L_0x00a2
            java.lang.Object r13 = r9.next()
            java.lang.ref.WeakReference r13 = (java.lang.ref.WeakReference) r13
            java.lang.Object r13 = r13.get()
            com.modiface.mfemakeupkit.MFEMakeupEngine$MFEMakeupEngineInternalUpdateCallback r13 = (com.modiface.mfemakeupkit.MFEMakeupEngine.MFEMakeupEngineInternalUpdateCallback) r13
            if (r13 == 0) goto L_0x008a
            r13.onEngineMakeupApplied(r11, r12)
            goto L_0x008a
        L_0x00a2:
            java.lang.ref.WeakReference<com.modiface.mfemakeupkit.MFEMakeupEngine$b> r9 = r8.mCallbackRef
            java.lang.Object r9 = r9.get()
            com.modiface.mfemakeupkit.MFEMakeupEngine$b r9 = (com.modiface.mfemakeupkit.MFEMakeupEngine.b) r9
            if (r9 == 0) goto L_0x00e9
            r13 = 0
            if (r11 == 0) goto L_0x00c7
            java.util.ArrayList r14 = r11.getAndClearErrors()
            r10.addAll(r14)
            android.graphics.Bitmap r14 = r11.captureToBitmap()
            boolean r0 = r11.hasError()
            if (r0 == 0) goto L_0x00c8
            java.util.ArrayList r11 = r11.getAndClearErrors()
            r10.addAll(r11)
        L_0x00c7:
            r14 = r13
        L_0x00c8:
            if (r12 == 0) goto L_0x00e4
            java.util.ArrayList r11 = r12.getAndClearErrors()
            r10.addAll(r11)
            android.graphics.Bitmap r11 = r12.captureToBitmap()
            boolean r0 = r12.hasError()
            if (r0 == 0) goto L_0x00e3
            java.util.ArrayList r11 = r12.getAndClearErrors()
            r10.addAll(r11)
            goto L_0x00e4
        L_0x00e3:
            r13 = r11
        L_0x00e4:
            if (r14 == 0) goto L_0x00e9
            r9.a(r14, r13)
        L_0x00e9:
            boolean r9 = r10.isEmpty()
            if (r9 != 0) goto L_0x00fc
            java.lang.ref.WeakReference<com.modiface.mfemakeupkit.MFEMakeupEngine$MFEMakeupEngineErrorCallback> r9 = r8.mErrorCallbackRef
            java.lang.Object r9 = r9.get()
            com.modiface.mfemakeupkit.MFEMakeupEngine$MFEMakeupEngineErrorCallback r9 = (com.modiface.mfemakeupkit.MFEMakeupEngine.MFEMakeupEngineErrorCallback) r9
            if (r9 == 0) goto L_0x00fc
            r9.onMakeupEngineError(r10)
        L_0x00fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.modiface.mfemakeupkit.MFEMakeupEngine.onMakeupApplied(boolean, java.util.ArrayList, com.modiface.mfemakeupkit.utils.MFEGLFramebuffer, com.modiface.mfemakeupkit.utils.MFEGLFramebuffer, com.modiface.mfemakeupkit.data.MFETrackingData, com.modiface.mfemakeupkit.effects.MFEMakeupProductCategory):void");
    }

    public MFEImage onNewCameraFrame(p pVar) {
        if (!this.mIsPaused.get() && this.mCurrentInputState.get() == a.CAMERA_LIVE_FEED) {
            this.cameraFps = (this.cameraFps * 0.9d) + (this.cameraTimer.a() * 0.1d);
            this.cameraTimer.c();
            y yVar = new y();
            MFEImage a2 = pVar.a(this.mLiveImageCache.poll());
            if (a2 != null) {
                Bitmap bitmap = a2.bitmap;
                if (bitmap != null && !bitmap.isRecycled() && a2.bitmap.getWidth() > 0 && a2.bitmap.getHeight() > 0 && a2.bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
                    MFEDebugInfo mFEDebugInfo = new MFEDebugInfo(kMFEMakeupEngineCameraDebugInfoName);
                    mFEDebugInfo.addSimpleDebugInfo("camera frame conversion time (ms)", yVar.d());
                    mFEDebugInfo.addSimpleDebugInfo("camera fps", this.cameraFps);
                    this.mDebugInfo.addSubDebugInfo(mFEDebugInfo);
                    return a2;
                }
            }
        }
        return null;
    }

    public void onPause() {
        this.mIsPaused.set(true);
        this.mCamera.a();
        callOnPauseOnMakeupViewsOnRenderThread();
        this.mFaceTrackingEngine.c();
        this.mMakeupRenderingEngine.a((Runnable) new t(this, this.mFaceTrackingEngine.a(this.mFaceTrackingEngineStreamTag)));
    }

    public void onProcessCameraFrameErrors(ArrayList<Throwable> arrayList) {
        if (!arrayList.isEmpty()) {
            MFEMakeupEngineErrorCallback mFEMakeupEngineErrorCallback = (MFEMakeupEngineErrorCallback) this.mErrorCallbackRef.get();
            if (mFEMakeupEngineErrorCallback != null) {
                mFEMakeupEngineErrorCallback.onMakeupEngineError(arrayList);
            }
        }
    }

    public void onRenderingEngineErrors(ArrayList<Throwable> arrayList) {
        if (!arrayList.isEmpty()) {
            MFEMakeupEngineErrorCallback mFEMakeupEngineErrorCallback = (MFEMakeupEngineErrorCallback) this.mErrorCallbackRef.get();
            if (mFEMakeupEngineErrorCallback != null) {
                mFEMakeupEngineErrorCallback.onMakeupEngineError(arrayList);
            }
        }
    }

    public void onResume(Context context) {
        if (context != null) {
            this.mMakeupRenderingEngine.c();
            this.mFaceTrackingEngine.d();
            this.mMakeupRenderingEngine.b((Runnable) new u(this));
            callOnResumeOnMakeupViewsOnRenderThread();
            this.mCamera.b(context);
            this.mIsPaused.set(false);
            return;
        }
        throw new IllegalArgumentException("context cannot be null when calling onResume() in MFEMakeupEngine");
    }

    public void requestRender() {
        this.mMakeupRenderingEngine.d();
    }

    public void requestToRender(aa aaVar) {
        if (aaVar != null) {
            this.mMakeupRenderingEngine.a((m.e) new k(this, aaVar));
        }
    }

    public void setCallback(b bVar) {
        this.mCallbackRef = new WeakReference<>(bVar);
    }

    public void setCameraErrorCallback(MFEAndroidCameraErrorCallback mFEAndroidCameraErrorCallback) {
        this.mCamera.a(mFEAndroidCameraErrorCallback);
    }

    public void setCameraParameters(Context context, MFEAndroidCameraParameters mFEAndroidCameraParameters) {
        this.mCamera.a(context, mFEAndroidCameraParameters);
    }

    public void setCameraParametersCallback(MFEAndroidCameraParametersCallback mFEAndroidCameraParametersCallback) {
        this.mCamera.a(mFEAndroidCameraParametersCallback);
    }

    public void setDetectionCallbackForCameraFeed(MFEMakeupEngineDetectionCallback mFEMakeupEngineDetectionCallback) {
        this.mDetectionCallbackRef = new WeakReference<>(mFEMakeupEngineDetectionCallback);
    }

    public void setErrorCallback(MFEMakeupEngineErrorCallback mFEMakeupEngineErrorCallback) {
        this.mErrorCallbackRef = new WeakReference<>(mFEMakeupEngineErrorCallback);
    }

    public void setImageProcessedCallbackForCameraFeed(MFEMakeupEngineImageProcessedCallback mFEMakeupEngineImageProcessedCallback) {
        this.mCameraImageProcessedCallbackRef = new WeakReference<>(mFEMakeupEngineImageProcessedCallback);
    }

    public void setMakeupLook(MFEMakeupLook mFEMakeupLook) {
        this.mMakeupRenderingEngine.a(mFEMakeupLook);
    }

    public void setMakeupRenderingParameters(MFEMakeupRenderingParameters mFEMakeupRenderingParameters) {
        this.mMakeupRenderingEngine.a(mFEMakeupRenderingParameters);
    }

    public void startRecordingOutputToVideoFile(File file, boolean z) {
        this.mMakeupRenderingEngine.b((Runnable) new h(this, file, z));
    }

    public void startRunningWithCamera(Context context) {
        if (!n.a()) {
            throw new IllegalStateException("must call startRunningWithCamera() of MFEMakeupEngine in UI thread");
        } else if (context != null) {
            this.mCurrentInputState.set(a.CAMERA_LIVE_FEED);
            this.mCamera.a((i.b) this);
            this.mCamera.a(context, (i.b) this);
        } else {
            throw new IllegalArgumentException("context cannot be null when calling startRunningWithCamera() in MFEMakeupEngine");
        }
    }

    public void startRunningWithPhoto(Bitmap bitmap, boolean z) {
        startRunningWithPhoto(bitmap, z, (MFEMakeupEngineDetectionCallback) null, (MFEMakeupEngineImageProcessedCallback) null);
    }

    public void stopRecording(RecordVideoOutputCompletionHandler recordVideoOutputCompletionHandler) {
        this.mMakeupRenderingEngine.a((Runnable) new i(this, recordVideoOutputCompletionHandler), (Runnable) new j(this, recordVideoOutputCompletionHandler));
    }

    public void takePictureFromCameraWithCompletionHandler(boolean z, TakePictureCameraParametersCallback takePictureCameraParametersCallback, TakePictureFromCameraCompletionHandler takePictureFromCameraCompletionHandler) {
        if (takePictureFromCameraCompletionHandler != null) {
            if (n.a()) {
                i iVar = this.mCamera;
                if (iVar == null) {
                    takePictureFromCameraCompletionHandler.onTakePictureFromCameraDone((Bitmap) null, (Bitmap) null, new IllegalStateException("failed to take picture because camera is not previously turned on or has failed to turn on"));
                } else {
                    iVar.a(z, (i.c) new g(this, takePictureCameraParametersCallback, takePictureFromCameraCompletionHandler));
                }
            } else {
                throw new IllegalStateException("must call takePictureFromCameraWithCompletionHandler() of MFEMakeupEngine in UI thread");
            }
        }
    }

    public void trackFaceOnPhotoInBackground(Bitmap bitmap, boolean z, FaceTrackedOnPhotoCompletionHandler faceTrackedOnPhotoCompletionHandler) {
        if (faceTrackedOnPhotoCompletionHandler != null) {
            if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0 || bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
                throw new IllegalArgumentException("Invalid bitmap to apply makeup on");
            }
            MFEImage mFEImage = new MFEImage();
            mFEImage.bitmap = bitmap;
            this.mFaceTrackingEngine.a(new u(mFEImage, com.modiface.mfemakeupkit.utils.f.a(), new e(f.STATIC, (MFEMakeupEngineDetectionCallback) null, (MFEMakeupEngineImageProcessedCallback) null)), new MFEFaceTrackingParameters(z ? 320 : 0, true), new e(this, faceTrackedOnPhotoCompletionHandler, bitmap));
        }
    }

    public MFEMakeupEngine(Context context, Region region, MFEMakeupEngineErrorCallback mFEMakeupEngineErrorCallback) {
        this.mInternalUpdateCallbackRefs = new CopyOnWriteArrayList<>();
        this.mMakeupViewRefs = new CopyOnWriteArrayList<>();
        this.mDetectionCallbackRef = new WeakReference<>((Object) null);
        this.mCameraImageProcessedCallbackRef = new WeakReference<>((Object) null);
        this.mLiveImageCache = new ConcurrentLinkedQueue<>();
        this.mCallbackRef = new WeakReference<>((Object) null);
        this.mErrorCallbackRef = new WeakReference<>((Object) null);
        this.mDebugInfo = new MFEDebugInfo(kMFEMakeupEngineDebugInfoName);
        this.mVideoRecorder = null;
        this.mIsPaused = new AtomicBoolean(false);
        this.cameraTimer = new y();
        this.cameraFps = 0.0d;
        this.mFaceTrackingEngineStreamTag = new Object();
        this.mCurrentInputState = new AtomicReference<>(a.NONE);
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null when calling MFEMakeupEngine constructor");
        } else if (region != null) {
            setErrorCallback(mFEMakeupEngineErrorCallback);
            this.serverRegion = region;
            this.mCamera = i.a(context, region);
            this.mFaceTrackingEngine = j.a(context, region);
            this.mMakeupRenderingEngine = new m(context, region);
            this.mMakeupRenderingEngine.a((m.c) this);
            this.mMakeupRenderingEngine.a((m.d) this);
            this.mMakeupRenderingEngine.a(new MFEMakeupRenderingParameters(false));
        } else {
            throw new IllegalArgumentException("region cannot be null when calling MFEMakeupEngine constructor");
        }
    }

    public void disableFaceTracking() {
        disableFaceTracking((c) null);
    }

    public void enableFaceTracking() {
        enableFaceTracking((d) null);
    }

    public void loadResources(String str, MFEMakeupEngineLoadResourcesCallback mFEMakeupEngineLoadResourcesCallback) {
        this.mFaceTrackingEngine.a(str, (j.c) new o(this, mFEMakeupEngineLoadResourcesCallback));
    }

    public void startRunningWithPhoto(Bitmap bitmap, boolean z, MFEMakeupEngineDetectionCallback mFEMakeupEngineDetectionCallback, MFEMakeupEngineImageProcessedCallback mFEMakeupEngineImageProcessedCallback) {
        if (!n.a()) {
            throw new IllegalStateException("must call startRunningWithPhoto() of MFEMakeupEngine in UI thread");
        } else if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0 || bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            throw new IllegalArgumentException("Invalid bitmap to apply makeup on");
        } else {
            this.mCurrentInputState.set(a.STATIC_IMAGE);
            MFEImage mFEImage = new MFEImage();
            mFEImage.bitmap = bitmap;
            this.mCamera.a((i.b) this);
            this.mFaceTrackingEngine.a(new u(mFEImage, com.modiface.mfemakeupkit.utils.f.a(), true, new e(f.STATIC, mFEMakeupEngineDetectionCallback, mFEMakeupEngineImageProcessedCallback)), new MFEFaceTrackingParameters(z ? 320 : 0, true), new v(this));
        }
    }
}
