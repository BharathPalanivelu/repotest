package qalsdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class ah implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private static ah f34092a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f34093b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private Runnable f34094c;

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

    static {
        ah.class.getSimpleName();
    }

    private ah() {
    }

    public static void a(Context context) {
        if (f34092a == null) {
            f34092a = new ah();
            ((Application) context).registerActivityLifecycleCallbacks(f34092a);
        }
    }

    public void onActivityPaused(Activity activity) {
        Runnable runnable = this.f34094c;
        if (runnable != null) {
            this.f34093b.removeCallbacks(runnable);
        }
        Handler handler = this.f34093b;
        ai aiVar = new ai(this);
        this.f34094c = aiVar;
        handler.postDelayed(aiVar, 2000);
    }

    public void onActivityResumed(Activity activity) {
        Runnable runnable = this.f34094c;
        if (runnable != null) {
            this.f34093b.removeCallbacks(runnable);
        }
    }
}
