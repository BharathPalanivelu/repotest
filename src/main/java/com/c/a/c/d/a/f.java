package com.c.a.c.d.a;

import android.util.Log;
import com.c.a.c.f;
import com.c.a.i.h;
import com.facebook.soloader.MinElf;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class f implements com.c.a.c.f {

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f6000a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f6001b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    private interface c {
        int a() throws IOException;

        int a(byte[] bArr, int i) throws IOException;

        long a(long j) throws IOException;

        short b() throws IOException;

        int c() throws IOException;
    }

    private static int a(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    private static boolean a(int i) {
        return (i & 65496) == 65496 || i == 19789 || i == 18761;
    }

    public f.a a(InputStream inputStream) throws IOException {
        return a((c) new d((InputStream) h.a(inputStream)));
    }

    public f.a a(ByteBuffer byteBuffer) throws IOException {
        return a((c) new a((ByteBuffer) h.a(byteBuffer)));
    }

    public int a(InputStream inputStream, com.c.a.c.b.a.b bVar) throws IOException {
        return a((c) new d((InputStream) h.a(inputStream)), (com.c.a.c.b.a.b) h.a(bVar));
    }

    private f.a a(c cVar) throws IOException {
        int a2 = cVar.a();
        if (a2 == 65496) {
            return f.a.JPEG;
        }
        int a3 = ((a2 << 16) & -65536) | (cVar.a() & MinElf.PN_XNUM);
        if (a3 == -1991225785) {
            cVar.a(21);
            return cVar.c() >= 3 ? f.a.PNG_A : f.a.PNG;
        } else if ((a3 >> 8) == 4671814) {
            return f.a.GIF;
        } else {
            if (a3 != 1380533830) {
                return f.a.UNKNOWN;
            }
            cVar.a(4);
            if ((((cVar.a() << 16) & -65536) | (cVar.a() & MinElf.PN_XNUM)) != 1464156752) {
                return f.a.UNKNOWN;
            }
            int a4 = ((cVar.a() << 16) & -65536) | (cVar.a() & MinElf.PN_XNUM);
            if ((a4 & -256) != 1448097792) {
                return f.a.UNKNOWN;
            }
            int i = a4 & 255;
            if (i == 88) {
                cVar.a(4);
                return (cVar.c() & 16) != 0 ? f.a.WEBP_A : f.a.WEBP;
            } else if (i != 76) {
                return f.a.WEBP;
            } else {
                cVar.a(4);
                return (cVar.c() & 8) != 0 ? f.a.WEBP_A : f.a.WEBP;
            }
        }
    }

    private int a(c cVar, com.c.a.c.b.a.b bVar) throws IOException {
        int a2 = cVar.a();
        if (!a(a2)) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + a2);
            }
            return -1;
        }
        int b2 = b(cVar);
        if (b2 == -1) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        byte[] bArr = (byte[]) bVar.a(b2, byte[].class);
        try {
            return a(cVar, bArr, b2);
        } finally {
            bVar.a(bArr, byte[].class);
        }
    }

    private int a(c cVar, byte[] bArr, int i) throws IOException {
        int a2 = cVar.a(bArr, i);
        if (a2 != i) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i + ", actually read: " + a2);
            }
            return -1;
        } else if (a(bArr, i)) {
            return a(new b(bArr, i));
        } else {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    private boolean a(byte[] bArr, int i) {
        boolean z = bArr != null && i > f6000a.length;
        if (!z) {
            return z;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = f6000a;
            if (i2 >= bArr2.length) {
                return z;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    private int b(c cVar) throws IOException {
        short b2;
        int a2;
        long j;
        long a3;
        do {
            short b3 = cVar.b();
            if (b3 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + b3);
                }
                return -1;
            }
            b2 = cVar.b();
            if (b2 == 218) {
                return -1;
            }
            if (b2 == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            a2 = cVar.a() - 2;
            if (b2 == 225) {
                return a2;
            }
            j = (long) a2;
            a3 = cVar.a(j);
        } while (a3 == j);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + b2 + ", wanted to skip: " + a2 + ", but actually skipped: " + a3);
        }
        return -1;
    }

    private static int a(b bVar) {
        ByteOrder byteOrder;
        short b2 = bVar.b(6);
        if (b2 == 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (b2 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + b2);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        bVar.a(byteOrder);
        int a2 = bVar.a(10) + 6;
        short b3 = bVar.b(a2);
        for (int i = 0; i < b3; i++) {
            int a3 = a(a2, i);
            short b4 = bVar.b(a3);
            if (b4 == 274) {
                short b5 = bVar.b(a3 + 2);
                if (b5 >= 1 && b5 <= 12) {
                    int a4 = bVar.a(a3 + 4);
                    if (a4 >= 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i + " tagType=" + b4 + " formatCode=" + b5 + " componentCount=" + a4);
                        }
                        int i2 = a4 + f6001b[b5];
                        if (i2 <= 4) {
                            int i3 = a3 + 8;
                            if (i3 < 0 || i3 > bVar.a()) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i3 + " tagType=" + b4);
                                }
                            } else if (i2 >= 0 && i2 + i3 <= bVar.a()) {
                                return bVar.b(i3);
                            } else {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + b4);
                                }
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + b5);
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Got invalid format code = " + b5);
                }
            }
        }
        return -1;
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f6003a;

        b(byte[] bArr, int i) {
            this.f6003a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        /* access modifiers changed from: package-private */
        public void a(ByteOrder byteOrder) {
            this.f6003a.order(byteOrder);
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f6003a.remaining();
        }

        /* access modifiers changed from: package-private */
        public int a(int i) {
            if (a(i, 4)) {
                return this.f6003a.getInt(i);
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public short b(int i) {
            if (a(i, 2)) {
                return this.f6003a.getShort(i);
            }
            return -1;
        }

        private boolean a(int i, int i2) {
            return this.f6003a.remaining() - i >= i2;
        }
    }

    private static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f6002a;

        a(ByteBuffer byteBuffer) {
            this.f6002a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public int a() throws IOException {
            return ((c() << 8) & 65280) | (c() & 255);
        }

        public short b() throws IOException {
            return (short) (c() & 255);
        }

        public long a(long j) throws IOException {
            int min = (int) Math.min((long) this.f6002a.remaining(), j);
            ByteBuffer byteBuffer = this.f6002a;
            byteBuffer.position(byteBuffer.position() + min);
            return (long) min;
        }

        public int a(byte[] bArr, int i) throws IOException {
            int min = Math.min(i, this.f6002a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f6002a.get(bArr, 0, min);
            return min;
        }

        public int c() throws IOException {
            if (this.f6002a.remaining() < 1) {
                return -1;
            }
            return this.f6002a.get();
        }
    }

    private static final class d implements c {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f6004a;

        d(InputStream inputStream) {
            this.f6004a = inputStream;
        }

        public int a() throws IOException {
            return ((this.f6004a.read() << 8) & 65280) | (this.f6004a.read() & 255);
        }

        public short b() throws IOException {
            return (short) (this.f6004a.read() & 255);
        }

        public long a(long j) throws IOException {
            if (j < 0) {
                return 0;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f6004a.skip(j2);
                if (skip <= 0) {
                    if (this.f6004a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }

        public int a(byte[] bArr, int i) throws IOException {
            int i2 = i;
            while (i2 > 0) {
                int read = this.f6004a.read(bArr, i - i2, i2);
                if (read == -1) {
                    break;
                }
                i2 -= read;
            }
            return i - i2;
        }

        public int c() throws IOException {
            return this.f6004a.read();
        }
    }
}
