package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import com.appsflyer.AFDeepLinkManager;
import com.appsflyer.AFExecutor;
import com.appsflyer.AFLogger;
import java.lang.ref.WeakReference;
import java.util.concurrent.RejectedExecutionException;

public final class p implements Application.ActivityLifecycleCallbacks {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static p f224;

    /* renamed from: ˊ  reason: contains not printable characters */
    boolean f225 = false;

    /* renamed from: ˋ  reason: contains not printable characters */
    boolean f226 = true;

    /* renamed from: ॱ  reason: contains not printable characters */
    public b f227 = null;

    public interface b {
        /* renamed from: ˋ  reason: contains not printable characters */
        void m173(Activity activity);

        /* renamed from: ˎ  reason: contains not printable characters */
        void m174(WeakReference<Context> weakReference);
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        this.f226 = false;
        boolean z = !this.f225;
        this.f225 = true;
        if (z) {
            try {
                this.f227.m173(activity);
            } catch (Exception e2) {
                AFLogger.afErrorLog("Listener threw exception! ", e2);
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        this.f226 = true;
        try {
            new a(new WeakReference(activity.getApplicationContext())).executeOnExecutor(AFExecutor.getInstance().getThreadPoolExecutor(), new Void[0]);
        } catch (RejectedExecutionException e2) {
            AFLogger.afErrorLog("backgroundTask.executeOnExecutor failed with RejectedExecutionException Exception", e2);
        } catch (Throwable th) {
            AFLogger.afErrorLog("backgroundTask.executeOnExecutor failed with Exception", th);
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AFDeepLinkManager.getInstance().collectIntentsFromActivities(activity.getIntent());
    }

    class a extends AsyncTask<Void, Void, Void> {

        /* renamed from: ˏ  reason: contains not printable characters */
        private WeakReference<Context> f229;

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return m172();
        }

        public a(WeakReference<Context> weakReference) {
            this.f229 = weakReference;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        private Void m172() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e2) {
                AFLogger.afErrorLog("Sleeping attempt failed (essential for background state verification)\n", e2);
            }
            if (p.this.f225 && p.this.f226) {
                p pVar = p.this;
                pVar.f225 = false;
                try {
                    pVar.f227.m174(this.f229);
                } catch (Exception e3) {
                    AFLogger.afErrorLog("Listener threw exception! ", e3);
                    cancel(true);
                }
            }
            this.f229.clear();
            return null;
        }
    }
}
