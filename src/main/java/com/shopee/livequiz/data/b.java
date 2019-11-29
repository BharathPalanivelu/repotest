package com.shopee.livequiz.data;

import com.shopee.livequiz.data.bean.LiveParams;

public class b {

    /* renamed from: b  reason: collision with root package name */
    private static b f29823b;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public LiveParams f29824a = new LiveParams();

    public static b a() {
        synchronized (b.class) {
            if (f29823b == null) {
                synchronized (b.class) {
                    f29823b = new b();
                }
            }
        }
        return f29823b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0078, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.shopee.livequiz.data.bean.LiveParams r5) {
        /*
            r4 = this;
            java.lang.Class<com.shopee.livequiz.data.b> r0 = com.shopee.livequiz.data.b.class
            monitor-enter(r0)
            if (r5 != 0) goto L_0x0007
            monitor-exit(r0)     // Catch:{ all -> 0x0079 }
            return
        L_0x0007:
            r4.f29824a = r5     // Catch:{ all -> 0x0079 }
            com.shopee.livequiz.data.bean.LiveParams r5 = r4.f29824a     // Catch:{ all -> 0x0079 }
            com.shopee.livequiz.data.bean.LiveParams r1 = r4.f29824a     // Catch:{ all -> 0x0079 }
            int r1 = r1.showAnswerTime     // Catch:{ all -> 0x0079 }
            r2 = 3
            if (r1 <= 0) goto L_0x0017
            com.shopee.livequiz.data.bean.LiveParams r1 = r4.f29824a     // Catch:{ all -> 0x0079 }
            int r1 = r1.showAnswerTime     // Catch:{ all -> 0x0079 }
            goto L_0x0018
        L_0x0017:
            r1 = 3
        L_0x0018:
            r5.showAnswerTime = r1     // Catch:{ all -> 0x0079 }
            com.shopee.livequiz.data.bean.LiveParams r5 = r4.f29824a     // Catch:{ all -> 0x0079 }
            com.shopee.livequiz.data.bean.LiveParams r1 = r4.f29824a     // Catch:{ all -> 0x0079 }
            int r1 = r1.showQuizTime     // Catch:{ all -> 0x0079 }
            if (r1 <= 0) goto L_0x0026
            com.shopee.livequiz.data.bean.LiveParams r1 = r4.f29824a     // Catch:{ all -> 0x0079 }
            int r2 = r1.showQuizTime     // Catch:{ all -> 0x0079 }
        L_0x0026:
            r5.showQuizTime = r2     // Catch:{ all -> 0x0079 }
            com.shopee.livequiz.data.bean.LiveParams r5 = r4.f29824a     // Catch:{ all -> 0x0079 }
            com.shopee.livequiz.data.bean.LiveParams r1 = r4.f29824a     // Catch:{ all -> 0x0079 }
            int r1 = r1.extraLifeBalance     // Catch:{ all -> 0x0079 }
            r2 = 0
            if (r1 < 0) goto L_0x0036
            com.shopee.livequiz.data.bean.LiveParams r1 = r4.f29824a     // Catch:{ all -> 0x0079 }
            int r1 = r1.extraLifeBalance     // Catch:{ all -> 0x0079 }
            goto L_0x0037
        L_0x0036:
            r1 = 0
        L_0x0037:
            r5.extraLifeBalance = r1     // Catch:{ all -> 0x0079 }
            com.shopee.livequiz.data.bean.LiveParams r5 = r4.f29824a     // Catch:{ all -> 0x0079 }
            com.shopee.livequiz.data.bean.LiveParams r1 = r4.f29824a     // Catch:{ all -> 0x0079 }
            int r1 = r1.extraLifeLimit     // Catch:{ all -> 0x0079 }
            if (r1 < 0) goto L_0x0046
            com.shopee.livequiz.data.bean.LiveParams r1 = r4.f29824a     // Catch:{ all -> 0x0079 }
            int r1 = r1.extraLifeLimit     // Catch:{ all -> 0x0079 }
            goto L_0x0047
        L_0x0046:
            r1 = 0
        L_0x0047:
            r5.extraLifeLimit = r1     // Catch:{ all -> 0x0079 }
            com.shopee.livequiz.data.bean.LiveParams r5 = r4.f29824a     // Catch:{ all -> 0x0079 }
            com.shopee.livequiz.data.bean.LiveParams r1 = r4.f29824a     // Catch:{ all -> 0x0079 }
            int r1 = r1.extraLifeReviveCountdown     // Catch:{ all -> 0x0079 }
            if (r1 < 0) goto L_0x0055
            com.shopee.livequiz.data.bean.LiveParams r1 = r4.f29824a     // Catch:{ all -> 0x0079 }
            int r2 = r1.extraLifeReviveCountdown     // Catch:{ all -> 0x0079 }
        L_0x0055:
            r5.extraLifeReviveCountdown = r2     // Catch:{ all -> 0x0079 }
            com.shopee.livequiz.data.bean.LiveParams r5 = r4.f29824a     // Catch:{ all -> 0x0079 }
            java.lang.String r5 = r5.shareToken     // Catch:{ all -> 0x0079 }
            boolean r5 = com.shopee.livequiz.g.j.a(r5)     // Catch:{ all -> 0x0079 }
            if (r5 == 0) goto L_0x0077
            java.util.Random r5 = new java.util.Random     // Catch:{ all -> 0x0079 }
            r5.<init>()     // Catch:{ all -> 0x0079 }
            com.shopee.livequiz.data.b$1 r1 = new com.shopee.livequiz.data.b$1     // Catch:{ all -> 0x0079 }
            r1.<init>()     // Catch:{ all -> 0x0079 }
            r2 = 10
            int r5 = r5.nextInt(r2)     // Catch:{ all -> 0x0079 }
            int r5 = r5 * 1000
            long r2 = (long) r5     // Catch:{ all -> 0x0079 }
            com.shopee.livequiz.c.f.a((com.shopee.livequiz.c.e) r1, (long) r2)     // Catch:{ all -> 0x0079 }
        L_0x0077:
            monitor-exit(r0)     // Catch:{ all -> 0x0079 }
            return
        L_0x0079:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0079 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.livequiz.data.b.a(com.shopee.livequiz.data.bean.LiveParams):void");
    }

    public LiveParams b() {
        LiveParams liveParams;
        synchronized (b.class) {
            liveParams = this.f29824a;
        }
        return liveParams;
    }

    public int c() {
        int i;
        synchronized (b.class) {
            i = this.f29824a.eventId;
        }
        return i;
    }

    public int d() {
        int i;
        synchronized (b.class) {
            i = this.f29824a.sessionId;
        }
        return i;
    }

    public boolean e() {
        boolean z;
        synchronized (b.class) {
            z = this.f29824a.supportHorizontal != 0;
        }
        return z;
    }
}
