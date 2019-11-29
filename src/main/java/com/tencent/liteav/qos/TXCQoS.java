package com.tencent.liteav.qos;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.b;
import com.tencent.rtmp.TXLiveConstants;

public class TXCQoS {
    public static final int AUTO_ADJUST_LIVEPUSH_RESOLUTION_STRATEGY = 1;
    public static final int AUTO_ADJUST_REALTIME_VIDEOCHAT_STRATEGY = 5;
    static final String TAG = "TXCQos";
    /* access modifiers changed from: private */
    public int mAutoStrategy = -1;
    /* access modifiers changed from: private */
    public int mBitrate = 0;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler();
    /* access modifiers changed from: private */
    public int mHeight = 0;
    /* access modifiers changed from: private */
    public long mInstance;
    /* access modifiers changed from: private */
    public long mInterval = 1000;
    /* access modifiers changed from: private */
    public boolean mIsEnableDrop = false;
    /* access modifiers changed from: private */
    public a mListener;
    /* access modifiers changed from: private */
    public a mNotifyListener;
    private Runnable mRunnable = new Runnable() {
        public void run() {
            if (TXCQoS.this.mListener != null) {
                int b2 = TXCQoS.this.mListener.b();
                int c2 = TXCQoS.this.mListener.c();
                int d2 = TXCQoS.this.mListener.d();
                int e2 = TXCQoS.this.mListener.e();
                int f2 = TXCQoS.this.mListener.f();
                int g2 = TXCQoS.this.mListener.g();
                TXCQoS tXCQoS = TXCQoS.this;
                tXCQoS.nativeSetVideoRealBitrate(tXCQoS.mInstance, b2);
                TXCQoS tXCQoS2 = TXCQoS.this;
                tXCQoS2.nativeAdjustBitrate(tXCQoS2.mInstance, e2, f2, g2, d2, c2);
                TXCQoS tXCQoS3 = TXCQoS.this;
                boolean access$400 = tXCQoS3.nativeIsEnableDrop(tXCQoS3.mInstance);
                if (TXCQoS.this.mIsEnableDrop != access$400) {
                    boolean unused = TXCQoS.this.mIsEnableDrop = access$400;
                    TXCQoS.this.mListener.a(access$400);
                }
                TXCQoS tXCQoS4 = TXCQoS.this;
                int access$600 = tXCQoS4.nativeGetBitrate(tXCQoS4.mInstance);
                TXCQoS tXCQoS5 = TXCQoS.this;
                int access$700 = tXCQoS5.nativeGetWidth(tXCQoS5.mInstance);
                TXCQoS tXCQoS6 = TXCQoS.this;
                int access$800 = tXCQoS6.nativeGetHeight(tXCQoS6.mInstance);
                if (access$700 == TXCQoS.this.mWidth && access$800 == TXCQoS.this.mHeight) {
                    if (access$600 != TXCQoS.this.mBitrate) {
                        TXCQoS.this.mListener.b(access$600, 0, 0);
                        if (TXCQoS.this.mNotifyListener != null) {
                            Bundle bundle = new Bundle();
                            bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, "调整编码码率:new bitrate:" + access$600);
                            bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                            bundle.putString("EVT_USERID", TXCQoS.this.mUserID);
                            TXCQoS.this.mNotifyListener.onNotifyEvent(1006, bundle);
                        }
                    }
                } else if (TXCQoS.this.mAutoStrategy == 1 || TXCQoS.this.mAutoStrategy == 5) {
                    TXCQoS.this.mListener.b(access$600, access$700, access$800);
                    if (TXCQoS.this.mNotifyListener != null) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, "调整分辨率:new bitrate:" + access$600 + " new resolution:" + access$700 + "*" + access$800);
                        bundle2.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                        TXCQoS.this.mNotifyListener.onNotifyEvent(1005, bundle2);
                    }
                }
                int unused2 = TXCQoS.this.mBitrate = access$600;
                int unused3 = TXCQoS.this.mWidth = access$700;
                int unused4 = TXCQoS.this.mHeight = access$800;
            }
            TXCQoS.this.mHandler.postDelayed(this, TXCQoS.this.mInterval);
        }
    };
    /* access modifiers changed from: private */
    public String mUserID = "";
    /* access modifiers changed from: private */
    public int mWidth = 0;

    private native void nativeAddQueueInputSize(long j, int i);

    private native void nativeAddQueueOutputSize(long j, int i);

    /* access modifiers changed from: private */
    public native void nativeAdjustBitrate(long j, int i, int i2, int i3, int i4, int i5);

    private native void nativeDeinit(long j);

    /* access modifiers changed from: private */
    public native int nativeGetBitrate(long j);

    /* access modifiers changed from: private */
    public native int nativeGetHeight(long j);

    public static native int nativeGetProperResolutionByVideoBitrate(boolean z, int i, int i2);

    /* access modifiers changed from: private */
    public native int nativeGetWidth(long j);

    private native long nativeInit(boolean z);

    /* access modifiers changed from: private */
    public native boolean nativeIsEnableDrop(long j);

    private native void nativeReset(long j, boolean z);

    private native void nativeSetAutoAdjustBitrate(long j, boolean z);

    private native void nativeSetAutoAdjustStrategy(long j, int i);

    private native void nativeSetHasVideo(long j, boolean z);

    private native void nativeSetVideoDefaultResolution(long j, int i);

    private native void nativeSetVideoEncBitrate(long j, int i, int i2, int i3);

    private native void nativeSetVideoExpectBitrate(long j, int i);

    /* access modifiers changed from: private */
    public native void nativeSetVideoRealBitrate(long j, int i);

    public TXCQoS(boolean z) {
        this.mInstance = nativeInit(z);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            nativeDeinit(this.mInstance);
        } finally {
            super.finalize();
        }
    }

    public void start(long j) {
        this.mInterval = j;
        this.mHandler.postDelayed(this.mRunnable, this.mInterval);
    }

    public void stop() {
        this.mHandler.removeCallbacks(this.mRunnable);
        this.mAutoStrategy = -1;
    }

    public String getUserID() {
        return this.mUserID;
    }

    public void setUserID(String str) {
        this.mUserID = str;
    }

    public void setNotifyListener(a aVar) {
        this.mNotifyListener = aVar;
    }

    public void setListener(a aVar) {
        this.mListener = aVar;
    }

    public void reset(boolean z) {
        nativeReset(this.mInstance, z);
    }

    public boolean isEnableDrop() {
        return nativeIsEnableDrop(this.mInstance);
    }

    public void setHasVideo(boolean z) {
        nativeSetHasVideo(this.mInstance, z);
    }

    public void setAutoAdjustBitrate(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("autoAdjustBitrate is ");
        sb.append(z ? "yes" : "no");
        TXCLog.d(TAG, sb.toString());
        nativeSetAutoAdjustBitrate(this.mInstance, z);
    }

    public void setAutoAdjustStrategy(int i) {
        TXCLog.d(TAG, "autoAdjustStrategy is " + i);
        nativeSetAutoAdjustStrategy(this.mInstance, i);
        this.mAutoStrategy = i;
    }

    public void setDefaultVideoResolution(int i) {
        TXCLog.d(TAG, "DefaultVideoResolution is " + i);
        this.mWidth = 0;
        this.mHeight = 0;
        nativeSetVideoDefaultResolution(this.mInstance, i);
    }

    public void setVideoEncBitrate(int i, int i2, int i3) {
        this.mBitrate = 0;
        nativeSetVideoEncBitrate(this.mInstance, i, i2, i3);
    }

    public void setVideoExpectBitrate(int i) {
        nativeSetVideoExpectBitrate(this.mInstance, i);
    }

    static {
        b.f();
    }
}
