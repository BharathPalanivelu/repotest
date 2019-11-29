package com.tencent.qalsdk.util;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

final class a {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f32319a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f32320b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f32321c;

    /* renamed from: d  reason: collision with root package name */
    private int f32322d;

    /* renamed from: e  reason: collision with root package name */
    private int f32323e;

    /* renamed from: f  reason: collision with root package name */
    private int f32324f;

    /* renamed from: g  reason: collision with root package name */
    private int f32325g;
    private byte[] h;
    private boolean i = true;
    private int j;
    private Random k = new Random();

    a() {
    }

    private static long a(byte[] bArr, int i2, int i3) {
        int i4 = i2 + 4;
        long j2 = 0;
        while (i2 < i4) {
            j2 = (j2 << 8) | ((long) (bArr[i2] & 255));
            i2++;
        }
        return (4294967295L & j2) | (j2 >>> 32);
    }

    /* access modifiers changed from: protected */
    public final byte[] a(byte[] bArr, int i2, int i3, byte[] bArr2) {
        int i4 = 0;
        this.f32323e = 0;
        this.f32322d = 0;
        this.h = bArr2;
        byte[] bArr3 = new byte[(i2 + 8)];
        if (i3 % 8 != 0 || i3 < 16) {
            return null;
        }
        this.f32320b = a(bArr, i2);
        this.f32324f = this.f32320b[0] & 7;
        int i5 = (i3 - this.f32324f) - 10;
        if (i5 < 0) {
            return null;
        }
        for (int i6 = i2; i6 < bArr3.length; i6++) {
            bArr3[i6] = 0;
        }
        this.f32321c = new byte[i5];
        this.f32323e = 0;
        this.f32322d = 8;
        this.j = 8;
        this.f32324f++;
        this.f32325g = 1;
        while (true) {
            int i7 = this.f32325g;
            if (i7 <= 2) {
                int i8 = this.f32324f;
                if (i8 < 8) {
                    this.f32324f = i8 + 1;
                    this.f32325g = i7 + 1;
                }
                if (this.f32324f == 8) {
                    if (!b(bArr, i2, i3)) {
                        return null;
                    }
                    bArr3 = bArr;
                }
            } else {
                while (i5 != 0) {
                    int i9 = this.f32324f;
                    if (i9 < 8) {
                        this.f32321c[i4] = (byte) (bArr3[(this.f32323e + i2) + i9] ^ this.f32320b[i9]);
                        i4++;
                        i5--;
                        this.f32324f = i9 + 1;
                    }
                    if (this.f32324f == 8) {
                        this.f32323e = this.f32322d - 8;
                        if (!b(bArr, i2, i3)) {
                            return null;
                        }
                        bArr3 = bArr;
                    }
                }
                this.f32325g = 1;
                while (this.f32325g < 8) {
                    int i10 = this.f32324f;
                    if (i10 < 8) {
                        if ((bArr3[(this.f32323e + i2) + i10] ^ this.f32320b[i10]) != 0) {
                            return null;
                        }
                        this.f32324f = i10 + 1;
                    }
                    if (this.f32324f == 8) {
                        this.f32323e = this.f32322d;
                        if (!b(bArr, i2, i3)) {
                            return null;
                        }
                        bArr3 = bArr;
                    }
                    this.f32325g++;
                }
                return this.f32321c;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, 0, bArr.length, bArr2);
    }

    /* access modifiers changed from: protected */
    public final byte[] b(byte[] bArr, byte[] bArr2) {
        int i2;
        int length = bArr.length;
        this.f32319a = new byte[8];
        this.f32320b = new byte[8];
        this.f32324f = 1;
        this.f32325g = 0;
        this.f32323e = 0;
        this.f32322d = 0;
        this.h = bArr2;
        this.i = true;
        this.f32324f = (length + 10) % 8;
        int i3 = this.f32324f;
        if (i3 != 0) {
            this.f32324f = 8 - i3;
        }
        this.f32321c = new byte[(this.f32324f + length + 10)];
        this.f32319a[0] = (byte) ((this.k.nextInt() & 248) | this.f32324f);
        int i4 = 1;
        while (true) {
            i2 = this.f32324f;
            if (i4 > i2) {
                break;
            }
            this.f32319a[i4] = (byte) this.k.nextInt();
            i4++;
        }
        this.f32324f = i2 + 1;
        for (int i5 = 0; i5 < 8; i5++) {
            this.f32320b[i5] = 0;
        }
        this.f32325g = 1;
        while (this.f32325g <= 2) {
            int i6 = this.f32324f;
            if (i6 < 8) {
                byte[] bArr3 = this.f32319a;
                this.f32324f = i6 + 1;
                bArr3[i6] = (byte) this.k.nextInt();
                this.f32325g++;
            }
            if (this.f32324f == 8) {
                a();
            }
        }
        int i7 = 0;
        while (length > 0) {
            int i8 = this.f32324f;
            if (i8 < 8) {
                byte[] bArr4 = this.f32319a;
                this.f32324f = i8 + 1;
                bArr4[i8] = bArr[i7];
                length--;
                i7++;
            }
            if (this.f32324f == 8) {
                a();
            }
        }
        this.f32325g = 1;
        while (true) {
            int i9 = this.f32325g;
            if (i9 > 7) {
                return this.f32321c;
            }
            int i10 = this.f32324f;
            if (i10 < 8) {
                byte[] bArr5 = this.f32319a;
                this.f32324f = i10 + 1;
                bArr5[i10] = 0;
                this.f32325g = i9 + 1;
            }
            if (this.f32324f == 8) {
                a();
            }
        }
    }

    private byte[] a(byte[] bArr) {
        byte[] bArr2 = bArr;
        int i2 = 16;
        try {
            long a2 = a(bArr2, 0, 4);
            long a3 = a(bArr2, 4, 4);
            long a4 = a(this.h, 0, 4);
            long a5 = a(this.h, 4, 4);
            long a6 = a(this.h, 8, 4);
            long a7 = a(this.h, 12, 4);
            long j2 = 0;
            while (true) {
                int i3 = i2 - 1;
                if (i2 > 0) {
                    j2 = (j2 + 2654435769L) & 4294967295L;
                    a2 = (a2 + ((((a3 << 4) + a4) ^ (a3 + j2)) ^ ((a3 >>> 5) + a5))) & 4294967295L;
                    a3 = (a3 + ((((a2 << 4) + a6) ^ (a2 + j2)) ^ ((a2 >>> 5) + a7))) & 4294967295L;
                    i2 = i3;
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) a2);
                    dataOutputStream.writeInt((int) a3);
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }

    private byte[] a(byte[] bArr, int i2) {
        byte[] bArr2 = bArr;
        int i3 = i2;
        int i4 = 16;
        try {
            long a2 = a(bArr2, i3, 4);
            long a3 = a(bArr2, i3 + 4, 4);
            long a4 = a(this.h, 0, 4);
            long a5 = a(this.h, 4, 4);
            long a6 = a(this.h, 8, 4);
            long a7 = a(this.h, 12, 4);
            long j2 = 3816266640L;
            while (true) {
                int i5 = i4 - 1;
                if (i4 > 0) {
                    a3 = (a3 - ((((a2 << 4) + a6) ^ (a2 + j2)) ^ ((a2 >>> 5) + a7))) & 4294967295L;
                    a2 = (a2 - ((((a3 << 4) + a4) ^ (a3 + j2)) ^ ((a3 >>> 5) + a5))) & 4294967295L;
                    j2 = (j2 - 2654435769L) & 4294967295L;
                    i4 = i5;
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) a2);
                    dataOutputStream.writeInt((int) a3);
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }

    private void a() {
        this.f32324f = 0;
        while (true) {
            int i2 = this.f32324f;
            if (i2 >= 8) {
                break;
            }
            if (this.i) {
                byte[] bArr = this.f32319a;
                bArr[i2] = (byte) (bArr[i2] ^ this.f32320b[i2]);
            } else {
                byte[] bArr2 = this.f32319a;
                bArr2[i2] = (byte) (bArr2[i2] ^ this.f32321c[this.f32323e + i2]);
            }
            this.f32324f++;
        }
        System.arraycopy(a(this.f32319a), 0, this.f32321c, this.f32322d, 8);
        this.f32324f = 0;
        while (true) {
            int i3 = this.f32324f;
            if (i3 < 8) {
                byte[] bArr3 = this.f32321c;
                int i4 = this.f32322d + i3;
                bArr3[i4] = (byte) (bArr3[i4] ^ this.f32320b[i3]);
                this.f32324f = i3 + 1;
            } else {
                System.arraycopy(this.f32319a, 0, this.f32320b, 0, 8);
                int i5 = this.f32322d;
                this.f32323e = i5;
                this.f32322d = i5 + 8;
                this.f32324f = 0;
                this.i = false;
                return;
            }
        }
    }

    private boolean b(byte[] bArr, int i2, int i3) {
        this.f32324f = 0;
        while (true) {
            int i4 = this.f32324f;
            if (i4 >= 8) {
                this.f32320b = a(this.f32320b, 0);
                if (this.f32320b == null) {
                    return false;
                }
                this.j += 8;
                this.f32322d += 8;
                this.f32324f = 0;
                return true;
            } else if (this.j + i4 >= i3) {
                return true;
            } else {
                byte[] bArr2 = this.f32320b;
                bArr2[i4] = (byte) (bArr2[i4] ^ bArr[(this.f32322d + i2) + i4]);
                this.f32324f = i4 + 1;
            }
        }
    }
}
