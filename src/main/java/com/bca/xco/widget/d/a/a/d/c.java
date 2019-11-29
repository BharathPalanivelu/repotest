package com.bca.xco.widget.d.a.a.d;

import com.bca.xco.widget.d.a.v;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

class c extends e {

    /* renamed from: a  reason: collision with root package name */
    private final Method f4845a;

    /* renamed from: b  reason: collision with root package name */
    private final Method f4846b;

    /* renamed from: c  reason: collision with root package name */
    private final Method f4847c;

    /* renamed from: d  reason: collision with root package name */
    private final Class<?> f4848d;

    /* renamed from: e  reason: collision with root package name */
    private final Class<?> f4849e;

    public c(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f4845a = method;
        this.f4846b = method2;
        this.f4847c = method3;
        this.f4848d = cls;
        this.f4849e = cls2;
    }

    public void a(SSLSocket sSLSocket, String str, List<v> list) {
        List<String> a2 = a(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(e.class.getClassLoader(), new Class[]{this.f4848d, this.f4849e}, new a(a2));
            this.f4845a.invoke((Object) null, new Object[]{sSLSocket, newProxyInstance});
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new AssertionError(e2);
        }
    }

    public void b(SSLSocket sSLSocket) {
        try {
            this.f4847c.invoke((Object) null, new Object[]{sSLSocket});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            throw new AssertionError();
        }
    }

    public String a(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f4846b.invoke((Object) null, new Object[]{sSLSocket}));
            if (!aVar.f4851b && aVar.f4852c == null) {
                e.b().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (aVar.f4851b) {
                return null;
            } else {
                return aVar.f4852c;
            }
        } catch (IllegalAccessException | InvocationTargetException unused) {
            throw new AssertionError();
        }
    }

    public static e a() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider");
            Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider");
            Method method = cls.getMethod("put", new Class[]{SSLSocket.class, cls2});
            return new c(method, cls.getMethod("get", new Class[]{SSLSocket.class}), cls.getMethod(ProductAction.ACTION_REMOVE, new Class[]{SSLSocket.class}), cls3, cls4);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    private static class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f4850a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f4851b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f4852c;

        public a(List<String> list) {
            this.f4850a = list;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = com.bca.xco.widget.d.a.a.c.f4796b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f4851b = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f4850a;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f4850a.contains(list.get(i))) {
                            String str = (String) list.get(i);
                            this.f4852c = str;
                            return str;
                        }
                    }
                    String str2 = this.f4850a.get(0);
                    this.f4852c = str2;
                    return str2;
                } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.f4852c = (String) objArr[0];
                    return null;
                }
            }
        }
    }
}
