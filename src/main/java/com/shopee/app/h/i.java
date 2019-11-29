package com.shopee.app.h;

import java.util.HashMap;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private static i f17662a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<Integer, a> f17663b = new HashMap<>();

    public static synchronized i a() {
        i iVar;
        synchronized (i.class) {
            if (f17662a == null) {
                f17662a = new i();
            }
            iVar = f17662a;
        }
        return iVar;
    }

    public a a(int i) {
        a aVar = this.f17663b.get(Integer.valueOf(i));
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        this.f17663b.put(Integer.valueOf(i), aVar2);
        return aVar2;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f17664a;

        /* renamed from: b  reason: collision with root package name */
        public long f17665b;

        private a() {
            this.f17664a = 0;
            this.f17665b = 0;
        }

        public boolean a() {
            return this.f17665b != -1;
        }
    }
}
