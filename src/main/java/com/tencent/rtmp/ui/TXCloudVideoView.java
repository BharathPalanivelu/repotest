package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.liteav.l;
import com.tencent.liteav.renderer.TXCFocusIndicatorView;
import com.tencent.liteav.renderer.TXCGLSurfaceView;

public class TXCloudVideoView extends FrameLayout implements View.OnTouchListener {
    private static final int FOCUS_AREA_SIZE_DP = 70;
    private static final String TAG = "TXCloudVideoView";
    /* access modifiers changed from: private */
    public float mBottom;
    /* access modifiers changed from: private */
    public l mCapture;
    private int mCaptureHeight;
    private int mCaptureWidth;
    /* access modifiers changed from: private */
    public int mCurrentScale;
    protected TXDashBoard mDashBoard;
    /* access modifiers changed from: private */
    public boolean mFocus;
    private int mFocusAreaSize;
    protected TXCFocusIndicatorView mFocusIndicatorView;
    protected TXCGLSurfaceView mGLSurfaceView;
    /* access modifiers changed from: private */
    public float mLeft;
    /* access modifiers changed from: private */
    public float mRight;
    private ScaleGestureDetector mScaleGestureDetector;
    private ScaleGestureDetector.OnScaleGestureListener mScaleGestureListener;
    /* access modifiers changed from: private */
    public float mTop;
    private a mTouchFocusRunnable;
    private String mUserId;
    protected TextureView mVideoView;
    private boolean mZoom;

