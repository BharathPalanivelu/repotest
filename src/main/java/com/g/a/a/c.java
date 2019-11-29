package com.g.a.a;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f7279a;

    /* renamed from: b  reason: collision with root package name */
    private int f7280b = 0;

    private void a(String str) {
        for (int i = 0; i < this.f7280b; i++) {
            this.f7279a.append(9);
        }
        if (str != null) {
            StringBuilder sb = this.f7279a;
            sb.append(str);
            sb.append(": ");
        }
    }

    public c(StringBuilder sb, int i) {
        this.f7279a = sb;
        this.f7280b = i;
    }

    public c a(boolean z, String str) {
        a(str);
        StringBuilder sb = this.f7279a;
        sb.append(z ? 'T' : 'F');
        sb.append(10);
        return this;
    }

    public c a(byte b2, String str) {
        a(str);
        StringBuilder sb = this.f7279a;
        sb.append(b2);
        sb.append(10);
        return this;
    }

    public c a(char c2, String str) {
        a(str);
        StringBuilder sb = this.f7279a;
        sb.append(c2);
        sb.append(10);
        return this;
    }

    public c a(short s, String str) {
        a(str);
        StringBuilder sb = this.f7279a;
        sb.append(s);
        sb.append(10);
        return this;
    }

    public c a(int i, String str) {
        a(str);
        StringBuilder sb = this.f7279a;
        sb.append(i);
        sb.append(10);
        return this;
    }

    public c a(long j, String str) {
        a(str);
        StringBuilder sb = this.f7279a;
        sb.append(j);
        sb.append(10);
        return this;
    }

    public c a(float f2, String str) {
        a(str);
        StringBuilder sb = this.f7279a;
        sb.append(f2);
        sb.append(10);
        return this;
    }

    public c a(double d2, String str) {
        a(str);
        StringBuilder sb = this.f7279a;
        sb.append(d2);
        sb.append(10);
        return this;
    }

    public c a(String str, String str2) {
        a(str2);
        if (str == null) {
            StringBuilder sb = this.f7279a;
            sb.append("null");
            sb.append(10);
        } else {
            StringBuilder sb2 = this.f7279a;
            sb2.append(str);
            sb2.append(10);
        }
        return this;
    }

    public c a(byte[] bArr, String str) {
        a(str);
        if (bArr == null) {
            StringBuilder sb = this.f7279a;
            sb.append("null");
            sb.append(10);
            return this;
        } else if (bArr.length == 0) {
            StringBuilder sb2 = this.f7279a;
            sb2.append(bArr.length);
            sb2.append(", []");
            sb2.append(10);
            return this;
        } else {
            StringBuilder sb3 = this.f7279a;
            sb3.append(bArr.length);
            sb3.append(", [");
            sb3.append(10);
            c cVar = new c(this.f7279a, this.f7280b + 1);
            for (byte a2 : bArr) {
                cVar.a(a2, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    public c a(short[] sArr, String str) {
        a(str);
        if (sArr == null) {
            StringBuilder sb = this.f7279a;
            sb.append("null");
            sb.append(10);
            return this;
        } else if (sArr.length == 0) {
            StringBuilder sb2 = this.f7279a;
            sb2.append(sArr.length);
            sb2.append(", []");
            sb2.append(10);
            return this;
        } else {
            StringBuilder sb3 = this.f7279a;
            sb3.append(sArr.length);
            sb3.append(", [");
            sb3.append(10);
            c cVar = new c(this.f7279a, this.f7280b + 1);
            for (short a2 : sArr) {
                cVar.a(a2, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    public c a(int[] iArr, String str) {
        a(str);
        if (iArr == null) {
            StringBuilder sb = this.f7279a;
            sb.append("null");
            sb.append(10);
            return this;
        } else if (iArr.length == 0) {
            StringBuilder sb2 = this.f7279a;
            sb2.append(iArr.length);
            sb2.append(", []");
            sb2.append(10);
            return this;
        } else {
            StringBuilder sb3 = this.f7279a;
            sb3.append(iArr.length);
            sb3.append(", [");
            sb3.append(10);
            c cVar = new c(this.f7279a, this.f7280b + 1);
            for (int a2 : iArr) {
                cVar.a(a2, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    public c a(long[] jArr, String str) {
        a(str);
        if (jArr == null) {
            StringBuilder sb = this.f7279a;
            sb.append("null");
            sb.append(10);
            return this;
        } else if (jArr.length == 0) {
            StringBuilder sb2 = this.f7279a;
            sb2.append(jArr.length);
            sb2.append(", []");
            sb2.append(10);
            return this;
        } else {
            StringBuilder sb3 = this.f7279a;
            sb3.append(jArr.length);
            sb3.append(", [");
            sb3.append(10);
            c cVar = new c(this.f7279a, this.f7280b + 1);
            for (long a2 : jArr) {
                cVar.a(a2, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    public c a(float[] fArr, String str) {
        a(str);
        if (fArr == null) {
            StringBuilder sb = this.f7279a;
            sb.append("null");
            sb.append(10);
            return this;
        } else if (fArr.length == 0) {
            StringBuilder sb2 = this.f7279a;
            sb2.append(fArr.length);
            sb2.append(", []");
            sb2.append(10);
            return this;
        } else {
            StringBuilder sb3 = this.f7279a;
            sb3.append(fArr.length);
            sb3.append(", [");
            sb3.append(10);
            c cVar = new c(this.f7279a, this.f7280b + 1);
            for (float a2 : fArr) {
                cVar.a(a2, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    public c a(double[] dArr, String str) {
        a(str);
        if (dArr == null) {
            StringBuilder sb = this.f7279a;
            sb.append("null");
            sb.append(10);
            return this;
        } else if (dArr.length == 0) {
            StringBuilder sb2 = this.f7279a;
            sb2.append(dArr.length);
            sb2.append(", []");
            sb2.append(10);
            return this;
        } else {
            StringBuilder sb3 = this.f7279a;
            sb3.append(dArr.length);
            sb3.append(", [");
            sb3.append(10);
            c cVar = new c(this.f7279a, this.f7280b + 1);
            for (double a2 : dArr) {
                cVar.a(a2, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    public <K, V> c a(Map<K, V> map, String str) {
        a(str);
        if (map == null) {
            StringBuilder sb = this.f7279a;
            sb.append("null");
            sb.append(10);
            return this;
        } else if (map.isEmpty()) {
            StringBuilder sb2 = this.f7279a;
            sb2.append(map.size());
            sb2.append(", {}");
            sb2.append(10);
            return this;
        } else {
            StringBuilder sb3 = this.f7279a;
            sb3.append(map.size());
            sb3.append(", {");
            sb3.append(10);
            c cVar = new c(this.f7279a, this.f7280b + 1);
            c cVar2 = new c(this.f7279a, this.f7280b + 2);
            for (Map.Entry next : map.entrySet()) {
                cVar.a('(', (String) null);
                cVar2.a(next.getKey(), (String) null);
                cVar2.a(next.getValue(), (String) null);
                cVar.a(')', (String) null);
            }
            a('}', (String) null);
            return this;
        }
    }

    public <T> c a(T[] tArr, String str) {
        a(str);
        if (tArr == null) {
            StringBuilder sb = this.f7279a;
            sb.append("null");
            sb.append(10);
            return this;
        } else if (tArr.length == 0) {
            StringBuilder sb2 = this.f7279a;
            sb2.append(tArr.length);
            sb2.append(", []");
            sb2.append(10);
            return this;
        } else {
            StringBuilder sb3 = this.f7279a;
            sb3.append(tArr.length);
            sb3.append(", [");
            sb3.append(10);
            c cVar = new c(this.f7279a, this.f7280b + 1);
            for (T a2 : tArr) {
                cVar.a(a2, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    public <T> c a(Collection<T> collection, String str) {
        if (collection != null) {
            return a((T[]) collection.toArray(), str);
        }
        a(str);
        StringBuilder sb = this.f7279a;
        sb.append("null");
        sb.append(9);
        return this;
    }

    public <T> c a(T t, String str) {
        if (t == null) {
            StringBuilder sb = this.f7279a;
            sb.append("null");
            sb.append(10);
        } else if (t instanceof Byte) {
            a(((Byte) t).byteValue(), str);
        } else if (t instanceof Boolean) {
            a(((Boolean) t).booleanValue(), str);
        } else if (t instanceof Short) {
            a(((Short) t).shortValue(), str);
        } else if (t instanceof Integer) {
            a(((Integer) t).intValue(), str);
        } else if (t instanceof Long) {
            a(((Long) t).longValue(), str);
        } else if (t instanceof Float) {
            a(((Float) t).floatValue(), str);
        } else if (t instanceof Double) {
            a(((Double) t).doubleValue(), str);
        } else if (t instanceof String) {
            a((String) t, str);
        } else if (t instanceof Map) {
            a((Map) t, str);
        } else if (t instanceof List) {
            a((List) t, str);
        } else if (t instanceof g) {
            a((g) t, str);
        } else if (t instanceof byte[]) {
            a((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            a((boolean[]) t, str);
        } else if (t instanceof short[]) {
            a((short[]) t, str);
        } else if (t instanceof int[]) {
            a((int[]) t, str);
        } else if (t instanceof long[]) {
            a((long[]) t, str);
        } else if (t instanceof float[]) {
            a((float[]) t, str);
        } else if (t instanceof double[]) {
            a((double[]) t, str);
        } else if (t.getClass().isArray()) {
            a((T[]) (Object[]) t, str);
        } else {
            throw new d("write object error: unsupport type.");
        }
        return this;
    }

    public c a(g gVar, String str) {
        a('{', str);
        if (gVar == null) {
            StringBuilder sb = this.f7279a;
            sb.append(9);
            sb.append("null");
        } else {
            gVar.display(this.f7279a, this.f7280b + 1);
        }
        a('}', (String) null);
        return this;
    }
}
