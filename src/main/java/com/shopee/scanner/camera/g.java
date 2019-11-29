package com.shopee.scanner.camera;

import androidx.b.a;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

class g {

    /* renamed from: a  reason: collision with root package name */
    private final a<AspectRatio, SortedSet<f>> f30315a = new a<>();

    g() {
    }

    public boolean a(f fVar) {
        for (AspectRatio next : this.f30315a.keySet()) {
            if (next.a(fVar)) {
                SortedSet sortedSet = this.f30315a.get(next);
                if (sortedSet.contains(fVar)) {
                    return false;
                }
                sortedSet.add(fVar);
                return true;
            }
        }
        TreeSet treeSet = new TreeSet();
        treeSet.add(fVar);
        this.f30315a.put(AspectRatio.a(fVar.a(), fVar.b()), treeSet);
        return true;
    }

    public void a(AspectRatio aspectRatio) {
        this.f30315a.remove(aspectRatio);
    }

    /* access modifiers changed from: package-private */
    public Set<AspectRatio> a() {
        return this.f30315a.keySet();
    }

    /* access modifiers changed from: package-private */
    public SortedSet<f> b(AspectRatio aspectRatio) {
        return this.f30315a.get(aspectRatio);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f30315a.clear();
    }
}
