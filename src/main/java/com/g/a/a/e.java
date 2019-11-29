package com.g.a.a;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    protected String f7281a = "GBK";

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f7282b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public byte f7283a;

        /* renamed from: b  reason: collision with root package name */
        public int f7284b;
    }

    public e() {
    }

    public e(byte[] bArr) {
        this.f7282b = ByteBuffer.wrap(bArr);
    }

    public static int a(a aVar, ByteBuffer byteBuffer) {
        byte b2 = byteBuffer.get();
        aVar.f7283a = (byte) (b2 & 15);
        aVar.f7284b = (b2 & 240) >> 4;
        if (aVar.f7284b != 15) {
            return 1;
        }
        aVar.f7284b = byteBuffer.get() & 255;
        return 2;
    }

    public void a(a aVar) {
        a(aVar, this.f7282b);
    }

    private int b(a aVar) {
        return a(aVar, this.f7282b.duplicate());
    }

    private void b(int i) {
        ByteBuffer byteBuffer = this.f7282b;
        byteBuffer.position(byteBuffer.position() + i);
    }

    public boolean a(int i) {
        try {
            a aVar = new a();
            while (true) {
                int b2 = b(aVar);
                if (aVar.f7283a == 11) {
                    return false;
                }
                if (i > aVar.f7284b) {
                    b(b2);
                    a(aVar.f7283a);
                } else if (i == aVar.f7284b) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (b | BufferUnderflowException unused) {
            return false;
        }
    }

    public void a() {
        a aVar = new a();
        do {
            a(aVar);
            a(aVar.f7283a);
        } while (aVar.f7283a != 11);
    }

    private void b() {
        a aVar = new a();
        a(aVar);
        a(aVar.f7283a);
    }

    private void a(byte b2) {
        int i = 0;
        switch (b2) {
            case 0:
                b(1);
                return;
            case 1:
                b(2);
                return;
            case 2:
                b(4);
                return;
            case 3:
                b(8);
                return;
            case 4:
                b(4);
                return;
            case 5:
                b(8);
                return;
            case 6:
                int i2 = this.f7282b.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                b(i2);
                return;
            case 7:
                b(this.f7282b.getInt());
                return;
            case 8:
                int a2 = a(0, 0, true);
                while (i < a2 * 2) {
                    b();
                    i++;
                }
                return;
            case 9:
                int a3 = a(0, 0, true);
                while (i < a3) {
                    b();
                    i++;
                }
                return;
            case 10:
                a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                a aVar = new a();
                a(aVar);
                if (aVar.f7283a == 0) {
                    b(a(0, 0, true));
                    return;
                }
                throw new b("skipField with invalid type, type value: " + b2 + ", " + aVar.f7283a);
            default:
                throw new b("invalid type.");
        }
    }

    public boolean a(boolean z, int i, boolean z2) {
        return a((byte) 0, i, z2) != 0;
    }

    public byte a(byte b2, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            byte b3 = aVar.f7283a;
            if (b3 == 0) {
                return this.f7282b.get();
            }
            if (b3 == 12) {
                return 0;
            }
            throw new b("type mismatch.");
        } else if (!z) {
            return b2;
        } else {
            throw new b("require field not exist.");
        }
    }

    public short a(short s, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            byte b2 = aVar.f7283a;
            if (b2 == 0) {
                return (short) this.f7282b.get();
            }
            if (b2 == 1) {
                return this.f7282b.getShort();
            }
            if (b2 == 12) {
                return 0;
            }
            throw new b("type mismatch.");
        } else if (!z) {
            return s;
        } else {
            throw new b("require field not exist.");
        }
    }

    public int a(int i, int i2, boolean z) {
        if (a(i2)) {
            a aVar = new a();
            a(aVar);
            byte b2 = aVar.f7283a;
            if (b2 == 0) {
                return this.f7282b.get();
            }
            if (b2 == 1) {
                return this.f7282b.getShort();
            }
            if (b2 == 2) {
                return this.f7282b.getInt();
            }
            if (b2 == 12) {
                return 0;
            }
            throw new b("type mismatch.");
        } else if (!z) {
            return i;
        } else {
            throw new b("require field not exist.");
        }
    }

    public long a(long j, int i, boolean z) {
        int i2;
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            byte b2 = aVar.f7283a;
            if (b2 == 0) {
                i2 = this.f7282b.get();
            } else if (b2 == 1) {
                i2 = this.f7282b.getShort();
            } else if (b2 == 2) {
                i2 = this.f7282b.getInt();
            } else if (b2 == 3) {
                return this.f7282b.getLong();
            } else {
                if (b2 == 12) {
                    return 0;
                }
                throw new b("type mismatch.");
            }
            return (long) i2;
        } else if (!z) {
            return j;
        } else {
            throw new b("require field not exist.");
        }
    }

    public float a(float f2, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            byte b2 = aVar.f7283a;
            if (b2 == 4) {
                return this.f7282b.getFloat();
            }
            if (b2 == 12) {
                return BitmapDescriptorFactory.HUE_RED;
            }
            throw new b("type mismatch.");
        } else if (!z) {
            return f2;
        } else {
            throw new b("require field not exist.");
        }
    }

    public double a(double d2, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            byte b2 = aVar.f7283a;
            if (b2 == 4) {
                return (double) this.f7282b.getFloat();
            }
            if (b2 == 5) {
                return this.f7282b.getDouble();
            }
            if (b2 == 12) {
                return 0.0d;
            }
            throw new b("type mismatch.");
        } else if (!z) {
            return d2;
        } else {
            throw new b("require field not exist.");
        }
    }

    public String a(int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            byte b2 = aVar.f7283a;
            if (b2 == 6) {
                int i2 = this.f7282b.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                byte[] bArr = new byte[i2];
                this.f7282b.get(bArr);
                try {
                    return new String(bArr, this.f7281a);
                } catch (UnsupportedEncodingException unused) {
                    return new String(bArr);
                }
            } else if (b2 == 7) {
                int i3 = this.f7282b.getInt();
                if (i3 > 104857600 || i3 < 0 || i3 > this.f7282b.capacity()) {
                    throw new b("String too long: " + i3);
                }
                byte[] bArr2 = new byte[i3];
                this.f7282b.get(bArr2);
                try {
                    return new String(bArr2, this.f7281a);
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr2);
                }
            } else {
                throw new b("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new b("require field not exist.");
        }
    }

    public <K, V> HashMap<K, V> a(Map<K, V> map, int i, boolean z) {
        return (HashMap) a(new HashMap(), map, i, z);
    }

    private <K, V> Map<K, V> a(Map<K, V> map, Map<K, V> map2, int i, boolean z) {
        if (map2 == null || map2.isEmpty()) {
            return new HashMap();
        }
        Map.Entry next = map2.entrySet().iterator().next();
        Object key = next.getKey();
        Object value = next.getValue();
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f7283a == 8) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    for (int i2 = 0; i2 < a2; i2++) {
                        map.put(a(key, 0, true), a(value, 1, true));
                    }
                } else {
                    throw new b("size invalid: " + a2);
                }
            } else {
                throw new b("type mismatch.");
            }
        } else if (z) {
            throw new b("require field not exist.");
        }
        return map;
    }

    public boolean[] a(boolean[] zArr, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f7283a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    boolean[] zArr2 = new boolean[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        zArr2[i2] = a(zArr2[0], 0, true);
                    }
                    return zArr2;
                }
                throw new b("size invalid: " + a2);
            }
            throw new b("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new b("require field not exist.");
        }
    }

    public byte[] a(byte[] bArr, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            byte b2 = aVar.f7283a;
            if (b2 == 9) {
                int a2 = a(0, 0, true);
                if (a2 < 0 || a2 > this.f7282b.capacity()) {
                    throw new b("size invalid: " + a2);
                }
                byte[] bArr2 = new byte[a2];
                for (int i2 = 0; i2 < a2; i2++) {
                    bArr2[i2] = a(bArr2[0], 0, true);
                }
                return bArr2;
            } else if (b2 == 13) {
                a aVar2 = new a();
                a(aVar2);
                if (aVar2.f7283a == 0) {
                    int a3 = a(0, 0, true);
                    if (a3 < 0 || a3 > this.f7282b.capacity()) {
                        throw new b("invalid size, tag: " + i + ", type: " + aVar.f7283a + ", " + aVar2.f7283a + ", size: " + a3);
                    }
                    byte[] bArr3 = new byte[a3];
                    this.f7282b.get(bArr3);
                    return bArr3;
                }
                throw new b("type mismatch, tag: " + i + ", type: " + aVar.f7283a + ", " + aVar2.f7283a);
            } else {
                throw new b("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new b("require field not exist.");
        }
    }

    public short[] a(short[] sArr, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f7283a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    short[] sArr2 = new short[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        sArr2[i2] = a(sArr2[0], 0, true);
                    }
                    return sArr2;
                }
                throw new b("size invalid: " + a2);
            }
            throw new b("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new b("require field not exist.");
        }
    }

    public int[] a(int[] iArr, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f7283a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    int[] iArr2 = new int[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        iArr2[i2] = a(iArr2[0], 0, true);
                    }
                    return iArr2;
                }
                throw new b("size invalid: " + a2);
            }
            throw new b("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new b("require field not exist.");
        }
    }

    public long[] a(long[] jArr, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f7283a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    long[] jArr2 = new long[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        jArr2[i2] = a(jArr2[0], 0, true);
                    }
                    return jArr2;
                }
                throw new b("size invalid: " + a2);
            }
            throw new b("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new b("require field not exist.");
        }
    }

    public float[] a(float[] fArr, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f7283a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    float[] fArr2 = new float[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        fArr2[i2] = a(fArr2[0], 0, true);
                    }
                    return fArr2;
                }
                throw new b("size invalid: " + a2);
            }
            throw new b("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new b("require field not exist.");
        }
    }

    public double[] a(double[] dArr, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f7283a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    double[] dArr2 = new double[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        dArr2[i2] = a(dArr2[0], 0, true);
                    }
                    return dArr2;
                }
                throw new b("size invalid: " + a2);
            }
            throw new b("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new b("require field not exist.");
        }
    }

    public <T> T[] a(T[] tArr, int i, boolean z) {
        if (tArr != null && tArr.length != 0) {
            return b(tArr[0], i, z);
        }
        throw new b("unable to get type of key and value.");
    }

    public <T> List<T> a(List<T> list, int i, boolean z) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        Object[] b2 = b(list.get(0), i, z);
        if (b2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object add : b2) {
            arrayList.add(add);
        }
        return arrayList;
    }

    private <T> T[] b(T t, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f7283a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    T[] tArr = (Object[]) Array.newInstance(t.getClass(), a2);
                    for (int i2 = 0; i2 < a2; i2++) {
                        tArr[i2] = a(t, 0, true);
                    }
                    return tArr;
                }
                throw new b("size invalid: " + a2);
            }
            throw new b("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new b("require field not exist.");
        }
    }

    public g a(g gVar, int i, boolean z) {
        if (a(i)) {
            try {
                g gVar2 = (g) gVar.getClass().newInstance();
                a aVar = new a();
                a(aVar);
                if (aVar.f7283a == 10) {
                    gVar2.readFrom(this);
                    a();
                    return gVar2;
                }
                throw new b("type mismatch.");
            } catch (Exception e2) {
                throw new b(e2.getMessage());
            }
        } else if (!z) {
            return null;
        } else {
            throw new b("require field not exist.");
        }
    }

    public <T> Object a(T t, int i, boolean z) {
        if (t instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i, z));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(a(false, i, z));
        }
        if (t instanceof Short) {
            return Short.valueOf(a(0, i, z));
        }
        if (t instanceof Integer) {
            return Integer.valueOf(a(0, i, z));
        }
        if (t instanceof Long) {
            return Long.valueOf(a(0, i, z));
        }
        if (t instanceof Float) {
            return Float.valueOf(a((float) BitmapDescriptorFactory.HUE_RED, i, z));
        }
        if (t instanceof Double) {
            return Double.valueOf(a(0.0d, i, z));
        }
        if (t instanceof String) {
            return a(i, z);
        }
        if (t instanceof Map) {
            return a((Map) t, i, z);
        }
        if (t instanceof List) {
            return a((List) t, i, z);
        }
        if (t instanceof g) {
            return a((g) t, i, z);
        }
        if (!t.getClass().isArray()) {
            throw new b("read object error: unsupport type.");
        } else if ((t instanceof byte[]) || (t instanceof Byte[])) {
            return a((byte[]) null, i, z);
        } else {
            if (t instanceof boolean[]) {
                return a((boolean[]) null, i, z);
            }
            if (t instanceof short[]) {
                return a((short[]) null, i, z);
            }
            if (t instanceof int[]) {
                return a((int[]) null, i, z);
            }
            if (t instanceof long[]) {
                return a((long[]) null, i, z);
            }
            if (t instanceof float[]) {
                return a((float[]) null, i, z);
            }
            if (t instanceof double[]) {
                return a((double[]) null, i, z);
            }
            return a((T[]) (Object[]) t, i, z);
        }
    }
}
