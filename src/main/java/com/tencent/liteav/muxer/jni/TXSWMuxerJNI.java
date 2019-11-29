package com.tencent.liteav.muxer.jni;

import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.basic.log.TXCLog;
import java.nio.ByteBuffer;

public class TXSWMuxerJNI {

    /* renamed from: a  reason: collision with root package name */
    private long f31685a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f31686b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f31687c;

    public static class AVOptions {
        public int audioChannels = 0;
        public int audioSampleRate = 0;
        public int videoGOP = 12;
        public int videoHeight = 540;
        public int videoWidth = TXEAudioDef.TXE_OPUS_SAMPLE_NUM;
    }

    private native long init();

    private native void release(long j);

    private native void setAVParams(long j, AVOptions aVOptions);

    private native void setAudioCSD(long j, byte[] bArr);

    private native void setDstPath(long j, String str);

    private native void setVideoCSD(long j, byte[] bArr, byte[] bArr2);

    private native int start(long j);

    private native int stop(long j);

    private native int writeFrame(long j, byte[] bArr, int i, int i2, int i3, int i4, long j2);

    public TXSWMuxerJNI() {
        this.f31685a = -1;
        this.f31685a = init();
        this.f31686b = true;
    }

    public void a(AVOptions aVOptions) {
        if (this.f31686b) {
            setAVParams(this.f31685a, aVOptions);
        } else {
            TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
        }
    }

    public void a(String str) {
        if (this.f31686b) {
            setDstPath(this.f31685a, str);
        } else {
            TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
        }
    }

    public void a(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2) {
        if (this.f31686b) {
            setVideoCSD(this.f31685a, b(byteBuffer, i), b(byteBuffer2, i2));
        } else {
            TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
        }
    }

    public void a(ByteBuffer byteBuffer, int i) {
        if (this.f31686b) {
            setAudioCSD(this.f31685a, b(byteBuffer, i));
        } else {
            TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
        }
    }

    public int a(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, long j) {
        if (!this.f31686b) {
            TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
            return -1;
        } else if (this.f31687c) {
            ByteBuffer byteBuffer2 = byteBuffer;
            int i5 = i3;
            int writeFrame = writeFrame(this.f31685a, b(byteBuffer, i5), i, i2, i5, i4, j);
            if (writeFrame != 0) {
                TXCLog.e("TXSWMuxerJNI", "Muxer write frame error!");
            }
            return writeFrame;
        } else {
            TXCLog.e("TXSWMuxerJNI", "Muxer isn't start yet!");
            return -1;
        }
    }

    public int a() {
        if (this.f31686b) {
            int start = start(this.f31685a);
            if (start == 0) {
                this.f31687c = true;
            } else {
                TXCLog.e("TXSWMuxerJNI", "Start Muxer Error!!!");
            }
            return start;
        }
        TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
        return -1;
    }

    public int b() {
        if (!this.f31686b) {
            TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
            return -1;
        } else if (this.f31687c) {
            this.f31687c = false;
            int stop = stop(this.f31685a);
            if (stop != 0) {
                TXCLog.e("TXSWMuxerJNI", "Stop Muxer Error!!!");
            }
            return stop;
        } else {
            TXCLog.e("TXSWMuxerJNI", "Muxer isn't start yet!");
            return -1;
        }
    }

    public void c() {
        if (this.f31686b) {
            release(this.f31685a);
            this.f31686b = false;
            this.f31687c = false;
            return;
        }
        TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
    }

    private byte[] b(ByteBuffer byteBuffer, int i) {
        if (byteBuffer == null) {
            return null;
        }
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return bArr;
    }
}
