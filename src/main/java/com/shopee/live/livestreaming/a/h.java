package com.shopee.live.livestreaming.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.List;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private Application.ActivityLifecycleCallbacks f28757a = new Application.ActivityLifecycleCallbacks() {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (h.this.f28758b) {
                boolean unused = h.this.f28758b = false;
                com.shopee.e.a.a.a((Object) "LiveStreaming： back to foreground");
                h.this.c().b();
            }
        }

        public void onActivityResumed(Activity activity) {
            if (h.this.f28758b) {
                boolean unused = h.this.f28758b = false;
                com.shopee.e.a.a.a((Object) "LiveStreaming： back to foreground");
                h.this.c().b();
            }
        }

        public void onActivityPaused(Activity activity) {
            if (!h.this.f28758b && h.this.b() == 0) {
                boolean unused = h.this.f28758b = true;
                com.shopee.e.a.a.a((Object) "LiveStreaming： go to background");
                h.this.c().a();
            }
        }

        public void onActivityStopped(Activity activity) {
            if (!h.this.f28758b && h.this.b() == 0) {
                boolean unused = h.this.f28758b = true;
                com.shopee.e.a.a.a((Object) "LiveStreaming： go to background");
                h.this.c().a();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f28758b;

    /* renamed from: c  reason: collision with root package name */
    private Application f28759c;

    /* renamed from: d  reason: collision with root package name */
    private a f28760d;

    /* renamed from: e  reason: collision with root package name */
    private ComponentCallbacks2 f28761e;

    public interface a {
        void a();

        void b();
    }

    public h(Application application) {
        this.f28759c = application;
        this.f28759c.registerActivityLifecycleCallbacks(this.f28757a);
        this.f28761e = new ComponentCallbacks2() {
            public void onConfigurationChanged(Configuration configuration) {
            }

            public void onLowMemory() {
            }

            public void onTrimMemory(int i) {
                if (i == 20 && !h.this.f28758b) {
                    boolean unused = h.this.f28758b = true;
                    com.shopee.e.a.a.a((Object) "LiveStreaming： onTrim-ui-hidden go to background");
                    h.this.c().a();
                }
            }
        };
        this.f28759c.registerComponentCallbacks(this.f28761e);
    }

    public void a(a aVar) {
        this.f28760d = aVar;
    }

    public void a() {
        this.f28759c.unregisterActivityLifecycleCallbacks(this.f28757a);
        this.f28759c.unregisterComponentCallbacks(this.f28761e);
        this.f28760d = null;
        this.f28761e = null;
    }

    /* access modifiers changed from: private */
    public int b() {
        ActivityManager activityManager = (ActivityManager) this.f28759c.getSystemService("activity");
        if (activityManager == null) {
            return -1;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
            try {
                for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                    if (next.processName.equals(this.f28759c.getPackageName()) && next.importance == 100) {
                        return 1;
                    }
                }
                return 0;
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public a c() {
        a aVar = this.f28760d;
        return aVar == null ? new a() {
            public void a() {
            }

            public void b() {
            }
        } : aVar;
    }
}
