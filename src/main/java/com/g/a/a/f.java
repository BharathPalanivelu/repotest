package com.g.a.a;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class f {

    /* renamed from: a  reason: collision with root package name */
    protected String f7285a;

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f7286b;

    /* renamed from: c  reason: collision with root package name */
    private i f7287c;

    public f(int i) {
        this.f7285a = "GBK";
        this.f7286b = ByteBuffer.allocate(i);
    }

    public f() {
        this(128);
    }

    public byte[] a() {
        byte[] bArr = new byte[this.f7286b.position()];
        System.arraycopy(this.f7286b.array(), 0, bArr, 0, this.f7286b.position());
        return bArr;
    }

    public void a(int i) {
        if (this.f7286b.remaining() < i) {
            int capacity = (this.f7286b.capacity() + i) * 2;
            try {
                ByteBuffer allocate = ByteBuffer.allocate(capacity);
                allocate.put(this.f7286b.array(), 0, this.f7286b.position());
                this.f7286b = allocate;
            } catch (IllegalArgumentException e2) {
                i iVar = this.f7287c;
                if (iVar != null) {
                    iVar.a(e2, this.f7286b, i, capacity);
                }
                throw e2;
            }
        }
    }

    public void a(byte b2, int i) {
        if (i < 15) {
            this.f7286b.put((byte) (b2 | (i << 4)));
        } else if (i < 256) {
            this.f7286b.put((byte) (b2 | 240));
            this.f7286b.put((byte) i);
        } else {
            throw new d("tag is too large: " + i);
        }
    }

    public void a(boolean z, int i) {
        b(z ? (byte) 1 : 0, i);
    }

    public void b(byte b2, int i) {
        a(3);
        if (b2 == 0) {
            a((byte) g.ZERO_TAG, i);
            return;
        }
        a((byte) 0, i);
        this.f7286b.put(b2);
    }

    public void a(short s, int i) {
        a(4);
        if (s < -128 || s > 127) {
            a((byte) 1, i);
            this.f7286b.putShort(s);
            return;
        }
        b((byte) s, i);
    }

    public void a(int i, int i2) {
        a(6);
        if (i < -32768 || i > 32767) {
            a((byte) 2, i2);
            this.f7286b.putInt(i);
            return;
        }
        a((short) i, i2);
    }

    public void a(long j, int i) {
        a(10);
        if (j < -2147483648L || j > 2147483647L) {
            a((byte) 3, i);
            this.f7286b.putLong(j);
            return;
        }
        a((int) j, i);
    }

    public void a(float f2, int i) {
        a(6);
        a((byte) 4, i);
        this.f7286b.putFloat(f2);
    }

    public void a(double d2, int i) {
        a(10);
        a((byte) 5, i);
        this.f7286b.putDouble(d2);
    }

    public void a(String str, int i) {
        byte[] bArr;
        try {
            bArr = str.getBytes(this.f7285a);
        } catch (UnsupportedEncodingException unused) {
            bArr = str.getBytes();
        }
        a(bArr.length + 10);
        if (bArr.length > 255) {
            a((byte) 7, i);
            this.f7286b.putInt(bArr.length);
            this.f7286b.put(bArr);
            return;
        }
        a((byte) 6, i);
        this.f7286b.put((byte) bArr.length);
        this.f7286b.put(bArr);
    }

    public <K, V> void a(Map<K, V> map, int i) {
        int i2;
        a(8);
        a((byte) 8, i);
        if (map == null) {
            i2 = 0;
        } else {
            i2 = map.size();
        }
        a(i2, 0);
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                a(next.getKey(), 0);
                a(next.getValue(), 1);
            }
        }
    }

    public void a(boolean[] zArr, int i) {
        a(8);
        a((byte) 9, i);
        a(zArr.length, 0);
        for (boolean a2 : zArr) {
            a(a2, 0);
        }
    }

    public void a(byte[] bArr, int i) {
        a(bArr.length + 8);
        a((byte) g.SIMPLE_LIST, i);
        a((byte) 0, 0);
        a(bArr.length, 0);
        this.f7286b.put(bArr);
    }

    public void a(short[] sArr, int i) {
        a(8);
        a((byte) 9, i);
        a(sArr.length, 0);
        for (short a2 : sArr) {
            a(a2, 0);
        }
    }

    public void a(int[] iArr, int i) {
        a(8);
        a((byte) 9, i);
        a(iArr.length, 0);
        for (int a2 : iArr) {
            a(a2, 0);
        }
    }

    public void a(long[] jArr, int i) {
        a(8);
        a((byte) 9, i);
        a(jArr.length, 0);
        for (long a2 : jArr) {
            a(a2, 0);
        }
    }

    public void a(float[] fArr, int i) {
        a(8);
        a((byte) 9, i);
        a(fArr.length, 0);
        for (float a2 : fArr) {
            a(a2, 0);
        }
    }

    public void a(double[] dArr, int i) {
        a(8);
        a((byte) 9, i);
        a(dArr.length, 0);
        for (double a2 : dArr) {
            a(a2, 0);
        }
    }

    private void a(Object[] objArr, int i) {
        a(8);
        a((byte) 9, i);
        a(objArr.length, 0);
        for (Object a2 : objArr) {
            a(a2, 0);
        }
    }

    public <T> void a(Collection<T> collection, int i) {
        int i2;
        a(8);
        a((byte) 9, i);
        if (collection == null) {
            i2 = 0;
        } else {
            i2 = collection.size();
        }
        a(i2, 0);
        if (collection != null) {
            for (T a2 : collection) {
                a((Object) a2, 0);
            }
        }
    }

    public void a(g gVar, int i) {
        a(2);
        a((byte) 10, i);
        gVar.writeTo(this);
        a(2);
        a((byte) g.STRUCT_END, 0);
    }

    public void a(Object obj, int i) {
        if (obj instanceof Byte) {
            b(((Byte) obj).byteValue(), i);
        } else if (obj instanceof Boolean) {
            a(((Boolean) obj).booleanValue(), i);
        } else if (obj instanceof Short) {
            a(((Short) obj).shortValue(), i);
        } else if (obj instanceof Integer) {
            a(((Integer) obj).intValue(), i);
        } else if (obj instanceof Long) {
            a(((Long) obj).longValue(), i);
        } else if (obj instanceof Float) {
            a(((Float) obj).floatValue(), i);
        } else if (obj instanceof Double) {
            a(((Double) obj).doubleValue(), i);
        } else if (obj instanceof String) {
            a((String) obj, i);
        } else if (obj instanceof Map) {
            a((Map) obj, i);
        } else if (obj instanceof List) {
            a((List) obj, i);
        } else if (obj instanceof g) {
            a((g) obj, i);
        } else if (obj instanceof byte[]) {
            a((byte[]) obj, i);
        } else if (obj instanceof boolean[]) {
            a((boolean[]) obj, i);
        } else if (obj instanceof short[]) {
            a((short[]) obj, i);
        } else if (obj instanceof int[]) {
            a((int[]) obj, i);
        } else if (obj instanceof long[]) {
            a((long[]) obj, i);
        } else if (obj instanceof float[]) {
            a((float[]) obj, i);
        } else if (obj instanceof double[]) {
            a((double[]) obj, i);
        } else if (obj.getClass().isArray()) {
            a((Object[]) obj, i);
        } else if (obj instanceof Collection) {
            a((Collection) obj, i);
        } else {
            throw new d("write object error: unsupport type. " + obj.getClass());
        }
    }

    public int a(String str) {
        this.f7285a = str;
        return 0;
    }
}
