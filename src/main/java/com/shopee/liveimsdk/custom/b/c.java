package com.shopee.liveimsdk.custom.b;

import a.k;
import com.shopee.liveimsdk.custom.b.a.b;
import com.shopee.liveimsdk.custom.b.a.d;
import com.shopee.liveimsdk.custom.b.a.e;
import f.m;
import java.util.concurrent.Callable;

public class c {

    public interface a<T> {
        void a(int i);

        void a(T t);

        void b(int i);
    }

    public static void a(final String str, final String str2, final com.shopee.liveimsdk.custom.b.a.c cVar, final a<d> aVar) {
        k.a(new Callable<Void>() {
            /* renamed from: a */
            public Void call() throws Exception {
                if (str2 != null) {
                    b.a().a(str2);
                }
                try {
                    m<d<b>> a2 = ((com.shopee.liveimsdk.custom.b.b.c) b.a().b().a(com.shopee.liveimsdk.custom.b.b.c.class)).a(str, cVar).a();
                    if (aVar == null) {
                        return null;
                    }
                    if (a2 == null) {
                        aVar.b(-1);
                        return null;
                    }
                    a2.c().toString();
                    if (a2.e() == null) {
                        aVar.b(a2.a());
                        return null;
                    } else if (a2.e().code == 0) {
                        aVar.a(a2.e());
                        return null;
                    } else {
                        aVar.a(a2.e().code);
                        return null;
                    }
                } catch (Exception unused) {
                    com.shopee.liveimsdk.c.b("postJoinRoom exception");
                }
            }
        });
    }

    public static void a(final String str, final com.shopee.liveimsdk.custom.b.a.a aVar, final a<d> aVar2) {
        k.a(new Callable<Void>() {
            /* renamed from: a */
            public Void call() throws Exception {
                try {
                    m<d> a2 = ((com.shopee.liveimsdk.custom.b.b.a) b.a().b().a(com.shopee.liveimsdk.custom.b.b.a.class)).a(str, aVar).a();
                    if (aVar2 == null) {
                        return null;
                    }
                    if (a2 == null) {
                        aVar2.b(-1);
                        return null;
                    } else if (a2.e() == null) {
                        aVar2.b(a2.a());
                        return null;
                    } else if (a2.e().code == 0) {
                        aVar2.a(a2.e());
                        return null;
                    } else {
                        aVar2.a(a2.e().code);
                        return null;
                    }
                } catch (Exception unused) {
                    com.shopee.liveimsdk.c.b("postExitRoom exception");
                }
            }
        });
    }

    public static void a(final String str, final String str2, final e eVar, final a<d> aVar) {
        k.a(new Callable<Void>() {
            /* renamed from: a */
            public Void call() throws Exception {
                com.shopee.liveimsdk.custom.b.b.d dVar = (com.shopee.liveimsdk.custom.b.b.d) b.a().b().a(com.shopee.liveimsdk.custom.b.b.d.class);
                try {
                    if (str2 != null) {
                        b.a().a(str2);
                    }
                    m<d<d>> a2 = dVar.a(str, eVar).a();
                    if (aVar == null) {
                        return null;
                    }
                    if (a2 == null) {
                        aVar.b(-1);
                        return null;
                    } else if (a2.e() == null) {
                        aVar.b(a2.a());
                        return null;
                    } else if (a2.e().code == 0) {
                        aVar.a(a2.e().data);
                        return null;
                    } else {
                        aVar.a(a2.e().code);
                        return null;
                    }
                } catch (Exception unused) {
                    com.shopee.liveimsdk.c.b("sendMessage exception");
                }
            }
        });
    }
}
