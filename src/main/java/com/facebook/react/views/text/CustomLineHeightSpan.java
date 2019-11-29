package com.facebook.react.views.text;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;

public class CustomLineHeightSpan implements LineHeightSpan, ReactSpan {
    private final int mHeight;

    CustomLineHeightSpan(float f2) {
        this.mHeight = (int) Math.ceil((double) f2);
    }

    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        int i5 = fontMetricsInt.descent;
        int i6 = this.mHeight;
        if (i5 > i6) {
            int min = Math.min(i6, fontMetricsInt.descent);
            fontMetricsInt.descent = min;
            fontMetricsInt.bottom = min;
            fontMetricsInt.ascent = 0;
            fontMetricsInt.top = 0;
        } else if ((-fontMetricsInt.ascent) + fontMetricsInt.descent > this.mHeight) {
            fontMetricsInt.bottom = fontMetricsInt.descent;
            int i7 = (-this.mHeight) + fontMetricsInt.descent;
            fontMetricsInt.ascent = i7;
            fontMetricsInt.top = i7;
        } else if ((-fontMetricsInt.ascent) + fontMetricsInt.bottom > this.mHeight) {
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = fontMetricsInt.ascent + this.mHeight;
        } else {
            int i8 = (-fontMetricsInt.top) + fontMetricsInt.bottom;
            int i9 = this.mHeight;
            if (i8 > i9) {
                fontMetricsInt.top = fontMetricsInt.bottom - this.mHeight;
                return;
            }
            int i10 = i9 - ((-fontMetricsInt.top) + fontMetricsInt.bottom);
            double d2 = (double) fontMetricsInt.top;
            double d3 = (double) (((float) i10) / 2.0f);
            double ceil = Math.ceil(d3);
            Double.isNaN(d2);
            fontMetricsInt.top = (int) (d2 - ceil);
            double d4 = (double) fontMetricsInt.bottom;
            double floor = Math.floor(d3);
            Double.isNaN(d4);
            fontMetricsInt.bottom = (int) (d4 + floor);
            fontMetricsInt.ascent = fontMetricsInt.top;
            fontMetricsInt.descent = fontMetricsInt.bottom;
        }
    }
}
