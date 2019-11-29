package com.shopee.livequiz.g;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.shopee.livequiz.b;
import com.shopee.livequiz.c;

public class m {
    public static DisplayMetrics b() {
        return Resources.getSystem().getDisplayMetrics();
    }

    public static int c() {
        return b().widthPixels;
    }

    public static int d() {
        return b().heightPixels;
    }

    public static int e() {
        Resources resources = b.a().c().getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
        return dimensionPixelSize > 0 ? dimensionPixelSize : com.garena.android.appkit.tools.b.d(c.b.livequiz_header_top_margin);
    }

    public static boolean a(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        int measuredWidth = view.getMeasuredWidth() + i;
        int measuredHeight = view.getMeasuredHeight() + i2;
        if (f3 < ((float) i2) || f3 > ((float) measuredHeight) || f2 < ((float) i) || f2 > ((float) measuredWidth)) {
            return false;
        }
        return true;
    }
}
