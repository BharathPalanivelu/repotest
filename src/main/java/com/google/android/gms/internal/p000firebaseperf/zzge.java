package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.zzep;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;
import tencent.tls.platform.SigType;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzge  reason: invalid package */
final class zzge<T> implements zzgn<T> {
    private static final int[] zztd = new int[0];
    private static final Unsafe zzte = zzhl.zzjl();
    private final zzga zzsz;
    private final zzhf<?, ?> zzta;
    private final boolean zztb;
    private final zzef<?> zztc;
    private final int[] zztf;
    private final Object[] zztg;
    private final int zzth;
    private final int zzti;
    private final boolean zztj;
    private final boolean zztk;
    private final boolean zztl;
    private final int[] zztm;
    private final int zztn;
    private final int zzto;
    private final zzgf zztp;
    private final zzfk zztq;
    private final zzft zztr;

    private zzge(int[] iArr, Object[] objArr, int i, int i2, zzga zzga, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzgf zzgf, zzfk zzfk, zzhf<?, ?> zzhf, zzef<?> zzef, zzft zzft) {
        this.zztf = iArr;
        this.zztg = objArr;
        this.zzth = i;
        this.zzti = i2;
        this.zztj = zzga instanceof zzep;
        this.zztk = z;
        this.zztb = zzef != null && zzef.zze(zzga);
        this.zztl = false;
        this.zztm = iArr2;
        this.zztn = i3;
        this.zzto = i4;
        this.zztp = zzgf;
        this.zztq = zzfk;
        this.zzta = zzhf;
        this.zztc = zzef;
        this.zzsz = zzga;
        this.zztr = zzft;
    }

