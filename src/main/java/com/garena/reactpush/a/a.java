package com.garena.reactpush.a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Set;

public class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private static a f8303a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayDeque<C0143a> f8304b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayDeque<C0143a> f8305c;

    /* renamed from: d  reason: collision with root package name */
    private WeakReference<Activity> f8306d;

    /* renamed from: e  reason: collision with root package name */
    private int f8307e;

    /* renamed from: f  reason: collision with root package name */
    private Set<String> f8308f;

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public static synchronized void a(String str, Throwable th) {
        synchronized (a.class) {
            if (f8303a != null) {
                f8303a.b(str, th);
            }
        }
    }

    public static synchronized void a(Throwable th) {
        synchronized (a.class) {
            if (f8303a != null) {
                f8303a.b(th);
            }
        }
    }

    private void b(String str, Throwable th) {
        if (this.f8307e >= 2 && !this.f8308f.contains(str)) {
            this.f8305c.push(new C0143a(th, str));
            a((Activity) this.f8306d.get());
        }
    }

    private void b(Throwable th) {
        this.f8304b.push(new C0143a(th));
        a((Activity) this.f8306d.get());
    }

    public void onActivityResumed(Activity activity) {
        this.f8306d = new WeakReference<>(activity);
        a(activity);
    }

    public void onActivityPaused(Activity activity) {
        this.f8306d = new WeakReference<>((Object) null);
    }

    private void a(final Activity activity) {
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    int i;
                    FrameLayout frameLayout = (FrameLayout) activity.findViewById(16908290);
                    if (frameLayout != null) {
                        C0143a aVar = null;
                        synchronized (a.this) {
                            i = 1;
                            if (!a.this.f8304b.isEmpty()) {
                                aVar = (C0143a) a.this.f8304b.pop();
                                i = 0;
                            } else if (!a.this.f8305c.isEmpty()) {
                                aVar = (C0143a) a.this.f8305c.pop();
                            }
                        }
                        if (aVar != null) {
                            new d(activity, i, aVar.f8312b, aVar.f8311a).a(frameLayout);
                        }
                    }
                }
            });
        }
    }

    /* renamed from: com.garena.reactpush.a.a$a  reason: collision with other inner class name */
    private static class C0143a {

        /* renamed from: a  reason: collision with root package name */
        public Throwable f8311a;

        /* renamed from: b  reason: collision with root package name */
        public String f8312b;

        public C0143a(Throwable th, String str) {
            this.f8311a = th;
            this.f8312b = str;
        }

        public C0143a(Throwable th) {
            this.f8311a = th;
        }
    }
}
