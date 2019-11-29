package com.garena.reactpush.c;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.CatalystInstanceImpl;
import com.facebook.react.bridge.ReactContext;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public static Set<String> f8359a = new HashSet();

    public static CatalystInstance a(ReactInstanceManager reactInstanceManager) {
        if (reactInstanceManager == null) {
            return null;
        }
        ReactContext currentReactContext = reactInstanceManager.getCurrentReactContext();
        if (currentReactContext == null) {
            return null;
        }
        return currentReactContext.getCatalystInstance();
    }

    public static void a(CatalystInstance catalystInstance, String str) {
        if (!f8359a.contains(str)) {
            Class<CatalystInstanceImpl> cls = CatalystInstanceImpl.class;
            try {
                Method declaredMethod = cls.getDeclaredMethod("loadScriptFromFile", new Class[]{String.class, String.class, Boolean.TYPE});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(catalystInstance, new Object[]{str, str, false});
                f8359a.add(str);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
    }
}
