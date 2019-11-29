package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.b.e;
import androidx.core.content.a.c;
import androidx.core.content.a.f;
import androidx.core.e.b;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final i f1826a;

    /* renamed from: b  reason: collision with root package name */
    private static final e<String, Typeface> f1827b = new e<>(16);

    static {
        if (Build.VERSION.SDK_INT >= 28) {
            f1826a = new h();
        } else if (Build.VERSION.SDK_INT >= 26) {
            f1826a = new g();
        } else if (Build.VERSION.SDK_INT >= 24 && f.a()) {
            f1826a = new f();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f1826a = new e();
        } else {
            f1826a = new i();
        }
    }

    public static Typeface a(Resources resources, int i, int i2) {
        return f1827b.get(b(resources, i, i2));
    }

    private static String b(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    public static Typeface a(Context context, c.a aVar, Resources resources, int i, int i2, f.a aVar2, Handler handler, boolean z) {
        Typeface typeface;
        if (aVar instanceof c.d) {
            c.d dVar = (c.d) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : dVar.b() == 0) {
                z2 = true;
            }
            typeface = b.a(context, dVar.a(), aVar2, handler, z2, z ? dVar.c() : -1, i2);
        } else {
            typeface = f1826a.a(context, (c.b) aVar, resources, i2);
            if (aVar2 != null) {
                if (typeface != null) {
                    aVar2.a(typeface, handler);
                } else {
                    aVar2.a(-3, handler);
                }
            }
        }
        if (typeface != null) {
            f1827b.put(b(resources, i, i2), typeface);
        }
        return typeface;
    }

    public static Typeface a(Context context, Resources resources, int i, String str, int i2) {
        Typeface a2 = f1826a.a(context, resources, i, str, i2);
        if (a2 != null) {
            f1827b.put(b(resources, i, i2), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b.C0031b[] bVarArr, int i) {
        return f1826a.a(context, cancellationSignal, bVarArr, i);
    }

    private static Typeface b(Context context, Typeface typeface, int i) {
        c.b a2 = f1826a.a(typeface);
        if (a2 == null) {
            return null;
        }
        return f1826a.a(context, a2, context.getResources(), i);
    }

    public static Typeface a(Context context, Typeface typeface, int i) {
        if (context != null) {
            if (Build.VERSION.SDK_INT < 21) {
                Typeface b2 = b(context, typeface, i);
                if (b2 != null) {
                    return b2;
                }
            }
            return Typeface.create(typeface, i);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }
}
