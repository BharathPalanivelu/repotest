package com.google.android.gms.internal.vision;

import com.tencent.liteav.audio.TXEAudioDef;

final class zzfr extends zzfo {
    zzfr() {
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return zzfn.zzap(i);
        }
        if (i2 == 1) {
            return zzfn.zzt(i, zzfl.zza(bArr, j));
        }
        if (i2 == 2) {
            return zzfn.zzc(i, zzfl.zza(bArr, j), zzfl.zza(bArr, j + 1));
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00b9, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(int r16, byte[] r17, int r18, int r19) {
        /*
            r15 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r1 | r2
            int r4 = r0.length
            int r4 = r4 - r2
            r3 = r3 | r4
            r4 = 2
            r5 = 3
            r6 = 0
            if (r3 < 0) goto L_0x00ba
            long r7 = (long) r1
            long r1 = (long) r2
            long r1 = r1 - r7
            int r2 = (int) r1
            r1 = 16
            r9 = 1
            if (r2 >= r1) goto L_0x001c
            r1 = 0
            goto L_0x002e
        L_0x001c:
            r11 = r7
            r1 = 0
        L_0x001e:
            if (r1 >= r2) goto L_0x002d
            long r13 = r11 + r9
            byte r3 = com.google.android.gms.internal.vision.zzfl.zza(r0, r11)
            if (r3 >= 0) goto L_0x0029
            goto L_0x002e
        L_0x0029:
            int r1 = r1 + 1
            r11 = r13
            goto L_0x001e
        L_0x002d:
            r1 = r2
        L_0x002e:
            int r2 = r2 - r1
            long r11 = (long) r1
            long r7 = r7 + r11
        L_0x0031:
            r1 = 0
        L_0x0032:
            if (r2 <= 0) goto L_0x0040
            long r11 = r7 + r9
            byte r1 = com.google.android.gms.internal.vision.zzfl.zza(r0, r7)
            if (r1 < 0) goto L_0x0041
            int r2 = r2 + -1
            r7 = r11
            goto L_0x0032
        L_0x0040:
            r11 = r7
        L_0x0041:
            if (r2 != 0) goto L_0x0044
            return r6
        L_0x0044:
            int r2 = r2 + -1
            r3 = -32
            r7 = -65
            r8 = -1
            if (r1 >= r3) goto L_0x0062
            if (r2 != 0) goto L_0x0050
            return r1
        L_0x0050:
            int r2 = r2 + -1
            r3 = -62
            if (r1 < r3) goto L_0x0061
            long r13 = r11 + r9
            byte r1 = com.google.android.gms.internal.vision.zzfl.zza(r0, r11)
            if (r1 <= r7) goto L_0x005f
            goto L_0x0061
        L_0x005f:
            r7 = r13
            goto L_0x0031
        L_0x0061:
            return r8
        L_0x0062:
            r13 = -16
            if (r1 >= r13) goto L_0x008f
            if (r2 >= r4) goto L_0x006d
            int r0 = zza(r0, r1, r11, r2)
            return r0
        L_0x006d:
            int r2 = r2 + -2
            long r13 = r11 + r9
            byte r11 = com.google.android.gms.internal.vision.zzfl.zza(r0, r11)
            if (r11 > r7) goto L_0x008e
            r12 = -96
            if (r1 != r3) goto L_0x007d
            if (r11 < r12) goto L_0x008e
        L_0x007d:
            r3 = -19
            if (r1 != r3) goto L_0x0083
            if (r11 >= r12) goto L_0x008e
        L_0x0083:
            long r11 = r13 + r9
            byte r1 = com.google.android.gms.internal.vision.zzfl.zza(r0, r13)
            if (r1 <= r7) goto L_0x008c
            goto L_0x008e
        L_0x008c:
            r7 = r11
            goto L_0x0031
        L_0x008e:
            return r8
        L_0x008f:
            if (r2 >= r5) goto L_0x0096
            int r0 = zza(r0, r1, r11, r2)
            return r0
        L_0x0096:
            int r2 = r2 + -3
            long r13 = r11 + r9
            byte r3 = com.google.android.gms.internal.vision.zzfl.zza(r0, r11)
            if (r3 > r7) goto L_0x00b9
            int r1 = r1 << 28
            int r3 = r3 + 112
            int r1 = r1 + r3
            int r1 = r1 >> 30
            if (r1 != 0) goto L_0x00b9
            long r11 = r13 + r9
            byte r1 = com.google.android.gms.internal.vision.zzfl.zza(r0, r13)
            if (r1 > r7) goto L_0x00b9
            long r13 = r11 + r9
            byte r1 = com.google.android.gms.internal.vision.zzfl.zza(r0, r11)
            if (r1 <= r7) goto L_0x005f
        L_0x00b9:
            return r8
        L_0x00ba:
            java.lang.ArrayIndexOutOfBoundsException r3 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.Object[] r5 = new java.lang.Object[r5]
            int r0 = r0.length
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r5[r6] = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r18)
            r1 = 1
            r5[r1] = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r19)
            r5[r4] = r0
            java.lang.String r0 = "Array length=%d, index=%d, limit=%d"
            java.lang.String r0 = java.lang.String.format(r0, r5)
            r3.<init>(r0)
            goto L_0x00dd
        L_0x00dc:
            throw r3
        L_0x00dd:
            goto L_0x00dc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfr.zzb(int, byte[], int, int):int");
    }

    /* access modifiers changed from: package-private */
    public final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        char c2;
        long j;
        long j2;
        long j3;
        CharSequence charSequence2 = charSequence;
        byte[] bArr2 = bArr;
        int i3 = i;
        int i4 = i2;
        long j4 = (long) i3;
        long j5 = ((long) i4) + j4;
        int length = charSequence.length();
        if (length > i4 || bArr2.length - i4 < i3) {
            char charAt = charSequence2.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt);
            sb.append(" at index ");
            sb.append(i3 + i4);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i5 = 0;
        while (true) {
            c2 = 128;
            j = 1;
            if (i5 >= length) {
                break;
            }
            char charAt2 = charSequence2.charAt(i5);
            if (charAt2 >= 128) {
                break;
            }
            zzfl.zza(bArr2, j4, (byte) charAt2);
            i5++;
            j4 = 1 + j4;
        }
        if (i5 == length) {
            return (int) j4;
        }
        while (i5 < length) {
            char charAt3 = charSequence2.charAt(i5);
            if (charAt3 < c2 && j4 < j5) {
                long j6 = j4 + j;
                zzfl.zza(bArr2, j4, (byte) charAt3);
                j3 = j;
                j2 = j6;
            } else if (charAt3 < 2048 && j4 <= j5 - 2) {
                long j7 = j4 + j;
                zzfl.zza(bArr2, j4, (byte) ((charAt3 >>> 6) | TXEAudioDef.TXE_OPUS_SAMPLE_NUM));
                zzfl.zza(bArr2, j7, (byte) ((charAt3 & '?') | 128));
                j2 = j7 + j;
                j3 = j;
                i5++;
                c2 = 128;
                long j8 = j3;
                j4 = j2;
                j = j8;
            } else if ((charAt3 < 55296 || 57343 < charAt3) && j4 <= j5 - 3) {
                long j9 = j4 + j;
                zzfl.zza(bArr2, j4, (byte) ((charAt3 >>> 12) | 480));
                long j10 = j9 + j;
                zzfl.zza(bArr2, j9, (byte) (((charAt3 >>> 6) & 63) | 128));
                zzfl.zza(bArr2, j10, (byte) ((charAt3 & '?') | 128));
                j2 = j10 + 1;
                j3 = 1;
            } else if (j4 <= j5 - 4) {
                int i6 = i5 + 1;
                if (i6 != length) {
                    char charAt4 = charSequence2.charAt(i6);
                    if (Character.isSurrogatePair(charAt3, charAt4)) {
                        int codePoint = Character.toCodePoint(charAt3, charAt4);
                        long j11 = j4 + 1;
                        zzfl.zza(bArr2, j4, (byte) ((codePoint >>> 18) | 240));
                        long j12 = j11 + 1;
                        zzfl.zza(bArr2, j11, (byte) (((codePoint >>> 12) & 63) | 128));
                        long j13 = j12 + 1;
                        zzfl.zza(bArr2, j12, (byte) (((codePoint >>> 6) & 63) | 128));
                        j3 = 1;
                        j2 = j13 + 1;
                        zzfl.zza(bArr2, j13, (byte) ((codePoint & 63) | 128));
                        i5 = i6;
                        i5++;
                        c2 = 128;
                        long j82 = j3;
                        j4 = j2;
                        j = j82;
                    } else {
                        i5 = i6;
                    }
                }
                throw new zzfq(i5 - 1, length);
            } else {
                if (55296 <= charAt3 && charAt3 <= 57343) {
                    int i7 = i5 + 1;
                    if (i7 == length || !Character.isSurrogatePair(charAt3, charSequence2.charAt(i7))) {
                        throw new zzfq(i5, length);
                    }
                }
                StringBuilder sb2 = new StringBuilder(46);
                sb2.append("Failed writing ");
                sb2.append(charAt3);
                sb2.append(" at index ");
                sb2.append(j4);
                throw new ArrayIndexOutOfBoundsException(sb2.toString());
            }
            i5++;
            c2 = 128;
            long j822 = j3;
            j4 = j2;
            j = j822;
        }
        return (int) j4;
    }
}
