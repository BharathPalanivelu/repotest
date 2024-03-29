package com.facebook.react.uimanager;

import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.uimanager.common.ViewUtil;

public class UIManagerHelper {
    public static UIManager getUIManagerForReactTag(ReactContext reactContext, int i) {
        return getUIManager(reactContext, ViewUtil.getUIManagerType(i));
    }

    public static UIManager getUIManager(ReactContext reactContext, int i) {
        CatalystInstance catalystInstance = reactContext.getCatalystInstance();
        if (i == 2) {
            return (UIManager) catalystInstance.getJSIModule(UIManager.class);
        }
        return (UIManager) catalystInstance.getNativeModule(UIManagerModule.class);
    }
}
