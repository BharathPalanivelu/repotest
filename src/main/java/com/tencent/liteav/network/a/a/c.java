package com.tencent.liteav.network.a.a;

import com.tencent.liteav.network.a.a;
import com.tencent.liteav.network.a.b;
import com.tencent.liteav.network.a.d;
import com.tencent.liteav.network.a.e;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Random;

public final class c implements com.tencent.liteav.network.a.c {

    /* renamed from: b  reason: collision with root package name */
    private static final Random f31728b = new Random();

    /* renamed from: a  reason: collision with root package name */
    final InetAddress f31729a;

    /* renamed from: c  reason: collision with root package name */
    private final int f31730c;

    public c(InetAddress inetAddress) {
        this(inetAddress, 10);
    }

    public c(InetAddress inetAddress, int i) {
        this.f31729a = inetAddress;
        this.f31730c = i;
    }

    public e[] a(b bVar, d dVar) throws IOException {
        int nextInt;
        synchronized (f31728b) {
            nextInt = f31728b.nextInt() & 255;
        }
        byte[] a2 = a(b.a(bVar.f31731a, nextInt));
        if (a2 != null) {
            return b.a(a2, nextInt, bVar.f31731a);
        }
        throw new a(bVar.f31731a, "cant get answer");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(byte[] r6) throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            java.net.DatagramSocket r1 = new java.net.DatagramSocket     // Catch:{ all -> 0x0030 }
            r1.<init>()     // Catch:{ all -> 0x0030 }
            java.net.DatagramPacket r0 = new java.net.DatagramPacket     // Catch:{ all -> 0x002e }
            int r2 = r6.length     // Catch:{ all -> 0x002e }
            java.net.InetAddress r3 = r5.f31729a     // Catch:{ all -> 0x002e }
            r4 = 53
            r0.<init>(r6, r2, r3, r4)     // Catch:{ all -> 0x002e }
            int r6 = r5.f31730c     // Catch:{ all -> 0x002e }
            int r6 = r6 * 1000
            r1.setSoTimeout(r6)     // Catch:{ all -> 0x002e }
            r1.send(r0)     // Catch:{ all -> 0x002e }
            java.net.DatagramPacket r6 = new java.net.DatagramPacket     // Catch:{ all -> 0x002e }
            r0 = 1500(0x5dc, float:2.102E-42)
            byte[] r2 = new byte[r0]     // Catch:{ all -> 0x002e }
            r6.<init>(r2, r0)     // Catch:{ all -> 0x002e }
            r1.receive(r6)     // Catch:{ all -> 0x002e }
            byte[] r6 = r6.getData()     // Catch:{ all -> 0x002e }
            r1.close()
            return r6
        L_0x002e:
            r6 = move-exception
            goto L_0x0032
        L_0x0030:
            r6 = move-exception
            r1 = r0
        L_0x0032:
            if (r1 == 0) goto L_0x0037
            r1.close()
        L_0x0037:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.network.a.a.c.a(byte[]):byte[]");
    }
}
