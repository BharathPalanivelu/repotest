package com.airbnb.android.react.maps;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class r extends ReactViewGroup {
    public boolean hasOverlappingRendering() {
        return false;
    }

    public r(Context context) {
        super(context);
        setWillNotDraw(true);
        setVisibility(0);
        setAlpha(BitmapDescriptorFactory.HUE_RED);
        setRemoveClippedSubviews(false);
        if (Build.VERSION.SDK_INT >= 18) {
            setClipBounds(new Rect(0, 0, 0, 0));
        }
        setOverflow(ViewProps.HIDDEN);
    }
}
