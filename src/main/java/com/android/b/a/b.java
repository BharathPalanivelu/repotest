package com.android.b.a;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    protected static final Comparator<byte[]> f4561a = new Comparator<byte[]>() {
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private List<byte[]> f4562b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    private List<byte[]> f4563c = new ArrayList(64);

    /* renamed from: d  reason: collision with root package name */
    private int f4564d = 0;

    /* renamed from: e  reason: collision with root package name */
    private final int f4565e;

    public b(int i) {
        this.f4565e = i;
    }

    public synchronized byte[] a(int i) {
        for (int i2 = 0; i2 < this.f4563c.size(); i2++) {
            byte[] bArr = this.f4563c.get(i2);
            if (bArr.length >= i) {
                this.f4564d -= bArr.length;
                this.f4563c.remove(i2);
                this.f4562b.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(byte[] r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L_0x002e
            int r0 = r3.length     // Catch:{ all -> 0x002b }
            int r1 = r2.f4565e     // Catch:{ all -> 0x002b }
            if (r0 <= r1) goto L_0x0009
            goto L_0x002e
        L_0x0009:
            java.util.List<byte[]> r0 = r2.f4562b     // Catch:{ all -> 0x002b }
            r0.add(r3)     // Catch:{ all -> 0x002b }
            java.util.List<byte[]> r0 = r2.f4563c     // Catch:{ all -> 0x002b }
            java.util.Comparator<byte[]> r1 = f4561a     // Catch:{ all -> 0x002b }
            int r0 = java.util.Collections.binarySearch(r0, r3, r1)     // Catch:{ all -> 0x002b }
            if (r0 >= 0) goto L_0x001b
            int r0 = -r0
            int r0 = r0 + -1
        L_0x001b:
            java.util.List<byte[]> r1 = r2.f4563c     // Catch:{ all -> 0x002b }
            r1.add(r0, r3)     // Catch:{ all -> 0x002b }
            int r0 = r2.f4564d     // Catch:{ all -> 0x002b }
            int r3 = r3.length     // Catch:{ all -> 0x002b }
            int r0 = r0 + r3
            r2.f4564d = r0     // Catch:{ all -> 0x002b }
            r2.a()     // Catch:{ all -> 0x002b }
            monitor-exit(r2)
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x002e:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.b.a.b.a(byte[]):void");
    }

    private synchronized void a() {
        while (this.f4564d > this.f4565e) {
            byte[] remove = this.f4562b.remove(0);
            this.f4563c.remove(remove);
            this.f4564d -= remove.length;
        }
    }
}
