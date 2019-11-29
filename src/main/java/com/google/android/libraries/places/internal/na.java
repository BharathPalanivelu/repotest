package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.Map;

final class na implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private int f13001a = -1;

    /* renamed from: b  reason: collision with root package name */
    private boolean f13002b;

    /* renamed from: c  reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f13003c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ ms f13004d;

    na(ms msVar) {
        this.f13004d = msVar;
    }

    public final boolean hasNext() {
        if (this.f13001a + 1 < this.f13004d.f12984a.size() || (!this.f13004d.f12985b.isEmpty() && a().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (this.f13002b) {
            this.f13002b = false;
            this.f13004d.e();
            if (this.f13001a < this.f13004d.f12984a.size()) {
                ms msVar = this.f13004d;
                int i = this.f13001a;
                this.f13001a = i - 1;
                msVar.c(i);
                return;
            }
            a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    private final Iterator<Map.Entry<K, V>> a() {
        if (this.f13003c == null) {
            this.f13003c = this.f13004d.f12985b.entrySet().iterator();
        }
        return this.f13003c;
    }

    public final /* synthetic */ Object next() {
        this.f13002b = true;
        int i = this.f13001a + 1;
        this.f13001a = i;
        if (i < this.f13004d.f12984a.size()) {
            return this.f13004d.f12984a.get(this.f13001a);
        }
        return (Map.Entry) a().next();
    }
}
