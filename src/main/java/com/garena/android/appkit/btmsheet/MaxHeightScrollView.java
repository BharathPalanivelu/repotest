package com.garena.android.appkit.btmsheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;

public class MaxHeightScrollView extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    private int f7639a = 480;

    public MaxHeightScrollView(Context context) {
        super(context);
        a(context);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        setVerticalScrollBarEnabled(false);
    }

    public void setMaxHeight(int i) {
        this.f7639a = i;
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.f7639a, RNCartPanelDataEntity.NULL_VALUE));
    }
}
