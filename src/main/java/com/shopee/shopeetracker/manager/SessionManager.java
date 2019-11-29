package com.shopee.shopeetracker.manager;

import java.util.UUID;

public class SessionManager {
    private long lastTimeEnterBackground;
    private long sequenceId;
    private String sessionId;
    private long sessionIntervalTime;

    public synchronized String getSessionId() {
        return this.sessionId;
    }

    public synchronized Long getSequenceId() {
        long j;
        j = this.sequenceId;
        this.sequenceId = 1 + j;
        return Long.valueOf(j);
    }

    public synchronized void setLastTimeEnterBackground() {
        this.lastTimeEnterBackground = System.currentTimeMillis();
    }

    public synchronized void setSessionIntervalTime(long j) {
        this.sessionIntervalTime = j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void refreshSessionId() {
        /*
            r9 = this;
            monitor-enter(r9)
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0072 }
            java.lang.String r2 = r9.sessionId     // Catch:{ all -> 0x0072 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0072 }
            r3 = 0
            if (r2 != 0) goto L_0x0022
            long r5 = r9.lastTimeEnterBackground     // Catch:{ all -> 0x0072 }
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0020
            long r5 = r9.lastTimeEnterBackground     // Catch:{ all -> 0x0072 }
            long r5 = r0 - r5
            long r7 = r9.sessionIntervalTime     // Catch:{ all -> 0x0072 }
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 <= 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r2 = 0
            goto L_0x0023
        L_0x0022:
            r2 = 1
        L_0x0023:
            java.lang.Class r5 = r9.getClass()     // Catch:{ all -> 0x0072 }
            java.lang.String r5 = r5.getSimpleName()     // Catch:{ all -> 0x0072 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0072 }
            r6.<init>()     // Catch:{ all -> 0x0072 }
            java.lang.String r7 = "time = "
            r6.append(r7)     // Catch:{ all -> 0x0072 }
            long r7 = r9.lastTimeEnterBackground     // Catch:{ all -> 0x0072 }
            long r0 = r0 - r7
            r6.append(r0)     // Catch:{ all -> 0x0072 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0072 }
            com.shopee.shopeetracker.utils.Logger.debug(r5, r0)     // Catch:{ all -> 0x0072 }
            if (r2 == 0) goto L_0x006e
            java.util.UUID r0 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x0072 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0072 }
            r9.sessionId = r0     // Catch:{ all -> 0x0072 }
            r9.sequenceId = r3     // Catch:{ all -> 0x0072 }
            java.lang.Class r0 = r9.getClass()     // Catch:{ all -> 0x0072 }
            java.lang.String r0 = r0.getSimpleName()     // Catch:{ all -> 0x0072 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0072 }
            r1.<init>()     // Catch:{ all -> 0x0072 }
            java.lang.String r2 = "generate new sessionId = "
            r1.append(r2)     // Catch:{ all -> 0x0072 }
            java.lang.String r2 = r9.sessionId     // Catch:{ all -> 0x0072 }
            r1.append(r2)     // Catch:{ all -> 0x0072 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0072 }
            com.shopee.shopeetracker.utils.Logger.debug(r0, r1)     // Catch:{ all -> 0x0072 }
        L_0x006e:
            r9.lastTimeEnterBackground = r3     // Catch:{ all -> 0x0072 }
            monitor-exit(r9)
            return
        L_0x0072:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.shopeetracker.manager.SessionManager.refreshSessionId():void");
    }

    private static class Holder {
        /* access modifiers changed from: private */
        public static final SessionManager instance = new SessionManager();

        private Holder() {
        }
    }

    private SessionManager() {
        this.lastTimeEnterBackground = 0;
        this.sequenceId = 0;
        this.sessionIntervalTime = 1800000;
        this.sessionId = UUID.randomUUID().toString();
        this.sequenceId = 0;
    }

    public static SessionManager getInstance() {
        return Holder.instance;
    }
}
