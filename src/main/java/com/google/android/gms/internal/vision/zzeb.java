package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzcr;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;
import tencent.tls.platform.SigType;

final class zzeb<T> implements zzen<T> {
    private static final int[] zznc = new int[0];
    private static final Unsafe zznd = zzfl.zzdz();
    private final int[] zzne;
    private final Object[] zznf;
    private final int zzng;
    private final int zznh;
    private final zzdx zzni;
    private final boolean zznj;
    private final boolean zznk;
    private final boolean zznl;
    private final boolean zznm;
    private final int[] zznn;
    private final int zzno;
    private final int zznp;
    private final zzef zznq;
    private final zzdh zznr;
    private final zzff<?, ?> zzns;
    private final zzcg<?> zznt;
    private final zzds zznu;

    private zzeb(int[] iArr, Object[] objArr, int i, int i2, zzdx zzdx, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzef zzef, zzdh zzdh, zzff<?, ?> zzff, zzcg<?> zzcg, zzds zzds) {
        this.zzne = iArr;
        this.zznf = objArr;
        this.zzng = i;
        this.zznh = i2;
        this.zznk = zzdx instanceof zzcr;
        this.zznl = z;
        this.zznj = zzcg != null && zzcg.zze(zzdx);
        this.zznm = false;
        this.zznn = iArr2;
        this.zzno = i3;
        this.zznp = i4;
        this.zznq = zzef;
        this.zznr = zzdh;
        this.zzns = zzff;
        this.zznt = zzcg;
        this.zzni = zzdx;
        this.zznu = zzds;
    }

    private static int zza(int i, byte[] bArr, int i2, int i3, Object obj, zzbl zzbl) throws IOException {
        return zzbk.zza(i, bArr, i2, i3, zzo(obj), zzbl);
    }

    private static int zza(zzen<?> zzen, int i, byte[] bArr, int i2, int i3, zzcw<?> zzcw, zzbl zzbl) throws IOException {
        int zza = zza((zzen) zzen, bArr, i2, i3, zzbl);
        while (true) {
            zzcw.add(zzbl.zzgq);
            if (zza >= i3) {
                break;
            }
            int zza2 = zzbk.zza(bArr, zza, zzbl);
            if (i != zzbl.zzgo) {
                break;
            }
            zza = zza((zzen) zzen, bArr, zza2, i3, zzbl);
        }
        return zza;
    }

