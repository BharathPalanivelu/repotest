package iyegoroff.RNTextGradient;

import android.text.SpannableStringBuilder;

public class RNSetGradientSpanOperation {
    private int end;
    private int start;
    private Object what;

    public RNSetGradientSpanOperation(int i, int i2, Object obj) {
        this.start = i;
        this.end = i2;
        this.what = obj;
    }

    /* access modifiers changed from: package-private */
    public void execute(SpannableStringBuilder spannableStringBuilder) {
        int i = this.start == 0 ? 18 : 34;
        if (this.end <= spannableStringBuilder.length()) {
            spannableStringBuilder.setSpan(this.what, this.start, this.end, i);
        }
    }
}
