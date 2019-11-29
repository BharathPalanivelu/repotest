package com.google.android.libraries.places.internal;

import android.content.Context;
import android.content.pm.PackageManager;

public class fg implements ny {

    /* renamed from: a  reason: collision with root package name */
    public final String f12552a;

    /* renamed from: b  reason: collision with root package name */
    public final String f12553b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12554c;

    public final /* synthetic */ Object b() {
        throw new NoSuchMethodError();
    }

    public fg(Context context) {
        this.f12552a = context.getPackageName();
        this.f12553b = dq.a(context.getPackageManager(), this.f12552a);
        this.f12554c = a(context);
    }

    public String a() {
        return this.f12553b;
    }

    public String c() {
        return this.f12552a;
    }

    public int d() {
        return this.f12554c;
    }

    public int a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(this.f12552a, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }
}
