package iyegoroff.RNTextGradient.Linear;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.annotations.ReactProp;
import iyegoroff.RNTextGradient.RNSetGradientSpanOperation;
import iyegoroff.RNTextGradient.RNShadowTextGradient;

public class RNShadowLinearTextGradient extends RNShadowTextGradient {
    private float[] mEnd;
    private float[] mStart;

    RNShadowLinearTextGradient(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactProp(name = "gradientStart")
    public void setStart(ReadableArray readableArray) {
        if (readableArray != null) {
            this.mStart = new float[]{(float) readableArray.getDouble(0), (float) readableArray.getDouble(1)};
            markUpdated();
        }
    }

    @ReactProp(name = "gradientEnd")
    public void setEnd(ReadableArray readableArray) {
        if (readableArray != null) {
            this.mEnd = new float[]{(float) readableArray.getDouble(0), (float) readableArray.getDouble(1)};
            markUpdated();
        }
    }

    /* access modifiers changed from: protected */
    public RNSetGradientSpanOperation createSpan(SpannableStringBuilder spannableStringBuilder, int i, int i2, float f2, float f3, Layout layout) {
        return new RNSetGradientSpanOperation(i, i2, new RNLinearTextGradientSpan(this.mLocations, this.mColors, this.mStart, this.mEnd, this.mUseViewFrame, layout, i, i2, f2, f3, spannableStringBuilder.toString()));
    }
}
