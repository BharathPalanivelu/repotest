package com.airpay.paysdk.base.ui.weidget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.airpay.paysdk.base.d.k;
import com.airpay.paysdk.c;

public class BPCustomFontTextView extends AppCompatTextView {
    public BPCustomFontTextView(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public BPCustomFontTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public BPCustomFontTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        boolean z = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.k.BPCustomFontTextView);
            if (obtainStyledAttributes.hasValue(c.k.BPCustomFontTextView_font_path)) {
                z = a(obtainStyledAttributes.getString(c.k.BPCustomFontTextView_font_path));
            }
            obtainStyledAttributes.recycle();
        }
        if (!isInEditMode() && !z) {
            setTypeface(k.a(context, 3));
        }
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Typeface createFromAsset = Typeface.createFromAsset(getContext().getAssets(), str);
            if (createFromAsset != null) {
                setTypeface(createFromAsset);
                return true;
            }
        } catch (RuntimeException unused) {
        }
        return false;
    }
}
