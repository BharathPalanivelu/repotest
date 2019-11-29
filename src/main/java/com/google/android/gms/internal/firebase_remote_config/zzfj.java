package com.google.android.gms.internal.firebase_remote_config;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public final class zzfj implements Closeable {
    private static final char[] zznf = ")]}'\n".toCharArray();
    private final Reader in;
    private int limit = 0;
    private int pos = 0;
    private boolean zzng = false;
    private final char[] zznh = new char[1024];
    private int zzni = 0;
    private int zznj = 0;
    private int zznk = 0;
    private long zznl;
    private int zznm;
    private String zznn;
    private int[] zzno = new int[32];
    private int zznp = 0;
    private String[] zznq;
    private int[] zznr;

    public zzfj(Reader reader) {
        int[] iArr = this.zzno;
        int i = this.zznp;
        this.zznp = i + 1;
        iArr[i] = 6;
        this.zznq = new String[32];
        this.zznr = new int[32];
        if (reader != null) {
            this.in = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    public final void setLenient(boolean z) {
        this.zzng = true;
    }

    public final void beginArray() throws IOException {
        int i = this.zznk;
        if (i == 0) {
            i = zzdz();
        }
        if (i == 3) {
            zzo(1);
            this.zznr[this.zznp - 1] = 0;
            this.zznk = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + zzdy() + zzed());
    }

    public final void endArray() throws IOException {
        int i = this.zznk;
        if (i == 0) {
            i = zzdz();
        }
        if (i == 4) {
            this.zznp--;
            int[] iArr = this.zznr;
            int i2 = this.zznp - 1;
            iArr[i2] = iArr[i2] + 1;
            this.zznk = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + zzdy() + zzed());
    }

    public final void beginObject() throws IOException {
        int i = this.zznk;
        if (i == 0) {
            i = zzdz();
        }
        if (i == 1) {
            zzo(3);
            this.zznk = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + zzdy() + zzed());
    }

    public final void endObject() throws IOException {
        int i = this.zznk;
        if (i == 0) {
            i = zzdz();
        }
        if (i == 2) {
            this.zznp--;
            String[] strArr = this.zznq;
            int i2 = this.zznp;
            strArr[i2] = null;
            int[] iArr = this.zznr;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.zznk = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + zzdy() + zzed());
    }

    public final zzfl zzdy() throws IOException {
        int i = this.zznk;
        if (i == 0) {
            i = zzdz();
        }
        switch (i) {
            case 1:
                return zzfl.BEGIN_OBJECT;
            case 2:
                return zzfl.END_OBJECT;
            case 3:
                return zzfl.BEGIN_ARRAY;
            case 4:
                return zzfl.END_ARRAY;
            case 5:
            case 6:
                return zzfl.BOOLEAN;
            case 7:
                return zzfl.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return zzfl.STRING;
            case 12:
            case 13:
            case 14:
                return zzfl.NAME;
            case 15:
            case 16:
                return zzfl.NUMBER;
            case 17:
                return zzfl.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01fc, code lost:
        if (r8 == 6) goto L_0x0204;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0218, code lost:
        if (zze(r15) == false) goto L_0x021b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x021b, code lost:
        if (r8 != 2) goto L_0x0241;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x021d, code lost:
        if (r10 == false) goto L_0x0241;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0223, code lost:
        if (r11 != Long.MIN_VALUE) goto L_0x0227;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0225, code lost:
        if (r16 == false) goto L_0x0241;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x022b, code lost:
        if (r11 != 0) goto L_0x022f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x022d, code lost:
        if (r16 != false) goto L_0x0241;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x022f, code lost:
        if (r16 == false) goto L_0x0232;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0232, code lost:
        r11 = -r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0233, code lost:
        r0.zznl = r11;
        r0.pos += r3;
        r0.zznk = 15;
        r17 = 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0241, code lost:
        if (r8 == 2) goto L_0x024d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0244, code lost:
        if (r8 == 4) goto L_0x024d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0247, code lost:
        if (r8 != 7) goto L_0x024a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x024d, code lost:
        r0.zznm = r3;
        r0.zznk = 16;
        r17 = 16;
     */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x017a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x017b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzdz() throws java.io.IOException {
        /*
            r20 = this;
            r0 = r20
            int[] r1 = r0.zzno
            int r2 = r0.zznp
            int r3 = r2 + -1
            r3 = r1[r3]
            r5 = 34
            r6 = 93
            r7 = 59
            r8 = 44
            r9 = 3
            r10 = 6
            r11 = 7
            r12 = 4
            r13 = 5
            r14 = 2
            r15 = 0
            r4 = 1
            if (r3 != r4) goto L_0x0021
            int r2 = r2 - r4
            r1[r2] = r14
            goto L_0x00d4
        L_0x0021:
            if (r3 != r14) goto L_0x003c
            int r1 = r0.zzb(r4)
            if (r1 == r8) goto L_0x00d4
            if (r1 == r7) goto L_0x0037
            if (r1 != r6) goto L_0x0030
            r0.zznk = r12
            return r12
        L_0x0030:
            java.lang.String r1 = "Unterminated array"
            java.io.IOException r1 = r0.zzbe(r1)
            throw r1
        L_0x0037:
            r20.zzeb()
            goto L_0x00d4
        L_0x003c:
            if (r3 == r9) goto L_0x02d3
            if (r3 != r13) goto L_0x0042
            goto L_0x02d3
        L_0x0042:
            if (r3 != r12) goto L_0x0077
            int r2 = r2 - r4
            r1[r2] = r13
            int r1 = r0.zzb(r4)
            r2 = 58
            if (r1 == r2) goto L_0x00d4
            r2 = 61
            if (r1 != r2) goto L_0x0070
            r20.zzeb()
            int r1 = r0.pos
            int r2 = r0.limit
            if (r1 < r2) goto L_0x0062
            boolean r1 = r0.zzp(r4)
            if (r1 == 0) goto L_0x00d4
        L_0x0062:
            char[] r1 = r0.zznh
            int r2 = r0.pos
            char r1 = r1[r2]
            r12 = 62
            if (r1 != r12) goto L_0x00d4
            int r2 = r2 + r4
            r0.pos = r2
            goto L_0x00d4
        L_0x0070:
            java.lang.String r1 = "Expected ':'"
            java.io.IOException r1 = r0.zzbe(r1)
            throw r1
        L_0x0077:
            if (r3 != r10) goto L_0x00b9
            boolean r1 = r0.zzng
            if (r1 == 0) goto L_0x00b1
            r0.zzb(r4)
            int r1 = r0.pos
            int r1 = r1 - r4
            r0.pos = r1
            int r1 = r0.pos
            char[] r2 = zznf
            int r12 = r2.length
            int r1 = r1 + r12
            int r12 = r0.limit
            if (r1 <= r12) goto L_0x0096
            int r1 = r2.length
            boolean r1 = r0.zzp(r1)
            if (r1 == 0) goto L_0x00b1
        L_0x0096:
            r1 = 0
        L_0x0097:
            char[] r2 = zznf
            int r12 = r2.length
            if (r1 >= r12) goto L_0x00ab
            char[] r12 = r0.zznh
            int r10 = r0.pos
            int r10 = r10 + r1
            char r10 = r12[r10]
            char r2 = r2[r1]
            if (r10 != r2) goto L_0x00b1
            int r1 = r1 + 1
            r10 = 6
            goto L_0x0097
        L_0x00ab:
            int r1 = r0.pos
            int r2 = r2.length
            int r1 = r1 + r2
            r0.pos = r1
        L_0x00b1:
            int[] r1 = r0.zzno
            int r2 = r0.zznp
            int r2 = r2 - r4
            r1[r2] = r11
            goto L_0x00d4
        L_0x00b9:
            if (r3 != r11) goto L_0x00d0
            int r1 = r0.zzb(r15)
            r2 = -1
            if (r1 != r2) goto L_0x00c7
            r1 = 17
            r0.zznk = r1
            return r1
        L_0x00c7:
            r20.zzeb()
            int r1 = r0.pos
            int r1 = r1 - r4
            r0.pos = r1
            goto L_0x00d4
        L_0x00d0:
            r1 = 8
            if (r3 == r1) goto L_0x02cb
        L_0x00d4:
            int r1 = r0.zzb(r4)
            if (r1 == r5) goto L_0x02c6
            r2 = 39
            if (r1 == r2) goto L_0x02be
            if (r1 == r8) goto L_0x02a5
            if (r1 == r7) goto L_0x02a5
            r2 = 91
            if (r1 == r2) goto L_0x02a2
            if (r1 == r6) goto L_0x029b
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L_0x0297
            int r1 = r0.pos
            int r1 = r1 - r4
            r0.pos = r1
            char[] r1 = r0.zznh
            int r2 = r0.pos
            char r1 = r1[r2]
            r2 = 116(0x74, float:1.63E-43)
            if (r1 == r2) goto L_0x011f
            r2 = 84
            if (r1 != r2) goto L_0x0100
            goto L_0x011f
        L_0x0100:
            r2 = 102(0x66, float:1.43E-43)
            if (r1 == r2) goto L_0x0118
            r2 = 70
            if (r1 != r2) goto L_0x0109
            goto L_0x0118
        L_0x0109:
            r2 = 110(0x6e, float:1.54E-43)
            if (r1 == r2) goto L_0x0111
            r2 = 78
            if (r1 != r2) goto L_0x016f
        L_0x0111:
            java.lang.String r1 = "null"
            java.lang.String r2 = "NULL"
            r3 = r2
            r2 = 7
            goto L_0x0125
        L_0x0118:
            java.lang.String r1 = "false"
            java.lang.String r2 = "FALSE"
            r3 = r2
            r2 = 6
            goto L_0x0125
        L_0x011f:
            java.lang.String r1 = "true"
            java.lang.String r2 = "TRUE"
            r3 = r2
            r2 = 5
        L_0x0125:
            int r5 = r1.length()
            r6 = 1
        L_0x012a:
            if (r6 >= r5) goto L_0x0153
            int r7 = r0.pos
            int r7 = r7 + r6
            int r8 = r0.limit
            if (r7 < r8) goto L_0x013c
            int r7 = r6 + 1
            boolean r7 = r0.zzp(r7)
            if (r7 != 0) goto L_0x013c
            goto L_0x016f
        L_0x013c:
            char[] r7 = r0.zznh
            int r8 = r0.pos
            int r8 = r8 + r6
            char r7 = r7[r8]
            char r8 = r1.charAt(r6)
            if (r7 == r8) goto L_0x0150
            char r8 = r3.charAt(r6)
            if (r7 == r8) goto L_0x0150
            goto L_0x016f
        L_0x0150:
            int r6 = r6 + 1
            goto L_0x012a
        L_0x0153:
            int r1 = r0.pos
            int r1 = r1 + r5
            int r3 = r0.limit
            if (r1 < r3) goto L_0x0162
            int r1 = r5 + 1
            boolean r1 = r0.zzp(r1)
            if (r1 == 0) goto L_0x0171
        L_0x0162:
            char[] r1 = r0.zznh
            int r3 = r0.pos
            int r3 = r3 + r5
            char r1 = r1[r3]
            boolean r1 = r0.zze(r1)
            if (r1 == 0) goto L_0x0171
        L_0x016f:
            r2 = 0
            goto L_0x0178
        L_0x0171:
            int r1 = r0.pos
            int r1 = r1 + r5
            r0.pos = r1
            r0.zznk = r2
        L_0x0178:
            if (r2 == 0) goto L_0x017b
            return r2
        L_0x017b:
            char[] r1 = r0.zznh
            int r2 = r0.pos
            int r3 = r0.limit
            r5 = 0
            r7 = r3
            r11 = r5
            r3 = 0
            r8 = 0
            r10 = 1
            r16 = 0
        L_0x018a:
            int r15 = r2 + r3
            if (r15 != r7) goto L_0x019d
            int r2 = r1.length
            if (r3 == r2) goto L_0x024a
            int r2 = r3 + 1
            boolean r2 = r0.zzp(r2)
            if (r2 == 0) goto L_0x021b
            int r2 = r0.pos
            int r7 = r0.limit
        L_0x019d:
            int r15 = r2 + r3
            char r15 = r1[r15]
            r13 = 43
            if (r15 == r13) goto L_0x026f
            r13 = 69
            if (r15 == r13) goto L_0x0266
            r13 = 101(0x65, float:1.42E-43)
            if (r15 == r13) goto L_0x0266
            r13 = 45
            if (r15 == r13) goto L_0x025b
            r13 = 46
            if (r15 == r13) goto L_0x0256
            r13 = 48
            if (r15 < r13) goto L_0x0214
            r13 = 57
            if (r15 <= r13) goto L_0x01be
            goto L_0x0214
        L_0x01be:
            if (r8 == r4) goto L_0x0209
            if (r8 != 0) goto L_0x01c3
            goto L_0x0209
        L_0x01c3:
            if (r8 != r14) goto L_0x01f1
            int r13 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r13 == 0) goto L_0x024a
            r18 = 10
            long r18 = r18 * r11
            int r15 = r15 + -48
            long r4 = (long) r15
            long r18 = r18 - r4
            r4 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x01eb
            r4 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x01e9
            int r4 = (r18 > r11 ? 1 : (r18 == r11 ? 0 : -1))
            if (r4 >= 0) goto L_0x01e9
            goto L_0x01eb
        L_0x01e9:
            r4 = 0
            goto L_0x01ec
        L_0x01eb:
            r4 = 1
        L_0x01ec:
            r4 = r4 & r10
            r10 = r4
            r11 = r18
            goto L_0x01ff
        L_0x01f1:
            if (r8 != r9) goto L_0x01f8
            r5 = 0
            r8 = 4
            goto L_0x0273
        L_0x01f8:
            r4 = 5
            if (r8 == r4) goto L_0x0203
            r4 = 6
            if (r8 != r4) goto L_0x01ff
            goto L_0x0204
        L_0x01ff:
            r5 = 0
            goto L_0x0273
        L_0x0203:
            r4 = 6
        L_0x0204:
            r5 = 0
            r8 = 7
            goto L_0x0273
        L_0x0209:
            r4 = 6
            int r15 = r15 + -48
            int r5 = -r15
            long r5 = (long) r5
            r11 = r5
            r5 = 0
            r8 = 2
            goto L_0x0273
        L_0x0214:
            boolean r1 = r0.zze(r15)
            if (r1 == 0) goto L_0x021b
            goto L_0x024a
        L_0x021b:
            if (r8 != r14) goto L_0x0241
            if (r10 == 0) goto L_0x0241
            r1 = -9223372036854775808
            int r4 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r4 != 0) goto L_0x0227
            if (r16 == 0) goto L_0x0241
        L_0x0227:
            r5 = 0
            int r1 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x022f
            if (r16 != 0) goto L_0x0241
        L_0x022f:
            if (r16 == 0) goto L_0x0232
            goto L_0x0233
        L_0x0232:
            long r11 = -r11
        L_0x0233:
            r0.zznl = r11
            int r1 = r0.pos
            int r1 = r1 + r3
            r0.pos = r1
            r15 = 15
            r0.zznk = r15
            r17 = 15
            goto L_0x0279
        L_0x0241:
            if (r8 == r14) goto L_0x024d
            r1 = 4
            if (r8 == r1) goto L_0x024d
            r1 = 7
            if (r8 != r1) goto L_0x024a
            goto L_0x024d
        L_0x024a:
            r17 = 0
            goto L_0x0279
        L_0x024d:
            r0.zznm = r3
            r15 = 16
            r0.zznk = r15
            r17 = 16
            goto L_0x0279
        L_0x0256:
            r4 = 6
            if (r8 != r14) goto L_0x024a
            r8 = 3
            goto L_0x0273
        L_0x025b:
            r4 = 6
            if (r8 != 0) goto L_0x0262
            r8 = 1
            r16 = 1
            goto L_0x0273
        L_0x0262:
            r15 = 5
            if (r8 != r15) goto L_0x024a
            goto L_0x0272
        L_0x0266:
            r4 = 6
            r15 = 5
            if (r8 == r14) goto L_0x026d
            r4 = 4
            if (r8 != r4) goto L_0x024a
        L_0x026d:
            r8 = 5
            goto L_0x0273
        L_0x026f:
            r15 = 5
            if (r8 != r15) goto L_0x024a
        L_0x0272:
            r8 = 6
        L_0x0273:
            int r3 = r3 + 1
            r4 = 1
            r13 = 5
            goto L_0x018a
        L_0x0279:
            if (r17 == 0) goto L_0x027c
            return r17
        L_0x027c:
            char[] r1 = r0.zznh
            int r2 = r0.pos
            char r1 = r1[r2]
            boolean r1 = r0.zze(r1)
            if (r1 == 0) goto L_0x0290
            r20.zzeb()
            r1 = 10
            r0.zznk = r1
            return r1
        L_0x0290:
            java.lang.String r1 = "Expected value"
            java.io.IOException r1 = r0.zzbe(r1)
            throw r1
        L_0x0297:
            r1 = 1
            r0.zznk = r1
            return r1
        L_0x029b:
            r1 = 1
            if (r3 != r1) goto L_0x02a6
            r2 = 4
            r0.zznk = r2
            return r2
        L_0x02a2:
            r0.zznk = r9
            return r9
        L_0x02a5:
            r1 = 1
        L_0x02a6:
            if (r3 == r1) goto L_0x02b2
            if (r3 != r14) goto L_0x02ab
            goto L_0x02b2
        L_0x02ab:
            java.lang.String r1 = "Unexpected value"
            java.io.IOException r1 = r0.zzbe(r1)
            throw r1
        L_0x02b2:
            r20.zzeb()
            int r2 = r0.pos
            int r2 = r2 - r1
            r0.pos = r2
            r1 = 7
            r0.zznk = r1
            return r1
        L_0x02be:
            r20.zzeb()
            r1 = 8
            r0.zznk = r1
            return r1
        L_0x02c6:
            r1 = 9
            r0.zznk = r1
            return r1
        L_0x02cb:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "JsonReader is closed"
            r1.<init>(r2)
            throw r1
        L_0x02d3:
            int[] r1 = r0.zzno
            int r2 = r0.zznp
            r4 = 1
            int r2 = r2 - r4
            r6 = 4
            r1[r2] = r6
            r1 = 5
            if (r3 != r1) goto L_0x02f8
            int r1 = r0.zzb(r4)
            if (r1 == r8) goto L_0x02f8
            if (r1 == r7) goto L_0x02f5
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 != r2) goto L_0x02ee
            r0.zznk = r14
            return r14
        L_0x02ee:
            java.lang.String r1 = "Unterminated object"
            java.io.IOException r1 = r0.zzbe(r1)
            throw r1
        L_0x02f5:
            r20.zzeb()
        L_0x02f8:
            r1 = 1
            int r2 = r0.zzb(r1)
            if (r2 == r5) goto L_0x0337
            r4 = 39
            if (r2 == r4) goto L_0x032f
            r4 = 125(0x7d, float:1.75E-43)
            if (r2 == r4) goto L_0x0322
            r20.zzeb()
            int r3 = r0.pos
            int r3 = r3 - r1
            r0.pos = r3
            char r1 = (char) r2
            boolean r1 = r0.zze(r1)
            if (r1 == 0) goto L_0x031b
            r1 = 14
            r0.zznk = r1
            return r1
        L_0x031b:
            java.lang.String r1 = "Expected name"
            java.io.IOException r1 = r0.zzbe(r1)
            throw r1
        L_0x0322:
            r1 = 5
            if (r3 == r1) goto L_0x0328
            r0.zznk = r14
            return r14
        L_0x0328:
            java.lang.String r1 = "Expected name"
            java.io.IOException r1 = r0.zzbe(r1)
            throw r1
        L_0x032f:
            r20.zzeb()
            r1 = 12
            r0.zznk = r1
            return r1
        L_0x0337:
            r1 = 13
            r0.zznk = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzfj.zzdz():int");
    }

    private final boolean zze(char c2) throws IOException {
        if (c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13 || c2 == ' ') {
            return false;
        }
        if (c2 != '#') {
            if (c2 == ',') {
                return false;
            }
            if (!(c2 == '/' || c2 == '=')) {
                if (c2 == '{' || c2 == '}' || c2 == ':') {
                    return false;
                }
                if (c2 != ';') {
                    switch (c2) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        zzeb();
        return false;
    }

    public final String nextName() throws IOException {
        String str;
        int i = this.zznk;
        if (i == 0) {
            i = zzdz();
        }
        if (i == 14) {
            str = zzea();
        } else if (i == 12) {
            str = zzf('\'');
        } else if (i == 13) {
            str = zzf('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + zzdy() + zzed());
        }
        this.zznk = 0;
        this.zznq[this.zznp - 1] = str;
        return str;
    }

    public final String nextString() throws IOException {
        int i = this.zznk;
        if (i == 0) {
            i = zzdz();
        }
        String str = null;
        if (i == 10) {
            str = zzea();
        } else if (i == 8) {
            str = zzf('\'');
        } else if (i == 9) {
            str = zzf('\"');
        } else if (i == 11) {
            this.zznn = null;
        } else if (i == 15) {
            str = Long.toString(this.zznl);
        } else if (i == 16) {
            str = new String(this.zznh, this.pos, this.zznm);
            this.pos += this.zznm;
        } else {
            throw new IllegalStateException("Expected a string but was " + zzdy() + zzed());
        }
        this.zznk = 0;
        int[] iArr = this.zznr;
        int i2 = this.zznp - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public final boolean nextBoolean() throws IOException {
        int i = this.zznk;
        if (i == 0) {
            i = zzdz();
        }
        if (i == 5) {
            this.zznk = 0;
            int[] iArr = this.zznr;
            int i2 = this.zznp - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.zznk = 0;
            int[] iArr2 = this.zznr;
            int i3 = this.zznp - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + zzdy() + zzed());
        }
    }

    public final void nextNull() throws IOException {
        int i = this.zznk;
        if (i == 0) {
            i = zzdz();
        }
        if (i == 7) {
            this.zznk = 0;
            int[] iArr = this.zznr;
            int i2 = this.zznp - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + zzdy() + zzed());
    }

    private final String zzf(char c2) throws IOException {
        char[] cArr = this.zznh;
        StringBuilder sb = null;
        while (true) {
            int i = this.pos;
            int i2 = this.limit;
            int i3 = i;
            while (true) {
                if (i3 < i2) {
                    int i4 = i3 + 1;
                    char c3 = cArr[i3];
                    if (c3 == c2) {
                        this.pos = i4;
                        int i5 = (i4 - i) - 1;
                        if (sb == null) {
                            return new String(cArr, i, i5);
                        }
                        sb.append(cArr, i, i5);
                        return sb.toString();
                    } else if (c3 == '\\') {
                        this.pos = i4;
                        int i6 = (i4 - i) - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max((i6 + 1) << 1, 16));
                        }
                        sb.append(cArr, i, i6);
                        sb.append(zzee());
                    } else {
                        if (c3 == 10) {
                            this.zzni++;
                            this.zznj = i4;
                        }
                        i3 = i4;
                    }
                } else {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max((i3 - i) << 1, 16));
                    }
                    sb.append(cArr, i, i3 - i);
                    this.pos = i3;
                    if (!zzp(1)) {
                        throw zzbe("Unterminated string");
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004b, code lost:
        zzeb();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String zzea() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            r2 = r1
        L_0x0003:
            r1 = 0
        L_0x0004:
            int r3 = r6.pos
            int r4 = r3 + r1
            int r5 = r6.limit
            if (r4 >= r5) goto L_0x004f
            char[] r4 = r6.zznh
            int r3 = r3 + r1
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L_0x005d
            r4 = 10
            if (r3 == r4) goto L_0x005d
            r4 = 12
            if (r3 == r4) goto L_0x005d
            r4 = 13
            if (r3 == r4) goto L_0x005d
            r4 = 32
            if (r3 == r4) goto L_0x005d
            r4 = 35
            if (r3 == r4) goto L_0x004b
            r4 = 44
            if (r3 == r4) goto L_0x005d
            r4 = 47
            if (r3 == r4) goto L_0x004b
            r4 = 61
            if (r3 == r4) goto L_0x004b
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L_0x005d
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L_0x005d
            r4 = 58
            if (r3 == r4) goto L_0x005d
            r4 = 59
            if (r3 == r4) goto L_0x004b
            switch(r3) {
                case 91: goto L_0x005d;
                case 92: goto L_0x004b;
                case 93: goto L_0x005d;
                default: goto L_0x0048;
            }
        L_0x0048:
            int r1 = r1 + 1
            goto L_0x0004
        L_0x004b:
            r6.zzeb()
            goto L_0x005d
        L_0x004f:
            char[] r3 = r6.zznh
            int r3 = r3.length
            if (r1 >= r3) goto L_0x005f
            int r3 = r1 + 1
            boolean r3 = r6.zzp(r3)
            if (r3 == 0) goto L_0x005d
            goto L_0x0004
        L_0x005d:
            r0 = r1
            goto L_0x007f
        L_0x005f:
            if (r2 != 0) goto L_0x006c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r1, r3)
            r2.<init>(r3)
        L_0x006c:
            char[] r3 = r6.zznh
            int r4 = r6.pos
            r2.append(r3, r4, r1)
            int r3 = r6.pos
            int r3 = r3 + r1
            r6.pos = r3
            r1 = 1
            boolean r1 = r6.zzp(r1)
            if (r1 != 0) goto L_0x0003
        L_0x007f:
            if (r2 != 0) goto L_0x008b
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.zznh
            int r3 = r6.pos
            r1.<init>(r2, r3, r0)
            goto L_0x0096
        L_0x008b:
            char[] r1 = r6.zznh
            int r3 = r6.pos
            r2.append(r1, r3, r0)
            java.lang.String r1 = r2.toString()
        L_0x0096:
            int r2 = r6.pos
            int r2 = r2 + r0
            r6.pos = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzfj.zzea():java.lang.String");
    }

    private final void zzg(char c2) throws IOException {
        char[] cArr = this.zznh;
        while (true) {
            int i = this.pos;
            int i2 = this.limit;
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    char c3 = cArr[i];
                    if (c3 == c2) {
                        this.pos = i3;
                        return;
                    } else if (c3 == '\\') {
                        this.pos = i3;
                        zzee();
                        break;
                    } else {
                        if (c3 == 10) {
                            this.zzni++;
                            this.zznj = i3;
                        }
                        i = i3;
                    }
                } else {
                    this.pos = i;
                    if (!zzp(1)) {
                        throw zzbe("Unterminated string");
                    }
                }
            }
        }
    }

    public final void close() throws IOException {
        this.zznk = 0;
        this.zzno[0] = 8;
        this.zznp = 1;
        this.in.close();
    }

    public final void skipValue() throws IOException {
        int i;
        int i2 = 0;
        do {
            int i3 = this.zznk;
            if (i3 == 0) {
                i3 = zzdz();
            }
            if (i3 == 3) {
                zzo(1);
            } else if (i3 == 1) {
                zzo(3);
            } else {
                if (i3 == 4) {
                    this.zznp--;
                } else if (i3 == 2) {
                    this.zznp--;
                } else if (i3 == 14 || i3 == 10) {
                    while (true) {
                        i = 0;
                        while (true) {
                            int i4 = this.pos;
                            if (i4 + i < this.limit) {
                                char c2 = this.zznh[i4 + i];
                                if (!(c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13 || c2 == ' ')) {
                                    if (c2 != '#') {
                                        if (c2 != ',') {
                                            if (!(c2 == '/' || c2 == '=')) {
                                                if (!(c2 == '{' || c2 == '}' || c2 == ':')) {
                                                    if (c2 != ';') {
                                                        switch (c2) {
                                                            case '[':
                                                            case ']':
                                                                break;
                                                            case '\\':
                                                                break;
                                                            default:
                                                                i++;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                this.pos = i4 + i;
                                if (!zzp(1)) {
                                }
                            }
                        }
                    }
                    zzeb();
                    this.pos += i;
                    this.zznk = 0;
                } else if (i3 == 8 || i3 == 12) {
                    zzg('\'');
                    this.zznk = 0;
                } else if (i3 == 9 || i3 == 13) {
                    zzg('\"');
                    this.zznk = 0;
                } else {
                    if (i3 == 16) {
                        this.pos += this.zznm;
                    }
                    this.zznk = 0;
                }
                i2--;
                this.zznk = 0;
            }
            i2++;
            this.zznk = 0;
        } while (i2 != 0);
        int[] iArr = this.zznr;
        int i5 = this.zznp;
        int i6 = i5 - 1;
        iArr[i6] = iArr[i6] + 1;
        this.zznq[i5 - 1] = "null";
    }

    private final void zzo(int i) {
        int i2 = this.zznp;
        int[] iArr = this.zzno;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[(i2 << 1)];
            int[] iArr3 = new int[(i2 << 1)];
            String[] strArr = new String[(i2 << 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.zznr, 0, iArr3, 0, this.zznp);
            System.arraycopy(this.zznq, 0, strArr, 0, this.zznp);
            this.zzno = iArr2;
            this.zznr = iArr3;
            this.zznq = strArr;
        }
        int[] iArr4 = this.zzno;
        int i3 = this.zznp;
        this.zznp = i3 + 1;
        iArr4[i3] = i;
    }

    private final boolean zzp(int i) throws IOException {
        char[] cArr = this.zznh;
        int i2 = this.zznj;
        int i3 = this.pos;
        this.zznj = i2 - i3;
        int i4 = this.limit;
        if (i4 != i3) {
            this.limit = i4 - i3;
            System.arraycopy(cArr, i3, cArr, 0, this.limit);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.in;
            int i5 = this.limit;
            int read = reader.read(cArr, i5, cArr.length - i5);
            if (read == -1) {
                return false;
            }
            this.limit += read;
            if (this.zzni == 0) {
                int i6 = this.zznj;
                if (i6 == 0 && this.limit > 0 && cArr[0] == 65279) {
                    this.pos++;
                    this.zznj = i6 + 1;
                    i++;
                }
            }
        } while (this.limit < i);
        return true;
    }

    private final int zzb(boolean z) throws IOException {
        char[] cArr = this.zznh;
        int i = this.pos;
        int i2 = this.limit;
        while (true) {
            boolean z2 = true;
            if (i == i2) {
                this.pos = i;
                if (zzp(1)) {
                    i = this.pos;
                    i2 = this.limit;
                } else if (!z) {
                    return -1;
                } else {
                    throw new EOFException("End of input" + zzed());
                }
            }
            int i3 = i + 1;
            char c2 = cArr[i];
            if (c2 == 10) {
                this.zzni++;
                this.zznj = i3;
            } else if (!(c2 == ' ' || c2 == 13 || c2 == 9)) {
                if (c2 == '/') {
                    this.pos = i3;
                    if (i3 == i2) {
                        this.pos--;
                        boolean zzp = zzp(2);
                        this.pos++;
                        if (!zzp) {
                            return c2;
                        }
                    }
                    zzeb();
                    int i4 = this.pos;
                    char c3 = cArr[i4];
                    if (c3 == '*') {
                        this.pos = i4 + 1;
                        while (true) {
                            int i5 = 0;
                            if (this.pos + 2 > this.limit && !zzp(2)) {
                                z2 = false;
                                break;
                            }
                            char[] cArr2 = this.zznh;
                            int i6 = this.pos;
                            if (cArr2[i6] != 10) {
                                while (i5 < 2) {
                                    if (this.zznh[this.pos + i5] == "*/".charAt(i5)) {
                                        i5++;
                                    }
                                }
                                break;
                            }
                            this.zzni++;
                            this.zznj = i6 + 1;
                            this.pos++;
                        }
                        if (z2) {
                            i = this.pos + 2;
                            i2 = this.limit;
                        } else {
                            throw zzbe("Unterminated comment");
                        }
                    } else if (c3 != '/') {
                        return c2;
                    } else {
                        this.pos = i4 + 1;
                        zzec();
                        i = this.pos;
                        i2 = this.limit;
                    }
                } else if (c2 == '#') {
                    this.pos = i3;
                    zzeb();
                    zzec();
                    i = this.pos;
                    i2 = this.limit;
                } else {
                    this.pos = i3;
                    return c2;
                }
            }
            i = i3;
        }
    }

    private final void zzeb() throws IOException {
        if (!this.zzng) {
            throw zzbe("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private final void zzec() throws IOException {
        char c2;
        do {
            if (this.pos < this.limit || zzp(1)) {
                char[] cArr = this.zznh;
                int i = this.pos;
                this.pos = i + 1;
                c2 = cArr[i];
                if (c2 == 10) {
                    this.zzni++;
                    this.zznj = this.pos;
                    return;
                }
            } else {
                return;
            }
        } while (c2 != 13);
    }

    public final String toString() {
        return getClass().getSimpleName() + zzed();
    }

    private final String zzed() {
        StringBuilder sb = new StringBuilder(" at line ");
        sb.append(this.zzni + 1);
        sb.append(" column ");
        sb.append((this.pos - this.zznj) + 1);
        sb.append(" path ");
        StringBuilder sb2 = new StringBuilder("$");
        int i = this.zznp;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.zzno[i2];
            if (i3 == 1 || i3 == 2) {
                sb2.append('[');
                sb2.append(this.zznr[i2]);
                sb2.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb2.append('.');
                String[] strArr = this.zznq;
                if (strArr[i2] != null) {
                    sb2.append(strArr[i2]);
                }
            }
        }
        sb.append(sb2.toString());
        return sb.toString();
    }

    private final char zzee() throws IOException {
        int i;
        int i2;
        if (this.pos != this.limit || zzp(1)) {
            char[] cArr = this.zznh;
            int i3 = this.pos;
            this.pos = i3 + 1;
            char c2 = cArr[i3];
            if (c2 == 10) {
                this.zzni++;
                this.zznj = this.pos;
            } else if (!(c2 == '\"' || c2 == '\'' || c2 == '/' || c2 == '\\')) {
                if (c2 == 'b') {
                    return 8;
                }
                if (c2 == 'f') {
                    return 12;
                }
                if (c2 == 'n') {
                    return 10;
                }
                if (c2 == 'r') {
                    return 13;
                }
                if (c2 == 't') {
                    return 9;
                }
                if (c2 != 'u') {
                    throw zzbe("Invalid escape sequence");
                } else if (this.pos + 4 <= this.limit || zzp(4)) {
                    char c3 = 0;
                    int i4 = this.pos;
                    int i5 = i4 + 4;
                    while (i4 < i5) {
                        char c4 = this.zznh[i4];
                        char c5 = (char) (c3 << 4);
                        if (c4 < '0' || c4 > '9') {
                            if (c4 >= 'a' && c4 <= 'f') {
                                i = c4 - 'a';
                            } else if (c4 < 'A' || c4 > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.zznh, this.pos, 4));
                            } else {
                                i = c4 - 'A';
                            }
                            i2 = i + 10;
                        } else {
                            i2 = c4 - '0';
                        }
                        c3 = (char) (c5 + i2);
                        i4++;
                    }
                    this.pos += 4;
                    return c3;
                } else {
                    throw zzbe("Unterminated escape sequence");
                }
            }
            return c2;
        }
        throw zzbe("Unterminated escape sequence");
    }

    private final IOException zzbe(String str) throws IOException {
        throw new zzfn(str + zzed());
    }

    static {
        zzfk.zzns = new zzfm();
    }
}
