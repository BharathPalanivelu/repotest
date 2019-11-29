package iyegoroff.RNTextGradient.Linear;

import com.facebook.react.bridge.ReactApplicationContext;

public class RNVirtualShadowLinearTextGradient extends RNShadowLinearTextGradient {
    public boolean isVirtual() {
        return true;
    }

    RNVirtualShadowLinearTextGradient(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }
}