    private static int zza(zzen zzen, byte[] bArr, int i, int i2, int i3, zzbl zzbl) throws IOException {
        zzeb zzeb = (zzeb) zzen;
        Object newInstance = zzeb.newInstance();
        int zza = zzeb.zza(newInstance, bArr, i, i2, i3, zzbl);
        zzeb.zzd(newInstance);
        zzbl.zzgq = newInstance;
        return zza;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zza(com.google.android.gms.internal.vision.zzen r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.vision.zzbl r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = com.google.android.gms.internal.vision.zzbk.zza((int) r8, (byte[]) r7, (int) r0, (com.google.android.gms.internal.vision.zzbl) r10)
            int r8 = r10.zzgo
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.newInstance()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.zza(r1, r2, r3, r4, r5)
            r6.zzd(r9)
            r10.zzgq = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.vision.zzcx r6 = com.google.android.gms.internal.vision.zzcx.zzcb()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzeb.zza(com.google.android.gms.internal.vision.zzen, byte[], int, int, com.google.android.gms.internal.vision.zzbl):int");
    }

    private static <UT, UB> int zza(zzff<UT, UB> zzff, T t) {
        return zzff.zzn(zzff.zzr(t));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b9, code lost:
        r2 = r2 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0143, code lost:
        r3 = java.lang.Integer.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0150, code lost:
        r3 = java.lang.Long.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0154, code lost:
        r12.putObject(r1, r9, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0162, code lost:
        r12.putObject(r1, r9, r2);
        r2 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0173, code lost:
        r12.putObject(r1, r9, r2);
        r2 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0178, code lost:
        r12.putInt(r1, r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, com.google.android.gms.internal.vision.zzbl r29) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r2 = r21
            r8 = r22
            r5 = r23
            r9 = r26
            r6 = r28
            r11 = r29
            sun.misc.Unsafe r12 = zznd
            int[] r7 = r0.zzne
            int r13 = r6 + 2
            r7 = r7[r13]
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r13
            long r13 = (long) r7
            r7 = 5
            r15 = 2
            switch(r25) {
                case 51: goto L_0x0168;
                case 52: goto L_0x0158;
                case 53: goto L_0x0148;
                case 54: goto L_0x0148;
                case 55: goto L_0x013b;
                case 56: goto L_0x012f;
                case 57: goto L_0x0124;
                case 58: goto L_0x010e;
                case 59: goto L_0x00e2;
                case 60: goto L_0x00bc;
                case 61: goto L_0x00a4;
                case 62: goto L_0x013b;
                case 63: goto L_0x0076;
                case 64: goto L_0x0124;
                case 65: goto L_0x012f;
                case 66: goto L_0x0068;
                case 67: goto L_0x005a;
                case 68: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x017c
        L_0x0028:
            r7 = 3
            if (r5 != r7) goto L_0x017c
            r2 = r2 & -8
            r7 = r2 | 4
            com.google.android.gms.internal.vision.zzen r2 = r0.zzag(r6)
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r7
            r7 = r29
            int r2 = zza((com.google.android.gms.internal.vision.zzen) r2, (byte[]) r3, (int) r4, (int) r5, (int) r6, (com.google.android.gms.internal.vision.zzbl) r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004b
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004c
        L_0x004b:
            r15 = 0
        L_0x004c:
            if (r15 != 0) goto L_0x0052
            java.lang.Object r3 = r11.zzgq
            goto L_0x0154
        L_0x0052:
            java.lang.Object r3 = r11.zzgq
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzct.zza((java.lang.Object) r15, (java.lang.Object) r3)
            goto L_0x0154
        L_0x005a:
            if (r5 != 0) goto L_0x017c
            int r2 = com.google.android.gms.internal.vision.zzbk.zzb(r3, r4, r11)
            long r3 = r11.zzgp
            long r3 = com.google.android.gms.internal.vision.zzbx.zza(r3)
            goto L_0x0150
        L_0x0068:
            if (r5 != 0) goto L_0x017c
            int r2 = com.google.android.gms.internal.vision.zzbk.zza(r3, r4, r11)
            int r3 = r11.zzgo
            int r3 = com.google.android.gms.internal.vision.zzbx.zzo(r3)
            goto L_0x0143
        L_0x0076:
            if (r5 != 0) goto L_0x017c
            int r3 = com.google.android.gms.internal.vision.zzbk.zza(r3, r4, r11)
            int r4 = r11.zzgo
            com.google.android.gms.internal.vision.zzcv r5 = r0.zzai(r6)
            if (r5 == 0) goto L_0x009a
            com.google.android.gms.internal.vision.zzcu r5 = r5.zzaf(r4)
            if (r5 == 0) goto L_0x008b
            goto L_0x009a
        L_0x008b:
            com.google.android.gms.internal.vision.zzfg r1 = zzo(r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.zzb(r2, r4)
            r2 = r3
            goto L_0x017d
        L_0x009a:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r2 = r3
            goto L_0x0178
        L_0x00a4:
            if (r5 != r15) goto L_0x017c
            int r2 = com.google.android.gms.internal.vision.zzbk.zza(r3, r4, r11)
            int r4 = r11.zzgo
            if (r4 != 0) goto L_0x00b2
            com.google.android.gms.internal.vision.zzbo r3 = com.google.android.gms.internal.vision.zzbo.zzgt
            goto L_0x0154
        L_0x00b2:
            com.google.android.gms.internal.vision.zzbo r3 = com.google.android.gms.internal.vision.zzbo.zzb((byte[]) r3, (int) r2, (int) r4)
            r12.putObject(r1, r9, r3)
        L_0x00b9:
            int r2 = r2 + r4
            goto L_0x0178
        L_0x00bc:
            if (r5 != r15) goto L_0x017c
            com.google.android.gms.internal.vision.zzen r2 = r0.zzag(r6)
            r5 = r20
            int r2 = zza((com.google.android.gms.internal.vision.zzen) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.vision.zzbl) r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00d3
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00d4
        L_0x00d3:
            r15 = 0
        L_0x00d4:
            if (r15 != 0) goto L_0x00da
            java.lang.Object r3 = r11.zzgq
            goto L_0x0154
        L_0x00da:
            java.lang.Object r3 = r11.zzgq
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzct.zza((java.lang.Object) r15, (java.lang.Object) r3)
            goto L_0x0154
        L_0x00e2:
            if (r5 != r15) goto L_0x017c
            int r2 = com.google.android.gms.internal.vision.zzbk.zza(r3, r4, r11)
            int r4 = r11.zzgo
            if (r4 != 0) goto L_0x00ef
            java.lang.String r3 = ""
            goto L_0x0154
        L_0x00ef:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x0103
            int r5 = r2 + r4
            boolean r5 = com.google.android.gms.internal.vision.zzfn.zze(r3, r2, r5)
            if (r5 == 0) goto L_0x00fe
            goto L_0x0103
        L_0x00fe:
            com.google.android.gms.internal.vision.zzcx r1 = com.google.android.gms.internal.vision.zzcx.zzcg()
            throw r1
        L_0x0103:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.vision.zzct.UTF_8
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            goto L_0x00b9
        L_0x010e:
            if (r5 != 0) goto L_0x017c
            int r2 = com.google.android.gms.internal.vision.zzbk.zzb(r3, r4, r11)
            long r3 = r11.zzgp
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x011e
            r15 = 1
            goto L_0x011f
        L_0x011e:
            r15 = 0
        L_0x011f:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)
            goto L_0x0154
        L_0x0124:
            if (r5 != r7) goto L_0x017c
            int r2 = com.google.android.gms.internal.vision.zzbk.zza(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0162
        L_0x012f:
            r2 = 1
            if (r5 != r2) goto L_0x017c
            long r2 = com.google.android.gms.internal.vision.zzbk.zzb(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            goto L_0x0173
        L_0x013b:
            if (r5 != 0) goto L_0x017c
            int r2 = com.google.android.gms.internal.vision.zzbk.zza(r3, r4, r11)
            int r3 = r11.zzgo
        L_0x0143:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0154
        L_0x0148:
            if (r5 != 0) goto L_0x017c
            int r2 = com.google.android.gms.internal.vision.zzbk.zzb(r3, r4, r11)
            long r3 = r11.zzgp
        L_0x0150:
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
        L_0x0154:
            r12.putObject(r1, r9, r3)
            goto L_0x0178
        L_0x0158:
            if (r5 != r7) goto L_0x017c
            float r2 = com.google.android.gms.internal.vision.zzbk.zzd(r18, r19)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
        L_0x0162:
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 4
            goto L_0x0178
        L_0x0168:
            r2 = 1
            if (r5 != r2) goto L_0x017c
            double r2 = com.google.android.gms.internal.vision.zzbk.zzc(r18, r19)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
        L_0x0173:
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 8
        L_0x0178:
            r12.putInt(r1, r13, r8)
            goto L_0x017d
        L_0x017c:
            r2 = r4
        L_0x017d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzeb.zza(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.android.gms.internal.vision.zzbl):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0260, code lost:
        if (r7.zzgp != 0) goto L_0x0262;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0262, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0264, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0265, code lost:
        r11.addBoolean(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0268, code lost:
        if (r4 >= r5) goto L_0x03c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x026a, code lost:
        r6 = com.google.android.gms.internal.vision.zzbk.zza(r3, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0270, code lost:
        if (r2 != r7.zzgo) goto L_0x03c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0272, code lost:
        r4 = com.google.android.gms.internal.vision.zzbk.zzb(r3, r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x027a, code lost:
        if (r7.zzgp == 0) goto L_0x0264;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:?, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x013c, code lost:
        if (r4 == 0) goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x013e, code lost:
        r11.add(com.google.android.gms.internal.vision.zzbo.zzgt);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0144, code lost:
        r11.add(com.google.android.gms.internal.vision.zzbo.zzb(r3, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x014c, code lost:
        if (r1 >= r5) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x014e, code lost:
        r4 = com.google.android.gms.internal.vision.zzbk.zza(r3, r1, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (r2 != r7.zzgo) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0156, code lost:
        r1 = com.google.android.gms.internal.vision.zzbk.zza(r3, r4, r7);
        r4 = r7.zzgo;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x015c, code lost:
        if (r4 < 0) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x015e, code lost:
        if (r4 != 0) goto L_0x0144;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0165, code lost:
        throw com.google.android.gms.internal.vision.zzcx.zzcc();
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.vision.zzbl r30) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r2 = r21
            r6 = r23
            r8 = r24
            r9 = r28
            r7 = r30
            sun.misc.Unsafe r11 = zznd
            java.lang.Object r11 = r11.getObject(r1, r9)
            com.google.android.gms.internal.vision.zzcw r11 = (com.google.android.gms.internal.vision.zzcw) r11
            boolean r12 = r11.zzan()
            r13 = 1
            if (r12 != 0) goto L_0x0036
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002c
            r12 = 10
            goto L_0x002d
        L_0x002c:
            int r12 = r12 << r13
        L_0x002d:
            com.google.android.gms.internal.vision.zzcw r11 = r11.zzk(r12)
            sun.misc.Unsafe r12 = zznd
            r12.putObject(r1, r9, r11)
        L_0x0036:
            r9 = 5
            r14 = 0
            r10 = 2
            switch(r27) {
                case 18: goto L_0x038b;
                case 19: goto L_0x034d;
                case 20: goto L_0x0315;
                case 21: goto L_0x0315;
                case 22: goto L_0x02fb;
                case 23: goto L_0x02bc;
                case 24: goto L_0x027d;
                case 25: goto L_0x022c;
                case 26: goto L_0x0185;
                case 27: goto L_0x016b;
                case 28: goto L_0x0132;
                case 29: goto L_0x02fb;
                case 30: goto L_0x00fa;
                case 31: goto L_0x027d;
                case 32: goto L_0x02bc;
                case 33: goto L_0x00ba;
                case 34: goto L_0x007a;
                case 35: goto L_0x038b;
                case 36: goto L_0x034d;
                case 37: goto L_0x0315;
                case 38: goto L_0x0315;
                case 39: goto L_0x02fb;
                case 40: goto L_0x02bc;
                case 41: goto L_0x027d;
                case 42: goto L_0x022c;
                case 43: goto L_0x02fb;
                case 44: goto L_0x00fa;
                case 45: goto L_0x027d;
                case 46: goto L_0x02bc;
                case 47: goto L_0x00ba;
                case 48: goto L_0x007a;
                case 49: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x03c9
        L_0x003f:
            r1 = 3
            if (r6 != r1) goto L_0x03c9
            com.google.android.gms.internal.vision.zzen r1 = r0.zzag(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r22 = r1
            r23 = r18
            r24 = r19
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = zza((com.google.android.gms.internal.vision.zzen) r22, (byte[]) r23, (int) r24, (int) r25, (int) r26, (com.google.android.gms.internal.vision.zzbl) r27)
        L_0x005a:
            java.lang.Object r8 = r7.zzgq
            r11.add(r8)
            if (r4 >= r5) goto L_0x03c9
            int r8 = com.google.android.gms.internal.vision.zzbk.zza(r3, r4, r7)
            int r9 = r7.zzgo
            if (r2 != r9) goto L_0x03c9
            r22 = r1
            r23 = r18
            r24 = r8
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = zza((com.google.android.gms.internal.vision.zzen) r22, (byte[]) r23, (int) r24, (int) r25, (int) r26, (com.google.android.gms.internal.vision.zzbl) r27)
            goto L_0x005a
        L_0x007a:
            if (r6 != r10) goto L_0x009e
            com.google.android.gms.internal.vision.zzdl r11 = (com.google.android.gms.internal.vision.zzdl) r11
            int r1 = com.google.android.gms.internal.vision.zzbk.zza(r3, r4, r7)
            int r2 = r7.zzgo
            int r2 = r2 + r1
        L_0x0085:
            if (r1 >= r2) goto L_0x0095
            int r1 = com.google.android.gms.internal.vision.zzbk.zzb(r3, r1, r7)
            long r4 = r7.zzgp
            long r4 = com.google.android.gms.internal.vision.zzbx.zza(r4)
            r11.zzl(r4)
            goto L_0x0085
        L_0x0095:
            if (r1 != r2) goto L_0x0099
            goto L_0x03ca
        L_0x0099:
            com.google.android.gms.internal.vision.zzcx r1 = com.google.android.gms.internal.vision.zzcx.zzcb()
            throw r1
        L_0x009e:
            if (r6 != 0) goto L_0x03c9
            com.google.android.gms.internal.vision.zzdl r11 = (com.google.android.gms.internal.vision.zzdl) r11
        L_0x00a2:
            int r1 = com.google.android.gms.internal.vision.zzbk.zzb(r3, r4, r7)
            long r8 = r7.zzgp
            long r8 = com.google.android.gms.internal.vision.zzbx.zza(r8)
            r11.zzl(r8)
            if (r1 >= r5) goto L_0x03ca
            int r4 = com.google.android.gms.internal.vision.zzbk.zza(r3, r1, r7)
            int r6 = r7.zzgo
            if (r2 != r6) goto L_0x03ca
            goto L_0x00a2
        L_0x00ba:
            if (r6 != r10) goto L_0x00de
            com.google.android.gms.internal.vision.zzcs r11 = (com.google.android.gms.internal.vision.zzcs) r11
            int r1 = com.google.android.gms.internal.vision.zzbk.zza(r3, r4, r7)
            int r2 = r7.zzgo
            int r2 = r2 + r1
        L_0x00c5:
            if (r1 >= r2) goto L_0x00d5
            int r1 = com.google.android.gms.internal.vision.zzbk.zza(r3, r1, r7)
            int r4 = r7.zzgo
            int r4 = com.google.android.gms.internal.vision.zzbx.zzo(r4)
            r11.zzae(r4)
            goto L_0x00c5
        L_0x00d5:
            if (r1 != r2) goto L_0x00d9
            goto L_0x03ca
        L_0x00d9:
            com.google.android.gms.internal.vision.zzcx r1 = com.google.android.gms.internal.vision.zzcx.zzcb()
            throw r1
        L_0x00de:
            if (r6 != 0) goto L_0x03c9
            com.google.android.gms.internal.vision.zzcs r11 = (com.google.android.gms.internal.vision.zzcs) r11
        L_0x00e2:
            int r1 = com.google.android.gms.internal.vision.zzbk.zza(r3, r4, r7)
            int r4 = r7.zzgo
            int r4 = com.google.android.gms.internal.vision.zzbx.zzo(r4)
            r11.zzae(r4)
            if (r1 >= r5) goto L_0x03ca
            int r4 = com.google.android.gms.internal.vision.zzbk.zza(r3, r1, r7)
            int r6 = r7.zzgo
            if (r2 != r6) goto L_0x03ca
            goto L_0x00e2
        L_0x00fa:
            if (r6 != r10) goto L_0x0101
            int r2 = com.google.android.gms.internal.vision.zzbk.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.vision.zzcw<?>) r11, (com.google.android.gms.internal.vision.zzbl) r7)
            goto L_0x0112
        L_0x0101:
            if (r6 != 0) goto L_0x03c9
            r2 = r21
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r11
            r7 = r30
            int r2 = com.google.android.gms.internal.vision.zzbk.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.vision.zzcw<?>) r6, (com.google.android.gms.internal.vision.zzbl) r7)
        L_0x0112:
            com.google.android.gms.internal.vision.zzcr r1 = (com.google.android.gms.internal.vision.zzcr) r1
            com.google.android.gms.internal.vision.zzfg r3 = r1.zzkr
            com.google.android.gms.internal.vision.zzfg r4 = com.google.android.gms.internal.vision.zzfg.zzdu()
            if (r3 != r4) goto L_0x011d
            r3 = 0
        L_0x011d:
            com.google.android.gms.internal.vision.zzcv r4 = r0.zzai(r8)
            com.google.android.gms.internal.vision.zzff<?, ?> r5 = r0.zzns
            r6 = r22
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzep.zza(r6, r11, r4, r3, r5)
            com.google.android.gms.internal.vision.zzfg r3 = (com.google.android.gms.internal.vision.zzfg) r3
            if (r3 == 0) goto L_0x012f
            r1.zzkr = r3
        L_0x012f:
            r1 = r2
            goto L_0x03ca
        L_0x0132:
            if (r6 != r10) goto L_0x03c9
            int r1 = com.google.android.gms.internal.vision.zzbk.zza(r3, r4, r7)
            int r4 = r7.zzgo
            if (r4 < 0) goto L_0x0166
            if (r4 != 0) goto L_0x0144
        L_0x013e:
            com.google.android.gms.internal.vision.zzbo r4 = com.google.android.gms.internal.vision.zzbo.zzgt
            r11.add(r4)
            goto L_0x014c
        L_0x0144:
            com.google.android.gms.internal.vision.zzbo r6 = com.google.android.gms.internal.vision.zzbo.zzb((byte[]) r3, (int) r1, (int) r4)
            r11.add(r6)
            int r1 = r1 + r4
        L_0x014c:
            if (r1 >= r5) goto L_0x03ca
            int r4 = com.google.android.gms.internal.vision.zzbk.zza(r3, r1, r7)
            int r6 = r7.zzgo
            if (r2 != r6) goto L_0x03ca
            int r1 = com.google.android.gms.internal.vision.zzbk.zza(r3, r4, r7)
            int r4 = r7.zzgo
            if (r4 < 0) goto L_0x0161
            if (r4 != 0) goto L_0x0144
            goto L_0x013e
        L_0x0161:
            com.google.android.gms.internal.vision.zzcx r1 = com.google.android.gms.internal.vision.zzcx.zzcc()
            throw r1
        L_0x0166:
            com.google.android.gms.internal.vision.zzcx r1 = com.google.android.gms.internal.vision.zzcx.zzcc()
            throw r1
        L_0x016b:
            if (r6 != r10) goto L_0x03c9
            com.google.android.gms.internal.vision.zzen r1 = r0.zzag(r8)
            r22 = r1
            r23 = r21
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r11
            r28 = r30
            int r1 = zza((com.google.android.gms.internal.vision.zzen<?>) r22, (int) r23, (byte[]) r24, (int) r25, (int) r26, (com.google.android.gms.internal.vision.zzcw<?>) r27, (com.google.android.gms.internal.vision.zzbl) r28)
            goto L_0x03ca
        L_0x0185:
            if (r6 != r10) goto L_0x03c9
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r25 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 != 0) goto L_0x01d2
            int r4 = com.google.android.gms.internal.vision.zzbk.zza(r3, r4, r7)
            int r6 = r7.zzgo
            if (r6 < 0) goto L_0x01cd
            if (r6 != 0) goto L_0x01a0
        L_0x019c:
            r11.add(r1)
            goto L_0x01ab
        L_0x01a0:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.vision.zzct.UTF_8
            r8.<init>(r3, r4, r6, r9)
        L_0x01a7:
            r11.add(r8)
            int r4 = r4 + r6
        L_0x01ab:
            if (r4 >= r5) goto L_0x03c9
            int r6 = com.google.android.gms.internal.vision.zzbk.zza(r3, r4, r7)
            int r8 = r7.zzgo
            if (r2 != r8) goto L_0x03c9
            int r4 = com.google.android.gms.internal.vision.zzbk.zza(r3, r6, r7)
            int r6 = r7.zzgo
            if (r6 < 0) goto L_0x01c8
            if (r6 != 0) goto L_0x01c0
            goto L_0x019c
        L_0x01c0:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.vision.zzct.UTF_8
            r8.<init>(r3, r4, r6, r9)
            goto L_0x01a7
        L_0x01c8:
            com.google.android.gms.internal.vision.zzcx r1 = com.google.android.gms.internal.vision.zzcx.zzcc()
            throw r1
        L_0x01cd:
            com.google.android.gms.internal.vision.zzcx r1 = com.google.android.gms.internal.vision.zzcx.zzcc()
            throw r1
        L_0x01d2:
            int r4 = com.google.android.gms.internal.vision.zzbk.zza(r3, r4, r7)
            int r6 = r7.zzgo
            if (r6 < 0) goto L_0x0227
            if (r6 != 0) goto L_0x01e0
        L_0x01dc:
            r11.add(r1)
            goto L_0x01f3
        L_0x01e0:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.vision.zzfn.zze(r3, r4, r8)
            if (r9 == 0) goto L_0x0222
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.vision.zzct.UTF_8
            r9.<init>(r3, r4, r6, r10)
        L_0x01ef:
            r11.add(r9)
            r4 = r8
        L_0x01f3:
            if (r4 >= r5) goto L_0x03c9
            int r6 = com.google.android.gms.internal.vision.zzbk.zza(r3, r4, r7)
            int r8 = r7.zzgo
            if (r2 != r8) goto L_0x03c9
            int r4 = com.google.android.gms.internal.vision.zzbk.zza(r3, r6, r7)
            int r6 = r7.zzgo
            if (r6 < 0) goto L_0x021d
            if (r6 != 0) goto L_0x0208
            goto L_0x01dc
        L_0x0208:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.vision.zzfn.zze(r3, r4, r8)
            if (r9 == 0) goto L_0x0218
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.vision.zzct.UTF_8
            r9.<init>(r3, r4, r6, r10)
            goto L_0x01ef
        L_0x0218:
            com.google.android.gms.internal.vision.zzcx r1 = com.google.android.gms.internal.vision.zzcx.zzcg()
            throw r1
        L_0x021d:
            com.google.android.gms.internal.vision.zzcx r1 = com.google.android.gms.internal.vision.zzcx.zzcc()
            throw r1
        L_0x0222:
            com.google.android.gms.internal.vision.zzcx r1 = com.google.android.gms.internal.vision.zzcx.zzcg()
            throw r1
        L_0x0227:
            com.google.android.gms.internal.vision.zzcx r1 = com.google.android.gms.internal.vision.zzcx.zzcc()
            throw r1
        L_0x022c:
            r1 = 0
            if (r6 != r10) goto L_0x0254
            com.google.android.gms.internal.vision.zzbm r11 = (com.google.android.gms.internal.vision.zzbm) r11
            int r2 = com.google.android.gms.internal.vision.zzbk.zza(r3, r4, r7)
            int r4 = r7.zzgo
            int r4 = r4 + r2
        L_0x0238:
            if (r2 >= r4) goto L_0x024b
            int r2 = com.google.android.gms.internal.vision.zzbk.zzb(r3, r2, r7)
            long r5 = r7.zzgp
            int r8 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x0246
            r5 = 1
            goto L_0x0247
        L_0x0246:
            r5 = 0
        L_0x0247:
            r11.addBoolean(r5)
            goto L_0x0238
        L_0x024b:
            if (r2 != r4) goto L_0x024f
            goto L_0x012f
        L_0x024f:
            com.google.android.gms.internal.vision.zzcx r1 = com.google.android.gms.internal.vision.zzcx.zzcb()
            throw r1
        L_0x0254:
            if (r6 != 0) goto L_0x03c9
            com.google.android.gms.internal.vision.zzbm r11 = (com.google.android.gms.internal.vision.zzbm) r11
            int r4 = com.google.android.gms.internal.vision.zzbk.zzb(r3, r4, r7)
            long r8 = r7.zzgp
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0264
        L_0x0262:
            r6 = 1
            goto L_0x0265
        L_0x0264:
            r6 = 0
        L_0x0265:
            r11.addBoolean(r6)
            if (r4 >= r5) goto L_0x03c9
            int r6 = com.google.android.gms.internal.vision.zzbk.zza(r3, r4, r7)
            int r8 = r7.zzgo
            if (r2 != r8) goto L_0x03c9
            int r4 = com.google.android.gms.internal.vision.zzbk.zzb(r3, r6, r7)
            long r8 = r7.zzgp
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0264
            goto L_0x0262
        L_0x027d:
            if (r6 != r10) goto L_0x029d
            com.google.android.gms.internal.vision.zzcs r11 = (com.google.android.gms.internal.vision.zzcs) r11
            int r1 = com.google.android.gms.internal.vision.zzbk.zza(r3, r4, r7)
            int r2 = r7.zzgo
            int r2 = r2 + r1
        L_0x0288:
            if (r1 >= r2) goto L_0x0294
            int r4 = com.google.android.gms.internal.vision.zzbk.zza(r3, r1)
            r11.zzae(r4)
            int r1 = r1 + 4
            goto L_0x0288
        L_0x0294:
            if (r1 != r2) goto L_0x0298
            goto L_0x03ca
        L_0x0298:
            com.google.android.gms.internal.vision.zzcx r1 = com.google.android.gms.internal.vision.zzcx.zzcb()
            throw r1
        L_0x029d:
            if (r6 != r9) goto L_0x03c9
            com.google.android.gms.internal.vision.zzcs r11 = (com.google.android.gms.internal.vision.zzcs) r11
            int r1 = com.google.android.gms.internal.vision.zzbk.zza(r18, r19)
            r11.zzae(r1)
        L_0x02a8:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03ca
            int r4 = com.google.android.gms.internal.vision.zzbk.zza(r3, r1, r7)
            int r6 = r7.zzgo
            if (r2 != r6) goto L_0x03ca
            int r1 = com.google.android.gms.internal.vision.zzbk.zza(r3, r4)
            r11.zzae(r1)
            goto L_0x02a8
        L_0x02bc:
            if (r6 != r10) goto L_0x02dc
            com.google.android.gms.internal.vision.zzdl r11 = (com.google.android.gms.internal.vision.zzdl) r11
            int r1 = com.google.android.gms.internal.vision.zzbk.zza(r3, r4, r7)
            int r2 = r7.zzgo
            int r2 = r2 + r1
        L_0x02c7:
            if (r1 >= r2) goto L_0x02d3
            long r4 = com.google.android.gms.internal.vision.zzbk.zzb(r3, r1)
            r11.zzl(r4)
            int r1 = r1 + 8
            goto L_0x02c7
        L_0x02d3:
            if (r1 != r2) goto L_0x02d7
            goto L_0x03ca
        L_0x02d7:
            com.google.android.gms.internal.vision.zzcx r1 = com.google.android.gms.internal.vision.zzcx.zzcb()
            throw r1
        L_0x02dc:
            if (r6 != r13) goto L_0x03c9
            com.google.android.gms.internal.vision.zzdl r11 = (com.google.android.gms.internal.vision.zzdl) r11
            long r8 = com.google.android.gms.internal.vision.zzbk.zzb(r18, r19)
            r11.zzl(r8)
        L_0x02e7:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x03ca
            int r4 = com.google.android.gms.internal.vision.zzbk.zza(r3, r1, r7)
            int r6 = r7.zzgo
            if (r2 != r6) goto L_0x03ca
            long r8 = com.google.android.gms.internal.vision.zzbk.zzb(r3, r4)
            r11.zzl(r8)
            goto L_0x02e7
        L_0x02fb:
            if (r6 != r10) goto L_0x0303
            int r1 = com.google.android.gms.internal.vision.zzbk.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.vision.zzcw<?>) r11, (com.google.android.gms.internal.vision.zzbl) r7)
            goto L_0x03ca
        L_0x0303:
            if (r6 != 0) goto L_0x03c9
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = com.google.android.gms.internal.vision.zzbk.zza((int) r21, (byte[]) r22, (int) r23, (int) r24, (com.google.android.gms.internal.vision.zzcw<?>) r25, (com.google.android.gms.internal.vision.zzbl) r26)
            goto L_0x03ca
        L_0x0315:
            if (r6 != r10) goto L_0x0335
            com.google.android.gms.internal.vision.zzdl r11 = (com.google.android.gms.internal.vision.zzdl) r11
            int r1 = com.google.android.gms.internal.vision.zzbk.zza(r3, r4, r7)
            int r2 = r7.zzgo
            int r2 = r2 + r1
        L_0x0320:
            if (r1 >= r2) goto L_0x032c
            int r1 = com.google.android.gms.internal.vision.zzbk.zzb(r3, r1, r7)
            long r4 = r7.zzgp
            r11.zzl(r4)
            goto L_0x0320
        L_0x032c:
            if (r1 != r2) goto L_0x0330
            goto L_0x03ca
        L_0x0330:
            com.google.android.gms.internal.vision.zzcx r1 = com.google.android.gms.internal.vision.zzcx.zzcb()
            throw r1
        L_0x0335:
            if (r6 != 0) goto L_0x03c9
            com.google.android.gms.internal.vision.zzdl r11 = (com.google.android.gms.internal.vision.zzdl) r11
        L_0x0339:
            int r1 = com.google.android.gms.internal.vision.zzbk.zzb(r3, r4, r7)
            long r8 = r7.zzgp
            r11.zzl(r8)
            if (r1 >= r5) goto L_0x03ca
            int r4 = com.google.android.gms.internal.vision.zzbk.zza(r3, r1, r7)
            int r6 = r7.zzgo
            if (r2 != r6) goto L_0x03ca
            goto L_0x0339
        L_0x034d:
            if (r6 != r10) goto L_0x036c
            com.google.android.gms.internal.vision.zzcp r11 = (com.google.android.gms.internal.vision.zzcp) r11
            int r1 = com.google.android.gms.internal.vision.zzbk.zza(r3, r4, r7)
            int r2 = r7.zzgo
            int r2 = r2 + r1
        L_0x0358:
            if (r1 >= r2) goto L_0x0364
            float r4 = com.google.android.gms.internal.vision.zzbk.zzd(r3, r1)
            r11.zze(r4)
            int r1 = r1 + 4
            goto L_0x0358
        L_0x0364:
            if (r1 != r2) goto L_0x0367
            goto L_0x03ca
        L_0x0367:
            com.google.android.gms.internal.vision.zzcx r1 = com.google.android.gms.internal.vision.zzcx.zzcb()
            throw r1
        L_0x036c:
            if (r6 != r9) goto L_0x03c9
            com.google.android.gms.internal.vision.zzcp r11 = (com.google.android.gms.internal.vision.zzcp) r11
            float r1 = com.google.android.gms.internal.vision.zzbk.zzd(r18, r19)
            r11.zze(r1)
        L_0x0377:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03ca
            int r4 = com.google.android.gms.internal.vision.zzbk.zza(r3, r1, r7)
            int r6 = r7.zzgo
            if (r2 != r6) goto L_0x03ca
            float r1 = com.google.android.gms.internal.vision.zzbk.zzd(r3, r4)
            r11.zze(r1)
            goto L_0x0377
        L_0x038b:
            if (r6 != r10) goto L_0x03aa
            com.google.android.gms.internal.vision.zzcd r11 = (com.google.android.gms.internal.vision.zzcd) r11
            int r1 = com.google.android.gms.internal.vision.zzbk.zza(r3, r4, r7)
            int r2 = r7.zzgo
            int r2 = r2 + r1
        L_0x0396:
            if (r1 >= r2) goto L_0x03a2
            double r4 = com.google.android.gms.internal.vision.zzbk.zzc(r3, r1)
            r11.zzc(r4)
            int r1 = r1 + 8
            goto L_0x0396
        L_0x03a2:
            if (r1 != r2) goto L_0x03a5
            goto L_0x03ca
        L_0x03a5:
            com.google.android.gms.internal.vision.zzcx r1 = com.google.android.gms.internal.vision.zzcx.zzcb()
            throw r1
        L_0x03aa:
            if (r6 != r13) goto L_0x03c9
            com.google.android.gms.internal.vision.zzcd r11 = (com.google.android.gms.internal.vision.zzcd) r11
            double r8 = com.google.android.gms.internal.vision.zzbk.zzc(r18, r19)
            r11.zzc(r8)
        L_0x03b5:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x03ca
            int r4 = com.google.android.gms.internal.vision.zzbk.zza(r3, r1, r7)
            int r6 = r7.zzgo
            if (r2 != r6) goto L_0x03ca
            double r8 = com.google.android.gms.internal.vision.zzbk.zzc(r3, r4)
            r11.zzc(r8)
            goto L_0x03b5
        L_0x03c9:
            r1 = r4
        L_0x03ca:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzeb.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.vision.zzbl):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <K, V> int zza(T r8, byte[] r9, int r10, int r11, int r12, long r13, com.google.android.gms.internal.vision.zzbl r15) throws java.io.IOException {
        /*
            r7 = this;
            sun.misc.Unsafe r0 = zznd
            java.lang.Object r12 = r7.zzah(r12)
            java.lang.Object r1 = r0.getObject(r8, r13)
            com.google.android.gms.internal.vision.zzds r2 = r7.zznu
            boolean r2 = r2.zzj(r1)
            if (r2 == 0) goto L_0x0021
            com.google.android.gms.internal.vision.zzds r2 = r7.zznu
            java.lang.Object r2 = r2.zzl(r12)
            com.google.android.gms.internal.vision.zzds r3 = r7.zznu
            r3.zzb(r2, r1)
            r0.putObject(r8, r13, r2)
            r1 = r2
        L_0x0021:
            com.google.android.gms.internal.vision.zzds r8 = r7.zznu
            com.google.android.gms.internal.vision.zzdq r8 = r8.zzm(r12)
            com.google.android.gms.internal.vision.zzds r12 = r7.zznu
            java.util.Map r12 = r12.zzh(r1)
            int r10 = com.google.android.gms.internal.vision.zzbk.zza(r9, r10, r15)
            int r13 = r15.zzgo
            if (r13 < 0) goto L_0x0097
            int r14 = r11 - r10
            if (r13 > r14) goto L_0x0097
            int r13 = r13 + r10
            K r14 = r8.zzmx
            V r0 = r8.zzew
        L_0x003e:
            if (r10 >= r13) goto L_0x008c
            int r1 = r10 + 1
            byte r10 = r9[r10]
            if (r10 >= 0) goto L_0x004c
            int r1 = com.google.android.gms.internal.vision.zzbk.zza((int) r10, (byte[]) r9, (int) r1, (com.google.android.gms.internal.vision.zzbl) r15)
            int r10 = r15.zzgo
        L_0x004c:
            r2 = r1
            int r1 = r10 >>> 3
            r3 = r10 & 7
            r4 = 1
            if (r1 == r4) goto L_0x0072
            r4 = 2
            if (r1 == r4) goto L_0x0058
            goto L_0x0087
        L_0x0058:
            com.google.android.gms.internal.vision.zzft r1 = r8.zzmy
            int r1 = r1.zzee()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.vision.zzft r4 = r8.zzmy
            V r10 = r8.zzew
            java.lang.Class r5 = r10.getClass()
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.vision.zzft) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.vision.zzbl) r6)
            java.lang.Object r0 = r15.zzgq
            goto L_0x003e
        L_0x0072:
            com.google.android.gms.internal.vision.zzft r1 = r8.zzmw
            int r1 = r1.zzee()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.vision.zzft r4 = r8.zzmw
            r5 = 0
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.vision.zzft) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.vision.zzbl) r6)
            java.lang.Object r14 = r15.zzgq
            goto L_0x003e
        L_0x0087:
            int r10 = com.google.android.gms.internal.vision.zzbk.zza(r10, r9, r2, r11, r15)
            goto L_0x003e
        L_0x008c:
            if (r10 != r13) goto L_0x0092
            r12.put(r14, r0)
            return r13
        L_0x0092:
            com.google.android.gms.internal.vision.zzcx r8 = com.google.android.gms.internal.vision.zzcx.zzcf()
            throw r8
        L_0x0097:
            com.google.android.gms.internal.vision.zzcx r8 = com.google.android.gms.internal.vision.zzcx.zzcb()
            goto L_0x009d
        L_0x009c:
            throw r8
        L_0x009d:
            goto L_0x009c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzeb.zza(java.lang.Object, byte[], int, int, int, long, com.google.android.gms.internal.vision.zzbl):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v20, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0295, code lost:
        r18 = r6;
        r22 = r7;
        r6 = r8;
        r19 = r9;
        r27 = r10;
        r2 = r13;
        r7 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0336, code lost:
        if (r0 == r15) goto L_0x03a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x037d, code lost:
        if (r0 == r15) goto L_0x03a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00f6, code lost:
        r12 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01af, code lost:
        r10.putObject(r14, r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01ef, code lost:
        r6 = r6 | r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0213, code lost:
        r13 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x022b, code lost:
        r10.putInt(r14, r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0245, code lost:
        r10.putLong(r29, r2, r4);
        r6 = r6 | r22;
        r3 = r8;
        r2 = r9;
        r9 = r11;
        r0 = r13;
        r1 = r23;
        r13 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0286, code lost:
        r0 = r13 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0288, code lost:
        r6 = r6 | r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x028a, code lost:
        r13 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x028c, code lost:
        r3 = r8;
        r2 = r9;
        r9 = r11;
        r1 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0291, code lost:
        r11 = r33;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(T r29, byte[] r30, int r31, int r32, int r33, com.google.android.gms.internal.vision.zzbl r34) throws java.io.IOException {
        /*
            r28 = this;
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r11 = r33
            r9 = r34
            sun.misc.Unsafe r10 = zznd
            r16 = 0
            r0 = r31
            r1 = -1
            r2 = 0
            r3 = 0
            r6 = 0
            r7 = -1
        L_0x0017:
            r17 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 >= r13) goto L_0x03e4
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002b
            int r0 = com.google.android.gms.internal.vision.zzbk.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.vision.zzbl) r9)
            int r3 = r9.zzgo
            r4 = r0
            r5 = r3
            goto L_0x002d
        L_0x002b:
            r5 = r0
            r4 = r3
        L_0x002d:
            int r3 = r5 >>> 3
            r0 = r5 & 7
            r8 = 3
            if (r3 <= r1) goto L_0x003a
            int r2 = r2 / r8
            int r1 = r15.zzr(r3, r2)
            goto L_0x003e
        L_0x003a:
            int r1 = r15.zzal(r3)
        L_0x003e:
            r2 = r1
            r1 = -1
            if (r2 != r1) goto L_0x0051
            r23 = r3
            r2 = r4
            r18 = r6
            r22 = r7
            r27 = r10
            r7 = r11
            r19 = 0
            r6 = r5
            goto L_0x03a7
        L_0x0051:
            int[] r1 = r15.zzne
            int r19 = r2 + 1
            r8 = r1[r19]
            r19 = 267386880(0xff00000, float:2.3665827E-29)
            r19 = r8 & r19
            int r11 = r19 >>> 20
            r19 = r5
            r5 = r8 & r17
            long r12 = (long) r5
            r5 = 17
            r20 = r8
            if (r11 > r5) goto L_0x02a3
            int r5 = r2 + 2
            r1 = r1[r5]
            int r5 = r1 >>> 20
            r8 = 1
            int r22 = r8 << r5
            r1 = r1 & r17
            if (r1 == r7) goto L_0x0083
            r5 = -1
            if (r7 == r5) goto L_0x007c
            long r8 = (long) r7
            r10.putInt(r14, r8, r6)
        L_0x007c:
            long r6 = (long) r1
            int r6 = r10.getInt(r14, r6)
            r7 = r1
            goto L_0x0084
        L_0x0083:
            r5 = -1
        L_0x0084:
            r1 = 5
            switch(r11) {
                case 0: goto L_0x026f;
                case 1: goto L_0x0256;
                case 2: goto L_0x0230;
                case 3: goto L_0x0230;
                case 4: goto L_0x0216;
                case 5: goto L_0x01f3;
                case 6: goto L_0x01d6;
                case 7: goto L_0x01b3;
                case 8: goto L_0x018d;
                case 9: goto L_0x015e;
                case 10: goto L_0x0144;
                case 11: goto L_0x0216;
                case 12: goto L_0x0114;
                case 13: goto L_0x01d6;
                case 14: goto L_0x01f3;
                case 15: goto L_0x00fa;
                case 16: goto L_0x00dc;
                case 17: goto L_0x0096;
                default: goto L_0x0088;
            }
        L_0x0088:
            r12 = r30
            r11 = r34
            r9 = r2
            r23 = r3
            r13 = r4
            r8 = r19
            r19 = -1
            goto L_0x0295
        L_0x0096:
            r8 = 3
            if (r0 != r8) goto L_0x00d2
            int r0 = r3 << 3
            r8 = r0 | 4
            com.google.android.gms.internal.vision.zzen r0 = r15.zzag(r2)
            r1 = r30
            r9 = r2
            r2 = r4
            r23 = r3
            r3 = r32
            r4 = r8
            r8 = r19
            r19 = -1
            r5 = r34
            int r0 = zza((com.google.android.gms.internal.vision.zzen) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.android.gms.internal.vision.zzbl) r5)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x00bd
            r11 = r34
            java.lang.Object r1 = r11.zzgq
            goto L_0x00c9
        L_0x00bd:
            r11 = r34
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r11.zzgq
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzct.zza((java.lang.Object) r1, (java.lang.Object) r2)
        L_0x00c9:
            r10.putObject(r14, r12, r1)
            r6 = r6 | r22
            r12 = r30
            goto L_0x028a
        L_0x00d2:
            r11 = r34
            r9 = r2
            r23 = r3
            r8 = r19
            r19 = -1
            goto L_0x00f6
        L_0x00dc:
            r11 = r34
            r9 = r2
            r23 = r3
            r8 = r19
            r19 = -1
            if (r0 != 0) goto L_0x00f6
            r2 = r12
            r12 = r30
            int r13 = com.google.android.gms.internal.vision.zzbk.zzb(r12, r4, r11)
            long r0 = r11.zzgp
            long r4 = com.google.android.gms.internal.vision.zzbx.zza(r0)
            goto L_0x0245
        L_0x00f6:
            r12 = r30
            goto L_0x0213
        L_0x00fa:
            r11 = r34
            r9 = r2
            r23 = r3
            r2 = r12
            r8 = r19
            r19 = -1
            r12 = r30
            if (r0 != 0) goto L_0x0213
            int r0 = com.google.android.gms.internal.vision.zzbk.zza(r12, r4, r11)
            int r1 = r11.zzgo
            int r1 = com.google.android.gms.internal.vision.zzbx.zzo(r1)
            goto L_0x022b
        L_0x0114:
            r11 = r34
            r9 = r2
            r23 = r3
            r2 = r12
            r8 = r19
            r19 = -1
            r12 = r30
            if (r0 != 0) goto L_0x0213
            int r0 = com.google.android.gms.internal.vision.zzbk.zza(r12, r4, r11)
            int r1 = r11.zzgo
            com.google.android.gms.internal.vision.zzcv r4 = r15.zzai(r9)
            if (r4 == 0) goto L_0x022b
            com.google.android.gms.internal.vision.zzcu r4 = r4.zzaf(r1)
            if (r4 == 0) goto L_0x0136
            goto L_0x022b
        L_0x0136:
            com.google.android.gms.internal.vision.zzfg r2 = zzo(r29)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzb(r8, r1)
            goto L_0x028a
        L_0x0144:
            r11 = r34
            r9 = r2
            r23 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r19 = -1
            r12 = r30
            if (r0 != r1) goto L_0x0213
            int r0 = com.google.android.gms.internal.vision.zzbk.zze(r12, r4, r11)
            java.lang.Object r1 = r11.zzgq
            r10.putObject(r14, r2, r1)
            goto L_0x0288
        L_0x015e:
            r11 = r34
            r9 = r2
            r23 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r19 = -1
            r12 = r30
            if (r0 != r1) goto L_0x0189
            com.google.android.gms.internal.vision.zzen r0 = r15.zzag(r9)
            r13 = r32
            int r0 = zza((com.google.android.gms.internal.vision.zzen) r0, (byte[]) r12, (int) r4, (int) r13, (com.google.android.gms.internal.vision.zzbl) r11)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x017e
            java.lang.Object r1 = r11.zzgq
            goto L_0x01af
        L_0x017e:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r11.zzgq
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzct.zza((java.lang.Object) r1, (java.lang.Object) r4)
            goto L_0x01af
        L_0x0189:
            r13 = r32
            goto L_0x0213
        L_0x018d:
            r11 = r34
            r9 = r2
            r23 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r19 = -1
            r12 = r30
            r13 = r32
            if (r0 != r1) goto L_0x0213
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r20 & r0
            if (r0 != 0) goto L_0x01a9
            int r0 = com.google.android.gms.internal.vision.zzbk.zzc(r12, r4, r11)
            goto L_0x01ad
        L_0x01a9:
            int r0 = com.google.android.gms.internal.vision.zzbk.zzd(r12, r4, r11)
        L_0x01ad:
            java.lang.Object r1 = r11.zzgq
        L_0x01af:
            r10.putObject(r14, r2, r1)
            goto L_0x01ef
        L_0x01b3:
            r11 = r34
            r9 = r2
            r23 = r3
            r2 = r12
            r8 = r19
            r19 = -1
            r12 = r30
            r13 = r32
            if (r0 != 0) goto L_0x0213
            int r0 = com.google.android.gms.internal.vision.zzbk.zzb(r12, r4, r11)
            long r4 = r11.zzgp
            r20 = 0
            int r1 = (r4 > r20 ? 1 : (r4 == r20 ? 0 : -1))
            if (r1 == 0) goto L_0x01d1
            r1 = 1
            goto L_0x01d2
        L_0x01d1:
            r1 = 0
        L_0x01d2:
            com.google.android.gms.internal.vision.zzfl.zza((java.lang.Object) r14, (long) r2, (boolean) r1)
            goto L_0x01ef
        L_0x01d6:
            r11 = r34
            r9 = r2
            r23 = r3
            r2 = r12
            r8 = r19
            r19 = -1
            r12 = r30
            r13 = r32
            if (r0 != r1) goto L_0x0213
            int r0 = com.google.android.gms.internal.vision.zzbk.zza(r12, r4)
            r10.putInt(r14, r2, r0)
            int r0 = r4 + 4
        L_0x01ef:
            r6 = r6 | r22
            goto L_0x028c
        L_0x01f3:
            r11 = r34
            r9 = r2
            r23 = r3
            r2 = r12
            r8 = r19
            r1 = 1
            r19 = -1
            r12 = r30
            r13 = r32
            if (r0 != r1) goto L_0x0213
            long r17 = com.google.android.gms.internal.vision.zzbk.zzb(r12, r4)
            r0 = r10
            r1 = r29
            r13 = r4
            r4 = r17
            r0.putLong(r1, r2, r4)
            goto L_0x0286
        L_0x0213:
            r13 = r4
            goto L_0x0295
        L_0x0216:
            r11 = r34
            r9 = r2
            r23 = r3
            r2 = r12
            r8 = r19
            r19 = -1
            r12 = r30
            r13 = r4
            if (r0 != 0) goto L_0x0295
            int r0 = com.google.android.gms.internal.vision.zzbk.zza(r12, r13, r11)
            int r1 = r11.zzgo
        L_0x022b:
            r10.putInt(r14, r2, r1)
            goto L_0x0288
        L_0x0230:
            r11 = r34
            r9 = r2
            r23 = r3
            r2 = r12
            r8 = r19
            r19 = -1
            r12 = r30
            r13 = r4
            if (r0 != 0) goto L_0x0295
            int r13 = com.google.android.gms.internal.vision.zzbk.zzb(r12, r13, r11)
            long r4 = r11.zzgp
        L_0x0245:
            r0 = r10
            r1 = r29
            r0.putLong(r1, r2, r4)
            r6 = r6 | r22
            r3 = r8
            r2 = r9
            r9 = r11
            r0 = r13
            r1 = r23
            r13 = r32
            goto L_0x0291
        L_0x0256:
            r11 = r34
            r9 = r2
            r23 = r3
            r2 = r12
            r8 = r19
            r19 = -1
            r12 = r30
            r13 = r4
            if (r0 != r1) goto L_0x0295
            float r0 = com.google.android.gms.internal.vision.zzbk.zzd(r12, r13)
            com.google.android.gms.internal.vision.zzfl.zza((java.lang.Object) r14, (long) r2, (float) r0)
            int r0 = r13 + 4
            goto L_0x0288
        L_0x026f:
            r11 = r34
            r9 = r2
            r23 = r3
            r2 = r12
            r8 = r19
            r1 = 1
            r19 = -1
            r12 = r30
            r13 = r4
            if (r0 != r1) goto L_0x0295
            double r0 = com.google.android.gms.internal.vision.zzbk.zzc(r12, r13)
            com.google.android.gms.internal.vision.zzfl.zza((java.lang.Object) r14, (long) r2, (double) r0)
        L_0x0286:
            int r0 = r13 + 8
        L_0x0288:
            r6 = r6 | r22
        L_0x028a:
            r13 = r32
        L_0x028c:
            r3 = r8
            r2 = r9
            r9 = r11
            r1 = r23
        L_0x0291:
            r11 = r33
            goto L_0x0017
        L_0x0295:
            r18 = r6
            r22 = r7
            r6 = r8
            r19 = r9
            r27 = r10
            r2 = r13
            r7 = r33
            goto L_0x03a7
        L_0x02a3:
            r9 = r2
            r23 = r3
            r2 = r12
            r8 = r19
            r19 = -1
            r12 = r30
            r13 = r4
            r1 = 27
            if (r11 != r1) goto L_0x0301
            r1 = 2
            if (r0 != r1) goto L_0x02f4
            java.lang.Object r0 = r10.getObject(r14, r2)
            com.google.android.gms.internal.vision.zzcw r0 = (com.google.android.gms.internal.vision.zzcw) r0
            boolean r1 = r0.zzan()
            if (r1 != 0) goto L_0x02d3
            int r1 = r0.size()
            if (r1 != 0) goto L_0x02ca
            r1 = 10
            goto L_0x02cc
        L_0x02ca:
            int r1 = r1 << 1
        L_0x02cc:
            com.google.android.gms.internal.vision.zzcw r0 = r0.zzk(r1)
            r10.putObject(r14, r2, r0)
        L_0x02d3:
            r5 = r0
            com.google.android.gms.internal.vision.zzen r0 = r15.zzag(r9)
            r1 = r8
            r2 = r30
            r3 = r13
            r4 = r32
            r18 = r6
            r6 = r34
            int r0 = zza((com.google.android.gms.internal.vision.zzen<?>) r0, (int) r1, (byte[]) r2, (int) r3, (int) r4, (com.google.android.gms.internal.vision.zzcw<?>) r5, (com.google.android.gms.internal.vision.zzbl) r6)
            r13 = r32
            r11 = r33
            r3 = r8
            r2 = r9
            r6 = r18
            r1 = r23
            r9 = r34
            goto L_0x0017
        L_0x02f4:
            r18 = r6
            r22 = r7
            r26 = r8
            r19 = r9
            r27 = r10
            r15 = r13
            goto L_0x0380
        L_0x0301:
            r18 = r6
            r1 = 49
            if (r11 > r1) goto L_0x0352
            r6 = r20
            long r5 = (long) r6
            r4 = r0
            r0 = r28
            r1 = r29
            r24 = r2
            r2 = r30
            r3 = r13
            r31 = r4
            r4 = r32
            r20 = r5
            r5 = r8
            r6 = r23
            r22 = r7
            r7 = r31
            r26 = r8
            r15 = -1
            r8 = r9
            r19 = r9
            r27 = r10
            r9 = r20
            r15 = r33
            r15 = r13
            r12 = r24
            r14 = r34
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.vision.zzbl) r14)
            if (r0 != r15) goto L_0x033a
            goto L_0x03a3
        L_0x033a:
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r11 = r33
            r9 = r34
            r6 = r18
            r2 = r19
            r7 = r22
            r1 = r23
            r3 = r26
            goto L_0x03d0
        L_0x0352:
            r31 = r0
            r24 = r2
            r22 = r7
            r26 = r8
            r19 = r9
            r27 = r10
            r15 = r13
            r6 = r20
            r0 = 50
            if (r11 != r0) goto L_0x0386
            r7 = r31
            r0 = 2
            if (r7 != r0) goto L_0x0380
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r15
            r4 = r32
            r5 = r19
            r6 = r24
            r8 = r34
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.vision.zzbl) r8)
            if (r0 != r15) goto L_0x033a
            goto L_0x03a3
        L_0x0380:
            r7 = r33
            r2 = r15
        L_0x0383:
            r6 = r26
            goto L_0x03a7
        L_0x0386:
            r7 = r31
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r15
            r4 = r32
            r5 = r26
            r8 = r6
            r6 = r23
            r9 = r11
            r10 = r24
            r12 = r19
            r13 = r34
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.vision.zzbl) r13)
            if (r0 != r15) goto L_0x03d4
        L_0x03a3:
            r7 = r33
            r2 = r0
            goto L_0x0383
        L_0x03a7:
            if (r6 != r7) goto L_0x03af
            if (r7 != 0) goto L_0x03ac
            goto L_0x03af
        L_0x03ac:
            r8 = r2
            r9 = r6
            goto L_0x03ed
        L_0x03af:
            r0 = r6
            r1 = r30
            r3 = r32
            r4 = r29
            r5 = r34
            int r0 = zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzbl) r5)
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r9 = r34
            r3 = r6
            r11 = r7
        L_0x03c8:
            r6 = r18
            r2 = r19
            r7 = r22
            r1 = r23
        L_0x03d0:
            r10 = r27
            goto L_0x0017
        L_0x03d4:
            r6 = r26
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r11 = r33
            r9 = r34
            r3 = r6
            goto L_0x03c8
        L_0x03e4:
            r18 = r6
            r22 = r7
            r27 = r10
            r7 = r11
            r8 = r0
            r9 = r3
        L_0x03ed:
            r1 = r18
            r0 = r22
            r2 = -1
            if (r0 == r2) goto L_0x03fd
            long r2 = (long) r0
            r10 = r29
            r0 = r27
            r0.putInt(r10, r2, r1)
            goto L_0x03ff
        L_0x03fd:
            r10 = r29
        L_0x03ff:
            r0 = 0
            r11 = r28
            int r1 = r11.zzno
            r5 = r0
            r12 = r1
        L_0x0406:
            int r0 = r11.zznp
            if (r12 >= r0) goto L_0x043a
            int[] r0 = r11.zznn
            r1 = r0[r12]
            com.google.android.gms.internal.vision.zzff<?, ?> r6 = r11.zzns
            int[] r0 = r11.zzne
            r2 = r0[r1]
            int r0 = r11.zzaj(r1)
            r0 = r0 & r17
            long r3 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.vision.zzfl.zzo(r10, r3)
            if (r0 != 0) goto L_0x0422
            goto L_0x0435
        L_0x0422:
            com.google.android.gms.internal.vision.zzcv r4 = r11.zzai(r1)
            if (r4 != 0) goto L_0x0429
            goto L_0x0435
        L_0x0429:
            com.google.android.gms.internal.vision.zzds r3 = r11.zznu
            java.util.Map r3 = r3.zzh(r0)
            r0 = r28
            java.lang.Object r5 = r0.zza((int) r1, (int) r2, r3, (com.google.android.gms.internal.vision.zzcv<?>) r4, r5, r6)
        L_0x0435:
            com.google.android.gms.internal.vision.zzfg r5 = (com.google.android.gms.internal.vision.zzfg) r5
            int r12 = r12 + 1
            goto L_0x0406
        L_0x043a:
            if (r5 == 0) goto L_0x0441
            com.google.android.gms.internal.vision.zzff<?, ?> r0 = r11.zzns
            r0.zzf(r10, r5)
        L_0x0441:
            if (r7 != 0) goto L_0x044d
            r0 = r32
            if (r8 != r0) goto L_0x0448
            goto L_0x0453
        L_0x0448:
            com.google.android.gms.internal.vision.zzcx r0 = com.google.android.gms.internal.vision.zzcx.zzcf()
            throw r0
        L_0x044d:
            r0 = r32
            if (r8 > r0) goto L_0x0454
            if (r9 != r7) goto L_0x0454
        L_0x0453:
            return r8
        L_0x0454:
            com.google.android.gms.internal.vision.zzcx r0 = com.google.android.gms.internal.vision.zzcx.zzcf()
            goto L_0x045a
        L_0x0459:
            throw r0
        L_0x045a:
            goto L_0x0459
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzeb.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.vision.zzbl):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004d, code lost:
        r2 = java.lang.Integer.valueOf(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0051, code lost:
        r6.zzgq = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006e, code lost:
        r6.zzgq = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007b, code lost:
        r6.zzgq = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return r2 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r2 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0042, code lost:
        r2 = java.lang.Long.valueOf(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zza(byte[] r1, int r2, int r3, com.google.android.gms.internal.vision.zzft r4, java.lang.Class<?> r5, com.google.android.gms.internal.vision.zzbl r6) throws java.io.IOException {
        /*
            int[] r0 = com.google.android.gms.internal.vision.zzec.zzhz
            int r4 = r4.ordinal()
            r4 = r0[r4]
            switch(r4) {
                case 1: goto L_0x0085;
                case 2: goto L_0x0080;
                case 3: goto L_0x0073;
                case 4: goto L_0x0066;
                case 5: goto L_0x0066;
                case 6: goto L_0x005d;
                case 7: goto L_0x005d;
                case 8: goto L_0x0054;
                case 9: goto L_0x0047;
                case 10: goto L_0x0047;
                case 11: goto L_0x0047;
                case 12: goto L_0x003c;
                case 13: goto L_0x003c;
                case 14: goto L_0x002f;
                case 15: goto L_0x0024;
                case 16: goto L_0x0019;
                case 17: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "unsupported field type."
            r1.<init>(r2)
            throw r1
        L_0x0013:
            int r1 = com.google.android.gms.internal.vision.zzbk.zzd(r1, r2, r6)
            goto L_0x0099
        L_0x0019:
            int r1 = com.google.android.gms.internal.vision.zzbk.zzb(r1, r2, r6)
            long r2 = r6.zzgp
            long r2 = com.google.android.gms.internal.vision.zzbx.zza(r2)
            goto L_0x0042
        L_0x0024:
            int r1 = com.google.android.gms.internal.vision.zzbk.zza(r1, r2, r6)
            int r2 = r6.zzgo
            int r2 = com.google.android.gms.internal.vision.zzbx.zzo(r2)
            goto L_0x004d
        L_0x002f:
            com.google.android.gms.internal.vision.zzek r4 = com.google.android.gms.internal.vision.zzek.zzdc()
            com.google.android.gms.internal.vision.zzen r4 = r4.zze(r5)
            int r1 = zza((com.google.android.gms.internal.vision.zzen) r4, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.vision.zzbl) r6)
            goto L_0x0099
        L_0x003c:
            int r1 = com.google.android.gms.internal.vision.zzbk.zzb(r1, r2, r6)
            long r2 = r6.zzgp
        L_0x0042:
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            goto L_0x0051
        L_0x0047:
            int r1 = com.google.android.gms.internal.vision.zzbk.zza(r1, r2, r6)
            int r2 = r6.zzgo
        L_0x004d:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x0051:
            r6.zzgq = r2
            goto L_0x0099
        L_0x0054:
            float r1 = com.google.android.gms.internal.vision.zzbk.zzd(r1, r2)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            goto L_0x006e
        L_0x005d:
            long r3 = com.google.android.gms.internal.vision.zzbk.zzb(r1, r2)
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            goto L_0x007b
        L_0x0066:
            int r1 = com.google.android.gms.internal.vision.zzbk.zza(r1, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x006e:
            r6.zzgq = r1
            int r1 = r2 + 4
            goto L_0x0099
        L_0x0073:
            double r3 = com.google.android.gms.internal.vision.zzbk.zzc(r1, r2)
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
        L_0x007b:
            r6.zzgq = r1
            int r1 = r2 + 8
            goto L_0x0099
        L_0x0080:
            int r1 = com.google.android.gms.internal.vision.zzbk.zze(r1, r2, r6)
            goto L_0x0099
        L_0x0085:
            int r1 = com.google.android.gms.internal.vision.zzbk.zzb(r1, r2, r6)
            long r2 = r6.zzgp
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0093
            r2 = 1
            goto L_0x0094
        L_0x0093:
            r2 = 0
        L_0x0094:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            goto L_0x0051
        L_0x0099:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzeb.zza(byte[], int, int, com.google.android.gms.internal.vision.zzft, java.lang.Class, com.google.android.gms.internal.vision.zzbl):int");
    }

    static <T> zzeb<T> zza(Class<T> cls, zzdv zzdv, zzef zzef, zzdh zzdh, zzff<?, ?> zzff, zzcg<?> zzcg, zzds zzds) {
        int i;
        int i2;
        char c2;
        int[] iArr;
        char c3;
        char c4;
        int i3;
        char c5;
        char c6;
        int i4;
        int i5;
        String str;
        char c7;
        int i6;
        int i7;
        char c8;
        int i8;
        int i9;
        int i10;
        int i11;
        Class<?> cls2;
        int i12;
        Field field;
        int i13;
        char charAt;
        int i14;
        int i15;
        char c9;
        Field field2;
        Field field3;
        int i16;
        char charAt2;
        int i17;
        char charAt3;
        int i18;
        char charAt4;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        char charAt5;
        int i25;
        char charAt6;
        int i26;
        char charAt7;
        int i27;
        char charAt8;
        char charAt9;
        char charAt10;
        char charAt11;
        char charAt12;
        char charAt13;
        char charAt14;
        zzdv zzdv2 = zzdv;
        if (zzdv2 instanceof zzem) {
            zzem zzem = (zzem) zzdv2;
            char c10 = 0;
            boolean z = zzem.zzcv() == zzcr.zzd.zzlh;
            String zzde = zzem.zzde();
            int length = zzde.length();
            char charAt15 = zzde.charAt(0);
            if (charAt15 >= 55296) {
                char c11 = charAt15 & 8191;
                int i28 = 1;
                int i29 = 13;
                while (true) {
                    i = i28 + 1;
                    charAt14 = zzde.charAt(i28);
                    if (charAt14 < 55296) {
                        break;
                    }
                    c11 |= (charAt14 & 8191) << i29;
                    i29 += 13;
                    i28 = i;
                }
                charAt15 = (charAt14 << i29) | c11;
            } else {
                i = 1;
            }
            int i30 = i + 1;
            char charAt16 = zzde.charAt(i);
            if (charAt16 >= 55296) {
                char c12 = charAt16 & 8191;
                int i31 = 13;
                while (true) {
                    i2 = i30 + 1;
                    charAt13 = zzde.charAt(i30);
                    if (charAt13 < 55296) {
                        break;
                    }
                    c12 |= (charAt13 & 8191) << i31;
                    i31 += 13;
                    i30 = i2;
                }
                charAt16 = c12 | (charAt13 << i31);
            } else {
                i2 = i30;
            }
            if (charAt16 == 0) {
                iArr = zznc;
                c6 = 0;
                c5 = 0;
                i3 = 0;
                c4 = 0;
                c3 = 0;
                c2 = 0;
            } else {
                int i32 = i2 + 1;
                char charAt17 = zzde.charAt(i2);
                if (charAt17 >= 55296) {
                    char c13 = charAt17 & 8191;
                    int i33 = 13;
                    while (true) {
                        i19 = i32 + 1;
                        charAt12 = zzde.charAt(i32);
                        if (charAt12 < 55296) {
                            break;
                        }
                        c13 |= (charAt12 & 8191) << i33;
                        i33 += 13;
                        i32 = i19;
                    }
                    charAt17 = (charAt12 << i33) | c13;
                } else {
                    i19 = i32;
                }
                int i34 = i19 + 1;
                char charAt18 = zzde.charAt(i19);
                if (charAt18 >= 55296) {
                    char c14 = charAt18 & 8191;
                    int i35 = 13;
                    while (true) {
                        i20 = i34 + 1;
                        charAt11 = zzde.charAt(i34);
                        if (charAt11 < 55296) {
                            break;
                        }
                        c14 |= (charAt11 & 8191) << i35;
                        i35 += 13;
                        i34 = i20;
                    }
                    charAt18 = c14 | (charAt11 << i35);
                } else {
                    i20 = i34;
                }
                int i36 = i20 + 1;
                char charAt19 = zzde.charAt(i20);
                if (charAt19 >= 55296) {
                    char c15 = charAt19 & 8191;
                    int i37 = 13;
                    while (true) {
                        i21 = i36 + 1;
                        charAt10 = zzde.charAt(i36);
                        if (charAt10 < 55296) {
                            break;
                        }
                        c15 |= (charAt10 & 8191) << i37;
                        i37 += 13;
                        i36 = i21;
                    }
                    charAt19 = (charAt10 << i37) | c15;
                } else {
                    i21 = i36;
                }
                int i38 = i21 + 1;
                c4 = zzde.charAt(i21);
                if (c4 >= 55296) {
                    char c16 = c4 & 8191;
                    int i39 = 13;
                    while (true) {
                        i22 = i38 + 1;
                        charAt9 = zzde.charAt(i38);
                        if (charAt9 < 55296) {
                            break;
                        }
                        c16 |= (charAt9 & 8191) << i39;
                        i39 += 13;
                        i38 = i22;
                    }
                    c4 = (charAt9 << i39) | c16;
                } else {
                    i22 = i38;
                }
                int i40 = i22 + 1;
                c3 = zzde.charAt(i22);
                if (c3 >= 55296) {
                    char c17 = c3 & 8191;
                    int i41 = 13;
                    while (true) {
                        i27 = i40 + 1;
                        charAt8 = zzde.charAt(i40);
                        if (charAt8 < 55296) {
                            break;
                        }
                        c17 |= (charAt8 & 8191) << i41;
                        i41 += 13;
                        i40 = i27;
                    }
                    c3 = (charAt8 << i41) | c17;
                    i40 = i27;
                }
                int i42 = i40 + 1;
                c6 = zzde.charAt(i40);
                if (c6 >= 55296) {
                    char c18 = c6 & 8191;
                    int i43 = 13;
                    while (true) {
                        i26 = i42 + 1;
                        charAt7 = zzde.charAt(i42);
                        if (charAt7 < 55296) {
                            break;
                        }
                        c18 |= (charAt7 & 8191) << i43;
                        i43 += 13;
                        i42 = i26;
                    }
                    c6 = c18 | (charAt7 << i43);
                    i42 = i26;
                }
                int i44 = i42 + 1;
                char charAt20 = zzde.charAt(i42);
                if (charAt20 >= 55296) {
                    int i45 = 13;
                    int i46 = i44;
                    char c19 = charAt20 & 8191;
                    int i47 = i46;
                    while (true) {
                        i25 = i47 + 1;
                        charAt6 = zzde.charAt(i47);
                        if (charAt6 < 55296) {
                            break;
                        }
                        c19 |= (charAt6 & 8191) << i45;
                        i45 += 13;
                        i47 = i25;
                    }
                    charAt20 = c19 | (charAt6 << i45);
                    i23 = i25;
                } else {
                    i23 = i44;
                }
                int i48 = i23 + 1;
                c10 = zzde.charAt(i23);
                if (c10 >= 55296) {
                    int i49 = 13;
                    int i50 = i48;
                    char c20 = c10 & 8191;
                    int i51 = i50;
                    while (true) {
                        i24 = i51 + 1;
                        charAt5 = zzde.charAt(i51);
                        if (charAt5 < 55296) {
                            break;
                        }
                        c20 |= (charAt5 & 8191) << i49;
                        i49 += 13;
                        i51 = i24;
                    }
                    c10 = c20 | (charAt5 << i49);
                    i48 = i24;
                }
                iArr = new int[(c10 + c6 + charAt20)];
                i3 = (charAt17 << 1) + charAt18;
                int i52 = i48;
                c2 = charAt17;
                c5 = charAt19;
                i2 = i52;
            }
            Unsafe unsafe = zznd;
            Object[] zzdf = zzem.zzdf();
            Class<?> cls3 = zzem.zzcx().getClass();
            int i53 = i3;
            int[] iArr2 = new int[(c3 * 3)];
            Object[] objArr = new Object[(c3 << 1)];
            int i54 = c10 + c6;
            char c21 = c10;
            int i55 = i53;
            int i56 = i54;
            int i57 = 0;
            int i58 = 0;
            while (i2 < length) {
                int i59 = i2 + 1;
                char charAt21 = zzde.charAt(i2);
                char c22 = 55296;
                if (charAt21 >= 55296) {
                    int i60 = 13;
                    int i61 = i59;
                    char c23 = charAt21 & 8191;
                    int i62 = i61;
                    while (true) {
                        i18 = i62 + 1;
                        charAt4 = zzde.charAt(i62);
                        if (charAt4 < c22) {
                            break;
                        }
                        c23 |= (charAt4 & 8191) << i60;
                        i60 += 13;
                        i62 = i18;
                        c22 = 55296;
                    }
                    charAt21 = c23 | (charAt4 << i60);
                    i4 = i18;
                } else {
                    i4 = i59;
                }
                int i63 = i4 + 1;
                char charAt22 = zzde.charAt(i4);
                int i64 = length;
                char c24 = 55296;
                if (charAt22 >= 55296) {
                    int i65 = 13;
                    int i66 = i63;
                    char c25 = charAt22 & 8191;
                    int i67 = i66;
                    while (true) {
                        i17 = i67 + 1;
                        charAt3 = zzde.charAt(i67);
                        if (charAt3 < c24) {
                            break;
                        }
                        c25 |= (charAt3 & 8191) << i65;
                        i65 += 13;
                        i67 = i17;
                        c24 = 55296;
                    }
                    charAt22 = c25 | (charAt3 << i65);
                    i5 = i17;
                } else {
                    i5 = i63;
                }
                char c26 = c10;
                char c27 = charAt22 & 255;
                boolean z2 = z;
                if ((charAt22 & 1024) != 0) {
                    iArr[i57] = i58;
                    i57++;
                }
                if (c27 > zzcm.MAP.id()) {
                    int i68 = i5 + 1;
                    char charAt23 = zzde.charAt(i5);
                    i6 = i57;
                    char c28 = 55296;
                    if (charAt23 >= 55296) {
                        char c29 = charAt23 & 8191;
                        int i69 = 13;
                        while (true) {
                            i16 = i68 + 1;
                            charAt2 = zzde.charAt(i68);
                            if (charAt2 < c28) {
                                break;
                            }
                            c29 |= (charAt2 & 8191) << i69;
                            i69 += 13;
                            i68 = i16;
                            c28 = 55296;
                        }
                        charAt23 = c29 | (charAt2 << i69);
                        i68 = i16;
                    }
                    if (c27 == zzcm.MESSAGE.id() + 51 || c27 == zzcm.GROUP.id() + 51) {
                        i15 = i68;
                        c9 = 1;
                        objArr[((i58 / 3) << 1) + 1] = zzdf[i55];
                        i55++;
                    } else {
                        if (c27 == zzcm.ENUM.id() + 51) {
                            i15 = i68;
                            if ((charAt15 & 1) == 1) {
                                objArr[((i58 / 3) << 1) + 1] = zzdf[i55];
                                i55++;
                            }
                        } else {
                            i15 = i68;
                        }
                        c9 = 1;
                    }
                    int i70 = charAt23 << c9;
                    Object obj = zzdf[i70];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls3, (String) obj);
                        zzdf[i70] = field2;
                    }
                    char c30 = c5;
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i71 = i70 + 1;
                    Object obj2 = zzdf[i71];
                    int i72 = objectFieldOffset;
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls3, (String) obj2);
                        zzdf[i71] = field3;
                    }
                    str = zzde;
                    i10 = (int) unsafe.objectFieldOffset(field3);
                    cls2 = cls3;
                    i7 = i55;
                    i9 = i72;
                    i11 = 0;
                    c8 = c30;
                    char c31 = c4;
                    i8 = charAt21;
                    i12 = i15;
                    c7 = c31;
                } else {
                    i6 = i57;
                    char c32 = c5;
                    int i73 = i55 + 1;
                    Field zza = zza(cls3, (String) zzdf[i55]);
                    c7 = c4;
                    if (c27 == zzcm.MESSAGE.id() || c27 == zzcm.GROUP.id()) {
                        c8 = c32;
                        objArr[((i58 / 3) << 1) + 1] = zza.getType();
                    } else {
                        if (c27 == zzcm.MESSAGE_LIST.id() || c27 == zzcm.GROUP_LIST.id()) {
                            c8 = c32;
                            i14 = i73 + 1;
                            objArr[((i58 / 3) << 1) + 1] = zzdf[i73];
                        } else if (c27 == zzcm.ENUM.id() || c27 == zzcm.ENUM_LIST.id() || c27 == zzcm.ENUM_LIST_PACKED.id()) {
                            c8 = c32;
                            if ((charAt15 & 1) == 1) {
                                i14 = i73 + 1;
                                objArr[((i58 / 3) << 1) + 1] = zzdf[i73];
                            }
                        } else if (c27 == zzcm.MAP.id()) {
                            int i74 = c21 + 1;
                            iArr[c21] = i58;
                            int i75 = (i58 / 3) << 1;
                            int i76 = i73 + 1;
                            objArr[i75] = zzdf[i73];
                            if ((charAt22 & 2048) != 0) {
                                i73 = i76 + 1;
                                objArr[i75 + 1] = zzdf[i76];
                                c8 = c32;
                            } else {
                                c8 = c32;
                                i73 = i76;
                            }
                            c21 = i74;
                        } else {
                            c8 = c32;
                        }
                        i8 = charAt21;
                        i73 = i14;
                        i9 = (int) unsafe.objectFieldOffset(zza);
                        if ((charAt15 & 1) == 1 || c27 > zzcm.GROUP.id()) {
                            str = zzde;
                            cls2 = cls3;
                            i7 = i73;
                            i12 = i5;
                            i11 = 0;
                            i10 = 0;
                        } else {
                            int i77 = i5 + 1;
                            char charAt24 = zzde.charAt(i5);
                            if (charAt24 >= 55296) {
                                char c33 = charAt24 & 8191;
                                int i78 = 13;
                                while (true) {
                                    i13 = i77 + 1;
                                    charAt = zzde.charAt(i77);
                                    if (charAt < 55296) {
                                        break;
                                    }
                                    c33 |= (charAt & 8191) << i78;
                                    i78 += 13;
                                    i77 = i13;
                                }
                                charAt24 = c33 | (charAt << i78);
                                i77 = i13;
                            }
                            int i79 = (c2 << 1) + (charAt24 / ' ');
                            Object obj3 = zzdf[i79];
                            str = zzde;
                            if (obj3 instanceof Field) {
                                field = (Field) obj3;
                            } else {
                                field = zza(cls3, (String) obj3);
                                zzdf[i79] = field;
                            }
                            cls2 = cls3;
                            i7 = i73;
                            i10 = (int) unsafe.objectFieldOffset(field);
                            i11 = charAt24 % ' ';
                            i12 = i77;
                        }
                    }
                    i8 = charAt21;
                    i9 = (int) unsafe.objectFieldOffset(zza);
                    if ((charAt15 & 1) == 1) {
                    }
                    str = zzde;
                    cls2 = cls3;
                    i7 = i73;
                    i12 = i5;
                    i11 = 0;
                    i10 = 0;
                }
                if (c27 >= 18 && c27 <= '1') {
                    iArr[i56] = i9;
                    i56++;
                }
                int i80 = i58 + 1;
                iArr2[i58] = i8;
                int i81 = i80 + 1;
                iArr2[i80] = (c27 << 20) | ((charAt22 & 256) != 0 ? SigType.TLS : 0) | ((charAt22 & 512) != 0 ? 536870912 : 0) | i9;
                i58 = i81 + 1;
                iArr2[i81] = (i11 << 20) | i10;
                cls3 = cls2;
                c5 = c8;
                c10 = c26;
                i55 = i7;
                length = i64;
                z = z2;
                i57 = i6;
                c4 = c7;
                zzde = str;
            }
            boolean z3 = z;
            return new zzeb(iArr2, objArr, c5, c4, zzem.zzcx(), z, false, iArr, c10, i54, zzef, zzdh, zzff, zzcg, zzds);
        }
        ((zzfa) zzdv2).zzcv();
        throw new NoSuchMethodError();
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzcv<?> zzcv, UB ub, zzff<UT, UB> zzff) {
        zzdq<?, ?> zzm = this.zznu.zzm(zzah(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (zzcv.zzaf(((Integer) next.getValue()).intValue()) == null) {
                if (ub == null) {
                    ub = zzff.zzdt();
                }
                zzbt zzm2 = zzbo.zzm(zzdp.zza(zzm, next.getKey(), next.getValue()));
                try {
                    zzdp.zza(zzm2.zzax(), zzm, next.getKey(), next.getValue());
                    zzff.zza(ub, i2, zzm2.zzaw());
                    it.remove();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return ub;
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    private static void zza(int i, Object obj, zzfz zzfz) throws IOException {
        if (obj instanceof String) {
            zzfz.zza(i, (String) obj);
        } else {
            zzfz.zza(i, (zzbo) obj);
        }
    }

    private static <UT, UB> void zza(zzff<UT, UB> zzff, T t, zzfz zzfz) throws IOException {
        zzff.zza(zzff.zzr(t), zzfz);
    }

    private final <K, V> void zza(zzfz zzfz, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzfz.zza(i, this.zznu.zzm(zzah(i2)), this.zznu.zzi(obj));
        }
    }

    private final void zza(T t, T t2, int i) {
        long zzaj = (long) (zzaj(i) & 1048575);
        if (zza(t2, i)) {
            Object zzo = zzfl.zzo(t, zzaj);
            Object zzo2 = zzfl.zzo(t2, zzaj);
            if (zzo != null && zzo2 != null) {
                zzfl.zza((Object) t, zzaj, zzct.zza(zzo, zzo2));
                zzb(t, i);
            } else if (zzo2 != null) {
                zzfl.zza((Object) t, zzaj, zzo2);
                zzb(t, i);
            }
        }
    }

    private final boolean zza(T t, int i) {
        if (this.zznl) {
            int zzaj = zzaj(i);
            long j = (long) (zzaj & 1048575);
            switch ((zzaj & 267386880) >>> 20) {
                case 0:
                    return zzfl.zzn(t, j) != 0.0d;
                case 1:
                    return zzfl.zzm(t, j) != BitmapDescriptorFactory.HUE_RED;
                case 2:
                    return zzfl.zzk(t, j) != 0;
                case 3:
                    return zzfl.zzk(t, j) != 0;
                case 4:
                    return zzfl.zzj(t, j) != 0;
                case 5:
                    return zzfl.zzk(t, j) != 0;
                case 6:
                    return zzfl.zzj(t, j) != 0;
                case 7:
                    return zzfl.zzl(t, j);
                case 8:
                    Object zzo = zzfl.zzo(t, j);
                    if (zzo instanceof String) {
                        return !((String) zzo).isEmpty();
                    }
                    if (zzo instanceof zzbo) {
                        return !zzbo.zzgt.equals(zzo);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzfl.zzo(t, j) != null;
                case 10:
                    return !zzbo.zzgt.equals(zzfl.zzo(t, j));
                case 11:
                    return zzfl.zzj(t, j) != 0;
                case 12:
                    return zzfl.zzj(t, j) != 0;
                case 13:
                    return zzfl.zzj(t, j) != 0;
                case 14:
                    return zzfl.zzk(t, j) != 0;
                case 15:
                    return zzfl.zzj(t, j) != 0;
                case 16:
                    return zzfl.zzk(t, j) != 0;
                case 17:
                    return zzfl.zzo(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzak = zzak(i);
            return (zzfl.zzj(t, (long) (zzak & 1048575)) & (1 << (zzak >>> 20))) != 0;
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzfl.zzj(t, (long) (zzak(i2) & 1048575)) == i;
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        return this.zznl ? zza(t, i) : (i2 & i3) != 0;
    }

    private static boolean zza(Object obj, int i, zzen zzen) {
        return zzen.zzp(zzfl.zzo(obj, (long) (i & 1048575)));
    }

    private final zzen zzag(int i) {
        int i2 = (i / 3) << 1;
        zzen zzen = (zzen) this.zznf[i2];
        if (zzen != null) {
            return zzen;
        }
        zzen zze = zzek.zzdc().zze((Class) this.zznf[i2 + 1]);
        this.zznf[i2] = zze;
        return zze;
    }

    private final Object zzah(int i) {
        return this.zznf[(i / 3) << 1];
    }

    private final zzcv<?> zzai(int i) {
        return (zzcv) this.zznf[((i / 3) << 1) + 1];
    }

    private final int zzaj(int i) {
        return this.zzne[i + 1];
    }

    private final int zzak(int i) {
        return this.zzne[i + 2];
    }

    private final int zzal(int i) {
        if (i < this.zzng || i > this.zznh) {
            return -1;
        }
        return zzs(i, 0);
    }

    private final void zzb(T t, int i) {
        if (!this.zznl) {
            int zzak = zzak(i);
            long j = (long) (zzak & 1048575);
            zzfl.zza((Object) t, j, zzfl.zzj(t, j) | (1 << (zzak >>> 20)));
        }
    }

    private final void zzb(T t, int i, int i2) {
        zzfl.zza((Object) t, (long) (zzak(i2) & 1048575), i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0280, code lost:
        com.google.android.gms.internal.vision.zzep.zzj(r4, (java.util.List) r8.getObject(r1, r12), r2, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0290, code lost:
        com.google.android.gms.internal.vision.zzep.zzg(r4, (java.util.List) r8.getObject(r1, r12), r2, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02a0, code lost:
        com.google.android.gms.internal.vision.zzep.zzl(r4, (java.util.List) r8.getObject(r1, r12), r2, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x02b0, code lost:
        com.google.android.gms.internal.vision.zzep.zzm(r4, (java.util.List) r8.getObject(r1, r12), r2, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02c0, code lost:
        com.google.android.gms.internal.vision.zzep.zzi(r4, (java.util.List) r8.getObject(r1, r12), r2, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0479, code lost:
        r5 = r5 + 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0276, code lost:
        com.google.android.gms.internal.vision.zzep.zze(r4, r9, r2, r14);
     */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0483  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r19, com.google.android.gms.internal.vision.zzfz r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r0.zznj
            if (r3 == 0) goto L_0x0021
            com.google.android.gms.internal.vision.zzcg<?> r3 = r0.zznt
            com.google.android.gms.internal.vision.zzcj r3 = r3.zzb(r1)
            boolean r5 = r3.isEmpty()
            if (r5 != 0) goto L_0x0021
            java.util.Iterator r3 = r3.iterator()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0023
        L_0x0021:
            r3 = 0
            r5 = 0
        L_0x0023:
            r6 = -1
            int[] r7 = r0.zzne
            int r7 = r7.length
            sun.misc.Unsafe r8 = zznd
            r10 = r5
            r5 = 0
            r11 = 0
        L_0x002c:
            if (r5 >= r7) goto L_0x047d
            int r12 = r0.zzaj(r5)
            int[] r13 = r0.zzne
            r14 = r13[r5]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r12
            int r15 = r15 >>> 20
            boolean r4 = r0.zznl
            r16 = 1048575(0xfffff, float:1.469367E-39)
            if (r4 != 0) goto L_0x0062
            r4 = 17
            if (r15 > r4) goto L_0x0062
            int r4 = r5 + 2
            r4 = r13[r4]
            r13 = r4 & r16
            if (r13 == r6) goto L_0x0056
            r17 = r10
            long r9 = (long) r13
            int r11 = r8.getInt(r1, r9)
            goto L_0x0059
        L_0x0056:
            r17 = r10
            r13 = r6
        L_0x0059:
            int r4 = r4 >>> 20
            r6 = 1
            int r9 = r6 << r4
            r6 = r13
            r10 = r17
            goto L_0x0067
        L_0x0062:
            r17 = r10
            r10 = r17
            r9 = 0
        L_0x0067:
            if (r10 == 0) goto L_0x0086
            com.google.android.gms.internal.vision.zzcg<?> r4 = r0.zznt
            int r4 = r4.zza(r10)
            if (r4 > r14) goto L_0x0086
            com.google.android.gms.internal.vision.zzcg<?> r4 = r0.zznt
            r4.zza((com.google.android.gms.internal.vision.zzfz) r2, (java.util.Map.Entry<?, ?>) r10)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0084
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r10 = r4
            goto L_0x0067
        L_0x0084:
            r10 = 0
            goto L_0x0067
        L_0x0086:
            r4 = r12 & r16
            long r12 = (long) r4
            switch(r15) {
                case 0: goto L_0x046d;
                case 1: goto L_0x0460;
                case 2: goto L_0x0453;
                case 3: goto L_0x0446;
                case 4: goto L_0x0439;
                case 5: goto L_0x042c;
                case 6: goto L_0x041f;
                case 7: goto L_0x0412;
                case 8: goto L_0x0404;
                case 9: goto L_0x03f2;
                case 10: goto L_0x03e2;
                case 11: goto L_0x03d4;
                case 12: goto L_0x03c6;
                case 13: goto L_0x03b8;
                case 14: goto L_0x03aa;
                case 15: goto L_0x039c;
                case 16: goto L_0x038e;
                case 17: goto L_0x037c;
                case 18: goto L_0x036c;
                case 19: goto L_0x035c;
                case 20: goto L_0x034c;
                case 21: goto L_0x033c;
                case 22: goto L_0x032c;
                case 23: goto L_0x031c;
                case 24: goto L_0x030c;
                case 25: goto L_0x02fc;
                case 26: goto L_0x02ed;
                case 27: goto L_0x02da;
                case 28: goto L_0x02cb;
                case 29: goto L_0x02bb;
                case 30: goto L_0x02ab;
                case 31: goto L_0x029b;
                case 32: goto L_0x028b;
                case 33: goto L_0x027b;
                case 34: goto L_0x026b;
                case 35: goto L_0x025b;
                case 36: goto L_0x024b;
                case 37: goto L_0x023b;
                case 38: goto L_0x022b;
                case 39: goto L_0x021b;
                case 40: goto L_0x020b;
                case 41: goto L_0x01fb;
                case 42: goto L_0x01eb;
                case 43: goto L_0x01e4;
                case 44: goto L_0x01dd;
                case 45: goto L_0x01d6;
                case 46: goto L_0x01cf;
                case 47: goto L_0x01c8;
                case 48: goto L_0x01bb;
                case 49: goto L_0x01a8;
                case 50: goto L_0x019f;
                case 51: goto L_0x0190;
                case 52: goto L_0x0181;
                case 53: goto L_0x0172;
                case 54: goto L_0x0163;
                case 55: goto L_0x0154;
                case 56: goto L_0x0145;
                case 57: goto L_0x0136;
                case 58: goto L_0x0127;
                case 59: goto L_0x0118;
                case 60: goto L_0x0105;
                case 61: goto L_0x00f5;
                case 62: goto L_0x00e7;
                case 63: goto L_0x00d9;
                case 64: goto L_0x00cb;
                case 65: goto L_0x00bd;
                case 66: goto L_0x00af;
                case 67: goto L_0x00a1;
                case 68: goto L_0x008f;
                default: goto L_0x008c;
            }
        L_0x008c:
            r15 = 0
            goto L_0x0479
        L_0x008f:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.vision.zzen r9 = r0.zzag(r5)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzen) r9)
            goto L_0x008c
        L_0x00a1:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            long r12 = zzh(r1, r12)
            r2.zzb((int) r14, (long) r12)
            goto L_0x008c
        L_0x00af:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            int r4 = zzg(r1, r12)
            r2.zzg(r14, r4)
            goto L_0x008c
        L_0x00bd:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            long r12 = zzh(r1, r12)
            r2.zzj(r14, r12)
            goto L_0x008c
        L_0x00cb:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            int r4 = zzg(r1, r12)
            r2.zzo(r14, r4)
            goto L_0x008c
        L_0x00d9:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            int r4 = zzg(r1, r12)
            r2.zzp(r14, r4)
            goto L_0x008c
        L_0x00e7:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            int r4 = zzg(r1, r12)
            r2.zzf(r14, r4)
            goto L_0x008c
        L_0x00f5:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.vision.zzbo r4 = (com.google.android.gms.internal.vision.zzbo) r4
            r2.zza((int) r14, (com.google.android.gms.internal.vision.zzbo) r4)
            goto L_0x008c
        L_0x0105:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.vision.zzen r9 = r0.zzag(r5)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzen) r9)
            goto L_0x008c
        L_0x0118:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            java.lang.Object r4 = r8.getObject(r1, r12)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzfz) r2)
            goto L_0x008c
        L_0x0127:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            boolean r4 = zzi(r1, r12)
            r2.zzb((int) r14, (boolean) r4)
            goto L_0x008c
        L_0x0136:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            int r4 = zzg(r1, r12)
            r2.zzh(r14, r4)
            goto L_0x008c
        L_0x0145:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            long r12 = zzh(r1, r12)
            r2.zzc(r14, r12)
            goto L_0x008c
        L_0x0154:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            int r4 = zzg(r1, r12)
            r2.zze(r14, r4)
            goto L_0x008c
        L_0x0163:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            long r12 = zzh(r1, r12)
            r2.zza((int) r14, (long) r12)
            goto L_0x008c
        L_0x0172:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            long r12 = zzh(r1, r12)
            r2.zzi(r14, r12)
            goto L_0x008c
        L_0x0181:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            float r4 = zzf(r1, r12)
            r2.zza((int) r14, (float) r4)
            goto L_0x008c
        L_0x0190:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            double r12 = zze(r1, r12)
            r2.zza((int) r14, (double) r12)
            goto L_0x008c
        L_0x019f:
            java.lang.Object r4 = r8.getObject(r1, r12)
            r0.zza((com.google.android.gms.internal.vision.zzfz) r2, (int) r14, (java.lang.Object) r4, (int) r5)
            goto L_0x008c
        L_0x01a8:
            int[] r4 = r0.zzne
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzen r12 = r0.zzag(r5)
            com.google.android.gms.internal.vision.zzep.zzb((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.vision.zzfz) r2, (com.google.android.gms.internal.vision.zzen) r12)
            goto L_0x008c
        L_0x01bb:
            int[] r4 = r0.zzne
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r14 = 1
            goto L_0x0276
        L_0x01c8:
            r14 = 1
            int[] r4 = r0.zzne
            r4 = r4[r5]
            goto L_0x0280
        L_0x01cf:
            r14 = 1
            int[] r4 = r0.zzne
            r4 = r4[r5]
            goto L_0x0290
        L_0x01d6:
            r14 = 1
            int[] r4 = r0.zzne
            r4 = r4[r5]
            goto L_0x02a0
        L_0x01dd:
            r14 = 1
            int[] r4 = r0.zzne
            r4 = r4[r5]
            goto L_0x02b0
        L_0x01e4:
            r14 = 1
            int[] r4 = r0.zzne
            r4 = r4[r5]
            goto L_0x02c0
        L_0x01eb:
            r14 = 1
            int[] r4 = r0.zzne
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzn(r4, r9, r2, r14)
            goto L_0x008c
        L_0x01fb:
            r14 = 1
            int[] r4 = r0.zzne
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzk(r4, r9, r2, r14)
            goto L_0x008c
        L_0x020b:
            r14 = 1
            int[] r4 = r0.zzne
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzf(r4, r9, r2, r14)
            goto L_0x008c
        L_0x021b:
            r14 = 1
            int[] r4 = r0.zzne
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzh(r4, r9, r2, r14)
            goto L_0x008c
        L_0x022b:
            r14 = 1
            int[] r4 = r0.zzne
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzd(r4, r9, r2, r14)
            goto L_0x008c
        L_0x023b:
            r14 = 1
            int[] r4 = r0.zzne
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzc(r4, r9, r2, r14)
            goto L_0x008c
        L_0x024b:
            r14 = 1
            int[] r4 = r0.zzne
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.vision.zzfz) r2, (boolean) r14)
            goto L_0x008c
        L_0x025b:
            r14 = 1
            int[] r4 = r0.zzne
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.vision.zzfz) r2, (boolean) r14)
            goto L_0x008c
        L_0x026b:
            int[] r4 = r0.zzne
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r14 = 0
        L_0x0276:
            com.google.android.gms.internal.vision.zzep.zze(r4, r9, r2, r14)
            goto L_0x008c
        L_0x027b:
            r14 = 0
            int[] r4 = r0.zzne
            r4 = r4[r5]
        L_0x0280:
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzj(r4, r9, r2, r14)
            goto L_0x008c
        L_0x028b:
            r14 = 0
            int[] r4 = r0.zzne
            r4 = r4[r5]
        L_0x0290:
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzg(r4, r9, r2, r14)
            goto L_0x008c
        L_0x029b:
            r14 = 0
            int[] r4 = r0.zzne
            r4 = r4[r5]
        L_0x02a0:
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzl(r4, r9, r2, r14)
            goto L_0x008c
        L_0x02ab:
            r14 = 0
            int[] r4 = r0.zzne
            r4 = r4[r5]
        L_0x02b0:
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzm(r4, r9, r2, r14)
            goto L_0x008c
        L_0x02bb:
            r14 = 0
            int[] r4 = r0.zzne
            r4 = r4[r5]
        L_0x02c0:
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzi(r4, r9, r2, r14)
            goto L_0x008c
        L_0x02cb:
            int[] r4 = r0.zzne
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzb(r4, r9, r2)
            goto L_0x008c
        L_0x02da:
            int[] r4 = r0.zzne
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzen r12 = r0.zzag(r5)
            com.google.android.gms.internal.vision.zzep.zza((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.vision.zzfz) r2, (com.google.android.gms.internal.vision.zzen) r12)
            goto L_0x008c
        L_0x02ed:
            int[] r4 = r0.zzne
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zza((int) r4, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.vision.zzfz) r2)
            goto L_0x008c
        L_0x02fc:
            int[] r4 = r0.zzne
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r15 = 0
            com.google.android.gms.internal.vision.zzep.zzn(r4, r9, r2, r15)
            goto L_0x0479
        L_0x030c:
            r15 = 0
            int[] r4 = r0.zzne
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzk(r4, r9, r2, r15)
            goto L_0x0479
        L_0x031c:
            r15 = 0
            int[] r4 = r0.zzne
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzf(r4, r9, r2, r15)
            goto L_0x0479
        L_0x032c:
            r15 = 0
            int[] r4 = r0.zzne
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzh(r4, r9, r2, r15)
            goto L_0x0479
        L_0x033c:
            r15 = 0
            int[] r4 = r0.zzne
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzd(r4, r9, r2, r15)
            goto L_0x0479
        L_0x034c:
            r15 = 0
            int[] r4 = r0.zzne
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzc(r4, r9, r2, r15)
            goto L_0x0479
        L_0x035c:
            r15 = 0
            int[] r4 = r0.zzne
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.vision.zzfz) r2, (boolean) r15)
            goto L_0x0479
        L_0x036c:
            r15 = 0
            int[] r4 = r0.zzne
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.vision.zzfz) r2, (boolean) r15)
            goto L_0x0479
        L_0x037c:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.vision.zzen r9 = r0.zzag(r5)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzen) r9)
            goto L_0x0479
        L_0x038e:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            long r12 = r8.getLong(r1, r12)
            r2.zzb((int) r14, (long) r12)
            goto L_0x0479
        L_0x039c:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            int r4 = r8.getInt(r1, r12)
            r2.zzg(r14, r4)
            goto L_0x0479
        L_0x03aa:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            long r12 = r8.getLong(r1, r12)
            r2.zzj(r14, r12)
            goto L_0x0479
        L_0x03b8:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            int r4 = r8.getInt(r1, r12)
            r2.zzo(r14, r4)
            goto L_0x0479
        L_0x03c6:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            int r4 = r8.getInt(r1, r12)
            r2.zzp(r14, r4)
            goto L_0x0479
        L_0x03d4:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            int r4 = r8.getInt(r1, r12)
            r2.zzf(r14, r4)
            goto L_0x0479
        L_0x03e2:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.vision.zzbo r4 = (com.google.android.gms.internal.vision.zzbo) r4
            r2.zza((int) r14, (com.google.android.gms.internal.vision.zzbo) r4)
            goto L_0x0479
        L_0x03f2:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.vision.zzen r9 = r0.zzag(r5)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzen) r9)
            goto L_0x0479
        L_0x0404:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            java.lang.Object r4 = r8.getObject(r1, r12)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzfz) r2)
            goto L_0x0479
        L_0x0412:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            boolean r4 = com.google.android.gms.internal.vision.zzfl.zzl(r1, r12)
            r2.zzb((int) r14, (boolean) r4)
            goto L_0x0479
        L_0x041f:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            int r4 = r8.getInt(r1, r12)
            r2.zzh(r14, r4)
            goto L_0x0479
        L_0x042c:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            long r12 = r8.getLong(r1, r12)
            r2.zzc(r14, r12)
            goto L_0x0479
        L_0x0439:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            int r4 = r8.getInt(r1, r12)
            r2.zze(r14, r4)
            goto L_0x0479
        L_0x0446:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            long r12 = r8.getLong(r1, r12)
            r2.zza((int) r14, (long) r12)
            goto L_0x0479
        L_0x0453:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            long r12 = r8.getLong(r1, r12)
            r2.zzi(r14, r12)
            goto L_0x0479
        L_0x0460:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            float r4 = com.google.android.gms.internal.vision.zzfl.zzm(r1, r12)
            r2.zza((int) r14, (float) r4)
            goto L_0x0479
        L_0x046d:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            double r12 = com.google.android.gms.internal.vision.zzfl.zzn(r1, r12)
            r2.zza((int) r14, (double) r12)
        L_0x0479:
            int r5 = r5 + 3
            goto L_0x002c
        L_0x047d:
            r17 = r10
            r4 = r17
        L_0x0481:
            if (r4 == 0) goto L_0x0497
            com.google.android.gms.internal.vision.zzcg<?> r5 = r0.zznt
            r5.zza((com.google.android.gms.internal.vision.zzfz) r2, (java.util.Map.Entry<?, ?>) r4)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0495
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            goto L_0x0481
        L_0x0495:
            r4 = 0
            goto L_0x0481
        L_0x0497:
            com.google.android.gms.internal.vision.zzff<?, ?> r3 = r0.zzns
            zza(r3, r1, (com.google.android.gms.internal.vision.zzfz) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzeb.zzb(java.lang.Object, com.google.android.gms.internal.vision.zzfz):void");
    }

    private final void zzb(T t, T t2, int i) {
        int zzaj = zzaj(i);
        int i2 = this.zzne[i];
        long j = (long) (zzaj & 1048575);
        if (zza(t2, i2, i)) {
            Object zzo = zzfl.zzo(t, j);
            Object zzo2 = zzfl.zzo(t2, j);
            if (zzo != null && zzo2 != null) {
                zzfl.zza((Object) t, j, zzct.zza(zzo, zzo2));
                zzb(t, i2, i);
            } else if (zzo2 != null) {
                zzfl.zza((Object) t, j, zzo2);
                zzb(t, i2, i);
            }
        }
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private static <E> List<E> zzd(Object obj, long j) {
        return (List) zzfl.zzo(obj, j);
    }

    private static <T> double zze(T t, long j) {
        return ((Double) zzfl.zzo(t, j)).doubleValue();
    }

    private static <T> float zzf(T t, long j) {
        return ((Float) zzfl.zzo(t, j)).floatValue();
    }

    private static <T> int zzg(T t, long j) {
        return ((Integer) zzfl.zzo(t, j)).intValue();
    }

    private static <T> long zzh(T t, long j) {
        return ((Long) zzfl.zzo(t, j)).longValue();
    }

    private static <T> boolean zzi(T t, long j) {
        return ((Boolean) zzfl.zzo(t, j)).booleanValue();
    }

    private static zzfg zzo(Object obj) {
        zzcr zzcr = (zzcr) obj;
        zzfg zzfg = zzcr.zzkr;
        if (zzfg != zzfg.zzdu()) {
            return zzfg;
        }
        zzfg zzdv = zzfg.zzdv();
        zzcr.zzkr = zzdv;
        return zzdv;
    }

    private final int zzr(int i, int i2) {
        if (i < this.zzng || i > this.zznh) {
            return -1;
        }
        return zzs(i, i2);
    }

    private final int zzs(int i, int i2) {
        int length = (this.zzne.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzne[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005c, code lost:
        if (com.google.android.gms.internal.vision.zzep.zzd(com.google.android.gms.internal.vision.zzfl.zzo(r10, r6), com.google.android.gms.internal.vision.zzfl.zzo(r11, r6)) != false) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0070, code lost:
        if (com.google.android.gms.internal.vision.zzfl.zzk(r10, r6) == com.google.android.gms.internal.vision.zzfl.zzk(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0082, code lost:
        if (com.google.android.gms.internal.vision.zzfl.zzj(r10, r6) == com.google.android.gms.internal.vision.zzfl.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0096, code lost:
        if (com.google.android.gms.internal.vision.zzfl.zzk(r10, r6) == com.google.android.gms.internal.vision.zzfl.zzk(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a8, code lost:
        if (com.google.android.gms.internal.vision.zzfl.zzj(r10, r6) == com.google.android.gms.internal.vision.zzfl.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ba, code lost:
        if (com.google.android.gms.internal.vision.zzfl.zzj(r10, r6) == com.google.android.gms.internal.vision.zzfl.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cc, code lost:
        if (com.google.android.gms.internal.vision.zzfl.zzj(r10, r6) == com.google.android.gms.internal.vision.zzfl.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e2, code lost:
        if (com.google.android.gms.internal.vision.zzep.zzd(com.google.android.gms.internal.vision.zzfl.zzo(r10, r6), com.google.android.gms.internal.vision.zzfl.zzo(r11, r6)) != false) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f8, code lost:
        if (com.google.android.gms.internal.vision.zzep.zzd(com.google.android.gms.internal.vision.zzfl.zzo(r10, r6), com.google.android.gms.internal.vision.zzfl.zzo(r11, r6)) != false) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010e, code lost:
        if (com.google.android.gms.internal.vision.zzep.zzd(com.google.android.gms.internal.vision.zzfl.zzo(r10, r6), com.google.android.gms.internal.vision.zzfl.zzo(r11, r6)) != false) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0120, code lost:
        if (com.google.android.gms.internal.vision.zzfl.zzl(r10, r6) == com.google.android.gms.internal.vision.zzfl.zzl(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0132, code lost:
        if (com.google.android.gms.internal.vision.zzfl.zzj(r10, r6) == com.google.android.gms.internal.vision.zzfl.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0145, code lost:
        if (com.google.android.gms.internal.vision.zzfl.zzk(r10, r6) == com.google.android.gms.internal.vision.zzfl.zzk(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0156, code lost:
        if (com.google.android.gms.internal.vision.zzfl.zzj(r10, r6) == com.google.android.gms.internal.vision.zzfl.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0169, code lost:
        if (com.google.android.gms.internal.vision.zzfl.zzk(r10, r6) == com.google.android.gms.internal.vision.zzfl.zzk(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x017c, code lost:
        if (com.google.android.gms.internal.vision.zzfl.zzk(r10, r6) == com.google.android.gms.internal.vision.zzfl.zzk(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x018d, code lost:
        if (com.google.android.gms.internal.vision.zzfl.zzj(r10, r6) == com.google.android.gms.internal.vision.zzfl.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01a0, code lost:
        if (com.google.android.gms.internal.vision.zzfl.zzk(r10, r6) == com.google.android.gms.internal.vision.zzfl.zzk(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01a2, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.vision.zzep.zzd(com.google.android.gms.internal.vision.zzfl.zzo(r10, r6), com.google.android.gms.internal.vision.zzfl.zzo(r11, r6)) != false) goto L_0x01a3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzne
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01aa
            int r4 = r9.zzaj(r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x0190;
                case 1: goto L_0x017f;
                case 2: goto L_0x016c;
                case 3: goto L_0x0159;
                case 4: goto L_0x0148;
                case 5: goto L_0x0135;
                case 6: goto L_0x0124;
                case 7: goto L_0x0112;
                case 8: goto L_0x00fc;
                case 9: goto L_0x00e6;
                case 10: goto L_0x00d0;
                case 11: goto L_0x00be;
                case 12: goto L_0x00ac;
                case 13: goto L_0x009a;
                case 14: goto L_0x0086;
                case 15: goto L_0x0074;
                case 16: goto L_0x0060;
                case 17: goto L_0x004a;
                case 18: goto L_0x003c;
                case 19: goto L_0x003c;
                case 20: goto L_0x003c;
                case 21: goto L_0x003c;
                case 22: goto L_0x003c;
                case 23: goto L_0x003c;
                case 24: goto L_0x003c;
                case 25: goto L_0x003c;
                case 26: goto L_0x003c;
                case 27: goto L_0x003c;
                case 28: goto L_0x003c;
                case 29: goto L_0x003c;
                case 30: goto L_0x003c;
                case 31: goto L_0x003c;
                case 32: goto L_0x003c;
                case 33: goto L_0x003c;
                case 34: goto L_0x003c;
                case 35: goto L_0x003c;
                case 36: goto L_0x003c;
                case 37: goto L_0x003c;
                case 38: goto L_0x003c;
                case 39: goto L_0x003c;
                case 40: goto L_0x003c;
                case 41: goto L_0x003c;
                case 42: goto L_0x003c;
                case 43: goto L_0x003c;
                case 44: goto L_0x003c;
                case 45: goto L_0x003c;
                case 46: goto L_0x003c;
                case 47: goto L_0x003c;
                case 48: goto L_0x003c;
                case 49: goto L_0x003c;
                case 50: goto L_0x003c;
                case 51: goto L_0x001c;
                case 52: goto L_0x001c;
                case 53: goto L_0x001c;
                case 54: goto L_0x001c;
                case 55: goto L_0x001c;
                case 56: goto L_0x001c;
                case 57: goto L_0x001c;
                case 58: goto L_0x001c;
                case 59: goto L_0x001c;
                case 60: goto L_0x001c;
                case 61: goto L_0x001c;
                case 62: goto L_0x001c;
                case 63: goto L_0x001c;
                case 64: goto L_0x001c;
                case 65: goto L_0x001c;
                case 66: goto L_0x001c;
                case 67: goto L_0x001c;
                case 68: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x01a3
        L_0x001c:
            int r4 = r9.zzak(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.vision.zzfl.zzj(r10, r4)
            int r4 = com.google.android.gms.internal.vision.zzfl.zzj(r11, r4)
            if (r8 != r4) goto L_0x01a2
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzfl.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzfl.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zzep.zzd((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01a3
            goto L_0x018f
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzfl.zzo(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzfl.zzo(r11, r6)
            boolean r3 = com.google.android.gms.internal.vision.zzep.zzd((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01a3
        L_0x004a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzfl.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzfl.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zzep.zzd((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01a3
            goto L_0x01a2
        L_0x0060:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            long r4 = com.google.android.gms.internal.vision.zzfl.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzfl.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01a3
            goto L_0x018f
        L_0x0074:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            int r4 = com.google.android.gms.internal.vision.zzfl.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzfl.zzj(r11, r6)
            if (r4 == r5) goto L_0x01a3
            goto L_0x01a2
        L_0x0086:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            long r4 = com.google.android.gms.internal.vision.zzfl.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzfl.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01a3
            goto L_0x018f
        L_0x009a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            int r4 = com.google.android.gms.internal.vision.zzfl.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzfl.zzj(r11, r6)
            if (r4 == r5) goto L_0x01a3
            goto L_0x01a2
        L_0x00ac:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            int r4 = com.google.android.gms.internal.vision.zzfl.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzfl.zzj(r11, r6)
            if (r4 == r5) goto L_0x01a3
            goto L_0x018f
        L_0x00be:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            int r4 = com.google.android.gms.internal.vision.zzfl.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzfl.zzj(r11, r6)
            if (r4 == r5) goto L_0x01a3
            goto L_0x01a2
        L_0x00d0:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzfl.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzfl.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zzep.zzd((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01a3
            goto L_0x018f
        L_0x00e6:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzfl.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzfl.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zzep.zzd((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01a3
            goto L_0x01a2
        L_0x00fc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzfl.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzfl.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zzep.zzd((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01a3
            goto L_0x018f
        L_0x0112:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            boolean r4 = com.google.android.gms.internal.vision.zzfl.zzl(r10, r6)
            boolean r5 = com.google.android.gms.internal.vision.zzfl.zzl(r11, r6)
            if (r4 == r5) goto L_0x01a3
            goto L_0x01a2
        L_0x0124:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            int r4 = com.google.android.gms.internal.vision.zzfl.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzfl.zzj(r11, r6)
            if (r4 == r5) goto L_0x01a3
            goto L_0x018f
        L_0x0135:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            long r4 = com.google.android.gms.internal.vision.zzfl.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzfl.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01a3
            goto L_0x01a2
        L_0x0148:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            int r4 = com.google.android.gms.internal.vision.zzfl.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzfl.zzj(r11, r6)
            if (r4 == r5) goto L_0x01a3
            goto L_0x018f
        L_0x0159:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            long r4 = com.google.android.gms.internal.vision.zzfl.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzfl.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01a3
            goto L_0x01a2
        L_0x016c:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            long r4 = com.google.android.gms.internal.vision.zzfl.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzfl.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01a3
            goto L_0x018f
        L_0x017f:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            int r4 = com.google.android.gms.internal.vision.zzfl.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzfl.zzj(r11, r6)
            if (r4 == r5) goto L_0x01a3
        L_0x018f:
            goto L_0x01a2
        L_0x0190:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            long r4 = com.google.android.gms.internal.vision.zzfl.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzfl.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01a3
        L_0x01a2:
            r3 = 0
        L_0x01a3:
            if (r3 != 0) goto L_0x01a6
            return r1
        L_0x01a6:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01aa:
            com.google.android.gms.internal.vision.zzff<?, ?> r0 = r9.zzns
            java.lang.Object r0 = r0.zzr(r10)
            com.google.android.gms.internal.vision.zzff<?, ?> r2 = r9.zzns
            java.lang.Object r2 = r2.zzr(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01bd
            return r1
        L_0x01bd:
            boolean r0 = r9.zznj
            if (r0 == 0) goto L_0x01d2
            com.google.android.gms.internal.vision.zzcg<?> r0 = r9.zznt
            com.google.android.gms.internal.vision.zzcj r10 = r0.zzb(r10)
            com.google.android.gms.internal.vision.zzcg<?> r0 = r9.zznt
            com.google.android.gms.internal.vision.zzcj r11 = r0.zzb(r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01d2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzeb.equals(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0061, code lost:
        r3 = com.google.android.gms.internal.vision.zzfl.zzo(r9, r5);
        r2 = r2 * 53;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0093, code lost:
        r2 = r2 * 53;
        r3 = zzg(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a8, code lost:
        r2 = r2 * 53;
        r3 = zzh(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ce, code lost:
        if (r3 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d1, code lost:
        r2 = r2 * 53;
        r3 = com.google.android.gms.internal.vision.zzfl.zzo(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d7, code lost:
        r3 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e0, code lost:
        if (r3 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e2, code lost:
        r7 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e6, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ea, code lost:
        r2 = r2 * 53;
        r3 = ((java.lang.String) com.google.android.gms.internal.vision.zzfl.zzo(r9, r5)).hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00fd, code lost:
        r3 = com.google.android.gms.internal.vision.zzct.zzc(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0116, code lost:
        r3 = java.lang.Float.floatToIntBits(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0121, code lost:
        r3 = java.lang.Double.doubleToLongBits(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0125, code lost:
        r3 = com.google.android.gms.internal.vision.zzct.zzk(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0129, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x012a, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int hashCode(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzne
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x012e
            int r3 = r8.zzaj(r1)
            int[] r4 = r8.zzne
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = r3 & r7
            int r3 = r3 >>> 20
            r7 = 37
            switch(r3) {
                case 0: goto L_0x011b;
                case 1: goto L_0x0110;
                case 2: goto L_0x0109;
                case 3: goto L_0x0109;
                case 4: goto L_0x0102;
                case 5: goto L_0x0109;
                case 6: goto L_0x0102;
                case 7: goto L_0x00f7;
                case 8: goto L_0x00ea;
                case 9: goto L_0x00dc;
                case 10: goto L_0x00d1;
                case 11: goto L_0x0102;
                case 12: goto L_0x0102;
                case 13: goto L_0x0102;
                case 14: goto L_0x0109;
                case 15: goto L_0x0102;
                case 16: goto L_0x0109;
                case 17: goto L_0x00ca;
                case 18: goto L_0x00d1;
                case 19: goto L_0x00d1;
                case 20: goto L_0x00d1;
                case 21: goto L_0x00d1;
                case 22: goto L_0x00d1;
                case 23: goto L_0x00d1;
                case 24: goto L_0x00d1;
                case 25: goto L_0x00d1;
                case 26: goto L_0x00d1;
                case 27: goto L_0x00d1;
                case 28: goto L_0x00d1;
                case 29: goto L_0x00d1;
                case 30: goto L_0x00d1;
                case 31: goto L_0x00d1;
                case 32: goto L_0x00d1;
                case 33: goto L_0x00d1;
                case 34: goto L_0x00d1;
                case 35: goto L_0x00d1;
                case 36: goto L_0x00d1;
                case 37: goto L_0x00d1;
                case 38: goto L_0x00d1;
                case 39: goto L_0x00d1;
                case 40: goto L_0x00d1;
                case 41: goto L_0x00d1;
                case 42: goto L_0x00d1;
                case 43: goto L_0x00d1;
                case 44: goto L_0x00d1;
                case 45: goto L_0x00d1;
                case 46: goto L_0x00d1;
                case 47: goto L_0x00d1;
                case 48: goto L_0x00d1;
                case 49: goto L_0x00d1;
                case 50: goto L_0x00d1;
                case 51: goto L_0x00bd;
                case 52: goto L_0x00b0;
                case 53: goto L_0x00a2;
                case 54: goto L_0x009b;
                case 55: goto L_0x008d;
                case 56: goto L_0x0086;
                case 57: goto L_0x007f;
                case 58: goto L_0x0071;
                case 59: goto L_0x0069;
                case 60: goto L_0x005b;
                case 61: goto L_0x0053;
                case 62: goto L_0x004c;
                case 63: goto L_0x0045;
                case 64: goto L_0x003e;
                case 65: goto L_0x0036;
                case 66: goto L_0x002f;
                case 67: goto L_0x0027;
                case 68: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x012a
        L_0x0020:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x0061
        L_0x0027:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x00a8
        L_0x002f:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x004b
        L_0x0036:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x00a8
        L_0x003e:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x004b
        L_0x0045:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
        L_0x004b:
            goto L_0x0093
        L_0x004c:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x0093
        L_0x0053:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x00d1
        L_0x005b:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
        L_0x0061:
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzfl.zzo(r9, r5)
            int r2 = r2 * 53
            goto L_0x00d7
        L_0x0069:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x00ea
        L_0x0071:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            int r2 = r2 * 53
            boolean r3 = zzi(r9, r5)
            goto L_0x00fd
        L_0x007f:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x0093
        L_0x0086:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x00a8
        L_0x008d:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
        L_0x0093:
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0129
        L_0x009b:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x00a8
        L_0x00a2:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
        L_0x00a8:
            int r2 = r2 * 53
            long r3 = zzh(r9, r5)
            goto L_0x0125
        L_0x00b0:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            int r2 = r2 * 53
            float r3 = zzf(r9, r5)
            goto L_0x0116
        L_0x00bd:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            int r2 = r2 * 53
            double r3 = zze(r9, r5)
            goto L_0x0121
        L_0x00ca:
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzfl.zzo(r9, r5)
            if (r3 == 0) goto L_0x00e6
            goto L_0x00e2
        L_0x00d1:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzfl.zzo(r9, r5)
        L_0x00d7:
            int r3 = r3.hashCode()
            goto L_0x0129
        L_0x00dc:
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzfl.zzo(r9, r5)
            if (r3 == 0) goto L_0x00e6
        L_0x00e2:
            int r7 = r3.hashCode()
        L_0x00e6:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x012a
        L_0x00ea:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzfl.zzo(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0129
        L_0x00f7:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.vision.zzfl.zzl(r9, r5)
        L_0x00fd:
            int r3 = com.google.android.gms.internal.vision.zzct.zzc(r3)
            goto L_0x0129
        L_0x0102:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.vision.zzfl.zzj(r9, r5)
            goto L_0x0129
        L_0x0109:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.vision.zzfl.zzk(r9, r5)
            goto L_0x0125
        L_0x0110:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.vision.zzfl.zzm(r9, r5)
        L_0x0116:
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0129
        L_0x011b:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.vision.zzfl.zzn(r9, r5)
        L_0x0121:
            long r3 = java.lang.Double.doubleToLongBits(r3)
        L_0x0125:
            int r3 = com.google.android.gms.internal.vision.zzct.zzk(r3)
        L_0x0129:
            int r2 = r2 + r3
        L_0x012a:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x012e:
            int r2 = r2 * 53
            com.google.android.gms.internal.vision.zzff<?, ?> r0 = r8.zzns
            java.lang.Object r0 = r0.zzr(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zznj
            if (r0 == 0) goto L_0x014c
            int r2 = r2 * 53
            com.google.android.gms.internal.vision.zzcg<?> r0 = r8.zznt
            com.google.android.gms.internal.vision.zzcj r9 = r0.zzb(r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x014c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzeb.hashCode(java.lang.Object):int");
    }

    public final T newInstance() {
        return this.zznq.newInstance(this.zzni);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0385, code lost:
        r15.zzb(r9, com.google.android.gms.internal.vision.zzfl.zzo(r14, (long) (r8 & 1048575)), zzag(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x03a0, code lost:
        r15.zzb(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x03b1, code lost:
        r15.zzg(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x03c2, code lost:
        r15.zzj(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x03d3, code lost:
        r15.zzo(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x03e4, code lost:
        r15.zzp(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x03f5, code lost:
        r15.zzf(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0400, code lost:
        r15.zza(r9, (com.google.android.gms.internal.vision.zzbo) com.google.android.gms.internal.vision.zzfl.zzo(r14, (long) (r8 & 1048575)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0413, code lost:
        r15.zza(r9, com.google.android.gms.internal.vision.zzfl.zzo(r14, (long) (r8 & 1048575)), zzag(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0428, code lost:
        zza(r9, com.google.android.gms.internal.vision.zzfl.zzo(r14, (long) (r8 & 1048575)), r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x043f, code lost:
        r15.zzb(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0450, code lost:
        r15.zzh(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0460, code lost:
        r15.zzc(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0470, code lost:
        r15.zze(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0480, code lost:
        r15.zza(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0490, code lost:
        r15.zzi(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x04a0, code lost:
        r15.zza(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x04b0, code lost:
        r15.zza(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x0843, code lost:
        r15.zzb(r10, com.google.android.gms.internal.vision.zzfl.zzo(r14, (long) (r9 & 1048575)), zzag(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x085e, code lost:
        r15.zzb(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x086f, code lost:
        r15.zzg(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x0880, code lost:
        r15.zzj(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x0891, code lost:
        r15.zzo(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x08a2, code lost:
        r15.zzp(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x08b3, code lost:
        r15.zzf(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x08be, code lost:
        r15.zza(r10, (com.google.android.gms.internal.vision.zzbo) com.google.android.gms.internal.vision.zzfl.zzo(r14, (long) (r9 & 1048575)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x08d1, code lost:
        r15.zza(r10, com.google.android.gms.internal.vision.zzfl.zzo(r14, (long) (r9 & 1048575)), zzag(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x08e6, code lost:
        zza(r10, com.google.android.gms.internal.vision.zzfl.zzo(r14, (long) (r9 & 1048575)), r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:0x08fd, code lost:
        r15.zzb(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x090e, code lost:
        r15.zzh(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:328:0x091e, code lost:
        r15.zzc(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:332:0x092e, code lost:
        r15.zze(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:336:0x093e, code lost:
        r15.zza(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:0x094e, code lost:
        r15.zzi(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:344:0x095e, code lost:
        r15.zza(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:0x096e, code lost:
        r15.zza(r10, r11);
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x04b9  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x04f7  */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x0977  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.vision.zzfz r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zzbc()
            int r1 = com.google.android.gms.internal.vision.zzcr.zzd.zzlk
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x04cf
            com.google.android.gms.internal.vision.zzff<?, ?> r0 = r13.zzns
            zza(r0, r14, (com.google.android.gms.internal.vision.zzfz) r15)
            boolean r0 = r13.zznj
            if (r0 == 0) goto L_0x0030
            com.google.android.gms.internal.vision.zzcg<?> r0 = r13.zznt
            com.google.android.gms.internal.vision.zzcj r0 = r0.zzb(r14)
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0030
            java.util.Iterator r0 = r0.descendingIterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0032
        L_0x0030:
            r0 = r3
            r1 = r0
        L_0x0032:
            int[] r7 = r13.zzne
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0037:
            if (r7 < 0) goto L_0x04b7
            int r8 = r13.zzaj(r7)
            int[] r9 = r13.zzne
            r9 = r9[r7]
        L_0x0041:
            if (r1 == 0) goto L_0x005f
            com.google.android.gms.internal.vision.zzcg<?> r10 = r13.zznt
            int r10 = r10.zza(r1)
            if (r10 <= r9) goto L_0x005f
            com.google.android.gms.internal.vision.zzcg<?> r10 = r13.zznt
            r10.zza((com.google.android.gms.internal.vision.zzfz) r15, (java.util.Map.Entry<?, ?>) r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005d
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0041
        L_0x005d:
            r1 = r3
            goto L_0x0041
        L_0x005f:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x04a4;
                case 1: goto L_0x0494;
                case 2: goto L_0x0484;
                case 3: goto L_0x0474;
                case 4: goto L_0x0464;
                case 5: goto L_0x0454;
                case 6: goto L_0x0444;
                case 7: goto L_0x0433;
                case 8: goto L_0x0422;
                case 9: goto L_0x040d;
                case 10: goto L_0x03fa;
                case 11: goto L_0x03e9;
                case 12: goto L_0x03d8;
                case 13: goto L_0x03c7;
                case 14: goto L_0x03b6;
                case 15: goto L_0x03a5;
                case 16: goto L_0x0394;
                case 17: goto L_0x037f;
                case 18: goto L_0x036e;
                case 19: goto L_0x035d;
                case 20: goto L_0x034c;
                case 21: goto L_0x033b;
                case 22: goto L_0x032a;
                case 23: goto L_0x0319;
                case 24: goto L_0x0308;
                case 25: goto L_0x02f7;
                case 26: goto L_0x02e6;
                case 27: goto L_0x02d1;
                case 28: goto L_0x02c0;
                case 29: goto L_0x02af;
                case 30: goto L_0x029e;
                case 31: goto L_0x028d;
                case 32: goto L_0x027c;
                case 33: goto L_0x026b;
                case 34: goto L_0x025a;
                case 35: goto L_0x0249;
                case 36: goto L_0x0238;
                case 37: goto L_0x0227;
                case 38: goto L_0x0216;
                case 39: goto L_0x0205;
                case 40: goto L_0x01f4;
                case 41: goto L_0x01e3;
                case 42: goto L_0x01d2;
                case 43: goto L_0x01c1;
                case 44: goto L_0x01b0;
                case 45: goto L_0x019f;
                case 46: goto L_0x018e;
                case 47: goto L_0x017d;
                case 48: goto L_0x016c;
                case 49: goto L_0x0157;
                case 50: goto L_0x014c;
                case 51: goto L_0x013e;
                case 52: goto L_0x0130;
                case 53: goto L_0x0122;
                case 54: goto L_0x0114;
                case 55: goto L_0x0106;
                case 56: goto L_0x00f8;
                case 57: goto L_0x00ea;
                case 58: goto L_0x00dc;
                case 59: goto L_0x00d4;
                case 60: goto L_0x00cc;
                case 61: goto L_0x00c4;
                case 62: goto L_0x00b6;
                case 63: goto L_0x00a8;
                case 64: goto L_0x009a;
                case 65: goto L_0x008c;
                case 66: goto L_0x007e;
                case 67: goto L_0x0070;
                case 68: goto L_0x0068;
                default: goto L_0x0066;
            }
        L_0x0066:
            goto L_0x04b3
        L_0x0068:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b3
            goto L_0x0385
        L_0x0070:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            goto L_0x03a0
        L_0x007e:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            goto L_0x03b1
        L_0x008c:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            goto L_0x03c2
        L_0x009a:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            goto L_0x03d3
        L_0x00a8:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            goto L_0x03e4
        L_0x00b6:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            goto L_0x03f5
        L_0x00c4:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b3
            goto L_0x0400
        L_0x00cc:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b3
            goto L_0x0413
        L_0x00d4:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b3
            goto L_0x0428
        L_0x00dc:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzi(r14, r10)
            goto L_0x043f
        L_0x00ea:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            goto L_0x0450
        L_0x00f8:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            goto L_0x0460
        L_0x0106:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            goto L_0x0470
        L_0x0114:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            goto L_0x0480
        L_0x0122:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            goto L_0x0490
        L_0x0130:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzf(r14, r10)
            goto L_0x04a0
        L_0x013e:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zze(r14, r10)
            goto L_0x04b0
        L_0x014c:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            r13.zza((com.google.android.gms.internal.vision.zzfz) r15, (int) r9, (java.lang.Object) r8, (int) r7)
            goto L_0x04b3
        L_0x0157:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzen r10 = r13.zzag(r7)
            com.google.android.gms.internal.vision.zzep.zzb((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.vision.zzfz) r15, (com.google.android.gms.internal.vision.zzen) r10)
            goto L_0x04b3
        L_0x016c:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zze(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x017d:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zzj(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x018e:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zzg(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x019f:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zzl(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x01b0:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zzm(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x01c1:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zzi(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x01d2:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zzn(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x01e3:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zzk(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x01f4:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zzf(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x0205:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zzh(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x0216:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zzd(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x0227:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zzc(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x0238:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.vision.zzfz) r15, (boolean) r4)
            goto L_0x04b3
        L_0x0249:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.vision.zzfz) r15, (boolean) r4)
            goto L_0x04b3
        L_0x025a:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zze(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x026b:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zzj(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x027c:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zzg(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x028d:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zzl(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x029e:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zzm(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x02af:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zzi(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x02c0:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zzb(r9, r8, r15)
            goto L_0x04b3
        L_0x02d1:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzen r10 = r13.zzag(r7)
            com.google.android.gms.internal.vision.zzep.zza((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.vision.zzfz) r15, (com.google.android.gms.internal.vision.zzen) r10)
            goto L_0x04b3
        L_0x02e6:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zza((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.vision.zzfz) r15)
            goto L_0x04b3
        L_0x02f7:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zzn(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x0308:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zzk(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x0319:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zzf(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x032a:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zzh(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x033b:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zzd(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x034c:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zzc(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x035d:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.vision.zzfz) r15, (boolean) r5)
            goto L_0x04b3
        L_0x036e:
            int[] r9 = r13.zzne
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzep.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.vision.zzfz) r15, (boolean) r5)
            goto L_0x04b3
        L_0x037f:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b3
        L_0x0385:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            com.google.android.gms.internal.vision.zzen r10 = r13.zzag(r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.zzen) r10)
            goto L_0x04b3
        L_0x0394:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzfl.zzk(r14, r10)
        L_0x03a0:
            r15.zzb((int) r9, (long) r10)
            goto L_0x04b3
        L_0x03a5:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzfl.zzj(r14, r10)
        L_0x03b1:
            r15.zzg(r9, r8)
            goto L_0x04b3
        L_0x03b6:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzfl.zzk(r14, r10)
        L_0x03c2:
            r15.zzj(r9, r10)
            goto L_0x04b3
        L_0x03c7:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzfl.zzj(r14, r10)
        L_0x03d3:
            r15.zzo(r9, r8)
            goto L_0x04b3
        L_0x03d8:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzfl.zzj(r14, r10)
        L_0x03e4:
            r15.zzp(r9, r8)
            goto L_0x04b3
        L_0x03e9:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzfl.zzj(r14, r10)
        L_0x03f5:
            r15.zzf(r9, r8)
            goto L_0x04b3
        L_0x03fa:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b3
        L_0x0400:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            com.google.android.gms.internal.vision.zzbo r8 = (com.google.android.gms.internal.vision.zzbo) r8
            r15.zza((int) r9, (com.google.android.gms.internal.vision.zzbo) r8)
            goto L_0x04b3
        L_0x040d:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b3
        L_0x0413:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            com.google.android.gms.internal.vision.zzen r10 = r13.zzag(r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.zzen) r10)
            goto L_0x04b3
        L_0x0422:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b3
        L_0x0428:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.zzfz) r15)
            goto L_0x04b3
        L_0x0433:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.vision.zzfl.zzl(r14, r10)
        L_0x043f:
            r15.zzb((int) r9, (boolean) r8)
            goto L_0x04b3
        L_0x0444:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzfl.zzj(r14, r10)
        L_0x0450:
            r15.zzh(r9, r8)
            goto L_0x04b3
        L_0x0454:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzfl.zzk(r14, r10)
        L_0x0460:
            r15.zzc(r9, r10)
            goto L_0x04b3
        L_0x0464:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzfl.zzj(r14, r10)
        L_0x0470:
            r15.zze(r9, r8)
            goto L_0x04b3
        L_0x0474:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzfl.zzk(r14, r10)
        L_0x0480:
            r15.zza((int) r9, (long) r10)
            goto L_0x04b3
        L_0x0484:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzfl.zzk(r14, r10)
        L_0x0490:
            r15.zzi(r9, r10)
            goto L_0x04b3
        L_0x0494:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.vision.zzfl.zzm(r14, r10)
        L_0x04a0:
            r15.zza((int) r9, (float) r8)
            goto L_0x04b3
        L_0x04a4:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.vision.zzfl.zzn(r14, r10)
        L_0x04b0:
            r15.zza((int) r9, (double) r10)
        L_0x04b3:
            int r7 = r7 + -3
            goto L_0x0037
        L_0x04b7:
            if (r1 == 0) goto L_0x04ce
            com.google.android.gms.internal.vision.zzcg<?> r14 = r13.zznt
            r14.zza((com.google.android.gms.internal.vision.zzfz) r15, (java.util.Map.Entry<?, ?>) r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x04cc
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x04b7
        L_0x04cc:
            r1 = r3
            goto L_0x04b7
        L_0x04ce:
            return
        L_0x04cf:
            boolean r0 = r13.zznl
            if (r0 == 0) goto L_0x0992
            boolean r0 = r13.zznj
            if (r0 == 0) goto L_0x04ee
            com.google.android.gms.internal.vision.zzcg<?> r0 = r13.zznt
            com.google.android.gms.internal.vision.zzcj r0 = r0.zzb(r14)
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x04ee
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x04f0
        L_0x04ee:
            r0 = r3
            r1 = r0
        L_0x04f0:
            int[] r7 = r13.zzne
            int r7 = r7.length
            r8 = r1
            r1 = 0
        L_0x04f5:
            if (r1 >= r7) goto L_0x0975
            int r9 = r13.zzaj(r1)
            int[] r10 = r13.zzne
            r10 = r10[r1]
        L_0x04ff:
            if (r8 == 0) goto L_0x051d
            com.google.android.gms.internal.vision.zzcg<?> r11 = r13.zznt
            int r11 = r11.zza(r8)
            if (r11 > r10) goto L_0x051d
            com.google.android.gms.internal.vision.zzcg<?> r11 = r13.zznt
            r11.zza((com.google.android.gms.internal.vision.zzfz) r15, (java.util.Map.Entry<?, ?>) r8)
            boolean r8 = r0.hasNext()
            if (r8 == 0) goto L_0x051b
            java.lang.Object r8 = r0.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            goto L_0x04ff
        L_0x051b:
            r8 = r3
            goto L_0x04ff
        L_0x051d:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0962;
                case 1: goto L_0x0952;
                case 2: goto L_0x0942;
                case 3: goto L_0x0932;
                case 4: goto L_0x0922;
                case 5: goto L_0x0912;
                case 6: goto L_0x0902;
                case 7: goto L_0x08f1;
                case 8: goto L_0x08e0;
                case 9: goto L_0x08cb;
                case 10: goto L_0x08b8;
                case 11: goto L_0x08a7;
                case 12: goto L_0x0896;
                case 13: goto L_0x0885;
                case 14: goto L_0x0874;
                case 15: goto L_0x0863;
                case 16: goto L_0x0852;
                case 17: goto L_0x083d;
                case 18: goto L_0x082c;
                case 19: goto L_0x081b;
                case 20: goto L_0x080a;
                case 21: goto L_0x07f9;
                case 22: goto L_0x07e8;
                case 23: goto L_0x07d7;
                case 24: goto L_0x07c6;
                case 25: goto L_0x07b5;
                case 26: goto L_0x07a4;
                case 27: goto L_0x078f;
                case 28: goto L_0x077e;
                case 29: goto L_0x076d;
                case 30: goto L_0x075c;
                case 31: goto L_0x074b;
                case 32: goto L_0x073a;
                case 33: goto L_0x0729;
                case 34: goto L_0x0718;
                case 35: goto L_0x0707;
                case 36: goto L_0x06f6;
                case 37: goto L_0x06e5;
                case 38: goto L_0x06d4;
                case 39: goto L_0x06c3;
                case 40: goto L_0x06b2;
                case 41: goto L_0x06a1;
                case 42: goto L_0x0690;
                case 43: goto L_0x067f;
                case 44: goto L_0x066e;
                case 45: goto L_0x065d;
                case 46: goto L_0x064c;
                case 47: goto L_0x063b;
                case 48: goto L_0x062a;
                case 49: goto L_0x0615;
                case 50: goto L_0x060a;
                case 51: goto L_0x05fc;
                case 52: goto L_0x05ee;
                case 53: goto L_0x05e0;
                case 54: goto L_0x05d2;
                case 55: goto L_0x05c4;
                case 56: goto L_0x05b6;
                case 57: goto L_0x05a8;
                case 58: goto L_0x059a;
                case 59: goto L_0x0592;
                case 60: goto L_0x058a;
                case 61: goto L_0x0582;
                case 62: goto L_0x0574;
                case 63: goto L_0x0566;
                case 64: goto L_0x0558;
                case 65: goto L_0x054a;
                case 66: goto L_0x053c;
                case 67: goto L_0x052e;
                case 68: goto L_0x0526;
                default: goto L_0x0524;
            }
        L_0x0524:
            goto L_0x0971
        L_0x0526:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0971
            goto L_0x0843
        L_0x052e:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            goto L_0x085e
        L_0x053c:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            goto L_0x086f
        L_0x054a:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            goto L_0x0880
        L_0x0558:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            goto L_0x0891
        L_0x0566:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            goto L_0x08a2
        L_0x0574:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            goto L_0x08b3
        L_0x0582:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0971
            goto L_0x08be
        L_0x058a:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0971
            goto L_0x08d1
        L_0x0592:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0971
            goto L_0x08e6
        L_0x059a:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzi(r14, r11)
            goto L_0x08fd
        L_0x05a8:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            goto L_0x090e
        L_0x05b6:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            goto L_0x091e
        L_0x05c4:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            goto L_0x092e
        L_0x05d2:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            goto L_0x093e
        L_0x05e0:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            goto L_0x094e
        L_0x05ee:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzf(r14, r11)
            goto L_0x095e
        L_0x05fc:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zze(r14, r11)
            goto L_0x096e
        L_0x060a:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            r13.zza((com.google.android.gms.internal.vision.zzfz) r15, (int) r10, (java.lang.Object) r9, (int) r1)
            goto L_0x0971
        L_0x0615:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzen r11 = r13.zzag(r1)
            com.google.android.gms.internal.vision.zzep.zzb((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.vision.zzfz) r15, (com.google.android.gms.internal.vision.zzen) r11)
            goto L_0x0971
        L_0x062a:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zze(r10, r9, r15, r4)
            goto L_0x0971
        L_0x063b:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzj(r10, r9, r15, r4)
            goto L_0x0971
        L_0x064c:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzg(r10, r9, r15, r4)
            goto L_0x0971
        L_0x065d:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzl(r10, r9, r15, r4)
            goto L_0x0971
        L_0x066e:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzm(r10, r9, r15, r4)
            goto L_0x0971
        L_0x067f:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzi(r10, r9, r15, r4)
            goto L_0x0971
        L_0x0690:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzn(r10, r9, r15, r4)
            goto L_0x0971
        L_0x06a1:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzk(r10, r9, r15, r4)
            goto L_0x0971
        L_0x06b2:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzf(r10, r9, r15, r4)
            goto L_0x0971
        L_0x06c3:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzh(r10, r9, r15, r4)
            goto L_0x0971
        L_0x06d4:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzd(r10, r9, r15, r4)
            goto L_0x0971
        L_0x06e5:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzc(r10, r9, r15, r4)
            goto L_0x0971
        L_0x06f6:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.vision.zzfz) r15, (boolean) r4)
            goto L_0x0971
        L_0x0707:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.vision.zzfz) r15, (boolean) r4)
            goto L_0x0971
        L_0x0718:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zze(r10, r9, r15, r5)
            goto L_0x0971
        L_0x0729:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzj(r10, r9, r15, r5)
            goto L_0x0971
        L_0x073a:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzg(r10, r9, r15, r5)
            goto L_0x0971
        L_0x074b:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzl(r10, r9, r15, r5)
            goto L_0x0971
        L_0x075c:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzm(r10, r9, r15, r5)
            goto L_0x0971
        L_0x076d:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzi(r10, r9, r15, r5)
            goto L_0x0971
        L_0x077e:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzb(r10, r9, r15)
            goto L_0x0971
        L_0x078f:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzen r11 = r13.zzag(r1)
            com.google.android.gms.internal.vision.zzep.zza((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.vision.zzfz) r15, (com.google.android.gms.internal.vision.zzen) r11)
            goto L_0x0971
        L_0x07a4:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zza((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.vision.zzfz) r15)
            goto L_0x0971
        L_0x07b5:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzn(r10, r9, r15, r5)
            goto L_0x0971
        L_0x07c6:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzk(r10, r9, r15, r5)
            goto L_0x0971
        L_0x07d7:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzf(r10, r9, r15, r5)
            goto L_0x0971
        L_0x07e8:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzh(r10, r9, r15, r5)
            goto L_0x0971
        L_0x07f9:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzd(r10, r9, r15, r5)
            goto L_0x0971
        L_0x080a:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzc(r10, r9, r15, r5)
            goto L_0x0971
        L_0x081b:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.vision.zzfz) r15, (boolean) r5)
            goto L_0x0971
        L_0x082c:
            int[] r10 = r13.zzne
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzep.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.vision.zzfz) r15, (boolean) r5)
            goto L_0x0971
        L_0x083d:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0971
        L_0x0843:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            com.google.android.gms.internal.vision.zzen r11 = r13.zzag(r1)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.zzen) r11)
            goto L_0x0971
        L_0x0852:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzfl.zzk(r14, r11)
        L_0x085e:
            r15.zzb((int) r10, (long) r11)
            goto L_0x0971
        L_0x0863:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzfl.zzj(r14, r11)
        L_0x086f:
            r15.zzg(r10, r9)
            goto L_0x0971
        L_0x0874:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzfl.zzk(r14, r11)
        L_0x0880:
            r15.zzj(r10, r11)
            goto L_0x0971
        L_0x0885:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzfl.zzj(r14, r11)
        L_0x0891:
            r15.zzo(r10, r9)
            goto L_0x0971
        L_0x0896:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzfl.zzj(r14, r11)
        L_0x08a2:
            r15.zzp(r10, r9)
            goto L_0x0971
        L_0x08a7:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzfl.zzj(r14, r11)
        L_0x08b3:
            r15.zzf(r10, r9)
            goto L_0x0971
        L_0x08b8:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0971
        L_0x08be:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            com.google.android.gms.internal.vision.zzbo r9 = (com.google.android.gms.internal.vision.zzbo) r9
            r15.zza((int) r10, (com.google.android.gms.internal.vision.zzbo) r9)
            goto L_0x0971
        L_0x08cb:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0971
        L_0x08d1:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            com.google.android.gms.internal.vision.zzen r11 = r13.zzag(r1)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.zzen) r11)
            goto L_0x0971
        L_0x08e0:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0971
        L_0x08e6:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzfl.zzo(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.zzfz) r15)
            goto L_0x0971
        L_0x08f1:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.vision.zzfl.zzl(r14, r11)
        L_0x08fd:
            r15.zzb((int) r10, (boolean) r9)
            goto L_0x0971
        L_0x0902:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzfl.zzj(r14, r11)
        L_0x090e:
            r15.zzh(r10, r9)
            goto L_0x0971
        L_0x0912:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzfl.zzk(r14, r11)
        L_0x091e:
            r15.zzc(r10, r11)
            goto L_0x0971
        L_0x0922:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzfl.zzj(r14, r11)
        L_0x092e:
            r15.zze(r10, r9)
            goto L_0x0971
        L_0x0932:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzfl.zzk(r14, r11)
        L_0x093e:
            r15.zza((int) r10, (long) r11)
            goto L_0x0971
        L_0x0942:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzfl.zzk(r14, r11)
        L_0x094e:
            r15.zzi(r10, r11)
            goto L_0x0971
        L_0x0952:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.vision.zzfl.zzm(r14, r11)
        L_0x095e:
            r15.zza((int) r10, (float) r9)
            goto L_0x0971
        L_0x0962:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0971
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.vision.zzfl.zzn(r14, r11)
        L_0x096e:
            r15.zza((int) r10, (double) r11)
        L_0x0971:
            int r1 = r1 + 3
            goto L_0x04f5
        L_0x0975:
            if (r8 == 0) goto L_0x098c
            com.google.android.gms.internal.vision.zzcg<?> r1 = r13.zznt
            r1.zza((com.google.android.gms.internal.vision.zzfz) r15, (java.util.Map.Entry<?, ?>) r8)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x098a
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            r8 = r1
            goto L_0x0975
        L_0x098a:
            r8 = r3
            goto L_0x0975
        L_0x098c:
            com.google.android.gms.internal.vision.zzff<?, ?> r0 = r13.zzns
            zza(r0, r14, (com.google.android.gms.internal.vision.zzfz) r15)
            return
        L_0x0992:
            r13.zzb(r14, (com.google.android.gms.internal.vision.zzfz) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzeb.zza(java.lang.Object, com.google.android.gms.internal.vision.zzfz):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0090, code lost:
        if (r6 == 0) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009b, code lost:
        r1 = r11.zzgq;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009d, code lost:
        r9.putObject(r14, r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f1, code lost:
        r2 = r4;
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0107, code lost:
        if (r6 == 0) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0109, code lost:
        r0 = com.google.android.gms.internal.vision.zzbk.zza(r12, r8, r11);
        r1 = r11.zzgo;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x010f, code lost:
        r9.putInt(r14, r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0120, code lost:
        r0.putLong(r1, r2, r4);
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x013f, code lost:
        r0 = r8 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0141, code lost:
        r1 = r7;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0145, code lost:
        r24 = r7;
        r15 = r8;
        r18 = r9;
        r19 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01c8, code lost:
        if (r0 == r15) goto L_0x0216;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01f5, code lost:
        if (r0 == r15) goto L_0x0216;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0214, code lost:
        if (r0 == r15) goto L_0x0216;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r28, byte[] r29, int r30, int r31, com.google.android.gms.internal.vision.zzbl r32) throws java.io.IOException {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            boolean r0 = r15.zznl
            if (r0 == 0) goto L_0x0241
            sun.misc.Unsafe r9 = zznd
            r10 = -1
            r16 = 0
            r0 = r30
            r1 = -1
            r2 = 0
        L_0x0017:
            if (r0 >= r13) goto L_0x0238
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0029
            int r0 = com.google.android.gms.internal.vision.zzbk.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.vision.zzbl) r11)
            int r3 = r11.zzgo
            r8 = r0
            r17 = r3
            goto L_0x002c
        L_0x0029:
            r17 = r0
            r8 = r3
        L_0x002c:
            int r7 = r17 >>> 3
            r6 = r17 & 7
            if (r7 <= r1) goto L_0x0039
            int r2 = r2 / 3
            int r0 = r15.zzr(r7, r2)
            goto L_0x003d
        L_0x0039:
            int r0 = r15.zzal(r7)
        L_0x003d:
            r4 = r0
            if (r4 != r10) goto L_0x004b
            r24 = r7
            r2 = r8
            r18 = r9
            r19 = 0
            r26 = -1
            goto L_0x0217
        L_0x004b:
            int[] r0 = r15.zzne
            int r1 = r4 + 1
            r5 = r0[r1]
            r0 = 267386880(0xff00000, float:2.3665827E-29)
            r0 = r0 & r5
            int r3 = r0 >>> 20
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r1 = (long) r0
            r0 = 17
            r10 = 2
            if (r3 > r0) goto L_0x014d
            r0 = 1
            switch(r3) {
                case 0: goto L_0x0134;
                case 1: goto L_0x0125;
                case 2: goto L_0x0113;
                case 3: goto L_0x0113;
                case 4: goto L_0x0105;
                case 5: goto L_0x00f5;
                case 6: goto L_0x00e4;
                case 7: goto L_0x00ce;
                case 8: goto L_0x00bc;
                case 9: goto L_0x00a1;
                case 10: goto L_0x0094;
                case 11: goto L_0x0105;
                case 12: goto L_0x008e;
                case 13: goto L_0x00e4;
                case 14: goto L_0x00f5;
                case 15: goto L_0x007e;
                case 16: goto L_0x0066;
                default: goto L_0x0064;
            }
        L_0x0064:
            goto L_0x018a
        L_0x0066:
            if (r6 != 0) goto L_0x018a
            int r6 = com.google.android.gms.internal.vision.zzbk.zzb(r12, r8, r11)
            r19 = r1
            long r0 = r11.zzgp
            long r21 = com.google.android.gms.internal.vision.zzbx.zza(r0)
            r0 = r9
            r2 = r19
            r1 = r28
            r10 = r4
            r4 = r21
            goto L_0x0120
        L_0x007e:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0145
            int r0 = com.google.android.gms.internal.vision.zzbk.zza(r12, r8, r11)
            int r1 = r11.zzgo
            int r1 = com.google.android.gms.internal.vision.zzbx.zzo(r1)
            goto L_0x010f
        L_0x008e:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0145
            goto L_0x0109
        L_0x0094:
            r2 = r1
            if (r6 != r10) goto L_0x018a
            int r0 = com.google.android.gms.internal.vision.zzbk.zze(r12, r8, r11)
        L_0x009b:
            java.lang.Object r1 = r11.zzgq
        L_0x009d:
            r9.putObject(r14, r2, r1)
            goto L_0x00f1
        L_0x00a1:
            r2 = r1
            if (r6 != r10) goto L_0x018a
            com.google.android.gms.internal.vision.zzen r0 = r15.zzag(r4)
            int r0 = zza((com.google.android.gms.internal.vision.zzen) r0, (byte[]) r12, (int) r8, (int) r13, (com.google.android.gms.internal.vision.zzbl) r11)
            java.lang.Object r1 = r9.getObject(r14, r2)
            if (r1 != 0) goto L_0x00b5
            java.lang.Object r1 = r11.zzgq
            goto L_0x009d
        L_0x00b5:
            java.lang.Object r5 = r11.zzgq
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzct.zza((java.lang.Object) r1, (java.lang.Object) r5)
            goto L_0x009d
        L_0x00bc:
            r2 = r1
            if (r6 != r10) goto L_0x018a
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r5
            if (r0 != 0) goto L_0x00c9
            int r0 = com.google.android.gms.internal.vision.zzbk.zzc(r12, r8, r11)
            goto L_0x009b
        L_0x00c9:
            int r0 = com.google.android.gms.internal.vision.zzbk.zzd(r12, r8, r11)
            goto L_0x009b
        L_0x00ce:
            r2 = r1
            if (r6 != 0) goto L_0x018a
            int r1 = com.google.android.gms.internal.vision.zzbk.zzb(r12, r8, r11)
            long r5 = r11.zzgp
            r19 = 0
            int r8 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r8 == 0) goto L_0x00de
            goto L_0x00df
        L_0x00de:
            r0 = 0
        L_0x00df:
            com.google.android.gms.internal.vision.zzfl.zza((java.lang.Object) r14, (long) r2, (boolean) r0)
            r0 = r1
            goto L_0x00f1
        L_0x00e4:
            r2 = r1
            r0 = 5
            if (r6 != r0) goto L_0x018a
            int r0 = com.google.android.gms.internal.vision.zzbk.zza(r12, r8)
            r9.putInt(r14, r2, r0)
            int r0 = r8 + 4
        L_0x00f1:
            r2 = r4
            r1 = r7
            goto L_0x0235
        L_0x00f5:
            r2 = r1
            if (r6 != r0) goto L_0x018a
            long r5 = com.google.android.gms.internal.vision.zzbk.zzb(r12, r8)
            r0 = r9
            r1 = r28
            r10 = r4
            r4 = r5
            r0.putLong(r1, r2, r4)
            goto L_0x013f
        L_0x0105:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0145
        L_0x0109:
            int r0 = com.google.android.gms.internal.vision.zzbk.zza(r12, r8, r11)
            int r1 = r11.zzgo
        L_0x010f:
            r9.putInt(r14, r2, r1)
            goto L_0x0141
        L_0x0113:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0145
            int r6 = com.google.android.gms.internal.vision.zzbk.zzb(r12, r8, r11)
            long r4 = r11.zzgp
            r0 = r9
            r1 = r28
        L_0x0120:
            r0.putLong(r1, r2, r4)
            r0 = r6
            goto L_0x0141
        L_0x0125:
            r2 = r1
            r10 = r4
            r0 = 5
            if (r6 != r0) goto L_0x0145
            float r0 = com.google.android.gms.internal.vision.zzbk.zzd(r12, r8)
            com.google.android.gms.internal.vision.zzfl.zza((java.lang.Object) r14, (long) r2, (float) r0)
            int r0 = r8 + 4
            goto L_0x0141
        L_0x0134:
            r2 = r1
            r10 = r4
            if (r6 != r0) goto L_0x0145
            double r0 = com.google.android.gms.internal.vision.zzbk.zzc(r12, r8)
            com.google.android.gms.internal.vision.zzfl.zza((java.lang.Object) r14, (long) r2, (double) r0)
        L_0x013f:
            int r0 = r8 + 8
        L_0x0141:
            r1 = r7
            r2 = r10
            goto L_0x0235
        L_0x0145:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            goto L_0x0191
        L_0x014d:
            r0 = 27
            if (r3 != r0) goto L_0x0195
            if (r6 != r10) goto L_0x018a
            java.lang.Object r0 = r9.getObject(r14, r1)
            com.google.android.gms.internal.vision.zzcw r0 = (com.google.android.gms.internal.vision.zzcw) r0
            boolean r3 = r0.zzan()
            if (r3 != 0) goto L_0x0171
            int r3 = r0.size()
            if (r3 != 0) goto L_0x0168
            r3 = 10
            goto L_0x016a
        L_0x0168:
            int r3 = r3 << 1
        L_0x016a:
            com.google.android.gms.internal.vision.zzcw r0 = r0.zzk(r3)
            r9.putObject(r14, r1, r0)
        L_0x0171:
            r5 = r0
            com.google.android.gms.internal.vision.zzen r0 = r15.zzag(r4)
            r1 = r17
            r2 = r29
            r3 = r8
            r19 = r4
            r4 = r31
            r6 = r32
            int r0 = zza((com.google.android.gms.internal.vision.zzen<?>) r0, (int) r1, (byte[]) r2, (int) r3, (int) r4, (com.google.android.gms.internal.vision.zzcw<?>) r5, (com.google.android.gms.internal.vision.zzbl) r6)
            r1 = r7
            r2 = r19
            goto L_0x0235
        L_0x018a:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
        L_0x0191:
            r26 = -1
            goto L_0x01f8
        L_0x0195:
            r19 = r4
            r0 = 49
            if (r3 > r0) goto L_0x01cb
            long r4 = (long) r5
            r0 = r27
            r20 = r1
            r1 = r28
            r2 = r29
            r10 = r3
            r3 = r8
            r22 = r4
            r4 = r31
            r5 = r17
            r30 = r6
            r6 = r7
            r24 = r7
            r7 = r30
            r15 = r8
            r8 = r19
            r18 = r9
            r25 = r10
            r26 = -1
            r9 = r22
            r11 = r25
            r12 = r20
            r14 = r32
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.vision.zzbl) r14)
            if (r0 != r15) goto L_0x0225
            goto L_0x0216
        L_0x01cb:
            r20 = r1
            r25 = r3
            r30 = r6
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            r0 = 50
            r9 = r25
            if (r9 != r0) goto L_0x01fa
            r7 = r30
            if (r7 != r10) goto L_0x01f8
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r19
            r6 = r20
            r8 = r32
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.vision.zzbl) r8)
            if (r0 != r15) goto L_0x0225
            goto L_0x0216
        L_0x01f8:
            r2 = r15
            goto L_0x0217
        L_0x01fa:
            r7 = r30
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r8 = r5
            r5 = r17
            r6 = r24
            r10 = r20
            r12 = r19
            r13 = r32
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.vision.zzbl) r13)
            if (r0 != r15) goto L_0x0225
        L_0x0216:
            r2 = r0
        L_0x0217:
            r0 = r17
            r1 = r29
            r3 = r31
            r4 = r28
            r5 = r32
            int r0 = zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzbl) r5)
        L_0x0225:
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r18
            r2 = r19
            r1 = r24
        L_0x0235:
            r10 = -1
            goto L_0x0017
        L_0x0238:
            r4 = r13
            if (r0 != r4) goto L_0x023c
            return
        L_0x023c:
            com.google.android.gms.internal.vision.zzcx r0 = com.google.android.gms.internal.vision.zzcx.zzcf()
            throw r0
        L_0x0241:
            r4 = r13
            r5 = 0
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r6 = r32
            r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (com.google.android.gms.internal.vision.zzbl) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzeb.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.vision.zzbl):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
        com.google.android.gms.internal.vision.zzfl.zza((java.lang.Object) r7, r2, com.google.android.gms.internal.vision.zzfl.zzo(r8, r2));
        zzb(r7, r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0089, code lost:
        com.google.android.gms.internal.vision.zzfl.zza((java.lang.Object) r7, r2, com.google.android.gms.internal.vision.zzfl.zzo(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b3, code lost:
        com.google.android.gms.internal.vision.zzfl.zza((java.lang.Object) r7, r2, com.google.android.gms.internal.vision.zzfl.zzj(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c8, code lost:
        com.google.android.gms.internal.vision.zzfl.zza((java.lang.Object) r7, r2, com.google.android.gms.internal.vision.zzfl.zzk(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00eb, code lost:
        zzb(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ee, code lost:
        r0 = r0 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(T r7, T r8) {
        /*
            r6 = this;
            if (r8 == 0) goto L_0x0105
            r0 = 0
        L_0x0003:
            int[] r1 = r6.zzne
            int r1 = r1.length
            if (r0 >= r1) goto L_0x00f2
            int r1 = r6.zzaj(r0)
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r1
            long r2 = (long) r2
            int[] r4 = r6.zzne
            r4 = r4[r0]
            r5 = 267386880(0xff00000, float:2.3665827E-29)
            r1 = r1 & r5
            int r1 = r1 >>> 20
            switch(r1) {
                case 0: goto L_0x00de;
                case 1: goto L_0x00d0;
                case 2: goto L_0x00c2;
                case 3: goto L_0x00bb;
                case 4: goto L_0x00ad;
                case 5: goto L_0x00a6;
                case 6: goto L_0x009f;
                case 7: goto L_0x0091;
                case 8: goto L_0x0083;
                case 9: goto L_0x007e;
                case 10: goto L_0x0077;
                case 11: goto L_0x0070;
                case 12: goto L_0x0069;
                case 13: goto L_0x0062;
                case 14: goto L_0x005a;
                case 15: goto L_0x0053;
                case 16: goto L_0x004b;
                case 17: goto L_0x007e;
                case 18: goto L_0x0044;
                case 19: goto L_0x0044;
                case 20: goto L_0x0044;
                case 21: goto L_0x0044;
                case 22: goto L_0x0044;
                case 23: goto L_0x0044;
                case 24: goto L_0x0044;
                case 25: goto L_0x0044;
                case 26: goto L_0x0044;
                case 27: goto L_0x0044;
                case 28: goto L_0x0044;
                case 29: goto L_0x0044;
                case 30: goto L_0x0044;
                case 31: goto L_0x0044;
                case 32: goto L_0x0044;
                case 33: goto L_0x0044;
                case 34: goto L_0x0044;
                case 35: goto L_0x0044;
                case 36: goto L_0x0044;
                case 37: goto L_0x0044;
                case 38: goto L_0x0044;
                case 39: goto L_0x0044;
                case 40: goto L_0x0044;
                case 41: goto L_0x0044;
                case 42: goto L_0x0044;
                case 43: goto L_0x0044;
                case 44: goto L_0x0044;
                case 45: goto L_0x0044;
                case 46: goto L_0x0044;
                case 47: goto L_0x0044;
                case 48: goto L_0x0044;
                case 49: goto L_0x0044;
                case 50: goto L_0x003d;
                case 51: goto L_0x002b;
                case 52: goto L_0x002b;
                case 53: goto L_0x002b;
                case 54: goto L_0x002b;
                case 55: goto L_0x002b;
                case 56: goto L_0x002b;
                case 57: goto L_0x002b;
                case 58: goto L_0x002b;
                case 59: goto L_0x002b;
                case 60: goto L_0x0026;
                case 61: goto L_0x001f;
                case 62: goto L_0x001f;
                case 63: goto L_0x001f;
                case 64: goto L_0x001f;
                case 65: goto L_0x001f;
                case 66: goto L_0x001f;
                case 67: goto L_0x001f;
                case 68: goto L_0x0026;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x00ee
        L_0x001f:
            boolean r1 = r6.zza(r8, (int) r4, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x0031
        L_0x0026:
            r6.zzb(r7, r8, (int) r0)
            goto L_0x00ee
        L_0x002b:
            boolean r1 = r6.zza(r8, (int) r4, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x0031:
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzfl.zzo(r8, r2)
            com.google.android.gms.internal.vision.zzfl.zza((java.lang.Object) r7, (long) r2, (java.lang.Object) r1)
            r6.zzb(r7, (int) r4, (int) r0)
            goto L_0x00ee
        L_0x003d:
            com.google.android.gms.internal.vision.zzds r1 = r6.zznu
            com.google.android.gms.internal.vision.zzep.zza((com.google.android.gms.internal.vision.zzds) r1, r7, r8, (long) r2)
            goto L_0x00ee
        L_0x0044:
            com.google.android.gms.internal.vision.zzdh r1 = r6.zznr
            r1.zza(r7, r8, r2)
            goto L_0x00ee
        L_0x004b:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x0053:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x006f
        L_0x005a:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x0062:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x006f
        L_0x0069:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x006f:
            goto L_0x00b3
        L_0x0070:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00b3
        L_0x0077:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x0089
        L_0x007e:
            r6.zza(r7, r8, (int) r0)
            goto L_0x00ee
        L_0x0083:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x0089:
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzfl.zzo(r8, r2)
            com.google.android.gms.internal.vision.zzfl.zza((java.lang.Object) r7, (long) r2, (java.lang.Object) r1)
            goto L_0x00eb
        L_0x0091:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            boolean r1 = com.google.android.gms.internal.vision.zzfl.zzl(r8, r2)
            com.google.android.gms.internal.vision.zzfl.zza((java.lang.Object) r7, (long) r2, (boolean) r1)
            goto L_0x00eb
        L_0x009f:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00b3
        L_0x00a6:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x00ad:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x00b3:
            int r1 = com.google.android.gms.internal.vision.zzfl.zzj(r8, r2)
            com.google.android.gms.internal.vision.zzfl.zza((java.lang.Object) r7, (long) r2, (int) r1)
            goto L_0x00eb
        L_0x00bb:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x00c2:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x00c8:
            long r4 = com.google.android.gms.internal.vision.zzfl.zzk(r8, r2)
            com.google.android.gms.internal.vision.zzfl.zza((java.lang.Object) r7, (long) r2, (long) r4)
            goto L_0x00eb
        L_0x00d0:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            float r1 = com.google.android.gms.internal.vision.zzfl.zzm(r8, r2)
            com.google.android.gms.internal.vision.zzfl.zza((java.lang.Object) r7, (long) r2, (float) r1)
            goto L_0x00eb
        L_0x00de:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            double r4 = com.google.android.gms.internal.vision.zzfl.zzn(r8, r2)
            com.google.android.gms.internal.vision.zzfl.zza((java.lang.Object) r7, (long) r2, (double) r4)
        L_0x00eb:
            r6.zzb(r7, (int) r0)
        L_0x00ee:
            int r0 = r0 + 3
            goto L_0x0003
        L_0x00f2:
            boolean r0 = r6.zznl
            if (r0 != 0) goto L_0x0104
            com.google.android.gms.internal.vision.zzff<?, ?> r0 = r6.zzns
            com.google.android.gms.internal.vision.zzep.zza(r0, r7, r8)
            boolean r0 = r6.zznj
            if (r0 == 0) goto L_0x0104
            com.google.android.gms.internal.vision.zzcg<?> r0 = r6.zznt
            com.google.android.gms.internal.vision.zzep.zza(r0, r7, r8)
        L_0x0104:
            return
        L_0x0105:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            r7.<init>()
            goto L_0x010c
        L_0x010b:
            throw r7
        L_0x010c:
            goto L_0x010b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzeb.zzc(java.lang.Object, java.lang.Object):void");
    }

    public final void zzd(T t) {
        int i;
        int i2 = this.zzno;
        while (true) {
            i = this.zznp;
            if (i2 >= i) {
                break;
            }
            long zzaj = (long) (zzaj(this.zznn[i2]) & 1048575);
            Object zzo = zzfl.zzo(t, zzaj);
            if (zzo != null) {
                zzfl.zza((Object) t, zzaj, this.zznu.zzk(zzo));
            }
            i2++;
        }
        int length = this.zznn.length;
        while (i < length) {
            this.zznr.zza(t, (long) this.zznn[i]);
            i++;
        }
        this.zzns.zzd(t);
        if (this.zznj) {
            this.zznt.zzd(t);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01d8, code lost:
        if (r0.zznm != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01e9, code lost:
        if (r0.zznm != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01fa, code lost:
        if (r0.zznm != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x020b, code lost:
        if (r0.zznm != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x020d, code lost:
        r2.putInt(r1, (long) r14, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0211, code lost:
        r3 = (com.google.android.gms.internal.vision.zzca.zzt(r3) + com.google.android.gms.internal.vision.zzca.zzv(r5)) + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0296, code lost:
        r13 = r13 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x029f, code lost:
        r3 = com.google.android.gms.internal.vision.zzca.zzc(r3, (com.google.android.gms.internal.vision.zzdx) com.google.android.gms.internal.vision.zzfl.zzo(r1, r5), zzag(r12));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02b8, code lost:
        r3 = com.google.android.gms.internal.vision.zzca.zzf(r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02c7, code lost:
        r3 = com.google.android.gms.internal.vision.zzca.zzk(r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x02d2, code lost:
        r3 = com.google.android.gms.internal.vision.zzca.zzh(r3, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x02dd, code lost:
        r3 = com.google.android.gms.internal.vision.zzca.zzm(r3, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02ec, code lost:
        r3 = com.google.android.gms.internal.vision.zzca.zzn(r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x02fb, code lost:
        r3 = com.google.android.gms.internal.vision.zzca.zzj(r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0306, code lost:
        r5 = com.google.android.gms.internal.vision.zzfl.zzo(r1, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x030a, code lost:
        r3 = com.google.android.gms.internal.vision.zzca.zzc(r3, (com.google.android.gms.internal.vision.zzbo) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0317, code lost:
        r3 = com.google.android.gms.internal.vision.zzep.zzc(r3, com.google.android.gms.internal.vision.zzfl.zzo(r1, r5), zzag(r12));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0331, code lost:
        if ((r5 instanceof com.google.android.gms.internal.vision.zzbo) != false) goto L_0x030a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0334, code lost:
        r3 = com.google.android.gms.internal.vision.zzca.zzb(r3, (java.lang.String) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0342, code lost:
        r3 = com.google.android.gms.internal.vision.zzca.zzc(r3, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x034e, code lost:
        r3 = com.google.android.gms.internal.vision.zzca.zzl(r3, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x035a, code lost:
        r3 = com.google.android.gms.internal.vision.zzca.zzg(r3, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x036a, code lost:
        r3 = com.google.android.gms.internal.vision.zzca.zzi(r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x037a, code lost:
        r3 = com.google.android.gms.internal.vision.zzca.zze(r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x038a, code lost:
        r3 = com.google.android.gms.internal.vision.zzca.zzd(r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0396, code lost:
        r3 = com.google.android.gms.internal.vision.zzca.zzb(r3, (float) com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_RED);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x03a2, code lost:
        r3 = com.google.android.gms.internal.vision.zzca.zzb(r3, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x03aa, code lost:
        r12 = r12 + 3;
        r3 = 267386880;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x0417, code lost:
        if (zza(r1, r15, r3) != false) goto L_0x06b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x0437, code lost:
        if (zza(r1, r15, r3) != false) goto L_0x06e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x043f, code lost:
        if (zza(r1, r15, r3) != false) goto L_0x06f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x045f, code lost:
        if (zza(r1, r15, r3) != false) goto L_0x0716;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0467, code lost:
        if (zza(r1, r15, r3) != false) goto L_0x0725;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0477, code lost:
        if ((r4 instanceof com.google.android.gms.internal.vision.zzbo) != false) goto L_0x071a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x047f, code lost:
        if (zza(r1, r15, r3) != false) goto L_0x074c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x0517, code lost:
        if (r0.zznm != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x0529, code lost:
        if (r0.zznm != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x053b, code lost:
        if (r0.zznm != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x054d, code lost:
        if (r0.zznm != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x055f, code lost:
        if (r0.zznm != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x0571, code lost:
        if (r0.zznm != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x0583, code lost:
        if (r0.zznm != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x0595, code lost:
        if (r0.zznm != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x05a6, code lost:
        if (r0.zznm != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:309:0x05b7, code lost:
        if (r0.zznm != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x05c8, code lost:
        if (r0.zznm != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:317:0x05d9, code lost:
        if (r0.zznm != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:321:0x05ea, code lost:
        if (r0.zznm != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x05fb, code lost:
        if (r0.zznm != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:326:0x05fd, code lost:
        r2.putInt(r1, (long) r11, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:327:0x0601, code lost:
        r9 = (com.google.android.gms.internal.vision.zzca.zzt(r15) + com.google.android.gms.internal.vision.zzca.zzv(r4)) + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:341:0x06ac, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:343:0x06ae, code lost:
        r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:345:0x06b7, code lost:
        if ((r12 & r18) != 0) goto L_0x06b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:0x06b9, code lost:
        r4 = com.google.android.gms.internal.vision.zzca.zzc(r15, (com.google.android.gms.internal.vision.zzdx) r2.getObject(r1, r9), zzag(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:350:0x06d0, code lost:
        r4 = com.google.android.gms.internal.vision.zzca.zzf(r15, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:354:0x06dd, code lost:
        r4 = com.google.android.gms.internal.vision.zzca.zzk(r15, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:0x06e4, code lost:
        if ((r12 & r18) != 0) goto L_0x06e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:357:0x06e6, code lost:
        r4 = com.google.android.gms.internal.vision.zzca.zzh(r15, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x06ef, code lost:
        if ((r12 & r18) != 0) goto L_0x06f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:0x06f1, code lost:
        r9 = com.google.android.gms.internal.vision.zzca.zzm(r15, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:0x06f6, code lost:
        r5 = r5 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:0x0700, code lost:
        r4 = com.google.android.gms.internal.vision.zzca.zzn(r15, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:0x070d, code lost:
        r4 = com.google.android.gms.internal.vision.zzca.zzj(r15, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:0x0714, code lost:
        if ((r12 & r18) != 0) goto L_0x0716;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:0x0716, code lost:
        r4 = r2.getObject(r1, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:0x071a, code lost:
        r4 = com.google.android.gms.internal.vision.zzca.zzc(r15, (com.google.android.gms.internal.vision.zzbo) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:0x0723, code lost:
        if ((r12 & r18) != 0) goto L_0x0725;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x0725, code lost:
        r4 = com.google.android.gms.internal.vision.zzep.zzc(r15, r2.getObject(r1, r9), zzag(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ab, code lost:
        if ((r5 instanceof com.google.android.gms.internal.vision.zzbo) != false) goto L_0x030a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:380:0x073d, code lost:
        if ((r4 instanceof com.google.android.gms.internal.vision.zzbo) != false) goto L_0x071a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:381:0x0740, code lost:
        r4 = com.google.android.gms.internal.vision.zzca.zzb(r15, (java.lang.String) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:383:0x074a, code lost:
        if ((r12 & r18) != 0) goto L_0x074c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:384:0x074c, code lost:
        r4 = com.google.android.gms.internal.vision.zzca.zzc(r15, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:401:0x079c, code lost:
        r5 = r5 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:410:0x07be, code lost:
        r3 = r3 + 3;
        r9 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0127, code lost:
        if (r0.zznm != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0139, code lost:
        if (r0.zznm != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x014b, code lost:
        if (r0.zznm != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x015d, code lost:
        if (r0.zznm != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x016f, code lost:
        if (r0.zznm != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0181, code lost:
        if (r0.zznm != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0193, code lost:
        if (r0.zznm != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01a5, code lost:
        if (r0.zznm != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01b6, code lost:
        if (r0.zznm != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01c7, code lost:
        if (r0.zznm != false) goto L_0x020d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzn(T r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            boolean r2 = r0.zznl
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 0
            r7 = 1
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r9 = 0
            r11 = 0
            if (r2 == 0) goto L_0x03b8
            sun.misc.Unsafe r2 = zznd
            r12 = 0
            r13 = 0
        L_0x0016:
            int[] r14 = r0.zzne
            int r14 = r14.length
            if (r12 >= r14) goto L_0x03b0
            int r14 = r0.zzaj(r12)
            r15 = r14 & r3
            int r15 = r15 >>> 20
            int[] r3 = r0.zzne
            r3 = r3[r12]
            r14 = r14 & r8
            long r5 = (long) r14
            com.google.android.gms.internal.vision.zzcm r14 = com.google.android.gms.internal.vision.zzcm.DOUBLE_LIST_PACKED
            int r14 = r14.id()
            if (r15 < r14) goto L_0x0041
            com.google.android.gms.internal.vision.zzcm r14 = com.google.android.gms.internal.vision.zzcm.SINT64_LIST_PACKED
            int r14 = r14.id()
            if (r15 > r14) goto L_0x0041
            int[] r14 = r0.zzne
            int r17 = r12 + 2
            r14 = r14[r17]
            r14 = r14 & r8
            goto L_0x0042
        L_0x0041:
            r14 = 0
        L_0x0042:
            switch(r15) {
                case 0: goto L_0x039c;
                case 1: goto L_0x0390;
                case 2: goto L_0x0380;
                case 3: goto L_0x0370;
                case 4: goto L_0x0360;
                case 5: goto L_0x0354;
                case 6: goto L_0x0348;
                case 7: goto L_0x033c;
                case 8: goto L_0x0325;
                case 9: goto L_0x0311;
                case 10: goto L_0x0300;
                case 11: goto L_0x02f1;
                case 12: goto L_0x02e2;
                case 13: goto L_0x02d7;
                case 14: goto L_0x02cc;
                case 15: goto L_0x02bd;
                case 16: goto L_0x02ae;
                case 17: goto L_0x0299;
                case 18: goto L_0x028e;
                case 19: goto L_0x0285;
                case 20: goto L_0x027c;
                case 21: goto L_0x0273;
                case 22: goto L_0x026a;
                case 23: goto L_0x028e;
                case 24: goto L_0x0285;
                case 25: goto L_0x0261;
                case 26: goto L_0x0258;
                case 27: goto L_0x024b;
                case 28: goto L_0x0242;
                case 29: goto L_0x0239;
                case 30: goto L_0x0230;
                case 31: goto L_0x0285;
                case 32: goto L_0x028e;
                case 33: goto L_0x0227;
                case 34: goto L_0x021d;
                case 35: goto L_0x01fd;
                case 36: goto L_0x01ec;
                case 37: goto L_0x01db;
                case 38: goto L_0x01ca;
                case 39: goto L_0x01b9;
                case 40: goto L_0x01a8;
                case 41: goto L_0x0197;
                case 42: goto L_0x0185;
                case 43: goto L_0x0173;
                case 44: goto L_0x0161;
                case 45: goto L_0x014f;
                case 46: goto L_0x013d;
                case 47: goto L_0x012b;
                case 48: goto L_0x0119;
                case 49: goto L_0x010b;
                case 50: goto L_0x00fb;
                case 51: goto L_0x00f3;
                case 52: goto L_0x00eb;
                case 53: goto L_0x00df;
                case 54: goto L_0x00d3;
                case 55: goto L_0x00c7;
                case 56: goto L_0x00bf;
                case 57: goto L_0x00b7;
                case 58: goto L_0x00af;
                case 59: goto L_0x009f;
                case 60: goto L_0x0097;
                case 61: goto L_0x008f;
                case 62: goto L_0x0083;
                case 63: goto L_0x0077;
                case 64: goto L_0x006f;
                case 65: goto L_0x0067;
                case 66: goto L_0x005b;
                case 67: goto L_0x004f;
                case 68: goto L_0x0047;
                default: goto L_0x0045;
            }
        L_0x0045:
            goto L_0x03aa
        L_0x0047:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x03aa
            goto L_0x029f
        L_0x004f:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x03aa
            long r5 = zzh(r1, r5)
            goto L_0x02b8
        L_0x005b:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x03aa
            int r5 = zzg(r1, r5)
            goto L_0x02c7
        L_0x0067:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x03aa
            goto L_0x02d2
        L_0x006f:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x03aa
            goto L_0x02dd
        L_0x0077:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x03aa
            int r5 = zzg(r1, r5)
            goto L_0x02ec
        L_0x0083:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x03aa
            int r5 = zzg(r1, r5)
            goto L_0x02fb
        L_0x008f:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x03aa
            goto L_0x0306
        L_0x0097:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x03aa
            goto L_0x0317
        L_0x009f:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x03aa
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzfl.zzo(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.vision.zzbo
            if (r6 == 0) goto L_0x0334
            goto L_0x0333
        L_0x00af:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x03aa
            goto L_0x0342
        L_0x00b7:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x03aa
            goto L_0x034e
        L_0x00bf:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x03aa
            goto L_0x035a
        L_0x00c7:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x03aa
            int r5 = zzg(r1, r5)
            goto L_0x036a
        L_0x00d3:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x03aa
            long r5 = zzh(r1, r5)
            goto L_0x037a
        L_0x00df:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x03aa
            long r5 = zzh(r1, r5)
            goto L_0x038a
        L_0x00eb:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x03aa
            goto L_0x0396
        L_0x00f3:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x03aa
            goto L_0x03a2
        L_0x00fb:
            com.google.android.gms.internal.vision.zzds r14 = r0.zznu
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzfl.zzo(r1, r5)
            java.lang.Object r6 = r0.zzah(r12)
            int r3 = r14.zzb(r3, r5, r6)
            goto L_0x0296
        L_0x010b:
            java.util.List r5 = zzd(r1, r5)
            com.google.android.gms.internal.vision.zzen r6 = r0.zzag(r12)
            int r3 = com.google.android.gms.internal.vision.zzep.zzd(r3, r5, r6)
            goto L_0x0296
        L_0x0119:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzep.zzc(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zznm
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x012b:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzep.zzg(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zznm
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x013d:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzep.zzi(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zznm
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x014f:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzep.zzh(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zznm
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x0161:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzep.zzd((java.util.List<java.lang.Integer>) r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zznm
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x0173:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzep.zzf((java.util.List<java.lang.Integer>) r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zznm
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x0185:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzep.zzj(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zznm
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x0197:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzep.zzh(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zznm
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x01a8:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzep.zzi(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zznm
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x01b9:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzep.zze(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zznm
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x01ca:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzep.zzb(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zznm
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x01db:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzep.zza(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zznm
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x01ec:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzep.zzh(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zznm
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x01fd:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzep.zzi(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zznm
            if (r6 == 0) goto L_0x0211
        L_0x020d:
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0211:
            int r3 = com.google.android.gms.internal.vision.zzca.zzt(r3)
            int r6 = com.google.android.gms.internal.vision.zzca.zzv(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            goto L_0x0296
        L_0x021d:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzep.zzq(r3, r5, r11)
            goto L_0x0296
        L_0x0227:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzep.zzu(r3, r5, r11)
            goto L_0x0296
        L_0x0230:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzep.zzr(r3, r5, r11)
            goto L_0x0296
        L_0x0239:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzep.zzt(r3, r5, r11)
            goto L_0x0296
        L_0x0242:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzep.zzd((int) r3, (java.util.List<com.google.android.gms.internal.vision.zzbo>) r5)
            goto L_0x0296
        L_0x024b:
            java.util.List r5 = zzd(r1, r5)
            com.google.android.gms.internal.vision.zzen r6 = r0.zzag(r12)
            int r3 = com.google.android.gms.internal.vision.zzep.zzc((int) r3, (java.util.List<?>) r5, (com.google.android.gms.internal.vision.zzen) r6)
            goto L_0x0296
        L_0x0258:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzep.zzc(r3, r5)
            goto L_0x0296
        L_0x0261:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzep.zzx(r3, r5, r11)
            goto L_0x0296
        L_0x026a:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzep.zzs(r3, r5, r11)
            goto L_0x0296
        L_0x0273:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzep.zzp(r3, r5, r11)
            goto L_0x0296
        L_0x027c:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzep.zzo(r3, r5, r11)
            goto L_0x0296
        L_0x0285:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzep.zzv(r3, r5, r11)
            goto L_0x0296
        L_0x028e:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzep.zzw(r3, r5, r11)
        L_0x0296:
            int r13 = r13 + r3
            goto L_0x03aa
        L_0x0299:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x03aa
        L_0x029f:
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzfl.zzo(r1, r5)
            com.google.android.gms.internal.vision.zzdx r5 = (com.google.android.gms.internal.vision.zzdx) r5
            com.google.android.gms.internal.vision.zzen r6 = r0.zzag(r12)
            int r3 = com.google.android.gms.internal.vision.zzca.zzc(r3, r5, r6)
            goto L_0x0296
        L_0x02ae:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x03aa
            long r5 = com.google.android.gms.internal.vision.zzfl.zzk(r1, r5)
        L_0x02b8:
            int r3 = com.google.android.gms.internal.vision.zzca.zzf((int) r3, (long) r5)
            goto L_0x0296
        L_0x02bd:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x03aa
            int r5 = com.google.android.gms.internal.vision.zzfl.zzj(r1, r5)
        L_0x02c7:
            int r3 = com.google.android.gms.internal.vision.zzca.zzk(r3, r5)
            goto L_0x0296
        L_0x02cc:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x03aa
        L_0x02d2:
            int r3 = com.google.android.gms.internal.vision.zzca.zzh((int) r3, (long) r9)
            goto L_0x0296
        L_0x02d7:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x03aa
        L_0x02dd:
            int r3 = com.google.android.gms.internal.vision.zzca.zzm(r3, r11)
            goto L_0x0296
        L_0x02e2:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x03aa
            int r5 = com.google.android.gms.internal.vision.zzfl.zzj(r1, r5)
        L_0x02ec:
            int r3 = com.google.android.gms.internal.vision.zzca.zzn(r3, r5)
            goto L_0x0296
        L_0x02f1:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x03aa
            int r5 = com.google.android.gms.internal.vision.zzfl.zzj(r1, r5)
        L_0x02fb:
            int r3 = com.google.android.gms.internal.vision.zzca.zzj(r3, r5)
            goto L_0x0296
        L_0x0300:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x03aa
        L_0x0306:
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzfl.zzo(r1, r5)
        L_0x030a:
            com.google.android.gms.internal.vision.zzbo r5 = (com.google.android.gms.internal.vision.zzbo) r5
            int r3 = com.google.android.gms.internal.vision.zzca.zzc((int) r3, (com.google.android.gms.internal.vision.zzbo) r5)
            goto L_0x0296
        L_0x0311:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x03aa
        L_0x0317:
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzfl.zzo(r1, r5)
            com.google.android.gms.internal.vision.zzen r6 = r0.zzag(r12)
            int r3 = com.google.android.gms.internal.vision.zzep.zzc((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.vision.zzen) r6)
            goto L_0x0296
        L_0x0325:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x03aa
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzfl.zzo(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.vision.zzbo
            if (r6 == 0) goto L_0x0334
        L_0x0333:
            goto L_0x030a
        L_0x0334:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.vision.zzca.zzb((int) r3, (java.lang.String) r5)
            goto L_0x0296
        L_0x033c:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x03aa
        L_0x0342:
            int r3 = com.google.android.gms.internal.vision.zzca.zzc((int) r3, (boolean) r7)
            goto L_0x0296
        L_0x0348:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x03aa
        L_0x034e:
            int r3 = com.google.android.gms.internal.vision.zzca.zzl(r3, r11)
            goto L_0x0296
        L_0x0354:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x03aa
        L_0x035a:
            int r3 = com.google.android.gms.internal.vision.zzca.zzg((int) r3, (long) r9)
            goto L_0x0296
        L_0x0360:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x03aa
            int r5 = com.google.android.gms.internal.vision.zzfl.zzj(r1, r5)
        L_0x036a:
            int r3 = com.google.android.gms.internal.vision.zzca.zzi(r3, r5)
            goto L_0x0296
        L_0x0370:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x03aa
            long r5 = com.google.android.gms.internal.vision.zzfl.zzk(r1, r5)
        L_0x037a:
            int r3 = com.google.android.gms.internal.vision.zzca.zze((int) r3, (long) r5)
            goto L_0x0296
        L_0x0380:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x03aa
            long r5 = com.google.android.gms.internal.vision.zzfl.zzk(r1, r5)
        L_0x038a:
            int r3 = com.google.android.gms.internal.vision.zzca.zzd((int) r3, (long) r5)
            goto L_0x0296
        L_0x0390:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x03aa
        L_0x0396:
            int r3 = com.google.android.gms.internal.vision.zzca.zzb((int) r3, (float) r4)
            goto L_0x0296
        L_0x039c:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x03aa
        L_0x03a2:
            r5 = 0
            int r3 = com.google.android.gms.internal.vision.zzca.zzb((int) r3, (double) r5)
            goto L_0x0296
        L_0x03aa:
            int r12 = r12 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0016
        L_0x03b0:
            com.google.android.gms.internal.vision.zzff<?, ?> r2 = r0.zzns
            int r1 = zza(r2, r1)
            int r13 = r13 + r1
            return r13
        L_0x03b8:
            sun.misc.Unsafe r2 = zznd
            r3 = -1
            r3 = 0
            r5 = 0
            r6 = -1
            r12 = 0
        L_0x03bf:
            int[] r13 = r0.zzne
            int r13 = r13.length
            if (r3 >= r13) goto L_0x07c5
            int r13 = r0.zzaj(r3)
            int[] r14 = r0.zzne
            r15 = r14[r3]
            r16 = 267386880(0xff00000, float:2.3665827E-29)
            r17 = r13 & r16
            int r4 = r17 >>> 20
            r11 = 17
            if (r4 > r11) goto L_0x03eb
            int r11 = r3 + 2
            r11 = r14[r11]
            r14 = r11 & r8
            int r18 = r11 >>> 20
            int r18 = r7 << r18
            if (r14 == r6) goto L_0x03e8
            long r9 = (long) r14
            int r12 = r2.getInt(r1, r9)
            goto L_0x03e9
        L_0x03e8:
            r14 = r6
        L_0x03e9:
            r6 = r14
            goto L_0x040b
        L_0x03eb:
            boolean r9 = r0.zznm
            if (r9 == 0) goto L_0x0408
            com.google.android.gms.internal.vision.zzcm r9 = com.google.android.gms.internal.vision.zzcm.DOUBLE_LIST_PACKED
            int r9 = r9.id()
            if (r4 < r9) goto L_0x0408
            com.google.android.gms.internal.vision.zzcm r9 = com.google.android.gms.internal.vision.zzcm.SINT64_LIST_PACKED
            int r9 = r9.id()
            if (r4 > r9) goto L_0x0408
            int[] r9 = r0.zzne
            int r10 = r3 + 2
            r9 = r9[r10]
            r11 = r9 & r8
            goto L_0x0409
        L_0x0408:
            r11 = 0
        L_0x0409:
            r18 = 0
        L_0x040b:
            r9 = r13 & r8
            long r9 = (long) r9
            switch(r4) {
                case 0: goto L_0x07af;
                case 1: goto L_0x079f;
                case 2: goto L_0x078d;
                case 3: goto L_0x077d;
                case 4: goto L_0x076d;
                case 5: goto L_0x075e;
                case 6: goto L_0x0752;
                case 7: goto L_0x0748;
                case 8: goto L_0x0733;
                case 9: goto L_0x0721;
                case 10: goto L_0x0712;
                case 11: goto L_0x0705;
                case 12: goto L_0x06f8;
                case 13: goto L_0x06ed;
                case 14: goto L_0x06e2;
                case 15: goto L_0x06d5;
                case 16: goto L_0x06c8;
                case 17: goto L_0x06b5;
                case 18: goto L_0x06a1;
                case 19: goto L_0x0695;
                case 20: goto L_0x0689;
                case 21: goto L_0x067d;
                case 22: goto L_0x0671;
                case 23: goto L_0x06a1;
                case 24: goto L_0x0695;
                case 25: goto L_0x0665;
                case 26: goto L_0x065a;
                case 27: goto L_0x064b;
                case 28: goto L_0x0640;
                case 29: goto L_0x0634;
                case 30: goto L_0x0627;
                case 31: goto L_0x0695;
                case 32: goto L_0x06a1;
                case 33: goto L_0x061a;
                case 34: goto L_0x060d;
                case 35: goto L_0x05ed;
                case 36: goto L_0x05dc;
                case 37: goto L_0x05cb;
                case 38: goto L_0x05ba;
                case 39: goto L_0x05a9;
                case 40: goto L_0x0598;
                case 41: goto L_0x0587;
                case 42: goto L_0x0575;
                case 43: goto L_0x0563;
                case 44: goto L_0x0551;
                case 45: goto L_0x053f;
                case 46: goto L_0x052d;
                case 47: goto L_0x051b;
                case 48: goto L_0x0509;
                case 49: goto L_0x04f9;
                case 50: goto L_0x04e9;
                case 51: goto L_0x04db;
                case 52: goto L_0x04ce;
                case 53: goto L_0x04be;
                case 54: goto L_0x04ae;
                case 55: goto L_0x049e;
                case 56: goto L_0x0490;
                case 57: goto L_0x0483;
                case 58: goto L_0x047b;
                case 59: goto L_0x046b;
                case 60: goto L_0x0463;
                case 61: goto L_0x045b;
                case 62: goto L_0x044f;
                case 63: goto L_0x0443;
                case 64: goto L_0x043b;
                case 65: goto L_0x0433;
                case 66: goto L_0x0427;
                case 67: goto L_0x041b;
                case 68: goto L_0x0413;
                default: goto L_0x0411;
            }
        L_0x0411:
            goto L_0x06ad
        L_0x0413:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x06ad
            goto L_0x06b9
        L_0x041b:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x06ad
            long r9 = zzh(r1, r9)
            goto L_0x06d0
        L_0x0427:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x06ad
            int r4 = zzg(r1, r9)
            goto L_0x06dd
        L_0x0433:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x06ad
            goto L_0x06e6
        L_0x043b:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x06ad
            goto L_0x06f1
        L_0x0443:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x06ad
            int r4 = zzg(r1, r9)
            goto L_0x0700
        L_0x044f:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x06ad
            int r4 = zzg(r1, r9)
            goto L_0x070d
        L_0x045b:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x06ad
            goto L_0x0716
        L_0x0463:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x06ad
            goto L_0x0725
        L_0x046b:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x06ad
            java.lang.Object r4 = r2.getObject(r1, r9)
            boolean r9 = r4 instanceof com.google.android.gms.internal.vision.zzbo
            if (r9 == 0) goto L_0x0740
            goto L_0x073f
        L_0x047b:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x06ad
            goto L_0x074c
        L_0x0483:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x06ad
            r4 = 0
            int r9 = com.google.android.gms.internal.vision.zzca.zzl(r15, r4)
            goto L_0x06f6
        L_0x0490:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x06ad
            r9 = 0
            int r4 = com.google.android.gms.internal.vision.zzca.zzg((int) r15, (long) r9)
            goto L_0x06ac
        L_0x049e:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x06ad
            int r4 = zzg(r1, r9)
            int r4 = com.google.android.gms.internal.vision.zzca.zzi(r15, r4)
            goto L_0x06ac
        L_0x04ae:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x06ad
            long r9 = zzh(r1, r9)
            int r4 = com.google.android.gms.internal.vision.zzca.zze((int) r15, (long) r9)
            goto L_0x06ac
        L_0x04be:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x06ad
            long r9 = zzh(r1, r9)
            int r4 = com.google.android.gms.internal.vision.zzca.zzd((int) r15, (long) r9)
            goto L_0x06ac
        L_0x04ce:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x06ad
            r4 = 0
            int r9 = com.google.android.gms.internal.vision.zzca.zzb((int) r15, (float) r4)
            goto L_0x06f6
        L_0x04db:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x06ad
            r9 = 0
            int r4 = com.google.android.gms.internal.vision.zzca.zzb((int) r15, (double) r9)
            goto L_0x06ac
        L_0x04e9:
            com.google.android.gms.internal.vision.zzds r4 = r0.zznu
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.lang.Object r10 = r0.zzah(r3)
            int r4 = r4.zzb(r15, r9, r10)
            goto L_0x06ac
        L_0x04f9:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzen r9 = r0.zzag(r3)
            int r4 = com.google.android.gms.internal.vision.zzep.zzd(r15, r4, r9)
            goto L_0x06ac
        L_0x0509:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzep.zzc(r4)
            if (r4 <= 0) goto L_0x06ad
            boolean r9 = r0.zznm
            if (r9 == 0) goto L_0x0601
            goto L_0x05fd
        L_0x051b:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzep.zzg(r4)
            if (r4 <= 0) goto L_0x06ad
            boolean r9 = r0.zznm
            if (r9 == 0) goto L_0x0601
            goto L_0x05fd
        L_0x052d:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzep.zzi(r4)
            if (r4 <= 0) goto L_0x06ad
            boolean r9 = r0.zznm
            if (r9 == 0) goto L_0x0601
            goto L_0x05fd
        L_0x053f:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzep.zzh(r4)
            if (r4 <= 0) goto L_0x06ad
            boolean r9 = r0.zznm
            if (r9 == 0) goto L_0x0601
            goto L_0x05fd
        L_0x0551:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzep.zzd((java.util.List<java.lang.Integer>) r4)
            if (r4 <= 0) goto L_0x06ad
            boolean r9 = r0.zznm
            if (r9 == 0) goto L_0x0601
            goto L_0x05fd
        L_0x0563:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzep.zzf((java.util.List<java.lang.Integer>) r4)
            if (r4 <= 0) goto L_0x06ad
            boolean r9 = r0.zznm
            if (r9 == 0) goto L_0x0601
            goto L_0x05fd
        L_0x0575:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzep.zzj(r4)
            if (r4 <= 0) goto L_0x06ad
            boolean r9 = r0.zznm
            if (r9 == 0) goto L_0x0601
            goto L_0x05fd
        L_0x0587:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzep.zzh(r4)
            if (r4 <= 0) goto L_0x06ad
            boolean r9 = r0.zznm
            if (r9 == 0) goto L_0x0601
            goto L_0x05fd
        L_0x0598:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzep.zzi(r4)
            if (r4 <= 0) goto L_0x06ad
            boolean r9 = r0.zznm
            if (r9 == 0) goto L_0x0601
            goto L_0x05fd
        L_0x05a9:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzep.zze(r4)
            if (r4 <= 0) goto L_0x06ad
            boolean r9 = r0.zznm
            if (r9 == 0) goto L_0x0601
            goto L_0x05fd
        L_0x05ba:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzep.zzb(r4)
            if (r4 <= 0) goto L_0x06ad
            boolean r9 = r0.zznm
            if (r9 == 0) goto L_0x0601
            goto L_0x05fd
        L_0x05cb:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzep.zza(r4)
            if (r4 <= 0) goto L_0x06ad
            boolean r9 = r0.zznm
            if (r9 == 0) goto L_0x0601
            goto L_0x05fd
        L_0x05dc:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzep.zzh(r4)
            if (r4 <= 0) goto L_0x06ad
            boolean r9 = r0.zznm
            if (r9 == 0) goto L_0x0601
            goto L_0x05fd
        L_0x05ed:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzep.zzi(r4)
            if (r4 <= 0) goto L_0x06ad
            boolean r9 = r0.zznm
            if (r9 == 0) goto L_0x0601
        L_0x05fd:
            long r9 = (long) r11
            r2.putInt(r1, r9, r4)
        L_0x0601:
            int r9 = com.google.android.gms.internal.vision.zzca.zzt(r15)
            int r10 = com.google.android.gms.internal.vision.zzca.zzv(r4)
            int r9 = r9 + r10
            int r9 = r9 + r4
            goto L_0x06f6
        L_0x060d:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            r11 = 0
            int r4 = com.google.android.gms.internal.vision.zzep.zzq(r15, r4, r11)
            goto L_0x06ac
        L_0x061a:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzep.zzu(r15, r4, r11)
            goto L_0x06ac
        L_0x0627:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzep.zzr(r15, r4, r11)
            goto L_0x06ac
        L_0x0634:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzep.zzt(r15, r4, r11)
            goto L_0x06ac
        L_0x0640:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzep.zzd((int) r15, (java.util.List<com.google.android.gms.internal.vision.zzbo>) r4)
            goto L_0x06ac
        L_0x064b:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzen r9 = r0.zzag(r3)
            int r4 = com.google.android.gms.internal.vision.zzep.zzc((int) r15, (java.util.List<?>) r4, (com.google.android.gms.internal.vision.zzen) r9)
            goto L_0x06ac
        L_0x065a:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzep.zzc(r15, r4)
            goto L_0x06ac
        L_0x0665:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            r11 = 0
            int r4 = com.google.android.gms.internal.vision.zzep.zzx(r15, r4, r11)
            goto L_0x06ac
        L_0x0671:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzep.zzs(r15, r4, r11)
            goto L_0x06ac
        L_0x067d:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzep.zzp(r15, r4, r11)
            goto L_0x06ac
        L_0x0689:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzep.zzo(r15, r4, r11)
            goto L_0x06ac
        L_0x0695:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzep.zzv(r15, r4, r11)
            goto L_0x06ac
        L_0x06a1:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzep.zzw(r15, r4, r11)
        L_0x06ac:
            int r5 = r5 + r4
        L_0x06ad:
            r4 = 0
        L_0x06ae:
            r9 = 0
            r10 = 0
            r13 = 0
            goto L_0x07be
        L_0x06b5:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x06ad
        L_0x06b9:
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.vision.zzdx r4 = (com.google.android.gms.internal.vision.zzdx) r4
            com.google.android.gms.internal.vision.zzen r9 = r0.zzag(r3)
            int r4 = com.google.android.gms.internal.vision.zzca.zzc(r15, r4, r9)
            goto L_0x06ac
        L_0x06c8:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x06ad
            long r9 = r2.getLong(r1, r9)
        L_0x06d0:
            int r4 = com.google.android.gms.internal.vision.zzca.zzf((int) r15, (long) r9)
            goto L_0x06ac
        L_0x06d5:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x06ad
            int r4 = r2.getInt(r1, r9)
        L_0x06dd:
            int r4 = com.google.android.gms.internal.vision.zzca.zzk(r15, r4)
            goto L_0x06ac
        L_0x06e2:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x06ad
        L_0x06e6:
            r9 = 0
            int r4 = com.google.android.gms.internal.vision.zzca.zzh((int) r15, (long) r9)
            goto L_0x06ac
        L_0x06ed:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x06ad
        L_0x06f1:
            r4 = 0
            int r9 = com.google.android.gms.internal.vision.zzca.zzm(r15, r4)
        L_0x06f6:
            int r5 = r5 + r9
            goto L_0x06ad
        L_0x06f8:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x06ad
            int r4 = r2.getInt(r1, r9)
        L_0x0700:
            int r4 = com.google.android.gms.internal.vision.zzca.zzn(r15, r4)
            goto L_0x06ac
        L_0x0705:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x06ad
            int r4 = r2.getInt(r1, r9)
        L_0x070d:
            int r4 = com.google.android.gms.internal.vision.zzca.zzj(r15, r4)
            goto L_0x06ac
        L_0x0712:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x06ad
        L_0x0716:
            java.lang.Object r4 = r2.getObject(r1, r9)
        L_0x071a:
            com.google.android.gms.internal.vision.zzbo r4 = (com.google.android.gms.internal.vision.zzbo) r4
            int r4 = com.google.android.gms.internal.vision.zzca.zzc((int) r15, (com.google.android.gms.internal.vision.zzbo) r4)
            goto L_0x06ac
        L_0x0721:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x06ad
        L_0x0725:
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.vision.zzen r9 = r0.zzag(r3)
            int r4 = com.google.android.gms.internal.vision.zzep.zzc((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzen) r9)
            goto L_0x06ac
        L_0x0733:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x06ad
            java.lang.Object r4 = r2.getObject(r1, r9)
            boolean r9 = r4 instanceof com.google.android.gms.internal.vision.zzbo
            if (r9 == 0) goto L_0x0740
        L_0x073f:
            goto L_0x071a
        L_0x0740:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.vision.zzca.zzb((int) r15, (java.lang.String) r4)
            goto L_0x06ac
        L_0x0748:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x06ad
        L_0x074c:
            int r4 = com.google.android.gms.internal.vision.zzca.zzc((int) r15, (boolean) r7)
            goto L_0x06ac
        L_0x0752:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x06ad
            r4 = 0
            int r9 = com.google.android.gms.internal.vision.zzca.zzl(r15, r4)
            int r5 = r5 + r9
            goto L_0x06ae
        L_0x075e:
            r4 = 0
            r9 = r12 & r18
            if (r9 == 0) goto L_0x076a
            r13 = 0
            int r9 = com.google.android.gms.internal.vision.zzca.zzg((int) r15, (long) r13)
            goto L_0x079c
        L_0x076a:
            r13 = 0
            goto L_0x079d
        L_0x076d:
            r4 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x079d
            int r9 = r2.getInt(r1, r9)
            int r9 = com.google.android.gms.internal.vision.zzca.zzi(r15, r9)
            goto L_0x079c
        L_0x077d:
            r4 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x079d
            long r9 = r2.getLong(r1, r9)
            int r9 = com.google.android.gms.internal.vision.zzca.zze((int) r15, (long) r9)
            goto L_0x079c
        L_0x078d:
            r4 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x079d
            long r9 = r2.getLong(r1, r9)
            int r9 = com.google.android.gms.internal.vision.zzca.zzd((int) r15, (long) r9)
        L_0x079c:
            int r5 = r5 + r9
        L_0x079d:
            r9 = 0
            goto L_0x07ac
        L_0x079f:
            r4 = 0
            r13 = 0
            r9 = r12 & r18
            if (r9 == 0) goto L_0x079d
            r9 = 0
            int r10 = com.google.android.gms.internal.vision.zzca.zzb((int) r15, (float) r9)
            int r5 = r5 + r10
        L_0x07ac:
            r10 = 0
            goto L_0x07be
        L_0x07af:
            r4 = 0
            r9 = 0
            r13 = 0
            r10 = r12 & r18
            if (r10 == 0) goto L_0x07ac
            r10 = 0
            int r15 = com.google.android.gms.internal.vision.zzca.zzb((int) r15, (double) r10)
            int r5 = r5 + r15
        L_0x07be:
            int r3 = r3 + 3
            r9 = r13
            r4 = 0
            r11 = 0
            goto L_0x03bf
        L_0x07c5:
            com.google.android.gms.internal.vision.zzff<?, ?> r2 = r0.zzns
            int r2 = zza(r2, r1)
            int r5 = r5 + r2
            boolean r2 = r0.zznj
            if (r2 == 0) goto L_0x07db
            com.google.android.gms.internal.vision.zzcg<?> r2 = r0.zznt
            com.google.android.gms.internal.vision.zzcj r1 = r2.zzb(r1)
            int r1 = r1.zzbl()
            int r5 = r5 + r1
        L_0x07db:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzeb.zzn(java.lang.Object):int");
    }

    public final boolean zzp(T t) {
        int i;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= this.zzno) {
                return !this.zznj || this.zznt.zzb(t).isInitialized();
            }
            int i5 = this.zznn[i2];
            int i6 = this.zzne[i5];
            int zzaj = zzaj(i5);
            if (!this.zznl) {
                int i7 = this.zzne[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i3) {
                    i4 = zznd.getInt(t, (long) i8);
                    i3 = i8;
                }
            } else {
                i = 0;
            }
            if (((268435456 & zzaj) != 0) && !zza(t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & zzaj) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (zza(t, i6, i5) && !zza((Object) t, zzaj, zzag(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzi = this.zznu.zzi(zzfl.zzo(t, (long) (zzaj & 1048575)));
                            if (!zzi.isEmpty()) {
                                if (this.zznu.zzm(zzah(i5)).zzmy.zzed() == zzfy.MESSAGE) {
                                    zzen<?> zzen = null;
                                    Iterator<?> it = zzi.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzen == null) {
                                            zzen = zzek.zzdc().zze(next.getClass());
                                        }
                                        if (!zzen.zzp(next)) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzfl.zzo(t, (long) (zzaj & 1048575));
                if (!list.isEmpty()) {
                    zzen zzag = zzag(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!zzag.zzp(list.get(i10))) {
                            z = false;
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zza(t, i5, i4, i) && !zza((Object) t, zzaj, zzag(i5))) {
                return false;
            }
            i2++;
        }
    }
}
