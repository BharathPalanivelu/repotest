package com.salesforce.android.service.common.ui.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.content.b;
import com.salesforce.android.service.common.ui.R;
import com.salesforce.android.service.common.ui.internal.utils.ShapeFactory;

public class SalesforceProgressSpinner extends View implements ValueAnimator.AnimatorUpdateListener {
    private static final long MILLISECONDS_PER_SECOND = 1000;
    private static final float ROTATION_0 = 0.0f;
    private static final float ROTATION_360 = 360.0f;
    private final ProgressSpinner mProgressSpinner;

    public SalesforceProgressSpinner(Context context) {
        this(context, (AttributeSet) null);
    }

    public SalesforceProgressSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.salesforceProgressSpinnerStyle);
    }

    /* JADX INFO: finally extract failed */
    public SalesforceProgressSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SalesforceProgressSpinner, i, 0);
        ProgressSpinnerProperties progressSpinnerProperties = new ProgressSpinnerProperties();
        try {
            progressSpinnerProperties.mHighlightColor = loadColor(obtainStyledAttributes, R.styleable.SalesforceProgressSpinner_salesforce_highlight_color, R.color.salesforce_brand_secondary);
            progressSpinnerProperties.mShadowColor = loadColor(obtainStyledAttributes, R.styleable.SalesforceProgressSpinner_salesforce_shadow_color, R.color.salesforce_contrast_tertiary);
            progressSpinnerProperties.mHighlightArcDegrees = loadInt(loadString(obtainStyledAttributes, R.styleable.SalesforceProgressSpinner_salesforce_highlight_arc_degrees));
            progressSpinnerProperties.mThicknessInPixels = loadDimensionInPixels(obtainStyledAttributes, R.styleable.SalesforceProgressSpinner_salesforce_thickness);
            progressSpinnerProperties.mRotationsPerSecond = loadFloat(obtainStyledAttributes, R.styleable.SalesforceProgressSpinner_salesforce_rotations_per_second);
            obtainStyledAttributes.recycle();
            this.mProgressSpinner = new ProgressSpinner(progressSpinnerProperties);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private int loadColor(TypedArray typedArray, int i, int i2) {
        return typedArray.getColor(i, b.c(getContext(), i2));
    }

    private String loadString(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    private int loadInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    private float loadFloat(TypedArray typedArray, int i) {
        return typedArray.getFloat(i, 0.0f);
    }

    private int loadDimensionInPixels(TypedArray typedArray, int i) {
        return typedArray.getDimensionPixelSize(i, 0);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mProgressSpinner.setDimensionsInPixels(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() == 0) {
            this.mProgressSpinner.addAnimatorUpdateListener(this);
            this.mProgressSpinner.start();
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.mProgressSpinner.stop();
            this.mProgressSpinner.start();
            return;
        }
        this.mProgressSpinner.stop();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mProgressSpinner.stop();
        this.mProgressSpinner.removeAnimatorUpdateListener(this);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.mProgressSpinner.onDraw(canvas);
    }

    static class ProgressSpinnerProperties {
        int mHighlightArcDegrees;
        int mHighlightColor;
        float mRotationsPerSecond;
        int mShadowColor;
        int mThicknessInPixels;

        ProgressSpinnerProperties() {
        }
    }

    static class ProgressSpinner {
        final GradientDrawable mHighlight;
        private final ProgressSpinnerProperties mProperties;
        private final ValueAnimator mRotationAnimator = createRotationAnimator(this.mProperties.mRotationsPerSecond);
        final GradientDrawable mShadow = createOval();

        ProgressSpinner(ProgressSpinnerProperties progressSpinnerProperties) {
            this.mProperties = progressSpinnerProperties;
            this.mShadow.setStroke(this.mProperties.mThicknessInPixels, this.mProperties.mShadowColor);
            this.mHighlight = createOval();
        }

        /* access modifiers changed from: package-private */
        public void onDraw(Canvas canvas) {
            this.mShadow.draw(canvas);
            this.mHighlight.draw(canvas);
        }

        /* access modifiers changed from: package-private */
        public void setDimensionsInPixels(int i, int i2) {
            int min = Math.min(i, i2);
            int i3 = (i - min) / 2;
            int i4 = (i2 - min) / 2;
            int i5 = i - i3;
            int i6 = i2 - i4;
            this.mShadow.setBounds(i3, i4, i5, i6);
            this.mHighlight.setBounds(i3, i4, i5, i6);
            setHighlightStroke(((float) min) * 3.1415927f);
        }

        /* access modifiers changed from: package-private */
        public void setHighlightStroke(float f2) {
            float f3 = (((float) this.mProperties.mHighlightArcDegrees) / SalesforceProgressSpinner.ROTATION_360) * f2;
            this.mHighlight.setStroke(this.mProperties.mThicknessInPixels, this.mProperties.mHighlightColor, f3, f2 - f3);
        }

        /* access modifiers changed from: package-private */
        public void start() {
            this.mRotationAnimator.start();
        }

        /* access modifiers changed from: package-private */
        public void stop() {
            this.mRotationAnimator.cancel();
        }

        /* access modifiers changed from: package-private */
        public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            this.mRotationAnimator.addUpdateListener(animatorUpdateListener);
        }

        /* access modifiers changed from: package-private */
        public void removeAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            this.mRotationAnimator.removeUpdateListener(animatorUpdateListener);
        }

        /* access modifiers changed from: package-private */
        public GradientDrawable createOval() {
            GradientDrawable createGradientDrawable = ShapeFactory.createGradientDrawable();
            createGradientDrawable.setColor(0);
            createGradientDrawable.setShape(1);
            return createGradientDrawable;
        }

        /* access modifiers changed from: package-private */
        public ValueAnimator createRotationAnimator(float f2) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, SalesforceProgressSpinner.ROTATION_360});
            ofFloat.setRepeatCount(-1);
            ofFloat.setDuration((long) (1000.0f / f2));
            ofFloat.setInterpolator(new LinearInterpolator());
            return ofFloat;
        }
    }
}
