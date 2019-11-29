package iyegoroff.RNTextGradient;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.text.ReactTextAnchorViewManager;
import com.facebook.react.views.text.ReactTextView;
import com.facebook.react.views.text.ReactTextViewManager;

public abstract class RNTextGradientManager extends ReactTextAnchorViewManager<RNTextGradient, RNShadowTextGradient> {
    private ReactTextViewManager mManager = new ReactTextViewManager();

    public RNTextGradient createViewInstance(ThemedReactContext themedReactContext) {
        return new RNTextGradient(themedReactContext);
    }

    public void updateExtraData(RNTextGradient rNTextGradient, Object obj) {
        this.mManager.updateExtraData((ReactTextView) rNTextGradient, obj);
    }
}