    static <T> zzge<T> zza(Class<T> cls, zzfy zzfy, zzgf zzgf, zzfk zzfk, zzhf<?, ?> zzhf, zzef<?> zzef, zzft zzft) {
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
        char c8;
        int i7;
        int i8;
        int i9;
        int i10;
        Class<?> cls2;
        int i11;
        int i12;
        Field field;
        int i13;
        char charAt;
        int i14;
        char c9;
        Field field2;
        Field field3;
        int i15;
        char charAt2;
        int i16;
        char charAt3;
        int i17;
        char charAt4;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        char charAt5;
        int i24;
        char charAt6;
        int i25;
        char charAt7;
        int i26;
        char charAt8;
        char charAt9;
        char charAt10;
        char charAt11;
        char charAt12;
        char charAt13;
        char charAt14;
        zzfy zzfy2 = zzfy;
        if (zzfy2 instanceof zzgo) {
            zzgo zzgo = (zzgo) zzfy2;
            char c10 = 0;
            boolean z = zzgo.zzij() == zzep.zzc.zzrb;
            String zzis = zzgo.zzis();
            int length = zzis.length();
            char charAt15 = zzis.charAt(0);
            if (charAt15 >= 55296) {
                char c11 = charAt15 & 8191;
                int i27 = 1;
                int i28 = 13;
                while (true) {
                    i = i27 + 1;
                    charAt14 = zzis.charAt(i27);
                    if (charAt14 < 55296) {
                        break;
                    }
                    c11 |= (charAt14 & 8191) << i28;
                    i28 += 13;
                    i27 = i;
                }
                charAt15 = (charAt14 << i28) | c11;
            } else {
                i = 1;
            }
            int i29 = i + 1;
            char charAt16 = zzis.charAt(i);
            if (charAt16 >= 55296) {
                char c12 = charAt16 & 8191;
                int i30 = 13;
                while (true) {
                    i2 = i29 + 1;
                    charAt13 = zzis.charAt(i29);
                    if (charAt13 < 55296) {
                        break;
                    }
                    c12 |= (charAt13 & 8191) << i30;
                    i30 += 13;
                    i29 = i2;
                }
                charAt16 = c12 | (charAt13 << i30);
            } else {
                i2 = i29;
            }
            if (charAt16 == 0) {
                iArr = zztd;
                c6 = 0;
                c5 = 0;
                i3 = 0;
                c4 = 0;
                c3 = 0;
                c2 = 0;
            } else {
                int i31 = i2 + 1;
                char charAt17 = zzis.charAt(i2);
                if (charAt17 >= 55296) {
                    char c13 = charAt17 & 8191;
                    int i32 = 13;
                    while (true) {
                        i18 = i31 + 1;
                        charAt12 = zzis.charAt(i31);
                        if (charAt12 < 55296) {
                            break;
                        }
                        c13 |= (charAt12 & 8191) << i32;
                        i32 += 13;
                        i31 = i18;
                    }
                    charAt17 = (charAt12 << i32) | c13;
                } else {
                    i18 = i31;
                }
                int i33 = i18 + 1;
                char charAt18 = zzis.charAt(i18);
                if (charAt18 >= 55296) {
                    char c14 = charAt18 & 8191;
                    int i34 = 13;
                    while (true) {
                        i19 = i33 + 1;
                        charAt11 = zzis.charAt(i33);
                        if (charAt11 < 55296) {
                            break;
                        }
                        c14 |= (charAt11 & 8191) << i34;
                        i34 += 13;
                        i33 = i19;
                    }
                    charAt18 = c14 | (charAt11 << i34);
                } else {
                    i19 = i33;
                }
                int i35 = i19 + 1;
                char charAt19 = zzis.charAt(i19);
                if (charAt19 >= 55296) {
                    char c15 = charAt19 & 8191;
                    int i36 = 13;
                    while (true) {
                        i20 = i35 + 1;
                        charAt10 = zzis.charAt(i35);
                        if (charAt10 < 55296) {
                            break;
                        }
                        c15 |= (charAt10 & 8191) << i36;
                        i36 += 13;
                        i35 = i20;
                    }
                    charAt19 = (charAt10 << i36) | c15;
                } else {
                    i20 = i35;
                }
                int i37 = i20 + 1;
                c4 = zzis.charAt(i20);
                if (c4 >= 55296) {
                    char c16 = c4 & 8191;
                    int i38 = 13;
                    while (true) {
                        i21 = i37 + 1;
                        charAt9 = zzis.charAt(i37);
                        if (charAt9 < 55296) {
                            break;
                        }
                        c16 |= (charAt9 & 8191) << i38;
                        i38 += 13;
                        i37 = i21;
                    }
                    c4 = (charAt9 << i38) | c16;
                } else {
                    i21 = i37;
                }
                int i39 = i21 + 1;
                c3 = zzis.charAt(i21);
                if (c3 >= 55296) {
                    char c17 = c3 & 8191;
                    int i40 = 13;
                    while (true) {
                        i26 = i39 + 1;
                        charAt8 = zzis.charAt(i39);
                        if (charAt8 < 55296) {
                            break;
                        }
                        c17 |= (charAt8 & 8191) << i40;
                        i40 += 13;
                        i39 = i26;
                    }
                    c3 = (charAt8 << i40) | c17;
                    i39 = i26;
                }
                int i41 = i39 + 1;
                c6 = zzis.charAt(i39);
                if (c6 >= 55296) {
                    char c18 = c6 & 8191;
                    int i42 = 13;
                    while (true) {
                        i25 = i41 + 1;
                        charAt7 = zzis.charAt(i41);
                        if (charAt7 < 55296) {
                            break;
                        }
                        c18 |= (charAt7 & 8191) << i42;
                        i42 += 13;
                        i41 = i25;
                    }
                    c6 = c18 | (charAt7 << i42);
                    i41 = i25;
                }
                int i43 = i41 + 1;
                char charAt20 = zzis.charAt(i41);
                if (charAt20 >= 55296) {
                    int i44 = 13;
                    int i45 = i43;
                    char c19 = charAt20 & 8191;
                    int i46 = i45;
                    while (true) {
                        i24 = i46 + 1;
                        charAt6 = zzis.charAt(i46);
                        if (charAt6 < 55296) {
                            break;
                        }
                        c19 |= (charAt6 & 8191) << i44;
                        i44 += 13;
                        i46 = i24;
                    }
                    charAt20 = c19 | (charAt6 << i44);
                    i22 = i24;
                } else {
                    i22 = i43;
                }
                int i47 = i22 + 1;
                c10 = zzis.charAt(i22);
                if (c10 >= 55296) {
                    int i48 = 13;
                    int i49 = i47;
                    char c20 = c10 & 8191;
                    int i50 = i49;
                    while (true) {
                        i23 = i50 + 1;
                        charAt5 = zzis.charAt(i50);
                        if (charAt5 < 55296) {
                            break;
                        }
                        c20 |= (charAt5 & 8191) << i48;
                        i48 += 13;
                        i50 = i23;
                    }
                    c10 = c20 | (charAt5 << i48);
                    i47 = i23;
                }
                iArr = new int[(c10 + c6 + charAt20)];
                i3 = (charAt17 << 1) + charAt18;
                int i51 = i47;
                c2 = charAt17;
                c5 = charAt19;
                i2 = i51;
            }
            Unsafe unsafe = zzte;
            Object[] zzit = zzgo.zzit();
            Class<?> cls3 = zzgo.zzil().getClass();
            int i52 = i3;
            int[] iArr2 = new int[(c3 * 3)];
            Object[] objArr = new Object[(c3 << 1)];
            int i53 = c10 + c6;
            char c21 = c10;
            int i54 = i53;
            int i55 = 0;
            int i56 = 0;
            while (i2 < length) {
                int i57 = i2 + 1;
                char charAt21 = zzis.charAt(i2);
                char c22 = 55296;
                if (charAt21 >= 55296) {
                    int i58 = 13;
                    int i59 = i57;
                    char c23 = charAt21 & 8191;
                    int i60 = i59;
                    while (true) {
                        i17 = i60 + 1;
                        charAt4 = zzis.charAt(i60);
                        if (charAt4 < c22) {
                            break;
                        }
                        c23 |= (charAt4 & 8191) << i58;
                        i58 += 13;
                        i60 = i17;
                        c22 = 55296;
                    }
                    charAt21 = c23 | (charAt4 << i58);
                    i4 = i17;
                } else {
                    i4 = i57;
                }
                int i61 = i4 + 1;
                char charAt22 = zzis.charAt(i4);
                int i62 = length;
                char c24 = 55296;
                if (charAt22 >= 55296) {
                    int i63 = 13;
                    int i64 = i61;
                    char c25 = charAt22 & 8191;
                    int i65 = i64;
                    while (true) {
                        i16 = i65 + 1;
                        charAt3 = zzis.charAt(i65);
                        if (charAt3 < c24) {
                            break;
                        }
                        c25 |= (charAt3 & 8191) << i63;
                        i63 += 13;
                        i65 = i16;
                        c24 = 55296;
                    }
                    charAt22 = c25 | (charAt3 << i63);
                    i5 = i16;
                } else {
                    i5 = i61;
                }
                char c26 = c10;
                char c27 = charAt22 & 255;
                boolean z2 = z;
                if ((charAt22 & 1024) != 0) {
                    iArr[i55] = i56;
                    i55++;
                }
                int i66 = i55;
                if (c27 >= '3') {
                    int i67 = i5 + 1;
                    char charAt23 = zzis.charAt(i5);
                    char c28 = 55296;
                    if (charAt23 >= 55296) {
                        char c29 = charAt23 & 8191;
                        int i68 = 13;
                        while (true) {
                            i15 = i67 + 1;
                            charAt2 = zzis.charAt(i67);
                            if (charAt2 < c28) {
                                break;
                            }
                            c29 |= (charAt2 & 8191) << i68;
                            i68 += 13;
                            i67 = i15;
                            c28 = 55296;
                        }
                        charAt23 = c29 | (charAt2 << i68);
                        i67 = i15;
                    }
                    int i69 = c27 - '3';
                    int i70 = i67;
                    if (i69 == 9 || i69 == 17) {
                        c9 = 1;
                        objArr[((i56 / 3) << 1) + 1] = zzit[i52];
                        i52++;
                    } else {
                        if (i69 == 12 && (charAt15 & 1) == 1) {
                            objArr[((i56 / 3) << 1) + 1] = zzit[i52];
                            i52++;
                        }
                        c9 = 1;
                    }
                    int i71 = charAt23 << c9;
                    Object obj = zzit[i71];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls3, (String) obj);
                        zzit[i71] = field2;
                    }
                    char c30 = c5;
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i72 = i71 + 1;
                    Object obj2 = zzit[i72];
                    int i73 = objectFieldOffset;
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls3, (String) obj2);
                        zzit[i72] = field3;
                    }
                    str = zzis;
                    i9 = (int) unsafe.objectFieldOffset(field3);
                    cls2 = cls3;
                    i6 = i52;
                    i8 = i73;
                    i10 = 0;
                    c7 = c30;
                    c8 = c4;
                    i7 = charAt21;
                    i12 = i70;
                } else {
                    char c31 = c5;
                    int i74 = i52 + 1;
                    Field zza = zza(cls3, (String) zzit[i52]);
                    c8 = c4;
                    if (c27 == 9 || c27 == 17) {
                        c7 = c31;
                        objArr[((i56 / 3) << 1) + 1] = zza.getType();
                    } else {
                        if (c27 == 27 || c27 == '1') {
                            c7 = c31;
                            i14 = i74 + 1;
                            objArr[((i56 / 3) << 1) + 1] = zzit[i74];
                        } else if (c27 == 12 || c27 == 30 || c27 == ',') {
                            c7 = c31;
                            if ((charAt15 & 1) == 1) {
                                i14 = i74 + 1;
                                objArr[((i56 / 3) << 1) + 1] = zzit[i74];
                            }
                        } else if (c27 == '2') {
                            int i75 = c21 + 1;
                            iArr[c21] = i56;
                            int i76 = (i56 / 3) << 1;
                            int i77 = i74 + 1;
                            objArr[i76] = zzit[i74];
                            if ((charAt22 & 2048) != 0) {
                                i74 = i77 + 1;
                                objArr[i76 + 1] = zzit[i77];
                                c7 = c31;
                                c21 = i75;
                            } else {
                                c21 = i75;
                                i74 = i77;
                                c7 = c31;
                            }
                        } else {
                            c7 = c31;
                        }
                        i7 = charAt21;
                        i74 = i14;
                        i8 = (int) unsafe.objectFieldOffset(zza);
                        if ((charAt15 & 1) == 1 || c27 > 17) {
                            str = zzis;
                            cls2 = cls3;
                            i6 = i74;
                            i11 = i5;
                            i10 = 0;
                            i9 = 0;
                        } else {
                            i11 = i5 + 1;
                            char charAt24 = zzis.charAt(i5);
                            if (charAt24 >= 55296) {
                                char c32 = charAt24 & 8191;
                                int i78 = 13;
                                while (true) {
                                    i13 = i11 + 1;
                                    charAt = zzis.charAt(i11);
                                    if (charAt < 55296) {
                                        break;
                                    }
                                    c32 |= (charAt & 8191) << i78;
                                    i78 += 13;
                                    i11 = i13;
                                }
                                charAt24 = c32 | (charAt << i78);
                                i11 = i13;
                            }
                            int i79 = (c2 << 1) + (charAt24 / ' ');
                            Object obj3 = zzit[i79];
                            str = zzis;
                            if (obj3 instanceof Field) {
                                field = (Field) obj3;
                            } else {
                                field = zza(cls3, (String) obj3);
                                zzit[i79] = field;
                            }
                            cls2 = cls3;
                            i6 = i74;
                            i9 = (int) unsafe.objectFieldOffset(field);
                            i10 = charAt24 % ' ';
                        }
                        if (c27 >= 18 && c27 <= '1') {
                            iArr[i54] = i8;
                            i54++;
                        }
                        i12 = i11;
                    }
                    i7 = charAt21;
                    i8 = (int) unsafe.objectFieldOffset(zza);
                    if ((charAt15 & 1) == 1) {
                    }
                    str = zzis;
                    cls2 = cls3;
                    i6 = i74;
                    i11 = i5;
                    i10 = 0;
                    i9 = 0;
                    iArr[i54] = i8;
                    i54++;
                    i12 = i11;
                }
                int i80 = i56 + 1;
                iArr2[i56] = i7;
                int i81 = i80 + 1;
                iArr2[i80] = (c27 << 20) | ((charAt22 & 256) != 0 ? SigType.TLS : 0) | ((charAt22 & 512) != 0 ? 536870912 : 0) | i8;
                i56 = i81 + 1;
                iArr2[i81] = (i10 << 20) | i9;
                cls3 = cls2;
                c4 = c8;
                c10 = c26;
                i52 = i6;
                length = i62;
                z = z2;
                c5 = c7;
                i55 = i66;
                zzis = str;
            }
            boolean z3 = z;
            return new zzge(iArr2, objArr, c5, c4, zzgo.zzil(), z, false, iArr, c10, i53, zzgf, zzfk, zzhf, zzef, zzft);
        }
        int zzij = ((zzhc) zzfy2).zzij();
        int i82 = zzep.zzc.zzrb;
        throw new NoSuchMethodError();
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

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.zzgp.zzf(com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r10, r6), com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r10, r6) == com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r10, r6) == com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r10, r6) == com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r10, r6) == com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r10, r6) == com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r10, r6) == com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.zzgp.zzf(com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r10, r6), com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.zzgp.zzf(com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r10, r6), com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.zzgp.zzf(com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r10, r6), com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.zzhl.zzl(r10, r6) == com.google.android.gms.internal.p000firebaseperf.zzhl.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r10, r6) == com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r10, r6) == com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r10, r6) == com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r10, r6) == com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r10, r6) == com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.p000firebaseperf.zzhl.zzm(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.p000firebaseperf.zzhl.zzm(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.p000firebaseperf.zzhl.zzn(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.p000firebaseperf.zzhl.zzn(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c1, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.zzgp.zzf(com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r10, r6), com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r11, r6)) != false) goto L_0x01c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zztf
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.zzar(r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x01a7;
                case 1: goto L_0x018e;
                case 2: goto L_0x017b;
                case 3: goto L_0x0168;
                case 4: goto L_0x0157;
                case 5: goto L_0x0144;
                case 6: goto L_0x0132;
                case 7: goto L_0x0120;
                case 8: goto L_0x010a;
                case 9: goto L_0x00f4;
                case 10: goto L_0x00de;
                case 11: goto L_0x00cc;
                case 12: goto L_0x00ba;
                case 13: goto L_0x00a8;
                case 14: goto L_0x0094;
                case 15: goto L_0x0082;
                case 16: goto L_0x006e;
                case 17: goto L_0x0058;
                case 18: goto L_0x004a;
                case 19: goto L_0x004a;
                case 20: goto L_0x004a;
                case 21: goto L_0x004a;
                case 22: goto L_0x004a;
                case 23: goto L_0x004a;
                case 24: goto L_0x004a;
                case 25: goto L_0x004a;
                case 26: goto L_0x004a;
                case 27: goto L_0x004a;
                case 28: goto L_0x004a;
                case 29: goto L_0x004a;
                case 30: goto L_0x004a;
                case 31: goto L_0x004a;
                case 32: goto L_0x004a;
                case 33: goto L_0x004a;
                case 34: goto L_0x004a;
                case 35: goto L_0x004a;
                case 36: goto L_0x004a;
                case 37: goto L_0x004a;
                case 38: goto L_0x004a;
                case 39: goto L_0x004a;
                case 40: goto L_0x004a;
                case 41: goto L_0x004a;
                case 42: goto L_0x004a;
                case 43: goto L_0x004a;
                case 44: goto L_0x004a;
                case 45: goto L_0x004a;
                case 46: goto L_0x004a;
                case 47: goto L_0x004a;
                case 48: goto L_0x004a;
                case 49: goto L_0x004a;
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
            goto L_0x01c2
        L_0x001c:
            int r4 = r9.zzas(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r10, r4)
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r11, r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzf(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r11, r6)
            boolean r3 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzf(r3, r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r11, r6)
            boolean r3 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzf(r3, r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzf(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzf(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzf(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzf(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzl(r10, r6)
            boolean r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzl(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzm(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzm(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzn(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzn(r11, r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
        L_0x01c1:
            r3 = 0
        L_0x01c2:
            if (r3 != 0) goto L_0x01c5
            return r1
        L_0x01c5:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01c9:
            com.google.android.gms.internal.firebase-perf.zzhf<?, ?> r0 = r9.zzta
            java.lang.Object r0 = r0.zzo(r10)
            com.google.android.gms.internal.firebase-perf.zzhf<?, ?> r2 = r9.zzta
            java.lang.Object r2 = r2.zzo(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.zztb
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.firebase-perf.zzef<?> r0 = r9.zztc
            com.google.android.gms.internal.firebase-perf.zzek r10 = r0.zzc(r10)
            com.google.android.gms.internal.firebase-perf.zzef<?> r0 = r9.zztc
            com.google.android.gms.internal.firebase-perf.zzek r11 = r0.zzc(r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p000firebaseperf.zzge.equals(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c3, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0227, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0228, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int hashCode(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zztf
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x022c
            int r3 = r8.zzar(r1)
            int[] r4 = r8.zztf
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = r3 & r7
            int r3 = r3 >>> 20
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0219;
                case 1: goto L_0x020e;
                case 2: goto L_0x0203;
                case 3: goto L_0x01f8;
                case 4: goto L_0x01f1;
                case 5: goto L_0x01e6;
                case 6: goto L_0x01df;
                case 7: goto L_0x01d4;
                case 8: goto L_0x01c7;
                case 9: goto L_0x01b9;
                case 10: goto L_0x01ad;
                case 11: goto L_0x01a5;
                case 12: goto L_0x019d;
                case 13: goto L_0x0195;
                case 14: goto L_0x0189;
                case 15: goto L_0x0181;
                case 16: goto L_0x0175;
                case 17: goto L_0x016a;
                case 18: goto L_0x015e;
                case 19: goto L_0x015e;
                case 20: goto L_0x015e;
                case 21: goto L_0x015e;
                case 22: goto L_0x015e;
                case 23: goto L_0x015e;
                case 24: goto L_0x015e;
                case 25: goto L_0x015e;
                case 26: goto L_0x015e;
                case 27: goto L_0x015e;
                case 28: goto L_0x015e;
                case 29: goto L_0x015e;
                case 30: goto L_0x015e;
                case 31: goto L_0x015e;
                case 32: goto L_0x015e;
                case 33: goto L_0x015e;
                case 34: goto L_0x015e;
                case 35: goto L_0x015e;
                case 36: goto L_0x015e;
                case 37: goto L_0x015e;
                case 38: goto L_0x015e;
                case 39: goto L_0x015e;
                case 40: goto L_0x015e;
                case 41: goto L_0x015e;
                case 42: goto L_0x015e;
                case 43: goto L_0x015e;
                case 44: goto L_0x015e;
                case 45: goto L_0x015e;
                case 46: goto L_0x015e;
                case 47: goto L_0x015e;
                case 48: goto L_0x015e;
                case 49: goto L_0x015e;
                case 50: goto L_0x0152;
                case 51: goto L_0x013c;
                case 52: goto L_0x012a;
                case 53: goto L_0x0118;
                case 54: goto L_0x0106;
                case 55: goto L_0x00f8;
                case 56: goto L_0x00e6;
                case 57: goto L_0x00d8;
                case 58: goto L_0x00c6;
                case 59: goto L_0x00b2;
                case 60: goto L_0x00a0;
                case 61: goto L_0x008e;
                case 62: goto L_0x0080;
                case 63: goto L_0x0072;
                case 64: goto L_0x0064;
                case 65: goto L_0x0052;
                case 66: goto L_0x0044;
                case 67: goto L_0x0032;
                case 68: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x0228
        L_0x0020:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x0032:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzh(r9, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzer.zzav(r3)
            goto L_0x0227
        L_0x0044:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0227
        L_0x0052:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzh(r9, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzer.zzav(r3)
            goto L_0x0227
        L_0x0064:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0227
        L_0x0072:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0227
        L_0x0080:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0227
        L_0x008e:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00a0:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00b2:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00c6:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            boolean r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzer.zzf((boolean) r3)
            goto L_0x0227
        L_0x00d8:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0227
        L_0x00e6:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzh(r9, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzer.zzav(r3)
            goto L_0x0227
        L_0x00f8:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0227
        L_0x0106:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzh(r9, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzer.zzav(r3)
            goto L_0x0227
        L_0x0118:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzh(r9, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzer.zzav(r3)
            goto L_0x0227
        L_0x012a:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            float r3 = zzf(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x013c:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            double r3 = zze(r9, (long) r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzer.zzav(r3)
            goto L_0x0227
        L_0x0152:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x015e:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x016a:
            java.lang.Object r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
            goto L_0x01c3
        L_0x0175:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r9, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzer.zzav(r3)
            goto L_0x0227
        L_0x0181:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r9, r5)
            goto L_0x0227
        L_0x0189:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r9, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzer.zzav(r3)
            goto L_0x0227
        L_0x0195:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r9, r5)
            goto L_0x0227
        L_0x019d:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r9, r5)
            goto L_0x0227
        L_0x01a5:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r9, r5)
            goto L_0x0227
        L_0x01ad:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01b9:
            java.lang.Object r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
        L_0x01c3:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0228
        L_0x01c7:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01d4:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzer.zzf((boolean) r3)
            goto L_0x0227
        L_0x01df:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r9, r5)
            goto L_0x0227
        L_0x01e6:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r9, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzer.zzav(r3)
            goto L_0x0227
        L_0x01f1:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r9, r5)
            goto L_0x0227
        L_0x01f8:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r9, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzer.zzav(r3)
            goto L_0x0227
        L_0x0203:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r9, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzer.zzav(r3)
            goto L_0x0227
        L_0x020e:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzm(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x0219:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzn(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzer.zzav(r3)
        L_0x0227:
            int r2 = r2 + r3
        L_0x0228:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022c:
            int r2 = r2 * 53
            com.google.android.gms.internal.firebase-perf.zzhf<?, ?> r0 = r8.zzta
            java.lang.Object r0 = r0.zzo(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zztb
            if (r0 == 0) goto L_0x024a
            int r2 = r2 * 53
            com.google.android.gms.internal.firebase-perf.zzef<?> r0 = r8.zztc
            com.google.android.gms.internal.firebase-perf.zzek r9 = r0.zzc(r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x024a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p000firebaseperf.zzge.hashCode(java.lang.Object):int");
    }

    public final void zze(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zztf.length; i += 3) {
                int zzar = zzar(i);
                long j = (long) (1048575 & zzar);
                int i2 = this.zztf[i];
                switch ((zzar & 267386880) >>> 20) {
                    case 0:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhl.zza((Object) t, j, zzhl.zzn(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhl.zza((Object) t, j, zzhl.zzm(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhl.zza((Object) t, j, zzhl.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 3:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhl.zza((Object) t, j, zzhl.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 4:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhl.zza((Object) t, j, zzhl.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 5:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhl.zza((Object) t, j, zzhl.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhl.zza((Object) t, j, zzhl.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhl.zza((Object) t, j, zzhl.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhl.zza((Object) t, j, zzhl.zzo(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 9:
                        zza(t, t2, i);
                        break;
                    case 10:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhl.zza((Object) t, j, zzhl.zzo(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 11:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhl.zza((Object) t, j, zzhl.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 12:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhl.zza((Object) t, j, zzhl.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 13:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhl.zza((Object) t, j, zzhl.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhl.zza((Object) t, j, zzhl.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhl.zza((Object) t, j, zzhl.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 16:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhl.zza((Object) t, j, zzhl.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 17:
                        zza(t, t2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zztq.zza(t, t2, j);
                        break;
                    case 50:
                        zzgp.zza(this.zztr, t, t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzhl.zza((Object) t, j, zzhl.zzo(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 60:
                        zzb(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzhl.zza((Object) t, j, zzhl.zzo(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            if (!this.zztk) {
                zzgp.zza(this.zzta, t, t2);
                if (this.zztb) {
                    zzgp.zza(this.zztc, t, t2);
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    private final void zza(T t, T t2, int i) {
        long zzar = (long) (zzar(i) & 1048575);
        if (zza(t2, i)) {
            Object zzo = zzhl.zzo(t, zzar);
            Object zzo2 = zzhl.zzo(t2, zzar);
            if (zzo != null && zzo2 != null) {
                zzhl.zza((Object) t, zzar, zzer.zzc(zzo, zzo2));
                zzb(t, i);
            } else if (zzo2 != null) {
                zzhl.zza((Object) t, zzar, zzo2);
                zzb(t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzar = zzar(i);
        int i2 = this.zztf[i];
        long j = (long) (zzar & 1048575);
        if (zza(t2, i2, i)) {
            Object zzo = zzhl.zzo(t, j);
            Object zzo2 = zzhl.zzo(t2, j);
            if (zzo != null && zzo2 != null) {
                zzhl.zza((Object) t, j, zzer.zzc(zzo, zzo2));
                zzb(t, i2, i);
            } else if (zzo2 != null) {
                zzhl.zza((Object) t, j, zzo2);
                zzb(t, i2, i);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:398:0x0834, code lost:
        r8 = (r8 + r9) + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:415:0x0900, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:421:0x0915, code lost:
        r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:437:0x095a, code lost:
        r5 = r5 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:476:0x0a11, code lost:
        r5 = r5 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:484:0x0a34, code lost:
        r3 = r3 + 3;
        r9 = r13;
        r7 = 1048575;
        r8 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzm(T r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            boolean r2 = r0.zztk
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 1
            r9 = 0
            r11 = 0
            if (r2 == 0) goto L_0x04f2
            sun.misc.Unsafe r2 = zzte
            r12 = 0
            r13 = 0
        L_0x0016:
            int[] r14 = r0.zztf
            int r14 = r14.length
            if (r12 >= r14) goto L_0x04ea
            int r14 = r0.zzar(r12)
            r15 = r14 & r3
            int r15 = r15 >>> 20
            int[] r3 = r0.zztf
            r3 = r3[r12]
            r14 = r14 & r7
            long r5 = (long) r14
            com.google.android.gms.internal.firebase-perf.zzel r14 = com.google.android.gms.internal.p000firebaseperf.zzel.DOUBLE_LIST_PACKED
            int r14 = r14.id()
            if (r15 < r14) goto L_0x0041
            com.google.android.gms.internal.firebase-perf.zzel r14 = com.google.android.gms.internal.p000firebaseperf.zzel.SINT64_LIST_PACKED
            int r14 = r14.id()
            if (r15 > r14) goto L_0x0041
            int[] r14 = r0.zztf
            int r17 = r12 + 2
            r14 = r14[r17]
            r14 = r14 & r7
            goto L_0x0042
        L_0x0041:
            r14 = 0
        L_0x0042:
            switch(r15) {
                case 0: goto L_0x04d6;
                case 1: goto L_0x04ca;
                case 2: goto L_0x04ba;
                case 3: goto L_0x04aa;
                case 4: goto L_0x049a;
                case 5: goto L_0x048e;
                case 6: goto L_0x0482;
                case 7: goto L_0x0476;
                case 8: goto L_0x0458;
                case 9: goto L_0x0444;
                case 10: goto L_0x0433;
                case 11: goto L_0x0424;
                case 12: goto L_0x0415;
                case 13: goto L_0x040a;
                case 14: goto L_0x03ff;
                case 15: goto L_0x03f0;
                case 16: goto L_0x03e1;
                case 17: goto L_0x03cc;
                case 18: goto L_0x03c1;
                case 19: goto L_0x03b8;
                case 20: goto L_0x03af;
                case 21: goto L_0x03a6;
                case 22: goto L_0x039d;
                case 23: goto L_0x0394;
                case 24: goto L_0x038b;
                case 25: goto L_0x0382;
                case 26: goto L_0x0379;
                case 27: goto L_0x036c;
                case 28: goto L_0x0363;
                case 29: goto L_0x035a;
                case 30: goto L_0x0350;
                case 31: goto L_0x0346;
                case 32: goto L_0x033c;
                case 33: goto L_0x0332;
                case 34: goto L_0x0328;
                case 35: goto L_0x0308;
                case 36: goto L_0x02eb;
                case 37: goto L_0x02ce;
                case 38: goto L_0x02b1;
                case 39: goto L_0x0293;
                case 40: goto L_0x0275;
                case 41: goto L_0x0257;
                case 42: goto L_0x0239;
                case 43: goto L_0x021b;
                case 44: goto L_0x01fd;
                case 45: goto L_0x01df;
                case 46: goto L_0x01c1;
                case 47: goto L_0x01a3;
                case 48: goto L_0x0185;
                case 49: goto L_0x0177;
                case 50: goto L_0x0167;
                case 51: goto L_0x0159;
                case 52: goto L_0x014d;
                case 53: goto L_0x013d;
                case 54: goto L_0x012d;
                case 55: goto L_0x011d;
                case 56: goto L_0x0111;
                case 57: goto L_0x0105;
                case 58: goto L_0x00f9;
                case 59: goto L_0x00db;
                case 60: goto L_0x00c7;
                case 61: goto L_0x00b5;
                case 62: goto L_0x00a5;
                case 63: goto L_0x0095;
                case 64: goto L_0x0089;
                case 65: goto L_0x007d;
                case 66: goto L_0x006d;
                case 67: goto L_0x005d;
                case 68: goto L_0x0047;
                default: goto L_0x0045;
            }
        L_0x0045:
            goto L_0x04e4
        L_0x0047:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r1, r5)
            com.google.android.gms.internal.firebase-perf.zzga r5 = (com.google.android.gms.internal.p000firebaseperf.zzga) r5
            com.google.android.gms.internal.firebase-perf.zzgn r6 = r0.zzap(r12)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x005d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzf((int) r3, (long) r5)
            goto L_0x03c9
        L_0x006d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzg(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzm(r3, r5)
            goto L_0x03c9
        L_0x007d:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzh((int) r3, (long) r9)
            goto L_0x03c9
        L_0x0089:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzo(r3, r11)
            goto L_0x03c9
        L_0x0095:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzg(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzp(r3, r5)
            goto L_0x03c9
        L_0x00a5:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzg(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzl(r3, r5)
            goto L_0x03c9
        L_0x00b5:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r1, r5)
            com.google.android.gms.internal.firebase-perf.zzdl r5 = (com.google.android.gms.internal.p000firebaseperf.zzdl) r5
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzc((int) r3, (com.google.android.gms.internal.p000firebaseperf.zzdl) r5)
            goto L_0x03c9
        L_0x00c7:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r1, r5)
            com.google.android.gms.internal.firebase-perf.zzgn r6 = r0.zzap(r12)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzc((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.p000firebaseperf.zzgn) r6)
            goto L_0x03c9
        L_0x00db:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.p000firebaseperf.zzdl
            if (r6 == 0) goto L_0x00f1
            com.google.android.gms.internal.firebase-perf.zzdl r5 = (com.google.android.gms.internal.p000firebaseperf.zzdl) r5
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzc((int) r3, (com.google.android.gms.internal.p000firebaseperf.zzdl) r5)
            goto L_0x03c9
        L_0x00f1:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzc((int) r3, (java.lang.String) r5)
            goto L_0x03c9
        L_0x00f9:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzb((int) r3, (boolean) r8)
            goto L_0x03c9
        L_0x0105:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzn(r3, r11)
            goto L_0x03c9
        L_0x0111:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzg((int) r3, (long) r9)
            goto L_0x03c9
        L_0x011d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzg(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzk(r3, r5)
            goto L_0x03c9
        L_0x012d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zze(r3, r5)
            goto L_0x03c9
        L_0x013d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzd((int) r3, (long) r5)
            goto L_0x03c9
        L_0x014d:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzb((int) r3, (float) r4)
            goto L_0x03c9
        L_0x0159:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            r5 = 0
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzb((int) r3, (double) r5)
            goto L_0x03c9
        L_0x0167:
            com.google.android.gms.internal.firebase-perf.zzft r14 = r0.zztr
            java.lang.Object r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r1, r5)
            java.lang.Object r6 = r0.zzaq(r12)
            int r3 = r14.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x0177:
            java.util.List r5 = zzd(r1, r5)
            com.google.android.gms.internal.firebase-perf.zzgn r6 = r0.zzap(r12)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzd(r3, r5, r6)
            goto L_0x03c9
        L_0x0185:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzf((java.util.List<java.lang.Long>) r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x0199
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0199:
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x01a3:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzj(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x01b7
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01b7:
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x01c1:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzl(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x01d5
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01d5:
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x01df:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzk(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x01f3
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01f3:
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x01fd:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzg((java.util.List<java.lang.Integer>) r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x0211
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0211:
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x021b:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzi(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x022f
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x022f:
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x0239:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzm(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x024d
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x024d:
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x0257:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzk(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x026b
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x026b:
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x0275:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzl(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x0289
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0289:
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x0293:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzh(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x02a7
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02a7:
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x02b1:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p000firebaseperf.zzgp.zze(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x02c5
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02c5:
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x02ce:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzd(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x02e2
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02e2:
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x02eb:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzk(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x02ff
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02ff:
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x0308:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzl(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x031c
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x031c:
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r5)
        L_0x0324:
            int r3 = r3 + r6
            int r3 = r3 + r5
            goto L_0x03c9
        L_0x0328:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzq(r3, r5, r11)
            goto L_0x03c9
        L_0x0332:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzu(r3, r5, r11)
            goto L_0x03c9
        L_0x033c:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzw(r3, r5, r11)
            goto L_0x03c9
        L_0x0346:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzv(r3, r5, r11)
            goto L_0x03c9
        L_0x0350:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzr(r3, r5, r11)
            goto L_0x03c9
        L_0x035a:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzt(r3, r5, r11)
            goto L_0x03c9
        L_0x0363:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzd(r3, r5)
            goto L_0x03c9
        L_0x036c:
            java.util.List r5 = zzd(r1, r5)
            com.google.android.gms.internal.firebase-perf.zzgn r6 = r0.zzap(r12)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzc((int) r3, (java.util.List<?>) r5, (com.google.android.gms.internal.p000firebaseperf.zzgn) r6)
            goto L_0x03c9
        L_0x0379:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzc(r3, r5)
            goto L_0x03c9
        L_0x0382:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzx(r3, r5, r11)
            goto L_0x03c9
        L_0x038b:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzv(r3, r5, r11)
            goto L_0x03c9
        L_0x0394:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzw(r3, r5, r11)
            goto L_0x03c9
        L_0x039d:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzs(r3, r5, r11)
            goto L_0x03c9
        L_0x03a6:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzp(r3, r5, r11)
            goto L_0x03c9
        L_0x03af:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzo(r3, r5, r11)
            goto L_0x03c9
        L_0x03b8:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzv(r3, r5, r11)
            goto L_0x03c9
        L_0x03c1:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzw(r3, r5, r11)
        L_0x03c9:
            int r13 = r13 + r3
            goto L_0x04e4
        L_0x03cc:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r1, r5)
            com.google.android.gms.internal.firebase-perf.zzga r5 = (com.google.android.gms.internal.p000firebaseperf.zzga) r5
            com.google.android.gms.internal.firebase-perf.zzgn r6 = r0.zzap(r12)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x03e1:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzf((int) r3, (long) r5)
            goto L_0x03c9
        L_0x03f0:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzm(r3, r5)
            goto L_0x03c9
        L_0x03ff:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzh((int) r3, (long) r9)
            goto L_0x03c9
        L_0x040a:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzo(r3, r11)
            goto L_0x03c9
        L_0x0415:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzp(r3, r5)
            goto L_0x03c9
        L_0x0424:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzl(r3, r5)
            goto L_0x03c9
        L_0x0433:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r1, r5)
            com.google.android.gms.internal.firebase-perf.zzdl r5 = (com.google.android.gms.internal.p000firebaseperf.zzdl) r5
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzc((int) r3, (com.google.android.gms.internal.p000firebaseperf.zzdl) r5)
            goto L_0x03c9
        L_0x0444:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r1, r5)
            com.google.android.gms.internal.firebase-perf.zzgn r6 = r0.zzap(r12)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzc((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.p000firebaseperf.zzgn) r6)
            goto L_0x03c9
        L_0x0458:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.p000firebaseperf.zzdl
            if (r6 == 0) goto L_0x046e
            com.google.android.gms.internal.firebase-perf.zzdl r5 = (com.google.android.gms.internal.p000firebaseperf.zzdl) r5
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzc((int) r3, (com.google.android.gms.internal.p000firebaseperf.zzdl) r5)
            goto L_0x03c9
        L_0x046e:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzc((int) r3, (java.lang.String) r5)
            goto L_0x03c9
        L_0x0476:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzb((int) r3, (boolean) r8)
            goto L_0x03c9
        L_0x0482:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzn(r3, r11)
            goto L_0x03c9
        L_0x048e:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzg((int) r3, (long) r9)
            goto L_0x03c9
        L_0x049a:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzk(r3, r5)
            goto L_0x03c9
        L_0x04aa:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zze(r3, r5)
            goto L_0x03c9
        L_0x04ba:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzd((int) r3, (long) r5)
            goto L_0x03c9
        L_0x04ca:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzb((int) r3, (float) r4)
            goto L_0x03c9
        L_0x04d6:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            r5 = 0
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzec.zzb((int) r3, (double) r5)
            goto L_0x03c9
        L_0x04e4:
            int r12 = r12 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0016
        L_0x04ea:
            com.google.android.gms.internal.firebase-perf.zzhf<?, ?> r2 = r0.zzta
            int r1 = zza(r2, r1)
            int r13 = r13 + r1
            return r13
        L_0x04f2:
            sun.misc.Unsafe r2 = zzte
            r3 = -1
            r3 = 0
            r5 = 0
            r6 = -1
            r12 = 0
        L_0x04f9:
            int[] r13 = r0.zztf
            int r13 = r13.length
            if (r3 >= r13) goto L_0x0a3f
            int r13 = r0.zzar(r3)
            int[] r14 = r0.zztf
            r15 = r14[r3]
            r16 = 267386880(0xff00000, float:2.3665827E-29)
            r17 = r13 & r16
            int r4 = r17 >>> 20
            r11 = 17
            if (r4 > r11) goto L_0x0525
            int r11 = r3 + 2
            r11 = r14[r11]
            r14 = r11 & r7
            int r18 = r11 >>> 20
            int r18 = r8 << r18
            if (r14 == r6) goto L_0x0522
            long r8 = (long) r14
            int r12 = r2.getInt(r1, r8)
            goto L_0x0523
        L_0x0522:
            r14 = r6
        L_0x0523:
            r6 = r14
            goto L_0x0545
        L_0x0525:
            boolean r8 = r0.zztl
            if (r8 == 0) goto L_0x0542
            com.google.android.gms.internal.firebase-perf.zzel r8 = com.google.android.gms.internal.p000firebaseperf.zzel.DOUBLE_LIST_PACKED
            int r8 = r8.id()
            if (r4 < r8) goto L_0x0542
            com.google.android.gms.internal.firebase-perf.zzel r8 = com.google.android.gms.internal.p000firebaseperf.zzel.SINT64_LIST_PACKED
            int r8 = r8.id()
            if (r4 > r8) goto L_0x0542
            int[] r8 = r0.zztf
            int r9 = r3 + 2
            r8 = r8[r9]
            r11 = r8 & r7
            goto L_0x0543
        L_0x0542:
            r11 = 0
        L_0x0543:
            r18 = 0
        L_0x0545:
            r8 = r13 & r7
            long r8 = (long) r8
            switch(r4) {
                case 0: goto L_0x0a24;
                case 1: goto L_0x0a13;
                case 2: goto L_0x0a01;
                case 3: goto L_0x09f0;
                case 4: goto L_0x09df;
                case 5: goto L_0x09cf;
                case 6: goto L_0x09bf;
                case 7: goto L_0x09b3;
                case 8: goto L_0x0997;
                case 9: goto L_0x0985;
                case 10: goto L_0x0976;
                case 11: goto L_0x0969;
                case 12: goto L_0x095c;
                case 13: goto L_0x0951;
                case 14: goto L_0x0946;
                case 15: goto L_0x0939;
                case 16: goto L_0x092c;
                case 17: goto L_0x0919;
                case 18: goto L_0x0905;
                case 19: goto L_0x08f5;
                case 20: goto L_0x08e9;
                case 21: goto L_0x08dd;
                case 22: goto L_0x08d1;
                case 23: goto L_0x08c5;
                case 24: goto L_0x08b9;
                case 25: goto L_0x08ad;
                case 26: goto L_0x08a2;
                case 27: goto L_0x0892;
                case 28: goto L_0x0886;
                case 29: goto L_0x0879;
                case 30: goto L_0x086c;
                case 31: goto L_0x085f;
                case 32: goto L_0x0852;
                case 33: goto L_0x0845;
                case 34: goto L_0x0838;
                case 35: goto L_0x0818;
                case 36: goto L_0x07fb;
                case 37: goto L_0x07de;
                case 38: goto L_0x07c1;
                case 39: goto L_0x07a3;
                case 40: goto L_0x0785;
                case 41: goto L_0x0767;
                case 42: goto L_0x0749;
                case 43: goto L_0x072b;
                case 44: goto L_0x070d;
                case 45: goto L_0x06ef;
                case 46: goto L_0x06d1;
                case 47: goto L_0x06b3;
                case 48: goto L_0x0695;
                case 49: goto L_0x0685;
                case 50: goto L_0x0675;
                case 51: goto L_0x0667;
                case 52: goto L_0x065a;
                case 53: goto L_0x064a;
                case 54: goto L_0x063a;
                case 55: goto L_0x062a;
                case 56: goto L_0x061c;
                case 57: goto L_0x060f;
                case 58: goto L_0x0602;
                case 59: goto L_0x05e4;
                case 60: goto L_0x05d0;
                case 61: goto L_0x05be;
                case 62: goto L_0x05ae;
                case 63: goto L_0x059e;
                case 64: goto L_0x0591;
                case 65: goto L_0x0583;
                case 66: goto L_0x0573;
                case 67: goto L_0x0563;
                case 68: goto L_0x054d;
                default: goto L_0x054b;
            }
        L_0x054b:
            goto L_0x0911
        L_0x054d:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.firebase-perf.zzga r4 = (com.google.android.gms.internal.p000firebaseperf.zzga) r4
            com.google.android.gms.internal.firebase-perf.zzgn r8 = r0.zzap(r3)
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzec.zzc(r15, r4, r8)
            goto L_0x0910
        L_0x0563:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            long r8 = zzh(r1, r8)
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzec.zzf((int) r15, (long) r8)
            goto L_0x0910
        L_0x0573:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            int r4 = zzg(r1, r8)
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzec.zzm(r15, r4)
            goto L_0x0910
        L_0x0583:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r8 = 0
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzec.zzh((int) r15, (long) r8)
            goto L_0x0910
        L_0x0591:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r4 = 0
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzec.zzo(r15, r4)
            goto L_0x095a
        L_0x059e:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            int r4 = zzg(r1, r8)
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzec.zzp(r15, r4)
            goto L_0x0910
        L_0x05ae:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            int r4 = zzg(r1, r8)
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzec.zzl(r15, r4)
            goto L_0x0910
        L_0x05be:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.firebase-perf.zzdl r4 = (com.google.android.gms.internal.p000firebaseperf.zzdl) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzec.zzc((int) r15, (com.google.android.gms.internal.p000firebaseperf.zzdl) r4)
            goto L_0x0910
        L_0x05d0:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.firebase-perf.zzgn r8 = r0.zzap(r3)
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzc((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.p000firebaseperf.zzgn) r8)
            goto L_0x0910
        L_0x05e4:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            boolean r8 = r4 instanceof com.google.android.gms.internal.p000firebaseperf.zzdl
            if (r8 == 0) goto L_0x05fa
            com.google.android.gms.internal.firebase-perf.zzdl r4 = (com.google.android.gms.internal.p000firebaseperf.zzdl) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzec.zzc((int) r15, (com.google.android.gms.internal.p000firebaseperf.zzdl) r4)
            goto L_0x0910
        L_0x05fa:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzec.zzc((int) r15, (java.lang.String) r4)
            goto L_0x0910
        L_0x0602:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r4 = 1
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzec.zzb((int) r15, (boolean) r4)
            goto L_0x095a
        L_0x060f:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r4 = 0
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzec.zzn(r15, r4)
            goto L_0x095a
        L_0x061c:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r8 = 0
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzec.zzg((int) r15, (long) r8)
            goto L_0x0910
        L_0x062a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            int r4 = zzg(r1, r8)
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzec.zzk(r15, r4)
            goto L_0x0910
        L_0x063a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            long r8 = zzh(r1, r8)
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzec.zze(r15, r8)
            goto L_0x0910
        L_0x064a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            long r8 = zzh(r1, r8)
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzec.zzd((int) r15, (long) r8)
            goto L_0x0910
        L_0x065a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r4 = 0
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzec.zzb((int) r15, (float) r4)
            goto L_0x095a
        L_0x0667:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r8 = 0
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzec.zzb((int) r15, (double) r8)
            goto L_0x0910
        L_0x0675:
            com.google.android.gms.internal.firebase-perf.zzft r4 = r0.zztr
            java.lang.Object r8 = r2.getObject(r1, r8)
            java.lang.Object r9 = r0.zzaq(r3)
            int r4 = r4.zzc(r15, r8, r9)
            goto L_0x0910
        L_0x0685:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase-perf.zzgn r8 = r0.zzap(r3)
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzd(r15, r4, r8)
            goto L_0x0910
        L_0x0695:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzf((java.util.List<java.lang.Long>) r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztl
            if (r8 == 0) goto L_0x06a9
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x06a9:
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x06b3:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzj(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztl
            if (r8 == 0) goto L_0x06c7
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x06c7:
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x06d1:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzl(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztl
            if (r8 == 0) goto L_0x06e5
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x06e5:
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x06ef:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzk(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztl
            if (r8 == 0) goto L_0x0703
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x0703:
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x070d:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzg((java.util.List<java.lang.Integer>) r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztl
            if (r8 == 0) goto L_0x0721
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x0721:
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x072b:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzi(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztl
            if (r8 == 0) goto L_0x073f
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x073f:
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x0749:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzm(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztl
            if (r8 == 0) goto L_0x075d
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x075d:
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x0767:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzk(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztl
            if (r8 == 0) goto L_0x077b
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x077b:
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x0785:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzl(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztl
            if (r8 == 0) goto L_0x0799
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x0799:
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x07a3:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzh(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztl
            if (r8 == 0) goto L_0x07b7
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x07b7:
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x07c1:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zze(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztl
            if (r8 == 0) goto L_0x07d5
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x07d5:
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x07de:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzd(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztl
            if (r8 == 0) goto L_0x07f2
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x07f2:
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x07fb:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzk(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztl
            if (r8 == 0) goto L_0x080f
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x080f:
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x0818:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzl(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztl
            if (r8 == 0) goto L_0x082c
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x082c:
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.p000firebaseperf.zzec.zzaa(r4)
        L_0x0834:
            int r8 = r8 + r9
            int r8 = r8 + r4
            goto L_0x095a
        L_0x0838:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            r10 = 0
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzq(r15, r4, r10)
            goto L_0x0900
        L_0x0845:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzu(r15, r4, r10)
            goto L_0x0900
        L_0x0852:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzw(r15, r4, r10)
            goto L_0x0900
        L_0x085f:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzv(r15, r4, r10)
            goto L_0x0900
        L_0x086c:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzr(r15, r4, r10)
            goto L_0x0900
        L_0x0879:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzt(r15, r4, r10)
            goto L_0x0910
        L_0x0886:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzd(r15, r4)
            goto L_0x0910
        L_0x0892:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase-perf.zzgn r8 = r0.zzap(r3)
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzc((int) r15, (java.util.List<?>) r4, (com.google.android.gms.internal.p000firebaseperf.zzgn) r8)
            goto L_0x0910
        L_0x08a2:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzc(r15, r4)
            goto L_0x0910
        L_0x08ad:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            r10 = 0
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzx(r15, r4, r10)
            goto L_0x0900
        L_0x08b9:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzv(r15, r4, r10)
            goto L_0x0900
        L_0x08c5:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzw(r15, r4, r10)
            goto L_0x0900
        L_0x08d1:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzs(r15, r4, r10)
            goto L_0x0900
        L_0x08dd:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzp(r15, r4, r10)
            goto L_0x0900
        L_0x08e9:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzo(r15, r4, r10)
            goto L_0x0900
        L_0x08f5:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzv(r15, r4, r10)
        L_0x0900:
            int r5 = r5 + r4
            r4 = 1
        L_0x0902:
            r7 = 0
            goto L_0x0915
        L_0x0905:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzw(r15, r4, r10)
        L_0x0910:
            int r5 = r5 + r4
        L_0x0911:
            r4 = 1
        L_0x0912:
            r7 = 0
            r10 = 0
        L_0x0915:
            r13 = 0
            goto L_0x0a34
        L_0x0919:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.firebase-perf.zzga r4 = (com.google.android.gms.internal.p000firebaseperf.zzga) r4
            com.google.android.gms.internal.firebase-perf.zzgn r8 = r0.zzap(r3)
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzec.zzc(r15, r4, r8)
            goto L_0x0910
        L_0x092c:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            long r8 = r2.getLong(r1, r8)
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzec.zzf((int) r15, (long) r8)
            goto L_0x0910
        L_0x0939:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzec.zzm(r15, r4)
            goto L_0x0910
        L_0x0946:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            r8 = 0
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzec.zzh((int) r15, (long) r8)
            goto L_0x0910
        L_0x0951:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            r4 = 0
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzec.zzo(r15, r4)
        L_0x095a:
            int r5 = r5 + r8
            goto L_0x0911
        L_0x095c:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzec.zzp(r15, r4)
            goto L_0x0910
        L_0x0969:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzec.zzl(r15, r4)
            goto L_0x0910
        L_0x0976:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.firebase-perf.zzdl r4 = (com.google.android.gms.internal.p000firebaseperf.zzdl) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzec.zzc((int) r15, (com.google.android.gms.internal.p000firebaseperf.zzdl) r4)
            goto L_0x0910
        L_0x0985:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.firebase-perf.zzgn r8 = r0.zzap(r3)
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzgp.zzc((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.p000firebaseperf.zzgn) r8)
            goto L_0x0910
        L_0x0997:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            boolean r8 = r4 instanceof com.google.android.gms.internal.p000firebaseperf.zzdl
            if (r8 == 0) goto L_0x09ab
            com.google.android.gms.internal.firebase-perf.zzdl r4 = (com.google.android.gms.internal.p000firebaseperf.zzdl) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzec.zzc((int) r15, (com.google.android.gms.internal.p000firebaseperf.zzdl) r4)
            goto L_0x0910
        L_0x09ab:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.p000firebaseperf.zzec.zzc((int) r15, (java.lang.String) r4)
            goto L_0x0910
        L_0x09b3:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            r4 = 1
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzec.zzb((int) r15, (boolean) r4)
            int r5 = r5 + r8
            goto L_0x0912
        L_0x09bf:
            r4 = 1
            r8 = r12 & r18
            if (r8 == 0) goto L_0x09cc
            r10 = 0
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzec.zzn(r15, r10)
            int r5 = r5 + r8
            goto L_0x0902
        L_0x09cc:
            r10 = 0
            goto L_0x0902
        L_0x09cf:
            r4 = 1
            r10 = 0
            r8 = r12 & r18
            if (r8 == 0) goto L_0x09dc
            r13 = 0
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzec.zzg((int) r15, (long) r13)
            goto L_0x0a11
        L_0x09dc:
            r13 = 0
            goto L_0x0a21
        L_0x09df:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a21
            int r8 = r2.getInt(r1, r8)
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzec.zzk(r15, r8)
            goto L_0x0a11
        L_0x09f0:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a21
            long r8 = r2.getLong(r1, r8)
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzec.zze(r15, r8)
            goto L_0x0a11
        L_0x0a01:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a21
            long r8 = r2.getLong(r1, r8)
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzec.zzd((int) r15, (long) r8)
        L_0x0a11:
            int r5 = r5 + r8
            goto L_0x0a21
        L_0x0a13:
            r4 = 1
            r10 = 0
            r13 = 0
            r8 = r12 & r18
            if (r8 == 0) goto L_0x0a21
            r8 = 0
            int r9 = com.google.android.gms.internal.p000firebaseperf.zzec.zzb((int) r15, (float) r8)
            int r5 = r5 + r9
        L_0x0a21:
            r7 = 0
            goto L_0x0a34
        L_0x0a24:
            r4 = 1
            r8 = 0
            r10 = 0
            r13 = 0
            r9 = r12 & r18
            if (r9 == 0) goto L_0x0a21
            r7 = 0
            int r11 = com.google.android.gms.internal.p000firebaseperf.zzec.zzb((int) r15, (double) r7)
            int r5 = r5 + r11
        L_0x0a34:
            int r3 = r3 + 3
            r9 = r13
            r4 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 1
            r11 = 0
            goto L_0x04f9
        L_0x0a3f:
            r10 = 0
            com.google.android.gms.internal.firebase-perf.zzhf<?, ?> r2 = r0.zzta
            int r2 = zza(r2, r1)
            int r5 = r5 + r2
            boolean r2 = r0.zztb
            if (r2 == 0) goto L_0x0a99
            com.google.android.gms.internal.firebase-perf.zzef<?> r2 = r0.zztc
            com.google.android.gms.internal.firebase-perf.zzek r1 = r2.zzc(r1)
            r2 = 0
        L_0x0a52:
            com.google.android.gms.internal.firebase-perf.zzgs<FieldDescriptorType, java.lang.Object> r3 = r1.zznt
            int r3 = r3.zziz()
            if (r10 >= r3) goto L_0x0a72
            com.google.android.gms.internal.firebase-perf.zzgs<FieldDescriptorType, java.lang.Object> r3 = r1.zznt
            java.util.Map$Entry r3 = r3.zzau(r10)
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.firebase-perf.zzem r4 = (com.google.android.gms.internal.p000firebaseperf.zzem) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzek.zzb((com.google.android.gms.internal.p000firebaseperf.zzem<?>) r4, (java.lang.Object) r3)
            int r2 = r2 + r3
            int r10 = r10 + 1
            goto L_0x0a52
        L_0x0a72:
            com.google.android.gms.internal.firebase-perf.zzgs<FieldDescriptorType, java.lang.Object> r1 = r1.zznt
            java.lang.Iterable r1 = r1.zzja()
            java.util.Iterator r1 = r1.iterator()
        L_0x0a7c:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0a98
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.firebase-perf.zzem r4 = (com.google.android.gms.internal.p000firebaseperf.zzem) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.p000firebaseperf.zzek.zzb((com.google.android.gms.internal.p000firebaseperf.zzem<?>) r4, (java.lang.Object) r3)
            int r2 = r2 + r3
            goto L_0x0a7c
        L_0x0a98:
            int r5 = r5 + r2
        L_0x0a99:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p000firebaseperf.zzge.zzm(java.lang.Object):int");
    }

    private static <UT, UB> int zza(zzhf<UT, UB> zzhf, T t) {
        return zzhf.zzm(zzhf.zzo(t));
    }

    private static List<?> zzd(Object obj, long j) {
        return (List) zzhl.zzo(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0553  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.p000firebaseperf.zzhz r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zzgt()
            int r1 = com.google.android.gms.internal.p000firebaseperf.zzep.zzc.zzre
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0529
            com.google.android.gms.internal.firebase-perf.zzhf<?, ?> r0 = r13.zzta
            zza(r0, r14, (com.google.android.gms.internal.p000firebaseperf.zzhz) r15)
            boolean r0 = r13.zztb
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.firebase-perf.zzef<?> r0 = r13.zztc
            com.google.android.gms.internal.firebase-perf.zzek r0 = r0.zzc(r14)
            com.google.android.gms.internal.firebase-perf.zzgs<FieldDescriptorType, java.lang.Object> r1 = r0.zznt
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0032
            java.util.Iterator r0 = r0.descendingIterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0034
        L_0x0032:
            r0 = r3
            r1 = r0
        L_0x0034:
            int[] r7 = r13.zztf
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0039:
            if (r7 < 0) goto L_0x0511
            int r8 = r13.zzar(r7)
            int[] r9 = r13.zztf
            r9 = r9[r7]
        L_0x0043:
            if (r1 == 0) goto L_0x0061
            com.google.android.gms.internal.firebase-perf.zzef<?> r10 = r13.zztc
            int r10 = r10.zzb(r1)
            if (r10 <= r9) goto L_0x0061
            com.google.android.gms.internal.firebase-perf.zzef<?> r10 = r13.zztc
            r10.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005f
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0043
        L_0x005f:
            r1 = r3
            goto L_0x0043
        L_0x0061:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x04fe;
                case 1: goto L_0x04ee;
                case 2: goto L_0x04de;
                case 3: goto L_0x04ce;
                case 4: goto L_0x04be;
                case 5: goto L_0x04ae;
                case 6: goto L_0x049e;
                case 7: goto L_0x048d;
                case 8: goto L_0x047c;
                case 9: goto L_0x0467;
                case 10: goto L_0x0454;
                case 11: goto L_0x0443;
                case 12: goto L_0x0432;
                case 13: goto L_0x0421;
                case 14: goto L_0x0410;
                case 15: goto L_0x03ff;
                case 16: goto L_0x03ee;
                case 17: goto L_0x03d9;
                case 18: goto L_0x03c8;
                case 19: goto L_0x03b7;
                case 20: goto L_0x03a6;
                case 21: goto L_0x0395;
                case 22: goto L_0x0384;
                case 23: goto L_0x0373;
                case 24: goto L_0x0362;
                case 25: goto L_0x0351;
                case 26: goto L_0x0340;
                case 27: goto L_0x032b;
                case 28: goto L_0x031a;
                case 29: goto L_0x0309;
                case 30: goto L_0x02f8;
                case 31: goto L_0x02e7;
                case 32: goto L_0x02d6;
                case 33: goto L_0x02c5;
                case 34: goto L_0x02b4;
                case 35: goto L_0x02a3;
                case 36: goto L_0x0292;
                case 37: goto L_0x0281;
                case 38: goto L_0x0270;
                case 39: goto L_0x025f;
                case 40: goto L_0x024e;
                case 41: goto L_0x023d;
                case 42: goto L_0x022c;
                case 43: goto L_0x021b;
                case 44: goto L_0x020a;
                case 45: goto L_0x01f9;
                case 46: goto L_0x01e8;
                case 47: goto L_0x01d7;
                case 48: goto L_0x01c6;
                case 49: goto L_0x01b1;
                case 50: goto L_0x01a6;
                case 51: goto L_0x0195;
                case 52: goto L_0x0184;
                case 53: goto L_0x0173;
                case 54: goto L_0x0162;
                case 55: goto L_0x0151;
                case 56: goto L_0x0140;
                case 57: goto L_0x012f;
                case 58: goto L_0x011e;
                case 59: goto L_0x010d;
                case 60: goto L_0x00f8;
                case 61: goto L_0x00e5;
                case 62: goto L_0x00d4;
                case 63: goto L_0x00c3;
                case 64: goto L_0x00b2;
                case 65: goto L_0x00a1;
                case 66: goto L_0x0090;
                case 67: goto L_0x007f;
                case 68: goto L_0x006a;
                default: goto L_0x0068;
            }
        L_0x0068:
            goto L_0x050d
        L_0x006a:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            com.google.android.gms.internal.firebase-perf.zzgn r10 = r13.zzap(r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.p000firebaseperf.zzgn) r10)
            goto L_0x050d
        L_0x007f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x050d
        L_0x0090:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            r15.zzi((int) r9, (int) r8)
            goto L_0x050d
        L_0x00a1:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            r15.zzj((int) r9, (long) r10)
            goto L_0x050d
        L_0x00b2:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            r15.zzq(r9, r8)
            goto L_0x050d
        L_0x00c3:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            r15.zzr(r9, r8)
            goto L_0x050d
        L_0x00d4:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            r15.zzh(r9, r8)
            goto L_0x050d
        L_0x00e5:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            com.google.android.gms.internal.firebase-perf.zzdl r8 = (com.google.android.gms.internal.p000firebaseperf.zzdl) r8
            r15.zza((int) r9, (com.google.android.gms.internal.p000firebaseperf.zzdl) r8)
            goto L_0x050d
        L_0x00f8:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            com.google.android.gms.internal.firebase-perf.zzgn r10 = r13.zzap(r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.p000firebaseperf.zzgn) r10)
            goto L_0x050d
        L_0x010d:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.p000firebaseperf.zzhz) r15)
            goto L_0x050d
        L_0x011e:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzi(r14, r10)
            r15.zza((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x012f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            r15.zzj((int) r9, (int) r8)
            goto L_0x050d
        L_0x0140:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            r15.zzc(r9, r10)
            goto L_0x050d
        L_0x0151:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            r15.zzg(r9, r8)
            goto L_0x050d
        L_0x0162:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x050d
        L_0x0173:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            r15.zzi((int) r9, (long) r10)
            goto L_0x050d
        L_0x0184:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzf(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x050d
        L_0x0195:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zze(r14, (long) r10)
            r15.zza((int) r9, (double) r10)
            goto L_0x050d
        L_0x01a6:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            r13.zza((com.google.android.gms.internal.p000firebaseperf.zzhz) r15, (int) r9, (java.lang.Object) r8, (int) r7)
            goto L_0x050d
        L_0x01b1:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgn r10 = r13.zzap(r7)
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzb((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.p000firebaseperf.zzhz) r15, (com.google.android.gms.internal.p000firebaseperf.zzgn) r10)
            goto L_0x050d
        L_0x01c6:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zze(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01d7:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzj(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01e8:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzg(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01f9:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzl(r9, r8, r15, r4)
            goto L_0x050d
        L_0x020a:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzm(r9, r8, r15, r4)
            goto L_0x050d
        L_0x021b:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzi(r9, r8, r15, r4)
            goto L_0x050d
        L_0x022c:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzn(r9, r8, r15, r4)
            goto L_0x050d
        L_0x023d:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzk(r9, r8, r15, r4)
            goto L_0x050d
        L_0x024e:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzf(r9, r8, r15, r4)
            goto L_0x050d
        L_0x025f:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzh(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0270:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzd(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0281:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzc(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0292:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.p000firebaseperf.zzhz) r15, (boolean) r4)
            goto L_0x050d
        L_0x02a3:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.p000firebaseperf.zzhz) r15, (boolean) r4)
            goto L_0x050d
        L_0x02b4:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zze(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02c5:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzj(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02d6:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzg(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02e7:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzl(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02f8:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzm(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0309:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzi(r9, r8, r15, r5)
            goto L_0x050d
        L_0x031a:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzb(r9, r8, r15)
            goto L_0x050d
        L_0x032b:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgn r10 = r13.zzap(r7)
            com.google.android.gms.internal.p000firebaseperf.zzgp.zza((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.p000firebaseperf.zzhz) r15, (com.google.android.gms.internal.p000firebaseperf.zzgn) r10)
            goto L_0x050d
        L_0x0340:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zza((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.p000firebaseperf.zzhz) r15)
            goto L_0x050d
        L_0x0351:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzn(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0362:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzk(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0373:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzf(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0384:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzh(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0395:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzd(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03a6:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzc(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03b7:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.p000firebaseperf.zzhz) r15, (boolean) r5)
            goto L_0x050d
        L_0x03c8:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p000firebaseperf.zzgp.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.p000firebaseperf.zzhz) r15, (boolean) r5)
            goto L_0x050d
        L_0x03d9:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            com.google.android.gms.internal.firebase-perf.zzgn r10 = r13.zzap(r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.p000firebaseperf.zzgn) r10)
            goto L_0x050d
        L_0x03ee:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x050d
        L_0x03ff:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r14, r10)
            r15.zzi((int) r9, (int) r8)
            goto L_0x050d
        L_0x0410:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r14, r10)
            r15.zzj((int) r9, (long) r10)
            goto L_0x050d
        L_0x0421:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r14, r10)
            r15.zzq(r9, r8)
            goto L_0x050d
        L_0x0432:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r14, r10)
            r15.zzr(r9, r8)
            goto L_0x050d
        L_0x0443:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r14, r10)
            r15.zzh(r9, r8)
            goto L_0x050d
        L_0x0454:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            com.google.android.gms.internal.firebase-perf.zzdl r8 = (com.google.android.gms.internal.p000firebaseperf.zzdl) r8
            r15.zza((int) r9, (com.google.android.gms.internal.p000firebaseperf.zzdl) r8)
            goto L_0x050d
        L_0x0467:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            com.google.android.gms.internal.firebase-perf.zzgn r10 = r13.zzap(r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.p000firebaseperf.zzgn) r10)
            goto L_0x050d
        L_0x047c:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.p000firebaseperf.zzhz) r15)
            goto L_0x050d
        L_0x048d:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzl(r14, r10)
            r15.zza((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x049e:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r14, r10)
            r15.zzj((int) r9, (int) r8)
            goto L_0x050d
        L_0x04ae:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r14, r10)
            r15.zzc(r9, r10)
            goto L_0x050d
        L_0x04be:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r14, r10)
            r15.zzg(r9, r8)
            goto L_0x050d
        L_0x04ce:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x050d
        L_0x04de:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r14, r10)
            r15.zzi((int) r9, (long) r10)
            goto L_0x050d
        L_0x04ee:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzm(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x050d
        L_0x04fe:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzn(r14, r10)
            r15.zza((int) r9, (double) r10)
        L_0x050d:
            int r7 = r7 + -3
            goto L_0x0039
        L_0x0511:
            if (r1 == 0) goto L_0x0528
            com.google.android.gms.internal.firebase-perf.zzef<?> r14 = r13.zztc
            r14.zza(r15, r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x0526
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x0511
        L_0x0526:
            r1 = r3
            goto L_0x0511
        L_0x0528:
            return
        L_0x0529:
            boolean r0 = r13.zztk
            if (r0 == 0) goto L_0x0a46
            boolean r0 = r13.zztb
            if (r0 == 0) goto L_0x054a
            com.google.android.gms.internal.firebase-perf.zzef<?> r0 = r13.zztc
            com.google.android.gms.internal.firebase-perf.zzek r0 = r0.zzc(r14)
            com.google.android.gms.internal.firebase-perf.zzgs<FieldDescriptorType, java.lang.Object> r1 = r0.zznt
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x054a
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x054c
        L_0x054a:
            r0 = r3
            r1 = r0
        L_0x054c:
            int[] r7 = r13.zztf
            int r7 = r7.length
            r8 = r1
            r1 = 0
        L_0x0551:
            if (r1 >= r7) goto L_0x0a29
            int r9 = r13.zzar(r1)
            int[] r10 = r13.zztf
            r10 = r10[r1]
        L_0x055b:
            if (r8 == 0) goto L_0x0579
            com.google.android.gms.internal.firebase-perf.zzef<?> r11 = r13.zztc
            int r11 = r11.zzb(r8)
            if (r11 > r10) goto L_0x0579
            com.google.android.gms.internal.firebase-perf.zzef<?> r11 = r13.zztc
            r11.zza(r15, r8)
            boolean r8 = r0.hasNext()
            if (r8 == 0) goto L_0x0577
            java.lang.Object r8 = r0.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            goto L_0x055b
        L_0x0577:
            r8 = r3
            goto L_0x055b
        L_0x0579:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0a16;
                case 1: goto L_0x0a06;
                case 2: goto L_0x09f6;
                case 3: goto L_0x09e6;
                case 4: goto L_0x09d6;
                case 5: goto L_0x09c6;
                case 6: goto L_0x09b6;
                case 7: goto L_0x09a5;
                case 8: goto L_0x0994;
                case 9: goto L_0x097f;
                case 10: goto L_0x096c;
                case 11: goto L_0x095b;
                case 12: goto L_0x094a;
                case 13: goto L_0x0939;
                case 14: goto L_0x0928;
                case 15: goto L_0x0917;
                case 16: goto L_0x0906;
                case 17: goto L_0x08f1;
                case 18: goto L_0x08e0;
                case 19: goto L_0x08cf;
                case 20: goto L_0x08be;
                case 21: goto L_0x08ad;
                case 22: goto L_0x089c;
                case 23: goto L_0x088b;
                case 24: goto L_0x087a;
                case 25: goto L_0x0869;
                case 26: goto L_0x0858;
                case 27: goto L_0x0843;
                case 28: goto L_0x0832;
                case 29: goto L_0x0821;
                case 30: goto L_0x0810;
                case 31: goto L_0x07ff;
                case 32: goto L_0x07ee;
                case 33: goto L_0x07dd;
                case 34: goto L_0x07cc;
                case 35: goto L_0x07bb;
                case 36: goto L_0x07aa;
                case 37: goto L_0x0799;
                case 38: goto L_0x0788;
                case 39: goto L_0x0777;
                case 40: goto L_0x0766;
                case 41: goto L_0x0755;
                case 42: goto L_0x0744;
                case 43: goto L_0x0733;
                case 44: goto L_0x0722;
                case 45: goto L_0x0711;
                case 46: goto L_0x0700;
                case 47: goto L_0x06ef;
                case 48: goto L_0x06de;
                case 49: goto L_0x06c9;
                case 50: goto L_0x06be;
                case 51: goto L_0x06ad;
                case 52: goto L_0x069c;
                case 53: goto L_0x068b;
                case 54: goto L_0x067a;
                case 55: goto L_0x0669;
                case 56: goto L_0x0658;
                case 57: goto L_0x0647;
                case 58: goto L_0x0636;
                case 59: goto L_0x0625;
                case 60: goto L_0x0610;
                case 61: goto L_0x05fd;
                case 62: goto L_0x05ec;
                case 63: goto L_0x05db;
                case 64: goto L_0x05ca;
                case 65: goto L_0x05b9;
                case 66: goto L_0x05a8;
                case 67: goto L_0x0597;
                case 68: goto L_0x0582;
                default: goto L_0x0580;
            }
        L_0x0580:
            goto L_0x0a25
        L_0x0582:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            com.google.android.gms.internal.firebase-perf.zzgn r11 = r13.zzap(r1)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.p000firebaseperf.zzgn) r11)
            goto L_0x0a25
        L_0x0597:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0a25
        L_0x05a8:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            r15.zzi((int) r10, (int) r9)
            goto L_0x0a25
        L_0x05b9:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            r15.zzj((int) r10, (long) r11)
            goto L_0x0a25
        L_0x05ca:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            r15.zzq(r10, r9)
            goto L_0x0a25
        L_0x05db:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            r15.zzr(r10, r9)
            goto L_0x0a25
        L_0x05ec:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            r15.zzh(r10, r9)
            goto L_0x0a25
        L_0x05fd:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            com.google.android.gms.internal.firebase-perf.zzdl r9 = (com.google.android.gms.internal.p000firebaseperf.zzdl) r9
            r15.zza((int) r10, (com.google.android.gms.internal.p000firebaseperf.zzdl) r9)
            goto L_0x0a25
        L_0x0610:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            com.google.android.gms.internal.firebase-perf.zzgn r11 = r13.zzap(r1)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.p000firebaseperf.zzgn) r11)
            goto L_0x0a25
        L_0x0625:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.p000firebaseperf.zzhz) r15)
            goto L_0x0a25
        L_0x0636:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzi(r14, r11)
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0a25
        L_0x0647:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            r15.zzj((int) r10, (int) r9)
            goto L_0x0a25
        L_0x0658:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            r15.zzc(r10, r11)
            goto L_0x0a25
        L_0x0669:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            r15.zzg(r10, r9)
            goto L_0x0a25
        L_0x067a:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0a25
        L_0x068b:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            r15.zzi((int) r10, (long) r11)
            goto L_0x0a25
        L_0x069c:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzf(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0a25
        L_0x06ad:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zze(r14, (long) r11)
            r15.zza((int) r10, (double) r11)
            goto L_0x0a25
        L_0x06be:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            r13.zza((com.google.android.gms.internal.p000firebaseperf.zzhz) r15, (int) r10, (java.lang.Object) r9, (int) r1)
            goto L_0x0a25
        L_0x06c9:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzgn r11 = r13.zzap(r1)
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzb((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.p000firebaseperf.zzhz) r15, (com.google.android.gms.internal.p000firebaseperf.zzgn) r11)
            goto L_0x0a25
        L_0x06de:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zze(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x06ef:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzj(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0700:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzg(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0711:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzl(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0722:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzm(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0733:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzi(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0744:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzn(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0755:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzk(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0766:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzf(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0777:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzh(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0788:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzd(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0799:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzc(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x07aa:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.p000firebaseperf.zzhz) r15, (boolean) r4)
            goto L_0x0a25
        L_0x07bb:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.p000firebaseperf.zzhz) r15, (boolean) r4)
            goto L_0x0a25
        L_0x07cc:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zze(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x07dd:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzj(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x07ee:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzg(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x07ff:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzl(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x0810:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzm(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x0821:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzi(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x0832:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzb(r10, r9, r15)
            goto L_0x0a25
        L_0x0843:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzgn r11 = r13.zzap(r1)
            com.google.android.gms.internal.p000firebaseperf.zzgp.zza((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.p000firebaseperf.zzhz) r15, (com.google.android.gms.internal.p000firebaseperf.zzgn) r11)
            goto L_0x0a25
        L_0x0858:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zza((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.p000firebaseperf.zzhz) r15)
            goto L_0x0a25
        L_0x0869:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzn(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x087a:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzk(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x088b:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzf(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x089c:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzh(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x08ad:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzd(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x08be:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzc(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x08cf:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.p000firebaseperf.zzhz) r15, (boolean) r5)
            goto L_0x0a25
        L_0x08e0:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.p000firebaseperf.zzhz) r15, (boolean) r5)
            goto L_0x0a25
        L_0x08f1:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            com.google.android.gms.internal.firebase-perf.zzgn r11 = r13.zzap(r1)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.p000firebaseperf.zzgn) r11)
            goto L_0x0a25
        L_0x0906:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0a25
        L_0x0917:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r14, r11)
            r15.zzi((int) r10, (int) r9)
            goto L_0x0a25
        L_0x0928:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r14, r11)
            r15.zzj((int) r10, (long) r11)
            goto L_0x0a25
        L_0x0939:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r14, r11)
            r15.zzq(r10, r9)
            goto L_0x0a25
        L_0x094a:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r14, r11)
            r15.zzr(r10, r9)
            goto L_0x0a25
        L_0x095b:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r14, r11)
            r15.zzh(r10, r9)
            goto L_0x0a25
        L_0x096c:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            com.google.android.gms.internal.firebase-perf.zzdl r9 = (com.google.android.gms.internal.p000firebaseperf.zzdl) r9
            r15.zza((int) r10, (com.google.android.gms.internal.p000firebaseperf.zzdl) r9)
            goto L_0x0a25
        L_0x097f:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            com.google.android.gms.internal.firebase-perf.zzgn r11 = r13.zzap(r1)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.p000firebaseperf.zzgn) r11)
            goto L_0x0a25
        L_0x0994:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzo(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.p000firebaseperf.zzhz) r15)
            goto L_0x0a25
        L_0x09a5:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzl(r14, r11)
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0a25
        L_0x09b6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r14, r11)
            r15.zzj((int) r10, (int) r9)
            goto L_0x0a25
        L_0x09c6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r14, r11)
            r15.zzc(r10, r11)
            goto L_0x0a25
        L_0x09d6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzj(r14, r11)
            r15.zzg(r10, r9)
            goto L_0x0a25
        L_0x09e6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0a25
        L_0x09f6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzk(r14, r11)
            r15.zzi((int) r10, (long) r11)
            goto L_0x0a25
        L_0x0a06:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzm(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0a25
        L_0x0a16:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzn(r14, r11)
            r15.zza((int) r10, (double) r11)
        L_0x0a25:
            int r1 = r1 + 3
            goto L_0x0551
        L_0x0a29:
            if (r8 == 0) goto L_0x0a40
            com.google.android.gms.internal.firebase-perf.zzef<?> r1 = r13.zztc
            r1.zza(r15, r8)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0a3e
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            r8 = r1
            goto L_0x0a29
        L_0x0a3e:
            r8 = r3
            goto L_0x0a29
        L_0x0a40:
            com.google.android.gms.internal.firebase-perf.zzhf<?, ?> r0 = r13.zzta
            zza(r0, r14, (com.google.android.gms.internal.p000firebaseperf.zzhz) r15)
            return
        L_0x0a46:
            r13.zzb(r14, (com.google.android.gms.internal.p000firebaseperf.zzhz) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p000firebaseperf.zzge.zza(java.lang.Object, com.google.android.gms.internal.firebase-perf.zzhz):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:172:0x04b5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r19, com.google.android.gms.internal.p000firebaseperf.zzhz r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r0.zztb
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.firebase-perf.zzef<?> r3 = r0.zztc
            com.google.android.gms.internal.firebase-perf.zzek r3 = r3.zzc(r1)
            com.google.android.gms.internal.firebase-perf.zzgs<FieldDescriptorType, java.lang.Object> r5 = r3.zznt
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0023
            java.util.Iterator r3 = r3.iterator()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0025
        L_0x0023:
            r3 = 0
            r5 = 0
        L_0x0025:
            r6 = -1
            int[] r7 = r0.zztf
            int r7 = r7.length
            sun.misc.Unsafe r8 = zzte
            r10 = r5
            r5 = 0
            r11 = 0
        L_0x002e:
            if (r5 >= r7) goto L_0x04af
            int r12 = r0.zzar(r5)
            int[] r13 = r0.zztf
            r14 = r13[r5]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r12
            int r15 = r15 >>> 20
            boolean r4 = r0.zztk
            r16 = 1048575(0xfffff, float:1.469367E-39)
            if (r4 != 0) goto L_0x0064
            r4 = 17
            if (r15 > r4) goto L_0x0064
            int r4 = r5 + 2
            r4 = r13[r4]
            r13 = r4 & r16
            if (r13 == r6) goto L_0x0058
            r17 = r10
            long r9 = (long) r13
            int r11 = r8.getInt(r1, r9)
            goto L_0x005b
        L_0x0058:
            r17 = r10
            r13 = r6
        L_0x005b:
            int r4 = r4 >>> 20
            r6 = 1
            int r9 = r6 << r4
            r6 = r13
            r10 = r17
            goto L_0x0069
        L_0x0064:
            r17 = r10
            r10 = r17
            r9 = 0
        L_0x0069:
            if (r10 == 0) goto L_0x0088
            com.google.android.gms.internal.firebase-perf.zzef<?> r4 = r0.zztc
            int r4 = r4.zzb(r10)
            if (r4 > r14) goto L_0x0088
            com.google.android.gms.internal.firebase-perf.zzef<?> r4 = r0.zztc
            r4.zza(r2, r10)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r10 = r4
            goto L_0x0069
        L_0x0086:
            r10 = 0
            goto L_0x0069
        L_0x0088:
            r4 = r12 & r16
            long r12 = (long) r4
            switch(r15) {
                case 0: goto L_0x049f;
                case 1: goto L_0x0492;
                case 2: goto L_0x0485;
                case 3: goto L_0x0478;
                case 4: goto L_0x046b;
                case 5: goto L_0x045e;
                case 6: goto L_0x0451;
                case 7: goto L_0x0444;
                case 8: goto L_0x0436;
                case 9: goto L_0x0424;
                case 10: goto L_0x0414;
                case 11: goto L_0x0406;
                case 12: goto L_0x03f8;
                case 13: goto L_0x03ea;
                case 14: goto L_0x03dc;
                case 15: goto L_0x03ce;
                case 16: goto L_0x03c0;
                case 17: goto L_0x03ae;
                case 18: goto L_0x039e;
                case 19: goto L_0x038e;
                case 20: goto L_0x037e;
                case 21: goto L_0x036e;
                case 22: goto L_0x035e;
                case 23: goto L_0x034e;
                case 24: goto L_0x033e;
                case 25: goto L_0x032e;
                case 26: goto L_0x031f;
                case 27: goto L_0x030c;
                case 28: goto L_0x02fd;
                case 29: goto L_0x02ed;
                case 30: goto L_0x02dd;
                case 31: goto L_0x02cd;
                case 32: goto L_0x02bd;
                case 33: goto L_0x02ad;
                case 34: goto L_0x029d;
                case 35: goto L_0x028d;
                case 36: goto L_0x027d;
                case 37: goto L_0x026d;
                case 38: goto L_0x025d;
                case 39: goto L_0x024d;
                case 40: goto L_0x023d;
                case 41: goto L_0x022d;
                case 42: goto L_0x021d;
                case 43: goto L_0x020d;
                case 44: goto L_0x01fd;
                case 45: goto L_0x01ed;
                case 46: goto L_0x01dd;
                case 47: goto L_0x01cd;
                case 48: goto L_0x01bd;
                case 49: goto L_0x01aa;
                case 50: goto L_0x01a1;
                case 51: goto L_0x0192;
                case 52: goto L_0x0183;
                case 53: goto L_0x0174;
                case 54: goto L_0x0165;
                case 55: goto L_0x0156;
                case 56: goto L_0x0147;
                case 57: goto L_0x0138;
                case 58: goto L_0x0129;
                case 59: goto L_0x011a;
                case 60: goto L_0x0107;
                case 61: goto L_0x00f7;
                case 62: goto L_0x00e9;
                case 63: goto L_0x00db;
                case 64: goto L_0x00cd;
                case 65: goto L_0x00bf;
                case 66: goto L_0x00b1;
                case 67: goto L_0x00a3;
                case 68: goto L_0x0091;
                default: goto L_0x008e;
            }
        L_0x008e:
            r15 = 0
            goto L_0x04ab
        L_0x0091:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.firebase-perf.zzgn r9 = r0.zzap(r5)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.p000firebaseperf.zzgn) r9)
            goto L_0x008e
        L_0x00a3:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r12 = zzh(r1, r12)
            r2.zzb((int) r14, (long) r12)
            goto L_0x008e
        L_0x00b1:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzg(r1, r12)
            r2.zzi((int) r14, (int) r4)
            goto L_0x008e
        L_0x00bf:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r12 = zzh(r1, r12)
            r2.zzj((int) r14, (long) r12)
            goto L_0x008e
        L_0x00cd:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzg(r1, r12)
            r2.zzq(r14, r4)
            goto L_0x008e
        L_0x00db:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzg(r1, r12)
            r2.zzr(r14, r4)
            goto L_0x008e
        L_0x00e9:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzg(r1, r12)
            r2.zzh(r14, r4)
            goto L_0x008e
        L_0x00f7:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.firebase-perf.zzdl r4 = (com.google.android.gms.internal.p000firebaseperf.zzdl) r4
            r2.zza((int) r14, (com.google.android.gms.internal.p000firebaseperf.zzdl) r4)
            goto L_0x008e
        L_0x0107:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.firebase-perf.zzgn r9 = r0.zzap(r5)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.p000firebaseperf.zzgn) r9)
            goto L_0x008e
        L_0x011a:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r8.getObject(r1, r12)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.p000firebaseperf.zzhz) r2)
            goto L_0x008e
        L_0x0129:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            boolean r4 = zzi(r1, r12)
            r2.zza((int) r14, (boolean) r4)
            goto L_0x008e
        L_0x0138:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzg(r1, r12)
            r2.zzj((int) r14, (int) r4)
            goto L_0x008e
        L_0x0147:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r12 = zzh(r1, r12)
            r2.zzc(r14, r12)
            goto L_0x008e
        L_0x0156:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzg(r1, r12)
            r2.zzg(r14, r4)
            goto L_0x008e
        L_0x0165:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r12 = zzh(r1, r12)
            r2.zza((int) r14, (long) r12)
            goto L_0x008e
        L_0x0174:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r12 = zzh(r1, r12)
            r2.zzi((int) r14, (long) r12)
            goto L_0x008e
        L_0x0183:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            float r4 = zzf(r1, r12)
            r2.zza((int) r14, (float) r4)
            goto L_0x008e
        L_0x0192:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            double r12 = zze(r1, (long) r12)
            r2.zza((int) r14, (double) r12)
            goto L_0x008e
        L_0x01a1:
            java.lang.Object r4 = r8.getObject(r1, r12)
            r0.zza((com.google.android.gms.internal.p000firebaseperf.zzhz) r2, (int) r14, (java.lang.Object) r4, (int) r5)
            goto L_0x008e
        L_0x01aa:
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzgn r12 = r0.zzap(r5)
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzb((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.p000firebaseperf.zzhz) r2, (com.google.android.gms.internal.p000firebaseperf.zzgn) r12)
            goto L_0x008e
        L_0x01bd:
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r14 = 1
            com.google.android.gms.internal.p000firebaseperf.zzgp.zze(r4, r9, r2, r14)
            goto L_0x008e
        L_0x01cd:
            r14 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzj(r4, r9, r2, r14)
            goto L_0x008e
        L_0x01dd:
            r14 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzg(r4, r9, r2, r14)
            goto L_0x008e
        L_0x01ed:
            r14 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzl(r4, r9, r2, r14)
            goto L_0x008e
        L_0x01fd:
            r14 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzm(r4, r9, r2, r14)
            goto L_0x008e
        L_0x020d:
            r14 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzi(r4, r9, r2, r14)
            goto L_0x008e
        L_0x021d:
            r14 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzn(r4, r9, r2, r14)
            goto L_0x008e
        L_0x022d:
            r14 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzk(r4, r9, r2, r14)
            goto L_0x008e
        L_0x023d:
            r14 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzf(r4, r9, r2, r14)
            goto L_0x008e
        L_0x024d:
            r14 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzh(r4, r9, r2, r14)
            goto L_0x008e
        L_0x025d:
            r14 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzd(r4, r9, r2, r14)
            goto L_0x008e
        L_0x026d:
            r14 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzc(r4, r9, r2, r14)
            goto L_0x008e
        L_0x027d:
            r14 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.p000firebaseperf.zzhz) r2, (boolean) r14)
            goto L_0x008e
        L_0x028d:
            r14 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.p000firebaseperf.zzhz) r2, (boolean) r14)
            goto L_0x008e
        L_0x029d:
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r14 = 0
            com.google.android.gms.internal.p000firebaseperf.zzgp.zze(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02ad:
            r14 = 0
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzj(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02bd:
            r14 = 0
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzg(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02cd:
            r14 = 0
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzl(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02dd:
            r14 = 0
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzm(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02ed:
            r14 = 0
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzi(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02fd:
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzb(r4, r9, r2)
            goto L_0x008e
        L_0x030c:
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzgn r12 = r0.zzap(r5)
            com.google.android.gms.internal.p000firebaseperf.zzgp.zza((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.p000firebaseperf.zzhz) r2, (com.google.android.gms.internal.p000firebaseperf.zzgn) r12)
            goto L_0x008e
        L_0x031f:
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zza((int) r4, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.p000firebaseperf.zzhz) r2)
            goto L_0x008e
        L_0x032e:
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r15 = 0
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzn(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x033e:
            r15 = 0
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzk(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x034e:
            r15 = 0
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzf(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x035e:
            r15 = 0
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzh(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x036e:
            r15 = 0
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzd(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x037e:
            r15 = 0
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzc(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x038e:
            r15 = 0
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.p000firebaseperf.zzhz) r2, (boolean) r15)
            goto L_0x04ab
        L_0x039e:
            r15 = 0
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p000firebaseperf.zzgp.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.p000firebaseperf.zzhz) r2, (boolean) r15)
            goto L_0x04ab
        L_0x03ae:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.firebase-perf.zzgn r9 = r0.zzap(r5)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.p000firebaseperf.zzgn) r9)
            goto L_0x04ab
        L_0x03c0:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            long r12 = r8.getLong(r1, r12)
            r2.zzb((int) r14, (long) r12)
            goto L_0x04ab
        L_0x03ce:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r8.getInt(r1, r12)
            r2.zzi((int) r14, (int) r4)
            goto L_0x04ab
        L_0x03dc:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            long r12 = r8.getLong(r1, r12)
            r2.zzj((int) r14, (long) r12)
            goto L_0x04ab
        L_0x03ea:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r8.getInt(r1, r12)
            r2.zzq(r14, r4)
            goto L_0x04ab
        L_0x03f8:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r8.getInt(r1, r12)
            r2.zzr(r14, r4)
            goto L_0x04ab
        L_0x0406:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r8.getInt(r1, r12)
            r2.zzh(r14, r4)
            goto L_0x04ab
        L_0x0414:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.firebase-perf.zzdl r4 = (com.google.android.gms.internal.p000firebaseperf.zzdl) r4
            r2.zza((int) r14, (com.google.android.gms.internal.p000firebaseperf.zzdl) r4)
            goto L_0x04ab
        L_0x0424:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.firebase-perf.zzgn r9 = r0.zzap(r5)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.p000firebaseperf.zzgn) r9)
            goto L_0x04ab
        L_0x0436:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r8.getObject(r1, r12)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.p000firebaseperf.zzhz) r2)
            goto L_0x04ab
        L_0x0444:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            boolean r4 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzl(r1, r12)
            r2.zza((int) r14, (boolean) r4)
            goto L_0x04ab
        L_0x0451:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r8.getInt(r1, r12)
            r2.zzj((int) r14, (int) r4)
            goto L_0x04ab
        L_0x045e:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            long r12 = r8.getLong(r1, r12)
            r2.zzc(r14, r12)
            goto L_0x04ab
        L_0x046b:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r8.getInt(r1, r12)
            r2.zzg(r14, r4)
            goto L_0x04ab
        L_0x0478:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            long r12 = r8.getLong(r1, r12)
            r2.zza((int) r14, (long) r12)
            goto L_0x04ab
        L_0x0485:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            long r12 = r8.getLong(r1, r12)
            r2.zzi((int) r14, (long) r12)
            goto L_0x04ab
        L_0x0492:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            float r4 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzm(r1, r12)
            r2.zza((int) r14, (float) r4)
            goto L_0x04ab
        L_0x049f:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            double r12 = com.google.android.gms.internal.p000firebaseperf.zzhl.zzn(r1, r12)
            r2.zza((int) r14, (double) r12)
        L_0x04ab:
            int r5 = r5 + 3
            goto L_0x002e
        L_0x04af:
            r17 = r10
            r4 = r17
        L_0x04b3:
            if (r4 == 0) goto L_0x04c9
            com.google.android.gms.internal.firebase-perf.zzef<?> r5 = r0.zztc
            r5.zza(r2, r4)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04c7
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            goto L_0x04b3
        L_0x04c7:
            r4 = 0
            goto L_0x04b3
        L_0x04c9:
            com.google.android.gms.internal.firebase-perf.zzhf<?, ?> r3 = r0.zzta
            zza(r3, r1, (com.google.android.gms.internal.p000firebaseperf.zzhz) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p000firebaseperf.zzge.zzb(java.lang.Object, com.google.android.gms.internal.firebase-perf.zzhz):void");
    }

    private final <K, V> void zza(zzhz zzhz, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzhz.zza(i, this.zztr.zzj(zzaq(i2)), this.zztr.zzh(obj));
        }
    }

    private static <UT, UB> void zza(zzhf<UT, UB> zzhf, T t, zzhz zzhz) throws IOException {
        zzhf.zza(zzhf.zzo(t), zzhz);
    }

    private final zzgn zzap(int i) {
        int i2 = (i / 3) << 1;
        zzgn zzgn = (zzgn) this.zztg[i2];
        if (zzgn != null) {
            return zzgn;
        }
        zzgn zze = zzgm.zzir().zze((Class) this.zztg[i2 + 1]);
        this.zztg[i2] = zze;
        return zze;
    }

    private final Object zzaq(int i) {
        return this.zztg[(i / 3) << 1];
    }

    public final void zze(T t) {
        int i;
        int i2 = this.zztn;
        while (true) {
            i = this.zzto;
            if (i2 >= i) {
                break;
            }
            long zzar = (long) (zzar(this.zztm[i2]) & 1048575);
            Object zzo = zzhl.zzo(t, zzar);
            if (zzo != null) {
                zzhl.zza((Object) t, zzar, this.zztr.zzi(zzo));
            }
            i2++;
        }
        int length = this.zztm.length;
        while (i < length) {
            this.zztq.zza(t, (long) this.zztm[i]);
            i++;
        }
        this.zzta.zze(t);
        if (this.zztb) {
            this.zztc.zze((Object) t);
        }
    }

    public final boolean zzl(T t) {
        int i;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= this.zztn) {
                return !this.zztb || this.zztc.zzc(t).isInitialized();
            }
            int i5 = this.zztm[i2];
            int i6 = this.zztf[i5];
            int zzar = zzar(i5);
            if (!this.zztk) {
                int i7 = this.zztf[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i3) {
                    i4 = zzte.getInt(t, (long) i8);
                    i3 = i8;
                }
            } else {
                i = 0;
            }
            if (((268435456 & zzar) != 0) && !zza(t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & zzar) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (zza(t, i6, i5) && !zza((Object) t, zzar, zzap(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzh = this.zztr.zzh(zzhl.zzo(t, (long) (zzar & 1048575)));
                            if (!zzh.isEmpty()) {
                                if (this.zztr.zzj(zzaq(i5)).zzss.zzjp() == zzia.MESSAGE) {
                                    zzgn<?> zzgn = null;
                                    Iterator<?> it = zzh.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzgn == null) {
                                            zzgn = zzgm.zzir().zze(next.getClass());
                                        }
                                        if (!zzgn.zzl(next)) {
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
                List list = (List) zzhl.zzo(t, (long) (zzar & 1048575));
                if (!list.isEmpty()) {
                    zzgn zzap = zzap(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!zzap.zzl(list.get(i10))) {
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
            } else if (zza(t, i5, i4, i) && !zza((Object) t, zzar, zzap(i5))) {
                return false;
            }
            i2++;
        }
    }

    private static boolean zza(Object obj, int i, zzgn zzgn) {
        return zzgn.zzl(zzhl.zzo(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzhz zzhz) throws IOException {
        if (obj instanceof String) {
            zzhz.zzb(i, (String) obj);
        } else {
            zzhz.zza(i, (zzdl) obj);
        }
    }

    private final int zzar(int i) {
        return this.zztf[i + 1];
    }

    private final int zzas(int i) {
        return this.zztf[i + 2];
    }

    private static <T> double zze(T t, long j) {
        return ((Double) zzhl.zzo(t, j)).doubleValue();
    }

    private static <T> float zzf(T t, long j) {
        return ((Float) zzhl.zzo(t, j)).floatValue();
    }

    private static <T> int zzg(T t, long j) {
        return ((Integer) zzhl.zzo(t, j)).intValue();
    }

    private static <T> long zzh(T t, long j) {
        return ((Long) zzhl.zzo(t, j)).longValue();
    }

    private static <T> boolean zzi(T t, long j) {
        return ((Boolean) zzhl.zzo(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zztk) {
            return zza(t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zza(T t, int i) {
        if (this.zztk) {
            int zzar = zzar(i);
            long j = (long) (zzar & 1048575);
            switch ((zzar & 267386880) >>> 20) {
                case 0:
                    return zzhl.zzn(t, j) != 0.0d;
                case 1:
                    return zzhl.zzm(t, j) != BitmapDescriptorFactory.HUE_RED;
                case 2:
                    return zzhl.zzk(t, j) != 0;
                case 3:
                    return zzhl.zzk(t, j) != 0;
                case 4:
                    return zzhl.zzj(t, j) != 0;
                case 5:
                    return zzhl.zzk(t, j) != 0;
                case 6:
                    return zzhl.zzj(t, j) != 0;
                case 7:
                    return zzhl.zzl(t, j);
                case 8:
                    Object zzo = zzhl.zzo(t, j);
                    if (zzo instanceof String) {
                        return !((String) zzo).isEmpty();
                    }
                    if (zzo instanceof zzdl) {
                        return !zzdl.zzmt.equals(zzo);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzhl.zzo(t, j) != null;
                case 10:
                    return !zzdl.zzmt.equals(zzhl.zzo(t, j));
                case 11:
                    return zzhl.zzj(t, j) != 0;
                case 12:
                    return zzhl.zzj(t, j) != 0;
                case 13:
                    return zzhl.zzj(t, j) != 0;
                case 14:
                    return zzhl.zzk(t, j) != 0;
                case 15:
                    return zzhl.zzj(t, j) != 0;
                case 16:
                    return zzhl.zzk(t, j) != 0;
                case 17:
                    return zzhl.zzo(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzas = zzas(i);
            return (zzhl.zzj(t, (long) (zzas & 1048575)) & (1 << (zzas >>> 20))) != 0;
        }
    }

    private final void zzb(T t, int i) {
        if (!this.zztk) {
            int zzas = zzas(i);
            long j = (long) (zzas & 1048575);
            zzhl.zza((Object) t, j, zzhl.zzj(t, j) | (1 << (zzas >>> 20)));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzhl.zzj(t, (long) (zzas(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzhl.zza((Object) t, (long) (zzas(i2) & 1048575), i);
    }
}
