package com.google.c;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class av extends AbstractList<String> implements z, RandomAccess {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final z f13688a;

    public z e() {
        return this;
    }

    public av(z zVar) {
        this.f13688a = zVar;
    }

    /* renamed from: a */
    public String get(int i) {
        return (String) this.f13688a.get(i);
    }

    public Object c(int i) {
        return this.f13688a.c(i);
    }

    public int size() {
        return this.f13688a.size();
    }

    public void a(f fVar) {
        throw new UnsupportedOperationException();
    }

    public ListIterator<String> listIterator(final int i) {
        return new ListIterator<String>() {

            /* renamed from: a  reason: collision with root package name */
            ListIterator<String> f13689a = av.this.f13688a.listIterator(i);

            public boolean hasNext() {
                return this.f13689a.hasNext();
            }

            /* renamed from: a */
            public String next() {
                return this.f13689a.next();
            }

            public boolean hasPrevious() {
                return this.f13689a.hasPrevious();
            }

            /* renamed from: b */
            public String previous() {
                return this.f13689a.previous();
            }

            public int nextIndex() {
                return this.f13689a.nextIndex();
            }

            public int previousIndex() {
                return this.f13689a.previousIndex();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            /* renamed from: a */
            public void set(String str) {
                throw new UnsupportedOperationException();
            }

            /* renamed from: b */
            public void add(String str) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public Iterator<String> iterator() {
        return new Iterator<String>() {

            /* renamed from: a  reason: collision with root package name */
            Iterator<String> f13692a = av.this.f13688a.iterator();

            public boolean hasNext() {
                return this.f13692a.hasNext();
            }

            /* renamed from: a */
            public String next() {
                return this.f13692a.next();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public List<?> d() {
        return this.f13688a.d();
    }
}
