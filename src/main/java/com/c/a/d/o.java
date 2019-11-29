package com.c.a.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.c;
import com.c.a.j;
import java.util.HashSet;

public class o extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final a f6147a;

    /* renamed from: b  reason: collision with root package name */
    private final m f6148b;

    /* renamed from: c  reason: collision with root package name */
    private final HashSet<o> f6149c;

    /* renamed from: d  reason: collision with root package name */
    private o f6150d;

    /* renamed from: e  reason: collision with root package name */
    private j f6151e;

    /* renamed from: f  reason: collision with root package name */
    private Fragment f6152f;

    public o() {
        this(new a());
    }

    @SuppressLint({"ValidFragment"})
    public o(a aVar) {
        this.f6148b = new a();
        this.f6149c = new HashSet<>();
        this.f6147a = aVar;
    }

    public void a(j jVar) {
        this.f6151e = jVar;
    }

    /* access modifiers changed from: package-private */
    public a a() {
        return this.f6147a;
    }

    public j b() {
        return this.f6151e;
    }

    public m c() {
        return this.f6148b;
    }

    private void a(o oVar) {
        this.f6149c.add(oVar);
    }

    private void b(o oVar) {
        this.f6149c.remove(oVar);
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        this.f6152f = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            a(fragment.getActivity());
        }
    }

    private Fragment d() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f6152f;
    }

    private void a(c cVar) {
        e();
        this.f6150d = com.c.a.c.a((Context) cVar).g().a(cVar.getSupportFragmentManager(), (Fragment) null);
        o oVar = this.f6150d;
        if (oVar != this) {
            oVar.a(this);
        }
    }

    private void e() {
        o oVar = this.f6150d;
        if (oVar != null) {
            oVar.b(this);
            this.f6150d = null;
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            a(getActivity());
        } catch (IllegalStateException e2) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root", e2);
            }
        }
    }

    public void onDetach() {
        super.onDetach();
        this.f6152f = null;
        e();
    }

    public void onStart() {
        super.onStart();
        this.f6147a.a();
    }

    public void onStop() {
        super.onStop();
        this.f6147a.b();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f6147a.c();
        e();
    }

    public String toString() {
        return super.toString() + "{parent=" + d() + "}";
    }

    private class a implements m {
        a() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + o.this + "}";
        }
    }
}
