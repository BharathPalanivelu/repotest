package com.shopee.app.ui.home.me.v3;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.shopee.id.R;
import d.d.b.j;

public final class MeBuyerOptionsLayout extends LinearLayout {
    public MeBuyerOptionsLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public MeBuyerOptionsLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MeBuyerOptionsLayout(Context context, AttributeSet attributeSet, int i, int i2, g gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MeBuyerOptionsLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.b(context, "context");
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view != null && view.getId() == R.id.my_voucher_button) {
            View findViewById = findViewById(R.id.my_kredit_button);
            if (findViewById != null) {
                super.addView(view, indexOfChild(findViewById) + 1, layoutParams);
                return;
            }
        }
        super.addView(view, i, layoutParams);
    }
}
