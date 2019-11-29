package com.garena.android.uikit.image.a;

import android.content.Context;
import android.view.View;
import com.garena.android.uikit.image.browser.BBTouchViewPager;

public class a extends BBTouchViewPager {
    public a(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public boolean a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof com.garena.android.uikit.image.c.a) {
            return ((com.garena.android.uikit.image.c.a) view).a(i);
        }
        return super.a(view, z, i, i2, i3);
    }
}
