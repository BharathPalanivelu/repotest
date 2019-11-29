package com.salesforce.android.service.common.ui.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
import androidx.core.content.b;
import com.salesforce.android.service.common.ui.R;
import com.salesforce.android.service.common.utilities.spatial.Coordinate;

public class SalesforceFloatingActionButton extends Button {
    private final int mBackgroundSelected;
    private final int mBackgroundUnselected;
    private final Drawable mIcon;
    private final int mIconColorSelected;
    private final int mIconColorUnselected;
    private final SalesforceFloatingActionButtonImpl mImpl;

    public SalesforceFloatingActionButton(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX INFO: finally extract failed */
    public SalesforceFloatingActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SalesforceFloatingActionButton, 0, 0);
        try {
            this.mBackgroundUnselected = loadColor(obtainStyledAttributes, R.styleable.SalesforceFloatingActionButton_salesforce_background_unselected, R.color.salesforce_contrast_primary);
            this.mBackgroundSelected = loadColor(obtainStyledAttributes, R.styleable.SalesforceFloatingActionButton_salesforce_background_selected, R.color.salesforce_feedback_primary);
            this.mIconColorUnselected = loadColor(obtainStyledAttributes, R.styleable.SalesforceFloatingActionButton_salesforce_src_color_unselected, R.color.salesforce_contrast_inverted);
            this.mIconColorSelected = loadColor(obtainStyledAttributes, R.styleable.SalesforceFloatingActionButton_salesforce_src_color_selected, R.color.salesforce_brand_primary_inverted);
            this.mIcon = obtainStyledAttributes.getDrawable(R.styleable.SalesforceFloatingActionButton_salesforce_src);
            obtainStyledAttributes.recycle();
            this.mImpl = SalesforceFloatingActionButtonImpl.builder(this).setButtonColor(this.mBackgroundUnselected).setRippleColor(this.mBackgroundSelected).setIcon(this.mIcon).setIconColor(this.mIconColorUnselected).setRippleIconColor(this.mIconColorSelected).build();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private int loadColor(TypedArray typedArray, int i, int i2) {
        return typedArray.getColor(i, b.c(getContext(), i2));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mImpl.setButtonSize(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            Coordinate create = Coordinate.create((int) motionEvent.getX(), (int) motionEvent.getY());
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(new Animator[]{this.mImpl.rippleOnPress(create), this.mImpl.rippleOnRelease(create)});
            animatorSet.start();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.mImpl.draw(canvas);
    }
}
