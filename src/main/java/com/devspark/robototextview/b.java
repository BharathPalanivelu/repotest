package com.devspark.robototextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.TextView;
import com.devspark.robototextview.a;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final SparseArray<Typeface> f6631a = new SparseArray<>(32);

    public static Typeface a(Context context, int i) {
        Typeface typeface = f6631a.get(i);
        if (typeface != null) {
            return typeface;
        }
        Typeface b2 = b(context, i);
        f6631a.put(i, b2);
        return b2;
    }

    public static Typeface a(Context context, int i, int i2, int i3) {
        int i4 = 5;
        if (i == 0) {
            if (i3 == 0) {
                if (i2 == 0) {
                    i4 = 4;
                } else if (i2 == 1) {
                    i4 = 0;
                } else if (i2 == 2) {
                    i4 = 2;
                } else if (i2 == 3) {
                    i4 = 6;
                } else if (i2 == 4) {
                    i4 = 8;
                } else if (i2 == 5) {
                    i4 = 10;
                } else {
                    throw new IllegalArgumentException("`robotoTextWeight` attribute value " + i2 + " is not supported for this fontFamily " + i + " and textStyle " + i3);
                }
            } else if (i3 != 1) {
                throw new IllegalArgumentException("`robotoTextStyle` attribute value " + i3 + " is not supported for this fontFamily " + i);
            } else if (i2 != 0) {
                if (i2 == 1) {
                    i4 = 1;
                } else if (i2 == 2) {
                    i4 = 3;
                } else if (i2 == 3) {
                    i4 = 7;
                } else if (i2 == 4) {
                    i4 = 9;
                } else if (i2 == 5) {
                    i4 = 11;
                } else {
                    throw new IllegalArgumentException("`robotoTextWeight` attribute value " + i2 + " is not supported for this fontFamily " + i + " and textStyle " + i3);
                }
            }
        } else if (i == 1) {
            if (i3 == 0) {
                if (i2 == 0) {
                    i4 = 14;
                } else if (i2 == 1) {
                    i4 = 12;
                } else if (i2 == 4) {
                    i4 = 16;
                } else {
                    throw new IllegalArgumentException("`robotoTextWeight` attribute value " + i2 + " is not supported for this fontFamily " + i + " and textStyle " + i3);
                }
            } else if (i3 != 1) {
                throw new IllegalArgumentException("`robotoTextStyle` attribute value " + i3 + " is not supported for this fontFamily " + i);
            } else if (i2 == 0) {
                i4 = 15;
            } else if (i2 == 1) {
                i4 = 13;
            } else if (i2 == 4) {
                i4 = 17;
            } else {
                throw new IllegalArgumentException("`robotoTextWeight` attribute value " + i2 + " is not supported for this fontFamily " + i + " and textStyle " + i3);
            }
        } else if (i == 2) {
            if (i3 != 0) {
                throw new IllegalArgumentException("`robotoTextStyle` attribute value " + i3 + " is not supported for this fontFamily " + i);
            } else if (i2 == 0) {
                i4 = 20;
            } else if (i2 == 1) {
                i4 = 18;
            } else if (i2 == 2) {
                i4 = 19;
            } else if (i2 == 4) {
                i4 = 21;
            } else {
                throw new IllegalArgumentException("`robotoTextWeight` attribute value " + i2 + " is not supported for this fontFamily " + i + " and textStyle " + i3);
            }
        } else if (i != 3) {
            throw new IllegalArgumentException("Unknown `robotoFontFamily` attribute value " + i);
        } else if (i3 == 0) {
            if (i2 == 0) {
                i4 = 26;
            } else if (i2 == 1) {
                i4 = 22;
            } else if (i2 == 2) {
                i4 = 24;
            } else if (i2 == 3) {
                i4 = 28;
            } else if (i2 == 4) {
                i4 = 30;
            } else {
                throw new IllegalArgumentException("`robotoTextWeight` attribute value " + i2 + " is not supported for this fontFamily " + i + " and textStyle " + i3);
            }
        } else if (i3 != 1) {
            throw new IllegalArgumentException("`robotoTextStyle` attribute value " + i3 + " is not supported for this fontFamily " + i);
        } else if (i2 == 0) {
            i4 = 27;
        } else if (i2 == 1) {
            i4 = 23;
        } else if (i2 == 2) {
            i4 = 25;
        } else if (i2 == 3) {
            i4 = 29;
        } else if (i2 == 4) {
            i4 = 31;
        } else {
            throw new IllegalArgumentException("`robotoTextWeight` attribute value " + i2 + " is not supported for this fontFamily " + i + " and textStyle " + i3);
        }
        return a(context, i4);
    }

    private static Typeface b(Context context, int i) {
        String str;
        switch (i) {
            case 0:
                str = "fonts/Roboto-Thin.ttf";
                break;
            case 1:
                str = "fonts/Roboto-ThinItalic.ttf";
                break;
            case 2:
                str = "fonts/Roboto-Light.ttf";
                break;
            case 3:
                str = "fonts/Roboto-LightItalic.ttf";
                break;
            case 4:
                str = "fonts/Roboto-Regular.ttf";
                break;
            case 5:
                str = "fonts/Roboto-Italic.ttf";
                break;
            case 6:
                str = "fonts/Roboto-Medium.ttf";
                break;
            case 7:
                str = "fonts/Roboto-MediumItalic.ttf";
                break;
            case 8:
                str = "fonts/Roboto-Bold.ttf";
                break;
            case 9:
                str = "fonts/Roboto-BoldItalic.ttf";
                break;
            case 10:
                str = "fonts/Roboto-Black.ttf";
                break;
            case 11:
                str = "fonts/Roboto-BlackItalic.ttf";
                break;
            case 12:
                str = "fonts/RobotoCondensed-Light.ttf";
                break;
            case 13:
                str = "fonts/RobotoCondensed-LightItalic.ttf";
                break;
            case 14:
                str = "fonts/RobotoCondensed-Regular.ttf";
                break;
            case 15:
                str = "fonts/RobotoCondensed-Italic.ttf";
                break;
            case 16:
                str = "fonts/RobotoCondensed-Bold.ttf";
                break;
            case 17:
                str = "fonts/RobotoCondensed-BoldItalic.ttf";
                break;
            case 18:
                str = "fonts/RobotoSlab-Thin.ttf";
                break;
            case 19:
                str = "fonts/RobotoSlab-Light.ttf";
                break;
            case 20:
                str = "fonts/RobotoSlab-Regular.ttf";
                break;
            case 21:
                str = "fonts/RobotoSlab-Bold.ttf";
                break;
            case 22:
                str = "fonts/RobotoMono-Thin.ttf";
                break;
            case 23:
                str = "fonts/RobotoMono-ThinItalic.ttf";
                break;
            case 24:
                str = "fonts/RobotoMono-Light.ttf";
                break;
            case 25:
                str = "fonts/RobotoMono-LightItalic.ttf";
                break;
            case 26:
                str = "fonts/RobotoMono-Regular.ttf";
                break;
            case 27:
                str = "fonts/RobotoMono-Italic.ttf";
                break;
            case 28:
                str = "fonts/RobotoMono-Medium.ttf";
                break;
            case 29:
                str = "fonts/RobotoMono-MediumItalic.ttf";
                break;
            case 30:
                str = "fonts/RobotoMono-Bold.ttf";
                break;
            case 31:
                str = "fonts/RobotoMono-BoldItalic.ttf";
                break;
            default:
                throw new IllegalArgumentException("Unknown `robotoTypeface` attribute value " + i);
        }
        return Typeface.createFromAsset(context.getAssets(), str);
    }

    public static Typeface a(Context context, TypedArray typedArray) {
        if (typedArray.hasValue(a.C0115a.RobotoTextView_robotoTypeface)) {
            return a(context, typedArray.getInt(a.C0115a.RobotoTextView_robotoTypeface, 4));
        }
        return a(context, typedArray.getInt(a.C0115a.RobotoTextView_robotoFontFamily, 0), typedArray.getInt(a.C0115a.RobotoTextView_robotoTextWeight, 0), typedArray.getInt(a.C0115a.RobotoTextView_robotoTextStyle, 0));
    }

    public static void a(TextView textView, Context context, AttributeSet attributeSet) {
        Typeface typeface;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0115a.RobotoTextView);
            try {
                typeface = a(context, obtainStyledAttributes);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            typeface = a(context, 4);
        }
        a(textView, typeface);
    }

    public static void a(TextView textView, Typeface typeface) {
        textView.setPaintFlags(textView.getPaintFlags() | 1 | 128);
        textView.setTypeface(typeface);
    }

    public static void a(Paint paint, Typeface typeface) {
        paint.setFlags(paint.getFlags() | 1 | 128);
        paint.setTypeface(typeface);
    }
}
