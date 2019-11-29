package com.shopee.app.ui.common;

import android.content.Context;
import android.util.AttributeSet;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.uikit.a.c;
import com.shopee.app.util.x;

public class MaterialTabView extends c {

    /* renamed from: c  reason: collision with root package name */
    i f20986c;

    public interface a {
        void a(MaterialTabView materialTabView);
    }

    public MaterialTabView(Context context) {
        super(context);
        a(context);
    }

    public MaterialTabView(Context context, boolean z) {
        super(context, z);
        a(context);
    }

    public MaterialTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public MaterialTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        ((a) ((x) context).b()).a(this);
        this.f20986c.setShadowTopOffset(b.a.h * 4);
    }

    public void setShadowOffset(int i) {
        this.f20986c.setShadowTopOffset(i);
    }
}
