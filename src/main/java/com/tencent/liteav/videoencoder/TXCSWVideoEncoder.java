package com.tencent.liteav.videoencoder;

import android.media.MediaCodec;
import android.opengl.GLES20;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.b;
import com.tencent.liteav.beauty.b.o;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class TXCSWVideoEncoder extends c {
    private static final boolean DEBUG = false;
    private static final String TAG = "TXCSWVideoEncoder";
    private int mBitrate = 0;
    /* access modifiers changed from: private */
    public long mNativeEncoder = 0;
    /* access modifiers changed from: private */
    public long mPTS = 0;
    private int mPopIdx = 0;
    private int mPushIdx = 0;
    private g mRawFrameFilter;
    private int mRendIdx = 0;
    private g mResizeFilter;

    private static native void nativeClassInit();

    private native void nativeEnableNearestRPS(long j, int i);

    /* access modifiers changed from: private */
    public native int nativeEncode(long j, int i, int i2, int i3, long j2);

    /* access modifiers changed from: private */
    public native int nativeEncodeSync(long j, int i, int i2, int i3, long j2);

    private static native long nativeGetAndIncreaseGopIndex();

    private static native long nativeGetAndIncreaseSeq();

    private native long nativeGetRealFPS(long j);

    private native long nativeInit(WeakReference<TXCSWVideoEncoder> weakReference);

    private native void nativeRelease(long j);

    private native void nativeRestartIDR(long j);

    private native void nativeSetBitrate(long j, int i);

    private native void nativeSetBitrateFromQos(long j, int i, int i2);

    private native void nativeSetEncodeIdrFpsFromQos(long j, int i);

    private native void nativeSetFPS(long j, int i);

    private native void nativeSetID(long j, String str);

    private native void nativeSetRPSRefBitmap(long j, int i, int i2, long j2);

    private native void nativeSignalEOSAndFlush(long j);

    private native int nativeStart(long j, TXSVideoEncoderParam tXSVideoEncoderParam);

    private native void nativeStop(long j);

    private native long nativegetRealBitrate(long j);

    public int start(TXSVideoEncoderParam tXSVideoEncoderParam) {
        super.start(tXSVideoEncoderParam);
        int i = ((tXSVideoEncoderParam.width + 7) / 8) * 8;
        int i2 = ((tXSVideoEncoderParam.height + 1) / 2) * 2;
        if (!(i == tXSVideoEncoderParam.width && i2 == tXSVideoEncoderParam.height)) {
            TXCLog.w(TAG, "Encode Resolution not supportted, transforming...");
            String str = TAG;
            TXCLog.w(str, tXSVideoEncoderParam.width + "x" + tXSVideoEncoderParam.height + "-> " + i + "x" + i2);
        }
        tXSVideoEncoderParam.width = i;
        tXSVideoEncoderParam.height = i2;
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
        this.mInputWidth = i;
        this.mInputHeight = i2;
        this.mNativeEncoder = nativeInit(new WeakReference(this));
        nativeSetBitrate(this.mNativeEncoder, this.mBitrate);
        nativeSetID(this.mNativeEncoder, getID());
        nativeStart(this.mNativeEncoder, tXSVideoEncoderParam);
        return 0;
    }

    public void stop() {
        String str = TAG;
        TXCLog.i(str, "stop->enter with mRawFrameFilter:" + this.mRawFrameFilter);
        this.mGLContextExternal = null;
        nativeStop(this.mNativeEncoder);
        nativeRelease(this.mNativeEncoder);
        this.mNativeEncoder = 0;
        g gVar = this.mRawFrameFilter;
        if (gVar != null) {
            gVar.d();
            this.mRawFrameFilter = null;
        }
        g gVar2 = this.mResizeFilter;
        if (gVar2 != null) {
            gVar2.d();
            this.mResizeFilter = null;
        }
        super.stop();
    }

    public void setID(String str) {
        super.setID(str);
        nativeSetID(this.mNativeEncoder, str);
    }

    public void setFPS(int i) {
        nativeSetFPS(this.mNativeEncoder, i);
    }

    public void enableNearestRPS(int i) {
        nativeEnableNearestRPS(this.mNativeEncoder, i);
    }

    public void setBitrate(int i) {
        this.mBitrate = i;
        nativeSetBitrate(this.mNativeEncoder, i);
    }

    public void setBitrateFromQos(int i, int i2) {
        this.mBitrate = i;
        nativeSetBitrateFromQos(this.mNativeEncoder, i, i2);
    }

    public void setEncodeIdrFpsFromQos(int i) {
        nativeSetEncodeIdrFpsFromQos(this.mNativeEncoder, i);
    }

    public double getRealFPS() {
        return (double) nativeGetRealFPS(this.mNativeEncoder);
    }

    public long getRealBitrate() {
        return nativegetRealBitrate(this.mNativeEncoder);
    }

    public long pushVideoFrame(int i, int i2, int i3, long j) {
        return pushVideoFrameInternal(i, i2, i3, j, false);
    }

    public long pushVideoFrameSync(int i, int i2, int i3, long j) {
        return pushVideoFrameInternal(i, i2, i3, j, true);
    }

    public void signalEOSAndFlush() {
        nativeSignalEOSAndFlush(this.mNativeEncoder);
    }

    public void setRPSRefBitmap(int i, int i2, long j) {
        nativeSetRPSRefBitmap(this.mNativeEncoder, i, i2, j);
    }

    public void restartIDR() {
        nativeRestartIDR(this.mNativeEncoder);
    }

    public static long getAndIncreateSeq() {
        return nativeGetAndIncreaseSeq();
    }

    public static long getAndIncreaseGopIndex() {
        return nativeGetAndIncreaseGopIndex();
    }

    private static void postEventFromNative(WeakReference<TXCSWVideoEncoder> weakReference, byte[] bArr, int i, long j, long j2, long j3, long j4, long j5, long j6, int i2) {
        TXCSWVideoEncoder tXCSWVideoEncoder = (TXCSWVideoEncoder) weakReference.get();
        if (tXCSWVideoEncoder != null) {
            tXCSWVideoEncoder.callDelegate(bArr, i, j, j2, j3, j4, j5, j6, i2, (ByteBuffer) null, (MediaCodec.BufferInfo) null);
        }
    }

    private static void onEncodeFinishedFromNative(WeakReference<TXCSWVideoEncoder> weakReference, long j, long j2, long j3) {
        TXCSWVideoEncoder tXCSWVideoEncoder = (TXCSWVideoEncoder) weakReference.get();
        if (tXCSWVideoEncoder != null) {
            tXCSWVideoEncoder.onEncodeFinished(j, j2, j3);
        }
    }

    private long pushVideoFrameInternal(int i, int i2, int i3, long j, boolean z) {
        int i4;
        int i5 = i2;
        int i6 = i3;
        if (this.mGLContextExternal == null) {
            return 0;
        }
        this.mInputWidth = i5;
        this.mInputHeight = i6;
        if (this.mResizeFilter == null) {
            this.mResizeFilter = new g();
            this.mResizeFilter.a();
            this.mResizeFilter.a(true);
        }
        this.mResizeFilter.a(this.mOutputWidth, this.mOutputHeight);
        GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
        if (this.mResizeFilter != null) {
            float[] a2 = this.mResizeFilter.a(i2, i3, (FloatBuffer) null, b.a(i2, i6, this.mOutputWidth, this.mOutputHeight), 0);
            int i7 = (720 - this.mRotation) % 360;
            this.mResizeFilter.a(i2, i3, i7, a2, ((float) ((i7 == 90 || i7 == 270) ? this.mOutputHeight : this.mOutputWidth)) / ((float) ((i7 == 90 || i7 == 270) ? this.mOutputWidth : this.mOutputHeight)), false, false);
            i4 = i;
            this.mResizeFilter.b(i);
        } else {
            i4 = i;
        }
        g gVar = this.mResizeFilter;
        final int l = gVar != null ? gVar.l() : i4;
        int[] iArr = new int[1];
        this.mPTS = j;
        if (this.mRawFrameFilter == null) {
            TXCLog.i(TAG, "pushVideoFrameInternal->create mRawFrameFilter");
            this.mRawFrameFilter = new o(1);
            this.mRawFrameFilter.a(true);
            if (!this.mRawFrameFilter.a()) {
                TXCLog.i(TAG, "pushVideoFrameInternal->destroy mRawFrameFilter, init failed!");
                this.mRawFrameFilter = null;
                return 10000004;
            }
            this.mRawFrameFilter.a(this.mOutputWidth, this.mOutputHeight);
            final boolean z2 = z;
            this.mRawFrameFilter.a((g.a) new g.a() {
                public void a(int i) {
                    if (z2) {
                        TXCSWVideoEncoder tXCSWVideoEncoder = TXCSWVideoEncoder.this;
                        int unused = tXCSWVideoEncoder.nativeEncodeSync(tXCSWVideoEncoder.mNativeEncoder, l, TXCSWVideoEncoder.this.mOutputWidth, TXCSWVideoEncoder.this.mOutputHeight, TXCSWVideoEncoder.this.mPTS);
                        return;
                    }
                    TXCSWVideoEncoder tXCSWVideoEncoder2 = TXCSWVideoEncoder.this;
                    int unused2 = tXCSWVideoEncoder2.nativeEncode(tXCSWVideoEncoder2.mNativeEncoder, l, TXCSWVideoEncoder.this.mOutputWidth, TXCSWVideoEncoder.this.mOutputHeight, TXCSWVideoEncoder.this.mPTS);
                }
            });
        }
        if (this.mRawFrameFilter == null) {
            return 10000004;
        }
        GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
        this.mRawFrameFilter.b(l);
        int i8 = iArr[0];
        if (i8 == 0) {
            return 0;
        }
        callDelegate(i8);
        return 0;
    }

    static {
        b.f();
        nativeClassInit();
    }
}
