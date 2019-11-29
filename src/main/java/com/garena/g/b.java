package com.garena.g;

import com.garena.g.a.a;
import com.garena.g.a.c;
import com.garena.g.a.d;
import com.garena.g.a.e;
import com.garena.g.a.f;
import com.garena.g.a.g;
import com.garena.g.a.h;
import com.garena.g.a.i;
import com.garena.g.a.j;
import com.garena.g.a.k;
import com.garena.g.a.l;
import com.garena.g.a.m;
import com.garena.g.a.n;
import java.util.HashMap;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static i f8002a = new i();

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<String, Boolean> f8003b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static HashMap<Integer, a> f8004c = new HashMap<>();

    public static a a(int i) {
        a aVar = f8004c.get(Integer.valueOf(i));
        if (aVar != null) {
            return aVar;
        }
        throw new c("application not found");
    }

    static {
        f8004c.put(0, new f());
        f8004c.put(1, new c());
        f8004c.put(2, new com.garena.g.a.b());
        f8004c.put(4, new l());
        f8004c.put(11, new m());
        f8004c.put(5, new g());
        f8004c.put(6, new n());
        f8004c.put(7, f8002a);
        f8004c.put(8, new d());
        f8004c.put(9, new e());
        f8004c.put(10, new j());
        f8004c.put(12, new k());
        f8004c.put(13, new h());
    }

    public static void a(String str) {
        f8002a.a(str);
    }
}
