package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.graphics.a;

class am {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f1133a = {-16842910};

    /* renamed from: b  reason: collision with root package name */
    static final int[] f1134b = {16842908};

    /* renamed from: c  reason: collision with root package name */
    static final int[] f1135c = {16843518};

    /* renamed from: d  reason: collision with root package name */
    static final int[] f1136d = {16842919};

    /* renamed from: e  reason: collision with root package name */
    static final int[] f1137e = {16842912};

    /* renamed from: f  reason: collision with root package name */
    static final int[] f1138f = {16842913};

    /* renamed from: g  reason: collision with root package name */
    static final int[] f1139g = {-16842919, -16842908};
    static final int[] h = new int[0];
    private static final ThreadLocal<TypedValue> i = new ThreadLocal<>();
    private static final int[] j = new int[1];

    public static int a(Context context, int i2) {
        int[] iArr = j;
        iArr[0] = i2;
        ar a2 = ar.a(context, (AttributeSet) null, iArr);
        try {
            return a2.b(0, 0);
        } finally {
            a2.a();
        }
    }

    public static ColorStateList b(Context context, int i2) {
        int[] iArr = j;
        iArr[0] = i2;
        ar a2 = ar.a(context, (AttributeSet) null, iArr);
        try {
            return a2.e(0);
        } finally {
            a2.a();
        }
    }

    public static int c(Context context, int i2) {
        ColorStateList b2 = b(context, i2);
        if (b2 != null && b2.isStateful()) {
            return b2.getColorForState(f1133a, b2.getDefaultColor());
        }
        TypedValue a2 = a();
        context.getTheme().resolveAttribute(16842803, a2, true);
        return a(context, i2, a2.getFloat());
    }

    private static TypedValue a() {
        TypedValue typedValue = i.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        i.set(typedValue2);
        return typedValue2;
    }

    static int a(Context context, int i2, float f2) {
        int a2 = a(context, i2);
        return a.c(a2, Math.round(((float) Color.alpha(a2)) * f2));
    }
}
