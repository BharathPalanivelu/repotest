package com.bca.xco.widget.d.a.a.f;

import com.appsflyer.share.Constants;
import com.bca.xco.widget.d.a.a.a.e;
import com.bca.xco.widget.d.a.a.c;
import com.bca.xco.widget.d.a.aa;
import com.bca.xco.widget.d.a.ab;
import com.bca.xco.widget.d.a.d;
import com.bca.xco.widget.d.a.g;
import com.bca.xco.widget.d.a.h;
import com.bca.xco.widget.d.a.s;
import com.bca.xco.widget.d.a.t;
import com.bca.xco.widget.d.a.x;
import com.bca.xco.widget.d.a.y;
import com.bca.xco.widget.d.a.z;
import com.salesforce.android.chat.core.internal.liveagent.response.message.FileTransferMessage;
import com.tencent.imsdk.protocol.im_common;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public final class k implements g {

    /* renamed from: a  reason: collision with root package name */
    private final s f4884a;

    /* renamed from: b  reason: collision with root package name */
    private com.bca.xco.widget.d.a.a.a.g f4885b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4886c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f4887d;

    public k(s sVar) {
        this.f4884a = sVar;
    }

    public boolean a() {
        return this.f4887d;
    }

    public boolean b() {
        return this.f4886c;
    }

    public z a(g.a aVar) {
        x a2 = aVar.a();
        this.f4885b = new com.bca.xco.widget.d.a.a.a.g(this.f4884a.o(), a(a2.a()));
        z zVar = null;
        int i = 0;
        while (!this.f4887d) {
            try {
                z a3 = ((h) aVar).a(a2, this.f4885b, (a) null, (d) null);
                if (zVar != null) {
                    a3 = a3.f().c(zVar.f().a((aa) null).a()).a();
                }
                zVar = a3;
                a2 = a(zVar);
                if (a2 == null) {
                    if (!this.f4886c) {
                        this.f4885b.c();
                    }
                    return zVar;
                }
                c.a((Closeable) zVar.e());
                i++;
                if (i > 20) {
                    this.f4885b.c();
                    throw new ProtocolException("Too many follow-up requests: " + i);
                } else if (a2.d() instanceof b) {
                    throw new HttpRetryException("Cannot retry streamed HTTP body", zVar.b());
                } else if (!a(zVar, a2.a())) {
                    this.f4885b.c();
                    this.f4885b = new com.bca.xco.widget.d.a.a.a.g(this.f4884a.o(), a(a2.a()));
                } else if (this.f4885b.a() != null) {
                    throw new IllegalStateException("Closing the body of " + zVar + " didn't close its backing stream. Bad interceptor?");
                }
            } catch (e e2) {
                if (!a(e2.a(), true, a2)) {
                    throw e2.a();
                }
            } catch (IOException e3) {
                if (!a(e3, false, a2)) {
                    throw e3;
                }
            } catch (Throwable th) {
                this.f4885b.a((IOException) null);
                this.f4885b.c();
                throw th;
            }
        }
        this.f4885b.c();
        throw new IOException(FileTransferMessage.EVENT_TYPE_CANCELLED);
    }

    private h a(t tVar) {
        com.bca.xco.widget.d.a.k kVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (tVar.c()) {
            SSLSocketFactory j = this.f4884a.j();
            hostnameVerifier = this.f4884a.k();
            sSLSocketFactory = j;
            kVar = this.f4884a.l();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            kVar = null;
        }
        return new h(tVar.f(), tVar.g(), this.f4884a.h(), this.f4884a.i(), sSLSocketFactory, hostnameVerifier, kVar, this.f4884a.n(), this.f4884a.d(), this.f4884a.t(), this.f4884a.u(), this.f4884a.e());
    }

    private boolean a(IOException iOException, boolean z, x xVar) {
        this.f4885b.a(iOException);
        if (!this.f4884a.r()) {
            return false;
        }
        if ((z || !(xVar.d() instanceof b)) && a(iOException, z) && this.f4885b.e()) {
            return true;
        }
        return false;
    }

    private boolean a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || !z) {
                return false;
            }
            return true;
        } else if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return true;
        } else {
            return false;
        }
    }

    private x a(z zVar) {
        Proxy proxy;
        if (zVar != null) {
            com.bca.xco.widget.d.a.a.a.c b2 = this.f4885b.b();
            y yVar = null;
            ab a2 = b2 != null ? b2.a() : null;
            int b3 = zVar.b();
            String b4 = zVar.a().b();
            if (b3 == 307 || b3 == 308) {
                if (!b4.equals("GET") && !b4.equals("HEAD")) {
                    return null;
                }
            } else if (b3 == 401) {
                return this.f4884a.m().a(a2, zVar);
            } else {
                if (b3 == 407) {
                    if (a2 != null) {
                        proxy = a2.b();
                    } else {
                        proxy = this.f4884a.d();
                    }
                    if (proxy.type() == Proxy.Type.HTTP) {
                        return this.f4884a.n().a(a2, zVar);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                } else if (b3 != 408) {
                    switch (b3) {
                        case 300:
                        case 301:
                        case 302:
                        case im_common.RICH_STATUS_TMP_MSG /*303*/:
                            break;
                        default:
                            return null;
                    }
                } else if (zVar.a().d() instanceof b) {
                    return null;
                } else {
                    return zVar.a();
                }
            }
            if (!this.f4884a.q()) {
                return null;
            }
            String a3 = zVar.a(Constants.HTTP_REDIRECT_URL_HEADER_FIELD);
            if (a3 == null) {
                return null;
            }
            t c2 = zVar.a().a().c(a3);
            if (c2 == null) {
                return null;
            }
            if (!c2.b().equals(zVar.a().a().b()) && !this.f4884a.p()) {
                return null;
            }
            x.a e2 = zVar.a().e();
            if (g.c(b4)) {
                boolean d2 = g.d(b4);
                if (g.e(b4)) {
                    e2.a("GET", (y) null);
                } else {
                    if (d2) {
                        yVar = zVar.a().d();
                    }
                    e2.a(b4, yVar);
                }
                if (!d2) {
                    e2.b(HttpConstants.Header.TRANSFER_ENCODING);
                    e2.b(HttpConstants.Header.CONTENT_LENGTH);
                    e2.b(HttpConstants.Header.CONTENT_TYPE);
                }
            }
            if (!a(zVar, c2)) {
                e2.b(HttpConstants.Header.AUTHORIZATION);
            }
            return e2.a(c2).b();
        }
        throw new IllegalStateException();
    }

    private boolean a(z zVar, t tVar) {
        t a2 = zVar.a().a();
        return a2.f().equals(tVar.f()) && a2.g() == tVar.g() && a2.b().equals(tVar.b());
    }
}
