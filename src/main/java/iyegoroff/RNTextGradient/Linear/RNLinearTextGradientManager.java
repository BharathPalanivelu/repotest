package iyegoroff.RNTextGradient.Linear;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import iyegoroff.RNTextGradient.RNShadowTextGradient;
import iyegoroff.RNTextGradient.RNTextGradientManager;

@ReactModule(name = "RNLinearTextGradient")
public class RNLinearTextGradientManager extends RNTextGradientManager {
    @VisibleForTesting
    static final String REACT_CLASS = "RNLinearTextGradient";

    public String getName() {
        return REACT_CLASS;
    }

    public RNShadowTextGradient createShadowNodeInstance(ReactApplicationContext reactApplicationContext) {
        return new RNShadowLinearTextGradient(reactApplicationContext);
    }

    public Class<? extends RNShadowTextGradient> getShadowNodeClass() {
        return RNShadowLinearTextGradient.class;
    }
}
