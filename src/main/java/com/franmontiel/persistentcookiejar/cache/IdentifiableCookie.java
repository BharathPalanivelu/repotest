package com.franmontiel.persistentcookiejar.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import okhttp3.Cookie;

class IdentifiableCookie {

    /* renamed from: a  reason: collision with root package name */
    private Cookie f7269a;

    static List<IdentifiableCookie> a(Collection<Cookie> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Cookie identifiableCookie : collection) {
            arrayList.add(new IdentifiableCookie(identifiableCookie));
        }
        return arrayList;
    }

    IdentifiableCookie(Cookie cookie) {
        this.f7269a = cookie;
    }

    /* access modifiers changed from: package-private */
    public Cookie a() {
        return this.f7269a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IdentifiableCookie)) {
            return false;
        }
        IdentifiableCookie identifiableCookie = (IdentifiableCookie) obj;
        if (!identifiableCookie.f7269a.name().equals(this.f7269a.name()) || !identifiableCookie.f7269a.domain().equals(this.f7269a.domain()) || !identifiableCookie.f7269a.path().equals(this.f7269a.path()) || identifiableCookie.f7269a.secure() != this.f7269a.secure() || identifiableCookie.f7269a.hostOnly() != this.f7269a.hostOnly()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((((527 + this.f7269a.name().hashCode()) * 31) + this.f7269a.domain().hashCode()) * 31) + this.f7269a.path().hashCode()) * 31) + (this.f7269a.secure() ^ true ? 1 : 0)) * 31) + (this.f7269a.hostOnly() ^ true ? 1 : 0);
    }
}
