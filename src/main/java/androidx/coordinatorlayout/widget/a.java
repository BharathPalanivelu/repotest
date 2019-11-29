package androidx.coordinatorlayout.widget;

import androidx.b.g;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Pools.a<ArrayList<T>> f1507a = new Pools.SimplePool(10);

    /* renamed from: b  reason: collision with root package name */
    private final g<T, ArrayList<T>> f1508b = new g<>();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<T> f1509c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<T> f1510d = new HashSet<>();

    public void a(T t) {
        if (!this.f1508b.containsKey(t)) {
            this.f1508b.put(t, null);
        }
    }

    public boolean b(T t) {
        return this.f1508b.containsKey(t);
    }

    public void a(T t, T t2) {
        if (!this.f1508b.containsKey(t) || !this.f1508b.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayList = this.f1508b.get(t);
        if (arrayList == null) {
            arrayList = c();
            this.f1508b.put(t, arrayList);
        }
        arrayList.add(t2);
    }

    public List c(T t) {
        return this.f1508b.get(t);
    }

    public List<T> d(T t) {
        int size = this.f1508b.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ArrayList c2 = this.f1508b.c(i);
            if (c2 != null && c2.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f1508b.b(i));
            }
        }
        return arrayList;
    }

    public boolean e(T t) {
        int size = this.f1508b.size();
        for (int i = 0; i < size; i++) {
            ArrayList c2 = this.f1508b.c(i);
            if (c2 != null && c2.contains(t)) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        int size = this.f1508b.size();
        for (int i = 0; i < size; i++) {
            ArrayList c2 = this.f1508b.c(i);
            if (c2 != null) {
                a(c2);
            }
        }
        this.f1508b.clear();
    }

    public ArrayList<T> b() {
        this.f1509c.clear();
        this.f1510d.clear();
        int size = this.f1508b.size();
        for (int i = 0; i < size; i++) {
            a(this.f1508b.b(i), this.f1509c, this.f1510d);
        }
        return this.f1509c;
    }

    private void a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (!hashSet.contains(t)) {
                hashSet.add(t);
                ArrayList arrayList2 = this.f1508b.get(t);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i = 0; i < size; i++) {
                        a(arrayList2.get(i), arrayList, hashSet);
                    }
                }
                hashSet.remove(t);
                arrayList.add(t);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }

    private ArrayList<T> c() {
        ArrayList<T> acquire = this.f1507a.acquire();
        return acquire == null ? new ArrayList<>() : acquire;
    }

    private void a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f1507a.release(arrayList);
    }
}
