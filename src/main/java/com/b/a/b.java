package com.b.a;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.b.a.a;
import com.b.a.a.b;
import com.b.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class b<P extends com.b.a.a.b<C>, C, PVH extends c, CVH extends a> extends RecyclerView.a<RecyclerView.w> {

    /* renamed from: a  reason: collision with root package name */
    protected List<com.b.a.a.a<P, C>> f4656a;

    /* renamed from: b  reason: collision with root package name */
    private List<P> f4657b;

    /* renamed from: c  reason: collision with root package name */
    private a f4658c;

    /* renamed from: d  reason: collision with root package name */
    private List<RecyclerView> f4659d;

    /* renamed from: e  reason: collision with root package name */
    private Map<P, Boolean> f4660e;

    /* renamed from: f  reason: collision with root package name */
    private c.a f4661f = new c.a() {
        public void a(int i) {
            b.this.c(i);
        }

        public void b(int i) {
            b.this.d(i);
        }
    };

    public interface a {
        void a(int i);

        void b(int i);
    }

    public int a(int i) {
        return 0;
    }

    public int a(int i, int i2) {
        return 1;
    }

    public abstract PVH a(ViewGroup viewGroup, int i);

    public abstract void a(CVH cvh, int i, int i2, C c2);

    public abstract void a(PVH pvh, int i, P p);

    public abstract CVH b(ViewGroup viewGroup, int i);

    public boolean b(int i) {
        return i == 0;
    }

    public b(List<P> list) {
        this.f4657b = list;
        this.f4656a = a(list);
        this.f4659d = new ArrayList();
        this.f4660e = new HashMap(this.f4657b.size());
    }

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (b(i)) {
            c a2 = a(viewGroup, i);
            a2.a(this.f4661f);
            a2.f4664b = this;
            return a2;
        }
        a b2 = b(viewGroup, i);
        b2.f4650b = this;
        return b2;
    }

    public void onBindViewHolder(RecyclerView.w wVar, int i) {
        if (i <= this.f4656a.size()) {
            com.b.a.a.a aVar = this.f4656a.get(i);
            if (aVar.d()) {
                c cVar = (c) wVar;
                if (cVar.d()) {
                    cVar.b();
                }
                cVar.a(aVar.c());
                cVar.f4663a = aVar.a();
                a(cVar, e(i), aVar.a());
                return;
            }
            a aVar2 = (a) wVar;
            aVar2.f4649a = aVar.b();
            a(aVar2, e(i), f(i), aVar.b());
            return;
        }
        throw new IllegalStateException("Trying to bind item out of bounds, size " + this.f4656a.size() + " flatPosition " + i + ". Was the data changed without a call to notify...()?");
    }

    public int getItemCount() {
        return this.f4656a.size();
    }

    public int getItemViewType(int i) {
        if (this.f4656a.get(i).d()) {
            return a(e(i));
        }
        return a(e(i), f(i));
    }

    public List<P> a() {
        return this.f4657b;
    }

    public void a(List<P> list, boolean z) {
        this.f4657b = list;
        a(z);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f4659d.add(recyclerView);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.f4659d.remove(recyclerView);
    }

    /* access modifiers changed from: protected */
    public void c(int i) {
        a(this.f4656a.get(i), i, true);
    }

    /* access modifiers changed from: protected */
    public void d(int i) {
        b(this.f4656a.get(i), i, true);
    }

    private void a(com.b.a.a.a<P, C> aVar, int i, boolean z) {
        if (!aVar.c()) {
            aVar.a(true);
            this.f4660e.put(aVar.a(), true);
            List<com.b.a.a.a<P, C>> e2 = aVar.e();
            if (e2 != null) {
                int size = e2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f4656a.add(i + i2 + 1, e2.get(i2));
                }
                notifyItemRangeInserted(i + 1, size);
            }
            if (z) {
                a aVar2 = this.f4658c;
                if (aVar2 != null) {
                    aVar2.a(e(i));
                }
            }
        }
    }

    private void b(com.b.a.a.a<P, C> aVar, int i, boolean z) {
        if (aVar.c()) {
            aVar.a(false);
            this.f4660e.put(aVar.a(), false);
            List<com.b.a.a.a<P, C>> e2 = aVar.e();
            if (e2 != null) {
                int size = e2.size();
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    this.f4656a.remove(i + i2 + 1);
                }
                notifyItemRangeRemoved(i + 1, size);
            }
            if (z) {
                a aVar2 = this.f4658c;
                if (aVar2 != null) {
                    aVar2.b(e(i));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int e(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = -1;
        for (int i3 = 0; i3 <= i; i3++) {
            if (this.f4656a.get(i3).d()) {
                i2++;
            }
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public int f(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = this.f4656a.get(i3).d() ? 0 : i2 + 1;
        }
        return i2;
    }

    public void a(boolean z) {
        if (z) {
            this.f4656a = a(this.f4657b, this.f4660e);
        } else {
            this.f4656a = a(this.f4657b);
        }
        notifyDataSetChanged();
    }

    private List<com.b.a.a.a<P, C>> a(List<P> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.b.a.a.b bVar = (com.b.a.a.b) list.get(i);
            a(arrayList, bVar, bVar.isInitiallyExpanded());
        }
        return arrayList;
    }

    private List<com.b.a.a.a<P, C>> a(List<P> list, Map<P, Boolean> map) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.b.a.a.b bVar = (com.b.a.a.b) list.get(i);
            Boolean bool = map.get(bVar);
            a(arrayList, bVar, bool == null ? bVar.isInitiallyExpanded() : bool.booleanValue());
        }
        return arrayList;
    }

    private void a(List<com.b.a.a.a<P, C>> list, P p, boolean z) {
        com.b.a.a.a aVar = new com.b.a.a.a(p);
        list.add(aVar);
        if (z) {
            a(list, aVar);
        }
    }

    private void a(List<com.b.a.a.a<P, C>> list, com.b.a.a.a<P, C> aVar) {
        aVar.a(true);
        List<com.b.a.a.a<P, C>> e2 = aVar.e();
        int size = e2.size();
        for (int i = 0; i < size; i++) {
            list.add(e2.get(i));
        }
    }
}
