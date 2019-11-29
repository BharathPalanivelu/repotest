package com.franmontiel.persistentcookiejar.cache;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import okhttp3.Cookie;

public class SetCookieCache implements CookieCache {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Set<IdentifiableCookie> f7270a = new HashSet();

    public void a(Collection<Cookie> collection) {
        for (IdentifiableCookie next : IdentifiableCookie.a(collection)) {
            this.f7270a.remove(next);
            this.f7270a.add(next);
        }
    }

    public Iterator<Cookie> iterator() {
        return new SetCookieCacheIterator();
    }

    private class SetCookieCacheIterator implements Iterator<Cookie> {

        /* renamed from: b  reason: collision with root package name */
        private Iterator<IdentifiableCookie> f7272b;

        public SetCookieCacheIterator() {
            this.f7272b = SetCookieCache.this.f7270a.iterator();
        }

        public boolean hasNext() {
            return this.f7272b.hasNext();
        }

        /* renamed from: a */
        public Cookie next() {
            return this.f7272b.next().a();
        }

        public void remove() {
            this.f7272b.remove();
        }
    }
}
