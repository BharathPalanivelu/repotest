package com.modiface.mfemakeupkit.widgets;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import com.modiface.mfemakeupkit.aa;
import com.modiface.mfemakeupkit.data.MFETrackingData;
import com.modiface.mfemakeupkit.utils.MFEDebugInfo;
import com.modiface.mfemakeupkit.utils.q;
import com.modiface.mfemakeupkit.utils.y;
import java.util.concurrent.atomic.AtomicReference;

public class MFEMakeupView extends TextureView implements TextureView.SurfaceTextureListener, aa.a {
    private static final String TAG = "MFEMakeupView";
    private static final String kMFEDisplayMakeupDebugInfoName = "Display";
    private static final String kMFEMakeupViewDebugInfoName = "MFE Makeup View";
    private static final String kMFESurfaceTextureDebugInfoName = "Surface Texture";
    private final MFEDebugInfo mDebugInfo = new MFEDebugInfo(kMFEMakeupViewDebugInfoName);
    private double mDisplayFPS = 0.0d;
    private final y mDisplayTimer = new y();
    private final aa mMakeupSurface = new e(this);
    /* access modifiers changed from: private */
    public AtomicReference<MFEMakeupZoomArea> mZoomAreaRef = new AtomicReference<>(MFEMakeupZoomArea.None);

    static {
        q.a("MFEMakeupKit");
        registerNatives();
    }

    public MFEMakeupView(Context context) {
        super(context);
        init();
    }

    private void init() {
        setSurfaceTextureListener(this);
        this.mMakeupSurface.a((aa.a) this);
    }

    /* access modifiers changed from: private */
    public native void jniCalculateZoomArea(MFEMakeupZoomArea mFEMakeupZoomArea, int i, int i2, MFETrackingData mFETrackingData, RectF rectF);

    private static native void registerNatives();

    private void setNewSurfaceTexture(SurfaceTexture surfaceTexture, int i, int i2) {
        MFEDebugInfo mFEDebugInfo = new MFEDebugInfo(kMFESurfaceTextureDebugInfoName);
        mFEDebugInfo.addSimpleDebugInfo("available", true);
        mFEDebugInfo.addDetailedDebugInfo("width", i);
        mFEDebugInfo.addDetailedDebugInfo("height", i2);
        this.mMakeupSurface.a(surfaceTexture, i, i2);
        this.mDebugInfo.addSubDebugInfo(mFEDebugInfo);
    }

    public MFEDebugInfo getDebugInfo() {
        return this.mDebugInfo.getNewCopy();
    }

    public MFEDebugInfo getDebugInfoToPopulateOn() {
        return new MFEDebugInfo(kMFEDisplayMakeupDebugInfoName);
    }

    public aa getMakeupSurface() {
        return this.mMakeupSurface;
    }

    public void onRenderDone(MFEDebugInfo mFEDebugInfo) {
        this.mDisplayFPS = (this.mDisplayFPS * 0.9d) + (this.mDisplayTimer.a() * 0.1d);
        this.mDisplayTimer.c();
        mFEDebugInfo.addSimpleDebugInfo("display FPS", this.mDisplayFPS);
        this.mDebugInfo.addSubDebugInfo(mFEDebugInfo);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        setNewSurfaceTexture(surfaceTexture, i, i2);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.mMakeupSurface.a();
        MFEDebugInfo mFEDebugInfo = new MFEDebugInfo(kMFESurfaceTextureDebugInfoName);
        mFEDebugInfo.addSimpleDebugInfo("available", false);
        this.mDebugInfo.addSubDebugInfo(mFEDebugInfo);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        setNewSurfaceTexture(surfaceTexture, i, i2);
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setShowBefore(boolean z) {
        this.mMakeupSurface.a(z);
    }

    public void setZoomArea(MFEMakeupZoomArea mFEMakeupZoomArea) {
        if (mFEMakeupZoomArea == null) {
            mFEMakeupZoomArea = MFEMakeupZoomArea.None;
        }
        this.mZoomAreaRef.set(mFEMakeupZoomArea);
        this.mMakeupSurface.e();
    }

    public MFEMakeupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MFEMakeupView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
