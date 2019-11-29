package com.afollestad.materialdialogs.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import androidx.appcompat.widget.k;
import com.afollestad.materialdialogs.a.a;
import com.afollestad.materialdialogs.g;

public class b {
    public static void a(RadioButton radioButton, int i) {
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{16842912}}, new int[]{a.b(radioButton.getContext(), g.a.colorControlNormal), i});
        if (Build.VERSION.SDK_INT >= 21) {
            radioButton.setButtonTintList(colorStateList);
            return;
        }
        Drawable g2 = androidx.core.graphics.drawable.a.g(androidx.core.content.b.a(radioButton.getContext(), g.e.abc_btn_radio_material));
        androidx.core.graphics.drawable.a.a(g2, colorStateList);
        radioButton.setButtonDrawable(g2);
    }

    public static void a(ProgressBar progressBar, int i) {
        a(progressBar, i, false);
    }

    public static void a(ProgressBar progressBar, int i, boolean z) {
        ColorStateList valueOf = ColorStateList.valueOf(i);
        if (Build.VERSION.SDK_INT >= 21) {
            progressBar.setProgressTintList(valueOf);
            progressBar.setSecondaryProgressTintList(valueOf);
            if (!z) {
                progressBar.setIndeterminateTintList(valueOf);
                return;
            }
            return;
        }
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        if (Build.VERSION.SDK_INT <= 10) {
            mode = PorterDuff.Mode.MULTIPLY;
        }
        if (!z && progressBar.getIndeterminateDrawable() != null) {
            progressBar.getIndeterminateDrawable().setColorFilter(i, mode);
        }
        if (progressBar.getProgressDrawable() != null) {
            progressBar.getProgressDrawable().setColorFilter(i, mode);
        }
    }

    private static ColorStateList a(Context context, int i) {
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{-16842919, -16842908}, new int[0]}, new int[]{a.b(context, g.a.colorControlNormal), a.b(context, g.a.colorControlNormal), i});
    }

    public static void a(EditText editText, int i) {
        ColorStateList a2 = a(editText.getContext(), i);
        if (editText instanceof k) {
            ((k) editText).setSupportBackgroundTintList(a2);
        } else if (Build.VERSION.SDK_INT >= 21) {
            editText.setBackgroundTintList(a2);
        }
    }

    public static void a(CheckBox checkBox, int i) {
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{16842912}}, new int[]{a.b(checkBox.getContext(), g.a.colorControlNormal), i});
        if (Build.VERSION.SDK_INT >= 21) {
            checkBox.setButtonTintList(colorStateList);
            return;
        }
        Drawable g2 = androidx.core.graphics.drawable.a.g(androidx.core.content.b.a(checkBox.getContext(), g.e.abc_btn_check_material));
        androidx.core.graphics.drawable.a.a(g2, colorStateList);
        checkBox.setButtonDrawable(g2);
    }
}
