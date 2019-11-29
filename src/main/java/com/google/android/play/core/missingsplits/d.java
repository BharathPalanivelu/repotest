package com.google.android.play.core.missingsplits;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.play.core.a.a;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

final class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final a f13574a = new a("MissingSplitsManagerImpl");

    /* renamed from: b  reason: collision with root package name */
    private final Context f13575b;

    /* renamed from: c  reason: collision with root package name */
    private final Runtime f13576c;

    /* renamed from: d  reason: collision with root package name */
    private final c f13577d;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicReference<Boolean> f13578e;

    d(Context context, Runtime runtime, c cVar, AtomicReference<Boolean> atomicReference) {
        this.f13575b = context;
        this.f13576c = runtime;
        this.f13577d = cVar;
        this.f13578e = atomicReference;
    }

    private final boolean a(ComponentName componentName) {
        String className = componentName.getClassName();
        try {
            Class<?> cls = Class.forName(className);
            while (cls != null) {
                if (cls.equals(Activity.class)) {
                    return true;
                }
                Class<? super Object> superclass = cls.getSuperclass();
                cls = superclass != cls ? superclass : null;
            }
            return false;
        } catch (ClassNotFoundException unused) {
            f13574a.c("ClassNotFoundException when scanning class hierarchy of '%s'", className);
            try {
                return this.f13575b.getPackageManager().getActivityInfo(componentName, 0) != null;
            } catch (PackageManager.NameNotFoundException unused2) {
            }
        }
    }

    private final boolean c() {
        try {
            ApplicationInfo applicationInfo = this.f13575b.getPackageManager().getApplicationInfo(this.f13575b.getPackageName(), 128);
            return applicationInfo.metaData != null && Boolean.TRUE.equals(applicationInfo.metaData.get("com.android.vending.splits.required"));
        } catch (PackageManager.NameNotFoundException unused) {
            f13574a.c("App '%s' is not found in the PackageManager", this.f13575b.getPackageName());
            return false;
        }
    }

    private final Set<String> d() {
        if (Build.VERSION.SDK_INT < 21) {
            return Collections.emptySet();
        }
        try {
            PackageInfo packageInfo = this.f13575b.getPackageManager().getPackageInfo(this.f13575b.getPackageName(), 0);
            HashSet hashSet = new HashSet();
            if (packageInfo.splitNames != null) {
                Collections.addAll(hashSet, packageInfo.splitNames);
            }
            return hashSet;
        } catch (PackageManager.NameNotFoundException unused) {
            f13574a.c("App '%s' is not found in PackageManager", this.f13575b.getPackageName());
            return Collections.emptySet();
        }
    }

    private final List<ActivityManager.AppTask> e() {
        List<ActivityManager.AppTask> appTasks = ((ActivityManager) this.f13575b.getSystemService("activity")).getAppTasks();
        return appTasks != null ? appTasks : Collections.emptyList();
    }

    public final boolean a() {
        boolean z;
        boolean z2;
        boolean z3;
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        if (b()) {
            Iterator<ActivityManager.AppTask> it = e().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                ActivityManager.AppTask next = it.next();
                if (!(next.getTaskInfo() == null || next.getTaskInfo().baseIntent == null || next.getTaskInfo().baseIntent.getComponent() == null)) {
                    if (PlayCoreMissingSplitsActivity.class.getName().equals(next.getTaskInfo().baseIntent.getComponent().getClassName())) {
                        z = true;
                        break;
                    }
                }
            }
            if (!z) {
                Iterator<ActivityManager.AppTask> it2 = e().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z2 = false;
                        break;
                    }
                    ActivityManager.RecentTaskInfo taskInfo = it2.next().getTaskInfo();
                    if (taskInfo == null || taskInfo.baseIntent == null || taskInfo.baseIntent.getComponent() == null || !a(taskInfo.baseIntent.getComponent())) {
                        z3 = false;
                        continue;
                    } else {
                        z3 = true;
                        continue;
                    }
                    if (z3) {
                        z2 = true;
                        break;
                    }
                }
                this.f13577d.b();
                for (ActivityManager.AppTask finishAndRemoveTask : e()) {
                    finishAndRemoveTask.finishAndRemoveTask();
                }
                if (z2) {
                    this.f13575b.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f13575b, PlayCoreMissingSplitsActivity.class), 1, 1);
                    this.f13575b.startActivity(new Intent(this.f13575b, PlayCoreMissingSplitsActivity.class).addFlags(884998144));
                }
                this.f13576c.exit(0);
            }
            return true;
        }
        if (this.f13577d.a()) {
            this.f13577d.c();
            this.f13576c.exit(0);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b() {
        /*
            r6 = this;
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r0 = r6.f13578e
            monitor-enter(r0)
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r1 = r6.f13578e     // Catch:{ all -> 0x0051 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x0051 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x0051 }
            if (r1 != 0) goto L_0x0043
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r1 = r6.f13578e     // Catch:{ all -> 0x0051 }
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0051 }
            r3 = 21
            r4 = 0
            r5 = 1
            if (r2 < r3) goto L_0x003c
            boolean r2 = r6.c()     // Catch:{ all -> 0x0051 }
            if (r2 == 0) goto L_0x003c
            java.util.Set r2 = r6.d()     // Catch:{ all -> 0x0051 }
            boolean r3 = r2.isEmpty()     // Catch:{ all -> 0x0051 }
            if (r3 != 0) goto L_0x0038
            int r3 = r2.size()     // Catch:{ all -> 0x0051 }
            if (r3 != r5) goto L_0x0036
            java.lang.String r3 = ""
            boolean r2 = r2.contains(r3)     // Catch:{ all -> 0x0051 }
            if (r2 == 0) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            r2 = 0
            goto L_0x0039
        L_0x0038:
            r2 = 1
        L_0x0039:
            if (r2 == 0) goto L_0x003c
            r4 = 1
        L_0x003c:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x0051 }
            r1.set(r2)     // Catch:{ all -> 0x0051 }
        L_0x0043:
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r1 = r6.f13578e     // Catch:{ all -> 0x0051 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x0051 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x0051 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0051 }
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            return r1
        L_0x0051:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.missingsplits.d.b():boolean");
    }
}
