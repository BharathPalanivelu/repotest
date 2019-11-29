package com.bca.xco.widget.d.b;

import com.appsflyer.share.Constants;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.io.EOFException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;

public class h implements Serializable, Comparable<h> {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f5216a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b  reason: collision with root package name */
    public static final h f5217b = a(new byte[0]);
    private static final long serialVersionUID = 1;

    /* renamed from: c  reason: collision with root package name */
    final byte[] f5218c;

    /* renamed from: d  reason: collision with root package name */
    transient int f5219d;

    /* renamed from: e  reason: collision with root package name */
    transient String f5220e;

    h(byte[] bArr) {
        this.f5218c = bArr;
    }

    public static h a(byte... bArr) {
        if (bArr != null) {
            return new h((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static h a(String str) {
        if (str != null) {
            h hVar = new h(str.getBytes(t.f5259a));
            hVar.f5220e = str;
            return hVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public String a() {
        String str = this.f5220e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f5218c, t.f5259a);
        this.f5220e = str2;
        return str2;
    }

    public String b() {
        return f.a(this.f5218c);
    }

    public String c() {
        byte[] bArr = this.f5218c;
        char[] cArr = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f5216a;
            cArr[i] = cArr2[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public static h a(InputStream inputStream, int i) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (i >= 0) {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read != -1) {
                    i2 += read;
                } else {
                    throw new EOFException();
                }
            }
            return new h(bArr);
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + i);
        }
    }

    public h d() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f5218c;
            if (i >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i];
            if (b2 < 65 || b2 > 90) {
                i++;
            } else {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b3 = bArr2[i2];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr2[i2] = (byte) (b3 + 32);
                    }
                }
                return new h(bArr2);
            }
        }
    }

    public h a(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.f5218c;
            if (i2 <= bArr.length) {
                int i3 = i2 - i;
                if (i3 < 0) {
                    throw new IllegalArgumentException("endIndex < beginIndex");
                } else if (i == 0 && i2 == bArr.length) {
                    return this;
                } else {
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(this.f5218c, i, bArr2, 0, i3);
                    return new h(bArr2);
                }
            } else {
                throw new IllegalArgumentException("endIndex > length(" + this.f5218c.length + SQLBuilder.PARENTHESES_RIGHT);
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0");
        }
    }

    public byte a(int i) {
        return this.f5218c[i];
    }

    public int e() {
        return this.f5218c.length;
    }

    public byte[] f() {
        return (byte[]) this.f5218c.clone();
    }

    /* access modifiers changed from: package-private */
    public void a(g gVar) {
        byte[] bArr = this.f5218c;
        gVar.a(bArr, 0, bArr.length);
    }

    public boolean a(int i, h hVar, int i2, int i3) {
        return hVar.a(i2, this.f5218c, i, i3);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.f5218c;
            return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && t.a(bArr2, i, bArr, i2, i3);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            int e2 = hVar.e();
            byte[] bArr = this.f5218c;
            if (e2 != bArr.length || !hVar.a(0, bArr, 0, bArr.length)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.f5219d;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.f5218c);
        this.f5219d = hashCode;
        return hashCode;
    }

    /* renamed from: a */
    public int compareTo(h hVar) {
        int e2 = e();
        int e3 = hVar.e();
        int min = Math.min(e2, e3);
        int i = 0;
        while (i < min) {
            byte a2 = a(i) & 255;
            byte a3 = hVar.a(i) & 255;
            if (a2 == a3) {
                i++;
            } else if (a2 < a3) {
                return -1;
            } else {
                return 1;
            }
        }
        if (e2 == e3) {
            return 0;
        }
        if (e2 < e3) {
            return -1;
        }
        return 1;
    }

    public String toString() {
        StringBuilder sb;
        if (this.f5218c.length == 0) {
            return "[size=0]";
        }
        String a2 = a();
        int a3 = a(a2, 64);
        if (a3 != -1) {
            String replace = a2.substring(0, a3).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (a3 < a2.length()) {
                sb = new StringBuilder();
                sb.append("[size=");
                sb.append(this.f5218c.length);
                sb.append(" text=");
                sb.append(replace);
                sb.append("…]");
            } else {
                sb = new StringBuilder();
                sb.append("[text=");
                sb.append(replace);
                sb.append("]");
            }
            return sb.toString();
        } else if (this.f5218c.length <= 64) {
            return "[hex=" + c() + "]";
        } else {
            return "[size=" + this.f5218c.length + " hex=" + a(0, 64).c() + "…]";
        }
    }

    static int a(String str, int i) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        h a2 = a((InputStream) objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = h.class.getDeclaredField(Constants.URL_CAMPAIGN);
            declaredField.setAccessible(true);
            declaredField.set(this, a2.f5218c);
        } catch (NoSuchFieldException unused) {
            throw new AssertionError();
        } catch (IllegalAccessException unused2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.f5218c.length);
        objectOutputStream.write(this.f5218c);
    }
}
