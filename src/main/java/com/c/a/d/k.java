package com.c.a.d;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.c.a.c;
import com.c.a.j;
import java.util.HashSet;

public class k extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final a f6130a;

    /* renamed from: b  reason: collision with root package name */
    private final m f6131b;

    /* renamed from: c  reason: collision with root package name */
    private final HashSet<k> f6132c;

    /* renamed from: d  reason: collision with root package name */
    private j f6133d;

    /* renamed from: e  reason: collision with root package name */
    private k f6134e;

    /* renamed from: f  reason: collision with root package name */
    private Fragment f6135f;

    public k() {
        this(new a());
    }

    @SuppressLint({"ValidFragment"})
    k(a aVar) {
        this.f6131b = new a();
        this.f6132c = new HashSet<>();
        this.f6130a = aVar;
    }

    public void a(j jVar) {
        this.f6133d = jVar;
    }

    /* access modifiers changed from: package-private */
    public a a() {
        return this.f6130a;
    }

    public j b() {
        return this.f6133d;
    }

    public m c() {
        return this.f6131b;
    }

    private void a(k kVar) {
        this.f6132c.add(kVar);
    }

    private void b(k kVar) {
        this.f6132c.remove(kVar);
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        this.f6135f = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            a(fragment.getActivity());
        }
    }

    @TargetApi(17)
    private Fragment d() {
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.f6135f;
    }

    private void a(Activity activity) {
        e();
        this.f6134e = c.a((Context) activity).g().a(activity.getFragmentManager(), (Fragment) null);
        k kVar = this.f6134e;
        if (kVar != this) {
            kVar.a(this);
        }
    }

    private void e() {
        k kVar = this.f6134e;
        if (kVar != null) {
            kVar.b(this);
            this.f6134e = null;
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            a(activity);
        } catch (IllegalStateException e2) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e2);
            }
        }
    }

    public void onDetach() {
        super.onDetach();
        e();
    }

    public void onStart() {
        super.onStart();
        this.f6130a.a();
    }

    public void onStop() {
        super.onStop();
        this.f6130a.b();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f6130a.c();
        e();
    }

    public String toString() {
        return super.toString() + "{parent=" + d() + "}";
    }

    private class a implements m {
        a() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + k.this + "}";
        }
    }
}
