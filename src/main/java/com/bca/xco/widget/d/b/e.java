package com.bca.xco.widget.d.b;

import com.litesuits.orm.db.assit.SQLBuilder;
import com.path.android.jobqueue.JobManager;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.io.IOException;
import java.io.InterruptedIOException;

public class e extends s {

    /* renamed from: a  reason: collision with root package name */
    private static e f5203a;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5204c;

    /* renamed from: d  reason: collision with root package name */
    private e f5205d;

    /* renamed from: e  reason: collision with root package name */
    private long f5206e;

    /* access modifiers changed from: protected */
    public void a() {
    }

    public final void c() {
        if (!this.f5204c) {
            long c_ = c_();
            boolean d_ = d_();
            if (c_ != 0 || d_) {
                this.f5204c = true;
                a(this, c_, d_);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    private static synchronized void a(e eVar, long j, boolean z) {
        synchronized (e.class) {
            if (f5203a == null) {
                f5203a = new e();
                new a().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                eVar.f5206e = Math.min(j, eVar.e_() - nanoTime) + nanoTime;
            } else if (j != 0) {
                eVar.f5206e = j + nanoTime;
            } else if (z) {
                eVar.f5206e = eVar.e_();
            } else {
                throw new AssertionError();
            }
            long b2 = eVar.b(nanoTime);
            e eVar2 = f5203a;
            while (true) {
                if (eVar2.f5205d == null) {
                    break;
                } else if (b2 < eVar2.f5205d.b(nanoTime)) {
                    break;
                } else {
                    eVar2 = eVar2.f5205d;
                }
            }
            eVar.f5205d = eVar2.f5205d;
            eVar2.f5205d = eVar;
            if (eVar2 == f5203a) {
                e.class.notify();
            }
        }
    }

    public final boolean d() {
        if (!this.f5204c) {
            return false;
        }
        this.f5204c = false;
        return a(this);
    }

    private static synchronized boolean a(e eVar) {
        synchronized (e.class) {
            for (e eVar2 = f5203a; eVar2 != null; eVar2 = eVar2.f5205d) {
                if (eVar2.f5205d == eVar) {
                    eVar2.f5205d = eVar.f5205d;
                    eVar.f5205d = null;
                    return false;
                }
            }
            return true;
        }
    }

    private long b(long j) {
        return this.f5206e - j;
    }

    public final c a(final c cVar) {
        return new c() {
            public void a_(g gVar, long j) {
                t.a(gVar.f5215b, 0, j);
                while (true) {
                    long j2 = 0;
                    if (j > 0) {
                        p pVar = gVar.f5214a;
                        while (true) {
                            if (j2 >= IjkMediaMeta.AV_CH_TOP_BACK_CENTER) {
                                break;
                            }
                            j2 += (long) (gVar.f5214a.f5246c - gVar.f5214a.f5245b);
                            if (j2 >= j) {
                                j2 = j;
                                break;
                            }
                            pVar = pVar.f5249f;
                        }
                        e.this.c();
                        try {
                            cVar.a_(gVar, j2);
                            j -= j2;
                            e.this.a(true);
                        } catch (IOException e2) {
                            throw e.this.b(e2);
                        } catch (Throwable th) {
                            e.this.a(false);
                            throw th;
                        }
                    } else {
                        return;
                    }
                }
            }

            public void flush() {
                e.this.c();
                try {
                    cVar.flush();
                    e.this.a(true);
                } catch (IOException e2) {
                    throw e.this.b(e2);
                } catch (Throwable th) {
                    e.this.a(false);
                    throw th;
                }
            }

            public void close() {
                e.this.c();
                try {
                    cVar.close();
                    e.this.a(true);
                } catch (IOException e2) {
                    throw e.this.b(e2);
                } catch (Throwable th) {
                    e.this.a(false);
                    throw th;
                }
            }

            public s a() {
                return e.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + cVar + SQLBuilder.PARENTHESES_RIGHT;
            }
        };
    }

    public final d a(final d dVar) {
        return new d() {
            public long a(g gVar, long j) {
                e.this.c();
                try {
                    long a2 = dVar.a(gVar, j);
                    e.this.a(true);
                    return a2;
                } catch (IOException e2) {
                    throw e.this.b(e2);
                } catch (Throwable th) {
                    e.this.a(false);
                    throw th;
                }
            }

            public void close() {
                try {
                    dVar.close();
                    e.this.a(true);
                } catch (IOException e2) {
                    throw e.this.b(e2);
                } catch (Throwable th) {
                    e.this.a(false);
                    throw th;
                }
            }

            public s a() {
                return e.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + dVar + SQLBuilder.PARENTHESES_RIGHT;
            }
        };
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        if (d() && z) {
            throw a((IOException) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final IOException b(IOException iOException) {
        if (!d()) {
            return iOException;
        }
        return a(iOException);
    }

    /* access modifiers changed from: protected */
    public IOException a(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    private static final class a extends Thread {
        public a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:0|1|(2:3|6)(2:4|7)|5) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:5:0x0000, LOOP_START, MTH_ENTER_BLOCK, SYNTHETIC, Splitter:B:0:0x0000] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r1 = this;
            L_0x0000:
                com.bca.xco.widget.d.b.e r0 = com.bca.xco.widget.d.b.e.b_()     // Catch:{ InterruptedException -> 0x0000 }
                if (r0 != 0) goto L_0x0007
                goto L_0x0000
            L_0x0007:
                r0.a()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.d.b.e.a.run():void");
        }
    }

    static synchronized e b_() {
        synchronized (e.class) {
            e eVar = f5203a.f5205d;
            if (eVar == null) {
                e.class.wait();
                return null;
            }
            long b2 = eVar.b(System.nanoTime());
            if (b2 > 0) {
                long j = b2 / JobManager.NS_PER_MS;
                Long.signum(j);
                e.class.wait(j, (int) (b2 - (JobManager.NS_PER_MS * j)));
                return null;
            }
            f5203a.f5205d = eVar.f5205d;
            eVar.f5205d = null;
            return eVar;
        }
    }
}
