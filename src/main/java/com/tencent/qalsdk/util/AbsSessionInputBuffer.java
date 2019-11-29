package com.tencent.qalsdk.util;

import java.io.IOException;
import org.apache.http.impl.io.HttpTransportMetricsImpl;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;

public abstract class AbsSessionInputBuffer implements SessionInputBuffer {
    protected boolean ascii = true;
    protected byte[] buffer;
    protected int bufferlen;
    protected int bufferpos;
    protected String charset = "US-ASCII";
    protected ByteArrayBuffer linebuffer = null;
    protected int maxLineLen = -1;
    protected HttpTransportMetricsImpl metrics;

    /* access modifiers changed from: protected */
    public abstract int fillBuffer() throws IOException;

    public boolean hasBufferedData() {
        return this.bufferpos < this.bufferlen;
    }

    public int read() throws IOException {
        while (!hasBufferedData()) {
            if (fillBuffer() == -1) {
                return -1;
            }
        }
        byte[] bArr = this.buffer;
        int i = this.bufferpos;
        this.bufferpos = i + 1;
        return bArr[i] & 255;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (bArr == null) {
            return 0;
        }
        while (!hasBufferedData()) {
            if (fillBuffer() == -1) {
                return -1;
            }
        }
        int i3 = this.bufferlen - this.bufferpos;
        if (i3 <= i2) {
            i2 = i3;
        }
        System.arraycopy(this.buffer, this.bufferpos, bArr, i, i2);
        this.bufferpos += i2;
        return i2;
    }

    public int read(byte[] bArr) throws IOException {
        if (bArr == null) {
            return 0;
        }
        return read(bArr, 0, bArr.length);
    }

    private int locateLF() {
        for (int i = this.bufferpos; i < this.bufferlen; i++) {
            if (this.buffer[i] == 10) {
                return i;
            }
        }
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004b, code lost:
        if (r2 == -1) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int readLine(org.apache.http.util.CharArrayBuffer r8) throws java.io.IOException {
        /*
            r7 = this;
            if (r8 == 0) goto L_0x0075
            org.apache.http.util.ByteArrayBuffer r0 = r7.linebuffer
            r0.clear()
            r0 = 1
            r1 = 0
            r2 = 0
        L_0x000a:
            r3 = -1
            if (r0 == 0) goto L_0x0065
            int r4 = r7.locateLF()
            if (r4 == r3) goto L_0x0031
            org.apache.http.util.ByteArrayBuffer r0 = r7.linebuffer
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0020
            int r8 = r7.lineFromReadBuffer(r8, r4)
            return r8
        L_0x0020:
            int r4 = r4 + 1
            int r0 = r7.bufferpos
            int r3 = r4 - r0
            org.apache.http.util.ByteArrayBuffer r5 = r7.linebuffer
            byte[] r6 = r7.buffer
            r5.append(r6, r0, r3)
            r7.bufferpos = r4
        L_0x002f:
            r0 = 0
            goto L_0x004e
        L_0x0031:
            boolean r2 = r7.hasBufferedData()
            if (r2 == 0) goto L_0x0047
            int r2 = r7.bufferlen
            int r4 = r7.bufferpos
            int r2 = r2 - r4
            org.apache.http.util.ByteArrayBuffer r5 = r7.linebuffer
            byte[] r6 = r7.buffer
            r5.append(r6, r4, r2)
            int r2 = r7.bufferlen
            r7.bufferpos = r2
        L_0x0047:
            int r2 = r7.fillBuffer()
            if (r2 != r3) goto L_0x004e
            goto L_0x002f
        L_0x004e:
            int r3 = r7.maxLineLen
            if (r3 <= 0) goto L_0x000a
            org.apache.http.util.ByteArrayBuffer r3 = r7.linebuffer
            int r3 = r3.length()
            int r4 = r7.maxLineLen
            if (r3 >= r4) goto L_0x005d
            goto L_0x000a
        L_0x005d:
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r0 = "Maximum line length limit exceeded"
            r8.<init>(r0)
            throw r8
        L_0x0065:
            if (r2 != r3) goto L_0x0070
            org.apache.http.util.ByteArrayBuffer r0 = r7.linebuffer
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0070
            return r3
        L_0x0070:
            int r8 = r7.lineFromLineBuffer(r8)
            return r8
        L_0x0075:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Char array buffer may not be null"
            r8.<init>(r0)
            goto L_0x007e
        L_0x007d:
            throw r8
        L_0x007e:
            goto L_0x007d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qalsdk.util.AbsSessionInputBuffer.readLine(org.apache.http.util.CharArrayBuffer):int");
    }

    private int lineFromLineBuffer(CharArrayBuffer charArrayBuffer) throws IOException {
        int length = this.linebuffer.length();
        if (length > 0) {
            if (this.linebuffer.byteAt(length - 1) == 10) {
                length--;
                this.linebuffer.setLength(length);
            }
            if (length > 0 && this.linebuffer.byteAt(length - 1) == 13) {
                this.linebuffer.setLength(length - 1);
            }
        }
        int length2 = this.linebuffer.length();
        if (this.ascii) {
            charArrayBuffer.append(this.linebuffer, 0, length2);
        } else {
            charArrayBuffer.append(new String(this.linebuffer.buffer(), 0, length2, this.charset));
        }
        return length2;
    }

    private int lineFromReadBuffer(CharArrayBuffer charArrayBuffer, int i) throws IOException {
        int i2 = this.bufferpos;
        this.bufferpos = i + 1;
        if (i > i2 && this.buffer[i - 1] == 13) {
            i--;
        }
        int i3 = i - i2;
        if (this.ascii) {
            charArrayBuffer.append(this.buffer, i2, i3);
        } else {
            charArrayBuffer.append(new String(this.buffer, i2, i3, this.charset));
        }
        return i3;
    }

    public String readLine() throws IOException {
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(64);
        if (readLine(charArrayBuffer) != -1) {
            return charArrayBuffer.toString();
        }
        return null;
    }

    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }

    public byte[] getBuffer() {
        return this.buffer;
    }

    public int getBufferpos() {
        return this.bufferpos;
    }

    public int getBufferlen() {
        return this.bufferlen;
    }
}
