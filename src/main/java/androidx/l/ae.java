package androidx.l;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.Property;
import android.view.View;
import androidx.core.g.w;
import java.lang.reflect.Field;

class ae {

    /* renamed from: a  reason: collision with root package name */
    static final Property<View, Float> f2419a = new Property<View, Float>(Float.class, "translationAlpha") {
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(ae.c(view));
        }

        /* renamed from: a */
        public void set(View view, Float f2) {
            ae.a(view, f2.floatValue());
        }
    };

    /* renamed from: b  reason: collision with root package name */
    static final Property<View, Rect> f2420b = new Property<View, Rect>(Rect.class, "clipBounds") {
        /* renamed from: a */
        public Rect get(View view) {
            return w.C(view);
        }

        /* renamed from: a */
        public void set(View view, Rect rect) {
            w.a(view, rect);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static final ai f2421c;

    /* renamed from: d  reason: collision with root package name */
    private static Field f2422d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f2423e;

    static {
        if (Build.VERSION.SDK_INT >= 22) {
            f2421c = new ah();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f2421c = new ag();
        } else if (Build.VERSION.SDK_INT >= 19) {
            f2421c = new af();
        } else {
            f2421c = new ai();
        }
    }

    static ad a(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ac(view);
        }
        return ab.d(view);
    }

    static am b(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new al(view);
        }
        return new ak(view.getWindowToken());
    }

    static void a(View view, float f2) {
        f2421c.a(view, f2);
    }

    static float c(View view) {
        return f2421c.a(view);
    }

    static void d(View view) {
        f2421c.b(view);
    }

    static void e(View view) {
        f2421c.c(view);
    }

    static void a(View view, int i) {
        a();
        Field field = f2422d;
        if (field != null) {
            try {
                f2422d.setInt(view, i | (field.getInt(view) & -13));
            } catch (IllegalAccessException unused) {
            }
        }
    }

    static void a(View view, Matrix matrix) {
        f2421c.a(view, matrix);
    }

    static void b(View view, Matrix matrix) {
        f2421c.b(view, matrix);
    }

    static void a(View view, int i, int i2, int i3, int i4) {
        f2421c.a(view, i, i2, i3, i4);
    }

    private static void a() {
        if (!f2423e) {
            try {
                f2422d = View.class.getDeclaredField("mViewFlags");
                f2422d.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtils", "fetchViewFlagsField: ");
            }
            f2423e = true;
        }
    }
}
