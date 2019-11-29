package com.google.c;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f14058a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    static final Charset f14059b = Charset.forName("ISO-8859-1");

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f14060c = new byte[0];

    /* renamed from: d  reason: collision with root package name */
    public static final ByteBuffer f14061d = ByteBuffer.wrap(f14060c);

    /* renamed from: e  reason: collision with root package name */
    public static final g f14062e = g.a(f14060c);

    public interface a {
        int getNumber();
    }

    public interface b<T extends a> {
    }

    public interface c extends List, RandomAccess {
    }

    public static int a(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int a(boolean z) {
        return z ? 1231 : 1237;
    }

    public static boolean a(byte[] bArr) {
        return ax.a(bArr);
    }

    public static String b(byte[] bArr) {
        return new String(bArr, f14058a);
    }

    public static int a(a aVar) {
        return aVar.getNumber();
    }

    public static int a(List<? extends a> list) {
        int i = 1;
        for (a a2 : list) {
            i = (i * 31) + a(a2);
        }
        return i;
    }

    public static int c(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    static int a(byte[] bArr, int i, int i2) {
        int a2 = a(i2, bArr, i, i2);
        if (a2 == 0) {
            return 1;
        }
        return a2;
    }

    static int a(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 = (i4 * 31) + bArr[i5];
        }
        return i4;
    }
}
