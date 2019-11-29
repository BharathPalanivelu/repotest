package com.bca.xco.widget.d.a.a.g;

import com.bca.xco.widget.d.a.a.c;
import com.bca.xco.widget.d.a.a.g.e;
import com.bca.xco.widget.d.b.d;
import com.bca.xco.widget.d.b.g;
import com.bca.xco.widget.d.b.h;
import com.bca.xco.widget.d.b.s;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class a implements Closeable {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Logger f4891b = Logger.getLogger(f.class.getName());

    /* renamed from: a  reason: collision with root package name */
    final e.a f4892a = new e.a(4096, this.f4894d);

    /* renamed from: c  reason: collision with root package name */
    private final com.bca.xco.widget.d.b.b f4893c;

    /* renamed from: d  reason: collision with root package name */
    private final b f4894d = new b(this.f4893c);

    /* renamed from: e  reason: collision with root package name */
    private final boolean f4895e;

    /* renamed from: com.bca.xco.widget.d.a.a.g.a$a  reason: collision with other inner class name */
    interface C0093a {
        void a(int i, int i2, int i3, boolean z);

        void a(int i, int i2, List<d> list);

        void a(int i, long j);

        void a(int i, c cVar);

        void a(int i, c cVar, h hVar);

        void a(boolean z, int i, int i2);

        void a(boolean z, int i, int i2, List<d> list);

        void a(boolean z, int i, com.bca.xco.widget.d.b.b bVar, int i2);

        void a(boolean z, m mVar);

        void b();
    }

    public a(com.bca.xco.widget.d.b.b bVar, boolean z) {
        this.f4893c = bVar;
        this.f4895e = z;
    }

    public void a() {
        if (!this.f4895e) {
            h e2 = this.f4893c.e((long) f.f4933a.e());
            if (f4891b.isLoggable(Level.FINE)) {
                f4891b.fine(c.a("<< CONNECTION %s", e2.c()));
            }
            if (!f.f4933a.equals(e2)) {
                throw f.b("Expected a connection header but was %s", e2.a());
            }
        }
    }

    public boolean a(C0093a aVar) {
        try {
            this.f4893c.c(9);
            int a2 = a(this.f4893c);
            if (a2 < 0 || a2 > 16384) {
                throw f.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a2));
            }
            byte e2 = (byte) (this.f4893c.e() & 255);
            byte e3 = (byte) (this.f4893c.e() & 255);
            int h = this.f4893c.h() & Integer.MAX_VALUE;
            if (f4891b.isLoggable(Level.FINE)) {
                f4891b.fine(f.a(true, h, a2, e2, e3));
            }
            switch (e2) {
                case 0:
                    b(aVar, a2, e3, h);
                    break;
                case 1:
                    a(aVar, a2, e3, h);
                    break;
                case 2:
                    c(aVar, a2, e3, h);
                    break;
                case 3:
                    d(aVar, a2, e3, h);
                    break;
                case 4:
                    e(aVar, a2, e3, h);
                    break;
                case 5:
                    f(aVar, a2, e3, h);
                    break;
                case 6:
                    g(aVar, a2, e3, h);
                    break;
                case 7:
                    h(aVar, a2, e3, h);
                    break;
                case 8:
                    i(aVar, a2, e3, h);
                    break;
                default:
                    this.f4893c.d((long) a2);
                    break;
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private void a(C0093a aVar, int i, byte b2, int i2) {
        short s = 0;
        if (i2 != 0) {
            boolean z = (b2 & 1) != 0;
            if ((b2 & 8) != 0) {
                s = (short) (this.f4893c.e() & 255);
            }
            if ((b2 & 32) != 0) {
                a(aVar, i2);
                i -= 5;
            }
            aVar.a(z, i2, -1, a(a(i, b2, s), s, b2, i2));
            return;
        }
        throw f.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    private List<d> a(int i, short s, byte b2, int i2) {
        b bVar = this.f4894d;
        bVar.f4899d = i;
        bVar.f4896a = i;
        bVar.f4900e = s;
        bVar.f4897b = b2;
        bVar.f4898c = i2;
        this.f4892a.a();
        return this.f4892a.b();
    }

    private void b(C0093a aVar, int i, byte b2, int i2) {
        boolean z = true;
        short s = 0;
        boolean z2 = (b2 & 1) != 0;
        if ((b2 & 32) == 0) {
            z = false;
        }
        if (!z) {
            if ((b2 & 8) != 0) {
                s = (short) (this.f4893c.e() & 255);
            }
            aVar.a(z2, i2, this.f4893c, a(i, b2, s));
            this.f4893c.d((long) s);
            return;
        }
        throw f.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
    }

    private void c(C0093a aVar, int i, byte b2, int i2) {
        if (i != 5) {
            throw f.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        } else if (i2 != 0) {
            a(aVar, i2);
        } else {
            throw f.b("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
    }

    private void a(C0093a aVar, int i) {
        int h = this.f4893c.h();
        aVar.a(i, h & Integer.MAX_VALUE, (this.f4893c.e() & 255) + 1, (Integer.MIN_VALUE & h) != 0);
    }

    private void d(C0093a aVar, int i, byte b2, int i2) {
        if (i != 4) {
            throw f.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        } else if (i2 != 0) {
            int h = this.f4893c.h();
            c a2 = c.a(h);
            if (a2 != null) {
                aVar.a(i2, a2);
            } else {
                throw f.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(h));
            }
        } else {
            throw f.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
    }

    private void e(C0093a aVar, int i, byte b2, int i2) {
        if (i2 != 0) {
            throw f.b("TYPE_SETTINGS streamId != 0", new Object[0]);
        } else if ((b2 & 1) != 0) {
            if (i == 0) {
                aVar.b();
                return;
            }
            throw f.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        } else if (i % 6 == 0) {
            m mVar = new m();
            for (int i3 = 0; i3 < i; i3 += 6) {
                short f2 = this.f4893c.f();
                int h = this.f4893c.h();
                switch (f2) {
                    case 2:
                        if (!(h == 0 || h == 1)) {
                            throw f.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                    case 3:
                        f2 = 4;
                        break;
                    case 4:
                        f2 = 7;
                        if (h >= 0) {
                            break;
                        } else {
                            throw f.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                    case 5:
                        if (h >= 16384 && h <= 16777215) {
                            break;
                        } else {
                            throw f.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(h));
                        }
                        break;
                }
                mVar.a(f2, h);
            }
            aVar.a(false, mVar);
        } else {
            throw f.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
    }

    private void f(C0093a aVar, int i, byte b2, int i2) {
        short s = 0;
        if (i2 != 0) {
            if ((b2 & 8) != 0) {
                s = (short) (this.f4893c.e() & 255);
            }
            aVar.a(i2, this.f4893c.h() & Integer.MAX_VALUE, a(a(i - 4, b2, s), s, b2, i2));
            return;
        }
        throw f.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    private void g(C0093a aVar, int i, byte b2, int i2) {
        boolean z = false;
        if (i != 8) {
            throw f.b("TYPE_PING length != 8: %s", Integer.valueOf(i));
        } else if (i2 == 0) {
            int h = this.f4893c.h();
            int h2 = this.f4893c.h();
            if ((b2 & 1) != 0) {
                z = true;
            }
            aVar.a(z, h, h2);
        } else {
            throw f.b("TYPE_PING streamId != 0", new Object[0]);
        }
    }

    private void h(C0093a aVar, int i, byte b2, int i2) {
        if (i < 8) {
            throw f.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        } else if (i2 == 0) {
            int h = this.f4893c.h();
            int h2 = this.f4893c.h();
            int i3 = i - 8;
            c a2 = c.a(h2);
            if (a2 != null) {
                h hVar = h.f5217b;
                if (i3 > 0) {
                    hVar = this.f4893c.e((long) i3);
                }
                aVar.a(h, a2, hVar);
                return;
            }
            throw f.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(h2));
        } else {
            throw f.b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
    }

    private void i(C0093a aVar, int i, byte b2, int i2) {
        if (i == 4) {
            long h = ((long) this.f4893c.h()) & 2147483647L;
            if (h != 0) {
                aVar.a(i2, h);
            } else {
                throw f.b("windowSizeIncrement was 0", Long.valueOf(h));
            }
        } else {
            throw f.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
    }

    public void close() {
        this.f4893c.close();
    }

    static final class b implements d {

        /* renamed from: a  reason: collision with root package name */
        int f4896a;

        /* renamed from: b  reason: collision with root package name */
        byte f4897b;

        /* renamed from: c  reason: collision with root package name */
        int f4898c;

        /* renamed from: d  reason: collision with root package name */
        int f4899d;

        /* renamed from: e  reason: collision with root package name */
        short f4900e;

        /* renamed from: f  reason: collision with root package name */
        private final com.bca.xco.widget.d.b.b f4901f;

        public void close() {
        }

        public b(com.bca.xco.widget.d.b.b bVar) {
            this.f4901f = bVar;
        }

        public long a(g gVar, long j) {
            while (true) {
                int i = this.f4899d;
                if (i == 0) {
                    this.f4901f.d((long) this.f4900e);
                    this.f4900e = 0;
                    if ((this.f4897b & 4) != 0) {
                        return -1;
                    }
                    b();
                } else {
                    long a2 = this.f4901f.a(gVar, Math.min(j, (long) i));
                    if (a2 == -1) {
                        return -1;
                    }
                    this.f4899d = (int) (((long) this.f4899d) - a2);
                    return a2;
                }
            }
        }

        public s a() {
            return this.f4901f.a();
        }

        private void b() {
            int i = this.f4898c;
            int a2 = a.a(this.f4901f);
            this.f4899d = a2;
            this.f4896a = a2;
            byte e2 = (byte) (this.f4901f.e() & 255);
            this.f4897b = (byte) (this.f4901f.e() & 255);
            if (a.f4891b.isLoggable(Level.FINE)) {
                a.f4891b.fine(f.a(true, this.f4898c, this.f4896a, e2, this.f4897b));
            }
            this.f4898c = this.f4901f.h() & Integer.MAX_VALUE;
            if (e2 != 9) {
                throw f.b("%s != TYPE_CONTINUATION", Byte.valueOf(e2));
            } else if (this.f4898c != i) {
                throw f.b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    static int a(com.bca.xco.widget.d.b.b bVar) {
        return (bVar.e() & 255) | ((bVar.e() & 255) << 16) | ((bVar.e() & 255) << 8);
    }

    static int a(int i, byte b2, short s) {
        if ((b2 & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw f.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}
