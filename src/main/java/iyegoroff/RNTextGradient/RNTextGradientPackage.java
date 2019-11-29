package iyegoroff.RNTextGradient;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import iyegoroff.RNTextGradient.Linear.RNLinearTextGradientManager;
import iyegoroff.RNTextGradient.Linear.RNVirtualLinearTextGradientManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RNTextGradientPackage implements ReactPackage {
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new ViewManager[]{new RNLinearTextGradientManager(), new RNVirtualLinearTextGradientManager()});
    }
}
