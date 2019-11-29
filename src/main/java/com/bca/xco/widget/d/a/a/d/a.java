package com.bca.xco.widget.d.a.a.d;

import android.util.Log;
import com.bca.xco.widget.d.a.a.c;
import com.bca.xco.widget.d.a.a.e.b;
import com.bca.xco.widget.d.a.v;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

class a extends e {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f4836a;

    /* renamed from: b  reason: collision with root package name */
    private final d<Socket> f4837b;

    /* renamed from: c  reason: collision with root package name */
    private final d<Socket> f4838c;

    /* renamed from: d  reason: collision with root package name */
    private final d<Socket> f4839d;

    /* renamed from: e  reason: collision with root package name */
    private final d<Socket> f4840e;

    public a(Class<?> cls, d<Socket> dVar, d<Socket> dVar2, d<Socket> dVar3, d<Socket> dVar4) {
        this.f4836a = cls;
        this.f4837b = dVar;
        this.f4838c = dVar2;
        this.f4839d = dVar3;
        this.f4840e = dVar4;
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e2) {
            if (c.a(e2)) {
                throw new IOException(e2);
            }
            throw e2;
        } catch (SecurityException e3) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e3);
            throw iOException;
        }
    }

    public X509TrustManager a(SSLSocketFactory sSLSocketFactory) {
        Object a2 = a((Object) sSLSocketFactory, this.f4836a, "sslParameters");
        if (a2 == null) {
            try {
                a2 = a((Object) sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (ClassNotFoundException unused) {
                return super.a(sSLSocketFactory);
            }
        }
        X509TrustManager x509TrustManager = (X509TrustManager) a((Object) a2, X509TrustManager.class, "x509TrustManager");
        if (x509TrustManager != null) {
            return x509TrustManager;
        }
        return (X509TrustManager) a((Object) a2, X509TrustManager.class, "trustManager");
    }

    public void a(SSLSocket sSLSocket, String str, List<v> list) {
        if (str != null) {
            this.f4837b.b(sSLSocket, true);
            this.f4838c.b(sSLSocket, str);
        }
        d<Socket> dVar = this.f4840e;
        if (dVar != null && dVar.a(sSLSocket)) {
            this.f4840e.d(sSLSocket, b(list));
        }
    }

    public String a(SSLSocket sSLSocket) {
        d<Socket> dVar = this.f4839d;
        if (dVar == null || !dVar.a(sSLSocket)) {
            return null;
        }
        byte[] bArr = (byte[]) this.f4839d.d(sSLSocket, new Object[0]);
        if (bArr != null) {
            return new String(bArr, c.f4797c);
        }
        return null;
    }

    public void a(int i, String str, Throwable th) {
        int min;
        int i2 = 5;
        if (i != 5) {
            i2 = 3;
        }
        if (th != null) {
            str = str + 10 + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    public boolean a(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            Object invoke = cls.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(invoke, new Object[]{str})).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.a(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
            throw new AssertionError();
        }
    }

    public b a(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0092a(cls.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class}));
        } catch (Exception unused) {
            return super.a(x509TrustManager);
        }
    }

    public static e a() {
        Class<?> cls;
        d dVar;
        d dVar2;
        try {
            cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        } catch (ClassNotFoundException unused) {
            try {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
        Class<?> cls2 = cls;
        d dVar3 = new d((Class<?>) null, "setUseSessionTickets", Boolean.TYPE);
        d dVar4 = new d((Class<?>) null, "setHostname", String.class);
        try {
            Class.forName("android.net.Network");
            dVar2 = new d(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            try {
                dVar = new d((Class<?>) null, "setAlpnProtocols", byte[].class);
            } catch (ClassNotFoundException unused3) {
                dVar = null;
                return new a(cls2, dVar3, dVar4, dVar2, dVar);
            }
        } catch (ClassNotFoundException unused4) {
            dVar2 = null;
            dVar = null;
            return new a(cls2, dVar3, dVar4, dVar2, dVar);
        }
        return new a(cls2, dVar3, dVar4, dVar2, dVar);
    }

    /* renamed from: com.bca.xco.widget.d.a.a.d.a$a  reason: collision with other inner class name */
    static final class C0092a extends b {

        /* renamed from: a  reason: collision with root package name */
        private final Object f4841a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f4842b;

        C0092a(Object obj, Method method) {
            this.f4841a = obj;
            this.f4842b = method;
        }

        public List<Certificate> a(List<Certificate> list, String str) {
            try {
                return (List) this.f4842b.invoke(this.f4841a, new Object[]{(X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str});
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            }
        }
    }
}
