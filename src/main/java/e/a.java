package e;

import com.litesuits.orm.db.assit.SQLBuilder;
import com.path.android.jobqueue.JobManager;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class a extends w {
    private static final long IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60);
    private static final long IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    static a head;
    private boolean inQueue;
    private a next;
    private long timeoutAt;

    /* access modifiers changed from: protected */
    public void timedOut() {
    }

    public final void enter() {
        if (!this.inQueue) {
            long timeoutNanos = timeoutNanos();
            boolean hasDeadline = hasDeadline();
            if (timeoutNanos != 0 || hasDeadline) {
                this.inQueue = true;
                scheduleTimeout(this, timeoutNanos, hasDeadline);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    private static synchronized void scheduleTimeout(a aVar, long j, boolean z) {
        synchronized (a.class) {
            if (head == null) {
                head = new a();
                new C0500a().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                aVar.timeoutAt = Math.min(j, aVar.deadlineNanoTime() - nanoTime) + nanoTime;
            } else if (j != 0) {
                aVar.timeoutAt = j + nanoTime;
            } else if (z) {
                aVar.timeoutAt = aVar.deadlineNanoTime();
            } else {
                throw new AssertionError();
            }
            long remainingNanos = aVar.remainingNanos(nanoTime);
            a aVar2 = head;
            while (true) {
                if (aVar2.next == null) {
                    break;
                } else if (remainingNanos < aVar2.next.remainingNanos(nanoTime)) {
                    break;
                } else {
                    aVar2 = aVar2.next;
                }
            }
            aVar.next = aVar2.next;
            aVar2.next = aVar;
            if (aVar2 == head) {
                a.class.notify();
            }
        }
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return cancelScheduledTimeout(this);
    }

    private static synchronized boolean cancelScheduledTimeout(a aVar) {
        synchronized (a.class) {
            for (a aVar2 = head; aVar2 != null; aVar2 = aVar2.next) {
                if (aVar2.next == aVar) {
                    aVar2.next = aVar.next;
                    aVar.next = null;
                    return false;
                }
            }
            return true;
        }
    }

    private long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    public final u sink(final u uVar) {
        return new u() {
            public void write(c cVar, long j) throws IOException {
                x.a(cVar.f32725b, 0, j);
                while (true) {
                    long j2 = 0;
                    if (j > 0) {
                        r rVar = cVar.f32724a;
                        while (true) {
                            if (j2 >= IjkMediaMeta.AV_CH_TOP_BACK_CENTER) {
                                break;
                            }
                            j2 += (long) (rVar.f32783c - rVar.f32782b);
                            if (j2 >= j) {
                                j2 = j;
                                break;
                            }
                            rVar = rVar.f32786f;
                        }
                        a.this.enter();
                        try {
                            uVar.write(cVar, j2);
                            j -= j2;
                            a.this.exit(true);
                        } catch (IOException e2) {
                            throw a.this.exit(e2);
                        } catch (Throwable th) {
                            a.this.exit(false);
                            throw th;
                        }
                    } else {
                        return;
                    }
                }
            }

            public void flush() throws IOException {
                a.this.enter();
                try {
                    uVar.flush();
                    a.this.exit(true);
                } catch (IOException e2) {
                    throw a.this.exit(e2);
                } catch (Throwable th) {
                    a.this.exit(false);
                    throw th;
                }
            }

            public void close() throws IOException {
                a.this.enter();
                try {
                    uVar.close();
                    a.this.exit(true);
                } catch (IOException e2) {
                    throw a.this.exit(e2);
                } catch (Throwable th) {
                    a.this.exit(false);
                    throw th;
                }
            }

            public w timeout() {
                return a.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + uVar + SQLBuilder.PARENTHESES_RIGHT;
            }
        };
    }

    public final v source(final v vVar) {
        return new v() {
            public long read(c cVar, long j) throws IOException {
                a.this.enter();
                try {
                    long read = vVar.read(cVar, j);
                    a.this.exit(true);
                    return read;
                } catch (IOException e2) {
                    throw a.this.exit(e2);
                } catch (Throwable th) {
                    a.this.exit(false);
                    throw th;
                }
            }

            public void close() throws IOException {
                try {
                    vVar.close();
                    a.this.exit(true);
                } catch (IOException e2) {
                    throw a.this.exit(e2);
                } catch (Throwable th) {
                    a.this.exit(false);
                    throw th;
                }
            }

            public w timeout() {
                return a.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + vVar + SQLBuilder.PARENTHESES_RIGHT;
            }
        };
    }

    /* access modifiers changed from: package-private */
    public final void exit(boolean z) throws IOException {
        if (exit() && z) {
            throw newTimeoutException((IOException) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final IOException exit(IOException iOException) throws IOException {
        if (!exit()) {
            return iOException;
        }
        return newTimeoutException(iOException);
    }

    /* access modifiers changed from: protected */
    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* renamed from: e.a$a  reason: collision with other inner class name */
    private static final class C0500a extends Thread {
        C0500a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1.timedOut();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<e.a> r0 = e.a.class
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
                e.a r1 = e.a.awaitTimeout()     // Catch:{ all -> 0x0019 }
                if (r1 != 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                goto L_0x0000
            L_0x000b:
                e.a r2 = e.a.head     // Catch:{ all -> 0x0019 }
                if (r1 != r2) goto L_0x0014
                r1 = 0
                e.a.head = r1     // Catch:{ all -> 0x0019 }
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                return
            L_0x0014:
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                r1.timedOut()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x0019:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                goto L_0x001d
            L_0x001c:
                throw r1
            L_0x001d:
                goto L_0x001c
            */
            throw new UnsupportedOperationException("Method not decompiled: e.a.C0500a.run():void");
        }
    }

    static a awaitTimeout() throws InterruptedException {
        a aVar = head.next;
        if (aVar == null) {
            long nanoTime = System.nanoTime();
            a.class.wait(IDLE_TIMEOUT_MILLIS);
            if (head.next != null || System.nanoTime() - nanoTime < IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return head;
        }
        long remainingNanos = aVar.remainingNanos(System.nanoTime());
        if (remainingNanos > 0) {
            long j = remainingNanos / JobManager.NS_PER_MS;
            a.class.wait(j, (int) (remainingNanos - (JobManager.NS_PER_MS * j)));
            return null;
        }
        head.next = aVar.next;
        aVar.next = null;
        return aVar;
    }
}
