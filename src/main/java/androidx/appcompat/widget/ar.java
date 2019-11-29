package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.a.a.a;
import androidx.core.content.a.f;

public class ar {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1149a;

    /* renamed from: b  reason: collision with root package name */
    private final TypedArray f1150b;

    /* renamed from: c  reason: collision with root package name */
    private TypedValue f1151c;

    public static ar a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new ar(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static ar a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new ar(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public static ar a(Context context, int i, int[] iArr) {
        return new ar(context, context.obtainStyledAttributes(i, iArr));
    }

    private ar(Context context, TypedArray typedArray) {
        this.f1149a = context;
        this.f1150b = typedArray;
    }

    public Drawable a(int i) {
        if (this.f1150b.hasValue(i)) {
            int resourceId = this.f1150b.getResourceId(i, 0);
            if (resourceId != 0) {
                return a.b(this.f1149a, resourceId);
            }
        }
        return this.f1150b.getDrawable(i);
    }

    public Drawable b(int i) {
        if (!this.f1150b.hasValue(i)) {
            return null;
        }
        int resourceId = this.f1150b.getResourceId(i, 0);
        if (resourceId != 0) {
            return j.b().a(this.f1149a, resourceId, true);
        }
        return null;
    }

    public Typeface a(int i, int i2, f.a aVar) {
        int resourceId = this.f1150b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1151c == null) {
            this.f1151c = new TypedValue();
        }
        return f.a(this.f1149a, resourceId, this.f1151c, i2, aVar);
    }

    public CharSequence c(int i) {
        return this.f1150b.getText(i);
    }

    public String d(int i) {
        return this.f1150b.getString(i);
    }

    public boolean a(int i, boolean z) {
        return this.f1150b.getBoolean(i, z);
    }

    public int a(int i, int i2) {
        return this.f1150b.getInt(i, i2);
    }

    public float a(int i, float f2) {
        return this.f1150b.getFloat(i, f2);
    }

    public int b(int i, int i2) {
        return this.f1150b.getColor(i, i2);
    }

    public ColorStateList e(int i) {
        if (this.f1150b.hasValue(i)) {
            int resourceId = this.f1150b.getResourceId(i, 0);
            if (resourceId != 0) {
                ColorStateList a2 = a.a(this.f1149a, resourceId);
                if (a2 != null) {
                    return a2;
                }
            }
        }
        return this.f1150b.getColorStateList(i);
    }

    public int c(int i, int i2) {
        return this.f1150b.getInteger(i, i2);
    }

    public float b(int i, float f2) {
        return this.f1150b.getDimension(i, f2);
    }

    public int d(int i, int i2) {
        return this.f1150b.getDimensionPixelOffset(i, i2);
    }

    public int e(int i, int i2) {
        return this.f1150b.getDimensionPixelSize(i, i2);
    }

    public int f(int i, int i2) {
        return this.f1150b.getLayoutDimension(i, i2);
    }

    public int g(int i, int i2) {
        return this.f1150b.getResourceId(i, i2);
    }

    public CharSequence[] f(int i) {
        return this.f1150b.getTextArray(i);
    }

    public boolean g(int i) {
        return this.f1150b.hasValue(i);
    }

    public void a() {
        this.f1150b.recycle();
    }
}
