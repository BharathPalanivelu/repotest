package com.garena.android.appkit.e;

import android.app.Activity;
import java.lang.ref.WeakReference;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f7669a = new a();

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<Activity> f7670b;

    public static a a() {
        return f7669a;
    }

    private a() {
    }

    public void a(Activity activity) {
        if (activity == null) {
            this.f7670b = null;
        } else {
            this.f7670b = new WeakReference<>(activity);
        }
    }

    public Activity b() {
        WeakReference<Activity> weakReference = this.f7670b;
        if (weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }
}
