package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzbc;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;
import tencent.tls.platform.SigType;

final class zzco<T> implements zzda<T> {
    private static final int[] zzkq = new int[0];
    private static final Unsafe zzkr = zzdy.zzdn();
    private final int[] zzks;
    private final Object[] zzkt;
    private final int zzku;
    private final int zzkv;
    private final zzck zzkw;
    private final boolean zzkx;
    private final boolean zzky;
    private final boolean zzkz;
    private final boolean zzla;
    private final int[] zzlb;
    private final int zzlc;
    private final int zzld;
    private final zzcs zzle;
    private final zzbu zzlf;
    private final zzds<?, ?> zzlg;
    private final zzar<?> zzlh;
    private final zzcd zzli;

    private zzco(int[] iArr, Object[] objArr, int i, int i2, zzck zzck, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzcs zzcs, zzbu zzbu, zzds<?, ?> zzds, zzar<?> zzar, zzcd zzcd) {
        this.zzks = iArr;
        this.zzkt = objArr;
        this.zzku = i;
        this.zzkv = i2;
        this.zzky = zzck instanceof zzbc;
        this.zzkz = z;
        this.zzkx = zzar != null && zzar.zzf(zzck);
        this.zzla = false;
        this.zzlb = iArr2;
        this.zzlc = i3;
        this.zzld = i4;
        this.zzle = zzcs;
        this.zzlf = zzbu;
        this.zzlg = zzds;
        this.zzlh = zzar;
        this.zzkw = zzck;
        this.zzli = zzcd;
    }

