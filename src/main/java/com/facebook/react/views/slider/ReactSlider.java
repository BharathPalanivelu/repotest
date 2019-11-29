package com.facebook.react.views.slider;

import android.animation.StateListAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;

public class ReactSlider extends AppCompatSeekBar {
    private static int DEFAULT_TOTAL_STEPS = 128;
    private double mMaxValue = 0.0d;
    private double mMinValue = 0.0d;
    private double mStep = 0.0d;
    private double mStepCalculated = 0.0d;
    private double mValue = 0.0d;

    public ReactSlider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        disableStateListAnimatorIfNeeded();
    }

    private void disableStateListAnimatorIfNeeded() {
        if (Build.VERSION.SDK_INT >= 23 && Build.VERSION.SDK_INT < 26) {
            super.setStateListAnimator((StateListAnimator) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void setMaxValue(double d2) {
        this.mMaxValue = d2;
        updateAll();
    }

    /* access modifiers changed from: package-private */
    public void setMinValue(double d2) {
        this.mMinValue = d2;
        updateAll();
    }

    /* access modifiers changed from: package-private */
    public void setValue(double d2) {
        this.mValue = d2;
        updateValue();
    }

    /* access modifiers changed from: package-private */
    public void setStep(double d2) {
        this.mStep = d2;
        updateAll();
    }

    public double toRealProgress(int i) {
        if (i == getMax()) {
            return this.mMaxValue;
        }
        double d2 = (double) i;
        double stepValue = getStepValue();
        Double.isNaN(d2);
        return (d2 * stepValue) + this.mMinValue;
    }

    private void updateAll() {
        if (this.mStep == 0.0d) {
            double d2 = this.mMaxValue - this.mMinValue;
            double d3 = (double) DEFAULT_TOTAL_STEPS;
            Double.isNaN(d3);
            this.mStepCalculated = d2 / d3;
        }
        setMax(getTotalSteps());
        updateValue();
    }

    private void updateValue() {
        double d2 = this.mValue;
        double d3 = this.mMinValue;
        double totalSteps = (double) getTotalSteps();
        Double.isNaN(totalSteps);
        setProgress((int) Math.round(((d2 - d3) / (this.mMaxValue - d3)) * totalSteps));
    }

    private int getTotalSteps() {
        return (int) Math.ceil((this.mMaxValue - this.mMinValue) / getStepValue());
    }

    private double getStepValue() {
        double d2 = this.mStep;
        return d2 > 0.0d ? d2 : this.mStepCalculated;
    }
}
