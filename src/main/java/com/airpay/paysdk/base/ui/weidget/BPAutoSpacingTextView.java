package com.airpay.paysdk.base.ui.weidget;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import com.airpay.paysdk.base.d.l;

public class BPAutoSpacingTextView extends BPCustomFontTextView {

    /* renamed from: a  reason: collision with root package name */
    private int f3862a = 0;

    /* renamed from: b  reason: collision with root package name */
    private CharSequence f3863b;

    /* renamed from: c  reason: collision with root package name */
    private TextView.BufferType f3864c;

    public BPAutoSpacingTextView(Context context) {
        super(context);
    }

    public BPAutoSpacingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BPAutoSpacingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.f3863b = charSequence;
        this.f3864c = bufferType;
        if (getLayoutParams() == null || getLayoutParams().width != -2) {
            a();
        } else {
            super.setText(charSequence, bufferType);
        }
    }

    public CharSequence getText() {
        return this.f3863b;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.f3862a = (getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight();
            a();
        }
    }

    private float a(CharSequence charSequence) {
        TextPaint paint = getPaint();
        TransformationMethod transformationMethod = getTransformationMethod();
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, this);
        }
        return paint.measureText(charSequence, 0, charSequence.length());
    }

    private void a() {
        CharSequence charSequence = this.f3863b;
        if (charSequence != null) {
            float a2 = ((float) this.f3862a) - a(charSequence);
            if (a2 <= ((float) l.a(getContext(), 4.0f)) || this.f3863b.length() <= 1) {
                super.setText(this.f3863b, this.f3864c);
                return;
            }
            int length = (int) (a2 / ((float) (this.f3863b.length() - 1)));
            CharSequence a3 = a(this.f3863b, length);
            float a4 = a(a3);
            int i = this.f3862a;
            if (a4 > ((float) i)) {
                a3 = a(this.f3863b, length - ((int) Math.ceil((double) ((a4 - ((float) i)) / ((float) (this.f3863b.length() - 1))))));
            }
            super.setText(a3, TextView.BufferType.SPANNABLE);
        }
    }

    private CharSequence a(CharSequence charSequence, int i) {
        String a2 = a(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i2 = 0;
        while (i2 < charSequence.length()) {
            spannableStringBuilder.append(charSequence.charAt(i2));
            i2++;
            if (i2 < charSequence.length()) {
                spannableStringBuilder.append(a2);
            }
        }
        return spannableStringBuilder;
    }

    private String a(int i) {
        int min = Math.min((int) (((float) i) / a((CharSequence) " ")), 100);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < min; i2++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
