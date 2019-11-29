package com.facebook.react.uimanager;

import com.facebook.yoga.YogaConfig;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class ReactYogaConfigProvider {
    private static YogaConfig YOGA_CONFIG;

    public static YogaConfig get() {
        if (YOGA_CONFIG == null) {
            YOGA_CONFIG = new YogaConfig();
            YOGA_CONFIG.setPointScaleFactor(BitmapDescriptorFactory.HUE_RED);
            YOGA_CONFIG.setUseLegacyStretchBehaviour(true);
        }
        return YOGA_CONFIG;
    }
}
