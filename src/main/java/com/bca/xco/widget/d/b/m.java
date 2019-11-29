package com.bca.xco.widget.d.b;

import com.litesuits.orm.db.assit.SQLBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    static final Logger f5232a = Logger.getLogger(m.class.getName());

    private m() {
    }

    public static b a(d dVar) {
        return new o(dVar);
    }

    public static a a(c cVar) {
        return new n(cVar);
    }

    private static c a(final OutputStream outputStream, final s sVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (sVar != null) {
            return new c() {
                public void a_(g gVar, long j) {
                    t.a(gVar.f5215b, 0, j);
                    while (j > 0) {
                        sVar.g();
                        p pVar = gVar.f5214a;
                        int min = (int) Math.min(j, (long) (pVar.f5246c - pVar.f5245b));
                        outputStream.write(pVar.f5244a, pVar.f5245b, min);
                        pVar.f5245b += min;
                        long j2 = (long) min;
                        j -= j2;
                        gVar.f5215b -= j2;
                        if (pVar.f5245b == pVar.f5246c) {
                            gVar.f5214a = pVar.a();
                            q.a(pVar);
                        }
                    }
                }

                public void flush() {
                    outputStream.flush();
                }

                public void close() {
                    outputStream.close();
                }

                public s a() {
                    return sVar;
                }

                public String toString() {
                    return "sink(" + outputStream + SQLBuilder.PARENTHESES_RIGHT;
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static c a(Socket socket) {
        if (socket != null) {
            e c2 = c(socket);
            return c2.a(a(socket.getOutputStream(), (s) c2));
        }
        throw new IllegalArgumentException("socket == null");
    }

    private static d a(final InputStream inputStream, final s sVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (sVar != null) {
            return new d() {
                public long a(g gVar, long j) {
                    if (j < 0) {
                        throw new IllegalArgumentException("byteCount < 0: " + j);
                    } else if (j == 0) {
                        return 0;
                    } else {
                        try {
                            sVar.g();
                            p h = gVar.h(1);
                            int read = inputStream.read(h.f5244a, h.f5246c, (int) Math.min(j, (long) (8192 - h.f5246c)));
                            if (read == -1) {
                                return -1;
                            }
                            h.f5246c += read;
                            long j2 = (long) read;
                            gVar.f5215b += j2;
                            return j2;
                        } catch (AssertionError e2) {
                            if (m.a(e2)) {
                                throw new IOException(e2);
                            }
                            throw e2;
                        }
                    }
                }

                public void close() {
                    inputStream.close();
                }

                public s a() {
                    return sVar;
                }

                public String toString() {
                    return "source(" + inputStream + SQLBuilder.PARENTHESES_RIGHT;
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static d b(Socket socket) {
        if (socket != null) {
            e c2 = c(socket);
            return c2.a(a(socket.getInputStream(), (s) c2));
        }
        throw new IllegalArgumentException("socket == null");
    }

    private static e c(final Socket socket) {
        return new e() {
            /* access modifiers changed from: protected */
            public IOException a(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            /* access modifiers changed from: protected */
            public void a() {
                try {
                    socket.close();
                } catch (Exception e2) {
                    Logger logger = m.f5232a;
                    Level level = Level.WARNING;
                    logger.log(level, "Failed to close timed out socket " + socket, e2);
                } catch (AssertionError e3) {
                    if (m.a(e3)) {
                        Logger logger2 = m.f5232a;
                        Level level2 = Level.WARNING;
                        logger2.log(level2, "Failed to close timed out socket " + socket, e3);
                        return;
                    }
                    throw e3;
                }
            }
        };
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
