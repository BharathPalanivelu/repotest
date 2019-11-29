package com.garena.android.uikit.fluid.tagcloud;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class GTagCloud extends com.garena.android.uikit.fluid.a {

    /* renamed from: a  reason: collision with root package name */
    private a f7730a;

    public interface a {
        int a();

        View a(Context context, int i);
    }

    public GTagCloud(Context context) {
        super(context);
    }

    public GTagCloud(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GTagCloud(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setAdapter(a aVar) {
        this.f7730a = aVar;
    }

    public void a() {
        if (this.f7730a != null) {
            removeAllViews();
            int a2 = this.f7730a.a();
            for (int i = 0; i < a2; i++) {
                addView(this.f7730a.a(getContext(), i));
            }
        }
    }
}
