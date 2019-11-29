package com.tencent.liteav.videodecoder;

import android.view.Surface;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.b;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class TXCVideoFfmpegDecoder implements a {
    private boolean mFirstDec;
    private c mListener;
    private long mNativeDecoder;
    private long mNativeNotify;
    private ByteBuffer mPps;
    private byte[] mRawData;
    private ByteBuffer mSps;
    private int mVideoHeight;
    private int mVideoWidth;

    private static native void nativeClassInit();

    private native boolean nativeDecode(byte[] bArr, long j, long j2, long j3);

    private native void nativeInit(WeakReference<TXCVideoFfmpegDecoder> weakReference, boolean z);

    private native void nativeLoadRawData(byte[] bArr, long j, int i);

    private native void nativeRelease();

    private static void postEventFromNative(WeakReference<TXCVideoFfmpegDecoder> weakReference, long j, int i, int i2, long j2, long j3, int i3) {
    }

    public int config(Surface surface) {
        return 0;
    }

    public boolean isHevc() {
        return false;
    }

    public void setNotifyListener(WeakReference<a> weakReference) {
    }

    public void setListener(c cVar) {
        this.mListener = cVar;
    }

    public void decode(TXSNALPacket tXSNALPacket) {
        TXSNALPacket tXSNALPacket2 = tXSNALPacket;
        if (this.mFirstDec) {
            ByteBuffer byteBuffer = this.mSps;
            if (!(byteBuffer == null || this.mPps == null)) {
                byte[] array = byteBuffer.array();
                byte[] array2 = this.mPps.array();
                byte[] bArr = new byte[(array.length + array2.length)];
                System.arraycopy(array, 0, bArr, 0, array.length);
                System.arraycopy(array2, 0, bArr, array.length, array2.length);
                nativeDecode(bArr, tXSNALPacket2.pts - 1, tXSNALPacket2.dts - 1, (long) tXSNALPacket2.rotation);
            }
            this.mFirstDec = false;
        }
        nativeDecode(tXSNALPacket2.nalData, tXSNALPacket2.pts, tXSNALPacket2.dts, (long) tXSNALPacket2.rotation);
    }

    public int start(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, boolean z2) {
        this.mSps = byteBuffer;
        this.mPps = byteBuffer2;
        this.mFirstDec = true;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        nativeInit(new WeakReference(this), z);
        return 0;
    }

    public void stop() {
        nativeRelease();
    }

    public void loadNativeData(byte[] bArr, long j, int i) {
        nativeLoadRawData(bArr, j, i);
    }

    static {
        b.f();
        nativeClassInit();
    }
}
