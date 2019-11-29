package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

final class b {

    /* renamed from: a  reason: collision with root package name */
    protected static final Class<?> f1526a = d();

    /* renamed from: b  reason: collision with root package name */
    protected static final Field f1527b = b();

    /* renamed from: c  reason: collision with root package name */
    protected static final Field f1528c = c();

    /* renamed from: d  reason: collision with root package name */
    protected static final Method f1529d = a(f1526a);

    /* renamed from: e  reason: collision with root package name */
    protected static final Method f1530e = b(f1526a);

    /* renamed from: f  reason: collision with root package name */
    protected static final Method f1531f = c(f1526a);

    /* renamed from: g  reason: collision with root package name */
    private static final Handler f1532g = new Handler(Looper.getMainLooper());

    static boolean a(Activity activity) {
        final Application application;
        final a aVar;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (a() && f1531f == null) {
            return false;
        } else {
            if (f1530e == null && f1529d == null) {
                return false;
            }
            try {
                final Object obj = f1528c.get(activity);
                if (obj == null) {
                    return false;
                }
                Object obj2 = f1527b.get(activity);
                if (obj2 == null) {
                    return false;
                }
                application = activity.getApplication();
                aVar = new a(activity);
                application.registerActivityLifecycleCallbacks(aVar);
                f1532g.post(new Runnable() {
                    public void run() {
                        aVar.f1539a = obj;
                    }
                });
                if (a()) {
                    f1531f.invoke(obj2, new Object[]{obj, null, null, 0, false, null, null, false, false});
                } else {
                    activity.recreate();
                }
                f1532g.post(new Runnable() {
                    public void run() {
                        application.unregisterActivityLifecycleCallbacks(aVar);
                    }
                });
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    private static final class a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        Object f1539a;

        /* renamed from: b  reason: collision with root package name */
        private Activity f1540b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1541c = false;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1542d = false;

        /* renamed from: e  reason: collision with root package name */
        private boolean f1543e = false;

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStopped(Activity activity) {
        }

        a(Activity activity) {
            this.f1540b = activity;
        }

        public void onActivityStarted(Activity activity) {
            if (this.f1540b == activity) {
                this.f1541c = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.f1542d && !this.f1543e && !this.f1541c && b.a(this.f1539a, activity)) {
                this.f1543e = true;
                this.f1539a = null;
            }
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.f1540b == activity) {
                this.f1540b = null;
                this.f1542d = true;
            }
        }
    }

    protected static boolean a(Object obj, Activity activity) {
        try {
            final Object obj2 = f1528c.get(activity);
            if (obj2 != obj) {
                return false;
            }
            final Object obj3 = f1527b.get(activity);
            f1532g.postAtFrontOfQueue(new Runnable() {
                public void run() {
                    try {
                        if (b.f1529d != null) {
                            b.f1529d.invoke(obj3, new Object[]{obj2, false, "AppCompat recreation"});
                            return;
                        }
                        b.f1530e.invoke(obj3, new Object[]{obj2, false});
                    } catch (RuntimeException e2) {
                        if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                            throw e2;
                        }
                    } catch (Throwable th) {
                        Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                    }
                }
            });
            return true;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    private static Method a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE, String.class});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27;
    }

    private static Method c(Class<?> cls) {
        if (a() && cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", new Class[]{IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE});
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field c() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> d() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }
}
