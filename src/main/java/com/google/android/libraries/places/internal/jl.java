package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.kv;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class jl extends kv<jl, a> implements mc {

    /* renamed from: b  reason: collision with root package name */
    public static final jl f12831b = new jl();

    /* renamed from: c  reason: collision with root package name */
    private static volatile mj<jl> f12832c;

    /* renamed from: a  reason: collision with root package name */
    public lc<String> f12833a = mn.f12974b;

    public static final class a extends kv.a<jl, a> implements mc {
        a() {
            super(jl.f12831b);
        }

        public final a a(Iterable<String> iterable) {
            b();
            jl jlVar = (jl) this.f12904a;
            if (!jlVar.f12833a.a()) {
                jlVar.f12833a = kv.a(jlVar.f12833a);
            }
            lc<String> lcVar = jlVar.f12833a;
            kx.a(iterable);
            if (iterable instanceof ll) {
                List<?> d2 = ((ll) iterable).d();
                ll llVar = (ll) lcVar;
                int size = lcVar.size();
                for (Object next : d2) {
                    if (next == null) {
                        StringBuilder sb = new StringBuilder(37);
                        sb.append("Element at index ");
                        sb.append(llVar.size() - size);
                        sb.append(" is null.");
                        String sb2 = sb.toString();
                        for (int size2 = llVar.size() - 1; size2 >= size; size2--) {
                            llVar.remove(size2);
                        }
                        throw new NullPointerException(sb2);
                    } else if (next instanceof kc) {
                        llVar.a((kc) next);
                    } else {
                        llVar.add((String) next);
                    }
                }
            } else if (iterable instanceof mk) {
                lcVar.addAll((Collection) iterable);
            } else {
                if ((lcVar instanceof ArrayList) && (iterable instanceof Collection)) {
                    ((ArrayList) lcVar).ensureCapacity(lcVar.size() + ((Collection) iterable).size());
                }
                int size3 = lcVar.size();
                for (String next2 : iterable) {
                    if (next2 == null) {
                        StringBuilder sb3 = new StringBuilder(37);
                        sb3.append("Element at index ");
                        sb3.append(lcVar.size() - size3);
                        sb3.append(" is null.");
                        String sb4 = sb3.toString();
                        for (int size4 = lcVar.size() - 1; size4 >= size3; size4--) {
                            lcVar.remove(size4);
                        }
                        throw new NullPointerException(sb4);
                    }
                    lcVar.add(next2);
                }
            }
            return this;
        }
    }

    private jl() {
    }

    public static a a() {
        return (a) f12831b.f();
    }

    /* access modifiers changed from: protected */
    public final Object a(kv.d dVar, Object obj) {
        switch (dVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return a((ma) f12831b, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"a"});
            case 3:
                return new jl();
            case 4:
                return new a();
            case 5:
                return f12831b;
            case 6:
                mj<jl> mjVar = f12832c;
                if (mjVar == null) {
                    synchronized (jl.class) {
                        mjVar = f12832c;
                        if (mjVar == null) {
                            mjVar = new jx<>(f12831b);
                            f12832c = mjVar;
                        }
                    }
                }
                return mjVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        kv.a(jl.class, f12831b);
    }
}
