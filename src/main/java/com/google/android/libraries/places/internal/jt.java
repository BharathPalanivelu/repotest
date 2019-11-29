package com.google.android.libraries.places.internal;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class jt {

    /* renamed from: a  reason: collision with root package name */
    public final hj f12855a;

    /* renamed from: b  reason: collision with root package name */
    public final String f12856b;

    public jt(hj hjVar, String str) {
        this.f12855a = hjVar;
        this.f12856b = (String) go.a(str);
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A a(A a2, Iterator<? extends Map.Entry<?, ?>> it) throws IOException {
        go.a(a2);
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            a2.append(this.f12855a.a(entry.getKey()));
            a2.append(this.f12856b);
            a2.append(this.f12855a.a(entry.getValue()));
            while (it.hasNext()) {
                a2.append(this.f12855a.f6718a);
                Map.Entry entry2 = (Map.Entry) it.next();
                a2.append(this.f12855a.a(entry2.getKey()));
                a2.append(this.f12856b);
                a2.append(this.f12855a.a(entry2.getValue()));
            }
        }
        return a2;
    }

    @CanIgnoreReturnValue
    public StringBuilder a(StringBuilder sb, Iterator<? extends Map.Entry<?, ?>> it) {
        try {
            a(sb, it);
            return sb;
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public String a(Map<?, ?> map) {
        return a((Iterable<? extends Map.Entry<?, ?>>) map.entrySet());
    }

    public String a(Iterable<? extends Map.Entry<?, ?>> iterable) {
        return a(iterable.iterator());
    }

    public String a(Iterator<? extends Map.Entry<?, ?>> it) {
        return a(new StringBuilder(), it).toString();
    }

    public /* synthetic */ jt(hj hjVar, String str, byte b2) {
        this(hjVar, str);
    }
}
