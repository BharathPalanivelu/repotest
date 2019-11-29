package com.salesforce.android.service.common.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import androidx.core.content.b;
import com.salesforce.android.service.common.ui.R;
import com.salesforce.android.service.common.utilities.spatial.Coordinate;
import java.util.ArrayList;
import java.util.List;

public class SalesforceFloatingActionToggleButton extends ToggleButton implements CompoundButton.OnCheckedChangeListener {
    private final int mBackgroundChecked;
    private final int mBackgroundUnchecked;
    List<CompoundButton.OnCheckedChangeListener> mExtraListeners;
    private Coordinate mHotspot;
    private final Drawable mIconChecked;
    private final int mIconColorChecked;
    private final int mIconColorUnchecked;
    private final Drawable mIconUnchecked;
    private final SalesforceFloatingActionButtonImpl mImpl;

    public SalesforceFloatingActionToggleButton(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX INFO: finally extract failed */
    public SalesforceFloatingActionToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHotspot = Coordinate.create(0, 0);
        setOnCheckedChangeListener(this);
        this.mExtraListeners = new ArrayList();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SalesforceFloatingActionToggleButton, 0, 0);
        try {
            this.mBackgroundUnchecked = loadColor(obtainStyledAttributes, R.styleable.SalesforceFloatingActionToggleButton_salesforce_background_unchecked, R.color.salesforce_contrast_primary);
            this.mBackgroundChecked = loadColor(obtainStyledAttributes, R.styleable.SalesforceFloatingActionToggleButton_salesforce_background_checked, R.color.salesforce_feedback_secondary);
            this.mIconColorUnchecked = loadColor(obtainStyledAttributes, R.styleable.SalesforceFloatingActionToggleButton_salesforce_src_color_unchecked, R.color.salesforce_contrast_inverted);
            this.mIconColorChecked = loadColor(obtainStyledAttributes, R.styleable.SalesforceFloatingActionToggleButton_salesforce_src_color_checked, R.color.salesforce_brand_primary_inverted);
            this.mIconUnchecked = obtainStyledAttributes.getDrawable(R.styleable.SalesforceFloatingActionToggleButton_salesforce_src_unchecked);
            this.mIconChecked = obtainStyledAttributes.getDrawable(R.styleable.SalesforceFloatingActionToggleButton_salesforce_src_checked);
            obtainStyledAttributes.recycle();
            this.mImpl = SalesforceFloatingActionButtonImpl.builder(this).setButtonColor(this.mBackgroundUnchecked).setRippleColor(this.mBackgroundChecked).setIcon(this.mIconUnchecked).setIconColor(this.mIconColorUnchecked).setRippleIcon(this.mIconChecked).setRippleIconColor(this.mIconColorChecked).build();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private int loadColor(TypedArray typedArray, int i, int i2) {
        return typedArray.getColor(i, b.c(getContext(), i2));
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.mImpl.rippleOnPress(this.mHotspot).start();
        } else {
            this.mImpl.rippleOnRelease(this.mHotspot).start();
        }
        for (CompoundButton.OnCheckedChangeListener onCheckedChanged : this.mExtraListeners) {
            onCheckedChanged.onCheckedChanged(compoundButton, z);
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (onCheckedChangeListener instanceof SalesforceFloatingActionToggleButton) {
            super.setOnCheckedChangeListener(onCheckedChangeListener);
        } else {
            this.mExtraListeners.add(onCheckedChangeListener);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mImpl.setButtonSize(i, i2);
        invalidate();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mHotspot = Coordinate.create((int) motionEvent.getX(), (int) motionEvent.getY());
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.mImpl.draw(canvas);
    }
}
