package com.garena.library.reactshadow.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.view.ReactViewGroup;
import java.util.Locale;

public class a extends ReactViewGroup {
    public a(Context context) {
        super(context);
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        Drawable a2 = a(i);
        if (i2 == 0 && i4 == 0 && i3 == 0 && i5 == 0) {
            setTranslucentBackgroundDrawable(a2);
        } else {
            setTranslucentBackgroundDrawable(new InsetDrawable(a2, i2, i3, i4, i5));
        }
    }

    private Drawable a(int i) {
        int max = Math.max(-1, Math.min(i, 9));
        return getResources().getDrawable(getResources().getIdentifier(String.format(Locale.ENGLISH, "ms9_composite_shadow_z%1$s", new Object[]{max != -1 ? max != 0 ? String.valueOf(max) : "header" : ViewProps.BOTTOM}), "drawable", getContext().getPackageName()));
    }
}
