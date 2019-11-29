package com.afollestad.materialdialogs.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.afollestad.materialdialogs.e;
import com.afollestad.materialdialogs.f;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class a {
    public static float a(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, new int[]{i});
        try {
            return obtainStyledAttributes.getFloat(0, BitmapDescriptorFactory.HUE_RED);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int a(int i, float f2) {
        return Color.argb(Math.round(((float) Color.alpha(i)) * f2), Color.red(i), Color.green(i), Color.blue(i));
    }

    public static int b(Context context, int i) {
        return a(context, i, 0);
    }

    public static int a(Context context, int i, int i2) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            return obtainStyledAttributes.getColor(0, i2);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList a(Context context, int i, ColorStateList colorStateList) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            TypedValue peekValue = obtainStyledAttributes.peekValue(0);
            if (peekValue == null) {
                return colorStateList;
            }
            if (peekValue.type < 28 || peekValue.type > 31) {
                ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(0);
                if (colorStateList2 != null) {
                    obtainStyledAttributes.recycle();
                    return colorStateList2;
                }
                obtainStyledAttributes.recycle();
                return colorStateList;
            }
            ColorStateList g2 = g(context, peekValue.data);
            obtainStyledAttributes.recycle();
            return g2;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static String c(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return (String) typedValue.string;
    }

    /* renamed from: com.afollestad.materialdialogs.a.a$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3142a = new int[e.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.afollestad.materialdialogs.e[] r0 = com.afollestad.materialdialogs.e.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3142a = r0
                int[] r0 = f3142a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.afollestad.materialdialogs.e r1 = com.afollestad.materialdialogs.e.CENTER     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f3142a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.afollestad.materialdialogs.e r1 = com.afollestad.materialdialogs.e.END     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.a.a.AnonymousClass3.<clinit>():void");
        }
    }

    private static int a(e eVar) {
        int i = AnonymousClass3.f3142a[eVar.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                return 0;
            }
        }
        return i2;
    }

    public static e a(Context context, int i, e eVar) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            int i2 = obtainStyledAttributes.getInt(0, a(eVar));
            if (i2 == 1) {
                e eVar2 = e.CENTER;
                obtainStyledAttributes.recycle();
                return eVar2;
            } else if (i2 != 2) {
                return e.START;
            } else {
                e eVar3 = e.END;
                obtainStyledAttributes.recycle();
                return eVar3;
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static Drawable d(Context context, int i) {
        return a(context, i, (Drawable) null);
    }

    private static Drawable a(Context context, int i, Drawable drawable) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            Drawable drawable2 = obtainStyledAttributes.getDrawable(0);
            if (drawable2 == null && drawable != null) {
                drawable2 = drawable;
            }
            return drawable2;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int e(Context context, int i) {
        return b(context, i, -1);
    }

    private static int b(Context context, int i, int i2) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            return obtainStyledAttributes.getDimensionPixelSize(0, i2);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static boolean a(Context context, int i, boolean z) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            return obtainStyledAttributes.getBoolean(0, z);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static boolean f(Context context, int i) {
        return a(context, i, false);
    }

    public static boolean a(int i) {
        double red = (double) Color.red(i);
        Double.isNaN(red);
        double green = (double) Color.green(i);
        Double.isNaN(green);
        double d2 = (red * 0.299d) + (green * 0.587d);
        double blue = (double) Color.blue(i);
        Double.isNaN(blue);
        return 1.0d - ((d2 + (blue * 0.114d)) / 255.0d) >= 0.5d;
    }

    public static void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT < 16) {
            view.setBackgroundDrawable(drawable);
        } else {
            view.setBackground(drawable);
        }
    }

    public static void a(DialogInterface dialogInterface, final f.a aVar) {
        final f fVar = (f) dialogInterface;
        if (fVar.f() != null) {
            fVar.f().post(new Runnable() {
                public void run() {
                    fVar.f().requestFocus();
                    InputMethodManager inputMethodManager = (InputMethodManager) aVar.a().getSystemService("input_method");
                    if (inputMethodManager != null) {
                        inputMethodManager.showSoftInput(fVar.f(), 1);
                    }
                }
            });
        }
    }

    public static void b(DialogInterface dialogInterface, final f.a aVar) {
        final f fVar = (f) dialogInterface;
        if (fVar.f() != null) {
            fVar.f().post(new Runnable() {
                public void run() {
                    fVar.f().requestFocus();
                    InputMethodManager inputMethodManager = (InputMethodManager) aVar.a().getSystemService("input_method");
                    if (inputMethodManager != null) {
                        inputMethodManager.hideSoftInputFromWindow(fVar.f().getWindowToken(), 0);
                    }
                }
            });
        }
    }

    public static ColorStateList g(Context context, int i) {
        int b2 = b(context, 16842806);
        if (i != 0) {
            b2 = i;
        }
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[0]}, new int[]{a(b2, 0.4f), b2});
    }
}
