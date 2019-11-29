package com.google.android.exoplayer2.m;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.exoplayer2.n.t;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class r implements s {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f10817a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b<? extends c> f10818b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public IOException f10819c;

    public interface a<T extends c> {
        int a(T t, long j, long j2, IOException iOException);

        void a(T t, long j, long j2);

        void a(T t, long j, long j2, boolean z);
    }

    public interface c {
        void a();

        boolean b();

        void c() throws IOException, InterruptedException;
    }

    public static final class d extends IOException {
        public d(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public r(String str) {
        this.f10817a = t.a(str);
    }

    public <T extends c> long a(T t, a<T> aVar, int i) {
        Looper myLooper = Looper.myLooper();
        com.google.android.exoplayer2.n.a.b(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new b(myLooper, t, aVar, i, elapsedRealtime).a(0);
        return elapsedRealtime;
    }

    public boolean a() {
        return this.f10818b != null;
    }

    public void b() {
        this.f10818b.a(false);
    }

    public void c() {
        a((Runnable) null);
    }

    public void a(Runnable runnable) {
        b<? extends c> bVar = this.f10818b;
        if (bVar != null) {
            bVar.a(true);
        }
        if (runnable != null) {
            this.f10817a.execute(runnable);
        }
        this.f10817a.shutdown();
    }

    public void d() throws IOException {
        a((int) RNCartPanelDataEntity.NULL_VALUE);
    }

    public void a(int i) throws IOException {
        IOException iOException = this.f10819c;
        if (iOException == null) {
            b<? extends c> bVar = this.f10818b;
            if (bVar != null) {
                if (i == Integer.MIN_VALUE) {
                    i = bVar.f10820a;
                }
                bVar.a(i);
                return;
            }
            return;
        }
        throw iOException;
    }

    @SuppressLint({"HandlerLeak"})
    private final class b<T extends c> extends Handler implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final int f10820a;

        /* renamed from: c  reason: collision with root package name */
        private final T f10822c;

        /* renamed from: d  reason: collision with root package name */
        private final a<T> f10823d;

        /* renamed from: e  reason: collision with root package name */
        private final long f10824e;

        /* renamed from: f  reason: collision with root package name */
        private IOException f10825f;

        /* renamed from: g  reason: collision with root package name */
        private int f10826g;
        private volatile Thread h;
        private volatile boolean i;

        public b(Looper looper, T t, a<T> aVar, int i2, long j) {
            super(looper);
            this.f10822c = t;
            this.f10823d = aVar;
            this.f10820a = i2;
            this.f10824e = j;
        }

        public void a(int i2) throws IOException {
            IOException iOException = this.f10825f;
            if (iOException != null && this.f10826g > i2) {
                throw iOException;
            }
        }

        public void a(long j) {
            com.google.android.exoplayer2.n.a.b(r.this.f10818b == null);
            b unused = r.this.f10818b = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                a();
            }
        }

        public void a(boolean z) {
            this.i = z;
            this.f10825f = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.f10822c.a();
                if (this.h != null) {
                    this.h.interrupt();
                }
            }
            if (z) {
                b();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f10823d.a(this.f10822c, elapsedRealtime, elapsedRealtime - this.f10824e, true);
            }
        }

        public void run() {
            try {
                this.h = Thread.currentThread();
                if (!this.f10822c.b()) {
                    com.google.android.exoplayer2.n.r.a("load:" + this.f10822c.getClass().getSimpleName());
                    this.f10822c.c();
                    com.google.android.exoplayer2.n.r.a();
                }
                if (!this.i) {
                    sendEmptyMessage(2);
                }
            } catch (IOException e2) {
                if (!this.i) {
                    obtainMessage(3, e2).sendToTarget();
                }
            } catch (InterruptedException unused) {
                com.google.android.exoplayer2.n.a.b(this.f10822c.b());
                if (!this.i) {
                    sendEmptyMessage(2);
                }
            } catch (Exception e3) {
                Log.e("LoadTask", "Unexpected exception loading stream", e3);
                if (!this.i) {
                    obtainMessage(3, new d(e3)).sendToTarget();
                }
            } catch (OutOfMemoryError e4) {
                Log.e("LoadTask", "OutOfMemory error loading stream", e4);
                if (!this.i) {
                    obtainMessage(3, new d(e4)).sendToTarget();
                }
            } catch (Error e5) {
                Log.e("LoadTask", "Unexpected error loading stream", e5);
                if (!this.i) {
                    obtainMessage(4, e5).sendToTarget();
                }
                throw e5;
            } catch (Throwable th) {
                com.google.android.exoplayer2.n.r.a();
                throw th;
            }
        }

        public void handleMessage(Message message) {
            if (!this.i) {
                if (message.what == 0) {
                    a();
                } else if (message.what != 4) {
                    b();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j = elapsedRealtime - this.f10824e;
                    if (this.f10822c.b()) {
                        this.f10823d.a(this.f10822c, elapsedRealtime, j, false);
                        return;
                    }
                    int i2 = message.what;
                    int i3 = 1;
                    if (i2 == 1) {
                        this.f10823d.a(this.f10822c, elapsedRealtime, j, false);
                    } else if (i2 == 2) {
                        this.f10823d.a(this.f10822c, elapsedRealtime, j);
                    } else if (i2 == 3) {
                        this.f10825f = (IOException) message.obj;
                        int a2 = this.f10823d.a(this.f10822c, elapsedRealtime, j, this.f10825f);
                        if (a2 == 3) {
                            IOException unused = r.this.f10819c = this.f10825f;
                        } else if (a2 != 2) {
                            if (a2 != 1) {
                                i3 = 1 + this.f10826g;
                            }
                            this.f10826g = i3;
                            a(c());
                        }
                    }
                } else {
                    throw ((Error) message.obj);
                }
            }
        }

        private void a() {
            this.f10825f = null;
            r.this.f10817a.execute(r.this.f10818b);
        }

        private void b() {
            b unused = r.this.f10818b = null;
        }

        private long c() {
            return (long) Math.min((this.f10826g - 1) * 1000, 5000);
        }
    }
}
