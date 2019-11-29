package com.google.android.libraries.places.internal;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;
import tencent.tls.platform.SigType;

final class md<T> implements mp<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f12955a = new int[0];

    /* renamed from: b  reason: collision with root package name */
    private static final Unsafe f12956b = nk.a();

    /* renamed from: c  reason: collision with root package name */
    private final int[] f12957c;

    /* renamed from: d  reason: collision with root package name */
    private final Object[] f12958d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12959e;

    /* renamed from: f  reason: collision with root package name */
    private final int f12960f;

    /* renamed from: g  reason: collision with root package name */
    private final ma f12961g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final int[] l;
    private final int m;
    private final int n;
    private final mg o;
    private final lm p;
    private final nf<?, ?> q;
    private final kn<?> r;
    private final lw s;

    private md(int[] iArr, Object[] objArr, int i2, int i3, ma maVar, boolean z, boolean z2, int[] iArr2, int i4, int i5, mg mgVar, lm lmVar, nf<?, ?> nfVar, kn<?> knVar, lw lwVar) {
        this.f12957c = iArr;
        this.f12958d = objArr;
        this.f12959e = i2;
        this.f12960f = i3;
        this.i = maVar instanceof kv;
        this.j = z;
        this.h = knVar != null && knVar.a(maVar);
        this.k = z2;
        this.l = iArr2;
        this.m = i4;
        this.n = i5;
        this.o = mgVar;
        this.p = lmVar;
        this.q = nfVar;
        this.r = knVar;
        this.f12961g = maVar;
        this.s = lwVar;
    }

    static <T> md<T> a(ly lyVar, mg mgVar, lm lmVar, nf<?, ?> nfVar, kn<?> knVar, lw lwVar) {
        int i2;
        int i3;
        char c2;
        int[] iArr;
        char c3;
        char c4;
        int i4;
        char c5;
        char c6;
        int i5;
        int i6;
        int i7;
        mo moVar;
        char c7;
        String str;
        int i8;
        int i9;
        int i10;
        int i11;
        Field field;
        char charAt;
        int i12;
        char c8;
        Field field2;
        Field field3;
        int i13;
        char charAt2;
        int i14;
        char charAt3;
        int i15;
        char charAt4;
        int i16;
        char c9;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        char charAt5;
        int i22;
        char charAt6;
        int i23;
        char charAt7;
        int i24;
        char charAt8;
        char charAt9;
        char charAt10;
        char charAt11;
        char charAt12;
        char charAt13;
        char charAt14;
        ly lyVar2 = lyVar;
        if (lyVar2 instanceof mo) {
            mo moVar2 = (mo) lyVar2;
            char c10 = 0;
            boolean z = moVar2.a() == ml.f12969b;
            String str2 = moVar2.f12977b;
            int length = str2.length();
            char charAt15 = str2.charAt(0);
            if (charAt15 >= 55296) {
                char c11 = charAt15 & 8191;
                int i25 = 1;
                int i26 = 13;
                while (true) {
                    i2 = i25 + 1;
                    charAt14 = str2.charAt(i25);
                    if (charAt14 < 55296) {
                        break;
                    }
                    c11 |= (charAt14 & 8191) << i26;
                    i26 += 13;
                    i25 = i2;
                }
                charAt15 = (charAt14 << i26) | c11;
            } else {
                i2 = 1;
            }
            int i27 = i2 + 1;
            char charAt16 = str2.charAt(i2);
            if (charAt16 >= 55296) {
                char c12 = charAt16 & 8191;
                int i28 = 13;
                while (true) {
                    i3 = i27 + 1;
                    charAt13 = str2.charAt(i27);
                    if (charAt13 < 55296) {
                        break;
                    }
                    c12 |= (charAt13 & 8191) << i28;
                    i28 += 13;
                    i27 = i3;
                }
                charAt16 = c12 | (charAt13 << i28);
            } else {
                i3 = i27;
            }
            if (charAt16 == 0) {
                iArr = f12955a;
                c6 = 0;
                c5 = 0;
                i4 = 0;
                c4 = 0;
                c3 = 0;
                c2 = 0;
            } else {
                int i29 = i3 + 1;
                char charAt17 = str2.charAt(i3);
                if (charAt17 >= 55296) {
                    char c13 = charAt17 & 8191;
                    int i30 = 13;
                    while (true) {
                        i16 = i29 + 1;
                        charAt12 = str2.charAt(i29);
                        if (charAt12 < 55296) {
                            break;
                        }
                        c13 |= (charAt12 & 8191) << i30;
                        i30 += 13;
                        i29 = i16;
                    }
                    c9 = (charAt12 << i30) | c13;
                } else {
                    i16 = i29;
                    c9 = charAt17;
                }
                int i31 = i16 + 1;
                char charAt18 = str2.charAt(i16);
                if (charAt18 >= 55296) {
                    char c14 = charAt18 & 8191;
                    int i32 = 13;
                    while (true) {
                        i17 = i31 + 1;
                        charAt11 = str2.charAt(i31);
                        if (charAt11 < 55296) {
                            break;
                        }
                        c14 |= (charAt11 & 8191) << i32;
                        i32 += 13;
                        i31 = i17;
                    }
                    charAt18 = c14 | (charAt11 << i32);
                } else {
                    i17 = i31;
                }
                int i33 = i17 + 1;
                char charAt19 = str2.charAt(i17);
                if (charAt19 >= 55296) {
                    char c15 = charAt19 & 8191;
                    int i34 = 13;
                    while (true) {
                        i18 = i33 + 1;
                        charAt10 = str2.charAt(i33);
                        if (charAt10 < 55296) {
                            break;
                        }
                        c15 |= (charAt10 & 8191) << i34;
                        i34 += 13;
                        i33 = i18;
                    }
                    charAt19 = (charAt10 << i34) | c15;
                } else {
                    i18 = i33;
                }
                int i35 = i18 + 1;
                c4 = str2.charAt(i18);
                if (c4 >= 55296) {
                    char c16 = c4 & 8191;
                    int i36 = 13;
                    while (true) {
                        i19 = i35 + 1;
                        charAt9 = str2.charAt(i35);
                        if (charAt9 < 55296) {
                            break;
                        }
                        c16 |= (charAt9 & 8191) << i36;
                        i36 += 13;
                        i35 = i19;
                    }
                    c4 = (charAt9 << i36) | c16;
                } else {
                    i19 = i35;
                }
                int i37 = i19 + 1;
                c3 = str2.charAt(i19);
                if (c3 >= 55296) {
                    char c17 = c3 & 8191;
                    int i38 = 13;
                    while (true) {
                        i24 = i37 + 1;
                        charAt8 = str2.charAt(i37);
                        if (charAt8 < 55296) {
                            break;
                        }
                        c17 |= (charAt8 & 8191) << i38;
                        i38 += 13;
                        i37 = i24;
                    }
                    c3 = (charAt8 << i38) | c17;
                    i37 = i24;
                }
                int i39 = i37 + 1;
                c5 = str2.charAt(i37);
                if (c5 >= 55296) {
                    char c18 = c5 & 8191;
                    int i40 = 13;
                    while (true) {
                        i23 = i39 + 1;
                        charAt7 = str2.charAt(i39);
                        if (charAt7 < 55296) {
                            break;
                        }
                        c18 |= (charAt7 & 8191) << i40;
                        i40 += 13;
                        i39 = i23;
                    }
                    c5 = c18 | (charAt7 << i40);
                    i39 = i23;
                }
                int i41 = i39 + 1;
                char charAt20 = str2.charAt(i39);
                if (charAt20 >= 55296) {
                    int i42 = 13;
                    int i43 = i41;
                    char c19 = charAt20 & 8191;
                    int i44 = i43;
                    while (true) {
                        i22 = i44 + 1;
                        charAt6 = str2.charAt(i44);
                        if (charAt6 < 55296) {
                            break;
                        }
                        c19 |= (charAt6 & 8191) << i42;
                        i42 += 13;
                        i44 = i22;
                    }
                    charAt20 = c19 | (charAt6 << i42);
                    i20 = i22;
                } else {
                    i20 = i41;
                }
                int i45 = i20 + 1;
                c10 = str2.charAt(i20);
                if (c10 >= 55296) {
                    int i46 = 13;
                    int i47 = i45;
                    char c20 = c10 & 8191;
                    int i48 = i47;
                    while (true) {
                        i21 = i48 + 1;
                        charAt5 = str2.charAt(i48);
                        if (charAt5 < 55296) {
                            break;
                        }
                        c20 |= (charAt5 & 8191) << i46;
                        i46 += 13;
                        i48 = i21;
                    }
                    c10 = c20 | (charAt5 << i46);
                    i45 = i21;
                }
                iArr = new int[(c10 + c5 + charAt20)];
                i4 = (c9 << 1) + charAt18;
                int i49 = i45;
                c2 = c9;
                c6 = charAt19;
                i3 = i49;
            }
            Unsafe unsafe = f12956b;
            Object[] objArr = moVar2.f12978c;
            Class<?> cls = moVar2.f12976a.getClass();
            int i50 = i4;
            int[] iArr2 = new int[(c3 * 3)];
            Object[] objArr2 = new Object[(c3 << 1)];
            int i51 = c10 + c5;
            char c21 = c10;
            int i52 = i50;
            int i53 = i51;
            int i54 = 0;
            int i55 = 0;
            while (i3 < length) {
                int i56 = i3 + 1;
                int charAt21 = str2.charAt(i3);
                int i57 = length;
                char c22 = 55296;
                if (charAt21 >= 55296) {
                    int i58 = 13;
                    int i59 = i56;
                    int i60 = charAt21 & 8191;
                    int i61 = i59;
                    while (true) {
                        i15 = i61 + 1;
                        charAt4 = str2.charAt(i61);
                        if (charAt4 < c22) {
                            break;
                        }
                        i60 |= (charAt4 & 8191) << i58;
                        i58 += 13;
                        i61 = i15;
                        c22 = 55296;
                    }
                    charAt21 = i60 | (charAt4 << i58);
                    i5 = i15;
                } else {
                    i5 = i56;
                }
                int i62 = i5 + 1;
                char charAt22 = str2.charAt(i5);
                char c23 = c10;
                char c24 = 55296;
                if (charAt22 >= 55296) {
                    int i63 = 13;
                    int i64 = i62;
                    char c25 = charAt22 & 8191;
                    int i65 = i64;
                    while (true) {
                        i14 = i65 + 1;
                        charAt3 = str2.charAt(i65);
                        if (charAt3 < c24) {
                            break;
                        }
                        c25 |= (charAt3 & 8191) << i63;
                        i63 += 13;
                        i65 = i14;
                        c24 = 55296;
                    }
                    charAt22 = c25 | (charAt3 << i63);
                    i6 = i14;
                } else {
                    i6 = i62;
                }
                boolean z2 = z;
                char c26 = charAt22 & 255;
                char c27 = c4;
                if ((charAt22 & 1024) != 0) {
                    iArr[i54] = i55;
                    i54++;
                }
                int i66 = i54;
                if (c26 >= '3') {
                    int i67 = i6 + 1;
                    char charAt23 = str2.charAt(i6);
                    char c28 = 55296;
                    if (charAt23 >= 55296) {
                        char c29 = charAt23 & 8191;
                        int i68 = 13;
                        while (true) {
                            i13 = i67 + 1;
                            charAt2 = str2.charAt(i67);
                            if (charAt2 < c28) {
                                break;
                            }
                            c29 |= (charAt2 & 8191) << i68;
                            i68 += 13;
                            i67 = i13;
                            c28 = 55296;
                        }
                        charAt23 = c29 | (charAt2 << i68);
                        i67 = i13;
                    }
                    int i69 = c26 - '3';
                    int i70 = i67;
                    if (i69 == 9 || i69 == 17) {
                        c8 = 1;
                        objArr2[((i55 / 3) << 1) + 1] = objArr[i52];
                        i52++;
                    } else {
                        if (i69 == 12 && (charAt15 & 1) == 1) {
                            objArr2[((i55 / 3) << 1) + 1] = objArr[i52];
                            i52++;
                        }
                        c8 = 1;
                    }
                    int i71 = charAt23 << c8;
                    Object obj = objArr[i71];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = a(cls, (String) obj);
                        objArr[i71] = field2;
                    }
                    char c30 = c6;
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i72 = i71 + 1;
                    Object obj2 = objArr[i72];
                    int i73 = objectFieldOffset;
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = a(cls, (String) obj2);
                        objArr[i72] = field3;
                    }
                    int objectFieldOffset2 = (int) unsafe.objectFieldOffset(field3);
                    i9 = i52;
                    i8 = i73;
                    i7 = i70;
                    moVar = moVar2;
                    c7 = c30;
                    str = str2;
                    i11 = objectFieldOffset2;
                    i10 = 0;
                } else {
                    char c31 = c6;
                    i9 = i52 + 1;
                    Field a2 = a(cls, (String) objArr[i52]);
                    c7 = c31;
                    if (c26 == 9 || c26 == 17) {
                        moVar = moVar2;
                        objArr2[((i55 / 3) << 1) + 1] = a2.getType();
                    } else {
                        if (c26 == 27 || c26 == '1') {
                            moVar = moVar2;
                            i12 = i9 + 1;
                            objArr2[((i55 / 3) << 1) + 1] = objArr[i9];
                        } else if (c26 == 12 || c26 == 30 || c26 == ',') {
                            moVar = moVar2;
                            if ((charAt15 & 1) == 1) {
                                i12 = i9 + 1;
                                objArr2[((i55 / 3) << 1) + 1] = objArr[i9];
                            }
                        } else if (c26 == '2') {
                            int i74 = c21 + 1;
                            iArr[c21] = i55;
                            int i75 = (i55 / 3) << 1;
                            int i76 = i9 + 1;
                            objArr2[i75] = objArr[i9];
                            if ((charAt22 & 2048) != 0) {
                                i9 = i76 + 1;
                                objArr2[i75 + 1] = objArr[i76];
                                moVar = moVar2;
                                c21 = i74;
                            } else {
                                c21 = i74;
                                i9 = i76;
                                moVar = moVar2;
                            }
                        } else {
                            moVar = moVar2;
                        }
                        str = str2;
                        i9 = i12;
                        i8 = (int) unsafe.objectFieldOffset(a2);
                        if ((charAt15 & 1) == 1 || c26 > 17) {
                            i7 = i6;
                            i11 = 0;
                            i10 = 0;
                        } else {
                            int i77 = i6 + 1;
                            String str3 = str;
                            char charAt24 = str3.charAt(i6);
                            if (charAt24 >= 55296) {
                                char c32 = charAt24 & 8191;
                                int i78 = 13;
                                while (true) {
                                    i7 = i77 + 1;
                                    charAt = str3.charAt(i77);
                                    if (charAt < 55296) {
                                        break;
                                    }
                                    c32 |= (charAt & 8191) << i78;
                                    i78 += 13;
                                    i77 = i7;
                                }
                                charAt24 = c32 | (charAt << i78);
                            } else {
                                i7 = i77;
                            }
                            int i79 = (c2 << 1) + (charAt24 / ' ');
                            Object obj3 = objArr[i79];
                            if (obj3 instanceof Field) {
                                field = (Field) obj3;
                            } else {
                                field = a(cls, (String) obj3);
                                objArr[i79] = field;
                            }
                            str = str3;
                            i11 = (int) unsafe.objectFieldOffset(field);
                            i10 = charAt24 % ' ';
                        }
                        if (c26 >= 18 && c26 <= '1') {
                            iArr[i53] = i8;
                            i53++;
                        }
                    }
                    str = str2;
                    i8 = (int) unsafe.objectFieldOffset(a2);
                    if ((charAt15 & 1) == 1) {
                    }
                    i7 = i6;
                    i11 = 0;
                    i10 = 0;
                    iArr[i53] = i8;
                    i53++;
                }
                int i80 = i55 + 1;
                iArr2[i55] = charAt21;
                int i81 = i80 + 1;
                Class<?> cls2 = cls;
                iArr2[i80] = ((charAt22 & 256) != 0 ? SigType.TLS : 0) | ((charAt22 & 512) != 0 ? 536870912 : 0) | (c26 << 20) | i8;
                i55 = i81 + 1;
                iArr2[i81] = (i10 << 20) | i11;
                str2 = str;
                cls = cls2;
                z = z2;
                length = i57;
                c10 = c23;
                c4 = c27;
                moVar2 = moVar;
                i3 = i7;
                i54 = i66;
                char c33 = c7;
                i52 = i9;
                c6 = c33;
            }
            char c34 = c6;
            boolean z3 = z;
            return new md(iArr2, objArr2, c6, c4, moVar2.f12976a, z, false, iArr, c10, i51, mgVar, lmVar, nfVar, knVar, lwVar);
        }
        nc ncVar = (nc) lyVar2;
        throw new NoSuchMethodError();
    }

    private static Field a(Class<?> cls, String str) {
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
        if (com.google.android.libraries.places.internal.mr.a(com.google.android.libraries.places.internal.nk.f(r10, r6), com.google.android.libraries.places.internal.nk.f(r11, r6)) != false) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.libraries.places.internal.nk.b(r10, r6) == com.google.android.libraries.places.internal.nk.b(r11, r6)) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.libraries.places.internal.nk.a((java.lang.Object) r10, r6) == com.google.android.libraries.places.internal.nk.a((java.lang.Object) r11, r6)) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.libraries.places.internal.nk.b(r10, r6) == com.google.android.libraries.places.internal.nk.b(r11, r6)) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.libraries.places.internal.nk.a((java.lang.Object) r10, r6) == com.google.android.libraries.places.internal.nk.a((java.lang.Object) r11, r6)) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.libraries.places.internal.nk.a((java.lang.Object) r10, r6) == com.google.android.libraries.places.internal.nk.a((java.lang.Object) r11, r6)) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.libraries.places.internal.nk.a((java.lang.Object) r10, r6) == com.google.android.libraries.places.internal.nk.a((java.lang.Object) r11, r6)) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.libraries.places.internal.mr.a(com.google.android.libraries.places.internal.nk.f(r10, r6), com.google.android.libraries.places.internal.nk.f(r11, r6)) != false) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.libraries.places.internal.mr.a(com.google.android.libraries.places.internal.nk.f(r10, r6), com.google.android.libraries.places.internal.nk.f(r11, r6)) != false) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.libraries.places.internal.mr.a(com.google.android.libraries.places.internal.nk.f(r10, r6), com.google.android.libraries.places.internal.nk.f(r11, r6)) != false) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.libraries.places.internal.nk.c(r10, r6) == com.google.android.libraries.places.internal.nk.c(r11, r6)) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.libraries.places.internal.nk.a((java.lang.Object) r10, r6) == com.google.android.libraries.places.internal.nk.a((java.lang.Object) r11, r6)) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.libraries.places.internal.nk.b(r10, r6) == com.google.android.libraries.places.internal.nk.b(r11, r6)) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0166, code lost:
        if (com.google.android.libraries.places.internal.nk.a((java.lang.Object) r10, r6) == com.google.android.libraries.places.internal.nk.a((java.lang.Object) r11, r6)) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0179, code lost:
        if (com.google.android.libraries.places.internal.nk.b(r10, r6) == com.google.android.libraries.places.internal.nk.b(r11, r6)) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018c, code lost:
        if (com.google.android.libraries.places.internal.nk.b(r10, r6) == com.google.android.libraries.places.internal.nk.b(r11, r6)) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a5, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.libraries.places.internal.nk.d(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.libraries.places.internal.nk.d(r11, r6))) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01c0, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.libraries.places.internal.nk.e(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.libraries.places.internal.nk.e(r11, r6))) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c3, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.libraries.places.internal.mr.a(com.google.android.libraries.places.internal.nk.f(r10, r6), com.google.android.libraries.places.internal.nk.f(r11, r6)) != false) goto L_0x01c4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.f12957c
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01cb
            int r4 = r9.c((int) r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x01a8;
                case 1: goto L_0x018f;
                case 2: goto L_0x017c;
                case 3: goto L_0x0169;
                case 4: goto L_0x0158;
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
            goto L_0x01c4
        L_0x001c:
            int r4 = r9.d((int) r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r10, (long) r4)
            int r4 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r11, (long) r4)
            if (r8 != r4) goto L_0x01c3
            java.lang.Object r4 = com.google.android.libraries.places.internal.nk.f(r10, r6)
            java.lang.Object r5 = com.google.android.libraries.places.internal.nk.f(r11, r6)
            boolean r4 = com.google.android.libraries.places.internal.mr.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x01c3
            goto L_0x01c4
        L_0x003c:
            java.lang.Object r3 = com.google.android.libraries.places.internal.nk.f(r10, r6)
            java.lang.Object r4 = com.google.android.libraries.places.internal.nk.f(r11, r6)
            boolean r3 = com.google.android.libraries.places.internal.mr.a((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c4
        L_0x004a:
            java.lang.Object r3 = com.google.android.libraries.places.internal.nk.f(r10, r6)
            java.lang.Object r4 = com.google.android.libraries.places.internal.nk.f(r11, r6)
            boolean r3 = com.google.android.libraries.places.internal.mr.a((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c4
        L_0x0058:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c3
            java.lang.Object r4 = com.google.android.libraries.places.internal.nk.f(r10, r6)
            java.lang.Object r5 = com.google.android.libraries.places.internal.nk.f(r11, r6)
            boolean r4 = com.google.android.libraries.places.internal.mr.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x01c3
            goto L_0x01c4
        L_0x006e:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c3
            long r4 = com.google.android.libraries.places.internal.nk.b(r10, r6)
            long r6 = com.google.android.libraries.places.internal.nk.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x01c3
            goto L_0x01c4
        L_0x0082:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c3
            int r4 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r11, (long) r6)
            if (r4 != r5) goto L_0x01c3
            goto L_0x01c4
        L_0x0094:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c3
            long r4 = com.google.android.libraries.places.internal.nk.b(r10, r6)
            long r6 = com.google.android.libraries.places.internal.nk.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x01c3
            goto L_0x01c4
        L_0x00a8:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c3
            int r4 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r11, (long) r6)
            if (r4 != r5) goto L_0x01c3
            goto L_0x01c4
        L_0x00ba:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c3
            int r4 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r11, (long) r6)
            if (r4 != r5) goto L_0x01c3
            goto L_0x01c4
        L_0x00cc:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c3
            int r4 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r11, (long) r6)
            if (r4 != r5) goto L_0x01c3
            goto L_0x01c4
        L_0x00de:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c3
            java.lang.Object r4 = com.google.android.libraries.places.internal.nk.f(r10, r6)
            java.lang.Object r5 = com.google.android.libraries.places.internal.nk.f(r11, r6)
            boolean r4 = com.google.android.libraries.places.internal.mr.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x01c3
            goto L_0x01c4
        L_0x00f4:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c3
            java.lang.Object r4 = com.google.android.libraries.places.internal.nk.f(r10, r6)
            java.lang.Object r5 = com.google.android.libraries.places.internal.nk.f(r11, r6)
            boolean r4 = com.google.android.libraries.places.internal.mr.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x01c3
            goto L_0x01c4
        L_0x010a:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c3
            java.lang.Object r4 = com.google.android.libraries.places.internal.nk.f(r10, r6)
            java.lang.Object r5 = com.google.android.libraries.places.internal.nk.f(r11, r6)
            boolean r4 = com.google.android.libraries.places.internal.mr.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x01c3
            goto L_0x01c4
        L_0x0120:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c3
            boolean r4 = com.google.android.libraries.places.internal.nk.c(r10, r6)
            boolean r5 = com.google.android.libraries.places.internal.nk.c(r11, r6)
            if (r4 != r5) goto L_0x01c3
            goto L_0x01c4
        L_0x0132:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c3
            int r4 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r11, (long) r6)
            if (r4 != r5) goto L_0x01c3
            goto L_0x01c4
        L_0x0144:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c3
            long r4 = com.google.android.libraries.places.internal.nk.b(r10, r6)
            long r6 = com.google.android.libraries.places.internal.nk.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x01c3
            goto L_0x01c4
        L_0x0158:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c3
            int r4 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r11, (long) r6)
            if (r4 != r5) goto L_0x01c3
            goto L_0x01c4
        L_0x0169:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c3
            long r4 = com.google.android.libraries.places.internal.nk.b(r10, r6)
            long r6 = com.google.android.libraries.places.internal.nk.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x01c3
            goto L_0x01c4
        L_0x017c:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c3
            long r4 = com.google.android.libraries.places.internal.nk.b(r10, r6)
            long r6 = com.google.android.libraries.places.internal.nk.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x01c3
            goto L_0x01c4
        L_0x018f:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c3
            float r4 = com.google.android.libraries.places.internal.nk.d(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.libraries.places.internal.nk.d(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 != r5) goto L_0x01c3
            goto L_0x01c4
        L_0x01a8:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c3
            double r4 = com.google.android.libraries.places.internal.nk.e(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.libraries.places.internal.nk.e(r11, r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x01c3
            goto L_0x01c4
        L_0x01c3:
            r3 = 0
        L_0x01c4:
            if (r3 != 0) goto L_0x01c7
            return r1
        L_0x01c7:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01cb:
            com.google.android.libraries.places.internal.nf<?, ?> r0 = r9.q
            java.lang.Object r0 = r0.a((java.lang.Object) r10)
            com.google.android.libraries.places.internal.nf<?, ?> r2 = r9.q
            java.lang.Object r2 = r2.a((java.lang.Object) r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01de
            return r1
        L_0x01de:
            boolean r0 = r9.h
            if (r0 == 0) goto L_0x01f3
            com.google.android.libraries.places.internal.kn<?> r0 = r9.r
            com.google.android.libraries.places.internal.kp r10 = r0.a((java.lang.Object) r10)
            com.google.android.libraries.places.internal.kn<?> r0 = r9.r
            com.google.android.libraries.places.internal.kp r11 = r0.a((java.lang.Object) r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f3:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.md.a(java.lang.Object, java.lang.Object):boolean");
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
    public final int a(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.f12957c
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x022c
            int r3 = r8.c((int) r1)
            int[] r4 = r8.f12957c
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
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.libraries.places.internal.nk.f(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x0032:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.google.android.libraries.places.internal.kx.a((long) r3)
            goto L_0x0227
        L_0x0044:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x0227
        L_0x0052:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.google.android.libraries.places.internal.kx.a((long) r3)
            goto L_0x0227
        L_0x0064:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x0227
        L_0x0072:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x0227
        L_0x0080:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x0227
        L_0x008e:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.libraries.places.internal.nk.f(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00a0:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.libraries.places.internal.nk.f(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00b2:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.libraries.places.internal.nk.f(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00c6:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            boolean r3 = f(r9, r5)
            int r3 = com.google.android.libraries.places.internal.kx.a((boolean) r3)
            goto L_0x0227
        L_0x00d8:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x0227
        L_0x00e6:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.google.android.libraries.places.internal.kx.a((long) r3)
            goto L_0x0227
        L_0x00f8:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x0227
        L_0x0106:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.google.android.libraries.places.internal.kx.a((long) r3)
            goto L_0x0227
        L_0x0118:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.google.android.libraries.places.internal.kx.a((long) r3)
            goto L_0x0227
        L_0x012a:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            float r3 = c(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x013c:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            double r3 = b(r9, (long) r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.libraries.places.internal.kx.a((long) r3)
            goto L_0x0227
        L_0x0152:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.libraries.places.internal.nk.f(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x015e:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.libraries.places.internal.nk.f(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x016a:
            java.lang.Object r3 = com.google.android.libraries.places.internal.nk.f(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
            goto L_0x01c3
        L_0x0175:
            int r2 = r2 * 53
            long r3 = com.google.android.libraries.places.internal.nk.b(r9, r5)
            int r3 = com.google.android.libraries.places.internal.kx.a((long) r3)
            goto L_0x0227
        L_0x0181:
            int r2 = r2 * 53
            int r3 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x0189:
            int r2 = r2 * 53
            long r3 = com.google.android.libraries.places.internal.nk.b(r9, r5)
            int r3 = com.google.android.libraries.places.internal.kx.a((long) r3)
            goto L_0x0227
        L_0x0195:
            int r2 = r2 * 53
            int r3 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x019d:
            int r2 = r2 * 53
            int r3 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01a5:
            int r2 = r2 * 53
            int r3 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01ad:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.libraries.places.internal.nk.f(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01b9:
            java.lang.Object r3 = com.google.android.libraries.places.internal.nk.f(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
        L_0x01c3:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0228
        L_0x01c7:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.libraries.places.internal.nk.f(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01d4:
            int r2 = r2 * 53
            boolean r3 = com.google.android.libraries.places.internal.nk.c(r9, r5)
            int r3 = com.google.android.libraries.places.internal.kx.a((boolean) r3)
            goto L_0x0227
        L_0x01df:
            int r2 = r2 * 53
            int r3 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01e6:
            int r2 = r2 * 53
            long r3 = com.google.android.libraries.places.internal.nk.b(r9, r5)
            int r3 = com.google.android.libraries.places.internal.kx.a((long) r3)
            goto L_0x0227
        L_0x01f1:
            int r2 = r2 * 53
            int r3 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01f8:
            int r2 = r2 * 53
            long r3 = com.google.android.libraries.places.internal.nk.b(r9, r5)
            int r3 = com.google.android.libraries.places.internal.kx.a((long) r3)
            goto L_0x0227
        L_0x0203:
            int r2 = r2 * 53
            long r3 = com.google.android.libraries.places.internal.nk.b(r9, r5)
            int r3 = com.google.android.libraries.places.internal.kx.a((long) r3)
            goto L_0x0227
        L_0x020e:
            int r2 = r2 * 53
            float r3 = com.google.android.libraries.places.internal.nk.d(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x0219:
            int r2 = r2 * 53
            double r3 = com.google.android.libraries.places.internal.nk.e(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.libraries.places.internal.kx.a((long) r3)
        L_0x0227:
            int r2 = r2 + r3
        L_0x0228:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022c:
            int r2 = r2 * 53
            com.google.android.libraries.places.internal.nf<?, ?> r0 = r8.q
            java.lang.Object r0 = r0.a((java.lang.Object) r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.h
            if (r0 == 0) goto L_0x024a
            int r2 = r2 * 53
            com.google.android.libraries.places.internal.kn<?> r0 = r8.r
            com.google.android.libraries.places.internal.kp r9 = r0.a((java.lang.Object) r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x024a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.md.a(java.lang.Object):int");
    }

    public final void b(T t, T t2) {
        if (t2 != null) {
            for (int i2 = 0; i2 < this.f12957c.length; i2 += 3) {
                int c2 = c(i2);
                long j2 = (long) (1048575 & c2);
                int i3 = this.f12957c[i2];
                switch ((c2 & 267386880) >>> 20) {
                    case 0:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            nk.a((Object) t, j2, nk.e(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 1:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            nk.a((Object) t, j2, nk.d(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 2:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            nk.a((Object) t, j2, nk.b(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 3:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            nk.a((Object) t, j2, nk.b(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 4:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            nk.a((Object) t, j2, nk.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 5:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            nk.a((Object) t, j2, nk.b(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 6:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            nk.a((Object) t, j2, nk.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 7:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            nk.a((Object) t, j2, nk.c(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 8:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            nk.a((Object) t, j2, nk.f(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 9:
                        a(t, t2, i2);
                        break;
                    case 10:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            nk.a((Object) t, j2, nk.f(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 11:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            nk.a((Object) t, j2, nk.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 12:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            nk.a((Object) t, j2, nk.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 13:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            nk.a((Object) t, j2, nk.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 14:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            nk.a((Object) t, j2, nk.b(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 15:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            nk.a((Object) t, j2, nk.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 16:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            nk.a((Object) t, j2, nk.b(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 17:
                        a(t, t2, i2);
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
                        this.p.a(t, t2, j2);
                        break;
                    case 50:
                        mr.a(this.s, t, t2, j2);
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
                        if (!a(t2, i3, i2)) {
                            break;
                        } else {
                            nk.a((Object) t, j2, nk.f(t2, j2));
                            b(t, i3, i2);
                            break;
                        }
                    case 60:
                        b(t, t2, i2);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!a(t2, i3, i2)) {
                            break;
                        } else {
                            nk.a((Object) t, j2, nk.f(t2, j2));
                            b(t, i3, i2);
                            break;
                        }
                    case 68:
                        b(t, t2, i2);
                        break;
                }
            }
            if (!this.j) {
                mr.a(this.q, t, t2);
                if (this.h) {
                    mr.a(this.r, t, t2);
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    private final void a(T t, T t2, int i2) {
        long c2 = (long) (c(i2) & 1048575);
        if (a(t2, i2)) {
            Object f2 = nk.f(t, c2);
            Object f3 = nk.f(t2, c2);
            if (f2 != null && f3 != null) {
                nk.a((Object) t, c2, kx.a(f2, f3));
                b(t, i2);
            } else if (f3 != null) {
                nk.a((Object) t, c2, f3);
                b(t, i2);
            }
        }
    }

    private final void b(T t, T t2, int i2) {
        int c2 = c(i2);
        int i3 = this.f12957c[i2];
        long j2 = (long) (c2 & 1048575);
        if (a(t2, i3, i2)) {
            Object f2 = nk.f(t, j2);
            Object f3 = nk.f(t2, j2);
            if (f2 != null && f3 != null) {
                nk.a((Object) t, j2, kx.a(f2, f3));
                b(t, i3, i2);
            } else if (f3 != null) {
                nk.a((Object) t, j2, f3);
                b(t, i3, i2);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:398:0x082c, code lost:
        r8 = (r8 + r9) + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:415:0x08f8, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:421:0x090d, code lost:
        r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:437:0x0952, code lost:
        r5 = r5 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:476:0x0a09, code lost:
        r5 = r5 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:484:0x0a2c, code lost:
        r3 = r3 + 3;
        r9 = r13;
        r7 = 1048575;
        r8 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int b(T r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            boolean r2 = r0.j
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 1
            r9 = 0
            r11 = 0
            if (r2 == 0) goto L_0x04ee
            sun.misc.Unsafe r2 = f12956b
            r12 = 0
            r13 = 0
        L_0x0016:
            int[] r14 = r0.f12957c
            int r14 = r14.length
            if (r12 >= r14) goto L_0x04e6
            int r14 = r0.c((int) r12)
            r15 = r14 & r3
            int r15 = r15 >>> 20
            int[] r3 = r0.f12957c
            r3 = r3[r12]
            r14 = r14 & r7
            long r5 = (long) r14
            com.google.android.libraries.places.internal.kr r14 = com.google.android.libraries.places.internal.kr.DOUBLE_LIST_PACKED
            int r14 = r14.h
            if (r15 < r14) goto L_0x003d
            com.google.android.libraries.places.internal.kr r14 = com.google.android.libraries.places.internal.kr.SINT64_LIST_PACKED
            int r14 = r14.h
            if (r15 > r14) goto L_0x003d
            int[] r14 = r0.f12957c
            int r17 = r12 + 2
            r14 = r14[r17]
            r14 = r14 & r7
            goto L_0x003e
        L_0x003d:
            r14 = 0
        L_0x003e:
            switch(r15) {
                case 0: goto L_0x04d2;
                case 1: goto L_0x04c6;
                case 2: goto L_0x04b6;
                case 3: goto L_0x04a6;
                case 4: goto L_0x0496;
                case 5: goto L_0x048a;
                case 6: goto L_0x047e;
                case 7: goto L_0x0472;
                case 8: goto L_0x0454;
                case 9: goto L_0x0440;
                case 10: goto L_0x042f;
                case 11: goto L_0x0420;
                case 12: goto L_0x0411;
                case 13: goto L_0x0406;
                case 14: goto L_0x03fb;
                case 15: goto L_0x03ec;
                case 16: goto L_0x03dd;
                case 17: goto L_0x03c8;
                case 18: goto L_0x03bd;
                case 19: goto L_0x03b4;
                case 20: goto L_0x03ab;
                case 21: goto L_0x03a2;
                case 22: goto L_0x0399;
                case 23: goto L_0x0390;
                case 24: goto L_0x0387;
                case 25: goto L_0x037e;
                case 26: goto L_0x0375;
                case 27: goto L_0x0368;
                case 28: goto L_0x035f;
                case 29: goto L_0x0356;
                case 30: goto L_0x034c;
                case 31: goto L_0x0342;
                case 32: goto L_0x0338;
                case 33: goto L_0x032e;
                case 34: goto L_0x0324;
                case 35: goto L_0x0304;
                case 36: goto L_0x02e7;
                case 37: goto L_0x02ca;
                case 38: goto L_0x02ad;
                case 39: goto L_0x028f;
                case 40: goto L_0x0271;
                case 41: goto L_0x0253;
                case 42: goto L_0x0235;
                case 43: goto L_0x0217;
                case 44: goto L_0x01f9;
                case 45: goto L_0x01db;
                case 46: goto L_0x01bd;
                case 47: goto L_0x019f;
                case 48: goto L_0x0181;
                case 49: goto L_0x0173;
                case 50: goto L_0x0163;
                case 51: goto L_0x0155;
                case 52: goto L_0x0149;
                case 53: goto L_0x0139;
                case 54: goto L_0x0129;
                case 55: goto L_0x0119;
                case 56: goto L_0x010d;
                case 57: goto L_0x0101;
                case 58: goto L_0x00f5;
                case 59: goto L_0x00d7;
                case 60: goto L_0x00c3;
                case 61: goto L_0x00b1;
                case 62: goto L_0x00a1;
                case 63: goto L_0x0091;
                case 64: goto L_0x0085;
                case 65: goto L_0x0079;
                case 66: goto L_0x0069;
                case 67: goto L_0x0059;
                case 68: goto L_0x0043;
                default: goto L_0x0041;
            }
        L_0x0041:
            goto L_0x04e0
        L_0x0043:
            boolean r14 = r0.a(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e0
            java.lang.Object r5 = com.google.android.libraries.places.internal.nk.f(r1, r5)
            com.google.android.libraries.places.internal.ma r5 = (com.google.android.libraries.places.internal.ma) r5
            com.google.android.libraries.places.internal.mp r6 = r0.a((int) r12)
            int r3 = com.google.android.libraries.places.internal.kk.c(r3, r5, r6)
            goto L_0x03c5
        L_0x0059:
            boolean r14 = r0.a(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e0
            long r5 = e(r1, r5)
            int r3 = com.google.android.libraries.places.internal.kk.f((int) r3, (long) r5)
            goto L_0x03c5
        L_0x0069:
            boolean r14 = r0.a(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e0
            int r5 = d(r1, r5)
            int r3 = com.google.android.libraries.places.internal.kk.h((int) r3, (int) r5)
            goto L_0x03c5
        L_0x0079:
            boolean r5 = r0.a(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e0
            int r3 = com.google.android.libraries.places.internal.kk.h((int) r3, (long) r9)
            goto L_0x03c5
        L_0x0085:
            boolean r5 = r0.a(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e0
            int r3 = com.google.android.libraries.places.internal.kk.j(r3, r11)
            goto L_0x03c5
        L_0x0091:
            boolean r14 = r0.a(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e0
            int r5 = d(r1, r5)
            int r3 = com.google.android.libraries.places.internal.kk.k(r3, r5)
            goto L_0x03c5
        L_0x00a1:
            boolean r14 = r0.a(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e0
            int r5 = d(r1, r5)
            int r3 = com.google.android.libraries.places.internal.kk.g((int) r3, (int) r5)
            goto L_0x03c5
        L_0x00b1:
            boolean r14 = r0.a(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e0
            java.lang.Object r5 = com.google.android.libraries.places.internal.nk.f(r1, r5)
            com.google.android.libraries.places.internal.kc r5 = (com.google.android.libraries.places.internal.kc) r5
            int r3 = com.google.android.libraries.places.internal.kk.c((int) r3, (com.google.android.libraries.places.internal.kc) r5)
            goto L_0x03c5
        L_0x00c3:
            boolean r14 = r0.a(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e0
            java.lang.Object r5 = com.google.android.libraries.places.internal.nk.f(r1, r5)
            com.google.android.libraries.places.internal.mp r6 = r0.a((int) r12)
            int r3 = com.google.android.libraries.places.internal.mr.a((int) r3, (java.lang.Object) r5, (com.google.android.libraries.places.internal.mp) r6)
            goto L_0x03c5
        L_0x00d7:
            boolean r14 = r0.a(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e0
            java.lang.Object r5 = com.google.android.libraries.places.internal.nk.f(r1, r5)
            boolean r6 = r5 instanceof com.google.android.libraries.places.internal.kc
            if (r6 == 0) goto L_0x00ed
            com.google.android.libraries.places.internal.kc r5 = (com.google.android.libraries.places.internal.kc) r5
            int r3 = com.google.android.libraries.places.internal.kk.c((int) r3, (com.google.android.libraries.places.internal.kc) r5)
            goto L_0x03c5
        L_0x00ed:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.libraries.places.internal.kk.b((int) r3, (java.lang.String) r5)
            goto L_0x03c5
        L_0x00f5:
            boolean r5 = r0.a(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e0
            int r3 = com.google.android.libraries.places.internal.kk.b((int) r3, (boolean) r8)
            goto L_0x03c5
        L_0x0101:
            boolean r5 = r0.a(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e0
            int r3 = com.google.android.libraries.places.internal.kk.i(r3, r11)
            goto L_0x03c5
        L_0x010d:
            boolean r5 = r0.a(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e0
            int r3 = com.google.android.libraries.places.internal.kk.g((int) r3, (long) r9)
            goto L_0x03c5
        L_0x0119:
            boolean r14 = r0.a(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e0
            int r5 = d(r1, r5)
            int r3 = com.google.android.libraries.places.internal.kk.f((int) r3, (int) r5)
            goto L_0x03c5
        L_0x0129:
            boolean r14 = r0.a(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e0
            long r5 = e(r1, r5)
            int r3 = com.google.android.libraries.places.internal.kk.e((int) r3, (long) r5)
            goto L_0x03c5
        L_0x0139:
            boolean r14 = r0.a(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e0
            long r5 = e(r1, r5)
            int r3 = com.google.android.libraries.places.internal.kk.d((int) r3, (long) r5)
            goto L_0x03c5
        L_0x0149:
            boolean r5 = r0.a(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e0
            int r3 = com.google.android.libraries.places.internal.kk.b((int) r3, (float) r4)
            goto L_0x03c5
        L_0x0155:
            boolean r5 = r0.a(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e0
            r5 = 0
            int r3 = com.google.android.libraries.places.internal.kk.b((int) r3, (double) r5)
            goto L_0x03c5
        L_0x0163:
            com.google.android.libraries.places.internal.lw r14 = r0.s
            java.lang.Object r5 = com.google.android.libraries.places.internal.nk.f(r1, r5)
            java.lang.Object r6 = r0.b((int) r12)
            int r3 = r14.a(r3, r5, r6)
            goto L_0x03c5
        L_0x0173:
            java.util.List r5 = a((java.lang.Object) r1, (long) r5)
            com.google.android.libraries.places.internal.mp r6 = r0.a((int) r12)
            int r3 = com.google.android.libraries.places.internal.mr.b((int) r3, (java.util.List<com.google.android.libraries.places.internal.ma>) r5, (com.google.android.libraries.places.internal.mp) r6)
            goto L_0x03c5
        L_0x0181:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.libraries.places.internal.mr.c(r5)
            if (r5 <= 0) goto L_0x04e0
            boolean r6 = r0.k
            if (r6 == 0) goto L_0x0195
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0195:
            int r3 = com.google.android.libraries.places.internal.kk.e((int) r3)
            int r6 = com.google.android.libraries.places.internal.kk.g((int) r5)
            goto L_0x0320
        L_0x019f:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.libraries.places.internal.mr.g(r5)
            if (r5 <= 0) goto L_0x04e0
            boolean r6 = r0.k
            if (r6 == 0) goto L_0x01b3
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01b3:
            int r3 = com.google.android.libraries.places.internal.kk.e((int) r3)
            int r6 = com.google.android.libraries.places.internal.kk.g((int) r5)
            goto L_0x0320
        L_0x01bd:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.libraries.places.internal.mr.i(r5)
            if (r5 <= 0) goto L_0x04e0
            boolean r6 = r0.k
            if (r6 == 0) goto L_0x01d1
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01d1:
            int r3 = com.google.android.libraries.places.internal.kk.e((int) r3)
            int r6 = com.google.android.libraries.places.internal.kk.g((int) r5)
            goto L_0x0320
        L_0x01db:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.libraries.places.internal.mr.h(r5)
            if (r5 <= 0) goto L_0x04e0
            boolean r6 = r0.k
            if (r6 == 0) goto L_0x01ef
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01ef:
            int r3 = com.google.android.libraries.places.internal.kk.e((int) r3)
            int r6 = com.google.android.libraries.places.internal.kk.g((int) r5)
            goto L_0x0320
        L_0x01f9:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.libraries.places.internal.mr.d(r5)
            if (r5 <= 0) goto L_0x04e0
            boolean r6 = r0.k
            if (r6 == 0) goto L_0x020d
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x020d:
            int r3 = com.google.android.libraries.places.internal.kk.e((int) r3)
            int r6 = com.google.android.libraries.places.internal.kk.g((int) r5)
            goto L_0x0320
        L_0x0217:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.libraries.places.internal.mr.f(r5)
            if (r5 <= 0) goto L_0x04e0
            boolean r6 = r0.k
            if (r6 == 0) goto L_0x022b
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x022b:
            int r3 = com.google.android.libraries.places.internal.kk.e((int) r3)
            int r6 = com.google.android.libraries.places.internal.kk.g((int) r5)
            goto L_0x0320
        L_0x0235:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.libraries.places.internal.mr.j(r5)
            if (r5 <= 0) goto L_0x04e0
            boolean r6 = r0.k
            if (r6 == 0) goto L_0x0249
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0249:
            int r3 = com.google.android.libraries.places.internal.kk.e((int) r3)
            int r6 = com.google.android.libraries.places.internal.kk.g((int) r5)
            goto L_0x0320
        L_0x0253:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.libraries.places.internal.mr.h(r5)
            if (r5 <= 0) goto L_0x04e0
            boolean r6 = r0.k
            if (r6 == 0) goto L_0x0267
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0267:
            int r3 = com.google.android.libraries.places.internal.kk.e((int) r3)
            int r6 = com.google.android.libraries.places.internal.kk.g((int) r5)
            goto L_0x0320
        L_0x0271:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.libraries.places.internal.mr.i(r5)
            if (r5 <= 0) goto L_0x04e0
            boolean r6 = r0.k
            if (r6 == 0) goto L_0x0285
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0285:
            int r3 = com.google.android.libraries.places.internal.kk.e((int) r3)
            int r6 = com.google.android.libraries.places.internal.kk.g((int) r5)
            goto L_0x0320
        L_0x028f:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.libraries.places.internal.mr.e(r5)
            if (r5 <= 0) goto L_0x04e0
            boolean r6 = r0.k
            if (r6 == 0) goto L_0x02a3
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02a3:
            int r3 = com.google.android.libraries.places.internal.kk.e((int) r3)
            int r6 = com.google.android.libraries.places.internal.kk.g((int) r5)
            goto L_0x0320
        L_0x02ad:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.libraries.places.internal.mr.b(r5)
            if (r5 <= 0) goto L_0x04e0
            boolean r6 = r0.k
            if (r6 == 0) goto L_0x02c1
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02c1:
            int r3 = com.google.android.libraries.places.internal.kk.e((int) r3)
            int r6 = com.google.android.libraries.places.internal.kk.g((int) r5)
            goto L_0x0320
        L_0x02ca:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.libraries.places.internal.mr.a((java.util.List<java.lang.Long>) r5)
            if (r5 <= 0) goto L_0x04e0
            boolean r6 = r0.k
            if (r6 == 0) goto L_0x02de
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02de:
            int r3 = com.google.android.libraries.places.internal.kk.e((int) r3)
            int r6 = com.google.android.libraries.places.internal.kk.g((int) r5)
            goto L_0x0320
        L_0x02e7:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.libraries.places.internal.mr.h(r5)
            if (r5 <= 0) goto L_0x04e0
            boolean r6 = r0.k
            if (r6 == 0) goto L_0x02fb
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02fb:
            int r3 = com.google.android.libraries.places.internal.kk.e((int) r3)
            int r6 = com.google.android.libraries.places.internal.kk.g((int) r5)
            goto L_0x0320
        L_0x0304:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.libraries.places.internal.mr.i(r5)
            if (r5 <= 0) goto L_0x04e0
            boolean r6 = r0.k
            if (r6 == 0) goto L_0x0318
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0318:
            int r3 = com.google.android.libraries.places.internal.kk.e((int) r3)
            int r6 = com.google.android.libraries.places.internal.kk.g((int) r5)
        L_0x0320:
            int r3 = r3 + r6
            int r3 = r3 + r5
            goto L_0x03c5
        L_0x0324:
            java.util.List r5 = a((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.libraries.places.internal.mr.c(r3, r5, r11)
            goto L_0x03c5
        L_0x032e:
            java.util.List r5 = a((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.libraries.places.internal.mr.g(r3, r5, r11)
            goto L_0x03c5
        L_0x0338:
            java.util.List r5 = a((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.libraries.places.internal.mr.i(r3, r5, r11)
            goto L_0x03c5
        L_0x0342:
            java.util.List r5 = a((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.libraries.places.internal.mr.h(r3, r5, r11)
            goto L_0x03c5
        L_0x034c:
            java.util.List r5 = a((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.libraries.places.internal.mr.d(r3, r5, r11)
            goto L_0x03c5
        L_0x0356:
            java.util.List r5 = a((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.libraries.places.internal.mr.f(r3, r5, r11)
            goto L_0x03c5
        L_0x035f:
            java.util.List r5 = a((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.libraries.places.internal.mr.b(r3, r5)
            goto L_0x03c5
        L_0x0368:
            java.util.List r5 = a((java.lang.Object) r1, (long) r5)
            com.google.android.libraries.places.internal.mp r6 = r0.a((int) r12)
            int r3 = com.google.android.libraries.places.internal.mr.a((int) r3, (java.util.List<?>) r5, (com.google.android.libraries.places.internal.mp) r6)
            goto L_0x03c5
        L_0x0375:
            java.util.List r5 = a((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.libraries.places.internal.mr.a((int) r3, (java.util.List<?>) r5)
            goto L_0x03c5
        L_0x037e:
            java.util.List r5 = a((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.libraries.places.internal.mr.j(r3, r5, r11)
            goto L_0x03c5
        L_0x0387:
            java.util.List r5 = a((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.libraries.places.internal.mr.h(r3, r5, r11)
            goto L_0x03c5
        L_0x0390:
            java.util.List r5 = a((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.libraries.places.internal.mr.i(r3, r5, r11)
            goto L_0x03c5
        L_0x0399:
            java.util.List r5 = a((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.libraries.places.internal.mr.e(r3, r5, r11)
            goto L_0x03c5
        L_0x03a2:
            java.util.List r5 = a((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.libraries.places.internal.mr.b((int) r3, (java.util.List<java.lang.Long>) r5, (boolean) r11)
            goto L_0x03c5
        L_0x03ab:
            java.util.List r5 = a((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.libraries.places.internal.mr.a((int) r3, (java.util.List<java.lang.Long>) r5, (boolean) r11)
            goto L_0x03c5
        L_0x03b4:
            java.util.List r5 = a((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.libraries.places.internal.mr.h(r3, r5, r11)
            goto L_0x03c5
        L_0x03bd:
            java.util.List r5 = a((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.libraries.places.internal.mr.i(r3, r5, r11)
        L_0x03c5:
            int r13 = r13 + r3
            goto L_0x04e0
        L_0x03c8:
            boolean r14 = r0.a(r1, (int) r12)
            if (r14 == 0) goto L_0x04e0
            java.lang.Object r5 = com.google.android.libraries.places.internal.nk.f(r1, r5)
            com.google.android.libraries.places.internal.ma r5 = (com.google.android.libraries.places.internal.ma) r5
            com.google.android.libraries.places.internal.mp r6 = r0.a((int) r12)
            int r3 = com.google.android.libraries.places.internal.kk.c(r3, r5, r6)
            goto L_0x03c5
        L_0x03dd:
            boolean r14 = r0.a(r1, (int) r12)
            if (r14 == 0) goto L_0x04e0
            long r5 = com.google.android.libraries.places.internal.nk.b(r1, r5)
            int r3 = com.google.android.libraries.places.internal.kk.f((int) r3, (long) r5)
            goto L_0x03c5
        L_0x03ec:
            boolean r14 = r0.a(r1, (int) r12)
            if (r14 == 0) goto L_0x04e0
            int r5 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.libraries.places.internal.kk.h((int) r3, (int) r5)
            goto L_0x03c5
        L_0x03fb:
            boolean r5 = r0.a(r1, (int) r12)
            if (r5 == 0) goto L_0x04e0
            int r3 = com.google.android.libraries.places.internal.kk.h((int) r3, (long) r9)
            goto L_0x03c5
        L_0x0406:
            boolean r5 = r0.a(r1, (int) r12)
            if (r5 == 0) goto L_0x04e0
            int r3 = com.google.android.libraries.places.internal.kk.j(r3, r11)
            goto L_0x03c5
        L_0x0411:
            boolean r14 = r0.a(r1, (int) r12)
            if (r14 == 0) goto L_0x04e0
            int r5 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.libraries.places.internal.kk.k(r3, r5)
            goto L_0x03c5
        L_0x0420:
            boolean r14 = r0.a(r1, (int) r12)
            if (r14 == 0) goto L_0x04e0
            int r5 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.libraries.places.internal.kk.g((int) r3, (int) r5)
            goto L_0x03c5
        L_0x042f:
            boolean r14 = r0.a(r1, (int) r12)
            if (r14 == 0) goto L_0x04e0
            java.lang.Object r5 = com.google.android.libraries.places.internal.nk.f(r1, r5)
            com.google.android.libraries.places.internal.kc r5 = (com.google.android.libraries.places.internal.kc) r5
            int r3 = com.google.android.libraries.places.internal.kk.c((int) r3, (com.google.android.libraries.places.internal.kc) r5)
            goto L_0x03c5
        L_0x0440:
            boolean r14 = r0.a(r1, (int) r12)
            if (r14 == 0) goto L_0x04e0
            java.lang.Object r5 = com.google.android.libraries.places.internal.nk.f(r1, r5)
            com.google.android.libraries.places.internal.mp r6 = r0.a((int) r12)
            int r3 = com.google.android.libraries.places.internal.mr.a((int) r3, (java.lang.Object) r5, (com.google.android.libraries.places.internal.mp) r6)
            goto L_0x03c5
        L_0x0454:
            boolean r14 = r0.a(r1, (int) r12)
            if (r14 == 0) goto L_0x04e0
            java.lang.Object r5 = com.google.android.libraries.places.internal.nk.f(r1, r5)
            boolean r6 = r5 instanceof com.google.android.libraries.places.internal.kc
            if (r6 == 0) goto L_0x046a
            com.google.android.libraries.places.internal.kc r5 = (com.google.android.libraries.places.internal.kc) r5
            int r3 = com.google.android.libraries.places.internal.kk.c((int) r3, (com.google.android.libraries.places.internal.kc) r5)
            goto L_0x03c5
        L_0x046a:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.libraries.places.internal.kk.b((int) r3, (java.lang.String) r5)
            goto L_0x03c5
        L_0x0472:
            boolean r5 = r0.a(r1, (int) r12)
            if (r5 == 0) goto L_0x04e0
            int r3 = com.google.android.libraries.places.internal.kk.b((int) r3, (boolean) r8)
            goto L_0x03c5
        L_0x047e:
            boolean r5 = r0.a(r1, (int) r12)
            if (r5 == 0) goto L_0x04e0
            int r3 = com.google.android.libraries.places.internal.kk.i(r3, r11)
            goto L_0x03c5
        L_0x048a:
            boolean r5 = r0.a(r1, (int) r12)
            if (r5 == 0) goto L_0x04e0
            int r3 = com.google.android.libraries.places.internal.kk.g((int) r3, (long) r9)
            goto L_0x03c5
        L_0x0496:
            boolean r14 = r0.a(r1, (int) r12)
            if (r14 == 0) goto L_0x04e0
            int r5 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.libraries.places.internal.kk.f((int) r3, (int) r5)
            goto L_0x03c5
        L_0x04a6:
            boolean r14 = r0.a(r1, (int) r12)
            if (r14 == 0) goto L_0x04e0
            long r5 = com.google.android.libraries.places.internal.nk.b(r1, r5)
            int r3 = com.google.android.libraries.places.internal.kk.e((int) r3, (long) r5)
            goto L_0x03c5
        L_0x04b6:
            boolean r14 = r0.a(r1, (int) r12)
            if (r14 == 0) goto L_0x04e0
            long r5 = com.google.android.libraries.places.internal.nk.b(r1, r5)
            int r3 = com.google.android.libraries.places.internal.kk.d((int) r3, (long) r5)
            goto L_0x03c5
        L_0x04c6:
            boolean r5 = r0.a(r1, (int) r12)
            if (r5 == 0) goto L_0x04e0
            int r3 = com.google.android.libraries.places.internal.kk.b((int) r3, (float) r4)
            goto L_0x03c5
        L_0x04d2:
            boolean r5 = r0.a(r1, (int) r12)
            if (r5 == 0) goto L_0x04e0
            r5 = 0
            int r3 = com.google.android.libraries.places.internal.kk.b((int) r3, (double) r5)
            goto L_0x03c5
        L_0x04e0:
            int r12 = r12 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0016
        L_0x04e6:
            com.google.android.libraries.places.internal.nf<?, ?> r2 = r0.q
            int r1 = a(r2, r1)
            int r13 = r13 + r1
            return r13
        L_0x04ee:
            sun.misc.Unsafe r2 = f12956b
            r3 = -1
            r3 = 0
            r5 = 0
            r6 = -1
            r12 = 0
        L_0x04f5:
            int[] r13 = r0.f12957c
            int r13 = r13.length
            if (r3 >= r13) goto L_0x0a37
            int r13 = r0.c((int) r3)
            int[] r14 = r0.f12957c
            r15 = r14[r3]
            r16 = 267386880(0xff00000, float:2.3665827E-29)
            r17 = r13 & r16
            int r4 = r17 >>> 20
            r11 = 17
            if (r4 > r11) goto L_0x0521
            int r11 = r3 + 2
            r11 = r14[r11]
            r14 = r11 & r7
            int r18 = r11 >>> 20
            int r18 = r8 << r18
            if (r14 == r6) goto L_0x051e
            long r8 = (long) r14
            int r12 = r2.getInt(r1, r8)
            goto L_0x051f
        L_0x051e:
            r14 = r6
        L_0x051f:
            r6 = r14
            goto L_0x053d
        L_0x0521:
            boolean r8 = r0.k
            if (r8 == 0) goto L_0x053a
            com.google.android.libraries.places.internal.kr r8 = com.google.android.libraries.places.internal.kr.DOUBLE_LIST_PACKED
            int r8 = r8.h
            if (r4 < r8) goto L_0x053a
            com.google.android.libraries.places.internal.kr r8 = com.google.android.libraries.places.internal.kr.SINT64_LIST_PACKED
            int r8 = r8.h
            if (r4 > r8) goto L_0x053a
            int[] r8 = r0.f12957c
            int r9 = r3 + 2
            r8 = r8[r9]
            r11 = r8 & r7
            goto L_0x053b
        L_0x053a:
            r11 = 0
        L_0x053b:
            r18 = 0
        L_0x053d:
            r8 = r13 & r7
            long r8 = (long) r8
            switch(r4) {
                case 0: goto L_0x0a1c;
                case 1: goto L_0x0a0b;
                case 2: goto L_0x09f9;
                case 3: goto L_0x09e8;
                case 4: goto L_0x09d7;
                case 5: goto L_0x09c7;
                case 6: goto L_0x09b7;
                case 7: goto L_0x09ab;
                case 8: goto L_0x098f;
                case 9: goto L_0x097d;
                case 10: goto L_0x096e;
                case 11: goto L_0x0961;
                case 12: goto L_0x0954;
                case 13: goto L_0x0949;
                case 14: goto L_0x093e;
                case 15: goto L_0x0931;
                case 16: goto L_0x0924;
                case 17: goto L_0x0911;
                case 18: goto L_0x08fd;
                case 19: goto L_0x08ed;
                case 20: goto L_0x08e1;
                case 21: goto L_0x08d5;
                case 22: goto L_0x08c9;
                case 23: goto L_0x08bd;
                case 24: goto L_0x08b1;
                case 25: goto L_0x08a5;
                case 26: goto L_0x089a;
                case 27: goto L_0x088a;
                case 28: goto L_0x087e;
                case 29: goto L_0x0871;
                case 30: goto L_0x0864;
                case 31: goto L_0x0857;
                case 32: goto L_0x084a;
                case 33: goto L_0x083d;
                case 34: goto L_0x0830;
                case 35: goto L_0x0810;
                case 36: goto L_0x07f3;
                case 37: goto L_0x07d6;
                case 38: goto L_0x07b9;
                case 39: goto L_0x079b;
                case 40: goto L_0x077d;
                case 41: goto L_0x075f;
                case 42: goto L_0x0741;
                case 43: goto L_0x0723;
                case 44: goto L_0x0705;
                case 45: goto L_0x06e7;
                case 46: goto L_0x06c9;
                case 47: goto L_0x06ab;
                case 48: goto L_0x068d;
                case 49: goto L_0x067d;
                case 50: goto L_0x066d;
                case 51: goto L_0x065f;
                case 52: goto L_0x0652;
                case 53: goto L_0x0642;
                case 54: goto L_0x0632;
                case 55: goto L_0x0622;
                case 56: goto L_0x0614;
                case 57: goto L_0x0607;
                case 58: goto L_0x05fa;
                case 59: goto L_0x05dc;
                case 60: goto L_0x05c8;
                case 61: goto L_0x05b6;
                case 62: goto L_0x05a6;
                case 63: goto L_0x0596;
                case 64: goto L_0x0589;
                case 65: goto L_0x057b;
                case 66: goto L_0x056b;
                case 67: goto L_0x055b;
                case 68: goto L_0x0545;
                default: goto L_0x0543;
            }
        L_0x0543:
            goto L_0x0909
        L_0x0545:
            boolean r4 = r0.a(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0909
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.libraries.places.internal.ma r4 = (com.google.android.libraries.places.internal.ma) r4
            com.google.android.libraries.places.internal.mp r8 = r0.a((int) r3)
            int r4 = com.google.android.libraries.places.internal.kk.c(r15, r4, r8)
            goto L_0x0908
        L_0x055b:
            boolean r4 = r0.a(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0909
            long r8 = e(r1, r8)
            int r4 = com.google.android.libraries.places.internal.kk.f((int) r15, (long) r8)
            goto L_0x0908
        L_0x056b:
            boolean r4 = r0.a(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0909
            int r4 = d(r1, r8)
            int r4 = com.google.android.libraries.places.internal.kk.h((int) r15, (int) r4)
            goto L_0x0908
        L_0x057b:
            boolean r4 = r0.a(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0909
            r8 = 0
            int r4 = com.google.android.libraries.places.internal.kk.h((int) r15, (long) r8)
            goto L_0x0908
        L_0x0589:
            boolean r4 = r0.a(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0909
            r4 = 0
            int r8 = com.google.android.libraries.places.internal.kk.j(r15, r4)
            goto L_0x0952
        L_0x0596:
            boolean r4 = r0.a(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0909
            int r4 = d(r1, r8)
            int r4 = com.google.android.libraries.places.internal.kk.k(r15, r4)
            goto L_0x0908
        L_0x05a6:
            boolean r4 = r0.a(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0909
            int r4 = d(r1, r8)
            int r4 = com.google.android.libraries.places.internal.kk.g((int) r15, (int) r4)
            goto L_0x0908
        L_0x05b6:
            boolean r4 = r0.a(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0909
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.libraries.places.internal.kc r4 = (com.google.android.libraries.places.internal.kc) r4
            int r4 = com.google.android.libraries.places.internal.kk.c((int) r15, (com.google.android.libraries.places.internal.kc) r4)
            goto L_0x0908
        L_0x05c8:
            boolean r4 = r0.a(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0909
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.libraries.places.internal.mp r8 = r0.a((int) r3)
            int r4 = com.google.android.libraries.places.internal.mr.a((int) r15, (java.lang.Object) r4, (com.google.android.libraries.places.internal.mp) r8)
            goto L_0x0908
        L_0x05dc:
            boolean r4 = r0.a(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0909
            java.lang.Object r4 = r2.getObject(r1, r8)
            boolean r8 = r4 instanceof com.google.android.libraries.places.internal.kc
            if (r8 == 0) goto L_0x05f2
            com.google.android.libraries.places.internal.kc r4 = (com.google.android.libraries.places.internal.kc) r4
            int r4 = com.google.android.libraries.places.internal.kk.c((int) r15, (com.google.android.libraries.places.internal.kc) r4)
            goto L_0x0908
        L_0x05f2:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.libraries.places.internal.kk.b((int) r15, (java.lang.String) r4)
            goto L_0x0908
        L_0x05fa:
            boolean r4 = r0.a(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0909
            r4 = 1
            int r8 = com.google.android.libraries.places.internal.kk.b((int) r15, (boolean) r4)
            goto L_0x0952
        L_0x0607:
            boolean r4 = r0.a(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0909
            r4 = 0
            int r8 = com.google.android.libraries.places.internal.kk.i(r15, r4)
            goto L_0x0952
        L_0x0614:
            boolean r4 = r0.a(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0909
            r8 = 0
            int r4 = com.google.android.libraries.places.internal.kk.g((int) r15, (long) r8)
            goto L_0x0908
        L_0x0622:
            boolean r4 = r0.a(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0909
            int r4 = d(r1, r8)
            int r4 = com.google.android.libraries.places.internal.kk.f((int) r15, (int) r4)
            goto L_0x0908
        L_0x0632:
            boolean r4 = r0.a(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0909
            long r8 = e(r1, r8)
            int r4 = com.google.android.libraries.places.internal.kk.e((int) r15, (long) r8)
            goto L_0x0908
        L_0x0642:
            boolean r4 = r0.a(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0909
            long r8 = e(r1, r8)
            int r4 = com.google.android.libraries.places.internal.kk.d((int) r15, (long) r8)
            goto L_0x0908
        L_0x0652:
            boolean r4 = r0.a(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0909
            r4 = 0
            int r8 = com.google.android.libraries.places.internal.kk.b((int) r15, (float) r4)
            goto L_0x0952
        L_0x065f:
            boolean r4 = r0.a(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0909
            r8 = 0
            int r4 = com.google.android.libraries.places.internal.kk.b((int) r15, (double) r8)
            goto L_0x0908
        L_0x066d:
            com.google.android.libraries.places.internal.lw r4 = r0.s
            java.lang.Object r8 = r2.getObject(r1, r8)
            java.lang.Object r9 = r0.b((int) r3)
            int r4 = r4.a(r15, r8, r9)
            goto L_0x0908
        L_0x067d:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.android.libraries.places.internal.mp r8 = r0.a((int) r3)
            int r4 = com.google.android.libraries.places.internal.mr.b((int) r15, (java.util.List<com.google.android.libraries.places.internal.ma>) r4, (com.google.android.libraries.places.internal.mp) r8)
            goto L_0x0908
        L_0x068d:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.c(r4)
            if (r4 <= 0) goto L_0x0909
            boolean r8 = r0.k
            if (r8 == 0) goto L_0x06a1
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x06a1:
            int r8 = com.google.android.libraries.places.internal.kk.e((int) r15)
            int r9 = com.google.android.libraries.places.internal.kk.g((int) r4)
            goto L_0x082c
        L_0x06ab:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.g(r4)
            if (r4 <= 0) goto L_0x0909
            boolean r8 = r0.k
            if (r8 == 0) goto L_0x06bf
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x06bf:
            int r8 = com.google.android.libraries.places.internal.kk.e((int) r15)
            int r9 = com.google.android.libraries.places.internal.kk.g((int) r4)
            goto L_0x082c
        L_0x06c9:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.i(r4)
            if (r4 <= 0) goto L_0x0909
            boolean r8 = r0.k
            if (r8 == 0) goto L_0x06dd
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x06dd:
            int r8 = com.google.android.libraries.places.internal.kk.e((int) r15)
            int r9 = com.google.android.libraries.places.internal.kk.g((int) r4)
            goto L_0x082c
        L_0x06e7:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.h(r4)
            if (r4 <= 0) goto L_0x0909
            boolean r8 = r0.k
            if (r8 == 0) goto L_0x06fb
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x06fb:
            int r8 = com.google.android.libraries.places.internal.kk.e((int) r15)
            int r9 = com.google.android.libraries.places.internal.kk.g((int) r4)
            goto L_0x082c
        L_0x0705:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.d(r4)
            if (r4 <= 0) goto L_0x0909
            boolean r8 = r0.k
            if (r8 == 0) goto L_0x0719
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x0719:
            int r8 = com.google.android.libraries.places.internal.kk.e((int) r15)
            int r9 = com.google.android.libraries.places.internal.kk.g((int) r4)
            goto L_0x082c
        L_0x0723:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.f(r4)
            if (r4 <= 0) goto L_0x0909
            boolean r8 = r0.k
            if (r8 == 0) goto L_0x0737
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x0737:
            int r8 = com.google.android.libraries.places.internal.kk.e((int) r15)
            int r9 = com.google.android.libraries.places.internal.kk.g((int) r4)
            goto L_0x082c
        L_0x0741:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.j(r4)
            if (r4 <= 0) goto L_0x0909
            boolean r8 = r0.k
            if (r8 == 0) goto L_0x0755
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x0755:
            int r8 = com.google.android.libraries.places.internal.kk.e((int) r15)
            int r9 = com.google.android.libraries.places.internal.kk.g((int) r4)
            goto L_0x082c
        L_0x075f:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.h(r4)
            if (r4 <= 0) goto L_0x0909
            boolean r8 = r0.k
            if (r8 == 0) goto L_0x0773
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x0773:
            int r8 = com.google.android.libraries.places.internal.kk.e((int) r15)
            int r9 = com.google.android.libraries.places.internal.kk.g((int) r4)
            goto L_0x082c
        L_0x077d:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.i(r4)
            if (r4 <= 0) goto L_0x0909
            boolean r8 = r0.k
            if (r8 == 0) goto L_0x0791
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x0791:
            int r8 = com.google.android.libraries.places.internal.kk.e((int) r15)
            int r9 = com.google.android.libraries.places.internal.kk.g((int) r4)
            goto L_0x082c
        L_0x079b:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.e(r4)
            if (r4 <= 0) goto L_0x0909
            boolean r8 = r0.k
            if (r8 == 0) goto L_0x07af
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x07af:
            int r8 = com.google.android.libraries.places.internal.kk.e((int) r15)
            int r9 = com.google.android.libraries.places.internal.kk.g((int) r4)
            goto L_0x082c
        L_0x07b9:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.b(r4)
            if (r4 <= 0) goto L_0x0909
            boolean r8 = r0.k
            if (r8 == 0) goto L_0x07cd
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x07cd:
            int r8 = com.google.android.libraries.places.internal.kk.e((int) r15)
            int r9 = com.google.android.libraries.places.internal.kk.g((int) r4)
            goto L_0x082c
        L_0x07d6:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.a((java.util.List<java.lang.Long>) r4)
            if (r4 <= 0) goto L_0x0909
            boolean r8 = r0.k
            if (r8 == 0) goto L_0x07ea
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x07ea:
            int r8 = com.google.android.libraries.places.internal.kk.e((int) r15)
            int r9 = com.google.android.libraries.places.internal.kk.g((int) r4)
            goto L_0x082c
        L_0x07f3:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.h(r4)
            if (r4 <= 0) goto L_0x0909
            boolean r8 = r0.k
            if (r8 == 0) goto L_0x0807
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x0807:
            int r8 = com.google.android.libraries.places.internal.kk.e((int) r15)
            int r9 = com.google.android.libraries.places.internal.kk.g((int) r4)
            goto L_0x082c
        L_0x0810:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.i(r4)
            if (r4 <= 0) goto L_0x0909
            boolean r8 = r0.k
            if (r8 == 0) goto L_0x0824
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x0824:
            int r8 = com.google.android.libraries.places.internal.kk.e((int) r15)
            int r9 = com.google.android.libraries.places.internal.kk.g((int) r4)
        L_0x082c:
            int r8 = r8 + r9
            int r8 = r8 + r4
            goto L_0x0952
        L_0x0830:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            r10 = 0
            int r4 = com.google.android.libraries.places.internal.mr.c(r15, r4, r10)
            goto L_0x08f8
        L_0x083d:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.g(r15, r4, r10)
            goto L_0x08f8
        L_0x084a:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.i(r15, r4, r10)
            goto L_0x08f8
        L_0x0857:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.h(r15, r4, r10)
            goto L_0x08f8
        L_0x0864:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.d(r15, r4, r10)
            goto L_0x08f8
        L_0x0871:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.f(r15, r4, r10)
            goto L_0x0908
        L_0x087e:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.b(r15, r4)
            goto L_0x0908
        L_0x088a:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.android.libraries.places.internal.mp r8 = r0.a((int) r3)
            int r4 = com.google.android.libraries.places.internal.mr.a((int) r15, (java.util.List<?>) r4, (com.google.android.libraries.places.internal.mp) r8)
            goto L_0x0908
        L_0x089a:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.a((int) r15, (java.util.List<?>) r4)
            goto L_0x0908
        L_0x08a5:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            r10 = 0
            int r4 = com.google.android.libraries.places.internal.mr.j(r15, r4, r10)
            goto L_0x08f8
        L_0x08b1:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.h(r15, r4, r10)
            goto L_0x08f8
        L_0x08bd:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.i(r15, r4, r10)
            goto L_0x08f8
        L_0x08c9:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.e(r15, r4, r10)
            goto L_0x08f8
        L_0x08d5:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.b((int) r15, (java.util.List<java.lang.Long>) r4, (boolean) r10)
            goto L_0x08f8
        L_0x08e1:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.a((int) r15, (java.util.List<java.lang.Long>) r4, (boolean) r10)
            goto L_0x08f8
        L_0x08ed:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.h(r15, r4, r10)
        L_0x08f8:
            int r5 = r5 + r4
            r4 = 1
        L_0x08fa:
            r7 = 0
            goto L_0x090d
        L_0x08fd:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.mr.i(r15, r4, r10)
        L_0x0908:
            int r5 = r5 + r4
        L_0x0909:
            r4 = 1
        L_0x090a:
            r7 = 0
            r10 = 0
        L_0x090d:
            r13 = 0
            goto L_0x0a2c
        L_0x0911:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0909
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.libraries.places.internal.ma r4 = (com.google.android.libraries.places.internal.ma) r4
            com.google.android.libraries.places.internal.mp r8 = r0.a((int) r3)
            int r4 = com.google.android.libraries.places.internal.kk.c(r15, r4, r8)
            goto L_0x0908
        L_0x0924:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0909
            long r8 = r2.getLong(r1, r8)
            int r4 = com.google.android.libraries.places.internal.kk.f((int) r15, (long) r8)
            goto L_0x0908
        L_0x0931:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0909
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.libraries.places.internal.kk.h((int) r15, (int) r4)
            goto L_0x0908
        L_0x093e:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0909
            r8 = 0
            int r4 = com.google.android.libraries.places.internal.kk.h((int) r15, (long) r8)
            goto L_0x0908
        L_0x0949:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0909
            r4 = 0
            int r8 = com.google.android.libraries.places.internal.kk.j(r15, r4)
        L_0x0952:
            int r5 = r5 + r8
            goto L_0x0909
        L_0x0954:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0909
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.libraries.places.internal.kk.k(r15, r4)
            goto L_0x0908
        L_0x0961:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0909
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.libraries.places.internal.kk.g((int) r15, (int) r4)
            goto L_0x0908
        L_0x096e:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0909
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.libraries.places.internal.kc r4 = (com.google.android.libraries.places.internal.kc) r4
            int r4 = com.google.android.libraries.places.internal.kk.c((int) r15, (com.google.android.libraries.places.internal.kc) r4)
            goto L_0x0908
        L_0x097d:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0909
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.libraries.places.internal.mp r8 = r0.a((int) r3)
            int r4 = com.google.android.libraries.places.internal.mr.a((int) r15, (java.lang.Object) r4, (com.google.android.libraries.places.internal.mp) r8)
            goto L_0x0908
        L_0x098f:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0909
            java.lang.Object r4 = r2.getObject(r1, r8)
            boolean r8 = r4 instanceof com.google.android.libraries.places.internal.kc
            if (r8 == 0) goto L_0x09a3
            com.google.android.libraries.places.internal.kc r4 = (com.google.android.libraries.places.internal.kc) r4
            int r4 = com.google.android.libraries.places.internal.kk.c((int) r15, (com.google.android.libraries.places.internal.kc) r4)
            goto L_0x0908
        L_0x09a3:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.libraries.places.internal.kk.b((int) r15, (java.lang.String) r4)
            goto L_0x0908
        L_0x09ab:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0909
            r4 = 1
            int r8 = com.google.android.libraries.places.internal.kk.b((int) r15, (boolean) r4)
            int r5 = r5 + r8
            goto L_0x090a
        L_0x09b7:
            r4 = 1
            r8 = r12 & r18
            if (r8 == 0) goto L_0x09c4
            r10 = 0
            int r8 = com.google.android.libraries.places.internal.kk.i(r15, r10)
            int r5 = r5 + r8
            goto L_0x08fa
        L_0x09c4:
            r10 = 0
            goto L_0x08fa
        L_0x09c7:
            r4 = 1
            r10 = 0
            r8 = r12 & r18
            if (r8 == 0) goto L_0x09d4
            r13 = 0
            int r8 = com.google.android.libraries.places.internal.kk.g((int) r15, (long) r13)
            goto L_0x0a09
        L_0x09d4:
            r13 = 0
            goto L_0x0a19
        L_0x09d7:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a19
            int r8 = r2.getInt(r1, r8)
            int r8 = com.google.android.libraries.places.internal.kk.f((int) r15, (int) r8)
            goto L_0x0a09
        L_0x09e8:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a19
            long r8 = r2.getLong(r1, r8)
            int r8 = com.google.android.libraries.places.internal.kk.e((int) r15, (long) r8)
            goto L_0x0a09
        L_0x09f9:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a19
            long r8 = r2.getLong(r1, r8)
            int r8 = com.google.android.libraries.places.internal.kk.d((int) r15, (long) r8)
        L_0x0a09:
            int r5 = r5 + r8
            goto L_0x0a19
        L_0x0a0b:
            r4 = 1
            r10 = 0
            r13 = 0
            r8 = r12 & r18
            if (r8 == 0) goto L_0x0a19
            r8 = 0
            int r9 = com.google.android.libraries.places.internal.kk.b((int) r15, (float) r8)
            int r5 = r5 + r9
        L_0x0a19:
            r7 = 0
            goto L_0x0a2c
        L_0x0a1c:
            r4 = 1
            r8 = 0
            r10 = 0
            r13 = 0
            r9 = r12 & r18
            if (r9 == 0) goto L_0x0a19
            r7 = 0
            int r11 = com.google.android.libraries.places.internal.kk.b((int) r15, (double) r7)
            int r5 = r5 + r11
        L_0x0a2c:
            int r3 = r3 + 3
            r9 = r13
            r4 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 1
            r11 = 0
            goto L_0x04f5
        L_0x0a37:
            r10 = 0
            com.google.android.libraries.places.internal.nf<?, ?> r2 = r0.q
            int r2 = a(r2, r1)
            int r5 = r5 + r2
            boolean r2 = r0.h
            if (r2 == 0) goto L_0x0a91
            com.google.android.libraries.places.internal.kn<?> r2 = r0.r
            com.google.android.libraries.places.internal.kp r1 = r2.a((java.lang.Object) r1)
            r2 = 0
        L_0x0a4a:
            com.google.android.libraries.places.internal.ms<FieldDescriptorType, java.lang.Object> r3 = r1.f12885a
            int r3 = r3.b()
            if (r10 >= r3) goto L_0x0a6a
            com.google.android.libraries.places.internal.ms<FieldDescriptorType, java.lang.Object> r3 = r1.f12885a
            java.util.Map$Entry r3 = r3.b(r10)
            java.lang.Object r4 = r3.getKey()
            com.google.android.libraries.places.internal.kq r4 = (com.google.android.libraries.places.internal.kq) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.libraries.places.internal.kp.b((com.google.android.libraries.places.internal.kq<?>) r4, (java.lang.Object) r3)
            int r2 = r2 + r3
            int r10 = r10 + 1
            goto L_0x0a4a
        L_0x0a6a:
            com.google.android.libraries.places.internal.ms<FieldDescriptorType, java.lang.Object> r1 = r1.f12885a
            java.lang.Iterable r1 = r1.c()
            java.util.Iterator r1 = r1.iterator()
        L_0x0a74:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0a90
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            com.google.android.libraries.places.internal.kq r4 = (com.google.android.libraries.places.internal.kq) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.libraries.places.internal.kp.b((com.google.android.libraries.places.internal.kq<?>) r4, (java.lang.Object) r3)
            int r2 = r2 + r3
            goto L_0x0a74
        L_0x0a90:
            int r5 = r5 + r2
        L_0x0a91:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.md.b(java.lang.Object):int");
    }

    private static <UT, UB> int a(nf<UT, UB> nfVar, T t) {
        return nfVar.d(nfVar.a((Object) t));
    }

    private static <E> List<E> a(Object obj, long j2) {
        return (List) nk.f(obj, j2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x052e  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x056e  */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x0a46  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(T r14, com.google.android.libraries.places.internal.nt r15) throws java.io.IOException {
        /*
            r13 = this;
            com.google.android.libraries.places.internal.nu r0 = r15.a()
            com.google.android.libraries.places.internal.nu r1 = com.google.android.libraries.places.internal.nu.DESCENDING
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0544
            com.google.android.libraries.places.internal.nf<?, ?> r0 = r13.q
            a(r0, r14, (com.google.android.libraries.places.internal.nt) r15)
            boolean r0 = r13.h
            if (r0 == 0) goto L_0x004d
            com.google.android.libraries.places.internal.kn<?> r0 = r13.r
            com.google.android.libraries.places.internal.kp r0 = r0.a((java.lang.Object) r14)
            com.google.android.libraries.places.internal.ms<FieldDescriptorType, java.lang.Object> r1 = r0.f12885a
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x004d
            boolean r1 = r0.f12887c
            if (r1 == 0) goto L_0x003c
            com.google.android.libraries.places.internal.li r1 = new com.google.android.libraries.places.internal.li
            com.google.android.libraries.places.internal.ms<FieldDescriptorType, java.lang.Object> r0 = r0.f12885a
            java.util.Set r0 = r0.d()
            java.util.Iterator r0 = r0.iterator()
            r1.<init>(r0)
            r0 = r1
            goto L_0x0046
        L_0x003c:
            com.google.android.libraries.places.internal.ms<FieldDescriptorType, java.lang.Object> r0 = r0.f12885a
            java.util.Set r0 = r0.d()
            java.util.Iterator r0 = r0.iterator()
        L_0x0046:
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x004f
        L_0x004d:
            r0 = r3
            r1 = r0
        L_0x004f:
            int[] r7 = r13.f12957c
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0054:
            if (r7 < 0) goto L_0x052c
            int r8 = r13.c((int) r7)
            int[] r9 = r13.f12957c
            r9 = r9[r7]
        L_0x005e:
            if (r1 == 0) goto L_0x007c
            com.google.android.libraries.places.internal.kn<?> r10 = r13.r
            int r10 = r10.a((java.util.Map.Entry<?, ?>) r1)
            if (r10 <= r9) goto L_0x007c
            com.google.android.libraries.places.internal.kn<?> r10 = r13.r
            r10.a(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x007a
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x005e
        L_0x007a:
            r1 = r3
            goto L_0x005e
        L_0x007c:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x0519;
                case 1: goto L_0x0509;
                case 2: goto L_0x04f9;
                case 3: goto L_0x04e9;
                case 4: goto L_0x04d9;
                case 5: goto L_0x04c9;
                case 6: goto L_0x04b9;
                case 7: goto L_0x04a8;
                case 8: goto L_0x0497;
                case 9: goto L_0x0482;
                case 10: goto L_0x046f;
                case 11: goto L_0x045e;
                case 12: goto L_0x044d;
                case 13: goto L_0x043c;
                case 14: goto L_0x042b;
                case 15: goto L_0x041a;
                case 16: goto L_0x0409;
                case 17: goto L_0x03f4;
                case 18: goto L_0x03e3;
                case 19: goto L_0x03d2;
                case 20: goto L_0x03c1;
                case 21: goto L_0x03b0;
                case 22: goto L_0x039f;
                case 23: goto L_0x038e;
                case 24: goto L_0x037d;
                case 25: goto L_0x036c;
                case 26: goto L_0x035b;
                case 27: goto L_0x0346;
                case 28: goto L_0x0335;
                case 29: goto L_0x0324;
                case 30: goto L_0x0313;
                case 31: goto L_0x0302;
                case 32: goto L_0x02f1;
                case 33: goto L_0x02e0;
                case 34: goto L_0x02cf;
                case 35: goto L_0x02be;
                case 36: goto L_0x02ad;
                case 37: goto L_0x029c;
                case 38: goto L_0x028b;
                case 39: goto L_0x027a;
                case 40: goto L_0x0269;
                case 41: goto L_0x0258;
                case 42: goto L_0x0247;
                case 43: goto L_0x0236;
                case 44: goto L_0x0225;
                case 45: goto L_0x0214;
                case 46: goto L_0x0203;
                case 47: goto L_0x01f2;
                case 48: goto L_0x01e1;
                case 49: goto L_0x01cc;
                case 50: goto L_0x01c1;
                case 51: goto L_0x01b0;
                case 52: goto L_0x019f;
                case 53: goto L_0x018e;
                case 54: goto L_0x017d;
                case 55: goto L_0x016c;
                case 56: goto L_0x015b;
                case 57: goto L_0x014a;
                case 58: goto L_0x0139;
                case 59: goto L_0x0128;
                case 60: goto L_0x0113;
                case 61: goto L_0x0100;
                case 62: goto L_0x00ef;
                case 63: goto L_0x00de;
                case 64: goto L_0x00cd;
                case 65: goto L_0x00bc;
                case 66: goto L_0x00ab;
                case 67: goto L_0x009a;
                case 68: goto L_0x0085;
                default: goto L_0x0083;
            }
        L_0x0083:
            goto L_0x0528
        L_0x0085:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            com.google.android.libraries.places.internal.mp r10 = r13.a((int) r7)
            r15.b((int) r9, (java.lang.Object) r8, (com.google.android.libraries.places.internal.mp) r10)
            goto L_0x0528
        L_0x009a:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = e(r14, r10)
            r15.e((int) r9, (long) r10)
            goto L_0x0528
        L_0x00ab:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = d(r14, r10)
            r15.f(r9, r8)
            goto L_0x0528
        L_0x00bc:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = e(r14, r10)
            r15.b((int) r9, (long) r10)
            goto L_0x0528
        L_0x00cd:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = d(r14, r10)
            r15.a((int) r9, (int) r8)
            goto L_0x0528
        L_0x00de:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = d(r14, r10)
            r15.b((int) r9, (int) r8)
            goto L_0x0528
        L_0x00ef:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = d(r14, r10)
            r15.e((int) r9, (int) r8)
            goto L_0x0528
        L_0x0100:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            com.google.android.libraries.places.internal.kc r8 = (com.google.android.libraries.places.internal.kc) r8
            r15.a((int) r9, (com.google.android.libraries.places.internal.kc) r8)
            goto L_0x0528
        L_0x0113:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            com.google.android.libraries.places.internal.mp r10 = r13.a((int) r7)
            r15.a((int) r9, (java.lang.Object) r8, (com.google.android.libraries.places.internal.mp) r10)
            goto L_0x0528
        L_0x0128:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            a((int) r9, (java.lang.Object) r8, (com.google.android.libraries.places.internal.nt) r15)
            goto L_0x0528
        L_0x0139:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = f(r14, r10)
            r15.a((int) r9, (boolean) r8)
            goto L_0x0528
        L_0x014a:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = d(r14, r10)
            r15.d((int) r9, (int) r8)
            goto L_0x0528
        L_0x015b:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = e(r14, r10)
            r15.d((int) r9, (long) r10)
            goto L_0x0528
        L_0x016c:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = d(r14, r10)
            r15.c((int) r9, (int) r8)
            goto L_0x0528
        L_0x017d:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = e(r14, r10)
            r15.c((int) r9, (long) r10)
            goto L_0x0528
        L_0x018e:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = e(r14, r10)
            r15.a((int) r9, (long) r10)
            goto L_0x0528
        L_0x019f:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = c(r14, r10)
            r15.a((int) r9, (float) r8)
            goto L_0x0528
        L_0x01b0:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = b(r14, (long) r10)
            r15.a((int) r9, (double) r10)
            goto L_0x0528
        L_0x01c1:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            r13.a((com.google.android.libraries.places.internal.nt) r15, (int) r9, (java.lang.Object) r8, (int) r7)
            goto L_0x0528
        L_0x01cc:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mp r10 = r13.a((int) r7)
            com.google.android.libraries.places.internal.mr.b((int) r9, (java.util.List<?>) r8, (com.google.android.libraries.places.internal.nt) r15, (com.google.android.libraries.places.internal.mp) r10)
            goto L_0x0528
        L_0x01e1:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.e(r9, r8, r15, r4)
            goto L_0x0528
        L_0x01f2:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.j(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0203:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.g(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0214:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.l(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0225:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.m(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0236:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.i(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0247:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.n(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0258:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.k(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0269:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.f(r9, r8, r15, r4)
            goto L_0x0528
        L_0x027a:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.h(r9, r8, r15, r4)
            goto L_0x0528
        L_0x028b:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.d(r9, r8, r15, r4)
            goto L_0x0528
        L_0x029c:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.c(r9, r8, r15, r4)
            goto L_0x0528
        L_0x02ad:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.b((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.libraries.places.internal.nt) r15, (boolean) r4)
            goto L_0x0528
        L_0x02be:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.a((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.libraries.places.internal.nt) r15, (boolean) r4)
            goto L_0x0528
        L_0x02cf:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.e(r9, r8, r15, r5)
            goto L_0x0528
        L_0x02e0:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.j(r9, r8, r15, r5)
            goto L_0x0528
        L_0x02f1:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.g(r9, r8, r15, r5)
            goto L_0x0528
        L_0x0302:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.l(r9, r8, r15, r5)
            goto L_0x0528
        L_0x0313:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.m(r9, r8, r15, r5)
            goto L_0x0528
        L_0x0324:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.i(r9, r8, r15, r5)
            goto L_0x0528
        L_0x0335:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.b((int) r9, (java.util.List<com.google.android.libraries.places.internal.kc>) r8, (com.google.android.libraries.places.internal.nt) r15)
            goto L_0x0528
        L_0x0346:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mp r10 = r13.a((int) r7)
            com.google.android.libraries.places.internal.mr.a((int) r9, (java.util.List<?>) r8, (com.google.android.libraries.places.internal.nt) r15, (com.google.android.libraries.places.internal.mp) r10)
            goto L_0x0528
        L_0x035b:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.a((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.libraries.places.internal.nt) r15)
            goto L_0x0528
        L_0x036c:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.n(r9, r8, r15, r5)
            goto L_0x0528
        L_0x037d:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.k(r9, r8, r15, r5)
            goto L_0x0528
        L_0x038e:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.f(r9, r8, r15, r5)
            goto L_0x0528
        L_0x039f:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.h(r9, r8, r15, r5)
            goto L_0x0528
        L_0x03b0:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.d(r9, r8, r15, r5)
            goto L_0x0528
        L_0x03c1:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.c(r9, r8, r15, r5)
            goto L_0x0528
        L_0x03d2:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.b((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.libraries.places.internal.nt) r15, (boolean) r5)
            goto L_0x0528
        L_0x03e3:
            int[] r9 = r13.f12957c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.mr.a((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.libraries.places.internal.nt) r15, (boolean) r5)
            goto L_0x0528
        L_0x03f4:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            com.google.android.libraries.places.internal.mp r10 = r13.a((int) r7)
            r15.b((int) r9, (java.lang.Object) r8, (com.google.android.libraries.places.internal.mp) r10)
            goto L_0x0528
        L_0x0409:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.libraries.places.internal.nk.b(r14, r10)
            r15.e((int) r9, (long) r10)
            goto L_0x0528
        L_0x041a:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r14, (long) r10)
            r15.f(r9, r8)
            goto L_0x0528
        L_0x042b:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.libraries.places.internal.nk.b(r14, r10)
            r15.b((int) r9, (long) r10)
            goto L_0x0528
        L_0x043c:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r14, (long) r10)
            r15.a((int) r9, (int) r8)
            goto L_0x0528
        L_0x044d:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r14, (long) r10)
            r15.b((int) r9, (int) r8)
            goto L_0x0528
        L_0x045e:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r14, (long) r10)
            r15.e((int) r9, (int) r8)
            goto L_0x0528
        L_0x046f:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            com.google.android.libraries.places.internal.kc r8 = (com.google.android.libraries.places.internal.kc) r8
            r15.a((int) r9, (com.google.android.libraries.places.internal.kc) r8)
            goto L_0x0528
        L_0x0482:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            com.google.android.libraries.places.internal.mp r10 = r13.a((int) r7)
            r15.a((int) r9, (java.lang.Object) r8, (com.google.android.libraries.places.internal.mp) r10)
            goto L_0x0528
        L_0x0497:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.nk.f(r14, r10)
            a((int) r9, (java.lang.Object) r8, (com.google.android.libraries.places.internal.nt) r15)
            goto L_0x0528
        L_0x04a8:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.libraries.places.internal.nk.c(r14, r10)
            r15.a((int) r9, (boolean) r8)
            goto L_0x0528
        L_0x04b9:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r14, (long) r10)
            r15.d((int) r9, (int) r8)
            goto L_0x0528
        L_0x04c9:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.libraries.places.internal.nk.b(r14, r10)
            r15.d((int) r9, (long) r10)
            goto L_0x0528
        L_0x04d9:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r14, (long) r10)
            r15.c((int) r9, (int) r8)
            goto L_0x0528
        L_0x04e9:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.libraries.places.internal.nk.b(r14, r10)
            r15.c((int) r9, (long) r10)
            goto L_0x0528
        L_0x04f9:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.libraries.places.internal.nk.b(r14, r10)
            r15.a((int) r9, (long) r10)
            goto L_0x0528
        L_0x0509:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.libraries.places.internal.nk.d(r14, r10)
            r15.a((int) r9, (float) r8)
            goto L_0x0528
        L_0x0519:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.libraries.places.internal.nk.e(r14, r10)
            r15.a((int) r9, (double) r10)
        L_0x0528:
            int r7 = r7 + -3
            goto L_0x0054
        L_0x052c:
            if (r1 == 0) goto L_0x0543
            com.google.android.libraries.places.internal.kn<?> r14 = r13.r
            r14.a(r15, r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x0541
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x052c
        L_0x0541:
            r1 = r3
            goto L_0x052c
        L_0x0543:
            return
        L_0x0544:
            boolean r0 = r13.j
            if (r0 == 0) goto L_0x0a61
            boolean r0 = r13.h
            if (r0 == 0) goto L_0x0565
            com.google.android.libraries.places.internal.kn<?> r0 = r13.r
            com.google.android.libraries.places.internal.kp r0 = r0.a((java.lang.Object) r14)
            com.google.android.libraries.places.internal.ms<FieldDescriptorType, java.lang.Object> r1 = r0.f12885a
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0565
            java.util.Iterator r0 = r0.b()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0567
        L_0x0565:
            r0 = r3
            r1 = r0
        L_0x0567:
            int[] r7 = r13.f12957c
            int r7 = r7.length
            r8 = r1
            r1 = 0
        L_0x056c:
            if (r1 >= r7) goto L_0x0a44
            int r9 = r13.c((int) r1)
            int[] r10 = r13.f12957c
            r10 = r10[r1]
        L_0x0576:
            if (r8 == 0) goto L_0x0594
            com.google.android.libraries.places.internal.kn<?> r11 = r13.r
            int r11 = r11.a((java.util.Map.Entry<?, ?>) r8)
            if (r11 > r10) goto L_0x0594
            com.google.android.libraries.places.internal.kn<?> r11 = r13.r
            r11.a(r15, r8)
            boolean r8 = r0.hasNext()
            if (r8 == 0) goto L_0x0592
            java.lang.Object r8 = r0.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            goto L_0x0576
        L_0x0592:
            r8 = r3
            goto L_0x0576
        L_0x0594:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0a31;
                case 1: goto L_0x0a21;
                case 2: goto L_0x0a11;
                case 3: goto L_0x0a01;
                case 4: goto L_0x09f1;
                case 5: goto L_0x09e1;
                case 6: goto L_0x09d1;
                case 7: goto L_0x09c0;
                case 8: goto L_0x09af;
                case 9: goto L_0x099a;
                case 10: goto L_0x0987;
                case 11: goto L_0x0976;
                case 12: goto L_0x0965;
                case 13: goto L_0x0954;
                case 14: goto L_0x0943;
                case 15: goto L_0x0932;
                case 16: goto L_0x0921;
                case 17: goto L_0x090c;
                case 18: goto L_0x08fb;
                case 19: goto L_0x08ea;
                case 20: goto L_0x08d9;
                case 21: goto L_0x08c8;
                case 22: goto L_0x08b7;
                case 23: goto L_0x08a6;
                case 24: goto L_0x0895;
                case 25: goto L_0x0884;
                case 26: goto L_0x0873;
                case 27: goto L_0x085e;
                case 28: goto L_0x084d;
                case 29: goto L_0x083c;
                case 30: goto L_0x082b;
                case 31: goto L_0x081a;
                case 32: goto L_0x0809;
                case 33: goto L_0x07f8;
                case 34: goto L_0x07e7;
                case 35: goto L_0x07d6;
                case 36: goto L_0x07c5;
                case 37: goto L_0x07b4;
                case 38: goto L_0x07a3;
                case 39: goto L_0x0792;
                case 40: goto L_0x0781;
                case 41: goto L_0x0770;
                case 42: goto L_0x075f;
                case 43: goto L_0x074e;
                case 44: goto L_0x073d;
                case 45: goto L_0x072c;
                case 46: goto L_0x071b;
                case 47: goto L_0x070a;
                case 48: goto L_0x06f9;
                case 49: goto L_0x06e4;
                case 50: goto L_0x06d9;
                case 51: goto L_0x06c8;
                case 52: goto L_0x06b7;
                case 53: goto L_0x06a6;
                case 54: goto L_0x0695;
                case 55: goto L_0x0684;
                case 56: goto L_0x0673;
                case 57: goto L_0x0662;
                case 58: goto L_0x0651;
                case 59: goto L_0x0640;
                case 60: goto L_0x062b;
                case 61: goto L_0x0618;
                case 62: goto L_0x0607;
                case 63: goto L_0x05f6;
                case 64: goto L_0x05e5;
                case 65: goto L_0x05d4;
                case 66: goto L_0x05c3;
                case 67: goto L_0x05b2;
                case 68: goto L_0x059d;
                default: goto L_0x059b;
            }
        L_0x059b:
            goto L_0x0a40
        L_0x059d:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            com.google.android.libraries.places.internal.mp r11 = r13.a((int) r1)
            r15.b((int) r10, (java.lang.Object) r9, (com.google.android.libraries.places.internal.mp) r11)
            goto L_0x0a40
        L_0x05b2:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = e(r14, r11)
            r15.e((int) r10, (long) r11)
            goto L_0x0a40
        L_0x05c3:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = d(r14, r11)
            r15.f(r10, r9)
            goto L_0x0a40
        L_0x05d4:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = e(r14, r11)
            r15.b((int) r10, (long) r11)
            goto L_0x0a40
        L_0x05e5:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = d(r14, r11)
            r15.a((int) r10, (int) r9)
            goto L_0x0a40
        L_0x05f6:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = d(r14, r11)
            r15.b((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0607:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = d(r14, r11)
            r15.e((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0618:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            com.google.android.libraries.places.internal.kc r9 = (com.google.android.libraries.places.internal.kc) r9
            r15.a((int) r10, (com.google.android.libraries.places.internal.kc) r9)
            goto L_0x0a40
        L_0x062b:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            com.google.android.libraries.places.internal.mp r11 = r13.a((int) r1)
            r15.a((int) r10, (java.lang.Object) r9, (com.google.android.libraries.places.internal.mp) r11)
            goto L_0x0a40
        L_0x0640:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            a((int) r10, (java.lang.Object) r9, (com.google.android.libraries.places.internal.nt) r15)
            goto L_0x0a40
        L_0x0651:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = f(r14, r11)
            r15.a((int) r10, (boolean) r9)
            goto L_0x0a40
        L_0x0662:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = d(r14, r11)
            r15.d((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0673:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = e(r14, r11)
            r15.d((int) r10, (long) r11)
            goto L_0x0a40
        L_0x0684:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = d(r14, r11)
            r15.c((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0695:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = e(r14, r11)
            r15.c((int) r10, (long) r11)
            goto L_0x0a40
        L_0x06a6:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = e(r14, r11)
            r15.a((int) r10, (long) r11)
            goto L_0x0a40
        L_0x06b7:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = c(r14, r11)
            r15.a((int) r10, (float) r9)
            goto L_0x0a40
        L_0x06c8:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = b(r14, (long) r11)
            r15.a((int) r10, (double) r11)
            goto L_0x0a40
        L_0x06d9:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            r13.a((com.google.android.libraries.places.internal.nt) r15, (int) r10, (java.lang.Object) r9, (int) r1)
            goto L_0x0a40
        L_0x06e4:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mp r11 = r13.a((int) r1)
            com.google.android.libraries.places.internal.mr.b((int) r10, (java.util.List<?>) r9, (com.google.android.libraries.places.internal.nt) r15, (com.google.android.libraries.places.internal.mp) r11)
            goto L_0x0a40
        L_0x06f9:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.e(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x070a:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.j(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x071b:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.g(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x072c:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.l(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x073d:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.m(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x074e:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.i(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x075f:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.n(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x0770:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.k(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x0781:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.f(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x0792:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.h(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x07a3:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.d(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x07b4:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.c(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x07c5:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.b((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.libraries.places.internal.nt) r15, (boolean) r4)
            goto L_0x0a40
        L_0x07d6:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.a((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.libraries.places.internal.nt) r15, (boolean) r4)
            goto L_0x0a40
        L_0x07e7:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.e(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x07f8:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.j(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x0809:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.g(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x081a:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.l(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x082b:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.m(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x083c:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.i(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x084d:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.b((int) r10, (java.util.List<com.google.android.libraries.places.internal.kc>) r9, (com.google.android.libraries.places.internal.nt) r15)
            goto L_0x0a40
        L_0x085e:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mp r11 = r13.a((int) r1)
            com.google.android.libraries.places.internal.mr.a((int) r10, (java.util.List<?>) r9, (com.google.android.libraries.places.internal.nt) r15, (com.google.android.libraries.places.internal.mp) r11)
            goto L_0x0a40
        L_0x0873:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.a((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.libraries.places.internal.nt) r15)
            goto L_0x0a40
        L_0x0884:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.n(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x0895:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.k(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x08a6:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.f(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x08b7:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.h(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x08c8:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.d(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x08d9:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.c(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x08ea:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.b((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.libraries.places.internal.nt) r15, (boolean) r5)
            goto L_0x0a40
        L_0x08fb:
            int[] r10 = r13.f12957c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.a((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.libraries.places.internal.nt) r15, (boolean) r5)
            goto L_0x0a40
        L_0x090c:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            com.google.android.libraries.places.internal.mp r11 = r13.a((int) r1)
            r15.b((int) r10, (java.lang.Object) r9, (com.google.android.libraries.places.internal.mp) r11)
            goto L_0x0a40
        L_0x0921:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.libraries.places.internal.nk.b(r14, r11)
            r15.e((int) r10, (long) r11)
            goto L_0x0a40
        L_0x0932:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r14, (long) r11)
            r15.f(r10, r9)
            goto L_0x0a40
        L_0x0943:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.libraries.places.internal.nk.b(r14, r11)
            r15.b((int) r10, (long) r11)
            goto L_0x0a40
        L_0x0954:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r14, (long) r11)
            r15.a((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0965:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r14, (long) r11)
            r15.b((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0976:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r14, (long) r11)
            r15.e((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0987:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            com.google.android.libraries.places.internal.kc r9 = (com.google.android.libraries.places.internal.kc) r9
            r15.a((int) r10, (com.google.android.libraries.places.internal.kc) r9)
            goto L_0x0a40
        L_0x099a:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            com.google.android.libraries.places.internal.mp r11 = r13.a((int) r1)
            r15.a((int) r10, (java.lang.Object) r9, (com.google.android.libraries.places.internal.mp) r11)
            goto L_0x0a40
        L_0x09af:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.nk.f(r14, r11)
            a((int) r10, (java.lang.Object) r9, (com.google.android.libraries.places.internal.nt) r15)
            goto L_0x0a40
        L_0x09c0:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.libraries.places.internal.nk.c(r14, r11)
            r15.a((int) r10, (boolean) r9)
            goto L_0x0a40
        L_0x09d1:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r14, (long) r11)
            r15.d((int) r10, (int) r9)
            goto L_0x0a40
        L_0x09e1:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.libraries.places.internal.nk.b(r14, r11)
            r15.d((int) r10, (long) r11)
            goto L_0x0a40
        L_0x09f1:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.libraries.places.internal.nk.a((java.lang.Object) r14, (long) r11)
            r15.c((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0a01:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.libraries.places.internal.nk.b(r14, r11)
            r15.c((int) r10, (long) r11)
            goto L_0x0a40
        L_0x0a11:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.libraries.places.internal.nk.b(r14, r11)
            r15.a((int) r10, (long) r11)
            goto L_0x0a40
        L_0x0a21:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.libraries.places.internal.nk.d(r14, r11)
            r15.a((int) r10, (float) r9)
            goto L_0x0a40
        L_0x0a31:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.libraries.places.internal.nk.e(r14, r11)
            r15.a((int) r10, (double) r11)
        L_0x0a40:
            int r1 = r1 + 3
            goto L_0x056c
        L_0x0a44:
            if (r8 == 0) goto L_0x0a5b
            com.google.android.libraries.places.internal.kn<?> r1 = r13.r
            r1.a(r15, r8)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0a59
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            r8 = r1
            goto L_0x0a44
        L_0x0a59:
            r8 = r3
            goto L_0x0a44
        L_0x0a5b:
            com.google.android.libraries.places.internal.nf<?, ?> r0 = r13.q
            a(r0, r14, (com.google.android.libraries.places.internal.nt) r15)
            return
        L_0x0a61:
            r13.b(r14, (com.google.android.libraries.places.internal.nt) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.md.a(java.lang.Object, com.google.android.libraries.places.internal.nt):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:172:0x04b5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b(T r19, com.google.android.libraries.places.internal.nt r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r0.h
            if (r3 == 0) goto L_0x0023
            com.google.android.libraries.places.internal.kn<?> r3 = r0.r
            com.google.android.libraries.places.internal.kp r3 = r3.a((java.lang.Object) r1)
            com.google.android.libraries.places.internal.ms<FieldDescriptorType, java.lang.Object> r5 = r3.f12885a
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0023
            java.util.Iterator r3 = r3.b()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0025
        L_0x0023:
            r3 = 0
            r5 = 0
        L_0x0025:
            r6 = -1
            int[] r7 = r0.f12957c
            int r7 = r7.length
            sun.misc.Unsafe r8 = f12956b
            r10 = r5
            r5 = 0
            r11 = 0
        L_0x002e:
            if (r5 >= r7) goto L_0x04af
            int r12 = r0.c((int) r5)
            int[] r13 = r0.f12957c
            r14 = r13[r5]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r12
            int r15 = r15 >>> 20
            boolean r4 = r0.j
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
            com.google.android.libraries.places.internal.kn<?> r4 = r0.r
            int r4 = r4.a((java.util.Map.Entry<?, ?>) r10)
            if (r4 > r14) goto L_0x0088
            com.google.android.libraries.places.internal.kn<?> r4 = r0.r
            r4.a(r2, r10)
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
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.libraries.places.internal.mp r9 = r0.a((int) r5)
            r2.b((int) r14, (java.lang.Object) r4, (com.google.android.libraries.places.internal.mp) r9)
            goto L_0x008e
        L_0x00a3:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r12 = e(r1, r12)
            r2.e((int) r14, (long) r12)
            goto L_0x008e
        L_0x00b1:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = d(r1, r12)
            r2.f(r14, r4)
            goto L_0x008e
        L_0x00bf:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r12 = e(r1, r12)
            r2.b((int) r14, (long) r12)
            goto L_0x008e
        L_0x00cd:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = d(r1, r12)
            r2.a((int) r14, (int) r4)
            goto L_0x008e
        L_0x00db:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = d(r1, r12)
            r2.b((int) r14, (int) r4)
            goto L_0x008e
        L_0x00e9:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = d(r1, r12)
            r2.e((int) r14, (int) r4)
            goto L_0x008e
        L_0x00f7:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.libraries.places.internal.kc r4 = (com.google.android.libraries.places.internal.kc) r4
            r2.a((int) r14, (com.google.android.libraries.places.internal.kc) r4)
            goto L_0x008e
        L_0x0107:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.libraries.places.internal.mp r9 = r0.a((int) r5)
            r2.a((int) r14, (java.lang.Object) r4, (com.google.android.libraries.places.internal.mp) r9)
            goto L_0x008e
        L_0x011a:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r8.getObject(r1, r12)
            a((int) r14, (java.lang.Object) r4, (com.google.android.libraries.places.internal.nt) r2)
            goto L_0x008e
        L_0x0129:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            boolean r4 = f(r1, r12)
            r2.a((int) r14, (boolean) r4)
            goto L_0x008e
        L_0x0138:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = d(r1, r12)
            r2.d((int) r14, (int) r4)
            goto L_0x008e
        L_0x0147:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r12 = e(r1, r12)
            r2.d((int) r14, (long) r12)
            goto L_0x008e
        L_0x0156:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = d(r1, r12)
            r2.c((int) r14, (int) r4)
            goto L_0x008e
        L_0x0165:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r12 = e(r1, r12)
            r2.c((int) r14, (long) r12)
            goto L_0x008e
        L_0x0174:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r12 = e(r1, r12)
            r2.a((int) r14, (long) r12)
            goto L_0x008e
        L_0x0183:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            float r4 = c(r1, r12)
            r2.a((int) r14, (float) r4)
            goto L_0x008e
        L_0x0192:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            double r12 = b(r1, (long) r12)
            r2.a((int) r14, (double) r12)
            goto L_0x008e
        L_0x01a1:
            java.lang.Object r4 = r8.getObject(r1, r12)
            r0.a((com.google.android.libraries.places.internal.nt) r2, (int) r14, (java.lang.Object) r4, (int) r5)
            goto L_0x008e
        L_0x01aa:
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mp r12 = r0.a((int) r5)
            com.google.android.libraries.places.internal.mr.b((int) r4, (java.util.List<?>) r9, (com.google.android.libraries.places.internal.nt) r2, (com.google.android.libraries.places.internal.mp) r12)
            goto L_0x008e
        L_0x01bd:
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r14 = 1
            com.google.android.libraries.places.internal.mr.e(r4, r9, r2, r14)
            goto L_0x008e
        L_0x01cd:
            r14 = 1
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.j(r4, r9, r2, r14)
            goto L_0x008e
        L_0x01dd:
            r14 = 1
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.g(r4, r9, r2, r14)
            goto L_0x008e
        L_0x01ed:
            r14 = 1
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.l(r4, r9, r2, r14)
            goto L_0x008e
        L_0x01fd:
            r14 = 1
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.m(r4, r9, r2, r14)
            goto L_0x008e
        L_0x020d:
            r14 = 1
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.i(r4, r9, r2, r14)
            goto L_0x008e
        L_0x021d:
            r14 = 1
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.n(r4, r9, r2, r14)
            goto L_0x008e
        L_0x022d:
            r14 = 1
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.k(r4, r9, r2, r14)
            goto L_0x008e
        L_0x023d:
            r14 = 1
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.f(r4, r9, r2, r14)
            goto L_0x008e
        L_0x024d:
            r14 = 1
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.h(r4, r9, r2, r14)
            goto L_0x008e
        L_0x025d:
            r14 = 1
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.d(r4, r9, r2, r14)
            goto L_0x008e
        L_0x026d:
            r14 = 1
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.c(r4, r9, r2, r14)
            goto L_0x008e
        L_0x027d:
            r14 = 1
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.b((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.libraries.places.internal.nt) r2, (boolean) r14)
            goto L_0x008e
        L_0x028d:
            r14 = 1
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.a((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.libraries.places.internal.nt) r2, (boolean) r14)
            goto L_0x008e
        L_0x029d:
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r14 = 0
            com.google.android.libraries.places.internal.mr.e(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02ad:
            r14 = 0
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.j(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02bd:
            r14 = 0
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.g(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02cd:
            r14 = 0
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.l(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02dd:
            r14 = 0
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.m(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02ed:
            r14 = 0
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.i(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02fd:
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.b((int) r4, (java.util.List<com.google.android.libraries.places.internal.kc>) r9, (com.google.android.libraries.places.internal.nt) r2)
            goto L_0x008e
        L_0x030c:
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mp r12 = r0.a((int) r5)
            com.google.android.libraries.places.internal.mr.a((int) r4, (java.util.List<?>) r9, (com.google.android.libraries.places.internal.nt) r2, (com.google.android.libraries.places.internal.mp) r12)
            goto L_0x008e
        L_0x031f:
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.a((int) r4, (java.util.List<java.lang.String>) r9, (com.google.android.libraries.places.internal.nt) r2)
            goto L_0x008e
        L_0x032e:
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r15 = 0
            com.google.android.libraries.places.internal.mr.n(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x033e:
            r15 = 0
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.k(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x034e:
            r15 = 0
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.f(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x035e:
            r15 = 0
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.h(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x036e:
            r15 = 0
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.d(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x037e:
            r15 = 0
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.c(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x038e:
            r15 = 0
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.b((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.libraries.places.internal.nt) r2, (boolean) r15)
            goto L_0x04ab
        L_0x039e:
            r15 = 0
            int[] r4 = r0.f12957c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.mr.a((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.libraries.places.internal.nt) r2, (boolean) r15)
            goto L_0x04ab
        L_0x03ae:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.libraries.places.internal.mp r9 = r0.a((int) r5)
            r2.b((int) r14, (java.lang.Object) r4, (com.google.android.libraries.places.internal.mp) r9)
            goto L_0x04ab
        L_0x03c0:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            long r12 = r8.getLong(r1, r12)
            r2.e((int) r14, (long) r12)
            goto L_0x04ab
        L_0x03ce:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r8.getInt(r1, r12)
            r2.f(r14, r4)
            goto L_0x04ab
        L_0x03dc:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            long r12 = r8.getLong(r1, r12)
            r2.b((int) r14, (long) r12)
            goto L_0x04ab
        L_0x03ea:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r8.getInt(r1, r12)
            r2.a((int) r14, (int) r4)
            goto L_0x04ab
        L_0x03f8:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r8.getInt(r1, r12)
            r2.b((int) r14, (int) r4)
            goto L_0x04ab
        L_0x0406:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r8.getInt(r1, r12)
            r2.e((int) r14, (int) r4)
            goto L_0x04ab
        L_0x0414:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.libraries.places.internal.kc r4 = (com.google.android.libraries.places.internal.kc) r4
            r2.a((int) r14, (com.google.android.libraries.places.internal.kc) r4)
            goto L_0x04ab
        L_0x0424:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.libraries.places.internal.mp r9 = r0.a((int) r5)
            r2.a((int) r14, (java.lang.Object) r4, (com.google.android.libraries.places.internal.mp) r9)
            goto L_0x04ab
        L_0x0436:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r8.getObject(r1, r12)
            a((int) r14, (java.lang.Object) r4, (com.google.android.libraries.places.internal.nt) r2)
            goto L_0x04ab
        L_0x0444:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            boolean r4 = com.google.android.libraries.places.internal.nk.c(r1, r12)
            r2.a((int) r14, (boolean) r4)
            goto L_0x04ab
        L_0x0451:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r8.getInt(r1, r12)
            r2.d((int) r14, (int) r4)
            goto L_0x04ab
        L_0x045e:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            long r12 = r8.getLong(r1, r12)
            r2.d((int) r14, (long) r12)
            goto L_0x04ab
        L_0x046b:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r8.getInt(r1, r12)
            r2.c((int) r14, (int) r4)
            goto L_0x04ab
        L_0x0478:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            long r12 = r8.getLong(r1, r12)
            r2.c((int) r14, (long) r12)
            goto L_0x04ab
        L_0x0485:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            long r12 = r8.getLong(r1, r12)
            r2.a((int) r14, (long) r12)
            goto L_0x04ab
        L_0x0492:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            float r4 = com.google.android.libraries.places.internal.nk.d(r1, r12)
            r2.a((int) r14, (float) r4)
            goto L_0x04ab
        L_0x049f:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            double r12 = com.google.android.libraries.places.internal.nk.e(r1, r12)
            r2.a((int) r14, (double) r12)
        L_0x04ab:
            int r5 = r5 + 3
            goto L_0x002e
        L_0x04af:
            r17 = r10
            r4 = r17
        L_0x04b3:
            if (r4 == 0) goto L_0x04c9
            com.google.android.libraries.places.internal.kn<?> r5 = r0.r
            r5.a(r2, r4)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04c7
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            goto L_0x04b3
        L_0x04c7:
            r4 = 0
            goto L_0x04b3
        L_0x04c9:
            com.google.android.libraries.places.internal.nf<?, ?> r3 = r0.q
            a(r3, r1, (com.google.android.libraries.places.internal.nt) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.md.b(java.lang.Object, com.google.android.libraries.places.internal.nt):void");
    }

    private final <K, V> void a(nt ntVar, int i2, Object obj, int i3) throws IOException {
        if (obj != null) {
            ntVar.a(i2, this.s.c(b(i3)), this.s.a(obj));
        }
    }

    private static <UT, UB> void a(nf<UT, UB> nfVar, T t, nt ntVar) throws IOException {
        nfVar.a(nfVar.a((Object) t), ntVar);
    }

    private final mp a(int i2) {
        int i3 = (i2 / 3) << 1;
        mp mpVar = (mp) this.f12958d[i3];
        if (mpVar != null) {
            return mpVar;
        }
        mp a2 = mm.f12971a.a((Class) this.f12958d[i3 + 1]);
        this.f12958d[i3] = a2;
        return a2;
    }

    private final Object b(int i2) {
        return this.f12958d[(i2 / 3) << 1];
    }

    public final void c(T t) {
        int i2;
        int i3 = this.m;
        while (true) {
            i2 = this.n;
            if (i3 >= i2) {
                break;
            }
            long c2 = (long) (c(this.l[i3]) & 1048575);
            Object f2 = nk.f(t, c2);
            if (f2 != null) {
                nk.a((Object) t, c2, this.s.b(f2));
            }
            i3++;
        }
        int length = this.l.length;
        while (i2 < length) {
            this.p.a(t, (long) this.l[i2]);
            i2++;
        }
        this.q.b((Object) t);
        if (this.h) {
            this.r.c(t);
        }
    }

    public final boolean d(T t) {
        int i2;
        int i3 = 0;
        int i4 = -1;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= this.m) {
                return !this.h || this.r.a((Object) t).c();
            }
            int i6 = this.l[i3];
            int i7 = this.f12957c[i6];
            int c2 = c(i6);
            if (!this.j) {
                int i8 = this.f12957c[i6 + 2];
                int i9 = i8 & 1048575;
                i2 = 1 << (i8 >>> 20);
                if (i9 != i4) {
                    i5 = f12956b.getInt(t, (long) i9);
                    i4 = i9;
                }
            } else {
                i2 = 0;
            }
            if (((268435456 & c2) != 0) && !a(t, i6, i5, i2)) {
                return false;
            }
            int i10 = (267386880 & c2) >>> 20;
            if (i10 != 9 && i10 != 17) {
                if (i10 != 27) {
                    if (i10 == 60 || i10 == 68) {
                        if (a(t, i7, i6) && !a((Object) t, c2, a(i6))) {
                            return false;
                        }
                    } else if (i10 != 49) {
                        if (i10 != 50) {
                            continue;
                        } else {
                            Map<?, ?> a2 = this.s.a(nk.f(t, (long) (c2 & 1048575)));
                            if (!a2.isEmpty()) {
                                if (this.s.c(b(i6)).f12947b.s == ns.MESSAGE) {
                                    mp<?> mpVar = null;
                                    Iterator<?> it = a2.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (mpVar == null) {
                                            mpVar = mm.f12971a.a(next.getClass());
                                        }
                                        if (!mpVar.d(next)) {
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
                List list = (List) nk.f(t, (long) (c2 & 1048575));
                if (!list.isEmpty()) {
                    mp a3 = a(i6);
                    int i11 = 0;
                    while (true) {
                        if (i11 >= list.size()) {
                            break;
                        } else if (!a3.d(list.get(i11))) {
                            z = false;
                            break;
                        } else {
                            i11++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (a(t, i6, i5, i2) && !a((Object) t, c2, a(i6))) {
                return false;
            }
            i3++;
        }
    }

    private static boolean a(Object obj, int i2, mp mpVar) {
        return mpVar.d(nk.f(obj, (long) (i2 & 1048575)));
    }

    private static void a(int i2, Object obj, nt ntVar) throws IOException {
        if (obj instanceof String) {
            ntVar.a(i2, (String) obj);
        } else {
            ntVar.a(i2, (kc) obj);
        }
    }

    private final int c(int i2) {
        return this.f12957c[i2 + 1];
    }

    private final int d(int i2) {
        return this.f12957c[i2 + 2];
    }

    private static <T> double b(T t, long j2) {
        return ((Double) nk.f(t, j2)).doubleValue();
    }

    private static <T> float c(T t, long j2) {
        return ((Float) nk.f(t, j2)).floatValue();
    }

    private static <T> int d(T t, long j2) {
        return ((Integer) nk.f(t, j2)).intValue();
    }

    private static <T> long e(T t, long j2) {
        return ((Long) nk.f(t, j2)).longValue();
    }

    private static <T> boolean f(T t, long j2) {
        return ((Boolean) nk.f(t, j2)).booleanValue();
    }

    private final boolean c(T t, T t2, int i2) {
        return a(t, i2) == a(t2, i2);
    }

    private final boolean a(T t, int i2, int i3, int i4) {
        if (this.j) {
            return a(t, i2);
        }
        return (i3 & i4) != 0;
    }

    private final boolean a(T t, int i2) {
        if (this.j) {
            int c2 = c(i2);
            long j2 = (long) (c2 & 1048575);
            switch ((c2 & 267386880) >>> 20) {
                case 0:
                    return nk.e(t, j2) != 0.0d;
                case 1:
                    return nk.d(t, j2) != BitmapDescriptorFactory.HUE_RED;
                case 2:
                    return nk.b(t, j2) != 0;
                case 3:
                    return nk.b(t, j2) != 0;
                case 4:
                    return nk.a((Object) t, j2) != 0;
                case 5:
                    return nk.b(t, j2) != 0;
                case 6:
                    return nk.a((Object) t, j2) != 0;
                case 7:
                    return nk.c(t, j2);
                case 8:
                    Object f2 = nk.f(t, j2);
                    if (f2 instanceof String) {
                        return !((String) f2).isEmpty();
                    }
                    if (f2 instanceof kc) {
                        return !kc.f12862a.equals(f2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return nk.f(t, j2) != null;
                case 10:
                    return !kc.f12862a.equals(nk.f(t, j2));
                case 11:
                    return nk.a((Object) t, j2) != 0;
                case 12:
                    return nk.a((Object) t, j2) != 0;
                case 13:
                    return nk.a((Object) t, j2) != 0;
                case 14:
                    return nk.b(t, j2) != 0;
                case 15:
                    return nk.a((Object) t, j2) != 0;
                case 16:
                    return nk.b(t, j2) != 0;
                case 17:
                    return nk.f(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int d2 = d(i2);
            return (nk.a((Object) t, (long) (d2 & 1048575)) & (1 << (d2 >>> 20))) != 0;
        }
    }

    private final void b(T t, int i2) {
        if (!this.j) {
            int d2 = d(i2);
            long j2 = (long) (d2 & 1048575);
            nk.a((Object) t, j2, nk.a((Object) t, j2) | (1 << (d2 >>> 20)));
        }
    }

    private final boolean a(T t, int i2, int i3) {
        return nk.a((Object) t, (long) (d(i3) & 1048575)) == i2;
    }

    private final void b(T t, int i2, int i3) {
        nk.a((Object) t, (long) (d(i3) & 1048575), i2);
    }
}