    private int clamp(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void setMirror(boolean z) {
    }

    public void setRenderMode(int i) {
    }

    public void setRenderRotation(int i) {
    }

    public TXCloudVideoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TXCloudVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCaptureWidth = 0;
        this.mCaptureHeight = 0;
        this.mLeft = BitmapDescriptorFactory.HUE_RED;
        this.mRight = BitmapDescriptorFactory.HUE_RED;
        this.mTop = BitmapDescriptorFactory.HUE_RED;
        this.mBottom = BitmapDescriptorFactory.HUE_RED;
        this.mFocusAreaSize = 0;
        this.mUserId = "";
        this.mFocus = false;
        this.mZoom = false;
        this.mCurrentScale = 1;
        this.mScaleGestureDetector = null;
        this.mScaleGestureListener = new ScaleGestureDetector.OnScaleGestureListener() {
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            }

            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                int e2 = TXCloudVideoView.this.mCapture != null ? TXCloudVideoView.this.mCapture.e() : 0;
                if (e2 > 0) {
                    float scaleFactor = scaleGestureDetector.getScaleFactor();
                    if (scaleFactor > 1.0f) {
                        scaleFactor = ((0.2f / ((float) e2)) * ((float) (e2 - TXCloudVideoView.this.mCurrentScale))) + 1.0f;
                        if (scaleFactor <= 1.1f) {
                            scaleFactor = 1.1f;
                        }
                    } else if (scaleFactor < 1.0f) {
                        scaleFactor = 1.0f - ((0.2f / ((float) e2)) * ((float) TXCloudVideoView.this.mCurrentScale));
                        if (scaleFactor >= 0.9f) {
                            scaleFactor = 0.9f;
                        }
                    }
                    int round = Math.round(((float) TXCloudVideoView.this.mCurrentScale) * scaleFactor);
                    if (round == TXCloudVideoView.this.mCurrentScale) {
                        if (scaleFactor > 1.0f) {
                            round++;
                        } else if (scaleFactor < 1.0f) {
                            round--;
                        }
                    }
                    if (round < e2) {
                        e2 = round;
                    }
                    if (e2 <= 1) {
                        e2 = 1;
                    }
                    if (scaleFactor > 1.0f) {
                        if (e2 < TXCloudVideoView.this.mCurrentScale) {
                            e2 = TXCloudVideoView.this.mCurrentScale;
                        }
                    } else if (scaleFactor < 1.0f && e2 > TXCloudVideoView.this.mCurrentScale) {
                        e2 = TXCloudVideoView.this.mCurrentScale;
                    }
                    int unused = TXCloudVideoView.this.mCurrentScale = e2;
                    if (TXCloudVideoView.this.mCapture != null) {
                        TXCloudVideoView.this.mCapture.a(TXCloudVideoView.this.mCurrentScale);
                    }
                }
                return false;
            }
        };
        this.mTouchFocusRunnable = new a();
        this.mDashBoard = new TXDashBoard(context);
        this.mScaleGestureDetector = new ScaleGestureDetector(context, this.mScaleGestureListener);
    }

    public void addVideoView(TXCGLSurfaceView tXCGLSurfaceView) {
        TXCGLSurfaceView tXCGLSurfaceView2 = this.mGLSurfaceView;
        if (tXCGLSurfaceView2 != null) {
            removeView(tXCGLSurfaceView2);
        }
        this.mGLSurfaceView = tXCGLSurfaceView;
        addView(this.mGLSurfaceView);
        resetLogView();
    }

    public void addVideoView(TextureView textureView) {
        TextureView textureView2 = this.mVideoView;
        if (textureView2 != null) {
            removeView(textureView2);
        }
        this.mVideoView = textureView;
        addView(this.mVideoView);
        resetLogView();
    }

    public void removeVideoView() {
        TextureView textureView = this.mVideoView;
        if (textureView != null) {
            removeView(textureView);
            this.mVideoView = null;
        }
        TXCGLSurfaceView tXCGLSurfaceView = this.mGLSurfaceView;
        if (tXCGLSurfaceView != null) {
            removeView(tXCGLSurfaceView);
            this.mGLSurfaceView = null;
        }
    }

    public void removeFocusIndicatorView() {
        TXCFocusIndicatorView tXCFocusIndicatorView = this.mFocusIndicatorView;
        if (tXCFocusIndicatorView != null) {
            removeView(tXCFocusIndicatorView);
            this.mFocusIndicatorView = null;
        }
    }

    public TextureView getVideoView() {
        return this.mVideoView;
    }

    public TXCGLSurfaceView getGLSurfaceView() {
        return this.mGLSurfaceView;
    }

    public TextureView getHWVideoView() {
        return this.mVideoView;
    }

    public void clearLastFrame(boolean z) {
        if (z) {
            setVisibility(8);
        }
    }

    public void onTouchFocus(int i, int i2) {
        if (this.mGLSurfaceView != null) {
            if (i < 0 || i2 < 0) {
                TXCFocusIndicatorView tXCFocusIndicatorView = this.mFocusIndicatorView;
                if (tXCFocusIndicatorView != null) {
                    tXCFocusIndicatorView.setVisibility(8);
                    return;
                }
                return;
            }
            TXCFocusIndicatorView tXCFocusIndicatorView2 = this.mFocusIndicatorView;
            if (tXCFocusIndicatorView2 == null) {
                this.mFocusIndicatorView = new TXCFocusIndicatorView(getContext());
                this.mFocusIndicatorView.setVisibility(0);
                addView(this.mFocusIndicatorView);
            } else if (indexOfChild(tXCFocusIndicatorView2) != getChildCount() - 1) {
                removeView(this.mFocusIndicatorView);
                addView(this.mFocusIndicatorView);
            }
            Rect touchRect = getTouchRect(i, i2, this.mGLSurfaceView.getWidth(), this.mGLSurfaceView.getHeight(), 1.0f);
            this.mFocusIndicatorView.show(touchRect.left, touchRect.top, touchRect.right - touchRect.left);
        }
    }

    private Rect getTouchRect(int i, int i2, int i3, int i4, float f2) {
        if (this.mFocusAreaSize == 0) {
            TXCGLSurfaceView tXCGLSurfaceView = this.mGLSurfaceView;
            if (tXCGLSurfaceView != null) {
                this.mFocusAreaSize = (int) ((tXCGLSurfaceView.getResources().getDisplayMetrics().density * 70.0f) + 0.5f);
            }
        }
        int intValue = Float.valueOf(((float) this.mFocusAreaSize) * f2).intValue();
        int i5 = intValue / 2;
        int clamp = clamp(i - i5, 0, i3 - intValue);
        int clamp2 = clamp(i2 - i5, 0, i4 - intValue);
        return new Rect(clamp, clamp2, clamp + intValue, intValue + clamp2);
    }

    public void disableLog(boolean z) {
        TXDashBoard tXDashBoard = this.mDashBoard;
        if (tXDashBoard != null) {
            tXDashBoard.a(z);
        }
    }

    public void showLog(boolean z) {
        TXDashBoard tXDashBoard = this.mDashBoard;
        if (tXDashBoard != null) {
            tXDashBoard.setShowLevel(z ? 2 : 0);
        }
    }

    public void clearLog() {
        TXDashBoard tXDashBoard = this.mDashBoard;
        if (tXDashBoard != null) {
            tXDashBoard.a();
        }
    }

    public void setLogText(Bundle bundle, Bundle bundle2, int i) {
        TXDashBoard tXDashBoard = this.mDashBoard;
        if (tXDashBoard != null) {
            tXDashBoard.a(bundle, bundle2, i);
        }
    }

    /* access modifiers changed from: protected */
    public void resetLogView() {
        TXDashBoard tXDashBoard = this.mDashBoard;
        if (tXDashBoard != null) {
            removeView(tXDashBoard);
            addView(this.mDashBoard);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        updateDbMargin();
        TXDashBoard tXDashBoard = this.mDashBoard;
        if (tXDashBoard != null) {
            double px2dip = (double) px2dip(getContext(), (float) getWidth());
            Double.isNaN(px2dip);
            tXDashBoard.setStatusTextSize((float) (px2dip / 30.0d));
            TXDashBoard tXDashBoard2 = this.mDashBoard;
            double px2dip2 = (double) px2dip(getContext(), (float) getWidth());
            Double.isNaN(px2dip2);
            tXDashBoard2.setEventTextSize((float) (px2dip2 / 25.0d));
        }
        int i5 = this.mCaptureWidth;
        if (i5 != 0) {
            int i6 = this.mCaptureHeight;
            if (i6 != 0) {
                updateVideoViewSize(i5, i6);
            }
        }
    }

    public void updateVideoViewSize(int i, int i2) {
        int i3;
        FrameLayout.LayoutParams layoutParams;
        View view = this.mGLSurfaceView;
        if (view == null) {
            view = this.mVideoView;
            if (view == null) {
                return;
            }
        }
        int width = getWidth();
        int height = getHeight();
        if (i2 != 0 && height != 0) {
            this.mCaptureWidth = i;
            this.mCaptureHeight = i2;
            float f2 = (((float) i) * 1.0f) / ((float) i2);
            float f3 = (float) width;
            float f4 = (float) height;
            int i4 = 0;
            if (f2 > (1.0f * f3) / f4) {
                height = (int) (f3 / f2);
                i4 = (getHeight() - height) / 2;
                i3 = 0;
            } else {
                width = (int) (f4 * f2);
                i3 = (getWidth() - width) / 2;
            }
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams = (FrameLayout.LayoutParams) layoutParams2;
                if (layoutParams.width != width || layoutParams.height != height) {
                    layoutParams.width = width;
                    layoutParams.height = height;
                } else {
                    return;
                }
            } else {
                layoutParams = new FrameLayout.LayoutParams(width, height);
            }
            layoutParams.leftMargin = i3;
            layoutParams.topMargin = i4;
            view.setLayoutParams(layoutParams);
        }
    }

    public void setDashBoardStatusInfo(CharSequence charSequence) {
        TXDashBoard tXDashBoard = this.mDashBoard;
        if (tXDashBoard != null) {
            tXDashBoard.a(charSequence);
        }
    }

    public void appendEventInfo(String str) {
        TXDashBoard tXDashBoard = this.mDashBoard;
        if (tXDashBoard != null) {
            tXDashBoard.a(str);
        }
    }

    public void showVideoDebugLog(int i) {
        TXDashBoard tXDashBoard = this.mDashBoard;
        if (tXDashBoard != null) {
            tXDashBoard.setShowLevel(i);
        }
    }

    public void setLogMargin(float f2, float f3, float f4, float f5) {
        this.mLeft = f2;
        this.mRight = f3;
        this.mTop = f4;
        this.mBottom = f5;
        TXDashBoard tXDashBoard = this.mDashBoard;
        if (tXDashBoard != null) {
            tXDashBoard.a((int) this.mLeft, (int) this.mTop, (int) this.mRight, (int) this.mBottom);
        }
    }

    public void setLogMarginRatio(float f2, float f3, float f4, float f5) {
        getWidth();
        getHeight();
        final float f6 = f2;
        final float f7 = f3;
        final float f8 = f4;
        final float f9 = f5;
        postDelayed(new Runnable() {
            public void run() {
                TXCloudVideoView tXCloudVideoView = TXCloudVideoView.this;
                float unused = tXCloudVideoView.mLeft = ((float) tXCloudVideoView.getWidth()) * f6;
                TXCloudVideoView tXCloudVideoView2 = TXCloudVideoView.this;
                float unused2 = tXCloudVideoView2.mRight = ((float) tXCloudVideoView2.getWidth()) * f7;
                TXCloudVideoView tXCloudVideoView3 = TXCloudVideoView.this;
                float unused3 = tXCloudVideoView3.mTop = ((float) tXCloudVideoView3.getHeight()) * f8;
                TXCloudVideoView tXCloudVideoView4 = TXCloudVideoView.this;
                float unused4 = tXCloudVideoView4.mBottom = ((float) tXCloudVideoView4.getHeight()) * f9;
                if (TXCloudVideoView.this.mDashBoard != null) {
                    TXCloudVideoView.this.mDashBoard.a((int) TXCloudVideoView.this.mLeft, (int) TXCloudVideoView.this.mTop, (int) TXCloudVideoView.this.mRight, (int) TXCloudVideoView.this.mBottom);
                }
            }
        }, 100);
    }

    public String getUserId() {
        return this.mUserId;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public static int px2dip(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void updateDbMargin() {
        TXDashBoard tXDashBoard = this.mDashBoard;
        if (tXDashBoard != null) {
            tXDashBoard.a((int) this.mLeft, (int) this.mTop, (int) this.mRight, (int) this.mBottom);
        }
    }

    public void start(boolean z, boolean z2, l lVar) {
        this.mFocus = z;
        this.mZoom = z2;
        if (this.mFocus || this.mZoom) {
            setOnTouchListener(this);
            this.mCapture = lVar;
        }
        TXCGLSurfaceView tXCGLSurfaceView = this.mGLSurfaceView;
        if (tXCGLSurfaceView != null) {
            tXCGLSurfaceView.setVisibility(0);
        }
    }

    public void stop(boolean z) {
        if (this.mFocus || this.mZoom) {
            setOnTouchListener((View.OnTouchListener) null);
        }
        this.mCapture = null;
        if (z) {
            TXCGLSurfaceView tXCGLSurfaceView = this.mGLSurfaceView;
            if (tXCGLSurfaceView != null) {
                tXCGLSurfaceView.setVisibility(8);
            }
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 1 && motionEvent.getAction() == 0) {
            this.mTouchFocusRunnable.a(view);
            this.mTouchFocusRunnable.a(motionEvent);
            postDelayed(this.mTouchFocusRunnable, 100);
        } else if (motionEvent.getPointerCount() > 1 && motionEvent.getAction() == 2) {
            removeCallbacks(this.mTouchFocusRunnable);
            onTouchFocus(-1, -1);
            ScaleGestureDetector scaleGestureDetector = this.mScaleGestureDetector;
            if (scaleGestureDetector != null && this.mZoom) {
                scaleGestureDetector.onTouchEvent(motionEvent);
            }
        }
        if (this.mZoom && motionEvent.getAction() == 0) {
            performClick();
        }
        return this.mZoom;
    }

    private class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private View f32476b;

        /* renamed from: c  reason: collision with root package name */
        private MotionEvent f32477c;

        private a() {
        }

        public void a(View view) {
            this.f32476b = view;
        }

        public void a(MotionEvent motionEvent) {
            this.f32477c = motionEvent;
        }

        public void run() {
            if (TXCloudVideoView.this.mCapture != null && TXCloudVideoView.this.mFocus) {
                TXCloudVideoView.this.mCapture.a(this.f32477c.getX() / ((float) this.f32476b.getWidth()), this.f32477c.getY() / ((float) this.f32476b.getHeight()));
            }
            if (TXCloudVideoView.this.mFocus) {
                TXCloudVideoView.this.onTouchFocus((int) this.f32477c.getX(), (int) this.f32477c.getY());
            }
        }
    }
}
