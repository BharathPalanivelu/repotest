package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

class h {

    /* renamed from: a  reason: collision with root package name */
    private static Field f648a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f649b;

    /* renamed from: c  reason: collision with root package name */
    private static Class<?> f650c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f651d;

    /* renamed from: e  reason: collision with root package name */
    private static Field f652e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f653f;

    /* renamed from: g  reason: collision with root package name */
    private static Field f654g;
    private static boolean h;

    static void a(Resources resources) {
        if (Build.VERSION.SDK_INT < 28) {
            if (Build.VERSION.SDK_INT >= 24) {
                d(resources);
            } else if (Build.VERSION.SDK_INT >= 23) {
                c(resources);
            } else if (Build.VERSION.SDK_INT >= 21) {
                b(resources);
            }
        }
    }

    private static void b(Resources resources) {
        Map map;
        if (!f649b) {
            try {
                f648a = Resources.class.getDeclaredField("mDrawableCache");
                f648a.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f649b = true;
        }
        Field field = f648a;
        if (field != null) {
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    private static void c(Resources resources) {
        if (!f649b) {
            try {
                f648a = Resources.class.getDeclaredField("mDrawableCache");
                f648a.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f649b = true;
        }
        Object obj = null;
        Field field = f648a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
            }
        }
        if (obj != null) {
            a(obj);
        }
    }

    private static void d(Resources resources) {
        Object obj;
        if (!h) {
            try {
                f654g = Resources.class.getDeclaredField("mResourcesImpl");
                f654g.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e2);
            }
            h = true;
        }
        Field field = f654g;
        if (field != null) {
            Object obj2 = null;
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e3);
                obj = null;
            }
            if (obj != null) {
                if (!f649b) {
                    try {
                        f648a = obj.getClass().getDeclaredField("mDrawableCache");
                        f648a.setAccessible(true);
                    } catch (NoSuchFieldException e4) {
                        Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e4);
                    }
                    f649b = true;
                }
                Field field2 = f648a;
                if (field2 != null) {
                    try {
                        obj2 = field2.get(obj);
                    } catch (IllegalAccessException e5) {
                        Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e5);
                    }
                }
                if (obj2 != null) {
                    a(obj2);
                }
            }
        }
    }

    private static void a(Object obj) {
        LongSparseArray longSparseArray;
        if (!f651d) {
            try {
                f650c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e2) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e2);
            }
            f651d = true;
        }
        Class<?> cls = f650c;
        if (cls != null) {
            if (!f653f) {
                try {
                    f652e = cls.getDeclaredField("mUnthemedEntries");
                    f652e.setAccessible(true);
                } catch (NoSuchFieldException e3) {
                    Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e3);
                }
                f653f = true;
            }
            Field field = f652e;
            if (field != null) {
                try {
                    longSparseArray = (LongSparseArray) field.get(obj);
                } catch (IllegalAccessException e4) {
                    Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e4);
                    longSparseArray = null;
                }
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
    }
}
