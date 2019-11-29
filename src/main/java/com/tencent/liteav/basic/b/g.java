package com.tencent.liteav.basic.b;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f31253a = "#PART#".getBytes();

    public static byte[] a(byte[] bArr, byte[] bArr2) throws Exception {
        PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bArr2));
        Cipher instance = Cipher.getInstance("RSA/None/PKCS1Padding");
        instance.init(2, generatePrivate);
        return instance.doFinal(bArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0089 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] b(byte[] r12, byte[] r13) throws java.lang.Exception {
        /*
            byte[] r0 = f31253a
            int r0 = r0.length
            if (r0 > 0) goto L_0x000a
            byte[] r12 = a(r12, r13)
            return r12
        L_0x000a:
            int r1 = r12.length
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3)
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x0015:
            if (r4 >= r1) goto L_0x008b
            byte r6 = r12[r4]
            int r7 = r1 + -1
            r8 = 1
            if (r4 != r7) goto L_0x003f
            int r6 = r1 - r5
            byte[] r6 = new byte[r6]
            int r7 = r6.length
            java.lang.System.arraycopy(r12, r5, r6, r3, r7)
            byte[] r5 = a(r6, r13)
            int r6 = r5.length
            r7 = 0
        L_0x002c:
            if (r7 >= r6) goto L_0x003a
            byte r9 = r5[r7]
            java.lang.Byte r9 = java.lang.Byte.valueOf(r9)
            r2.add(r9)
            int r7 = r7 + 1
            goto L_0x002c
        L_0x003a:
            int r5 = r4 + r0
            int r4 = r5 + -1
            goto L_0x0064
        L_0x003f:
            byte[] r7 = f31253a
            byte r7 = r7[r3]
            if (r6 != r7) goto L_0x0064
            if (r0 <= r8) goto L_0x0062
            int r6 = r4 + r0
            if (r6 >= r1) goto L_0x0064
            r6 = 1
            r7 = 0
        L_0x004d:
            if (r6 >= r0) goto L_0x0065
            byte[] r9 = f31253a
            byte r9 = r9[r6]
            int r10 = r4 + r6
            byte r10 = r12[r10]
            if (r9 == r10) goto L_0x005a
            goto L_0x0065
        L_0x005a:
            int r9 = r0 + -1
            if (r6 != r9) goto L_0x005f
            r7 = 1
        L_0x005f:
            int r6 = r6 + 1
            goto L_0x004d
        L_0x0062:
            r7 = 1
            goto L_0x0065
        L_0x0064:
            r7 = 0
        L_0x0065:
            if (r7 == 0) goto L_0x0089
            int r6 = r4 - r5
            byte[] r6 = new byte[r6]
            int r7 = r6.length
            java.lang.System.arraycopy(r12, r5, r6, r3, r7)
            byte[] r5 = a(r6, r13)
            int r6 = r5.length
            r7 = 0
        L_0x0075:
            if (r7 >= r6) goto L_0x0083
            byte r9 = r5[r7]
            java.lang.Byte r9 = java.lang.Byte.valueOf(r9)
            r2.add(r9)
            int r7 = r7 + 1
            goto L_0x0075
        L_0x0083:
            int r4 = r4 + r0
            int r5 = r4 + -1
            r11 = r5
            r5 = r4
            r4 = r11
        L_0x0089:
            int r4 = r4 + r8
            goto L_0x0015
        L_0x008b:
            int r12 = r2.size()
            byte[] r12 = new byte[r12]
            java.util.Iterator r13 = r2.iterator()
        L_0x0095:
            boolean r0 = r13.hasNext()
            if (r0 == 0) goto L_0x00ab
            java.lang.Object r0 = r13.next()
            java.lang.Byte r0 = (java.lang.Byte) r0
            int r1 = r3 + 1
            byte r0 = r0.byteValue()
            r12[r3] = r0
            r3 = r1
            goto L_0x0095
        L_0x00ab:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.basic.b.g.b(byte[], byte[]):byte[]");
    }
}
