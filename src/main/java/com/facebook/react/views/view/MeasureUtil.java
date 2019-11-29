package com.facebook.react.views.view;

import android.view.View;
import com.facebook.yoga.YogaMeasureMode;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;

public class MeasureUtil {
    public static int getMeasureSpec(float f2, YogaMeasureMode yogaMeasureMode) {
        if (yogaMeasureMode == YogaMeasureMode.EXACTLY) {
            return View.MeasureSpec.makeMeasureSpec((int) f2, 1073741824);
        }
        if (yogaMeasureMode == YogaMeasureMode.AT_MOST) {
            return View.MeasureSpec.makeMeasureSpec((int) f2, RNCartPanelDataEntity.NULL_VALUE);
        }
        return View.MeasureSpec.makeMeasureSpec(0, 0);
    }
}
