package butterknife;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ButterKnife {

    /* renamed from: a  reason: collision with root package name */
    static final Map<Class<?>, Constructor<? extends Unbinder>> f3071a = new LinkedHashMap();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f3072b = false;

    private ButterKnife() {
        throw new AssertionError("No instances.");
    }

    public static Unbinder a(Activity activity) {
        return a(activity, activity.getWindow().getDecorView());
    }

    public static Unbinder a(Object obj, View view) {
        Class<?> cls = obj.getClass();
        if (f3072b) {
            Log.d("ButterKnife", "Looking up binding for " + cls.getName());
        }
        Constructor<? extends Unbinder> a2 = a(cls);
        if (a2 == null) {
            return Unbinder.f3073a;
        }
        try {
            return (Unbinder) a2.newInstance(new Object[]{obj, view});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Unable to invoke " + a2, e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("Unable to invoke " + a2, e3);
        } catch (InvocationTargetException e4) {
            Throwable cause = e4.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unable to create binding instance.", cause);
            }
        }
    }

    private static Constructor<? extends Unbinder> a(Class<?> cls) {
        Constructor<? extends Unbinder> constructor;
        Constructor<? extends Unbinder> constructor2 = f3071a.get(cls);
        if (constructor2 != null || f3071a.containsKey(cls)) {
            if (f3072b) {
                Log.d("ButterKnife", "HIT: Cached in binding map.");
            }
            return constructor2;
        }
        String name = cls.getName();
        if (!name.startsWith("android.") && !name.startsWith("java.") && !name.startsWith("androidx.")) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                constructor = classLoader.loadClass(name + "_ViewBinding").getConstructor(new Class[]{cls, View.class});
                if (f3072b) {
                    Log.d("ButterKnife", "HIT: Loaded binding class and constructor.");
                }
            } catch (ClassNotFoundException unused) {
                if (f3072b) {
                    Log.d("ButterKnife", "Not found. Trying superclass " + cls.getSuperclass().getName());
                }
                constructor = a((Class<?>) cls.getSuperclass());
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException("Unable to find binding constructor for " + name, e2);
            }
            f3071a.put(cls, constructor);
            return constructor;
        } else if (!f3072b) {
            return null;
        } else {
            Log.d("ButterKnife", "MISS: Reached framework class. Abandoning search.");
            return null;
        }
    }
}
