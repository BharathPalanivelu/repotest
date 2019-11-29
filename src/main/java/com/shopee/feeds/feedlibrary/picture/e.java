package com.shopee.feeds.feedlibrary.picture;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import java.lang.ref.WeakReference;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Activity> f28244a;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Fragment> f28245b;

    private e(Activity activity) {
        this(activity, (Fragment) null);
    }

    private e(Activity activity, Fragment fragment) {
        this.f28244a = new WeakReference<>(activity);
        this.f28245b = new WeakReference<>(fragment);
    }

    public static e a(Activity activity) {
        return new e(activity);
    }

    public d a(int i) {
        return new d(this, i);
    }
}
