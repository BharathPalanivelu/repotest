package com.google.c;

import com.tencent.ijk.media.player.IjkMediaMeta;
import com.tencent.liteav.audio.TXEAudioDef;

final class ax {

    /* renamed from: a  reason: collision with root package name */
    private static final a f13699a = (d.a() ? new d() : new b());

    /* access modifiers changed from: private */
    public static int b(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    /* access modifiers changed from: private */
    public static int b(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    /* access modifiers changed from: private */
    public static int b(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    public static boolean a(byte[] bArr) {
        return f13699a.a(bArr, 0, bArr.length);
    }

    public static boolean a(byte[] bArr, int i, int i2) {
        return f13699a.a(bArr, i, i2);
    }

    /* access modifiers changed from: private */
    public static int c(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 == 0) {
            return b(b2);
        }
        if (i3 == 1) {
            return b(b2, bArr[i]);
        }
        if (i3 == 2) {
            return b((int) b2, (int) bArr[i], (int) bArr[i + 1]);
        }
        throw new AssertionError();
    }

    static class c extends IllegalArgumentException {
        c(int i, int i2) {
            super("Unpaired surrogate at index " + i + " of " + i2);
        }
    }

    static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int i2 = length;
        while (true) {
            if (i >= length) {
                break;
            }
            char charAt = charSequence.charAt(i);
            if (charAt >= 2048) {
                i2 += a(charSequence, i);
                break;
            }
            i2 += (127 - charAt) >>> 31;
            i++;
        }
        if (i2 >= length) {
            return i2;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i2) + IjkMediaMeta.AV_CH_WIDE_RIGHT));
    }

    private static int a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 2048) {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) >= 65536) {
                        i++;
                    } else {
                        throw new c(i, length);
                    }
                }
            }
            i++;
        }
        return i2;
    }

    static int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return f13699a.a(charSequence, bArr, i, i2);
    }

    static abstract class a {
        /* access modifiers changed from: package-private */
        public abstract int a(int i, byte[] bArr, int i2, int i3);

        /* access modifiers changed from: package-private */
        public abstract int a(CharSequence charSequence, byte[] bArr, int i, int i2);

        a() {
        }

        /* access modifiers changed from: package-private */
        public final boolean a(byte[] bArr, int i, int i2) {
            return a(0, bArr, i, i2) == 0;
        }
    }

    static final class b extends a {
        b() {
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0042, code lost:
            if (r8[r9] > -65) goto L_0x0044;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x007a, code lost:
            if (r8[r7] > -65) goto L_0x007c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
            if (r8[r9] > -65) goto L_0x0017;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int a(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L_0x007d
                if (r9 < r10) goto L_0x0005
                return r7
            L_0x0005:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L_0x0018
                r7 = -62
                if (r0 < r7) goto L_0x0017
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r9 <= r3) goto L_0x007e
            L_0x0017:
                return r2
            L_0x0018:
                r4 = -16
                if (r0 >= r4) goto L_0x0045
                int r7 = r7 >> 8
                r7 = r7 ^ r2
                byte r7 = (byte) r7
                if (r7 != 0) goto L_0x0030
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r7 < r10) goto L_0x002d
                int r7 = com.google.c.ax.b(r0, r9)
                return r7
            L_0x002d:
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x0030:
                if (r7 > r3) goto L_0x0044
                r4 = -96
                if (r0 != r1) goto L_0x0038
                if (r7 < r4) goto L_0x0044
            L_0x0038:
                r1 = -19
                if (r0 != r1) goto L_0x003e
                if (r7 >= r4) goto L_0x0044
            L_0x003e:
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r9 <= r3) goto L_0x007e
            L_0x0044:
                return r2
            L_0x0045:
                int r1 = r7 >> 8
                r1 = r1 ^ r2
                byte r1 = (byte) r1
                r4 = 0
                if (r1 != 0) goto L_0x0057
                int r7 = r9 + 1
                byte r1 = r8[r9]
                if (r7 < r10) goto L_0x005b
                int r7 = com.google.c.ax.b(r0, r1)
                return r7
            L_0x0057:
                int r7 = r7 >> 16
                byte r4 = (byte) r7
                r7 = r9
            L_0x005b:
                if (r4 != 0) goto L_0x0069
                int r9 = r7 + 1
                byte r4 = r8[r7]
                if (r9 < r10) goto L_0x0068
                int r7 = com.google.c.ax.b((int) r0, (int) r1, (int) r4)
                return r7
            L_0x0068:
                r7 = r9
            L_0x0069:
                if (r1 > r3) goto L_0x007c
                int r9 = r0 << 28
                int r1 = r1 + 112
                int r9 = r9 + r1
                int r9 = r9 >> 30
                if (r9 != 0) goto L_0x007c
                if (r4 > r3) goto L_0x007c
                int r9 = r7 + 1
                byte r7 = r8[r7]
                if (r7 <= r3) goto L_0x007d
            L_0x007c:
                return r2
            L_0x007d:
                r7 = r9
            L_0x007e:
                int r7 = b(r8, r7, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.ax.b.a(int, byte[], int, int):int");
        }

        /* access modifiers changed from: package-private */
        public int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
            int i3;
            int length = charSequence.length();
            int i4 = i2 + i;
            int i5 = 0;
            while (i5 < length) {
                int i6 = i5 + i;
                if (i6 >= i4) {
                    break;
                }
                char charAt = charSequence.charAt(i5);
                if (charAt >= 128) {
                    break;
                }
                bArr[i6] = (byte) charAt;
                i5++;
            }
            if (i5 == length) {
                return i + length;
            }
            int i7 = i + i5;
            while (i5 < length) {
                char charAt2 = charSequence.charAt(i5);
                if (charAt2 < 128 && i7 < i4) {
                    i3 = i7 + 1;
                    bArr[i7] = (byte) charAt2;
                } else if (charAt2 < 2048 && i7 <= i4 - 2) {
                    int i8 = i7 + 1;
                    bArr[i7] = (byte) ((charAt2 >>> 6) | TXEAudioDef.TXE_OPUS_SAMPLE_NUM);
                    i7 = i8 + 1;
                    bArr[i8] = (byte) ((charAt2 & '?') | 128);
                    i5++;
                } else if ((charAt2 < 55296 || 57343 < charAt2) && i7 <= i4 - 3) {
                    int i9 = i7 + 1;
                    bArr[i7] = (byte) ((charAt2 >>> 12) | 480);
                    int i10 = i9 + 1;
                    bArr[i9] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i3 = i10 + 1;
                    bArr[i10] = (byte) ((charAt2 & '?') | 128);
                } else if (i7 <= i4 - 4) {
                    int i11 = i5 + 1;
                    if (i11 != charSequence.length()) {
                        char charAt3 = charSequence.charAt(i11);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            int i12 = i7 + 1;
                            bArr[i7] = (byte) ((codePoint >>> 18) | 240);
                            int i13 = i12 + 1;
                            bArr[i12] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i14 = i13 + 1;
                            bArr[i13] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i7 = i14 + 1;
                            bArr[i14] = (byte) ((codePoint & 63) | 128);
                            i5 = i11;
                            i5++;
                        } else {
                            i5 = i11;
                        }
                    }
                    throw new c(i5 - 1, length);
                } else {
                    if (55296 <= charAt2 && charAt2 <= 57343) {
                        int i15 = i5 + 1;
                        if (i15 == charSequence.length() || !Character.isSurrogatePair(charAt2, charSequence.charAt(i15))) {
                            throw new c(i5, length);
                        }
                    }
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i7);
                }
                i7 = i3;
                i5++;
            }
            return i7;
        }

        private static int b(byte[] bArr, int i, int i2) {
            while (i < i2 && bArr[i] >= 0) {
                i++;
            }
            if (i >= i2) {
                return 0;
            }
            return c(bArr, i, i2);
        }

        private static int c(byte[] bArr, int i, int i2) {
            while (i < i2) {
                int i3 = i + 1;
                byte b2 = bArr[i];
                if (b2 < 0) {
                    if (b2 < -32) {
                        if (i3 >= i2) {
                            return b2;
                        }
                        if (b2 >= -62) {
                            i = i3 + 1;
                            if (bArr[i3] > -65) {
                            }
                        }
                        return -1;
                    } else if (b2 < -16) {
                        if (i3 >= i2 - 1) {
                            return ax.c(bArr, i3, i2);
                        }
                        int i4 = i3 + 1;
                        byte b3 = bArr[i3];
                        if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                            i = i4 + 1;
                            if (bArr[i4] > -65) {
                            }
                        }
                        return -1;
                    } else if (i3 >= i2 - 2) {
                        return ax.c(bArr, i3, i2);
                    } else {
                        int i5 = i3 + 1;
                        byte b4 = bArr[i3];
                        if (b4 <= -65 && (((b2 << 28) + (b4 + 112)) >> 30) == 0) {
                            int i6 = i5 + 1;
                            if (bArr[i5] <= -65) {
                                i3 = i6 + 1;
                                if (bArr[i6] > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                }
                i = i3;
            }
            return 0;
        }
    }

    static final class d extends a {
        d() {
        }

        static boolean a() {
            return aw.a() && aw.b();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
            if (com.google.c.aw.a(r13, r2) > -65) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0060, code lost:
            if (com.google.c.aw.a(r13, r2) > -65) goto L_0x0062;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00a2, code lost:
            if (com.google.c.aw.a(r13, r2) > -65) goto L_0x00a4;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int a(int r12, byte[] r13, int r14, int r15) {
            /*
                r11 = this;
                r0 = r14 | r15
                int r1 = r13.length
                int r1 = r1 - r15
                r0 = r0 | r1
                r1 = 0
                if (r0 < 0) goto L_0x00ad
                long r2 = com.google.c.aw.c()
                long r4 = (long) r14
                long r2 = r2 + r4
                long r4 = com.google.c.aw.c()
                long r14 = (long) r15
                long r4 = r4 + r14
                if (r12 == 0) goto L_0x00a5
                int r14 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r14 < 0) goto L_0x001b
                return r12
            L_0x001b:
                byte r14 = (byte) r12
                r15 = -32
                r0 = -1
                r6 = -65
                r7 = 1
                if (r14 >= r15) goto L_0x0032
                r12 = -62
                if (r14 < r12) goto L_0x0031
                long r14 = r2 + r7
                byte r12 = com.google.c.aw.a((byte[]) r13, (long) r2)
                if (r12 <= r6) goto L_0x00a6
            L_0x0031:
                return r0
            L_0x0032:
                r9 = -16
                if (r14 >= r9) goto L_0x0063
                int r12 = r12 >> 8
                r12 = r12 ^ r0
                byte r12 = (byte) r12
                if (r12 != 0) goto L_0x004c
                long r9 = r2 + r7
                byte r12 = com.google.c.aw.a((byte[]) r13, (long) r2)
                int r1 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r1 < 0) goto L_0x004b
                int r12 = com.google.c.ax.b(r14, r12)
                return r12
            L_0x004b:
                r2 = r9
            L_0x004c:
                if (r12 > r6) goto L_0x0062
                r1 = -96
                if (r14 != r15) goto L_0x0054
                if (r12 < r1) goto L_0x0062
            L_0x0054:
                r15 = -19
                if (r14 != r15) goto L_0x005a
                if (r12 >= r1) goto L_0x0062
            L_0x005a:
                long r14 = r2 + r7
                byte r12 = com.google.c.aw.a((byte[]) r13, (long) r2)
                if (r12 <= r6) goto L_0x00a6
            L_0x0062:
                return r0
            L_0x0063:
                int r15 = r12 >> 8
                r15 = r15 ^ r0
                byte r15 = (byte) r15
                if (r15 != 0) goto L_0x007a
                long r9 = r2 + r7
                byte r15 = com.google.c.aw.a((byte[]) r13, (long) r2)
                int r12 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r12 < 0) goto L_0x0078
                int r12 = com.google.c.ax.b(r14, r15)
                return r12
            L_0x0078:
                r2 = r9
                goto L_0x007d
            L_0x007a:
                int r12 = r12 >> 16
                byte r1 = (byte) r12
            L_0x007d:
                if (r1 != 0) goto L_0x008f
                long r9 = r2 + r7
                byte r1 = com.google.c.aw.a((byte[]) r13, (long) r2)
                int r12 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r12 < 0) goto L_0x008e
                int r12 = com.google.c.ax.b((int) r14, (int) r15, (int) r1)
                return r12
            L_0x008e:
                r2 = r9
            L_0x008f:
                if (r15 > r6) goto L_0x00a4
                int r12 = r14 << 28
                int r15 = r15 + 112
                int r12 = r12 + r15
                int r12 = r12 >> 30
                if (r12 != 0) goto L_0x00a4
                if (r1 > r6) goto L_0x00a4
                long r14 = r2 + r7
                byte r12 = com.google.c.aw.a((byte[]) r13, (long) r2)
                if (r12 <= r6) goto L_0x00a6
            L_0x00a4:
                return r0
            L_0x00a5:
                r14 = r2
            L_0x00a6:
                long r4 = r4 - r14
                int r12 = (int) r4
                int r12 = b(r13, r14, r12)
                return r12
            L_0x00ad:
                java.lang.ArrayIndexOutOfBoundsException r12 = new java.lang.ArrayIndexOutOfBoundsException
                r0 = 3
                java.lang.Object[] r0 = new java.lang.Object[r0]
                int r13 = r13.length
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
                r0[r1] = r13
                r13 = 1
                java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
                r0[r13] = r14
                r13 = 2
                java.lang.Integer r14 = java.lang.Integer.valueOf(r15)
                r0[r13] = r14
                java.lang.String r13 = "Array length=%d, index=%d, limit=%d"
                java.lang.String r13 = java.lang.String.format(r13, r0)
                r12.<init>(r13)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.ax.d.a(int, byte[], int, int):int");
        }

        /* access modifiers changed from: package-private */
        public int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
            char c2;
            long j;
            long c3;
            long j2;
            long j3;
            CharSequence charSequence2 = charSequence;
            byte[] bArr2 = bArr;
            int i3 = i;
            int i4 = i2;
            long c4 = aw.c() + ((long) i3);
            long j4 = ((long) i4) + c4;
            int length = charSequence.length();
            if (length > i4 || bArr2.length - i4 < i3) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence2.charAt(length - 1) + " at index " + (i3 + i4));
            }
            int i5 = 0;
            while (true) {
                c2 = 128;
                j = 1;
                if (i5 >= length) {
                    break;
                }
                char charAt = charSequence2.charAt(i5);
                if (charAt >= 128) {
                    break;
                }
                aw.a(bArr2, c4, (byte) charAt);
                i5++;
                c4 = 1 + c4;
            }
            if (i5 == length) {
                c3 = aw.c();
            } else {
                while (i5 < length) {
                    char charAt2 = charSequence2.charAt(i5);
                    if (charAt2 < c2 && c4 < j4) {
                        long j5 = c4 + j;
                        aw.a(bArr2, c4, (byte) charAt2);
                        j3 = j;
                        j2 = j5;
                    } else if (charAt2 < 2048 && c4 <= j4 - 2) {
                        long j6 = c4 + j;
                        aw.a(bArr2, c4, (byte) ((charAt2 >>> 6) | TXEAudioDef.TXE_OPUS_SAMPLE_NUM));
                        aw.a(bArr2, j6, (byte) ((charAt2 & '?') | 128));
                        j2 = j6 + j;
                        j3 = j;
                        i5++;
                        c2 = 128;
                        long j7 = j3;
                        c4 = j2;
                        j = j7;
                    } else if ((charAt2 < 55296 || 57343 < charAt2) && c4 <= j4 - 3) {
                        long j8 = c4 + j;
                        aw.a(bArr2, c4, (byte) ((charAt2 >>> 12) | 480));
                        long j9 = j8 + j;
                        aw.a(bArr2, j8, (byte) (((charAt2 >>> 6) & 63) | 128));
                        aw.a(bArr2, j9, (byte) ((charAt2 & '?') | 128));
                        j2 = j9 + 1;
                        j3 = 1;
                    } else if (c4 <= j4 - 4) {
                        int i6 = i5 + 1;
                        if (i6 != length) {
                            char charAt3 = charSequence2.charAt(i6);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                long j10 = c4 + 1;
                                aw.a(bArr2, c4, (byte) ((codePoint >>> 18) | 240));
                                long j11 = j10 + 1;
                                aw.a(bArr2, j10, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j12 = j11 + 1;
                                aw.a(bArr2, j11, (byte) (((codePoint >>> 6) & 63) | 128));
                                j3 = 1;
                                j2 = j12 + 1;
                                aw.a(bArr2, j12, (byte) ((codePoint & 63) | 128));
                                i5 = i6;
                                i5++;
                                c2 = 128;
                                long j72 = j3;
                                c4 = j2;
                                j = j72;
                            } else {
                                i5 = i6;
                            }
                        }
                        throw new c(i5 - 1, length);
                    } else {
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            int i7 = i5 + 1;
                            if (i7 == length || !Character.isSurrogatePair(charAt2, charSequence2.charAt(i7))) {
                                throw new c(i5, length);
                            }
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + c4);
                    }
                    i5++;
                    c2 = 128;
                    long j722 = j3;
                    c4 = j2;
                    j = j722;
                }
                c3 = aw.c();
            }
            return (int) (c4 - c3);
        }

        private static int a(byte[] bArr, long j, int i) {
            if (i < 16) {
                return 0;
            }
            int i2 = ((int) j) & 7;
            long j2 = j;
            int i3 = i2;
            while (i3 > 0) {
                long j3 = 1 + j2;
                if (aw.a(bArr, j2) < 0) {
                    return i2 - i3;
                }
                i3--;
                j2 = j3;
            }
            int i4 = i - i2;
            while (i4 >= 8 && (aw.b(bArr, j2) & -9187201950435737472L) == 0) {
                j2 += 8;
                i4 -= 8;
            }
            return i - i4;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0063, code lost:
            return -1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int b(byte[] r8, long r9, int r11) {
            /*
                int r0 = a(r8, r9, r11)
                int r11 = r11 - r0
                long r0 = (long) r0
                long r9 = r9 + r0
            L_0x0007:
                r0 = 0
                r1 = 0
            L_0x0009:
                r2 = 1
                if (r11 <= 0) goto L_0x001a
                long r4 = r9 + r2
                byte r1 = com.google.c.aw.a((byte[]) r8, (long) r9)
                if (r1 < 0) goto L_0x0019
                int r11 = r11 + -1
                r9 = r4
                goto L_0x0009
            L_0x0019:
                r9 = r4
            L_0x001a:
                if (r11 != 0) goto L_0x001d
                return r0
            L_0x001d:
                int r11 = r11 + -1
                r0 = -32
                r4 = -65
                r5 = -1
                if (r1 >= r0) goto L_0x003a
                if (r11 != 0) goto L_0x0029
                return r1
            L_0x0029:
                int r11 = r11 + -1
                r0 = -62
                if (r1 < r0) goto L_0x0039
                long r2 = r2 + r9
                byte r9 = com.google.c.aw.a((byte[]) r8, (long) r9)
                if (r9 <= r4) goto L_0x0037
                goto L_0x0039
            L_0x0037:
                r9 = r2
                goto L_0x0007
            L_0x0039:
                return r5
            L_0x003a:
                r6 = -16
                if (r1 >= r6) goto L_0x0064
                r6 = 2
                if (r11 >= r6) goto L_0x0046
                int r8 = a((byte[]) r8, (int) r1, (long) r9, (int) r11)
                return r8
            L_0x0046:
                int r11 = r11 + -2
                long r6 = r9 + r2
                byte r9 = com.google.c.aw.a((byte[]) r8, (long) r9)
                if (r9 > r4) goto L_0x0063
                r10 = -96
                if (r1 != r0) goto L_0x0056
                if (r9 < r10) goto L_0x0063
            L_0x0056:
                r0 = -19
                if (r1 != r0) goto L_0x005c
                if (r9 >= r10) goto L_0x0063
            L_0x005c:
                long r2 = r2 + r6
                byte r9 = com.google.c.aw.a((byte[]) r8, (long) r6)
                if (r9 <= r4) goto L_0x0037
            L_0x0063:
                return r5
            L_0x0064:
                r0 = 3
                if (r11 >= r0) goto L_0x006c
                int r8 = a((byte[]) r8, (int) r1, (long) r9, (int) r11)
                return r8
            L_0x006c:
                int r11 = r11 + -3
                long r6 = r9 + r2
                byte r9 = com.google.c.aw.a((byte[]) r8, (long) r9)
                if (r9 > r4) goto L_0x008e
                int r10 = r1 << 28
                int r9 = r9 + 112
                int r10 = r10 + r9
                int r9 = r10 >> 30
                if (r9 != 0) goto L_0x008e
                long r9 = r6 + r2
                byte r0 = com.google.c.aw.a((byte[]) r8, (long) r6)
                if (r0 > r4) goto L_0x008e
                long r2 = r2 + r9
                byte r9 = com.google.c.aw.a((byte[]) r8, (long) r9)
                if (r9 <= r4) goto L_0x0037
            L_0x008e:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.ax.d.b(byte[], long, int):int");
        }

        private static int a(byte[] bArr, int i, long j, int i2) {
            if (i2 == 0) {
                return ax.b(i);
            }
            if (i2 == 1) {
                return ax.b(i, aw.a(bArr, j));
            }
            if (i2 == 2) {
                return ax.b(i, (int) aw.a(bArr, j), (int) aw.a(bArr, j + 1));
            }
            throw new AssertionError();
        }
    }
}
