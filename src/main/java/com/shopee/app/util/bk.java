package com.shopee.app.util;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

public abstract class bk extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f26261a;

    public bk() {
        this.f26261a = null;
    }

    public bk(int i) {
        this.f26261a = Integer.valueOf(i);
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        Integer num = this.f26261a;
        if (num != null) {
            textPaint.setColor(num.intValue());
        }
        textPaint.setUnderlineText(false);
    }
}
