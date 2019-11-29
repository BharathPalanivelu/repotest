package com.bca.xco.widget.d.a.a.d;

import com.bca.xco.widget.d.a.a.e.a;
import com.bca.xco.widget.d.a.a.e.b;
import com.bca.xco.widget.d.a.s;
import com.bca.xco.widget.d.a.v;
import com.bca.xco.widget.d.b.g;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final e f4856a = a();

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f4857b = Logger.getLogger(s.class.getName());

    public String a(SSLSocket sSLSocket) {
        return null;
    }

    public void a(SSLSocket sSLSocket, String str, List<v> list) {
    }

    public boolean a(String str) {
        return true;
    }

    public void b(SSLSocket sSLSocket) {
    }

    public static e b() {
        return f4856a;
    }

    public X509TrustManager a(SSLSocketFactory sSLSocketFactory) {
        try {
            Object a2 = a((Object) sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (a2 == null) {
                return null;
            }
            return (X509TrustManager) a((Object) a2, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        socket.connect(inetSocketAddress, i);
    }

    public void a(int i, String str, Throwable th) {
        f4857b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public static List<String> a(List<v> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            v vVar = list.get(i);
            if (vVar != v.HTTP_1_0) {
                arrayList.add(vVar.toString());
            }
        }
        return arrayList;
    }

    public b a(X509TrustManager x509TrustManager) {
        return new a(com.bca.xco.widget.d.a.a.e.e.a(x509TrustManager));
    }

    private static e a() {
        e a2 = a.a();
        if (a2 != null) {
            return a2;
        }
        b a3 = b.a();
        if (a3 != null) {
            return a3;
        }
        e a4 = c.a();
        if (a4 != null) {
            return a4;
        }
        return new e();
    }

    static byte[] b(List<v> list) {
        g gVar = new g();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            v vVar = list.get(i);
            if (vVar != v.HTTP_1_0) {
                gVar.a(vVar.toString().length());
                gVar.a(vVar.toString());
            }
        }
        return gVar.k();
    }

    static <T> T a(Object obj, Class<T> cls, String str) {
        Class cls2 = obj.getClass();
        while (cls2 != Object.class) {
            try {
                Field declaredField = cls2.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (obj2 != null) {
                    if (cls.isInstance(obj2)) {
                        return cls.cast(obj2);
                    }
                }
                return null;
            } catch (NoSuchFieldException unused) {
                cls2 = cls2.getSuperclass();
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        }
        if (!str.equals("delegate")) {
            Object a2 = a(obj, Object.class, "delegate");
            if (a2 != null) {
                return a(a2, cls, str);
            }
        }
        return null;
    }
}
