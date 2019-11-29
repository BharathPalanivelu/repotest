package com.c.a.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class b implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f5599a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Charset f5600b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f5601c;

    /* renamed from: d  reason: collision with root package name */
    private int f5602d;

    /* renamed from: e  reason: collision with root package name */
    private int f5603e;

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(c.f5605a)) {
            this.f5599a = inputStream;
            this.f5600b = charset;
            this.f5601c = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() throws IOException {
        synchronized (this.f5599a) {
            if (this.f5601c != null) {
                this.f5601c = null;
                this.f5599a.close();
            }
        }
    }

    public String a() throws IOException {
        int i;
        int i2;
        synchronized (this.f5599a) {
            if (this.f5601c != null) {
                if (this.f5602d >= this.f5603e) {
                    c();
                }
                for (int i3 = this.f5602d; i3 != this.f5603e; i3++) {
                    if (this.f5601c[i3] == 10) {
                        if (i3 != this.f5602d) {
                            i2 = i3 - 1;
                            if (this.f5601c[i2] == 13) {
                                String str = new String(this.f5601c, this.f5602d, i2 - this.f5602d, this.f5600b.name());
                                this.f5602d = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.f5601c, this.f5602d, i2 - this.f5602d, this.f5600b.name());
                        this.f5602d = i3 + 1;
                        return str2;
                    }
                }
                AnonymousClass1 r1 = new ByteArrayOutputStream((this.f5603e - this.f5602d) + 80) {
                    public String toString() {
                        try {
                            return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + -1] != 13) ? this.count : this.count - 1, b.this.f5600b.name());
                        } catch (UnsupportedEncodingException e2) {
                            throw new AssertionError(e2);
                        }
                    }
                };
                loop1:
                while (true) {
                    r1.write(this.f5601c, this.f5602d, this.f5603e - this.f5602d);
                    this.f5603e = -1;
                    c();
                    i = this.f5602d;
                    while (true) {
                        if (i != this.f5603e) {
                            if (this.f5601c[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                }
                if (i != this.f5602d) {
                    r1.write(this.f5601c, this.f5602d, i - this.f5602d);
                }
                this.f5602d = i + 1;
                String byteArrayOutputStream = r1.toString();
                return byteArrayOutputStream;
            }
            throw new IOException("LineReader is closed");
        }
    }

    public boolean b() {
        return this.f5603e == -1;
    }

    private void c() throws IOException {
        InputStream inputStream = this.f5599a;
        byte[] bArr = this.f5601c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f5602d = 0;
            this.f5603e = read;
            return;
        }
        throw new EOFException();
    }
}
