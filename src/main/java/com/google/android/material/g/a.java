package com.google.android.material.g;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.StateSet;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f13315a = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f13316b = {16842919};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f13317c = {16843623, 16842908};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f13318d = {16842908};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f13319e = {16843623};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f13320f = {16842913, 16842919};

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f13321g = {16842913, 16843623, 16842908};
    private static final int[] h = {16842913, 16842908};
    private static final int[] i = {16842913, 16843623};
    private static final int[] j = {16842913};

    public static ColorStateList a(ColorStateList colorStateList) {
        if (f13315a) {
            return new ColorStateList(new int[][]{j, StateSet.NOTHING}, new int[]{a(colorStateList, f13320f), a(colorStateList, f13316b)});
        }
        int[] iArr = f13320f;
        int[] iArr2 = f13321g;
        int[] iArr3 = h;
        int[] iArr4 = i;
        int[] iArr5 = f13316b;
        int[] iArr6 = f13317c;
        int[] iArr7 = f13318d;
        int[] iArr8 = f13319e;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, j, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{a(colorStateList, iArr), a(colorStateList, iArr2), a(colorStateList, iArr3), a(colorStateList, iArr4), 0, a(colorStateList, iArr5), a(colorStateList, iArr6), a(colorStateList, iArr7), a(colorStateList, iArr8), 0});
    }

    private static int a(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f13315a ? a(colorForState) : colorForState;
    }

    @TargetApi(21)
    private static int a(int i2) {
        return androidx.core.graphics.a.c(i2, Math.min(Color.alpha(i2) * 2, 255));
    }
}
