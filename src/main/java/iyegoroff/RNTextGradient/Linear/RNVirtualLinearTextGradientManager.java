package iyegoroff.RNTextGradient.Linear;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import iyegoroff.RNTextGradient.RNVirtualTextGradientManager;

@ReactModule(name = "RNVirtualLinearTextGradient")
public class RNVirtualLinearTextGradientManager extends RNVirtualTextGradientManager<RNVirtualShadowLinearTextGradient> {
    @VisibleForTesting
    static final String REACT_CLASS = "RNVirtualLinearTextGradient";

    public String getName() {
        return REACT_CLASS;
    }

    public RNVirtualShadowLinearTextGradient createShadowNodeInstance(ReactApplicationContext reactApplicationContext) {
        return new RNVirtualShadowLinearTextGradient(reactApplicationContext);
    }

    public Class<? extends RNVirtualShadowLinearTextGradient> getShadowNodeClass() {
        return RNVirtualShadowLinearTextGradient.class;
    }
}
