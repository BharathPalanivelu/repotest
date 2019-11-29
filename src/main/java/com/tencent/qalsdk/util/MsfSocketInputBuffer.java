package com.tencent.qalsdk.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.Socket;
import org.apache.http.impl.io.HttpTransportMetricsImpl;
import org.apache.http.util.ByteArrayBuffer;
import qalsdk.j;

public class MsfSocketInputBuffer extends AbsSessionInputBuffer {
    private static final Class SOCKET_TIMEOUT_CLASS = SocketTimeoutExceptionClass();
    private int inputBufferSize = 0;
    public InputStream instream;
    private final Socket socket;

    public MsfSocketInputBuffer(Socket socket2, int i, String str, int i2) throws IOException {
        if (socket2 != null) {
            this.socket = socket2;
            i = i < 0 ? socket2.getReceiveBufferSize() : i;
            i = i < 1024 ? 1024 : i;
            InputStream inputStream = socket2.getInputStream();
            if (!j.f34148a.contains(inputStream.toString())) {
                j.f34148a.add(inputStream.toString());
            }
            init(inputStream, i, str, i2);
            return;
        }
        throw new IllegalArgumentException("Socket may not be null");
    }

    private static Class SocketTimeoutExceptionClass() {
        try {
            return Class.forName("java.net.SocketTimeoutException");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static boolean isSocketTimeoutException(InterruptedIOException interruptedIOException) {
        Class cls = SOCKET_TIMEOUT_CLASS;
        if (cls != null) {
            return cls.isInstance(interruptedIOException);
        }
        return true;
    }

    public boolean isDataAvailable(int i) throws IOException {
        boolean hasBufferedData = hasBufferedData();
        if (hasBufferedData) {
            return hasBufferedData;
        }
        try {
            if (fillBuffer() != -1) {
                return hasBufferedData();
            }
            throw new IOException("readData return -1");
        } catch (InterruptedIOException e2) {
            if (isSocketTimeoutException(e2)) {
                return hasBufferedData;
            }
            throw e2;
        }
    }

    public void reset() {
        if (this.buffer != null) {
            this.buffer = new byte[this.inputBufferSize];
        }
        this.bufferpos = 0;
        this.bufferlen = 0;
        if (this.linebuffer != null) {
            this.linebuffer.clear();
        }
    }

    /* access modifiers changed from: protected */
    public void init(InputStream inputStream, int i, String str, int i2) {
        if (inputStream == null) {
            throw new IllegalArgumentException("Input stream may not be null");
        } else if (i > 0) {
            this.instream = inputStream;
            this.inputBufferSize = i;
            this.buffer = new byte[this.inputBufferSize];
            boolean z = false;
            this.bufferpos = 0;
            this.bufferlen = 0;
            this.linebuffer = new ByteArrayBuffer(i);
            this.charset = str;
            if (this.charset.equalsIgnoreCase("US-ASCII") || this.charset.equalsIgnoreCase("ASCII")) {
                z = true;
            }
            this.ascii = z;
            this.maxLineLen = i2;
            this.metrics = new HttpTransportMetricsImpl();
        } else {
            throw new IllegalArgumentException("Buffer size may not be negative or zero");
        }
    }

    /* access modifiers changed from: protected */
    public int fillBuffer() throws IOException {
        if (this.bufferpos > 0) {
            int i = this.bufferlen - this.bufferpos;
            if (i > 0) {
                System.arraycopy(this.buffer, this.bufferpos, this.buffer, 0, i);
            }
            this.bufferpos = 0;
            this.bufferlen = i;
        }
        int i2 = this.bufferlen;
        int read = this.instream.read(this.buffer, i2, this.buffer.length - i2);
        if (read == -1) {
            return -1;
        }
        this.bufferlen = i2 + read;
        this.metrics.incrementBytesTransferred((long) read);
        return read;
    }
}
