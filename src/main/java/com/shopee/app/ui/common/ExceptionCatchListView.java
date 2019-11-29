package com.shopee.app.ui.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ListView;
import com.garena.android.appkit.d.a;

public class ExceptionCatchListView extends ListView {
    public ExceptionCatchListView(Context context) {
        super(context);
    }

    public ExceptionCatchListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ExceptionCatchListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public ExceptionCatchListView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: protected */
    public void layoutChildren() {
        try {
            super.layoutChildren();
        } catch (IllegalStateException | IndexOutOfBoundsException unused) {
            a.a("there will be a problem at LoadMoreHelper.java", new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (IllegalStateException unused) {
            a.a("there will be a problem at LoadMoreHelper.java", new Object[0]);
        }
    }
}
