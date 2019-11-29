package com.bca.xco.widget.d.a.a.g;

import com.bca.xco.widget.d.a.a.c;
import com.bca.xco.widget.d.a.a.g.e;
import com.bca.xco.widget.d.b.a;
import com.bca.xco.widget.d.b.g;
import com.tencent.imsdk.TIMGroupManager;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class j implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f5012b = Logger.getLogger(f.class.getName());

    /* renamed from: a  reason: collision with root package name */
    final e.b f5013a = new e.b(this.f5016e);

    /* renamed from: c  reason: collision with root package name */
    private final a f5014c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f5015d;

    /* renamed from: e  reason: collision with root package name */
    private final g f5016e = new g();

    /* renamed from: f  reason: collision with root package name */
    private int f5017f = TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5018g;

    public j(a aVar, boolean z) {
        this.f5014c = aVar;
        this.f5015d = z;
    }

    public synchronized void a() {
        if (this.f5018g) {
            throw new IOException("closed");
        } else if (this.f5015d) {
            if (f5012b.isLoggable(Level.FINE)) {
                f5012b.fine(c.a(">> CONNECTION %s", f.f4933a.c()));
            }
            this.f5014c.a(f.f4933a.f());
            this.f5014c.flush();
        }
    }

    public synchronized void a(m mVar) {
        if (!this.f5018g) {
            this.f5017f = mVar.d(this.f5017f);
            if (mVar.c() != -1) {
                this.f5013a.a(mVar.c());
            }
            a(0, 0, (byte) 4, (byte) 1);
            this.f5014c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i, int i2, List<d> list) {
        if (!this.f5018g) {
            this.f5013a.a(list);
            long m = this.f5016e.m();
            int min = (int) Math.min((long) (this.f5017f - 4), m);
            long j = (long) min;
            a(i, min + 4, (byte) 5, m == j ? (byte) 4 : 0);
            this.f5014c.c(i2 & Integer.MAX_VALUE);
            this.f5014c.a_(this.f5016e, j);
            if (m > j) {
                b(i, m - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void b() {
        if (!this.f5018g) {
            this.f5014c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(boolean z, int i, int i2, List<d> list) {
        if (!this.f5018g) {
            a(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i, c cVar) {
        if (this.f5018g) {
            throw new IOException("closed");
        } else if (cVar.f4909g != -1) {
            a(i, 4, (byte) 3, (byte) 0);
            this.f5014c.c(cVar.f4909g);
            this.f5014c.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int c() {
        return this.f5017f;
    }

    public synchronized void a(boolean z, int i, g gVar, int i2) {
        if (!this.f5018g) {
            byte b2 = 0;
            if (z) {
                b2 = (byte) 1;
            }
            a(i, b2, gVar, i2);
        } else {
            throw new IOException("closed");
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i, byte b2, g gVar, int i2) {
        a(i, i2, (byte) 0, b2);
        if (i2 > 0) {
            this.f5014c.a_(gVar, (long) i2);
        }
    }

    public synchronized void b(m mVar) {
        if (!this.f5018g) {
            int i = 0;
            a(0, mVar.b() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (mVar.a(i)) {
                    this.f5014c.b(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.f5014c.c(mVar.b(i));
                }
                i++;
            }
            this.f5014c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(boolean z, int i, int i2) {
        if (!this.f5018g) {
            a(0, 8, (byte) 6, z ? (byte) 1 : 0);
            this.f5014c.c(i);
            this.f5014c.c(i2);
            this.f5014c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i, c cVar, byte[] bArr) {
        if (this.f5018g) {
            throw new IOException("closed");
        } else if (cVar.f4909g != -1) {
            a(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f5014c.c(i);
            this.f5014c.c(cVar.f4909g);
            if (bArr.length > 0) {
                this.f5014c.a(bArr);
            }
            this.f5014c.flush();
        } else {
            throw f.a("errorCode.httpCode == -1", new Object[0]);
        }
    }

    public synchronized void a(int i, long j) {
        if (this.f5018g) {
            throw new IOException("closed");
        } else if (j == 0 || j > 2147483647L) {
            throw f.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        } else {
            a(i, 4, (byte) 8, (byte) 0);
            this.f5014c.c((int) j);
            this.f5014c.flush();
        }
    }

    public void a(int i, int i2, byte b2, byte b3) {
        if (f5012b.isLoggable(Level.FINE)) {
            f5012b.fine(f.a(false, i, i2, b2, b3));
        }
        int i3 = this.f5017f;
        if (i2 > i3) {
            throw f.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        } else if ((Integer.MIN_VALUE & i) == 0) {
            a(this.f5014c, i2);
            this.f5014c.a((int) b2 & 255);
            this.f5014c.a((int) b3 & 255);
            this.f5014c.c(i & Integer.MAX_VALUE);
        } else {
            throw f.a("reserved bit set: %s", Integer.valueOf(i));
        }
    }

    public synchronized void close() {
        this.f5018g = true;
        this.f5014c.close();
    }

    private static void a(a aVar, int i) {
        aVar.a((i >>> 16) & 255);
        aVar.a((i >>> 8) & 255);
        aVar.a(i & 255);
    }

    private void b(int i, long j) {
        while (j > 0) {
            int min = (int) Math.min((long) this.f5017f, j);
            long j2 = (long) min;
            j -= j2;
            a(i, min, (byte) 9, j == 0 ? (byte) 4 : 0);
            this.f5014c.a_(this.f5016e, j2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z, int i, List<d> list) {
        if (!this.f5018g) {
            this.f5013a.a(list);
            long m = this.f5016e.m();
            int min = (int) Math.min((long) this.f5017f, m);
            long j = (long) min;
            byte b2 = m == j ? (byte) 4 : 0;
            if (z) {
                b2 = (byte) (b2 | 1);
            }
            a(i, min, (byte) 1, b2);
            this.f5014c.a_(this.f5016e, j);
            if (m > j) {
                b(i, m - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
