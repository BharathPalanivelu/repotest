package com.google.android.play.core.missingsplits;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.android.play.core.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final a f13571a = new a("MissingSplitsAppComponentsHelper");

    /* renamed from: b  reason: collision with root package name */
    private final Context f13572b;

    /* renamed from: c  reason: collision with root package name */
    private final PackageManager f13573c;

    c(Context context, PackageManager packageManager) {
        this.f13572b = context;
        this.f13573c = packageManager;
    }

    private final void a(List<ComponentInfo> list, int i) {
        for (ComponentInfo next : list) {
            this.f13573c.setComponentEnabledSetting(new ComponentName(next.packageName, next.name), i, 1);
        }
    }

    private final List<ComponentInfo> d() {
        try {
            ArrayList arrayList = new ArrayList();
            PackageInfo packageInfo = this.f13573c.getPackageInfo(this.f13572b.getPackageName(), 526);
            if (packageInfo.providers != null) {
                Collections.addAll(arrayList, packageInfo.providers);
            }
            if (packageInfo.receivers != null) {
                Collections.addAll(arrayList, packageInfo.receivers);
            }
            if (packageInfo.services != null) {
                Collections.addAll(arrayList, packageInfo.services);
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e2) {
            f13571a.c("Failed to resolve own package", e2);
            return Collections.emptyList();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        for (ComponentInfo next : d()) {
            if (this.f13573c.getComponentEnabledSetting(new ComponentName(next.packageName, next.name)) != 2) {
                f13571a.b("Not all non-activity components are disabled", new Object[0]);
                return false;
            }
        }
        f13571a.b("All non-activity components are disabled", new Object[0]);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        f13571a.a("Disabling all non-activity components", new Object[0]);
        a(d(), 2);
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        f13571a.a("Resetting enabled state of all non-activity components", new Object[0]);
        a(d(), 0);
    }
}
