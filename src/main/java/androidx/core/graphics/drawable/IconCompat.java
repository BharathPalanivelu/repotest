package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

public class IconCompat extends CustomVersionedParcelable {
    static final PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public int f1828a = -1;

    /* renamed from: b  reason: collision with root package name */
    Object f1829b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f1830c = null;

    /* renamed from: d  reason: collision with root package name */
    public Parcelable f1831d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f1832e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f1833f = 0;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f1834g = null;
    PorterDuff.Mode i = h;
    public String j = null;

    private static String a(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "UNKNOWN" : "BITMAP_MASKABLE" : "URI" : "DATA" : "RESOURCE" : "BITMAP";
    }

    public String a() {
        if (this.f1828a == -1 && Build.VERSION.SDK_INT >= 23) {
            return a((Icon) this.f1829b);
        }
        if (this.f1828a == 2) {
            return ((String) this.f1829b).split(":", -1)[0];
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int b() {
        if (this.f1828a == -1 && Build.VERSION.SDK_INT >= 23) {
            return b((Icon) this.f1829b);
        }
        if (this.f1828a == 2) {
            return this.f1832e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (r1 != 5) goto L_0x009a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r4 = this;
            int r0 = r4.f1828a
            r1 = -1
            if (r0 != r1) goto L_0x000c
            java.lang.Object r0 = r4.f1829b
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        L_0x000c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Icon(typ="
            r0.<init>(r1)
            int r1 = r4.f1828a
            java.lang.String r1 = a((int) r1)
            r0.append(r1)
            int r1 = r4.f1828a
            r2 = 1
            if (r1 == r2) goto L_0x007a
            r3 = 2
            if (r1 == r3) goto L_0x0052
            r2 = 3
            if (r1 == r2) goto L_0x0039
            r2 = 4
            if (r1 == r2) goto L_0x002e
            r2 = 5
            if (r1 == r2) goto L_0x007a
            goto L_0x009a
        L_0x002e:
            java.lang.String r1 = " uri="
            r0.append(r1)
            java.lang.Object r1 = r4.f1829b
            r0.append(r1)
            goto L_0x009a
        L_0x0039:
            java.lang.String r1 = " len="
            r0.append(r1)
            int r1 = r4.f1832e
            r0.append(r1)
            int r1 = r4.f1833f
            if (r1 == 0) goto L_0x009a
            java.lang.String r1 = " off="
            r0.append(r1)
            int r1 = r4.f1833f
            r0.append(r1)
            goto L_0x009a
        L_0x0052:
            java.lang.String r1 = " pkg="
            r0.append(r1)
            java.lang.String r1 = r4.a()
            r0.append(r1)
            java.lang.String r1 = " id="
            r0.append(r1)
            java.lang.Object[] r1 = new java.lang.Object[r2]
            r2 = 0
            int r3 = r4.b()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1[r2] = r3
            java.lang.String r2 = "0x%08x"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            r0.append(r1)
            goto L_0x009a
        L_0x007a:
            java.lang.String r1 = " size="
            r0.append(r1)
            java.lang.Object r1 = r4.f1829b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getWidth()
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            java.lang.Object r1 = r4.f1829b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getHeight()
            r0.append(r1)
        L_0x009a:
            android.content.res.ColorStateList r1 = r4.f1834g
            if (r1 == 0) goto L_0x00a8
            java.lang.String r1 = " tint="
            r0.append(r1)
            android.content.res.ColorStateList r1 = r4.f1834g
            r0.append(r1)
        L_0x00a8:
            android.graphics.PorterDuff$Mode r1 = r4.i
            android.graphics.PorterDuff$Mode r2 = h
            if (r1 == r2) goto L_0x00b8
            java.lang.String r1 = " mode="
            r0.append(r1)
            android.graphics.PorterDuff$Mode r1 = r4.i
            r0.append(r1)
        L_0x00b8:
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.toString():java.lang.String");
    }

    public void a(boolean z) {
        this.j = this.i.name();
        int i2 = this.f1828a;
        if (i2 != -1) {
            if (i2 != 1) {
                if (i2 == 2) {
                    this.f1830c = ((String) this.f1829b).getBytes(Charset.forName("UTF-16"));
                    return;
                } else if (i2 == 3) {
                    this.f1830c = (byte[]) this.f1829b;
                    return;
                } else if (i2 == 4) {
                    this.f1830c = this.f1829b.toString().getBytes(Charset.forName("UTF-16"));
                    return;
                } else if (i2 != 5) {
                    return;
                }
            }
            if (z) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ((Bitmap) this.f1829b).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f1830c = byteArrayOutputStream.toByteArray();
                return;
            }
            this.f1831d = (Parcelable) this.f1829b;
        } else if (!z) {
            this.f1831d = (Parcelable) this.f1829b;
        } else {
            throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
        }
    }

    public void c() {
        this.i = PorterDuff.Mode.valueOf(this.j);
        int i2 = this.f1828a;
        if (i2 != -1) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        this.f1829b = this.f1830c;
                        return;
                    } else if (i2 != 4) {
                        if (i2 != 5) {
                            return;
                        }
                    }
                }
                this.f1829b = new String(this.f1830c, Charset.forName("UTF-16"));
                return;
            }
            Parcelable parcelable = this.f1831d;
            if (parcelable != null) {
                this.f1829b = parcelable;
                return;
            }
            byte[] bArr = this.f1830c;
            this.f1829b = bArr;
            this.f1828a = 3;
            this.f1832e = 0;
            this.f1833f = bArr.length;
            return;
        }
        Parcelable parcelable2 = this.f1831d;
        if (parcelable2 != null) {
            this.f1829b = parcelable2;
            return;
        }
        throw new IllegalArgumentException("Invalid icon");
    }

    private static String a(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon package", e3);
            return null;
        } catch (NoSuchMethodException e4) {
            Log.e("IconCompat", "Unable to get icon package", e4);
            return null;
        }
    }

    private static int b(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        } catch (NoSuchMethodException e4) {
            Log.e("IconCompat", "Unable to get icon resource", e4);
            return 0;
        }
    }
}
