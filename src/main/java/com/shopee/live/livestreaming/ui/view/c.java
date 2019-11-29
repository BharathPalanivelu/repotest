package com.shopee.live.livestreaming.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;

public class c extends RecyclerView {
    private int M;

    public c(Context context) {
        super(context);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.i.MaxHeightRecyclerView);
        this.M = obtainStyledAttributes.getLayoutDimension(c.i.MaxHeightRecyclerView_maxHeight, this.M);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = this.M;
        if (i3 > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, RNCartPanelDataEntity.NULL_VALUE);
        }
        super.onMeasure(i, i2);
    }

    public void setmMaxHeight(int i) {
        this.M = i;
        requestLayout();
    }
}
