package com.c.a.c.d.a;

import com.c.a.c.b.a.b;
import com.facebook.internal.NativeProtocol;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class m extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private volatile byte[] f6029a;

    /* renamed from: b  reason: collision with root package name */
    private int f6030b;

    /* renamed from: c  reason: collision with root package name */
    private int f6031c;

    /* renamed from: d  reason: collision with root package name */
    private int f6032d;

    /* renamed from: e  reason: collision with root package name */
    private int f6033e;

    /* renamed from: f  reason: collision with root package name */
    private final b f6034f;

    public boolean markSupported() {
        return true;
    }

    public m(InputStream inputStream, b bVar) {
        this(inputStream, bVar, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
    }

    m(InputStream inputStream, b bVar, int i) {
        super(inputStream);
        this.f6032d = -1;
        this.f6034f = bVar;
        this.f6029a = (byte[]) bVar.a(i, byte[].class);
    }

    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = this.in;
        if (this.f6029a == null || inputStream == null) {
            throw c();
        }
        return (this.f6030b - this.f6033e) + inputStream.available();
    }

    private static IOException c() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized void a() {
        this.f6031c = this.f6029a.length;
    }

    public synchronized void b() {
        if (this.f6029a != null) {
            this.f6034f.a(this.f6029a, byte[].class);
            this.f6029a = null;
        }
    }

    public void close() throws IOException {
        if (this.f6029a != null) {
            this.f6034f.a(this.f6029a, byte[].class);
            this.f6029a = null;
        }
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i;
        int i2 = this.f6032d;
        if (i2 != -1) {
            int i3 = this.f6033e - i2;
            int i4 = this.f6031c;
            if (i3 < i4) {
                if (i2 == 0 && i4 > bArr.length && this.f6030b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length > i4) {
                        length = i4;
                    }
                    byte[] bArr2 = (byte[]) this.f6034f.a(length, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f6029a = bArr2;
                    this.f6034f.a(bArr, byte[].class);
                    bArr = bArr2;
                } else {
                    int i5 = this.f6032d;
                    if (i5 > 0) {
                        System.arraycopy(bArr, i5, bArr, 0, bArr.length - i5);
                    }
                }
                this.f6033e -= this.f6032d;
                this.f6032d = 0;
                this.f6030b = 0;
                int i6 = this.f6033e;
                int read = inputStream.read(bArr, i6, bArr.length - i6);
                if (read <= 0) {
                    i = this.f6033e;
                } else {
                    i = this.f6033e + read;
                }
                this.f6030b = i;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f6032d = -1;
            this.f6033e = 0;
            this.f6030b = read2;
        }
        return read2;
    }

    public synchronized void mark(int i) {
        this.f6031c = Math.max(this.f6031c, i);
        this.f6032d = this.f6033e;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:11:0x0018=Splitter:B:11:0x0018, B:27:0x003b=Splitter:B:27:0x003b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read() throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            byte[] r0 = r5.f6029a     // Catch:{ all -> 0x0040 }
            java.io.InputStream r1 = r5.in     // Catch:{ all -> 0x0040 }
            if (r0 == 0) goto L_0x003b
            if (r1 == 0) goto L_0x003b
            int r2 = r5.f6033e     // Catch:{ all -> 0x0040 }
            int r3 = r5.f6030b     // Catch:{ all -> 0x0040 }
            r4 = -1
            if (r2 < r3) goto L_0x0018
            int r1 = r5.a(r1, r0)     // Catch:{ all -> 0x0040 }
            if (r1 != r4) goto L_0x0018
            monitor-exit(r5)
            return r4
        L_0x0018:
            byte[] r1 = r5.f6029a     // Catch:{ all -> 0x0040 }
            if (r0 == r1) goto L_0x0026
            byte[] r0 = r5.f6029a     // Catch:{ all -> 0x0040 }
            if (r0 == 0) goto L_0x0021
            goto L_0x0026
        L_0x0021:
            java.io.IOException r0 = c()     // Catch:{ all -> 0x0040 }
            throw r0     // Catch:{ all -> 0x0040 }
        L_0x0026:
            int r1 = r5.f6030b     // Catch:{ all -> 0x0040 }
            int r2 = r5.f6033e     // Catch:{ all -> 0x0040 }
            int r1 = r1 - r2
            if (r1 <= 0) goto L_0x0039
            int r1 = r5.f6033e     // Catch:{ all -> 0x0040 }
            int r2 = r1 + 1
            r5.f6033e = r2     // Catch:{ all -> 0x0040 }
            byte r0 = r0[r1]     // Catch:{ all -> 0x0040 }
            r0 = r0 & 255(0xff, float:3.57E-43)
            monitor-exit(r5)
            return r0
        L_0x0039:
            monitor-exit(r5)
            return r4
        L_0x003b:
            java.io.IOException r0 = c()     // Catch:{ all -> 0x0040 }
            throw r0     // Catch:{ all -> 0x0040 }
        L_0x0040:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.c.d.a.m.read():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0050, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x005d, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(byte[] r6, int r7, int r8) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            byte[] r0 = r5.f6029a     // Catch:{ all -> 0x009e }
            if (r0 == 0) goto L_0x0099
            if (r8 != 0) goto L_0x000a
            r6 = 0
            monitor-exit(r5)
            return r6
        L_0x000a:
            java.io.InputStream r1 = r5.in     // Catch:{ all -> 0x009e }
            if (r1 == 0) goto L_0x0094
            int r2 = r5.f6033e     // Catch:{ all -> 0x009e }
            int r3 = r5.f6030b     // Catch:{ all -> 0x009e }
            if (r2 >= r3) goto L_0x003b
            int r2 = r5.f6030b     // Catch:{ all -> 0x009e }
            int r3 = r5.f6033e     // Catch:{ all -> 0x009e }
            int r2 = r2 - r3
            if (r2 < r8) goto L_0x001d
            r2 = r8
            goto L_0x0022
        L_0x001d:
            int r2 = r5.f6030b     // Catch:{ all -> 0x009e }
            int r3 = r5.f6033e     // Catch:{ all -> 0x009e }
            int r2 = r2 - r3
        L_0x0022:
            int r3 = r5.f6033e     // Catch:{ all -> 0x009e }
            java.lang.System.arraycopy(r0, r3, r6, r7, r2)     // Catch:{ all -> 0x009e }
            int r3 = r5.f6033e     // Catch:{ all -> 0x009e }
            int r3 = r3 + r2
            r5.f6033e = r3     // Catch:{ all -> 0x009e }
            if (r2 == r8) goto L_0x0039
            int r3 = r1.available()     // Catch:{ all -> 0x009e }
            if (r3 != 0) goto L_0x0035
            goto L_0x0039
        L_0x0035:
            int r7 = r7 + r2
            int r2 = r8 - r2
            goto L_0x003c
        L_0x0039:
            monitor-exit(r5)
            return r2
        L_0x003b:
            r2 = r8
        L_0x003c:
            int r3 = r5.f6032d     // Catch:{ all -> 0x009e }
            r4 = -1
            if (r3 != r4) goto L_0x0051
            int r3 = r0.length     // Catch:{ all -> 0x009e }
            if (r2 < r3) goto L_0x0051
            int r3 = r1.read(r6, r7, r2)     // Catch:{ all -> 0x009e }
            if (r3 != r4) goto L_0x0084
            if (r2 != r8) goto L_0x004d
            goto L_0x004f
        L_0x004d:
            int r4 = r8 - r2
        L_0x004f:
            monitor-exit(r5)
            return r4
        L_0x0051:
            int r3 = r5.a(r1, r0)     // Catch:{ all -> 0x009e }
            if (r3 != r4) goto L_0x005e
            if (r2 != r8) goto L_0x005a
            goto L_0x005c
        L_0x005a:
            int r4 = r8 - r2
        L_0x005c:
            monitor-exit(r5)
            return r4
        L_0x005e:
            byte[] r3 = r5.f6029a     // Catch:{ all -> 0x009e }
            if (r0 == r3) goto L_0x006c
            byte[] r0 = r5.f6029a     // Catch:{ all -> 0x009e }
            if (r0 == 0) goto L_0x0067
            goto L_0x006c
        L_0x0067:
            java.io.IOException r6 = c()     // Catch:{ all -> 0x009e }
            throw r6     // Catch:{ all -> 0x009e }
        L_0x006c:
            int r3 = r5.f6030b     // Catch:{ all -> 0x009e }
            int r4 = r5.f6033e     // Catch:{ all -> 0x009e }
            int r3 = r3 - r4
            if (r3 < r2) goto L_0x0075
            r3 = r2
            goto L_0x007a
        L_0x0075:
            int r3 = r5.f6030b     // Catch:{ all -> 0x009e }
            int r4 = r5.f6033e     // Catch:{ all -> 0x009e }
            int r3 = r3 - r4
        L_0x007a:
            int r4 = r5.f6033e     // Catch:{ all -> 0x009e }
            java.lang.System.arraycopy(r0, r4, r6, r7, r3)     // Catch:{ all -> 0x009e }
            int r4 = r5.f6033e     // Catch:{ all -> 0x009e }
            int r4 = r4 + r3
            r5.f6033e = r4     // Catch:{ all -> 0x009e }
        L_0x0084:
            int r2 = r2 - r3
            if (r2 != 0) goto L_0x0089
            monitor-exit(r5)
            return r8
        L_0x0089:
            int r4 = r1.available()     // Catch:{ all -> 0x009e }
            if (r4 != 0) goto L_0x0092
            int r8 = r8 - r2
            monitor-exit(r5)
            return r8
        L_0x0092:
            int r7 = r7 + r3
            goto L_0x003c
        L_0x0094:
            java.io.IOException r6 = c()     // Catch:{ all -> 0x009e }
            throw r6     // Catch:{ all -> 0x009e }
        L_0x0099:
            java.io.IOException r6 = c()     // Catch:{ all -> 0x009e }
            throw r6     // Catch:{ all -> 0x009e }
        L_0x009e:
            r6 = move-exception
            monitor-exit(r5)
            goto L_0x00a2
        L_0x00a1:
            throw r6
        L_0x00a2:
            goto L_0x00a1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.c.d.a.m.read(byte[], int, int):int");
    }

    public synchronized void reset() throws IOException {
        if (this.f6029a == null) {
            throw new IOException("Stream is closed");
        } else if (-1 != this.f6032d) {
            this.f6033e = this.f6032d;
        } else {
            throw new a("Mark has been invalidated, pos: " + this.f6033e + " markLimit: " + this.f6031c);
        }
    }

    public synchronized long skip(long j) throws IOException {
        byte[] bArr = this.f6029a;
        InputStream inputStream = this.in;
        if (bArr == null) {
            throw c();
        } else if (j < 1) {
            return 0;
        } else {
            if (inputStream == null) {
                throw c();
            } else if (((long) (this.f6030b - this.f6033e)) >= j) {
                this.f6033e = (int) (((long) this.f6033e) + j);
                return j;
            } else {
                long j2 = (long) (this.f6030b - this.f6033e);
                this.f6033e = this.f6030b;
                if (this.f6032d == -1 || j > ((long) this.f6031c)) {
                    return j2 + inputStream.skip(j - j2);
                } else if (a(inputStream, bArr) == -1) {
                    return j2;
                } else {
                    long j3 = j - j2;
                    if (((long) (this.f6030b - this.f6033e)) >= j3) {
                        this.f6033e = (int) (((long) this.f6033e) + j3);
                        return j;
                    }
                    long j4 = (j2 + ((long) this.f6030b)) - ((long) this.f6033e);
                    this.f6033e = this.f6030b;
                    return j4;
                }
            }
        }
    }

    public static class a extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        public a(String str) {
            super(str);
        }
    }
}
