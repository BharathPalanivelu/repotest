package org.apache.commons.c;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Object[] f33837a = new Object[0];

    /* renamed from: b  reason: collision with root package name */
    public static final Class<?>[] f33838b = new Class[0];

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f33839c = new String[0];

    /* renamed from: d  reason: collision with root package name */
    public static final long[] f33840d = new long[0];

    /* renamed from: e  reason: collision with root package name */
    public static final Long[] f33841e = new Long[0];

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f33842f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    public static final Integer[] f33843g = new Integer[0];
    public static final short[] h = new short[0];
    public static final Short[] i = new Short[0];
    public static final byte[] j = new byte[0];
    public static final Byte[] k = new Byte[0];
    public static final double[] l = new double[0];
    public static final Double[] m = new Double[0];
    public static final float[] n = new float[0];
    public static final Float[] o = new Float[0];
    public static final boolean[] p = new boolean[0];
    public static final Boolean[] q = new Boolean[0];
    public static final char[] r = new char[0];
    public static final Character[] s = new Character[0];

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public static byte[] a(byte[] bArr, byte... bArr2) {
        if (bArr == null) {
            return a(bArr2);
        }
        if (bArr2 == null) {
            return a(bArr);
        }
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }
}