    static <T> zzco<T> zzb(Class<T> cls, zzci zzci, zzcs zzcs, zzbu zzbu, zzds<?, ?> zzds, zzar<?> zzar, zzcd zzcd) {
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
        zzci zzci2 = zzci;
        if (zzci2 instanceof zzcx) {
            zzcx zzcx = (zzcx) zzci2;
            char c10 = 0;
            boolean z = zzcx.zzcj() == zzbc.zze.zziu;
            String zzcr = zzcx.zzcr();
            int length = zzcr.length();
            char charAt15 = zzcr.charAt(0);
            if (charAt15 >= 55296) {
                char c11 = charAt15 & 8191;
                int i27 = 1;
                int i28 = 13;
                while (true) {
                    i = i27 + 1;
                    charAt14 = zzcr.charAt(i27);
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
            char charAt16 = zzcr.charAt(i);
            if (charAt16 >= 55296) {
                char c12 = charAt16 & 8191;
                int i30 = 13;
                while (true) {
                    i2 = i29 + 1;
                    charAt13 = zzcr.charAt(i29);
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
                iArr = zzkq;
                c6 = 0;
                c5 = 0;
                i3 = 0;
                c4 = 0;
                c3 = 0;
                c2 = 0;
            } else {
                int i31 = i2 + 1;
                char charAt17 = zzcr.charAt(i2);
                if (charAt17 >= 55296) {
                    char c13 = charAt17 & 8191;
                    int i32 = 13;
                    while (true) {
                        i18 = i31 + 1;
                        charAt12 = zzcr.charAt(i31);
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
                char charAt18 = zzcr.charAt(i18);
                if (charAt18 >= 55296) {
                    char c14 = charAt18 & 8191;
                    int i34 = 13;
                    while (true) {
                        i19 = i33 + 1;
                        charAt11 = zzcr.charAt(i33);
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
                char charAt19 = zzcr.charAt(i19);
                if (charAt19 >= 55296) {
                    char c15 = charAt19 & 8191;
                    int i36 = 13;
                    while (true) {
                        i20 = i35 + 1;
                        charAt10 = zzcr.charAt(i35);
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
                c4 = zzcr.charAt(i20);
                if (c4 >= 55296) {
                    char c16 = c4 & 8191;
                    int i38 = 13;
                    while (true) {
                        i21 = i37 + 1;
                        charAt9 = zzcr.charAt(i37);
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
                c3 = zzcr.charAt(i21);
                if (c3 >= 55296) {
                    char c17 = c3 & 8191;
                    int i40 = 13;
                    while (true) {
                        i26 = i39 + 1;
                        charAt8 = zzcr.charAt(i39);
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
                c6 = zzcr.charAt(i39);
                if (c6 >= 55296) {
                    char c18 = c6 & 8191;
                    int i42 = 13;
                    while (true) {
                        i25 = i41 + 1;
                        charAt7 = zzcr.charAt(i41);
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
                char charAt20 = zzcr.charAt(i41);
                if (charAt20 >= 55296) {
                    int i44 = 13;
                    int i45 = i43;
                    char c19 = charAt20 & 8191;
                    int i46 = i45;
                    while (true) {
                        i24 = i46 + 1;
                        charAt6 = zzcr.charAt(i46);
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
                c10 = zzcr.charAt(i22);
                if (c10 >= 55296) {
                    int i48 = 13;
                    int i49 = i47;
                    char c20 = c10 & 8191;
                    int i50 = i49;
                    while (true) {
                        i23 = i50 + 1;
                        charAt5 = zzcr.charAt(i50);
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
            Unsafe unsafe = zzkr;
            Object[] zzcs2 = zzcx.zzcs();
            Class<?> cls3 = zzcx.zzcl().getClass();
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
                char charAt21 = zzcr.charAt(i2);
                char c22 = 55296;
                if (charAt21 >= 55296) {
                    int i58 = 13;
                    int i59 = i57;
                    char c23 = charAt21 & 8191;
                    int i60 = i59;
                    while (true) {
                        i17 = i60 + 1;
                        charAt4 = zzcr.charAt(i60);
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
                char charAt22 = zzcr.charAt(i4);
                int i62 = length;
                char c24 = 55296;
                if (charAt22 >= 55296) {
                    int i63 = 13;
                    int i64 = i61;
                    char c25 = charAt22 & 8191;
                    int i65 = i64;
                    while (true) {
                        i16 = i65 + 1;
                        charAt3 = zzcr.charAt(i65);
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
                    char charAt23 = zzcr.charAt(i5);
                    char c28 = 55296;
                    if (charAt23 >= 55296) {
                        char c29 = charAt23 & 8191;
                        int i68 = 13;
                        while (true) {
                            i15 = i67 + 1;
                            charAt2 = zzcr.charAt(i67);
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
                        objArr[((i56 / 3) << 1) + 1] = zzcs2[i52];
                        i52++;
                    } else {
                        if (i69 == 12 && (charAt15 & 1) == 1) {
                            objArr[((i56 / 3) << 1) + 1] = zzcs2[i52];
                            i52++;
                        }
                        c9 = 1;
                    }
                    int i71 = charAt23 << c9;
                    Object obj = zzcs2[i71];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zzb(cls3, (String) obj);
                        zzcs2[i71] = field2;
                    }
                    char c30 = c5;
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i72 = i71 + 1;
                    Object obj2 = zzcs2[i72];
                    int i73 = objectFieldOffset;
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zzb(cls3, (String) obj2);
                        zzcs2[i72] = field3;
                    }
                    str = zzcr;
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
                    Field zzb = zzb(cls3, (String) zzcs2[i52]);
                    c8 = c4;
                    if (c27 == 9 || c27 == 17) {
                        c7 = c31;
                        objArr[((i56 / 3) << 1) + 1] = zzb.getType();
                    } else {
                        if (c27 == 27 || c27 == '1') {
                            c7 = c31;
                            i14 = i74 + 1;
                            objArr[((i56 / 3) << 1) + 1] = zzcs2[i74];
                        } else if (c27 == 12 || c27 == 30 || c27 == ',') {
                            c7 = c31;
                            if ((charAt15 & 1) == 1) {
                                i14 = i74 + 1;
                                objArr[((i56 / 3) << 1) + 1] = zzcs2[i74];
                            }
                        } else if (c27 == '2') {
                            int i75 = c21 + 1;
                            iArr[c21] = i56;
                            int i76 = (i56 / 3) << 1;
                            int i77 = i74 + 1;
                            objArr[i76] = zzcs2[i74];
                            if ((charAt22 & 2048) != 0) {
                                i74 = i77 + 1;
                                objArr[i76 + 1] = zzcs2[i77];
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
                        i8 = (int) unsafe.objectFieldOffset(zzb);
                        if ((charAt15 & 1) == 1 || c27 > 17) {
                            str = zzcr;
                            cls2 = cls3;
                            i6 = i74;
                            i11 = i5;
                            i10 = 0;
                            i9 = 0;
                        } else {
                            i11 = i5 + 1;
                            char charAt24 = zzcr.charAt(i5);
                            if (charAt24 >= 55296) {
                                char c32 = charAt24 & 8191;
                                int i78 = 13;
                                while (true) {
                                    i13 = i11 + 1;
                                    charAt = zzcr.charAt(i11);
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
                            Object obj3 = zzcs2[i79];
                            str = zzcr;
                            if (obj3 instanceof Field) {
                                field = (Field) obj3;
                            } else {
                                field = zzb(cls3, (String) obj3);
                                zzcs2[i79] = field;
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
                    i8 = (int) unsafe.objectFieldOffset(zzb);
                    if ((charAt15 & 1) == 1) {
                    }
                    str = zzcr;
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
                zzcr = str;
            }
            boolean z3 = z;
            return new zzco(iArr2, objArr, c5, c4, zzcx.zzcl(), z, false, iArr, c10, i53, zzcs, zzbu, zzds, zzar, zzcd);
        }
        int zzcj = ((zzdl) zzci2).zzcj();
        int i82 = zzbc.zze.zziu;
        throw new NoSuchMethodError();
    }

    private static Field zzb(Class<?> cls, String str) {
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

    public final T newInstance() {
        return this.zzle.newInstance(this.zzkw);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.places.zzdc.zze(com.google.android.gms.internal.places.zzdy.zzp(r10, r6), com.google.android.gms.internal.places.zzdy.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzl(r10, r6) == com.google.android.gms.internal.places.zzdy.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzk(r10, r6) == com.google.android.gms.internal.places.zzdy.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzl(r10, r6) == com.google.android.gms.internal.places.zzdy.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzk(r10, r6) == com.google.android.gms.internal.places.zzdy.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzk(r10, r6) == com.google.android.gms.internal.places.zzdy.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzk(r10, r6) == com.google.android.gms.internal.places.zzdy.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.places.zzdc.zze(com.google.android.gms.internal.places.zzdy.zzp(r10, r6), com.google.android.gms.internal.places.zzdy.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.places.zzdc.zze(com.google.android.gms.internal.places.zzdy.zzp(r10, r6), com.google.android.gms.internal.places.zzdy.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.places.zzdc.zze(com.google.android.gms.internal.places.zzdy.zzp(r10, r6), com.google.android.gms.internal.places.zzdy.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzm(r10, r6) == com.google.android.gms.internal.places.zzdy.zzm(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzk(r10, r6) == com.google.android.gms.internal.places.zzdy.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzl(r10, r6) == com.google.android.gms.internal.places.zzdy.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzk(r10, r6) == com.google.android.gms.internal.places.zzdy.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzl(r10, r6) == com.google.android.gms.internal.places.zzdy.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzl(r10, r6) == com.google.android.gms.internal.places.zzdy.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.places.zzdy.zzn(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.places.zzdy.zzn(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.places.zzdy.zzo(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.places.zzdy.zzo(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c1, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.places.zzdc.zze(com.google.android.gms.internal.places.zzdy.zzp(r10, r6), com.google.android.gms.internal.places.zzdy.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzks
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.zzai(r2)
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
            int r4 = r9.zzaj(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.places.zzdy.zzk(r10, r4)
            int r4 = com.google.android.gms.internal.places.zzdy.zzk(r11, r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.places.zzdy.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.places.zzdc.zze((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdy.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.places.zzdy.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.places.zzdc.zze((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdy.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.places.zzdy.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.places.zzdc.zze((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.places.zzdy.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.places.zzdc.zze((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.places.zzdy.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.places.zzdy.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.places.zzdy.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.places.zzdy.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.places.zzdy.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.places.zzdy.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.places.zzdy.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.places.zzdy.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.places.zzdy.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.places.zzdy.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.places.zzdy.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.places.zzdy.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.places.zzdy.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.places.zzdc.zze((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.places.zzdy.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.places.zzdc.zze((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.places.zzdy.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.places.zzdc.zze((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.places.zzdy.zzm(r10, r6)
            boolean r5 = com.google.android.gms.internal.places.zzdy.zzm(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.places.zzdy.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.places.zzdy.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.places.zzdy.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.places.zzdy.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.places.zzdy.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.places.zzdy.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.places.zzdy.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.places.zzdy.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.places.zzdy.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.places.zzdy.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.places.zzdy.zzn(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.places.zzdy.zzn(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.places.zzdy.zzo(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.places.zzdy.zzo(r11, r6)
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
            com.google.android.gms.internal.places.zzds<?, ?> r0 = r9.zzlg
            java.lang.Object r0 = r0.zzr(r10)
            com.google.android.gms.internal.places.zzds<?, ?> r2 = r9.zzlg
            java.lang.Object r2 = r2.zzr(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.zzkx
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.places.zzar<?> r0 = r9.zzlh
            com.google.android.gms.internal.places.zzav r10 = r0.zzb((java.lang.Object) r10)
            com.google.android.gms.internal.places.zzar<?> r0 = r9.zzlh
            com.google.android.gms.internal.places.zzav r11 = r0.zzb((java.lang.Object) r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.equals(java.lang.Object, java.lang.Object):boolean");
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
            int[] r0 = r8.zzks
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x022c
            int r3 = r8.zzai(r1)
            int[] r4 = r8.zzks
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
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdy.zzp(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x0032:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.places.zzbd.zzl(r3)
            goto L_0x0227
        L_0x0044:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x0052:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.places.zzbd.zzl(r3)
            goto L_0x0227
        L_0x0064:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x0072:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x0080:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x008e:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdy.zzp(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00a0:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdy.zzp(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00b2:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdy.zzp(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00c6:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            boolean r3 = zzj(r9, r5)
            int r3 = com.google.android.gms.internal.places.zzbd.zze((boolean) r3)
            goto L_0x0227
        L_0x00d8:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x00e6:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.places.zzbd.zzl(r3)
            goto L_0x0227
        L_0x00f8:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x0106:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.places.zzbd.zzl(r3)
            goto L_0x0227
        L_0x0118:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.places.zzbd.zzl(r3)
            goto L_0x0227
        L_0x012a:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            float r3 = zzg(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x013c:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            double r3 = zzf(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.places.zzbd.zzl(r3)
            goto L_0x0227
        L_0x0152:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdy.zzp(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x015e:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdy.zzp(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x016a:
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdy.zzp(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
            goto L_0x01c3
        L_0x0175:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.places.zzdy.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.places.zzbd.zzl(r3)
            goto L_0x0227
        L_0x0181:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.places.zzdy.zzk(r9, r5)
            goto L_0x0227
        L_0x0189:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.places.zzdy.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.places.zzbd.zzl(r3)
            goto L_0x0227
        L_0x0195:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.places.zzdy.zzk(r9, r5)
            goto L_0x0227
        L_0x019d:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.places.zzdy.zzk(r9, r5)
            goto L_0x0227
        L_0x01a5:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.places.zzdy.zzk(r9, r5)
            goto L_0x0227
        L_0x01ad:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdy.zzp(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01b9:
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdy.zzp(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
        L_0x01c3:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0228
        L_0x01c7:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdy.zzp(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01d4:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.places.zzdy.zzm(r9, r5)
            int r3 = com.google.android.gms.internal.places.zzbd.zze((boolean) r3)
            goto L_0x0227
        L_0x01df:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.places.zzdy.zzk(r9, r5)
            goto L_0x0227
        L_0x01e6:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.places.zzdy.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.places.zzbd.zzl(r3)
            goto L_0x0227
        L_0x01f1:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.places.zzdy.zzk(r9, r5)
            goto L_0x0227
        L_0x01f8:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.places.zzdy.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.places.zzbd.zzl(r3)
            goto L_0x0227
        L_0x0203:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.places.zzdy.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.places.zzbd.zzl(r3)
            goto L_0x0227
        L_0x020e:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.places.zzdy.zzn(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x0219:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.places.zzdy.zzo(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.places.zzbd.zzl(r3)
        L_0x0227:
            int r2 = r2 + r3
        L_0x0228:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022c:
            int r2 = r2 * 53
            com.google.android.gms.internal.places.zzds<?, ?> r0 = r8.zzlg
            java.lang.Object r0 = r0.zzr(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzkx
            if (r0 == 0) goto L_0x024a
            int r2 = r2 * 53
            com.google.android.gms.internal.places.zzar<?> r0 = r8.zzlh
            com.google.android.gms.internal.places.zzav r9 = r0.zzb((java.lang.Object) r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x024a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.hashCode(java.lang.Object):int");
    }

    public final void zzd(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzks.length; i += 3) {
                int zzai = zzai(i);
                long j = (long) (1048575 & zzai);
                int i2 = this.zzks[i];
                switch ((zzai & 267386880) >>> 20) {
                    case 0:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzdy.zzb((Object) t, j, zzdy.zzo(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 1:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzdy.zzb((Object) t, j, zzdy.zzn(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 2:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzdy.zzb((Object) t, j, zzdy.zzl(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 3:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzdy.zzb((Object) t, j, zzdy.zzl(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 4:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzdy.zzb((Object) t, j, zzdy.zzk(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 5:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzdy.zzb((Object) t, j, zzdy.zzl(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 6:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzdy.zzb((Object) t, j, zzdy.zzk(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 7:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzdy.zzb((Object) t, j, zzdy.zzm(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 8:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzdy.zzb((Object) t, j, zzdy.zzp(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 9:
                        zzb(t, t2, i);
                        break;
                    case 10:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzdy.zzb((Object) t, j, zzdy.zzp(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 11:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzdy.zzb((Object) t, j, zzdy.zzk(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 12:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzdy.zzb((Object) t, j, zzdy.zzk(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 13:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzdy.zzb((Object) t, j, zzdy.zzk(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 14:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzdy.zzb((Object) t, j, zzdy.zzl(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 15:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzdy.zzb((Object) t, j, zzdy.zzk(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 16:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzdy.zzb((Object) t, j, zzdy.zzl(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 17:
                        zzb(t, t2, i);
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
                        this.zzlf.zzb(t, t2, j);
                        break;
                    case 50:
                        zzdc.zzb(this.zzli, t, t2, j);
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
                        if (!zzb(t2, i2, i)) {
                            break;
                        } else {
                            zzdy.zzb((Object) t, j, zzdy.zzp(t2, j));
                            zzc(t, i2, i);
                            break;
                        }
                    case 60:
                        zzc(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zzb(t2, i2, i)) {
                            break;
                        } else {
                            zzdy.zzb((Object) t, j, zzdy.zzp(t2, j));
                            zzc(t, i2, i);
                            break;
                        }
                    case 68:
                        zzc(t, t2, i);
                        break;
                }
            }
            if (!this.zzkz) {
                zzdc.zzb(this.zzlg, t, t2);
                if (this.zzkx) {
                    zzdc.zzb(this.zzlh, t, t2);
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    private final void zzb(T t, T t2, int i) {
        long zzai = (long) (zzai(i) & 1048575);
        if (zzb(t2, i)) {
            Object zzp = zzdy.zzp(t, zzai);
            Object zzp2 = zzdy.zzp(t2, zzai);
            if (zzp != null && zzp2 != null) {
                zzdy.zzb((Object) t, zzai, zzbd.zzb(zzp, zzp2));
                zzc(t, i);
            } else if (zzp2 != null) {
                zzdy.zzb((Object) t, zzai, zzp2);
                zzc(t, i);
            }
        }
    }

    private final void zzc(T t, T t2, int i) {
        int zzai = zzai(i);
        int i2 = this.zzks[i];
        long j = (long) (zzai & 1048575);
        if (zzb(t2, i2, i)) {
            Object zzp = zzdy.zzp(t, j);
            Object zzp2 = zzdy.zzp(t2, j);
            if (zzp != null && zzp2 != null) {
                zzdy.zzb((Object) t, j, zzbd.zzb(zzp, zzp2));
                zzc(t, i2, i);
            } else if (zzp2 != null) {
                zzdy.zzb((Object) t, j, zzp2);
                zzc(t, i2, i);
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
    public final int zzn(T r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            boolean r2 = r0.zzkz
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 1
            r9 = 0
            r11 = 0
            if (r2 == 0) goto L_0x04f2
            sun.misc.Unsafe r2 = zzkr
            r12 = 0
            r13 = 0
        L_0x0016:
            int[] r14 = r0.zzks
            int r14 = r14.length
            if (r12 >= r14) goto L_0x04ea
            int r14 = r0.zzai(r12)
            r15 = r14 & r3
            int r15 = r15 >>> 20
            int[] r3 = r0.zzks
            r3 = r3[r12]
            r14 = r14 & r7
            long r5 = (long) r14
            com.google.android.gms.internal.places.zzaw r14 = com.google.android.gms.internal.places.zzaw.DOUBLE_LIST_PACKED
            int r14 = r14.id()
            if (r15 < r14) goto L_0x0041
            com.google.android.gms.internal.places.zzaw r14 = com.google.android.gms.internal.places.zzaw.SINT64_LIST_PACKED
            int r14 = r14.id()
            if (r15 > r14) goto L_0x0041
            int[] r14 = r0.zzks
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
            boolean r14 = r0.zzb(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r1, r5)
            com.google.android.gms.internal.places.zzck r5 = (com.google.android.gms.internal.places.zzck) r5
            com.google.android.gms.internal.places.zzda r6 = r0.zzaf(r12)
            int r3 = com.google.android.gms.internal.places.zzaj.zzd(r3, r5, r6)
            goto L_0x03c9
        L_0x005d:
            boolean r14 = r0.zzb(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzi(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zzg((int) r3, (long) r5)
            goto L_0x03c9
        L_0x006d:
            boolean r14 = r0.zzb(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zzj(r3, r5)
            goto L_0x03c9
        L_0x007d:
            boolean r5 = r0.zzb(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.places.zzaj.zzi((int) r3, (long) r9)
            goto L_0x03c9
        L_0x0089:
            boolean r5 = r0.zzb(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.places.zzaj.zzl(r3, r11)
            goto L_0x03c9
        L_0x0095:
            boolean r14 = r0.zzb(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zzm(r3, r5)
            goto L_0x03c9
        L_0x00a5:
            boolean r14 = r0.zzb(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zzi((int) r3, (int) r5)
            goto L_0x03c9
        L_0x00b5:
            boolean r14 = r0.zzb(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r1, r5)
            com.google.android.gms.internal.places.zzw r5 = (com.google.android.gms.internal.places.zzw) r5
            int r3 = com.google.android.gms.internal.places.zzaj.zzd((int) r3, (com.google.android.gms.internal.places.zzw) r5)
            goto L_0x03c9
        L_0x00c7:
            boolean r14 = r0.zzb(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r1, r5)
            com.google.android.gms.internal.places.zzda r6 = r0.zzaf(r12)
            int r3 = com.google.android.gms.internal.places.zzdc.zzd((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.places.zzda) r6)
            goto L_0x03c9
        L_0x00db:
            boolean r14 = r0.zzb(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.places.zzw
            if (r6 == 0) goto L_0x00f1
            com.google.android.gms.internal.places.zzw r5 = (com.google.android.gms.internal.places.zzw) r5
            int r3 = com.google.android.gms.internal.places.zzaj.zzd((int) r3, (com.google.android.gms.internal.places.zzw) r5)
            goto L_0x03c9
        L_0x00f1:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.places.zzaj.zzc((int) r3, (java.lang.String) r5)
            goto L_0x03c9
        L_0x00f9:
            boolean r5 = r0.zzb(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.places.zzaj.zzd((int) r3, (boolean) r8)
            goto L_0x03c9
        L_0x0105:
            boolean r5 = r0.zzb(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.places.zzaj.zzk(r3, r11)
            goto L_0x03c9
        L_0x0111:
            boolean r5 = r0.zzb(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.places.zzaj.zzh((int) r3, (long) r9)
            goto L_0x03c9
        L_0x011d:
            boolean r14 = r0.zzb(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zzh((int) r3, (int) r5)
            goto L_0x03c9
        L_0x012d:
            boolean r14 = r0.zzb(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzi(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zzf((int) r3, (long) r5)
            goto L_0x03c9
        L_0x013d:
            boolean r14 = r0.zzb(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzi(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zze((int) r3, (long) r5)
            goto L_0x03c9
        L_0x014d:
            boolean r5 = r0.zzb(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.places.zzaj.zzc((int) r3, (float) r4)
            goto L_0x03c9
        L_0x0159:
            boolean r5 = r0.zzb(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            r5 = 0
            int r3 = com.google.android.gms.internal.places.zzaj.zzc((int) r3, (double) r5)
            goto L_0x03c9
        L_0x0167:
            com.google.android.gms.internal.places.zzcd r14 = r0.zzli
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r1, r5)
            java.lang.Object r6 = r0.zzag(r12)
            int r3 = r14.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x0177:
            java.util.List r5 = zze(r1, r5)
            com.google.android.gms.internal.places.zzda r6 = r0.zzaf(r12)
            int r3 = com.google.android.gms.internal.places.zzdc.zze(r3, r5, r6)
            goto L_0x03c9
        L_0x0185:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzg((java.util.List<java.lang.Long>) r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x0199
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0199:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x01a3:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzk(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x01b7
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01b7:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x01c1:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzm(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x01d5
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01d5:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x01df:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzl(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x01f3
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01f3:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x01fd:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzh(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x0211
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0211:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x021b:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzj(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x022f
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x022f:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x0239:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzn(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x024d
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x024d:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x0257:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzl(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x026b
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x026b:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x0275:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzm(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x0289
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0289:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x0293:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzi(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x02a7
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02a7:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x02b1:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzf((java.util.List<java.lang.Long>) r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x02c5
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02c5:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x02ce:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zze(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x02e2
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02e2:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x02eb:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzl(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x02ff
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02ff:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x0308:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzm(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x031c
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x031c:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
        L_0x0324:
            int r3 = r3 + r6
            int r3 = r3 + r5
            goto L_0x03c9
        L_0x0328:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzr(r3, r5, r11)
            goto L_0x03c9
        L_0x0332:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzv(r3, r5, r11)
            goto L_0x03c9
        L_0x033c:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzx(r3, r5, r11)
            goto L_0x03c9
        L_0x0346:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzw(r3, r5, r11)
            goto L_0x03c9
        L_0x0350:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzs(r3, r5, r11)
            goto L_0x03c9
        L_0x035a:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzu(r3, r5, r11)
            goto L_0x03c9
        L_0x0363:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zze((int) r3, (java.util.List<com.google.android.gms.internal.places.zzw>) r5)
            goto L_0x03c9
        L_0x036c:
            java.util.List r5 = zze(r1, r5)
            com.google.android.gms.internal.places.zzda r6 = r0.zzaf(r12)
            int r3 = com.google.android.gms.internal.places.zzdc.zzd((int) r3, (java.util.List<?>) r5, (com.google.android.gms.internal.places.zzda) r6)
            goto L_0x03c9
        L_0x0379:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzd(r3, r5)
            goto L_0x03c9
        L_0x0382:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzy(r3, r5, r11)
            goto L_0x03c9
        L_0x038b:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzw(r3, r5, r11)
            goto L_0x03c9
        L_0x0394:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzx(r3, r5, r11)
            goto L_0x03c9
        L_0x039d:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzt(r3, r5, r11)
            goto L_0x03c9
        L_0x03a6:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzq(r3, r5, r11)
            goto L_0x03c9
        L_0x03af:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzp(r3, r5, r11)
            goto L_0x03c9
        L_0x03b8:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzw(r3, r5, r11)
            goto L_0x03c9
        L_0x03c1:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzx(r3, r5, r11)
        L_0x03c9:
            int r13 = r13 + r3
            goto L_0x04e4
        L_0x03cc:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r1, r5)
            com.google.android.gms.internal.places.zzck r5 = (com.google.android.gms.internal.places.zzck) r5
            com.google.android.gms.internal.places.zzda r6 = r0.zzaf(r12)
            int r3 = com.google.android.gms.internal.places.zzaj.zzd(r3, r5, r6)
            goto L_0x03c9
        L_0x03e1:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.places.zzdy.zzl(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zzg((int) r3, (long) r5)
            goto L_0x03c9
        L_0x03f0:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.places.zzdy.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zzj(r3, r5)
            goto L_0x03c9
        L_0x03ff:
            boolean r5 = r0.zzb(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.places.zzaj.zzi((int) r3, (long) r9)
            goto L_0x03c9
        L_0x040a:
            boolean r5 = r0.zzb(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.places.zzaj.zzl(r3, r11)
            goto L_0x03c9
        L_0x0415:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.places.zzdy.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zzm(r3, r5)
            goto L_0x03c9
        L_0x0424:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.places.zzdy.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zzi((int) r3, (int) r5)
            goto L_0x03c9
        L_0x0433:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r1, r5)
            com.google.android.gms.internal.places.zzw r5 = (com.google.android.gms.internal.places.zzw) r5
            int r3 = com.google.android.gms.internal.places.zzaj.zzd((int) r3, (com.google.android.gms.internal.places.zzw) r5)
            goto L_0x03c9
        L_0x0444:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r1, r5)
            com.google.android.gms.internal.places.zzda r6 = r0.zzaf(r12)
            int r3 = com.google.android.gms.internal.places.zzdc.zzd((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.places.zzda) r6)
            goto L_0x03c9
        L_0x0458:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.places.zzw
            if (r6 == 0) goto L_0x046e
            com.google.android.gms.internal.places.zzw r5 = (com.google.android.gms.internal.places.zzw) r5
            int r3 = com.google.android.gms.internal.places.zzaj.zzd((int) r3, (com.google.android.gms.internal.places.zzw) r5)
            goto L_0x03c9
        L_0x046e:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.places.zzaj.zzc((int) r3, (java.lang.String) r5)
            goto L_0x03c9
        L_0x0476:
            boolean r5 = r0.zzb(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.places.zzaj.zzd((int) r3, (boolean) r8)
            goto L_0x03c9
        L_0x0482:
            boolean r5 = r0.zzb(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.places.zzaj.zzk(r3, r11)
            goto L_0x03c9
        L_0x048e:
            boolean r5 = r0.zzb(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.places.zzaj.zzh((int) r3, (long) r9)
            goto L_0x03c9
        L_0x049a:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.places.zzdy.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zzh((int) r3, (int) r5)
            goto L_0x03c9
        L_0x04aa:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.places.zzdy.zzl(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zzf((int) r3, (long) r5)
            goto L_0x03c9
        L_0x04ba:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.places.zzdy.zzl(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zze((int) r3, (long) r5)
            goto L_0x03c9
        L_0x04ca:
            boolean r5 = r0.zzb(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.places.zzaj.zzc((int) r3, (float) r4)
            goto L_0x03c9
        L_0x04d6:
            boolean r5 = r0.zzb(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            r5 = 0
            int r3 = com.google.android.gms.internal.places.zzaj.zzc((int) r3, (double) r5)
            goto L_0x03c9
        L_0x04e4:
            int r12 = r12 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0016
        L_0x04ea:
            com.google.android.gms.internal.places.zzds<?, ?> r2 = r0.zzlg
            int r1 = zzb(r2, r1)
            int r13 = r13 + r1
            return r13
        L_0x04f2:
            sun.misc.Unsafe r2 = zzkr
            r3 = -1
            r3 = 0
            r5 = 0
            r6 = -1
            r12 = 0
        L_0x04f9:
            int[] r13 = r0.zzks
            int r13 = r13.length
            if (r3 >= r13) goto L_0x0a3f
            int r13 = r0.zzai(r3)
            int[] r14 = r0.zzks
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
            boolean r8 = r0.zzla
            if (r8 == 0) goto L_0x0542
            com.google.android.gms.internal.places.zzaw r8 = com.google.android.gms.internal.places.zzaw.DOUBLE_LIST_PACKED
            int r8 = r8.id()
            if (r4 < r8) goto L_0x0542
            com.google.android.gms.internal.places.zzaw r8 = com.google.android.gms.internal.places.zzaw.SINT64_LIST_PACKED
            int r8 = r8.id()
            if (r4 > r8) goto L_0x0542
            int[] r8 = r0.zzks
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
            boolean r4 = r0.zzb(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.places.zzck r4 = (com.google.android.gms.internal.places.zzck) r4
            com.google.android.gms.internal.places.zzda r8 = r0.zzaf(r3)
            int r4 = com.google.android.gms.internal.places.zzaj.zzd(r15, r4, r8)
            goto L_0x0910
        L_0x0563:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            long r8 = zzi(r1, r8)
            int r4 = com.google.android.gms.internal.places.zzaj.zzg((int) r15, (long) r8)
            goto L_0x0910
        L_0x0573:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            int r4 = zzh(r1, r8)
            int r4 = com.google.android.gms.internal.places.zzaj.zzj(r15, r4)
            goto L_0x0910
        L_0x0583:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r8 = 0
            int r4 = com.google.android.gms.internal.places.zzaj.zzi((int) r15, (long) r8)
            goto L_0x0910
        L_0x0591:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r4 = 0
            int r8 = com.google.android.gms.internal.places.zzaj.zzl(r15, r4)
            goto L_0x095a
        L_0x059e:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            int r4 = zzh(r1, r8)
            int r4 = com.google.android.gms.internal.places.zzaj.zzm(r15, r4)
            goto L_0x0910
        L_0x05ae:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            int r4 = zzh(r1, r8)
            int r4 = com.google.android.gms.internal.places.zzaj.zzi((int) r15, (int) r4)
            goto L_0x0910
        L_0x05be:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.places.zzw r4 = (com.google.android.gms.internal.places.zzw) r4
            int r4 = com.google.android.gms.internal.places.zzaj.zzd((int) r15, (com.google.android.gms.internal.places.zzw) r4)
            goto L_0x0910
        L_0x05d0:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.places.zzda r8 = r0.zzaf(r3)
            int r4 = com.google.android.gms.internal.places.zzdc.zzd((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.places.zzda) r8)
            goto L_0x0910
        L_0x05e4:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            boolean r8 = r4 instanceof com.google.android.gms.internal.places.zzw
            if (r8 == 0) goto L_0x05fa
            com.google.android.gms.internal.places.zzw r4 = (com.google.android.gms.internal.places.zzw) r4
            int r4 = com.google.android.gms.internal.places.zzaj.zzd((int) r15, (com.google.android.gms.internal.places.zzw) r4)
            goto L_0x0910
        L_0x05fa:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.places.zzaj.zzc((int) r15, (java.lang.String) r4)
            goto L_0x0910
        L_0x0602:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r4 = 1
            int r8 = com.google.android.gms.internal.places.zzaj.zzd((int) r15, (boolean) r4)
            goto L_0x095a
        L_0x060f:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r4 = 0
            int r8 = com.google.android.gms.internal.places.zzaj.zzk(r15, r4)
            goto L_0x095a
        L_0x061c:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r8 = 0
            int r4 = com.google.android.gms.internal.places.zzaj.zzh((int) r15, (long) r8)
            goto L_0x0910
        L_0x062a:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            int r4 = zzh(r1, r8)
            int r4 = com.google.android.gms.internal.places.zzaj.zzh((int) r15, (int) r4)
            goto L_0x0910
        L_0x063a:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            long r8 = zzi(r1, r8)
            int r4 = com.google.android.gms.internal.places.zzaj.zzf((int) r15, (long) r8)
            goto L_0x0910
        L_0x064a:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            long r8 = zzi(r1, r8)
            int r4 = com.google.android.gms.internal.places.zzaj.zze((int) r15, (long) r8)
            goto L_0x0910
        L_0x065a:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r4 = 0
            int r8 = com.google.android.gms.internal.places.zzaj.zzc((int) r15, (float) r4)
            goto L_0x095a
        L_0x0667:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r8 = 0
            int r4 = com.google.android.gms.internal.places.zzaj.zzc((int) r15, (double) r8)
            goto L_0x0910
        L_0x0675:
            com.google.android.gms.internal.places.zzcd r4 = r0.zzli
            java.lang.Object r8 = r2.getObject(r1, r8)
            java.lang.Object r9 = r0.zzag(r3)
            int r4 = r4.zzc(r15, r8, r9)
            goto L_0x0910
        L_0x0685:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.places.zzda r8 = r0.zzaf(r3)
            int r4 = com.google.android.gms.internal.places.zzdc.zze(r15, r4, r8)
            goto L_0x0910
        L_0x0695:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzg((java.util.List<java.lang.Long>) r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzla
            if (r8 == 0) goto L_0x06a9
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x06a9:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0834
        L_0x06b3:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzk(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzla
            if (r8 == 0) goto L_0x06c7
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x06c7:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0834
        L_0x06d1:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzm(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzla
            if (r8 == 0) goto L_0x06e5
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x06e5:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0834
        L_0x06ef:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzl(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzla
            if (r8 == 0) goto L_0x0703
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x0703:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0834
        L_0x070d:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzh(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzla
            if (r8 == 0) goto L_0x0721
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x0721:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0834
        L_0x072b:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzj(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzla
            if (r8 == 0) goto L_0x073f
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x073f:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0834
        L_0x0749:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzn(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzla
            if (r8 == 0) goto L_0x075d
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x075d:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0834
        L_0x0767:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzl(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzla
            if (r8 == 0) goto L_0x077b
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x077b:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0834
        L_0x0785:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzm(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzla
            if (r8 == 0) goto L_0x0799
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x0799:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0834
        L_0x07a3:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzi(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzla
            if (r8 == 0) goto L_0x07b7
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x07b7:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0834
        L_0x07c1:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzf((java.util.List<java.lang.Long>) r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzla
            if (r8 == 0) goto L_0x07d5
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x07d5:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0834
        L_0x07de:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zze(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzla
            if (r8 == 0) goto L_0x07f2
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x07f2:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0834
        L_0x07fb:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzl(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzla
            if (r8 == 0) goto L_0x080f
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x080f:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0834
        L_0x0818:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzm(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzla
            if (r8 == 0) goto L_0x082c
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x082c:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
        L_0x0834:
            int r8 = r8 + r9
            int r8 = r8 + r4
            goto L_0x095a
        L_0x0838:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            r10 = 0
            int r4 = com.google.android.gms.internal.places.zzdc.zzr(r15, r4, r10)
            goto L_0x0900
        L_0x0845:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzv(r15, r4, r10)
            goto L_0x0900
        L_0x0852:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzx(r15, r4, r10)
            goto L_0x0900
        L_0x085f:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzw(r15, r4, r10)
            goto L_0x0900
        L_0x086c:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzs(r15, r4, r10)
            goto L_0x0900
        L_0x0879:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzu(r15, r4, r10)
            goto L_0x0910
        L_0x0886:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zze((int) r15, (java.util.List<com.google.android.gms.internal.places.zzw>) r4)
            goto L_0x0910
        L_0x0892:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.places.zzda r8 = r0.zzaf(r3)
            int r4 = com.google.android.gms.internal.places.zzdc.zzd((int) r15, (java.util.List<?>) r4, (com.google.android.gms.internal.places.zzda) r8)
            goto L_0x0910
        L_0x08a2:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzd(r15, r4)
            goto L_0x0910
        L_0x08ad:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            r10 = 0
            int r4 = com.google.android.gms.internal.places.zzdc.zzy(r15, r4, r10)
            goto L_0x0900
        L_0x08b9:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzw(r15, r4, r10)
            goto L_0x0900
        L_0x08c5:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzx(r15, r4, r10)
            goto L_0x0900
        L_0x08d1:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzt(r15, r4, r10)
            goto L_0x0900
        L_0x08dd:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzq(r15, r4, r10)
            goto L_0x0900
        L_0x08e9:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzp(r15, r4, r10)
            goto L_0x0900
        L_0x08f5:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzw(r15, r4, r10)
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
            int r4 = com.google.android.gms.internal.places.zzdc.zzx(r15, r4, r10)
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
            com.google.android.gms.internal.places.zzck r4 = (com.google.android.gms.internal.places.zzck) r4
            com.google.android.gms.internal.places.zzda r8 = r0.zzaf(r3)
            int r4 = com.google.android.gms.internal.places.zzaj.zzd(r15, r4, r8)
            goto L_0x0910
        L_0x092c:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            long r8 = r2.getLong(r1, r8)
            int r4 = com.google.android.gms.internal.places.zzaj.zzg((int) r15, (long) r8)
            goto L_0x0910
        L_0x0939:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.places.zzaj.zzj(r15, r4)
            goto L_0x0910
        L_0x0946:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            r8 = 0
            int r4 = com.google.android.gms.internal.places.zzaj.zzi((int) r15, (long) r8)
            goto L_0x0910
        L_0x0951:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            r4 = 0
            int r8 = com.google.android.gms.internal.places.zzaj.zzl(r15, r4)
        L_0x095a:
            int r5 = r5 + r8
            goto L_0x0911
        L_0x095c:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.places.zzaj.zzm(r15, r4)
            goto L_0x0910
        L_0x0969:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.places.zzaj.zzi((int) r15, (int) r4)
            goto L_0x0910
        L_0x0976:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.places.zzw r4 = (com.google.android.gms.internal.places.zzw) r4
            int r4 = com.google.android.gms.internal.places.zzaj.zzd((int) r15, (com.google.android.gms.internal.places.zzw) r4)
            goto L_0x0910
        L_0x0985:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.places.zzda r8 = r0.zzaf(r3)
            int r4 = com.google.android.gms.internal.places.zzdc.zzd((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.places.zzda) r8)
            goto L_0x0910
        L_0x0997:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            boolean r8 = r4 instanceof com.google.android.gms.internal.places.zzw
            if (r8 == 0) goto L_0x09ab
            com.google.android.gms.internal.places.zzw r4 = (com.google.android.gms.internal.places.zzw) r4
            int r4 = com.google.android.gms.internal.places.zzaj.zzd((int) r15, (com.google.android.gms.internal.places.zzw) r4)
            goto L_0x0910
        L_0x09ab:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.places.zzaj.zzc((int) r15, (java.lang.String) r4)
            goto L_0x0910
        L_0x09b3:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            r4 = 1
            int r8 = com.google.android.gms.internal.places.zzaj.zzd((int) r15, (boolean) r4)
            int r5 = r5 + r8
            goto L_0x0912
        L_0x09bf:
            r4 = 1
            r8 = r12 & r18
            if (r8 == 0) goto L_0x09cc
            r10 = 0
            int r8 = com.google.android.gms.internal.places.zzaj.zzk(r15, r10)
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
            int r8 = com.google.android.gms.internal.places.zzaj.zzh((int) r15, (long) r13)
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
            int r8 = com.google.android.gms.internal.places.zzaj.zzh((int) r15, (int) r8)
            goto L_0x0a11
        L_0x09f0:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a21
            long r8 = r2.getLong(r1, r8)
            int r8 = com.google.android.gms.internal.places.zzaj.zzf((int) r15, (long) r8)
            goto L_0x0a11
        L_0x0a01:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a21
            long r8 = r2.getLong(r1, r8)
            int r8 = com.google.android.gms.internal.places.zzaj.zze((int) r15, (long) r8)
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
            int r9 = com.google.android.gms.internal.places.zzaj.zzc((int) r15, (float) r8)
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
            int r11 = com.google.android.gms.internal.places.zzaj.zzc((int) r15, (double) r7)
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
            com.google.android.gms.internal.places.zzds<?, ?> r2 = r0.zzlg
            int r2 = zzb(r2, r1)
            int r5 = r5 + r2
            boolean r2 = r0.zzkx
            if (r2 == 0) goto L_0x0a99
            com.google.android.gms.internal.places.zzar<?> r2 = r0.zzlh
            com.google.android.gms.internal.places.zzav r1 = r2.zzb((java.lang.Object) r1)
            r2 = 0
        L_0x0a52:
            com.google.android.gms.internal.places.zzdb<FieldDescriptorType, java.lang.Object> r3 = r1.zzfj
            int r3 = r3.zzcu()
            if (r10 >= r3) goto L_0x0a72
            com.google.android.gms.internal.places.zzdb<FieldDescriptorType, java.lang.Object> r3 = r1.zzfj
            java.util.Map$Entry r3 = r3.zzam(r10)
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.places.zzax r4 = (com.google.android.gms.internal.places.zzax) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.places.zzav.zzc((com.google.android.gms.internal.places.zzax<?>) r4, (java.lang.Object) r3)
            int r2 = r2 + r3
            int r10 = r10 + 1
            goto L_0x0a52
        L_0x0a72:
            com.google.android.gms.internal.places.zzdb<FieldDescriptorType, java.lang.Object> r1 = r1.zzfj
            java.lang.Iterable r1 = r1.zzcv()
            java.util.Iterator r1 = r1.iterator()
        L_0x0a7c:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0a98
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.places.zzax r4 = (com.google.android.gms.internal.places.zzax) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.places.zzav.zzc((com.google.android.gms.internal.places.zzax<?>) r4, (java.lang.Object) r3)
            int r2 = r2 + r3
            goto L_0x0a7c
        L_0x0a98:
            int r5 = r5 + r2
        L_0x0a99:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzn(java.lang.Object):int");
    }

    private static <UT, UB> int zzb(zzds<UT, UB> zzds, T t) {
        return zzds.zzn(zzds.zzr(t));
    }

    private static List<?> zze(Object obj, long j) {
        return (List) zzdy.zzp(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0553  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(T r14, com.google.android.gms.internal.places.zzel r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zzam()
            int r1 = com.google.android.gms.internal.places.zzbc.zze.zzix
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0529
            com.google.android.gms.internal.places.zzds<?, ?> r0 = r13.zzlg
            zzb(r0, r14, (com.google.android.gms.internal.places.zzel) r15)
            boolean r0 = r13.zzkx
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.places.zzar<?> r0 = r13.zzlh
            com.google.android.gms.internal.places.zzav r0 = r0.zzb((java.lang.Object) r14)
            com.google.android.gms.internal.places.zzdb<FieldDescriptorType, java.lang.Object> r1 = r0.zzfj
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
            int[] r7 = r13.zzks
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0039:
            if (r7 < 0) goto L_0x0511
            int r8 = r13.zzai(r7)
            int[] r9 = r13.zzks
            r9 = r9[r7]
        L_0x0043:
            if (r1 == 0) goto L_0x0061
            com.google.android.gms.internal.places.zzar<?> r10 = r13.zzlh
            int r10 = r10.zzb((java.util.Map.Entry<?, ?>) r1)
            if (r10 <= r9) goto L_0x0061
            com.google.android.gms.internal.places.zzar<?> r10 = r13.zzlh
            r10.zzb(r15, r1)
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
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            com.google.android.gms.internal.places.zzda r10 = r13.zzaf(r7)
            r15.zzc((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.places.zzda) r10)
            goto L_0x050d
        L_0x007f:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzc((int) r9, (long) r10)
            goto L_0x050d
        L_0x0090:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzf(r9, r8)
            goto L_0x050d
        L_0x00a1:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzk(r9, r10)
            goto L_0x050d
        L_0x00b2:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzn(r9, r8)
            goto L_0x050d
        L_0x00c3:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzo(r9, r8)
            goto L_0x050d
        L_0x00d4:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zze(r9, r8)
            goto L_0x050d
        L_0x00e5:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            com.google.android.gms.internal.places.zzw r8 = (com.google.android.gms.internal.places.zzw) r8
            r15.zzb((int) r9, (com.google.android.gms.internal.places.zzw) r8)
            goto L_0x050d
        L_0x00f8:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            com.google.android.gms.internal.places.zzda r10 = r13.zzaf(r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.places.zzda) r10)
            goto L_0x050d
        L_0x010d:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.places.zzel) r15)
            goto L_0x050d
        L_0x011e:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzj(r14, r10)
            r15.zzc((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x012f:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzg(r9, r8)
            goto L_0x050d
        L_0x0140:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzd((int) r9, (long) r10)
            goto L_0x050d
        L_0x0151:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzd((int) r9, (int) r8)
            goto L_0x050d
        L_0x0162:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x050d
        L_0x0173:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x050d
        L_0x0184:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzg(r14, r10)
            r15.zzb((int) r9, (float) r8)
            goto L_0x050d
        L_0x0195:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zzf(r14, r10)
            r15.zzb((int) r9, (double) r10)
            goto L_0x050d
        L_0x01a6:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            r13.zzb((com.google.android.gms.internal.places.zzel) r15, (int) r9, (java.lang.Object) r8, (int) r7)
            goto L_0x050d
        L_0x01b1:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzda r10 = r13.zzaf(r7)
            com.google.android.gms.internal.places.zzdc.zzc((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.places.zzel) r15, (com.google.android.gms.internal.places.zzda) r10)
            goto L_0x050d
        L_0x01c6:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzf(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01d7:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzk(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01e8:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzh(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01f9:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzm(r9, r8, r15, r4)
            goto L_0x050d
        L_0x020a:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzn(r9, r8, r15, r4)
            goto L_0x050d
        L_0x021b:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzj(r9, r8, r15, r4)
            goto L_0x050d
        L_0x022c:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzo(r9, r8, r15, r4)
            goto L_0x050d
        L_0x023d:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzl(r9, r8, r15, r4)
            goto L_0x050d
        L_0x024e:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzg(r9, r8, r15, r4)
            goto L_0x050d
        L_0x025f:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzi(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0270:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zze(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0281:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzd(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0292:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzc((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.places.zzel) r15, (boolean) r4)
            goto L_0x050d
        L_0x02a3:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzb((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.places.zzel) r15, (boolean) r4)
            goto L_0x050d
        L_0x02b4:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzf(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02c5:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzk(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02d6:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzh(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02e7:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzm(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02f8:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzn(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0309:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzj(r9, r8, r15, r5)
            goto L_0x050d
        L_0x031a:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzc(r9, r8, r15)
            goto L_0x050d
        L_0x032b:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzda r10 = r13.zzaf(r7)
            com.google.android.gms.internal.places.zzdc.zzb((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.places.zzel) r15, (com.google.android.gms.internal.places.zzda) r10)
            goto L_0x050d
        L_0x0340:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzb((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.places.zzel) r15)
            goto L_0x050d
        L_0x0351:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzo(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0362:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzl(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0373:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzg(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0384:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzi(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0395:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zze(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03a6:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzd(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03b7:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzc((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.places.zzel) r15, (boolean) r5)
            goto L_0x050d
        L_0x03c8:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzb((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.places.zzel) r15, (boolean) r5)
            goto L_0x050d
        L_0x03d9:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            com.google.android.gms.internal.places.zzda r10 = r13.zzaf(r7)
            r15.zzc((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.places.zzda) r10)
            goto L_0x050d
        L_0x03ee:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.places.zzdy.zzl(r14, r10)
            r15.zzc((int) r9, (long) r10)
            goto L_0x050d
        L_0x03ff:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.places.zzdy.zzk(r14, r10)
            r15.zzf(r9, r8)
            goto L_0x050d
        L_0x0410:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.places.zzdy.zzl(r14, r10)
            r15.zzk(r9, r10)
            goto L_0x050d
        L_0x0421:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.places.zzdy.zzk(r14, r10)
            r15.zzn(r9, r8)
            goto L_0x050d
        L_0x0432:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.places.zzdy.zzk(r14, r10)
            r15.zzo(r9, r8)
            goto L_0x050d
        L_0x0443:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.places.zzdy.zzk(r14, r10)
            r15.zze(r9, r8)
            goto L_0x050d
        L_0x0454:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            com.google.android.gms.internal.places.zzw r8 = (com.google.android.gms.internal.places.zzw) r8
            r15.zzb((int) r9, (com.google.android.gms.internal.places.zzw) r8)
            goto L_0x050d
        L_0x0467:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            com.google.android.gms.internal.places.zzda r10 = r13.zzaf(r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.places.zzda) r10)
            goto L_0x050d
        L_0x047c:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.places.zzel) r15)
            goto L_0x050d
        L_0x048d:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.places.zzdy.zzm(r14, r10)
            r15.zzc((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x049e:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.places.zzdy.zzk(r14, r10)
            r15.zzg(r9, r8)
            goto L_0x050d
        L_0x04ae:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.places.zzdy.zzl(r14, r10)
            r15.zzd((int) r9, (long) r10)
            goto L_0x050d
        L_0x04be:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.places.zzdy.zzk(r14, r10)
            r15.zzd((int) r9, (int) r8)
            goto L_0x050d
        L_0x04ce:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.places.zzdy.zzl(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x050d
        L_0x04de:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.places.zzdy.zzl(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x050d
        L_0x04ee:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.places.zzdy.zzn(r14, r10)
            r15.zzb((int) r9, (float) r8)
            goto L_0x050d
        L_0x04fe:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.places.zzdy.zzo(r14, r10)
            r15.zzb((int) r9, (double) r10)
        L_0x050d:
            int r7 = r7 + -3
            goto L_0x0039
        L_0x0511:
            if (r1 == 0) goto L_0x0528
            com.google.android.gms.internal.places.zzar<?> r14 = r13.zzlh
            r14.zzb(r15, r1)
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
            boolean r0 = r13.zzkz
            if (r0 == 0) goto L_0x0a46
            boolean r0 = r13.zzkx
            if (r0 == 0) goto L_0x054a
            com.google.android.gms.internal.places.zzar<?> r0 = r13.zzlh
            com.google.android.gms.internal.places.zzav r0 = r0.zzb((java.lang.Object) r14)
            com.google.android.gms.internal.places.zzdb<FieldDescriptorType, java.lang.Object> r1 = r0.zzfj
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
            int[] r7 = r13.zzks
            int r7 = r7.length
            r8 = r1
            r1 = 0
        L_0x0551:
            if (r1 >= r7) goto L_0x0a29
            int r9 = r13.zzai(r1)
            int[] r10 = r13.zzks
            r10 = r10[r1]
        L_0x055b:
            if (r8 == 0) goto L_0x0579
            com.google.android.gms.internal.places.zzar<?> r11 = r13.zzlh
            int r11 = r11.zzb((java.util.Map.Entry<?, ?>) r8)
            if (r11 > r10) goto L_0x0579
            com.google.android.gms.internal.places.zzar<?> r11 = r13.zzlh
            r11.zzb(r15, r8)
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
            boolean r11 = r13.zzb(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            com.google.android.gms.internal.places.zzda r11 = r13.zzaf(r1)
            r15.zzc((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.places.zzda) r11)
            goto L_0x0a25
        L_0x0597:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzc((int) r10, (long) r11)
            goto L_0x0a25
        L_0x05a8:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzf(r10, r9)
            goto L_0x0a25
        L_0x05b9:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzk(r10, r11)
            goto L_0x0a25
        L_0x05ca:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzn(r10, r9)
            goto L_0x0a25
        L_0x05db:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzo(r10, r9)
            goto L_0x0a25
        L_0x05ec:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zze(r10, r9)
            goto L_0x0a25
        L_0x05fd:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            com.google.android.gms.internal.places.zzw r9 = (com.google.android.gms.internal.places.zzw) r9
            r15.zzb((int) r10, (com.google.android.gms.internal.places.zzw) r9)
            goto L_0x0a25
        L_0x0610:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            com.google.android.gms.internal.places.zzda r11 = r13.zzaf(r1)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.places.zzda) r11)
            goto L_0x0a25
        L_0x0625:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.places.zzel) r15)
            goto L_0x0a25
        L_0x0636:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzj(r14, r11)
            r15.zzc((int) r10, (boolean) r9)
            goto L_0x0a25
        L_0x0647:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzg(r10, r9)
            goto L_0x0a25
        L_0x0658:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzd((int) r10, (long) r11)
            goto L_0x0a25
        L_0x0669:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzd((int) r10, (int) r9)
            goto L_0x0a25
        L_0x067a:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0a25
        L_0x068b:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0a25
        L_0x069c:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzg(r14, r11)
            r15.zzb((int) r10, (float) r9)
            goto L_0x0a25
        L_0x06ad:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zzf(r14, r11)
            r15.zzb((int) r10, (double) r11)
            goto L_0x0a25
        L_0x06be:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            r13.zzb((com.google.android.gms.internal.places.zzel) r15, (int) r10, (java.lang.Object) r9, (int) r1)
            goto L_0x0a25
        L_0x06c9:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzda r11 = r13.zzaf(r1)
            com.google.android.gms.internal.places.zzdc.zzc((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.places.zzel) r15, (com.google.android.gms.internal.places.zzda) r11)
            goto L_0x0a25
        L_0x06de:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzf(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x06ef:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzk(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0700:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzh(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0711:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzm(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0722:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzn(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0733:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzj(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0744:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzo(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0755:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzl(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0766:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzg(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0777:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzi(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0788:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zze(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0799:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzd(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x07aa:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzc((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.places.zzel) r15, (boolean) r4)
            goto L_0x0a25
        L_0x07bb:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzb((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.places.zzel) r15, (boolean) r4)
            goto L_0x0a25
        L_0x07cc:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzf(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x07dd:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzk(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x07ee:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzh(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x07ff:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzm(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x0810:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzn(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x0821:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzj(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x0832:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzc(r10, r9, r15)
            goto L_0x0a25
        L_0x0843:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzda r11 = r13.zzaf(r1)
            com.google.android.gms.internal.places.zzdc.zzb((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.places.zzel) r15, (com.google.android.gms.internal.places.zzda) r11)
            goto L_0x0a25
        L_0x0858:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzb((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.places.zzel) r15)
            goto L_0x0a25
        L_0x0869:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzo(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x087a:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzl(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x088b:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzg(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x089c:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzi(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x08ad:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zze(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x08be:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzd(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x08cf:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzc((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.places.zzel) r15, (boolean) r5)
            goto L_0x0a25
        L_0x08e0:
            int[] r10 = r13.zzks
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzb((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.places.zzel) r15, (boolean) r5)
            goto L_0x0a25
        L_0x08f1:
            boolean r11 = r13.zzb(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            com.google.android.gms.internal.places.zzda r11 = r13.zzaf(r1)
            r15.zzc((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.places.zzda) r11)
            goto L_0x0a25
        L_0x0906:
            boolean r11 = r13.zzb(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.places.zzdy.zzl(r14, r11)
            r15.zzc((int) r10, (long) r11)
            goto L_0x0a25
        L_0x0917:
            boolean r11 = r13.zzb(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.places.zzdy.zzk(r14, r11)
            r15.zzf(r10, r9)
            goto L_0x0a25
        L_0x0928:
            boolean r11 = r13.zzb(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.places.zzdy.zzl(r14, r11)
            r15.zzk(r10, r11)
            goto L_0x0a25
        L_0x0939:
            boolean r11 = r13.zzb(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.places.zzdy.zzk(r14, r11)
            r15.zzn(r10, r9)
            goto L_0x0a25
        L_0x094a:
            boolean r11 = r13.zzb(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.places.zzdy.zzk(r14, r11)
            r15.zzo(r10, r9)
            goto L_0x0a25
        L_0x095b:
            boolean r11 = r13.zzb(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.places.zzdy.zzk(r14, r11)
            r15.zze(r10, r9)
            goto L_0x0a25
        L_0x096c:
            boolean r11 = r13.zzb(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            com.google.android.gms.internal.places.zzw r9 = (com.google.android.gms.internal.places.zzw) r9
            r15.zzb((int) r10, (com.google.android.gms.internal.places.zzw) r9)
            goto L_0x0a25
        L_0x097f:
            boolean r11 = r13.zzb(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            com.google.android.gms.internal.places.zzda r11 = r13.zzaf(r1)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.places.zzda) r11)
            goto L_0x0a25
        L_0x0994:
            boolean r11 = r13.zzb(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.places.zzel) r15)
            goto L_0x0a25
        L_0x09a5:
            boolean r11 = r13.zzb(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.places.zzdy.zzm(r14, r11)
            r15.zzc((int) r10, (boolean) r9)
            goto L_0x0a25
        L_0x09b6:
            boolean r11 = r13.zzb(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.places.zzdy.zzk(r14, r11)
            r15.zzg(r10, r9)
            goto L_0x0a25
        L_0x09c6:
            boolean r11 = r13.zzb(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.places.zzdy.zzl(r14, r11)
            r15.zzd((int) r10, (long) r11)
            goto L_0x0a25
        L_0x09d6:
            boolean r11 = r13.zzb(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.places.zzdy.zzk(r14, r11)
            r15.zzd((int) r10, (int) r9)
            goto L_0x0a25
        L_0x09e6:
            boolean r11 = r13.zzb(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.places.zzdy.zzl(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0a25
        L_0x09f6:
            boolean r11 = r13.zzb(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.places.zzdy.zzl(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0a25
        L_0x0a06:
            boolean r11 = r13.zzb(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.places.zzdy.zzn(r14, r11)
            r15.zzb((int) r10, (float) r9)
            goto L_0x0a25
        L_0x0a16:
            boolean r11 = r13.zzb(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.places.zzdy.zzo(r14, r11)
            r15.zzb((int) r10, (double) r11)
        L_0x0a25:
            int r1 = r1 + 3
            goto L_0x0551
        L_0x0a29:
            if (r8 == 0) goto L_0x0a40
            com.google.android.gms.internal.places.zzar<?> r1 = r13.zzlh
            r1.zzb(r15, r8)
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
            com.google.android.gms.internal.places.zzds<?, ?> r0 = r13.zzlg
            zzb(r0, r14, (com.google.android.gms.internal.places.zzel) r15)
            return
        L_0x0a46:
            r13.zzc(r14, (com.google.android.gms.internal.places.zzel) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzb(java.lang.Object, com.google.android.gms.internal.places.zzel):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:172:0x04b5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzc(T r19, com.google.android.gms.internal.places.zzel r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r0.zzkx
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.places.zzar<?> r3 = r0.zzlh
            com.google.android.gms.internal.places.zzav r3 = r3.zzb((java.lang.Object) r1)
            com.google.android.gms.internal.places.zzdb<FieldDescriptorType, java.lang.Object> r5 = r3.zzfj
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
            int[] r7 = r0.zzks
            int r7 = r7.length
            sun.misc.Unsafe r8 = zzkr
            r10 = r5
            r5 = 0
            r11 = 0
        L_0x002e:
            if (r5 >= r7) goto L_0x04af
            int r12 = r0.zzai(r5)
            int[] r13 = r0.zzks
            r14 = r13[r5]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r12
            int r15 = r15 >>> 20
            boolean r4 = r0.zzkz
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
            com.google.android.gms.internal.places.zzar<?> r4 = r0.zzlh
            int r4 = r4.zzb((java.util.Map.Entry<?, ?>) r10)
            if (r4 > r14) goto L_0x0088
            com.google.android.gms.internal.places.zzar<?> r4 = r0.zzlh
            r4.zzb(r2, r10)
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
            boolean r4 = r0.zzb(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.places.zzda r9 = r0.zzaf(r5)
            r2.zzc((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.places.zzda) r9)
            goto L_0x008e
        L_0x00a3:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r12 = zzi(r1, r12)
            r2.zzc((int) r14, (long) r12)
            goto L_0x008e
        L_0x00b1:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzh(r1, r12)
            r2.zzf(r14, r4)
            goto L_0x008e
        L_0x00bf:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r12 = zzi(r1, r12)
            r2.zzk(r14, r12)
            goto L_0x008e
        L_0x00cd:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzh(r1, r12)
            r2.zzn(r14, r4)
            goto L_0x008e
        L_0x00db:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzh(r1, r12)
            r2.zzo(r14, r4)
            goto L_0x008e
        L_0x00e9:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzh(r1, r12)
            r2.zze(r14, r4)
            goto L_0x008e
        L_0x00f7:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.places.zzw r4 = (com.google.android.gms.internal.places.zzw) r4
            r2.zzb((int) r14, (com.google.android.gms.internal.places.zzw) r4)
            goto L_0x008e
        L_0x0107:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.places.zzda r9 = r0.zzaf(r5)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.places.zzda) r9)
            goto L_0x008e
        L_0x011a:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r8.getObject(r1, r12)
            zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.places.zzel) r2)
            goto L_0x008e
        L_0x0129:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            boolean r4 = zzj(r1, r12)
            r2.zzc((int) r14, (boolean) r4)
            goto L_0x008e
        L_0x0138:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzh(r1, r12)
            r2.zzg(r14, r4)
            goto L_0x008e
        L_0x0147:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r12 = zzi(r1, r12)
            r2.zzd((int) r14, (long) r12)
            goto L_0x008e
        L_0x0156:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzh(r1, r12)
            r2.zzd((int) r14, (int) r4)
            goto L_0x008e
        L_0x0165:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r12 = zzi(r1, r12)
            r2.zzb((int) r14, (long) r12)
            goto L_0x008e
        L_0x0174:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r12 = zzi(r1, r12)
            r2.zzj(r14, r12)
            goto L_0x008e
        L_0x0183:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            float r4 = zzg(r1, r12)
            r2.zzb((int) r14, (float) r4)
            goto L_0x008e
        L_0x0192:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            double r12 = zzf(r1, r12)
            r2.zzb((int) r14, (double) r12)
            goto L_0x008e
        L_0x01a1:
            java.lang.Object r4 = r8.getObject(r1, r12)
            r0.zzb((com.google.android.gms.internal.places.zzel) r2, (int) r14, (java.lang.Object) r4, (int) r5)
            goto L_0x008e
        L_0x01aa:
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzda r12 = r0.zzaf(r5)
            com.google.android.gms.internal.places.zzdc.zzc((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.places.zzel) r2, (com.google.android.gms.internal.places.zzda) r12)
            goto L_0x008e
        L_0x01bd:
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r14 = 1
            com.google.android.gms.internal.places.zzdc.zzf(r4, r9, r2, r14)
            goto L_0x008e
        L_0x01cd:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzk(r4, r9, r2, r14)
            goto L_0x008e
        L_0x01dd:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzh(r4, r9, r2, r14)
            goto L_0x008e
        L_0x01ed:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzm(r4, r9, r2, r14)
            goto L_0x008e
        L_0x01fd:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzn(r4, r9, r2, r14)
            goto L_0x008e
        L_0x020d:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzj(r4, r9, r2, r14)
            goto L_0x008e
        L_0x021d:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzo(r4, r9, r2, r14)
            goto L_0x008e
        L_0x022d:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzl(r4, r9, r2, r14)
            goto L_0x008e
        L_0x023d:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzg(r4, r9, r2, r14)
            goto L_0x008e
        L_0x024d:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzi(r4, r9, r2, r14)
            goto L_0x008e
        L_0x025d:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zze(r4, r9, r2, r14)
            goto L_0x008e
        L_0x026d:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzd(r4, r9, r2, r14)
            goto L_0x008e
        L_0x027d:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzc((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.places.zzel) r2, (boolean) r14)
            goto L_0x008e
        L_0x028d:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzb((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.places.zzel) r2, (boolean) r14)
            goto L_0x008e
        L_0x029d:
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r14 = 0
            com.google.android.gms.internal.places.zzdc.zzf(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02ad:
            r14 = 0
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzk(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02bd:
            r14 = 0
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzh(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02cd:
            r14 = 0
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzm(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02dd:
            r14 = 0
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzn(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02ed:
            r14 = 0
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzj(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02fd:
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzc(r4, r9, r2)
            goto L_0x008e
        L_0x030c:
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzda r12 = r0.zzaf(r5)
            com.google.android.gms.internal.places.zzdc.zzb((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.places.zzel) r2, (com.google.android.gms.internal.places.zzda) r12)
            goto L_0x008e
        L_0x031f:
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzb((int) r4, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.places.zzel) r2)
            goto L_0x008e
        L_0x032e:
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r15 = 0
            com.google.android.gms.internal.places.zzdc.zzo(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x033e:
            r15 = 0
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzl(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x034e:
            r15 = 0
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzg(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x035e:
            r15 = 0
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzi(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x036e:
            r15 = 0
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zze(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x037e:
            r15 = 0
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzd(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x038e:
            r15 = 0
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzc((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.places.zzel) r2, (boolean) r15)
            goto L_0x04ab
        L_0x039e:
            r15 = 0
            int[] r4 = r0.zzks
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzb((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.places.zzel) r2, (boolean) r15)
            goto L_0x04ab
        L_0x03ae:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.places.zzda r9 = r0.zzaf(r5)
            r2.zzc((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.places.zzda) r9)
            goto L_0x04ab
        L_0x03c0:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            long r12 = r8.getLong(r1, r12)
            r2.zzc((int) r14, (long) r12)
            goto L_0x04ab
        L_0x03ce:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r8.getInt(r1, r12)
            r2.zzf(r14, r4)
            goto L_0x04ab
        L_0x03dc:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            long r12 = r8.getLong(r1, r12)
            r2.zzk(r14, r12)
            goto L_0x04ab
        L_0x03ea:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r8.getInt(r1, r12)
            r2.zzn(r14, r4)
            goto L_0x04ab
        L_0x03f8:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r8.getInt(r1, r12)
            r2.zzo(r14, r4)
            goto L_0x04ab
        L_0x0406:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r8.getInt(r1, r12)
            r2.zze(r14, r4)
            goto L_0x04ab
        L_0x0414:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.places.zzw r4 = (com.google.android.gms.internal.places.zzw) r4
            r2.zzb((int) r14, (com.google.android.gms.internal.places.zzw) r4)
            goto L_0x04ab
        L_0x0424:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.places.zzda r9 = r0.zzaf(r5)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.places.zzda) r9)
            goto L_0x04ab
        L_0x0436:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r8.getObject(r1, r12)
            zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.places.zzel) r2)
            goto L_0x04ab
        L_0x0444:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            boolean r4 = com.google.android.gms.internal.places.zzdy.zzm(r1, r12)
            r2.zzc((int) r14, (boolean) r4)
            goto L_0x04ab
        L_0x0451:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r8.getInt(r1, r12)
            r2.zzg(r14, r4)
            goto L_0x04ab
        L_0x045e:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            long r12 = r8.getLong(r1, r12)
            r2.zzd((int) r14, (long) r12)
            goto L_0x04ab
        L_0x046b:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r8.getInt(r1, r12)
            r2.zzd((int) r14, (int) r4)
            goto L_0x04ab
        L_0x0478:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            long r12 = r8.getLong(r1, r12)
            r2.zzb((int) r14, (long) r12)
            goto L_0x04ab
        L_0x0485:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            long r12 = r8.getLong(r1, r12)
            r2.zzj(r14, r12)
            goto L_0x04ab
        L_0x0492:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            float r4 = com.google.android.gms.internal.places.zzdy.zzn(r1, r12)
            r2.zzb((int) r14, (float) r4)
            goto L_0x04ab
        L_0x049f:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            double r12 = com.google.android.gms.internal.places.zzdy.zzo(r1, r12)
            r2.zzb((int) r14, (double) r12)
        L_0x04ab:
            int r5 = r5 + 3
            goto L_0x002e
        L_0x04af:
            r17 = r10
            r4 = r17
        L_0x04b3:
            if (r4 == 0) goto L_0x04c9
            com.google.android.gms.internal.places.zzar<?> r5 = r0.zzlh
            r5.zzb(r2, r4)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04c7
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            goto L_0x04b3
        L_0x04c7:
            r4 = 0
            goto L_0x04b3
        L_0x04c9:
            com.google.android.gms.internal.places.zzds<?, ?> r3 = r0.zzlg
            zzb(r3, r1, (com.google.android.gms.internal.places.zzel) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzc(java.lang.Object, com.google.android.gms.internal.places.zzel):void");
    }

    private final <K, V> void zzb(zzel zzel, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzel.zzb(i, this.zzli.zzl(zzag(i2)), this.zzli.zzh(obj));
        }
    }

    private static <UT, UB> void zzb(zzds<UT, UB> zzds, T t, zzel zzel) throws IOException {
        zzds.zzb(zzds.zzr(t), zzel);
    }

    private static zzdr zzo(Object obj) {
        zzbc zzbc = (zzbc) obj;
        zzdr zzdr = zzbc.zzih;
        if (zzdr != zzdr.zzdh()) {
            return zzdr;
        }
        zzdr zzdi = zzdr.zzdi();
        zzbc.zzih = zzdi;
        return zzdi;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r2 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return r2 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzb(byte[] r1, int r2, int r3, com.google.android.gms.internal.places.zzef r4, java.lang.Class<?> r5, com.google.android.gms.internal.places.zzr r6) throws java.io.IOException {
        /*
            int[] r0 = com.google.android.gms.internal.places.zzcn.zzfi
            int r4 = r4.ordinal()
            r4 = r0[r4]
            switch(r4) {
                case 1: goto L_0x0099;
                case 2: goto L_0x0094;
                case 3: goto L_0x0087;
                case 4: goto L_0x007a;
                case 5: goto L_0x007a;
                case 6: goto L_0x006f;
                case 7: goto L_0x006f;
                case 8: goto L_0x0064;
                case 9: goto L_0x0057;
                case 10: goto L_0x0057;
                case 11: goto L_0x0057;
                case 12: goto L_0x004a;
                case 13: goto L_0x004a;
                case 14: goto L_0x003d;
                case 15: goto L_0x002b;
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
            int r1 = com.google.android.gms.internal.places.zzs.zze(r1, r2, r6)
            goto L_0x00ae
        L_0x0019:
            int r1 = com.google.android.gms.internal.places.zzs.zzc(r1, r2, r6)
            long r2 = r6.zzea
            long r2 = com.google.android.gms.internal.places.zzai.zzb(r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.zzeb = r2
            goto L_0x00ae
        L_0x002b:
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r1, r2, r6)
            int r2 = r6.zzdz
            int r2 = com.google.android.gms.internal.places.zzai.zzm(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.zzeb = r2
            goto L_0x00ae
        L_0x003d:
            com.google.android.gms.internal.places.zzcv r4 = com.google.android.gms.internal.places.zzcv.zzcq()
            com.google.android.gms.internal.places.zzda r4 = r4.zzf(r5)
            int r1 = com.google.android.gms.internal.places.zzs.zzb((com.google.android.gms.internal.places.zzda) r4, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.places.zzr) r6)
            goto L_0x00ae
        L_0x004a:
            int r1 = com.google.android.gms.internal.places.zzs.zzc(r1, r2, r6)
            long r2 = r6.zzea
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.zzeb = r2
            goto L_0x00ae
        L_0x0057:
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r1, r2, r6)
            int r2 = r6.zzdz
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.zzeb = r2
            goto L_0x00ae
        L_0x0064:
            float r1 = com.google.android.gms.internal.places.zzs.zze(r1, r2)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r6.zzeb = r1
            goto L_0x0084
        L_0x006f:
            long r3 = com.google.android.gms.internal.places.zzs.zzc(r1, r2)
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r6.zzeb = r1
            goto L_0x0091
        L_0x007a:
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r1, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r6.zzeb = r1
        L_0x0084:
            int r1 = r2 + 4
            goto L_0x00ae
        L_0x0087:
            double r3 = com.google.android.gms.internal.places.zzs.zzd(r1, r2)
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r6.zzeb = r1
        L_0x0091:
            int r1 = r2 + 8
            goto L_0x00ae
        L_0x0094:
            int r1 = com.google.android.gms.internal.places.zzs.zzf(r1, r2, r6)
            goto L_0x00ae
        L_0x0099:
            int r1 = com.google.android.gms.internal.places.zzs.zzc(r1, r2, r6)
            long r2 = r6.zzea
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00a7
            r2 = 1
            goto L_0x00a8
        L_0x00a7:
            r2 = 0
        L_0x00a8:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r6.zzeb = r2
        L_0x00ae:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzb(byte[], int, int, com.google.android.gms.internal.places.zzef, java.lang.Class, com.google.android.gms.internal.places.zzr):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0422 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01eb  */
    private final int zzb(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.places.zzr r30) throws java.io.IOException {
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
            sun.misc.Unsafe r11 = zzkr
            java.lang.Object r11 = r11.getObject(r1, r9)
            com.google.android.gms.internal.places.zzbh r11 = (com.google.android.gms.internal.places.zzbh) r11
            boolean r12 = r11.zzaa()
            r13 = 1
            if (r12 != 0) goto L_0x0036
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002c
            r12 = 10
            goto L_0x002d
        L_0x002c:
            int r12 = r12 << r13
        L_0x002d:
            com.google.android.gms.internal.places.zzbh r11 = r11.zzh(r12)
            sun.misc.Unsafe r12 = zzkr
            r12.putObject(r1, r9, r11)
        L_0x0036:
            r9 = 5
            r14 = 0
            r10 = 2
            switch(r27) {
                case 18: goto L_0x03e4;
                case 19: goto L_0x03a6;
                case 20: goto L_0x0365;
                case 21: goto L_0x0365;
                case 22: goto L_0x034b;
                case 23: goto L_0x030c;
                case 24: goto L_0x02cd;
                case 25: goto L_0x0276;
                case 26: goto L_0x01c3;
                case 27: goto L_0x01a9;
                case 28: goto L_0x0151;
                case 29: goto L_0x034b;
                case 30: goto L_0x0119;
                case 31: goto L_0x02cd;
                case 32: goto L_0x030c;
                case 33: goto L_0x00cc;
                case 34: goto L_0x007f;
                case 35: goto L_0x03e4;
                case 36: goto L_0x03a6;
                case 37: goto L_0x0365;
                case 38: goto L_0x0365;
                case 39: goto L_0x034b;
                case 40: goto L_0x030c;
                case 41: goto L_0x02cd;
                case 42: goto L_0x0276;
                case 43: goto L_0x034b;
                case 44: goto L_0x0119;
                case 45: goto L_0x02cd;
                case 46: goto L_0x030c;
                case 47: goto L_0x00cc;
                case 48: goto L_0x007f;
                case 49: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x0422
        L_0x003f:
            r1 = 3
            if (r6 != r1) goto L_0x0422
            com.google.android.gms.internal.places.zzda r1 = r0.zzaf(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r22 = r1
            r23 = r18
            r24 = r19
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.places.zzs.zzb((com.google.android.gms.internal.places.zzda) r22, (byte[]) r23, (int) r24, (int) r25, (int) r26, (com.google.android.gms.internal.places.zzr) r27)
            java.lang.Object r8 = r7.zzeb
            r11.add(r8)
        L_0x005f:
            if (r4 >= r5) goto L_0x0422
            int r8 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r9 = r7.zzdz
            if (r2 != r9) goto L_0x0422
            r22 = r1
            r23 = r18
            r24 = r8
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.places.zzs.zzb((com.google.android.gms.internal.places.zzda) r22, (byte[]) r23, (int) r24, (int) r25, (int) r26, (com.google.android.gms.internal.places.zzr) r27)
            java.lang.Object r8 = r7.zzeb
            r11.add(r8)
            goto L_0x005f
        L_0x007f:
            if (r6 != r10) goto L_0x00a3
            com.google.android.gms.internal.places.zzby r11 = (com.google.android.gms.internal.places.zzby) r11
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r2 = r7.zzdz
            int r2 = r2 + r1
        L_0x008a:
            if (r1 >= r2) goto L_0x009a
            int r1 = com.google.android.gms.internal.places.zzs.zzc(r3, r1, r7)
            long r4 = r7.zzea
            long r4 = com.google.android.gms.internal.places.zzai.zzb(r4)
            r11.zzm(r4)
            goto L_0x008a
        L_0x009a:
            if (r1 != r2) goto L_0x009e
            goto L_0x0423
        L_0x009e:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbp()
            throw r1
        L_0x00a3:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.places.zzby r11 = (com.google.android.gms.internal.places.zzby) r11
            int r1 = com.google.android.gms.internal.places.zzs.zzc(r3, r4, r7)
            long r8 = r7.zzea
            long r8 = com.google.android.gms.internal.places.zzai.zzb(r8)
            r11.zzm(r8)
        L_0x00b4:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r3, r1, r7)
            int r6 = r7.zzdz
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.places.zzs.zzc(r3, r4, r7)
            long r8 = r7.zzea
            long r8 = com.google.android.gms.internal.places.zzai.zzb(r8)
            r11.zzm(r8)
            goto L_0x00b4
        L_0x00cc:
            if (r6 != r10) goto L_0x00f0
            com.google.android.gms.internal.places.zzbe r11 = (com.google.android.gms.internal.places.zzbe) r11
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r2 = r7.zzdz
            int r2 = r2 + r1
        L_0x00d7:
            if (r1 >= r2) goto L_0x00e7
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r1, r7)
            int r4 = r7.zzdz
            int r4 = com.google.android.gms.internal.places.zzai.zzm(r4)
            r11.zzac(r4)
            goto L_0x00d7
        L_0x00e7:
            if (r1 != r2) goto L_0x00eb
            goto L_0x0423
        L_0x00eb:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbp()
            throw r1
        L_0x00f0:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.places.zzbe r11 = (com.google.android.gms.internal.places.zzbe) r11
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r4 = r7.zzdz
            int r4 = com.google.android.gms.internal.places.zzai.zzm(r4)
            r11.zzac(r4)
        L_0x0101:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r3, r1, r7)
            int r6 = r7.zzdz
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r4 = r7.zzdz
            int r4 = com.google.android.gms.internal.places.zzai.zzm(r4)
            r11.zzac(r4)
            goto L_0x0101
        L_0x0119:
            if (r6 != r10) goto L_0x0120
            int r2 = com.google.android.gms.internal.places.zzs.zzb((byte[]) r3, (int) r4, (com.google.android.gms.internal.places.zzbh<?>) r11, (com.google.android.gms.internal.places.zzr) r7)
            goto L_0x0131
        L_0x0120:
            if (r6 != 0) goto L_0x0422
            r2 = r21
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r11
            r7 = r30
            int r2 = com.google.android.gms.internal.places.zzs.zzb((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.places.zzbh<?>) r6, (com.google.android.gms.internal.places.zzr) r7)
        L_0x0131:
            com.google.android.gms.internal.places.zzbc r1 = (com.google.android.gms.internal.places.zzbc) r1
            com.google.android.gms.internal.places.zzdr r3 = r1.zzih
            com.google.android.gms.internal.places.zzdr r4 = com.google.android.gms.internal.places.zzdr.zzdh()
            if (r3 != r4) goto L_0x013c
            r3 = 0
        L_0x013c:
            com.google.android.gms.internal.places.zzbf r4 = r0.zzah(r8)
            com.google.android.gms.internal.places.zzds<?, ?> r5 = r0.zzlg
            r6 = r22
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdc.zzb(r6, r11, r4, r3, r5)
            com.google.android.gms.internal.places.zzdr r3 = (com.google.android.gms.internal.places.zzdr) r3
            if (r3 == 0) goto L_0x014e
            r1.zzih = r3
        L_0x014e:
            r1 = r2
            goto L_0x0423
        L_0x0151:
            if (r6 != r10) goto L_0x0422
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r4 = r7.zzdz
            if (r4 < 0) goto L_0x01a4
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x019f
            if (r4 != 0) goto L_0x0167
            com.google.android.gms.internal.places.zzw r4 = com.google.android.gms.internal.places.zzw.zzeg
            r11.add(r4)
            goto L_0x016f
        L_0x0167:
            com.google.android.gms.internal.places.zzw r6 = com.google.android.gms.internal.places.zzw.zzc((byte[]) r3, (int) r1, (int) r4)
            r11.add(r6)
        L_0x016e:
            int r1 = r1 + r4
        L_0x016f:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r3, r1, r7)
            int r6 = r7.zzdz
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r4 = r7.zzdz
            if (r4 < 0) goto L_0x019a
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0195
            if (r4 != 0) goto L_0x018d
            com.google.android.gms.internal.places.zzw r4 = com.google.android.gms.internal.places.zzw.zzeg
            r11.add(r4)
            goto L_0x016f
        L_0x018d:
            com.google.android.gms.internal.places.zzw r6 = com.google.android.gms.internal.places.zzw.zzc((byte[]) r3, (int) r1, (int) r4)
            r11.add(r6)
            goto L_0x016e
        L_0x0195:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbp()
            throw r1
        L_0x019a:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbq()
            throw r1
        L_0x019f:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbp()
            throw r1
        L_0x01a4:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbq()
            throw r1
        L_0x01a9:
            if (r6 != r10) goto L_0x0422
            com.google.android.gms.internal.places.zzda r1 = r0.zzaf(r8)
            r22 = r1
            r23 = r21
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r11
            r28 = r30
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r22, r23, r24, r25, r26, r27, r28)
            goto L_0x0423
        L_0x01c3:
            if (r6 != r10) goto L_0x0422
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r25 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 != 0) goto L_0x0216
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r6 = r7.zzdz
            if (r6 < 0) goto L_0x0211
            if (r6 != 0) goto L_0x01de
            r11.add(r1)
            goto L_0x01e9
        L_0x01de:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.places.zzbd.UTF_8
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
        L_0x01e8:
            int r4 = r4 + r6
        L_0x01e9:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r8 = r7.zzdz
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r3, r6, r7)
            int r6 = r7.zzdz
            if (r6 < 0) goto L_0x020c
            if (r6 != 0) goto L_0x0201
            r11.add(r1)
            goto L_0x01e9
        L_0x0201:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.places.zzbd.UTF_8
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
            goto L_0x01e8
        L_0x020c:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbq()
            throw r1
        L_0x0211:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbq()
            throw r1
        L_0x0216:
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r6 = r7.zzdz
            if (r6 < 0) goto L_0x0271
            if (r6 != 0) goto L_0x0224
            r11.add(r1)
            goto L_0x0237
        L_0x0224:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.places.zzea.zzf(r3, r4, r8)
            if (r9 == 0) goto L_0x026c
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.places.zzbd.UTF_8
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
        L_0x0236:
            r4 = r8
        L_0x0237:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r8 = r7.zzdz
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r3, r6, r7)
            int r6 = r7.zzdz
            if (r6 < 0) goto L_0x0267
            if (r6 != 0) goto L_0x024f
            r11.add(r1)
            goto L_0x0237
        L_0x024f:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.places.zzea.zzf(r3, r4, r8)
            if (r9 == 0) goto L_0x0262
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.places.zzbd.UTF_8
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
            goto L_0x0236
        L_0x0262:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbu()
            throw r1
        L_0x0267:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbq()
            throw r1
        L_0x026c:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbu()
            throw r1
        L_0x0271:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbq()
            throw r1
        L_0x0276:
            r1 = 0
            if (r6 != r10) goto L_0x029e
            com.google.android.gms.internal.places.zzu r11 = (com.google.android.gms.internal.places.zzu) r11
            int r2 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r4 = r7.zzdz
            int r4 = r4 + r2
        L_0x0282:
            if (r2 >= r4) goto L_0x0295
            int r2 = com.google.android.gms.internal.places.zzs.zzc(r3, r2, r7)
            long r5 = r7.zzea
            int r8 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x0290
            r5 = 1
            goto L_0x0291
        L_0x0290:
            r5 = 0
        L_0x0291:
            r11.addBoolean(r5)
            goto L_0x0282
        L_0x0295:
            if (r2 != r4) goto L_0x0299
            goto L_0x014e
        L_0x0299:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbp()
            throw r1
        L_0x029e:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.places.zzu r11 = (com.google.android.gms.internal.places.zzu) r11
            int r4 = com.google.android.gms.internal.places.zzs.zzc(r3, r4, r7)
            long r8 = r7.zzea
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x02ae
            r6 = 1
            goto L_0x02af
        L_0x02ae:
            r6 = 0
        L_0x02af:
            r11.addBoolean(r6)
        L_0x02b2:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r8 = r7.zzdz
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.places.zzs.zzc(r3, r6, r7)
            long r8 = r7.zzea
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x02c8
            r6 = 1
            goto L_0x02c9
        L_0x02c8:
            r6 = 0
        L_0x02c9:
            r11.addBoolean(r6)
            goto L_0x02b2
        L_0x02cd:
            if (r6 != r10) goto L_0x02ed
            com.google.android.gms.internal.places.zzbe r11 = (com.google.android.gms.internal.places.zzbe) r11
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r2 = r7.zzdz
            int r2 = r2 + r1
        L_0x02d8:
            if (r1 >= r2) goto L_0x02e4
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r3, r1)
            r11.zzac(r4)
            int r1 = r1 + 4
            goto L_0x02d8
        L_0x02e4:
            if (r1 != r2) goto L_0x02e8
            goto L_0x0423
        L_0x02e8:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbp()
            throw r1
        L_0x02ed:
            if (r6 != r9) goto L_0x0422
            com.google.android.gms.internal.places.zzbe r11 = (com.google.android.gms.internal.places.zzbe) r11
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r18, r19)
            r11.zzac(r1)
        L_0x02f8:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r3, r1, r7)
            int r6 = r7.zzdz
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4)
            r11.zzac(r1)
            goto L_0x02f8
        L_0x030c:
            if (r6 != r10) goto L_0x032c
            com.google.android.gms.internal.places.zzby r11 = (com.google.android.gms.internal.places.zzby) r11
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r2 = r7.zzdz
            int r2 = r2 + r1
        L_0x0317:
            if (r1 >= r2) goto L_0x0323
            long r4 = com.google.android.gms.internal.places.zzs.zzc(r3, r1)
            r11.zzm(r4)
            int r1 = r1 + 8
            goto L_0x0317
        L_0x0323:
            if (r1 != r2) goto L_0x0327
            goto L_0x0423
        L_0x0327:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbp()
            throw r1
        L_0x032c:
            if (r6 != r13) goto L_0x0422
            com.google.android.gms.internal.places.zzby r11 = (com.google.android.gms.internal.places.zzby) r11
            long r8 = com.google.android.gms.internal.places.zzs.zzc(r18, r19)
            r11.zzm(r8)
        L_0x0337:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r3, r1, r7)
            int r6 = r7.zzdz
            if (r2 != r6) goto L_0x0423
            long r8 = com.google.android.gms.internal.places.zzs.zzc(r3, r4)
            r11.zzm(r8)
            goto L_0x0337
        L_0x034b:
            if (r6 != r10) goto L_0x0353
            int r1 = com.google.android.gms.internal.places.zzs.zzb((byte[]) r3, (int) r4, (com.google.android.gms.internal.places.zzbh<?>) r11, (com.google.android.gms.internal.places.zzr) r7)
            goto L_0x0423
        L_0x0353:
            if (r6 != 0) goto L_0x0422
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = com.google.android.gms.internal.places.zzs.zzb((int) r21, (byte[]) r22, (int) r23, (int) r24, (com.google.android.gms.internal.places.zzbh<?>) r25, (com.google.android.gms.internal.places.zzr) r26)
            goto L_0x0423
        L_0x0365:
            if (r6 != r10) goto L_0x0385
            com.google.android.gms.internal.places.zzby r11 = (com.google.android.gms.internal.places.zzby) r11
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r2 = r7.zzdz
            int r2 = r2 + r1
        L_0x0370:
            if (r1 >= r2) goto L_0x037c
            int r1 = com.google.android.gms.internal.places.zzs.zzc(r3, r1, r7)
            long r4 = r7.zzea
            r11.zzm(r4)
            goto L_0x0370
        L_0x037c:
            if (r1 != r2) goto L_0x0380
            goto L_0x0423
        L_0x0380:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbp()
            throw r1
        L_0x0385:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.places.zzby r11 = (com.google.android.gms.internal.places.zzby) r11
            int r1 = com.google.android.gms.internal.places.zzs.zzc(r3, r4, r7)
            long r8 = r7.zzea
            r11.zzm(r8)
        L_0x0392:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r3, r1, r7)
            int r6 = r7.zzdz
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.places.zzs.zzc(r3, r4, r7)
            long r8 = r7.zzea
            r11.zzm(r8)
            goto L_0x0392
        L_0x03a6:
            if (r6 != r10) goto L_0x03c5
            com.google.android.gms.internal.places.zzbb r11 = (com.google.android.gms.internal.places.zzbb) r11
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r2 = r7.zzdz
            int r2 = r2 + r1
        L_0x03b1:
            if (r1 >= r2) goto L_0x03bd
            float r4 = com.google.android.gms.internal.places.zzs.zze(r3, r1)
            r11.zzf((float) r4)
            int r1 = r1 + 4
            goto L_0x03b1
        L_0x03bd:
            if (r1 != r2) goto L_0x03c0
            goto L_0x0423
        L_0x03c0:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbp()
            throw r1
        L_0x03c5:
            if (r6 != r9) goto L_0x0422
            com.google.android.gms.internal.places.zzbb r11 = (com.google.android.gms.internal.places.zzbb) r11
            float r1 = com.google.android.gms.internal.places.zzs.zze(r18, r19)
            r11.zzf((float) r1)
        L_0x03d0:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r3, r1, r7)
            int r6 = r7.zzdz
            if (r2 != r6) goto L_0x0423
            float r1 = com.google.android.gms.internal.places.zzs.zze(r3, r4)
            r11.zzf((float) r1)
            goto L_0x03d0
        L_0x03e4:
            if (r6 != r10) goto L_0x0403
            com.google.android.gms.internal.places.zzao r11 = (com.google.android.gms.internal.places.zzao) r11
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r2 = r7.zzdz
            int r2 = r2 + r1
        L_0x03ef:
            if (r1 >= r2) goto L_0x03fb
            double r4 = com.google.android.gms.internal.places.zzs.zzd(r3, r1)
            r11.zzd(r4)
            int r1 = r1 + 8
            goto L_0x03ef
        L_0x03fb:
            if (r1 != r2) goto L_0x03fe
            goto L_0x0423
        L_0x03fe:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbp()
            throw r1
        L_0x0403:
            if (r6 != r13) goto L_0x0422
            com.google.android.gms.internal.places.zzao r11 = (com.google.android.gms.internal.places.zzao) r11
            double r8 = com.google.android.gms.internal.places.zzs.zzd(r18, r19)
            r11.zzd(r8)
        L_0x040e:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r3, r1, r7)
            int r6 = r7.zzdz
            if (r2 != r6) goto L_0x0423
            double r8 = com.google.android.gms.internal.places.zzs.zzd(r3, r4)
            r11.zzd(r8)
            goto L_0x040e
        L_0x0422:
            r1 = r4
        L_0x0423:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzb(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.places.zzr):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <K, V> int zzb(T r8, byte[] r9, int r10, int r11, int r12, long r13, com.google.android.gms.internal.places.zzr r15) throws java.io.IOException {
        /*
            r7 = this;
            sun.misc.Unsafe r0 = zzkr
            java.lang.Object r12 = r7.zzag(r12)
            java.lang.Object r1 = r0.getObject(r8, r13)
            com.google.android.gms.internal.places.zzcd r2 = r7.zzli
            boolean r2 = r2.zzi(r1)
            if (r2 == 0) goto L_0x0021
            com.google.android.gms.internal.places.zzcd r2 = r7.zzli
            java.lang.Object r2 = r2.zzk(r12)
            com.google.android.gms.internal.places.zzcd r3 = r7.zzli
            r3.zzc(r2, r1)
            r0.putObject(r8, r13, r2)
            r1 = r2
        L_0x0021:
            com.google.android.gms.internal.places.zzcd r8 = r7.zzli
            com.google.android.gms.internal.places.zzcb r8 = r8.zzl(r12)
            com.google.android.gms.internal.places.zzcd r12 = r7.zzli
            java.util.Map r12 = r12.zzg(r1)
            int r10 = com.google.android.gms.internal.places.zzs.zzb(r9, r10, r15)
            int r13 = r15.zzdz
            if (r13 < 0) goto L_0x0097
            int r14 = r11 - r10
            if (r13 > r14) goto L_0x0097
            int r13 = r13 + r10
            K r14 = r8.zzkk
            V r0 = r8.zzkm
        L_0x003e:
            if (r10 >= r13) goto L_0x008c
            int r1 = r10 + 1
            byte r10 = r9[r10]
            if (r10 >= 0) goto L_0x004c
            int r1 = com.google.android.gms.internal.places.zzs.zzb((int) r10, (byte[]) r9, (int) r1, (com.google.android.gms.internal.places.zzr) r15)
            int r10 = r15.zzdz
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
            com.google.android.gms.internal.places.zzef r1 = r8.zzkl
            int r1 = r1.zzds()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.places.zzef r4 = r8.zzkl
            V r10 = r8.zzkm
            java.lang.Class r5 = r10.getClass()
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zzb((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.places.zzef) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.places.zzr) r6)
            java.lang.Object r0 = r15.zzeb
            goto L_0x003e
        L_0x0072:
            com.google.android.gms.internal.places.zzef r1 = r8.zzkj
            int r1 = r1.zzds()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.places.zzef r4 = r8.zzkj
            r5 = 0
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zzb((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.places.zzef) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.places.zzr) r6)
            java.lang.Object r14 = r15.zzeb
            goto L_0x003e
        L_0x0087:
            int r10 = com.google.android.gms.internal.places.zzs.zzb((int) r10, (byte[]) r9, (int) r2, (int) r11, (com.google.android.gms.internal.places.zzr) r15)
            goto L_0x003e
        L_0x008c:
            if (r10 != r13) goto L_0x0092
            r12.put(r14, r0)
            return r13
        L_0x0092:
            com.google.android.gms.internal.places.zzbk r8 = com.google.android.gms.internal.places.zzbk.zzbt()
            throw r8
        L_0x0097:
            com.google.android.gms.internal.places.zzbk r8 = com.google.android.gms.internal.places.zzbk.zzbp()
            goto L_0x009d
        L_0x009c:
            throw r8
        L_0x009d:
            goto L_0x009c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzb(java.lang.Object, byte[], int, int, int, long, com.google.android.gms.internal.places.zzr):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x018a, code lost:
        r2 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x019b, code lost:
        r2 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x019d, code lost:
        r12.putInt(r1, r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzb(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, com.google.android.gms.internal.places.zzr r29) throws java.io.IOException {
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
            sun.misc.Unsafe r12 = zzkr
            int[] r7 = r0.zzks
            int r13 = r6 + 2
            r7 = r7[r13]
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r13
            long r13 = (long) r7
            r7 = 5
            r15 = 2
            switch(r25) {
                case 51: goto L_0x018d;
                case 52: goto L_0x017d;
                case 53: goto L_0x016d;
                case 54: goto L_0x016d;
                case 55: goto L_0x015d;
                case 56: goto L_0x014e;
                case 57: goto L_0x0140;
                case 58: goto L_0x0127;
                case 59: goto L_0x00f3;
                case 60: goto L_0x00c5;
                case 61: goto L_0x00b8;
                case 62: goto L_0x015d;
                case 63: goto L_0x008a;
                case 64: goto L_0x0140;
                case 65: goto L_0x014e;
                case 66: goto L_0x0075;
                case 67: goto L_0x0060;
                case 68: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x01a1
        L_0x0028:
            r7 = 3
            if (r5 != r7) goto L_0x01a1
            r2 = r2 & -8
            r7 = r2 | 4
            com.google.android.gms.internal.places.zzda r2 = r0.zzaf(r6)
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r7
            r7 = r29
            int r2 = com.google.android.gms.internal.places.zzs.zzb((com.google.android.gms.internal.places.zzda) r2, (byte[]) r3, (int) r4, (int) r5, (int) r6, (com.google.android.gms.internal.places.zzr) r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004b
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004c
        L_0x004b:
            r15 = 0
        L_0x004c:
            if (r15 != 0) goto L_0x0055
            java.lang.Object r3 = r11.zzeb
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0055:
            java.lang.Object r3 = r11.zzeb
            java.lang.Object r3 = com.google.android.gms.internal.places.zzbd.zzb((java.lang.Object) r15, (java.lang.Object) r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0060:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.places.zzs.zzc(r3, r4, r11)
            long r3 = r11.zzea
            long r3 = com.google.android.gms.internal.places.zzai.zzb(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0075:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r11)
            int r3 = r11.zzdz
            int r3 = com.google.android.gms.internal.places.zzai.zzm(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x008a:
            if (r5 != 0) goto L_0x01a1
            int r3 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r11)
            int r4 = r11.zzdz
            com.google.android.gms.internal.places.zzbf r5 = r0.zzah(r6)
            if (r5 == 0) goto L_0x00ae
            boolean r5 = r5.zzad(r4)
            if (r5 == 0) goto L_0x009f
            goto L_0x00ae
        L_0x009f:
            com.google.android.gms.internal.places.zzdr r1 = zzo(r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.zzc(r2, r4)
            r2 = r3
            goto L_0x01a2
        L_0x00ae:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r2 = r3
            goto L_0x019d
        L_0x00b8:
            if (r5 != r15) goto L_0x01a1
            int r2 = com.google.android.gms.internal.places.zzs.zzf(r3, r4, r11)
            java.lang.Object r3 = r11.zzeb
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x00c5:
            if (r5 != r15) goto L_0x01a1
            com.google.android.gms.internal.places.zzda r2 = r0.zzaf(r6)
            r5 = r20
            int r2 = com.google.android.gms.internal.places.zzs.zzb((com.google.android.gms.internal.places.zzda) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.places.zzr) r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00dc
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00dd
        L_0x00dc:
            r15 = 0
        L_0x00dd:
            if (r15 != 0) goto L_0x00e5
            java.lang.Object r3 = r11.zzeb
            r12.putObject(r1, r9, r3)
            goto L_0x00ee
        L_0x00e5:
            java.lang.Object r3 = r11.zzeb
            java.lang.Object r3 = com.google.android.gms.internal.places.zzbd.zzb((java.lang.Object) r15, (java.lang.Object) r3)
            r12.putObject(r1, r9, r3)
        L_0x00ee:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x00f3:
            if (r5 != r15) goto L_0x01a1
            int r2 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r11)
            int r4 = r11.zzdz
            if (r4 != 0) goto L_0x0103
            java.lang.String r3 = ""
            r12.putObject(r1, r9, r3)
            goto L_0x0122
        L_0x0103:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x0117
            int r5 = r2 + r4
            boolean r5 = com.google.android.gms.internal.places.zzea.zzf(r3, r2, r5)
            if (r5 == 0) goto L_0x0112
            goto L_0x0117
        L_0x0112:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbu()
            throw r1
        L_0x0117:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.places.zzbd.UTF_8
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            int r2 = r2 + r4
        L_0x0122:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x0127:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.places.zzs.zzc(r3, r4, r11)
            long r3 = r11.zzea
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0137
            r15 = 1
            goto L_0x0138
        L_0x0137:
            r15 = 0
        L_0x0138:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0140:
            if (r5 != r7) goto L_0x01a1
            int r2 = com.google.android.gms.internal.places.zzs.zzb(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r12.putObject(r1, r9, r2)
            goto L_0x018a
        L_0x014e:
            r2 = 1
            if (r5 != r2) goto L_0x01a1
            long r2 = com.google.android.gms.internal.places.zzs.zzc(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r12.putObject(r1, r9, r2)
            goto L_0x019b
        L_0x015d:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r11)
            int r3 = r11.zzdz
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x016d:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.places.zzs.zzc(r3, r4, r11)
            long r3 = r11.zzea
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x017d:
            if (r5 != r7) goto L_0x01a1
            float r2 = com.google.android.gms.internal.places.zzs.zze(r18, r19)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r12.putObject(r1, r9, r2)
        L_0x018a:
            int r2 = r4 + 4
            goto L_0x019d
        L_0x018d:
            r2 = 1
            if (r5 != r2) goto L_0x01a1
            double r2 = com.google.android.gms.internal.places.zzs.zzd(r18, r19)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            r12.putObject(r1, r9, r2)
        L_0x019b:
            int r2 = r4 + 8
        L_0x019d:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x01a1:
            r2 = r4
        L_0x01a2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzb(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.android.gms.internal.places.zzr):int");
    }

    private final zzda zzaf(int i) {
        int i2 = (i / 3) << 1;
        zzda zzda = (zzda) this.zzkt[i2];
        if (zzda != null) {
            return zzda;
        }
        zzda zzf = zzcv.zzcq().zzf((Class) this.zzkt[i2 + 1]);
        this.zzkt[i2] = zzf;
        return zzf;
    }

    private final Object zzag(int i) {
        return this.zzkt[(i / 3) << 1];
    }

    private final zzbf zzah(int i) {
        return (zzbf) this.zzkt[((i / 3) << 1) + 1];
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v31, resolved type: byte} */
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
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v44, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v35, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02cc, code lost:
        r18 = r33;
        r22 = r6;
        r2 = r7;
        r6 = r8;
        r19 = r9;
        r27 = r10;
        r25 = r11;
        r7 = r35;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0372, code lost:
        if (r0 == r15) goto L_0x03e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x03bb, code lost:
        if (r0 == r15) goto L_0x03e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0094, code lost:
        r7 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x017a, code lost:
        r6 = r6 | r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0219, code lost:
        r6 = r6 | r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x021b, code lost:
        r3 = r8;
        r2 = r9;
        r1 = r11;
        r9 = r13;
        r11 = r35;
        r13 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0245, code lost:
        r33 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02bc, code lost:
        r0 = r7 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02be, code lost:
        r6 = r6 | r22;
        r7 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02c2, code lost:
        r3 = r8;
        r2 = r9;
        r1 = r11;
        r9 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02c6, code lost:
        r13 = r34;
        r11 = r35;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x03e7 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x03f8  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x043a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(T r31, byte[] r32, int r33, int r34, int r35, com.google.android.gms.internal.places.zzr r36) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r9 = r36
            sun.misc.Unsafe r10 = zzkr
            r16 = 0
            r0 = r33
            r1 = -1
            r2 = 0
            r3 = 0
            r6 = 0
            r7 = -1
        L_0x0017:
            r17 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 >= r13) goto L_0x047c
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002b
            int r0 = com.google.android.gms.internal.places.zzs.zzb((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.places.zzr) r9)
            int r3 = r9.zzdz
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
            int r1 = r15.zzq(r3, r2)
            goto L_0x003e
        L_0x003a:
            int r1 = r15.zzak(r3)
        L_0x003e:
            r2 = r1
            r1 = -1
            if (r2 != r1) goto L_0x0051
            r25 = r3
            r2 = r4
            r22 = r6
            r18 = r7
            r27 = r10
            r7 = r11
            r19 = 0
            r6 = r5
            goto L_0x03e5
        L_0x0051:
            int[] r1 = r15.zzks
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
            if (r11 > r5) goto L_0x02dc
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
                case 0: goto L_0x02a4;
                case 1: goto L_0x028a;
                case 2: goto L_0x0264;
                case 3: goto L_0x0264;
                case 4: goto L_0x0249;
                case 5: goto L_0x0224;
                case 6: goto L_0x0201;
                case 7: goto L_0x01d9;
                case 8: goto L_0x01b4;
                case 9: goto L_0x017e;
                case 10: goto L_0x0163;
                case 11: goto L_0x0249;
                case 12: goto L_0x0131;
                case 13: goto L_0x0201;
                case 14: goto L_0x0224;
                case 15: goto L_0x0116;
                case 16: goto L_0x00e9;
                case 17: goto L_0x0097;
                default: goto L_0x0088;
            }
        L_0x0088:
            r12 = r32
            r13 = r36
            r9 = r2
            r11 = r3
            r33 = r7
            r8 = r19
            r19 = -1
        L_0x0094:
            r7 = r4
            goto L_0x02cc
        L_0x0097:
            r8 = 3
            if (r0 != r8) goto L_0x00dd
            int r0 = r3 << 3
            r8 = r0 | 4
            com.google.android.gms.internal.places.zzda r0 = r15.zzaf(r2)
            r1 = r32
            r9 = r2
            r2 = r4
            r11 = r3
            r3 = r34
            r4 = r8
            r8 = r19
            r19 = -1
            r5 = r36
            int r0 = com.google.android.gms.internal.places.zzs.zzb((com.google.android.gms.internal.places.zzda) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.android.gms.internal.places.zzr) r5)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x00c0
            r5 = r36
            java.lang.Object r1 = r5.zzeb
            r10.putObject(r14, r12, r1)
            goto L_0x00cf
        L_0x00c0:
            r5 = r36
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r5.zzeb
            java.lang.Object r1 = com.google.android.gms.internal.places.zzbd.zzb((java.lang.Object) r1, (java.lang.Object) r2)
            r10.putObject(r14, r12, r1)
        L_0x00cf:
            r6 = r6 | r22
            r12 = r32
            r13 = r34
            r3 = r8
            r2 = r9
            r1 = r11
            r11 = r35
            r9 = r5
            goto L_0x0017
        L_0x00dd:
            r9 = r2
            r11 = r3
            r8 = r19
            r19 = -1
            r12 = r32
            r13 = r36
            goto L_0x0245
        L_0x00e9:
            r5 = r36
            r9 = r2
            r11 = r3
            r8 = r19
            r19 = -1
            if (r0 != 0) goto L_0x0111
            r2 = r12
            r12 = r32
            int r13 = com.google.android.gms.internal.places.zzs.zzc(r12, r4, r5)
            long r0 = r5.zzea
            long r17 = com.google.android.gms.internal.places.zzai.zzb(r0)
            r0 = r10
            r1 = r31
            r33 = r13
            r13 = r5
            r4 = r17
            r0.putLong(r1, r2, r4)
            r6 = r6 | r22
            r0 = r33
            goto L_0x02c2
        L_0x0111:
            r12 = r32
            r13 = r5
            goto L_0x0245
        L_0x0116:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r19 = -1
            r12 = r32
            r13 = r36
            if (r0 != 0) goto L_0x0245
            int r0 = com.google.android.gms.internal.places.zzs.zzb(r12, r4, r13)
            int r1 = r13.zzdz
            int r1 = com.google.android.gms.internal.places.zzai.zzm(r1)
            r10.putInt(r14, r2, r1)
            goto L_0x017a
        L_0x0131:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r19 = -1
            r12 = r32
            r13 = r36
            if (r0 != 0) goto L_0x0245
            int r0 = com.google.android.gms.internal.places.zzs.zzb(r12, r4, r13)
            int r1 = r13.zzdz
            com.google.android.gms.internal.places.zzbf r4 = r15.zzah(r9)
            if (r4 == 0) goto L_0x015f
            boolean r4 = r4.zzad(r1)
            if (r4 == 0) goto L_0x0151
            goto L_0x015f
        L_0x0151:
            com.google.android.gms.internal.places.zzdr r2 = zzo(r31)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzc(r8, r1)
            goto L_0x02c2
        L_0x015f:
            r10.putInt(r14, r2, r1)
            goto L_0x017a
        L_0x0163:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r19 = -1
            r12 = r32
            r13 = r36
            if (r0 != r1) goto L_0x0245
            int r0 = com.google.android.gms.internal.places.zzs.zzf(r12, r4, r13)
            java.lang.Object r1 = r13.zzeb
            r10.putObject(r14, r2, r1)
        L_0x017a:
            r6 = r6 | r22
            goto L_0x02c2
        L_0x017e:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r19 = -1
            r12 = r32
            r13 = r36
            if (r0 != r1) goto L_0x01b0
            com.google.android.gms.internal.places.zzda r0 = r15.zzaf(r9)
            r5 = r34
            int r0 = com.google.android.gms.internal.places.zzs.zzb((com.google.android.gms.internal.places.zzda) r0, (byte[]) r12, (int) r4, (int) r5, (com.google.android.gms.internal.places.zzr) r13)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x01a1
            java.lang.Object r1 = r13.zzeb
            r10.putObject(r14, r2, r1)
            goto L_0x0219
        L_0x01a1:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r13.zzeb
            java.lang.Object r1 = com.google.android.gms.internal.places.zzbd.zzb((java.lang.Object) r1, (java.lang.Object) r4)
            r10.putObject(r14, r2, r1)
            goto L_0x0219
        L_0x01b0:
            r5 = r34
            goto L_0x0245
        L_0x01b4:
            r5 = r34
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r19 = -1
            r12 = r32
            r13 = r36
            if (r0 != r1) goto L_0x0245
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r20 & r0
            if (r0 != 0) goto L_0x01cf
            int r0 = com.google.android.gms.internal.places.zzs.zzd(r12, r4, r13)
            goto L_0x01d3
        L_0x01cf:
            int r0 = com.google.android.gms.internal.places.zzs.zze(r12, r4, r13)
        L_0x01d3:
            java.lang.Object r1 = r13.zzeb
            r10.putObject(r14, r2, r1)
            goto L_0x0219
        L_0x01d9:
            r5 = r34
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r19 = -1
            r12 = r32
            r13 = r36
            if (r0 != 0) goto L_0x0245
            int r0 = com.google.android.gms.internal.places.zzs.zzc(r12, r4, r13)
            r33 = r0
            long r0 = r13.zzea
            r20 = 0
            int r4 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r4 == 0) goto L_0x01f8
            r0 = 1
            goto L_0x01f9
        L_0x01f8:
            r0 = 0
        L_0x01f9:
            com.google.android.gms.internal.places.zzdy.zzb((java.lang.Object) r14, (long) r2, (boolean) r0)
            r6 = r6 | r22
            r0 = r33
            goto L_0x021b
        L_0x0201:
            r5 = r34
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r19 = -1
            r12 = r32
            r13 = r36
            if (r0 != r1) goto L_0x0245
            int r0 = com.google.android.gms.internal.places.zzs.zzb(r12, r4)
            r10.putInt(r14, r2, r0)
            int r0 = r4 + 4
        L_0x0219:
            r6 = r6 | r22
        L_0x021b:
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r11 = r35
            r13 = r5
            goto L_0x0017
        L_0x0224:
            r5 = r34
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 1
            r19 = -1
            r12 = r32
            r13 = r36
            if (r0 != r1) goto L_0x0245
            long r17 = com.google.android.gms.internal.places.zzs.zzc(r12, r4)
            r0 = r10
            r1 = r31
            r33 = r7
            r7 = r4
            r4 = r17
            r0.putLong(r1, r2, r4)
            goto L_0x02bc
        L_0x0245:
            r33 = r7
            goto L_0x0094
        L_0x0249:
            r9 = r2
            r11 = r3
            r33 = r7
            r2 = r12
            r8 = r19
            r19 = -1
            r12 = r32
            r13 = r36
            r7 = r4
            if (r0 != 0) goto L_0x02cc
            int r0 = com.google.android.gms.internal.places.zzs.zzb(r12, r7, r13)
            int r1 = r13.zzdz
            r10.putInt(r14, r2, r1)
            goto L_0x02be
        L_0x0264:
            r9 = r2
            r11 = r3
            r33 = r7
            r2 = r12
            r8 = r19
            r19 = -1
            r12 = r32
            r13 = r36
            r7 = r4
            if (r0 != 0) goto L_0x02cc
            int r7 = com.google.android.gms.internal.places.zzs.zzc(r12, r7, r13)
            long r4 = r13.zzea
            r0 = r10
            r1 = r31
            r0.putLong(r1, r2, r4)
            r6 = r6 | r22
            r0 = r7
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r7 = r33
            goto L_0x02c6
        L_0x028a:
            r9 = r2
            r11 = r3
            r33 = r7
            r2 = r12
            r8 = r19
            r19 = -1
            r12 = r32
            r13 = r36
            r7 = r4
            if (r0 != r1) goto L_0x02cc
            float r0 = com.google.android.gms.internal.places.zzs.zze(r12, r7)
            com.google.android.gms.internal.places.zzdy.zzb((java.lang.Object) r14, (long) r2, (float) r0)
            int r0 = r7 + 4
            goto L_0x02be
        L_0x02a4:
            r9 = r2
            r11 = r3
            r33 = r7
            r2 = r12
            r8 = r19
            r1 = 1
            r19 = -1
            r12 = r32
            r13 = r36
            r7 = r4
            if (r0 != r1) goto L_0x02cc
            double r0 = com.google.android.gms.internal.places.zzs.zzd(r12, r7)
            com.google.android.gms.internal.places.zzdy.zzb((java.lang.Object) r14, (long) r2, (double) r0)
        L_0x02bc:
            int r0 = r7 + 8
        L_0x02be:
            r6 = r6 | r22
            r7 = r33
        L_0x02c2:
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
        L_0x02c6:
            r13 = r34
            r11 = r35
            goto L_0x0017
        L_0x02cc:
            r18 = r33
            r22 = r6
            r2 = r7
            r6 = r8
            r19 = r9
            r27 = r10
            r25 = r11
            r7 = r35
            goto L_0x03e5
        L_0x02dc:
            r5 = r3
            r18 = r7
            r8 = r19
            r19 = -1
            r7 = r4
            r28 = r12
            r12 = r32
            r13 = r9
            r9 = r2
            r2 = r28
            r1 = 27
            if (r11 != r1) goto L_0x0341
            r1 = 2
            if (r0 != r1) goto L_0x0334
            java.lang.Object r0 = r10.getObject(r14, r2)
            com.google.android.gms.internal.places.zzbh r0 = (com.google.android.gms.internal.places.zzbh) r0
            boolean r1 = r0.zzaa()
            if (r1 != 0) goto L_0x0311
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0308
            r1 = 10
            goto L_0x030a
        L_0x0308:
            int r1 = r1 << 1
        L_0x030a:
            com.google.android.gms.internal.places.zzbh r0 = r0.zzh(r1)
            r10.putObject(r14, r2, r0)
        L_0x0311:
            r11 = r0
            com.google.android.gms.internal.places.zzda r0 = r15.zzaf(r9)
            r1 = r8
            r2 = r32
            r3 = r7
            r4 = r34
            r7 = r5
            r5 = r11
            r22 = r6
            r6 = r36
            int r0 = com.google.android.gms.internal.places.zzs.zzb(r0, r1, r2, r3, r4, r5, r6)
            r11 = r35
            r1 = r7
            r3 = r8
            r2 = r9
            r9 = r13
            r7 = r18
            r6 = r22
            r13 = r34
            goto L_0x0017
        L_0x0334:
            r22 = r6
            r25 = r5
            r15 = r7
            r26 = r8
            r19 = r9
            r27 = r10
            goto L_0x03be
        L_0x0341:
            r22 = r6
            r6 = r5
            r1 = 49
            if (r11 > r1) goto L_0x0390
            r5 = r20
            long r4 = (long) r5
            r1 = r0
            r0 = r30
            r33 = r1
            r1 = r31
            r23 = r2
            r2 = r32
            r3 = r7
            r20 = r4
            r4 = r34
            r5 = r8
            r25 = r6
            r15 = r7
            r7 = r33
            r26 = r8
            r8 = r9
            r19 = r9
            r27 = r10
            r9 = r20
            r12 = r23
            r14 = r36
            int r0 = r0.zzb(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.places.zzr) r14)
            if (r0 != r15) goto L_0x0376
            goto L_0x03e1
        L_0x0376:
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r9 = r36
            r7 = r18
            r2 = r19
            r6 = r22
            r1 = r25
            r3 = r26
        L_0x038c:
            r10 = r27
            goto L_0x0017
        L_0x0390:
            r33 = r0
            r23 = r2
            r25 = r6
            r15 = r7
            r26 = r8
            r19 = r9
            r27 = r10
            r5 = r20
            r0 = 50
            if (r11 != r0) goto L_0x03c4
            r7 = r33
            r0 = 2
            if (r7 != r0) goto L_0x03be
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r19
            r6 = r23
            r8 = r36
            int r0 = r0.zzb(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.places.zzr) r8)
            if (r0 != r15) goto L_0x0376
            goto L_0x03e1
        L_0x03be:
            r7 = r35
            r2 = r15
        L_0x03c1:
            r6 = r26
            goto L_0x03e5
        L_0x03c4:
            r7 = r33
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r8 = r5
            r5 = r26
            r6 = r25
            r9 = r11
            r10 = r23
            r12 = r19
            r13 = r36
            int r0 = r0.zzb(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.places.zzr) r13)
            if (r0 != r15) goto L_0x0462
        L_0x03e1:
            r7 = r35
            r2 = r0
            goto L_0x03c1
        L_0x03e5:
            if (r6 != r7) goto L_0x03f2
            if (r7 != 0) goto L_0x03ea
            goto L_0x03f2
        L_0x03ea:
            r8 = r30
            r11 = r31
            r9 = r2
            r10 = r6
            goto L_0x0487
        L_0x03f2:
            r8 = r30
            boolean r0 = r8.zzkx
            if (r0 == 0) goto L_0x043a
            r9 = r36
            com.google.android.gms.internal.places.zzap r0 = r9.zzec
            com.google.android.gms.internal.places.zzap r1 = com.google.android.gms.internal.places.zzap.zzao()
            if (r0 == r1) goto L_0x0437
            com.google.android.gms.internal.places.zzck r0 = r8.zzkw
            com.google.android.gms.internal.places.zzap r1 = r9.zzec
            r10 = r25
            com.google.android.gms.internal.places.zzbc$zzf r0 = r1.zzb(r0, r10)
            if (r0 != 0) goto L_0x0427
            com.google.android.gms.internal.places.zzdr r4 = zzo(r31)
            r0 = r6
            r1 = r32
            r3 = r34
            r5 = r36
            int r0 = com.google.android.gms.internal.places.zzs.zzb((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.places.zzdr) r4, (com.google.android.gms.internal.places.zzr) r5)
            r14 = r31
            r12 = r32
            r13 = r34
            r3 = r6
            r11 = r7
            r15 = r8
            goto L_0x0473
        L_0x0427:
            r11 = r31
            r0 = r11
            com.google.android.gms.internal.places.zzbc$zzc r0 = (com.google.android.gms.internal.places.zzbc.zzc) r0
            r0.zzbm()
            com.google.android.gms.internal.places.zzav<java.lang.Object> r0 = r0.zzik
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        L_0x0437:
            r11 = r31
            goto L_0x043e
        L_0x043a:
            r11 = r31
            r9 = r36
        L_0x043e:
            r10 = r25
            com.google.android.gms.internal.places.zzdr r4 = zzo(r31)
            r0 = r6
            r1 = r32
            r3 = r34
            r5 = r36
            int r0 = com.google.android.gms.internal.places.zzs.zzb((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.places.zzdr) r4, (com.google.android.gms.internal.places.zzr) r5)
            r12 = r32
            r13 = r34
            r3 = r6
            r15 = r8
            r1 = r10
            r14 = r11
            r2 = r19
            r6 = r22
            r10 = r27
            r11 = r7
            r7 = r18
            goto L_0x0017
        L_0x0462:
            r10 = r25
            r6 = r26
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r9 = r36
            r3 = r6
        L_0x0473:
            r1 = r10
            r7 = r18
            r2 = r19
            r6 = r22
            goto L_0x038c
        L_0x047c:
            r22 = r6
            r18 = r7
            r27 = r10
            r7 = r11
            r11 = r14
            r8 = r15
            r9 = r0
            r10 = r3
        L_0x0487:
            r0 = r18
            r1 = r22
            r2 = -1
            if (r0 == r2) goto L_0x0494
            long r2 = (long) r0
            r0 = r27
            r0.putInt(r11, r2, r1)
        L_0x0494:
            r0 = 0
            int r1 = r8.zzlc
            r5 = r0
            r12 = r1
        L_0x0499:
            int r0 = r8.zzld
            if (r12 >= r0) goto L_0x04cd
            int[] r0 = r8.zzlb
            r1 = r0[r12]
            com.google.android.gms.internal.places.zzds<?, ?> r6 = r8.zzlg
            int[] r0 = r8.zzks
            r2 = r0[r1]
            int r0 = r8.zzai(r1)
            r0 = r0 & r17
            long r3 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.places.zzdy.zzp(r11, r3)
            if (r0 != 0) goto L_0x04b5
            goto L_0x04c8
        L_0x04b5:
            com.google.android.gms.internal.places.zzbf r4 = r8.zzah(r1)
            if (r4 != 0) goto L_0x04bc
            goto L_0x04c8
        L_0x04bc:
            com.google.android.gms.internal.places.zzcd r3 = r8.zzli
            java.util.Map r3 = r3.zzg(r0)
            r0 = r30
            java.lang.Object r5 = r0.zzb((int) r1, (int) r2, r3, (com.google.android.gms.internal.places.zzbf) r4, r5, r6)
        L_0x04c8:
            com.google.android.gms.internal.places.zzdr r5 = (com.google.android.gms.internal.places.zzdr) r5
            int r12 = r12 + 1
            goto L_0x0499
        L_0x04cd:
            if (r5 == 0) goto L_0x04d4
            com.google.android.gms.internal.places.zzds<?, ?> r0 = r8.zzlg
            r0.zzg(r11, r5)
        L_0x04d4:
            if (r7 != 0) goto L_0x04e0
            r0 = r34
            if (r9 != r0) goto L_0x04db
            goto L_0x04e6
        L_0x04db:
            com.google.android.gms.internal.places.zzbk r0 = com.google.android.gms.internal.places.zzbk.zzbt()
            throw r0
        L_0x04e0:
            r0 = r34
            if (r9 > r0) goto L_0x04e7
            if (r10 != r7) goto L_0x04e7
        L_0x04e6:
            return r9
        L_0x04e7:
            com.google.android.gms.internal.places.zzbk r0 = com.google.android.gms.internal.places.zzbk.zzbt()
            goto L_0x04ed
        L_0x04ec:
            throw r0
        L_0x04ed:
            goto L_0x04ec
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzb(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.places.zzr):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010b, code lost:
        r2 = r4;
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x013d, code lost:
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0159, code lost:
        r0 = r8 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x015b, code lost:
        r1 = r7;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x015f, code lost:
        r24 = r7;
        r15 = r8;
        r18 = r9;
        r19 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01e2, code lost:
        if (r0 == r15) goto L_0x0230;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x020f, code lost:
        if (r0 == r15) goto L_0x0230;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x022e, code lost:
        if (r0 == r15) goto L_0x0230;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(T r28, byte[] r29, int r30, int r31, com.google.android.gms.internal.places.zzr r32) throws java.io.IOException {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            boolean r0 = r15.zzkz
            if (r0 == 0) goto L_0x025d
            sun.misc.Unsafe r9 = zzkr
            r10 = -1
            r16 = 0
            r0 = r30
            r1 = -1
            r2 = 0
        L_0x0017:
            if (r0 >= r13) goto L_0x0254
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0029
            int r0 = com.google.android.gms.internal.places.zzs.zzb((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.places.zzr) r11)
            int r3 = r11.zzdz
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
            int r0 = r15.zzq(r7, r2)
            goto L_0x003d
        L_0x0039:
            int r0 = r15.zzak(r7)
        L_0x003d:
            r4 = r0
            if (r4 != r10) goto L_0x004b
            r24 = r7
            r2 = r8
            r18 = r9
            r19 = 0
            r26 = -1
            goto L_0x0231
        L_0x004b:
            int[] r0 = r15.zzks
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
            if (r3 > r0) goto L_0x0167
            r0 = 1
            switch(r3) {
                case 0: goto L_0x014e;
                case 1: goto L_0x013f;
                case 2: goto L_0x012d;
                case 3: goto L_0x012d;
                case 4: goto L_0x011f;
                case 5: goto L_0x010f;
                case 6: goto L_0x00fe;
                case 7: goto L_0x00e8;
                case 8: goto L_0x00d1;
                case 9: goto L_0x00b0;
                case 10: goto L_0x00a3;
                case 11: goto L_0x011f;
                case 12: goto L_0x0094;
                case 13: goto L_0x00fe;
                case 14: goto L_0x010f;
                case 15: goto L_0x0081;
                case 16: goto L_0x0066;
                default: goto L_0x0064;
            }
        L_0x0064:
            goto L_0x01a4
        L_0x0066:
            if (r6 != 0) goto L_0x01a4
            int r6 = com.google.android.gms.internal.places.zzs.zzc(r12, r8, r11)
            r19 = r1
            long r0 = r11.zzea
            long r21 = com.google.android.gms.internal.places.zzai.zzb(r0)
            r0 = r9
            r2 = r19
            r1 = r28
            r10 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            goto L_0x013d
        L_0x0081:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015f
            int r0 = com.google.android.gms.internal.places.zzs.zzb(r12, r8, r11)
            int r1 = r11.zzdz
            int r1 = com.google.android.gms.internal.places.zzai.zzm(r1)
            r9.putInt(r14, r2, r1)
            goto L_0x015b
        L_0x0094:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015f
            int r0 = com.google.android.gms.internal.places.zzs.zzb(r12, r8, r11)
            int r1 = r11.zzdz
            r9.putInt(r14, r2, r1)
            goto L_0x015b
        L_0x00a3:
            r2 = r1
            if (r6 != r10) goto L_0x01a4
            int r0 = com.google.android.gms.internal.places.zzs.zzf(r12, r8, r11)
            java.lang.Object r1 = r11.zzeb
            r9.putObject(r14, r2, r1)
            goto L_0x010b
        L_0x00b0:
            r2 = r1
            if (r6 != r10) goto L_0x01a4
            com.google.android.gms.internal.places.zzda r0 = r15.zzaf(r4)
            int r0 = com.google.android.gms.internal.places.zzs.zzb((com.google.android.gms.internal.places.zzda) r0, (byte[]) r12, (int) r8, (int) r13, (com.google.android.gms.internal.places.zzr) r11)
            java.lang.Object r1 = r9.getObject(r14, r2)
            if (r1 != 0) goto L_0x00c7
            java.lang.Object r1 = r11.zzeb
            r9.putObject(r14, r2, r1)
            goto L_0x010b
        L_0x00c7:
            java.lang.Object r5 = r11.zzeb
            java.lang.Object r1 = com.google.android.gms.internal.places.zzbd.zzb((java.lang.Object) r1, (java.lang.Object) r5)
            r9.putObject(r14, r2, r1)
            goto L_0x010b
        L_0x00d1:
            r2 = r1
            if (r6 != r10) goto L_0x01a4
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r5
            if (r0 != 0) goto L_0x00de
            int r0 = com.google.android.gms.internal.places.zzs.zzd(r12, r8, r11)
            goto L_0x00e2
        L_0x00de:
            int r0 = com.google.android.gms.internal.places.zzs.zze(r12, r8, r11)
        L_0x00e2:
            java.lang.Object r1 = r11.zzeb
            r9.putObject(r14, r2, r1)
            goto L_0x010b
        L_0x00e8:
            r2 = r1
            if (r6 != 0) goto L_0x01a4
            int r1 = com.google.android.gms.internal.places.zzs.zzc(r12, r8, r11)
            long r5 = r11.zzea
            r19 = 0
            int r8 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r8 == 0) goto L_0x00f8
            goto L_0x00f9
        L_0x00f8:
            r0 = 0
        L_0x00f9:
            com.google.android.gms.internal.places.zzdy.zzb((java.lang.Object) r14, (long) r2, (boolean) r0)
            r0 = r1
            goto L_0x010b
        L_0x00fe:
            r2 = r1
            r0 = 5
            if (r6 != r0) goto L_0x01a4
            int r0 = com.google.android.gms.internal.places.zzs.zzb(r12, r8)
            r9.putInt(r14, r2, r0)
            int r0 = r8 + 4
        L_0x010b:
            r2 = r4
            r1 = r7
            goto L_0x0251
        L_0x010f:
            r2 = r1
            if (r6 != r0) goto L_0x01a4
            long r5 = com.google.android.gms.internal.places.zzs.zzc(r12, r8)
            r0 = r9
            r1 = r28
            r10 = r4
            r4 = r5
            r0.putLong(r1, r2, r4)
            goto L_0x0159
        L_0x011f:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015f
            int r0 = com.google.android.gms.internal.places.zzs.zzb(r12, r8, r11)
            int r1 = r11.zzdz
            r9.putInt(r14, r2, r1)
            goto L_0x015b
        L_0x012d:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015f
            int r6 = com.google.android.gms.internal.places.zzs.zzc(r12, r8, r11)
            long r4 = r11.zzea
            r0 = r9
            r1 = r28
            r0.putLong(r1, r2, r4)
        L_0x013d:
            r0 = r6
            goto L_0x015b
        L_0x013f:
            r2 = r1
            r10 = r4
            r0 = 5
            if (r6 != r0) goto L_0x015f
            float r0 = com.google.android.gms.internal.places.zzs.zze(r12, r8)
            com.google.android.gms.internal.places.zzdy.zzb((java.lang.Object) r14, (long) r2, (float) r0)
            int r0 = r8 + 4
            goto L_0x015b
        L_0x014e:
            r2 = r1
            r10 = r4
            if (r6 != r0) goto L_0x015f
            double r0 = com.google.android.gms.internal.places.zzs.zzd(r12, r8)
            com.google.android.gms.internal.places.zzdy.zzb((java.lang.Object) r14, (long) r2, (double) r0)
        L_0x0159:
            int r0 = r8 + 8
        L_0x015b:
            r1 = r7
            r2 = r10
            goto L_0x0251
        L_0x015f:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            goto L_0x01ab
        L_0x0167:
            r0 = 27
            if (r3 != r0) goto L_0x01af
            if (r6 != r10) goto L_0x01a4
            java.lang.Object r0 = r9.getObject(r14, r1)
            com.google.android.gms.internal.places.zzbh r0 = (com.google.android.gms.internal.places.zzbh) r0
            boolean r3 = r0.zzaa()
            if (r3 != 0) goto L_0x018b
            int r3 = r0.size()
            if (r3 != 0) goto L_0x0182
            r3 = 10
            goto L_0x0184
        L_0x0182:
            int r3 = r3 << 1
        L_0x0184:
            com.google.android.gms.internal.places.zzbh r0 = r0.zzh(r3)
            r9.putObject(r14, r1, r0)
        L_0x018b:
            r5 = r0
            com.google.android.gms.internal.places.zzda r0 = r15.zzaf(r4)
            r1 = r17
            r2 = r29
            r3 = r8
            r19 = r4
            r4 = r31
            r6 = r32
            int r0 = com.google.android.gms.internal.places.zzs.zzb(r0, r1, r2, r3, r4, r5, r6)
            r1 = r7
            r2 = r19
            goto L_0x0251
        L_0x01a4:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
        L_0x01ab:
            r26 = -1
            goto L_0x0212
        L_0x01af:
            r19 = r4
            r0 = 49
            if (r3 > r0) goto L_0x01e5
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
            int r0 = r0.zzb(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.places.zzr) r14)
            if (r0 != r15) goto L_0x0241
            goto L_0x0230
        L_0x01e5:
            r20 = r1
            r25 = r3
            r30 = r6
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            r0 = 50
            r9 = r25
            if (r9 != r0) goto L_0x0214
            r7 = r30
            if (r7 != r10) goto L_0x0212
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r19
            r6 = r20
            r8 = r32
            int r0 = r0.zzb(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.places.zzr) r8)
            if (r0 != r15) goto L_0x0241
            goto L_0x0230
        L_0x0212:
            r2 = r15
            goto L_0x0231
        L_0x0214:
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
            int r0 = r0.zzb(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.places.zzr) r13)
            if (r0 != r15) goto L_0x0241
        L_0x0230:
            r2 = r0
        L_0x0231:
            com.google.android.gms.internal.places.zzdr r4 = zzo(r28)
            r0 = r17
            r1 = r29
            r3 = r31
            r5 = r32
            int r0 = com.google.android.gms.internal.places.zzs.zzb((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.places.zzdr) r4, (com.google.android.gms.internal.places.zzr) r5)
        L_0x0241:
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r18
            r2 = r19
            r1 = r24
        L_0x0251:
            r10 = -1
            goto L_0x0017
        L_0x0254:
            r4 = r13
            if (r0 != r4) goto L_0x0258
            return
        L_0x0258:
            com.google.android.gms.internal.places.zzbk r0 = com.google.android.gms.internal.places.zzbk.zzbt()
            throw r0
        L_0x025d:
            r4 = r13
            r5 = 0
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r6 = r32
            r0.zzb(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (com.google.android.gms.internal.places.zzr) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzb(java.lang.Object, byte[], int, int, com.google.android.gms.internal.places.zzr):void");
    }

    public final void zzd(T t) {
        int i;
        int i2 = this.zzlc;
        while (true) {
            i = this.zzld;
            if (i2 >= i) {
                break;
            }
            long zzai = (long) (zzai(this.zzlb[i2]) & 1048575);
            Object zzp = zzdy.zzp(t, zzai);
            if (zzp != null) {
                zzdy.zzb((Object) t, zzai, this.zzli.zzj(zzp));
            }
            i2++;
        }
        int length = this.zzlb.length;
        while (i < length) {
            this.zzlf.zzb(t, (long) this.zzlb[i]);
            i++;
        }
        this.zzlg.zzd(t);
        if (this.zzkx) {
            this.zzlh.zzd(t);
        }
    }

    private final <K, V, UT, UB> UB zzb(int i, int i2, Map<K, V> map, zzbf zzbf, UB ub, zzds<UT, UB> zzds) {
        zzcb<?, ?> zzl = this.zzli.zzl(zzag(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!zzbf.zzad(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzds.zzdk();
                }
                zzae zzk = zzw.zzk(zzcc.zzb(zzl, next.getKey(), next.getValue()));
                try {
                    zzcc.zzb(zzk.zzai(), zzl, next.getKey(), next.getValue());
                    zzds.zzb(ub, i2, zzk.zzah());
                    it.remove();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return ub;
    }

    public final boolean zzp(T t) {
        int i;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= this.zzlc) {
                return !this.zzkx || this.zzlh.zzb((Object) t).isInitialized();
            }
            int i5 = this.zzlb[i2];
            int i6 = this.zzks[i5];
            int zzai = zzai(i5);
            if (!this.zzkz) {
                int i7 = this.zzks[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i3) {
                    i4 = zzkr.getInt(t, (long) i8);
                    i3 = i8;
                }
            } else {
                i = 0;
            }
            if (((268435456 & zzai) != 0) && !zzb(t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & zzai) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (zzb(t, i6, i5) && !zzb((Object) t, zzai, zzaf(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzh = this.zzli.zzh(zzdy.zzp(t, (long) (zzai & 1048575)));
                            if (!zzh.isEmpty()) {
                                if (this.zzli.zzl(zzag(i5)).zzkl.zzdr() == zzem.MESSAGE) {
                                    zzda<?> zzda = null;
                                    Iterator<?> it = zzh.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzda == null) {
                                            zzda = zzcv.zzcq().zzf(next.getClass());
                                        }
                                        if (!zzda.zzp(next)) {
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
                List list = (List) zzdy.zzp(t, (long) (zzai & 1048575));
                if (!list.isEmpty()) {
                    zzda zzaf = zzaf(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!zzaf.zzp(list.get(i10))) {
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
            } else if (zzb(t, i5, i4, i) && !zzb((Object) t, zzai, zzaf(i5))) {
                return false;
            }
            i2++;
        }
    }

    private static boolean zzb(Object obj, int i, zzda zzda) {
        return zzda.zzp(zzdy.zzp(obj, (long) (i & 1048575)));
    }

    private static void zzb(int i, Object obj, zzel zzel) throws IOException {
        if (obj instanceof String) {
            zzel.zzb(i, (String) obj);
        } else {
            zzel.zzb(i, (zzw) obj);
        }
    }

    private final int zzai(int i) {
        return this.zzks[i + 1];
    }

    private final int zzaj(int i) {
        return this.zzks[i + 2];
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zzdy.zzp(t, j)).doubleValue();
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zzdy.zzp(t, j)).floatValue();
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zzdy.zzp(t, j)).intValue();
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zzdy.zzp(t, j)).longValue();
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zzdy.zzp(t, j)).booleanValue();
    }

    private final boolean zzd(T t, T t2, int i) {
        return zzb(t, i) == zzb(t2, i);
    }

    private final boolean zzb(T t, int i, int i2, int i3) {
        if (this.zzkz) {
            return zzb(t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zzb(T t, int i) {
        if (this.zzkz) {
            int zzai = zzai(i);
            long j = (long) (zzai & 1048575);
            switch ((zzai & 267386880) >>> 20) {
                case 0:
                    return zzdy.zzo(t, j) != 0.0d;
                case 1:
                    return zzdy.zzn(t, j) != BitmapDescriptorFactory.HUE_RED;
                case 2:
                    return zzdy.zzl(t, j) != 0;
                case 3:
                    return zzdy.zzl(t, j) != 0;
                case 4:
                    return zzdy.zzk(t, j) != 0;
                case 5:
                    return zzdy.zzl(t, j) != 0;
                case 6:
                    return zzdy.zzk(t, j) != 0;
                case 7:
                    return zzdy.zzm(t, j);
                case 8:
                    Object zzp = zzdy.zzp(t, j);
                    if (zzp instanceof String) {
                        return !((String) zzp).isEmpty();
                    }
                    if (zzp instanceof zzw) {
                        return !zzw.zzeg.equals(zzp);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzdy.zzp(t, j) != null;
                case 10:
                    return !zzw.zzeg.equals(zzdy.zzp(t, j));
                case 11:
                    return zzdy.zzk(t, j) != 0;
                case 12:
                    return zzdy.zzk(t, j) != 0;
                case 13:
                    return zzdy.zzk(t, j) != 0;
                case 14:
                    return zzdy.zzl(t, j) != 0;
                case 15:
                    return zzdy.zzk(t, j) != 0;
                case 16:
                    return zzdy.zzl(t, j) != 0;
                case 17:
                    return zzdy.zzp(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzaj = zzaj(i);
            return (zzdy.zzk(t, (long) (zzaj & 1048575)) & (1 << (zzaj >>> 20))) != 0;
        }
    }

    private final void zzc(T t, int i) {
        if (!this.zzkz) {
            int zzaj = zzaj(i);
            long j = (long) (zzaj & 1048575);
            zzdy.zzb((Object) t, j, zzdy.zzk(t, j) | (1 << (zzaj >>> 20)));
        }
    }

    private final boolean zzb(T t, int i, int i2) {
        return zzdy.zzk(t, (long) (zzaj(i2) & 1048575)) == i;
    }

    private final void zzc(T t, int i, int i2) {
        zzdy.zzb((Object) t, (long) (zzaj(i2) & 1048575), i);
    }

    private final int zzak(int i) {
        if (i < this.zzku || i > this.zzkv) {
            return -1;
        }
        return zzr(i, 0);
    }

    private final int zzq(int i, int i2) {
        if (i < this.zzku || i > this.zzkv) {
            return -1;
        }
        return zzr(i, i2);
    }

    private final int zzr(int i, int i2) {
        int length = (this.zzks.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzks[i4];
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
}
