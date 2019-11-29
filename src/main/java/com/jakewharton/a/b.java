package com.jakewharton.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class b implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f14959a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Charset f14960b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f14961c;

    /* renamed from: d  reason: collision with root package name */
    private int f14962d;

    /* renamed from: e  reason: collision with root package name */
    private int f14963e;

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(c.f14965a)) {
            this.f14959a = inputStream;
            this.f14960b = charset;
            this.f14961c = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() throws IOException {
        synchronized (this.f14959a) {
            if (this.f14961c != null) {
                this.f14961c = null;
                this.f14959a.close();
            }
        }
    }

    public String a() throws IOException {
        int i;
        int i2;
        synchronized (this.f14959a) {
            if (this.f14961c != null) {
                if (this.f14962d >= this.f14963e) {
                    b();
                }
                for (int i3 = this.f14962d; i3 != this.f14963e; i3++) {
                    if (this.f14961c[i3] == 10) {
                        if (i3 != this.f14962d) {
                            i2 = i3 - 1;
                            if (this.f14961c[i2] == 13) {
                                String str = new String(this.f14961c, this.f14962d, i2 - this.f14962d, this.f14960b.name());
                                this.f14962d = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.f14961c, this.f14962d, i2 - this.f14962d, this.f14960b.name());
                        this.f14962d = i3 + 1;
                        return str2;
                    }
                }
                AnonymousClass1 r1 = new ByteArrayOutputStream((this.f14963e - this.f14962d) + 80) {
                    public String toString() {
                        try {
                            return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + -1] != 13) ? this.count : this.count - 1, b.this.f14960b.name());
                        } catch (UnsupportedEncodingException e2) {
                            throw new AssertionError(e2);
                        }
                    }
                };
                loop1:
                while (true) {
                    r1.write(this.f14961c, this.f14962d, this.f14963e - this.f14962d);
                    this.f14963e = -1;
                    b();
                    i = this.f14962d;
                    while (true) {
                        if (i != this.f14963e) {
                            if (this.f14961c[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                }
                if (i != this.f14962d) {
                    r1.write(this.f14961c, this.f14962d, i - this.f14962d);
                }
                this.f14962d = i + 1;
                String byteArrayOutputStream = r1.toString();
                return byteArrayOutputStream;
            }
            throw new IOException("LineReader is closed");
        }
    }

    private void b() throws IOException {
        InputStream inputStream = this.f14959a;
        byte[] bArr = this.f14961c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f14962d = 0;
            this.f14963e = read;
            return;
        }
        throw new EOFException();
    }
}
