package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Iterator;

public final class gn extends hj {

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ hj f12628b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public gn(hj hjVar, hj hjVar2) {
        super(hjVar2, (byte) 0);
        this.f12628b = hjVar;
    }

    public final <A extends Appendable> A a(A a2, Iterator<?> it) throws IOException {
        go.a(a2, (Object) "appendable");
        go.a(it, (Object) "parts");
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (next != null) {
                a2.append(this.f12628b.a((Object) next));
                break;
            }
        }
        while (it.hasNext()) {
            Object next2 = it.next();
            if (next2 != null) {
                a2.append(this.f12628b.f6718a);
                a2.append(this.f12628b.a((Object) next2));
            }
        }
        return a2;
    }

    public final jt a(String str) {
        throw new UnsupportedOperationException("can't use .skipNulls() with maps");
    }
}
