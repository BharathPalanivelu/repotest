package com.shopee.app.ui.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.garena.android.appkit.d.a;
import com.shopee.id.R;

public class LockingScrollView extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f20985a;

    public LockingScrollView(Context context) {
        super(context);
    }

    public LockingScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LockingScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public LockingScrollView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
    }

    /* access modifiers changed from: protected */
    public int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        a.b(rect.toString(), new Object[0]);
        View currentFocus = ((Activity) getContext()).getCurrentFocus();
        if (currentFocus == null || currentFocus.getId() != R.id.hash_tag_view) {
            return super.computeScrollDeltaToGetChildRectOnScreen(rect);
        }
        if (((TagEditText2) currentFocus).getMode() == 0) {
            return 0;
        }
        this.f20985a = false;
        return 0;
    }
}
