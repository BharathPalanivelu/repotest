package com.bca.xco.widget.comp;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class XTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private Context f4711a;

    public XTextView(Context context) {
        super(context);
        this.f4711a = context;
        a(context, 0);
    }

    public XTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4711a = context;
        a(context, 0);
    }

    public XTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4711a = context;
        a(context, 0);
    }

    public void a(Context context, int i) {
        if (i == 1) {
            setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Bold.ttf"));
        } else {
            setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Regular.ttf"));
        }
    }
}
