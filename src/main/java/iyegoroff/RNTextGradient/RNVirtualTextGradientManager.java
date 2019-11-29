package iyegoroff.RNTextGradient;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import iyegoroff.RNTextGradient.RNShadowTextGradient;

public abstract class RNVirtualTextGradientManager<T extends RNShadowTextGradient> extends BaseViewManager<View, T> {
    public void updateExtraData(View view, Object obj) {
    }

    public RNTextGradient createViewInstance(ThemedReactContext themedReactContext) {
        throw new IllegalStateException("RNVirtualTextGradientManager doesn't have a native view");
    }
}
