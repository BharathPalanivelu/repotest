package androidx.l;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.g.w;
import androidx.l.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class p {

    /* renamed from: a  reason: collision with root package name */
    static ArrayList<ViewGroup> f2520a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private static n f2521b = new b();

    /* renamed from: c  reason: collision with root package name */
    private static ThreadLocal<WeakReference<androidx.b.a<ViewGroup, ArrayList<n>>>> f2522c = new ThreadLocal<>();

    static androidx.b.a<ViewGroup, ArrayList<n>> a() {
        WeakReference weakReference = f2522c.get();
        if (weakReference != null) {
            androidx.b.a<ViewGroup, ArrayList<n>> aVar = (androidx.b.a) weakReference.get();
            if (aVar != null) {
                return aVar;
            }
        }
        androidx.b.a<ViewGroup, ArrayList<n>> aVar2 = new androidx.b.a<>();
        f2522c.set(new WeakReference(aVar2));
        return aVar2;
    }

    private static void b(ViewGroup viewGroup, n nVar) {
        if (nVar != null && viewGroup != null) {
            a aVar = new a(nVar, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    private static class a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        n f2523a;

        /* renamed from: b  reason: collision with root package name */
        ViewGroup f2524b;

        public void onViewAttachedToWindow(View view) {
        }

        a(n nVar, ViewGroup viewGroup) {
            this.f2523a = nVar;
            this.f2524b = viewGroup;
        }

        private void a() {
            this.f2524b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f2524b.removeOnAttachStateChangeListener(this);
        }

        public void onViewDetachedFromWindow(View view) {
            a();
            p.f2520a.remove(this.f2524b);
            ArrayList arrayList = p.a().get(this.f2524b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((n) it.next()).e(this.f2524b);
                }
            }
            this.f2523a.a(true);
        }

        public boolean onPreDraw() {
            a();
            if (!p.f2520a.remove(this.f2524b)) {
                return true;
            }
            final androidx.b.a<ViewGroup, ArrayList<n>> a2 = p.a();
            ArrayList arrayList = a2.get(this.f2524b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                a2.put(this.f2524b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f2523a);
            this.f2523a.a((n.c) new o() {
                public void a(n nVar) {
                    ((ArrayList) a2.get(a.this.f2524b)).remove(nVar);
                }
            });
            this.f2523a.a(this.f2524b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((n) it.next()).e(this.f2524b);
                }
            }
            this.f2523a.a(this.f2524b);
            return true;
        }
    }

    private static void c(ViewGroup viewGroup, n nVar) {
        ArrayList arrayList = a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((n) it.next()).d(viewGroup);
            }
        }
        if (nVar != null) {
            nVar.a(viewGroup, true);
        }
        m a2 = m.a(viewGroup);
        if (a2 != null) {
            a2.a();
        }
    }

    public static void a(ViewGroup viewGroup, n nVar) {
        if (!f2520a.contains(viewGroup) && w.A(viewGroup)) {
            f2520a.add(viewGroup);
            if (nVar == null) {
                nVar = f2521b;
            }
            n o = nVar.clone();
            c(viewGroup, o);
            m.a(viewGroup, (m) null);
            b(viewGroup, o);
        }
    }
}
