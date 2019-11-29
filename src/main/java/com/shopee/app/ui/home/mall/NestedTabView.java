package com.shopee.app.ui.home.mall;

import android.content.Context;
import android.util.AttributeSet;
import com.garena.android.uikit.a.c;

public class NestedTabView extends c {
    public NestedTabView(Context context) {
        super(context);
    }

    public NestedTabView(Context context, boolean z) {
        super(context, z);
    }

    public NestedTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NestedTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public Object a(int i) {
        return String.valueOf(getId()) + i;
    }
}
