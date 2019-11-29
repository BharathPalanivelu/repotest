package com.shopee.b.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import d.d.b.j;
import java.util.ArrayList;
import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<a> f27111a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f27112b;

    public b(Context context) {
        j.b(context, "context");
        this.f27112b = context;
        this.f27111a = new ArrayList<>();
        this.f27111a = a(this, false, 1, (Object) null);
    }

    public final ArrayList<a> a() {
        return this.f27111a;
    }

    static /* synthetic */ ArrayList a(b bVar, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return bVar.a(z);
    }

    private final ArrayList<a> a(boolean z) {
        String str;
        ArrayList<a> arrayList = new ArrayList<>();
        List<PackageInfo> installedPackages = this.f27112b.getPackageManager().getInstalledPackages(0);
        j.a((Object) installedPackages, "packs");
        int size = installedPackages.size();
        for (int i = 0; i < size; i++) {
            PackageInfo packageInfo = installedPackages.get(i);
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (z || (applicationInfo.flags & 1) != 1) {
                String obj = packageInfo.applicationInfo.loadLabel(this.f27112b.getPackageManager()).toString();
                String str2 = packageInfo.packageName;
                String str3 = str2 != null ? str2 : "";
                String str4 = packageInfo.versionName;
                if (str4 != null) {
                    str = str4;
                } else {
                    str = "";
                }
                long j = (long) 1000;
                arrayList.add(new a(obj, str3, str, packageInfo.versionCode, (int) (packageInfo.firstInstallTime / j), (int) (packageInfo.lastUpdateTime / j)));
            }
        }
        return arrayList;
    }
}
