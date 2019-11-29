package io.a.a.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Application f33043a;

    /* renamed from: b  reason: collision with root package name */
    private C0510a f33044b;

    public static abstract class b {
        public void a(Activity activity) {
        }

        public void a(Activity activity, Bundle bundle) {
        }

        public void b(Activity activity) {
        }

        public void b(Activity activity, Bundle bundle) {
        }

        public void c(Activity activity) {
        }

        public void d(Activity activity) {
        }

        public void e(Activity activity) {
        }
    }

    public a(Context context) {
        this.f33043a = (Application) context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 14) {
            this.f33044b = new C0510a(this.f33043a);
        }
    }

    public boolean a(b bVar) {
        C0510a aVar = this.f33044b;
        return aVar != null && aVar.a(bVar);
    }

    public void a() {
        C0510a aVar = this.f33044b;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* renamed from: io.a.a.a.a$a  reason: collision with other inner class name */
    private static class C0510a {

        /* renamed from: a  reason: collision with root package name */
        private final Set<Application.ActivityLifecycleCallbacks> f33045a = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        private final Application f33046b;

        C0510a(Application application) {
            this.f33046b = application;
        }

        /* access modifiers changed from: private */
        @TargetApi(14)
        public void a() {
            for (Application.ActivityLifecycleCallbacks unregisterActivityLifecycleCallbacks : this.f33045a) {
                this.f33046b.unregisterActivityLifecycleCallbacks(unregisterActivityLifecycleCallbacks);
            }
        }

        /* access modifiers changed from: private */
        @TargetApi(14)
        public boolean a(final b bVar) {
            if (this.f33046b == null) {
                return false;
            }
            AnonymousClass1 r0 = new Application.ActivityLifecycleCallbacks() {
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    bVar.a(activity, bundle);
                }

                public void onActivityStarted(Activity activity) {
                    bVar.a(activity);
                }

                public void onActivityResumed(Activity activity) {
                    bVar.b(activity);
                }

                public void onActivityPaused(Activity activity) {
                    bVar.c(activity);
                }

                public void onActivityStopped(Activity activity) {
                    bVar.d(activity);
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    bVar.b(activity, bundle);
                }

                public void onActivityDestroyed(Activity activity) {
                    bVar.e(activity);
                }
            };
            this.f33046b.registerActivityLifecycleCallbacks(r0);
            this.f33045a.add(r0);
            return true;
        }
    }
}
