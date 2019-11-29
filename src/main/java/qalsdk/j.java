package qalsdk;

import android.os.SystemClock;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.qalsdk.base.CloseConnReason;
import com.tencent.qalsdk.core.c;
import com.tencent.qalsdk.sdk.MsfCommand;
import com.tencent.qalsdk.sdk.MsfSdkUtils;
import com.tencent.qalsdk.util.MsfSocketInputBuffer;
import com.tencent.qalsdk.util.QLog;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<String> f34148a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    f f34149b;

    /* renamed from: c  reason: collision with root package name */
    MsfSocketInputBuffer f34150c = null;

    /* renamed from: d  reason: collision with root package name */
    AtomicLong f34151d = new AtomicLong();

    /* renamed from: e  reason: collision with root package name */
    AtomicBoolean f34152e = new AtomicBoolean();

    /* renamed from: f  reason: collision with root package name */
    AtomicBoolean f34153f = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    AtomicBoolean f34154g = new AtomicBoolean(true);
    private Socket h;
    private c i;
    private InetSocketAddress j;
    private c k;
    private OutputStream l = null;
    private a m;
    private AtomicLong n = new AtomicLong();
    private long o = 0;
    private AtomicBoolean p = new AtomicBoolean();
    private ReentrantLock q = new ReentrantLock();
    private boolean r;
    private boolean s;
    private com.tencent.qalsdk.core.j t;
    private String u = "";
    private AtomicInteger v = new AtomicInteger();

    public j(com.tencent.qalsdk.core.j jVar, boolean z, boolean z2) {
        this.t = jVar;
        this.r = true;
        this.s = z2;
    }

    private static String a(Throwable th) {
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public final synchronized String a() {
        return this.u;
    }

    private synchronized void a(String str) {
        this.u = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:146:0x048f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0490, code lost:
        r2 = false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x03b6 A[Catch:{ InterruptedException -> 0x048f }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x03cc A[Catch:{ InterruptedException -> 0x048f }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0437 A[Catch:{ InterruptedException -> 0x048f }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0475  */
    /* JADX WARNING: Removed duplicated region for block: B:151:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0254 A[Catch:{ all -> 0x046b }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0265 A[Catch:{ all -> 0x046b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.qalsdk.core.c r21, int r22, int r23, qalsdk.f r24, boolean r25, qalsdk.d r26) {
        /*
            r20 = this;
            r1 = r20
            r2 = r21
            r3 = r26
            java.lang.String r4 = " configTimeout: "
            java.lang.String r5 = ":"
            java.lang.String r6 = "MSF.C.NetConnTag"
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.p
            boolean r0 = r0.get()
            r7 = 0
            if (r0 != 0) goto L_0x001d
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.f34152e
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x002f
        L_0x001d:
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.p
            boolean r0 = r0.get()
            if (r0 == 0) goto L_0x002f
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.p
            r0.set(r7)
            com.tencent.qalsdk.base.CloseConnReason r0 = com.tencent.qalsdk.base.CloseConnReason.closeLastOpened
            r1.a((com.tencent.qalsdk.base.CloseConnReason) r0)
        L_0x002f:
            r1.k = r2
            r0 = r24
            r1.f34149b = r0
            qalsdk.m r8 = qalsdk.m.connStarting
            java.lang.String r9 = ""
            r10 = 0
            r1.o = r10
            r12 = 1
            java.util.concurrent.locks.ReentrantLock r0 = r1.q     // Catch:{ InterruptedException -> 0x048f }
            r13 = 3000(0xbb8, double:1.482E-320)
            java.util.concurrent.TimeUnit r15 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x048f }
            boolean r0 = r0.tryLock(r13, r15)     // Catch:{ InterruptedException -> 0x048f }
            if (r0 == 0) goto L_0x048e
            long r13 = android.os.SystemClock.elapsedRealtime()     // Catch:{ InterruptedException -> 0x048f }
            long r15 = java.lang.System.currentTimeMillis()     // Catch:{ InterruptedException -> 0x048f }
            java.lang.System.currentTimeMillis()     // Catch:{ InterruptedException -> 0x048f }
            java.net.InetSocketAddress r0 = new java.net.InetSocketAddress     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            java.lang.String r10 = r21.c()     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            int r11 = r21.d()     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            r0.<init>(r10, r11)     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            r1.j = r0     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            r0.<init>()     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            java.util.concurrent.atomic.AtomicBoolean r10 = r1.f34154g     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            r10.set(r7)     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            java.lang.String r10 = "try open Conn "
            r0.append(r10)     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            java.net.InetSocketAddress r10 = r1.j     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            r0.append(r10)     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            java.lang.String r10 = r0.toString()     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            com.tencent.qalsdk.util.QLog.i(r6, r12, r10)     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            long r15 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            java.net.Socket r10 = new java.net.Socket     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            r10.<init>()     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            r1.h = r10     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            java.net.Socket r10 = r1.h     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            r11 = 30000(0x7530, float:4.2039E-41)
            r10.setSoTimeout(r11)     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            java.net.Socket r10 = r1.h     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            r10.setTcpNoDelay(r12)     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            java.net.Socket r10 = r1.h     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            r10.setKeepAlive(r12)     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            java.net.Socket r10 = r1.h     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            java.net.InetSocketAddress r11 = r1.j     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            int r7 = r21.e()     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            r10.connect(r11, r7)     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            r3.f34128c = r12     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            int r7 = r3.i     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            int r7 = r7 + r12
            r3.i = r7     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            r1.o = r10     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            long r10 = r1.o     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            long r10 = r10 - r15
            com.tencent.qalsdk.core.j r7 = r1.t     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            com.tencent.qalsdk.core.n r7 = r7.f32187c     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            qalsdk.k r7 = r7.k     // Catch:{ Throwable -> 0x022f, all -> 0x0228 }
            r17 = r13
            long r12 = r7.f34162f     // Catch:{ Throwable -> 0x0224, all -> 0x021f }
            long r12 = r12 + r10
            r7.f34162f = r12     // Catch:{ Throwable -> 0x0224, all -> 0x021f }
            r12 = 0
            int r7 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r7 >= 0) goto L_0x00ca
            r10 = r12
        L_0x00ca:
            long r12 = r1.o     // Catch:{ Throwable -> 0x0224, all -> 0x021f }
            com.tencent.qalsdk.core.n.f32215g = r12     // Catch:{ Throwable -> 0x0224, all -> 0x021f }
            java.util.concurrent.atomic.AtomicLong r7 = r1.n     // Catch:{ Throwable -> 0x0224, all -> 0x021f }
            r12 = 0
            r7.set(r12)     // Catch:{ Throwable -> 0x0224, all -> 0x021f }
            java.util.concurrent.atomic.AtomicLong r7 = r1.f34151d     // Catch:{ Throwable -> 0x0224, all -> 0x021f }
            r7.set(r12)     // Catch:{ Throwable -> 0x0224, all -> 0x021f }
            java.net.Socket r7 = r1.h     // Catch:{ Throwable -> 0x0224, all -> 0x021f }
            java.io.OutputStream r7 = r7.getOutputStream()     // Catch:{ Throwable -> 0x0224, all -> 0x021f }
            r1.l = r7     // Catch:{ Throwable -> 0x0224, all -> 0x021f }
            java.util.ArrayList<java.lang.String> r7 = f34148a     // Catch:{ Throwable -> 0x0224, all -> 0x021f }
            java.io.OutputStream r12 = r1.l     // Catch:{ Throwable -> 0x0224, all -> 0x021f }
            java.lang.String r12 = r12.toString()     // Catch:{ Throwable -> 0x0224, all -> 0x021f }
            boolean r7 = r7.contains(r12)     // Catch:{ Throwable -> 0x0224, all -> 0x021f }
            if (r7 != 0) goto L_0x00ff
            java.util.ArrayList<java.lang.String> r7 = f34148a     // Catch:{ Throwable -> 0x00fc }
            java.io.OutputStream r12 = r1.l     // Catch:{ Throwable -> 0x00fc }
            java.lang.String r12 = r12.toString()     // Catch:{ Throwable -> 0x00fc }
            r7.add(r12)     // Catch:{ Throwable -> 0x00fc }
            goto L_0x00ff
        L_0x00fc:
            r0 = move-exception
            goto L_0x0234
        L_0x00ff:
            com.tencent.qalsdk.util.MsfSocketInputBuffer r7 = new com.tencent.qalsdk.util.MsfSocketInputBuffer     // Catch:{ Throwable -> 0x0224, all -> 0x021f }
            java.net.Socket r12 = r1.h     // Catch:{ Throwable -> 0x0224, all -> 0x021f }
            r13 = 2048(0x800, float:2.87E-42)
            java.lang.String r14 = "US-ASCII"
            r19 = r8
            r8 = -1
            r7.<init>(r12, r13, r14, r8)     // Catch:{ Throwable -> 0x021b, all -> 0x0216 }
            r1.f34150c = r7     // Catch:{ Throwable -> 0x021b, all -> 0x0216 }
            qalsdk.j$a r7 = new qalsdk.j$a     // Catch:{ Throwable -> 0x021b, all -> 0x0216 }
            r7.<init>()     // Catch:{ Throwable -> 0x021b, all -> 0x0216 }
            r1.m = r7     // Catch:{ Throwable -> 0x021b, all -> 0x0216 }
            qalsdk.j$a r7 = r1.m     // Catch:{ Throwable -> 0x021b, all -> 0x0216 }
            java.lang.String r8 = "MsfCoreSocketReader"
            r7.setName(r8)     // Catch:{ Throwable -> 0x021b, all -> 0x0216 }
            qalsdk.j$a r7 = r1.m     // Catch:{ Throwable -> 0x021b, all -> 0x0216 }
            r7.start()     // Catch:{ Throwable -> 0x021b, all -> 0x0216 }
            java.util.concurrent.atomic.AtomicBoolean r7 = r1.f34152e     // Catch:{ Throwable -> 0x021b, all -> 0x0216 }
            r8 = 1
            r7.set(r8)     // Catch:{ Throwable -> 0x021b, all -> 0x0216 }
            java.util.concurrent.atomic.AtomicBoolean r7 = r1.f34153f     // Catch:{ Throwable -> 0x021b, all -> 0x0216 }
            r8 = 0
            r7.set(r8)     // Catch:{ Throwable -> 0x021b, all -> 0x0216 }
            qalsdk.m r8 = qalsdk.m.connSucc     // Catch:{ Throwable -> 0x021b, all -> 0x0216 }
            java.lang.String r9 = "conSucc"
            r1.i = r2     // Catch:{ Throwable -> 0x00fc }
            com.tencent.qalsdk.core.n.a()     // Catch:{ Throwable -> 0x00fc }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00fc }
            r7.<init>()     // Catch:{ Throwable -> 0x00fc }
            com.tencent.qalsdk.core.c r12 = r1.i     // Catch:{ Throwable -> 0x00fc }
            java.lang.String r12 = r12.c()     // Catch:{ Throwable -> 0x00fc }
            r7.append(r12)     // Catch:{ Throwable -> 0x00fc }
            r7.append(r5)     // Catch:{ Throwable -> 0x00fc }
            com.tencent.qalsdk.core.c r12 = r1.i     // Catch:{ Throwable -> 0x00fc }
            int r12 = r12.d()     // Catch:{ Throwable -> 0x00fc }
            r7.append(r12)     // Catch:{ Throwable -> 0x00fc }
            java.lang.String r7 = r7.toString()     // Catch:{ Throwable -> 0x00fc }
            com.tencent.qalsdk.core.n.f32211c = r7     // Catch:{ Throwable -> 0x00fc }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00fc }
            r7.<init>()     // Catch:{ Throwable -> 0x00fc }
            java.net.Socket r12 = r1.h     // Catch:{ Throwable -> 0x00fc }
            java.net.SocketAddress r12 = r12.getLocalSocketAddress()     // Catch:{ Throwable -> 0x00fc }
            r7.append(r12)     // Catch:{ Throwable -> 0x00fc }
            java.lang.String r12 = "|"
            r7.append(r12)     // Catch:{ Throwable -> 0x00fc }
            java.net.Socket r12 = r1.h     // Catch:{ Throwable -> 0x00fc }
            int r12 = r12.getLocalPort()     // Catch:{ Throwable -> 0x00fc }
            r7.append(r12)     // Catch:{ Throwable -> 0x00fc }
            java.lang.String r7 = r7.toString()     // Catch:{ Throwable -> 0x00fc }
            com.tencent.qalsdk.core.n.f32212d = r7     // Catch:{ Throwable -> 0x00fc }
            boolean r7 = com.tencent.qalsdk.core.m.d()     // Catch:{ Throwable -> 0x00fc }
            if (r7 == 0) goto L_0x0183
            r7 = 1
            com.tencent.qalsdk.core.n.f32213e = r7     // Catch:{ Throwable -> 0x00fc }
            goto L_0x0191
        L_0x0183:
            boolean r7 = com.tencent.qalsdk.core.m.e()     // Catch:{ Throwable -> 0x00fc }
            if (r7 == 0) goto L_0x0191
            int r7 = com.tencent.qalsdk.core.m.g()     // Catch:{ Throwable -> 0x00fc }
            int r7 = r7 + 100
            com.tencent.qalsdk.core.n.f32213e = r7     // Catch:{ Throwable -> 0x00fc }
        L_0x0191:
            com.tencent.qalsdk.core.c r7 = r1.i     // Catch:{ Throwable -> 0x00fc }
            r7.f()     // Catch:{ Throwable -> 0x00fc }
            int r7 = r0.length()     // Catch:{ Throwable -> 0x00fc }
            r12 = 0
            r0.delete(r12, r7)     // Catch:{ Throwable -> 0x00fc }
            java.lang.String r7 = r21.c()     // Catch:{ Throwable -> 0x00fc }
            r1.a((java.lang.String) r7)     // Catch:{ Throwable -> 0x00fc }
            java.net.Socket r7 = r1.h     // Catch:{ Throwable -> 0x00fc }
            r7.getPort()     // Catch:{ Throwable -> 0x00fc }
            java.lang.String r7 = "open conn at "
            r0.append(r7)     // Catch:{ Throwable -> 0x00fc }
            java.net.InetSocketAddress r7 = r1.j     // Catch:{ Throwable -> 0x00fc }
            r0.append(r7)     // Catch:{ Throwable -> 0x00fc }
            java.lang.String r7 = " costTime:"
            r0.append(r7)     // Catch:{ Throwable -> 0x00fc }
            r0.append(r10)     // Catch:{ Throwable -> 0x00fc }
            r0.append(r4)     // Catch:{ Throwable -> 0x00fc }
            int r7 = r21.e()     // Catch:{ Throwable -> 0x00fc }
            r0.append(r7)     // Catch:{ Throwable -> 0x00fc }
            java.lang.String r7 = " localSocket:"
            r0.append(r7)     // Catch:{ Throwable -> 0x00fc }
            java.net.Socket r7 = r1.h     // Catch:{ Throwable -> 0x00fc }
            java.net.InetAddress r7 = r7.getLocalAddress()     // Catch:{ Throwable -> 0x00fc }
            java.lang.String r7 = r7.getHostAddress()     // Catch:{ Throwable -> 0x00fc }
            r0.append(r7)     // Catch:{ Throwable -> 0x00fc }
            r0.append(r5)     // Catch:{ Throwable -> 0x00fc }
            java.net.Socket r7 = r1.h     // Catch:{ Throwable -> 0x00fc }
            int r7 = r7.getLocalPort()     // Catch:{ Throwable -> 0x00fc }
            r0.append(r7)     // Catch:{ Throwable -> 0x00fc }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x00fc }
            r7 = 1
            com.tencent.qalsdk.util.QLog.i(r6, r7, r0)     // Catch:{ Throwable -> 0x00fc }
            java.util.concurrent.atomic.AtomicBoolean r0 = com.tencent.qalsdk.core.n.h     // Catch:{ Throwable -> 0x00fc }
            r7 = 0
            r0.set(r7)     // Catch:{ Throwable -> 0x00fc }
            java.util.concurrent.atomic.AtomicInteger r0 = r1.v     // Catch:{ Throwable -> 0x00fc }
            r0.set(r7)     // Catch:{ Throwable -> 0x00fc }
            java.util.concurrent.locks.ReentrantLock r0 = r1.q     // Catch:{ InterruptedException -> 0x048f }
            r0.unlock()     // Catch:{ InterruptedException -> 0x048f }
            qalsdk.m r0 = qalsdk.m.connSucc     // Catch:{ InterruptedException -> 0x048f }
            if (r8 == r0) goto L_0x0208
            r3.f34128c = r7     // Catch:{ InterruptedException -> 0x048f }
            int r0 = r3.j     // Catch:{ InterruptedException -> 0x048f }
            r7 = 1
            int r0 = r0 + r7
            r3.j = r0     // Catch:{ InterruptedException -> 0x048f }
        L_0x0208:
            r3.f34129d = r8     // Catch:{ InterruptedException -> 0x048f }
            r3.f34130e = r9     // Catch:{ InterruptedException -> 0x048f }
            long r12 = android.os.SystemClock.elapsedRealtime()     // Catch:{ InterruptedException -> 0x048f }
        L_0x0210:
            long r12 = r12 - r17
            r3.f34126a = r12     // Catch:{ InterruptedException -> 0x048f }
            goto L_0x03c8
        L_0x0216:
            r0 = move-exception
            r8 = r19
            goto L_0x046c
        L_0x021b:
            r0 = move-exception
            r8 = r19
            goto L_0x0234
        L_0x021f:
            r0 = move-exception
            r19 = r8
            goto L_0x046c
        L_0x0224:
            r0 = move-exception
            r19 = r8
            goto L_0x0234
        L_0x0228:
            r0 = move-exception
            r19 = r8
            r17 = r13
            goto L_0x046c
        L_0x022f:
            r0 = move-exception
            r19 = r8
            r17 = r13
        L_0x0234:
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x046b }
            long r10 = r10 - r15
            com.tencent.qalsdk.core.j r7 = r1.t     // Catch:{ all -> 0x046b }
            com.tencent.qalsdk.core.n r7 = r7.f32187c     // Catch:{ all -> 0x046b }
            qalsdk.k r7 = r7.k     // Catch:{ all -> 0x046b }
            long r12 = r7.f34162f     // Catch:{ all -> 0x046b }
            long r12 = r12 + r10
            r7.f34162f = r12     // Catch:{ all -> 0x046b }
            java.lang.String r7 = r0.toString()     // Catch:{ all -> 0x046b }
            java.lang.String r9 = r7.toLowerCase()     // Catch:{ all -> 0x046b }
            int r7 = com.tencent.qalsdk.core.m.j()     // Catch:{ all -> 0x046b }
            r12 = 5000(0x1388, float:7.006E-42)
            if (r7 != 0) goto L_0x0265
            qalsdk.m r8 = qalsdk.m.connError_unreachable     // Catch:{ all -> 0x046b }
            java.lang.String r9 = r8.toString()     // Catch:{ all -> 0x046b }
            r3.f34132g = r12     // Catch:{ all -> 0x046b }
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.f34153f     // Catch:{ all -> 0x046b }
            r7 = 1
            r0.set(r7)     // Catch:{ all -> 0x046b }
        L_0x0262:
            r7 = 0
            goto L_0x03ad
        L_0x0265:
            java.lang.String r7 = "illegal"
            int r7 = r9.indexOf(r7)     // Catch:{ all -> 0x046b }
            if (r7 < 0) goto L_0x027a
            qalsdk.m r8 = qalsdk.m.connError_illegalargument     // Catch:{ all -> 0x046b }
            java.lang.String r9 = r8.toString()     // Catch:{ all -> 0x046b }
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.f34153f     // Catch:{ all -> 0x046b }
            r7 = 0
            r0.set(r7)     // Catch:{ all -> 0x046b }
            goto L_0x0262
        L_0x027a:
            java.lang.String r7 = "route to host"
            int r7 = r9.indexOf(r7)     // Catch:{ all -> 0x046b }
            if (r7 < 0) goto L_0x028f
            qalsdk.m r8 = qalsdk.m.connError_noroute     // Catch:{ all -> 0x046b }
            java.lang.String r9 = r8.toString()     // Catch:{ all -> 0x046b }
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.f34153f     // Catch:{ all -> 0x046b }
            r7 = 1
            r0.set(r7)     // Catch:{ all -> 0x046b }
            goto L_0x0262
        L_0x028f:
            java.lang.String r7 = "unreachable"
            int r7 = r9.indexOf(r7)     // Catch:{ all -> 0x046b }
            if (r7 < 0) goto L_0x02a6
            qalsdk.m r8 = qalsdk.m.connError_unreachable     // Catch:{ all -> 0x046b }
            java.lang.String r9 = r8.toString()     // Catch:{ all -> 0x046b }
            r3.f34132g = r12     // Catch:{ all -> 0x046b }
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.f34153f     // Catch:{ all -> 0x046b }
            r7 = 1
            r0.set(r7)     // Catch:{ all -> 0x046b }
            goto L_0x0262
        L_0x02a6:
            java.lang.String r7 = "permission"
            int r7 = r9.indexOf(r7)     // Catch:{ all -> 0x046b }
            if (r7 < 0) goto L_0x02bb
            qalsdk.m r8 = qalsdk.m.connError_permission     // Catch:{ all -> 0x046b }
            java.lang.String r9 = r8.toString()     // Catch:{ all -> 0x046b }
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.f34153f     // Catch:{ all -> 0x046b }
            r7 = 1
            r0.set(r7)     // Catch:{ all -> 0x046b }
            goto L_0x0262
        L_0x02bb:
            java.lang.String r7 = "refused"
            int r7 = r9.indexOf(r7)     // Catch:{ all -> 0x046b }
            if (r7 < 0) goto L_0x02d0
            qalsdk.m r8 = qalsdk.m.connError_refused     // Catch:{ all -> 0x046b }
            java.lang.String r9 = r8.toString()     // Catch:{ all -> 0x046b }
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.f34153f     // Catch:{ all -> 0x046b }
            r7 = 0
            r0.set(r7)     // Catch:{ all -> 0x046b }
            goto L_0x0262
        L_0x02d0:
            java.lang.String r7 = "reset"
            int r7 = r9.indexOf(r7)     // Catch:{ all -> 0x046b }
            if (r7 < 0) goto L_0x02e6
            qalsdk.m r8 = qalsdk.m.connError_reset     // Catch:{ all -> 0x046b }
            java.lang.String r9 = r8.toString()     // Catch:{ all -> 0x046b }
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.f34153f     // Catch:{ all -> 0x046b }
            r7 = 0
            r0.set(r7)     // Catch:{ all -> 0x046b }
            goto L_0x0262
        L_0x02e6:
            java.lang.String r7 = "timeoutexception"
            int r7 = r9.indexOf(r7)     // Catch:{ all -> 0x046b }
            if (r7 >= 0) goto L_0x03a1
            java.lang.String r7 = ") after"
            int r7 = r9.indexOf(r7)     // Catch:{ all -> 0x046b }
            if (r7 < 0) goto L_0x02f8
            goto L_0x03a1
        L_0x02f8:
            java.lang.String r7 = "unknownhost"
            int r7 = r9.indexOf(r7)     // Catch:{ all -> 0x046b }
            if (r7 < 0) goto L_0x030e
            qalsdk.m r8 = qalsdk.m.connError_unknownhost     // Catch:{ all -> 0x046b }
            java.lang.String r9 = r8.toString()     // Catch:{ all -> 0x046b }
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.f34153f     // Catch:{ all -> 0x046b }
            r7 = 1
            r0.set(r7)     // Catch:{ all -> 0x046b }
            goto L_0x0262
        L_0x030e:
            java.lang.String r7 = "unresolved"
            int r7 = r9.indexOf(r7)     // Catch:{ all -> 0x046b }
            if (r7 < 0) goto L_0x0324
            qalsdk.m r8 = qalsdk.m.connError_unresolved     // Catch:{ all -> 0x046b }
            java.lang.String r9 = r8.toString()     // Catch:{ all -> 0x046b }
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.f34153f     // Catch:{ all -> 0x046b }
            r7 = 1
            r0.set(r7)     // Catch:{ all -> 0x046b }
            goto L_0x0262
        L_0x0324:
            java.lang.String r7 = "enotsock"
            int r7 = r9.indexOf(r7)     // Catch:{ all -> 0x046b }
            if (r7 < 0) goto L_0x033a
            qalsdk.m r8 = qalsdk.m.connError_enotsock     // Catch:{ all -> 0x046b }
            java.lang.String r9 = r8.toString()     // Catch:{ all -> 0x046b }
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.f34153f     // Catch:{ all -> 0x046b }
            r7 = 0
            r0.set(r7)     // Catch:{ all -> 0x046b }
            goto L_0x0262
        L_0x033a:
            java.lang.String r7 = "enobufs"
            int r7 = r9.indexOf(r7)     // Catch:{ all -> 0x046b }
            if (r7 < 0) goto L_0x0350
            qalsdk.m r8 = qalsdk.m.connError_enobufs     // Catch:{ all -> 0x046b }
            java.lang.String r9 = r8.toString()     // Catch:{ all -> 0x046b }
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.f34153f     // Catch:{ all -> 0x046b }
            r7 = 0
            r0.set(r7)     // Catch:{ all -> 0x046b }
            goto L_0x0262
        L_0x0350:
            java.lang.String r7 = "ebadf"
            int r7 = r9.indexOf(r7)     // Catch:{ all -> 0x046b }
            if (r7 < 0) goto L_0x0366
            qalsdk.m r8 = qalsdk.m.connError_ebadFileNum     // Catch:{ all -> 0x046b }
            java.lang.String r9 = r8.toString()     // Catch:{ all -> 0x046b }
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.f34153f     // Catch:{ all -> 0x046b }
            r7 = 0
            r0.set(r7)     // Catch:{ all -> 0x046b }
            goto L_0x0262
        L_0x0366:
            java.lang.String r7 = "operation"
            int r7 = r9.indexOf(r7)     // Catch:{ all -> 0x046b }
            if (r7 < 0) goto L_0x037c
            qalsdk.m r8 = qalsdk.m.connError_timeout     // Catch:{ all -> 0x046b }
            java.lang.String r9 = r8.toString()     // Catch:{ all -> 0x046b }
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.f34153f     // Catch:{ all -> 0x046b }
            r7 = 0
            r0.set(r7)     // Catch:{ all -> 0x046b }
            goto L_0x0262
        L_0x037c:
            java.lang.String r7 = "invalid"
            int r7 = r9.indexOf(r7)     // Catch:{ all -> 0x046b }
            if (r7 < 0) goto L_0x038c
            qalsdk.m r8 = qalsdk.m.connError_invalidArgument     // Catch:{ all -> 0x046b }
            java.lang.String r9 = r8.toString()     // Catch:{ all -> 0x046b }
            goto L_0x0262
        L_0x038c:
            qalsdk.m r8 = qalsdk.m.connError_unknown     // Catch:{ all -> 0x046b }
            java.lang.String r9 = a((java.lang.Throwable) r0)     // Catch:{ all -> 0x046b }
            int r0 = r9.length()     // Catch:{ all -> 0x046b }
            r7 = 200(0xc8, float:2.8E-43)
            if (r0 <= r7) goto L_0x0262
            r12 = 0
            java.lang.String r9 = r9.substring(r12, r7)     // Catch:{ all -> 0x046b }
            goto L_0x0262
        L_0x03a1:
            qalsdk.m r8 = qalsdk.m.connError_timeout     // Catch:{ all -> 0x046b }
            java.lang.String r9 = r8.toString()     // Catch:{ all -> 0x046b }
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.f34153f     // Catch:{ all -> 0x046b }
            r7 = 0
            r0.set(r7)     // Catch:{ all -> 0x046b }
        L_0x03ad:
            java.util.concurrent.locks.ReentrantLock r0 = r1.q     // Catch:{ InterruptedException -> 0x048f }
            r0.unlock()     // Catch:{ InterruptedException -> 0x048f }
            qalsdk.m r0 = qalsdk.m.connSucc     // Catch:{ InterruptedException -> 0x048f }
            if (r8 == r0) goto L_0x03be
            r3.f34128c = r7     // Catch:{ InterruptedException -> 0x048f }
            int r0 = r3.j     // Catch:{ InterruptedException -> 0x048f }
            r7 = 1
            int r0 = r0 + r7
            r3.j = r0     // Catch:{ InterruptedException -> 0x048f }
        L_0x03be:
            r3.f34129d = r8     // Catch:{ InterruptedException -> 0x048f }
            r3.f34130e = r9     // Catch:{ InterruptedException -> 0x048f }
            long r12 = android.os.SystemClock.elapsedRealtime()     // Catch:{ InterruptedException -> 0x048f }
            goto L_0x0210
        L_0x03c8:
            qalsdk.m r0 = qalsdk.m.connSucc     // Catch:{ InterruptedException -> 0x048f }
            if (r8 != r0) goto L_0x0433
            boolean r0 = r1.r     // Catch:{ InterruptedException -> 0x048f }
            if (r0 == 0) goto L_0x0433
            boolean r0 = r1.s     // Catch:{ InterruptedException -> 0x048f }
            if (r0 != 0) goto L_0x0433
            boolean r0 = com.tencent.qalsdk.core.m.b()     // Catch:{ InterruptedException -> 0x048f }
            if (r0 != 0) goto L_0x03de
            r2 = 1
            com.tencent.qalsdk.core.m.a((boolean) r2)     // Catch:{ InterruptedException -> 0x048f }
        L_0x03de:
            com.tencent.qalsdk.core.j r0 = r1.t     // Catch:{ InterruptedException -> 0x048f }
            com.tencent.qalsdk.core.n r0 = r0.f32187c     // Catch:{ InterruptedException -> 0x048f }
            r2 = 0
            r0.b((byte[]) r2)     // Catch:{ InterruptedException -> 0x048f }
            com.tencent.qalsdk.core.j r0 = r1.t     // Catch:{ InterruptedException -> 0x048f }
            com.tencent.qalsdk.core.n r0 = r0.f32187c     // Catch:{ InterruptedException -> 0x048f }
            com.tencent.qalsdk.core.n.e()     // Catch:{ InterruptedException -> 0x048f }
            java.util.concurrent.atomic.AtomicInteger r0 = com.tencent.qalsdk.core.n.f32210b     // Catch:{ InterruptedException -> 0x048f }
            r2 = 0
            r0.set(r2)     // Catch:{ InterruptedException -> 0x047f }
            java.net.Socket r0 = r1.h     // Catch:{ InterruptedException -> 0x048f }
            if (r0 == 0) goto L_0x048e
            com.tencent.qalsdk.core.j r0 = r1.t     // Catch:{ InterruptedException -> 0x048f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x048f }
            r2.<init>()     // Catch:{ InterruptedException -> 0x048f }
            java.net.Socket r4 = r1.h     // Catch:{ InterruptedException -> 0x048f }
            java.net.InetAddress r4 = r4.getLocalAddress()     // Catch:{ InterruptedException -> 0x048f }
            java.lang.String r4 = r4.getHostAddress()     // Catch:{ InterruptedException -> 0x048f }
            r2.append(r4)     // Catch:{ InterruptedException -> 0x048f }
            r2.append(r5)     // Catch:{ InterruptedException -> 0x048f }
            java.net.Socket r4 = r1.h     // Catch:{ InterruptedException -> 0x048f }
            int r4 = r4.getLocalPort()     // Catch:{ InterruptedException -> 0x048f }
            r2.append(r4)     // Catch:{ InterruptedException -> 0x048f }
            java.lang.String r2 = r2.toString()     // Catch:{ InterruptedException -> 0x048f }
            r0.l = r2     // Catch:{ InterruptedException -> 0x048f }
            java.net.InetSocketAddress r0 = r1.j     // Catch:{ InterruptedException -> 0x048f }
            java.lang.String r0 = r0.toString()     // Catch:{ InterruptedException -> 0x048f }
            com.tencent.qalsdk.core.j r2 = r1.t     // Catch:{ InterruptedException -> 0x048f }
            java.lang.String r2 = r2.l     // Catch:{ InterruptedException -> 0x048f }
            com.tencent.qalsdk.core.NetConnInfoCenter.onConnOpened(r0, r2)     // Catch:{ InterruptedException -> 0x048f }
            com.tencent.qalsdk.core.j r0 = r1.t     // Catch:{ InterruptedException -> 0x048f }
            com.tencent.qalsdk.core.n r0 = r0.f32187c     // Catch:{ InterruptedException -> 0x048f }
            r0.h()     // Catch:{ InterruptedException -> 0x048f }
            goto L_0x04bc
        L_0x0433:
            qalsdk.m r0 = qalsdk.m.connSucc     // Catch:{ InterruptedException -> 0x048f }
            if (r8 == r0) goto L_0x048e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x048f }
            r0.<init>()     // Catch:{ InterruptedException -> 0x048f }
            java.lang.String r5 = "open "
            r0.append(r5)     // Catch:{ InterruptedException -> 0x048f }
            java.net.InetSocketAddress r5 = r1.j     // Catch:{ InterruptedException -> 0x048f }
            r0.append(r5)     // Catch:{ InterruptedException -> 0x048f }
            java.lang.String r5 = " failed "
            r0.append(r5)     // Catch:{ InterruptedException -> 0x048f }
            java.lang.String r5 = r3.f34130e     // Catch:{ InterruptedException -> 0x048f }
            r0.append(r5)     // Catch:{ InterruptedException -> 0x048f }
            java.lang.String r5 = " costTime: "
            r0.append(r5)     // Catch:{ InterruptedException -> 0x048f }
            r0.append(r10)     // Catch:{ InterruptedException -> 0x048f }
            r0.append(r4)     // Catch:{ InterruptedException -> 0x048f }
            int r2 = r21.e()     // Catch:{ InterruptedException -> 0x048f }
            r0.append(r2)     // Catch:{ InterruptedException -> 0x048f }
            java.lang.String r0 = r0.toString()     // Catch:{ InterruptedException -> 0x048f }
            r2 = 1
            com.tencent.qalsdk.util.QLog.i(r6, r2, r0)     // Catch:{ InterruptedException -> 0x048f }
            goto L_0x048e
        L_0x046b:
            r0 = move-exception
        L_0x046c:
            java.util.concurrent.locks.ReentrantLock r2 = r1.q     // Catch:{ InterruptedException -> 0x048f }
            r2.unlock()     // Catch:{ InterruptedException -> 0x048f }
            qalsdk.m r2 = qalsdk.m.connSucc     // Catch:{ InterruptedException -> 0x048f }
            if (r8 == r2) goto L_0x0481
            r2 = 0
            r3.f34128c = r2     // Catch:{ InterruptedException -> 0x047f }
            int r2 = r3.j     // Catch:{ InterruptedException -> 0x048f }
            r4 = 1
            int r2 = r2 + r4
            r3.j = r2     // Catch:{ InterruptedException -> 0x048f }
            goto L_0x0481
        L_0x047f:
            r0 = move-exception
            goto L_0x0491
        L_0x0481:
            r3.f34129d = r8     // Catch:{ InterruptedException -> 0x048f }
            r3.f34130e = r9     // Catch:{ InterruptedException -> 0x048f }
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ InterruptedException -> 0x048f }
            long r4 = r4 - r17
            r3.f34126a = r4     // Catch:{ InterruptedException -> 0x048f }
            throw r0     // Catch:{ InterruptedException -> 0x048f }
        L_0x048e:
            return
        L_0x048f:
            r0 = move-exception
            r2 = 0
        L_0x0491:
            r3.f34128c = r2
            int r2 = r3.j
            r4 = 1
            int r2 = r2 + r4
            r3.j = r2
            qalsdk.m r2 = qalsdk.m.interrupted
            r3.f34129d = r2
            java.lang.String r2 = r0.toString()
            r3.f34130e = r2
            r4 = 0
            r3.f34126a = r4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "open conn interrupted:"
            r2.<init>(r3)
            java.lang.String r0 = r0.toString()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.tencent.qalsdk.util.QLog.i(r6, r0)
        L_0x04bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: qalsdk.j.a(com.tencent.qalsdk.core.c, int, int, qalsdk.f, boolean, qalsdk.d):void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0063 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0077 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0085 */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0067 A[SYNTHETIC, Splitter:B:24:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007b A[SYNTHETIC, Splitter:B:29:0x007b] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0094 A[Catch:{ all -> 0x00a1, Throwable -> 0x00ab }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x012d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.qalsdk.base.CloseConnReason r11) {
        /*
            r10 = this;
            java.net.Socket r0 = r10.h
            java.lang.String r1 = "MSF.C.NetConnTag"
            r2 = 1
            if (r0 != 0) goto L_0x0019
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "conn is already closed on "
            r0.<init>(r3)
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            com.tencent.qalsdk.util.QLog.d(r1, r2, r11)
            return
        L_0x0019:
            r3 = 0
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x00d7 }
            java.util.concurrent.locks.ReentrantLock r4 = r10.q     // Catch:{ Throwable -> 0x00d5 }
            r5 = 3000(0xbb8, double:1.482E-320)
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Throwable -> 0x00d5 }
            boolean r4 = r4.tryLock(r5, r7)     // Catch:{ Throwable -> 0x00d5 }
            r5 = 0
            if (r4 == 0) goto L_0x00ad
            java.util.concurrent.atomic.AtomicInteger r4 = r10.v     // Catch:{ all -> 0x00a3 }
            r4.set(r5)     // Catch:{ all -> 0x00a3 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a3 }
            java.lang.String r6 = "begin close socket by "
            r4.<init>(r6)     // Catch:{ all -> 0x00a3 }
            r4.append(r11)     // Catch:{ all -> 0x00a3 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00a3 }
            com.tencent.qalsdk.util.QLog.i(r1, r4)     // Catch:{ all -> 0x00a3 }
            java.util.concurrent.atomic.AtomicBoolean r4 = r10.f34152e     // Catch:{ all -> 0x00a3 }
            boolean r4 = r4.get()     // Catch:{ all -> 0x00a3 }
            qalsdk.j$a r6 = r10.m     // Catch:{ all -> 0x00a1 }
            if (r6 == 0) goto L_0x0052
            qalsdk.j$a r6 = r10.m     // Catch:{ all -> 0x00a1 }
            java.util.concurrent.atomic.AtomicBoolean r6 = r6.f34155a     // Catch:{ all -> 0x00a1 }
            r6.set(r5)     // Catch:{ all -> 0x00a1 }
        L_0x0052:
            java.net.Socket r6 = r10.h     // Catch:{ Throwable -> 0x0063 }
            java.io.InputStream r6 = r6.getInputStream()     // Catch:{ Throwable -> 0x0063 }
            if (r6 == 0) goto L_0x0063
            java.net.Socket r6 = r10.h     // Catch:{ Throwable -> 0x0063 }
            java.io.InputStream r6 = r6.getInputStream()     // Catch:{ Throwable -> 0x0063 }
            r6.close()     // Catch:{ Throwable -> 0x0063 }
        L_0x0063:
            java.io.OutputStream r6 = r10.l     // Catch:{ all -> 0x00a1 }
            if (r6 == 0) goto L_0x0077
            java.util.ArrayList<java.lang.String> r6 = f34148a     // Catch:{ Exception -> 0x0077 }
            java.io.OutputStream r7 = r10.l     // Catch:{ Exception -> 0x0077 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0077 }
            r6.remove(r7)     // Catch:{ Exception -> 0x0077 }
            java.io.OutputStream r6 = r10.l     // Catch:{ Exception -> 0x0077 }
            r6.close()     // Catch:{ Exception -> 0x0077 }
        L_0x0077:
            java.net.Socket r6 = r10.h     // Catch:{ all -> 0x00a1 }
            if (r6 == 0) goto L_0x0085
            java.net.Socket r6 = r10.h     // Catch:{ Throwable -> 0x0085 }
            r6.close()     // Catch:{ Throwable -> 0x0085 }
            java.util.ArrayList<java.lang.String> r6 = f34148a     // Catch:{ Throwable -> 0x0085 }
            r6.clear()     // Catch:{ Throwable -> 0x0085 }
        L_0x0085:
            r10.m = r3     // Catch:{ all -> 0x00a1 }
            r10.h = r3     // Catch:{ all -> 0x00a1 }
            java.util.concurrent.atomic.AtomicBoolean r6 = r10.f34152e     // Catch:{ all -> 0x00a1 }
            r6.set(r5)     // Catch:{ all -> 0x00a1 }
            r10.f34149b = r3     // Catch:{ all -> 0x00a1 }
            com.tencent.qalsdk.base.CloseConnReason r5 = com.tencent.qalsdk.base.CloseConnReason.closeByOnetimeSocket     // Catch:{ all -> 0x00a1 }
            if (r11 == r5) goto L_0x009b
            com.tencent.qalsdk.core.j r5 = r10.t     // Catch:{ all -> 0x00a1 }
            com.tencent.qalsdk.core.n r5 = r5.f32187c     // Catch:{ all -> 0x00a1 }
            r5.b((byte[]) r3)     // Catch:{ all -> 0x00a1 }
        L_0x009b:
            java.util.concurrent.locks.ReentrantLock r5 = r10.q     // Catch:{ Throwable -> 0x00ab }
            r5.unlock()     // Catch:{ Throwable -> 0x00ab }
            goto L_0x00ec
        L_0x00a1:
            r5 = move-exception
            goto L_0x00a5
        L_0x00a3:
            r5 = move-exception
            r4 = 1
        L_0x00a5:
            java.util.concurrent.locks.ReentrantLock r6 = r10.q     // Catch:{ Throwable -> 0x00ab }
            r6.unlock()     // Catch:{ Throwable -> 0x00ab }
            throw r5     // Catch:{ Throwable -> 0x00ab }
        L_0x00ab:
            r5 = move-exception
            goto L_0x00db
        L_0x00ad:
            qalsdk.j$a r4 = r10.m     // Catch:{ Throwable -> 0x00d5 }
            if (r4 == 0) goto L_0x00b8
            qalsdk.j$a r4 = r10.m     // Catch:{ Throwable -> 0x00d5 }
            java.util.concurrent.atomic.AtomicBoolean r4 = r4.f34155a     // Catch:{ Throwable -> 0x00d5 }
            r4.set(r5)     // Catch:{ Throwable -> 0x00d5 }
        L_0x00b8:
            java.lang.String r4 = "can not get lock for closeConn."
            com.tencent.qalsdk.util.QLog.d(r1, r2, r4)     // Catch:{ Throwable -> 0x00d5 }
            java.util.concurrent.atomic.AtomicBoolean r4 = r10.p     // Catch:{ Throwable -> 0x00d5 }
            r4.set(r2)     // Catch:{ Throwable -> 0x00d5 }
            java.util.concurrent.atomic.AtomicInteger r4 = r10.v     // Catch:{ Throwable -> 0x00d5 }
            int r4 = r4.addAndGet(r2)     // Catch:{ Throwable -> 0x00d5 }
            r5 = 10
            if (r4 != r5) goto L_0x00d3
            int r4 = android.os.Process.myPid()     // Catch:{ Throwable -> 0x00d5 }
            android.os.Process.killProcess(r4)     // Catch:{ Throwable -> 0x00d5 }
        L_0x00d3:
            r4 = 1
            goto L_0x00ec
        L_0x00d5:
            r5 = move-exception
            goto L_0x00da
        L_0x00d7:
            r5 = move-exception
            java.lang.String r0 = ""
        L_0x00da:
            r4 = 1
        L_0x00db:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "closeConn Throwable "
            r6.<init>(r7)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            com.tencent.qalsdk.util.QLog.d(r1, r2, r6, r5)
        L_0x00ec:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "close info:"
            r5.<init>(r6)
            java.util.concurrent.atomic.AtomicBoolean r6 = r10.p
            boolean r6 = r6.get()
            r5.append(r6)
            java.lang.String r6 = ":"
            r5.append(r6)
            r5.append(r4)
            r5.append(r6)
            boolean r7 = r10.r
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            com.tencent.qalsdk.util.QLog.d(r1, r5)
            java.util.concurrent.atomic.AtomicBoolean r5 = r10.p
            boolean r5 = r5.get()
            if (r5 != 0) goto L_0x017a
            if (r4 == 0) goto L_0x017a
            boolean r4 = r10.r
            if (r4 == 0) goto L_0x017a
            com.tencent.qalsdk.base.CloseConnReason r4 = com.tencent.qalsdk.base.CloseConnReason.closeByOnetimeSocket
            if (r11 == r4) goto L_0x017a
            long r4 = r10.o
            r7 = 0
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x0138
            r10.o = r7
            com.tencent.qalsdk.core.j r4 = r10.t
            com.tencent.qalsdk.core.n r4 = r4.f32187c
            qalsdk.k r4 = r4.k
            r4.d()
        L_0x0138:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "close "
            r4.<init>(r5)
            r4.append(r0)
            java.lang.String r0 = " by "
            r4.append(r0)
            r4.append(r11)
            java.lang.String r0 = r4.toString()
            com.tencent.qalsdk.util.QLog.d(r1, r2, r0)
            com.tencent.qalsdk.core.j r0 = r10.t
            r0.l = r3
            r10.k = r3
            java.util.concurrent.atomic.AtomicLong r0 = r10.n
            r0.set(r7)
            java.util.concurrent.atomic.AtomicLong r0 = r10.f34151d
            r0.set(r7)
            com.tencent.qalsdk.util.CodecWarpper.onConnClose()     // Catch:{ Exception -> 0x0165 }
            goto L_0x0177
        L_0x0165:
            r0 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "codec onConnClose exception "
            r4.<init>(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            com.tencent.qalsdk.util.QLog.d(r1, r2, r4, r0)
        L_0x0177:
            com.tencent.qalsdk.core.NetConnInfoCenter.onConnClosed(r11)
        L_0x017a:
            com.tencent.qalsdk.core.c r0 = r10.i     // Catch:{ Exception -> 0x019a }
            if (r0 == 0) goto L_0x0191
            com.tencent.qalsdk.core.c r0 = r10.i     // Catch:{ Exception -> 0x019a }
            boolean r11 = r0.a((com.tencent.qalsdk.base.CloseConnReason) r11)     // Catch:{ Exception -> 0x019a }
            if (r11 == 0) goto L_0x0191
            com.tencent.qalsdk.core.j r11 = r10.t     // Catch:{ Exception -> 0x019a }
            qalsdk.c r11 = r11.g()     // Catch:{ Exception -> 0x019a }
            com.tencent.qalsdk.core.c r0 = r10.i     // Catch:{ Exception -> 0x019a }
            r11.a((com.tencent.qalsdk.core.c) r0)     // Catch:{ Exception -> 0x019a }
        L_0x0191:
            r10.i = r3     // Catch:{ Exception -> 0x019a }
            com.tencent.qalsdk.core.n.f32211c = r6     // Catch:{ Exception -> 0x019a }
            java.lang.String r11 = "0"
            com.tencent.qalsdk.core.n.f32212d = r11     // Catch:{ Exception -> 0x019a }
            return
        L_0x019a:
            r11 = move-exception
            r11.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: qalsdk.j.a(com.tencent.qalsdk.base.CloseConnReason):void");
    }

    public final int a(int i2, int i3, int i4, String str, String str2, MsfCommand msfCommand, byte[] bArr) throws IOException {
        if (this.p.get() || !this.f34152e.get() || this.f34149b == null) {
            return -100;
        }
        if (msfCommand != MsfCommand.openConn) {
            byte[] a2 = this.f34149b.a(this.k, str, str2, bArr);
            this.l.write(a2);
            this.l.flush();
            this.n.addAndGet((long) a2.length);
            StringBuilder sb = new StringBuilder();
            if (QLog.isDevelopLevel()) {
                sb.append("netSend appid:");
                sb.append(i2);
                sb.append(" appSeq:");
                sb.append(i3);
                sb.append(" ssoSeq:");
                sb.append(i4);
                sb.append(" uin:");
                sb.append(MsfSdkUtils.getShortUin(str));
                sb.append(" cmd:");
                sb.append(str2);
                sb.append(" len:");
                sb.append(bArr.length);
                QLog.d("MSF.C.NetConnTag", 1, sb.toString());
            } else {
                sb.append("netSend ssoSeq:");
                sb.append(i4);
                sb.append(" appSeq:");
                sb.append(i3);
                sb.append(" uin:");
                sb.append(MsfSdkUtils.getShortUin(str));
                sb.append(" cmd:");
                sb.append(str2);
                sb.append(SQLBuilder.BLANK + (i4 + bArr.length));
                QLog.i("MSF.C.NetConnTag", 1, sb.toString());
            }
        }
        return bArr.length;
    }

    public final long b() {
        return this.o;
    }

    public final f c() {
        return this.f34149b;
    }

    class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        AtomicBoolean f34155a = new AtomicBoolean(true);

        a() {
            SystemClock.elapsedRealtime();
        }

        public final void run() {
            while (this.f34155a.get()) {
                while (!j.this.f34150c.isDataAvailable(30000)) {
                    try {
                        if (!this.f34155a.get()) {
                            return;
                        }
                    } catch (Throwable th) {
                        this.f34155a.set(false);
                        QLog.d("MSF.C.NetConnTag", 1, "read DataError " + th);
                        j.this.a(CloseConnReason.readError);
                    }
                }
                if (this.f34155a.get()) {
                    j.this.f34149b.a(j.this.f34150c);
                    j.this.f34151d.addAndGet((long) j.this.f34150c.getBufferlen());
                    j.this.f34150c.reset();
                } else {
                    return;
                }
            }
        }
    }
}
