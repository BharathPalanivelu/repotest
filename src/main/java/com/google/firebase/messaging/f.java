package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.i;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Tasks;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class f {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f14212a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f14213b;

    /* renamed from: c  reason: collision with root package name */
    private final e f14214c;

    /* renamed from: d  reason: collision with root package name */
    private final Bundle f14215d;

    public f(Context context, Bundle bundle, Executor executor) {
        this.f14212a = executor;
        this.f14213b = context;
        this.f14215d = bundle;
        this.f14214c = new e(context, context.getPackageName());
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        boolean z;
        if ("1".equals(e.a(this.f14215d, "gcm.n.noui"))) {
            return true;
        }
        if (!((KeyguardManager) this.f14213b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            if (!PlatformVersion.isAtLeastLollipop()) {
                SystemClock.sleep(10);
            }
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f14213b.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == myPid) {
                        if (next.importance == 100) {
                            z = true;
                        }
                    }
                }
            }
        }
        z = false;
        if (z) {
            return false;
        }
        g a2 = g.a(e.a(this.f14215d, "gcm.n.image"));
        if (a2 != null) {
            a2.a(this.f14212a);
        }
        d a3 = this.f14214c.a(this.f14215d);
        i.d dVar = a3.f14205a;
        if (a2 != null) {
            try {
                Bitmap bitmap = (Bitmap) Tasks.await(a2.a(), 5, TimeUnit.SECONDS);
                dVar.a(bitmap);
                dVar.a((i.g) new i.b().a(bitmap).b((Bitmap) null));
            } catch (ExecutionException unused) {
            } catch (InterruptedException unused2) {
                Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
                a2.close();
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused3) {
                Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
                a2.close();
            }
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        ((NotificationManager) this.f14213b.getSystemService("notification")).notify(a3.f14206b, 0, a3.f14205a.b());
        return true;
    }
}
