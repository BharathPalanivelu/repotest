package iyegoroff.RNTextGradient.Linear;

import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import com.facebook.yoga.YogaConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class RNLinearTextGradientSpan extends CharacterStyle implements UpdateAppearance {
    private LinearGradient mGradient;

    RNLinearTextGradientSpan(float[] fArr, int[] iArr, float[] fArr2, float[] fArr3, boolean z, Layout layout, int i, int i2, float f2, float f3, String str) {
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        Layout layout2 = layout;
        int i3 = i;
        int i4 = i2;
        if (!(fArr2 == null || fArr3 == null || iArr == null || fArr == null || str == null || YogaConstants.isUndefined(f2))) {
            float f9 = BitmapDescriptorFactory.HUE_RED;
            if (!(f2 == BitmapDescriptorFactory.HUE_RED || f3 == BitmapDescriptorFactory.HUE_RED || layout2 == null)) {
                Path path = new Path();
                RectF rectF = new RectF();
                layout2.getSelectionPath(i3, i4, path);
                path.computeBounds(rectF, true);
                int i5 = i4 - 1;
                if (layout2.getLineForOffset(i5) != layout2.getLineForOffset(i4)) {
                    RectF rectF2 = new RectF();
                    layout2.getSelectionPath(i5, i4, path);
                    path.computeBounds(rectF2, true);
                    if (rectF2.contains(rectF) && rectF.contains(rectF2)) {
                        layout2.getSelectionPath(i3, i5, path);
                        path.computeBounds(rectF, true);
                    }
                }
                if (z) {
                    f4 = f2;
                } else {
                    f4 = rectF.width();
                }
                if (z) {
                    f5 = f3;
                } else {
                    f5 = rectF.height();
                }
                if (z) {
                    f6 = BitmapDescriptorFactory.HUE_RED;
                } else {
                    f6 = rectF.left;
                }
                float f10 = f6 + (fArr2[0] * f4);
                if (z) {
                    f7 = BitmapDescriptorFactory.HUE_RED;
                } else {
                    f7 = rectF.top;
                }
                float f11 = f7 + (fArr2[1] * f5);
                if (z) {
                    f8 = BitmapDescriptorFactory.HUE_RED;
                } else {
                    f8 = rectF.left;
                }
                this.mGradient = new LinearGradient(f10, f11, f8 + (fArr3[0] * f4), (!z ? rectF.top : f9) + (fArr3[1] * f5), iArr, fArr, Shader.TileMode.CLAMP);
                return;
            }
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        if (this.mGradient != null) {
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setShader(this.mGradient);
        }
    }
}
