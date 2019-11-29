package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSIModuleRegistry {
    private final Map<Class, JSIModuleHolder> mModules = new HashMap();

    public <T extends JSIModule> T getModule(Class<T> cls) {
        JSIModuleHolder jSIModuleHolder = this.mModules.get(cls);
        if (jSIModuleHolder != null) {
            return (JSIModule) Assertions.assertNotNull(jSIModuleHolder.getJSIModule());
        }
        throw new IllegalArgumentException("Unable to find JSIModule for class " + cls);
    }

    public void registerModules(List<JSIModuleSpec> list) {
        for (JSIModuleSpec next : list) {
            this.mModules.put(next.getJSIModuleClass(), new JSIModuleHolder(next));
        }
    }

    public void notifyJSInstanceDestroy() {
        for (JSIModuleHolder notifyJSInstanceDestroy : this.mModules.values()) {
            notifyJSInstanceDestroy.notifyJSInstanceDestroy();
        }
    }
}
