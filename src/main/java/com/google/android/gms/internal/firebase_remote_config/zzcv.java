package com.google.android.gms.internal.firebase_remote_config;

public abstract class zzcv extends zzcr {
    /* access modifiers changed from: protected */
    public abstract int zza(CharSequence charSequence, int i, int i2);

    /* access modifiers changed from: protected */
    public abstract char[] zzj(int i);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: char} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zza(java.lang.String r13, int r14) {
        /*
            r12 = this;
            int r0 = r13.length()
            char[] r1 = com.google.android.gms.internal.firebase_remote_config.zzct.zzcd()
            r2 = 0
            r4 = r1
            r1 = 0
            r3 = 0
        L_0x000c:
            if (r14 >= r0) goto L_0x00d0
            if (r14 >= r0) goto L_0x00c8
            int r5 = r14 + 1
            char r6 = r13.charAt(r14)
            r7 = 55296(0xd800, float:7.7486E-41)
            r8 = 1
            if (r6 < r7) goto L_0x0089
            r7 = 57343(0xdfff, float:8.0355E-41)
            if (r6 <= r7) goto L_0x0022
            goto L_0x0089
        L_0x0022:
            r7 = 56319(0xdbff, float:7.892E-41)
            java.lang.String r9 = " at index "
            java.lang.String r10 = "' with value "
            if (r6 > r7) goto L_0x0063
            if (r5 != r0) goto L_0x002f
            int r6 = -r6
            goto L_0x0089
        L_0x002f:
            char r7 = r13.charAt(r5)
            boolean r11 = java.lang.Character.isLowSurrogate(r7)
            if (r11 == 0) goto L_0x003e
            int r6 = java.lang.Character.toCodePoint(r6, r7)
            goto L_0x0089
        L_0x003e:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            r14 = 83
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r14)
            java.lang.String r14 = "Expected low surrogate but got char '"
            r0.append(r14)
            r0.append(r7)
            r0.append(r10)
            r0.append(r7)
            r0.append(r9)
            r0.append(r5)
            java.lang.String r14 = r0.toString()
            r13.<init>(r14)
            throw r13
        L_0x0063:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            int r5 = r5 - r8
            r14 = 82
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r14)
            java.lang.String r14 = "Unexpected low surrogate character '"
            r0.append(r14)
            r0.append(r6)
            r0.append(r10)
            r0.append(r6)
            r0.append(r9)
            r0.append(r5)
            java.lang.String r14 = r0.toString()
            r13.<init>(r14)
            throw r13
        L_0x0089:
            if (r6 < 0) goto L_0x00c0
            char[] r5 = r12.zzj(r6)
            boolean r6 = java.lang.Character.isSupplementaryCodePoint(r6)
            if (r6 == 0) goto L_0x0096
            r8 = 2
        L_0x0096:
            int r8 = r8 + r14
            if (r5 == 0) goto L_0x00ba
            int r6 = r14 - r1
            int r7 = r3 + r6
            int r9 = r5.length
            int r9 = r9 + r7
            int r10 = r4.length
            if (r10 >= r9) goto L_0x00aa
            int r9 = r9 + r0
            int r9 = r9 - r14
            int r9 = r9 + 32
            char[] r4 = zza((char[]) r4, (int) r3, (int) r9)
        L_0x00aa:
            if (r6 <= 0) goto L_0x00b0
            r13.getChars(r1, r14, r4, r3)
            r3 = r7
        L_0x00b0:
            int r14 = r5.length
            if (r14 <= 0) goto L_0x00b9
            int r14 = r5.length
            java.lang.System.arraycopy(r5, r2, r4, r3, r14)
            int r14 = r5.length
            int r3 = r3 + r14
        L_0x00b9:
            r1 = r8
        L_0x00ba:
            int r14 = r12.zza((java.lang.CharSequence) r13, (int) r8, (int) r0)
            goto L_0x000c
        L_0x00c0:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "Trailing high surrogate at end of input"
            r13.<init>(r14)
            throw r13
        L_0x00c8:
            java.lang.IndexOutOfBoundsException r13 = new java.lang.IndexOutOfBoundsException
            java.lang.String r14 = "Index exceeds specified range"
            r13.<init>(r14)
            throw r13
        L_0x00d0:
            int r14 = r0 - r1
            if (r14 <= 0) goto L_0x00e0
            int r14 = r14 + r3
            int r5 = r4.length
            if (r5 >= r14) goto L_0x00dc
            char[] r4 = zza((char[]) r4, (int) r3, (int) r14)
        L_0x00dc:
            r13.getChars(r1, r0, r4, r3)
            goto L_0x00e1
        L_0x00e0:
            r14 = r3
        L_0x00e1:
            java.lang.String r13 = new java.lang.String
            r13.<init>(r4, r2, r14)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzcv.zza(java.lang.String, int):java.lang.String");
    }

    private static char[] zza(char[] cArr, int i, int i2) {
        char[] cArr2 = new char[i2];
        if (i > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i);
        }
        return cArr2;
    }
}
