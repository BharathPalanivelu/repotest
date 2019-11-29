package com.linecorp.a.a;

import android.os.Build;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public final class a extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f14967a = {"RC4", "DES", "PSK", "_DHE_"};

    /* renamed from: b  reason: collision with root package name */
    private final SSLSocketFactory f14968b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14969c;

    /* renamed from: d  reason: collision with root package name */
    private Class<?> f14970d;

    /* renamed from: e  reason: collision with root package name */
    private Method f14971e;

    public a(SSLSocketFactory sSLSocketFactory) {
        this(sSLSocketFactory, (byte) 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:8:? A[ExcHandler: NoSuchMethodException (unused java.lang.NoSuchMethodException), SYNTHETIC, Splitter:B:5:0x0015] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private a(javax.net.ssl.SSLSocketFactory r4, byte r5) {
        /*
            r3 = this;
            r3.<init>()
            r5 = 1
            r3.f14969c = r5
            r3.f14968b = r4
            r3.f14969c = r5
            java.lang.String r4 = "com.android.org.conscrypt.OpenSSLSocketImpl"
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ ClassNotFoundException -> 0x0013 }
            r3.f14970d = r4     // Catch:{ ClassNotFoundException -> 0x0013 }
            goto L_0x001b
        L_0x0013:
            java.lang.String r4 = "org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl"
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
            r3.f14970d = r4     // Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        L_0x001b:
            java.lang.Class<?> r4 = r3.f14970d     // Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
            java.lang.String r0 = "setHostname"
            java.lang.Class[] r5 = new java.lang.Class[r5]     // Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
            r1 = 0
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            r5[r1] = r2     // Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
            java.lang.reflect.Method r4 = r4.getMethod(r0, r5)     // Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
            r3.f14971e = r4     // Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.linecorp.a.a.a.<init>(javax.net.ssl.SSLSocketFactory, byte):void");
    }

    private void a(Socket socket, String str) {
        if (this.f14970d.isInstance(socket)) {
            Method method = this.f14971e;
            if (method != null) {
                try {
                    method.invoke(socket, new Object[]{str});
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException(e2);
                } catch (IllegalAccessException e3) {
                    throw new RuntimeException(e3);
                }
            }
        }
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) {
        Socket createSocket = this.f14968b.createSocket(socket, str, i, z);
        a(createSocket, str);
        return a(createSocket);
    }

    public final Socket createSocket(String str, int i) {
        Socket createSocket = this.f14968b.createSocket(str, i);
        a(createSocket, str);
        return a(createSocket);
    }

    public final Socket createSocket(InetAddress inetAddress, int i) {
        return a(this.f14968b.createSocket(inetAddress, i));
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return a(this.f14968b.createSocket(inetAddress, i, inetAddress2, i2));
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        Socket createSocket = this.f14968b.createSocket(str, i, inetAddress, i2);
        a(createSocket, str);
        return a(createSocket);
    }

    public final Socket createSocket() {
        return a(this.f14968b.createSocket());
    }

    public final String[] getDefaultCipherSuites() {
        if (this.f14969c) {
            return a(this.f14968b.getDefaultCipherSuites());
        }
        return this.f14968b.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        if (this.f14969c) {
            return a(this.f14968b.getSupportedCipherSuites());
        }
        return this.f14968b.getSupportedCipherSuites();
    }

    private Socket a(Socket socket) {
        if (!(socket instanceof SSLSocket)) {
            return socket;
        }
        SSLSocket sSLSocket = (SSLSocket) socket;
        sSLSocket.setEnabledProtocols(Build.VERSION.SDK_INT < 16 ? new String[]{"TLSv1"} : new String[]{"TLSv1.2"});
        if (this.f14969c) {
            sSLSocket.setEnabledCipherSuites(a(sSLSocket.getEnabledCipherSuites()));
        }
        return new b(sSLSocket, (byte) 0);
    }

    private static String[] a(String[] strArr) {
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        for (String str : strArr) {
            for (String contains : f14967a) {
                if (str.contains(contains)) {
                    arrayList.remove(str);
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static class b extends C0244a {
        /* synthetic */ b(SSLSocket sSLSocket, byte b2) {
            this(sSLSocket);
        }

        private b(SSLSocket sSLSocket) {
            super(sSLSocket);
        }

        public final void setEnabledProtocols(String[] strArr) {
            if (strArr != null && strArr.length == 1 && "SSLv3".equals(strArr[0])) {
                ArrayList arrayList = new ArrayList(Arrays.asList(this.f14972a.getEnabledProtocols()));
                if (arrayList.size() > 1) {
                    arrayList.remove("SSLv3");
                }
                strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            super.setEnabledProtocols(strArr);
        }
    }

    /* renamed from: com.linecorp.a.a.a$a  reason: collision with other inner class name */
    private static class C0244a extends SSLSocket {

        /* renamed from: a  reason: collision with root package name */
        protected final SSLSocket f14972a;

        C0244a(SSLSocket sSLSocket) {
            this.f14972a = sSLSocket;
        }

        public String[] getSupportedCipherSuites() {
            return this.f14972a.getSupportedCipherSuites();
        }

        public String[] getEnabledCipherSuites() {
            return this.f14972a.getEnabledCipherSuites();
        }

        public void setEnabledCipherSuites(String[] strArr) {
            this.f14972a.setEnabledCipherSuites(strArr);
        }

        public String[] getSupportedProtocols() {
            return this.f14972a.getSupportedProtocols();
        }

        public String[] getEnabledProtocols() {
            return this.f14972a.getEnabledProtocols();
        }

        public void setEnabledProtocols(String[] strArr) {
            this.f14972a.setEnabledProtocols(strArr);
        }

        public SSLSession getSession() {
            return this.f14972a.getSession();
        }

        public void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
            this.f14972a.addHandshakeCompletedListener(handshakeCompletedListener);
        }

        public void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
            this.f14972a.removeHandshakeCompletedListener(handshakeCompletedListener);
        }

        public void startHandshake() {
            this.f14972a.startHandshake();
        }

        public void setUseClientMode(boolean z) {
            this.f14972a.setUseClientMode(z);
        }

        public boolean getUseClientMode() {
            return this.f14972a.getUseClientMode();
        }

        public void setNeedClientAuth(boolean z) {
            this.f14972a.setNeedClientAuth(z);
        }

        public void setWantClientAuth(boolean z) {
            this.f14972a.setWantClientAuth(z);
        }

        public boolean getNeedClientAuth() {
            return this.f14972a.getNeedClientAuth();
        }

        public boolean getWantClientAuth() {
            return this.f14972a.getWantClientAuth();
        }

        public void setEnableSessionCreation(boolean z) {
            this.f14972a.setEnableSessionCreation(z);
        }

        public boolean getEnableSessionCreation() {
            return this.f14972a.getEnableSessionCreation();
        }

        public void bind(SocketAddress socketAddress) {
            this.f14972a.bind(socketAddress);
        }

        public synchronized void close() {
            this.f14972a.close();
        }

        public void connect(SocketAddress socketAddress) {
            this.f14972a.connect(socketAddress);
        }

        public void connect(SocketAddress socketAddress, int i) {
            this.f14972a.connect(socketAddress, i);
        }

        public SocketChannel getChannel() {
            return this.f14972a.getChannel();
        }

        public InetAddress getInetAddress() {
            return this.f14972a.getInetAddress();
        }

        public InputStream getInputStream() {
            return this.f14972a.getInputStream();
        }

        public boolean getKeepAlive() {
            return this.f14972a.getKeepAlive();
        }

        public InetAddress getLocalAddress() {
            return this.f14972a.getLocalAddress();
        }

        public int getLocalPort() {
            return this.f14972a.getLocalPort();
        }

        public SocketAddress getLocalSocketAddress() {
            return this.f14972a.getLocalSocketAddress();
        }

        public boolean getOOBInline() {
            return this.f14972a.getOOBInline();
        }

        public OutputStream getOutputStream() {
            return this.f14972a.getOutputStream();
        }

        public int getPort() {
            return this.f14972a.getPort();
        }

        public synchronized int getReceiveBufferSize() {
            return this.f14972a.getReceiveBufferSize();
        }

        public SocketAddress getRemoteSocketAddress() {
            return this.f14972a.getRemoteSocketAddress();
        }

        public boolean getReuseAddress() {
            return this.f14972a.getReuseAddress();
        }

        public synchronized int getSendBufferSize() {
            return this.f14972a.getSendBufferSize();
        }

        public int getSoLinger() {
            return this.f14972a.getSoLinger();
        }

        public synchronized int getSoTimeout() {
            return this.f14972a.getSoTimeout();
        }

        public boolean getTcpNoDelay() {
            return this.f14972a.getTcpNoDelay();
        }

        public int getTrafficClass() {
            return this.f14972a.getTrafficClass();
        }

        public boolean isBound() {
            return this.f14972a.isBound();
        }

        public boolean isClosed() {
            return this.f14972a.isClosed();
        }

        public boolean isConnected() {
            return this.f14972a.isConnected();
        }

        public boolean isInputShutdown() {
            return this.f14972a.isInputShutdown();
        }

        public boolean isOutputShutdown() {
            return this.f14972a.isOutputShutdown();
        }

        public void sendUrgentData(int i) {
            this.f14972a.sendUrgentData(i);
        }

        public void setKeepAlive(boolean z) {
            this.f14972a.setKeepAlive(z);
        }

        public void setOOBInline(boolean z) {
            this.f14972a.setOOBInline(z);
        }

        public void setPerformancePreferences(int i, int i2, int i3) {
            this.f14972a.setPerformancePreferences(i, i2, i3);
        }

        public synchronized void setReceiveBufferSize(int i) {
            this.f14972a.setReceiveBufferSize(i);
        }

        public void setReuseAddress(boolean z) {
            this.f14972a.setReuseAddress(z);
        }

        public synchronized void setSendBufferSize(int i) {
            this.f14972a.setSendBufferSize(i);
        }

        public void setSoLinger(boolean z, int i) {
            this.f14972a.setSoLinger(z, i);
        }

        public synchronized void setSoTimeout(int i) {
            this.f14972a.setSoTimeout(i);
        }

        public void setTcpNoDelay(boolean z) {
            this.f14972a.setTcpNoDelay(z);
        }

        public void setTrafficClass(int i) {
            this.f14972a.setTrafficClass(i);
        }

        public void shutdownInput() {
            this.f14972a.shutdownInput();
        }

        public void shutdownOutput() {
            this.f14972a.shutdownOutput();
        }

        public String toString() {
            return this.f14972a.toString();
        }

        public boolean equals(Object obj) {
            return this.f14972a.equals(obj);
        }
    }
}
