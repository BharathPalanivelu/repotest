package com.google.android.exoplayer2.r;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.exoplayer2.s.t;
import com.google.android.exoplayer2.s.v;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class r implements s {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f11368a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b<? extends c> f11369b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public IOException f11370c;

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

    public interface d {
        void g();
    }

    public static final class f extends IOException {
        public f(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public r(String str) {
        this.f11368a = v.a(str);
    }

    public <T extends c> long a(T t, a<T> aVar, int i) {
        Looper myLooper = Looper.myLooper();
        com.google.android.exoplayer2.s.a.b(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new b(myLooper, t, aVar, i, elapsedRealtime).a(0);
        return elapsedRealtime;
    }

    public boolean a() {
        return this.f11369b != null;
    }

    public void b() {
        this.f11369b.a(false);
    }

    public void c() {
        a((d) null);
    }

    public boolean a(d dVar) {
        b<? extends c> bVar = this.f11369b;
        boolean z = true;
        if (bVar != null) {
            bVar.a(true);
            if (dVar != null) {
                this.f11368a.execute(new e(dVar));
            }
        } else if (dVar != null) {
            dVar.g();
            this.f11368a.shutdown();
            return z;
        }
        z = false;
        this.f11368a.shutdown();
        return z;
    }

    public void d() throws IOException {
        a((int) RNCartPanelDataEntity.NULL_VALUE);
    }

    public void a(int i) throws IOException {
        IOException iOException = this.f11370c;
        if (iOException == null) {
            b<? extends c> bVar = this.f11369b;
            if (bVar != null) {
                if (i == Integer.MIN_VALUE) {
                    i = bVar.f11371a;
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
        public final int f11371a;

        /* renamed from: c  reason: collision with root package name */
        private final T f11373c;

        /* renamed from: d  reason: collision with root package name */
        private final a<T> f11374d;

        /* renamed from: e  reason: collision with root package name */
        private final long f11375e;

        /* renamed from: f  reason: collision with root package name */
        private IOException f11376f;

        /* renamed from: g  reason: collision with root package name */
        private int f11377g;
        private volatile Thread h;
        private volatile boolean i;

        public b(Looper looper, T t, a<T> aVar, int i2, long j) {
            super(looper);
            this.f11373c = t;
            this.f11374d = aVar;
            this.f11371a = i2;
            this.f11375e = j;
        }

        public void a(int i2) throws IOException {
            IOException iOException = this.f11376f;
            if (iOException != null && this.f11377g > i2) {
                throw iOException;
            }
        }

        public void a(long j) {
            com.google.android.exoplayer2.s.a.b(r.this.f11369b == null);
            b unused = r.this.f11369b = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                a();
            }
        }

        public void a(boolean z) {
            this.i = z;
            this.f11376f = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.f11373c.a();
                if (this.h != null) {
                    this.h.interrupt();
                }
            }
            if (z) {
                b();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f11374d.a(this.f11373c, elapsedRealtime, elapsedRealtime - this.f11375e, true);
            }
        }

        public void run() {
            try {
                this.h = Thread.currentThread();
                if (!this.f11373c.b()) {
                    t.a("load:" + this.f11373c.getClass().getSimpleName());
                    this.f11373c.c();
                    t.a();
                }
                if (!this.i) {
                    sendEmptyMessage(2);
                }
            } catch (IOException e2) {
                if (!this.i) {
                    obtainMessage(3, e2).sendToTarget();
                }
            } catch (InterruptedException unused) {
                com.google.android.exoplayer2.s.a.b(this.f11373c.b());
                if (!this.i) {
                    sendEmptyMessage(2);
                }
            } catch (Exception e3) {
                Log.e("LoadTask", "Unexpected exception loading stream", e3);
                if (!this.i) {
                    obtainMessage(3, new f(e3)).sendToTarget();
                }
            } catch (OutOfMemoryError e4) {
                Log.e("LoadTask", "OutOfMemory error loading stream", e4);
                if (!this.i) {
                    obtainMessage(3, new f(e4)).sendToTarget();
                }
            } catch (Error e5) {
                Log.e("LoadTask", "Unexpected error loading stream", e5);
                if (!this.i) {
                    obtainMessage(4, e5).sendToTarget();
                }
                throw e5;
            } catch (Throwable th) {
                t.a();
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
                    long j = elapsedRealtime - this.f11375e;
                    if (this.f11373c.b()) {
                        this.f11374d.a(this.f11373c, elapsedRealtime, j, false);
                        return;
                    }
                    int i2 = message.what;
                    int i3 = 1;
                    if (i2 == 1) {
                        this.f11374d.a(this.f11373c, elapsedRealtime, j, false);
                    } else if (i2 == 2) {
                        this.f11374d.a(this.f11373c, elapsedRealtime, j);
                    } else if (i2 == 3) {
                        this.f11376f = (IOException) message.obj;
                        int a2 = this.f11374d.a(this.f11373c, elapsedRealtime, j, this.f11376f);
                        if (a2 == 3) {
                            IOException unused = r.this.f11370c = this.f11376f;
                        } else if (a2 != 2) {
                            if (a2 != 1) {
                                i3 = 1 + this.f11377g;
                            }
                            this.f11377g = i3;
                            a(c());
                        }
                    }
                } else {
                    throw ((Error) message.obj);
                }
            }
        }

        private void a() {
            this.f11376f = null;
            r.this.f11368a.execute(r.this.f11369b);
        }

        private void b() {
            b unused = r.this.f11369b = null;
        }

        private long c() {
            return (long) Math.min((this.f11377g - 1) * 1000, 5000);
        }
    }

    private static final class e extends Handler implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final d f11378a;

        public e(d dVar) {
            this.f11378a = dVar;
        }

        public void run() {
            sendEmptyMessage(0);
        }

        public void handleMessage(Message message) {
            this.f11378a.g();
        }
    }
}
