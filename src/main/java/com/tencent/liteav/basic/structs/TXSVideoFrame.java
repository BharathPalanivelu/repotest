package com.tencent.liteav.basic.structs;

import java.nio.ByteBuffer;

public class TXSVideoFrame {
    public ByteBuffer buffer;
    public byte[] data;
    public Object eglContext;
    public int frameType;
    public int height;
    public long pts;
    public int rotation;
    public int textureId;
    public int width;

    private native void loadGLArray(byte[] bArr, int i, int i2);

    private native void loadGLData(int i, int i2);

    private native void loadNativeData(byte[] bArr, int i);

    public native void nativeClone(ByteBuffer byteBuffer);

    public native void release();

    public void finalize() throws Throwable {
        release();
        super.finalize();
    }

    public void loadI420Array(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            int i = this.width;
            int i2 = this.height;
            if (length >= ((i * i2) * 3) / 2) {
                loadNativeData(bArr, ((i * i2) * 3) / 2);
            }
        }
    }

    public TXSVideoFrame clone() {
        TXSVideoFrame tXSVideoFrame = new TXSVideoFrame();
        tXSVideoFrame.width = this.width;
        tXSVideoFrame.height = this.height;
        tXSVideoFrame.frameType = this.frameType;
        tXSVideoFrame.rotation = this.rotation;
        tXSVideoFrame.pts = this.pts;
        tXSVideoFrame.data = this.data;
        tXSVideoFrame.textureId = this.textureId;
        tXSVideoFrame.eglContext = this.eglContext;
        tXSVideoFrame.nativeClone(this.buffer);
        return tXSVideoFrame;
    }

    public void loadI420BufferFromGL(byte[] bArr) {
        loadGLArray(bArr, this.width, this.height);
    }

    public void loadI420BufferFromGL() {
        loadGLData(this.width, this.height);
    }
}
