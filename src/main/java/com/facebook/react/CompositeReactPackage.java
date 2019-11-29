package com.facebook.react;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;

public class CompositeReactPackage implements ReactPackage, ViewManagerOnDemandReactPackage {
    private final List<ReactPackage> mChildReactPackages = new ArrayList();

    public CompositeReactPackage(ReactPackage reactPackage, ReactPackage reactPackage2, ReactPackage... reactPackageArr) {
        this.mChildReactPackages.add(reactPackage);
        this.mChildReactPackages.add(reactPackage2);
        Collections.addAll(this.mChildReactPackages, reactPackageArr);
    }

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        HashMap hashMap = new HashMap();
        for (ReactPackage createNativeModules : this.mChildReactPackages) {
            for (NativeModule next : createNativeModules.createNativeModules(reactApplicationContext)) {
                hashMap.put(next.getName(), next);
            }
        }
        return new ArrayList(hashMap.values());
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        HashMap hashMap = new HashMap();
        for (ReactPackage createViewManagers : this.mChildReactPackages) {
            for (ViewManager next : createViewManagers.createViewManagers(reactApplicationContext)) {
                hashMap.put(next.getName(), next);
            }
        }
        return new ArrayList(hashMap.values());
    }

    public List<String> getViewManagerNames(ReactApplicationContext reactApplicationContext) {
        HashSet hashSet = new HashSet();
        for (ReactPackage next : this.mChildReactPackages) {
            if (next instanceof ViewManagerOnDemandReactPackage) {
                List<String> viewManagerNames = ((ViewManagerOnDemandReactPackage) next).getViewManagerNames(reactApplicationContext);
                if (viewManagerNames != null) {
                    hashSet.addAll(viewManagerNames);
                }
            }
        }
        return new ArrayList(hashSet);
    }

    public ViewManager createViewManager(ReactApplicationContext reactApplicationContext, String str) {
        List<ReactPackage> list = this.mChildReactPackages;
        ListIterator<ReactPackage> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            ReactPackage previous = listIterator.previous();
            if (previous instanceof ViewManagerOnDemandReactPackage) {
                ViewManager createViewManager = ((ViewManagerOnDemandReactPackage) previous).createViewManager(reactApplicationContext, str);
                if (createViewManager != null) {
                    return createViewManager;
                }
            }
        }
        return null;
    }
}
