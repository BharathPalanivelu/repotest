package com.tencent.liteav.videoencoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.module.a;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import java.nio.ByteBuffer;

public class c extends a {
    protected g mEncodeFilter;
    private boolean mEncodeFirstGOP = false;
    protected Object mGLContextExternal = null;
    protected boolean mInit;
    protected g mInputFilter;
    protected int mInputHeight = 0;
    protected int mInputTextureID = -1;
    protected int mInputWidth = 0;
    protected d mListener = null;
    protected int mOutputHeight = 0;
    protected int mOutputWidth = 0;
    protected int mRotation = 0;
    private int mStreamType = 2;
    private long mVideoGOPEncode = 0;

    public void enableNearestRPS(int i) {
    }

    public long getRealBitrate() {
        return 0;
    }

    public double getRealFPS() {
        return 0.0d;
    }

    public long pushVideoFrame(int i, int i2, int i3, long j) {
        return 10000002;
    }

    public long pushVideoFrameSync(int i, int i2, int i3, long j) {
        return 10000002;
    }

    public void restartIDR() {
    }

    public void setBitrate(int i) {
    }

    public void setBitrateFromQos(int i, int i2) {
    }

    public void setEncodeIdrFpsFromQos(int i) {
    }

    public void setFPS(int i) {
    }

    public void setRPSRefBitmap(int i, int i2, long j) {
    }

    public void signalEOSAndFlush() {
    }

    public void stop() {
    }

    public int start(TXSVideoEncoderParam tXSVideoEncoderParam) {
        if (tXSVideoEncoderParam != null) {
            this.mOutputWidth = tXSVideoEncoderParam.width;
            this.mOutputHeight = tXSVideoEncoderParam.height;
            this.mInputWidth = tXSVideoEncoderParam.width;
            this.mInputHeight = tXSVideoEncoderParam.height;
            this.mGLContextExternal = tXSVideoEncoderParam.glContext;
            this.mStreamType = tXSVideoEncoderParam.streamType;
        }
        this.mVideoGOPEncode = 0;
        this.mEncodeFirstGOP = false;
        return 10000002;
    }

    public void setListener(d dVar) {
        this.mListener = dVar;
    }

    public void setRotation(int i) {
        this.mRotation = i;
    }

    public int getVideoWidth() {
        return this.mOutputWidth;
    }

    public int getVideoHeight() {
        return this.mOutputHeight;
    }

    /* access modifiers changed from: protected */
    public void callDelegate(int i) {
        callDelegate((byte[]) null, 0, 0, 0, 0, 0, 0, 0, i, (ByteBuffer) null, (MediaCodec.BufferInfo) null);
    }

    /* access modifiers changed from: protected */
    public void callDelegate(byte[] bArr, int i, long j, long j2, long j3, long j4, long j5, long j6, int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        int i3 = i;
        MediaCodec.BufferInfo bufferInfo2 = bufferInfo;
        MediaCodec.BufferInfo bufferInfo3 = null;
        ByteBuffer asReadOnlyBuffer = byteBuffer == null ? null : byteBuffer.asReadOnlyBuffer();
        if (bufferInfo2 != null) {
            bufferInfo3 = new MediaCodec.BufferInfo();
        }
        if (bufferInfo3 != null) {
            bufferInfo3.set(bufferInfo2.offset, bufferInfo2.size, bufferInfo2.presentationTimeUs, bufferInfo2.flags);
        }
        d dVar = this.mListener;
        if (dVar != null) {
            TXSNALPacket tXSNALPacket = new TXSNALPacket();
            tXSNALPacket.nalData = bArr;
            tXSNALPacket.nalType = i3;
            tXSNALPacket.gopIndex = j;
            tXSNALPacket.gopFrameIndex = j2;
            tXSNALPacket.frameIndex = j3;
            tXSNALPacket.refFremeIndex = j4;
            tXSNALPacket.pts = j5;
            tXSNALPacket.dts = j6;
            tXSNALPacket.buffer = asReadOnlyBuffer;
            tXSNALPacket.streamType = this.mStreamType;
            if (bufferInfo3 != null) {
                tXSNALPacket.info = bufferInfo3;
            }
            dVar.a(tXSNALPacket, i2);
            setStatusValue(4002, Long.valueOf(getRealBitrate()));
            setStatusValue(4001, this.mStreamType, Double.valueOf(getRealFPS()));
            if (i3 == 0) {
                long j7 = this.mVideoGOPEncode;
                if (j7 != 0) {
                    this.mEncodeFirstGOP = true;
                    setStatusValue(4006, Long.valueOf(j7));
                }
                this.mVideoGOPEncode = 1;
                return;
            }
            this.mVideoGOPEncode++;
            if (!this.mEncodeFirstGOP) {
                setStatusValue(4006, Long.valueOf(this.mVideoGOPEncode));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void callDelegate(MediaFormat mediaFormat) {
        d dVar = this.mListener;
        if (dVar != null) {
            dVar.a(mediaFormat);
        }
    }

    /* access modifiers changed from: protected */
    public void onEncodeFinished(long j, long j2, long j3) {
        d dVar = this.mListener;
        if (dVar != null) {
            dVar.a(j, j2, j3);
        }
    }
}
