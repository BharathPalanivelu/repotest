package com.beetalklib.network.file.b;

import java.util.ArrayList;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f5571a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<com.beetalklib.network.file.a.a> f5572b = new ArrayList<>();

    public static a a() {
        if (f5571a == null) {
            synchronized (a.class) {
                if (f5571a == null) {
                    f5571a = new a();
                }
            }
        }
        return f5571a;
    }

    private a() {
    }

    public void a(com.beetalklib.network.file.a.a aVar) {
        this.f5572b.add(aVar);
    }

    public void b(com.beetalklib.network.file.a.a aVar) {
        this.f5572b.remove(aVar);
    }
}
